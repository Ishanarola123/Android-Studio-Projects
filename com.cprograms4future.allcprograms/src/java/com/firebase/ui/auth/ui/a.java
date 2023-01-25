/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Parcelable
 *  android.support.v4.app.h
 *  com.firebase.ui.auth.b.a.b
 *  com.firebase.ui.auth.ui.h
 *  com.google.firebase.auth.q
 *  java.lang.String
 */
package com.firebase.ui.auth.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.firebase.ui.auth.b;
import com.firebase.ui.auth.c;
import com.firebase.ui.auth.ui.e;
import com.firebase.ui.auth.ui.h;
import com.google.firebase.auth.q;

public class a
extends com.firebase.ui.auth.ui.c {
    private h c;

    public a(h h2, Intent intent) {
        super((Context)h2, (e)intent.getParcelableExtra("extra_flow_params"));
        this.c = h2;
    }

    public void a() {
        this.c.setTheme(c.i.FirebaseUI);
        this.c.setTheme(this.c().c);
    }

    public void a(int n2, Intent intent) {
        this.a((Activity)this.c, n2, intent);
    }

    public void a(Intent intent, int n2) {
        this.c.startActivityForResult(intent, n2);
    }

    public void a(com.firebase.ui.auth.b.a.b b2, q q2, b b3) {
        this.a(b2, (Activity)this.c, q2, null, b3);
    }

    public void a(com.firebase.ui.auth.b.a.b b2, q q2, String string, b b3) {
        this.a(b2, (Activity)this.c, q2, string, b3);
    }

    public com.firebase.ui.auth.b.a.b b() {
        return this.a((android.support.v4.app.h)this.c);
    }
}

