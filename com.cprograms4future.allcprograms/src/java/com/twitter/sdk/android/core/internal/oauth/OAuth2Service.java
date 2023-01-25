/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  javax.net.ssl.SSLSocketFactory
 */
package com.twitter.sdk.android.core.internal.oauth;

import a.a.a.a.a.e.d;
import a.a.a.a.a.e.j;
import com.twitter.sdk.android.core.c;
import com.twitter.sdk.android.core.i;
import com.twitter.sdk.android.core.internal.d;
import com.twitter.sdk.android.core.internal.oauth.a;
import com.twitter.sdk.android.core.internal.oauth.b;
import com.twitter.sdk.android.core.internal.oauth.e;
import com.twitter.sdk.android.core.internal.oauth.g;
import com.twitter.sdk.android.core.n;
import com.twitter.sdk.android.core.q;
import com.twitter.sdk.android.core.r;
import d.l;
import d.m;
import javax.net.ssl.SSLSocketFactory;

public class OAuth2Service
extends g {
    OAuth2Api a = this.f().a(OAuth2Api.class);

    public OAuth2Service(q q2, SSLSocketFactory sSLSocketFactory, d d2) {
        super(q2, sSLSocketFactory, d2);
    }

    private String a() {
        n n2 = this.c().e();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Basic ");
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(j.c(n2.a()));
        stringBuilder2.append(":");
        stringBuilder2.append(j.c(n2.b()));
        stringBuilder.append(d.a.a(stringBuilder2.toString()));
        return stringBuilder.toString();
    }

    private String a(e e2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Bearer ");
        stringBuilder.append(e2.d());
        return stringBuilder.toString();
    }

    public void a(final c<a> c2) {
        this.b(new c<e>(){

            @Override
            public void a(i<e> i2) {
                final e e2 = (e)i2.a;
                c<b> c22 = new c<b>(){

                    @Override
                    public void a(i<b> i2) {
                        a a2 = new a(e2.c(), e2.d(), ((b)i2.a).a);
                        c2.a(new i<a>(a2, null));
                    }

                    @Override
                    public void a(r r2) {
                        a.a.a.a.c.h().d("Twitter", "Your app may not allow guest auth. Please talk to us regarding upgrading your consumer key.", (Throwable)((Object)r2));
                        c2.a(r2);
                    }
                };
                OAuth2Service.this.a(c22, e2);
            }

            @Override
            public void a(r r2) {
                a.a.a.a.c.h().d("Twitter", "Failed to get app auth token", (Throwable)((Object)r2));
                if (c2 != null) {
                    c2.a(r2);
                }
            }

        });
    }

    void a(c<b> c2, e e2) {
        this.a.getGuestToken(this.a(e2)).a(c2);
    }

    void b(c<e> c2) {
        this.a.getAppAuthToken(this.a(), "client_credentials").a(c2);
    }

}

