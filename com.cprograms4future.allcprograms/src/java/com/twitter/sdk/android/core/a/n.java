/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package com.twitter.sdk.android.core.a;

import com.google.a.a.c;
import com.twitter.sdk.android.core.a.e;
import com.twitter.sdk.android.core.a.f;
import com.twitter.sdk.android.core.a.k;
import com.twitter.sdk.android.core.a.p;
import com.twitter.sdk.android.core.a.r;
import java.util.List;

public class n {
    @c(a="text", b={"full_text"})
    public final String A;
    @c(a="display_text_range")
    public final List<Integer> B;
    @c(a="truncated")
    public final boolean C;
    @c(a="user")
    public final r D;
    @c(a="withheld_copyright")
    public final boolean E;
    @c(a="withheld_in_countries")
    public final List<String> F;
    @c(a="withheld_scope")
    public final String G;
    @c(a="card")
    public final e H;
    @c(a="coordinates")
    public final f a;
    @c(a="created_at")
    public final String b;
    @c(a="current_user_retweet")
    public final Object c;
    @c(a="entities")
    public final p d;
    @c(a="extended_entities")
    public final p e;
    @c(a="favorite_count")
    public final Integer f;
    @c(a="favorited")
    public final boolean g;
    @c(a="filter_level")
    public final String h;
    @c(a="id")
    public final long i;
    @c(a="id_str")
    public final String j;
    @c(a="in_reply_to_screen_name")
    public final String k;
    @c(a="in_reply_to_status_id")
    public final long l;
    @c(a="in_reply_to_status_id_str")
    public final String m;
    @c(a="in_reply_to_user_id")
    public final long n;
    @c(a="in_reply_to_user_id_str")
    public final String o;
    @c(a="lang")
    public final String p;
    @c(a="place")
    public final k q;
    @c(a="possibly_sensitive")
    public final boolean r;
    @c(a="scopes")
    public final Object s;
    @c(a="quoted_status_id")
    public final long t;
    @c(a="quoted_status_id_str")
    public final String u;
    @c(a="quoted_status")
    public final n v;
    @c(a="retweet_count")
    public final int w;
    @c(a="retweeted")
    public final boolean x;
    @c(a="retweeted_status")
    public final n y;
    @c(a="source")
    public final String z;

    public n(f f2, String string, Object object, p p2, p p3, Integer n2, boolean bl, String string2, long l2, String string3, String string4, long l3, String string5, long l4, String string6, String string7, k k2, boolean bl2, Object object2, long l5, String string8, n n3, int n4, boolean bl3, n n5, String string9, String string10, List<Integer> list, boolean bl4, r r2, boolean bl5, List<String> list2, String string11, e e2) {
        this.a = f2;
        this.b = string;
        this.c = object;
        this.d = p2;
        this.e = p3;
        this.f = n2;
        this.g = bl;
        this.h = string2;
        this.i = l2;
        this.j = string3;
        this.k = string4;
        this.l = l3;
        this.m = string5;
        this.n = l4;
        this.o = string6;
        this.p = string7;
        this.q = k2;
        this.r = bl2;
        this.s = object2;
        this.t = l5;
        this.u = string8;
        this.v = n3;
        this.w = n4;
        this.x = bl3;
        this.y = n5;
        this.z = string9;
        this.A = string10;
        this.B = list;
        this.C = bl4;
        this.D = r2;
        this.E = bl5;
        this.F = list2;
        this.G = string11;
        this.H = e2;
    }

    public long a() {
        return this.i;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (!(object instanceof n)) {
            return false;
        }
        n n2 = (n)object;
        long l2 = this.i LCMP n2.i;
        boolean bl = false;
        if (l2 == false) {
            bl = true;
        }
        return bl;
    }

    public int hashCode() {
        return (int)this.i;
    }
}

