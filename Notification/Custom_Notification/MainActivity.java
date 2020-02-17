package com.example.custopmnotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.RemoteViews;

import static com.example.custopmnotification.App.CHANNEL_1;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    NotificationManagerCompat managerCompat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        managerCompat = NotificationManagerCompat.from(this);

    }

    public void hanleShowClick(View view) {

        RemoteViews colapsedView = new RemoteViews(getPackageName(),
                R.layout.notification_colapsed_layout);

        RemoteViews expanedView = new RemoteViews(getPackageName(),
                R.layout.notification_expaned);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1)
                .setSmallIcon(R.drawable.ic_android_black_24dp)
                .setCustomContentView(colapsedView)
                .setCustomBigContentView(expanedView)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .build();
        managerCompat.notify(1, notification);


    }
}
