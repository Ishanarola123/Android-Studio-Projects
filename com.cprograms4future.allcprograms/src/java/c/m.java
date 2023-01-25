/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package c;

import c.c;
import c.d;
import c.f;
import c.q;
import c.r;
import c.s;
import c.t;
import java.io.IOException;

final class m
implements d {
    public final c a;
    public final q b;
    private boolean c;

    public m(q q2) {
        this(q2, new c());
    }

    public m(q q2, c c2) {
        if (q2 != null) {
            this.a = c2;
            this.b = q2;
            return;
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override
    public long a(r r2) throws IOException {
        if (r2 != null) {
            long l2;
            long l3 = 0L;
            while ((l2 = r2.a(this.a, 2048L)) != -1L) {
                l3 += l2;
                this.u();
            }
            return l3;
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override
    public s a() {
        return this.b.a();
    }

    @Override
    public void a_(c c2, long l2) throws IOException {
        if (!this.c) {
            this.a.a_(c2, l2);
            this.u();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public d b(f f2) throws IOException {
        if (!this.c) {
            this.a.a(f2);
            return this.u();
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public d b(String string) throws IOException {
        if (!this.c) {
            this.a.a(string);
            return this.u();
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public c c() {
        return this.a;
    }

    @Override
    public d c(byte[] arrby) throws IOException {
        if (!this.c) {
            this.a.b(arrby);
            return this.u();
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public d c(byte[] arrby, int n2, int n3) throws IOException {
        if (!this.c) {
            this.a.b(arrby, n2, n3);
            return this.u();
        }
        throw new IllegalStateException("closed");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void close() throws IOException {
        Throwable throwable;
        block7 : {
            if (this.c) {
                return;
            }
            try {
                long l2 = this.a.b LCMP 0L;
                throwable = null;
                if (l2 > 0) {
                    this.b.a_(this.a, this.a.b);
                    throwable = null;
                }
            }
            catch (Throwable throwable2) {
                // empty catch block
            }
            try {
                this.b.close();
            }
            catch (Throwable throwable3) {
                if (throwable != null) break block7;
                throwable = throwable3;
            }
        }
        this.c = true;
        if (throwable != null) {
            t.a(throwable);
        }
    }

    @Override
    public d f() throws IOException {
        if (!this.c) {
            long l2 = this.a.b();
            if (l2 > 0L) {
                this.b.a_(this.a, l2);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public d f(int n2) throws IOException {
        if (!this.c) {
            this.a.d(n2);
            return this.u();
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public void flush() throws IOException {
        if (!this.c) {
            if (this.a.b > 0L) {
                this.b.a_(this.a, this.a.b);
            }
            this.b.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public d g(int n2) throws IOException {
        if (!this.c) {
            this.a.c(n2);
            return this.u();
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public d h(int n2) throws IOException {
        if (!this.c) {
            this.a.b(n2);
            return this.u();
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public d j(long l2) throws IOException {
        if (!this.c) {
            this.a.i(l2);
            return this.u();
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public d k(long l2) throws IOException {
        if (!this.c) {
            this.a.h(l2);
            return this.u();
        }
        throw new IllegalStateException("closed");
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("buffer(");
        stringBuilder.append((Object)this.b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    @Override
    public d u() throws IOException {
        if (!this.c) {
            long l2 = this.a.i();
            if (l2 > 0L) {
                this.b.a_(this.a, l2);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }
}

