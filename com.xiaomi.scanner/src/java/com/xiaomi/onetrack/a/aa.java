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
import com.xiaomi.onetrack.h.q;
import org.json.JSONObject;

class aa
implements Runnable {
    final /* synthetic */ Object a;
    final /* synthetic */ String b;
    final /* synthetic */ f c;

    aa(f f2, Object object, String string2) {
        this.c = f2;
        this.a = object;
        this.b = string2;
    }

    public void run() {
        try {
            if (!q.b(this.a)) {
                q.a("OneTrackImp", this.b);
                return;
            }
            JSONObject jSONObject = f.b(this.c, "ot_profile_set");
            String string2 = c.a(new JSONObject().put(this.b, this.a), f.a(this.c), f.c(this.c), jSONObject);
            f.d(this.c).a("ot_profile_set", string2);
            return;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("setUserProfile single error:");
            stringBuilder.append(exception.toString());
            o.b("OneTrackImp", stringBuilder.toString());
            return;
        }
    }
}

