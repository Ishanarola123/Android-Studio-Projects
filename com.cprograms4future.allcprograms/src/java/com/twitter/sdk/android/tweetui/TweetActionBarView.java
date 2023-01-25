/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ImageButton
 *  android.widget.LinearLayout
 *  com.twitter.sdk.android.core.c
 *  com.twitter.sdk.android.tweetui.e
 *  com.twitter.sdk.android.tweetui.n
 *  java.lang.Object
 */
package com.twitter.sdk.android.tweetui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.twitter.sdk.android.core.c;
import com.twitter.sdk.android.tweetui.ToggleImageButton;
import com.twitter.sdk.android.tweetui.e;
import com.twitter.sdk.android.tweetui.h;
import com.twitter.sdk.android.tweetui.i;
import com.twitter.sdk.android.tweetui.n;

public class TweetActionBarView
extends LinearLayout {
    final a a;
    ToggleImageButton b;
    ImageButton c;
    c<com.twitter.sdk.android.core.a.n> d;

    public TweetActionBarView(Context context) {
        this(context, null, new a());
    }

    public TweetActionBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, new a());
    }

    TweetActionBarView(Context context, AttributeSet attributeSet, a a2) {
        super(context, attributeSet);
        this.a = a2;
    }

    void a() {
        this.b = (ToggleImageButton)this.findViewById(h.e.tw__tweet_like_button);
        this.c = (ImageButton)this.findViewById(h.e.tw__tweet_share_button);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.a();
    }

    void setLike(com.twitter.sdk.android.core.a.n n2) {
        n n3 = this.a.a();
        if (n2 != null) {
            this.b.setToggledOn(n2.g);
            e e2 = new e(n2, n3, this.d);
            this.b.setOnClickListener((View.OnClickListener)e2);
        }
    }

    void setOnActionCallback(c<com.twitter.sdk.android.core.a.n> c2) {
        this.d = c2;
    }

    void setShare(com.twitter.sdk.android.core.a.n n2) {
        n n3 = this.a.a();
        if (n2 != null) {
            this.c.setOnClickListener((View.OnClickListener)new i(n2, n3));
        }
    }

    void setTweet(com.twitter.sdk.android.core.a.n n2) {
        this.setLike(n2);
        this.setShare(n2);
    }

    static class a {
        a() {
        }

        n a() {
            return n.c();
        }
    }

}

