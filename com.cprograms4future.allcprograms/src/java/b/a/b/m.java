/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.net.Proxy
 *  java.net.Proxy$Type
 */
package b.a.b;

import b.s;
import b.z;
import java.net.Proxy;

public final class m {
    public static String a(s s2) {
        String string = s2.h();
        String string2 = s2.k();
        if (string2 != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append('?');
            stringBuilder.append(string2);
            string = stringBuilder.toString();
        }
        return string;
    }

    static String a(z z2, Proxy.Type type) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(z2.b());
        stringBuilder.append(' ');
        if (m.b(z2, type)) {
            stringBuilder.append((Object)z2.a());
        } else {
            stringBuilder.append(m.a(z2.a()));
        }
        stringBuilder.append(" HTTP/1.1");
        return stringBuilder.toString();
    }

    private static boolean b(z z2, Proxy.Type type) {
        return !z2.g() && type == Proxy.Type.HTTP;
    }
}

