/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  a.a.a.a.a.c.f$a$1
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.concurrent.Executor
 *  java.util.concurrent.ExecutorService
 */
package a.a.a.a.a.c;

import a.a.a.a.a.c.a;
import a.a.a.a.a.c.b;
import a.a.a.a.a.c.e;
import a.a.a.a.a.c.f;
import a.a.a.a.a.c.h;
import a.a.a.a.a.c.i;
import a.a.a.a.a.c.k;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/*
 * Exception performing whole class analysis.
 */
public abstract class f<Params, Progress, Result>
extends a.a.a.a.a.c.a<Params, Progress, Result>
implements b<k>,
h,
k {
    private final i a;

    public f() {
        this.a = new i();
    }

    @Override
    public void a(k k2) {
        if (this.y_() == a.d.a) {
            ((b)((Object)((h)this.g()))).c(k2);
            return;
        }
        throw new IllegalStateException("Must not add Dependency after task is running");
    }

    @Override
    public void a(Throwable throwable) {
        ((k)((Object)((h)this.g()))).a(throwable);
    }

    public final /* varargs */ void a(ExecutorService executorService, Params ... arrParams) {
        super.a(}
    java.lang.IllegalStateException: Inner class got unexpected class file - revert this change
    
    