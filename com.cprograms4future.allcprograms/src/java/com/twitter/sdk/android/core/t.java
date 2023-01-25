/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 */
package com.twitter.sdk.android.core;

import b.r;

public class t {
    private int a;
    private int b;
    private long c;

    t(r r2) {
        if (r2 != null) {
            for (int i2 = 0; i2 < r2.a(); ++i2) {
                if ("x-rate-limit-limit".equals((Object)r2.a(i2))) {
                    this.a = Integer.valueOf((String)r2.b(i2));
                    continue;
                }
                if ("x-rate-limit-remaining".equals((Object)r2.a(i2))) {
                    this.b = Integer.valueOf((String)r2.b(i2));
                    continue;
                }
                if (!"x-rate-limit-reset".equals((Object)r2.a(i2))) continue;
                this.c = Long.valueOf((String)r2.b(i2));
            }
            return;
        }
        throw new IllegalArgumentException("headers must not be null");
    }
}

