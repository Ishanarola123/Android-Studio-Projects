/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.IllegalAccessException
 *  java.lang.NoSuchFieldException
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Field
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Method
 */
package miuix.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflects {
    private Reflects() {
    }

    public static Class<?> forName(String string2) {
        try {
            Class class_ = Class.forName((String)string2);
            return class_;
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new RuntimeException((Throwable)classNotFoundException);
        }
    }

    public static Object get(Object object, Field field) {
        try {
            Object object2 = field.get(object);
            return object2;
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException((Throwable)illegalAccessException);
        }
    }

    public static Field getDeclaredField(Class<?> class_, String string2) {
        try {
            Field field = class_.getDeclaredField(string2);
            field.setAccessible(true);
            return field;
        }
        catch (NoSuchFieldException noSuchFieldException) {
            throw new RuntimeException((Throwable)noSuchFieldException);
        }
    }

    public static Field getDeclaredField(String string2, String string3) {
        return Reflects.getDeclaredField(Reflects.forName(string2), string3);
    }

    public static /* varargs */ Method getDeclaredMethod(Class<?> class_, String string2, Class<?> ... arrclass) {
        try {
            Method method = class_.getDeclaredMethod(string2, arrclass);
            method.setAccessible(true);
            return method;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new RuntimeException((Throwable)noSuchMethodException);
        }
    }

    public static /* varargs */ Method getDeclaredMethod(String string2, String string3, Class<?> ... arrclass) {
        return Reflects.getDeclaredMethod(Reflects.forName(string2), string3, arrclass);
    }

    public static Field getField(Class<?> class_, String string2) {
        try {
            Field field = class_.getField(string2);
            field.setAccessible(true);
            return field;
        }
        catch (NoSuchFieldException noSuchFieldException) {
            throw new RuntimeException((Throwable)noSuchFieldException);
        }
    }

    public static Field getField(String string2, String string3) {
        return Reflects.getField(Reflects.forName(string2), string3);
    }

    public static /* varargs */ Method getMethod(Class<?> class_, String string2, Class<?> ... arrclass) {
        try {
            Method method = class_.getMethod(string2, arrclass);
            method.setAccessible(true);
            return method;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new RuntimeException((Throwable)noSuchMethodException);
        }
    }

    public static /* varargs */ Method getMethod(String string2, String string3, Class<?> ... arrclass) {
        return Reflects.getMethod(Reflects.forName(string2), string3, arrclass);
    }

    public static /* varargs */ Object invoke(Object object, Method method, Object ... arrobject) {
        try {
            Object object2 = method.invoke(object, arrobject);
            return object2;
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new RuntimeException((Throwable)invocationTargetException);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException((Throwable)illegalAccessException);
        }
    }

    public static void set(Object object, Field field, Object object2) {
        try {
            field.set(object, object2);
            return;
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException((Throwable)illegalAccessException);
        }
    }
}

