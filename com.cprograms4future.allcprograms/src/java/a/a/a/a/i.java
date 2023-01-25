/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  a.a.a.a.h
 *  android.content.Context
 *  java.io.File
 *  java.lang.Class
 *  java.lang.Comparable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Void
 *  java.lang.annotation.Annotation
 *  java.util.concurrent.ExecutorService
 */
package a.a.a.a;

import a.a.a.a.a.b.m;
import a.a.a.a.c;
import a.a.a.a.d;
import a.a.a.a.f;
import a.a.a.a.h;
import android.content.Context;
import java.io.File;
import java.lang.annotation.Annotation;
import java.util.concurrent.ExecutorService;

public abstract class i<Result>
implements Comparable<i> {
    c e;
    h<Result> f = new h(this);
    Context g;
    f<Result> h;
    m i;
    final a.a.a.a.a.c.d j = (a.a.a.a.a.c.d)this.getClass().getAnnotation(a.a.a.a.a.c.d.class);

    public int a(i i2) {
        if (this.b(i2)) {
            return 1;
        }
        if (i2.b(this)) {
            return -1;
        }
        if (this.p() && !i2.p()) {
            return 1;
        }
        if (!this.p() && i2.p()) {
            return -1;
        }
        return 0;
    }

    public abstract String a();

    void a(Context context, c c2, f<Result> f2, m m2) {
        this.e = c2;
        this.g = new d(context, this.b(), this.o());
        this.h = f2;
        this.i = m2;
    }

    protected void a(Result Result) {
    }

    public abstract String b();

    protected void b(Result Result) {
    }

    boolean b(i i2) {
        if (this.p()) {
            Class<?>[] arrclass = this.j.a();
            int n2 = arrclass.length;
            for (int i3 = 0; i3 < n2; ++i3) {
                if (!arrclass[i3].isAssignableFrom(i2.getClass())) continue;
                return true;
            }
        }
        return false;
    }

    public /* synthetic */ int compareTo(Object object) {
        return this.a((i)object);
    }

    protected abstract Result d();

    protected boolean g() {
        return true;
    }

    final void k() {
        h<Result> h2 = this.f;
        ExecutorService executorService = this.e.e();
        Object[] arrobject = new Void[]{null};
        h2.a(executorService, arrobject);
    }

    protected m l() {
        return this.i;
    }

    public Context m() {
        return this.g;
    }

    public c n() {
        return this.e;
    }

    public String o() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(".Fabric");
        stringBuilder.append(File.separator);
        stringBuilder.append(this.b());
        return stringBuilder.toString();
    }

    boolean p() {
        return this.j != null;
    }
}

