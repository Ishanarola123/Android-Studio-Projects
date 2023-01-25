/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.res.Resources
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.support.design.widget.TextInputLayout
 *  android.support.v4.a.b
 *  android.support.v4.app.h
 *  android.text.Editable
 *  android.text.SpannableStringBuilder
 *  android.text.TextUtils
 *  android.text.style.ForegroundColorSpan
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnFocusChangeListener
 *  android.view.ViewGroup
 *  android.widget.EditText
 *  android.widget.TextView
 *  com.google.android.gms.d.d
 *  com.google.android.gms.d.e
 *  com.google.android.gms.d.g
 *  com.google.firebase.auth.FirebaseAuth
 *  com.google.firebase.auth.d
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.firebase.ui.auth.ui.email;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.h;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.firebase.ui.auth.c;
import com.firebase.ui.auth.ui.e;
import com.firebase.ui.auth.ui.email.a.b;
import com.firebase.ui.auth.ui.email.a.d;
import com.firebase.ui.auth.ui.email.c;
import com.firebase.ui.auth.ui.f;
import com.firebase.ui.auth.ui.g;
import com.firebase.ui.auth.ui.i;
import com.firebase.ui.auth.ui.j;
import com.google.firebase.auth.FirebaseAuth;

public class c
extends f
implements View.OnClickListener,
View.OnFocusChangeListener {
    private d ag;
    private com.firebase.ui.auth.b.a.b ah;
    private j ai;
    private EditText b;
    private EditText c;
    private EditText d;
    private TextView e;
    private TextInputLayout f;
    private TextInputLayout g;
    private b h;
    private com.firebase.ui.auth.ui.email.a.c i;

    public static c a(e e2, j j2) {
        c c2 = new c();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extra_flow_params", (Parcelable)e2);
        bundle.putParcelable("extra_user", (Parcelable)j2);
        c2.g(bundle);
        return c2;
    }

    static /* synthetic */ g a(c c2) {
        return c2.a;
    }

    private void a() {
        if (TextUtils.isEmpty((CharSequence)this.a.c().e)) {
            return;
        }
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(android.support.v4.a.b.c((Context)this.j(), (int)c.c.linkColor));
        String string = this.a(c.h.create_account_preamble);
        String string2 = this.a(c.h.terms_of_service);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(string2);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder((CharSequence)stringBuilder.toString());
        int n2 = string.length();
        spannableStringBuilder.setSpan((Object)foregroundColorSpan, n2, n2 + string2.length(), 0);
        this.e.setText((CharSequence)spannableStringBuilder);
        this.e.setOnClickListener(new View.OnClickListener(this){
            final /* synthetic */ c a;
            {
                this.a = c2;
            }

            public void onClick(View view) {
                android.util.TypedValue typedValue = new android.util.TypedValue();
                this.a.l().getTheme().resolveAttribute(com.firebase.ui.auth.c$b.colorPrimary, typedValue, true);
                int n2 = typedValue.data;
                new android.support.c.c$a().a(n2).a().a((Context)this.a.l(), Uri.parse((String)c.a((c)this.a).c().e));
            }
        });
    }

    private void a(String string, String string2, String string3) {
        this.a.g().b(string, string3).a((com.google.android.gms.d.d)new i("RegisterEmailFragment", "Error creating user")).a((com.google.android.gms.d.e)new com.google.android.gms.d.e<com.google.firebase.auth.d>(this, string2, string3, string){
            final /* synthetic */ String a;
            final /* synthetic */ String b;
            final /* synthetic */ String c;
            final /* synthetic */ c d;
            {
                this.d = c2;
                this.a = string;
                this.b = string2;
                this.c = string3;
            }

            public void a(com.google.firebase.auth.d d2) {
                com.google.firebase.auth.ad ad2 = new com.google.firebase.auth.ad$a().a(this.a).a(c.e(this.d).d()).a();
                com.google.firebase.auth.q q2 = d2.a();
                q2.a(ad2).a((com.google.android.gms.d.d)new i("RegisterEmailFragment", "Error setting display name")).a((com.google.android.gms.d.c)new com.google.android.gms.d.c<java.lang.Void>(this, q2){
                    final /* synthetic */ com.google.firebase.auth.q a;
                    final /* synthetic */ 4 b;
                    {
                        this.b = var1_1;
                        this.a = q2;
                    }

                    public void onComplete(com.google.android.gms.d.g<java.lang.Void> g2) {
                        c.g(this.b.d).a(c.f(this.b.d), (Activity)this.b.d.l(), this.a, this.b.b, new com.firebase.ui.auth.b("password", this.b.c));
                    }
                });
            }
        }).a((Activity)this.l(), new com.google.android.gms.d.d(this){
            final /* synthetic */ c a;
            {
                this.a = c2;
            }

            /*
             * Enabled aggressive block sorting
             */
            public void a(java.lang.Exception exception) {
                String string;
                TextInputLayout textInputLayout;
                c.b(this.a).d();
                if (exception instanceof com.google.firebase.auth.p) {
                    textInputLayout = c.c(this.a);
                    string = this.a.m().getQuantityString(com.firebase.ui.auth.c$g.error_weak_password, c.e.min_password_length);
                } else {
                    c c2;
                    int n2;
                    if (exception instanceof com.google.firebase.auth.k) {
                        textInputLayout = c.d(this.a);
                        c2 = this.a;
                        n2 = c.h.invalid_email_address;
                    } else if (exception instanceof com.google.firebase.auth.o) {
                        textInputLayout = c.d(this.a);
                        c2 = this.a;
                        n2 = c.h.error_user_collision;
                    } else {
                        textInputLayout = c.d(this.a);
                        c2 = this.a;
                        n2 = c.h.email_account_creation_error;
                    }
                    string = c2.a(n2);
                }
                textInputLayout.setError((CharSequence)string);
            }
        });
    }

    static /* synthetic */ g b(c c2) {
        return c2.a;
    }

    private void b(View view) {
        view.post(new Runnable(this, view){
            final /* synthetic */ View a;
            final /* synthetic */ c b;
            {
                this.b = c2;
                this.a = view;
            }

            public void run() {
                this.a.requestFocus();
            }
        });
    }

    static /* synthetic */ TextInputLayout c(c c2) {
        return c2.g;
    }

    static /* synthetic */ TextInputLayout d(c c2) {
        return c2.f;
    }

    static /* synthetic */ j e(c c2) {
        return c2.ai;
    }

    static /* synthetic */ com.firebase.ui.auth.b.a.b f(c c2) {
        return c2.ah;
    }

    static /* synthetic */ g g(c c2) {
        return c2.a;
    }

    /*
     * Enabled aggressive block sorting
     */
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        View view = layoutInflater.inflate(c.f.register_email_layout, viewGroup, false);
        this.i = new com.firebase.ui.auth.ui.email.a.c((TextInputLayout)view.findViewById(c.d.password_layout), this.m().getInteger(c.e.min_password_length));
        this.ag = new d((TextInputLayout)view.findViewById(c.d.name_layout));
        this.h = new b((TextInputLayout)view.findViewById(c.d.email_layout));
        this.b = (EditText)view.findViewById(c.d.email);
        this.c = (EditText)view.findViewById(c.d.name);
        this.d = (EditText)view.findViewById(c.d.password);
        this.e = (TextView)view.findViewById(c.d.create_account_text);
        this.f = (TextInputLayout)view.findViewById(c.d.email_layout);
        this.g = (TextInputLayout)view.findViewById(c.d.password_layout);
        this.b.setOnFocusChangeListener((View.OnFocusChangeListener)this);
        this.c.setOnFocusChangeListener((View.OnFocusChangeListener)this);
        this.d.setOnFocusChangeListener((View.OnFocusChangeListener)this);
        view.findViewById(c.d.button_create).setOnClickListener((View.OnClickListener)this);
        if (bundle != null) {
            return view;
        }
        String string2 = this.ai.a();
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            this.b.setText((CharSequence)string2);
        }
        if (!TextUtils.isEmpty((CharSequence)(string = this.ai.b()))) {
            this.c.setText((CharSequence)string);
        }
        EditText editText = !TextUtils.isEmpty((CharSequence)this.c.getText()) ? this.d : (!TextUtils.isEmpty((CharSequence)this.b.getText()) ? this.c : this.b);
        this.b((View)editText);
        return view;
    }

    @Override
    public void b_(Bundle bundle) {
        super.b_(bundle);
        if (bundle == null) {
            bundle = this.h();
        }
        this.ai = j.a(bundle);
    }

    public void d(Bundle bundle) {
        super.d(bundle);
        this.l().setTitle(c.h.title_register_email);
        this.ah = this.a.a(this.l());
        this.a();
    }

    public void e(Bundle bundle) {
        bundle.putParcelable("extra_user", (Parcelable)new j.a(this.b.getText().toString()).a(this.c.getText().toString()).a(this.ai.d()).a());
        super.e(bundle);
    }

    public void onClick(View view) {
        if (view.getId() == c.d.button_create) {
            String string = this.b.getText().toString();
            String string2 = this.d.getText().toString();
            String string3 = this.c.getText().toString();
            boolean bl = this.h.b(string);
            boolean bl2 = this.i.b(string2);
            boolean bl3 = this.ag.b(string3);
            if (bl && bl2 && bl3) {
                this.a.a(c.h.progress_dialog_signing_up);
                this.a(string, string3, string2);
            }
        }
    }

    public void onFocusChange(View view, boolean bl) {
        if (bl) {
            return;
        }
        int n2 = view.getId();
        if (n2 == c.d.email) {
            this.h.b((CharSequence)this.b.getText());
            return;
        }
        if (n2 == c.d.name) {
            this.ag.b((CharSequence)this.c.getText());
            return;
        }
        if (n2 == c.d.password) {
            this.i.b((CharSequence)this.d.getText());
        }
    }
}

