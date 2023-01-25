/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.NullPointerException
 *  java.lang.Object
 */
package com.google.a.b;

public final class a {
    public static <T> T a(T t2) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException();
    }

    public static void a(boolean bl) {
        if (bl) {
            return;
        }
        throw new IllegalArgumentException();
    }
}

