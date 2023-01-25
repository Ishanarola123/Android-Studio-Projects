/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.List
 *  org.json.JSONObject
 */
package com.xiaomi.onetrack.a;

import com.xiaomi.onetrack.a.f;
import com.xiaomi.onetrack.c.g;
import com.xiaomi.onetrack.h.o;
import java.util.List;
import org.json.JSONObject;

class v
implements Runnable {
    final /* synthetic */ f a;

    v(f f2) {
        this.a = f2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        try {
            if (!g.b()) {
                return;
            }
            List<JSONObject> list = g.c();
            if (list != null && list.size() > 0) {
                for (JSONObject jSONObject : list) {
                    String string2 = jSONObject.optString("eventName");
                    String string3 = jSONObject.optString("data");
                    f.d(this.a).a(string2, string3);
                }
            }
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("cta event error: ");
            stringBuilder.append(exception.toString());
            o.b("OneTrackImp", stringBuilder.toString());
        }
        g.c(true);
    }
}

