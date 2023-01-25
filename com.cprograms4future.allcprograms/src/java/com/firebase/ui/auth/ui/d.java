/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.Bundle
 *  android.support.v4.app.f
 *  android.support.v4.app.g
 */
package com.firebase.ui.auth.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.f;
import com.firebase.ui.auth.ui.g;

public class d
extends f {
    protected g ag;

    public void a(int n2, Intent intent) {
        this.ag.a(n2, intent);
    }

    public void b_(Bundle bundle) {
        super.b_(bundle);
        this.ag = new g((android.support.v4.app.g)this);
    }

    public void x() {
        super.x();
        this.ag.d();
    }
}

