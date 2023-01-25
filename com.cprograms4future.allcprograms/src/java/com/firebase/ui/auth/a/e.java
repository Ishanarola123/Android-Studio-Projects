/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.util.Log
 *  com.google.firebase.auth.ab
 *  com.google.firebase.auth.c
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ref.WeakReference
 */
package com.firebase.ui.auth.a;

import a.a.a.a.i;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.firebase.ui.auth.a.d;
import com.firebase.ui.auth.b;
import com.firebase.ui.auth.c;
import com.google.firebase.auth.ab;
import com.twitter.sdk.android.core.identity.j;
import com.twitter.sdk.android.core.n;
import com.twitter.sdk.android.core.p;
import com.twitter.sdk.android.core.r;
import com.twitter.sdk.android.core.u;
import java.lang.ref.WeakReference;

public class e
extends com.twitter.sdk.android.core.c<u>
implements d {
    private d.a a;
    private j b;

    public e(Context context) {
        n n2 = new n(context.getString(c.h.twitter_consumer_key), context.getString(c.h.twitter_consumer_secret));
        Context context2 = context.getApplicationContext();
        i[] arri = new i[]{new com.twitter.sdk.android.a(n2)};
        a.a.a.a.c.a(context2, arri);
        this.b = new j();
    }

    public static com.google.firebase.auth.c a(b b2) {
        if (!b2.a().equalsIgnoreCase("twitter.com")) {
            return null;
        }
        return ab.a((String)b2.c(), (String)b2.d());
    }

    @Override
    public String a(Context context) {
        return context.getString(c.h.idp_name_twitter);
    }

    @Override
    public void a(int n2, int n3, Intent intent) {
        this.b.a(n2, n3, intent);
    }

    @Override
    public void a(Activity activity) {
        this.b.a(activity, this);
    }

    @Override
    public void a(d.a a2) {
        this.a = a2;
    }

    @Override
    public void a(com.twitter.sdk.android.core.i<u> i2) {
        this.b.a((u)i2.a, new a((u)i2.a, this.a));
    }

    @Override
    public void a(r r2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Failure logging in to Twitter. ");
        stringBuilder.append(r2.getMessage());
        Log.e((String)"TwitterProvider", (String)stringBuilder.toString());
        this.a.b(new Bundle());
    }

    @Override
    public String b() {
        return "twitter.com";
    }

    private static class a
    extends com.twitter.sdk.android.core.c<String> {
        private u a;
        private WeakReference<d.a> b;

        public a(u u2, d.a a2) {
            this.a = u2;
            this.b = new WeakReference((Object)a2);
        }

        private b a(String string) {
            return new b("twitter.com", string, ((p)this.a.a()).b, ((p)this.a.a()).c);
        }

        private void a(b b2) {
            if (this.b != null) {
                ((d.a)this.b.get()).a(b2);
            }
        }

        @Override
        public void a(com.twitter.sdk.android.core.i<String> i2) {
            this.a(this.a((String)i2.a));
        }

        @Override
        public void a(r r2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failure retrieving Twitter email. ");
            stringBuilder.append(r2.getMessage());
            Log.e((String)"TwitterProvider", (String)stringBuilder.toString());
            this.a(this.a((String)null));
        }
    }

}

