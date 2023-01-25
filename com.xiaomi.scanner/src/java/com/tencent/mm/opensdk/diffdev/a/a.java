/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.AsyncTask
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Looper
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Void
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.concurrent.Executor
 */
package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mm.opensdk.diffdev.IDiffDevOAuth;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.diffdev.a.b;
import com.tencent.mm.opensdk.diffdev.a.d;
import com.tencent.mm.opensdk.utils.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public final class a
implements IDiffDevOAuth {
    private List<OAuthListener> c = new ArrayList();
    private d d;
    private OAuthListener e = new b(this);
    private Handler handler = null;

    static /* synthetic */ List a(a a2) {
        return a2.c;
    }

    static /* synthetic */ Handler b(a a2) {
        return a2.handler;
    }

    static /* synthetic */ d c(a a2) {
        a2.d = null;
        return null;
    }

    @Override
    public final void addListener(OAuthListener oAuthListener) {
        if (!this.c.contains((Object)oAuthListener)) {
            this.c.add((Object)oAuthListener);
        }
    }

    @Override
    public final boolean auth(String string2, String string3, String string4, String string5, String string6, OAuthListener oAuthListener) {
        StringBuilder stringBuilder = new StringBuilder("start auth, appId = ");
        stringBuilder.append(string2);
        Log.i("MicroMsg.SDK.DiffDevOAuth", stringBuilder.toString());
        if (string2 != null && string2.length() > 0 && string3 != null && string3.length() > 0) {
            d d2;
            if (this.handler == null) {
                this.handler = new Handler(Looper.getMainLooper());
            }
            this.addListener(oAuthListener);
            if (this.d != null) {
                Log.d("MicroMsg.SDK.DiffDevOAuth", "auth, already running, no need to start auth again");
                return true;
            }
            d d3 = this.d = (d2 = new d(string2, string3, string4, string5, string6, this.e));
            if (Build.VERSION.SDK_INT >= 11) {
                d3.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])new Void[0]);
                return true;
            }
            d3.execute((Object[])new Void[0]);
            return true;
        }
        Log.d("MicroMsg.SDK.DiffDevOAuth", String.format((String)"auth fail, invalid argument, appId = %s, scope = %s", (Object[])new Object[]{string2, string3}));
        return false;
    }

    @Override
    public final void detach() {
        Log.i("MicroMsg.SDK.DiffDevOAuth", "detach");
        this.c.clear();
        this.stopAuth();
    }

    @Override
    public final void removeAllListeners() {
        this.c.clear();
    }

    @Override
    public final void removeListener(OAuthListener oAuthListener) {
        this.c.remove((Object)oAuthListener);
    }

    @Override
    public final boolean stopAuth() {
        boolean bl;
        block3 : {
            Log.i("MicroMsg.SDK.DiffDevOAuth", "stopAuth");
            if (this.d != null) break block3;
            bl = true;
        }
        try {
            bl = this.d.a();
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder("stopAuth fail, ex = ");
            stringBuilder.append(exception.getMessage());
            Log.w("MicroMsg.SDK.DiffDevOAuth", stringBuilder.toString());
            bl = false;
        }
        this.d = null;
        return bl;
    }
}

