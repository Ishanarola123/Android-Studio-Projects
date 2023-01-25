/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  java.lang.Object
 *  java.lang.String
 *  java.util.concurrent.atomic.AtomicReference
 */
package com.twitter.sdk.android.core.identity;

import a.a.a.a.c;
import android.app.Activity;
import com.twitter.sdk.android.core.identity.a;
import java.util.concurrent.atomic.AtomicReference;

class b {
    final AtomicReference<a> a = new AtomicReference(null);

    b() {
    }

    public void a() {
        this.a.set(null);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean a(Activity activity, a a2) {
        if (!this.b()) {
            if (!a2.a(activity)) return false;
            boolean bl = this.a.compareAndSet(null, (Object)a2);
            if (bl) return bl;
            c.h().c("Twitter", "Failed to update authHandler, authorize already in progress.");
            return bl;
        }
        c.h().c("Twitter", "Authorize already in progress");
        return false;
    }

    public boolean b() {
        return this.a.get() != null;
    }

    public a c() {
        return (a)this.a.get();
    }
}

