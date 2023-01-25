/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.ProgressDialog
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentSender
 *  android.content.IntentSender$SendIntentException
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.support.v4.app.g
 *  android.support.v4.app.h
 *  java.lang.CharSequence
 *  java.lang.String
 */
package com.firebase.ui.auth.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.h;
import com.firebase.ui.auth.ui.c;
import com.firebase.ui.auth.ui.e;

public class g
extends c {
    private android.support.v4.app.g c;

    public g(android.support.v4.app.g g2) {
        super(g2.j().getApplicationContext(), (e)g2.h().getParcelable("extra_flow_params"));
        this.c = g2;
    }

    public static Bundle a(e e2) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("extra_flow_params", (Parcelable)e2);
        return bundle;
    }

    public void a(int n2, Intent intent) {
        this.a((Activity)this.c.l(), n2, intent);
    }

    public void a(IntentSender intentSender, int n2) throws IntentSender.SendIntentException {
        this.c.a(intentSender, n2, null, 0, 0, 0, null);
    }

    @Override
    public void a(String string) {
        this.d();
        this.b = ProgressDialog.show((Context)this.c.j(), (CharSequence)"", (CharSequence)string, (boolean)true);
    }
}

