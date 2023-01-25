/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Parcelable
 *  com.twitter.sdk.android.core.c
 *  com.twitter.sdk.android.core.identity.d
 *  com.twitter.sdk.android.core.identity.g
 *  com.twitter.sdk.android.core.identity.j$b
 *  com.twitter.sdk.android.core.internal.scribe.a
 *  com.twitter.sdk.android.core.o
 *  com.twitter.sdk.android.core.q
 *  com.twitter.sdk.android.core.u
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package com.twitter.sdk.android.core.identity;

import a.a.a.a.l;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.twitter.sdk.android.core.c;
import com.twitter.sdk.android.core.identity.ShareEmailActivity;
import com.twitter.sdk.android.core.identity.d;
import com.twitter.sdk.android.core.identity.g;
import com.twitter.sdk.android.core.identity.i;
import com.twitter.sdk.android.core.identity.j;
import com.twitter.sdk.android.core.internal.scribe.c;
import com.twitter.sdk.android.core.internal.scribe.m;
import com.twitter.sdk.android.core.k;
import com.twitter.sdk.android.core.n;
import com.twitter.sdk.android.core.o;
import com.twitter.sdk.android.core.q;
import com.twitter.sdk.android.core.r;
import com.twitter.sdk.android.core.u;

/*
 * Exception performing whole class analysis.
 */
public class j {
    final com.twitter.sdk.android.core.identity.b a;
    final k<u> b;
    private final Context c;
    private final n d;

    public j() {
        this(q.c().m(), q.c().e(), q.c().i(), a.a);
    }

    j(Context context, n n2, k<u> k2, com.twitter.sdk.android.core.identity.b b2) {
        this.a = b2;
        this.c = context;
        this.d = n2;
        this.b = k2;
    }

    private boolean a(Activity activity, b b2) {
        if (g.a((Context)activity)) {
            a.a.a.a.c.h().a("Twitter", "Using SSO");
            return this.a.a(activity, (com.twitter.sdk.android.core.identity.a)new g(this.d, (c)b2, this.d.c()));
        }
        return false;
    }

    private void b() {
        com.twitter.sdk.android.core.internal.scribe.a a2 = this.a();
        if (a2 == null) {
            return;
        }
        a2.a(new com.twitter.sdk.android.core.internal.scribe.c[]{new c.a().a("android").b("login").c("").d("").e("").f("impression").a()});
    }

    private void b(Activity activity, c<u> c2) {
        this.b();
        b b2 = new /* Unavailable Anonymous Inner Class!! */;
        if (!this.a(activity, b2) && !this.b(activity, b2)) {
            b2.a((r)new o("Authorize failed."));
        }
    }

    private boolean b(Activity activity, b b2) {
        a.a.a.a.c.h().a("Twitter", "Using OAuth");
        return this.a.a(activity, (com.twitter.sdk.android.core.identity.a)new d(this.d, (c)b2, this.d.c()));
    }

    private void c() {
        com.twitter.sdk.android.core.internal.scribe.a a2 = this.a();
        if (a2 == null) {
            return;
        }
        a2.a(new com.twitter.sdk.android.core.internal.scribe.c[]{new c.a().a("android").b("shareemail").c("").d("").e("").f("impression").a()});
    }

    protected com.twitter.sdk.android.core.internal.scribe.a a() {
        return m.a();
    }

    public void a(int n2, int n3, Intent intent) {
        l l2 = a.a.a.a.c.h();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onActivityResult called with ");
        stringBuilder.append(n2);
        stringBuilder.append(" ");
        stringBuilder.append(n3);
        l2.a("Twitter", stringBuilder.toString());
        if (!this.a.b()) {
            a.a.a.a.c.h().d("Twitter", "Authorize not in progress", null);
            return;
        }
        com.twitter.sdk.android.core.identity.a a2 = this.a.c();
        if (a2 != null && a2.a(n2, n3, intent)) {
            this.a.a();
        }
    }

    public void a(Activity activity, c<u> c2) {
        if (activity != null) {
            if (c2 != null) {
                if (activity.isFinishing()) {
                    a.a.a.a.c.h().d("Twitter", "Cannot authorize, activity is finishing.", null);
                    return;
                }
                this.b(activity, c2);
                return;
            }
            throw new IllegalArgumentException("Callback must not be null.");
        }
        throw new IllegalArgumentException("Activity must not be null.");
    }

    public void a(u u2, c<String> c2) {
        if (u2 != null) {
            if (c2 != null) {
                this.c();
                this.c.startActivity(this.b(u2, c2));
                return;
            }
            throw new IllegalArgumentException("Callback must not be null.");
        }
        throw new IllegalArgumentException("Session must not be null.");
    }

    Intent b(u u2, c<String> c2) {
        return new Intent(this.c, ShareEmailActivity.class).setFlags(268435456).putExtra("session_id", u2.b()).putExtra("result_receiver", (Parcelable)new i(c2));
    }

    private static class a {
        private static final com.twitter.sdk.android.core.identity.b a = new com.twitter.sdk.android.core.identity.b();
    }

}

