/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.os.Bundle
 *  android.os.SystemClock
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 */
package com.xiaomi.onetrack.a;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.SystemClock;
import com.xiaomi.onetrack.a.f;
import com.xiaomi.onetrack.c.g;
import com.xiaomi.onetrack.h.o;

class j
implements Application.ActivityLifecycleCallbacks {
    final /* synthetic */ f a;
    private int b = 0;
    private int c;
    private long d;
    private boolean e;
    private boolean f;

    j(f f2) {
        this.a = f2;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
        long l2 = this.c == System.identityHashCode((Object)activity) ? SystemClock.elapsedRealtime() - this.d : 0L;
        String string2 = activity.getClass().getName();
        f.a(this.a, string2, l2);
        if (o.a) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onActivityPaused:");
            stringBuilder.append(activity.getLocalClassName());
            o.a("OneTrackImp", stringBuilder.toString());
        }
    }

    public void onActivityResumed(Activity activity) {
        f.a(this.a, this.f);
        this.c = System.identityHashCode((Object)activity);
        this.d = SystemClock.elapsedRealtime();
        f.a(this.a, activity.getClass().getName(), this.e);
        if (o.a) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onActivityResumed:");
            stringBuilder.append(activity.getLocalClassName());
            stringBuilder.append(" isAppStart:");
            stringBuilder.append(this.e);
            o.a("OneTrackImp", stringBuilder.toString());
        }
        this.e = false;
        f.e(this.a);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        if (this.b == 0) {
            f.d(this.a).a(1);
            this.e = true;
            this.f = false;
            com.xiaomi.onetrack.h.f.a();
        } else {
            this.e = false;
        }
        this.b = 1 + this.b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onActivityStarted: ");
        stringBuilder.append(activity.getLocalClassName());
        o.a("OneTrackImp", stringBuilder.toString());
    }

    public void onActivityStopped(Activity activity) {
        --this.b;
        if (this.b == 0) {
            f.d(this.a).a(2);
            if (g.a()) {
                f.f(this.a);
            }
            this.f = true;
            this.e = false;
        } else {
            this.f = false;
        }
        f.a(this.a, this.f);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onActivityStopped: ");
        stringBuilder.append(activity.getLocalClassName());
        o.a("OneTrackImp", stringBuilder.toString());
    }
}

