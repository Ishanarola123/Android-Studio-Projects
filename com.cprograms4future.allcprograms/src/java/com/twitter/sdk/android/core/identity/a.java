/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Intent
 *  com.twitter.sdk.android.core.c
 *  com.twitter.sdk.android.core.o
 *  com.twitter.sdk.android.core.p
 *  com.twitter.sdk.android.core.u
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 */
package com.twitter.sdk.android.core.identity;

import android.app.Activity;
import android.content.Intent;
import com.twitter.sdk.android.core.c;
import com.twitter.sdk.android.core.i;
import com.twitter.sdk.android.core.n;
import com.twitter.sdk.android.core.o;
import com.twitter.sdk.android.core.p;
import com.twitter.sdk.android.core.r;
import com.twitter.sdk.android.core.u;
import d.l;
import java.io.Serializable;

public abstract class a {
    protected final int a;
    private final n b;
    private final c<u> c;

    a(n n2, c<u> c2, int n3) {
        this.b = n2;
        this.c = c2;
        this.a = n3;
    }

    n a() {
        return this.b;
    }

    public boolean a(int n2, int n3, Intent intent) {
        if (this.a != n2) {
            return false;
        }
        c<u> c2 = this.b();
        if (c2 != null) {
            if (n3 == -1) {
                String string = intent.getStringExtra("tk");
                String string2 = intent.getStringExtra("ts");
                String string3 = intent.getStringExtra("screen_name");
                long l2 = intent.getLongExtra("user_id", 0L);
                c2.a(new i<u>(new u(new p(string, string2), l2, string3), null));
            } else {
                o o2 = intent != null && intent.hasExtra("auth_error") ? (o)intent.getSerializableExtra("auth_error") : new o("Authorize failed.");
                c2.a((r)o2);
            }
        }
        return true;
    }

    public abstract boolean a(Activity var1);

    c<u> b() {
        return this.c;
    }
}

