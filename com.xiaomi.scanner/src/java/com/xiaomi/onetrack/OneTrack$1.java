/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 */
package com.xiaomi.onetrack;

import com.xiaomi.onetrack.c.g;

final class OneTrack$1
implements Runnable {
    final /* synthetic */ boolean a;

    OneTrack$1(boolean bl) {
        this.a = bl;
    }

    public void run() {
        g.a(this.a);
        g.b(this.a);
    }
}

