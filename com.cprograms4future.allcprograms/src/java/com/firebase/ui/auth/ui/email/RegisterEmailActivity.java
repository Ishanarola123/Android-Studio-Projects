/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.support.v4.app.g
 *  android.support.v4.app.l
 *  android.support.v4.app.q
 *  android.view.View
 *  java.lang.String
 */
package com.firebase.ui.auth.ui.email;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.g;
import android.support.v4.app.l;
import android.support.v4.app.q;
import android.view.View;
import com.firebase.ui.auth.b;
import com.firebase.ui.auth.c;
import com.firebase.ui.auth.ui.a;
import com.firebase.ui.auth.ui.accountlink.WelcomeBackIdpPrompt;
import com.firebase.ui.auth.ui.accountlink.WelcomeBackPasswordPrompt;
import com.firebase.ui.auth.ui.e;
import com.firebase.ui.auth.ui.email.a;
import com.firebase.ui.auth.ui.j;

public class RegisterEmailActivity
extends com.firebase.ui.auth.ui.b
implements a.a {
    public static Intent a(Context context, e e2) {
        return RegisterEmailActivity.a(context, e2, null);
    }

    public static Intent a(Context context, e e2, String string) {
        return com.firebase.ui.auth.ui.c.a(context, RegisterEmailActivity.class, e2).putExtra("extra_email", string);
    }

    private void a() {
        this.overridePendingTransition(c.a.slide_in_right, c.a.slide_out_left);
    }

    @Override
    public void a(j j2) {
        this.startActivityForResult(WelcomeBackPasswordPrompt.a((Context)this, this.a.c(), new b("password", j2.a())), 17);
        this.a();
    }

    @Override
    public void b(j j2) {
        Intent intent = WelcomeBackIdpPrompt.a((Context)this, this.a.c(), j2, new b("password", j2.a()));
        this.a.a(intent, 18);
        this.a();
    }

    @Override
    public void c(j j2) {
        com.firebase.ui.auth.ui.email.c c2 = com.firebase.ui.auth.ui.email.c.a(this.a.c(), j2);
        q q2 = this.getSupportFragmentManager().a().b(c.d.fragment_register_email, (g)c2, "RegisterEmailFragment");
        View view = this.findViewById(c.d.email_layout);
        if (view != null) {
            q2.a(view, "email_field");
        }
        q2.a().c();
    }

    protected void onActivityResult(int n2, int n3, Intent intent) {
        super.onActivityResult(n2, n3, intent);
        switch (n2) {
            default: {
                return;
            }
            case 17: 
            case 18: 
        }
        this.a(n3, intent);
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(c.f.activity_register_email);
        if (bundle != null) {
            return;
        }
        String string = this.getIntent().getExtras().getString("extra_email");
        com.firebase.ui.auth.ui.email.a a2 = com.firebase.ui.auth.ui.email.a.a(this.a.c(), string);
        this.getSupportFragmentManager().a().b(c.d.fragment_register_email, (g)a2, "CheckEmailFragment").a().c();
    }

    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("has_existing_instance", true);
        super.onSaveInstanceState(bundle);
    }
}

