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

import b.ac;
import b.d;
import b.q;
import b.r;
import b.s;
import b.x;
import b.z;

public final class ab {
    private final z a;
    private final x b;
    private final int c;
    private final String d;
    private final q e;
    private final r f;
    private final ac g;
    private ab h;
    private ab i;
    private final ab j;
    private volatile d k;

    private ab(a a2) {
        this.a = a2.a;
        this.b = a2.b;
        this.c = a2.c;
        this.d = a2.d;
        this.e = a2.e;
        this.f = a2.f.a();
        this.g = a2.g;
        this.h = a2.h;
        this.i = a2.i;
        this.j = a2.j;
    }

    public z a() {
        return this.a;
    }

    public String a(String string) {
        return this.a(string, null);
    }

    public String a(String string, String string2) {
        String string3 = this.f.a(string);
        if (string3 != null) {
            return string3;
        }
        return string2;
    }

    public int b() {
        return this.c;
    }

    public boolean c() {
        return this.c >= 200 && this.c < 300;
    }

    public q d() {
        return this.e;
    }

    public r e() {
        return this.f;
    }

    public ac f() {
        return this.g;
    }

    public a g() {
        return new a(this);
    }

    public ab h() {
        return this.j;
    }

    public d i() {
        d d2;
        d d3 = this.k;
        if (d3 != null) {
            return d3;
        }
        this.k = d2 = d.a(this.f);
        return d2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Response{protocol=");
        stringBuilder.append((Object)this.b);
        stringBuilder.append(", code=");
        stringBuilder.append(this.c);
        stringBuilder.append(", message=");
        stringBuilder.append(this.d);
        stringBuilder.append(", url=");
        stringBuilder.append((Object)this.a.a());
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public static class a {
        private z a;
        private x b;
        private int c = -1;
        private String d;
        private q e;
        private r.a f;
        private ac g;
        private ab h;
        private ab i;
        private ab j;

        public a() {
            this.f = new r.a();
        }

        private a(ab ab2) {
            this.a = ab2.a;
            this.b = ab2.b;
            this.c = ab2.c;
            this.d = ab2.d;
            this.e = ab2.e;
            this.f = ab2.f.b();
            this.g = ab2.g;
            this.h = ab2.h;
            this.i = ab2.i;
            this.j = ab2.j;
        }

        private void a(String string, ab ab2) {
            if (ab2.g == null) {
                if (ab2.h == null) {
                    if (ab2.i == null) {
                        if (ab2.j == null) {
                            return;
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(string);
                        stringBuilder.append(".priorResponse != null");
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(string);
                    stringBuilder.append(".cacheResponse != null");
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append(".networkResponse != null");
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append(".body != null");
            throw new IllegalArgumentException(stringBuilder.toString());
        }

        private void d(ab ab2) {
            if (ab2.g == null) {
                return;
            }
            throw new IllegalArgumentException("priorResponse.body != null");
        }

        public a a(int n2) {
            this.c = n2;
            return this;
        }

        public a a(ab ab2) {
            if (ab2 != null) {
                this.a("networkResponse", ab2);
            }
            this.h = ab2;
            return this;
        }

        public a a(ac ac2) {
            this.g = ac2;
            return this;
        }

        public a a(q q2) {
            this.e = q2;
            return this;
        }

        public a a(r r2) {
            this.f = r2.b();
            return this;
        }

        public a a(x x2) {
            this.b = x2;
            return this;
        }

        public a a(z z2) {
            this.a = z2;
            return this;
        }

        public a a(String string) {
            this.d = string;
            return this;
        }

        public a a(String string, String string2) {
            this.f.c(string, string2);
            return this;
        }

        public ab a() {
            if (this.a != null) {
                if (this.b != null) {
                    if (this.c >= 0) {
                        return new ab(this);
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("code < 0: ");
                    stringBuilder.append(this.c);
                    throw new IllegalStateException(stringBuilder.toString());
                }
                throw new IllegalStateException("protocol == null");
            }
            throw new IllegalStateException("request == null");
        }

        public a b(ab ab2) {
            if (ab2 != null) {
                this.a("cacheResponse", ab2);
            }
            this.i = ab2;
            return this;
        }

        public a b(String string, String string2) {
            this.f.a(string, string2);
            return this;
        }

        public a c(ab ab2) {
            if (ab2 != null) {
                this.d(ab2);
            }
            this.j = ab2;
            return this;
        }
    }

}

