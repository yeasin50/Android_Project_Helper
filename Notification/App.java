package com.example.notifiactionstyle;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

import androidx.core.app.NotificationCompat;

public class App extends Application {

    public static final String  CHANNEL_1 = "Channel 1";
    public static final String  CHANNEL_2 = "Channel 2";
    public static final String  Channel_3 = "Channel_3";
    public static final String CHANNEL_4 ="Channe 4";
    public static final String CHANNEL_5 ="Channe 5";
    public static final String CHANNEL_6 ="Channe 6";

    @Override
    public void onCreate() {
        super.onCreate();

        createNotificationChannel();
    }

    private void createNotificationChannel() {

      if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
          NotificationChannel channel1 = new NotificationChannel(
                  CHANNEL_1, "Channel 1 here",
                  NotificationManager.IMPORTANCE_HIGH);
          channel1.setDescription("Hey , Channel one description.");

          NotificationChannel channel2 = new NotificationChannel(
                  CHANNEL_2, "Channel 2 ",
                  NotificationManager.IMPORTANCE_LOW
          );
          channel2.setDescription("Amigo , channel 2 here.");

          NotificationChannel channel3 = new NotificationChannel(
                  Channel_3, "Channel 3",NotificationManager.IMPORTANCE_HIGH
          );
          channel3.setDescription("Channel BigPic Style");

          NotificationChannel channel4 = new NotificationChannel(
                  CHANNEL_4, "Channel 4", NotificationManager.IMPORTANCE_LOW
          );
          channel4.setDescription("ds ");
          NotificationChannel channel5 = new NotificationChannel(
                  CHANNEL_5, "Channel 5",NotificationManager.IMPORTANCE_HIGH
          );
          channel5.setDescription("Messagging ");

          NotificationChannel channel6 = new NotificationChannel(
                  CHANNEL_6, "Channel 6", NotificationManager.IMPORTANCE_LOW
          );
          channel6.setDescription("sds ");

          NotificationManager manager = getSystemService(NotificationManager.class);
          manager.createNotificationChannel(channel1);
          manager.createNotificationChannel(channel2);
          manager.createNotificationChannel(channel3);
          manager.createNotificationChannel(channel4);
          manager.createNotificationChannel(channel5);
          manager.createNotificationChannel(channel6);


      }
    }
}
