/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.concurrent.Future
 *  java.util.concurrent.ScheduledExecutorService
 */
package a.a.a.a.a.d;

import a.a.a.a.a.d.d;
import a.a.a.a.a.d.e;
import a.a.a.a.a.d.h;
import a.a.a.a.a.d.i;
import android.content.Context;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

public abstract class e<T>
implements h {
    protected final Context a;
    protected final ScheduledExecutorService b;
    protected i<T> c;

    public e(Context context, i<T> i2, d d2, ScheduledExecutorService scheduledExecutorService) {
        this.a = context.getApplicationContext();
        this.b = scheduledExecutorService;
        this.c = i2;
        d2.a(this);
    }

    public void a(T t2, boolean bl) {
        this.a(new Runnable(this, t2, bl){
            final /* synthetic */ Object a;
            final /* synthetic */ boolean b;
            final /* synthetic */ e c;
            {
                this.c = e2;
                this.a = object;
                this.b = bl;
            }

            public void run() {
                try {
                    this.c.c.a(this.a);
                    if (this.b) {
                        this.c.c.d();
                        return;
                    }
                }
                catch (Exception exception) {
                    a.a.a.a.a.b.i.a(this.c.a, "Failed to record event.", exception);
                }
            }
        });
    }

    protected void a(Runnable runnable) {
        try {
            this.b.submit(runnable);
            return;
        }
        catch (Exception exception) {
            a.a.a.a.a.b.i.a(this.a, "Failed to submit events task", exception);
            return;
        }
    }

    @Override
    public void a(String string) {
        this.a(new Runnable(this){
            final /* synthetic */ e a;
            {
                this.a = e2;
            }

            public void run() {
                try {
                    this.a.c.b();
                    return;
                }
                catch (Exception exception) {
                    a.a.a.a.a.b.i.a(this.a.a, "Failed to send events files.", exception);
                    return;
                }
            }
        });
    }
}

