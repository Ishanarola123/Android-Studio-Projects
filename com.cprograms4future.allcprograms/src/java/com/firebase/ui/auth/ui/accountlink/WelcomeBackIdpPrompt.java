/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.support.v4.app.h
 *  android.util.Log
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.TextView
 *  android.widget.Toast
 *  com.google.android.gms.d.c
 *  com.google.android.gms.d.d
 *  com.google.android.gms.d.e
 *  com.google.android.gms.d.g
 *  com.google.firebase.auth.FirebaseAuth
 *  com.google.firebase.auth.c
 *  com.google.firebase.auth.d
 *  com.google.firebase.auth.q
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.List
 */
package com.firebase.ui.auth.ui.accountlink;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.h;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.firebase.ui.auth.a;
import com.firebase.ui.auth.a.d;
import com.firebase.ui.auth.c;
import com.firebase.ui.auth.ui.accountlink.WelcomeBackIdpPrompt;
import com.firebase.ui.auth.ui.b;
import com.firebase.ui.auth.ui.c;
import com.firebase.ui.auth.ui.e;
import com.firebase.ui.auth.ui.i;
import com.firebase.ui.auth.ui.j;
import com.google.android.gms.d.d;
import com.google.android.gms.d.g;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.q;
import java.util.List;

public class WelcomeBackIdpPrompt
extends b
implements d.a {
    private com.firebase.ui.auth.a.d b;
    private com.google.firebase.auth.c c;

    public static Intent a(Context context, e e2, j j2, com.firebase.ui.auth.b b2) {
        return c.a(context, WelcomeBackIdpPrompt.class, e2).putExtra("extra_user", (Parcelable)j2).putExtra("extra_idp_response", (Parcelable)b2);
    }

    static /* synthetic */ com.firebase.ui.auth.ui.a a(WelcomeBackIdpPrompt welcomeBackIdpPrompt) {
        return welcomeBackIdpPrompt.a;
    }

    private String a(String string) {
        int n2 = c.h.welcome_back_idp_prompt;
        Object[] arrobject = new Object[]{string, this.b.a((Context)this)};
        return this.getString(n2, arrobject);
    }

    private void a() {
        Toast.makeText((Context)this, (int)c.h.general_error, (int)1).show();
        this.a(0, com.firebase.ui.auth.b.a(20));
    }

    static /* synthetic */ com.firebase.ui.auth.a.d b(WelcomeBackIdpPrompt welcomeBackIdpPrompt) {
        return welcomeBackIdpPrompt.b;
    }

    static /* synthetic */ void c(WelcomeBackIdpPrompt welcomeBackIdpPrompt) {
        welcomeBackIdpPrompt.a();
    }

    static /* synthetic */ com.google.firebase.auth.c d(WelcomeBackIdpPrompt welcomeBackIdpPrompt) {
        return welcomeBackIdpPrompt.c;
    }

    @Override
    public void a(com.firebase.ui.auth.b b2) {
        if (b2 == null) {
            return;
        }
        com.google.firebase.auth.c c2 = com.firebase.ui.auth.a.a.a(b2);
        if (c2 == null) {
            Log.e((String)"WelcomeBackIdpPrompt", (String)"No credential returned");
            this.a(0, com.firebase.ui.auth.b.a(20));
            return;
        }
        q q2 = this.a.i();
        if (q2 == null) {
            this.a.g().a(c2).a((com.google.android.gms.d.e)new com.google.android.gms.d.e<com.google.firebase.auth.d>(this, b2){
                final /* synthetic */ com.firebase.ui.auth.b a;
                final /* synthetic */ WelcomeBackIdpPrompt b;
                {
                    this.b = welcomeBackIdpPrompt;
                    this.a = b2;
                }

                public void a(com.google.firebase.auth.d d2) {
                    if (WelcomeBackIdpPrompt.d(this.b) != null) {
                        d2.a().b(WelcomeBackIdpPrompt.d(this.b)).a((d)new i("WelcomeBackIdpPrompt", "Error signing in with previous credential")).a((com.google.android.gms.d.c)new com.google.android.gms.d.c<com.google.firebase.auth.d>(this.a){
                            private final com.firebase.ui.auth.b b;
                            {
                                this.b = b2;
                            }

                            public void onComplete(g g2) {
                                WelcomeBackIdpPrompt.this.a(-1, com.firebase.ui.auth.b.a(this.b));
                            }
                        });
                        return;
                    }
                    this.b.a(-1, com.firebase.ui.auth.b.a(this.a));
                }
            }).a(new d(this){
                final /* synthetic */ WelcomeBackIdpPrompt a;
                {
                    this.a = welcomeBackIdpPrompt;
                }

                public void a(java.lang.Exception exception) {
                    WelcomeBackIdpPrompt.c(this.a);
                }
            }).a((d)new i("WelcomeBackIdpPrompt", "Error signing in with new credential"));
            return;
        }
        q2.b(c2).a((d)new i("WelcomeBackIdpPrompt", "Error linking with credential")).a((com.google.android.gms.d.c)new /* invalid duplicate definition of identical inner class */);
    }

    @Override
    public void b(Bundle bundle) {
        this.a();
    }

    public void onActivityResult(int n2, int n3, Intent intent) {
        super.onActivityResult(n2, n3, intent);
        this.b.a(n2, n3, intent);
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(c.f.welcome_back_idp_prompt_layout);
        this.c = com.firebase.ui.auth.a.a.a(com.firebase.ui.auth.b.a(this.getIntent()));
        j j2 = j.a(this.getIntent());
        String string = j2.c();
        block5 : for (a.a a2 : this.a.c().b) {
            com.firebase.ui.auth.a.d d2;
            if (!string.equals((Object)a2.a())) continue;
            int n2 = -1;
            int n3 = string.hashCode();
            if (n3 != -1830313082) {
                if (n3 != -1536293812) {
                    if (n3 == -364826023 && string.equals((Object)"facebook.com")) {
                        n2 = 1;
                    }
                } else if (string.equals((Object)"google.com")) {
                    n2 = 0;
                }
            } else if (string.equals((Object)"twitter.com")) {
                n2 = 2;
            }
            switch (n2) {
                default: {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unknown provider: ");
                    stringBuilder.append(string);
                    Log.w((String)"WelcomeBackIdpPrompt", (String)stringBuilder.toString());
                    this.a(0, com.firebase.ui.auth.b.a(20));
                    return;
                }
                case 2: {
                    this.b = new com.firebase.ui.auth.a.e((Context)this);
                    continue block5;
                }
                case 1: {
                    d2 = new com.firebase.ui.auth.a.b((Context)this, a2, this.a.c().c);
                    break;
                }
                case 0: {
                    d2 = new com.firebase.ui.auth.a.c((h)this, a2, j2.a());
                }
            }
            this.b = d2;
        }
        if (this.b == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Firebase login unsuccessful. Account linking failed due to provider not enabled by application: ");
            stringBuilder.append(string);
            Log.w((String)"WelcomeBackIdpPrompt", (String)stringBuilder.toString());
            this.a(0, com.firebase.ui.auth.b.a(20));
            return;
        }
        ((TextView)this.findViewById(c.d.welcome_back_idp_prompt)).setText((CharSequence)this.a(j2.a()));
        this.b.a(this);
        this.findViewById(c.d.welcome_back_idp_button).setOnClickListener(new View.OnClickListener(this){
            final /* synthetic */ WelcomeBackIdpPrompt a;
            {
                this.a = welcomeBackIdpPrompt;
            }

            public void onClick(View view) {
                WelcomeBackIdpPrompt.a(this.a).a(c.h.progress_dialog_signing_in);
                WelcomeBackIdpPrompt.b(this.a).a((android.app.Activity)this.a);
            }
        });
    }

}

