/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.a.a;

public final class p
extends Enum<p> {
    public static final /* enum */ p a = new p(1);
    public static final /* enum */ p b = new p(2);
    private static final /* synthetic */ p[] d;
    final int c;

    static {
        p[] arrp = new p[]{a, b};
        d = arrp;
    }

    private p(int n3) {
        this.c = n3;
    }

    static boolean a(int n2) {
        return (n2 & p.a.c) == 0;
    }

    static boolean b(int n2) {
        return (n2 & p.b.c) == 0;
    }

    public static p valueOf(String string) {
        return (p)Enum.valueOf(p.class, (String)string);
    }

    public static p[] values() {
        return (p[])d.clone();
    }
}

