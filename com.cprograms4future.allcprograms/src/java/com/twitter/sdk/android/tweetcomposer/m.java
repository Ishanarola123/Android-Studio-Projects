/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.List
 */
package com.twitter.sdk.android.tweetcomposer;

import com.twitter.sdk.android.core.internal.scribe.a;
import com.twitter.sdk.android.core.internal.scribe.c;
import com.twitter.sdk.android.core.internal.scribe.j;
import com.twitter.sdk.android.tweetcomposer.l;
import java.util.List;

class m
implements l {
    private final a a;

    public m(a a2) {
        this.a = a2;
    }

    @Override
    public void a(c c2, List<j> list) {
        if (this.a != null) {
            this.a.a(c2, list);
        }
    }
}

