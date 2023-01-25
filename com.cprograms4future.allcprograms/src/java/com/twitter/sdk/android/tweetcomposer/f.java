/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  android.view.View
 *  com.twitter.sdk.android.core.q
 *  com.twitter.sdk.android.core.u
 *  com.twitter.sdk.android.tweetcomposer.f$1
 *  com.twitter.sdk.android.tweetcomposer.f$b
 *  com.twitter.sdk.android.tweetcomposer.h
 *  com.twitter.sdk.android.tweetcomposer.o
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package com.twitter.sdk.android.tweetcomposer;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.twitter.sdk.android.core.a.r;
import com.twitter.sdk.android.core.q;
import com.twitter.sdk.android.core.services.AccountService;
import com.twitter.sdk.android.core.u;
import com.twitter.sdk.android.tweetcomposer.ComposerActivity;
import com.twitter.sdk.android.tweetcomposer.ComposerView;
import com.twitter.sdk.android.tweetcomposer.d;
import com.twitter.sdk.android.tweetcomposer.f;
import com.twitter.sdk.android.tweetcomposer.g;
import com.twitter.sdk.android.tweetcomposer.h;
import com.twitter.sdk.android.tweetcomposer.l;
import com.twitter.sdk.android.tweetcomposer.o;

/*
 * Exception performing whole class analysis.
 */
class f {
    final ComposerView a;
    final u b;
    final com.twitter.sdk.android.tweetcomposer.b c;
    final ComposerActivity.a d;
    final c e;

    f(ComposerView composerView, u u2, com.twitter.sdk.android.tweetcomposer.b b2, String string, ComposerActivity.a a2) {
        this(composerView, u2, b2, string, a2, new c());
    }

    f(ComposerView composerView, u u2, com.twitter.sdk.android.tweetcomposer.b b2, String string, ComposerActivity.a a2, c c2) {
        this.a = composerView;
        this.b = u2;
        this.c = b2;
        this.d = a2;
        this.e = c2;
        composerView.setCallbacks((a)new /* Unavailable Anonymous Inner Class!! */);
        composerView.setTweetText(string);
        this.a();
        this.a(b2);
        c2.c().a(b2);
    }

    static int a(int n2) {
        return 140 - n2;
    }

    static boolean b(int n2) {
        return n2 > 0 && n2 <= 140;
    }

    static boolean c(int n2) {
        return n2 > 140;
    }

    int a(String string) {
        if (TextUtils.isEmpty((CharSequence)string)) {
            return 0;
        }
        return this.e.b().a(string);
    }

    void a() {
        this.e.a(this.b).a().verifyCredentials(false, true).a((d.d<r>)new 1(this));
    }

    void a(com.twitter.sdk.android.tweetcomposer.b b2) {
        if (b2 != null) {
            View view = this.e.a().a(this.a.getContext(), b2);
            this.a.setCardView(view);
        }
    }

    public static interface a {
        public void a();

        public void a(String var1);

        public void b(String var1);
    }

    static class c {
        final d a = new d();
        final com.twitter.d b = new com.twitter.d();

        c() {
        }

        com.twitter.sdk.android.core.l a(u u2) {
            return q.c().a(u2);
        }

        d a() {
            return this.a;
        }

        com.twitter.d b() {
            return this.b;
        }

        g c() {
            return new h(o.e().f());
        }
    }

}

