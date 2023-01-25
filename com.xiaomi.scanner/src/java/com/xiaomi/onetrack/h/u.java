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
 *  java.lang.StringBuilder
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.concurrent.ConcurrentHashMap
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.xiaomi.onetrack.h;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.onetrack.b.c;
import com.xiaomi.onetrack.h.o;
import com.xiaomi.onetrack.h.p;
import com.xiaomi.onetrack.h.v;
import com.xiaomi.onetrack.h.w;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class u {
    private static final String a = "RegionDomainManager";
    private static final String b = "CN";
    private static final String c = "INTL";
    private static final String d = "IN";
    private static final String e = "RU";
    private static final String f = "http://";
    private static final String g = "https://";
    private static final String h = "tracking.miui.com";
    private static final String i = "tracking.intl.miui.com";
    private static final String j = "tracking.rus.miui.com";
    private static final String k = "tracking.india.miui.com";
    private static final String l = "sdkconfig.ad.xiaomi.com";
    private static final String m = "sdkconfig.ad.intl.xiaomi.com";
    private static final String n = "sdkconfig.ad.india.xiaomi.com";
    private static final String o = "sdkconfig.ad.rus.xiaomi.com";
    private static final String p = "staging.sdkconfig.ad.xiaomi.srv";
    private static final String q = "staging.tracking.miui.com";
    private static final String r = "/track/v4";
    private static final String s = "/track/key_get";
    private static final String t = "/api/v4/detail/config";
    private static final String u = "/api/v4/detail/config_common";
    private static ConcurrentHashMap<String, String> w = new ConcurrentHashMap();
    private Context v;

    private u() {
        w.put((Object)d, (Object)k);
        w.put((Object)e, (Object)j);
        this.f();
    }

    /* synthetic */ u(v v2) {
        this();
    }

    public static u a() {
        return a.a;
    }

    private String a(boolean bl, String string2) {
        if (!bl) {
            return h;
        }
        String string3 = (String)w.get((Object)string2);
        if (TextUtils.isEmpty((CharSequence)string3)) {
            string3 = i;
        }
        return string3;
    }

    private void f() {
        try {
            String string2 = w.h();
            if (!TextUtils.isEmpty((CharSequence)string2)) {
                this.a(new JSONObject(string2));
                return;
            }
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
        }
    }

    private String g() {
        return g;
    }

    private String h() {
        return this.a(p.A(), p.B());
    }

    private String i() {
        boolean bl = p.A();
        String string2 = p.B();
        if (!bl) {
            return l;
        }
        if (TextUtils.equals((CharSequence)string2, (CharSequence)d)) {
            return n;
        }
        if (TextUtils.equals((CharSequence)string2, (CharSequence)e)) {
            return o;
        }
        return m;
    }

    public String a(String string2, String string3, String string4) {
        StringBuilder stringBuilder = new StringBuilder(string2);
        stringBuilder.append(string3);
        stringBuilder.append(string4);
        return stringBuilder.toString();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(JSONObject jSONObject) {
        u u2 = this;
        synchronized (u2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("updateHostMap:");
            stringBuilder.append(jSONObject.toString());
            o.a(a, stringBuilder.toString());
            if (jSONObject == null) {
                return;
            }
            try {
                Iterator iterator = jSONObject.keys();
                while (iterator.hasNext()) {
                    String string2 = (String)iterator.next();
                    String string3 = jSONObject.optString(string2);
                    if (TextUtils.isEmpty((CharSequence)string2) || TextUtils.isEmpty((CharSequence)string3)) continue;
                    w.put((Object)string2, (Object)string3);
                }
                w.b(new JSONObject(w).toString());
            }
            catch (Exception exception) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("updateHostMap: ");
                stringBuilder2.append(exception.toString());
                o.a(a, stringBuilder2.toString());
            }
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("merge config:");
            stringBuilder3.append(new JSONObject(w).toString());
            o.a(a, stringBuilder3.toString());
            return;
        }
    }

    public String b() {
        try {
            if (TextUtils.isEmpty((CharSequence)w.l())) {
                c.b();
            }
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("getTrackingUrl: ");
            stringBuilder.append(exception.toString());
            o.a(a, stringBuilder.toString());
        }
        return this.a(this.g(), this.h(), r);
    }

    public String c() {
        return this.a(this.g(), this.i(), t);
    }

    public String d() {
        return this.a(this.g(), this.i(), u);
    }

    public String e() {
        return this.a(this.g(), this.h(), s);
    }

    private static class a {
        private static final u a = new u(null);

        private a() {
        }
    }

}

