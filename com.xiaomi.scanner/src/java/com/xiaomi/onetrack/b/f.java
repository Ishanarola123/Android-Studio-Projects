/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.content.Context
 *  android.database.DatabaseUtils
 *  android.database.sqlite.SQLiteDatabase
 *  android.text.TextUtils
 *  android.util.Log
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.concurrent.Callable
 *  java.util.concurrent.ConcurrentHashMap
 *  java.util.concurrent.FutureTask
 *  java.util.concurrent.atomic.AtomicBoolean
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.xiaomi.onetrack.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.onetrack.b.e;
import com.xiaomi.onetrack.b.g;
import com.xiaomi.onetrack.b.h;
import com.xiaomi.onetrack.b.i;
import com.xiaomi.onetrack.b.j;
import com.xiaomi.onetrack.h.o;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public class f {
    private static final String a = "ConfigDbManager";
    private e b = new e(com.xiaomi.onetrack.f.a.a());
    private ConcurrentHashMap<String, j> c = new ConcurrentHashMap();
    private AtomicBoolean d = new AtomicBoolean(false);

    private f() {
    }

    /* synthetic */ f(g g2) {
        this();
    }

    static /* synthetic */ e a(f f2) {
        return f2.b;
    }

    public static f a() {
        return a.a;
    }

    static /* synthetic */ void a(f f2, ArrayList arrayList) {
        f2.b((ArrayList<j>)arrayList);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private JSONObject b(String string2, String string3) {
        JSONArray jSONArray;
        if (TextUtils.isEmpty((CharSequence)string2)) return null;
        if (TextUtils.isEmpty((CharSequence)string3)) {
            return null;
        }
        try {
            j j2;
            if (this.c.get((Object)string2) == null || this.d.get()) {
                this.b(string2);
            }
            if ((j2 = (j)this.c.get((Object)string2)) == null || j2.d == null || (jSONArray = j2.d.optJSONArray("events")) == null) return null;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("getEventConfig error: ");
            stringBuilder.append(exception.toString());
            Log.e((String)a, (String)stringBuilder.toString());
            return null;
        }
        for (int i2 = 0; i2 < jSONArray.length(); ++i2) {
            JSONObject jSONObject = jSONArray.getJSONObject(i2);
            if (!TextUtils.equals((CharSequence)string3, (CharSequence)jSONObject.optString("event"))) continue;
            if (!o.a) return jSONObject;
            {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("getEventConfig:");
                String string4 = jSONObject != null ? jSONObject.toString() : "";
                stringBuilder.append(string4);
                o.a(a, stringBuilder.toString());
            }
            return jSONObject;
        }
        return null;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private void b(ArrayList<j> var1_1) {
        block11 : {
            var2_2 = null;
            var5_3 = this.b.getWritableDatabase();
            try {
                var5_3.beginTransaction();
                for (j var7_5 : var1_1) {
                    var8_6 = new ContentValues();
                    var8_6.put("app_id", var7_5.a);
                    var8_6.put("timestamp", Long.valueOf((long)var7_5.b));
                    if (var7_5.d != null) {
                        var8_6.put("cloud_data", var7_5.d.toString());
                    }
                    var8_6.put("data_hash", var7_5.c);
                    var9_7 = new String[]{var7_5.a};
                    if (DatabaseUtils.queryNumEntries((SQLiteDatabase)var5_3, (String)"events_cloud", (String)"app_id=?", (String[])var9_7) > 0L) {
                        var12_8 = new String[]{var7_5.a};
                        var5_3.update("events_cloud", var8_6, "app_id=?", var12_8);
                    } else {
                        var5_3.insert("events_cloud", null, var8_6);
                    }
                    this.d.set(true);
                }
                var5_3.setTransactionSuccessful();
                if (var5_3 == null) return;
            }
            catch (Throwable var4_9) {
                break block11;
            }
            catch (Exception var3_12) {
                var2_2 = var5_3;
                ** GOTO lbl-1000
            }
            var5_3.endTransaction();
            return;
            catch (Throwable var4_10) {
                var5_3 = var2_2;
                break block11;
            }
            catch (Exception var3_13) {
                // empty catch block
            }
lbl-1000: // 2 sources:
            {
                o.b("ConfigDbManager", "updateToDb error: ", (Throwable)var3_14);
                if (var2_2 == null) return;
            }
            var2_2.endTransaction();
            return;
        }
        if (var5_3 == null) throw var4_11;
        var5_3.endTransaction();
        throw var4_11;
    }

    public double a(String string2, String string3, String string4, double d2) {
        JSONObject jSONObject;
        block4 : {
            try {
                jSONObject = this.b(string2, string3);
                if (jSONObject != null) break block4;
            }
            catch (Exception exception) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("getDouble: ");
                stringBuilder.append(exception.toString());
                o.b(a, stringBuilder.toString());
                return d2;
            }
            o.a(a, "config not available, use default value");
            return d2;
        }
        double d3 = jSONObject.getDouble(string4);
        return d3;
    }

    public int a(String string2, String string3, String string4, int n2) {
        JSONObject jSONObject;
        block4 : {
            try {
                jSONObject = this.b(string2, string3);
                if (jSONObject != null) break block4;
            }
            catch (Exception exception) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("getInt: ");
                stringBuilder.append(exception.toString());
                o.b(a, stringBuilder.toString());
                return n2;
            }
            o.a(a, "config not available, use default value");
            return n2;
        }
        int n3 = jSONObject.getInt(string4);
        return n3;
    }

    public long a(String string2, String string3, String string4, long l2) {
        JSONObject jSONObject;
        block4 : {
            try {
                jSONObject = this.b(string2, string3);
                if (jSONObject != null) break block4;
            }
            catch (Exception exception) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("getLong: ");
                stringBuilder.append(exception.toString());
                o.b(a, stringBuilder.toString());
                return l2;
            }
            o.a(a, "config not available, use default value");
            return l2;
        }
        long l3 = jSONObject.getLong(string4);
        return l3;
    }

    public String a(String string2, String string3, String string4, String string5) {
        JSONObject jSONObject;
        block4 : {
            try {
                jSONObject = this.b(string2, string3);
                if (jSONObject != null) break block4;
            }
            catch (Exception exception) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("getString: ");
                stringBuilder.append(exception.toString());
                o.b(a, stringBuilder.toString());
                return string5;
            }
            o.a(a, "config not available, use default value");
            return string5;
        }
        String string6 = jSONObject.getString(string4);
        return string6;
    }

    public void a(String string2) {
        FutureTask futureTask = new FutureTask((Runnable)new h(this, string2), null);
        com.xiaomi.onetrack.c.a.a((Runnable)futureTask);
        try {
            futureTask.get();
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }

    public void a(ArrayList<j> arrayList) {
        com.xiaomi.onetrack.c.a.a(new g(this, arrayList));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean a(String string2, String string3) {
        j j2 = this.d(string2);
        if (j2 == null) return false;
        try {
            if (j2.d == null) return false;
            if (!j2.d.has(string3)) return false;
            return j2.d.optBoolean(string3);
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("getAppLevelBoolean");
            stringBuilder.append(exception.toString());
            o.b(a, stringBuilder.toString());
        }
        return false;
    }

    public boolean a(String string2, String string3, String string4, boolean bl) {
        JSONObject jSONObject;
        block4 : {
            try {
                jSONObject = this.b(string2, string3);
                if (jSONObject != null) break block4;
            }
            catch (Exception exception) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("getBoolean: ");
                stringBuilder.append(exception.toString());
                o.b(a, stringBuilder.toString());
                return bl;
            }
            o.a(a, "config not available, use default value");
            return bl;
        }
        boolean bl2 = jSONObject.getBoolean(string4);
        return bl2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void b(String string2) {
        FutureTask futureTask = new FutureTask((Callable)new i(this, string2));
        com.xiaomi.onetrack.c.a.a((Runnable)futureTask);
        j j2 = (j)futureTask.get();
        if (j2 == null) return;
        try {
            this.c.put((Object)string2, (Object)j2);
            this.d.set(false);
            if (!o.a) return;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("getConfig   appId :");
            stringBuilder.append(string2);
            stringBuilder.append(" config: ");
            stringBuilder.append(j2.toString());
            o.a(a, stringBuilder.toString());
            return;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("getConfig error: ");
            stringBuilder.append(exception.toString());
            o.b(a, stringBuilder.toString());
        }
    }

    public String c(String string2) {
        j j2 = this.d(string2);
        if (j2 != null) {
            return j2.c;
        }
        return "";
    }

    public j d(String string2) {
        if (TextUtils.isEmpty((CharSequence)string2)) {
            return null;
        }
        if (this.c.get((Object)string2) == null || this.d.get()) {
            this.b(string2);
        }
        return (j)this.c.get((Object)string2);
    }

    private static class a {
        private static final f a = new f(null);

        private a() {
        }
    }

}

