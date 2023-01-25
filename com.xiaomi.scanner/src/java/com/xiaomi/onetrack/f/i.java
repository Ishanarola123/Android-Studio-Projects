/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 */
package com.xiaomi.onetrack.f;

import com.xiaomi.onetrack.f.f;
import com.xiaomi.onetrack.f.h;

class i
implements Runnable {
    final /* synthetic */ h a;

    i(h h2) {
        this.a = h2;
    }

    public void run() {
        if (f.a(this.a.a).get()) {
            f.b(this.a.a);
        }
        f.a(this.a.a).set(true);
    }
}

