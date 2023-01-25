/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.content.pm.PackageManager
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  android.util.Log
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Iterator
 *  java.util.List
 *  java.util.concurrent.CopyOnWriteArrayList
 *  java.util.concurrent.atomic.AtomicBoolean
 */
package com.xiaomi.onetrack.a;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.miui.analytics.ITrack;
import com.xiaomi.onetrack.Configuration;
import com.xiaomi.onetrack.a.ai;
import com.xiaomi.onetrack.h.o;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class ah {
    public static final String a = "com.miui.analytics";
    public static final String b = "com.miui.analytics.onetrack.OneTrackService";
    private static final String c = "ServiceConnectManager";
    private static final int j = 1;
    private ITrack d;
    private AtomicBoolean e = new AtomicBoolean(false);
    private AtomicBoolean f = new AtomicBoolean(false);
    private final Object g = new Object();
    private boolean h = this.e();
    private Context i = com.xiaomi.onetrack.f.a.a();
    private c k = new c(Looper.getMainLooper());
    private ServiceConnection l = new ai(this);
    private CopyOnWriteArrayList<b> m = new CopyOnWriteArrayList();

    private ah() {
        this.b();
    }

    /* synthetic */ ah(ai ai2) {
        this();
    }

    static /* synthetic */ ITrack a(ah ah2, ITrack iTrack) {
        ah2.d = iTrack;
        return iTrack;
    }

    public static ah a() {
        return a.a;
    }

    static /* synthetic */ Object a(ah ah2) {
        return ah2.g;
    }

    static /* synthetic */ AtomicBoolean b(ah ah2) {
        return ah2.e;
    }

    private void b() {
        if (!(this.e.get() || this.f.get() && this.d != null)) {
            this.c();
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ensureService mConnecting: ");
        stringBuilder.append(this.e.get());
        stringBuilder.append(" mIsBindSuccess:");
        stringBuilder.append(this.f.get());
        stringBuilder.append(" mAnalytics: ");
        int n2 = this.d == null ? 0 : 1;
        stringBuilder.append(n2);
        o.a(c, stringBuilder.toString());
    }

    static /* synthetic */ AtomicBoolean c(ah ah2) {
        return ah2.f;
    }

    private void c() {
        if (this.h) {
            try {
                Intent intent = new Intent();
                intent.setClassName(a, b);
                this.i.bindService(intent, this.l, 1);
                this.e.set(true);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("bindService:  mConnecting: ");
                stringBuilder.append((Object)this.e);
                o.a(c, stringBuilder.toString());
                return;
            }
            catch (Exception exception) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("bindService: ");
                stringBuilder.append(exception.toString());
                o.b(c, stringBuilder.toString());
            }
        }
    }

    private void d() {
        try {
            if (this.h && this.f.get()) {
                this.i.unbindService(this.l);
                this.f.set(false);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("unBindService  mIsBindSuccess:");
                stringBuilder.append(this.f.get());
                o.a(c, stringBuilder.toString());
                return;
            }
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("unBindService: ");
            stringBuilder.append(exception.toString());
            o.a(c, stringBuilder.toString());
        }
    }

    static /* synthetic */ void d(ah ah2) {
        ah2.f();
    }

    static /* synthetic */ ITrack e(ah ah2) {
        return ah2.d;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean e() {
        List list;
        Intent intent = new Intent();
        intent.setClassName(a, b);
        if (this.i == null || this.i.getPackageManager() == null || (list = this.i.getPackageManager().queryIntentServices(intent, 0)) == null) return false;
        try {
            int n2 = list.size();
            if (n2 <= 0) return false;
            return true;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("isServiceOnline: ");
            stringBuilder.append(exception.toString());
            Log.d((String)c, (String)stringBuilder.toString());
        }
        return false;
    }

    private void f() {
        Iterator iterator = this.m.iterator();
        while (iterator.hasNext()) {
            ((b)iterator.next()).a();
        }
    }

    public void a(int n2) {
        if (n2 == 2) {
            this.k.sendEmptyMessageDelayed(1, 5000L);
            return;
        }
        if (this.k.hasMessages(1)) {
            this.k.removeMessages(1);
        }
    }

    public void a(b b2) {
        if (!this.m.contains((Object)b2)) {
            this.m.add((Object)b2);
        }
    }

    /*
     * Exception decompiling
     */
    public boolean a(String var1, String var2, Configuration var3) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void b(String string2, String string3, Configuration configuration) {
        try {
            Object object;
            Object object2 = object = this.g;
            // MONITORENTER : object2
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("trackCacheData error:");
            stringBuilder.append(exception.toString());
            o.b(c, stringBuilder.toString());
            return;
        }
        this.d.trackEvent(configuration.getAppId(), com.xiaomi.onetrack.f.a.d(), string2, string3);
        // MONITOREXIT : object2
    }

    private static class a {
        private static ah a = new ah(null);

        private a() {
        }
    }

    public static interface b {
        public void a();
    }

    private class c
    extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                ah.this.d();
            }
        }
    }

}

