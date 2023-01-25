/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.xiaomi.onetrack.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.xiaomi.onetrack.c.k;
import com.xiaomi.onetrack.c.l;
import com.xiaomi.onetrack.f.a;
import com.xiaomi.onetrack.h.o;

public class j
extends Handler {
    private static final String a = "UploadTimer";
    private static final int b = 5000;
    private static final int c = 15000;
    private static final int d = 1200000;
    private final int e = 1000;
    private final int f = 10000;
    private final int g = 1200000;
    private int h = 10000;
    private BroadcastReceiver i = new k(this);

    public j(Looper looper) {
        super(looper);
        this.a(a.a());
    }

    private void a() {
        if (!l.a().a(2)) {
            this.removeMessages(1000);
            this.h = 2 * this.h;
            if (this.h > 1200000) {
                this.h = 1200000;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("will restart retry msg after ");
            stringBuilder.append(this.h);
            o.a(a, stringBuilder.toString());
            this.sendEmptyMessageDelayed(1000, (long)this.h);
            return;
        }
        this.h = 10000;
        o.a(a, "retry success");
    }

    private void a(int n2, long l2) {
        this.removeMessages(n2);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("will post msg, prio=");
        stringBuilder.append(n2);
        stringBuilder.append(", delay=");
        stringBuilder.append(l2);
        o.a(a, stringBuilder.toString());
        this.sendEmptyMessageDelayed(n2, l2);
    }

    private void a(Context context) {
        if (context == null) {
            return;
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            context.registerReceiver(this.i, intentFilter);
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

    public void a(int n2, boolean bl) {
        if (this.hasMessages(1000)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("in retry mode, return, prio=");
            stringBuilder.append(n2);
            o.a(a, stringBuilder.toString());
            return;
        }
        if (bl) {
            this.removeMessages(n2);
        }
        if (!this.hasMessages(n2)) {
            long l2 = bl ? 0L : (long)com.xiaomi.onetrack.b.l.a(n2);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("will check prio=");
            stringBuilder.append(n2);
            stringBuilder.append(", delay=");
            stringBuilder.append(l2);
            o.a(a, stringBuilder.toString());
            this.a(n2, l2);
        }
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (com.xiaomi.onetrack.b.l.a() && com.xiaomi.onetrack.b.l.c() && !com.xiaomi.onetrack.b.l.b()) {
            if (message.what == 1000) {
                this.a();
                return;
            }
            int n2 = message.what;
            boolean bl = l.a().a(n2);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("handleCheckUpload ret=");
            stringBuilder.append(bl);
            stringBuilder.append(", prio=");
            stringBuilder.append(n2);
            o.a(a, stringBuilder.toString());
            if (!bl) {
                o.a(a, "handleCheckUpload failed, will check if need to send retry msg");
                if (!this.hasMessages(1000)) {
                    this.sendEmptyMessageDelayed(1000, (long)this.h);
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("fire retry timer after ");
                    stringBuilder2.append(this.h);
                    o.a(a, stringBuilder2.toString());
                }
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\u4e0d\u7528\u5904\u7406\u6d88\u606f, available=");
        stringBuilder.append(com.xiaomi.onetrack.b.l.a());
        stringBuilder.append(", \u662f\u5426\u6709\u7f51=");
        stringBuilder.append(com.xiaomi.onetrack.b.l.c());
        stringBuilder.append(", \u6570\u636e\u5e93\u662f\u5426\u4e3a\u7a7a=");
        stringBuilder.append(com.xiaomi.onetrack.b.l.b());
        o.a(a, stringBuilder.toString());
    }
}

