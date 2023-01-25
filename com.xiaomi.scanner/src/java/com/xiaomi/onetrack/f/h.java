/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.xiaomi.onetrack.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.onetrack.b.l;
import com.xiaomi.onetrack.f.f;
import com.xiaomi.onetrack.f.i;
import com.xiaomi.onetrack.g.c;
import com.xiaomi.onetrack.h.o;

class h
extends BroadcastReceiver {
    final /* synthetic */ f a;

    h(f f2) {
        this.a = f2;
    }

    public void onReceive(Context context, Intent intent) {
        boolean bl = c.a();
        l.b(bl);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\u7f51\u7edc\u662f\u5426\u53ef\u7528=");
        stringBuilder.append(bl);
        o.a("OneTrackApp", stringBuilder.toString());
        com.xiaomi.onetrack.h.h.a(new i(this));
    }
}

