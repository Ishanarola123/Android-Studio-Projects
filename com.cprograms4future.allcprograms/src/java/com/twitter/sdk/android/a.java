/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.twitter.sdk.android.core.q
 *  com.twitter.sdk.android.tweetcomposer.o
 *  com.twitter.sdk.android.tweetui.n
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 */
package com.twitter.sdk.android;

import a.a.a.a.i;
import a.a.a.a.j;
import com.twitter.sdk.android.core.q;
import com.twitter.sdk.android.tweetcomposer.o;
import com.twitter.sdk.android.tweetui.n;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class a
extends i
implements j {
    public final q a;
    public final n b;
    public final o c;
    public final Collection<? extends i> d;

    public a(com.twitter.sdk.android.core.n n2) {
        this.a = new q(n2);
        this.b = new n();
        this.c = new o();
        Object[] arrobject = new i[]{this.a, this.b, this.c};
        this.d = Collections.unmodifiableCollection((Collection)Arrays.asList((Object[])arrobject));
    }

    @Override
    public String a() {
        return "2.3.0.163";
    }

    @Override
    public String b() {
        return "com.twitter.sdk.android:twitter";
    }

    @Override
    public Collection<? extends i> c() {
        return this.d;
    }

    protected Object d() {
        return null;
    }
}

