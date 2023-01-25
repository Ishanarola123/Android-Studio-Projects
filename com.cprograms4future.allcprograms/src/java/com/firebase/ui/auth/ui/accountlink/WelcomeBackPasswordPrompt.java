/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.support.design.widget.TextInputLayout
 *  android.text.Editable
 *  android.text.SpannableStringBuilder
 *  android.text.TextUtils
 *  android.text.style.StyleSpan
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.Window
 *  android.widget.EditText
 *  android.widget.TextView
 *  com.google.android.gms.d.d
 *  com.google.android.gms.d.e
 *  com.google.android.gms.d.g
 *  com.google.firebase.auth.FirebaseAuth
 *  com.google.firebase.auth.d
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package com.firebase.ui.auth.ui.accountlink;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import com.firebase.ui.auth.c;
import com.firebase.ui.auth.ui.a;
import com.firebase.ui.auth.ui.accountlink.WelcomeBackPasswordPrompt;
import com.firebase.ui.auth.ui.b;
import com.firebase.ui.auth.ui.c;
import com.firebase.ui.auth.ui.e;
import com.firebase.ui.auth.ui.email.RecoverPasswordActivity;
import com.firebase.ui.auth.ui.i;
import com.google.android.gms.d.d;
import com.google.android.gms.d.g;
import com.google.firebase.auth.FirebaseAuth;

public class WelcomeBackPasswordPrompt
extends b
implements View.OnClickListener {
    private String b;
    private TextInputLayout c;
    private EditText d;
    private com.firebase.ui.auth.b e;
    private com.firebase.ui.auth.b.a.b f;

    public static Intent a(Context context, e e2, com.firebase.ui.auth.b b2) {
        return c.a(context, WelcomeBackPasswordPrompt.class, e2).putExtra("extra_idp_response", (Parcelable)b2);
    }

    static /* synthetic */ a a(WelcomeBackPasswordPrompt welcomeBackPasswordPrompt) {
        return welcomeBackPasswordPrompt.a;
    }

    private void a(String string, String string2) {
        if (TextUtils.isEmpty((CharSequence)string2)) {
            this.c.setError((CharSequence)this.getString(c.h.required_field));
            return;
        }
        this.c.setError(null);
        this.a.a(c.h.progress_dialog_signing_in);
        this.a.g().a(string, string2).a((d)new i("WelcomeBackPassword", "Error signing in with email and password")).a((com.google.android.gms.d.e)new com.google.android.gms.d.e<com.google.firebase.auth.d>(this, string2, string){
            final /* synthetic */ String a;
            final /* synthetic */ String b;
            final /* synthetic */ WelcomeBackPasswordPrompt c;
            {
                this.c = welcomeBackPasswordPrompt;
                this.a = string;
                this.b = string2;
            }

            public void a(com.google.firebase.auth.d d2) {
                com.google.firebase.auth.c c2 = com.firebase.ui.auth.a.a.a(WelcomeBackPasswordPrompt.c(this.c));
                if (c2 == null) {
                    WelcomeBackPasswordPrompt.e(this.c).a(WelcomeBackPasswordPrompt.d(this.c), d2.a(), this.a, new com.firebase.ui.auth.b("password", this.b));
                    return;
                }
                d2.a().b(c2).a((d)new i("WelcomeBackPassword", "Error signing in with credential")).a((com.google.android.gms.d.e)new com.google.android.gms.d.e<com.google.firebase.auth.d>(this){
                    final /* synthetic */ 2 a;
                    {
                        this.a = var1_1;
                    }

                    public void a(com.google.firebase.auth.d d2) {
                        WelcomeBackPasswordPrompt.f(this.a.c).a(WelcomeBackPasswordPrompt.d(this.a.c), d2.a(), WelcomeBackPasswordPrompt.c(this.a.c));
                    }
                });
            }
        }).a((Activity)this, new d(this){
            final /* synthetic */ WelcomeBackPasswordPrompt a;
            {
                this.a = welcomeBackPasswordPrompt;
            }

            public void a(java.lang.Exception exception) {
                WelcomeBackPasswordPrompt.a(this.a).d();
                String string = exception.getLocalizedMessage();
                WelcomeBackPasswordPrompt.b(this.a).setError((CharSequence)string);
            }
        });
    }

    static /* synthetic */ TextInputLayout b(WelcomeBackPasswordPrompt welcomeBackPasswordPrompt) {
        return welcomeBackPasswordPrompt.c;
    }

    static /* synthetic */ com.firebase.ui.auth.b c(WelcomeBackPasswordPrompt welcomeBackPasswordPrompt) {
        return welcomeBackPasswordPrompt.e;
    }

    static /* synthetic */ com.firebase.ui.auth.b.a.b d(WelcomeBackPasswordPrompt welcomeBackPasswordPrompt) {
        return welcomeBackPasswordPrompt.f;
    }

    static /* synthetic */ a e(WelcomeBackPasswordPrompt welcomeBackPasswordPrompt) {
        return welcomeBackPasswordPrompt.a;
    }

    static /* synthetic */ a f(WelcomeBackPasswordPrompt welcomeBackPasswordPrompt) {
        return welcomeBackPasswordPrompt.a;
    }

    public void onClick(View view) {
        int n2 = view.getId();
        if (n2 == c.d.button_done) {
            this.a(this.b, this.d.getText().toString());
            return;
        }
        if (n2 == c.d.trouble_signing_in) {
            this.startActivity(RecoverPasswordActivity.a((Context)this, this.a.c(), this.b));
            this.a(0, com.firebase.ui.auth.b.a(20));
        }
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(c.f.welcome_back_password_prompt_layout);
        this.getWindow().setSoftInputMode(4);
        this.f = this.a.b();
        this.e = com.firebase.ui.auth.b.a(this.getIntent());
        this.b = this.e.b();
        this.c = (TextInputLayout)this.findViewById(c.d.password_layout);
        this.d = (EditText)this.findViewById(c.d.password);
        int n2 = c.h.welcome_back_password_prompt_body;
        Object[] arrobject = new Object[]{this.b};
        String string = this.getString(n2, arrobject);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder((CharSequence)string);
        int n3 = string.indexOf(this.b);
        spannableStringBuilder.setSpan((Object)new StyleSpan(1), n3, n3 + this.b.length(), 18);
        ((TextView)this.findViewById(c.d.welcome_back_password_body)).setText((CharSequence)spannableStringBuilder);
        this.findViewById(c.d.button_done).setOnClickListener((View.OnClickListener)this);
        this.findViewById(c.d.trouble_signing_in).setOnClickListener((View.OnClickListener)this);
    }
}

