/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 */
package com.xiaomi.onetrack.b;

import com.xiaomi.onetrack.b.f;
import com.xiaomi.onetrack.h.o;
import java.util.ArrayList;

class g
implements Runnable {
    final /* synthetic */ ArrayList a;
    final /* synthetic */ f b;

    g(f f2, ArrayList arrayList) {
        this.b = f2;
        this.a = arrayList;
    }

    public void run() {
        if (o.a) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("update: ");
            stringBuilder.append((Object)this.a);
            o.a("ConfigDbManager", stringBuilder.toString());
        }
        f.a(this.b, this.a);
    }
}

