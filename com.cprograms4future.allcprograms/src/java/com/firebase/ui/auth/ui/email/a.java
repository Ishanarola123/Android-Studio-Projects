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
 *  android.support.design.widget.TextInputLayout
 *  android.support.v4.app.h
 *  android.text.Editable
 *  android.text.TextUtils
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.EditText
 *  com.google.android.gms.auth.api.a
 *  com.google.android.gms.auth.api.credentials.Credential
 *  com.google.android.gms.auth.api.credentials.CredentialPickerConfig
 *  com.google.android.gms.auth.api.credentials.CredentialPickerConfig$a
 *  com.google.android.gms.auth.api.credentials.HintRequest
 *  com.google.android.gms.auth.api.credentials.HintRequest$a
 *  com.google.android.gms.auth.api.credentials.c
 *  com.google.android.gms.common.api.a
 *  com.google.android.gms.common.api.f
 *  com.google.android.gms.common.api.f$a
 *  com.google.android.gms.common.api.f$c
 *  com.google.android.gms.d.c
 *  com.google.android.gms.d.d
 *  com.google.android.gms.d.e
 *  com.google.android.gms.d.g
 *  com.google.firebase.auth.FirebaseAuth
 *  com.google.firebase.auth.z
 *  java.lang.CharSequence
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.firebase.ui.auth.ui.email;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.h;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.firebase.ui.auth.c;
import com.firebase.ui.auth.ui.e;
import com.firebase.ui.auth.ui.email.a;
import com.firebase.ui.auth.ui.email.a.b;
import com.firebase.ui.auth.ui.f;
import com.firebase.ui.auth.ui.g;
import com.firebase.ui.auth.ui.i;
import com.firebase.ui.auth.ui.j;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.common.api.f;
import com.google.android.gms.d.d;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.z;

public class a
extends f
implements View.OnClickListener {
    private EditText b;
    private b c;
    private a d;
    private Credential e;

    public static a a(e e2, String string) {
        a a2 = new a();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extra_flow_params", (Parcelable)e2);
        bundle.putString("extra_email", string);
        a2.g(bundle);
        return a2;
    }

    static /* synthetic */ Credential a(a a2) {
        return a2.e;
    }

    private PendingIntent ae() {
        com.google.android.gms.common.api.f f2 = new f.a(this.j()).a(com.google.android.gms.auth.api.a.d).a(this.l(), 3, new f.c(this){
            final /* synthetic */ a a;
            {
                this.a = a2;
            }

            public void a(com.google.android.gms.common.b b2) {
                java.lang.StringBuilder stringBuilder = new java.lang.StringBuilder();
                stringBuilder.append("Client connection failed: ");
                stringBuilder.append(b2.e());
                Log.e((String)"CheckEmailFragment", (String)stringBuilder.toString());
            }
        }).b();
        HintRequest hintRequest = new HintRequest.a().a(new CredentialPickerConfig.a().a(true).a()).a(true).a();
        return com.google.android.gms.auth.api.a.g.a(f2, hintRequest);
    }

    static /* synthetic */ a b(a a2) {
        return a2.d;
    }

    private void b() {
        try {
            this.a.a(this.ae().getIntentSender(), 13);
            return;
        }
        catch (IntentSender.SendIntentException sendIntentException) {
            Log.e((String)"CheckEmailFragment", (String)"Unable to start hint intent", (Throwable)sendIntentException);
            return;
        }
    }

    static /* synthetic */ g c(a a2) {
        return a2.a;
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = layoutInflater.inflate(c.f.check_email_layout, viewGroup, false);
        this.b = (EditText)view.findViewById(c.d.email);
        this.c = new b((TextInputLayout)view.findViewById(c.d.email_layout));
        view.findViewById(c.d.button_next).setOnClickListener((View.OnClickListener)this);
        return view;
    }

    public void a() {
        String string = this.b.getText().toString();
        if (this.c.b(string)) {
            this.b(string);
        }
    }

    public void a(int n2, int n3, Intent intent) {
        super.a(n2, n3, intent);
        switch (n2) {
            default: {
                return;
            }
            case 15: 
            case 16: {
                this.a(n3, intent);
                return;
            }
            case 13: 
        }
        if (intent != null) {
            this.e = (Credential)intent.getParcelableExtra("com.google.android.gms.credentials.Credential");
            if (this.e != null) {
                this.b.setText((CharSequence)this.e.a());
                this.a();
            }
        }
    }

    public void b(String string) {
        this.a.a(c.h.progress_dialog_checking_accounts);
        if (!TextUtils.isEmpty((CharSequence)string)) {
            this.a.g().a(string).a((d)new i("CheckEmailFragment", "Error fetching providers for email")).a((Activity)this.l(), (com.google.android.gms.d.c)new com.google.android.gms.d.c<z>(this){
                final /* synthetic */ a a;
                {
                    this.a = a2;
                }

                public void onComplete(com.google.android.gms.d.g<z> g2) {
                    a.c(this.a).d();
                }
            }).a((Activity)this.l(), (com.google.android.gms.d.e)new com.google.android.gms.d.e<z>(this, string){
                final /* synthetic */ String a;
                final /* synthetic */ a b;
                {
                    this.b = a2;
                    this.a = string;
                }

                public void a(z z2) {
                    android.net.Uri uri;
                    java.util.List list = z2.a();
                    if (list != null && !list.isEmpty()) {
                        if ("password".equalsIgnoreCase((String)list.get(0))) {
                            a.b(this.b).a(new com.firebase.ui.auth.ui.j$a(this.a).a());
                            return;
                        }
                        a.b(this.b).b(new com.firebase.ui.auth.ui.j$a(this.a).b((String)list.get(0)).a());
                        return;
                    }
                    Credential credential = a.a(this.b);
                    String string = null;
                    if (credential != null && a.a(this.b).a().equals((Object)this.a)) {
                        string = a.a(this.b).b();
                        uri = a.a(this.b).c();
                    } else {
                        uri = null;
                    }
                    a.b(this.b).c(new com.firebase.ui.auth.ui.j$a(this.a).a(string).a(uri).a());
                }
            });
        }
    }

    public void d(Bundle bundle) {
        super.d(bundle);
        if (this.l() instanceof a) {
            this.d = this.l();
            if (bundle != null) {
                return;
            }
            String string = this.h().getString("extra_email");
            if (!TextUtils.isEmpty((CharSequence)string)) {
                this.b.setText((CharSequence)string);
                this.a();
                return;
            }
            if (this.a.c().f) {
                this.b();
            }
            return;
        }
        throw new IllegalStateException("Activity must implement CheckEmailListener");
    }

    public void e(Bundle bundle) {
        bundle.putBoolean("has_existing_instance", true);
        super.e(bundle);
    }

    public void onClick(View view) {
        if (view.getId() == c.d.button_next) {
            this.a();
        }
    }

}

