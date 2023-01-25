/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Boolean
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.concurrent.ConcurrentHashMap
 *  java.util.concurrent.ExecutorService
 *  javax.net.ssl.SSLSocketFactory
 */
package com.twitter.sdk.android.core;

import a.a.a.a.a.e.f;
import a.a.a.a.i;
import android.content.Context;
import com.twitter.sdk.android.core.d;
import com.twitter.sdk.android.core.g;
import com.twitter.sdk.android.core.internal.a;
import com.twitter.sdk.android.core.internal.b;
import com.twitter.sdk.android.core.internal.c;
import com.twitter.sdk.android.core.internal.d;
import com.twitter.sdk.android.core.internal.e;
import com.twitter.sdk.android.core.internal.oauth.OAuth2Service;
import com.twitter.sdk.android.core.internal.scribe.m;
import com.twitter.sdk.android.core.j;
import com.twitter.sdk.android.core.k;
import com.twitter.sdk.android.core.l;
import com.twitter.sdk.android.core.n;
import com.twitter.sdk.android.core.s;
import com.twitter.sdk.android.core.u;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import javax.net.ssl.SSLSocketFactory;

public class q
extends i<Boolean> {
    k<u> a;
    k<com.twitter.sdk.android.core.d> b;
    b<u> c;
    private final n d;
    private final ConcurrentHashMap<j, l> k;
    private volatile l l;
    private volatile com.twitter.sdk.android.core.e m;
    private volatile SSLSocketFactory n;

    public q(n n2) {
        this(n2, (ConcurrentHashMap<j, l>)new ConcurrentHashMap(), null);
    }

    q(n n2, ConcurrentHashMap<j, l> concurrentHashMap, l l2) {
        this.d = n2;
        this.k = concurrentHashMap;
        this.l = l2;
    }

    public static q c() {
        q.r();
        return a.a.a.a.c.a(q.class);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void q() {
        q q2 = this;
        synchronized (q2) {
            SSLSocketFactory sSLSocketFactory = this.n;
            if (sSLSocketFactory != null) return;
            this.n = f.a(new s(this.m()));
            a.a.a.a.c.h().a("Twitter", "Custom SSL pinning enabled");
            return;
        }
    }

    private static void r() {
        if (a.a.a.a.c.a(q.class) != null) {
            return;
        }
        throw new IllegalStateException("Must start Twitter Kit with Fabric.with() first");
    }

    private void s() {
        m.a(this, this.i(), this.j(), this.l());
    }

    private void t() {
        q q2 = this;
        synchronized (q2) {
            if (this.m == null) {
                this.m = new com.twitter.sdk.android.core.e(new OAuth2Service(this, this.f(), new d()), this.b);
            }
            return;
        }
    }

    public l a(u u2) {
        q.r();
        if (!this.k.containsKey((Object)u2)) {
            this.k.putIfAbsent((Object)u2, (Object)new l(u2));
        }
        return (l)this.k.get((Object)u2);
    }

    @Override
    public String a() {
        return "2.3.0.163";
    }

    @Override
    public String b() {
        return "com.twitter.sdk.android:twitter-core";
    }

    @Override
    protected /* synthetic */ Object d() {
        return this.h();
    }

    public n e() {
        return this.d;
    }

    public SSLSocketFactory f() {
        q.r();
        if (this.n == null) {
            this.q();
        }
        return this.n;
    }

    @Override
    protected boolean g() {
        a a2 = new a();
        Context context = this.m();
        String string = this.b();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.b());
        stringBuilder.append(":");
        stringBuilder.append("session_store");
        stringBuilder.append(".xml");
        a2.a(context, string, stringBuilder.toString());
        this.a = new g<u>(new a.a.a.a.a.f.c(this.m(), "session_store"), new u.a(), "active_twittersession", "twittersession");
        this.b = new g<com.twitter.sdk.android.core.d>(new a.a.a.a.a.f.c(this.m(), "session_store"), new d.a(), "active_guestsession", "guestsession");
        this.c = new b<u>(this.a, this.n().e(), new e());
        return true;
    }

    protected Boolean h() {
        this.a.b();
        this.b.b();
        this.f();
        this.j();
        this.s();
        this.c.a(this.n().d());
        return true;
    }

    public k<u> i() {
        q.r();
        return this.a;
    }

    public com.twitter.sdk.android.core.e j() {
        q.r();
        if (this.m == null) {
            this.t();
        }
        return this.m;
    }
}

