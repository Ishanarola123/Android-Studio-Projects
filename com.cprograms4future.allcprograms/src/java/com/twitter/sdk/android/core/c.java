/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.twitter.sdk.android.core;

import com.twitter.sdk.android.core.i;
import com.twitter.sdk.android.core.m;
import com.twitter.sdk.android.core.r;
import d.b;
import d.d;
import d.l;

public abstract class c<T>
implements d<T> {
    public abstract void a(i<T> var1);

    public abstract void a(r var1);

    @Override
    public final void a(b<T> b2, l<T> l2) {
        if (l2.c()) {
            this.a(new i<T>(l2.d(), l2));
            return;
        }
        this.a(new m(l2));
    }

    @Override
    public final void a(b<T> b2, Throwable throwable) {
        this.a(new r("Request Failure", throwable));
    }
}

