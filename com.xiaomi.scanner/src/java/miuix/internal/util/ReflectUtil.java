/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.reflect.Method
 */
package miuix.internal.util;

import android.util.Log;
import java.lang.reflect.Method;

public class ReflectUtil {
    private static final String TAG = "ReflectUtil";

    public static /* varargs */ Object callObjectMethod(Object object, String string2, Class<?>[] arrclass, Object ... arrobject) {
        if (object == null) {
            return null;
        }
        try {
            Object object2 = object.getClass().getDeclaredMethod(string2, arrclass).invoke(object, arrobject);
            return object2;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to call method:");
            stringBuilder.append(string2);
            Log.e((String)TAG, (String)stringBuilder.toString(), (Throwable)exception);
            return null;
        }
    }

    public static /* varargs */ <T> T callStaticObjectMethod(Class<?> class_, Class<T> class_2, String string2, Class<?>[] arrclass, Object ... arrobject) {
        Object object;
        if (class_ == null) {
            return null;
        }
        try {
            Method method = class_.getDeclaredMethod(string2, arrclass);
            method.setAccessible(true);
            object = method.invoke(null, arrobject);
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to call static method:");
            stringBuilder.append(string2);
            Log.e((String)TAG, (String)stringBuilder.toString(), (Throwable)exception);
            return null;
        }
        return (T)object;
    }

    public static Class<?> getClass(String string2) {
        try {
            Class class_ = Class.forName((String)string2);
            return class_;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cant find class ");
            stringBuilder.append(string2);
            Log.e((String)TAG, (String)stringBuilder.toString(), (Throwable)exception);
            return null;
        }
    }
}

