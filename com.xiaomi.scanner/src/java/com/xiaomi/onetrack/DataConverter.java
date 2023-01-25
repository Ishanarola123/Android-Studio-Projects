/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.reflect.Array
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.xiaomi.onetrack;

import android.os.Bundle;
import com.xiaomi.onetrack.h.o;
import com.xiaomi.onetrack.h.q;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DataConverter {
    private static final String a = "DataConverter";

    private static List a(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int n2 = jSONArray.length();
        for (int i2 = 0; i2 < n2; ++i2) {
            Object object = jSONArray.get(i2);
            if (q.b(object)) {
                arrayList.add(object);
                continue;
            }
            if (!(object instanceof JSONObject)) continue;
            JSONObject jSONObject = (JSONObject)object;
            Iterator iterator = jSONObject.keys();
            HashMap hashMap = new HashMap();
            while (iterator.hasNext()) {
                String string2 = (String)iterator.next();
                Object object2 = jSONObject.get(string2);
                if (!q.b(object2)) continue;
                hashMap.put((Object)string2, object2);
            }
            if (hashMap.size() <= 0) continue;
            arrayList.add((Object)hashMap);
        }
        return arrayList;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Map fromBundle(Bundle var0) {
        block10 : {
            if (var0 == null) {
                return null;
            }
            var1_1 = new HashMap();
            try {
                var6_2 = var0.keySet().iterator();
lbl6: // 3 sources:
                do {
                    if (var6_2.hasNext() == false) return var1_1;
                    var7_3 = (String)var6_2.next();
                    var8_4 = var0.get(var7_3);
                    if (q.b(var8_4)) {
                        var1_1.put((Object)var7_3, var8_4);
                        continue;
                    }
                    if (var8_4.getClass().isArray()) {
                        var15_9 = Array.getLength((Object)var8_4);
                        var16_10 = new ArrayList();
                        var17_11 = 0;
                        break block10;
                    }
                    if (var8_4 instanceof List) {
                        var9_5 = (List)var8_4;
                        var10_6 = new ArrayList();
                        for (Object var13_8 : var9_5) {
                            if (!q.b(var13_8)) continue;
                            var10_6.add(var13_8);
                        }
                        if (var10_6.size() <= 0) continue;
                        var1_1.put((Object)var7_3, (Object)var10_6);
                        continue;
                    }
                    if (!o.a) continue;
                    q.a("DataConverter", var7_3);
                    continue;
                    break;
                } while (true);
            }
            catch (Exception var2_13) {
                var3_14 = new StringBuilder();
                var3_14.append("convert bundle error:");
                var3_14.append(var2_13.toString());
                o.b("DataConverter", var3_14.toString());
            }
            return var1_1;
        }
        do {
            block12 : {
                block11 : {
                    if (var17_11 >= var15_9) break block11;
                    var18_12 = Array.get((Object)var8_4, (int)var17_11);
                    if (q.b(var18_12)) {
                        var16_10.add(var18_12);
                    }
                    break block12;
                }
                if (var16_10.size() <= 0) ** GOTO lbl6
                var1_1.put((Object)var7_3, (Object)var16_10);
                ** continue;
            }
            ++var17_11;
        } while (true);
    }

    public static Map fromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        try {
            Iterator iterator = jSONObject.keys();
            while (iterator.hasNext()) {
                String string2 = (String)iterator.next();
                Object object = jSONObject.get(string2);
                if (q.b(object)) {
                    hashMap.put((Object)string2, object);
                    continue;
                }
                if (object instanceof JSONArray) {
                    hashMap.put((Object)string2, (Object)DataConverter.a((JSONArray)object));
                    continue;
                }
                if (!o.a) continue;
                q.a(a, string2);
            }
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("convert json to map error:");
            stringBuilder.append(exception.toString());
            o.b(a, stringBuilder.toString());
        }
        return hashMap;
    }
}

