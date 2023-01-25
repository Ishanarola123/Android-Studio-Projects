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
import com.twitter.sdk.android.tweetui.n;
import com.twitter.sdk.android.tweetui.o;
import java.util.ArrayList;
import java.util.List;

class p
implements o {
    final n a;

    p(n n2) {
        this.a = n2;
    }

    static c a() {
        return new c.a().a("tfw").b("android").c("video").f("play").a();
    }

    @Override
    public void a(j j2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add((Object)j2);
        this.a.a(p.a(), (List<j>)arrayList);
    }
}

