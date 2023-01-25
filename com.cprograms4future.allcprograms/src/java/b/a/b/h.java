/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package b.a.b;

public final class h {
    public static boolean a(String string) {
        return string.equals((Object)"POST") || string.equals((Object)"PATCH") || string.equals((Object)"PUT") || string.equals((Object)"DELETE") || string.equals((Object)"MOVE");
        {
        }
    }

    public static boolean b(String string) {
        return string.equals((Object)"POST") || string.equals((Object)"PUT") || string.equals((Object)"PATCH") || string.equals((Object)"PROPPATCH") || string.equals((Object)"REPORT");
        {
        }
    }

    public static boolean c(String string) {
        return h.b(string) || string.equals((Object)"OPTIONS") || string.equals((Object)"DELETE") || string.equals((Object)"PROPFIND") || string.equals((Object)"MKCOL") || string.equals((Object)"LOCK");
        {
        }
    }

    public static boolean d(String string) {
        return true ^ string.equals((Object)"PROPFIND");
    }
}

