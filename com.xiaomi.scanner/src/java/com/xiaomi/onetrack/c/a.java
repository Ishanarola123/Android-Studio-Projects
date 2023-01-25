/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package com.xiaomi.onetrack.c;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public class a {
    private static final String a = "DbExecutor";
    private static String b = "onetrack_db";
    private static Handler c;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void a() {
        if (c != null) {
            return;
        }
        Class<a> class_ = a.class;
        synchronized (a.class) {
            if (c == null) {
                HandlerThread handlerThread = new HandlerThread(b);
                handlerThread.start();
                c = new Handler(handlerThread.getLooper());
            }
            // ** MonitorExit[var2] (shouldn't be in output)
            return;
        }
    }

    public static void a(Runnable runnable) {
        a.a();
        c.post(runnable);
    }
}

