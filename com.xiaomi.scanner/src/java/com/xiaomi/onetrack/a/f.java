/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.text.TextUtils
 *  android.util.Log
 *  com.xiaomi.onetrack.OnMainThreadException
 *  com.xiaomi.onetrack.a.ad
 *  com.xiaomi.onetrack.a.af
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.List
 *  java.util.Map
 *  java.util.concurrent.BlockingQueue
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.LinkedBlockingQueue
 *  java.util.concurrent.ThreadPoolExecutor
 *  java.util.concurrent.TimeUnit
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.xiaomi.onetrack.a;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.onetrack.Configuration;
import com.xiaomi.onetrack.CrashAnalysis;
import com.xiaomi.onetrack.OnMainThreadException;
import com.xiaomi.onetrack.OneTrack;
import com.xiaomi.onetrack.ServiceQualityEvent;
import com.xiaomi.onetrack.a.aa;
import com.xiaomi.onetrack.a.ab;
import com.xiaomi.onetrack.a.ac;
import com.xiaomi.onetrack.a.ad;
import com.xiaomi.onetrack.a.af;
import com.xiaomi.onetrack.a.c;
import com.xiaomi.onetrack.a.d;
import com.xiaomi.onetrack.a.e;
import com.xiaomi.onetrack.a.g;
import com.xiaomi.onetrack.a.h;
import com.xiaomi.onetrack.a.i;
import com.xiaomi.onetrack.a.j;
import com.xiaomi.onetrack.a.k;
import com.xiaomi.onetrack.a.l;
import com.xiaomi.onetrack.a.m;
import com.xiaomi.onetrack.a.n;
import com.xiaomi.onetrack.a.o;
import com.xiaomi.onetrack.a.p;
import com.xiaomi.onetrack.a.q;
import com.xiaomi.onetrack.a.r;
import com.xiaomi.onetrack.a.s;
import com.xiaomi.onetrack.a.t;
import com.xiaomi.onetrack.a.u;
import com.xiaomi.onetrack.a.v;
import com.xiaomi.onetrack.a.w;
import com.xiaomi.onetrack.a.x;
import com.xiaomi.onetrack.a.y;
import com.xiaomi.onetrack.a.z;
import com.xiaomi.onetrack.f.a;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public class f {
    private static final String a = "OneTrackImp";
    private static ExecutorService c;
    private d b;
    private Context d;
    private e e;
    private Configuration f;
    private OneTrack.ICommonPropertyProvider g;
    private OneTrack.IEventHook h;

    public f(Context context, Configuration configuration) {
        Context context2;
        this.d = context2 = context.getApplicationContext();
        this.f = configuration;
        this.b(context2);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("OneTrackImp init : ");
        stringBuilder.append(configuration.toString());
        Log.d((String)a, (String)stringBuilder.toString());
    }

    static /* synthetic */ Configuration a(f f2) {
        return f2.f;
    }

    private String a(long l2, String string2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("last_ver_name", (Object)string2);
        jSONObject.put("last_ver_code", l2);
        return jSONObject.toString();
    }

    static /* synthetic */ void a(f f2, String string2, long l2) {
        f2.a(string2, l2);
    }

    static /* synthetic */ void a(f f2, String string2, boolean bl) {
        f2.a(string2, bl);
    }

    static /* synthetic */ void a(f f2, boolean bl) {
        f2.b(bl);
    }

    private void a(String string2, long l2) {
        c.execute((Runnable)new m(this, string2, l2));
    }

    private void a(String string2, boolean bl) {
        c.execute((Runnable)new l(this, string2, bl));
    }

    static /* synthetic */ boolean a(f f2, String string2) {
        return f2.c(string2);
    }

    static /* synthetic */ JSONObject b(f f2, String string2) {
        return f2.d(string2);
    }

    private void b(Context context) {
        com.xiaomi.onetrack.h.o.a();
        com.xiaomi.onetrack.h.p.a(this.f.isInternational(), this.f.getRegion(), this.f.getMode());
        if (c == null) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, (BlockingQueue)new LinkedBlockingQueue());
            c = threadPoolExecutor;
        }
        if (com.xiaomi.onetrack.h.p.a() && this.e() && this.c()) {
            com.xiaomi.onetrack.h.n.a().a(true);
            this.b = new af(context, this.f);
        } else {
            com.xiaomi.onetrack.h.n.a().a(false);
            this.b = new ad(context, this.f);
        }
        if (this.f.getMode() == OneTrack.Mode.APP) {
            com.xiaomi.onetrack.h.p.a(this.f.isOverrideMiuiRegionSetting());
            this.c(context);
            if (this.f.isExceptionCatcherEnable()) {
                if (CrashAnalysis.isSupport()) {
                    CrashAnalysis.start(context, this);
                } else {
                    this.e = new e(this);
                    this.e.a();
                }
            }
        }
        c.execute((Runnable)new g(this));
    }

    static /* synthetic */ void b(f f2) {
        f2.l();
    }

    private void b(boolean bl) {
        c.execute((Runnable)new n(this, bl));
    }

    static /* synthetic */ OneTrack.IEventHook c(f f2) {
        return f2.h;
    }

    private void c(Context context) {
        ((Application)context).registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)new j(this));
    }

    private boolean c() {
        if (!this.f.isOverrideMiuiRegionSetting()) {
            return true;
        }
        return TextUtils.equals((CharSequence)com.xiaomi.onetrack.h.p.C(), (CharSequence)this.f.getRegion());
    }

    private boolean c(String string2) {
        boolean bl = com.xiaomi.onetrack.h.q.a(string2);
        if (!bl) {
            com.xiaomi.onetrack.h.o.b(a, String.format((String)"Invalid eventname: %s. Eventname can only consist of numbers, letters, underscores ,and can not start with a number or \"onetrack_\" or \"ot_\"", (Object[])new Object[]{string2}));
        }
        return bl ^ true;
    }

    static /* synthetic */ d d(f f2) {
        return f2.b;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private JSONObject d(String string2) {
        try {
            Map<String, Object> map = this.g != null ? this.g.getDynamicProperty(string2) : null;
            JSONObject jSONObject = com.xiaomi.onetrack.h.q.a(map, false);
            String string3 = com.xiaomi.onetrack.h.j.a(this.i());
            JSONObject jSONObject2 = !TextUtils.isEmpty((CharSequence)string3) ? new JSONObject(string3) : null;
            return com.xiaomi.onetrack.h.q.a(jSONObject, jSONObject2);
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("getCommonProperty: ");
            stringBuilder.append(exception.toString());
            com.xiaomi.onetrack.h.o.b(a, stringBuilder.toString());
            return null;
        }
    }

    private void d() {
        c.execute((Runnable)new k(this));
    }

    static /* synthetic */ void e(f f2) {
        f2.d();
    }

    private boolean e() {
        if (com.xiaomi.onetrack.h.o.a) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("enable:");
            stringBuilder.append(this.f());
            stringBuilder.append(" isServiceOnline: ");
            stringBuilder.append(f.g());
            com.xiaomi.onetrack.h.o.a(a, stringBuilder.toString());
        }
        return this.f() && f.g() && f.h();
    }

    static /* synthetic */ void f(f f2) {
        f2.k();
    }

    private boolean f() {
        try {
            ComponentName componentName = new ComponentName("com.miui.analytics", "com.miui.analytics.onetrack.OneTrackService");
            int n2 = a.a().getPackageManager().getComponentEnabledSetting(componentName);
            if (n2 == 1 || n2 == 0) {
                return true;
            }
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("enable error:");
            stringBuilder.append(exception.toString());
            com.xiaomi.onetrack.h.o.b(a, stringBuilder.toString());
        }
        return false;
    }

    static /* synthetic */ String g(f f2) {
        return f2.i();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean g() {
        List list;
        Intent intent = new Intent();
        intent.setClassName("com.miui.analytics", "com.miui.analytics.onetrack.OneTrackService");
        if (a.a() == null || a.a().getPackageManager() == null || (list = a.a().getPackageManager().queryIntentServices(intent, 0)) == null) return false;
        try {
            int n2 = list.size();
            if (n2 <= 0) return false;
            return true;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("isServiceOnline: ");
            stringBuilder.append(exception.toString());
            com.xiaomi.onetrack.h.o.a(a, stringBuilder.toString());
        }
        return false;
    }

    private static boolean h() {
        int n2;
        block3 : {
            try {
                n2 = a.a().getPackageManager().getPackageInfo((String)"com.miui.analytics", (int)0).versionCode;
                if (n2 < 2020062900) break block3;
                return true;
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                nameNotFoundException.printStackTrace();
                return false;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("system analytics version: ");
        stringBuilder.append(n2);
        com.xiaomi.onetrack.h.o.a(a, stringBuilder.toString());
        return false;
    }

    private String i() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = this.f.getAppId();
        String string3 = this.f.getPluginId();
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            stringBuilder.append(string2);
        }
        if (!TextUtils.isEmpty((CharSequence)string3)) {
            stringBuilder.append(string3);
        }
        return com.xiaomi.onetrack.d.d.h(stringBuilder.toString());
    }

    private void j() {
        c.execute((Runnable)new u(this));
    }

    private void k() {
        if (!com.xiaomi.onetrack.g.c.a()) {
            return;
        }
        com.xiaomi.onetrack.c.g.a(false);
        c.execute((Runnable)new v(this));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void l() {
        if (this.f.getMode() != OneTrack.Mode.APP) {
            return;
        }
        long l2 = a.c();
        String string2 = this.a(l2, a.b());
        String string3 = com.xiaomi.onetrack.h.w.A();
        if (TextUtils.isEmpty((CharSequence)string3)) {
            com.xiaomi.onetrack.h.w.j(string2);
            return;
        }
        JSONObject jSONObject = new JSONObject(string3);
        long l3 = jSONObject.optLong("last_ver_code");
        String string4 = jSONObject.optString("last_ver_name");
        if (l3 == l2) return;
        try {
            com.xiaomi.onetrack.h.w.j(string2);
            String string5 = c.a(l3, string4, l2, a.e(), this.f, this.h);
            this.b.a("onetrack_upgrade", string5);
            return;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("trackUpgradeEvent error: ");
            stringBuilder.append(exception.toString());
            com.xiaomi.onetrack.h.o.b(a, stringBuilder.toString());
        }
    }

    public String a(Context context) throws OnMainThreadException {
        if (!com.xiaomi.onetrack.h.t.a()) {
            return com.xiaomi.onetrack.h.f.y(context);
        }
        throw new OnMainThreadException("Can't call this method on main thread");
    }

    public void a() {
        c.execute((Runnable)new p(this));
    }

    public void a(OneTrack.ICommonPropertyProvider iCommonPropertyProvider) {
        this.g = iCommonPropertyProvider;
    }

    public void a(OneTrack.IEventHook iEventHook) {
        this.h = iEventHook;
    }

    public void a(ServiceQualityEvent serviceQualityEvent) {
        if (serviceQualityEvent == null) {
            return;
        }
        c.execute((Runnable)new t(this, serviceQualityEvent));
    }

    public void a(String string2) {
        c.execute((Runnable)new q(this, string2));
    }

    public void a(String string2, OneTrack.UserIdType userIdType, Map<String, Object> map, boolean bl) {
        ExecutorService executorService = c;
        ab ab2 = new ab(this, string2, userIdType, bl, map);
        executorService.execute((Runnable)ab2);
    }

    public void a(String string2, Number number) {
        c.execute((Runnable)new h(this, string2, number));
    }

    public void a(String string2, Object object) {
        c.execute((Runnable)new aa(this, object, string2));
    }

    public void a(String string2, String string3) {
        c.execute((Runnable)new x(this, string2, string3));
    }

    public void a(String string2, String string3, String string4, String string5, String string6) {
        ExecutorService executorService = c;
        y y2 = new y(this, string2, string3, string4, string6, string5);
        executorService.execute((Runnable)y2);
    }

    public void a(String string2, String string3, Map<String, Object> map) {
        c.execute((Runnable)new r(this, string3, map, string2));
    }

    public void a(String string2, Map<String, Object> map) {
        c.execute((Runnable)new w(this, string2, map));
    }

    public void a(Map<String, Object> map) {
        c.execute((Runnable)new z(this, map));
    }

    public void a(Map<String, Object> map, boolean bl) {
        c.execute((Runnable)new i(this, bl, map));
    }

    public void a(boolean bl) {
        com.xiaomi.onetrack.h.o.a = bl;
    }

    public String b() throws OnMainThreadException {
        if (!com.xiaomi.onetrack.h.t.a()) {
            return com.xiaomi.onetrack.h.n.a().b();
        }
        throw new OnMainThreadException("Can't call this method on main thread");
    }

    public void b(String string2) {
        c.execute((Runnable)new s(this, string2));
    }

    public void b(Map<String, ? extends Number> map) {
        c.execute((Runnable)new ac(this, map));
    }

    public void c(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        c.execute((Runnable)new o(this, map));
    }
}

