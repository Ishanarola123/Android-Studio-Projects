/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.xiaomi.onetrack.a;

import com.xiaomi.onetrack.ServiceQualityEvent;
import com.xiaomi.onetrack.a.c;
import com.xiaomi.onetrack.a.f;
import com.xiaomi.onetrack.h.o;

class t
implements Runnable {
    final /* synthetic */ ServiceQualityEvent a;
    final /* synthetic */ f b;

    t(f f2, ServiceQualityEvent serviceQualityEvent) {
        this.b = f2;
        this.a = serviceQualityEvent;
    }

    public void run() {
        try {
            String string2 = c.a(this.a, f.a(this.b), f.c(this.b));
            f.d(this.b).a("ot_service_quality", string2);
            return;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("trackNetAvailableEvent error: ");
            stringBuilder.append(exception.toString());
            o.b("OneTrackImp", stringBuilder.toString());
            return;
        }
    }
}

