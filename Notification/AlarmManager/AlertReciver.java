package com.example.alermmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

public class AlertReciver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationHelper notificationHelper = new NotificationHelper(context);
        NotificationCompat.Builder builder = notificationHelper.getChannelNotification();
        notificationHelper.getManager().notify(1,builder.build());
    }
}
