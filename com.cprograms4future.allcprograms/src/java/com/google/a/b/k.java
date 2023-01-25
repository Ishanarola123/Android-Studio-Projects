/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.a.b.k$1
 *  com.google.a.b.k$2
 *  com.google.a.b.k$3
 *  com.google.a.b.k$4
 *  java.io.ObjectInputStream
 *  java.io.ObjectStreamClass
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Field
 *  java.lang.reflect.Method
 */
package com.google.a.b;

import com.google.a.b.k;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class k {
    public static k a() {
        try {
            Class class_ = Class.forName((String)"sun.misc.Unsafe");
            Field field = class_.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            Object object = field.get(null);
            1 var10_3 = new 1(class_.getMethod("allocateInstance", new Class[]{Class.class}), object);
            return var10_3;
        }
        catch (Exception exception) {
            try {
                Method method = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[]{Class.class});
                method.setAccessible(true);
                int n2 = (Integer)method.invoke(null, new Object[]{Object.class});
                Class[] arrclass = new Class[]{Class.class, Integer.TYPE};
                Method method2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", arrclass);
                method2.setAccessible(true);
                2 var6_8 = new 2(method2, n2);
                return var6_8;
            }
            catch (Exception exception2) {
                try {
                    Method method = ObjectInputStream.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Class.class});
                    method.setAccessible(true);
                    3 var1_10 = new 3(method);
                    return var1_10;
                }
                catch (Exception exception3) {
                    return new 4();
                }
            }
        }
    }

    public abstract <T> T a(Class<T> var1) throws Exception;
}

