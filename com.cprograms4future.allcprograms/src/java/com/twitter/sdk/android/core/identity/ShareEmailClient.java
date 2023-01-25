/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Object
 */
package com.twitter.sdk.android.core.identity;

import com.twitter.sdk.android.core.a.r;
import com.twitter.sdk.android.core.c;
import com.twitter.sdk.android.core.l;
import com.twitter.sdk.android.core.u;
import d.b;
import d.b.f;
import d.b.s;
import d.d;

class ShareEmailClient
extends l {
    ShareEmailClient(u u2) {
        super(u2);
    }

    protected void a(c<r> c2) {
        this.a(EmailService.class).verifyCredentials(true, true).a(c2);
    }

}

