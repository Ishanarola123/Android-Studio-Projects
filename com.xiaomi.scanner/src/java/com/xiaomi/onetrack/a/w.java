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

class w
implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ Map b;
    final /* synthetic */ f c;

    w(f f2, String string2, Map map) {
        this.c = f2;
        this.a = string2;
        this.b = map;
    }

    public void run() {
        try {
            if (f.a(this.c, this.a)) {
                return;
            }
            JSONObject jSONObject = q.a((Map<String, Object>)this.b, true);
            JSONObject jSONObject2 = f.b(this.c, this.a);
            String string2 = c.a(this.a, jSONObject, f.a(this.c), f.c(this.c), jSONObject2);
            f.d(this.c).a(this.a, string2);
            return;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("track map error: ");
            stringBuilder.append(exception.toString());
            o.b("OneTrackImp", stringBuilder.toString());
            return;
        }
    }
}

