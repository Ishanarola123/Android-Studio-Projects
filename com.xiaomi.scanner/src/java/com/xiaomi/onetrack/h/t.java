/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.onetrack.h;

import android.os.Looper;

public class t {
    private static final String a = "ProcessUtil";

    public static boolean a() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}

