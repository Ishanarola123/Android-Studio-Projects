/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Number
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

class h
implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ Number b;
    final /* synthetic */ f c;

    h(f f2, String string2, Number number) {
        this.c = f2;
        this.a = string2;
        this.b = number;
    }

    public void run() {
        try {
            JSONObject jSONObject = f.b(this.c, "ot_profile_increment");
            String string2 = c.b(new JSONObject().put(this.a, (Object)this.b), f.a(this.c), f.c(this.c), jSONObject);
            f.d(this.c).a("ot_profile_increment", string2);
            return;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("userProfileIncrement single error:");
            stringBuilder.append(exception.toString());
            o.b("OneTrackImp", stringBuilder.toString());
            return;
        }
    }
}

