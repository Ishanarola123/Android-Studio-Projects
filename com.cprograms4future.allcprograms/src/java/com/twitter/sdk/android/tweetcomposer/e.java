/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 */
package com.twitter.sdk.android.tweetcomposer;

import com.twitter.sdk.android.core.l;
import com.twitter.sdk.android.core.u;
import com.twitter.sdk.android.tweetcomposer.StatusesService;
import com.twitter.sdk.android.tweetcomposer.internal.CardService;

class e
extends l {
    e(u u2) {
        super(u2);
    }

    StatusesService d() {
        return this.a(StatusesService.class);
    }

    CardService e() {
        return this.a(CardService.class);
    }
}

