/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Date
 *  java.util.concurrent.TimeUnit
 */
package b.a.b;

import b.a.b.c;
import b.a.b.f;
import b.a.b.j;
import b.ab;
import b.d;
import b.q;
import b.r;
import b.s;
import b.z;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public final class b {
    public final z a;
    public final ab b;

    private b(z z2, ab ab2) {
        this.a = z2;
        this.b = ab2;
    }

    public static boolean a(ab ab2, z z2) {
        boolean bl;
        switch (ab2.b()) {
            default: {
                return false;
            }
            case 302: 
            case 307: {
                if (ab2.a("Expires") == null && ab2.i().c() == -1 && !ab2.i().e()) {
                    boolean bl2 = ab2.i().d();
                    bl = false;
                    if (!bl2) break;
                }
            }
            case 200: 
            case 203: 
            case 204: 
            case 300: 
            case 301: 
            case 308: 
            case 404: 
            case 405: 
            case 410: 
            case 414: 
            case 501: {
                boolean bl3 = ab2.i().b();
                bl = false;
                if (bl3) break;
                boolean bl4 = z2.f().b();
                bl = false;
                if (bl4) break;
                bl = true;
            }
        }
        return bl;
    }

    public static class a {
        final long a;
        final z b;
        final ab c;
        private Date d;
        private String e;
        private Date f;
        private String g;
        private Date h;
        private long i;
        private long j;
        private String k;
        private int l = -1;

        public a(long l2, z z2, ab ab2) {
            this.a = l2;
            this.b = z2;
            this.c = ab2;
            if (ab2 != null) {
                r r2 = ab2.e();
                int n2 = r2.a();
                for (int i2 = 0; i2 < n2; ++i2) {
                    String string = r2.a(i2);
                    String string2 = r2.b(i2);
                    if ("Date".equalsIgnoreCase(string)) {
                        this.d = f.a(string2);
                        this.e = string2;
                        continue;
                    }
                    if ("Expires".equalsIgnoreCase(string)) {
                        this.h = f.a(string2);
                        continue;
                    }
                    if ("Last-Modified".equalsIgnoreCase(string)) {
                        this.f = f.a(string2);
                        this.g = string2;
                        continue;
                    }
                    if ("ETag".equalsIgnoreCase(string)) {
                        this.k = string2;
                        continue;
                    }
                    if ("Age".equalsIgnoreCase(string)) {
                        this.l = c.b(string2, -1);
                        continue;
                    }
                    if (j.b.equalsIgnoreCase(string)) {
                        this.i = Long.parseLong((String)string2);
                        continue;
                    }
                    if (!j.c.equalsIgnoreCase(string)) continue;
                    this.j = Long.parseLong((String)string2);
                }
            }
        }

        private static boolean a(z z2) {
            return z2.a("If-Modified-Since") != null || z2.a("If-None-Match") != null;
            {
            }
        }

        /*
         * Enabled aggressive block sorting
         */
        private b b() {
            z.a a2;
            block14 : {
                String string;
                String string2;
                block12 : {
                    block13 : {
                        block11 : {
                            long l2;
                            if (this.c == null) {
                                return new b(this.b, null);
                            }
                            if (this.b.g() && this.c.d() == null) {
                                return new b(this.b, null);
                            }
                            if (!b.a(this.c, this.b)) {
                                return new b(this.b, null);
                            }
                            d d2 = this.b.f();
                            if (d2.a()) return new b(this.b, null);
                            if (a.a(this.b)) {
                                return new b(this.b, null);
                            }
                            long l3 = this.d();
                            long l4 = this.c();
                            if (d2.c() != -1) {
                                l4 = Math.min((long)l4, (long)TimeUnit.SECONDS.toMillis((long)d2.c()));
                            }
                            int n2 = d2.h();
                            long l5 = 0L;
                            long l6 = n2 != -1 ? TimeUnit.SECONDS.toMillis((long)d2.h()) : l5;
                            d d3 = this.c.i();
                            if (!d3.f() && d2.g() != -1) {
                                l5 = TimeUnit.SECONDS.toMillis((long)d2.g());
                            }
                            if (!d3.a() && (l2 = l6 + l3) < l5 + l4) {
                                ab.a a3 = this.c.g();
                                if (l2 >= l4) {
                                    a3.b("Warning", "110 HttpURLConnection \"Response is stale\"");
                                }
                                if (l3 <= 86400000L) return new b(null, a3.a());
                                if (!this.e()) return new b(null, a3.a());
                                a3.b("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                                return new b(null, a3.a());
                            }
                            a2 = this.b.e();
                            if (this.k == null) break block11;
                            string2 = "If-None-Match";
                            string = this.k;
                            break block12;
                        }
                        if (this.f == null) break block13;
                        string2 = "If-Modified-Since";
                        string = this.g;
                        break block12;
                    }
                    if (this.d == null) break block14;
                    string2 = "If-Modified-Since";
                    string = this.e;
                }
                a2.a(string2, string);
            }
            z z2 = a2.a();
            if (!a.a(z2)) return new b(z2, null);
            return new b(z2, this.c);
        }

        private long c() {
            long l2;
            long l3;
            d d2 = this.c.i();
            if (d2.c() != -1) {
                return TimeUnit.SECONDS.toMillis((long)d2.c());
            }
            Date date = this.h;
            long l4 = 0L;
            if (date != null) {
                long l5 = this.d != null ? this.d.getTime() : this.j;
                long l6 = this.h.getTime() - l5;
                if (l6 > l4) {
                    l4 = l6;
                }
                return l4;
            }
            if (this.f != null && this.c.a().a().l() == null && (l3 = (l2 = this.d != null ? this.d.getTime() : this.i) - this.f.getTime()) > l4) {
                l4 = l3 / 10L;
            }
            return l4;
        }

        private long d() {
            Date date = this.d;
            long l2 = 0L;
            if (date != null) {
                l2 = Math.max((long)l2, (long)(this.j - this.d.getTime()));
            }
            if (this.l != -1) {
                l2 = Math.max((long)l2, (long)TimeUnit.SECONDS.toMillis((long)this.l));
            }
            long l3 = this.j - this.i;
            return this.a - this.j + (l2 + l3);
        }

        private boolean e() {
            return this.c.i().c() == -1 && this.h == null;
        }

        public b a() {
            b b2 = this.b();
            if (b2.a != null && this.b.f().i()) {
                b2 = new b(null, null);
            }
            return b2;
        }
    }

}

