/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Map
 *  org.json.JSONObject
 */
package com.xiaomi.onetrack.a;

import com.xiaomi.onetrack.a.c;
import com.xiaomi.onetrack.a.f;
import com.xiaomi.onetrack.h.o;
import com.xiaomi.onetrack.h.q;
import java.util.Map;
import org.json.JSONObject;

class z
implements Runnable {
    final /* synthetic */ Map a;
    final /* synthetic */ f b;

    z(f f2, Map map) {
        this.b = f2;
        this.a = map;
    }

    public void run() {
        try {
            JSONObject jSONObject = f.b(this.b, "ot_profile_set");
            String string2 = c.a(q.a((Map<String, Object>)this.a, false), f.a(this.b), f.c(this.b), jSONObject);
            f.d(this.b).a("ot_profile_set", string2);
            return;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("setUserProfile map error:");
            stringBuilder.append(exception.toString());
            o.b("OneTrackImp", stringBuilder.toString());
            return;
        }
    }
}

