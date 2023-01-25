/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package b.a.a;

public final class f {
    public static final c.f a = c.f.a(":status");
    public static final c.f b = c.f.a(":method");
    public static final c.f c = c.f.a(":path");
    public static final c.f d = c.f.a(":scheme");
    public static final c.f e = c.f.a(":authority");
    public static final c.f f = c.f.a(":host");
    public static final c.f g = c.f.a(":version");
    public final c.f h;
    public final c.f i;
    final int j;

    public f(c.f f2, c.f f3) {
        this.h = f2;
        this.i = f3;
        this.j = 32 + f2.f() + f3.f();
    }

    public f(c.f f2, String string) {
        this(f2, c.f.a(string));
    }

    public f(String string, String string2) {
        this(c.f.a(string), c.f.a(string2));
    }

    public boolean equals(Object object) {
        boolean bl = object instanceof f;
        boolean bl2 = false;
        if (bl) {
            f f2 = (f)object;
            boolean bl3 = this.h.equals(f2.h);
            bl2 = false;
            if (bl3) {
                boolean bl4 = this.i.equals(f2.i);
                bl2 = false;
                if (bl4) {
                    bl2 = true;
                }
            }
        }
        return bl2;
    }

    public int hashCode() {
        return 31 * (527 + this.h.hashCode()) + this.i.hashCode();
    }

    public String toString() {
        Object[] arrobject = new Object[]{this.h.a(), this.i.a()};
        return String.format((String)"%s: %s", (Object[])arrobject);
    }
}

