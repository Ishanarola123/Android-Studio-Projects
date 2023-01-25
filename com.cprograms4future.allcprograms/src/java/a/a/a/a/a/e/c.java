/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package a.a.a.a.a.e;

public final class c
extends Enum<c> {
    public static final /* enum */ c a = new c();
    public static final /* enum */ c b = new c();
    public static final /* enum */ c c = new c();
    public static final /* enum */ c d = new c();
    private static final /* synthetic */ c[] e;

    static {
        c[] arrc = new c[]{a, b, c, d};
        e = arrc;
    }

    public static c valueOf(String string) {
        return (c)Enum.valueOf(c.class, (String)string);
    }

    public static c[] values() {
        return (c[])e.clone();
    }
}

