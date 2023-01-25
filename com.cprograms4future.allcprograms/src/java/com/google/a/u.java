/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.google.a;

public abstract class u
extends Enum<u> {
    public static final /* enum */ u a = new u(){};
    public static final /* enum */ u b = new u(){};
    private static final /* synthetic */ u[] c;

    static {
        u[] arru = new u[]{a, b};
        c = arru;
    }

    private u() {
    }

    public static u valueOf(String string) {
        return (u)Enum.valueOf(u.class, (String)string);
    }

    public static u[] values() {
        return (u[])c.clone();
    }

}

