package com.example.alermmanager;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

public class NotificationHelper extends ContextWrapper {
    public static final String Channel_ID = "channel id ";
    public static final String Channel_name = "channel name";
    private NotificationManager manager;

    public NotificationHelper(Context base) {
        super(base);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createChannel();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createChannel() {
        NotificationChannel channel = new NotificationChannel(Channel_ID, Channel_name, NotificationManager.IMPORTANCE_HIGH);
        getManager().createNotificationChannel(channel);
    }

    public NotificationManager getManager() {
        if (manager == null) {
            manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return manager;
    }

    public NotificationCompat.Builder getChannelNotification() {

        return new NotificationCompat.Builder(getApplicationContext()
                , Channel_ID).setContentTitle("Alarm!")
                .setContentText("AlarManager is Working")
                .setSmallIcon(R.drawable.ic_add_alert_black_24dp);
    }
}
