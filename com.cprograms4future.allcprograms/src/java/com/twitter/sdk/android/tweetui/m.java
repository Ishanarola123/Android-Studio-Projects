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
import com.twitter.sdk.android.tweetui.l;
import com.twitter.sdk.android.tweetui.n;
import java.util.ArrayList;
import java.util.List;

class m
implements l {
    final n a;

    m(n n2) {
        this.a = n2;
    }

    static c a() {
        return new c.a().a("tfw").b("android").c("tweet").e("actions").f("unfavorite").a();
    }

    static c b() {
        return new c.a().a("tfw").b("android").c("tweet").e("actions").f("favorite").a();
    }

    static c c() {
        return new c.a().a("tfw").b("android").c("tweet").e("actions").f("share").a();
    }

    @Override
    public void a(com.twitter.sdk.android.core.a.n n2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add((Object)j.a(n2));
        this.a.a(m.c(), (List<j>)arrayList);
    }

    @Override
    public void b(com.twitter.sdk.android.core.a.n n2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add((Object)j.a(n2));
        this.a.a(m.b(), (List<j>)arrayList);
    }

    @Override
    public void c(com.twitter.sdk.android.core.a.n n2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add((Object)j.a(n2));
        this.a.a(m.a(), (List<j>)arrayList);
    }
}

