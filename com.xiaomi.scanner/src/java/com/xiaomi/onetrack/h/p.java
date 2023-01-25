/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.BroadcastReceiver
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.Signature
 *  android.graphics.Point
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Environment
 *  android.os.Process
 *  android.os.StatFs
 *  android.provider.Settings
 *  android.provider.Settings$Global
 *  android.telephony.TelephonyManager
 *  android.text.TextUtils
 *  android.util.Log
 *  android.view.Display
 *  android.view.WindowManager
 *  java.io.BufferedReader
 *  java.io.File
 *  java.io.FileReader
 *  java.io.Reader
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.Double
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.lang.reflect.Field
 *  java.lang.reflect.Method
 *  java.text.DecimalFormat
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.Locale
 *  java.util.Random
 *  java.util.Set
 *  java.util.TimeZone
 */
package com.xiaomi.onetrack.h;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Point;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.xiaomi.onetrack.OneTrack;
import com.xiaomi.onetrack.c.g;
import com.xiaomi.onetrack.d.d;
import com.xiaomi.onetrack.f.a;
import com.xiaomi.onetrack.h.o;
import com.xiaomi.onetrack.h.x;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;

public class p {
    private static volatile long A = 0L;
    private static final int B = 1;
    private static final int C = 2;
    private static final String D = "";
    private static Method E;
    private static boolean F = false;
    private static String G;
    private static boolean H = false;
    private static int I = 0;
    private static final Set<String> J;
    public static final int a = 29;
    public static final int b = 25;
    public static final int c = 24;
    public static final int d = 23;
    public static final int e = 22;
    public static final int f = 21;
    public static final int g = 19;
    public static final int h = 17;
    public static final int i = 28;
    private static final String j = "OsUtil";
    private static Class k;
    private static Method l;
    private static Boolean m;
    private static final String n = "ro.build.version.sdk";
    private static final String o = "ro.miui.cust_variant";
    private static final String p = "ro.miui.region";
    private static final String q = "ro.product.mod_device";
    private static final String r = "persist.radio.modem";
    private static final String s = "ro.board.platform";
    private static final String t = "\\d+.\\d+.\\d+(-internal)?";
    private static final long u = 1024L;
    private static final long v = 1024L;
    private static final long w = 0x100000L;
    private static final long x = 0x40000000L;
    private static final DecimalFormat y;
    private static final DecimalFormat z;

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    static {
        p.y = new DecimalFormat("#0");
        p.z = new DecimalFormat("#0.#");
        p.A = 0L;
        p.H = false;
        try {
            p.E = Class.forName((String)"android.os.SystemProperties").getMethod("get", new Class[]{String.class});
            ** GOTO lbl-1000
        }
        catch (Exception v0) {
            try lbl-1000: // 2 sources:
            {
                p.k = Class.forName((String)"miui.os.Build");
                ** GOTO lbl-1000
            }
            catch (Exception v1) {
                try lbl-1000: // 2 sources:
                {
                    p.l = Class.forName((String)"android.provider.MiuiSettings$Secure").getDeclaredMethod("isUserExperienceProgramEnable", new Class[]{ContentResolver.class});
                    p.l.setAccessible(true);
                }
                catch (Exception v2) {}
            }
        }
        p.J = new HashSet((Collection)Arrays.asList((Object[])new String[]{"AT", "BE", "BG", "CY", "CZ", "DE", "DK", "EE", "ES", "FI", "FR", "GB", "GR", "HR", "HU", "IE", "IT", "LT", "LU", "LV", "MT", "NL", "PL", "PT", "RO", "SE", "SI", "SK"}));
    }

    public static boolean A() {
        if (p.a() && !H) {
            return p.F();
        }
        return F;
    }

    public static String B() {
        if (p.a() && !H) {
            return p.D();
        }
        if (!TextUtils.isEmpty((CharSequence)G)) {
            return G;
        }
        return p.D();
    }

    public static String C() {
        return p.D();
    }

