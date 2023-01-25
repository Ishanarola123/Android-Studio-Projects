/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.support.design.widget.TextInputLayout
 *  android.util.Patterns
 *  java.lang.CharSequence
 *  java.lang.String
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package com.firebase.ui.auth.ui.email.a;

import android.content.res.Resources;
import android.support.design.widget.TextInputLayout;
import android.util.Patterns;
import com.firebase.ui.auth.c;
import com.firebase.ui.auth.ui.email.a.a;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class b
extends a {
    public b(TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.b = this.a.getResources().getString(c.h.invalid_email_address);
        this.c = this.a.getResources().getString(c.h.missing_email_address);
    }

    @Override
    protected boolean a(CharSequence charSequence) {
        return Patterns.EMAIL_ADDRESS.matcher(charSequence).matches();
    }
}

