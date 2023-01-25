/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.view.View
 *  android.view.View$OnClickListener
 *  com.twitter.sdk.android.tweetui.m
 *  com.twitter.sdk.android.tweetui.n
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package com.twitter.sdk.android.tweetui;

import a.a.a.a.c;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import com.twitter.sdk.android.core.a.r;
import com.twitter.sdk.android.core.f;
import com.twitter.sdk.android.tweetui.h;
import com.twitter.sdk.android.tweetui.l;
import com.twitter.sdk.android.tweetui.m;
import com.twitter.sdk.android.tweetui.n;

class i
implements View.OnClickListener {
    final com.twitter.sdk.android.core.a.n a;
    final n b;
    final l c;

    i(com.twitter.sdk.android.core.a.n n2, n n3) {
        this(n2, n3, (l)new m(n3));
    }

    i(com.twitter.sdk.android.core.a.n n2, n n3, l l2) {
        this.a = n2;
        this.b = n3;
        this.c = l2;
    }

    Intent a(String string, String string2) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.SUBJECT", string);
        intent.putExtra("android.intent.extra.TEXT", string2);
        intent.setType("text/plain");
        return intent;
    }

    String a(Resources resources) {
        int n2 = h.g.tw__share_content_format;
        Object[] arrobject = new Object[]{this.a.D.d, this.a.i};
        return resources.getString(n2, arrobject);
    }

    void a() {
        this.c.a(this.a);
    }

    void a(Context context, Resources resources) {
        if (this.a != null) {
            if (this.a.D == null) {
                return;
            }
            this.a();
            this.a(Intent.createChooser((Intent)this.a(this.b(resources), this.a(resources)), (CharSequence)resources.getString(h.g.tw__share_tweet)), context);
        }
    }

    void a(Intent intent, Context context) {
        if (!f.b(context, intent)) {
            c.h().d("TweetUi", "Activity cannot be found to handle share intent");
        }
    }

    String b(Resources resources) {
        int n2 = h.g.tw__share_subject_format;
        Object[] arrobject = new Object[]{this.a.D.b, this.a.D.d};
        return resources.getString(n2, arrobject);
    }

    public void onClick(View view) {
        this.a(view.getContext(), view.getResources());
    }
}

