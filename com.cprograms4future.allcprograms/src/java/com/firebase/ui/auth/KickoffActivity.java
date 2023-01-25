/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.Intent
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 *  android.os.Bundle
 *  android.support.v4.app.h
 *  android.util.Log
 *  java.lang.Object
 *  java.lang.String
 */
package com.firebase.ui.auth;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import com.firebase.ui.auth.KickoffActivity;
import com.firebase.ui.auth.b;
import com.firebase.ui.auth.b.a.c;
import com.firebase.ui.auth.b.d;
import com.firebase.ui.auth.ui.a;
import com.firebase.ui.auth.ui.e;
import com.firebase.ui.auth.ui.h;

public class KickoffActivity
extends h {
    private boolean b = false;

    public static Intent a(Context context, e e2) {
        return a.a(context, KickoffActivity.class, e2);
    }

    private boolean a() {
        ConnectivityManager connectivityManager = (ConnectivityManager)this.getSystemService("connectivity");
        return connectivityManager == null || connectivityManager.getActiveNetworkInfo() == null || !connectivityManager.getActiveNetworkInfo().isConnectedOrConnecting();
        {
        }
    }

    protected void onActivityResult(int n2, int n3, Intent intent) {
        super.onActivityResult(n2, n3, intent);
        if (n2 == 1) {
            if (n3 == -1) {
                c.a((android.support.v4.app.h)this, this.a.c());
                return;
            }
            this.a(0, b.a(20));
            return;
        }
        c c2 = c.a((android.support.v4.app.h)this);
        if (c2 != null) {
            c2.a(n2, n3, intent);
        }
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null || bundle.getBoolean("is_waiting_for_play_services")) {
            if (this.a()) {
                Log.d((String)"KickoffActivity", (String)"No network connection");
                this.a(10, b.a(10));
                return;
            }
            if (d.a((Activity)this, 1, new DialogInterface.OnCancelListener(this){
                final /* synthetic */ KickoffActivity a;
                {
                    this.a = kickoffActivity;
                }

                public void onCancel(DialogInterface dialogInterface) {
                    this.a.a(0, b.a(20));
                }
            })) {
                c.a((android.support.v4.app.h)this, this.a.c());
                return;
            }
            this.b = true;
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("has_existing_instance", true);
        bundle.putBoolean("is_waiting_for_play_services", this.b);
        super.onSaveInstanceState(bundle);
    }
}

