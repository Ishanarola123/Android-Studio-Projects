/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.twitter.sdk.android.core.internal.a.a
 *  com.twitter.sdk.android.core.internal.a.b
 *  com.twitter.sdk.android.core.internal.a.c
 *  com.twitter.sdk.android.core.internal.a.d
 *  com.twitter.sdk.android.core.p
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  javax.net.ssl.SSLSocketFactory
 */
package com.twitter.sdk.android.core.internal.a;

import b.t;
import b.w;
import com.twitter.sdk.android.core.internal.a.a;
import com.twitter.sdk.android.core.internal.a.b;
import com.twitter.sdk.android.core.internal.a.c;
import com.twitter.sdk.android.core.internal.a.d;
import com.twitter.sdk.android.core.j;
import com.twitter.sdk.android.core.n;
import com.twitter.sdk.android.core.p;
import javax.net.ssl.SSLSocketFactory;

public class e {
    static w.a a(w.a a2, com.twitter.sdk.android.core.e e2, SSLSocketFactory sSLSocketFactory) {
        return a2.a(sSLSocketFactory).a((b.b)new c(e2)).a((t)new a(e2)).b((t)new b());
    }

    static w.a a(w.a a2, j<? extends p> j2, n n2, SSLSocketFactory sSLSocketFactory) {
        return a2.a(sSLSocketFactory).a((t)new d(j2, n2));
    }

    public static w a(com.twitter.sdk.android.core.e e2, SSLSocketFactory sSLSocketFactory) {
        return e.b(e2, sSLSocketFactory).a();
    }

    public static w a(j<? extends p> j2, n n2, SSLSocketFactory sSLSocketFactory) {
        return e.b(j2, n2, sSLSocketFactory).a();
    }

    public static w.a b(com.twitter.sdk.android.core.e e2, SSLSocketFactory sSLSocketFactory) {
        return e.a(new Object(){
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
        }, e2, sSLSocketFactory);
    }

    public static w.a b(j<? extends p> j2, n n2, SSLSocketFactory sSLSocketFactory) {
        if (j2 != null) {
            return e.a(new /* invalid duplicate definition of identical inner class */, j2, n2, sSLSocketFactory);
        }
        throw new IllegalArgumentException("Session must not be null.");
    }
}

