/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.xiaomi.onetrack.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.onetrack.c.l;
import com.xiaomi.onetrack.h.o;

final class c
extends BroadcastReceiver {
    c() {
    }

    public void onReceive(Context context, Intent intent) {
        String string2 = intent.getAction();
        if (string2.equals((Object)"android.intent.action.SCREEN_OFF") || string2.equals((Object)"android.intent.action.SCREEN_ON")) {
            o.a("EventManager", "screen on/off");
            int n2 = string2.equals((Object)"android.intent.action.SCREEN_ON") ? 0 : 2;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("screenReceiver will post prio=");
            stringBuilder.append(n2);
            o.a("EventManager", stringBuilder.toString());
            l.a().a(n2, false);
        }
    }
}

