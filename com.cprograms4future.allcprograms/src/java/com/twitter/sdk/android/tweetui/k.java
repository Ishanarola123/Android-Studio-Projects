/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.support.v4.g.g
 *  com.twitter.sdk.android.core.c
 *  com.twitter.sdk.android.core.o
 *  com.twitter.sdk.android.core.q
 *  com.twitter.sdk.android.core.u
 *  com.twitter.sdk.android.tweetui.k$1
 *  com.twitter.sdk.android.tweetui.k$2
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 */
package com.twitter.sdk.android.tweetui;

import a.a.a.a.c;
import android.os.Handler;
import android.support.v4.g.g;
import com.twitter.sdk.android.core.a.n;
import com.twitter.sdk.android.core.i;
import com.twitter.sdk.android.core.o;
import com.twitter.sdk.android.core.q;
import com.twitter.sdk.android.core.r;
import com.twitter.sdk.android.core.u;
import com.twitter.sdk.android.tweetui.k;
import d.l;

class k {
    final g<Long, n> a;
    final g<Long, Object> b;
    private final q c;
    private final Handler d;
    private final com.twitter.sdk.android.core.k<u> e;

    k(Handler handler, com.twitter.sdk.android.core.k<u> k2) {
        this(handler, k2, q.c());
    }

    k(Handler handler, com.twitter.sdk.android.core.k<u> k2, q q2) {
        this.c = q2;
        this.d = handler;
        this.e = k2;
        this.a = new g(20);
        this.b = new g(20);
    }

    static /* synthetic */ q a(k k2) {
        return k2.c;
    }

    void a(long l2, com.twitter.sdk.android.core.c<n> c2) {
        1 var4_3 = new 1(this, c2, c.h(), l2, c2);
        this.a((com.twitter.sdk.android.core.c<u>)var4_3);
    }

    void a(com.twitter.sdk.android.core.c<u> c2) {
        u u2 = this.e.b();
        if (u2 == null) {
            c2.a((r)new o("User authorization required"));
            return;
        }
        c2.a(new i<u>(u2, null));
    }

    void b(long l2, com.twitter.sdk.android.core.c<n> c2) {
        2 var4_3 = new 2(this, c2, c.h(), l2, c2);
        this.a((com.twitter.sdk.android.core.c<u>)var4_3);
    }
}

