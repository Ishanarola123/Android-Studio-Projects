/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package a.a.a.a.a.c;

import a.a.a.a.a.c.h;

public final class e
extends Enum<e> {
    public static final /* enum */ e a = new e();
    public static final /* enum */ e b = new e();
    public static final /* enum */ e c = new e();
    public static final /* enum */ e d = new e();
    private static final /* synthetic */ e[] e;

    static {
        e[] arre = new e[]{a, b, c, d};
        e = arre;
    }

    static <Y> int a(h h2, Y y2) {
        e e2 = y2 instanceof h ? ((h)y2).b() : b;
        return e2.ordinal() - h2.b().ordinal();
    }

    public static e valueOf(String string) {
        return (e)Enum.valueOf(e.class, (String)string);
    }

    public static e[] values() {
        return (e[])e.clone();
    }
}

