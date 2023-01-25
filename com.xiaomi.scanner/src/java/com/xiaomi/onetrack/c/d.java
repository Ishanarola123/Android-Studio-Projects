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
package com.xiaomi.onetrack.c;

import com.xiaomi.onetrack.c.b;
import com.xiaomi.onetrack.c.l;
import com.xiaomi.onetrack.h.o;
import org.json.JSONObject;

class d
implements Runnable {
    final /* synthetic */ com.xiaomi.onetrack.f.b a;
    final /* synthetic */ b b;

    d(b b2, com.xiaomi.onetrack.f.b b3) {
        this.b = b2;
        this.a = b3;
    }

    public void run() {
        try {
            b.a(this.b, this.a);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("addEvent: ");
            stringBuilder.append(this.a.d());
            stringBuilder.append("data:");
            stringBuilder.append(this.a.f().toString());
            o.a("EventManager", stringBuilder.toString());
            int n2 = this.a.e();
            l.a().a(n2, false);
            return;
        }
        catch (Exception exception) {
            o.b("EventManager", "EventManager.addEvent exception: ", exception);
            return;
        }
    }
}

