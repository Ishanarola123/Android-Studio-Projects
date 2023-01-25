/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  org.json.JSONObject
 */
package com.xiaomi.onetrack.a;

import com.xiaomi.onetrack.a.c;
import com.xiaomi.onetrack.a.f;
import com.xiaomi.onetrack.h.o;
import com.xiaomi.onetrack.h.w;
import com.xiaomi.onetrack.h.y;
import org.json.JSONObject;

class k
implements Runnable {
    final /* synthetic */ f a;

    k(f f2) {
        this.a = f2;
    }

    public void run() {
        try {
            if (!y.d(w.t())) {
                w.m(System.currentTimeMillis());
                JSONObject jSONObject = f.b(this.a, "onetrack_dau");
                String string2 = c.a(f.a(this.a), f.c(this.a), jSONObject);
                f.d(this.a).a("onetrack_dau", string2);
                return;
            }
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("trackDau error  e:");
            stringBuilder.append(exception.toString());
            o.b("OneTrackImp", stringBuilder.toString());
        }
    }
}

