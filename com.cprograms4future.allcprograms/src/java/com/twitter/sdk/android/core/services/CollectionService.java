/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 */
package com.twitter.sdk.android.core.services;

import d.b;
import d.b.f;
import d.b.s;

public interface CollectionService {
    @f(a="/1.1/collections/entries.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    public b<Object> collection(@s(a="id") String var1, @s(a="count") Integer var2, @s(a="max_position") Long var3, @s(a="min_position") Long var4);
}

