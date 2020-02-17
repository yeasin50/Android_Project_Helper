package com.example.notificationgroup;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.Settings;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import static com.example.notificationgroup.App.CHANNEL_1;
import static com.example.notificationgroup.App.CHANNEL_2;
import static com.example.notificationgroup.App.Channel_3;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    NotificationManagerCompat managerCompat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        managerCompat = NotificationManagerCompat.from(this);
    }

    public void handleChannel1(View view) {
        if(!managerCompat.areNotificationsEnabled()){
            openSetttings();
            return;
        }

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O && isChannelBlocked(CHANNEL_1)){
            openChannelSetting(CHANNEL_1);
        }

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1)
                .setSmallIcon(R.drawable.ic_android_black_24dp)
                .setContentText("Amigos ,Channel 1 here")
                .setContentTitle("Channel 1")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .build();
        managerCompat.notify(11, notification);


    }

    public void handleChannel2(View view) {


        Notification notification1 = new NotificationCompat.Builder(
                this, CHANNEL_2)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setContentText(" Text")
                .setContentTitle("title ")
                .setSmallIcon(R.drawable.ic_android_black_24dp)
                .setGroup("example_group")
                .build();

        Notification notification2 = new NotificationCompat.Builder(
                this, CHANNEL_2)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setContentText(" Text")
                .setContentTitle("title ")
                .setSmallIcon(R.drawable.ic_android_black_24dp)
                .setGroup("example_group")
                .build();

        Notification summaryNotification = new NotificationCompat.Builder(
                this, CHANNEL_2)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setContentText(" Text")
                .setContentTitle("title ")
                .setSmallIcon(R.drawable.ic_android_black_24dp)
                .setGroup("example_group")
                .setGroupSummary(true)
                .setGroupAlertBehavior(NotificationCompat.GROUP_ALERT_CHILDREN)
                .build();

        SystemClock.sleep(2000);
        managerCompat.notify(2, notification1);
        SystemClock.sleep(100);
        managerCompat.notify(3, notification2);
        SystemClock.sleep(200);
        managerCompat.notify(4, summaryNotification);
//        managerCompat.notify(5, notification1);


    }

    private void openSetttings() {
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            Intent intent = new Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS);
            intent.putExtra(Settings.EXTRA_APP_PACKAGE, getPackageName());
            startActivity(intent);
        }else {
            Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
            intent.setData(Uri.parse("package:"+ getPackageName()));
            startActivity(intent);
        }
    }

    @RequiresApi(26)
    private boolean isChannelBlocked(String ChannelID){
        NotificationManager manager =  getSystemService(NotificationManager.class);
        NotificationChannel channel = manager.getNotificationChannel(ChannelID);

        return channel != null
        && channel.getImportance() == NotificationManager.IMPORTANCE_NONE;
    }

    @RequiresApi(26)
    private void openChannelSetting (String channelID){
        Intent intent = new Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS);
        intent.putExtra(Settings.EXTRA_APP_PACKAGE, getPackageName());
        intent.putExtra(Settings.EXTRA_CHANNEL_ID, channelID);
        startActivity(intent);
    }

    public void deleteNotifionChannel(View view){
       // auto add channel on start
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.deleteNotificationChannel(Channel_3);

        }
    }

}
