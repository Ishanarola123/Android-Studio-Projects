/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.twitter.sdk.android.core.internal.a;

import b.ab;
import b.t;
import b.z;
import com.twitter.sdk.android.core.d;
import com.twitter.sdk.android.core.e;
import java.io.IOException;

public class a
implements t {
    final e a;

    public a(e e2) {
        this.a = e2;
    }

    static void a(z.a a2, com.twitter.sdk.android.core.internal.oauth.a a3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a3.c());
        stringBuilder.append(" ");
        stringBuilder.append(a3.d());
        a2.a("Authorization", stringBuilder.toString());
        a2.a("x-guest-token", a3.a());
    }

    @Override
    public ab a(t.a a2) throws IOException {
        z z2 = a2.a();
        d d2 = this.a.a();
        com.twitter.sdk.android.core.internal.oauth.a a3 = d2 == null ? null : (com.twitter.sdk.android.core.internal.oauth.a)d2.a();
        if (a3 != null) {
            z.a a4 = z2.e();
            a.a(a4, a3);
            return a2.a(a4.a());
        }
        return a2.a(z2);
    }
}

