/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.twitter.sdk.android.core.c
 *  com.twitter.sdk.android.core.d
 *  com.twitter.sdk.android.core.e$1
 *  com.twitter.sdk.android.core.internal.oauth.OAuth2Service
 *  com.twitter.sdk.android.core.internal.oauth.a
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.concurrent.CountDownLatch
 */
package com.twitter.sdk.android.core;

import com.twitter.sdk.android.core.a;
import com.twitter.sdk.android.core.c;
import com.twitter.sdk.android.core.d;
import com.twitter.sdk.android.core.e;
import com.twitter.sdk.android.core.internal.oauth.OAuth2Service;
import com.twitter.sdk.android.core.k;
import java.util.concurrent.CountDownLatch;

public class e {
    private final OAuth2Service a;
    private final k<d> b;

    public e(OAuth2Service oAuth2Service, k<d> k2) {
        this.a = oAuth2Service;
        this.b = k2;
    }

    static /* synthetic */ k a(e e2) {
        return e2.b;
    }

    public d a() {
        e e2 = this;
        synchronized (e2) {
            block4 : {
                d d2 = this.b.b();
                boolean bl = this.b(d2);
                if (!bl) break block4;
                return d2;
            }
            this.b();
            d d3 = this.b.b();
            return d3;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public d a(d d2) {
        e e2 = this;
        synchronized (e2) {
            d d3 = this.b.b();
            if (d2 == null) return this.b.b();
            if (!d2.equals((Object)d3)) return this.b.b();
            this.b();
            return this.b.b();
        }
    }

    void b() {
        a.a.a.a.c.h().a("GuestSessionProvider", "Refreshing expired guest session.");
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.a.a((c)new 1(this, countDownLatch));
        try {
            countDownLatch.await();
            return;
        }
        catch (InterruptedException interruptedException) {
            this.b.c(0L);
            return;
        }
    }

    boolean b(d d2) {
        return d2 != null && d2.a() != null && !((com.twitter.sdk.android.core.internal.oauth.a)d2.a()).b();
    }
}

