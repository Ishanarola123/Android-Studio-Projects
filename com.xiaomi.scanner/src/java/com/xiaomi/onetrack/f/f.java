/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.concurrent.atomic.AtomicBoolean
 */
package com.xiaomi.onetrack.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.xiaomi.onetrack.b.c;
import com.xiaomi.onetrack.f.g;
import com.xiaomi.onetrack.f.h;
import com.xiaomi.onetrack.f.j;
import com.xiaomi.onetrack.h.o;
import java.util.concurrent.atomic.AtomicBoolean;

public class f {
    private static final String a = "OneTrackApp";
    private static f b;
    private static BroadcastReceiver e;
    private AtomicBoolean c = new AtomicBoolean(false);
    private BroadcastReceiver d = new h(this);

    static {
        e = new j();
    }

    private f(Context context) {
        com.xiaomi.onetrack.h.h.a(new g(this, context.getApplicationContext()));
    }

    static /* synthetic */ AtomicBoolean a(f f2) {
        return f2.c;
    }

    private void a() {
        c.b();
    }

    public static void a(Context context) {
        if (b == null) {
            b = new f(context);
        }
    }

    static /* synthetic */ void a(f f2, Context context) {
        f2.d(context);
    }

    static /* synthetic */ void b(Context context) {
        f.c(context);
    }

    static /* synthetic */ void b(f f2) {
        f2.a();
    }

    private static void c(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.registerReceiver(e, intentFilter);
    }

    private void d(Context context) {
        if (context == null) {
            return;
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            context.registerReceiver(this.d, intentFilter);
            return;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("registerNetReceiver: ");
            stringBuilder.append((Object)exception);
            o.a(a, stringBuilder.toString());
            return;
        }
    }
}

