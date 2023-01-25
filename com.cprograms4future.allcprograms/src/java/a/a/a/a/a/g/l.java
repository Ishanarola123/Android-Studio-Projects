/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.HashMap
 *  java.util.Map
 *  org.json.JSONObject
 */
package a.a.a.a.a.g;

import a.a.a.a.a.b.a;
import a.a.a.a.a.e.d;
import a.a.a.a.a.e.e;
import a.a.a.a.a.g.w;
import a.a.a.a.a.g.x;
import a.a.a.a.c;
import a.a.a.a.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class l
extends a
implements x {
    public l(i i2, String string, String string2, e e2) {
        this(i2, string, string2, e2, a.a.a.a.a.e.c.a);
    }

    l(i i2, String string, String string2, e e2, a.a.a.a.a.e.c c2) {
        super(i2, string, string2, e2, c2);
    }

    private d a(d d2, w w2) {
        this.a(d2, "X-CRASHLYTICS-API-KEY", w2.a);
        this.a(d2, "X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        this.a(d2, "X-CRASHLYTICS-API-CLIENT-VERSION", this.a.a());
        this.a(d2, "Accept", "application/json");
        this.a(d2, "X-CRASHLYTICS-DEVICE-MODEL", w2.b);
        this.a(d2, "X-CRASHLYTICS-OS-BUILD-VERSION", w2.c);
        this.a(d2, "X-CRASHLYTICS-OS-DISPLAY-VERSION", w2.d);
        this.a(d2, "X-CRASHLYTICS-ADVERTISING-TOKEN", w2.e);
        this.a(d2, "X-CRASHLYTICS-INSTALLATION-ID", w2.f);
        this.a(d2, "X-CRASHLYTICS-ANDROID-ID", w2.g);
        return d2;
    }

    private JSONObject a(String string) {
        try {
            JSONObject jSONObject = new JSONObject(string);
            return jSONObject;
        }
        catch (Exception exception) {
            a.a.a.a.l l2 = c.h();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to parse settings JSON from ");
            stringBuilder.append(this.a());
            l2.a("Fabric", stringBuilder.toString(), exception);
            a.a.a.a.l l3 = c.h();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Settings response ");
            stringBuilder2.append(string);
            l3.a("Fabric", stringBuilder2.toString());
            return null;
        }
    }

    private void a(d d2, String string, String string2) {
        if (string2 != null) {
            d2.a(string, string2);
        }
    }

    private Map<String, String> b(w w2) {
        String string;
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"build_version", (Object)w2.j);
        hashMap.put((Object)"display_version", (Object)w2.i);
        hashMap.put((Object)"source", (Object)Integer.toString((int)w2.k));
        if (w2.l != null) {
            hashMap.put((Object)"icon_hash", (Object)w2.l);
        }
        if (!a.a.a.a.a.b.i.b(string = w2.h)) {
            hashMap.put((Object)"instance", (Object)string);
        }
        return hashMap;
    }

    JSONObject a(d d2) {
        int n2 = d2.b();
        a.a.a.a.l l2 = c.h();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Settings result was: ");
        stringBuilder.append(n2);
        l2.a("Fabric", stringBuilder.toString());
        if (this.a(n2)) {
            return this.a(d2.d());
        }
        a.a.a.a.l l3 = c.h();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Failed to retrieve settings from ");
        stringBuilder2.append(this.a());
        l3.d("Fabric", stringBuilder2.toString());
        return null;
    }

    @Override
    public JSONObject a(w w2) {
        void var3_14;
        d d2;
        block7 : {
            JSONObject jSONObject;
            block6 : {
                d2 = null;
                Map<String, String> map = this.b(w2);
                d d3 = this.a(map);
                try {
                    d2 = this.a(d3, w2);
                }
                catch (Throwable throwable) {
                    d2 = d3;
                    break block7;
                }
                try {
                    a.a.a.a.l l2 = c.h();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Requesting settings from ");
                    stringBuilder.append(this.a());
                    l2.a("Fabric", stringBuilder.toString());
                    a.a.a.a.l l3 = c.h();
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("Settings query params were: ");
                    stringBuilder2.append(map);
                    l3.a("Fabric", stringBuilder2.toString());
                    jSONObject = this.a(d2);
                    if (d2 == null) break block6;
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
                a.a.a.a.l l4 = c.h();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Settings request ID: ");
                stringBuilder.append(d2.b("X-REQUEST-ID"));
                l4.a("Fabric", stringBuilder.toString());
            }
            return jSONObject;
        }
        if (d2 != null) {
            a.a.a.a.l l5 = c.h();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Settings request ID: ");
            stringBuilder.append(d2.b("X-REQUEST-ID"));
            l5.a("Fabric", stringBuilder.toString());
        }
        throw var3_14;
    }

    boolean a(int n2) {
        return n2 == 200 || n2 == 201 || n2 == 202 || n2 == 203;
        {
        }
    }
}

