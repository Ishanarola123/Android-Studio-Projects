/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.c
 *  java.io.IOException
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.UnsupportedOperationException
 *  java.util.List
 *  java.util.logging.Level
 *  java.util.logging.Logger
 */
package b.a.a;

import b.a.a.b;
import b.a.a.f;
import b.a.a.g;
import b.a.a.h;
import b.a.a.n;
import b.a.a.p;
import c.e;
import c.r;
import c.s;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class i
implements p {
    private static final Logger a = Logger.getLogger((String)b.class.getName());
    private static final c.f b = c.f.a("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    private static int b(int n2, byte by, short s2) throws IOException {
        if ((by & 8) != 0) {
            --n2;
        }
        if (s2 <= n2) {
            return (short)(n2 - s2);
        }
        Object[] arrobject = new Object[]{s2, n2};
        throw i.d("PROTOCOL_ERROR padding %s > remaining length %s", arrobject);
    }

    private static int b(e e2) throws IOException {
        return (255 & e2.j()) << 16 | (255 & e2.j()) << 8 | 255 & e2.j();
    }

    private static void b(c.d d2, int n2) throws IOException {
        d2.h(255 & n2 >>> 16);
        d2.h(255 & n2 >>> 8);
        d2.h(n2 & 255);
    }

    private static /* varargs */ IllegalArgumentException c(String string, Object ... arrobject) {
        throw new IllegalArgumentException(String.format((String)string, (Object[])arrobject));
    }

    private static /* varargs */ IOException d(String string, Object ... arrobject) throws IOException {
        throw new IOException(String.format((String)string, (Object[])arrobject));
    }

    @Override
    public b.a.a.b a(e e2, boolean bl) {
        return new c(e2, 4096, bl);
    }

    @Override
    public b.a.a.c a(c.d d2, boolean bl) {
        return new d(d2, bl);
    }

    static final class a
    implements r {
        int a;
        byte b;
        int c;
        int d;
        short e;
        private final e f;

        public a(e e2) {
            this.f = e2;
        }

        private void b() throws IOException {
            int n2;
            int n3 = this.c;
            this.d = n2 = i.b(this.f);
            this.a = n2;
            byte by = (byte)(255 & this.f.j());
            this.b = (byte)(255 & this.f.j());
            if (a.isLoggable(Level.FINE)) {
                a.fine(b.a(true, this.c, this.a, by, this.b));
            }
            this.c = Integer.MAX_VALUE & this.f.l();
            if (by == 9) {
                if (this.c == n3) {
                    return;
                }
                throw i.d("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
            Object[] arrobject = new Object[]{by};
            throw i.d("%s != TYPE_CONTINUATION", arrobject);
        }

        @Override
        public long a(c.c c2, long l2) throws IOException {
            while (this.d == 0) {
                this.f.g(this.e);
                this.e = 0;
                if ((4 & this.b) != 0) {
                    return -1L;
                }
                this.b();
            }
            long l3 = this.f.a(c2, Math.min((long)l2, (long)this.d));
            if (l3 == -1L) {
                return -1L;
            }
            this.d = (int)((long)this.d - l3);
            return l3;
        }

        @Override
        public s a() {
            return this.f.a();
        }

        @Override
        public void close() throws IOException {
        }
    }

    static final class c
    implements b.a.a.b {
        final h.a a;
        private final e b;
        private final a c;
        private final boolean d;

        c(e e2, int n2, boolean bl) {
            this.b = e2;
            this.d = bl;
            this.c = new a(this.b);
            this.a = new h.a(n2, this.c);
        }

        private List<f> a(int n2, short s2, byte by, int n3) throws IOException {
            a a2 = this.c;
            this.c.d = n2;
            a2.a = n2;
            this.c.e = s2;
            this.c.b = by;
            this.c.c = n3;
            this.a.a();
            return this.a.b();
        }

        private void a(b.a a2, int n2) throws IOException {
            int n3 = this.b.l();
            boolean bl = (Integer.MIN_VALUE & n3) != 0;
            a2.a(n2, n3 & Integer.MAX_VALUE, 1 + (255 & this.b.j()), bl);
        }

        private void a(b.a a2, int n2, byte by, int n3) throws IOException {
            if (n3 != 0) {
                boolean bl = (by & 1) != 0;
                int n4 = by & 8;
                short s2 = 0;
                if (n4 != 0) {
                    s2 = (short)(255 & this.b.j());
                }
                if ((by & 32) != 0) {
                    this.a(a2, n3);
                    n2 -= 5;
                }
                a2.a(false, bl, n3, -1, this.a(i.b(n2, by, s2), s2, by, n3), g.d);
                return;
            }
            throw i.d("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        }

        private void b(b.a a2, int n2, byte by, int n3) throws IOException {
            int n4 = by & 1;
            boolean bl = true;
            boolean bl2 = n4 != 0;
            if ((by & 32) == 0) {
                bl = false;
            }
            if (!bl) {
                int n5 = by & 8;
                short s2 = 0;
                if (n5 != 0) {
                    s2 = (short)(255 & this.b.j());
                }
                int n6 = i.b(n2, by, s2);
                a2.a(bl2, n3, this.b, n6);
                this.b.g(s2);
                return;
            }
            throw i.d("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }

        private void c(b.a a2, int n2, byte by, int n3) throws IOException {
            if (n2 == 5) {
                if (n3 != 0) {
                    this.a(a2, n3);
                    return;
                }
                throw i.d("TYPE_PRIORITY streamId == 0", new Object[0]);
            }
            Object[] arrobject = new Object[]{n2};
            throw i.d("TYPE_PRIORITY length: %d != 5", arrobject);
        }

        private void d(b.a a2, int n2, byte by, int n3) throws IOException {
            if (n2 == 4) {
                if (n3 != 0) {
                    int n4 = this.b.l();
                    b.a.a.a a3 = b.a.a.a.b(n4);
                    if (a3 != null) {
                        a2.a(n3, a3);
                        return;
                    }
                    Object[] arrobject = new Object[]{n4};
                    throw i.d("TYPE_RST_STREAM unexpected error code: %d", arrobject);
                }
                throw i.d("TYPE_RST_STREAM streamId == 0", new Object[0]);
            }
            Object[] arrobject = new Object[]{n2};
            throw i.d("TYPE_RST_STREAM length: %d != 4", arrobject);
        }

        private void e(b.a a2, int n2, byte by, int n3) throws IOException {
            if (n3 == 0) {
                if ((by & 1) != 0) {
                    if (n2 == 0) {
                        a2.a();
                        return;
                    }
                    throw i.d("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                }
                if (n2 % 6 == 0) {
                    n n4 = new n();
                    for (int i2 = 0; i2 < n2; i2 += 6) {
                        int n5 = this.b.k();
                        int n6 = this.b.l();
                        switch (n5) {
                            default: {
                                break;
                            }
                            case 5: {
                                if (n6 >= 16384 && n6 <= 16777215) break;
                                Object[] arrobject = new Object[]{n6};
                                throw i.d("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", arrobject);
                            }
                            case 4: {
                                n5 = 7;
                                if (n6 >= 0) break;
                                throw i.d("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                            }
                            case 3: {
                                n5 = 4;
                                break;
                            }
                            case 2: {
                                if (n6 == 0 || n6 == 1) break;
                                throw i.d("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                            }
                            case 1: 
                            case 6: 
                        }
                        n4.a(n5, 0, n6);
                    }
                    a2.a(false, n4);
                    if (n4.b() >= 0) {
                        this.a.a(n4.b());
                    }
                    return;
                }
                Object[] arrobject = new Object[]{n2};
                throw i.d("TYPE_SETTINGS length %% 6 != 0: %s", arrobject);
            }
            throw i.d("TYPE_SETTINGS streamId != 0", new Object[0]);
        }

        private void f(b.a a2, int n2, byte by, int n3) throws IOException {
            if (n3 != 0) {
                int n4 = by & 8;
                short s2 = 0;
                if (n4 != 0) {
                    s2 = (short)(255 & this.b.j());
                }
                a2.a(n3, Integer.MAX_VALUE & this.b.l(), this.a(i.b(n2 - 4, by, s2), s2, by, n3));
                return;
            }
            throw i.d("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }

        private void g(b.a a2, int n2, byte by, int n3) throws IOException {
            if (n2 == 8) {
                if (n3 == 0) {
                    int n4 = this.b.l();
                    int n5 = this.b.l();
                    int n6 = by & 1;
                    boolean bl = false;
                    if (n6 != 0) {
                        bl = true;
                    }
                    a2.a(bl, n4, n5);
                    return;
                }
                throw i.d("TYPE_PING streamId != 0", new Object[0]);
            }
            Object[] arrobject = new Object[]{n2};
            throw i.d("TYPE_PING length != 8: %s", arrobject);
        }

        private void h(b.a a2, int n2, byte by, int n3) throws IOException {
            if (n2 >= 8) {
                if (n3 == 0) {
                    int n4 = this.b.l();
                    int n5 = this.b.l();
                    int n6 = n2 - 8;
                    b.a.a.a a3 = b.a.a.a.b(n5);
                    if (a3 != null) {
                        c.f f2 = c.f.b;
                        if (n6 > 0) {
                            f2 = this.b.c(n6);
                        }
                        a2.a(n4, a3, f2);
                        return;
                    }
                    Object[] arrobject = new Object[]{n5};
                    throw i.d("TYPE_GOAWAY unexpected error code: %d", arrobject);
                }
                throw i.d("TYPE_GOAWAY streamId != 0", new Object[0]);
            }
            Object[] arrobject = new Object[]{n2};
            throw i.d("TYPE_GOAWAY length < 8: %s", arrobject);
        }

        private void i(b.a a2, int n2, byte by, int n3) throws IOException {
            if (n2 == 4) {
                long l2 = Integer.MAX_VALUE & (long)this.b.l();
                if (l2 != 0L) {
                    a2.a(n3, l2);
                    return;
                }
                Object[] arrobject = new Object[]{l2};
                throw i.d("windowSizeIncrement was 0", arrobject);
            }
            Object[] arrobject = new Object[]{n2};
            throw i.d("TYPE_WINDOW_UPDATE length !=4: %s", arrobject);
        }

        @Override
        public void a() throws IOException {
            if (this.d) {
                return;
            }
            c.f f2 = this.b.c(b.f());
            if (a.isLoggable(Level.FINE)) {
                Logger logger = a;
                Object[] arrobject = new Object[]{f2.d()};
                logger.fine(String.format((String)"<< CONNECTION %s", (Object[])arrobject));
            }
            if (b.equals(f2)) {
                return;
            }
            Object[] arrobject = new Object[]{f2.a()};
            throw i.d("Expected a connection header but was %s", arrobject);
        }

        @Override
        public boolean a(b.a a2) throws IOException {
            try {
                this.b.a(9L);
            }
            catch (IOException iOException) {
                return false;
            }
            int n2 = i.b(this.b);
            if (n2 >= 0 && n2 <= 16384) {
                byte by = (byte)(255 & this.b.j());
                byte by2 = (byte)(255 & this.b.j());
                int n3 = Integer.MAX_VALUE & this.b.l();
                if (a.isLoggable(Level.FINE)) {
                    a.fine(b.a(true, n3, n2, by, by2));
                }
                switch (by) {
                    default: {
                        this.b.g(n2);
                        return true;
                    }
                    case 8: {
                        this.i(a2, n2, by2, n3);
                        return true;
                    }
                    case 7: {
                        this.h(a2, n2, by2, n3);
                        return true;
                    }
                    case 6: {
                        this.g(a2, n2, by2, n3);
                        return true;
                    }
                    case 5: {
                        this.f(a2, n2, by2, n3);
                        return true;
                    }
                    case 4: {
                        this.e(a2, n2, by2, n3);
                        return true;
                    }
                    case 3: {
                        this.d(a2, n2, by2, n3);
                        return true;
                    }
                    case 2: {
                        this.c(a2, n2, by2, n3);
                        return true;
                    }
                    case 1: {
                        this.a(a2, n2, by2, n3);
                        return true;
                    }
                    case 0: 
                }
                this.b(a2, n2, by2, n3);
                return true;
            }
            Object[] arrobject = new Object[]{n2};
            throw i.d("FRAME_SIZE_ERROR: %s", arrobject);
        }

        public void close() throws IOException {
            this.b.close();
        }
    }

    static final class d
    implements b.a.a.c {
        private final c.d a;
        private final boolean b;
        private final c.c c;
        private final h.b d;
        private int e;
        private boolean f;

        d(c.d d2, boolean bl) {
            this.a = d2;
            this.b = bl;
            this.c = new c.c();
            this.d = new h.b(this.c);
            this.e = 16384;
        }

        private void b(int n2, long l2) throws IOException {
            while (l2 > 0L) {
                long l3;
                int n3;
                byte by = (l2 -= (l3 = (long)(n3 = (int)Math.min((long)this.e, (long)l2)))) == 0L ? (byte)4 : 0;
                this.a(n2, n3, (byte)9, by);
                this.a.a_(this.c, l3);
            }
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        public void a() throws IOException {
            d d2 = this;
            synchronized (d2) {
                block5 : {
                    if (this.f) throw new IOException("closed");
                    boolean bl = this.b;
                    if (bl) break block5;
                    return;
                }
                if (a.isLoggable(Level.FINE)) {
                    Logger logger = a;
                    Object[] arrobject = new Object[]{b.d()};
                    logger.fine(String.format((String)">> CONNECTION %s", (Object[])arrobject));
                }
                this.a.c(b.g());
                this.a.flush();
                return;
            }
        }

        void a(int n2, byte by, c.c c2, int n3) throws IOException {
            this.a(n2, n3, (byte)0, by);
            if (n3 > 0) {
                this.a.a_(c2, (long)n3);
            }
        }

        void a(int n2, int n3, byte by, byte by2) throws IOException {
            if (a.isLoggable(Level.FINE)) {
                a.fine(b.a(false, n2, n3, by, by2));
            }
            if (n3 <= this.e) {
                if ((Integer.MIN_VALUE & n2) == 0) {
                    i.b(this.a, n3);
                    this.a.h(by & 255);
                    this.a.h(by2 & 255);
                    this.a.f(n2 & Integer.MAX_VALUE);
                    return;
                }
                Object[] arrobject = new Object[]{n2};
                throw i.c("reserved bit set: %s", arrobject);
            }
            Object[] arrobject = new Object[]{this.e, n3};
            throw i.c("FRAME_SIZE_ERROR length > %d: %d", arrobject);
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void a(int n2, int n3, List<f> list) throws IOException {
            d d2 = this;
            synchronized (d2) {
                if (this.f) {
                    throw new IOException("closed");
                }
                this.d.a(list);
                long l2 = this.c.b();
                int n4 = (int)Math.min((long)(this.e - 4), (long)l2);
                long l3 = n4;
                byte by = l2 == l3 ? (byte)4 : 0;
                this.a(n2, n4 + 4, (byte)5, by);
                this.a.f(n3 & Integer.MAX_VALUE);
                this.a.a_(this.c, l3);
                if (l2 > l3) {
                    this.b(n2, l2 - l3);
                }
                return;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void a(int n2, long l2) throws IOException {
            d d2 = this;
            synchronized (d2) {
                if (this.f) {
                    throw new IOException("closed");
                }
                if (l2 != 0L && l2 <= Integer.MAX_VALUE) {
                    this.a(n2, 4, (byte)8, (byte)0);
                    this.a.f((int)l2);
                    this.a.flush();
                    return;
                }
                Object[] arrobject = new Object[]{l2};
                throw i.c("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", arrobject);
            }
        }

        @Override
        public void a(int n2, b.a.a.a a2) throws IOException {
            d d2 = this;
            synchronized (d2) {
                if (!this.f) {
                    if (a2.s != -1) {
                        this.a(n2, 4, (byte)3, (byte)0);
                        this.a.f(a2.s);
                        this.a.flush();
                        return;
                    }
                    throw new IllegalArgumentException();
                }
                throw new IOException("closed");
            }
        }

        @Override
        public void a(int n2, b.a.a.a a2, byte[] arrby) throws IOException {
            d d2 = this;
            synchronized (d2) {
                if (!this.f) {
                    if (a2.s != -1) {
                        this.a(0, 8 + arrby.length, (byte)7, (byte)0);
                        this.a.f(n2);
                        this.a.f(a2.s);
                        if (arrby.length > 0) {
                            this.a.c(arrby);
                        }
                        this.a.flush();
                        return;
                    }
                    throw i.c("errorCode.httpCode == -1", new Object[0]);
                }
                throw new IOException("closed");
            }
        }

        @Override
        public void a(n n2) throws IOException {
            d d2 = this;
            synchronized (d2) {
                if (!this.f) {
                    this.e = n2.e(this.e);
                    this.a(0, 0, (byte)4, (byte)1);
                    this.a.flush();
                    return;
                }
                throw new IOException("closed");
            }
        }

        @Override
        public void a(boolean bl, int n2, int n3) throws IOException {
            d d2 = this;
            synchronized (d2) {
                if (!this.f) {
                    this.a(0, 8, (byte)6, (byte)bl);
                    this.a.f(n2);
                    this.a.f(n3);
                    this.a.flush();
                    return;
                }
                throw new IOException("closed");
            }
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        public void a(boolean bl, int n2, c.c c2, int n3) throws IOException {
            d d2 = this;
            synchronized (d2) {
                byte by;
                block4 : {
                    if (this.f) throw new IOException("closed");
                    by = 0;
                    if (!bl) break block4;
                    by = (byte)(true ? 1 : 0);
                }
                this.a(n2, by, c2, n3);
                return;
            }
        }

        void a(boolean bl, int n2, List<f> list) throws IOException {
            if (!this.f) {
                this.d.a(list);
                long l2 = this.c.b();
                int n3 = (int)Math.min((long)this.e, (long)l2);
                long l3 = n3;
                byte by = l2 == l3 ? (byte)4 : 0;
                if (bl) {
                    by = (byte)(by | 1);
                }
                this.a(n2, n3, (byte)1, by);
                this.a.a_(this.c, l3);
                if (l2 > l3) {
                    this.b(n2, l2 - l3);
                }
                return;
            }
            throw new IOException("closed");
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        public void a(boolean bl, boolean bl2, int n2, int n3, List<f> list) throws IOException {
            d d2 = this;
            synchronized (d2) {
                if (bl2) throw new UnsupportedOperationException();
                if (this.f) throw new IOException("closed");
                this.a(bl, n2, list);
                return;
            }
        }

        @Override
        public void b() throws IOException {
            d d2 = this;
            synchronized (d2) {
                if (!this.f) {
                    this.a.flush();
                    return;
                }
                throw new IOException("closed");
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void b(n n2) throws IOException {
            d d2 = this;
            synchronized (d2) {
                if (this.f) {
                    throw new IOException("closed");
                }
                int n3 = 6 * n2.a();
                int n4 = 0;
                this.a(0, n3, (byte)4, (byte)0);
                do {
                    if (n4 >= 10) {
                        this.a.flush();
                        return;
                    }
                    if (n2.a(n4)) {
                        int n5 = n4 == 4 ? 3 : (n4 == 7 ? 4 : n4);
                        this.a.g(n5);
                        this.a.f(n2.b(n4));
                    }
                    ++n4;
                } while (true);
            }
        }

        @Override
        public int c() {
            return this.e;
        }

        public void close() throws IOException {
            d d2 = this;
            synchronized (d2) {
                this.f = true;
                this.a.close();
                return;
            }
        }
    }

}

