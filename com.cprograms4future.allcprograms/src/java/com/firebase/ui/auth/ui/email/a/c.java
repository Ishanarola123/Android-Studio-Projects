/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.support.design.widget.TextInputLayout
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package com.firebase.ui.auth.ui.email.a;

import android.content.res.Resources;
import android.support.design.widget.TextInputLayout;
import com.firebase.ui.auth.c;
import com.firebase.ui.auth.ui.email.a.a;

public class c
extends a {
    private int d;

    public c(TextInputLayout textInputLayout, int n2) {
        super(textInputLayout);
        this.d = n2;
        Resources resources = this.a.getResources();
        int n3 = c.g.error_weak_password;
        int n4 = this.d;
        Object[] arrobject = new Object[]{this.d};
        this.b = resources.getQuantityString(n3, n4, arrobject);
    }

    @Override
    protected boolean a(CharSequence charSequence) {
        return charSequence.length() >= this.d;
    }
}

