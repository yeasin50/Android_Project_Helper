package com.example.custopmnotification;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application {

    public static final String  CHANNEL_1 = "Channel 1";
    public static final String  CHANNEL_2 = "Channel 2";

    @Override
    public void onCreate() {
        super.onCreate();

        CreatChannels();
    }

    private void CreatChannels() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel1 = new NotificationChannel(
                    CHANNEL_1, "Channel 1 here",
                    NotificationManager.IMPORTANCE_HIGH);
            channel1.setDescription("Hey , Channel one description.");

            NotificationChannel channel2 = new NotificationChannel(
                    CHANNEL_2, "Channel 2 ",
                    NotificationManager.IMPORTANCE_LOW
            );

            channel2.setDescription("CHannel 2 here" );

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
            manager.createNotificationChannel(channel2);

        }
    }
}

