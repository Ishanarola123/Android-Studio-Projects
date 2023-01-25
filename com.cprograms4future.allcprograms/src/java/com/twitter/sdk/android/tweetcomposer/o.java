/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Void
 *  java.util.concurrent.ConcurrentHashMap
 */
package com.twitter.sdk.android.tweetcomposer;

import a.a.a.a.a.c.d;
import a.a.a.a.c;
import a.a.a.a.i;
import com.twitter.sdk.android.core.internal.scribe.a;
import com.twitter.sdk.android.core.j;
import com.twitter.sdk.android.core.k;
import com.twitter.sdk.android.core.p;
import com.twitter.sdk.android.core.q;
import com.twitter.sdk.android.core.u;
import com.twitter.sdk.android.tweetcomposer.e;
import com.twitter.sdk.android.tweetcomposer.l;
import com.twitter.sdk.android.tweetcomposer.m;
import java.util.concurrent.ConcurrentHashMap;

@d(a={"Lcom/twitter/sdk/android/core/q;"})
public class o
extends i<Void> {
    String a;
    k<u> b;
    com.twitter.sdk.android.core.e c;
    private final ConcurrentHashMap<j, e> d = new ConcurrentHashMap();
    private l k = new m(null);

    public static o e() {
        o.i();
        return c.a(o.class);
    }

    private static void i() {
        if (c.a(o.class) != null) {
            return;
        }
        throw new IllegalStateException("Must start Twitter Kit with Fabric.with() first");
    }

    public e a(u u2) {
        o.i();
        if (!this.d.containsKey((Object)u2)) {
            this.d.putIfAbsent((Object)u2, (Object)new e(u2));
        }
        return (e)this.d.get((Object)u2);
    }

    @Override
    public String a() {
        return "2.3.0.163";
    }

    @Override
    public String b() {
        return "com.twitter.sdk.android:tweet-composer";
    }

    protected Void c() {
        this.a = this.l().i();
        a a2 = new a(this, "TweetComposer", this.b, this.c, this.l());
        this.k = new m(a2);
        return null;
    }

    @Override
    protected /* synthetic */ Object d() {
        return this.c();
    }

    protected l f() {
        return this.k;
    }

    @Override
    protected boolean g() {
        this.b = q.c().i();
        this.c = q.c().j();
        return super.g();
    }

    String h() {
        return this.a;
    }
}

