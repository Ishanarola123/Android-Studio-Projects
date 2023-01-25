/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.annotation.Annotation
 *  java.lang.reflect.Type
 */
package d;

import d.b;
import d.m;
import d.o;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

public interface c<T> {
    public <R> T a(b<R> var1);

    public Type a();

    public static abstract class a {
        protected static Class<?> a(Type type) {
            return o.a(type);
        }

        public abstract c<?> a(Type var1, Annotation[] var2, m var3);
    }

}

