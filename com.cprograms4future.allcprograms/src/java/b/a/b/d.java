/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  b.a.b.d$c
 *  b.a.b.d$e
 *  b.a.b.d$f
 *  c.c
 *  java.io.EOFException
 *  java.io.IOException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.net.ProtocolException
 *  java.net.Proxy
 *  java.net.Proxy$Type
 */
package b.a.b;

import b.a.b.d;
import b.a.b.g;
import b.a.b.j;
import b.a.b.k;
import b.a.b.m;
import b.a.b.n;
import b.a.b.q;
import b.a.i;
import b.ab;
import b.ac;
import b.ad;
import b.r;
import b.x;
import b.z;
import c.l;
import c.s;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;

/*
 * Exception performing whole class analysis.
 */
public final class d
implements b.a.b.i {
    private final b.a.b.r a;
    private final c.e b;
    private final c.d c;
    private g d;
    private int e;

    public d(b.a.b.r r2, c.e e2, c.d d2) {
        this.e = 0;
        this.a = r2;
        this.b = e2;
        this.c = d2;
    }

    private void a(c.i i2) {
        s s2 = i2.a();
        i2.a(s.b);
        s2.f();
        s2.C_();
    }

    private c.r b(ab ab2) throws IOException {
        if (!g.a(ab2)) {
            return this.b(0L);
        }
        if ("chunked".equalsIgnoreCase(ab2.a("Transfer-Encoding"))) {
            return this.b(this.d);
        }
        long l2 = j.a(ab2);
        if (l2 != -1L) {
            return this.b(l2);
        }
        return this.g();
    }

    @Override
    public ac a(ab ab2) throws IOException {
        c.r r2 = this.b(ab2);
        return new k(ab2.e(), l.a(r2));
    }

    public c.q a(long l2) {
        if (this.e == 1) {
            this.e = 2;
            return new d(l2);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("state: ");
        stringBuilder.append(this.e);
        throw new IllegalStateException(stringBuilder.toString());
    }

    @Override
    public c.q a(z z2, long l2) throws IOException {
        if ("chunked".equalsIgnoreCase(z2.a("Transfer-Encoding"))) {
            return this.f();
        }
        if (l2 != -1L) {
            return this.a(l2);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override
    public void a() {
        b.a.c.b b2 = this.a.a();
        if (b2 != null) {
            b2.b();
        }
    }

    @Override
    public void a(g g2) {
        this.d = g2;
    }

    @Override
    public void a(n n2) throws IOException {
        if (this.e == 1) {
            this.e = 3;
            n2.a(this.c);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("state: ");
        stringBuilder.append(this.e);
        throw new IllegalStateException(stringBuilder.toString());
    }

    public void a(r r2, String string) throws IOException {
        if (this.e == 0) {
            this.c.b(string).b("\r\n");
            int n2 = r2.a();
            for (int i2 = 0; i2 < n2; ++i2) {
                this.c.b(r2.a(i2)).b(": ").b(r2.b(i2)).b("\r\n");
            }
            this.c.b("\r\n");
            this.e = 1;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("state: ");
        stringBuilder.append(this.e);
        throw new IllegalStateException(stringBuilder.toString());
    }

    @Override
    public void a(z z2) throws IOException {
        this.d.b();
        String string = m.a(z2, this.d.d().a().b().type());
        this.a(z2.c(), string);
    }

    @Override
    public ab.a b() throws IOException {
        return this.d();
    }

    public c.r b(long l2) throws IOException {
        if (this.e == 4) {
            this.e = 5;
            return new /* Unavailable Anonymous Inner Class!! */;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("state: ");
        stringBuilder.append(this.e);
        throw new IllegalStateException(stringBuilder.toString());
    }

    public c.r b(g g2) throws IOException {
        if (this.e == 4) {
            this.e = 5;
            return new /* Unavailable Anonymous Inner Class!! */;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("state: ");
        stringBuilder.append(this.e);
        throw new IllegalStateException(stringBuilder.toString());
    }

    @Override
    public void c() throws IOException {
        this.c.flush();
    }

    public ab.a d() throws IOException {
        if (this.e != 1 && this.e != 3) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("state: ");
            stringBuilder.append(this.e);
            throw new IllegalStateException(stringBuilder.toString());
        }
        try {
            q q2;
            ab.a a2;
            do {
                q2 = q.a(this.b.r());
                a2 = new ab.a().a(q2.a).a(q2.b).a(q2.c).a(this.e());
            } while (q2.b == 100);
            this.e = 4;
            return a2;
        }
        catch (EOFException eOFException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("unexpected end of stream on ");
            stringBuilder.append((Object)this.a);
            IOException iOException = new IOException(stringBuilder.toString());
            iOException.initCause((Throwable)eOFException);
            throw iOException;
        }
    }

    public r e() throws IOException {
        String string;
        r.a a2 = new r.a();
        while ((string = this.b.r()).length() != 0) {
            b.a.c.b.a(a2, string);
        }
        return a2.a();
    }

    public c.q f() {
        if (this.e == 1) {
            this.e = 2;
            return new b();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("state: ");
        stringBuilder.append(this.e);
        throw new IllegalStateException(stringBuilder.toString());
    }

    public c.r g() throws IOException {
        if (this.e == 4) {
            if (this.a != null) {
                this.e = 5;
                this.a.c();
                return new /* Unavailable Anonymous Inner Class!! */;
            }
            throw new IllegalStateException("streamAllocation == null");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("state: ");
        stringBuilder.append(this.e);
        throw new IllegalStateException(stringBuilder.toString());
    }

    private abstract class a
    implements c.r {
        protected final c.i a;
        protected boolean b;

        private a() {
            this.a = new c.i(d.this.b.a());
        }

        @Override
        public s a() {
            return this.a;
        }

        protected final void a(boolean bl) throws IOException {
            if (d.this.e == 6) {
                return;
            }
            if (d.this.e == 5) {
                d.this.a(this.a);
                d.this.e = 6;
                if (d.this.a != null) {
                    d.this.a.a(bl ^ true, d.this);
                }
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("state: ");
            stringBuilder.append(d.this.e);
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    private final class b
    implements c.q {
        private final c.i b;
        private boolean c;

        private b() {
            this.b = new c.i(d.this.c.a());
        }

        @Override
        public s a() {
            return this.b;
        }

        @Override
        public void a_(c.c c2, long l2) throws IOException {
            if (!this.c) {
                if (l2 == 0L) {
                    return;
                }
                d.this.c.j(l2);
                d.this.c.b("\r\n");
                d.this.c.a_(c2, l2);
                d.this.c.b("\r\n");
                return;
            }
            throw new IllegalStateException("closed");
        }

        @Override
        public void close() throws IOException {
            b b2 = this;
            synchronized (b2) {
                block4 : {
                    boolean bl = this.c;
                    if (!bl) break block4;
                    return;
                }
                this.c = true;
                d.this.c.b("0\r\n\r\n");
                d.this.a(this.b);
                d.this.e = 3;
                return;
            }
        }

        @Override
        public void flush() throws IOException {
            b b2 = this;
            synchronized (b2) {
                block4 : {
                    boolean bl = this.c;
                    if (!bl) break block4;
                    return;
                }
                d.this.c.flush();
                return;
            }
        }
    }

    private final class d
    implements c.q {
        private final c.i b;
        private boolean c;
        private long d;

        private d(long l2) {
            this.b = new c.i(d.this.c.a());
            this.d = l2;
        }

        @Override
        public s a() {
            return this.b;
        }

        @Override
        public void a_(c.c c2, long l2) throws IOException {
            if (!this.c) {
                i.a(c2.b(), 0L, l2);
                if (l2 <= this.d) {
                    d.this.c.a_(c2, l2);
                    this.d -= l2;
                    return;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("expected ");
                stringBuilder.append(this.d);
                stringBuilder.append(" bytes but received ");
                stringBuilder.append(l2);
                throw new ProtocolException(stringBuilder.toString());
            }
            throw new IllegalStateException("closed");
        }

        @Override
        public void close() throws IOException {
            if (this.c) {
                return;
            }
            this.c = true;
            if (this.d <= 0L) {
                d.this.a(this.b);
                d.this.e = 3;
                return;
            }
            throw new ProtocolException("unexpected end of stream");
        }

        @Override
        public void flush() throws IOException {
            if (this.c) {
                return;
            }
            d.this.c.flush();
        }
    }

}

