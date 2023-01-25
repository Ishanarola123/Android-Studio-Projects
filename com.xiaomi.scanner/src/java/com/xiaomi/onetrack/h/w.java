/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.onetrack.h;

import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.onetrack.f.a;
import com.xiaomi.onetrack.h.y;

public class w {
    private static final String A = "onetrack_user_id";
    private static final String B = "onetrack_user_type";
    private static final String C = "custom_id";
    private static final String D = "page_end";
    private static final String E = "last_app_version";
    private static final String F = "first_launch_time";
    private static final String a = "onetrack";
    private static final String b = "one_track_pref";
    private static SharedPreferences c;
    private static SharedPreferences.Editor d;
    private static final String e = "last_upload_active_time";
    private static final String f = "last_upload_usage_time";
    private static final String g = "last_collect_crash_time";
    private static final String h = "report_crash_ticket";
    private static final String i = "last_secret_key_time";
    private static final String j = "last_common_cloud_time";
    private static final String k = "next_update_common_conf_time";
    private static final String l = "common_cloud_data";
    private static final String m = "common_config_hash";
    private static final String n = "s_t";
    private static final String o = "l_t";
    private static final String p = "e_t";
    private static final String q = "secret_key_data";
    private static final String r = "region_rul";
    private static final String s = "pref_instance_id";
    private static final String t = "pref_instance_id_last_use_time";
    private static final String u = "last_usage_resume_component";
    private static final String v = "last_usage_resume_time";
    private static final String w = "network_access_enabled";
    private static final String x = "anonymous_enabled";
    private static final String y = "onetrack_first_open";
    private static final String z = "dau_last_time";

    public static String A() {
        return w.a(E, "");
    }

    public static long B() {
        return w.a(F, 0L);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void C() {
        if (d != null) {
            return;
        }
        Class<w> class_ = w.class;
        synchronized (w.class) {
            if (d == null) {
                c = a.a().getSharedPreferences(b, 0);
                d = c.edit();
            }
            // ** MonitorExit[var1] (shouldn't be in output)
            return;
        }
    }

    public static long a() {
        return w.a(e, 0L);
    }

    private static long a(String string2, long l2) {
        w.C();
        return c.getLong(string2, l2);
    }

    public static String a(Context context) {
        return w.a(C, "");
    }

    private static String a(String string2, String string3) {
        w.C();
        return c.getString(string2, string3);
    }

    public static void a(long l2) {
        w.b(e, l2);
    }

    public static void a(Context context, String string2) {
        w.b(C, string2);
    }

    public static void a(String string2) {
        w.b(q, string2);
    }

    private static void a(String string2, float f2) {
        w.C();
        d.putFloat(string2, f2).apply();
    }

    public static void a(boolean bl) {
        w.b(w, bl);
    }

    private static boolean a(String string2, boolean bl) {
        w.C();
        return c.getBoolean(string2, bl);
    }

    private static float b(String string2, float f2) {
        w.C();
        return c.getFloat(string2, f2);
    }

    public static long b() {
        return w.a(g, 0L);
    }

    public static long b(long l2) {
        return w.a(f, l2);
    }

    public static void b(String string2) {
        w.b(r, string2);
    }

    private static void b(String string2, long l2) {
        w.C();
        d.putLong(string2, l2).apply();
    }

    private static void b(String string2, String string3) {
        w.C();
        d.putString(string2, string3).apply();
    }

    private static void b(String string2, boolean bl) {
        w.C();
        d.putBoolean(string2, bl).apply();
    }

    public static void b(boolean bl) {
        w.b(x, bl);
    }

    public static long c() {
        return w.a(h, 0L);
    }

    public static void c(long l2) {
        w.b(g, l2);
    }

    public static void c(String string2) {
        w.b(m, string2);
    }

    public static void c(boolean bl) {
        w.b(y, bl);
    }

    public static long d() {
        return w.a(n, 0L);
    }

    public static void d(long l2) {
        w.b(h, l2);
    }

    public static void d(String string2) {
        w.b(l, string2);
    }

    public static long e() {
        return w.a(o, 0L);
    }

    public static void e(long l2) {
        w.b(f, l2);
    }

    public static void e(String string2) {
        w.b(s, string2);
        w.k(y.a());
    }

    public static long f() {
        return w.a(p, 0L);
    }

    public static void f(long l2) {
        w.b(n, l2);
    }

    public static void f(String string2) {
        w.b(u, string2);
    }

    public static String g() {
        return w.a(q, "");
    }

    public static void g(long l2) {
        w.b(o, l2);
    }

    public static void g(String string2) {
        w.b(A, string2);
    }

    public static String h() {
        return w.a(r, "");
    }

    public static void h(long l2) {
        w.b(p, l2);
    }

    public static void h(String string2) {
        w.b(B, string2);
    }

    public static long i() {
        return w.a(i, 0L);
    }

    public static void i(long l2) {
        w.b(i, l2);
    }

    public static void i(String string2) {
        w.b(D, string2);
    }

    public static long j() {
        return w.a(k, 0L);
    }

    public static void j(long l2) {
        w.b(k, l2);
    }

    public static void j(String string2) {
        w.b(E, string2);
    }

    public static String k() {
        return w.a(m, "");
    }

    public static void k(long l2) {
        w.b(t, l2);
    }

    private static void k(String string2) {
        w.C();
        d.remove(string2).apply();
    }

    public static String l() {
        return w.a(l, "");
    }

    public static void l(long l2) {
        w.b(v, l2);
    }

    public static String m() {
        return w.a(s, "");
    }

    public static void m(long l2) {
        w.b(z, l2);
    }

    public static long n() {
        return w.a(t, 0L);
    }

    public static void n(long l2) {
        w.b(F, l2);
    }

    public static String o() {
        return w.a(u, "");
    }

    public static long p() {
        return w.a(v, 0L);
    }

    public static boolean q() {
        return w.a(w, true);
    }

    public static boolean r() {
        return w.a(x, false);
    }

    public static boolean s() {
        return w.a(y, true);
    }

    public static long t() {
        return w.a(z, 0L);
    }

    public static String u() {
        return w.a(A, "");
    }

    public static void v() {
        w.k(A);
    }

    public static String w() {
        return w.a(B, "");
    }

    public static void x() {
        w.k(B);
    }

    public static long y() {
        return w.a(w, 0L);
    }

    public static String z() {
        return w.a(D, "");
    }
}

