/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  java.io.IOException
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.Random
 *  java.util.concurrent.ConcurrentHashMap
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.xiaomi.onetrack.b;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.onetrack.b.d;
import com.xiaomi.onetrack.f.a;
import com.xiaomi.onetrack.g.b;
import com.xiaomi.onetrack.h.f;
import com.xiaomi.onetrack.h.h;
import com.xiaomi.onetrack.h.o;
import com.xiaomi.onetrack.h.p;
import com.xiaomi.onetrack.h.u;
import com.xiaomi.onetrack.h.w;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c {
    public static final String a = "l";
    private static final String b = "CommonConfigUpdater";
    private static final String c = "t";
    private static final String d = "levels";
    private static final String e = "Android";
    private static ConcurrentHashMap<Integer, Integer> f = new ConcurrentHashMap();
    private static final long g = 172800000L;

    public static void a() {
        h.a(new d());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void a(String string2) {
        if (TextUtils.isEmpty((CharSequence)string2)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(string2);
            if (jSONObject.optInt("code") != 0) return;
            String string3 = jSONObject.optString("hash");
            JSONObject jSONObject2 = jSONObject.optJSONObject("data");
            if (jSONObject2 != null) {
                JSONObject jSONObject3 = jSONObject2.optJSONObject("regionUrl");
                if (jSONObject3 != null) {
                    u.a().a(jSONObject3);
                }
                w.d(jSONObject2.toString());
                w.c(string3);
            }
            w.j(86400000L + System.currentTimeMillis() + (long)new Random().nextInt(86400000));
            return;
        }
        catch (JSONException jSONException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("saveCommonCloudData: ");
            stringBuilder.append(jSONException.toString());
            o.a(b, stringBuilder.toString());
        }
    }

    public static void b() {
        if (c.e()) {
            c.f();
            return;
        }
        o.a(b, "CommonConfigUpdater Does not meet prerequisites for request");
    }

    public static Map<Integer, Integer> c() {
        block7 : {
            JSONArray jSONArray;
            int n2;
            try {
                if (!f.isEmpty()) {
                    return f;
                }
                String string2 = w.l();
                if (TextUtils.isEmpty((CharSequence)string2)) break block7;
                jSONArray = new JSONObject(string2).optJSONArray(d);
                n2 = 0;
            }
            catch (Exception exception) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("getLevelIntervalConfig: ");
                stringBuilder.append(exception.toString());
                o.a(b, stringBuilder.toString());
            }
            do {
                block8 : {
                    if (n2 >= jSONArray.length()) break block7;
                    JSONObject jSONObject = jSONArray.getJSONObject(n2);
                    int n3 = jSONObject.optInt(a);
                    int n4 = jSONObject.optInt(c);
                    if (n3 <= 0 || n4 <= 0) break block8;
                    f.put((Object)n3, (Object)n4);
                }
                ++n2;
            } while (true);
        }
        if (f.isEmpty()) {
            return c.g();
        }
        return f;
    }

    static /* synthetic */ void d() {
        c.f();
    }

    private static boolean e() {
        if (!com.xiaomi.onetrack.g.c.a()) {
            o.b(b, "net is not connected!");
            return false;
        }
        if (TextUtils.isEmpty((CharSequence)w.l())) {
            return true;
        }
        long l2 = w.j();
        if (l2 >= System.currentTimeMillis()) {
            return l2 - System.currentTimeMillis() > 172800000L;
        }
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void f() {
        String string2;
        if (p.a(b)) {
            return;
        }
        HashMap hashMap = new HashMap();
        try {
            Context context = a.a();
            hashMap.put((Object)"oa", (Object)com.xiaomi.onetrack.h.a.a.a().a(context));
            hashMap.put((Object)"ov", (Object)p.b());
            hashMap.put((Object)"ob", (Object)p.c());
            string2 = p.A() ? "1" : "0";
        }
        catch (IOException iOException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("requestCloudData: ");
            stringBuilder.append(iOException.toString());
            o.a(b, stringBuilder.toString());
            return;
        }
        hashMap.put((Object)"ii", (Object)string2);
        hashMap.put((Object)"sv", (Object)"1.1.3");
        hashMap.put((Object)"av", (Object)p.l());
        hashMap.put((Object)"ml", (Object)f.c());
        hashMap.put((Object)"re", (Object)p.B());
        hashMap.put((Object)"platform", (Object)e);
        String string3 = u.a().d();
        String string4 = b.b(string3, (Map<String, String>)hashMap, true);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("url:");
        stringBuilder.append(string3);
        stringBuilder.append(" response:");
        stringBuilder.append(string4);
        o.a(b, stringBuilder.toString());
        c.a(string4);
    }

    private static HashMap<Integer, Integer> g() {
        HashMap hashMap = new HashMap();
        hashMap.put((Object)1, (Object)5000);
        hashMap.put((Object)2, (Object)15000);
        hashMap.put((Object)3, (Object)900000);
        return hashMap;
    }
}

