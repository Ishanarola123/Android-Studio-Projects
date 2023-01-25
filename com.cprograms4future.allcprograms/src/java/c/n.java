/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.EOFException
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package c;

import c.c;
import c.e;
import c.f;
import c.n;
import c.q;
import c.r;
import c.s;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

final class n
implements e {
    public final c a;
    public final r b;
    private boolean c;

    public n(r r2) {
        this(r2, new c());
    }

    public n(r r2, c c2) {
        if (r2 != null) {
            this.a = c2;
            this.b = r2;
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    static /* synthetic */ boolean a(n n2) {
        return n2.c;
    }

    @Override
    public long a(byte by) throws IOException {
        return this.a(by, 0L);
    }

    public long a(byte by, long l2) throws IOException {
        if (!this.c) {
            long l3;
            while (l2 >= this.a.b) {
                if (this.b.a(this.a, 2048L) != -1L) continue;
                return -1L;
            }
            while ((l3 = this.a.a(by, l2)) == -1L) {
                l2 = this.a.b;
                if (this.b.a(this.a, 2048L) != -1L) continue;
                return -1L;
            }
            return l3;
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public long a(c c2, long l2) throws IOException {
        if (c2 != null) {
            if (l2 >= 0L) {
                if (!this.c) {
                    if (this.a.b == 0L && this.b.a(this.a, 2048L) == -1L) {
                        return -1L;
                    }
                    long l3 = Math.min((long)l2, (long)this.a.b);
                    return this.a.a(c2, l3);
                }
                throw new IllegalStateException("closed");
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("byteCount < 0: ");
            stringBuilder.append(l2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override
    public long a(q q2) throws IOException {
        if (q2 != null) {
            long l2 = 0L;
            while (this.b.a(this.a, 2048L) != -1L) {
                long l3 = this.a.i();
                if (l3 <= 0L) continue;
                l2 += l3;
                q2.a_(this.a, l3);
            }
            if (this.a.b() > 0L) {
                l2 += this.a.b();
                q2.a_(this.a, this.a.b());
            }
            return l2;
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override
    public s a() {
        return this.b.a();
    }

    @Override
    public void a(long l2) throws IOException {
        if (this.b(l2)) {
            return;
        }
        throw new EOFException();
    }

    public boolean b(long l2) throws IOException {
        if (l2 >= 0L) {
            if (!this.c) {
                while (this.a.b < l2) {
                    if (this.b.a(this.a, 2048L) != -1L) continue;
                    return false;
                }
                return true;
            }
            throw new IllegalStateException("closed");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("byteCount < 0: ");
        stringBuilder.append(l2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    @Override
    public c c() {
        return this.a;
    }

    @Override
    public f c(long l2) throws IOException {
        this.a(l2);
        return this.a.c(l2);
    }

    @Override
    public void close() throws IOException {
        if (this.c) {
            return;
        }
        this.c = true;
        this.b.close();
        this.a.clear();
    }

    @Override
    public byte[] f(long l2) throws IOException {
        this.a(l2);
        return this.a.f(l2);
    }

    @Override
    public void g(long l2) throws IOException {
        if (!this.c) {
            while (l2 > 0L) {
                if (this.a.b == 0L && this.b.a(this.a, 2048L) == -1L) {
                    throw new EOFException();
                }
                long l3 = Math.min((long)l2, (long)this.a.b());
                this.a.g(l3);
                l2 -= l3;
            }
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public boolean g() throws IOException {
        if (!this.c) {
            return this.a.g() && this.b.a(this.a, 2048L) == -1L;
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public InputStream h() {
        return new InputStream(this){
            final /* synthetic */ n a;
            {
                this.a = n2;
            }

            public int available() throws IOException {
                if (!n.a(this.a)) {
                    return (int)Math.min((long)this.a.a.b, (long)Integer.MAX_VALUE);
                }
                throw new IOException("closed");
            }

            public void close() throws IOException {
                this.a.close();
            }

            public int read() throws IOException {
                if (!n.a(this.a)) {
                    if (this.a.a.b == 0L && this.a.b.a(this.a.a, 2048L) == -1L) {
                        return -1;
                    }
                    return 255 & this.a.a.j();
                }
                throw new IOException("closed");
            }

            public int read(byte[] arrby, int n2, int n3) throws IOException {
                if (!n.a(this.a)) {
                    c.t.a(arrby.length, n2, n3);
                    if (this.a.a.b == 0L && this.a.b.a(this.a.a, 2048L) == -1L) {
                        return -1;
                    }
                    return this.a.a.a(arrby, n2, n3);
                }
                throw new IOException("closed");
            }

            public String toString() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((Object)this.a);
                stringBuilder.append(".inputStream()");
                return stringBuilder.toString();
            }
        };
    }

    @Override
    public byte j() throws IOException {
        this.a(1L);
        return this.a.j();
    }

    @Override
    public short k() throws IOException {
        this.a(2L);
        return this.a.k();
    }

    @Override
    public int l() throws IOException {
        this.a(4L);
        return this.a.l();
    }

    @Override
    public short m() throws IOException {
        this.a(2L);
        return this.a.m();
    }

    @Override
    public int n() throws IOException {
        this.a(4L);
        return this.a.n();
    }

    @Override
    public long o() throws IOException {
        int n2;
        this.a(1L);
        int n3 = 0;
        while (this.b(n2 = n3 + 1)) {
            byte by = this.a.b((long)n3);
            if (by >= 48 && by <= 57 || by >= 97 && by <= 102 || by >= 65 && by <= 70) {
                n3 = n2;
                continue;
            }
            if (n3 != 0) break;
            Object[] arrobject = new Object[]{by};
            throw new NumberFormatException(String.format((String)"Expected leading [0-9a-fA-F] character but was %#x", (Object[])arrobject));
        }
        return this.a.o();
    }

    @Override
    public String r() throws IOException {
        long l2 = this.a((byte)10);
        if (l2 != -1L) {
            return this.a.e(l2);
        }
        c c2 = new c();
        this.a.a(c2, 0L, Math.min((long)32L, (long)this.a.b()));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\\n not found: size=");
        stringBuilder.append(this.a.b());
        stringBuilder.append(" content=");
        stringBuilder.append(c2.p().d());
        stringBuilder.append("...");
        throw new EOFException(stringBuilder.toString());
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("buffer(");
        stringBuilder.append((Object)this.b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

