/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.twitter.sdk.android.tweetcomposer;

import com.twitter.sdk.android.tweetcomposer.b;
import com.twitter.sdk.android.tweetcomposer.internal.b;

class c {
    static com.twitter.sdk.android.tweetcomposer.internal.b a(b b2, Long l2, String string) {
        return new b.a().a("promo_image_app").b(c.a(l2)).f(b2.e).g(b2.d).h(b2.f).c("{}").d("open").e(string).a();
    }

    static String a(Long l2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("media://");
        stringBuilder.append(Long.toString((long)l2));
        return stringBuilder.toString();
    }
}

