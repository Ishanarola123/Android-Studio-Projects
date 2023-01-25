package com.example.alarmmanager_demo;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class AlarmReceiver extends BroadcastReceiver {
    MainActivity mainActivity=new MainActivity();

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i=new Intent(context,DestinationActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent=PendingIntent.getActivity(context,0,i,0);
        //create notification
        NotificationCompat.Builder  builder=new NotificationCompat.Builder(context,"ishaandroid")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Medicine Reminder")
                .setContentText("Alarm is starting!keep your works on time")
                .setContentText("you take your medicine!")
                .setVibrate(new long[]{1000,1000,1000,1000,1000})
                .setSound(Settings.System.DEFAULT_ALARM_ALERT_URI)
                .setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                //when user click on notification that's time another activity should be opened
                .setContentIntent(pendingIntent);
//show the notification
        NotificationManagerCompat notificationManagerCompat=NotificationManagerCompat.from(context);
        notificationManagerCompat.notify(123,builder.build());

    }
}
