/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  b.a.c.b
 *  java.lang.AssertionError
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.ref.Reference
 *  java.net.Socket
 *  java.util.ArrayDeque
 *  java.util.Deque
 *  java.util.Iterator
 *  java.util.List
 *  java.util.concurrent.BlockingQueue
 *  java.util.concurrent.Executor
 *  java.util.concurrent.SynchronousQueue
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.ThreadPoolExecutor
 *  java.util.concurrent.TimeUnit
 *  java.util.logging.Logger
 */
package b;

import b.a;
import b.a.b.r;
import b.a.c;
import b.a.c.b;
import b.a.h;
import b.a.i;
import b.ad;
import b.s;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public final class j {
    static final /* synthetic */ boolean c;
    private static final Executor d;
    final h a = new h();
    boolean b;
    private final int e;
    private final long f;
    private final Runnable g = new Runnable(){

        /*
         * Exception decompiling
         */
        public void run() {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl41.1 : ALOAD : trying to set 1 previously set to 0
            // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
            // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
            // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
            // org.benf.cfr.reader.entities.g.p(Method.java:396)
            // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
            // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
            // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
            // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
            // org.benf.cfr.reader.b.a(Driver.java:128)
            // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
            // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
            // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
            // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
            // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
            // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1162)
            // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:636)
            // java.lang.Thread.run(Thread.java:764)
            throw new IllegalStateException("Decompilation failed");
        }
    };
    private final Deque<b> h = new ArrayDeque();

    static {
        c = true ^ j.class.desiredAssertionStatus();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, (BlockingQueue)new SynchronousQueue(), i.a("OkHttp ConnectionPool", true));
        d = threadPoolExecutor;
    }

    public j() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    public j(int n2, long l2, TimeUnit timeUnit) {
        this.e = n2;
        this.f = timeUnit.toNanos(l2);
        if (l2 > 0L) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("keepAliveDuration <= 0: ");
        stringBuilder.append(l2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    private int a(b b2, long l2) {
        List list = b2.h;
        int n2 = 0;
        while (n2 < list.size()) {
            if (((Reference)list.get(n2)).get() != null) {
                ++n2;
                continue;
            }
            Logger logger = c.a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("A connection to ");
            stringBuilder.append((Object)b2.a().a().a());
            stringBuilder.append(" was leaked. Did you forget to close a response body?");
            logger.warning(stringBuilder.toString());
            list.remove(n2);
            b2.i = true;
            if (!list.isEmpty()) continue;
            b2.j = l2 - this.f;
            return 0;
        }
        return list.size();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    long a(long l2) {
        b b2;
        j j2 = this;
        synchronized (j2) {
            Iterator iterator = this.h.iterator();
            long l3 = Long.MIN_VALUE;
            b2 = null;
            int n2 = 0;
            int n3 = 0;
            while (iterator.hasNext()) {
                b b3 = (b)iterator.next();
                if (this.a(b3, l2) > 0) {
                    ++n3;
                    continue;
                }
                ++n2;
                long l4 = l2 - b3.j;
                if (l4 <= l3) continue;
                b2 = b3;
                l3 = l4;
            }
            if (l3 < this.f && n2 <= this.e) {
                if (n2 > 0) {
                    return this.f - l3;
                }
                if (n3 > 0) {
                    return this.f;
                }
                this.b = false;
                return -1L;
            }
            this.h.remove(b2);
        }
        i.a(b2.c());
        return 0L;
    }

    b a(a a2, r r2) {
        if (!c && !Thread.holdsLock((Object)this)) {
            throw new AssertionError();
        }
        for (b b2 : this.h) {
            if (b2.h.size() >= b2.g || !a2.equals(b2.a().a) || b2.i) continue;
            r2.a(b2);
            return b2;
        }
        return null;
    }

    void a(b b2) {
        if (!c && !Thread.holdsLock((Object)this)) {
            throw new AssertionError();
        }
        if (!this.b) {
            this.b = true;
            d.execute(this.g);
        }
        this.h.add((Object)b2);
    }

    boolean b(b b2) {
        if (!c && !Thread.holdsLock((Object)this)) {
            throw new AssertionError();
        }
        if (!b2.i && this.e != 0) {
            this.notifyAll();
            return false;
        }
        this.h.remove((Object)b2);
        return true;
    }

}

