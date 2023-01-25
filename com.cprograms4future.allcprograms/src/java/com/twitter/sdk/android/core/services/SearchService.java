/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 */
package com.twitter.sdk.android.core.services;

import com.twitter.sdk.android.core.services.a.a;
import d.b;
import d.b.f;
import d.b.s;

public interface SearchService {
    @f(a="/1.1/search/tweets.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    public b<Object> tweets(@s(a="q") String var1, @s(a="geocode", b=true) a var2, @s(a="lang") String var3, @s(a="locale") String var4, @s(a="result_type") String var5, @s(a="count") Integer var6, @s(a="until") String var7, @s(a="since_id") Long var8, @s(a="max_id") Long var9, @s(a="include_entities") Boolean var10);
}

