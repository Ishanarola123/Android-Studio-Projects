/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package b;

import b.a.b.h;
import b.aa;
import b.d;
import b.r;
import b.s;

public final class z {
    private final s a;
    private final String b;
    private final r c;
    private final aa d;
    private final Object e;
    private volatile d f;

    private z(a a2) {
        this.a = a2.a;
        this.b = a2.b;
        this.c = a2.c.a();
        this.d = a2.d;
        Object object = a2.e != null ? a2.e : this;
        this.e = object;
    }

    public s a() {
        return this.a;
    }

    public String a(String string) {
        return this.c.a(string);
    }

    public String b() {
        return this.b;
    }

    public r c() {
        return this.c;
    }

    public aa d() {
        return this.d;
    }

    public a e() {
        return new a(this);
    }

    public d f() {
        d d2;
        d d3 = this.f;
        if (d3 != null) {
            return d3;
        }
        this.f = d2 = d.a(this.c);
        return d2;
    }

    public boolean g() {
        return this.a.c();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Request{method=");
        stringBuilder.append(this.b);
        stringBuilder.append(", url=");
        stringBuilder.append((Object)this.a);
        stringBuilder.append(", tag=");
        Object object = this.e != this ? this.e : null;
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public static class a {
        private s a;
        private String b;
        private r.a c;
        private aa d;
        private Object e;

        public a() {
            this.b = "GET";
            this.c = new r.a();
        }

        private a(z z2) {
            this.a = z2.a;
            this.b = z2.b;
            this.d = z2.d;
            this.e = z2.e;
            this.c = z2.c.b();
        }

        public a a(r r2) {
            this.c = r2.b();
            return this;
        }

        public a a(s s2) {
            if (s2 != null) {
                this.a = s2;
                return this;
            }
            throw new IllegalArgumentException("url == null");
        }

        public a a(String string) {
            this.c.b(string);
            return this;
        }

        public a a(String string, aa aa2) {
            if (string != null && string.length() != 0) {
                if (aa2 != null && !h.c(string)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("method ");
                    stringBuilder.append(string);
                    stringBuilder.append(" must not have a request body.");
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
                if (aa2 == null && h.b(string)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("method ");
                    stringBuilder.append(string);
                    stringBuilder.append(" must have a request body.");
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
                this.b = string;
                this.d = aa2;
                return this;
            }
            throw new IllegalArgumentException("method == null || method.length() == 0");
        }

        public a a(String string, String string2) {
            this.c.c(string, string2);
            return this;
        }

        public z a() {
            if (this.a != null) {
                return new z(this);
            }
            throw new IllegalStateException("url == null");
        }

        public a b(String string, String string2) {
            this.c.a(string, string2);
            return this;
        }
    }

}

