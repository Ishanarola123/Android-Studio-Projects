/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  a.a.a.a.a.g.h
 *  a.a.a.a.a.g.y
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.concurrent.Future
 */
package a.a.a.a;

import a.a.a.a.a.b.g;
import a.a.a.a.a.b.i;
import a.a.a.a.a.b.k;
import a.a.a.a.a.e.b;
import a.a.a.a.a.e.e;
import a.a.a.a.a.g.d;
import a.a.a.a.a.g.h;
import a.a.a.a.a.g.n;
import a.a.a.a.a.g.q;
import a.a.a.a.a.g.t;
import a.a.a.a.a.g.y;
import a.a.a.a.c;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

class m
extends a.a.a.a.i<Boolean> {
    private final e a = new b();
    private PackageManager b;
    private String c;
    private PackageInfo d;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private final Future<Map<String, a.a.a.a.k>> p;
    private final Collection<a.a.a.a.i> q;

    public m(Future<Map<String, a.a.a.a.k>> future, Collection<a.a.a.a.i> collection) {
        this.p = future;
        this.q = collection;
    }

    private d a(n n2, Collection<a.a.a.a.k> collection) {
        Context context = this.m();
        String string = new g().a(context);
        String string2 = i.a(new String[]{i.g(context)});
        int n3 = k.a(this.m).a();
        String string3 = this.l().b();
        d d2 = new d(string, string3, this.l, this.k, string2, this.n, n3, this.o, "0", n2, collection);
        return d2;
    }

    private boolean a(a.a.a.a.a.g.e e2, n n2, Collection<a.a.a.a.k> collection) {
        d d2 = this.a(n2, collection);
        return new y((a.a.a.a.i)this, this.e(), e2.c, this.a).a(d2);
    }

    /*
     * Enabled aggressive block sorting
     */
    private boolean a(String string, a.a.a.a.a.g.e e2, Collection<a.a.a.a.k> collection) {
        if ("new".equals((Object)e2.b)) {
            if (this.b(string, e2, collection)) {
                return q.a().d();
            }
            c.h().d("Fabric", "Failed to create app with Crashlytics service.", null);
            return false;
        }
        if ("configured".equals((Object)e2.b)) {
            return q.a().d();
        }
        if (!e2.e) return true;
        c.h().a("Fabric", "Server says an update is required - forcing a full App update.");
        this.c(string, e2, collection);
        return true;
    }

    private boolean b(String string, a.a.a.a.a.g.e e2, Collection<a.a.a.a.k> collection) {
        d d2 = this.a(n.a(this.m(), string), collection);
        return new h((a.a.a.a.i)this, this.e(), e2.c, this.a).a(d2);
    }

    private boolean c(String string, a.a.a.a.a.g.e e2, Collection<a.a.a.a.k> collection) {
        return this.a(e2, n.a(this.m(), string), collection);
    }

    private t f() {
        try {
            q.a().a(this, this.i, this.a, this.k, this.l, this.e()).c();
            t t2 = q.a().b();
            return t2;
        }
        catch (Exception exception) {
            c.h().d("Fabric", "Error dealing with settings", exception);
            return null;
        }
    }

    @Override
    public String a() {
        return "1.3.14.143";
    }

    Map<String, a.a.a.a.k> a(Map<String, a.a.a.a.k> map, Collection<a.a.a.a.i> collection) {
        for (a.a.a.a.i i2 : collection) {
            if (map.containsKey((Object)i2.b())) continue;
            map.put((Object)i2.b(), (Object)new a.a.a.a.k(i2.b(), i2.a(), "binary"));
        }
        return map;
    }

    @Override
    public String b() {
        return "io.fabric.sdk.android:fabric";
    }

    protected Boolean c() {
        boolean bl;
        block3 : {
            String string = i.e(this.m());
            t t2 = this.f();
            if (t2 != null) {
                try {
                    Object object = this.p != null ? (Map)this.p.get() : new HashMap();
                    Map<String, a.a.a.a.k> map = this.a((Map<String, a.a.a.a.k>)object, this.q);
                    bl = this.a(string, t2.a, (Collection<a.a.a.a.k>)map.values());
                    break block3;
                }
                catch (Exception exception) {
                    c.h().d("Fabric", "Error performing auto configuration.", exception);
                }
            }
            bl = false;
        }
        return bl;
    }

    @Override
    protected /* synthetic */ Object d() {
        return this.c();
    }

    String e() {
        return i.b(this.m(), "com.crashlytics.ApiEndpoint");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    protected boolean g() {
        try {
            this.m = this.l().g();
            this.b = this.m().getPackageManager();
            this.c = this.m().getPackageName();
            this.d = this.b.getPackageInfo(this.c, 0);
            this.k = Integer.toString((int)this.d.versionCode);
            String string = this.d.versionName == null ? "0.0" : this.d.versionName;
            this.l = string;
            this.n = this.b.getApplicationLabel(this.m().getApplicationInfo()).toString();
            this.o = Integer.toString((int)this.m().getApplicationInfo().targetSdkVersion);
            return true;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            c.h().d("Fabric", "Failed init", nameNotFoundException);
            return false;
        }
    }
}

