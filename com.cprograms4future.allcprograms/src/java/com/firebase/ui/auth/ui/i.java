/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.google.android.gms.d.d
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.firebase.ui.auth.ui;

import android.util.Log;
import com.google.android.gms.d.d;

public class i
implements d {
    private String a;
    private String b;

    public i(String string, String string2) {
        this.a = string;
        this.b = string2;
    }

    public void a(Exception exception) {
        Log.w((String)this.a, (String)this.b, (Throwable)exception);
    }
}

