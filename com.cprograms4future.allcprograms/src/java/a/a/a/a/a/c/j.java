/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  a.a.a.a.a.c.g
 *  a.a.a.a.a.c.i
 *  android.annotation.TargetApi
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.Runtime
 *  java.lang.String
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.util.concurrent.BlockingQueue
 *  java.util.concurrent.Callable
 *  java.util.concurrent.RunnableFuture
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.ThreadPoolExecutor
 *  java.util.concurrent.TimeUnit
 */
package a.a.a.a.a.c;

import a.a.a.a.a.c.b;
import a.a.a.a.a.c.c;
import a.a.a.a.a.c.g;
import a.a.a.a.a.c.h;
import a.a.a.a.a.c.i;
import a.a.a.a.a.c.k;
import android.annotation.TargetApi;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class j
extends ThreadPoolExecutor {
    private static final int a = Runtime.getRuntime().availableProcessors();
    private static final int b = 1 + a;
    private static final int c = 1 + 2 * a;

    <T extends Runnable & b & h> j(int n2, int n3, long l2, TimeUnit timeUnit, c<T> c2, ThreadFactory threadFactory) {
        super(n2, n3, l2, timeUnit, c2, threadFactory);
        this.prestartAllCoreThreads();
    }

    public static j a() {
        return j.a(b, c);
    }

    public static <T extends Runnable & b & h> j a(int n2, int n3) {
        j j2 = new j(n2, n3, 1L, TimeUnit.SECONDS, new c(), new a(10));
        return j2;
    }

    protected void afterExecute(Runnable runnable, Throwable throwable) {
        k k2 = (k)runnable;
        k2.b(true);
        k2.a(throwable);
        this.b().d();
        super.afterExecute(runnable, throwable);
    }

    public c b() {
        return (c)super.getQueue();
    }

    /*
     * Enabled aggressive block sorting
     */
    @TargetApi(value=9)
    public void execute(Runnable runnableFuture) {
        if (!i.a(runnableFuture)) {
            runnableFuture = this.newTaskFor((Runnable)runnableFuture, null);
        }
        super.execute(runnableFuture);
    }

    public /* synthetic */ BlockingQueue getQueue() {
        return this.b();
    }

    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t2) {
        return new g(runnable, t2);
    }

    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new g(callable);
    }

    protected static final class a
    implements ThreadFactory {
        private final int a;

        public a(int n2) {
            this.a = n2;
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setPriority(this.a);
            thread.setName("Queue");
            return thread;
        }
    }

}

