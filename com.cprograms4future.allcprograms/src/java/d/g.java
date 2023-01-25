/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.CloneNotSupportedException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.annotation.Annotation
 *  java.lang.reflect.Type
 *  java.util.concurrent.Executor
 */
package d;

import d.b;
import d.c;
import d.d;
import d.g;
import d.l;
import d.m;
import d.o;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;

final class g
extends c.a {
    final Executor a;

    g(Executor executor) {
        this.a = executor;
    }

    public c<b<?>> a(Type type, Annotation[] arrannotation, m m2) {
        if (g.a(type) != b.class) {
            return null;
        }
        return new c<b<?>>(o.e(type)){
            final /* synthetic */ Type a;
            {
                this.a = type;
            }

            @Override
            public /* synthetic */ Object a(b b2) {
                return this.b(b2);
            }

            @Override
            public Type a() {
                return this.a;
            }

            public <R> b<R> b(b<R> b2) {
                return new a<R>(g.this.a, b2);
            }
        };
    }

    static final class a<T>
    implements b<T> {
        final Executor a;
        final b<T> b;

        a(Executor executor, b<T> b2) {
            this.a = executor;
            this.b = b2;
        }

        @Override
        public l<T> a() throws IOException {
            return this.b.a();
        }

        @Override
        public void a(final d<T> d2) {
            if (d2 != null) {
                this.b.a(new d<T>(){

                    @Override
                    public void a(b<T> b2, l<T> l2) {
                        a.this.a.execute(new Runnable(this, l2){
                            final /* synthetic */ l a;
                            final /* synthetic */ 1 b;
                            {
                                this.b = var1_1;
                                this.a = l2;
                            }

                            public void run() {
                                if (this.b.a.this.b.b()) {
                                    this.b.d2.a(this.b.a.this, new IOException("Canceled"));
                                    return;
                                }
                                this.b.d2.a(this.b.a.this, this.a);
                            }
                        });
                    }

                    @Override
                    public void a(b<T> b2, Throwable throwable) {
                        a.this.a.execute(new Runnable(this, throwable){
                            final /* synthetic */ Throwable a;
                            final /* synthetic */ 1 b;
                            {
                                this.b = var1_1;
                                this.a = throwable;
                            }

                            public void run() {
                                this.b.d2.a(this.b.a.this, this.a);
                            }
                        });
                    }
                });
                return;
            }
            throw new NullPointerException("callback == null");
        }

        @Override
        public boolean b() {
            return this.b.b();
        }

        @Override
        public b<T> c() {
            return new a<T>(this.a, this.b.c());
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            return this.c();
        }

    }

}

