/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.c
 *  c.e
 *  java.io.IOException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.Map
 */
package b.a.a;

import b.a.a.f;
import b.a.a.j;
import c.c;
import c.e;
import c.l;
import c.r;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

final class h {
    private static final f[] a;
    private static final Map<c.f, Integer> b;

    static {
        f[] arrf = new f[]{new f(f.e, ""), new f(f.b, "GET"), new f(f.b, "POST"), new f(f.c, "/"), new f(f.c, "/index.html"), new f(f.d, "http"), new f(f.d, "https"), new f(f.a, "200"), new f(f.a, "204"), new f(f.a, "206"), new f(f.a, "304"), new f(f.a, "400"), new f(f.a, "404"), new f(f.a, "500"), new f("accept-charset", ""), new f("accept-encoding", "gzip, deflate"), new f("accept-language", ""), new f("accept-ranges", ""), new f("accept", ""), new f("access-control-allow-origin", ""), new f("age", ""), new f("allow", ""), new f("authorization", ""), new f("cache-control", ""), new f("content-disposition", ""), new f("content-encoding", ""), new f("content-language", ""), new f("content-length", ""), new f("content-location", ""), new f("content-range", ""), new f("content-type", ""), new f("cookie", ""), new f("date", ""), new f("etag", ""), new f("expect", ""), new f("expires", ""), new f("from", ""), new f("host", ""), new f("if-match", ""), new f("if-modified-since", ""), new f("if-none-match", ""), new f("if-range", ""), new f("if-unmodified-since", ""), new f("last-modified", ""), new f("link", ""), new f("location", ""), new f("max-forwards", ""), new f("proxy-authenticate", ""), new f("proxy-authorization", ""), new f("range", ""), new f("referer", ""), new f("refresh", ""), new f("retry-after", ""), new f("server", ""), new f("set-cookie", ""), new f("strict-transport-security", ""), new f("transfer-encoding", ""), new f("user-agent", ""), new f("vary", ""), new f("via", ""), new f("www-authenticate", "")};
        a = arrf;
        b = h.c();
    }

    private static c.f b(c.f f2) throws IOException {
        int n2 = f2.f();
        for (int i2 = 0; i2 < n2; ++i2) {
            byte by = f2.a(i2);
            if (by < 65 || by > 90) continue;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("PROTOCOL_ERROR response malformed: mixed case name: ");
            stringBuilder.append(f2.a());
            throw new IOException(stringBuilder.toString());
        }
        return f2;
    }

