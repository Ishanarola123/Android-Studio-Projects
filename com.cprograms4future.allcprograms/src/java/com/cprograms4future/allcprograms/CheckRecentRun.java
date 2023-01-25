/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.AlarmManager
 *  android.app.Notification
 *  android.app.Notification$Builder
 *  android.app.NotificationManager
 *  android.app.PendingIntent
 *  android.app.Service
 *  android.content.Context
 *  android.content.Intent
 *  android.content.SharedPreferences
 *  android.os.IBinder
 *  android.util.Log
 *  com.cprograms4future.allcprograms.MainActivity
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 */
package com.cprograms4future.allcprograms;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.util.Log;
import com.cprograms4future.allcprograms.MainActivity;

public class CheckRecentRun
extends Service {
    private static Long MILLISECS_PER_DAY = 86400000L;
    private static Long MILLISECS_PER_MIN = 60000L;
    private static final String TAG = "CheckRecentPlay";
    private static long delay = 3L * MILLISECS_PER_DAY;

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        Log.v((String)TAG, (String)"Service started");
        SharedPreferences sharedPreferences = this.getSharedPreferences("PrefsFile", 0);
        if (sharedPreferences.getBoolean("enabled", true)) {
            if (sharedPreferences.getLong("lastRun", Long.MAX_VALUE) < System.currentTimeMillis() - delay) {
                this.sendNotification();
            }
        } else {
            Log.i((String)TAG, (String)"Notifications are disabled");
        }
        this.setAlarm();
        Log.v((String)TAG, (String)"Service stopped");
        this.stopSelf();
    }

    public void sendNotification() {
        Intent intent = new Intent((Context)this, MainActivity.class);
        Notification notification = new Notification.Builder((Context)this).setAutoCancel(true).setContentIntent(PendingIntent.getActivity((Context)this, (int)131314, (Intent)intent, (int)134217728)).setContentTitle((CharSequence)"We Miss You!").setContentText((CharSequence)"Build your Career with C Programs.").setDefaults(-1).setSmallIcon(2131230914).setTicker((CharSequence)"We Miss You! Build your Carrer with C Programs.").setWhen(System.currentTimeMillis()).getNotification();
        ((NotificationManager)this.getSystemService("notification")).notify(131315, notification);
        Log.v((String)TAG, (String)"Notification sent");
    }

    public void setAlarm() {
        PendingIntent pendingIntent = PendingIntent.getService((Context)this, (int)131313, (Intent)new Intent((Context)this, CheckRecentRun.class), (int)268435456);
        ((AlarmManager)this.getSystemService("alarm")).set(0, System.currentTimeMillis() + delay, pendingIntent);
        Log.v((String)TAG, (String)"Alarm set");
    }
}

