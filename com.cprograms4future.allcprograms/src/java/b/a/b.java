/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  b.a.b$1
 *  c.d
 *  java.io.Closeable
 *  java.io.File
 *  java.io.Flushable
 *  java.io.IOException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.concurrent.Executor
 *  java.util.regex.Pattern
 */
package b.a;

import b.a.b;
import c.d;
import c.q;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;

public final class b
implements Closeable,
Flushable {
    static final Pattern a;
    static final /* synthetic */ boolean b;
    private static final q p;
    private final b.a.c.a c;
    private long d;
    private final int e;
    private long f;
    private d g;
    private final LinkedHashMap<String, b> h;
    private int i;
    private boolean j;
    private boolean k;
    private boolean l;
    private long m;
    private final Executor n;
    private final Runnable o;

    static {
        b = true ^ b.class.desiredAssertionStatus();
        a = Pattern.compile((String)"[a-z0-9_-]{1,120}");
        p = new 1();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(a a2, boolean bl) throws IOException {
        b b2 = this;
        synchronized (b2) {
            b b3 = a2.b;
            if (b3.f != a2) {
                throw new IllegalStateException();
            }
            int n2 = 0;
            if (bl) {
                boolean bl2 = b3.e;
                n2 = 0;
                if (!bl2) {
                    int n3 = 0;
                    do {
                        int n4 = this.e;
                        n2 = 0;
                        if (n3 >= n4) break;
                        if (!a2.c[n3]) {
                            a2.a();
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Newly created entry didn't create value for index ");
                            stringBuilder.append(n3);
                            throw new IllegalStateException(stringBuilder.toString());
                        }
                        if (!this.c.b(b3.d[n3])) {
                            a2.a();
                            return;
                        }
                        ++n3;
                    } while (true);
                }
            }
            do {
                if (n2 < this.e) {
                    File file = b3.d[n2];
                    if (bl) {
                        if (this.c.b(file)) {
                            long l2;
                            File file2 = b3.c[n2];
                            this.c.a(file, file2);
                            long l3 = b3.b[n2];
                            b.b((b)b3)[n2] = l2 = this.c.c(file2);
                            this.f = l2 + (this.f - l3);
                        }
                    } else {
                        this.c.a(file);
                    }
                } else {
                    this.i = 1 + this.i;
                    b3.f = null;
                    if (bl | b3.e) {
                        b3.e = true;
                        this.g.b("CLEAN").h(32);
                        this.g.b(b3.a);
                        b3.a(this.g);
                        this.g.h(10);
                        if (bl) {
                            long l4 = this.m;
                            this.m = 1L + l4;
                            b3.g = l4;
                        }
                    } else {
                        this.h.remove((Object)b3.a);
                        this.g.b("REMOVE").h(32);
                        this.g.b(b3.a);
                        this.g.h(10);
                    }
                    this.g.flush();
                    if (this.f > this.d || this.b()) {
                        this.n.execute(this.o);
                    }
                    return;
                }
                ++n2;
            } while (true);
        }
    }

    private boolean a(b b2) throws IOException {
        if (b2.f != null) {
            b2.f.d = true;
        }
        for (int i2 = 0; i2 < this.e; ++i2) {
            this.c.a(b2.c[i2]);
            this.f -= b2.b[i2];
            b.b((b)b2)[i2] = 0L;
        }
        this.i = 1 + this.i;
        this.g.b("REMOVE").h(32).b(b2.a).h(10);
        this.h.remove((Object)b2.a);
        if (this.b()) {
            this.n.execute(this.o);
        }
        return true;
    }

    private boolean b() {
        return this.i >= 2000 && this.i >= this.h.size();
    }

    private void c() {
        b b2 = this;
        synchronized (b2) {
            block4 : {
                boolean bl = this.a();
                if (bl) break block4;
                return;
            }
            throw new IllegalStateException("cache is closed");
        }
    }

    private void d() throws IOException {
        while (this.f > this.d) {
            this.a((b)this.h.values().iterator().next());
        }
        this.l = false;
    }

    public boolean a() {
        b b2 = this;
        synchronized (b2) {
            boolean bl = this.k;
            return bl;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void close() throws IOException {
        b b2 = this;
        synchronized (b2) {
            if (!this.j || this.k) {
                this.k = true;
                return;
            }
            b[] arrb = (b[])this.h.values().toArray((Object[])new b[this.h.size()]);
            int n2 = arrb.length;
            int n3 = 0;
            do {
                if (n3 >= n2) {
                    this.d();
                    this.g.close();
                    this.g = null;
                    this.k = true;
                    return;
                }
                b b3 = arrb[n3];
                if (b3.f != null) {
                    b3.f.a();
                }
                ++n3;
            } while (true);
        }
    }

    public void flush() throws IOException {
        b b2 = this;
        synchronized (b2) {
            block4 : {
                boolean bl = this.j;
                if (bl) break block4;
                return;
            }
            this.c();
            this.d();
            this.g.flush();
            return;
        }
    }

    public final class a {
        final /* synthetic */ b a;
        private final b b;
        private final boolean[] c;
        private boolean d;

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public void a() throws IOException {
            b b2;
            b b3 = b2 = this.a;
            synchronized (b3) {
                this.a.a(this, false);
                return;
            }
        }
    }

    private final class b {
        private final String a;
        private final long[] b;
        private final File[] c;
        private final File[] d;
        private boolean e;
        private a f;
        private long g;

        void a(d d2) throws IOException {
            for (long l2 : this.b) {
                d2.h(32).k(l2);
            }
        }
    }

}

