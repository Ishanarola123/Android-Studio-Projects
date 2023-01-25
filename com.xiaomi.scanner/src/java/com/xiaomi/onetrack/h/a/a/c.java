/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.onetrack.h.a.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.onetrack.h.a.a.d;
import com.xiaomi.onetrack.h.a.a.e;
import com.xiaomi.onetrack.h.a.a.g;
import com.xiaomi.onetrack.h.a.a.i;
import com.xiaomi.onetrack.h.a.a.k;
import com.xiaomi.onetrack.h.a.a.l;
import com.xiaomi.onetrack.h.a.a.n;
import com.xiaomi.onetrack.h.a.a.p;
import com.xiaomi.onetrack.h.a.a.r;
import com.xiaomi.onetrack.h.a.a.s;
import com.xiaomi.onetrack.h.m;
import com.xiaomi.onetrack.h.o;
import com.xiaomi.onetrack.h.x;

public class c {
    static String a = "c";

    private static String c() {
        return Build.MANUFACTURER.toUpperCase();
    }

    public String a(Context context) {
        try {
            String string2 = this.a(context, c.c());
            return string2;
        }
        catch (Exception exception) {
            o.b(a, exception.getMessage());
            return "";
        }
    }

    String a(Context context, String string2) throws Exception {
        a a2 = a.b(string2);
        if (this.a()) {
            a2 = a.o;
        }
        if (this.b()) {
            a2 = a.p;
        }
        if (a2 != null) {
            switch (d.a[a2.ordinal()]) {
                default: {
                    return "";
                }
                case 14: 
                case 15: 
                case 16: {
                    return new s().a(context);
                }
                case 13: {
                    return new l().a(context);
                }
                case 10: 
                case 11: 
                case 12: {
                    return m.b(context);
                }
                case 9: {
                    return new r().a(context);
                }
                case 8: {
                    return new k().a(context);
                }
                case 7: {
                    return new p().a(context);
                }
                case 6: {
                    return new n().a(context);
                }
                case 5: {
                    return new i().a(context);
                }
                case 3: 
                case 4: {
                    return new g().a(context);
                }
                case 2: {
                    return new e().a(context);
                }
                case 1: 
            }
            return new com.xiaomi.onetrack.h.a.a.a().a(context);
        }
        throw new Exception(String.format((String)"undefined oaid method of manufacturer %s", (Object[])new Object[]{string2}));
    }

    public boolean a() {
        String string2 = x.a("ro.build.freeme.label");
        return !TextUtils.isEmpty((CharSequence)string2) && string2.equalsIgnoreCase("FREEMEOS");
    }

    public boolean b() {
        String string2 = x.a("ro.ssui.product");
        return !TextUtils.isEmpty((CharSequence)string2) && !string2.equalsIgnoreCase("unknown");
    }

    static final class a
    extends Enum<a> {
        public static final /* enum */ a a = new a("ASUS");
        public static final /* enum */ a b = new a("HUAWEI");
        public static final /* enum */ a c = new a("LENOVO");
        public static final /* enum */ a d = new a("MOTOLORA");
        public static final /* enum */ a e = new a("MEIZU");
        public static final /* enum */ a f = new a("OPPO");
        public static final /* enum */ a g = new a("SAMSUNG");
        public static final /* enum */ a h = new a("NUBIA");
        public static final /* enum */ a i = new a("VIVO");
        public static final /* enum */ a j = new a("XIAOMI");
        public static final /* enum */ a k = new a("REDMI");
        public static final /* enum */ a l = new a("BLACKSHARK");
        public static final /* enum */ a m = new a("ONEPLUS");
        public static final /* enum */ a n = new a("ZTE");
        public static final /* enum */ a o = new a("FERRMEOS");
        public static final /* enum */ a p = new a("SSUI");
        private static final /* synthetic */ a[] r;
        public final String q;

        static {
            a[] arra = new a[]{a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p};
            r = arra;
        }

        private a(String string3) {
            this.q = string3;
        }

        public static a a(String string2) {
            return (a)Enum.valueOf(a.class, (String)string2);
        }

        public static a[] a() {
            return (a[])r.clone();
        }

        static a b(String string2) {
            for (a a2 : a.a()) {
                if (!a2.q.equals((Object)string2)) continue;
                return a2;
            }
            return null;
        }
    }

}

