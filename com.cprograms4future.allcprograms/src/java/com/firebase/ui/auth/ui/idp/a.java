/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.util.Log
 *  com.firebase.ui.auth.b.a.b
 *  com.firebase.ui.auth.ui.accountlink.WelcomeBackIdpPrompt
 *  com.firebase.ui.auth.ui.accountlink.WelcomeBackPasswordPrompt
 *  com.google.android.gms.d.c
 *  com.google.android.gms.d.d
 *  com.google.android.gms.d.e
 *  com.google.android.gms.d.g
 *  com.google.firebase.auth.FirebaseAuth
 *  com.google.firebase.auth.d
 *  com.google.firebase.auth.o
 *  com.google.firebase.auth.q
 *  com.google.firebase.auth.z
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.List
 */
package com.firebase.ui.auth.ui.idp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.firebase.ui.auth.b;
import com.firebase.ui.auth.ui.accountlink.WelcomeBackIdpPrompt;
import com.firebase.ui.auth.ui.accountlink.WelcomeBackPasswordPrompt;
import com.firebase.ui.auth.ui.c;
import com.firebase.ui.auth.ui.e;
import com.firebase.ui.auth.ui.i;
import com.firebase.ui.auth.ui.j;
import com.google.android.gms.d.d;
import com.google.android.gms.d.g;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.o;
import com.google.firebase.auth.q;
import com.google.firebase.auth.z;
import java.util.List;

public class a
implements com.google.android.gms.d.c<com.google.firebase.auth.d> {
    private Activity a;
    private c b;
    private com.firebase.ui.auth.b.a.b c;
    private b d;
    private int e;

    public a(Activity activity, c c2, com.firebase.ui.auth.b.a.b b2, int n2, b b3) {
        this.a = activity;
        this.b = c2;
        this.c = b2;
        this.d = b3;
        this.e = n2;
    }

    public void onComplete(g<com.google.firebase.auth.d> g2) {
        if (g2.b()) {
            q q2 = ((com.google.firebase.auth.d)g2.d()).a();
            this.b.a(this.c, this.a, q2, this.d);
            return;
        }
        if (g2.e() instanceof o) {
            String string = this.d.b();
            if (string != null) {
                this.b.g().a(string).a((d)new i("CredentialSignInHandler", "Error fetching providers for email")).a((com.google.android.gms.d.e)new a()).a(new d(){

                    public void a(Exception exception) {
                    }
                });
                return;
            }
        } else {
            Log.e((String)"CredentialSignInHandler", (String)"Unexpected exception when signing in with credential", (Throwable)g2.e());
        }
        this.b.d();
    }

    private class a
    implements com.google.android.gms.d.e<z> {
        private a() {
        }

        public void a(z z2) {
            a.this.b.d();
            String string = (String)z2.a().get(0);
            if (string.equals((Object)"password")) {
                a.this.a.startActivityForResult(WelcomeBackPasswordPrompt.a((Context)a.this.a, (e)a.this.b.c(), (b)a.this.d), a.this.e);
                return;
            }
            a.this.a.startActivityForResult(WelcomeBackIdpPrompt.a((Context)a.this.a, (e)a.this.b.c(), (j)new j.a(a.this.d.b()).b(string).a(), (b)a.this.d), a.this.e);
        }
    }

}

