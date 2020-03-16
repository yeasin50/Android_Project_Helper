package com.example.splashscreen;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import gr.net.maroulis.library.EasySplashScreen;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        EasySplashScreen splash_confiq = new EasySplashScreen(SplashScreen.this)
                .withFullScreen()
                .withTargetActivity(MainActivity.class)
                .withSplashTimeOut(1500)
                .withBackgroundColor(Color.parseColor("#F34453"))
                .withHeaderText("Header here")
                .withFooterText("Fotter ")
                .withAfterLogoText("after Logo")
                .withBeforeLogoText("Before LOgo")
                .withLogo(R.mipmap.ic_launcher);

        splash_confiq.getHeaderTextView().setTextColor(Color.WHITE);
        splash_confiq.getAfterLogoTextView().setTextColor(Color.WHITE);
        splash_confiq.getBeforeLogoTextView().setTextColor(Color.WHITE);
        splash_confiq.getFooterTextView().setTextColor(Color.WHITE);

        View easySplashScreen = splash_confiq.create();
        setContentView(easySplashScreen);

    }
}

/*
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.example.splashscreen">

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity android:name=".MainActivity"></activity>
        <activity android:name=".SplashScreen">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>
