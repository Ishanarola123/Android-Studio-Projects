/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.System
 */
package com.twitter.sdk.android.core;

import com.google.a.a.c;

public abstract class a {
    @c(a="created_at")
    protected final long a;

    public a() {
        this(System.currentTimeMillis());
    }

    protected a(long l2) {
        this.a = l2;
    }
}

