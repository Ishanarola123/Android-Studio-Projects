/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 */
package com.twitter.sdk.android.core.internal;

import com.twitter.sdk.android.core.a.r;
import com.twitter.sdk.android.core.internal.scribe.c;
import com.twitter.sdk.android.core.internal.scribe.m;
import com.twitter.sdk.android.core.j;
import com.twitter.sdk.android.core.l;
import com.twitter.sdk.android.core.services.AccountService;
import com.twitter.sdk.android.core.u;
import d.b;
import java.io.IOException;

public class e
implements com.twitter.sdk.android.core.internal.c<u> {
    private final a a = new Object(){

        public AccountService a(u u2) {
            return new l(u2).a();
        }
    };
    private final com.twitter.sdk.android.core.internal.scribe.a b = m.a();

    private void a() {
        if (this.b == null) {
            return;
        }
        c c2 = new c.a().a("android").b("credentials").c("").d("").e("").f("impression").a();
        this.b.a(c2);
    }

    @Override
    public void a(u u2) {
        AccountService accountService = this.a.a(u2);
        try {
            this.a();
            accountService.verifyCredentials(true, false).a();
        }
        catch (IOException | RuntimeException throwable) {}
    }

}

