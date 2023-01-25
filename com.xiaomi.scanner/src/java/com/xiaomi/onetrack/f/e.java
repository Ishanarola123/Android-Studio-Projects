/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package com.xiaomi.onetrack.f;

import com.xiaomi.onetrack.f.b;

final class e
implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;

    e(String string2, String string3, String string4, String string5) {
        this.a = string2;
        this.b = string3;
        this.c = string4;
        this.d = string5;
    }

    public void run() {
        b b2 = com.xiaomi.onetrack.e.b.a(this.a, this.b, this.c, this.d);
        com.xiaomi.onetrack.c.b.a().a(b2);
    }
}

