/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  com.squareup.okhttp.Cache
 *  com.squareup.okhttp.CacheControl
 *  com.squareup.okhttp.CacheControl$Builder
 *  com.squareup.okhttp.Call
 *  com.squareup.okhttp.OkHttpClient
 *  com.squareup.okhttp.Request
 *  com.squareup.okhttp.Request$Builder
 *  com.squareup.okhttp.Response
 *  com.squareup.okhttp.ResponseBody
 *  java.io.File
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.concurrent.TimeUnit
 */
package com.a.a;

import android.content.Context;
import android.net.Uri;
import com.a.a.ag;
import com.a.a.j;
import com.a.a.q;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.CacheControl;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

public class s
implements j {
    private final OkHttpClient a;

    public s(Context context) {
        this(ag.b(context));
    }

    public s(OkHttpClient okHttpClient) {
        this.a = okHttpClient;
    }

    public s(File file) {
        this(file, ag.a(file));
    }

    public s(File file, long l2) {
        this(s.a());
        try {
            this.a.setCache(new Cache(file, l2));
        }
        catch (IOException iOException) {}
    }

    private static OkHttpClient a() {
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setConnectTimeout(15000L, TimeUnit.MILLISECONDS);
        okHttpClient.setReadTimeout(20000L, TimeUnit.MILLISECONDS);
        okHttpClient.setWriteTimeout(20000L, TimeUnit.MILLISECONDS);
        return okHttpClient;
    }

    @Override
    public j.a a(Uri uri, int n2) throws IOException {
        CacheControl cacheControl;
        Response response;
        int n3;
        if (n2 != 0) {
            if (q.c(n2)) {
                cacheControl = CacheControl.FORCE_CACHE;
            } else {
                CacheControl.Builder builder = new CacheControl.Builder();
                if (!q.a(n2)) {
                    builder.noCache();
                }
                if (!q.b(n2)) {
                    builder.noStore();
                }
                cacheControl = builder.build();
            }
        } else {
            cacheControl = null;
        }
        Request.Builder builder = new Request.Builder().url(uri.toString());
        if (cacheControl != null) {
            builder.cacheControl(cacheControl);
        }
        if ((n3 = (response = this.a.newCall(builder.build()).execute()).code()) < 300) {
            boolean bl = response.cacheResponse() != null;
            ResponseBody responseBody = response.body();
            return new j.a(responseBody.byteStream(), bl, responseBody.contentLength());
        }
        response.body().close();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(n3);
        stringBuilder.append(" ");
        stringBuilder.append(response.message());
        throw new j.b(stringBuilder.toString(), n2, n3);
    }
}

