/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.ResultReceiver
 *  com.twitter.sdk.android.core.c
 *  java.io.Serializable
 *  java.lang.IllegalArgumentException
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.twitter.sdk.android.core.identity;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.twitter.sdk.android.core.c;
import com.twitter.sdk.android.core.r;
import d.l;
import java.io.Serializable;

class i
extends ResultReceiver {
    private final c<String> a;

    public i(c<String> c2) {
        super(null);
        if (c2 != null) {
            this.a = c2;
            return;
        }
        throw new IllegalArgumentException("Callback must not be null");
    }

    public void onReceiveResult(int n2, Bundle bundle) {
        switch (n2) {
            default: {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid result code ");
                stringBuilder.append(n2);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 1: {
                this.a.a((r)bundle.getSerializable("error"));
                return;
            }
            case 0: {
                this.a.a(new r(bundle.getString("msg")));
                return;
            }
            case -1: 
        }
        this.a.a(new com.twitter.sdk.android.core.i<String>(bundle.getString("email"), null));
    }
}

