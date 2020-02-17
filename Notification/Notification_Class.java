package com.example.notifiactionstyle;

import android.app.RemoteInput;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class Notification_Class extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String msg = intent.getStringExtra("KEY_toast");
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();

        // msgStyle api 24

        Bundle remoteinput = RemoteInput.getResultsFromIntent(intent);
        if(remoteinput !=null){
            CharSequence replyText = remoteinput.getCharSequence("KEY_reply");
            Message answer = new Message(replyText,null);
            MainActivity.MEssages.add(answer);

            MainActivity.sendChannelNotificaion(context);
        }
    }
}
