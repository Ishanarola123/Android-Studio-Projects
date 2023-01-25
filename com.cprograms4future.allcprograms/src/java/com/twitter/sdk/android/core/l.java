/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.twitter.sdk.android.core.a.d
 *  com.twitter.sdk.android.core.a.l
 *  com.twitter.sdk.android.core.a.m
 *  com.twitter.sdk.android.core.p
 *  com.twitter.sdk.android.core.q
 *  com.twitter.sdk.android.core.u
 *  d.a.a.a
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Type
 *  java.util.concurrent.ConcurrentHashMap
 *  javax.net.ssl.SSLSocketFactory
 */
package com.twitter.sdk.android.core;

import b.w;
import com.google.a.f;
import com.google.a.g;
import com.google.a.x;
import com.twitter.sdk.android.core.a.c;
import com.twitter.sdk.android.core.a.d;
import com.twitter.sdk.android.core.a.m;
import com.twitter.sdk.android.core.internal.a.e;
import com.twitter.sdk.android.core.j;
import com.twitter.sdk.android.core.n;
import com.twitter.sdk.android.core.p;
import com.twitter.sdk.android.core.q;
import com.twitter.sdk.android.core.services.AccountService;
import com.twitter.sdk.android.core.services.FavoriteService;
import com.twitter.sdk.android.core.services.MediaService;
import com.twitter.sdk.android.core.u;
import d.a.a.a;
import d.e;
import d.m;
import java.lang.reflect.Type;
import java.util.concurrent.ConcurrentHashMap;
import javax.net.ssl.SSLSocketFactory;

public class l {
    final ConcurrentHashMap<Class, Object> a = this.e();
    final d.m b;

    public l() {
        this(e.a(q.c().j(), q.c().f()), new com.twitter.sdk.android.core.internal.d());
    }

    l(w w2, com.twitter.sdk.android.core.internal.d d2) {
        this.b = this.a(w2, d2);
    }

    public l(u u2) {
        this(e.a((j<? extends p>)u2, q.c().e(), q.c().f()), new com.twitter.sdk.android.core.internal.d());
    }

    private d.m a(w w2, com.twitter.sdk.android.core.internal.d d2) {
        return new m.a().a(w2).a(d2.a()).a((e.a)a.a((f)this.d())).a();
    }

    private f d() {
        return new g().a((x)new com.twitter.sdk.android.core.a.l()).a((x)new m()).a((Type)c.class, (Object)new d()).a();
    }

    private ConcurrentHashMap e() {
        return new ConcurrentHashMap();
    }

    public AccountService a() {
        return this.a(AccountService.class);
    }

    protected <T> T a(Class<T> class_) {
        if (!this.a.contains(class_)) {
            this.a.putIfAbsent(class_, this.b.a(class_));
        }
        return (T)this.a.get(class_);
    }

    public FavoriteService b() {
        return this.a(FavoriteService.class);
    }

    public MediaService c() {
        return this.a(MediaService.class);
    }
}

