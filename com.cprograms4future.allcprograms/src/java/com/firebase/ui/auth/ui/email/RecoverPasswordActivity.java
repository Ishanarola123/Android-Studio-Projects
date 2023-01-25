/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.support.design.widget.TextInputLayout
 *  android.text.Editable
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.EditText
 *  com.google.android.gms.d.d
 *  com.google.android.gms.d.e
 *  com.google.android.gms.d.g
 *  com.google.firebase.auth.FirebaseAuth
 *  java.lang.CharSequence
 *  java.lang.String
 *  java.lang.Void
 */
package com.firebase.ui.auth.ui.email;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import com.firebase.ui.auth.c;
import com.firebase.ui.auth.ui.a;
import com.firebase.ui.auth.ui.b;
import com.firebase.ui.auth.ui.c;
import com.firebase.ui.auth.ui.e;
import com.firebase.ui.auth.ui.email.RecoverPasswordActivity;
import com.firebase.ui.auth.ui.i;
import com.google.android.gms.d.d;
import com.google.android.gms.d.g;
import com.google.firebase.auth.FirebaseAuth;

public class RecoverPasswordActivity
extends b
implements View.OnClickListener {
    private EditText b;
    private com.firebase.ui.auth.ui.email.a.b c;

    public static Intent a(Context context, e e2, String string) {
        return c.a(context, RecoverPasswordActivity.class, e2).putExtra("extra_email", string);
    }

    static /* synthetic */ a a(RecoverPasswordActivity recoverPasswordActivity) {
        return recoverPasswordActivity.a;
    }

    private void a(String string) {
        this.a.g().b(string).a((d)new i("RecoverPasswordActivity", "Error sending password reset email")).a((com.google.android.gms.d.e)new com.google.android.gms.d.e<Void>(this, string){
            final /* synthetic */ String a;
            final /* synthetic */ RecoverPasswordActivity b;
            {
                this.b = recoverPasswordActivity;
                this.a = string;
            }

            public void a(Void void_) {
                RecoverPasswordActivity.c(this.b).d();
                com.firebase.ui.auth.ui.email.b.a(this.a, this.b.getSupportFragmentManager());
            }
        }).a((Activity)this, new d(this){
            final /* synthetic */ RecoverPasswordActivity a;
            {
                this.a = recoverPasswordActivity;
            }

            public void a(java.lang.Exception exception) {
                RecoverPasswordActivity.a(this.a).d();
                if (exception instanceof com.google.firebase.auth.l) {
                    RecoverPasswordActivity.b(this.a).setError((CharSequence)this.a.getString(c.h.error_email_does_not_exist));
                }
            }
        });
    }

    static /* synthetic */ EditText b(RecoverPasswordActivity recoverPasswordActivity) {
        return recoverPasswordActivity.b;
    }

    static /* synthetic */ a c(RecoverPasswordActivity recoverPasswordActivity) {
        return recoverPasswordActivity.a;
    }

    public void onClick(View view) {
        if (view.getId() == c.d.button_done && this.c.b((CharSequence)this.b.getText())) {
            this.a.a(c.h.progress_dialog_sending);
            this.a(this.b.getText().toString());
        }
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(c.f.forgot_password_layout);
        this.c = new com.firebase.ui.auth.ui.email.a.b((TextInputLayout)this.findViewById(c.d.email_layout));
        this.b = (EditText)this.findViewById(c.d.email);
        String string = this.getIntent().getStringExtra("extra_email");
        if (string != null) {
            this.b.setText((CharSequence)string);
        }
        this.findViewById(c.d.button_done).setOnClickListener((View.OnClickListener)this);
    }
}

