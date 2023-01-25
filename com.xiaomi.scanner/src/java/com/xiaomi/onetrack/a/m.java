/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  org.json.JSONObject
 */
package com.xiaomi.onetrack.a;

import com.xiaomi.onetrack.a.c;
import com.xiaomi.onetrack.a.f;
import com.xiaomi.onetrack.h.o;
import com.xiaomi.onetrack.h.w;
import org.json.JSONObject;

class m
implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ long b;
    final /* synthetic */ f c;

    m(f f2, String string2, long l2) {
        this.c = f2;
        this.a = string2;
        this.b = l2;
    }

    public void run() {
        try {
            if (!f.a(this.c).isAutoTrackActivityAction()) {
                o.a("OneTrackImp", "config.autoTrackActivityAction is false, ignore onetrack_pa pause event");
                return;
            }
            JSONObject jSONObject = f.b(this.c, "onetrack_pa");
            w.i(c.a(this.a, "onetrack_pa", this.b, f.a(this.c), f.c(this.c), jSONObject));
            return;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("savePageEndData error:");
            stringBuilder.append(exception.toString());
            o.b("OneTrackImp", stringBuilder.toString());
            return;
        }
    }
}

