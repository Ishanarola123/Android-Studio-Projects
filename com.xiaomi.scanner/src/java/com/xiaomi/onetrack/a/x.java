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

import com.xiaomi.onetrack.a.f;
import com.xiaomi.onetrack.h.o;

class x
implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ f c;

    x(f f2, String string2, String string3) {
        this.c = f2;
        this.a = string2;
        this.b = string3;
    }

    public void run() {
        try {
            if (f.a(this.c, this.a)) {
                return;
            }
            f.d(this.c).a(this.a, this.b);
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

