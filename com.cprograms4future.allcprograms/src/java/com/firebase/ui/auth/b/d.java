/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 *  com.google.android.gms.common.e
 *  java.lang.Object
 */
package com.firebase.ui.auth.b;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.google.android.gms.common.e;

public class d {
    private static e a;

    public static e a() {
        if (a == null) {
            a = e.a();
        }
        return a;
    }

    public static boolean a(Activity activity, int n2, DialogInterface.OnCancelListener onCancelListener) {
        Dialog dialog = d.a().a(activity, d.a().a((Context)activity), n2, onCancelListener);
        if (dialog == null) {
            return true;
        }
        dialog.show();
        return false;
    }
}

