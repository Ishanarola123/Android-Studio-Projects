/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.os.Bundle
 *  android.support.v4.view.ViewPager
 *  android.support.v4.view.ViewPager$f
 *  android.support.v4.view.q
 *  android.view.View
 *  com.twitter.sdk.android.core.a.j
 *  com.twitter.sdk.android.tweetui.GalleryActivity$1
 *  com.twitter.sdk.android.tweetui.GalleryActivity$2
 *  com.twitter.sdk.android.tweetui.b
 *  com.twitter.sdk.android.tweetui.d
 *  com.twitter.sdk.android.tweetui.n
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collections
 *  java.util.List
 */
package com.twitter.sdk.android.tweetui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.q;
import android.view.View;
import com.twitter.sdk.android.core.a.j;
import com.twitter.sdk.android.tweetui.GalleryActivity;
import com.twitter.sdk.android.tweetui.b;
import com.twitter.sdk.android.tweetui.c;
import com.twitter.sdk.android.tweetui.d;
import com.twitter.sdk.android.tweetui.h;
import com.twitter.sdk.android.tweetui.internal.f;
import com.twitter.sdk.android.tweetui.n;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class GalleryActivity
extends Activity {
    a a;
    final c b = new d(n.c());

    ViewPager.f a() {
        return new 1(this);
    }

    void a(int n2) {
        j j2 = (j)this.a.c.get(n2);
        com.twitter.sdk.android.core.internal.scribe.j j3 = com.twitter.sdk.android.core.internal.scribe.j.a(this.a.a, j2);
        this.b.a(j3);
    }

    f.a b() {
        return new 2(this);
    }

    a c() {
        j j2 = (j)this.getIntent().getSerializableExtra("MEDIA_ENTITY");
        if (j2 != null) {
            return new a(0, (List<j>)Collections.singletonList((Object)j2));
        }
        return (a)this.getIntent().getSerializableExtra("GALLERY_ITEM");
    }

    void d() {
        this.b.a();
    }

    void e() {
        this.b.c();
    }

    void f() {
        this.b.b();
    }

    public void onBackPressed() {
        this.e();
        super.onBackPressed();
        this.overridePendingTransition(0, h.a.tw__slide_out);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(h.f.tw__gallery_activity);
        this.a = this.c();
        if (bundle == null) {
            this.d();
        }
        b b2 = new b((Context)this, this.b());
        b2.a(this.a.c);
        ViewPager viewPager = (ViewPager)this.findViewById(h.e.tw__view_pager);
        viewPager.setPageMargin(this.getResources().getDimensionPixelSize(h.c.tw__gallery_page_margin));
        viewPager.a(this.a());
        viewPager.setAdapter((q)b2);
        viewPager.setCurrentItem(this.a.b);
    }

    public static class a
    implements Serializable {
        public final long a;
        public final int b;
        public final List<j> c;

        public a(int n2, List<j> list) {
            this(0L, n2, list);
        }

        public a(long l2, int n2, List<j> list) {
            this.a = l2;
            this.b = n2;
            this.c = list;
        }
    }

}

