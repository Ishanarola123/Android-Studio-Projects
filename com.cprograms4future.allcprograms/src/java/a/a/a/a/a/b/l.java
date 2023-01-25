/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  a.a.a.a.a.b.l$1$1
 *  a.a.a.a.a.b.l$2
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.Runtime
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.Executors
 *  java.util.concurrent.ScheduledExecutorService
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.atomic.AtomicLong
 */
package a.a.a.a.a.b;

import a.a.a.a.a.b.l;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public final class l {
    public static ScheduledExecutorService a(String string) {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor((ThreadFactory)l.b(string));
        l.a(string, (ExecutorService)scheduledExecutorService);
        return scheduledExecutorService;
    }

    private static final void a(String string, ExecutorService executorService) {
        l.a(string, executorService, 2L, TimeUnit.SECONDS);
    }

    public static final void a(String string, ExecutorService executorService, long l2, TimeUnit timeUnit) {
        Runtime runtime = Runtime.getRuntime();
        2 var6_5 = new 2(string, executorService, l2, timeUnit);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Crashlytics Shutdown Hook for ");
        stringBuilder.append(string);
        runtime.addShutdownHook(new Thread((Runnable)var6_5, stringBuilder.toString()));
    }

    public static final ThreadFactory b(final String string) {
        return new ThreadFactory(new AtomicLong(1L)){
            final /* synthetic */ AtomicLong b;
            {
                this.b = atomicLong;
            }

            public Thread newThread(Runnable runnable) {
                Thread thread = Executors.defaultThreadFactory().newThread((Runnable)new 1(this, runnable));
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append(this.b.getAndIncrement());
                thread.setName(stringBuilder.toString());
                return thread;
            }
        };
    }

}

