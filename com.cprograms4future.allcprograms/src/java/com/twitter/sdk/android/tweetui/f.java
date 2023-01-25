/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.twitter.sdk.android.tweetui;

import a.a.a.a.l;
import com.twitter.sdk.android.core.c;
import com.twitter.sdk.android.core.r;

abstract class f<T>
extends c<T> {
    private final c a;
    private final l b;

    f(c c2, l l2) {
        this.a = c2;
        this.b = l2;
    }

    @Override
    public void a(r r2) {
        this.b.d("TweetUi", r2.getMessage(), (Throwable)((Object)r2));
        if (this.a != null) {
            this.a.a(r2);
        }
    }
}

