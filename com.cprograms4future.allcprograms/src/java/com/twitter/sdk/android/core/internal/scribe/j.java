/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.twitter.sdk.android.core.a.j
 *  java.io.Serializable
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 */
package com.twitter.sdk.android.core.internal.scribe;

import com.twitter.sdk.android.core.a.e;
import com.twitter.sdk.android.core.a.n;
import com.twitter.sdk.android.core.internal.g;
import java.io.Serializable;

public class j
implements Serializable {
    @com.google.a.a.c(a="item_type")
    public final Integer a;
    @com.google.a.a.c(a="id")
    public final Long b;
    @com.google.a.a.c(a="description")
    public final String c;
    @com.google.a.a.c(a="card_event")
    public final b d;
    @com.google.a.a.c(a="media_details")
    public final c e;

    private j(Integer n2, Long l2, String string, b b2, c c2) {
        this.a = n2;
        this.b = l2;
        this.c = string;
        this.d = b2;
        this.e = c2;
    }

    static int a(com.twitter.sdk.android.core.a.j j2) {
        if ("animated_gif".equals((Object)j2.c)) {
            return 3;
        }
        return 1;
    }

    public static j a(long l2, e e2) {
        return new a().a(0).a(l2).a(j.b(l2, e2)).a();
    }

    public static j a(long l2, com.twitter.sdk.android.core.a.j j2) {
        return new a().a(0).a(l2).a(j.b(l2, j2)).a();
    }

    public static j a(n n2) {
        return new a().a(0).a(n2.i).a();
    }

    static c b(long l2, e e2) {
        c c2 = new c(l2, 4, Long.valueOf((String)g.b(e2)));
        return c2;
    }

    static c b(long l2, com.twitter.sdk.android.core.a.j j2) {
        c c2 = new c(l2, j.a(j2), j2.a);
        return c2;
    }

    public boolean equals(Object object) {
        block7 : {
            boolean bl;
            block9 : {
                block10 : {
                    j j2;
                    block8 : {
                        bl = true;
                        if (this == object) {
                            return bl;
                        }
                        if (object == null) break block7;
                        if (this.getClass() != object.getClass()) {
                            return false;
                        }
                        j2 = (j)object;
                        if (this.a != null ? !this.a.equals((Object)j2.a) : j2.a != null) {
                            return false;
                        }
                        if (this.b != null ? !this.b.equals((Object)j2.b) : j2.b != null) {
                            return false;
                        }
                        if (this.c != null ? !this.c.equals((Object)j2.c) : j2.c != null) {
                            return false;
                        }
                        if (this.d != null ? !this.d.equals(j2.d) : j2.d != null) {
                            return false;
                        }
                        if (this.e == null) break block8;
                        if (this.e.equals(j2.e)) break block9;
                        break block10;
                    }
                    if (j2.e == null) {
                        return bl;
                    }
                }
                bl = false;
            }
            return bl;
        }
        return false;
    }

    public int hashCode() {
        int n2 = this.a != null ? this.a.hashCode() : 0;
        int n3 = n2 * 31;
        int n4 = this.b != null ? this.b.hashCode() : 0;
        int n5 = 31 * (n3 + n4);
        int n6 = this.c != null ? this.c.hashCode() : 0;
        int n7 = 31 * (n5 + n6);
        int n8 = this.d != null ? this.d.hashCode() : 0;
        int n9 = 31 * (n7 + n8);
        c c2 = this.e;
        int n10 = 0;
        if (c2 != null) {
            n10 = this.e.hashCode();
        }
        return n9 + n10;
    }

    public static class a {
        private Integer a;
        private Long b;
        private String c;
        private b d;
        private c e;

        public a a(int n2) {
            this.a = n2;
            return this;
        }

        public a a(long l2) {
            this.b = l2;
            return this;
        }

        public a a(b b2) {
            this.d = b2;
            return this;
        }

        public a a(c c2) {
            this.e = c2;
            return this;
        }

        public j a() {
            j j2 = new j(this.a, this.b, this.c, this.d, this.e);
            return j2;
        }
    }

    public static class b
    implements Serializable {
        @com.google.a.a.c(a="promotion_card_type")
        final int a;

        public b(int n2) {
            this.a = n2;
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object != null) {
                if (this.getClass() != object.getClass()) {
                    return false;
                }
                b b2 = (b)object;
                return this.a == b2.a;
            }
            return false;
        }

        public int hashCode() {
            return this.a;
        }
    }

    public static class c
    implements Serializable {
        @com.google.a.a.c(a="content_id")
        public final long a;
        @com.google.a.a.c(a="media_type")
        public final int b;
        @com.google.a.a.c(a="publisher_id")
        public final long c;

        public c(long l2, int n2, long l3) {
            this.a = l2;
            this.b = n2;
            this.c = l3;
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object != null) {
                if (this.getClass() != object.getClass()) {
                    return false;
                }
                c c2 = (c)object;
                if (this.a != c2.a) {
                    return false;
                }
                if (this.b != c2.b) {
                    return false;
                }
                return this.c == c2.c;
            }
            return false;
        }

        public int hashCode() {
            return 31 * (31 * (int)(this.a ^ this.a >>> 32) + this.b) + (int)(this.c ^ this.c >>> 32);
        }
    }

}

