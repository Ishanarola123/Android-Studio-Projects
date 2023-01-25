/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.support.design.widget.TextInputLayout
 *  java.lang.CharSequence
 *  java.lang.String
 */
package com.firebase.ui.auth.ui.email.a;

import android.content.res.Resources;
import android.support.design.widget.TextInputLayout;
import com.firebase.ui.auth.c;
import com.firebase.ui.auth.ui.email.a.a;

public class d
extends a {
    public d(TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.b = this.a.getResources().getString(c.h.required_field);
    }

    @Override
    protected boolean a(CharSequence charSequence) {
        return charSequence != null && charSequence.length() > 0;
    }
}

