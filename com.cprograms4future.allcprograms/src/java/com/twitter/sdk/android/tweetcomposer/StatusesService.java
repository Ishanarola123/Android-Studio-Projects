/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.twitter.sdk.android.tweetcomposer;

import d.b;
import d.b.c;
import d.b.e;
import d.b.n;

public interface StatusesService {
    @e
    @n(a="/1.1/statuses/update.json")
    public b<com.twitter.sdk.android.core.a.n> update(@c(a="status") String var1, @c(a="card_uri") String var2);
}

