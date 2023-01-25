/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.content.Context
 *  com.firebase.ui.auth.b.c$1
 *  com.firebase.ui.auth.b.c$2
 *  com.firebase.ui.auth.b.c$a
 *  com.google.android.gms.common.api.f
 *  com.google.android.gms.common.api.f$a
 *  com.google.android.gms.common.api.f$b
 *  com.google.android.gms.common.api.f$c
 *  com.google.android.gms.d.g
 *  com.google.android.gms.d.h
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.IdentityHashMap
 *  java.util.concurrent.atomic.AtomicReference
 */
package com.firebase.ui.auth.b;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.firebase.ui.auth.b.c;
import com.google.android.gms.common.api.f;
import com.google.android.gms.d.g;
import com.google.android.gms.d.h;
import java.util.IdentityHashMap;
import java.util.concurrent.atomic.AtomicReference;

/*
 * Exception performing whole class analysis.
 */
public class c {
    private static final IdentityHashMap<Activity, c> a;
    private final Activity b;
    private final AtomicReference<f> c;
    private final AtomicReference<h<f>> d;
    private final f.a e;

    static {
        a = new IdentityHashMap();
    }

    private c(Activity activity) {
        if (activity != null) {
            this.b = activity;
            this.e = new f.a((Context)this.b);
            this.c = new AtomicReference();
            this.d = new AtomicReference();
            activity.getApplication().registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)new /* Unavailable Anonymous Inner Class!! */);
            return;
        }
        throw new IllegalArgumentException("activity must not be null");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static c a(Activity activity) {
        IdentityHashMap<Activity, c> identityHashMap;
        IdentityHashMap<Activity, c> identityHashMap2 = identityHashMap = a;
        synchronized (identityHashMap2) {
            c c2 = (c)a.get((Object)activity);
            if (c2 == null) {
                c2 = new c(activity);
                a.put((Object)activity, (Object)c2);
            }
            return c2;
        }
    }

    static /* synthetic */ AtomicReference a(c c2) {
        return c2.c;
    }

    static /* synthetic */ Activity b(c c2) {
        return c2.b;
    }

    static /* synthetic */ void b(Activity activity) {
        c.c(activity);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void c(Activity activity) {
        IdentityHashMap<Activity, c> identityHashMap;
        IdentityHashMap<Activity, c> identityHashMap2 = identityHashMap = a;
        synchronized (identityHashMap2) {
            a.remove((Object)activity);
            return;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public g<f> a() {
        h h2 = new h();
        if (!this.d.compareAndSet(null, (Object)h2)) {
            h2 = (h)this.d.get();
            do {
                return h2.a();
                break;
            } while (true);
        }
        f f2 = this.e.a((f.b)new 2(this, h2)).a((f.c)new 1(this, h2)).b();
        this.c.set((Object)f2);
        f2.e();
        return h2.a();
    }

    public f.a b() {
        return this.e;
    }
}

