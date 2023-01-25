/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 *  java.lang.Runnable
 */
package com.xiaomi.onetrack.f;

import android.content.Context;
import com.xiaomi.onetrack.c.b;
import com.xiaomi.onetrack.f.f;

class g
implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ f b;

    g(f f2, Context context) {
        this.b = f2;
        this.a = context;
    }

    public void run() {
        f.b(this.a);
        f.a(this.b, this.a);
        b.a(this.a);
    }
}

