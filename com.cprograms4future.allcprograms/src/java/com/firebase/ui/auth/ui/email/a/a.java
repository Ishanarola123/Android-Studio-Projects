/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.support.design.widget.TextInputLayout
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package com.firebase.ui.auth.ui.email.a;

import android.support.design.widget.TextInputLayout;

public class a {
    protected TextInputLayout a;
    protected String b = "";
    protected String c;

    public a(TextInputLayout textInputLayout) {
        this.a = textInputLayout;
    }

    protected boolean a(CharSequence charSequence) {
        return true;
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean b(CharSequence charSequence) {
        String string;
        TextInputLayout textInputLayout;
        if (this.c != null && (charSequence == null || charSequence.length() == 0)) {
            textInputLayout = this.a;
            string = this.c;
        } else {
            if (this.a(charSequence)) {
                this.a.setError((CharSequence)"");
                return true;
            }
            textInputLayout = this.a;
            string = this.b;
        }
        textInputLayout.setError((CharSequence)string);
        return false;
    }
}

