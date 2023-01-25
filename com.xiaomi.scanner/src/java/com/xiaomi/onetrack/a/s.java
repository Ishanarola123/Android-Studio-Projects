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
import com.xiaomi.onetrack.h.n;
import com.xiaomi.onetrack.h.o;

class s
implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ f b;

    s(f f2, String string2) {
        this.b = f2;
        this.a = string2;
    }

    public void run() {
        try {
            n.a().a(this.a);
            return;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("setInstanceId error: ");
            stringBuilder.append(exception.toString());
            o.b("OneTrackImp", stringBuilder.toString());
            return;
        }
    }
}

