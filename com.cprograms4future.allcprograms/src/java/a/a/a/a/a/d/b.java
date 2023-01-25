/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.io.File
 *  java.io.IOException
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.List
 *  java.util.Locale
 *  java.util.concurrent.RejectedExecutionException
 *  java.util.concurrent.ScheduledExecutorService
 *  java.util.concurrent.ScheduledFuture
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.atomic.AtomicReference
 */
package a.a.a.a.a.d;

import a.a.a.a.a.d.d;
import a.a.a.a.a.d.i;
import a.a.a.a.a.d.j;
import a.a.a.a.a.d.k;
import a.a.a.a.a.d.m;
import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public abstract class b<T>
implements i<T> {
    protected final Context a;
    protected final d<T> b;
    final ScheduledExecutorService c;
    final AtomicReference<ScheduledFuture<?>> d;
    volatile int e = -1;

    public b(Context context, ScheduledExecutorService scheduledExecutorService, d<T> d2) {
        this.a = context;
        this.c = scheduledExecutorService;
        this.b = d2;
        this.d = new AtomicReference();
    }

    @Override
    protected void a(int n2) {
        this.e = n2;
        this.a(0L, this.e);
    }

    void a(long l2, long l3) {
        boolean bl = this.d.get() == null;
        if (bl) {
            m m2 = new m(this.a, this);
            Context context = this.a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Scheduling time based file roll over every ");
            stringBuilder.append(l3);
            stringBuilder.append(" seconds");
            a.a.a.a.a.b.i.a(context, stringBuilder.toString());
            try {
                this.d.set((Object)this.c.scheduleAtFixedRate((Runnable)m2, l2, l3, TimeUnit.SECONDS));
                return;
            }
            catch (RejectedExecutionException rejectedExecutionException) {
                a.a.a.a.a.b.i.a(this.a, "Failed to schedule time based file roll over", rejectedExecutionException);
            }
        }
    }

    @Override
    public void a(T t) {
        a.a.a.a.a.b.i.a(this.a, t.toString());
        try {
            this.b.a(t);
        }
        catch (IOException iOException) {
            a.a.a.a.a.b.i.a(this.a, "Failed to write event.", iOException);
        }
        this.e();
    }

    @Override
    public void b() {
        this.f();
    }

    @Override
    public void c() {
        if (this.d.get() != null) {
            a.a.a.a.a.b.i.a(this.a, "Cancelling time-based rollover because no events are currently being generated.");
            ((ScheduledFuture)this.d.get()).cancel(false);
            this.d.set(null);
        }
    }

    @Override
    public boolean d() {
        try {
            boolean bl = this.b.b();
            return bl;
        }
        catch (IOException iOException) {
            a.a.a.a.a.b.i.a(this.a, "Failed to roll file over.", iOException);
            return false;
        }
    }

    public void e() {
        boolean bl = this.e != -1;
        if (bl) {
            this.a(this.e, this.e);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void f() {
        int n2;
        k k2 = this.a();
        if (k2 == null) {
            a.a.a.a.a.b.i.a(this.a, "skipping files send because we don't yet know the target endpoint");
            return;
        }
        a.a.a.a.a.b.i.a(this.a, "Sending all files");
        List<File> list = this.b.e();
        n2 = 0;
        try {
            while (list.size() > 0) {
                Context context = this.a;
                Locale locale = Locale.US;
                Object[] arrobject = new Object[]{list.size()};
                a.a.a.a.a.b.i.a(context, String.format((Locale)locale, (String)"attempt to send batch of %d files", (Object[])arrobject));
                boolean bl = k2.a(list);
                if (bl) {
                    n2 += list.size();
                    this.b.a(list);
                }
                if (bl) {
                    list = this.b.e();
                    continue;
                }
                break;
            }
        }
        catch (Exception exception) {
            Context context = this.a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to send batch of analytics files to server: ");
            stringBuilder.append(exception.getMessage());
            a.a.a.a.a.b.i.a(context, stringBuilder.toString(), exception);
        }
        if (n2 == 0) {
            this.b.f();
        }
    }
}

