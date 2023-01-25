/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package com.xiaomi.onetrack.c;

import com.xiaomi.onetrack.c.g;

final class h
implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;

    h(String string2, String string3) {
        this.a = string2;
        this.b = string3;
    }

    public void run() {
        g.b(this.a, this.b);
    }
}

