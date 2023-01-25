/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  java.lang.String
 */
package com.xiaomi.onetrack.h;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.xiaomi.onetrack.h.b;

class c
extends Handler {
    final /* synthetic */ b a;

    c(b b2, Looper looper) {
        this.a = b2;
        super(looper);
    }

    public void handleMessage(Message message) {
        if (message.what != 100) {
            return;
        }
        b.a(this.a, message.getData().getString("hint"));
    }
}

