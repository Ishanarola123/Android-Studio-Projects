/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.concurrent.TimeUnit
 */
package b;

import b.a.b.c;
import b.r;
import java.util.concurrent.TimeUnit;

public final class d {
    public static final d a = new a().a().c();
    public static final d b = new a().b().a(Integer.MAX_VALUE, TimeUnit.SECONDS).c();
    String c;
    private final boolean d;
    private final boolean e;
    private final int f;
    private final int g;
    private final boolean h;
    private final boolean i;
    private final boolean j;
    private final int k;
    private final int l;
    private final boolean m;
    private final boolean n;

    private d(a a2) {
        this.d = a2.a;
        this.e = a2.b;
        this.f = a2.c;
        this.g = -1;
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = a2.d;
        this.l = a2.e;
        this.m = a2.f;
        this.n = a2.g;
    }

    private d(boolean bl, boolean bl2, int n2, int n3, boolean bl3, boolean bl4, boolean bl5, int n4, int n5, boolean bl6, boolean bl7, String string) {
        this.d = bl;
        this.e = bl2;
        this.f = n2;
        this.g = n3;
        this.h = bl3;
        this.i = bl4;
        this.j = bl5;
        this.k = n4;
        this.l = n5;
        this.m = bl6;
        this.n = bl7;
        this.c = string;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static d a(r r2) {
        int n2 = r2.a();
        int n3 = 0;
        boolean bl = true;
        String string = null;
        boolean bl2 = false;
        boolean bl3 = false;
        int n4 = -1;
        int n5 = -1;
        boolean bl4 = false;
        boolean bl5 = false;
        boolean bl6 = false;
        int n6 = -1;
        int n7 = -1;
        boolean bl7 = false;
        boolean bl8 = false;
        do {
            block31 : {
                int n8;
                String string2;
                block32 : {
                    block27 : {
                        block30 : {
                            block29 : {
                                String string3;
                                block28 : {
                                    if (n3 >= n2) break block27;
                                    string3 = r2.a(n3);
                                    string2 = r2.b(n3);
                                    if (!string3.equalsIgnoreCase("Cache-Control")) break block28;
                                    if (string != null) break block29;
                                    string = string2;
                                    break block30;
                                }
                                if (!string3.equalsIgnoreCase("Pragma")) break block31;
                            }
                            bl = false;
                        }
                        n8 = 0;
                        break block32;
                    }
                    String string4 = !bl ? null : string;
                    return new d(bl2, bl3, n4, n5, bl4, bl5, bl6, n6, n7, bl7, bl8, string4);
                }
                while (n8 < string2.length()) {
                    String string5;
                    int n9;
                    int n10 = c.a(string2, n8, "=,;");
                    String string6 = string2.substring(n8, n10).trim();
                    if (n10 != string2.length() && string2.charAt(n10) != ',' && string2.charAt(n10) != ';') {
                        int n11 = c.a(string2, n10 + 1);
                        if (n11 < string2.length() && string2.charAt(n11) == '\"') {
                            int n12 = n11 + 1;
                            int n13 = c.a(string2, n12, "\"");
                            string5 = string2.substring(n12, n13);
                            n9 = n13 + 1;
                        } else {
                            n9 = c.a(string2, n11, ",;");
                            string5 = string2.substring(n11, n9).trim();
                        }
                    } else {
                        n9 = n10 + 1;
                        string5 = null;
                    }
                    if ("no-cache".equalsIgnoreCase(string6)) {
                        bl2 = true;
                    } else if ("no-store".equalsIgnoreCase(string6)) {
                        bl3 = true;
                    } else if ("max-age".equalsIgnoreCase(string6)) {
                        n4 = c.b(string5, -1);
                    } else if ("s-maxage".equalsIgnoreCase(string6)) {
                        n5 = c.b(string5, -1);
                    } else if ("private".equalsIgnoreCase(string6)) {
                        bl4 = true;
                    } else if ("public".equalsIgnoreCase(string6)) {
                        bl5 = true;
                    } else if ("must-revalidate".equalsIgnoreCase(string6)) {
                        bl6 = true;
                    } else if ("max-stale".equalsIgnoreCase(string6)) {
                        n6 = c.b(string5, Integer.MAX_VALUE);
                    } else if ("min-fresh".equalsIgnoreCase(string6)) {
                        n7 = c.b(string5, -1);
                    } else if ("only-if-cached".equalsIgnoreCase(string6)) {
                        bl7 = true;
                    } else if ("no-transform".equalsIgnoreCase(string6)) {
                        bl8 = true;
                    }
                    n8 = n9;
                }
            }
            ++n3;
        } while (true);
    }

    private String j() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.d) {
            stringBuilder.append("no-cache, ");
        }
        if (this.e) {
            stringBuilder.append("no-store, ");
        }
        if (this.f != -1) {
            stringBuilder.append("max-age=");
            stringBuilder.append(this.f);
            stringBuilder.append(", ");
        }
        if (this.g != -1) {
            stringBuilder.append("s-maxage=");
            stringBuilder.append(this.g);
            stringBuilder.append(", ");
        }
        if (this.h) {
            stringBuilder.append("private, ");
        }
        if (this.i) {
            stringBuilder.append("public, ");
        }
        if (this.j) {
            stringBuilder.append("must-revalidate, ");
        }
        if (this.k != -1) {
            stringBuilder.append("max-stale=");
            stringBuilder.append(this.k);
            stringBuilder.append(", ");
        }
        if (this.l != -1) {
            stringBuilder.append("min-fresh=");
            stringBuilder.append(this.l);
            stringBuilder.append(", ");
        }
        if (this.m) {
            stringBuilder.append("only-if-cached, ");
        }
        if (this.n) {
            stringBuilder.append("no-transform, ");
        }
        if (stringBuilder.length() == 0) {
            return "";
        }
        stringBuilder.delete(-2 + stringBuilder.length(), stringBuilder.length());
        return stringBuilder.toString();
    }

    public boolean a() {
        return this.d;
    }

    public boolean b() {
        return this.e;
    }

    public int c() {
        return this.f;
    }

    public boolean d() {
        return this.h;
    }

    public boolean e() {
        return this.i;
    }

    public boolean f() {
        return this.j;
    }

    public int g() {
        return this.k;
    }

    public int h() {
        return this.l;
    }

    public boolean i() {
        return this.m;
    }

    public String toString() {
        String string;
        String string2 = this.c;
        if (string2 != null) {
            return string2;
        }
        this.c = string = this.j();
        return string;
    }

    public static final class a {
        boolean a;
        boolean b;
        int c = -1;
        int d = -1;
        int e = -1;
        boolean f;
        boolean g;

        public a a() {
            this.a = true;
            return this;
        }

        public a a(int n2, TimeUnit timeUnit) {
            if (n2 >= 0) {
                long l2 = timeUnit.toSeconds((long)n2);
                int n3 = l2 > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)l2;
                this.d = n3;
                return this;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("maxStale < 0: ");
            stringBuilder.append(n2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }

        public a b() {
            this.f = true;
            return this;
        }

        public d c() {
            return new d(this);
        }
    }

}

