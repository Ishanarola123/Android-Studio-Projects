/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Method
 */
package com.xiaomi.onetrack.h;

import android.content.Context;
import com.xiaomi.onetrack.h.o;
import java.lang.reflect.Method;

public class m {
    private static final String a = "IdentifierManager";
    private static Object b;
    private static Class<?> c;
    private static Method d;
    private static Method e;
    private static Method f;
    private static Method g;

    static {
        try {
            c = Class.forName((String)"com.android.id.impl.IdProviderImpl");
            b = c.newInstance();
            d = c.getMethod("getUDID", new Class[]{Context.class});
            e = c.getMethod("getOAID", new Class[]{Context.class});
            f = c.getMethod("getVAID", new Class[]{Context.class});
            g = c.getMethod("getAAID", new Class[]{Context.class});
        }
        catch (Exception exception) {
            o.b(a, "reflect exception!", exception);
        }
    }

    public static String a(Context context) {
        return m.a(context, d);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static String a(Context context, Method method) {
        Object object = b;
        if (object == null) return "";
        if (method == null) return "";
        Object object2 = method.invoke(object, new Object[]{context});
        if (object2 == null) return "";
        try {
            return (String)object2;
        }
        catch (Exception exception) {
            o.b(a, "invoke exception!", exception);
        }
        return "";
    }

    public static boolean a() {
        return c != null && b != null;
    }

    public static String b(Context context) {
        return m.a(context, e);
    }

    public static String c(Context context) {
        return m.a(context, f);
    }

    public static String d(Context context) {
        return m.a(context, g);
    }
}

