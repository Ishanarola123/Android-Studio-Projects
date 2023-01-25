/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  java.lang.Boolean
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package com.twitter.sdk.android.tweetui;

import a.a.a.a.a.b.m;
import a.a.a.a.a.c.d;
import a.a.a.a.c;
import a.a.a.a.i;
import android.content.Context;
import android.os.Handler;
import com.a.a.t;
import com.twitter.sdk.android.core.e;
import com.twitter.sdk.android.core.internal.scribe.a;
import com.twitter.sdk.android.core.j;
import com.twitter.sdk.android.core.p;
import com.twitter.sdk.android.core.q;
import com.twitter.sdk.android.core.u;
import com.twitter.sdk.android.tweetui.k;
import java.util.List;

@d(a={"Lcom/twitter/sdk/android/core/q;"})
public class n
extends i<Boolean> {
    com.twitter.sdk.android.core.k<u> a;
    e b;
    a c;
    private k d;
    private t k;

    public static n c() {
        n.i();
        return c.a(n.class);
    }

    private static void i() {
        if (c.a(n.class) != null) {
            return;
        }
        throw new IllegalStateException("Must start TweetUi Kit in Fabric.with().");
    }

    private void j() {
        a a2;
        this.c = a2 = new a(this, "TweetUi", this.a, this.b, this.l());
    }

    @Override
    public String a() {
        return "2.3.0.163";
    }

    void a(com.twitter.sdk.android.core.internal.scribe.c c2, List<com.twitter.sdk.android.core.internal.scribe.j> list) {
        if (this.c == null) {
            return;
        }
        this.c.a(c2, list);
    }

    @Override
    /* varargs */ void a(com.twitter.sdk.android.core.internal.scribe.c ... arrc) {
        if (this.c == null) {
            return;
        }
        for (com.twitter.sdk.android.core.internal.scribe.c c2 : arrc) {
            this.c.a(c2);
        }
    }

    @Override
    public String b() {
        return "com.twitter.sdk.android:tweet-ui";
    }

    @Override
    protected /* synthetic */ Object d() {
        return this.e();
    }

    protected Boolean e() {
        this.k = t.a(this.m());
        this.j();
        return true;
    }

    k f() {
        return this.d;
    }

    @Override
    protected boolean g() {
        super.g();
        q q2 = q.c();
        this.a = q2.i();
        this.b = q2.j();
        this.d = new k(this.n().f(), q2.i());
        return true;
    }

    public t h() {
        return this.k;
    }
}

