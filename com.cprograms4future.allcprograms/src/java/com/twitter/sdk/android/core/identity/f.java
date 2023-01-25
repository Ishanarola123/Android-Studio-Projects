/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.net.http.SslError
 *  android.os.Bundle
 *  android.webkit.SslErrorHandler
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  java.lang.Object
 *  java.lang.String
 *  java.net.URI
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.TreeMap
 */
package com.twitter.sdk.android.core.identity;

import a.a.a.a.a.e.j;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.twitter.sdk.android.core.identity.k;
import java.net.URI;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class f
extends WebViewClient {
    private final String a;
    private final a b;

    public f(String string, a a2) {
        this.a = string;
        this.b = a2;
    }

    public void onPageFinished(WebView webView, String string) {
        super.onPageFinished(webView, string);
        this.b.a(webView, string);
    }

    public void onReceivedError(WebView webView, int n2, String string, String string2) {
        super.onReceivedError(webView, n2, string, string2);
        this.b.a(new k(n2, string, string2));
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        this.b.a(new k(sslError.getPrimaryError(), null, null));
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String string) {
        if (string.startsWith(this.a)) {
            TreeMap<String, String> treeMap = j.a(URI.create((String)string), false);
            Bundle bundle = new Bundle(treeMap.size());
            for (Map.Entry entry : treeMap.entrySet()) {
                bundle.putString((String)entry.getKey(), (String)entry.getValue());
            }
            this.b.a(bundle);
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, string);
    }

    static interface a {
        public void a(Bundle var1);

        public void a(WebView var1, String var2);

        public void a(k var1);
    }

}

