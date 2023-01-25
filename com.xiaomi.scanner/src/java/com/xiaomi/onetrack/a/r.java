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

class r
implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ Map b;
    final /* synthetic */ String c;
    final /* synthetic */ f d;

    r(f f2, String string2, Map map, String string3) {
        this.d = f2;
        this.a = string2;
        this.b = map;
        this.c = string3;
    }

    public void run() {
        try {
            if (f.a(this.d, this.a)) {
                return;
            }
            JSONObject jSONObject = q.a((Map<String, Object>)this.b, true);
            JSONObject jSONObject2 = f.b(this.d, this.a);
            String string2 = c.a(this.c, this.a, jSONObject, f.a(this.d), f.c(this.d), jSONObject2);
            f.d(this.d).a(this.a, string2);
            return;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("track json error:");
            stringBuilder.append(exception.toString());
            o.b("OneTrackImp", stringBuilder.toString());
            return;
        }
    }
}

