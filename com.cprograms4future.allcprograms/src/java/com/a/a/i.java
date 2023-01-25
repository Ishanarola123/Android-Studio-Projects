/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.graphics.Bitmap
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.os.Message
 *  com.a.a.r
 *  java.lang.AssertionError
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 *  java.util.WeakHashMap
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.Future
 */
package com.a.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.a.a.aa;
import com.a.a.ag;
import com.a.a.d;
import com.a.a.j;
import com.a.a.p;
import com.a.a.q;
import com.a.a.r;
import com.a.a.t;
import com.a.a.v;
import com.a.a.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

class i {
    final b a = new b();
    final Context b;
    final ExecutorService c;
    final j d;
    final Map<String, com.a.a.c> e;
    final Map<Object, com.a.a.a> f;
    final Map<Object, com.a.a.a> g;
    final Set<Object> h;
    final Handler i;
    final Handler j;
    final d k;
    final aa l;
    final List<com.a.a.c> m;
    final c n;
    final boolean o;
    boolean p;

    i(Context context, ExecutorService executorService, Handler handler, j j2, d d2, aa aa2) {
        this.a.start();
        ag.a(this.a.getLooper());
        this.b = context;
        this.c = executorService;
        this.e = new LinkedHashMap();
        this.f = new WeakHashMap();
        this.g = new WeakHashMap();
        this.h = new HashSet();
        this.i = new a(this.a.getLooper(), this);
        this.d = j2;
        this.j = handler;
        this.k = d2;
        this.l = aa2;
        this.m = new ArrayList(4);
        this.p = ag.d(this.b);
        this.o = ag.b(context, "android.permission.ACCESS_NETWORK_STATE");
        this.n = new c(this);
        this.n.a();
    }

    private void a(List<com.a.a.c> list) {
        if (list != null) {
            if (list.isEmpty()) {
                return;
            }
            if (((com.a.a.c)list.get((int)0)).j().l) {
                StringBuilder stringBuilder = new StringBuilder();
                for (com.a.a.c c2 : list) {
                    if (stringBuilder.length() > 0) {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append(ag.a(c2));
                }
                ag.a("Dispatcher", "delivered", stringBuilder.toString());
            }
        }
    }

    private void b() {
        if (!this.f.isEmpty()) {
            Iterator iterator = this.f.values().iterator();
            while (iterator.hasNext()) {
                com.a.a.a a2 = (com.a.a.a)iterator.next();
                iterator.remove();
                if (a2.j().l) {
                    ag.a("Dispatcher", "replaying", a2.c().a());
                }
                this.a(a2, false);
            }
        }
    }

    private void e(com.a.a.a a2) {
        Object t2 = a2.d();
        if (t2 != null) {
            a2.k = true;
            this.f.put(t2, (Object)a2);
        }
    }

    private void f(com.a.a.c c2) {
        List<com.a.a.a> list;
        com.a.a.a a2 = c2.i();
        if (a2 != null) {
            this.e(a2);
        }
        if ((list = c2.k()) != null) {
            int n2 = list.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                this.e((com.a.a.a)list.get(i2));
            }
        }
    }

    private void g(com.a.a.c c2) {
        if (c2.c()) {
            return;
        }
        this.m.add((Object)c2);
        if (!this.i.hasMessages(7)) {
            this.i.sendEmptyMessageDelayed(7, 200L);
        }
    }

    void a() {
        ArrayList arrayList = new ArrayList(this.m);
        this.m.clear();
        this.j.sendMessage(this.j.obtainMessage(8, (Object)arrayList));
        this.a((List<com.a.a.c>)arrayList);
    }

    void a(NetworkInfo networkInfo) {
        this.i.sendMessage(this.i.obtainMessage(9, (Object)networkInfo));
    }

    void a(com.a.a.a a2) {
        this.i.sendMessage(this.i.obtainMessage(1, (Object)a2));
    }

    void a(com.a.a.a a2, boolean bl) {
        if (this.h.contains(a2.l())) {
            this.g.put(a2.d(), (Object)a2);
            if (a2.j().l) {
                String string = a2.b.a();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("because tag '");
                stringBuilder.append(a2.l());
                stringBuilder.append("' is paused");
                ag.a("Dispatcher", "paused", string, stringBuilder.toString());
            }
            return;
        }
        com.a.a.c c2 = (com.a.a.c)this.e.get((Object)a2.e());
        if (c2 != null) {
            c2.a(a2);
            return;
        }
        if (this.c.isShutdown()) {
            if (a2.j().l) {
                ag.a("Dispatcher", "ignored", a2.b.a(), "because shut down");
            }
            return;
        }
        com.a.a.c c3 = com.a.a.c.a(a2.j(), this, this.k, this.l, a2);
        c3.n = this.c.submit((Runnable)c3);
        this.e.put((Object)a2.e(), (Object)c3);
        if (bl) {
            this.f.remove(a2.d());
        }
        if (a2.j().l) {
            ag.a("Dispatcher", "enqueued", a2.b.a());
        }
    }

