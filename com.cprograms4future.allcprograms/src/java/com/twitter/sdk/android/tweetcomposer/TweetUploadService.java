/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.IntentService
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Parcelable
 *  com.twitter.sdk.android.core.p
 *  com.twitter.sdk.android.core.u
 *  com.twitter.sdk.android.tweetcomposer.TweetUploadService$1
 *  com.twitter.sdk.android.tweetcomposer.TweetUploadService$2
 *  com.twitter.sdk.android.tweetcomposer.e
 *  com.twitter.sdk.android.tweetcomposer.o
 *  java.io.File
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.twitter.sdk.android.tweetcomposer;

import a.a.a.a.c;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import b.aa;
import com.twitter.sdk.android.core.a.n;
import com.twitter.sdk.android.core.p;
import com.twitter.sdk.android.core.r;
import com.twitter.sdk.android.core.services.MediaService;
import com.twitter.sdk.android.core.u;
import com.twitter.sdk.android.tweetcomposer.StatusesService;
import com.twitter.sdk.android.tweetcomposer.TweetUploadService;
import com.twitter.sdk.android.tweetcomposer.b;
import com.twitter.sdk.android.tweetcomposer.e;
import com.twitter.sdk.android.tweetcomposer.i;
import com.twitter.sdk.android.tweetcomposer.o;
import d.d;
import java.io.File;
import java.io.Serializable;

public class TweetUploadService
extends IntentService {
    a a;
    u b;
    String c;
    b d;
    Intent e;

    public TweetUploadService() {
        this(new a());
    }

    TweetUploadService(a a2) {
        super("TweetUploadService");
        this.a = a2;
    }

    void a(long l2) {
        Intent intent = new Intent("com.twitter.sdk.android.tweetcomposer.UPLOAD_SUCCESS");
        intent.putExtra("EXTRA_TWEET_ID", l2);
        this.sendBroadcast(intent);
    }

    void a(Intent intent) {
        Intent intent2 = new Intent("com.twitter.sdk.android.tweetcomposer.UPLOAD_FAILURE");
        intent2.putExtra("EXTRA_RETRY_INTENT", (Parcelable)intent);
        this.sendBroadcast(intent2);
    }

    void a(r r2) {
        this.a(this.e);
        c.h().d("TweetUploadService", "Post Tweet failed", (Throwable)((Object)r2));
        this.stopSelf();
    }

    void a(u u2, String string) {
        this.a.a(u2).d().update(string, null).a((d<n>)new 1(this));
    }

    void a(u u2, String string, b b2) {
        e e2 = this.a.a(u2);
        String string2 = i.a((Context)this, Uri.parse((String)b2.b));
        if (string2 == null) {
            this.a(new r("Uri file path resolved to null"));
            return;
        }
        File file = new File(string2);
        aa aa2 = aa.a(b.u.a(i.a(file)), file);
        e2.c().upload(aa2, null, null).a((d<com.twitter.sdk.android.core.a.i>)new 2(this, b2, e2, string));
    }

    protected void onHandleIntent(Intent intent) {
        p p2 = (p)intent.getParcelableExtra("EXTRA_USER_TOKEN");
        this.e = intent;
        this.b = new u(p2, -1L, "");
        this.c = intent.getStringExtra("EXTRA_TWEET_TEXT");
        this.d = (b)intent.getSerializableExtra("EXTRA_TWEET_CARD");
        if (b.a(this.d)) {
            this.a(this.b, this.c, this.d);
            return;
        }
        this.a(this.b, this.c);
    }

    static class a {
        a() {
        }

        e a(u u2) {
            return o.e().a(u2);
        }

        String a() {
            return o.e().h();
        }
    }

}

