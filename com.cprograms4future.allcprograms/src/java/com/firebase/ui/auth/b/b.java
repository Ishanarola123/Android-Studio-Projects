/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  com.firebase.ui.auth.b.b$1
 *  com.firebase.ui.auth.b.b$2
 *  com.google.android.gms.auth.api.a
 *  com.google.android.gms.auth.api.credentials.Credential
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.common.api.a
 *  com.google.android.gms.common.api.f
 *  com.google.android.gms.common.api.f$a
 *  com.google.android.gms.d.a
 *  com.google.android.gms.d.g
 *  java.lang.Object
 */
package com.firebase.ui.auth.b;

import android.app.Activity;
import com.firebase.ui.auth.b.b;
import com.firebase.ui.auth.b.c;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.f;
import com.google.android.gms.d.g;

public class b {
    private final c a;

    private b(c c2) {
        this.a = c2;
    }

    public static b a(Activity activity) {
        c c2 = c.a(activity);
        c2.b().a(com.google.android.gms.auth.api.a.d);
        return b.a(c2);
    }

    public static b a(c c2) {
        return new b(c2);
    }

    public g<Status> a() {
        return this.a.a().b((com.google.android.gms.d.a)new 2(this));
    }

    public g<Status> a(Credential credential) {
        return this.a.a().b((com.google.android.gms.d.a)new 1(this, credential));
    }
}

