/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Map
 *  org.json.JSONObject
 */
package com.xiaomi.onetrack.a;

import android.text.TextUtils;
import com.xiaomi.onetrack.a.f;
import com.xiaomi.onetrack.h.j;
import com.xiaomi.onetrack.h.q;
import java.util.Map;
import org.json.JSONObject;

class o
implements Runnable {
    final /* synthetic */ Map a;
    final /* synthetic */ f b;

    o(f f2, Map map) {
        this.b = f2;
        this.a = map;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        try {
            JSONObject jSONObject = q.a((Map<String, Object>)this.a, false);
            String string2 = j.a(f.g(this.b));
            boolean bl = TextUtils.isEmpty((CharSequence)string2);
            JSONObject jSONObject2 = null;
            if (!bl) {
                jSONObject2 = new JSONObject(string2);
            }
            JSONObject jSONObject3 = q.a(jSONObject, jSONObject2);
            j.a(f.g(this.b), jSONObject3.toString());
            return;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(" ");
            stringBuilder.append(exception.toString());
            com.xiaomi.onetrack.h.o.b("OneTrackImp", stringBuilder.toString());
            return;
        }
    }
}

