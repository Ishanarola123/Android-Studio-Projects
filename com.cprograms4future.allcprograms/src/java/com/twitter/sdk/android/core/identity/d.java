/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Parcelable
 *  java.lang.Class
 *  java.lang.String
 */
package com.twitter.sdk.android.core.identity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.twitter.sdk.android.core.c;
import com.twitter.sdk.android.core.identity.OAuthActivity;
import com.twitter.sdk.android.core.identity.a;
import com.twitter.sdk.android.core.n;
import com.twitter.sdk.android.core.u;

class d
extends a {
    public d(n n2, c<u> c2, int n3) {
        super(n2, c2, n3);
    }

    @Override
    public boolean a(Activity activity) {
        activity.startActivityForResult(this.b(activity), this.a);
        return true;
    }

    Intent b(Activity activity) {
        Intent intent = new Intent((Context)activity, OAuthActivity.class);
        intent.putExtra("auth_config", (Parcelable)this.a());
        return intent;
    }
}

