/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.xiaomi.onetrack.h.r
 *  com.xiaomi.onetrack.h.s
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Exception
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.xiaomi.onetrack.h;

import android.text.TextUtils;
import com.xiaomi.onetrack.h.o;
import com.xiaomi.onetrack.h.r;
import com.xiaomi.onetrack.h.s;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class q {
    public static final String a = "onetrack_";
    public static final String b = "ot_";
    private static final String c = "ParamUtil";

    private static JSONArray a(List list) throws JSONException {
        if (list == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (Object object : list) {
            if (q.b(object)) {
                jSONArray.put(object);
                continue;
            }
            if (!(object instanceof Map)) continue;
            JSONObject jSONObject = new JSONObject();
            Map map = (Map)object;
            boolean bl = false;
            for (Map.Entry entry : map.entrySet()) {
                Object object2 = entry.getKey();
                Object object3 = entry.getValue();
                if (!(object2 instanceof String) || !q.b(object3)) continue;
                jSONObject.put((String)object2, object3);
                bl = true;
            }
            if (!bl) continue;
            jSONArray.put((Object)jSONObject);
        }
        return jSONArray;
    }

    public static JSONObject a(Map<String, Object> map) {
        return q.a(map, (a)new s());
    }

    private static JSONObject a(Map<String, Object> map, a a2) {
        JSONObject jSONObject = new JSONObject();
        if (map == null) {
            return jSONObject;
        }
        try {
            for (Map.Entry entry : map.entrySet()) {
                String string2 = (String)entry.getKey();
                Object object = entry.getValue();
                if (!a2.a(object)) {
                    if (!o.a) continue;
                    q.a(c, (String)entry.getKey());
                    continue;
                }
                if (q.b(object)) {
                    jSONObject.put(string2, object);
                    continue;
                }
                if (!(object instanceof List)) continue;
                jSONObject.put(string2, (Object)q.a((List)object));
            }
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("checkParam error:");
            stringBuilder.append(exception.toString());
            o.b(c, stringBuilder.toString());
        }
        return jSONObject;
    }

    public static JSONObject a(Map<String, Object> map, boolean bl) {
        return q.a(map, (a)new r(bl));
    }

    public static JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null && jSONObject2 == null) {
            return new JSONObject();
        }
        if (jSONObject == null && jSONObject2 != null) {
            return jSONObject2;
        }
        if (jSONObject != null && jSONObject2 == null) {
            return jSONObject;
        }
        try {
            Iterator iterator = jSONObject.keys();
            while (iterator.hasNext()) {
                String string2 = (String)iterator.next();
                jSONObject2.put(string2, jSONObject.opt(string2));
            }
            return jSONObject2;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("merge error\uff1a");
            stringBuilder.append(exception.toString());
            o.b(c, stringBuilder.toString());
            return jSONObject;
        }
    }

    public static void a(String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("key is ");
        stringBuilder.append(string3);
        stringBuilder.append(", the param value is invalid\uff0cplease change the parameter type to string ,numeric, boolean\uff01");
        o.b(string2, stringBuilder.toString());
    }

    public static boolean a(Object object) {
        return q.b(object) || object instanceof List;
        {
        }
    }

    public static boolean a(String string2) {
        if (!q.c(string2)) {
            return false;
        }
        String string3 = string2.toLowerCase();
        if (!string3.startsWith(a)) {
            return !string3.startsWith(b);
        }
        return false;
    }

    public static boolean b(Object object) {
        return object instanceof Boolean || object instanceof Number || object instanceof String;
        {
        }
    }

    private static boolean b(String string2) {
        if (TextUtils.isEmpty((CharSequence)string2)) {
            return false;
        }
        return string2.matches("-?\\d+(\\.\\d+)?");
    }

    static /* synthetic */ boolean c(Object object) {
        return q.d(object);
    }

    private static boolean c(String string2) {
        if (string2 != null) {
            if (string2.isEmpty()) {
                return false;
            }
            char[] arrc = string2.toCharArray();
            for (int i2 = 0; i2 < arrc.length; ++i2) {
                char c2 = arrc[i2];
                if (i2 == 0 && Character.isDigit((char)c2)) {
                    return false;
                }
                if (c2 == '_' || Character.isDigit((char)c2) || c2 >= 'a' && c2 <= 'z' || c2 >= 'A' && c2 <= 'Z') continue;
                return false;
            }
            return true;
        }
        return false;
    }

    private static boolean d(Object object) {
        return object instanceof Number;
    }

    public static interface a {
        public boolean a(Object var1);
    }

}

