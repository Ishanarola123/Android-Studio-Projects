/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.ProgressDialog
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Parcelable
 *  android.support.v4.app.h
 *  com.firebase.ui.auth.b.a.b
 *  com.google.android.gms.auth.api.a
 *  com.google.android.gms.auth.api.credentials.c
 *  com.google.firebase.auth.FirebaseAuth
 *  com.google.firebase.auth.q
 *  com.google.firebase.c
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
package com.firebase.ui.auth.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v4.app.h;
import com.firebase.ui.auth.b;
import com.firebase.ui.auth.ui.e;
import com.google.android.gms.auth.api.a;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.q;

public class c {
    protected Context a;
    protected ProgressDialog b;
    private final e c;

    public c(Context context, e e2) {
        this.a = context;
        this.c = e2;
    }

    public static Intent a(Context context, Class<? extends Activity> class_, e e2) {
        return new Intent(com.firebase.ui.auth.b.e.a(context, "context cannot be null", new Object[0]), com.firebase.ui.auth.b.e.a(class_, "target activity cannot be null", new Object[0])).putExtra("extra_flow_params", (Parcelable)com.firebase.ui.auth.b.e.a(e2, "flowParams cannot be null", new Object[0]));
    }

    public com.firebase.ui.auth.b.a.b a(h h2) {
        return com.firebase.ui.auth.b.a.b.a((h)h2, (e)this.c());
    }

    public void a(int n2) {
        this.a(this.a.getString(n2));
    }

    public void a(Activity activity, int n2, Intent intent) {
        activity.setResult(n2, intent);
        activity.finish();
    }

    public void a(com.firebase.ui.auth.b.a.b b2, Activity activity, q q2, b b3) {
        this.a(b2, activity, q2, null, b3);
    }

    public void a(com.firebase.ui.auth.b.a.b b2, Activity activity, q q2, String string, b b3) {
        if (b2 == null) {
            this.a(activity, -1, b.a(b3));
            return;
        }
        b2.a(q2, string, b3);
    }

    public void a(String string) {
        this.d();
        if (this.b == null) {
            this.b = new ProgressDialog(this.a);
            this.b.setIndeterminate(true);
            this.b.setTitle((CharSequence)"");
        }
        this.b.setMessage((CharSequence)string);
        this.b.show();
    }

    public e c() {
        return this.c;
    }

    public void d() {
        if (this.b != null) {
            this.b.dismiss();
            this.b = null;
        }
    }

    public boolean e() {
        return this.b != null && this.b.isShowing();
    }

    public com.google.firebase.c f() {
        return com.google.firebase.c.a((String)this.c.a);
    }

    public FirebaseAuth g() {
        return FirebaseAuth.getInstance((com.google.firebase.c)this.f());
    }

    public com.google.android.gms.auth.api.credentials.c h() {
        return a.g;
    }

    public q i() {
        return this.g().a();
    }
}