    private static String D() {
        try {
            Object object;
            Object object2;
            String string2 = x.a(p, D);
            if (TextUtils.isEmpty((CharSequence)string2)) {
                string2 = x.a("ro.product.locale.region", D);
            }
            if (TextUtils.isEmpty((CharSequence)string2) && Build.VERSION.SDK_INT >= 24 && (object2 = (object = Class.forName((String)"android.os.LocaleList").getMethod("getDefault", new Class[0]).invoke(null, new Object[0])).getClass().getMethod("size", new Class[0]).invoke(object, new Object[0])) instanceof Integer && (Integer)object2 > 0) {
                Class class_ = object.getClass();
                Class[] arrclass = new Class[]{Integer.TYPE};
                Method method = class_.getMethod("get", arrclass);
                Object[] arrobject = new Object[]{0};
                Object object3 = method.invoke(object, arrobject);
                Object object4 = object3.getClass().getMethod("getCountry", new Class[0]).invoke(object3, new Object[0]);
                if (object4 instanceof String) {
                    string2 = (String)object4;
                }
            }
            if (TextUtils.isEmpty((CharSequence)string2)) {
                string2 = Locale.getDefault().getCountry();
            }
            if (!TextUtils.isEmpty((CharSequence)string2)) {
                String string3 = string2.trim();
                return string3;
            }
        }
        catch (Exception exception) {
            o.b(j, "getRegion Exception: ", exception);
        }
        return D;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static long E() {
        long l2;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            long l3 = (long)statFs.getBlockSize() * (long)statFs.getBlockCount();
            if (l3 >= 0x200000000L) {
                return 8L * (0x40000000L * (1L + l3 / 8L / 0x40000000L));
            }
            l2 = l3 / 0x40000000L;
        }
        catch (Exception exception) {
            o.b(j, "getTotalROM Exception: ", exception);
            return 0L;
        }
        return 0x40000000L * (l2 + 1L);
    }

