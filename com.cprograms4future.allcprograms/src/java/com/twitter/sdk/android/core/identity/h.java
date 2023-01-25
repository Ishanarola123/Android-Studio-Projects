/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.ResultReceiver
 *  com.twitter.sdk.android.core.c
 *  com.twitter.sdk.android.core.identity.ShareEmailClient
 *  com.twitter.sdk.android.core.identity.h$1
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 */
package com.twitter.sdk.android.core.identity;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.twitter.sdk.android.core.c;
import com.twitter.sdk.android.core.identity.ShareEmailClient;
import com.twitter.sdk.android.core.identity.h;
import com.twitter.sdk.android.core.r;
import java.io.Serializable;

class h {
    private final ShareEmailClient a;
    private final ResultReceiver b;

    public h(ShareEmailClient shareEmailClient, ResultReceiver resultReceiver) {
        this.a = shareEmailClient;
        this.b = resultReceiver;
    }

    public void a() {
        this.a.a(this.b());
    }

    /*
     * Enabled aggressive block sorting
     */
    void a(com.twitter.sdk.android.core.a.r r2) {
        r r3;
        if (r2.a == null) {
            r3 = new r("Your application may not have access to email addresses or the user may not have an email address. To request access, please visit https://support.twitter.com/forms/platform.");
        } else {
            if (!"".equals((Object)r2.a)) {
                this.a(r2.a);
                return;
            }
            r3 = new r("This user does not have an email address.");
        }
        this.a(r3);
    }

    void a(r r2) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("error", (Serializable)r2);
        this.b.send(1, bundle);
    }

    void a(String string) {
        Bundle bundle = new Bundle();
        bundle.putString("email", string);
        this.b.send(-1, bundle);
    }

    c<com.twitter.sdk.android.core.a.r> b() {
        return new 1(this);
    }

    public void c() {
        Bundle bundle = new Bundle();
        bundle.putSerializable("msg", (Serializable)"The user chose not to share their email address at this time.");
        this.b.send(0, bundle);
    }
}