    void a(com.a.a.c c2) {
        this.i.sendMessage(this.i.obtainMessage(4, (Object)c2));
    }

    void a(com.a.a.c c2, boolean bl) {
        if (c2.j().l) {
            String string = ag.a(c2);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("for error");
            String string2 = bl ? " (will replay)" : "";
            stringBuilder.append(string2);
            ag.a("Dispatcher", "batched", string, stringBuilder.toString());
        }
        this.e.remove((Object)c2.f());
        this.g(c2);
    }

    void a(Object object) {
        if (!this.h.add(object)) {
            return;
        }
        Iterator iterator = this.e.values().iterator();
        while (iterator.hasNext()) {
            com.a.a.c c2 = (com.a.a.c)iterator.next();
            boolean bl = c2.j().l;
            com.a.a.a a2 = c2.i();
            List<com.a.a.a> list = c2.k();
            boolean bl2 = list != null && !list.isEmpty();
            if (a2 == null && !bl2) continue;
            if (a2 != null && a2.l().equals(object)) {
                c2.b(a2);
                this.g.put(a2.d(), (Object)a2);
                if (bl) {
                    String string = a2.b.a();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("because tag '");
                    stringBuilder.append(object);
                    stringBuilder.append("' was paused");
                    ag.a("Dispatcher", "paused", string, stringBuilder.toString());
                }
            }
            if (bl2) {
                for (int i2 = list.size() - 1; i2 >= 0; --i2) {
                    com.a.a.a a3 = (com.a.a.a)list.get(i2);
                    if (!a3.l().equals(object)) continue;
                    c2.b(a3);
                    this.g.put(a3.d(), (Object)a3);
                    if (!bl) continue;
                    String string = a3.b.a();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("because tag '");
                    stringBuilder.append(object);
                    stringBuilder.append("' was paused");
                    ag.a("Dispatcher", "paused", string, stringBuilder.toString());
                }
            }
            if (!c2.b()) continue;
            iterator.remove();
            if (!bl) continue;
            ag.a("Dispatcher", "canceled", ag.a(c2), "all actions paused");
        }
    }

    void a(boolean bl) {
        this.i.sendMessage(this.i.obtainMessage(10, (int)bl, 0));
    }

    void b(NetworkInfo networkInfo) {
        if (this.c instanceof v) {
            ((v)this.c).a(networkInfo);
        }
        if (networkInfo != null && networkInfo.isConnected()) {
            this.b();
        }
    }

    void b(com.a.a.a a2) {
        this.i.sendMessage(this.i.obtainMessage(2, (Object)a2));
    }

    void b(com.a.a.c c2) {
        this.i.sendMessageDelayed(this.i.obtainMessage(5, (Object)c2), 500L);
    }

    void b(Object object) {
        if (!this.h.remove(object)) {
            return;
        }
        ArrayList arrayList = null;
        Iterator iterator = this.g.values().iterator();
        while (iterator.hasNext()) {
            com.a.a.a a2 = (com.a.a.a)iterator.next();
            if (!a2.l().equals(object)) continue;
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add((Object)a2);
            iterator.remove();
        }
        if (arrayList != null) {
            this.j.sendMessage(this.j.obtainMessage(13, arrayList));
        }
    }

    void b(boolean bl) {
        this.p = bl;
    }

    void c(com.a.a.a a2) {
        this.a(a2, true);
    }

    void c(com.a.a.c c2) {
        this.i.sendMessage(this.i.obtainMessage(6, (Object)c2));
    }

    void d(com.a.a.a a2) {
        com.a.a.a a3;
        String string = a2.e();
        com.a.a.c c2 = (com.a.a.c)this.e.get((Object)string);
        if (c2 != null) {
            c2.b(a2);
            if (c2.b()) {
                this.e.remove((Object)string);
                if (a2.j().l) {
                    ag.a("Dispatcher", "canceled", a2.c().a());
                }
            }
        }
        if (this.h.contains(a2.l())) {
            this.g.remove(a2.d());
            if (a2.j().l) {
                ag.a("Dispatcher", "canceled", a2.c().a(), "because paused request got canceled");
            }
        }
        if ((a3 = (com.a.a.a)this.f.remove(a2.d())) != null && a3.j().l) {
            ag.a("Dispatcher", "canceled", a3.c().a(), "from replaying");
        }
    }

