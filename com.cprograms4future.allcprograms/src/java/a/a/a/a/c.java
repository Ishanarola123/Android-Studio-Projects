/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  a.a.a.a.b
 *  a.a.a.a.c$1
 *  a.a.a.a.c$2
 *  a.a.a.a.h
 *  a.a.a.a.m
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Looper
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ref.WeakReference
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.concurrent.Callable
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.Future
 *  java.util.concurrent.atomic.AtomicBoolean
 */
package a.a.a.a;

import a.a.a.a.a;
import a.a.a.a.a.b.m;
import a.a.a.a.a.c.d;
import a.a.a.a.a.c.j;
import a.a.a.a.a.c.k;
import a.a.a.a.a.c.l;
import a.a.a.a.b;
import a.a.a.a.c;
import a.a.a.a.e;
import a.a.a.a.f;
import a.a.a.a.h;
import a.a.a.a.i;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

public class c {
    static volatile c a;
    static final a.a.a.a.l b;
    final a.a.a.a.l c;
    final boolean d;
    private final Context e;
    private final Map<Class<? extends i>, i> f;
    private final ExecutorService g;
    private final Handler h;
    private final f<c> i;
    private final f<?> j;
    private final m k;
    private a.a.a.a.a l;
    private WeakReference<Activity> m;
    private AtomicBoolean n;

    static {
        b = new b();
    }

    c(Context context, Map<Class<? extends i>, i> map, j j2, Handler handler, a.a.a.a.l l2, boolean bl, f f2, m m2) {
        this.e = context.getApplicationContext();
        this.f = map;
        this.g = j2;
        this.h = handler;
        this.c = l2;
        this.d = bl;
        this.i = f2;
        this.n = new AtomicBoolean(false);
        this.j = this.a(map.size());
        this.k = m2;
        this.a(this.c(context));
    }

    static c a() {
        if (a != null) {
            return a;
        }
        throw new IllegalStateException("Must Initialize Fabric before using singleton()");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* varargs */ c a(Context context, i ... arri) {
        if (a != null) return a;
        Class<c> class_ = c.class;
        synchronized (c.class) {
            if (a != null) return a;
            c.c(new a(context).a(arri).a());
            // ** MonitorExit[var3_2] (shouldn't be in output)
            return a;
        }
    }

    public static <T extends i> T a(Class<T> class_) {
        return (T)((i)c.a().f.get(class_));
    }

    static /* synthetic */ AtomicBoolean a(c c2) {
        return c2.n;
    }

    private static void a(Map<Class<? extends i>, i> map, Collection<? extends i> collection) {
        for (i i2 : collection) {
            map.put((Object)i2.getClass(), (Object)i2);
            if (!(i2 instanceof a.a.a.a.j)) continue;
            c.a(map, ((a.a.a.a.j)((Object)i2)).c());
        }
    }

    static /* synthetic */ f b(c c2) {
        return c2.i;
    }

    private static Map<Class<? extends i>, i> b(Collection<? extends i> collection) {
        HashMap hashMap = new HashMap(collection.size());
        c.a((Map<Class<? extends i>, i>)hashMap, collection);
        return hashMap;
    }

    private Activity c(Context context) {
        if (context instanceof Activity) {
            return (Activity)context;
        }
        return null;
    }

    private static void c(c c2) {
        a = c2;
        c2.j();
    }

    public static a.a.a.a.l h() {
        if (a == null) {
            return b;
        }
        return c.a.c;
    }

    public static boolean i() {
        if (a == null) {
            return false;
        }
        return c.a.d;
    }

    private void j() {
        this.l = new a.a.a.a.a(this.e);
        this.l.a((a.b)new 1(this));
        this.a(this.e);
    }

    public c a(Activity activity) {
        this.m = new WeakReference((Object)activity);
        return this;
    }

    f<?> a(int n2) {
        return new 2(this, n2);
    }

    void a(Context context) {
        StringBuilder stringBuilder;
        Future<Map<String, a.a.a.a.k>> future = this.b(context);
        Collection<i> collection = this.g();
        a.a.a.a.m m2 = new a.a.a.a.m(future, collection);
        ArrayList arrayList = new ArrayList(collection);
        Collections.sort((List)arrayList);
        m2.a(context, this, f.d, this.k);
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            ((i)iterator.next()).a(context, this, this.j, this.k);
        }
        m2.k();
        if (c.h().a("Fabric", 3)) {
            stringBuilder = new StringBuilder("Initializing ");
            stringBuilder.append(this.c());
            stringBuilder.append(" [Version: ");
            stringBuilder.append(this.b());
            stringBuilder.append("], with the following kits:\n");
        } else {
            stringBuilder = null;
        }
        for (i i2 : arrayList) {
            i2.f.a((k)m2.f);
            this.a(this.f, i2);
            i2.k();
            if (stringBuilder == null) continue;
            stringBuilder.append(i2.b());
            stringBuilder.append(" [Version: ");
            stringBuilder.append(i2.a());
            stringBuilder.append("]\n");
        }
        if (stringBuilder != null) {
            c.h().a("Fabric", stringBuilder.toString());
        }
    }

    void a(Map<Class<? extends i>, i> map, i i2) {
        d d2 = i2.j;
        if (d2 != null) {
            for (Class<?> class_ : d2.a()) {
                if (class_.isInterface()) {
                    for (i i3 : map.values()) {
                        if (!class_.isAssignableFrom(i3.getClass())) continue;
                        i2.f.a(i3.f);
                    }
                    continue;
                }
                if ((i)map.get(class_) != null) {
                    i2.f.a(((i)map.get(class_)).f);
                    continue;
                }
                throw new l("Referenced Kit was null, does the kit exist?");
            }
        }
    }

    public String b() {
        return "1.3.14.143";
    }

    Future<Map<String, a.a.a.a.k>> b(Context context) {
        e e2 = new e(context.getPackageCodePath());
        return this.e().submit((Callable)e2);
    }

    public String c() {
        return "io.fabric.sdk.android:fabric";
    }

    public a.a.a.a.a d() {
        return this.l;
    }

    public ExecutorService e() {
        return this.g;
    }

    public Handler f() {
        return this.h;
    }

    public Collection<i> g() {
        return this.f.values();
    }

    public static class a {
        private final Context a;
        private i[] b;
        private j c;
        private Handler d;
        private a.a.a.a.l e;
        private boolean f;
        private String g;
        private String h;
        private f<c> i;

        public a(Context context) {
            if (context != null) {
                this.a = context;
                return;
            }
            throw new IllegalArgumentException("Context must not be null.");
        }

        public /* varargs */ a a(i ... arri) {
            if (this.b == null) {
                this.b = arri;
                return this;
            }
            throw new IllegalStateException("Kits already set.");
        }

        /*
         * Enabled aggressive block sorting
         */
        public c a() {
            if (this.c == null) {
                this.c = j.a();
            }
            if (this.d == null) {
                this.d = new Handler(Looper.getMainLooper());
            }
            if (this.e == null) {
                b b2 = this.f ? new b(3) : new b();
                this.e = b2;
            }
            if (this.h == null) {
                this.h = this.a.getPackageName();
            }
            if (this.i == null) {
                this.i = f.d;
            }
            Object object = this.b == null ? new HashMap() : c.b((Collection<? extends i>)((Collection)Arrays.asList((Object[])this.b)));
            HashMap hashMap = object;
            m m2 = new m(this.a, this.h, this.g, (Collection<i>)hashMap.values());
            return new c(this.a, (Map<Class<? extends i>, i>)hashMap, this.c, this.d, this.e, this.f, this.i, m2);
        }
    }

}

