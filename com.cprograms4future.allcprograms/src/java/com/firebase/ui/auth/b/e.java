/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 */
package com.firebase.ui.auth.b;

public final class e {
    public static /* varargs */ <T> T a(T t2, String string, Object ... arrobject) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(String.format((String)string, (Object[])arrobject));
    }
}

