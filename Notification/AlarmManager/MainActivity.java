package com.example.alermmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

    private Button setAlrmBTN, cancleAlrm;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setAlrmBTN = findViewById(R.id.btn_Set_Alarm);
        cancleAlrm = findViewById(R.id.btnCancelAlarm);
        textView = findViewById(R.id.textView);

        setAlrmBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(),"Time Picker");

            }
        });

        cancleAlrm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelAlarm();
            }
        });

    }


    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
//        textView.setText("H "+hourOfDay + " M"+minute);
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY,hourOfDay);
        c.set(Calendar.MINUTE, minute);
        c.set(Calendar.SECOND, 0);
        
        updateTimeSet(c);
        startAlarm(c);
    }

    private void startAlarm(Calendar c) {

        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlertReciver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1,intent,0);
        alarmManager.setExact(AlarmManager.RTC_WAKEUP,c.getTimeInMillis(),pendingIntent);


        if(c.before(Calendar.getInstance())){
            c.add(Calendar.DATE,1);
        }
    }


    private void updateTimeSet(Calendar c) {
        String timetext = "Alerm Set for : ";
        timetext += DateFormat.getTimeInstance(DateFormat.SHORT).format(c.getTime());

        textView.setText(timetext);
    }

    private void cancelAlarm() {
        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlertReciver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1,intent,0);
        alarmManager.cancel(pendingIntent);
        textView.setText("Alarm Canceled");
    }

}
