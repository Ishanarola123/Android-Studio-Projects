/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  b.a.a.e$a
 *  b.a.a.e$b
 *  b.a.a.e$c
 *  c.e
 *  java.io.IOException
 *  java.io.InterruptedIOException
 *  java.lang.AssertionError
 *  java.lang.IllegalStateException
 *  java.lang.InterruptedException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 */
package b.a.a;

import b.a.a.d;
import b.a.a.e;
import b.a.a.f;
import b.a.a.g;
import b.a.a.n;
import c.q;
import c.r;
import c.s;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
 * Exception performing whole class analysis.
 * Exception performing whole class analysis ignored.
 */
public final class e {
    static final /* synthetic */ boolean d;
    long a;
    long b;
    final a c;
    private final int e;
    private final d f;
    private final List<f> g;
    private List<f> h;
    private final b i;
    private final c j;
    private final c k;
    private b.a.a.a l;

    static {
        d = true ^ e.class.desiredAssertionStatus();
    }

    e(int n2, d d2, boolean bl, boolean bl2, List<f> list) {
        this.a = 0L;
        this.j = new /* Unavailable Anonymous Inner Class!! */;
        this.k = new /* Unavailable Anonymous Inner Class!! */;
        this.l = null;
        if (d2 != null) {
            if (list != null) {
                this.e = n2;
                this.f = d2;
                this.b = d2.f.f(65536);
                this.i = new /* Unavailable Anonymous Inner Class!! */;
                this.c = new /* Unavailable Anonymous Inner Class!! */;
                b.a(this.i, (boolean)bl2);
                a.a(this.c, (boolean)bl);
                this.g = list;
                return;
            }
            throw new NullPointerException("requestHeaders == null");
        }
        throw new NullPointerException("connection == null");
    }

    static /* synthetic */ d a(e e2) {
        return e2.f;
    }

    static /* synthetic */ int b(e e2) {
        return e2.e;
    }

    static /* synthetic */ c c(e e2) {
        return e2.j;
    }

    static /* synthetic */ b.a.a.a d(e e2) {
        return e2.l;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean d(b.a.a.a a2) {
        if (!d && Thread.holdsLock((Object)this)) {
            throw new AssertionError();
        }
        e e2 = this;
        synchronized (e2) {
            if (this.l != null) {
                return false;
            }
            if (b.a(this.i) && a.a(this.c)) {
                return false;
            }
            this.l = a2;
            this.notifyAll();
        }
        this.f.b(this.e);
        return true;
    }

    static /* synthetic */ void e(e e2) throws InterruptedIOException {
        e2.l();
    }

    static /* synthetic */ void f(e e2) throws IOException {
        e2.j();
    }

    static /* synthetic */ c g(e e2) {
        return e2.k;
    }

    static /* synthetic */ void h(e e2) throws IOException {
        e2.k();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private void j() throws IOException {
        if (!d) {
            if (Thread.holdsLock((Object)this)) throw new AssertionError();
        }
        e e2 = this;
        // MONITORENTER : e2
        boolean bl = !b.a(this.i) && b.b(this.i) && (a.a(this.c) || a.b(this.c));
        boolean bl2 = this.b();
        // MONITOREXIT : e2
        if (bl) {
            this.a(b.a.a.a.l);
            return;
        }
        if (bl2) return;
        this.f.b(this.e);
    }

    private void k() throws IOException {
        if (!a.b(this.c)) {
            if (!a.a(this.c)) {
                if (this.l == null) {
                    return;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("stream was reset: ");
                stringBuilder.append((Object)this.l);
                throw new IOException(stringBuilder.toString());
            }
            throw new IOException("stream finished");
        }
        throw new IOException("stream closed");
    }

    private void l() throws InterruptedIOException {
        try {
            this.wait();
            return;
        }
        catch (InterruptedException interruptedException) {
            throw new InterruptedIOException();
        }
    }

    public int a() {
        return this.e;
    }

    void a(long l2) {
        this.b = l2 + this.b;
        if (l2 > 0L) {
            this.notifyAll();
        }
    }

    public void a(b.a.a.a a2) throws IOException {
        if (!this.d(a2)) {
            return;
        }
        this.f.b(this.e, a2);
    }

    void a(c.e e2, int n2) throws IOException {
        if (!d && Thread.holdsLock((Object)this)) {
            throw new AssertionError();
        }
        this.i.a(e2, (long)n2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    void a(List<f> list, g g2) {
        if (!d) {
            if (Thread.holdsLock((Object)this)) throw new AssertionError();
        }
        b.a.a.a a2 = null;
        boolean bl = true;
        e e2 = this;
        // MONITORENTER : e2
        if (this.h == null) {
            if (g2.c()) {
                a2 = b.a.a.a.b;
            } else {
                this.h = list;
                bl = this.b();
                this.notifyAll();
                a2 = null;
            }
        } else if (g2.d()) {
            a2 = b.a.a.a.e;
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.h);
            arrayList.addAll(list);
            this.h = arrayList;
        }
        // MONITOREXIT : e2
        if (a2 != null) {
            this.b(a2);
            return;
        }
        if (bl) return;
        this.f.b(this.e);
    }

    public void b(b.a.a.a a2) {
        if (!this.d(a2)) {
            return;
        }
        this.f.a(this.e, a2);
    }

    public boolean b() {
        e e2 = this;
        synchronized (e2) {
            block5 : {
                List<f> list;
                block4 : {
                    b.a.a.a a2 = this.l;
                    if (a2 == null) break block4;
                    return false;
                }
                if (!b.a(this.i) && !b.b(this.i) || !a.a(this.c) && !a.b(this.c) || (list = this.h) == null) break block5;
                return false;
            }
            return true;
        }
    }

    void c(b.a.a.a a2) {
        e e2 = this;
        synchronized (e2) {
            if (this.l == null) {
                this.l = a2;
                this.notifyAll();
            }
            return;
        }
    }

    public boolean c() {
        boolean bl = (1 & this.e) == 1;
        return this.f.b == bl;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List<f> d() throws IOException {
        e e2 = this;
        synchronized (e2) {
            block7 : {
                this.j.c();
                while (this.h == null && this.l == null) {
                    this.l();
                }
                if (this.h == null) break block7;
                List<f> list = this.h;
                return list;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("stream was reset: ");
            stringBuilder.append((Object)this.l);
            throw new IOException(stringBuilder.toString());
            finally {
                this.j.b();
            }
        }
    }

    public s e() {
        return this.j;
    }

    public s f() {
        return this.k;
    }

    public r g() {
        return this.i;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public q h() {
        e e2 = this;
        synchronized (e2) {
            if (this.h == null && !this.c()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
            return this.c;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    void i() {
        if (!d) {
            if (Thread.holdsLock((Object)this)) throw new AssertionError();
        }
        e e2 = this;
        // MONITORENTER : e2
        b.a(this.i, (boolean)true);
        boolean bl = this.b();
        this.notifyAll();
        // MONITOREXIT : e2
        if (bl) return;
        this.f.b(this.e);
    }

}

