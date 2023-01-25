/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.ServiceConnection
 *  android.os.IBinder
 *  android.os.Process
 *  com.miui.analytics.ITrack$Stub
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.xiaomi.onetrack.a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Process;
import com.miui.analytics.ITrack;
import com.xiaomi.onetrack.a.ah;
import com.xiaomi.onetrack.h.o;

class ai
implements ServiceConnection {
    final /* synthetic */ ah a;

    ai(ah ah2) {
        this.a = ah2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Object object;
        Object object2 = object = ah.a(this.a);
        synchronized (object2) {
            ah.b(this.a).set(false);
            ah.c(this.a).set(true);
            ah.a(this.a, ITrack.Stub.asInterface((IBinder)iBinder));
        }
        ah.d(this.a);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onServiceConnected  mConnecting ");
        stringBuilder.append((Object)ah.b(this.a));
        stringBuilder.append(" mIOneTrackService ");
        int n2 = ah.e(this.a) == null ? 0 : 1;
        stringBuilder.append(n2);
        stringBuilder.append(" pid:");
        stringBuilder.append(Process.myPid());
        stringBuilder.append(" tid:");
        stringBuilder.append(Process.myTid());
        o.a("ServiceConnectManager", stringBuilder.toString());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onServiceDisconnected(ComponentName componentName) {
        Object object;
        Object object2 = object = ah.a(this.a);
        synchronized (object2) {
            ah.a(this.a, null);
            ah.b(this.a).set(false);
            ah.c(this.a).set(false);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onServiceDisconnected:  mConnecting ");
        stringBuilder.append((Object)ah.b(this.a));
        stringBuilder.append(" mIOneTrackService ");
        int n2 = ah.e(this.a) == null ? 0 : 1;
        stringBuilder.append(n2);
        o.a("ServiceConnectManager", stringBuilder.toString());
    }
}

