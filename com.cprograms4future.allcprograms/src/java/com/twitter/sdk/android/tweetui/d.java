/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
package com.twitter.sdk.android.tweetui;

import com.twitter.sdk.android.core.internal.scribe.c;
import com.twitter.sdk.android.core.internal.scribe.j;
import com.twitter.sdk.android.tweetui.c;
import com.twitter.sdk.android.tweetui.n;
import java.util.ArrayList;
import java.util.List;

public class d
implements c {
    final n a;

    public d(n n2) {
        this.a = n2;
    }

    static com.twitter.sdk.android.core.internal.scribe.c d() {
        return new c.a().a("tfw").b("android").c("gallery").f("impression").a();
    }

    static com.twitter.sdk.android.core.internal.scribe.c e() {
        return new c.a().a("tfw").b("android").c("gallery").f("show").a();
    }

    static com.twitter.sdk.android.core.internal.scribe.c f() {
        return new c.a().a("tfw").b("android").c("gallery").f("navigate").a();
    }

    static com.twitter.sdk.android.core.internal.scribe.c g() {
        return new c.a().a("tfw").b("android").c("gallery").f("dismiss").a();
    }

    @Override
    public void a() {
        n n2 = this.a;
        com.twitter.sdk.android.core.internal.scribe.c[] arrc = new com.twitter.sdk.android.core.internal.scribe.c[]{d.e()};
        n2.a(arrc);
    }

    @Override
    public void a(j j2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add((Object)j2);
        this.a.a(d.d(), (List<j>)arrayList);
    }

    @Override
    public void b() {
        n n2 = this.a;
        com.twitter.sdk.android.core.internal.scribe.c[] arrc = new com.twitter.sdk.android.core.internal.scribe.c[]{d.f()};
        n2.a(arrc);
    }

    @Override
    public void c() {
        n n2 = this.a;
        com.twitter.sdk.android.core.internal.scribe.c[] arrc = new com.twitter.sdk.android.core.internal.scribe.c[]{d.g()};
        n2.a(arrc);
    }
}

