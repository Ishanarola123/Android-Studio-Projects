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
 *  java.lang.System
 *  java.util.HashMap
 *  java.util.Map
 *  org.json.JSONObject
 */
package com.xiaomi.onetrack.d;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.onetrack.d.b;
import com.xiaomi.onetrack.d.c;
import com.xiaomi.onetrack.d.e;
import com.xiaomi.onetrack.d.g;
import com.xiaomi.onetrack.h.o;
import com.xiaomi.onetrack.h.p;
import com.xiaomi.onetrack.h.u;
import com.xiaomi.onetrack.h.w;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class f {
    public static final JSONObject a = new JSONObject();
    private static final String b = "SecretKeyManager";
    private static final String c = "secretKey";
    private static final String d = "sid";
    private static final String e = "key";
    private Context f = com.xiaomi.onetrack.f.a.a();
    private JSONObject g = null;
    private String[] h = new String[2];

    private f() {
    }

    /* synthetic */ f(g g2) {
        this();
    }

    public static f a() {
        return a.a;
    }

    private void d() {
        if (o.a) {
            if (!TextUtils.isEmpty((CharSequence)this.h[0]) && !TextUtils.isEmpty((CharSequence)this.h[1])) {
                o.a(b, "key  and sid is valid! ");
                return;
            }
            o.a(b, "key or sid is invalid!");
        }
    }

    private JSONObject e() {
        JSONObject jSONObject = this.g;
        if (jSONObject == null && (jSONObject = this.f()) != null) {
            this.g = jSONObject;
        }
        if (jSONObject == null) {
            jSONObject = this.c();
        }
        return jSONObject;
    }

    private JSONObject f() {
        String string2;
        block3 : {
            try {
                string2 = w.g();
                if (!TextUtils.isEmpty((CharSequence)string2)) break block3;
                return null;
            }
            catch (Exception exception) {
                exception.printStackTrace();
                return null;
            }
        }
        JSONObject jSONObject = new JSONObject(b.b(this.f, string2));
        return jSONObject;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String[] b() {
        f f2 = this;
        synchronized (f2) {
            JSONObject jSONObject = this.e();
            String[] arrstring = this.h;
            String string2 = jSONObject != null ? jSONObject.optString(e) : "";
            arrstring[0] = string2;
            String[] arrstring2 = this.h;
            String string3 = jSONObject != null ? jSONObject.optString(d) : "";
            arrstring2[1] = string3;
            this.d();
            return this.h;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public JSONObject c() {
        if (p.a(b)) {
            return a;
        }
        byte[] arrby = com.xiaomi.onetrack.d.a.a();
        String string2 = c.a(e.a(arrby));
        HashMap hashMap = new HashMap();
        hashMap.put((Object)c, (Object)string2);
        String string3 = com.xiaomi.onetrack.g.b.b(u.a().e(), (Map<String, String>)hashMap, true);
        if (TextUtils.isEmpty((CharSequence)string3)) return this.g;
        JSONObject jSONObject = new JSONObject(string3);
        int n2 = jSONObject.optInt("code");
        JSONObject jSONObject2 = jSONObject.optJSONObject("data");
        if (n2 != 0 || jSONObject2 == null) return this.g;
        try {
            String string4 = jSONObject2.optString(e);
            String string5 = jSONObject2.optString(d);
            if (TextUtils.isEmpty((CharSequence)string4) || TextUtils.isEmpty((CharSequence)string5)) return this.g;
            String string6 = c.a(com.xiaomi.onetrack.d.a.b(c.a(string4), arrby));
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(e, (Object)string6);
            jSONObject3.put(d, (Object)string5);
            this.g = jSONObject3;
            w.a(b.a(this.f, jSONObject3.toString()));
            w.i(System.currentTimeMillis());
            return this.g;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("requestSecretData: ");
            stringBuilder.append(exception.toString());
            o.b(b, stringBuilder.toString());
        }
        return this.g;
    }

    private static final class a {
        private static final f a = new f(null);

        private a() {
        }
    }

}

