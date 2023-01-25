/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.a.a;

public final class q
extends Enum<q> {
    public static final /* enum */ q a = new q(1);
    public static final /* enum */ q b = new q(2);
    public static final /* enum */ q c = new q(4);
    private static final /* synthetic */ q[] e;
    final int d;

    static {
        q[] arrq = new q[]{a, b, c};
        e = arrq;
    }

    private q(int n3) {
        this.d = n3;
    }

    public static boolean a(int n2) {
        return (n2 & q.a.d) == 0;
    }

    public static boolean b(int n2) {
        return (n2 & q.b.d) == 0;
    }

    public static boolean c(int n2) {
        return (n2 & q.c.d) != 0;
    }

    public static q valueOf(String string) {
        return (q)Enum.valueOf(q.class, (String)string);
    }

    public static q[] values() {
        return (q[])e.clone();
    }
}

