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
import com.xiaomi.onetrack.h.w;
import java.util.Map;
import org.json.JSONObject;

class i
implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ Map b;
    final /* synthetic */ f c;

    i(f f2, boolean bl, Map map) {
        this.c = f2;
        this.a = bl;
        this.b = map;
    }

    public void run() {
        try {
            if (!this.a) {
                JSONObject jSONObject = q.a((Map<String, Object>)this.b, false);
                String string2 = w.u();
                String string3 = w.w();
                jSONObject.put("uid", (Object)string2);
                jSONObject.put("uid_type", (Object)string3);
                JSONObject jSONObject2 = f.b(this.c, "ot_logout");
                String string4 = c.d(jSONObject, f.a(this.c), f.c(this.c), jSONObject2);
                f.d(this.c).a("ot_logout", string4);
            }
            w.v();
            w.x();
            return;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("logout error:");
            stringBuilder.append(exception.toString());
            o.b("OneTrackImp", stringBuilder.toString());
            return;
        }
    }
}

