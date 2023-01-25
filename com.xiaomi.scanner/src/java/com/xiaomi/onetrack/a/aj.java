/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.xiaomi.onetrack.a;

import com.xiaomi.onetrack.a.ak;
import org.json.JSONException;
import org.json.JSONObject;

public class aj {
    public static final String a = "name";
    public static final String b = "gender";
    public static final String c = "birthday";
    public static final String d = "phone";
    public static final String e = "job";
    public static final String f = "hobby";
    public static final String g = "region";
    public static final String h = "province";
    public static final String i = "city";
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;

    private aj() {
    }

    /* synthetic */ aj(ak ak2) {
        this();
    }

    public String a() {
        return this.j;
    }

    public String b() {
        return this.k;
    }

    public String c() {
        return this.l;
    }

    public String d() {
        return this.m;
    }

    public String e() {
        return this.n;
    }

    public String f() {
        return this.o;
    }

    public String g() {
        return this.p;
    }

    public String h() {
        return this.q;
    }

    public String i() {
        return this.r;
    }

    public JSONObject j() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(a, (Object)this.j);
            jSONObject.put(b, (Object)this.k);
            jSONObject.put(c, (Object)this.l);
            jSONObject.put(d, (Object)this.m);
            jSONObject.put(e, (Object)this.n);
            jSONObject.put(f, (Object)this.o);
            jSONObject.put(g, (Object)this.p);
            jSONObject.put(h, (Object)this.q);
            jSONObject.put(i, (Object)this.r);
            return jSONObject;
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
            return jSONObject;
        }
    }

    public String toString() {
        return this.j().toString();
    }

    public static final class a {
        private String a;
        private String b;
        private String c;
        private String d;
        private String e;
        private String f;
        private String g;
        private String h;
        private String i;

        public a a(String string2) {
            this.a = string2;
            return this;
        }

        public aj a() {
            aj aj2 = new aj(null);
            aj2.o = this.f;
            aj2.n = this.e;
            aj2.r = this.i;
            aj2.m = this.d;
            aj2.q = this.h;
            aj2.l = this.c;
            aj2.j = this.a;
            aj2.p = this.g;
            aj2.k = this.b;
            return aj2;
        }

        public a b(String string2) {
            this.b = string2;
            return this;
        }

        public a c(String string2) {
            this.c = string2;
            return this;
        }

        public a d(String string2) {
            this.d = string2;
            return this;
        }

        public a e(String string2) {
            this.e = string2;
            return this;
        }

        public a f(String string2) {
            this.f = string2;
            return this;
        }

        public a g(String string2) {
            this.g = string2;
            return this;
        }

        public a h(String string2) {
            this.h = string2;
            return this;
        }

        public a i(String string2) {
            this.i = string2;
            return this;
        }
    }

}

