/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
package com.twitter.sdk.android.tweetcomposer;

import com.twitter.sdk.android.core.internal.scribe.c;
import com.twitter.sdk.android.core.internal.scribe.j;
import com.twitter.sdk.android.tweetcomposer.b;
import com.twitter.sdk.android.tweetcomposer.g;
import com.twitter.sdk.android.tweetcomposer.l;
import com.twitter.sdk.android.tweetcomposer.n;
import java.util.ArrayList;
import java.util.List;

class h
implements g {
    private final l a;

    h(l l2) {
        if (l2 != null) {
            this.a = l2;
            return;
        }
        throw new NullPointerException("scribeClient must not be null");
    }

    @Override
    public void a(b b2) {
        c c2 = n.a.d("").e("").f("impression").a();
        ArrayList arrayList = new ArrayList();
        arrayList.add((Object)n.a(b2));
        this.a.a(c2, (List<j>)arrayList);
    }

    @Override
    public void a(b b2, String string) {
        c c2 = n.a.d("").e(string).f("click").a();
        ArrayList arrayList = new ArrayList();
        arrayList.add((Object)n.a(b2));
        this.a.a(c2, (List<j>)arrayList);
    }
}

