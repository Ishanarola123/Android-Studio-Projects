/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.Log
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package com.xiaomi.onetrack.h;

import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.onetrack.f.a;
import com.xiaomi.onetrack.h.x;

public class o {
    public static boolean a = false;
    public static boolean b = false;
    private static final int c = 3000;
    private static final String d = "OneTrack-Api-";
    private static final int e = 0;
    private static final int f = 1;
    private static final int g = 2;
    private static final int h = 3;
    private static final int i = 4;

    public static String a(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(d);
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a() {
        block4 : {
            boolean bl;
            block3 : {
                block2 : {
                    try {
                        String string2 = a.d();
                        String string3 = x.a("debug.onetrack.log");
                        boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
                        bl = true;
                        boolean bl3 = !bl2 && !TextUtils.isEmpty((CharSequence)string2) && TextUtils.equals((CharSequence)string2, (CharSequence)string3);
                        a = bl3;
                        String string4 = x.a("debug.onetrack.upload");
                        if (TextUtils.isEmpty((CharSequence)string4) || TextUtils.isEmpty((CharSequence)string2) || !TextUtils.equals((CharSequence)string2, (CharSequence)string4)) break block2;
                        break block3;
                    }
                    catch (Exception exception) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("LogUtil static initializer: ");
                        stringBuilder.append(exception.toString());
                        Log.e((String)"OneTrackSdk", (String)stringBuilder.toString());
                        break block4;
                    }
                }
                bl = false;
            }
            b = bl;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("log on: ");
        stringBuilder.append(a);
        stringBuilder.append(", quick upload on: ");
        stringBuilder.append(b);
        Log.d((String)"OneTrackSdk", (String)stringBuilder.toString());
    }

    public static void a(String string2, String string3) {
        if (a) {
            o.a(o.a(string2), string3, 3);
        }
    }

    private static void a(String string2, String string3, int n2) {
        if (string3 == null) {
            return;
        }
        int n3 = 0;
        while (n3 <= string3.length() / 3000) {
            int n4 = n3 * 3000;
            int n5 = string3.length();
            int n6 = Math.min((int)n5, (int)(++n3 * 3000));
            if (n4 >= n6) continue;
            String string4 = string3.substring(n4, n6);
            if (n2 != 0) {
                if (n2 != 1) {
                    if (n2 != 2) {
                        if (n2 != 3) {
                            if (n2 != 4) continue;
                            Log.v((String)string2, (String)string4);
                            continue;
                        }
                        Log.d((String)string2, (String)string4);
                        continue;
                    }
                    Log.i((String)string2, (String)string4);
                    continue;
                }
                Log.w((String)string2, (String)string4);
                continue;
            }
            Log.e((String)string2, (String)string4);
        }
    }

    public static void a(String string2, String string3, Throwable throwable) {
        if (a) {
            Log.d((String)o.a(string2), (String)string3, (Throwable)throwable);
        }
    }

    public static void b(String string2, String string3) {
        if (a) {
            o.a(o.a(string2), string3, 0);
        }
    }

    public static void b(String string2, String string3, Throwable throwable) {
        if (a) {
            Log.e((String)o.a(string2), (String)string3, (Throwable)throwable);
        }
    }

    public static void c(String string2, String string3) {
        if (a) {
            o.a(o.a(string2), string3, 1);
        }
    }

    public static void c(String string2, String string3, Throwable throwable) {
        if (a) {
            Log.w((String)o.a(string2), (String)string3, (Throwable)throwable);
        }
    }

    public static void d(String string2, String string3) {
        if (a) {
            o.a(o.a(string2), string3, 2);
        }
    }

    public static void d(String string2, String string3, Throwable throwable) {
        if (a) {
            Log.i((String)o.a(string2), (String)string3, (Throwable)throwable);
        }
    }
}

