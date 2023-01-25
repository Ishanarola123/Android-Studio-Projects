/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.Bundle
 *  android.support.v7.app.e
 */
package com.firebase.ui.auth.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.e;
import com.firebase.ui.auth.ui.a;

public class h
extends e {
    protected a a;

    public void a(int n2, Intent intent) {
        this.a.a(n2, intent);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = new a(this, this.getIntent());
    }

    protected void onDestroy() {
        super.onDestroy();
        this.a.d();
    }
}

