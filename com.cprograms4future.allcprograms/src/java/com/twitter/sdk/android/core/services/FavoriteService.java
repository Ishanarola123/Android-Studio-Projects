/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package com.twitter.sdk.android.core.services;

import d.b;
import d.b.c;
import d.b.e;
import d.b.f;
import d.b.n;
import d.b.s;
import java.util.List;

public interface FavoriteService {
    @e
    @n(a="/1.1/favorites/create.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    public b<com.twitter.sdk.android.core.a.n> create(@c(a="id") Long var1, @c(a="include_entities") Boolean var2);

    @e
    @n(a="/1.1/favorites/destroy.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    public b<com.twitter.sdk.android.core.a.n> destroy(@c(a="id") Long var1, @c(a="include_entities") Boolean var2);

    @f(a="/1.1/favorites/list.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    public b<List<com.twitter.sdk.android.core.a.n>> list(@s(a="user_id") Long var1, @s(a="screen_name") String var2, @s(a="count") Integer var3, @s(a="since_id") String var4, @s(a="max_id") String var5, @s(a="include_entities") Boolean var6);
}

