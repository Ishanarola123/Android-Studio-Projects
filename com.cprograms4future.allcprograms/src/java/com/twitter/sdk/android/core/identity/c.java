/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.Bundle
 *  android.webkit.WebChromeClient
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  android.widget.ProgressBar
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package com.twitter.sdk.android.core.identity;

import a.a.a.a.l;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import com.twitter.sdk.android.core.i;
import com.twitter.sdk.android.core.identity.e;
import com.twitter.sdk.android.core.identity.f;
import com.twitter.sdk.android.core.identity.k;
import com.twitter.sdk.android.core.internal.oauth.OAuth1aService;
import com.twitter.sdk.android.core.n;
import com.twitter.sdk.android.core.o;
import com.twitter.sdk.android.core.p;
import com.twitter.sdk.android.core.r;
import java.io.Serializable;

class c
implements f.a {
    final a a;
    p b;
    private final ProgressBar c;
    private final WebView d;
    private final n e;
    private final OAuth1aService f;

    c(ProgressBar progressBar, WebView webView, n n2, OAuth1aService oAuth1aService, a a2) {
        this.c = progressBar;
        this.d = webView;
        this.e = n2;
        this.f = oAuth1aService;
        this.a = a2;
    }

    private void b(Bundle bundle) {
        String string;
        a.a.a.a.c.h().a("Twitter", "OAuth web view completed successfully");
        if (bundle != null && (string = bundle.getString("oauth_verifier")) != null) {
            a.a.a.a.c.h().a("Twitter", "Converting the request token to an access token.");
            this.f.a(this.c(), this.b, string);
            return;
        }
        l l2 = a.a.a.a.c.h();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Failed to get authorization, bundle incomplete ");
        stringBuilder.append((Object)bundle);
        l2.d("Twitter", stringBuilder.toString(), null);
        this.a(1, new o("Failed to get authorization, bundle incomplete"));
    }

    private void b(k k2) {
        a.a.a.a.c.h().d("Twitter", "OAuth web view completed with an error", (Throwable)((Object)k2));
        this.a(1, new o("OAuth web view completed with an error"));
    }

    private void d() {
        this.d.stopLoading();
        this.e();
    }

    private void e() {
        this.c.setVisibility(8);
    }

    void a() {
        a.a.a.a.c.h().a("Twitter", "Obtaining request token to start the sign in flow");
        this.f.a(this.b());
    }

    protected void a(int n2, o o2) {
        Intent intent = new Intent();
        intent.putExtra("auth_error", (Serializable)o2);
        this.a.a(n2, intent);
    }

    @Override
    public void a(Bundle bundle) {
        this.b(bundle);
        this.d();
    }

    void a(WebView webView, WebViewClient webViewClient, String string, WebChromeClient webChromeClient) {
        WebSettings webSettings = webView.getSettings();
        webSettings.setAllowFileAccess(false);
        webSettings.setJavaScriptEnabled(false);
        webSettings.setSaveFormData(false);
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);
        webView.setWebViewClient(webViewClient);
        webView.loadUrl(string);
        webView.setVisibility(4);
        webView.setWebChromeClient(webChromeClient);
    }

    @Override
    public void a(WebView webView, String string) {
        this.e();
        webView.setVisibility(0);
    }

    @Override
    public void a(k k2) {
        this.b(k2);
        this.d();
    }

    com.twitter.sdk.android.core.c<com.twitter.sdk.android.core.internal.oauth.f> b() {
        return new com.twitter.sdk.android.core.c<com.twitter.sdk.android.core.internal.oauth.f>(){

            @Override
            public void a(i<com.twitter.sdk.android.core.internal.oauth.f> i2) {
                c.this.b = ((com.twitter.sdk.android.core.internal.oauth.f)i2.a).a;
                String string = c.this.f.a(c.this.b);
                a.a.a.a.c.h().a("Twitter", "Redirecting user to web view to complete authorization flow");
                c.this.a(c.this.d, new f(c.this.f.a(c.this.e), c.this), string, new e());
            }

            @Override
            public void a(r r2) {
                a.a.a.a.c.h().d("Twitter", "Failed to get request token", (Throwable)((Object)r2));
                c.this.a(1, new o("Failed to get request token"));
            }
        };
    }

    com.twitter.sdk.android.core.c<com.twitter.sdk.android.core.internal.oauth.f> c() {
        return new com.twitter.sdk.android.core.c<com.twitter.sdk.android.core.internal.oauth.f>(){

            @Override
            public void a(i<com.twitter.sdk.android.core.internal.oauth.f> i2) {
                Intent intent = new Intent();
                com.twitter.sdk.android.core.internal.oauth.f f2 = (com.twitter.sdk.android.core.internal.oauth.f)i2.a;
                intent.putExtra("screen_name", f2.b);
                intent.putExtra("user_id", f2.c);
                intent.putExtra("tk", f2.a.b);
                intent.putExtra("ts", f2.a.c);
                c.this.a.a(-1, intent);
            }

            @Override
            public void a(r r2) {
                a.a.a.a.c.h().d("Twitter", "Failed to get access token", (Throwable)((Object)r2));
                c.this.a(1, new o("Failed to get access token"));
            }
        };
    }

}

