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
package com.xiaomi.onetrack.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.onetrack.b.l;
import com.xiaomi.onetrack.c.j;
import com.xiaomi.onetrack.g.c;
import com.xiaomi.onetrack.h.o;

class k
extends BroadcastReceiver {
    final /* synthetic */ j a;

    k(j j2) {
        this.a = j2;
    }

    public void onReceive(Context context, Intent intent) {
        boolean bl = c.a();
        l.b(bl);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UploadTimer netReceiver, \u7f51\u7edc\u662f\u5426\u53ef\u7528=");
        stringBuilder.append(bl);
        o.a("UploadTimer", stringBuilder.toString());
        if (bl) {
            for (int n2 : new int[]{0, 1, 2}) {
                int n3 = l.a(n2);
                if (this.a.hasMessages(n2)) continue;
                this.a.sendEmptyMessageDelayed(n2, (long)n3);
            }
        }
    }
}

