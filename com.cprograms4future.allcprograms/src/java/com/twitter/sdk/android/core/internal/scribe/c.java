/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.twitter.sdk.android.core.internal.scribe;

public class c {
    @com.google.a.a.c(a="client")
    public final String a;
    @com.google.a.a.c(a="page")
    public final String b;
    @com.google.a.a.c(a="section")
    public final String c;
    @com.google.a.a.c(a="component")
    public final String d;
    @com.google.a.a.c(a="element")
    public final String e;
    @com.google.a.a.c(a="action")
    public final String f;

    public c(String string, String string2, String string3, String string4, String string5, String string6) {
        this.a = string;
        this.b = string2;
        this.c = string3;
        this.d = string4;
        this.e = string5;
        this.f = string6;
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
            if (this.f != null ? !this.f.equals((Object)c2.f) : c2.f != null) {
                return false;
            }
            if (this.a != null ? !this.a.equals((Object)c2.a) : c2.a != null) {
                return false;
            }
            if (this.d != null ? !this.d.equals((Object)c2.d) : c2.d != null) {
                return false;
            }
            if (this.e != null ? !this.e.equals((Object)c2.e) : c2.e != null) {
                return false;
            }
            if (this.b != null ? !this.b.equals((Object)c2.b) : c2.b != null) {
                return false;
            }
            return !(this.c != null ? !this.c.equals((Object)c2.c) : c2.c != null);
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
        int n10 = this.e != null ? this.e.hashCode() : 0;
        int n11 = 31 * (n9 + n10);
        String string = this.f;
        int n12 = 0;
        if (string != null) {
            n12 = this.f.hashCode();
        }
        return n11 + n12;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("client=");
        stringBuilder.append(this.a);
        stringBuilder.append(", page=");
        stringBuilder.append(this.b);
        stringBuilder.append(", section=");
        stringBuilder.append(this.c);
        stringBuilder.append(", component=");
        stringBuilder.append(this.d);
        stringBuilder.append(", element=");
        stringBuilder.append(this.e);
        stringBuilder.append(", action=");
        stringBuilder.append(this.f);
        return stringBuilder.toString();
    }

    public static class a {
        private String a;
        private String b;
        private String c;
        private String d;
        private String e;
        private String f;

        public a a(String string) {
            this.a = string;
            return this;
        }

        public c a() {
            c c2 = new c(this.a, this.b, this.c, this.d, this.e, this.f);
            return c2;
        }

        public a b(String string) {
            this.b = string;
            return this;
        }

        public a c(String string) {
            this.c = string;
            return this;
        }

        public a d(String string) {
            this.d = string;
            return this;
        }

        public a e(String string) {
            this.e = string;
            return this;
        }

        public a f(String string) {
            this.f = string;
            return this;
        }
    }

}

