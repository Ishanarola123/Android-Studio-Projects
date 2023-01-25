/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.support.v4.view.q
 *  android.view.View
 *  android.view.ViewGroup
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 */
package com.twitter.sdk.android.tweetui;

import android.content.Context;
import android.support.v4.view.q;
import android.view.View;
import android.view.ViewGroup;
import com.a.a.ac;
import com.a.a.t;
import com.a.a.x;
import com.twitter.sdk.android.core.a.j;
import com.twitter.sdk.android.tweetui.internal.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class b
extends q {
    final List<j> a = new ArrayList();
    final Context b;
    final f.a c;

    b(Context context, f.a a2) {
        this.b = context;
        this.c = a2;
    }

    public int a() {
        return this.a.size();
    }

    public Object a(ViewGroup viewGroup, int n2) {
        com.twitter.sdk.android.tweetui.internal.b b2 = new com.twitter.sdk.android.tweetui.internal.b(this.b);
        b2.setSwipeToDismissCallback(this.c);
        viewGroup.addView((View)b2);
        j j2 = (j)this.a.get(n2);
        t.a(this.b).a(j2.b).a(b2);
        return b2;
    }

    public void a(ViewGroup viewGroup, int n2, Object object) {
        viewGroup.removeView((View)object);
    }

    void a(List<j> list) {
        this.a.addAll(list);
        this.c();
    }

    public boolean a(View view, Object object) {
        return view == object;
    }
}

