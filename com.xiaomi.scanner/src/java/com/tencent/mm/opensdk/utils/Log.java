/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.lang.Object
 *  java.lang.String
 */
package com.tencent.mm.opensdk.utils;

import com.tencent.mm.opensdk.utils.ILog;

public class Log {
    private static ILog logImpl;

    public static void d(String string2, String string3) {
        ILog iLog = logImpl;
        if (iLog == null) {
            android.util.Log.d((String)string2, (String)string3);
            return;
        }
        iLog.d(string2, string3);
    }

    public static void e(String string2, String string3) {
        ILog iLog = logImpl;
        if (iLog == null) {
            android.util.Log.e((String)string2, (String)string3);
            return;
        }
        iLog.e(string2, string3);
    }

    public static void i(String string2, String string3) {
        ILog iLog = logImpl;
        if (iLog == null) {
            android.util.Log.i((String)string2, (String)string3);
            return;
        }
        iLog.i(string2, string3);
    }

    public static void setLogImpl(ILog iLog) {
        logImpl = iLog;
    }

    public static void v(String string2, String string3) {
        ILog iLog = logImpl;
        if (iLog == null) {
            android.util.Log.v((String)string2, (String)string3);
            return;
        }
        iLog.v(string2, string3);
    }

    public static void w(String string2, String string3) {
        ILog iLog = logImpl;
        if (iLog == null) {
            android.util.Log.w((String)string2, (String)string3);
            return;
        }
        iLog.w(string2, string3);
    }
}

