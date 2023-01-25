/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager
 *  android.content.res.Resources
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.os.ResultReceiver
 *  android.view.View
 *  android.widget.TextView
 *  com.twitter.sdk.android.core.identity.ShareEmailClient
 *  com.twitter.sdk.android.core.q
 *  com.twitter.sdk.android.core.u
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package com.twitter.sdk.android.core.identity;

import a.a.a.a.c;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.view.View;
import android.widget.TextView;
import com.twitter.sdk.android.core.h;
import com.twitter.sdk.android.core.identity.ShareEmailClient;
import com.twitter.sdk.android.core.identity.h;
import com.twitter.sdk.android.core.k;
import com.twitter.sdk.android.core.q;
import com.twitter.sdk.android.core.u;

public class ShareEmailActivity
extends Activity {
    h a;
    private u b;

    private ResultReceiver a(Intent intent) {
        ResultReceiver resultReceiver = (ResultReceiver)intent.getParcelableExtra("result_receiver");
        if (resultReceiver != null) {
            return resultReceiver;
        }
        throw new IllegalArgumentException("ResultReceiver must not be null. This activity should not be started directly.");
    }

    private u b(Intent intent) {
        long l2 = intent.getLongExtra("session_id", -1L);
        u u2 = (u)q.c().i().a(l2);
        if (u2 != null) {
            return u2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("No TwitterSession for id:");
        stringBuilder.append(l2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    void a(Context context, TextView textView) {
        PackageManager packageManager = context.getPackageManager();
        Resources resources = this.getResources();
        int n2 = h.d.tw__share_email_desc;
        Object[] arrobject = new Object[]{packageManager.getApplicationLabel(context.getApplicationInfo()), this.b.c()};
        textView.setText((CharSequence)resources.getString(n2, arrobject));
    }

    public void onBackPressed() {
        this.a.c();
        super.onBackPressed();
    }

    public void onClickAllow(View view) {
        this.a.a();
        this.finish();
    }

    public void onClickNotNow(View view) {
        this.a.c();
        this.finish();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(h.b.tw__activity_share_email);
        try {
            Intent intent = this.getIntent();
            ResultReceiver resultReceiver = this.a(intent);
            this.b = this.b(intent);
            this.a = new h(new ShareEmailClient(this.b), resultReceiver);
            this.a((Context)this, (TextView)this.findViewById(h.a.tw__share_email_desc));
            return;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            c.h().d("Twitter", "Failed to create ShareEmailActivity.", illegalArgumentException);
            this.finish();
            return;
        }
    }
}

