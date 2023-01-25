/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentSender
 *  android.content.IntentSender$SendIntentException
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.support.v4.app.g
 *  android.support.v4.app.h
 *  android.support.v4.app.l
 *  android.support.v4.app.q
 *  android.text.TextUtils
 *  android.util.Log
 *  com.google.android.gms.auth.api.a
 *  com.google.android.gms.auth.api.credentials.Credential
 *  com.google.android.gms.auth.api.credentials.a
 *  com.google.android.gms.auth.api.credentials.a$a
 *  com.google.android.gms.auth.api.credentials.b
 *  com.google.android.gms.auth.api.credentials.c
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.common.api.a
 *  com.google.android.gms.common.api.f
 *  com.google.android.gms.common.api.f$a
 *  com.google.android.gms.common.api.f$b
 *  com.google.android.gms.common.api.f$c
 *  com.google.android.gms.common.api.g
 *  com.google.android.gms.common.api.k
 *  com.google.android.gms.common.api.l
 *  com.google.android.gms.d.c
 *  com.google.android.gms.d.d
 *  com.google.android.gms.d.e
 *  com.google.android.gms.d.g
 *  com.google.firebase.auth.FirebaseAuth
 *  com.google.firebase.auth.d
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 */
package com.firebase.ui.auth.b.a;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.h;
import android.support.v4.app.q;
import android.text.TextUtils;
import android.util.Log;
import com.firebase.ui.auth.a;
import com.firebase.ui.auth.b.a.a;
import com.firebase.ui.auth.b.a.c;
import com.firebase.ui.auth.b.a.d;
import com.firebase.ui.auth.b.b;
import com.firebase.ui.auth.c;
import com.firebase.ui.auth.ui.e;
import com.firebase.ui.auth.ui.email.RegisterEmailActivity;
import com.firebase.ui.auth.ui.g;
import com.firebase.ui.auth.ui.i;
import com.firebase.ui.auth.ui.idp.AuthMethodPickerActivity;
import com.firebase.ui.auth.ui.j;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.a;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.k;
import com.google.android.gms.common.api.l;
import com.google.firebase.auth.FirebaseAuth;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class c
extends d<com.google.android.gms.auth.api.credentials.b> {
    private Credential c;

    public static c a(h h2) {
        android.support.v4.app.g g2 = h2.getSupportFragmentManager().a("SignInDelegate");
        if (g2 instanceof c) {
            return (c)g2;
        }
        return null;
    }

    public static void a(h h2, e e2) {
        android.support.v4.app.l l2 = h2.getSupportFragmentManager();
        if (!(l2.a("SignInDelegate") instanceof c)) {
            c c2 = new c();
            c2.g(g.a(e2));
            l2.a().a((android.support.v4.app.g)c2, "SignInDelegate").a().c();
        }
    }

    static /* synthetic */ void a(c c2) {
        c2.ai();
    }

    private void a(Credential credential) {
        this.c = credential;
        String string = this.ae();
        String string2 = this.ag();
        if (!TextUtils.isEmpty((CharSequence)string)) {
            if (TextUtils.isEmpty((CharSequence)string2)) {
                this.b(string, this.af());
                return;
            }
            this.a(string, string2);
        }
    }

    private void a(String string, String string2) {
        this.a.g().a(string, string2).a((com.google.android.gms.d.d)new i("SignInDelegate", "Error signing in with email and password")).a((com.google.android.gms.d.e)new com.google.android.gms.d.e<com.google.firebase.auth.d>(this, string){
            final /* synthetic */ String a;
            final /* synthetic */ c b;
            {
                this.b = c2;
                this.a = string;
            }

            public void a(com.google.firebase.auth.d d2) {
                this.b.a(-1, com.firebase.ui.auth.b.a(new com.firebase.ui.auth.b("password", this.a)));
            }
        }).a(new com.google.android.gms.d.d(this){
            final /* synthetic */ c a;
            {
                this.a = c2;
            }

            public void a(java.lang.Exception exception) {
                if (exception instanceof com.google.firebase.auth.l) {
                    c.a(this.a);
                    return;
                }
                c.b(this.a);
            }
        });
    }

    private String ae() {
        if (this.c == null) {
            return null;
        }
        return this.c.a();
    }

    private String af() {
        if (this.c == null) {
            return null;
        }
        return this.c.f();
    }

    private String ag() {
        if (this.c == null) {
            return null;
        }
        return this.c.e();
    }

    private void ah() {
        block3 : {
            int n2;
            Intent intent;
            block2 : {
                block0 : {
                    List<a.a> list;
                    block1 : {
                        list = this.a.c().b;
                        if (list.size() != 1) break block0;
                        if (!((a.a)list.get(0)).a().equals((Object)"password")) break block1;
                        intent = RegisterEmailActivity.a(this.j(), this.a.c());
                        n2 = 5;
                        break block2;
                    }
                    this.b(null, c.b(((a.a)list.get(0)).a()));
                    break block3;
                }
                intent = AuthMethodPickerActivity.a(this.j(), this.a.c());
                n2 = 4;
            }
            this.startActivityForResult(intent, n2);
        }
        this.a.d();
    }

    private void ai() {
        if (this.c == null) {
            Log.w((String)"SignInDelegate", (String)"deleteCredentialAndRedirect: null credential");
            this.ah();
            return;
        }
        b.a((Activity)this.l()).a(this.c).a((com.google.android.gms.d.c)new com.google.android.gms.d.c<Status>(this){
            final /* synthetic */ c a;
            {
                this.a = c2;
            }

            public void onComplete(com.google.android.gms.d.g<Status> g2) {
                if (!g2.b()) {
                    Log.w((String)"SignInDelegate", (String)"deleteCredential:failure", (Throwable)g2.e());
                }
                c.b(this.a);
            }
        });
    }

    private List<String> b() {
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.a.c().b.iterator();
        while (iterator.hasNext()) {
            String string = ((a.a)iterator.next()).a();
            if (!string.equals((Object)"google.com") && !string.equals((Object)"facebook.com") && !string.equals((Object)"twitter.com")) continue;
            arrayList.add((Object)c.b(string));
        }
        return arrayList;
    }

    static /* synthetic */ void b(c c2) {
        c2.ah();
    }

    private void b(String string, String string2) {
        if (TextUtils.isEmpty((CharSequence)string2)) {
            this.startActivityForResult(RegisterEmailActivity.a(this.j(), this.a.c(), string), 5);
            return;
        }
        if (!(string2.equals((Object)"https://accounts.google.com") || string2.equals((Object)"https://www.facebook.com") || string2.equals((Object)"https://twitter.com"))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("unknown provider: ");
            stringBuilder.append(string2);
            Log.w((String)"SignInDelegate", (String)stringBuilder.toString());
            this.startActivityForResult(AuthMethodPickerActivity.a(this.j(), this.a.c()), 3);
            this.a.d();
            return;
        }
        a.a(this.l(), this.a.c(), new j.a(string).b(c.c(string2)).a());
    }

    public void a(int n2, int n3, Intent intent) {
        super.a(n2, n3, intent);
        switch (n2) {
            default: {
                a a2 = a.a(this.l());
                if (a2 == null) break;
                a2.a(n2, n3, intent);
                return;
            }
            case 3: 
            case 4: 
            case 5: {
                this.a(n3, intent);
                return;
            }
            case 2: {
                if (n3 == -1) {
                    this.a((Credential)intent.getParcelableExtra("com.google.android.gms.credentials.Credential"));
                    return;
                }
                this.ah();
            }
        }
    }

    public void a(Bundle bundle) {
    }

    public void a(com.google.android.gms.auth.api.credentials.b b2) {
        Status status = b2.b();
        if (status.d()) {
            this.a(b2.a());
            return;
        }
        if (status.c()) {
            try {
                if (status.e() == 6) {
                    this.a.a(status.f().getIntentSender(), 2);
                    return;
                }
                if (!this.b().isEmpty()) {
                    this.a.a(status.f().getIntentSender(), 2);
                    return;
                }
            }
            catch (IntentSender.SendIntentException sendIntentException) {
                Log.e((String)"SignInDelegate", (String)"Failed to send Credentials intent.", (Throwable)sendIntentException);
            }
        }
        this.ah();
    }

    @Override
    public void b_(Bundle bundle) {
        super.b_(bundle);
        if (bundle != null) {
            return;
        }
        if (this.a.c().f) {
            this.a.a(c.h.progress_dialog_loading);
            this.b = new f.a(this.j().getApplicationContext()).a((f.b)this).a(com.google.android.gms.auth.api.a.d).a(this.l(), 1, (f.c)this).b();
            this.b.e();
            this.a.h().a(this.b, new a.a().a(true).a((String[])this.b().toArray((Object[])new String[0])).a()).a((l)this);
            return;
        }
        this.ah();
    }

    public void e(Bundle bundle) {
        bundle.putBoolean("has_existing_instance", true);
        super.e(bundle);
    }
}

