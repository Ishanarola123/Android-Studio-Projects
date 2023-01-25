/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  b.a.a.d$1
 *  b.a.a.d$2
 *  b.a.a.d$3
 *  b.a.a.d$4
 *  b.a.a.d$5
 *  b.a.a.d$6
 *  b.a.a.d$7
 *  b.a.a.d$b$1
 *  b.a.a.d$c
 *  b.a.a.i
 *  b.a.a.o
 *  c.c
 *  c.d
 *  c.e
 *  java.io.Closeable
 *  java.io.IOException
 *  java.lang.AssertionError
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.net.Socket
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.LinkedHashSet
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 *  java.util.concurrent.BlockingQueue
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.Future
 *  java.util.concurrent.LinkedBlockingQueue
 *  java.util.concurrent.SynchronousQueue
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.ThreadPoolExecutor
 *  java.util.concurrent.TimeUnit
 */
package b.a.a;

import b.a.a.d;
import b.a.a.e;
import b.a.a.f;
import b.a.a.i;
import b.a.a.l;
import b.a.a.m;
import b.a.a.n;
import b.a.a.o;
import b.a.a.p;
import b.x;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
 * Exception performing whole class analysis.
 */
public final class d
implements Closeable {
    static final /* synthetic */ boolean k;
    private static final ExecutorService l;
    final x a;
    final boolean b;
    long c;
    long d;
    n e;
    final n f;
    final p g;
    final Socket h;
    final b.a.a.c i;
    final c j;
    private final b m;
    private final Map<Integer, e> n;
    private final String o;
    private int p;
    private int q;
    private boolean r;
    private long s;
    private final ExecutorService t;
    private Map<Integer, l> u;
    private final m v;
    private int w;
    private boolean x;
    private final Set<Integer> y;

    static {
        k = true ^ d.class.desiredAssertionStatus();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, (BlockingQueue)new SynchronousQueue(), b.a.i.a("OkHttp FramedConnection", true));
        l = threadPoolExecutor;
    }

    private d(a a2) throws IOException {
        block8 : {
            block7 : {
                block6 : {
                    this.n = new HashMap();
                    this.s = System.nanoTime();
                    this.c = 0L;
                    this.e = new n();
                    this.f = new n();
                    this.x = false;
                    this.y = new LinkedHashSet();
                    this.a = a2.f;
                    this.v = a2.g;
                    this.b = a2.h;
                    this.m = a2.e;
                    boolean bl = a2.h;
                    int n2 = 2;
                    int n3 = bl ? 1 : 2;
                    this.q = n3;
                    if (a2.h && this.a == x.d) {
                        this.q = n2 + this.q;
                    }
                    if (a2.h) {
                        n2 = 1;
                    }
                    this.w = n2;
                    if (a2.h) {
                        this.e.a(7, 0, 16777216);
                    }
                    this.o = a2.b;
                    if (this.a != x.d) break block6;
                    this.g = new i();
                    TimeUnit timeUnit = TimeUnit.SECONDS;
                    LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
                    Object[] arrobject = new Object[]{this.o};
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 60L, timeUnit, (BlockingQueue)linkedBlockingQueue, b.a.i.a(String.format((String)"OkHttp %s Push Observer", (Object[])arrobject), true));
                    this.t = threadPoolExecutor;
                    this.f.a(7, 0, 65535);
                    this.f.a(5, 0, 16384);
                    break block7;
                }
                if (this.a != x.c) break block8;
                this.g = new o();
                this.t = null;
            }
            this.d = this.f.f(65536);
            this.h = a2.a;
            this.i = this.g.a(a2.d, this.b);
            this.j = new /* Unavailable Anonymous Inner Class!! */;
            new Thread((Runnable)this.j).start();
            return;
        }
        throw new AssertionError((Object)this.a);
    }

    /* synthetic */ d(a a2, 1 var2_2) throws IOException {
        this(a2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private e a(int n2, List<f> list, boolean bl, boolean bl2) throws IOException {
        b.a.a.c c2;
        boolean bl3 = bl ^ true;
        boolean bl4 = bl2 ^ true;
        b.a.a.c c3 = c2 = this.i;
        // MONITORENTER : c3
        d d2 = this;
        // MONITORENTER : d2
        if (this.r) throw new IOException("shutdown");
        int n3 = this.q;
        this.q = 2 + this.q;
        e e2 = new e(n3, this, bl3, bl4, list);
        if (e2.b()) {
            this.n.put((Object)n3, (Object)e2);
            this.a(false);
        }
        // MONITOREXIT : d2
        if (n2 == 0) {
            this.i.a(bl3, bl4, n3, n2, list);
        } else {
            if (this.b) throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
            this.i.a(n2, n3, list);
        }
        // MONITOREXIT : c3
        if (bl) return e2;
        this.i.b();
        return e2;
    }

    static /* synthetic */ String a(d d2) {
        return d2.o;
    }

    private void a(int n2, c.e e2, int n3, boolean bl) throws IOException {
        c.c c2 = new c.c();
        long l2 = n3;
        e2.a(l2);
        e2.a(c2, l2);
        if (c2.b() == l2) {
            ExecutorService executorService = this.t;
            Object[] arrobject = new Object[]{this.o, n2};
            6 var16_9 = new 6(this, "OkHttp %s Push Data[%s]", arrobject, n2, c2, n3, bl);
            executorService.execute((Runnable)var16_9);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c2.b());
        stringBuilder.append(" != ");
        stringBuilder.append(n3);
        throw new IOException(stringBuilder.toString());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(int n2, List<f> list) {
        d d2 = this;
        synchronized (d2) {
            if (this.y.contains((Object)n2)) {
                this.a(n2, b.a.a.a.b);
                return;
            }
            this.y.add((Object)n2);
        }
        ExecutorService executorService = this.t;
        Object[] arrobject = new Object[]{this.o, n2};
        4 var7_6 = new 4(this, "OkHttp %s Push Request[%s]", arrobject, n2, list);
        executorService.execute((Runnable)var7_6);
    }

    private void a(int n2, List<f> list, boolean bl) {
        ExecutorService executorService = this.t;
        Object[] arrobject = new Object[]{this.o, n2};
        5 var6_6 = new 5(this, "OkHttp %s Push Headers[%s]", arrobject, n2, list, bl);
        executorService.execute((Runnable)var6_6);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private void a(b.a.a.a a2, b.a.a.a a3) throws IOException {
        IOException iOException;
        block19 : {
            e[] arre;
            if (!k) {
                if (Thread.holdsLock((Object)this)) throw new AssertionError();
            }
            try {
                this.a(a2);
                iOException = null;
            }
            catch (IOException iOException2) {
                // empty catch block
            }
            d d2 = this;
            // MONITORENTER : d2
            boolean bl = this.n.isEmpty();
            int n2 = 0;
            if (!bl) {
                arre = (e[])this.n.values().toArray((Object[])new e[this.n.size()]);
                this.n.clear();
                this.a(false);
            } else {
                arre = null;
            }
            Map<Integer, l> map = this.u;
            l[] arrl = null;
            if (map != null) {
                l[] arrl2 = (l[])this.u.values().toArray((Object[])new l[this.u.size()]);
                this.u = null;
                arrl = arrl2;
            }
            // MONITOREXIT : d2
            if (arre != null) {
                int n3 = arre.length;
                IOException iOException3 = iOException;
                for (int i2 = 0; i2 < n3; ++i2) {
                    e e2 = arre[i2];
                    try {
                        e2.a(a3);
                        continue;
                    }
                    catch (IOException iOException4) {
                        if (iOException3 == null) continue;
                        iOException3 = iOException4;
                    }
                }
                iOException = iOException3;
            }
            if (arrl != null) {
                int n4 = arrl.length;
                while (n2 < n4) {
                    arrl[n2].c();
                    ++n2;
                }
            }
            try {
                this.i.close();
            }
            catch (IOException iOException5) {
                if (iOException != null) break block19;
                iOException = iOException5;
            }
        }
        try {
            this.h.close();
        }
        catch (IOException iOException6) {
            // empty catch block
        }
        if (iOException != null) throw iOException;
    }

    static /* synthetic */ void a(d d2, int n2, b.a.a.a a2) {
        d2.c(n2, a2);
    }

    static /* synthetic */ void a(d d2, int n2, c.e e2, int n3, boolean bl) throws IOException {
        d2.a(n2, e2, n3, bl);
    }

    static /* synthetic */ void a(d d2, int n2, List list) {
        d2.a(n2, (List<f>)list);
    }

    static /* synthetic */ void a(d d2, int n2, List list, boolean bl) {
        d2.a(n2, (List<f>)list, bl);
    }

    static /* synthetic */ void a(d d2, b.a.a.a a2, b.a.a.a a3) throws IOException {
        d2.a(a2, a3);
    }

    static /* synthetic */ void a(d d2, boolean bl, int n2, int n3, l l2) throws IOException {
        d2.b(bl, n2, n3, l2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(boolean bl) {
        d d2 = this;
        synchronized (d2) {
            long l2;
            block4 : {
                if (bl) {
                    try {
                        l2 = System.nanoTime();
                        break block4;
                    }
                    catch (Throwable throwable) {}
                    throw throwable;
                }
                l2 = Long.MAX_VALUE;
            }
            this.s = l2;
            return;
        }
    }

    private void a(boolean bl, int n2, int n3, l l2) {
        ExecutorService executorService = l;
        Object[] arrobject = new Object[]{this.o, n2, n3};
        3 var7_7 = new 3(this, "OkHttp %s ping %08x%08x", arrobject, bl, n2, n3, l2);
        executorService.execute((Runnable)var7_7);
    }

    static /* synthetic */ boolean a(d d2, int n2) {
        return d2.d(n2);
    }

    static /* synthetic */ boolean a(d d2, boolean bl) {
        d2.x = bl;
        return bl;
    }

    static /* synthetic */ int b(d d2, int n2) {
        d2.p = n2;
        return n2;
    }

    static /* synthetic */ void b(d d2, boolean bl, int n2, int n3, l l2) {
        d2.a(bl, n2, n3, l2);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private void b(boolean var1_1, int var2_2, int var3_3, l var4_4) throws IOException {
        var7_6 = var5_5 = this.i;
        // MONITORENTER : var7_6
        if (var4_4 == null) ** GOTO lbl6
        var4_4.a();
lbl6: // 2 sources:
        this.i.a(var1_1, var2_2, var3_3);
        // MONITOREXIT : var7_6
        return;
    }

    static /* synthetic */ boolean b(d d2) {
        return d2.r;
    }

    static /* synthetic */ boolean b(d d2, boolean bl) {
        d2.r = bl;
        return bl;
    }

    static /* synthetic */ int c(d d2) {
        return d2.p;
    }

    private l c(int n2) {
        d d2 = this;
        synchronized (d2) {
            l l2 = this.u != null ? (l)this.u.remove((Object)n2) : null;
            return l2;
        }
    }

    static /* synthetic */ l c(d d2, int n2) {
        return d2.c(n2);
    }

    private void c(int n2, b.a.a.a a2) {
        ExecutorService executorService = this.t;
        Object[] arrobject = new Object[]{this.o, n2};
        7 var5_5 = new 7(this, "OkHttp %s Push Reset[%s]", arrobject, n2, a2);
        executorService.execute((Runnable)var5_5);
    }

    static /* synthetic */ int d(d d2) {
        return d2.q;
    }

    private boolean d(int n2) {
        return this.a == x.d && n2 != 0 && (n2 & 1) == 0;
    }

    static /* synthetic */ Map e(d d2) {
        return d2.n;
    }

    static /* synthetic */ ExecutorService e() {
        return l;
    }

    static /* synthetic */ b f(d d2) {
        return d2.m;
    }

    static /* synthetic */ boolean g(d d2) {
        return d2.x;
    }

    static /* synthetic */ m h(d d2) {
        return d2.v;
    }

    static /* synthetic */ Set i(d d2) {
        return d2.y;
    }

    e a(int n2) {
        d d2 = this;
        synchronized (d2) {
            e e2 = (e)this.n.get((Object)n2);
            return e2;
        }
    }

    public e a(List<f> list, boolean bl, boolean bl2) throws IOException {
        return this.a(0, list, bl, bl2);
    }

    public x a() {
        return this.a;
    }

    void a(int n2, long l2) {
        ExecutorService executorService = l;
        Object[] arrobject = new Object[]{this.o, n2};
        2 var6_5 = new 2(this, "OkHttp Window Update %s stream %d", arrobject, n2, l2);
        executorService.execute((Runnable)var6_5);
    }

    void a(int n2, b.a.a.a a2) {
        ExecutorService executorService = l;
        Object[] arrobject = new Object[]{this.o, n2};
        1 var5_5 = new 1(this, "OkHttp %s stream %d", arrobject, n2, a2);
        executorService.submit((Runnable)var5_5);
    }

    /*
     * Exception decompiling
     */
    public void a(int var1_1, boolean var2_2, c.c var3_3, long var4_4) throws IOException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 5[CATCHBLOCK]
        // org.benf.cfr.reader.b.a.a.j.a(Op04StructuredStatement.java:432)
        // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:484)
        // org.benf.cfr.reader.b.a.a.i.a(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:692)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
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

    void a(long l2) {
        this.d = l2 + this.d;
        if (l2 > 0L) {
            this.notifyAll();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(b.a.a.a a2) throws IOException {
        b.a.a.c c2;
        b.a.a.c c3 = c2 = this.i;
        synchronized (c3) {
            int n2;
            d d2 = this;
            synchronized (d2) {
                if (this.r) {
                    return;
                }
                this.r = true;
                n2 = this.p;
            }
            this.i.a(n2, a2, b.a.i.a);
            return;
        }
    }

    public int b() {
        d d2 = this;
        synchronized (d2) {
            int n2 = this.f.d(Integer.MAX_VALUE);
            return n2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    e b(int n2) {
        d d2 = this;
        synchronized (d2) {
            e e2 = (e)this.n.remove((Object)n2);
            if (e2 != null && this.n.isEmpty()) {
                this.a(true);
            }
            this.notifyAll();
            return e2;
        }
    }

    void b(int n2, b.a.a.a a2) throws IOException {
        this.i.a(n2, a2);
    }

    public void c() throws IOException {
        this.i.b();
    }

    public void close() throws IOException {
        this.a(b.a.a.a.a, b.a.a.a.l);
    }

    public void d() throws IOException {
        this.i.a();
        this.i.b(this.e);
        int n2 = this.e.f(65536);
        if (n2 != 65536) {
            this.i.a(0, n2 - 65536);
        }
    }

    public static class a {
        private Socket a;
        private String b;
        private c.e c;
        private c.d d;
        private b e = b.a;
        private x f = x.c;
        private m g = m.a;
        private boolean h;

        public a(boolean bl) throws IOException {
            this.h = bl;
        }

        public a a(b b2) {
            this.e = b2;
            return this;
        }

        public a a(x x2) {
            this.f = x2;
            return this;
        }

        public a a(Socket socket, String string, c.e e2, c.d d2) {
            this.a = socket;
            this.b = string;
            this.c = e2;
            this.d = d2;
            return this;
        }

        public d a() throws IOException {
            return new d(this, null);
        }
    }

    public static abstract class b {
        public static final b a = new 1();

        public void a(d d2) {
        }

        public abstract void a(e var1) throws IOException;
    }

}

