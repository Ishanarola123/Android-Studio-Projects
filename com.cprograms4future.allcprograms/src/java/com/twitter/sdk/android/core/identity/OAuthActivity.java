/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.view.View
 *  android.webkit.WebView
 *  android.widget.ProgressBar
 *  java.lang.String
 *  javax.net.ssl.SSLSocketFactory
 */
package com.twitter.sdk.android.core.identity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;
import com.twitter.sdk.android.core.h;
import com.twitter.sdk.android.core.identity.c;
import com.twitter.sdk.android.core.internal.d;
import com.twitter.sdk.android.core.internal.oauth.OAuth1aService;
import com.twitter.sdk.android.core.n;
import com.twitter.sdk.android.core.o;
import com.twitter.sdk.android.core.q;
import javax.net.ssl.SSLSocketFactory;

public class OAuthActivity
extends Activity
implements c.a {
    c a;
    private ProgressBar b;
    private WebView c;

    @Override
    public void a(int n2, Intent intent) {
        this.setResult(n2, intent);
        this.finish();
    }

    public void onBackPressed() {
        this.a.a(0, new o("Authorization failed, request was canceled."));
    }

    protected void onCreate(Bundle bundle) {
        c c2;
        super.onCreate(bundle);
        this.setContentView(h.b.tw__activity_oauth);
        this.b = (ProgressBar)this.findViewById(h.a.tw__spinner);
        this.c = (WebView)this.findViewById(h.a.tw__web_view);
        boolean bl = bundle != null ? bundle.getBoolean("progress", false) : true;
        ProgressBar progressBar = this.b;
        int n2 = bl ? 0 : 8;
        progressBar.setVisibility(n2);
        q q2 = q.c();
        this.a = c2 = new c(this.b, this.c, (n)this.getIntent().getParcelableExtra("auth_config"), new OAuth1aService(q2, q2.f(), new d()), this);
        this.a.a();
    }

    protected void onSaveInstanceState(Bundle bundle) {
        if (this.b.getVisibility() == 0) {
            bundle.putBoolean("progress", true);
        }
        super.onSaveInstanceState(bundle);
    }
}

