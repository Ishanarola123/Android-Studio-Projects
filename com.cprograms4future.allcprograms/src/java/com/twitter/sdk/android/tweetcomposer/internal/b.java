/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.twitter.sdk.android.tweetcomposer.internal;

import com.google.a.a.c;
import com.google.a.f;

public class b {
    private static b m;
    @c(a="twitter:card")
    public final String a;
    @c(a="twitter:image")
    public final String b;
    @c(a="twitter:site")
    public final String c;
    @c(a="twitter:description")
    public final String d;
    @c(a="twitter:card_data")
    public final String e;
    @c(a="twitter:text:cta")
    public final String f;
    @c(a="twitter:cta_key")
    public final String g;
    @c(a="twitter:text:did_value")
    public final String h;
    @c(a="twitter:app:id:iphone")
    public final String i;
    @c(a="twitter:app:id:ipad")
    public final String j;
    @c(a="twitter:app:id:googleplay")
    public final String k;
    @c(a="twitter:app:country")
    public final String l;

    private b(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, String string12) {
        this.a = string;
        this.b = string2;
        this.c = string3;
        this.d = string4;
        this.e = string5;
        this.f = string6;
        this.g = string7;
        this.h = string8;
        this.i = string9;
        this.j = string10;
        this.k = string11;
        this.l = string12;
    }

    b a() {
        if (m == null) {
            m = new b();
        }
        return m;
    }

    public String toString() {
        return this.a().a(this);
    }

    public static class a {
        private String a;
        private String b;
        private String c;
        private String d;
        private String e;
        private String f;
        private String g;
        private String h;
        private String i;
        private String j;
        private String k;
        private String l;

        public a a(String string) {
            this.a = string;
            return this;
        }

        public b a() {
            b b2 = new b(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l);
            return b2;
        }

        public a b(String string) {
            this.b = string;
            return this;
        }

        public a c(String string) {
            this.e = string;
            return this;
        }

        public a d(String string) {
            this.g = string;
            return this;
        }

        public a e(String string) {
            this.h = string;
            return this;
        }

        public a f(String string) {
            this.i = string;
            return this;
        }

        public a g(String string) {
            this.j = string;
            return this;
        }

        public a h(String string) {
            this.k = string;
            return this;
        }
    }

    static class b {
        private final f a = new f();

        b() {
        }

        String a(b b2) {
            return this.a.b(b2);
        }
    }

}

