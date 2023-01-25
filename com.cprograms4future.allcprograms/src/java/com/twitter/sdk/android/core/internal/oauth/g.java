/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.twitter.sdk.android.core.internal.oauth.g$1
 *  com.twitter.sdk.android.core.q
 *  d.a.a.a
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  javax.net.ssl.SSLSocketFactory
 */
package com.twitter.sdk.android.core.internal.oauth;

import b.t;
import b.w;
import com.twitter.sdk.android.core.internal.d;
import com.twitter.sdk.android.core.internal.oauth.g;
import com.twitter.sdk.android.core.q;
import d.a.a.a;
import d.e;
import d.m;
import javax.net.ssl.SSLSocketFactory;

abstract class g {
    private final q a;
    private final d b;
    private final String c;
    private final m d;

    g(q q2, SSLSocketFactory sSLSocketFactory, d d2) {
        this.a = q2;
        this.b = d2;
        this.c = d.a("TwitterAndroidSDK", q2.a());
        if (sSLSocketFactory != null) {
            w w2 = new Object(){
                b.n a = new b.n();
                java.net.Proxy b;
                java.util.List<b.x> c = w.x();
                java.util.List<b.k> d = w.y();
                final java.util.List<t> e = new java.util.ArrayList();
                final java.util.List<t> f = new java.util.ArrayList();
                java.net.ProxySelector g = java.net.ProxySelector.getDefault();
                b.m h = b.m.a;
                b.c i;
                b.a.d j;
                javax.net.SocketFactory k = javax.net.SocketFactory.getDefault();
                SSLSocketFactory l;
                b.a.d.f m;
                javax.net.ssl.HostnameVerifier n = b.a.d.d.a;
                b.g o = b.g.a;
                b.b p = b.b.b;
                b.b q = b.b.b;
                b.j r = new b.j();
                b.o s = b.o.a;
                boolean t = true;
                boolean u = true;
                boolean v = true;
                int w = 10000;
                int x = 10000;
                int y = 10000;

                public w.a a(b.b b2) {
                    if (b2 != null) {
                        this.q = b2;
                        return this;
                    }
                    throw new java.lang.NullPointerException("authenticator == null");
                }

                public w.a a(t t2) {
                    this.e.add((Object)t2);
                    return this;
                }

                public w.a a(SSLSocketFactory sSLSocketFactory) {
                    if (sSLSocketFactory != null) {
                        this.l = sSLSocketFactory;
                        this.m = null;
                        return this;
                    }
                    throw new java.lang.NullPointerException("sslSocketFactory == null");
                }

                public w a() {
                    return new w(this);
                }

                public w.a b(t t2) {
                    this.f.add((Object)t2);
                    return this;
                }
            }.a(sSLSocketFactory).a((t)new 1(this)).a();
            this.d = new m.a().a(this.d().a()).a(w2).a((e.a)a.a()).a();
            return;
        }
        throw new IllegalArgumentException("sslSocketFactory must not be null");
    }

    protected q c() {
        return this.a;
    }

    protected d d() {
        return this.b;
    }

    protected String e() {
        return this.c;
    }

    protected m f() {
        return this.d;
    }
}

