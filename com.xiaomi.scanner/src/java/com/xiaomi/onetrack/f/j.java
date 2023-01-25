/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.onetrack.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.onetrack.h.o;

final class j
extends BroadcastReceiver {
    j() {
    }

    public void onReceive(Context context, Intent intent) {
        String string2 = intent.getAction();
        if (string2.equals((Object)"android.intent.action.SCREEN_OFF") || string2.equals((Object)"android.intent.action.SCREEN_ON")) {
            String string3 = string2.equals((Object)"android.intent.action.SCREEN_ON") ? "\u5c4f\u5e55\u4eae" : "\u5c4f\u5e55\u706d";
            o.a("OneTrackApp", string3);
        }
    }
}

