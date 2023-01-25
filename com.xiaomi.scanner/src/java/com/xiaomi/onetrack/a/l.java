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
import org.json.JSONObject;

class l
implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ boolean b;
    final /* synthetic */ f c;

    l(f f2, String string2, boolean bl) {
        this.c = f2;
        this.a = string2;
        this.b = bl;
    }

    public void run() {
        try {
            if (!f.a(this.c).isAutoTrackActivityAction()) {
                o.a("OneTrackImp", "config.autoTrackActivityAction is false, ignore onetrack_pa resume event");
                return;
            }
            JSONObject jSONObject = f.b(this.c, "onetrack_pa");
            String string2 = c.a(this.a, "onetrack_pa", f.a(this.c), f.c(this.c), jSONObject, this.b);
            f.d(this.c).a("onetrack_pa", string2);
            o.a("OneTrackImp", "trackPageStartAuto");
            return;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("auto trackPageStartAuto error: ");
            stringBuilder.append(exception.toString());
            o.b("OneTrackImp", stringBuilder.toString());
            return;
        }
    }
}

