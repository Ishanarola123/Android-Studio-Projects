/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  java.lang.Object
 *  java.lang.String
 */
package com.twitter.sdk.android.tweetcomposer;

import android.content.Context;
import android.view.View;
import com.twitter.sdk.android.tweetcomposer.a;
import com.twitter.sdk.android.tweetcomposer.b;

class d {
    d() {
    }

    View a(Context context, b b2) {
        if (b2.a.equals((Object)"promo_image_app")) {
            a a2 = new a(context);
            a2.setCard(b2);
            return a2;
        }
        return null;
    }
}

