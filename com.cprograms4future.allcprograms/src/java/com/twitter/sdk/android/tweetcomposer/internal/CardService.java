/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.twitter.sdk.android.tweetcomposer.internal;

import com.twitter.sdk.android.tweetcomposer.internal.a;
import com.twitter.sdk.android.tweetcomposer.internal.b;
import d.b.c;
import d.b.e;
import d.b.n;

public interface CardService {
    @e
    @n(a="https://caps.twitter.com/v2/cards/create.json")
    public d.b<a> create(@c(a="card_data") b var1);
}

