/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentSender
 *  android.content.IntentSender$SendIntentException
 *  android.net.Uri
 *  android.os.Bundle
 *  android.support.v4.app.g
 *  android.support.v4.app.h
 *  android.support.v4.app.l
 *  android.support.v4.app.q
 *  android.text.TextUtils
 *  android.util.Log
 *  android.widget.Toast
 *  com.google.android.gms.auth.api.a
 *  com.google.android.gms.auth.api.credentials.Credential
 *  com.google.android.gms.auth.api.credentials.Credential$a
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
 *  com.google.android.gms.common.b
 *  com.google.firebase.auth.q
 *  java.lang.CharSequence
 *  java.lang.IllegalStateException
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.firebase.ui.auth.b.a;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.h;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.firebase.ui.auth.b.a.d;
import com.firebase.ui.auth.c;
import com.firebase.ui.auth.ui.e;
import com.firebase.ui.auth.ui.g;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.k;
import com.google.android.gms.common.api.l;
import com.google.firebase.auth.q;

public class b
extends d<Status> {
    private String c;
    private String d;
    private String e;
    private String f;
    private com.firebase.ui.auth.b g;

    public static b a(h h2, e e2) {
        android.support.v4.app.l l2 = h2.getSupportFragmentManager();
        android.support.v4.app.g g2 = l2.a("SaveSmartLock");
        if (!(g2 instanceof b)) {
            b b2 = new b();
            b2.g(g.a(e2));
            try {
                l2.a().a((android.support.v4.app.g)b2, "SaveSmartLock").a().c();
                return b2;
            }
            catch (IllegalStateException illegalStateException) {
                Log.e((String)"SaveSmartLock", (String)"Cannot add fragment", (Throwable)illegalStateException);
                return null;
            }
        }
        return (b)g2;
    }

    private void b() {
        this.a(-1, com.firebase.ui.auth.b.a(this.g));
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a(int n2, int n3, Intent intent) {
        block3 : {
            block4 : {
                block2 : {
                    super.a(n2, n3, intent);
                    if (n2 != 100) break block2;
                    if (n3 == -1) break block3;
                    break block4;
                }
                if (n2 != 28) {
                    return;
                }
                if (n3 == -1) {
                    Credential credential = new Credential.a(this.d).b(this.e).a();
                    this.a.h().a(this.b, credential).a((l)this);
                    return;
                }
            }
            Log.e((String)"SaveSmartLock", (String)"SAVE: Canceled by user");
        }
        this.b();
    }

    public void a(Bundle bundle) {
        if (TextUtils.isEmpty((CharSequence)this.d)) {
            Log.e((String)"SaveSmartLock", (String)"Unable to save null credential!");
            this.b();
            return;
        }
        Credential.a a2 = new Credential.a(this.d);
        a2.b(this.e);
        if (this.e == null && this.g != null) {
            String string = b.b(this.g.a());
            if (string != null) {
                a2.c(string);
            } else {
                Log.e((String)"SaveSmartLock", (String)"Unable to save null credential!");
                this.b();
                return;
            }
        }
        if (this.c != null) {
            a2.a(this.c);
        }
        if (this.f != null) {
            a2.a(Uri.parse((String)this.f));
        }
        this.a.h().a(this.b, a2.a()).a((l)this);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(Status status) {
        if (!status.d()) {
            if (status.c()) {
                try {
                    this.a.a(status.f().getIntentSender(), 100);
                    return;
                }
                catch (IntentSender.SendIntentException sendIntentException) {
                    Log.e((String)"SaveSmartLock", (String)"STATUS: Failed to send resolution.", (Throwable)sendIntentException);
                }
            } else {
                Log.w((String)"SaveSmartLock", (String)status.a());
            }
        }
        this.b();
    }

    @Override
    public void a(com.google.android.gms.common.b b2) {
        Toast.makeText((Context)this.j(), (int)c.h.general_error, (int)0).show();
        PendingIntent pendingIntent = com.firebase.ui.auth.b.d.a().a(this.j(), b2.c(), 28);
        try {
            this.a.a(pendingIntent.getIntentSender(), 28);
            return;
        }
        catch (IntentSender.SendIntentException sendIntentException) {
            Log.e((String)"SaveSmartLock", (String)"STATUS: Failed to send resolution.", (Throwable)sendIntentException);
            this.b();
            return;
        }
    }

    public void a(q q2, String string, com.firebase.ui.auth.b b2) {
        this.g = b2;
        if (!this.a.c().f) {
            this.b();
            return;
        }
        this.c = q2.g();
        this.d = q2.i();
        this.e = string;
        String string2 = q2.h() != null ? q2.h().toString() : null;
        this.f = string2;
        this.b = new f.a(this.j().getApplicationContext()).a((f.b)this).a((f.c)this).a(com.google.android.gms.auth.api.a.d).a(this.l(), 2, (f.c)this).b();
        this.b.e();
    }
}

