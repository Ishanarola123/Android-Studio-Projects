/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package b;

public final class ae
extends Enum<ae> {
    public static final /* enum */ ae a = new ae("TLSv1.2");
    public static final /* enum */ ae b = new ae("TLSv1.1");
    public static final /* enum */ ae c = new ae("TLSv1");
    public static final /* enum */ ae d = new ae("SSLv3");
    private static final /* synthetic */ ae[] f;
    final String e;

    static {
        ae[] arrae = new ae[]{a, b, c, d};
        f = arrae;
    }

    private ae(String string2) {
        this.e = string2;
    }

    public static ae a(String string) {
        int n2;
        block12 : {
            switch (string.hashCode()) {
                default: {
                    break;
                }
                case 79923350: {
                    if (!string.equals((Object)"TLSv1")) break;
                    n2 = 2;
                    break block12;
                }
                case 79201641: {
                    if (!string.equals((Object)"SSLv3")) break;
                    n2 = 3;
                    break block12;
                }
                case -503070502: {
                    if (!string.equals((Object)"TLSv1.2")) break;
                    n2 = 0;
                    break block12;
                }
                case -503070503: {
                    if (!string.equals((Object)"TLSv1.1")) break;
                    n2 = 1;
                    break block12;
                }
            }
            n2 = -1;
        }
        switch (n2) {
            default: {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unexpected TLS version: ");
                stringBuilder.append(string);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 3: {
                return d;
            }
            case 2: {
                return c;
            }
            case 1: {
                return b;
            }
            case 0: 
        }
        return a;
    }

    public static ae valueOf(String string) {
        return (ae)Enum.valueOf(ae.class, (String)string);
    }

    public static ae[] values() {
        return (ae[])f.clone();
    }
}