    private static Map<c.f, Integer> c() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(a.length);
        for (int i2 = 0; i2 < a.length; ++i2) {
            if (linkedHashMap.containsKey((Object)h.a[i2].h)) continue;
            linkedHashMap.put((Object)h.a[i2].h, (Object)i2);
        }
        return Collections.unmodifiableMap((Map)linkedHashMap);
    }

    static final class a {
        f[] a = new f[8];
        int b = -1 + this.a.length;
        int c = 0;
        int d = 0;
        private final List<f> e = new ArrayList();
        private final e f;
        private int g;
        private int h;

        a(int n2, r r2) {
            this.g = n2;
            this.h = n2;
            this.f = l.a(r2);
        }

        private void a(int n2, f f2) {
            this.e.add((Object)f2);
            int n3 = f2.j;
            if (n2 != -1) {
                n3 -= this.a[this.d((int)n2)].j;
            }
            if (n3 > this.h) {
                this.e();
                return;
            }
            int n4 = this.b(n3 + this.d - this.h);
            if (n2 == -1) {
                if (1 + this.c > this.a.length) {
                    f[] arrf = new f[2 * this.a.length];
                    System.arraycopy((Object)this.a, (int)0, (Object)arrf, (int)this.a.length, (int)this.a.length);
                    this.b = -1 + this.a.length;
                    this.a = arrf;
                }
                int n5 = this.b;
                this.b = n5 - 1;
                this.a[n5] = f2;
                this.c = 1 + this.c;
            } else {
                int n6 = n2 + (n4 + this.d(n2));
                this.a[n6] = f2;
            }
            this.d = n3 + this.d;
        }

        private int b(int n2) {
            int n3 = 0;
            if (n2 > 0) {
                for (int i2 = -1 + this.a.length; i2 >= this.b && n2 > 0; --i2) {
                    n2 -= this.a[i2].j;
                    this.d -= this.a[i2].j;
                    this.c = -1 + this.c;
                    ++n3;
                }
                System.arraycopy((Object)this.a, (int)(1 + this.b), (Object)this.a, (int)(n3 + (1 + this.b)), (int)this.c);
                this.b = n3 + this.b;
            }
            return n3;
        }

        private void c(int n2) throws IOException {
            if (this.h(n2)) {
                f f2 = a[n2];
                this.e.add((Object)f2);
                return;
            }
            int n3 = this.d(n2 - a.length);
            if (n3 >= 0 && n3 <= -1 + this.a.length) {
                this.e.add((Object)this.a[n3]);
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Header index too large ");
            stringBuilder.append(n2 + 1);
            throw new IOException(stringBuilder.toString());
        }

        private int d(int n2) {
            return n2 + (1 + this.b);
        }

        private void d() {
            if (this.h < this.d) {
                if (this.h == 0) {
                    this.e();
                    return;
                }
                this.b(this.d - this.h);
            }
        }

        private void e() {
            this.e.clear();
            Arrays.fill((Object[])this.a, null);
            this.b = -1 + this.a.length;
            this.c = 0;
            this.d = 0;
        }

        private void e(int n2) throws IOException {
            c.f f2 = this.g(n2);
            c.f f3 = this.c();
            this.e.add((Object)new f(f2, f3));
        }

        private void f() throws IOException {
            c.f f2 = h.b(this.c());
            c.f f3 = this.c();
            this.e.add((Object)new f(f2, f3));
        }

        private void f(int n2) throws IOException {
            this.a(-1, new f(this.g(n2), this.c()));
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        private c.f g(int n2) {
            f f2;
            if (this.h(n2)) {
                f2 = a[n2];
                do {
                    return f2.h;
                    break;
                } while (true);
            }
            f2 = this.a[this.d(n2 - a.length)];
            return f2.h;
        }

        private void g() throws IOException {
            this.a(-1, new f(h.b(this.c()), this.c()));
        }

        private int h() throws IOException {
            return 255 & this.f.j();
        }

        private boolean h(int n2) {
            return n2 >= 0 && n2 <= a.length - 1;
        }

        int a(int n2, int n3) throws IOException {
            int n4;
            int n5 = n2 & n3;
            if (n5 < n3) {
                return n5;
            }
            int n6 = 0;
            while (((n4 = this.h()) & 128) != 0) {
                n3 += (n4 & 127) << n6;
                n6 += 7;
            }
            return n3 + (n4 << n6);
        }

        void a() throws IOException {
            while (!this.f.g()) {
                int n2 = 255 & this.f.j();
                if (n2 != 128) {
                    if ((n2 & 128) == 128) {
                        this.c(-1 + this.a(n2, 127));
                        continue;
                    }
                    if (n2 == 64) {
                        this.g();
                        continue;
                    }
                    if ((n2 & 64) == 64) {
                        this.f(-1 + this.a(n2, 63));
                        continue;
                    }
                    if ((n2 & 32) == 32) {
                        this.h = this.a(n2, 31);
                        if (this.h >= 0 && this.h <= this.g) {
                            this.d();
                            continue;
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Invalid dynamic table size update ");
                        stringBuilder.append(this.h);
                        throw new IOException(stringBuilder.toString());
                    }
                    if (n2 != 16 && n2 != 0) {
                        this.e(-1 + this.a(n2, 15));
                        continue;
                    }
                    this.f();
                    continue;
                }
                throw new IOException("index == 0");
            }
        }

        void a(int n2) {
            this.g = n2;
            this.h = n2;
            this.d();
        }

        public List<f> b() {
            ArrayList arrayList = new ArrayList(this.e);
            this.e.clear();
            return arrayList;
        }

        c.f c() throws IOException {
            int n2 = this.h();
            boolean bl = (n2 & 128) == 128;
            int n3 = this.a(n2, 127);
            if (bl) {
                return c.f.a(j.a().a(this.f.f((long)n3)));
            }
            return this.f.c((long)n3);
        }
    }

    static final class b {
        private final c a;

        b(c c2) {
            this.a = c2;
        }

        /*
         * Enabled aggressive block sorting
         */
        void a(int n2, int n3, int n4) throws IOException {
            int n5;
            c c2;
            if (n2 < n3) {
                c2 = this.a;
                n5 = n2 | n4;
            } else {
                this.a.b(n4 | n3);
                for (n5 = n2 - n3; n5 >= 128; n5 >>>= 7) {
                    int n6 = n5 & 127;
                    this.a.b(128 | n6);
                }
                c2 = this.a;
            }
            c2.b(n5);
        }

        void a(c.f f2) throws IOException {
            this.a(f2.f(), 127, 0);
            this.a.a(f2);
        }

        /*
         * Enabled aggressive block sorting
         */
        void a(List<f> list) throws IOException {
            int n2 = list.size();
            int n3 = 0;
            while (n3 < n2) {
                c.f f2 = ((f)list.get((int)n3)).h.e();
                Integer n4 = (Integer)b.get((Object)f2);
                if (n4 != null) {
                    this.a(1 + n4, 15, 0);
                } else {
                    this.a.b(0);
                    this.a(f2);
                }
                this.a(((f)list.get((int)n3)).i);
                ++n3;
            }
            return;
        }
    }

}

