/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.CloneNotSupportedException
 *  java.lang.IllegalStateException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 */
package d;

import b.ab;
import b.ac;
import b.e;
import b.f;
import b.u;
import b.z;
import c.c;
import c.e;
import c.r;
import d.d;
import d.l;
import d.n;
import d.o;
import java.io.IOException;

final class h<T>
implements d.b<T> {
    private final n<T> a;
    private final Object[] b;
    private volatile boolean c;
    private b.e d;
    private Throwable e;
    private boolean f;

    h(n<T> n2, Object[] arrobject) {
        this.a = n2;
        this.b = arrobject;
    }

    private b.e e() throws IOException {
        z z2 = this.a.a(this.b);
        b.e e2 = this.a.c.a(z2);
        if (e2 != null) {
            return e2;
        }
        throw new NullPointerException("Call.Factory returned null.");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    @Override
    public l<T> a() throws IOException {
        h h2 = this;
        // MONITORENTER : h2
        if (this.f) throw new IllegalStateException("Already executed.");
        this.f = true;
        if (this.e != null) {
            if (!(this.e instanceof IOException)) throw (RuntimeException)this.e;
            throw (IOException)this.e;
        }
        b.e e2 = this.d;
        if (e2 == null) {
            try {
                this.d = e2 = this.e();
            }
            catch (IOException | RuntimeException throwable) {
                this.e = throwable;
                throw throwable;
            }
        }
        // MONITOREXIT : h2
        if (!this.c) return this.a(e2.a());
        e2.b();
        return this.a(e2.a());
    }

    l<T> a(ab ab2) throws IOException {
        ac ac2 = ab2.f();
        ab ab3 = ab2.g().a(new b(ac2.a(), ac2.b())).a();
        int n2 = ab3.b();
        if (n2 >= 200 && n2 < 300) {
            if (n2 != 204 && n2 != 205) {
                a a2 = new a(ac2);
                try {
                    l<T> l2 = l.a(this.a.a(a2), ab3);
                    return l2;
                }
                catch (RuntimeException runtimeException) {
                    a2.f();
                    throw runtimeException;
                }
            }
            return l.a(null, ab3);
        }
        try {
            l<ac> l3 = l.a(o.a(ac2), ab3);
            return l3;
        }
        finally {
            ac2.close();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    @Override
    public void a(final d<T> d2) {
        if (d2 == null) throw new NullPointerException("callback == null");
        h h2 = this;
        // MONITORENTER : h2
        if (this.f) throw new IllegalStateException("Already executed.");
        this.f = true;
        b.e e2 = this.d;
        Throwable throwable = this.e;
        if (e2 == null && throwable == null) {
            try {
                b.e e3;
                this.d = e3 = this.e();
                e2 = e3;
            }
            catch (Throwable throwable2) {
                this.e = throwable2;
            }
        }
        // MONITOREXIT : h2
        if (throwable != null) {
            d2.a(this, throwable);
            return;
        }
        if (this.c) {
            e2.b();
        }
        e2.a(new f(){

            private void a(l<T> l2) {
                try {
                    d2.a(h.this, l2);
                    return;
                }
                catch (Throwable throwable) {
                    throwable.printStackTrace();
                    return;
                }
            }

            private void a(Throwable throwable) {
                try {
                    d2.a(h.this, throwable);
                    return;
                }
                catch (Throwable throwable2) {
                    throwable2.printStackTrace();
                    return;
                }
            }

            @Override
            public void a(b.e e2, ab ab2) throws IOException {
                l l2;
                try {
                    l2 = h.this.a(ab2);
                }
                catch (Throwable throwable) {
                    this.a(throwable);
                    return;
                }
                this.a(l2);
            }

            @Override
            public void a(b.e e2, IOException iOException) {
                try {
                    d2.a(h.this, iOException);
                    return;
                }
                catch (Throwable throwable) {
                    throwable.printStackTrace();
                    return;
                }
            }
        });
    }

    @Override
    public boolean b() {
        return this.c;
    }

    @Override
    public /* synthetic */ d.b c() {
        return this.d();
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return this.d();
    }

    public h<T> d() {
        return new h<T>(this.a, this.b);
    }

    static final class a
    extends ac {
        IOException a;
        private final ac b;

        a(ac ac2) {
            this.b = ac2;
        }

        @Override
        public u a() {
            return this.b.a();
        }

        @Override
        public long b() {
            return this.b.b();
        }

        @Override
        public void close() {
            this.b.close();
        }

        @Override
        public e d() {
            return c.l.a(new c.h(this.b.d()){

                @Override
                public long a(c c2, long l2) throws IOException {
                    try {
                        long l3 = super.a(c2, l2);
                        return l3;
                    }
                    catch (IOException iOException) {
                        a.this.a = iOException;
                        throw iOException;
                    }
                }
            });
        }

        void f() throws IOException {
            if (this.a == null) {
                return;
            }
            throw this.a;
        }

    }

    static final class b
    extends ac {
        private final u a;
        private final long b;

        b(u u2, long l2) {
            this.a = u2;
            this.b = l2;
        }

        @Override
        public u a() {
            return this.a;
        }

        @Override
        public long b() {
            return this.b;
        }

        @Override
        public e d() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

}

