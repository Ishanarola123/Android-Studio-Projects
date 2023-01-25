/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.support.v4.app.g
 *  android.support.v4.app.h
 *  android.support.v4.app.l
 *  android.support.v4.app.q
 *  android.util.Log
 *  com.google.android.gms.d.c
 *  com.google.android.gms.d.d
 *  com.google.android.gms.d.g
 *  com.google.firebase.auth.FirebaseAuth
 *  com.google.firebase.auth.c
 *  java.lang.IllegalStateException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.List
 */
package com.firebase.ui.auth.b.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.h;
import android.support.v4.app.l;
import android.support.v4.app.q;
import android.util.Log;
import com.firebase.ui.auth.a;
import com.firebase.ui.auth.a.d;
import com.firebase.ui.auth.b.a.b;
import com.firebase.ui.auth.ui.e;
import com.firebase.ui.auth.ui.f;
import com.firebase.ui.auth.ui.i;
import com.firebase.ui.auth.ui.j;
import com.google.android.gms.d.c;
import com.google.android.gms.d.d;
import com.google.android.gms.d.g;
import com.google.firebase.auth.FirebaseAuth;
import java.util.List;

public class a
extends f
implements d.a {
    private com.firebase.ui.auth.a.d b;
    private b c;

    public static a a(h h2) {
        android.support.v4.app.g g2 = h2.getSupportFragmentManager().a("IDPSignInContainer");
        if (g2 instanceof a) {
            return (a)g2;
        }
        return null;
    }

    public static void a(h h2, e e2, j j2) {
        l l2 = h2.getSupportFragmentManager();
        if (!(l2.a("IDPSignInContainer") instanceof a)) {
            a a2 = new a();
            Bundle bundle = com.firebase.ui.auth.ui.g.a(e2);
            bundle.putParcelable("extra_user", (Parcelable)j2);
            a2.g(bundle);
            try {
                l2.a().a((android.support.v4.app.g)a2, "IDPSignInContainer").a().c();
                return;
            }
            catch (IllegalStateException illegalStateException) {
                Log.e((String)"IDPSignInContainer", (String)"Cannot add fragment", (Throwable)illegalStateException);
            }
        }
    }

    public void a(int n2, int n3, Intent intent) {
        super.a(n2, n3, intent);
        if (n2 == 4) {
            this.a(n3, intent);
            return;
        }
        this.b.a(n2, n3, intent);
    }

    @Override
    public void a(com.firebase.ui.auth.b b2) {
        com.google.firebase.auth.c c2 = com.firebase.ui.auth.a.a.a(b2);
        g g2 = this.a.g().a(c2).a((d)new i("IDPSignInContainer", "Failure authenticating with credential"));
        com.firebase.ui.auth.ui.idp.a a2 = new com.firebase.ui.auth.ui.idp.a((Activity)this.l(), this.a, this.c, 4, b2);
        g2.a((c)a2);
    }

    @Override
    public void b(Bundle bundle) {
        this.a(0, com.firebase.ui.auth.b.a(20));
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void b_(Bundle bundle) {
        block7 : {
            com.firebase.ui.auth.a.d d2;
            block9 : {
                String string;
                block8 : {
                    a.a a22;
                    block6 : {
                        j j2;
                        block5 : {
                            super.b_(bundle);
                            this.c = this.a.a(this.l());
                            j2 = j.a(this.h());
                            string = j2.c();
                            for (a.a a22 : this.a.c().b) {
                                if (!a22.a().equalsIgnoreCase(string)) continue;
                                break block5;
                            }
                            a22 = null;
                        }
                        if (a22 == null) {
                            this.a(0, com.firebase.ui.auth.b.a(20));
                            return;
                        }
                        if (!string.equalsIgnoreCase("google.com")) break block6;
                        this.b = new com.firebase.ui.auth.a.c(this.l(), a22, j2.a());
                        break block7;
                    }
                    if (!string.equalsIgnoreCase("facebook.com")) break block8;
                    d2 = new com.firebase.ui.auth.a.b(this.j(), a22, this.a.c().c);
                    break block9;
                }
                if (!string.equalsIgnoreCase("twitter.com")) break block7;
                d2 = new com.firebase.ui.auth.a.e(this.j());
            }
            this.b = d2;
        }
        this.b.a(this);
        this.b.a((Activity)this.l());
    }
}