    /*
     * Exception decompiling
     */
    private static boolean F() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl15.1 : INVOKESTATIC : trying to set 0 previously set to 1
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    public static PackageInfo a(Context context, String string2, int n2) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(string2, n2);
            return packageInfo;
        }
        catch (Exception exception) {
            return null;
        }
    }

    public static String a(int n2) {
        int n3;
        char c2;
        block3 : {
            try {
                n3 = n2 / 60000;
                c2 = '+';
                if (n3 >= 0) break block3;
                c2 = '-';
            }
            catch (Exception exception) {
                return D;
            }
            n3 = -n3;
        }
        StringBuilder stringBuilder = new StringBuilder(9);
        stringBuilder.append("GMT");
        stringBuilder.append(c2);
        p.a(stringBuilder, n3 / 60);
        stringBuilder.append(':');
        p.a(stringBuilder, n3 % 60);
        String string2 = stringBuilder.toString();
        return string2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static String a(long var0, boolean var2_1) {
        block6 : {
            if (!var2_1) ** GOTO lbl5
            var4_2 = p.y;
            break block6;
lbl5: // 1 sources:
            var4_2 = p.z;
        }
        if (var0 < 1024L && var0 > 0L) {
            var30_3 = new StringBuilder();
            var30_3.append(var4_2.format((double)var0));
            var30_3.append("B");
            return var30_3.toString();
        }
        if (var0 >= 0x100000L) ** GOTO lbl21
        var5_4 = new StringBuilder();
        var6_5 = var0;
        Double.isNaN((double)var6_5);
        var9_6 = var6_5 / 1024.0;
        var5_4.append(var4_2.format(var9_6));
        var5_4.append("KB");
        return var5_4.toString();
lbl21: // 1 sources:
        if (var0 >= 0x40000000L) ** GOTO lbl30
        var13_7 = new StringBuilder();
        var14_8 = var0;
        Double.isNaN((double)var14_8);
        var17_9 = var14_8 / 1048576.0;
        var13_7.append(var4_2.format(var17_9));
        var13_7.append("MB");
        return var13_7.toString();
lbl30: // 1 sources:
        var21_10 = new StringBuilder();
        var22_11 = var0;
        Double.isNaN((double)var22_11);
        var25_12 = var22_11 / 1.073741824E9;
        try {
            var21_10.append(var4_2.format(var25_12));
            var21_10.append("GB");
            return var21_10.toString();
        }
        catch (Exception var3_14) {
            o.b("OsUtil", "formatFileSize Exception: ", var3_14);
            return "";
        }
    }

    public static String a(Context context) {
        String string2;
        String string3 = p.f("gsm.operator.numeric");
        StringBuilder stringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty((CharSequence)string3)) {
            for (String string4 : string3.split(",")) {
                if (TextUtils.isEmpty((CharSequence)string4) || "00000".equals((Object)string4)) continue;
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(",");
                }
                stringBuilder.append(string4);
            }
        }
        if (TextUtils.isEmpty((CharSequence)(string2 = stringBuilder.toString()))) {
            string2 = ((TelephonyManager)context.getSystemService("phone")).getNetworkOperator();
        }
        if (string2 == null) {
            string2 = D;
        }
        return string2;
    }

    private static void a(StringBuilder stringBuilder, int n2) {
        String string2 = Integer.toString((int)n2);
        for (int i2 = 0; i2 < 2 - string2.length(); ++i2) {
            stringBuilder.append('0');
        }
        stringBuilder.append(string2);
    }

    public static void a(boolean bl) {
        H = bl;
    }

    public static void a(boolean bl, String string2, OneTrack.Mode mode) {
        int n2 = mode == OneTrack.Mode.APP ? 3 : (mode == OneTrack.Mode.PLUGIN ? 2 : (mode == OneTrack.Mode.SDK ? 1 : 0));
        if (I <= n2) {
            F = bl;
            G = string2;
            I = n2;
        }
    }

    public static boolean a() {
        Boolean bl = m;
        if (bl != null) {
            return bl;
        }
        m = !TextUtils.isEmpty((CharSequence)p.f("ro.miui.ui.version.code")) ? Boolean.valueOf((boolean)true) : Boolean.valueOf((boolean)false);
        return m;
    }

    /*
     * Exception decompiling
     */
    public static boolean a(Context var0, String var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    public static boolean a(ApplicationInfo applicationInfo) {
        return (1 & applicationInfo.flags) != 0;
    }

    public static boolean a(String string2) {
        if (!OneTrack.isDisable() && !OneTrack.isUseSystemNetTrafficOnly()) {
            if (!p.z()) {
                o.c(string2, "should not access network or location, not provisioned");
                return true;
            }
            if (!g.b()) {
                o.c(string2, "should not access network or location, cta");
                return true;
            }
            return false;
        }
        o.c(string2, "should not access network or location, cta");
        return true;
    }

    public static Signature[] a(Context context, File file) {
        try {
            Signature[] arrsignature = context.getPackageManager().getPackageArchiveInfo((String)file.getPath(), (int)64).signatures;
            return arrsignature;
        }
        catch (Exception exception) {
            return null;
        }
    }

    public static String b() {
        return Build.VERSION.RELEASE;
    }

    public static boolean b(Context context) {
        Method method = l;
        if (method == null) {
            return true;
        }
        try {
            Object[] arrobject = new Object[]{context.getContentResolver()};
            boolean bl = (Boolean)method.invoke(null, arrobject);
            return bl;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("isUserExperiencePlanEnabled failed: ");
            stringBuilder.append(exception.toString());
            Log.e((String)j, (String)stringBuilder.toString());
            return true;
        }
    }

    public static boolean b(Context context, String string2) {
        try {
            boolean bl = p.a(p.a((Context)context, (String)string2, (int)0).applicationInfo);
            return bl;
        }
        catch (Exception exception) {
            return false;
        }
    }

    public static boolean b(String string2) {
        try {
            boolean bl = (Boolean)Class.forName((String)"miui.os.MiuiInit").getMethod("isPreinstalledPackage", new Class[]{String.class}).invoke(null, new Object[]{string2});
            return bl;
        }
        catch (Exception exception) {
            Log.e((String)o.a(j), (String)"checkPreinstallApp failed:", (Throwable)exception);
            return false;
        }
        catch (ClassNotFoundException classNotFoundException) {
            if (p.a()) {
                Log.e((String)o.a(j), (String)"checkPreinstallApp failed:", (Throwable)classNotFoundException);
            }
            return false;
        }
    }

    public static String c() {
        return Build.VERSION.INCREMENTAL;
    }

    public static String c(Context context) {
        return p.a(p.f(context), true);
    }

    public static boolean c(Context context, String string2) {
        PackageInfo packageInfo = p.a(context, string2, 0);
        boolean bl = false;
        if (packageInfo != null) {
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            bl = false;
            if (applicationInfo != null) {
                bl = true;
            }
        }
        return bl;
    }

    public static boolean c(String string2) {
        try {
            boolean bl = (Boolean)Class.forName((String)"miui.os.MiuiInit").getMethod("isPreinstalledPAIPackage", new Class[]{String.class}).invoke(null, new Object[]{string2});
            return bl;
        }
        catch (Exception exception) {
            Log.e((String)o.a(j), (String)"isPreinstalledPAIPackage failed:", (Throwable)exception);
            return false;
        }
    }

    public static double d(Context context) {
        int n2;
        int n3;
        try {
            Intent intent = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            n2 = intent.getIntExtra("level", -1);
            n3 = intent.getIntExtra("scale", -1);
        }
        catch (Exception exception) {
            Log.e((String)o.a(j), (String)"getBatteryInfo exception", (Throwable)exception);
            return 0.0;
        }
        double d2 = n2;
        double d3 = n3;
        Double.isNaN((double)d2);
        Double.isNaN((double)d3);
        double d4 = 10.0 * (100.0 * (d2 / d3));
        long l2 = Math.round((double)d4);
        double d5 = l2;
        Double.isNaN((double)d5);
        return d5 / 10.0;
    }

    public static int d(String string2) {
        boolean bl = p.b(string2);
        boolean bl2 = p.c(string2);
        int n2 = bl ? 1 : 0;
        if (bl2) {
            n2 |= 2;
        }
        return n2;
    }

    public static String d() {
        return p.a(TimeZone.getDefault().getRawOffset());
    }

    public static Signature[] d(Context context, String string2) {
        try {
            Signature[] arrsignature = context.getPackageManager().getPackageInfo((String)string2, (int)64).signatures;
            return arrsignature;
        }
        catch (Exception exception) {
            return null;
        }
    }

    public static String e() {
        Locale locale = Locale.getDefault();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(locale.getLanguage());
        stringBuilder.append("_");
        stringBuilder.append(locale.getCountry());
        return stringBuilder.toString();
    }

    public static String e(Context context) {
        Display display = ((WindowManager)context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            display.getRealSize(point);
        } else {
            display.getSize(point);
        }
        Object[] arrobject = new Object[]{point.y, point.x};
        return String.format((String)"%d*%d", (Object[])arrobject);
    }

    public static String e(String string2) {
        try {
            String string3 = a.a().getPackageManager().getPackageInfo((String)string2, (int)16384).versionName;
            return string3;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return D;
        }
    }

    private static long f(Context context) {
        int n2;
        try {
            BufferedReader bufferedReader = new BufferedReader((Reader)new FileReader("/proc/meminfo"), 2048);
            String string2 = bufferedReader.readLine();
            String string3 = string2.substring(string2.indexOf("MemTotal:"));
            bufferedReader.close();
            n2 = Integer.parseInt((String)string3.replaceAll("\\D+", D));
        }
        catch (Exception exception) {
            o.b(j, "getTotalRAM Exception: ", exception);
            return 0L;
        }
        return 1024L * (long)n2;
    }

    public static String f() {
        Class class_ = k;
        if (class_ != null) {
            block7 : {
                block6 : {
                    if (!((Boolean)class_.getField("IS_ALPHA_BUILD").get(null)).booleanValue()) break block6;
                    return "A";
                }
                if (!((Boolean)k.getField("IS_DEVELOPMENT_VERSION").get(null)).booleanValue()) break block7;
                return "D";
            }
            try {
                if (((Boolean)k.getField("IS_STABLE_VERSION").get(null)).booleanValue()) {
                    return "S";
                }
            }
            catch (Exception exception) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("getRomBuildCode failed: ");
                stringBuilder.append(exception.toString());
                Log.e((String)j, (String)stringBuilder.toString());
            }
        }
        return D;
    }

    private static String f(String string2) {
        try {
            if (E != null) {
                String string3 = String.valueOf((Object)E.invoke(null, new Object[]{string2}));
                return string3;
            }
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("getProp failed ex: ");
            stringBuilder.append(exception.getMessage());
            o.a(j, stringBuilder.toString());
        }
        return null;
    }

    public static String g() {
        return x.a("ro.carrier.name", D);
    }

    public static String h() {
        return x.a("ro.miui.xms.version", D);
    }

    public static boolean i() {
        String string2 = x.a(p, "unknown");
        if (!TextUtils.isEmpty((CharSequence)string2) && !TextUtils.equals((CharSequence)string2, (CharSequence)"unknown")) {
            String string3 = string2.toUpperCase();
            return J.contains((Object)string3);
        }
        return true;
    }

    public static String j() {
        return Build.VERSION.RELEASE;
    }

    public static String k() {
        return Build.VERSION.INCREMENTAL;
    }

    public static String l() {
        return Build.VERSION.RELEASE;
    }

    public static int m() {
        return Build.VERSION.SDK_INT;
    }

    public static String n() {
        return x.a(o, D);
    }

    public static String o() {
        return x.a(p, D);
    }

    public static String p() {
        return x.a(r, D);
    }

    public static String q() {
        return p.a(p.E(), true);
    }

    public static String r() {
        return x.a(s, D);
    }

    public static boolean s() {
        return x.a(q, D).endsWith("_global");
    }

    public static int t() {
        try {
            Class class_ = Class.forName((String)"miui.telephony.TelephonyManager");
            Object object = class_.getMethod("getDefault", new Class[0]).invoke(null, new Object[0]);
            int n2 = (Integer)class_.getMethod("getPhoneCount", new Class[0]).invoke(object, new Object[0]);
            return n2;
        }
        catch (Exception exception) {
            o.b(j, "getPhoneCount Exception: ", exception);
            return 0;
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static int u() {
        Integer n2;
        block4 : {
            Exception exception;
            block5 : {
                n2 = null;
                int n3 = Build.VERSION.SDK_INT;
                n2 = null;
                if (n3 < 17) break block4;
                Class class_ = Class.forName((String)"android.os.UserHandle");
                Class[] arrclass = new Class[]{Integer.TYPE};
                Method method = class_.getDeclaredMethod("getUserId", arrclass);
                method.setAccessible(true);
                int n4 = Process.myUid();
                Object[] arrobject = new Object[]{n4};
                Integer n5 = (Integer)method.invoke(null, arrobject);
                try {
                    Object[] arrobject2 = new Object[]{n4, n5};
                    o.a(j, String.format((String)"getUserId, uid:%d, userId:%d", (Object[])arrobject2));
                    n2 = n5;
                    break block4;
                }
                catch (Exception exception2) {
                    exception = exception2;
                    n2 = n5;
                    break block5;
                }
                catch (Exception exception3) {
                    // empty catch block
                }
            }
            Log.e((String)o.a(j), (String)"getUserId exception: ", (Throwable)exception);
        }
        if (n2 != null) return n2;
        n2 = 0;
        return n2;
    }

    public static boolean v() {
        return p.u() == 0;
    }

    public static boolean w() {
        int n2 = p.u();
        if (n2 >= 10 && n2 != 99 && n2 != 999) {
            o.a(j, "second space");
            return true;
        }
        return false;
    }

    public static boolean x() {
        return p.u() == 999;
    }

    public static String y() {
        long l2 = System.currentTimeMillis();
        Random random = new Random(l2);
        double d2 = l2;
        double d3 = random.nextDouble();
        Double.isNaN((double)d2);
        return d.h(String.valueOf((double)(d2 + d3))).substring(0, 24);
    }

    @TargetApi(value=17)
    public static boolean z() {
        boolean bl;
        block6 : {
            Context context;
            block5 : {
                try {
                    context = a.a();
                    if (Build.VERSION.SDK_INT >= 17) break block5;
                    return true;
                }
                catch (Exception exception) {
                    o.b(j, "isDeviceProvisioned exception", exception);
                    return true;
                }
            }
            int n2 = Settings.Global.getInt((ContentResolver)context.getContentResolver(), (String)"device_provisioned", (int)0);
            bl = false;
            if (n2 != 0) {
                bl = true;
            }
            if (bl) break block6;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Provisioned: ");
            stringBuilder.append(bl);
            o.c(j, stringBuilder.toString());
        }
        return bl;
    }
}

