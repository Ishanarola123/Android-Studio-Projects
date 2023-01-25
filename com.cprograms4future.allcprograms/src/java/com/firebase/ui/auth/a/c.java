/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.os.Bundle
 *  android.support.v4.app.h
 *  android.text.TextUtils
 *  android.util.Log
 *  android.view.View
 *  android.view.View$OnClickListener
 *  com.google.android.gms.auth.api.a
 *  com.google.android.gms.auth.api.signin.GoogleSignInAccount
 *  com.google.android.gms.auth.api.signin.GoogleSignInOptions
 *  com.google.android.gms.auth.api.signin.GoogleSignInOptions$a
 *  com.google.android.gms.auth.api.signin.a
 *  com.google.android.gms.auth.api.signin.b
 *  com.google.android.gms.common.api.Scope
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.common.api.a
 *  com.google.android.gms.common.api.a$d
 *  com.google.android.gms.common.api.a$d$c
 *  com.google.android.gms.common.api.f
 *  com.google.android.gms.common.api.f$a
 *  com.google.android.gms.common.api.f$c
 *  com.google.android.gms.common.api.g
 *  com.google.android.gms.common.b
 *  com.google.firebase.auth.c
 *  com.google.firebase.auth.v
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Iterator
 *  java.util.List
 */
package com.firebase.ui.auth.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.h;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.firebase.ui.auth.a;
import com.firebase.ui.auth.a.d;
import com.firebase.ui.auth.b;
import com.firebase.ui.auth.c;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.g;
import com.google.firebase.auth.v;
import java.util.Iterator;
import java.util.List;

public class c
implements View.OnClickListener,
d,
f.c {
    private f a;
    private Activity b;
    private d.a c;

    public c(h h2, a.a a2) {
        this(h2, a2, null);
    }

    public c(h h2, a.a a2, String string) {
        this.b = h2;
        String string2 = h2.getString(c.h.default_web_client_id);
        GoogleSignInOptions.a a3 = new GoogleSignInOptions.a(GoogleSignInOptions.f).b().a(string2);
        if (h2.getResources().getIdentifier("google_permissions", "array", h2.getPackageName()) != 0) {
            Log.w((String)"GoogleProvider", (String)"DEVELOPER WARNING: You have defined R.array.google_permissions but that is no longer respected as of FirebaseUI 1.0.0. Please see README for IDP scope configuration instructions.");
        }
        Iterator iterator = a2.b().iterator();
        while (iterator.hasNext()) {
            a3.a(new Scope((String)iterator.next()), new Scope[0]);
        }
        if (!TextUtils.isEmpty((CharSequence)string)) {
            a3.b(string);
        }
        this.a = new f.a((Context)h2).a(h2, 0, (f.c)this).a(com.google.android.gms.auth.api.a.e, (a.d.c)a3.d()).b();
    }

    private b a(GoogleSignInAccount googleSignInAccount) {
        return new b("google.com", googleSignInAccount.c(), googleSignInAccount.b());
    }

    public static com.google.firebase.auth.c a(b b2) {
        return v.a((String)b2.c(), null);
    }

    private void a(com.google.android.gms.auth.api.signin.b b2) {
        String string = b2.b().a();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(b2.b().e());
        stringBuilder.append(" ");
        stringBuilder.append(string);
        this.a(stringBuilder.toString());
    }

    private void a(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Error logging in with Google. ");
        stringBuilder.append(string);
        Log.e((String)"GoogleProvider", (String)stringBuilder.toString());
        Bundle bundle = new Bundle();
        bundle.putString("error", string);
        this.c.b(bundle);
    }

    @Override
    public String a(Context context) {
        return context.getResources().getString(c.h.idp_name_google);
    }

    public void a() {
        if (this.a != null) {
            this.a.g();
            this.a = null;
        }
    }

    @Override
    public void a(int n2, int n3, Intent intent) {
        if (n2 == 20) {
            com.google.android.gms.auth.api.signin.b b2 = com.google.android.gms.auth.api.a.h.a(intent);
            if (b2 != null) {
                if (b2.c()) {
                    this.c.a(this.a(b2.a()));
                    return;
                }
                this.a(b2);
                return;
            }
            this.a("No result found in intent");
        }
    }

    @Override
    public void a(Activity activity) {
        activity.startActivityForResult(com.google.android.gms.auth.api.a.h.a(this.a), 20);
    }

    @Override
    public void a(d.a a2) {
        this.c = a2;
    }

    public void a(com.google.android.gms.common.b b2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onConnectionFailed:");
        stringBuilder.append((Object)b2);
        Log.w((String)"GoogleProvider", (String)stringBuilder.toString());
    }

    @Override
    public String b() {
        return "google.com";
    }

    public void onClick(View view) {
        com.google.android.gms.auth.api.a.h.b(this.a);
        this.a(this.b);
    }
}

