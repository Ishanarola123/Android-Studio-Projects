/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.support.v4.app.h
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  com.google.android.gms.d.c
 *  com.google.android.gms.d.d
 *  com.google.android.gms.d.g
 *  com.google.firebase.auth.FirebaseAuth
 *  com.google.firebase.auth.c
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 */
package com.firebase.ui.auth.ui.idp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.h;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.firebase.ui.auth.a;
import com.firebase.ui.auth.a.d;
import com.firebase.ui.auth.c;
import com.firebase.ui.auth.ui.b;
import com.firebase.ui.auth.ui.c;
import com.firebase.ui.auth.ui.e;
import com.firebase.ui.auth.ui.email.RegisterEmailActivity;
import com.firebase.ui.auth.ui.i;
import com.firebase.ui.auth.ui.idp.AuthMethodPickerActivity;
import com.firebase.ui.auth.ui.idp.a;
import com.google.android.gms.d.d;
import com.google.android.gms.d.g;
import com.google.firebase.auth.FirebaseAuth;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AuthMethodPickerActivity
extends b
implements View.OnClickListener,
d.a {
    private ArrayList<com.firebase.ui.auth.a.d> b;
    private com.firebase.ui.auth.b.a.b c;

    public static Intent a(Context context, e e2) {
        return c.a(context, AuthMethodPickerActivity.class, e2);
    }

    static /* synthetic */ com.firebase.ui.auth.ui.a a(AuthMethodPickerActivity authMethodPickerActivity) {
        return authMethodPickerActivity.a;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void a(List<a.a> var1_1) {
        this.b = new ArrayList();
        var2_2 = var1_1.iterator();
        block11 : do {
            block20 : {
                block17 : {
                    block18 : {
                        block19 : {
                            var3_5 = var2_2.hasNext();
                            var4_6 = 1;
                            if (!var3_5) break;
                            var18_3 = (a.a)var2_2.next();
                            var19_4 = var18_3.a();
                            var20_7 = var19_4.hashCode();
                            if (var20_7 == -1830313082) break block17;
                            if (var20_7 == -1536293812) break block18;
                            if (var20_7 == -364826023) break block19;
                            if (var20_7 != 1216985755 || !var19_4.equals((Object)"password")) ** GOTO lbl-1000
                            var4_6 = 3;
                            break block20;
                        }
                        if (!var19_4.equals((Object)"facebook.com")) ** GOTO lbl-1000
                        break block20;
                    }
                    if (!var19_4.equals((Object)"google.com")) ** GOTO lbl-1000
                    var4_6 = 0;
                    break block20;
                }
                if (var19_4.equals((Object)"twitter.com")) {
                    var4_6 = 2;
                } else lbl-1000: // 4 sources:
                {
                    var4_6 = -1;
                }
            }
            switch (var4_6) {
                default: {
                    var25_10 = new StringBuilder();
                    var25_10.append("Encountered unknown IDPProvider parcel with type: ");
                    var25_10.append(var18_3.a());
                    Log.e((String)"AuthMethodPicker", (String)var25_10.toString());
                    continue block11;
                }
                case 3: {
                    this.findViewById(c.d.email_provider).setVisibility(0);
                    continue block11;
                }
                case 2: {
                    this.b.add((Object)new com.firebase.ui.auth.a.e((Context)this));
                    continue block11;
                }
                case 1: {
                    var21_8 = this.b;
                    var22_9 /* !! */  = new com.firebase.ui.auth.a.b((Context)this, var18_3, this.a.c().c);
                    ** break;
                }
                case 0: 
            }
            var21_8 = this.b;
            var22_9 /* !! */  = new com.firebase.ui.auth.a.c((h)this, var18_3);
lbl49: // 2 sources:
            var21_8.add((Object)var22_9 /* !! */ );
        } while (true);
        var5_11 = (ViewGroup)this.findViewById(c.d.btn_holder);
        var6_12 = this.b.iterator();
        while (var6_12.hasNext() != false) {
            block23 : {
                block21 : {
                    block22 : {
                        var7_13 = (com.firebase.ui.auth.a.d)var6_12.next();
                        var8_14 = var7_13.b();
                        var9_15 = var8_14.hashCode();
                        if (var9_15 == -1830313082) break block21;
                        if (var9_15 == -1536293812) break block22;
                        if (var9_15 != -364826023 || !var8_14.equals((Object)"facebook.com")) ** GOTO lbl-1000
                        var10_16 = 1;
                        break block23;
                    }
                    if (!var8_14.equals((Object)"google.com")) ** GOTO lbl-1000
                    var10_16 = 0;
                    break block23;
                }
                if (var8_14.equals((Object)"twitter.com")) {
                    var10_16 = 2;
                } else lbl-1000: // 3 sources:
                {
                    var10_16 = -1;
                }
            }
            switch (var10_16) {
                default: {
                    var14_20 = new StringBuilder();
                    var14_20.append("No button for provider ");
                    var14_20.append(var7_13.b());
                    Log.e((String)"AuthMethodPicker", (String)var14_20.toString());
                    var13_19 = null;
                    break;
                }
                case 2: {
                    var11_17 = this.getLayoutInflater();
                    var12_18 = c.f.idp_button_twitter;
                    ** break;
                }
                case 1: {
                    var11_17 = this.getLayoutInflater();
                    var12_18 = c.f.idp_button_facebook;
                    ** break;
                }
                case 0: {
                    var11_17 = this.getLayoutInflater();
                    var12_18 = c.f.idp_button_google;
lbl91: // 3 sources:
                    var13_19 = var11_17.inflate(var12_18, var5_11, false);
                }
            }
            if (var13_19 == null) continue;
            var13_19.setOnClickListener(new View.OnClickListener(this, var7_13){
                final /* synthetic */ com.firebase.ui.auth.a.d a;
                final /* synthetic */ AuthMethodPickerActivity b;
                {
                    this.b = authMethodPickerActivity;
                    this.a = d2;
                }

                public void onClick(View view) {
                    AuthMethodPickerActivity.a(this.b).a(com.firebase.ui.auth.c$h.progress_dialog_loading);
                    this.a.a((Activity)this.b);
                }
            });
            var7_13.a(this);
            var5_11.addView(var13_19, 0);
        }
    }

    @Override
    public void a(com.firebase.ui.auth.b b2) {
        com.google.firebase.auth.c c2 = com.firebase.ui.auth.a.a.a(b2);
        g g2 = this.a.g().a(c2).a((d)new i("AuthMethodPicker", "Firebase sign in with credential unsuccessful"));
        a a2 = new a((Activity)this, this.a, this.c, 3, b2);
        g2.a((com.google.android.gms.d.c)a2);
    }

    @Override
    public void b(Bundle bundle) {
        this.a.d();
    }

    public void onActivityResult(int n2, int n3, Intent intent) {
        super.onActivityResult(n2, n3, intent);
        if (n2 == 2) {
            if (n3 == -1) {
                this.a(-1, intent);
                return;
            }
        } else {
            if (n2 == 3) {
                this.a(n3, intent);
                return;
            }
            Iterator iterator = this.b.iterator();
            while (iterator.hasNext()) {
                ((com.firebase.ui.auth.a.d)iterator.next()).a(n2, n3, intent);
            }
        }
    }

    public void onClick(View view) {
        if (view.getId() == c.d.email_provider) {
            this.startActivityForResult(RegisterEmailActivity.a((Context)this, this.a.c()), 2);
        }
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(c.f.auth_method_picker_layout);
        this.c = this.a.b();
        this.findViewById(c.d.email_provider).setOnClickListener((View.OnClickListener)this);
        this.a(this.a.c().b);
        int n2 = this.a.c().d;
        ImageView imageView = (ImageView)this.findViewById(c.d.logo);
        if (n2 == -1) {
            imageView.setVisibility(8);
            return;
        }
        imageView.setImageResource(n2);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (this.b != null) {
            for (com.firebase.ui.auth.a.d d2 : this.b) {
                if (!(d2 instanceof com.firebase.ui.auth.a.c)) continue;
                ((com.firebase.ui.auth.a.c)d2).a();
            }
        }
    }
}

