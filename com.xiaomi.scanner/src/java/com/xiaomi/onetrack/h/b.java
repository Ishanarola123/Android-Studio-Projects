/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  android.widget.Toast
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.xiaomi.onetrack.h;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;
import com.xiaomi.onetrack.f.a;
import com.xiaomi.onetrack.h.c;
import com.xiaomi.onetrack.h.d;
import com.xiaomi.onetrack.h.e;
import com.xiaomi.onetrack.h.h;
import com.xiaomi.onetrack.h.o;
import org.json.JSONException;
import org.json.JSONObject;

public class b {
    private static final String a = "b";
    private static final String b = "com.xiaomi.onetrack.DEBUG";
    private static final String c = "com.xiaomi.onetrack.permissions.DEBUG_MODE";
    private static final String d = "/api/open/device/writeBack";
    private static volatile b e;
    private static final int f = 100;
    private final Context g = a.a();
    private Handler h = new c(this, Looper.getMainLooper());
    private BroadcastReceiver i = new d(this);

    private b() {
        this.a(this.g);
    }

    static /* synthetic */ Context a(b b2) {
        return b2.g;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static b a() {
        if (e != null) return e;
        Class<b> class_ = b.class;
        synchronized (b.class) {
            if (e != null) return e;
            e = new b();
            // ** MonitorExit[var1] (shouldn't be in output)
            return e;
        }
    }

    private void a(Context context) {
        if (context == null) {
            return;
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(b);
            context.registerReceiver(this.i, intentFilter, c, null);
            return;
        }
        catch (Exception exception) {
            String string2 = a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("registerDebugModeReceiver: ");
            stringBuilder.append((Object)exception);
            o.a(string2, stringBuilder.toString());
            return;
        }
    }

    static /* synthetic */ void a(b b2, String string2) {
        b2.b(string2);
    }

    static /* synthetic */ void a(b b2, String string2, String string3, String string4) {
        b2.a(string2, string3, string4);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(String string2) {
        try {
            JSONObject jSONObject = new JSONObject(string2);
            int n2 = jSONObject.optInt("code");
            String string3 = jSONObject.optString("message");
            String string4 = jSONObject.optString("result");
            boolean bl = jSONObject.optBoolean("success");
            Message message = Message.obtain();
            message.what = 100;
            Bundle bundle = new Bundle();
            if (n2 == 0 && bl) {
                bundle.putString("hint", string4);
            } else {
                bundle.putString("hint", string3);
            }
            message.setData(bundle);
            this.h.sendMessage(message);
            return;
        }
        catch (JSONException jSONException) {
            o.b(a, jSONException.getMessage());
            return;
        }
    }

    private void a(String string2, String string3, String string4) {
        h.a(new e(this, string2, string3, string4));
    }

    static /* synthetic */ Handler b(b b2) {
        return b2.h;
    }

    static /* synthetic */ String b() {
        return a;
    }

    static /* synthetic */ void b(b b2, String string2) {
        b2.a(string2);
    }

    private void b(String string2) {
        Toast.makeText((Context)this.g, (CharSequence)string2, (int)1).show();
    }
}

