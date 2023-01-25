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

import com.xiaomi.onetrack.OneTrack;
import com.xiaomi.onetrack.a.c;
import com.xiaomi.onetrack.a.f;
import com.xiaomi.onetrack.h.o;
import com.xiaomi.onetrack.h.q;
import com.xiaomi.onetrack.h.w;
import java.util.Map;
import org.json.JSONObject;

class ab
implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ OneTrack.UserIdType b;
    final /* synthetic */ boolean c;
    final /* synthetic */ Map d;
    final /* synthetic */ f e;

    ab(f f2, String string2, OneTrack.UserIdType userIdType, boolean bl, Map map) {
        this.e = f2;
        this.a = string2;
        this.b = userIdType;
        this.c = bl;
        this.d = map;
    }

    public void run() {
        try {
            w.g(this.a);
            w.h(this.b.getUserIdType());
            if (this.c) {
                return;
            }
            JSONObject jSONObject = q.a((Map<String, Object>)this.d, false);
            jSONObject.put("uid", (Object)this.a);
            jSONObject.put("uid_type", (Object)this.b.getUserIdType());
            JSONObject jSONObject2 = f.b(this.e, "ot_login");
            String string2 = c.c(jSONObject, f.a(this.e), f.c(this.e), jSONObject2);
            f.d(this.e).a("ot_login", string2);
            return;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("login error:");
            stringBuilder.append(exception.toString());
            o.b("OneTrackImp", stringBuilder.toString());
            return;
        }
    }
}

