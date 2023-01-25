/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Method
 */
package com.xiaomi.onetrack.h;

import android.util.Log;
import com.xiaomi.onetrack.h.o;
import java.lang.reflect.Method;

public class x {
    private static final String a = "SystemProperties";

    public static long a(String string2, Long l2) {
        try {
            Class class_ = Class.forName((String)"android.os.SystemProperties");
            Class[] arrclass = new Class[]{String.class, Long.TYPE};
            long l3 = (Long)class_.getMethod("getLong", arrclass).invoke(null, new Object[]{string2, l2});
            return l3;
        }
        catch (Exception exception) {
            Log.e((String)o.a(a), (String)"getLong e", (Throwable)exception);
            return l2;
        }
    }

    public static String a(String string2) {
        return x.a(string2, "");
    }

    public static String a(String string2, String string3) {
        try {
            String string4 = (String)Class.forName((String)"android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{string2, string3});
            return string4;
        }
        catch (Exception exception) {
            Log.e((String)o.a(a), (String)"get e", (Throwable)exception);
            return string3;
        }
    }
}

