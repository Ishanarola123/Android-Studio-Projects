/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  java.io.IOException
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 *  java.util.Random
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.xiaomi.onetrack.b;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.onetrack.b.b;
import com.xiaomi.onetrack.b.f;
import com.xiaomi.onetrack.b.j;
import com.xiaomi.onetrack.g.c;
import com.xiaomi.onetrack.h.h;
import com.xiaomi.onetrack.h.o;
import com.xiaomi.onetrack.h.p;
import com.xiaomi.onetrack.h.u;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
    public static final String a = "disable_log";
    public static final String b = "event";
    public static final String c = "events";
    public static final String d = "level";
    private static final String e = "AppConfigUpdater";
    private static final long f = 172800000L;
    private static final String g = "hash";
    private static final String h = "appId";
    private static final String i = "apps";
    private static final String j = "type";
    private static final String k = "status";
    private static final String l = "deleted";
    private static final String m = "Android";
    private static boolean n = false;
    private static final int o = 0;
    private static final int p = 1;
    private static final int q = 2;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static JSONArray a(JSONArray jSONArray, JSONArray jSONArray2) {
        JSONArray jSONArray3 = jSONArray;
        int n2 = 0;
        block2 : while (jSONArray2 != null) {
            JSONObject jSONObject;
            int n3;
            String string2;
            try {
                if (n2 >= jSONArray2.length()) return jSONArray3;
                jSONObject = jSONArray2.optJSONObject(n2);
                string2 = jSONObject.optString(b);
                n3 = 0;
            }
            catch (Exception exception) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("mergeEventsElement error:");
                stringBuilder.append(exception.toString());
                o.b(e, stringBuilder.toString());
                return jSONArray3;
            }
            do {
                block10 : {
                    block9 : {
                        if (jSONArray3 == null || n3 >= jSONArray3.length()) break block9;
                        if (!TextUtils.equals((CharSequence)string2, (CharSequence)jSONArray3.optJSONObject(n3).optString(b))) break block10;
                        jSONArray3.remove(n3);
                    }
                    if (!jSONObject.has(k) || jSONObject.has(k) && !TextUtils.equals((CharSequence)jSONObject.optString(k), (CharSequence)l)) {
                        if (jSONArray3 == null) {
                            jSONArray3 = new JSONArray();
                        }
                        jSONArray3.put((Object)jSONObject);
                    }
                    ++n2;
                    continue block2;
                }
                ++n3;
            } while (true);
        }
        return jSONArray3;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static JSONObject a(String string2, JSONObject jSONObject) {
        try {
            j j2 = f.a().d(string2);
            JSONArray jSONArray = j2 != null ? j2.d.optJSONArray(c) : null;
            jSONObject.put(c, (Object)a.a(jSONArray, jSONObject.optJSONArray(c)));
            return jSONObject;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("mergeConfig: ");
            stringBuilder.append(exception.toString());
            o.b(e, stringBuilder.toString());
            return null;
        }
    }

    public static void a(String string2) {
        h.a(new b(string2));
    }

    public static void a(String string2, List<String> list) {
        if (TextUtils.isEmpty((CharSequence)string2)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(string2);
            if (jSONObject.optInt("code") == 0) {
                a.a(jSONObject.optJSONObject("data").optJSONArray(i), list);
                return;
            }
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("saveAppCloudData: ");
            stringBuilder.append(exception.toString());
            o.a(e, stringBuilder.toString());
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void a(List<String> list) {
        if (p.a(e)) {
            return;
        }
        if (n) {
            return;
        }
        HashMap hashMap = new HashMap();
        try {
            try {
                n = true;
                Context context = com.xiaomi.onetrack.f.a.a();
                hashMap.put((Object)"oa", (Object)com.xiaomi.onetrack.h.a.a.a().a(context));
                hashMap.put((Object)"ov", (Object)p.b());
                hashMap.put((Object)"ob", (Object)p.c());
                String string2 = p.A() ? "1" : "0";
                hashMap.put((Object)"ii", (Object)string2);
                hashMap.put((Object)"sv", (Object)"1.1.3");
                hashMap.put((Object)"av", (Object)p.l());
                hashMap.put((Object)"ml", (Object)com.xiaomi.onetrack.h.f.c());
                hashMap.put((Object)"re", (Object)p.B());
                hashMap.put((Object)"ail", (Object)a.b(list));
                hashMap.put((Object)"sender", (Object)com.xiaomi.onetrack.f.a.d());
                hashMap.put((Object)"platform", (Object)m);
                String string3 = u.a().c();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("pullData:");
                stringBuilder.append(string3);
                o.a(e, stringBuilder.toString());
                String string4 = com.xiaomi.onetrack.g.b.b(string3, (Map<String, String>)hashMap, true);
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("response:");
                stringBuilder2.append(string4);
                o.a(e, stringBuilder2.toString());
                a.a(string4, list);
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
        catch (Throwable throwable2) {}
        n = false;
        return;
        n = false;
        throw throwable2;
    }

    private static void a(List<String> list, long l2) {
        ArrayList arrayList = new ArrayList();
        int n2 = 0;
        do {
            if (n2 >= list.size()) break;
            j j2 = new j();
            j2.a = (String)list.get(n2);
            j2.b = l2;
            arrayList.add((Object)j2);
            ++n2;
        } while (true);
        try {
            f.a().a((ArrayList<j>)arrayList);
            return;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("handleError");
            stringBuilder.append(exception.toString());
            o.b(e, stringBuilder.toString());
            return;
        }
    }

    private static void a(List<String> list, long l2, List<String> list2) {
        try {
            if (list.size() != list2.size()) {
                list.removeAll(list2);
                a.a(list, l2);
                return;
            }
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("handleInvalidAppIds error:");
            stringBuilder.append(exception.toString());
            o.b(e, stringBuilder.toString());
        }
    }

    private static void a(JSONArray jSONArray, List<String> list) throws JSONException {
        long l2 = 86400000L + System.currentTimeMillis() + (long)new Random().nextInt(86400000);
        if (jSONArray != null && jSONArray.length() > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < jSONArray.length(); ++i2) {
                JSONObject jSONObject = jSONArray.optJSONObject(i2);
                int n2 = jSONObject != null ? jSONObject.optInt(j) : -1;
                String string2 = jSONObject != null ? jSONObject.optString(h) : "";
                if (n2 != 0 && n2 != 1) {
                    if (n2 == 2) {
                        a.b(jSONObject, l2);
                    } else {
                        o.a(e, "updateDataToDb do nothing!");
                    }
                } else {
                    a.a(jSONObject, l2);
                }
                if (TextUtils.isEmpty((CharSequence)string2)) continue;
                arrayList.add((Object)string2);
            }
            a.a(list, l2, (List<String>)arrayList);
            return;
        }
        a.a(list, l2);
    }

    private static void a(JSONObject jSONObject, long l2) {
        ArrayList arrayList = new ArrayList();
        if (jSONObject != null) {
            j j2 = new j();
            j2.c = jSONObject.optString(g);
            j2.a = jSONObject.optString(h);
            j2.b = l2;
            if (jSONObject.has(c)) {
                j2.d = jSONObject;
            }
            arrayList.add((Object)j2);
        }
        if (!arrayList.isEmpty()) {
            f.a().a((ArrayList<j>)arrayList);
            return;
        }
        o.a(e, "handleFullOrNoNewData no configuration can be updated!");
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static String b(List<String> list) {
        JSONObject jSONObject;
        int n2;
        JSONArray jSONArray = new JSONArray();
        try {
            jSONObject = new JSONObject();
            n2 = 0;
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
        }
        do {
            if (n2 >= list.size()) return jSONArray.toString();
            String string2 = (String)list.get(n2);
            jSONObject.put(h, (Object)string2);
            jSONObject.put(g, (Object)f.a().c(string2));
            jSONArray.put((Object)jSONObject);
            ++n2;
        } while (true);
        return jSONArray.toString();
    }

    public static void b(String string2) {
        if (a.c(string2)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add((Object)string2);
            a.a((List<String>)arrayList);
            return;
        }
        o.a(e, "AppConfigUpdater Does not meet prerequisites for request");
    }

    private static void b(JSONObject jSONObject, long l2) {
        ArrayList arrayList = new ArrayList();
        if (jSONObject != null && jSONObject.has(c)) {
            String string2;
            j j2 = new j();
            j2.c = jSONObject.optString(g);
            j2.a = string2 = jSONObject.optString(h);
            j2.b = l2;
            j2.d = a.a(string2, jSONObject);
            arrayList.add((Object)j2);
        } else {
            o.a(e, "handleIncrementalUpdate config is not change!");
        }
        if (!arrayList.isEmpty()) {
            f.a().a((ArrayList<j>)arrayList);
            return;
        }
        o.a(e, "handleIncrementalUpdate no configuration can be updated!");
    }

    private static boolean c(String string2) {
        if (!c.a()) {
            o.a(e, "net is not connected!");
            return false;
        }
        j j2 = f.a().d(string2);
        if (j2 == null) {
            return true;
        }
        long l2 = j2.b;
        if (l2 >= System.currentTimeMillis()) {
            return l2 - System.currentTimeMillis() > 172800000L;
        }
        return true;
    }
}

