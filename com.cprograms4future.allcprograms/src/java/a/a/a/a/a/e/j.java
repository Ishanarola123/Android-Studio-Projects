/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  java.io.UnsupportedEncodingException
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.net.URI
 *  java.net.URLDecoder
 *  java.net.URLEncoder
 *  java.util.TreeMap
 */
package a.a.a.a.a.e;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.TreeMap;

public final class j {
    public static String a(String string) {
        if (string == null) {
            return "";
        }
        try {
            String string2 = URLEncoder.encode((String)string, (String)"UTF8");
            return string2;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new RuntimeException(unsupportedEncodingException.getMessage(), (Throwable)unsupportedEncodingException);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static TreeMap<String, String> a(String string, boolean bl) {
        TreeMap treeMap = new TreeMap();
        if (string == null) {
            return treeMap;
        }
        String[] arrstring = string.split("&");
        int n2 = arrstring.length;
        int n3 = 0;
        while (n3 < n2) {
            String[] arrstring2 = arrstring[n3].split("=");
            if (arrstring2.length == 2) {
                String string2;
                String string3;
                if (bl) {
                    string2 = j.b(arrstring2[0]);
                    string3 = j.b(arrstring2[1]);
                } else {
                    string2 = arrstring2[0];
                    string3 = arrstring2[1];
                }
                treeMap.put((Object)string2, (Object)string3);
            } else if (!TextUtils.isEmpty((CharSequence)arrstring2[0])) {
                String string4 = bl ? j.b(arrstring2[0]) : arrstring2[0];
                treeMap.put((Object)string4, (Object)"");
            }
            ++n3;
        }
        return treeMap;
    }

    public static TreeMap<String, String> a(URI uRI, boolean bl) {
        return j.a(uRI.getRawQuery(), bl);
    }

    public static String b(String string) {
        if (string == null) {
            return "";
        }
        try {
            String string2 = URLDecoder.decode((String)string, (String)"UTF8");
            return string2;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new RuntimeException(unsupportedEncodingException.getMessage(), (Throwable)unsupportedEncodingException);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static String c(String var0) {
        if (var0 == null) {
            return "";
        }
        var1_1 = new StringBuilder();
        var2_2 = j.a(var0);
        var3_3 = var2_2.length();
        var4_4 = 0;
        while (var4_4 < var3_3) {
            block6 : {
                var5_5 = var2_2.charAt(var4_4);
                if (var5_5 != '*') break block6;
                var9_7 = "%2A";
                ** GOTO lbl15
            }
            if (var5_5 == '+') {
                var9_7 = "%20";
lbl15: // 2 sources:
                var1_1.append(var9_7);
            } else if (var5_5 == '%' && (var7_6 = var4_4 + 2) < var3_3 && var2_2.charAt(var4_4 + 1) == '7' && var2_2.charAt(var7_6) == 'E') {
                var1_1.append('~');
                var4_4 = var7_6;
            } else {
                var1_1.append(var5_5);
            }
            ++var4_4;
        }
        return var1_1.toString();
    }
}

