/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.Runtime
 *  java.lang.Throwable
 *  java.util.concurrent.BlockingQueue
 *  java.util.concurrent.LinkedBlockingQueue
 *  java.util.concurrent.ThreadPoolExecutor
 *  java.util.concurrent.TimeUnit
 */
package com.xiaomi.onetrack.h;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class h {
    private static ThreadPoolExecutor a;
    private static int b;

    static {
        ThreadPoolExecutor threadPoolExecutor;
        int n2 = b = 1 + Runtime.getRuntime().availableProcessors();
        a = threadPoolExecutor = new ThreadPoolExecutor(n2, n2, 10L, TimeUnit.SECONDS, (BlockingQueue)new LinkedBlockingQueue());
        a.allowCoreThreadTimeOut(true);
    }

    public static void a(Runnable runnable) {
        try {
            a.execute(runnable);
        }
        catch (Throwable throwable) {}
    }
}

