/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Double
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
import d.b.r;
import d.b.s;
import java.util.List;

public interface StatusesService {
    @e
    @n(a="/1.1/statuses/destroy/{id}.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    public b<com.twitter.sdk.android.core.a.n> destroy(@r(a="id") Long var1, @c(a="trim_user") Boolean var2);

    @f(a="/1.1/statuses/home_timeline.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    public b<List<com.twitter.sdk.android.core.a.n>> homeTimeline(@s(a="count") Integer var1, @s(a="since_id") Long var2, @s(a="max_id") Long var3, @s(a="trim_user") Boolean var4, @s(a="exclude_replies") Boolean var5, @s(a="contributor_details") Boolean var6, @s(a="include_entities") Boolean var7);

    @f(a="/1.1/statuses/lookup.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    public b<List<com.twitter.sdk.android.core.a.n>> lookup(@s(a="id") String var1, @s(a="include_entities") Boolean var2, @s(a="trim_user") Boolean var3, @s(a="map") Boolean var4);

    @f(a="/1.1/statuses/mentions_timeline.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    public b<List<com.twitter.sdk.android.core.a.n>> mentionsTimeline(@s(a="count") Integer var1, @s(a="since_id") Long var2, @s(a="max_id") Long var3, @s(a="trim_user") Boolean var4, @s(a="contributor_details") Boolean var5, @s(a="include_entities") Boolean var6);

    @e
    @n(a="/1.1/statuses/retweet/{id}.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    public b<com.twitter.sdk.android.core.a.n> retweet(@r(a="id") Long var1, @c(a="trim_user") Boolean var2);

    @f(a="/1.1/statuses/retweets_of_me.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    public b<List<com.twitter.sdk.android.core.a.n>> retweetsOfMe(@s(a="count") Integer var1, @s(a="since_id") Long var2, @s(a="max_id") Long var3, @s(a="trim_user") Boolean var4, @s(a="include_entities") Boolean var5, @s(a="include_user_entities") Boolean var6);

    @f(a="/1.1/statuses/show.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    public b<com.twitter.sdk.android.core.a.n> show(@s(a="id") Long var1, @s(a="trim_user") Boolean var2, @s(a="include_my_retweet") Boolean var3, @s(a="include_entities") Boolean var4);

    @e
    @n(a="/1.1/statuses/unretweet/{id}.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    public b<com.twitter.sdk.android.core.a.n> unretweet(@r(a="id") Long var1, @c(a="trim_user") Boolean var2);

    @e
    @n(a="/1.1/statuses/update.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    public b<com.twitter.sdk.android.core.a.n> update(@c(a="status") String var1, @c(a="in_reply_to_status_id") Long var2, @c(a="possibly_sensitive") Boolean var3, @c(a="lat") Double var4, @c(a="long") Double var5, @c(a="place_id") String var6, @c(a="display_cooridnates") Boolean var7, @c(a="trim_user") Boolean var8, @c(a="media_ids") String var9);

    @f(a="/1.1/statuses/user_timeline.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    public b<List<com.twitter.sdk.android.core.a.n>> userTimeline(@s(a="user_id") Long var1, @s(a="screen_name") String var2, @s(a="count") Integer var3, @s(a="since_id") Long var4, @s(a="max_id") Long var5, @s(a="trim_user") Boolean var6, @s(a="exclude_replies") Boolean var7, @s(a="contributor_details") Boolean var8, @s(a="include_rts") Boolean var9);
}

