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
 *  org.json.JSONObject
 */
package com.xiaomi.onetrack.a;

import android.text.TextUtils;
import com.xiaomi.onetrack.a.f;
import com.xiaomi.onetrack.h.o;
import com.xiaomi.onetrack.h.w;
import org.json.JSONObject;

class n
implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ f b;

    n(f f2, boolean bl) {
        this.b = f2;
        this.a = bl;
    }

    public void run() {
        try {
            String string2 = w.z();
            if (!TextUtils.isEmpty((CharSequence)string2)) {
                JSONObject jSONObject = new JSONObject(string2);
                JSONObject jSONObject2 = jSONObject.optJSONObject("B").put("app_end", this.a);
                f.d(this.b).a("onetrack_pa", jSONObject.put("B", (Object)jSONObject2).toString());
                if (o.a) {
                    o.a("OneTrackImp", "trackPageEndAuto");
                }
                w.i("");
                return;
            }
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("trackPageEndAuto error:");
            stringBuilder.append(exception.toString());
            o.b("OneTrackImp", stringBuilder.toString());
        }
    }
}

