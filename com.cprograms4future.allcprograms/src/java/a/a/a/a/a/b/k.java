/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 */
package a.a.a.a.a.b;

public final class k
extends Enum<k> {
    public static final /* enum */ k a = new k(1);
    public static final /* enum */ k b = new k(2);
    public static final /* enum */ k c = new k(3);
    public static final /* enum */ k d = new k(4);
    private static final /* synthetic */ k[] f;
    private final int e;

    static {
        k[] arrk = new k[]{a, b, c, d};
        f = arrk;
    }

    private k(int n3) {
        this.e = n3;
    }

    public static k a(String string) {
        if ("io.crash.air".equals((Object)string)) {
            return c;
        }
        if (string != null) {
            return d;
        }
        return a;
    }

    public static k valueOf(String string) {
        return (k)Enum.valueOf(k.class, (String)string);
    }

    public static k[] values() {
        return (k[])f.clone();
    }

    public int a() {
        return this.e;
    }

    public String toString() {
        return Integer.toString((int)this.e);
    }
}

