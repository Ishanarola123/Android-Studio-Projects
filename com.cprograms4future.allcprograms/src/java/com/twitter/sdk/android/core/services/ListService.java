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

import com.twitter.sdk.android.core.a.n;
import d.b;
import d.b.f;
import d.b.s;
import java.util.List;

public interface ListService {
    @f(a="/1.1/lists/statuses.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    public b<List<n>> statuses(@s(a="list_id") Long var1, @s(a="slug") String var2, @s(a="owner_screen_name") String var3, @s(a="owner_id") Long var4, @s(a="since_id") Long var5, @s(a="max_id") Long var6, @s(a="count") Integer var7, @s(a="include_entities") Boolean var8, @s(a="include_rts") Boolean var9);
}

