/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Locale
 *  java.util.Map
 */
package com.twitter.sdk.android.core.internal.a;

import b.aa;
import b.ab;
import b.s;
import b.t;
import b.z;
import com.twitter.sdk.android.core.internal.oauth.c;
import com.twitter.sdk.android.core.j;
import com.twitter.sdk.android.core.n;
import com.twitter.sdk.android.core.p;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class d
implements t {
    final j<? extends p> a;
    final n b;

    public d(j<? extends p> j2, n n2) {
        this.a = j2;
        this.b = n2;
    }

    @Override
    public ab a(t.a a2) throws IOException {
        z z2 = a2.a();
        z z3 = z2.e().a(this.a(z2.a())).a();
        return a2.a(z3.e().a("Authorization", this.a(z3)).a());
    }

    s a(s s2) {
        s.a a2 = s2.o().c(null);
        int n2 = s2.m();
        for (int i2 = 0; i2 < n2; ++i2) {
            a2.b(a.a.a.a.a.e.j.c(s2.a(i2)), a.a.a.a.a.e.j.c(s2.b(i2)));
        }
        return a2.c();
    }

    String a(z z2) throws IOException {
        return new c().a(this.b, this.a.a(), null, z2.b(), z2.a().toString(), this.b(z2));
    }

    Map<String, String> b(z z2) throws IOException {
        aa aa2;
        HashMap hashMap = new HashMap();
        if ("POST".equals((Object)z2.b().toUpperCase(Locale.US)) && (aa2 = z2.d()) instanceof b.p) {
            b.p p2 = (b.p)aa2;
            for (int i2 = 0; i2 < p2.a(); ++i2) {
                hashMap.put((Object)p2.a(i2), (Object)p2.c(i2));
            }
        }
        return hashMap;
    }
}

