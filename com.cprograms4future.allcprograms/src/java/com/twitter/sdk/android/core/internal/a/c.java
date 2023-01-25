/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package com.twitter.sdk.android.core.internal.a;

import b.ab;
import b.ad;
import b.b;
import b.r;
import b.z;
import com.twitter.sdk.android.core.d;
import com.twitter.sdk.android.core.e;
import com.twitter.sdk.android.core.internal.a.a;
import java.io.IOException;

public class c
implements b {
    final e a;

    public c(e e2) {
        this.a = e2;
    }

    z a(ab ab2) {
        com.twitter.sdk.android.core.internal.oauth.a a2;
        d d2;
        if (this.c(ab2) && (a2 = (d2 = this.a.a(this.b(ab2))) == null ? null : (com.twitter.sdk.android.core.internal.oauth.a)d2.a()) != null) {
            return this.a(ab2.a(), a2);
        }
        return null;
    }

    @Override
    public z a(ad ad2, ab ab2) throws IOException {
        return this.a(ab2);
    }

    z a(z z2, com.twitter.sdk.android.core.internal.oauth.a a2) {
        z.a a3 = z2.e();
        a.a(a3, a2);
        return a3.a();
    }

    d b(ab ab2) {
        r r2 = ab2.a().c();
        String string = r2.a("Authorization");
        String string2 = r2.a("x-guest-token");
        if (string != null && string2 != null) {
            return new d(new com.twitter.sdk.android.core.internal.oauth.a("bearer", string.replace((CharSequence)"bearer ", (CharSequence)""), string2));
        }
        return null;
    }

    boolean c(ab ab2) {
        int n2 = 1;
        while ((ab2 = ab2.h()) != null) {
            ++n2;
        }
        return n2 < 2;
    }
}

