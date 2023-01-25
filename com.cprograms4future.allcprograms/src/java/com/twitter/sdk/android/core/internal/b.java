/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.twitter.sdk.android.core.internal.b$1
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.Calendar
 *  java.util.Collection
 *  java.util.Map
 *  java.util.TimeZone
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.Future
 */
package com.twitter.sdk.android.core.internal;

import a.a.a.a.a;
import a.a.a.a.a.b.q;
import com.twitter.sdk.android.core.internal.b;
import com.twitter.sdk.android.core.internal.c;
import com.twitter.sdk.android.core.j;
import com.twitter.sdk.android.core.k;
import java.util.Calendar;
import java.util.Collection;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class b<T extends j> {
    protected final a a;
    private final q b;
    private final k<T> c;
    private final ExecutorService d;
    private final c e;

    b(k<T> k2, q q2, ExecutorService executorService, a a2, c c2) {
        this.b = q2;
        this.c = k2;
        this.d = executorService;
        this.a = a2;
        this.e = c2;
    }

    public b(k<T> k2, ExecutorService executorService, c<T> c2) {
        this(k2, new q(), executorService, new a(), c2);
    }

    public void a() {
        T t2 = this.c.b();
        long l2 = this.b.a();
        boolean bl = t2 != null && this.a.a(l2);
        if (bl) {
            this.d.submit(new Runnable(){

                public void run() {
                    b.this.b();
                }
            });
        }
    }

    public void a(a.a.a.a.a a2) {
        a2.a((a.b)new 1(this));
    }

    protected void b() {
        for (j j2 : this.c.c().values()) {
            this.e.a(j2);
        }
        this.a.b(this.b.a());
    }

    protected static class a {
        public boolean a;
        public long b;
        private final Calendar c = Calendar.getInstance((TimeZone)TimeZone.getTimeZone((String)"UTC"));

        private boolean a(long l2, long l3) {
            this.c.setTimeInMillis(l2);
            int n2 = this.c.get(6);
            int n3 = this.c.get(1);
            this.c.setTimeInMillis(l3);
            int n4 = this.c.get(6);
            int n5 = this.c.get(1);
            return n2 == n4 && n3 == n5;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public boolean a(long l2) {
            a a2 = this;
            synchronized (a2) {
                boolean bl = l2 - this.b > 21600000L;
                boolean bl2 = true ^ this.a(l2, this.b);
                if (!this.a && (bl || bl2)) {
                    this.a = true;
                    return true;
                }
                return false;
            }
        }

        public void b(long l2) {
            a a2 = this;
            synchronized (a2) {
                this.a = false;
                this.b = l2;
                return;
            }
        }
    }

}