    void d(com.a.a.c c2) {
        if (c2.c()) {
            return;
        }
        if (this.c.isShutdown()) {
            this.a(c2, false);
            return;
        }
        boolean bl = this.o;
        NetworkInfo networkInfo = null;
        if (bl) {
            networkInfo = ((ConnectivityManager)ag.a(this.b, "connectivity")).getActiveNetworkInfo();
        }
        boolean bl2 = networkInfo != null && networkInfo.isConnected();
        boolean bl3 = c2.a(this.p, networkInfo);
        boolean bl4 = c2.d();
        if (!bl3) {
            boolean bl5 = this.o;
            boolean bl6 = false;
            if (bl5) {
                bl6 = false;
                if (bl4) {
                    bl6 = true;
                }
            }
            this.a(c2, bl6);
            if (bl6) {
                this.f(c2);
            }
            return;
        }
        if (this.o && !bl2) {
            this.a(c2, bl4);
            if (bl4) {
                this.f(c2);
            }
            return;
        }
        if (c2.j().l) {
            ag.a("Dispatcher", "retrying", ag.a(c2));
        }
        if (c2.l() instanceof r.a) {
            c2.i |= q.a.d;
        }
        c2.n = this.c.submit((Runnable)c2);
    }

    void e(com.a.a.c c2) {
        if (p.b(c2.g())) {
            this.k.a(c2.f(), c2.e());
        }
        this.e.remove((Object)c2.f());
        this.g(c2);
        if (c2.j().l) {
            ag.a("Dispatcher", "batched", ag.a(c2), "for completion");
        }
    }

    private static class a
    extends Handler {
        private final i a;

        public a(Looper looper, i i2) {
            super(looper);
            this.a = i2;
        }

        public void handleMessage(final Message message) {
            switch (message.what) {
                default: {
                    t.a.post(new Runnable(){

                        public void run() {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Unknown handler message received: ");
                            stringBuilder.append(message.what);
                            throw new AssertionError((Object)stringBuilder.toString());
                        }
                    });
                    return;
                }
                case 12: {
                    Object object = message.obj;
                    this.a.b(object);
                    return;
                }
                case 11: {
                    Object object = message.obj;
                    this.a.a(object);
                    return;
                }
                case 10: {
                    i i2 = this.a;
                    int n2 = message.arg1;
                    boolean bl = false;
                    if (n2 == 1) {
                        bl = true;
                    }
                    i2.b(bl);
                    return;
                }
                case 9: {
                    NetworkInfo networkInfo = (NetworkInfo)message.obj;
                    this.a.b(networkInfo);
                    return;
                }
                case 7: {
                    this.a.a();
                    return;
                }
                case 6: {
                    com.a.a.c c2 = (com.a.a.c)message.obj;
                    this.a.a(c2, false);
                    return;
                }
                case 5: {
                    com.a.a.c c3 = (com.a.a.c)message.obj;
                    this.a.d(c3);
                    return;
                }
                case 4: {
                    com.a.a.c c4 = (com.a.a.c)message.obj;
                    this.a.e(c4);
                    return;
                }
                case 2: {
                    com.a.a.a a2 = (com.a.a.a)message.obj;
                    this.a.d(a2);
                    return;
                }
                case 1: 
            }
            com.a.a.a a3 = (com.a.a.a)message.obj;
            this.a.c(a3);
        }

    }

    static class b
    extends HandlerThread {
        b() {
            super("Picasso-Dispatcher", 10);
        }
    }

    static class c
    extends BroadcastReceiver {
        private final i a;

        c(i i2) {
            this.a = i2;
        }

        void a() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
            if (this.a.o) {
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
            this.a.b.registerReceiver((BroadcastReceiver)this, intentFilter);
        }

        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            String string = intent.getAction();
            if ("android.intent.action.AIRPLANE_MODE".equals((Object)string)) {
                if (!intent.hasExtra("state")) {
                    return;
                }
                this.a.a(intent.getBooleanExtra("state", false));
                return;
            }
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals((Object)string)) {
                ConnectivityManager connectivityManager = (ConnectivityManager)ag.a(context, "connectivity");
                this.a.a(connectivityManager.getActiveNetworkInfo());
            }
        }
    }

}

