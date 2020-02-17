package com.example.notifiactionstyle;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.session.MediaSession;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.RemoteInput;

import java.util.ArrayList;
import java.util.List;

import static com.example.notifiactionstyle.App.CHANNEL_1;
import static com.example.notifiactionstyle.App.CHANNEL_2;
import static com.example.notifiactionstyle.App.CHANNEL_4;
import static com.example.notifiactionstyle.App.CHANNEL_5;
import static com.example.notifiactionstyle.App.CHANNEL_6;
import static com.example.notifiactionstyle.App.Channel_3;

public class MainActivity extends AppCompatActivity {

    private NotificationManagerCompat compat;
    private EditText edititle, edextmsg;


    // being not real chat App
    private MediaSession mediaSession;
    static List<Message> MEssages = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        compat = NotificationManagerCompat.from(this);
        edititle = findViewById(R.id.editTexttitle);
        edextmsg = findViewById(R.id.editTextmsg);

        mediaSession = new MediaSession(this, "tag");

        MEssages.add(new Message("Hey there,", "Senorita"));
        MEssages.add(new Message("Hey there,", null));
        MEssages.add(new Message("Hey there,", "Senorita"));
        MEssages.add(new Message("Hey there,", null));

    }

    public void hanleChannelone(View view) {

        String msg = edextmsg.getText().toString();
        String title = edititle.getText().toString();

        Intent activityIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntetn = PendingIntent.getActivity(
                this, 0, activityIntent, 0);

        Intent broadCastIntent = new Intent(this, Notification_Class.class);
        broadCastIntent.putExtra("KEY_intent", msg);

        PendingIntent actionIntent = PendingIntent.getBroadcast(
                this, 0, broadCastIntent, PendingIntent.FLAG_UPDATE_CURRENT
        );


        Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.sssss);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1)
                .setSmallIcon(R.drawable.ic_looks_one_black_24dp)
                .setContentTitle(title)
                .setContentText(msg)
                .setLargeIcon(largeIcon)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText(getString(R.string.bigtxt))
                        .setSummaryText("Summary Text")
                        .setBigContentTitle("For The Big Tittle")
                )
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setContentIntent(contentIntetn)
                .setAutoCancel(true)
                .setColor(Color.RED)
                .addAction(R.drawable.ic_add_alert_black_24dp, "Ok", actionIntent)
                .build();
        compat.notify(1, notification);
    }

    public void hanleChannelTwo(View view) {

        String msg = edextmsg.getText().toString();
        String title = edititle.getText().toString();

        Notification notification = new NotificationCompat.Builder(
                this, CHANNEL_2)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setContentText(msg)
                .setContentTitle(title)

                .setStyle(new NotificationCompat.InboxStyle()
                        .addLine("Hey line 1")
                        .addLine("Line 2")
                        .addLine("Line 3")
                        .setBigContentTitle("Roww  "))
                .setSmallIcon(R.drawable.ic_looks_two_black_24dp)
                .build();
        compat.notify(2, notification);
    }

    public void hanleChannel3(View view) {

//        big picture style

        String msg = edextmsg.getText().toString();
        String title = edititle.getText().toString();

        Intent activityIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntetn = PendingIntent.getActivity(
                this, 0, activityIntent, 0);


        //make sure image type
        Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.llrg);

        Notification notification = new NotificationCompat.Builder(this, Channel_3)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle(title)
                .setContentText(msg)
                .setLargeIcon(largeIcon)
                .setStyle(new NotificationCompat.BigPictureStyle()
                        .bigPicture(largeIcon)
                        .bigLargeIcon(null)
                )
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setContentIntent(contentIntetn)
                .setAutoCancel(true)

                .build();
        compat.notify(7, notification);

    }

    public void hanleChannel4(View view) {

//        big picture style

        String msg = edextmsg.getText().toString();
        String title = edititle.getText().toString();

        Intent activityIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntetn = PendingIntent.getActivity(
                this, 0, activityIntent, 0);

        Bitmap artcover = BitmapFactory.decodeResource(getResources(), R.drawable.sssss);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_4)
                .setSmallIcon(R.drawable.three)
                .setContentTitle(title)
                .setContentText(msg)
                .setLargeIcon(artcover)
                .addAction(R.drawable.ic_fast_rewind_black_24dp, "Rewind", null)
                .addAction(R.drawable.ic_skip_previous_black_24dp, "Back", null)
                .addAction(R.drawable.ic_play_circle_filled_black_24dp, "Play", null)
                .addAction(R.drawable.ic_skip_next_black_24dp, "Next", null)
                .addAction(R.drawable.ic_fast_forward_black_24dp, "Forward", null)
                .setStyle(new androidx.media.app.NotificationCompat.MediaStyle()
                        .setShowActionsInCompactView(1, 2, 3))
                .setSubText("Sub Text")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setContentIntent(contentIntetn)
                .setAutoCancel(true)

                .build();
        compat.notify(4, notification);
    }

    // Messaging style & Direct  reply
    public void hanldeMsgStyle(View view) {
        sendChannelNotificaion(this);
    }

    public static void sendChannelNotificaion(Context context) {

        Intent intent = new Intent(context, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, intent, 0);

        RemoteInput remoteInput = new RemoteInput.Builder("KEY_reply")
                .setLabel("Reply....")
                .build();
        Intent replyIntent;
        PendingIntent pendingIntent = null;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            replyIntent = new Intent(context, Notification_Class.class);
            pendingIntent = PendingIntent.getBroadcast(context, 0, replyIntent, 0);
        } else {
            //Starting Chat Activity being api<=24
            // cancel notification -
            //notificationManagerCompat.cancel;
        }
        NotificationCompat.Action replyAction = new NotificationCompat.Action.Builder(
                R.drawable.ic_fast_forward_black_24dp
                , "reply",
                pendingIntent
        ).addRemoteInput(remoteInput).build();


        NotificationCompat.MessagingStyle messagingStyle = new NotificationCompat.MessagingStyle("Me:");
        messagingStyle.setConversationTitle("Group Chat");


        for (Message chatmsg : MEssages) {
            NotificationCompat.MessagingStyle.Message Nmessage = new NotificationCompat.MessagingStyle.Message(
                    chatmsg.getText(),
                    chatmsg.getTimestamp(),
                    chatmsg.getSender()
            );
            messagingStyle.addMessage(Nmessage);
        }

        Notification notification = new NotificationCompat.Builder(context, CHANNEL_5)
                .setSmallIcon(R.drawable.ic_looks_one_black_24dp)
                .setStyle(messagingStyle)
                .setContentIntent(contentIntent)
                .addAction(replyAction)
                .setColor(Color.BLUE)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setAutoCancel(true)
                .setOnlyAlertOnce(true)
                .build();
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
        notificationManagerCompat.notify(5, notification);


    }


    public void hanldeDownloadProgressNotify(View view) {

        final int progressMax = 100;

        final NotificationCompat.Builder notification = new NotificationCompat.Builder(this, CHANNEL_6)
                .setSmallIcon(R.drawable.ic_file_download_black_24dp)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setContentTitle("Download")
                .setContentText("Download in progress")
                .setProgress(progressMax, 0, false)
                .setOngoing(true)
                .setOnlyAlertOnce(true);

        compat.notify(6, notification.build());

        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(2000);

                for (int progress = 0; progress <= progressMax; progress += 10) {
                    notification.setProgress(progressMax, progress, false);
                    compat.notify(6, notification.build());
                    SystemClock.sleep(1000);
                }
                notification.setContentText("Download Finished")
                        .setProgress(0, 0, false)
                        .setOngoing(false);
                compat.notify(6, notification.build());
            }
        });

    }
}
