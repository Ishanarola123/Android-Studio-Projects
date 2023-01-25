/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.ServiceConnection
 *  android.os.IBinder
 *  java.lang.Exception
 *  java.lang.Object
 *  java.util.concurrent.LinkedBlockingQueue
 *  java.util.concurrent.TimeUnit
 */
package com.xiaomi.onetrack.h.a.a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.xiaomi.onetrack.h.a.a.n;
import com.xiaomi.onetrack.h.a.b.e;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

class o
implements ServiceConnection {
    final /* synthetic */ n a;

    o(n n2) {
        this.a = n2;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.a.b.offer((Object)iBinder, 1L, TimeUnit.SECONDS);
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.a.a = null;
    }
}

