/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.xiaomi.onetrack.f;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.onetrack.Configuration;
import com.xiaomi.onetrack.OneTrack;
import com.xiaomi.onetrack.f.c;
import com.xiaomi.onetrack.h.f;
import com.xiaomi.onetrack.h.n;
import com.xiaomi.onetrack.h.o;
import com.xiaomi.onetrack.h.p;
import com.xiaomi.onetrack.h.w;
import com.xiaomi.onetrack.h.y;
import org.json.JSONException;
import org.json.JSONObject;

public class b {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    private static final String d = "Event";
    private long e;
    private String f;
    private String g;
    private String h;
    private int i;
    private JSONObject j;
    private long k;

    public b() {
    }

    private b(a a2) {
        this.e = a2.a;
        this.f = a2.b;
        this.g = a2.c;
        this.h = a2.d;
        this.i = a2.e;
        this.j = a2.f;
        this.k = a2.g;
    }

    /* synthetic */ b(a a2, c c2) {
        this(a2);
    }

    public static JSONObject a(String string2, Configuration configuration, OneTrack.IEventHook iEventHook) throws JSONException {
        return b.a(string2, configuration, iEventHook, "");
    }

    public static JSONObject a(String string2, Configuration configuration, OneTrack.IEventHook iEventHook, String string3) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        Context context = com.xiaomi.onetrack.f.a.a();
        jSONObject.put(b.a, (Object)string2);
        boolean bl = p.a() ? p.A() : configuration.isInternational();
        if (bl) {
            String string4;
            if (iEventHook != null && iEventHook.fillGAID(string2) && !TextUtils.isEmpty((CharSequence)(string4 = f.p(context)))) {
                jSONObject.put(b.e, (Object)string4);
            }
        } else {
            String string5 = f.b(context);
            jSONObject.put(b.b, (Object)string5);
            jSONObject.put(b.c, (Object)com.xiaomi.onetrack.h.a.a.a().a(context));
        }
        jSONObject.put(b.g, (Object)n.a().b());
        jSONObject.put(b.h, (Object)f.d());
        jSONObject.put(b.i, (Object)f.c());
        jSONObject.put(b.j, (Object)"Android");
        jSONObject.put(b.k, (Object)p.k());
        jSONObject.put(b.l, (Object)p.f());
        jSONObject.put(b.m, (Object)p.l());
        jSONObject.put(b.o, (Object)com.xiaomi.onetrack.f.a.b());
        jSONObject.put(b.r, System.currentTimeMillis());
        jSONObject.put(b.s, (Object)p.d());
        jSONObject.put(b.t, (Object)com.xiaomi.onetrack.g.c.a(context).toString());
        jSONObject.put(b.u, (Object)p.B());
        jSONObject.put(b.w, (Object)"1.1.3");
        jSONObject.put(b.n, (Object)configuration.getAppId());
        jSONObject.put(b.p, (Object)com.xiaomi.onetrack.f.a.d());
        String string6 = !TextUtils.isEmpty((CharSequence)configuration.getChannel()) ? configuration.getChannel() : "default";
        jSONObject.put(b.q, (Object)string6);
        b.a(jSONObject, configuration, string3);
        b.a(jSONObject, context);
        jSONObject.put(b.z, p.u());
        OneTrack.Mode mode = configuration.getMode() != null ? configuration.getMode() : OneTrack.Mode.APP;
        String string7 = mode.getType();
        jSONObject.put(b.A, (Object)string7);
        jSONObject.put(b.B, y.d(w.B()));
        return jSONObject;
    }

    private static void a(JSONObject jSONObject, Context context) throws JSONException {
        String string2 = w.u();
        String string3 = w.w();
        if (!TextUtils.isEmpty((CharSequence)string2) && !TextUtils.isEmpty((CharSequence)string3)) {
            jSONObject.put(b.x, (Object)string2);
            jSONObject.put(b.y, (Object)string3);
        }
    }

    private static void a(JSONObject jSONObject, Configuration configuration, String string2) throws JSONException {
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            jSONObject.put(b.v, (Object)string2);
            return;
        }
        jSONObject.put(b.v, (Object)configuration.getPluginId());
    }

    public long a() {
        return this.e;
    }

    public void a(int n2) {
        this.i = n2;
    }

    public void a(long l2) {
        this.e = l2;
    }

    public void a(String string2) {
        this.f = string2;
    }

    public void a(JSONObject jSONObject) {
        this.j = jSONObject;
    }

    public String b() {
        return this.f;
    }

    public void b(long l2) {
        this.k = l2;
    }

    public void b(String string2) {
        this.g = string2;
    }

    public String c() {
        return this.g;
    }

    public void c(String string2) {
        this.h = string2;
    }

    public String d() {
        return this.h;
    }

    public int e() {
        return this.i;
    }

    public JSONObject f() {
        return this.j;
    }

    public long g() {
        return this.k;
    }

    public boolean h() {
        try {
            boolean bl;
            if (this.j != null && this.j.has("H") && this.j.has("B") && !TextUtils.isEmpty((CharSequence)this.f) && !(bl = TextUtils.isEmpty((CharSequence)this.g))) {
                return true;
            }
        }
        catch (Exception exception) {
            o.b(d, "check event isValid error, ", exception);
        }
        return false;
    }

    public static class a {
        private long a;
        private String b;
        private String c;
        private String d;
        private int e;
        private JSONObject f;
        private long g;

        public a a(int n2) {
            this.e = n2;
            return this;
        }

        public a a(long l2) {
            this.a = this.a;
            return this;
        }

        public a a(String string2) {
            this.b = string2;
            return this;
        }

        public a a(JSONObject jSONObject) {
            this.f = jSONObject;
            return this;
        }

        public b a() {
            return new b(this, null);
        }

        public a b(long l2) {
            this.g = l2;
            return this;
        }

        public a b(String string2) {
            this.c = string2;
            return this;
        }

        public a c(String string2) {
            this.d = string2;
            return this;
        }
    }

    public static class b {
        public static String A = "sdk_mode";
        public static String B = "ot_first_day";
        public static String a = "event";
        public static String b = "imei";
        public static String c = "oaid";
        public static String d = "sn";
        public static String e = "gaid";
        public static String f = "android_id";
        public static String g = "instance_id";
        public static String h = "mfrs";
        public static String i = "model";
        public static String j = "platform";
        public static String k = "miui";
        public static String l = "build";
        public static String m = "os_ver";
        public static String n = "app_id";
        public static String o = "app_ver";
        public static String p = "pkg";
        public static String q = "channel";
        public static String r = "e_ts";
        public static String s = "tz";
        public static String t = "net";
        public static String u = "region";
        public static String v = "plugin_id";
        public static String w = "sdk_ver";
        public static String x = "uid";
        public static String y = "uid_type";
        public static String z = "sid";
    }

}

