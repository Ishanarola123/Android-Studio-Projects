/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.System
 */
package com.xiaomi.onetrack.a;

import android.text.TextUtils;
import com.xiaomi.onetrack.a.f;
import com.xiaomi.onetrack.h.b;
import com.xiaomi.onetrack.h.n;
import com.xiaomi.onetrack.h.w;

class g
implements Runnable {
    final /* synthetic */ f a;

    g(f f2) {
        this.a = f2;
    }

    public void run() {
        if (w.B() == 0L) {
            w.n(System.currentTimeMillis());
        }
        if (!TextUtils.isEmpty((CharSequence)f.a(this.a).getInstanceId())) {
            n.a().a(f.a(this.a).getInstanceId());
        }
        f.b(this.a);
        b.a();
        com.xiaomi.onetrack.c.g.c(false);
    }
}

