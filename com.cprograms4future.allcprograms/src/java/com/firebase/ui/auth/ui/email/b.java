/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.DialogInterface$OnDismissListener
 *  android.os.Bundle
 *  android.support.v4.app.l
 *  android.support.v7.app.d
 *  android.support.v7.app.d$a
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package com.firebase.ui.auth.ui.email;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.l;
import android.support.v7.app.d;
import com.firebase.ui.auth.c;
import com.firebase.ui.auth.ui.d;
import com.firebase.ui.auth.ui.email.b;

public class b
extends d {
    public static void a(String string, l l2) {
        b b2 = new b();
        Bundle bundle = new Bundle();
        bundle.putString("extra_email", string);
        b2.g(bundle);
        b2.a(l2, "RecoveryEmailSentDialog");
    }

    public Dialog c(Bundle bundle) {
        d.a a2 = new d.a(this.j(), c.i.FirebaseUI_Dialog).a(c.h.title_confirm_recover_password);
        int n2 = c.h.confirm_recovery_body;
        Object[] arrobject = new Object[]{this.h().getString("extra_email")};
        return a2.b((CharSequence)this.a(n2, arrobject)).a(new DialogInterface.OnDismissListener(this){
            final /* synthetic */ b a;
            {
                this.a = b2;
            }

            public void onDismiss(DialogInterface dialogInterface) {
                this.a.a(-1, new android.content.Intent());
            }
        }).a(17039370, null).c();
    }
}

