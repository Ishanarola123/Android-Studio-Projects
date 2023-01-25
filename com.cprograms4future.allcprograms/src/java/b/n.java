/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  b.y
 *  b.y$b
 *  java.lang.AssertionError
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.ArrayDeque
 *  java.util.Deque
 *  java.util.Iterator
 *  java.util.concurrent.BlockingQueue
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.SynchronousQueue
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.ThreadPoolExecutor
 *  java.util.concurrent.TimeUnit
 */
package b;

import b.a.i;
import b.e;
import b.y;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class n {
    private int a = 64;
    private int b = 5;
    private ExecutorService c;
    private final Deque<y.b> d = new ArrayDeque();
    private final Deque<y.b> e = new ArrayDeque();
    private final Deque<y> f = new ArrayDeque();

    private void b() {
        if (this.e.size() >= this.a) {
            return;
        }
        if (this.d.isEmpty()) {
            return;
        }
        Iterator iterator = this.d.iterator();
        while (iterator.hasNext()) {
            y.b b2 = (y.b)iterator.next();
            if (this.c(b2) < this.b) {
                iterator.remove();
                this.e.add((Object)b2);
                this.a().execute((Runnable)b2);
            }
            if (this.e.size() < this.a) continue;
        }
    }

    private int c(y.b b2) {
        Iterator iterator = this.e.iterator();
        int n2 = 0;
        while (iterator.hasNext()) {
            if (!((y.b)iterator.next()).a().equals((Object)b2.a())) continue;
            ++n2;
        }
        return n2;
    }

    public ExecutorService a() {
        n n2 = this;
        synchronized (n2) {
            if (this.c == null) {
                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, (BlockingQueue)new SynchronousQueue(), i.a("OkHttp Dispatcher", false));
                this.c = threadPoolExecutor;
            }
            ExecutorService executorService = this.c;
            return executorService;
        }
    }

    void a(e e2) {
        n n2 = this;
        synchronized (n2) {
            block4 : {
                boolean bl = this.f.remove((Object)e2);
                if (!bl) break block4;
                return;
            }
            throw new AssertionError((Object)"Call wasn't in-flight!");
        }
    }

    void a(y.b b2) {
        n n2 = this;
        synchronized (n2) {
            if (this.e.size() < this.a && this.c(b2) < this.b) {
                this.e.add((Object)b2);
                this.a().execute((Runnable)b2);
            } else {
                this.d.add((Object)b2);
            }
            return;
        }
    }

    void a(y y2) {
        n n2 = this;
        synchronized (n2) {
            this.f.add((Object)y2);
            return;
        }
    }

    void b(y.b b2) {
        n n2 = this;
        synchronized (n2) {
            if (this.e.remove((Object)b2)) {
                this.b();
                return;
            }
            throw new AssertionError((Object)"AsyncCall wasn't running!");
        }
    }
}

