/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.c
 *  d.k$a
 *  java.lang.AssertionError
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.IllegalArgumentException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package d;

import b.aa;
import b.p;
import b.r;
import b.s;
import b.u;
import b.v;
import b.z;
import c.c;
import d.k;

/*
 * Exception performing whole class analysis.
 */
final class k {
    private static final char[] a;
    private final String b;
    private final s c;
    private String d;
    private s.a e;
    private final z.a f;
    private u g;
    private final boolean h;
    private v.a i;
    private p.a j;
    private aa k;

    static {
        a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    k(String string, s s2, String string2, r r2, u u2, boolean bl, boolean bl2, boolean bl3) {
        this.b = string;
        this.c = s2;
        this.d = string2;
        this.f = new z.a();
        this.g = u2;
        this.h = bl;
        if (r2 != null) {
            this.f.a(r2);
        }
        if (bl2) {
            this.j = new Object(){
                private final java.util.List<String> a = new java.util.ArrayList();
                private final java.util.List<String> b = new java.util.ArrayList();

                public p.a a(String string, String string2) {
                    this.a.add((Object)s.a(string, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
                    this.b.add((Object)s.a(string2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
                    return this;
                }

                public p a() {
                    return new p(this.a, this.b);
                }

                public p.a b(String string, String string2) {
                    this.a.add((Object)s.a(string, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true));
                    this.b.add((Object)s.a(string2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true));
                    return this;
                }
            };
            return;
        }
        if (bl3) {
            this.i = new Object(){
                private final c.f a;
                private u b = v.a;
                private final java.util.List<v.b> c = new java.util.ArrayList();
                {
                    this(java.util.UUID.randomUUID().toString());
                }
                {
                    this.a = c.f.a(string);
                }

                public v.a a(r r2, aa aa2) {
                    return this.a(v.b.a(r2, aa2));
                }

                public v.a a(u u2) {
                    if (u2 != null) {
                        if (u2.a().equals((Object)"multipart")) {
                            this.b = u2;
                            return this;
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("multipart != ");
                        stringBuilder.append((Object)u2);
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                    throw new NullPointerException("type == null");
                }

                public v.a a(v.b b2) {
                    if (b2 != null) {
                        this.c.add((Object)b2);
                        return this;
                    }
                    throw new NullPointerException("part == null");
                }

                public v a() {
                    if (!this.c.isEmpty()) {
                        return new v(this.a, this.b, this.c);
                    }
                    throw new java.lang.IllegalStateException("Multipart body must have at least one part.");
                }
            };
            this.i.a(v.e);
        }
    }

    private static String a(String string, boolean bl) {
        int n2;
        int n3 = string.length();
        for (int i2 = 0; i2 < n3; i2 += Character.charCount((int)n2)) {
            n2 = string.codePointAt(i2);
            if (n2 >= 32 && n2 < 127 && " \"<>^`{}|\\?#".indexOf(n2) == -1 && (bl || n2 != 47 && n2 != 37)) {
                continue;
            }
            c c2 = new c();
            c2.a(string, 0, i2);
            k.a(c2, string, i2, n3, bl);
            string = c2.q();
            break;
        }
        return string;
    }

    private static void a(c c2, String string, int n2, int n3, boolean bl) {
        c c3 = null;
        while (n2 < n3) {
            int n4 = string.codePointAt(n2);
            if (!bl || n4 != 9 && n4 != 10 && n4 != 12 && n4 != 13) {
                if (n4 >= 32 && n4 < 127 && " \"<>^`{}|\\?#".indexOf(n4) == -1 && (bl || n4 != 47 && n4 != 37)) {
                    c2.a(n4);
                } else {
                    if (c3 == null) {
                        c3 = new c();
                    }
                    c3.a(n4);
                    while (!c3.g()) {
                        int n5 = 255 & c3.j();
                        c2.b(37);
                        c2.b((int)a[15 & n5 >> 4]);
                        c2.b((int)a[n5 & 15]);
                    }
                }
            }
            n2 += Character.charCount((int)n4);
        }
    }

    z a() {
        block14 : {
            u u2;
            s s2;
            block13 : {
                block12 : {
                    s.a a2 = this.e;
                    if (a2 == null) break block12;
                    s2 = a2.c();
                    break block13;
                }
                s2 = this.c.c(this.d);
                if (s2 == null) break block14;
            }
            aa aa2 = this.k;
            if (aa2 == null) {
                if (this.j != null) {
                    aa2 = this.j.a();
                } else if (this.i != null) {
                    aa2 = this.i.a();
                } else if (this.h) {
                    aa2 = aa.a(null, new byte[0]);
                }
            }
            if ((u2 = this.g) != null) {
                if (aa2 != null) {
                    aa2 = new /* Unavailable Anonymous Inner Class!! */;
                } else {
                    this.f.b("Content-Type", u2.toString());
                }
            }
            return this.f.a(s2).a(this.b, aa2).a();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Malformed URL. Base: ");
        stringBuilder.append((Object)this.c);
        stringBuilder.append(", Relative: ");
        stringBuilder.append(this.d);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    void a(aa aa2) {
        this.k = aa2;
    }

    void a(r r2, aa aa2) {
        this.i.a(r2, aa2);
    }

    void a(v.b b2) {
        this.i.a(b2);
    }

    void a(Object object) {
        if (object != null) {
            this.d = object.toString();
            return;
        }
        throw new NullPointerException("@Url parameter is null.");
    }

    void a(String string, String string2) {
        if ("Content-Type".equalsIgnoreCase(string)) {
            this.g = u.a(string2);
            return;
        }
        this.f.b(string, string2);
    }

    void a(String string, String string2, boolean bl) {
        if (this.d != null) {
            String string3 = this.d;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("{");
            stringBuilder.append(string);
            stringBuilder.append("}");
            this.d = string3.replace((CharSequence)stringBuilder.toString(), (CharSequence)k.a(string2, bl));
            return;
        }
        throw new AssertionError();
    }

    void b(String string, String string2, boolean bl) {
        if (this.d != null) {
            this.e = this.c.d(this.d);
            if (this.e != null) {
                this.d = null;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Malformed URL. Base: ");
                stringBuilder.append((Object)this.c);
                stringBuilder.append(", Relative: ");
                stringBuilder.append(this.d);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        if (bl) {
            this.e.b(string, string2);
            return;
        }
        this.e.a(string, string2);
    }

    void c(String string, String string2, boolean bl) {
        if (bl) {
            this.j.b(string, string2);
            return;
        }
        this.j.a(string, string2);
    }
}

