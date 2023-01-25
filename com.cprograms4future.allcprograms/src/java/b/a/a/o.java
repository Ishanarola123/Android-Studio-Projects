/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.c
 *  java.io.IOException
 *  java.io.UnsupportedEncodingException
 *  java.lang.AssertionError
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.net.ProtocolException
 *  java.nio.charset.Charset
 *  java.util.List
 *  java.util.zip.Deflater
 */
package b.a.a;

import b.a.a.b;
import b.a.a.c;
import b.a.a.f;
import b.a.a.g;
import b.a.a.k;
import b.a.a.n;
import b.a.a.p;
import b.a.i;
import c.d;
import c.e;
import c.l;
import c.q;
import c.r;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.zip.Deflater;

public final class o
implements p {
    static final byte[] a;

    static {
        try {
            a = "\u0000\u0000\u0000\u0007options\u0000\u0000\u0000\u0004head\u0000\u0000\u0000\u0004post\u0000\u0000\u0000\u0003put\u0000\u0000\u0000\u0006delete\u0000\u0000\u0000\u0005trace\u0000\u0000\u0000\u0006accept\u0000\u0000\u0000\u000eaccept-charset\u0000\u0000\u0000\u000faccept-encoding\u0000\u0000\u0000\u000faccept-language\u0000\u0000\u0000\raccept-ranges\u0000\u0000\u0000\u0003age\u0000\u0000\u0000\u0005allow\u0000\u0000\u0000\rauthorization\u0000\u0000\u0000\rcache-control\u0000\u0000\u0000\nconnection\u0000\u0000\u0000\fcontent-base\u0000\u0000\u0000\u0010content-encoding\u0000\u0000\u0000\u0010content-language\u0000\u0000\u0000\u000econtent-length\u0000\u0000\u0000\u0010content-location\u0000\u0000\u0000\u000bcontent-md5\u0000\u0000\u0000\rcontent-range\u0000\u0000\u0000\fcontent-type\u0000\u0000\u0000\u0004date\u0000\u0000\u0000\u0004etag\u0000\u0000\u0000\u0006expect\u0000\u0000\u0000\u0007expires\u0000\u0000\u0000\u0004from\u0000\u0000\u0000\u0004host\u0000\u0000\u0000\bif-match\u0000\u0000\u0000\u0011if-modified-since\u0000\u0000\u0000\rif-none-match\u0000\u0000\u0000\bif-range\u0000\u0000\u0000\u0013if-unmodified-since\u0000\u0000\u0000\rlast-modified\u0000\u0000\u0000\blocation\u0000\u0000\u0000\fmax-forwards\u0000\u0000\u0000\u0006pragma\u0000\u0000\u0000\u0012proxy-authenticate\u0000\u0000\u0000\u0013proxy-authorization\u0000\u0000\u0000\u0005range\u0000\u0000\u0000\u0007referer\u0000\u0000\u0000\u000bretry-after\u0000\u0000\u0000\u0006server\u0000\u0000\u0000\u0002te\u0000\u0000\u0000\u0007trailer\u0000\u0000\u0000\u0011transfer-encoding\u0000\u0000\u0000\u0007upgrade\u0000\u0000\u0000\nuser-agent\u0000\u0000\u0000\u0004vary\u0000\u0000\u0000\u0003via\u0000\u0000\u0000\u0007warning\u0000\u0000\u0000\u0010www-authenticate\u0000\u0000\u0000\u0006method\u0000\u0000\u0000\u0003get\u0000\u0000\u0000\u0006status\u0000\u0000\u0000\u0006200 OK\u0000\u0000\u0000\u0007version\u0000\u0000\u0000\bHTTP/1.1\u0000\u0000\u0000\u0003url\u0000\u0000\u0000\u0006public\u0000\u0000\u0000\nset-cookie\u0000\u0000\u0000\nkeep-alive\u0000\u0000\u0000\u0006origin100101201202205206300302303304305306307402405406407408409410411412413414415416417502504505203 Non-Authoritative Information204 No Content301 Moved Permanently400 Bad Request401 Unauthorized403 Forbidden404 Not Found500 Internal Server Error501 Not Implemented503 Service UnavailableJan Feb Mar Apr May Jun Jul Aug Sept Oct Nov Dec 00:00:00 Mon, Tue, Wed, Thu, Fri, Sat, Sun, GMTchunked,text/html,image/png,image/jpg,image/gif,application/xml,application/xhtml+xml,text/plain,text/javascript,publicprivatemax-age=gzip,deflate,sdchcharset=utf-8charset=iso-8859-1,utf-,*,enq=0.".getBytes(i.c.name());
            return;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new AssertionError();
        }
    }

    @Override
    public b.a.a.b a(e e2, boolean bl) {
        return new a(e2, bl);
    }

    @Override
    public c a(d d2, boolean bl) {
        return new b(d2, bl);
    }

    static final class a
    implements b.a.a.b {
        private final e a;
        private final boolean b;
        private final k c;

        a(e e2, boolean bl) {
            this.a = e2;
            this.c = new k(this.a);
            this.b = bl;
        }

        private static /* varargs */ IOException a(String string, Object ... arrobject) throws IOException {
            throw new IOException(String.format((String)string, (Object[])arrobject));
        }

        private void a(b.a a2, int n2, int n3) throws IOException {
            int n4 = this.a.l();
            int n5 = this.a.l();
            int n6 = n4 & Integer.MAX_VALUE;
            int n7 = n5 & Integer.MAX_VALUE;
            this.a.k();
            List<f> list = this.c.a(n3 - 10);
            boolean bl = (n2 & 1) != 0;
            boolean bl2 = (n2 & 2) != 0;
            a2.a(bl2, bl, n6, n7, list, g.a);
        }

        private void b(b.a a2, int n2, int n3) throws IOException {
            int n4 = Integer.MAX_VALUE & this.a.l();
            List<f> list = this.c.a(n3 - 4);
            boolean bl = (n2 & 1) != 0;
            a2.a(false, bl, n4, -1, list, g.b);
        }

        private void c(b.a a2, int n2, int n3) throws IOException {
            if (n3 == 8) {
                int n4 = Integer.MAX_VALUE & this.a.l();
                int n5 = this.a.l();
                b.a.a.a a3 = b.a.a.a.a(n5);
                if (a3 != null) {
                    a2.a(n4, a3);
                    return;
                }
                Object[] arrobject = new Object[]{n5};
                throw a.a("TYPE_RST_STREAM unexpected error code: %d", arrobject);
            }
            Object[] arrobject = new Object[]{n3};
            throw a.a("TYPE_RST_STREAM length: %d != 8", arrobject);
        }

        private void d(b.a a2, int n2, int n3) throws IOException {
            a2.a(false, false, Integer.MAX_VALUE & this.a.l(), -1, this.c.a(n3 - 4), g.c);
        }

        private void e(b.a a2, int n2, int n3) throws IOException {
            if (n3 == 8) {
                int n4 = this.a.l();
                int n5 = this.a.l();
                int n6 = n4 & Integer.MAX_VALUE;
                long l2 = n5 & Integer.MAX_VALUE;
                if (l2 != 0L) {
                    a2.a(n6, l2);
                    return;
                }
                Object[] arrobject = new Object[]{l2};
                throw a.a("windowSizeIncrement was 0", arrobject);
            }
            Object[] arrobject = new Object[]{n3};
            throw a.a("TYPE_WINDOW_UPDATE length: %d != 8", arrobject);
        }

        private void f(b.a a2, int n2, int n3) throws IOException {
            int n4 = 1;
            if (n3 == 4) {
                boolean bl = this.b;
                int n5 = this.a.l();
                boolean bl2 = (n5 & 1) == n4;
                if (bl != bl2) {
                    n4 = 0;
                }
                a2.a((boolean)n4, n5, 0);
                return;
            }
            Object[] arrobject = new Object[n4];
            arrobject[0] = n3;
            throw a.a("TYPE_PING length: %d != 4", arrobject);
        }

        private void g(b.a a2, int n2, int n3) throws IOException {
            if (n3 == 8) {
                int n4 = Integer.MAX_VALUE & this.a.l();
                int n5 = this.a.l();
                b.a.a.a a3 = b.a.a.a.c(n5);
                if (a3 != null) {
                    a2.a(n4, a3, c.f.b);
                    return;
                }
                Object[] arrobject = new Object[]{n5};
                throw a.a("TYPE_GOAWAY unexpected error code: %d", arrobject);
            }
            Object[] arrobject = new Object[]{n3};
            throw a.a("TYPE_GOAWAY length: %d != 8", arrobject);
        }

        private void h(b.a a2, int n2, int n3) throws IOException {
            int n4 = this.a.l();
            if (n3 == 4 + n4 * 8) {
                n n5 = new n();
                for (int i2 = 0; i2 < n4; ++i2) {
                    int n6 = this.a.l();
                    int n7 = this.a.l();
                    int n8 = (-16777216 & n6) >>> 24;
                    n5.a(n6 & 16777215, n8, n7);
                }
                int n9 = n2 & 1;
                boolean bl = false;
                if (n9 != 0) {
                    bl = true;
                }
                a2.a(bl, n5);
                return;
            }
            Object[] arrobject = new Object[]{n3, n4};
            throw a.a("TYPE_SETTINGS length: %d != 4 + 8 * %d", arrobject);
        }

        @Override
        public void a() {
        }

        @Override
        public boolean a(b.a a2) throws IOException {
            int n2;
            int n3;
            try {
                n3 = this.a.l();
                n2 = this.a.l();
            }
            catch (IOException iOException) {
                return false;
            }
            boolean bl = (Integer.MIN_VALUE & n3) != 0;
            int n4 = (-16777216 & n2) >>> 24;
            int n5 = n2 & 16777215;
            if (bl) {
                int n6 = (2147418112 & n3) >>> 16;
                int n7 = n3 & 65535;
                if (n6 == 3) {
                    switch (n7) {
                        default: {
                            this.a.g(n5);
                            return true;
                        }
                        case 9: {
                            this.e(a2, n4, n5);
                            return true;
                        }
                        case 8: {
                            this.d(a2, n4, n5);
                            return true;
                        }
                        case 7: {
                            this.g(a2, n4, n5);
                            return true;
                        }
                        case 6: {
                            this.f(a2, n4, n5);
                            return true;
                        }
                        case 4: {
                            this.h(a2, n4, n5);
                            return true;
                        }
                        case 3: {
                            this.c(a2, n4, n5);
                            return true;
                        }
                        case 2: {
                            this.b(a2, n4, n5);
                            return true;
                        }
                        case 1: 
                    }
                    this.a(a2, n4, n5);
                    return true;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("version != 3: ");
                stringBuilder.append(n6);
                throw new ProtocolException(stringBuilder.toString());
            }
            int n8 = n3 & Integer.MAX_VALUE;
            int n9 = n4 & 1;
            boolean bl2 = false;
            if (n9 != 0) {
                bl2 = true;
            }
            a2.a(bl2, n8, this.a, n5);
            return true;
        }

        public void close() throws IOException {
            this.c.a();
        }
    }

    static final class b
    implements c {
        private final d a;
        private final c.c b;
        private final d c;
        private final boolean d;
        private boolean e;

        b(d d2, boolean bl) {
            this.a = d2;
            this.d = bl;
            Deflater deflater = new Deflater();
            deflater.setDictionary(o.a);
            this.b = new c.c();
            this.c = l.a(new c.g((q)this.b, deflater));
        }

        private void a(List<f> list) throws IOException {
            this.c.f(list.size());
            int n2 = list.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                c.f f2 = ((f)list.get((int)i2)).h;
                this.c.f(f2.f());
                this.c.b(f2);
                c.f f3 = ((f)list.get((int)i2)).i;
                this.c.f(f3.f());
                this.c.b(f3);
            }
            this.c.flush();
        }

        /*
         * Enabled aggressive block sorting
         * Converted monitor instructions to comments
         * Lifted jumps to return sites
         */
        @Override
        public void a() {
            b b2 = this;
            // MONITORENTER : b2
            // MONITOREXIT : b2
        }

        void a(int n2, int n3, c.c c2, int n4) throws IOException {
            if (!this.e) {
                long l2 = n4;
                if (l2 <= 0xFFFFFFL) {
                    this.a.f(n2 & Integer.MAX_VALUE);
                    this.a.f((n3 & 255) << 24 | 16777215 & n4);
                    if (n4 > 0) {
                        this.a.a_(c2, l2);
                    }
                    return;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("FRAME_TOO_LARGE max size is 16Mib: ");
                stringBuilder.append(n4);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            throw new IOException("closed");
        }

        @Override
        public void a(int n2, int n3, List<f> list) throws IOException {
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void a(int n2, long l2) throws IOException {
            b b2 = this;
            synchronized (b2) {
                if (this.e) {
                    throw new IOException("closed");
                }
                if (l2 != 0L && l2 <= Integer.MAX_VALUE) {
                    this.a.f(-2147287031);
                    this.a.f(8);
                    this.a.f(n2);
                    this.a.f((int)l2);
                    this.a.flush();
                    return;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("windowSizeIncrement must be between 1 and 0x7fffffff: ");
                stringBuilder.append(l2);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }

        @Override
        public void a(int n2, b.a.a.a a2) throws IOException {
            b b2 = this;
            synchronized (b2) {
                if (!this.e) {
                    if (a2.t != -1) {
                        this.a.f(-2147287037);
                        this.a.f(8);
                        this.a.f(n2 & Integer.MAX_VALUE);
                        this.a.f(a2.t);
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
            b b2 = this;
            synchronized (b2) {
                if (!this.e) {
                    if (a2.u != -1) {
                        this.a.f(-2147287033);
                        this.a.f(8);
                        this.a.f(n2);
                        this.a.f(a2.u);
                        this.a.flush();
                        return;
                    }
                    throw new IllegalArgumentException("errorCode.spdyGoAwayCode == -1");
                }
                throw new IOException("closed");
            }
        }

        @Override
        public void a(n n2) {
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void a(boolean bl, int n2, int n3) throws IOException {
            b b2 = this;
            synchronized (b2) {
                if (this.e) {
                    throw new IOException("closed");
                }
                boolean bl2 = this.d;
                boolean bl3 = (n2 & 1) == 1;
                boolean bl4 = false;
                if (bl2 != bl3) {
                    bl4 = true;
                }
                if (bl == bl4) {
                    this.a.f(-2147287034);
                    this.a.f(4);
                    this.a.f(n2);
                    this.a.flush();
                    return;
                }
                throw new IllegalArgumentException("payload != reply");
            }
        }

        @Override
        public void a(boolean bl, int n2, c.c c2, int n3) throws IOException {
            b b2 = this;
            synchronized (b2) {
                this.a(n2, (int)bl, c2, n3);
                return;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void a(boolean bl, boolean bl2, int n2, int n3, List<f> list) throws IOException {
            b b2 = this;
            synchronized (b2) {
                if (this.e) {
                    throw new IOException("closed");
                }
                this.a(list);
                int n4 = (int)(10L + this.b.b());
                int n5 = bl2 ? 2 : 0;
                int n6 = bl | n5;
                this.a.f(-2147287039);
                this.a.f((n6 & 255) << 24 | n4 & 16777215);
                this.a.f(n2 & Integer.MAX_VALUE);
                this.a.f(Integer.MAX_VALUE & n3);
                this.a.g(0);
                this.a.a((r)this.b);
                this.a.flush();
                return;
            }
        }

        @Override
        public void b() throws IOException {
            b b2 = this;
            synchronized (b2) {
                if (!this.e) {
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
            b b2 = this;
            synchronized (b2) {
                if (this.e) {
                    throw new IOException("closed");
                }
                int n3 = n2.a();
                int n4 = 4 + n3 * 8;
                this.a.f(-2147287036);
                d d2 = this.a;
                int n5 = n4 & 16777215;
                int n6 = 0;
                d2.f(n5 | 0);
                this.a.f(n3);
                do {
                    if (n6 > 10) {
                        this.a.flush();
                        return;
                    }
                    if (n2.a(n6)) {
                        int n7 = n2.c(n6);
                        this.a.f((n7 & 255) << 24 | n6 & 16777215);
                        this.a.f(n2.b(n6));
                    }
                    ++n6;
                } while (true);
            }
        }

        @Override
        public int c() {
            return 16383;
        }

        public void close() throws IOException {
            b b2 = this;
            synchronized (b2) {
                this.e = true;
                i.a(this.a, this.c);
                return;
            }
        }
    }

}

