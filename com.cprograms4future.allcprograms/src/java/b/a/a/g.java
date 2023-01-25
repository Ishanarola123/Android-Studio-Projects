/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package b.a.a;

public final class g
extends Enum<g> {
    public static final /* enum */ g a = new g();
    public static final /* enum */ g b = new g();
    public static final /* enum */ g c = new g();
    public static final /* enum */ g d = new g();
    private static final /* synthetic */ g[] e;

    static {
        g[] arrg = new g[]{a, b, c, d};
        e = arrg;
    }

    public static g valueOf(String string) {
        return (g)Enum.valueOf(g.class, (String)string);
    }

    public static g[] values() {
        return (g[])e.clone();
    }

    public boolean a() {
        return this == b || this == c;
        {
        }
    }

    public boolean b() {
        return this == a;
    }

    public boolean c() {
        return this == c;
    }

    public boolean d() {
        return this == b;
    }
}

