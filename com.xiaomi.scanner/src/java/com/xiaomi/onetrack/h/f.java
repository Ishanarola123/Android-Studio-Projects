/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.ComponentName
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.ServiceConnection
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.Signature
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.graphics.Point
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Environment
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Process
 *  android.os.RemoteException
 *  android.os.StatFs
 *  android.telephony.SubscriptionManager
 *  android.telephony.TelephonyManager
 *  android.text.TextUtils
 *  android.view.Display
 *  android.view.WindowManager
 *  java.io.BufferedReader
 *  java.io.Closeable
 *  java.io.FileInputStream
 *  java.io.InputStream
 *  java.io.InputStreamReader
 *  java.io.Reader
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.InterruptedException
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.reflect.Field
 *  java.lang.reflect.Method
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.Iterator
 *  java.util.List
 */
package com.xiaomi.onetrack.h;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Process;
import android.os.RemoteException;
import android.os.StatFs;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.xiaomi.onetrack.d.d;
import com.xiaomi.onetrack.h.g;
import com.xiaomi.onetrack.h.l;
import com.xiaomi.onetrack.h.o;
import com.xiaomi.onetrack.h.x;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class f {
    private static String A;
    private static String B;
    private static String C;
    private static String D;
    private static String E;
    private static String F;
    private static String G;
    private static Boolean H;
    private static String I;
    static final int a = 15;
    static final int b = 6;
    private static final String c = "DeviceUtil";
    private static final long d = 7776000000L;
    private static final String e = "";
    private static final String f = "ro.build.product";
    private static final String g = "ro.build.description";
    private static final int h = 15;
    private static final int i = 14;
    private static Method j;
    private static Method k;
    private static Method l;
    private static Object m;
    private static Method n;
    private static Method o;
    private static String p;
    private static String q;
    private static String r;
    private static String s;
    private static String t;
    private static String u;
    private static String v;
    private static String w;
    private static String x;
    private static String y;
    private static String z;

    /*
     * Exception decompiling
     */
    static {
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

    private static String A(Context context) {
        if (!TextUtils.isEmpty((CharSequence)r)) {
            return r;
        }
        f.D(context);
        if (!TextUtils.isEmpty((CharSequence)r)) {
            return r;
        }
        return e;
    }

    private static List<String> B(Context context) {
        if (n != null) {
            try {
                ArrayList arrayList = new ArrayList();
                TelephonyManager telephonyManager = (TelephonyManager)context.getSystemService("phone");
                Method method = n;
                Object[] arrobject = new Object[]{0};
                String string2 = (String)method.invoke((Object)telephonyManager, arrobject);
                if (f.c(string2)) {
                    arrayList.add((Object)string2);
                }
                if (f.m()) {
                    Method method2 = n;
                    Object[] arrobject2 = new Object[]{1};
                    String string3 = (String)method2.invoke((Object)telephonyManager, arrobject2);
                    if (f.c(string3)) {
                        arrayList.add((Object)string3);
                    }
                }
                return arrayList;
            }
            catch (Exception exception) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("getImeiListAboveLollipop failed ex: ");
                stringBuilder.append(exception.getMessage());
                o.a(c, stringBuilder.toString());
            }
        }
        return null;
    }

    @SuppressLint(value={"MissingPermission"})
    private static List<String> C(Context context) {
        Class class_;
        ArrayList arrayList;
        block7 : {
            try {
                arrayList = new ArrayList();
                class_ = Class.forName((String)"android.telephony.TelephonyManager");
                boolean bl = f.m();
                if (bl) break block7;
            }
            catch (Exception exception) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("getImeiListBelowLollipop failed ex: ");
                stringBuilder.append(exception.getMessage());
                o.a(c, stringBuilder.toString());
                return null;
            }
            String string2 = ((TelephonyManager)class_.getMethod("getDefault", new Class[0]).invoke(null, new Object[0])).getDeviceId();
            if (f.c(string2)) {
                arrayList.add((Object)string2);
                return arrayList;
            }
        }
        Class[] arrclass = new Class[]{Integer.TYPE};
        Method method = class_.getMethod("getDefault", arrclass);
        Object[] arrobject = new Object[]{0};
        String string3 = ((TelephonyManager)method.invoke(null, arrobject)).getDeviceId();
        Class[] arrclass2 = new Class[]{Integer.TYPE};
        Method method2 = class_.getMethod("getDefault", arrclass2);
        Object[] arrobject2 = new Object[]{1};
        String string4 = ((TelephonyManager)method2.invoke(null, arrobject2)).getDeviceId();
        if (f.c(string3)) {
            arrayList.add((Object)string3);
        }
        if (f.c(string4)) {
            arrayList.add((Object)string4);
        }
        return arrayList;
        return arrayList;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @SuppressLint(value={"MissingPermission"})
    private static List<String> D(Context context) {
        String string2;
        block9 : {
            block8 : {
                if (!f.a(context, "android.permission.READ_PHONE_STATE")) return null;
                Method method = l;
                if (method != null) {
                    try {
                        List list = (List)method.invoke(m, new Object[0]);
                        if (list != null && list.size() > 0 && !f.b((List<String>)list)) {
                            Collections.sort((List)list);
                            r = (String)list.get(0);
                            return list;
                        }
                    }
                    catch (Exception exception) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("queryMeidList failed ex: ");
                        stringBuilder.append(exception.getMessage());
                        o.a(c, stringBuilder.toString());
                    }
                }
                try {
                    Class class_ = Class.forName((String)"android.telephony.TelephonyManager");
                    TelephonyManager telephonyManager = (TelephonyManager)context.getSystemService("phone");
                    if (class_ == null) break block8;
                    if (Build.VERSION.SDK_INT >= 26) {
                        Method method2 = class_.getMethod("getMeid", new Class[0]);
                        if (method2 == null) break block8;
                        string2 = (String)method2.invoke((Object)telephonyManager, new Object[0]);
                        break block9;
                    }
                    Method method3 = class_.getMethod("getDeviceId", new Class[0]);
                    if (method3 == null) break block8;
                    string2 = (String)method3.invoke((Object)telephonyManager, new Object[0]);
                    break block9;
                }
                catch (Exception exception) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("queryMeidList->getMeid failed ex: ");
                    stringBuilder.append(exception.getMessage());
                    o.a(c, stringBuilder.toString());
                    return null;
                }
            }
            string2 = null;
        }
        if (!f.d(string2)) return null;
        {
            ArrayList arrayList = new ArrayList();
            arrayList.add(string2);
            r = string2;
            return arrayList;
        }
    }

    private static boolean E(Context context) {
        return (15 & context.getResources().getConfiguration().screenLayout) >= 3;
    }

    private static boolean F(Context context) {
        if (b.a(context)) {
            return true;
        }
        return (15 & context.getResources().getConfiguration().uiMode) == 4;
    }

    public static long a(long l2) {
        float f2 = l2;
        if ((double)f2 > 900.0) {
            f2 /= 1000.0f;
        }
        if ((double)f2 > 900.0) {
            f2 /= 1000.0f;
        }
        if ((double)f2 > 900.0) {
            f2 /= 1000.0f;
        }
        return (long)f2;
    }

    public static String a(Context context) {
        if (!TextUtils.isEmpty((CharSequence)p)) {
            return p;
        }
        f.r(context);
        if (!TextUtils.isEmpty((CharSequence)p)) {
            return p;
        }
        return e;
    }

    static /* synthetic */ String a(String string2) {
        return f.b(string2);
    }

    public static void a() {
        v = null;
    }

    private static boolean a(Context context, String string2) {
        return context.checkPermission(string2, Process.myPid(), Process.myUid()) == 0;
    }

    private static boolean a(List<String> list) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            if (f.c((String)iterator.next())) continue;
            return true;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static String[] a(Class<?> class_, Class<?> class_2, TelephonyManager telephonyManager, SubscriptionManager subscriptionManager) {
        String[] arrstring = new String[2];
        try {
            int n2 = Build.VERSION.SDK_INT;
            if (n2 == 21) {
                Class[] arrclass = new Class[]{Integer.TYPE};
                Method method = class_2.getMethod("getSubId", arrclass);
                Object[] arrobject = new Object[]{0};
                long[] arrl = (long[])method.invoke((Object)subscriptionManager, arrobject);
                Class[] arrclass2 = new Class[]{Long.TYPE};
                Method method2 = class_.getMethod("getSubscriberId", arrclass2);
                Object[] arrobject2 = new Object[]{arrl[0]};
                arrstring[0] = (String)method2.invoke((Object)telephonyManager, arrobject2);
            } else {
                Class[] arrclass = new Class[]{Integer.TYPE};
                Method method = class_2.getMethod("getSubId", arrclass);
                Object[] arrobject = new Object[]{0};
                int[] arrn = (int[])method.invoke((Object)subscriptionManager, arrobject);
                Class[] arrclass3 = new Class[]{Integer.TYPE};
                Method method3 = class_.getMethod("getSubscriberId", arrclass3);
                Object[] arrobject3 = new Object[]{arrn[0]};
                arrstring[0] = (String)method3.invoke((Object)telephonyManager, arrobject3);
            }
            if (!f.e(arrstring[0]) && n != null && m != null) {
                Method method = o;
                Object object = m;
                Object[] arrobject = new Object[]{0};
                arrstring[0] = (String)method.invoke(object, arrobject);
                Method method4 = o;
                Object object2 = m;
                Object[] arrobject4 = new Object[]{1};
                arrstring[1] = (String)method4.invoke(object2, arrobject4);
                return arrstring;
            }
            if (Build.VERSION.SDK_INT == 21) {
                Class[] arrclass = new Class[]{Integer.TYPE};
                Method method = class_2.getMethod("getSubId", arrclass);
                Object[] arrobject = new Object[]{1};
                long[] arrl = (long[])method.invoke((Object)subscriptionManager, arrobject);
                Class[] arrclass4 = new Class[]{Long.TYPE};
                Method method5 = class_.getMethod("getSubscriberId", arrclass4);
                Object[] arrobject5 = new Object[]{arrl[0]};
                arrstring[1] = (String)method5.invoke((Object)telephonyManager, arrobject5);
                return arrstring;
            }
            Class[] arrclass = new Class[]{Integer.TYPE};
            Method method = class_2.getMethod("getSubId", arrclass);
            Object[] arrobject = new Object[]{1};
            int[] arrn = (int[])method.invoke((Object)subscriptionManager, arrobject);
            Class[] arrclass5 = new Class[]{Integer.TYPE};
            Method method6 = class_.getMethod("getSubscriberId", arrclass5);
            Object[] arrobject6 = new Object[]{arrn[0]};
            arrstring[1] = (String)method6.invoke((Object)telephonyManager, arrobject6);
            return arrstring;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("getImsiFromLToP: ");
            stringBuilder.append((Object)exception);
            o.a(c, stringBuilder.toString());
            return arrstring;
        }
    }

    private static long b(long l2) {
        long l3 = l2 >= 8000000000L ? (long)Math.pow((double)2.0, (double)Math.ceil((double)(Math.log((double)(l2 / 1000000000L)) / Math.log((double)2.0)))) : 1L + l2 / 1000000000L;
        long l4 = l3 * 1000000000L;
        if (l4 < l2) {
            l4 = f.c(l2);
        }
        return l4 / 1000000000L;
    }

    public static String b() {
        return f.b("ro.product.name");
    }

    public static String b(Context context) {
        if (!TextUtils.isEmpty((CharSequence)w)) {
            return w;
        }
        String string2 = f.a(context);
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            w = d.c(string2);
            return w;
        }
        return e;
    }

    private static String b(String string2) {
        try {
            if (j != null) {
                String string3 = String.valueOf((Object)j.invoke(null, new Object[]{string2}));
                return string3;
            }
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("getProp failed ex: ");
            stringBuilder.append(exception.getMessage());
            o.a(c, stringBuilder.toString());
        }
        return null;
    }

    private static boolean b(List<String> list) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            if (f.d((String)iterator.next())) continue;
            return true;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static String[] b(Class<?> class_, Class<?> class_2, TelephonyManager telephonyManager, SubscriptionManager subscriptionManager) {
        String[] arrstring = new String[2];
        try {
            Class[] arrclass = new Class[]{Integer.TYPE};
            Method method = class_2.getMethod("getSubscriptionIds", arrclass);
            Object[] arrobject = new Object[]{0};
            int[] arrn = (int[])method.invoke((Object)subscriptionManager, arrobject);
            if (arrn != null) {
                Class[] arrclass2 = new Class[]{Integer.TYPE};
                Method method2 = class_.getMethod("getSubscriberId", arrclass2);
                Object[] arrobject2 = new Object[]{arrn[0]};
                arrstring[0] = (String)method2.invoke((Object)telephonyManager, arrobject2);
            }
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("get imsi1 above Android Q exception:");
            stringBuilder.append((Object)exception);
            o.b(c, stringBuilder.toString());
        }
        try {
            Class[] arrclass = new Class[]{Integer.TYPE};
            Method method = class_2.getMethod("getSubscriptionIds", arrclass);
            Object[] arrobject = new Object[]{1};
            int[] arrn = (int[])method.invoke((Object)subscriptionManager, arrobject);
            if (arrn == null) return arrstring;
            {
                Class[] arrclass3 = new Class[]{Integer.TYPE};
                Method method3 = class_.getMethod("getSubscriberId", arrclass3);
                Object[] arrobject3 = new Object[]{arrn[0]};
                arrstring[1] = (String)method3.invoke((Object)telephonyManager, arrobject3);
                return arrstring;
            }
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("get imsi2 above Android Q exception:");
            stringBuilder.append((Object)exception);
            o.b(c, stringBuilder.toString());
        }
        return arrstring;
    }

    private static long c(long l2) {
        long l3;
        long l4;
        long l5 = l3 = 1L;
        while ((l4 = l3 * l5) < l2) {
            if ((l3 <<= 1) <= 512L) continue;
            l5 *= 1000L;
            l3 = 1L;
        }
        return l4;
    }

    public static String c() {
        return Build.MODEL;
    }

    public static String c(Context context) {
        if (!TextUtils.isEmpty((CharSequence)A)) {
            return A;
        }
        String string2 = f.a(context);
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            A = d.e(string2);
            return A;
        }
        return e;
    }

    private static boolean c(String string2) {
        return string2 != null && string2.length() == 15 && !string2.matches("^0*$");
    }

    public static String d() {
        return Build.MANUFACTURER;
    }

    public static String d(Context context) {
        if (!TextUtils.isEmpty((CharSequence)C)) {
            return C;
        }
        String string2 = f.a(context);
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            C = d.d(string2);
            return C;
        }
        return e;
    }

    private static boolean d(String string2) {
        return string2 != null && string2.length() == 14 && !string2.matches("^0*$");
    }

    public static String e() {
        try {
            String string2 = f.b("ro.product.model.real");
            if (TextUtils.isEmpty((CharSequence)string2)) {
                string2 = f.c();
            }
            return string2;
        }
        catch (Exception exception) {
            o.b(c, "getModelReal Exception: ", exception);
            return e;
        }
    }

    public static String e(Context context) {
        if (!TextUtils.isEmpty((CharSequence)q)) {
            return q;
        }
        f.r(context);
        if (!TextUtils.isEmpty((CharSequence)q)) {
            return q;
        }
        return e;
    }

    private static boolean e(String string2) {
        return string2 != null && string2.length() >= 6 && string2.length() <= 15 && !string2.matches("^0*$");
    }

    public static String f() {
        try {
            String string2 = x.a("ro.product.mod_device", e);
            if (TextUtils.isEmpty((CharSequence)string2)) {
                string2 = Build.DEVICE;
            }
            return string2;
        }
        catch (Exception exception) {
            o.b(c, "getModDevice Exception: ", exception);
            return e;
        }
    }

    public static String f(Context context) {
        if (!TextUtils.isEmpty((CharSequence)x)) {
            return x;
        }
        String string2 = f.e(context);
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            x = d.c(string2);
            return x;
        }
        return e;
    }

    public static String g() {
        return x.a(g, e);
    }

    public static String g(Context context) {
        if (!TextUtils.isEmpty((CharSequence)B)) {
            return B;
        }
        String string2 = f.e(context);
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            B = d.e(string2);
            return B;
        }
        return e;
    }

    public static String h() {
        try {
            String string2 = x.a("ro.product.manufacturer", e);
            return string2;
        }
        catch (Exception exception) {
            o.b(o.a(c), "getProductManufacturer e", exception);
            return e;
        }
    }

    public static String h(Context context) {
        if (!TextUtils.isEmpty((CharSequence)D)) {
            return D;
        }
        String string2 = f.e(context);
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            D = d.d(string2);
            return D;
        }
        return e;
    }

    public static long i() {
        long l2;
        long l3;
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        if (Build.VERSION.SDK_INT >= 18) {
            l3 = statFs.getBlockSizeLong();
            l2 = statFs.getBlockCountLong();
        } else {
            l3 = statFs.getBlockSize();
            l2 = statFs.getBlockCount();
        }
        return l3 * l2 / 0x40000000L;
    }

    public static String i(Context context) {
        if (!TextUtils.isEmpty((CharSequence)y)) {
            return y;
        }
        String string2 = f.A(context);
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            y = d.c(string2);
            return y;
        }
        return e;
    }

    public static String j() {
        long l2;
        long l3;
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        if (Build.VERSION.SDK_INT >= 18) {
            l3 = statFs.getBlockSizeLong();
            l2 = statFs.getBlockCountLong();
        } else {
            l3 = statFs.getBlockSize();
            l2 = statFs.getBlockCount();
        }
        long l4 = l3 * l2;
        Object[] arrobject = new Object[]{f.b(l4)};
        return String.format((String)"%dGB", (Object[])arrobject);
    }

    public static String j(Context context) {
        if (!TextUtils.isEmpty((CharSequence)E)) {
            return E;
        }
        String string2 = f.A(context);
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            E = d.e(string2);
            return E;
        }
        return e;
    }

    public static long k() {
        long l2;
        long l3;
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        if (Build.VERSION.SDK_INT >= 18) {
            l3 = statFs.getBlockSizeLong();
            l2 = statFs.getAvailableBlocksLong();
        } else {
            l3 = statFs.getBlockSize();
            l2 = statFs.getAvailableBlocks();
        }
        return f.a(l3 * l2);
    }

    public static String k(Context context) {
        if (!TextUtils.isEmpty((CharSequence)s)) {
            return s;
        }
        String string2 = b.b(context);
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            s = string2;
            return s;
        }
        return e;
    }

    public static String l(Context context) {
        if (!TextUtils.isEmpty((CharSequence)t)) {
            return t;
        }
        String string2 = f.u(context);
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            t = string2;
            return t;
        }
        return e;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static List<String> l() {
        if (k == null || f.n()) return null;
        List list = (List)k.invoke(m, new Object[0]);
        if (list == null) return null;
        try {
            boolean bl;
            if (list.size() <= 0 || (bl = f.a((List<String>)list))) return null;
            return list;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("getImeiListFromMiui failed ex: ");
            stringBuilder.append(exception.getMessage());
            o.a(c, stringBuilder.toString());
        }
        return null;
    }

    public static String m(Context context) {
        if (!TextUtils.isEmpty((CharSequence)z)) {
            return z;
        }
        String string2 = f.l(context);
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            z = d.c(string2);
            return z;
        }
        return e;
    }

    private static boolean m() {
        if ("dsds".equals((Object)f.b("persist.radio.multisim.config"))) {
            return true;
        }
        String string2 = Build.DEVICE;
        if (!("lcsh92_wet_jb9".equals((Object)string2) || "lcsh92_wet_tdd".equals((Object)string2) || "HM2013022".equals((Object)string2) || "HM2013023".equals((Object)string2) || "armani".equals((Object)string2) || "HM2014011".equals((Object)string2))) {
            return "HM2014012".equals((Object)string2);
        }
        return true;
    }

    public static String n(Context context) {
        if (!TextUtils.isEmpty((CharSequence)G)) {
            return G;
        }
        String string2 = f.l(context);
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            G = d.e(string2);
            return G;
        }
        return e;
    }

    private static boolean n() {
        if (Build.VERSION.SDK_INT >= 21) {
            return false;
        }
        String string2 = Build.DEVICE;
        String string3 = f.b("persist.radio.modem");
        return "HM2014812".equals((Object)string2) || "HM2014821".equals((Object)string2) || "gucci".equals((Object)string2) && "ct".equals((Object)f.b("persist.sys.modem")) || "CDMA".equals((Object)string3) || "HM1AC".equals((Object)string3) || "LTE-X5-ALL".equals((Object)string3) || "LTE-CT".equals((Object)string3) || "MI 3C".equals((Object)Build.MODEL);
        {
        }
    }

    public static String o(Context context) {
        block5 : {
            if (!TextUtils.isEmpty((CharSequence)u)) {
                return u;
            }
            String string2 = context.getContentResolver().getType(Uri.parse((String)"content://com.miui.analytics.server.AnalyticsProvider/aaid"));
            if (TextUtils.isEmpty((CharSequence)string2)) break block5;
            u = string2;
            return string2;
        }
        try {
            Method method = Class.forName((String)"android.provider.MiuiSettings$Ad").getDeclaredMethod("getAaid", new Class[]{ContentResolver.class});
            Object[] arrobject = new Object[]{context.getContentResolver()};
            Object object = method.invoke(null, arrobject);
            if (object instanceof String && !TextUtils.isEmpty((CharSequence)((String)object))) {
                String string3 = u = (String)object;
                return string3;
            }
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("getAaid failed ex: ");
            stringBuilder.append(exception.getMessage());
            o.a(c, stringBuilder.toString());
        }
        return e;
    }

    /*
     * Exception decompiling
     */
    private static boolean o() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl58.1 : ICONST_0 : trying to set 1 previously set to 0
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

    public static String p(Context context) {
        if (!TextUtils.isEmpty((CharSequence)v)) {
            return v;
        }
        if (a.b(context)) {
            return e;
        }
        String string2 = a.a(context);
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            v = string2;
            return v;
        }
        return e;
    }

    public static List<String> q(Context context) {
        List<String> list = f.r(context);
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); ++i2) {
                if (TextUtils.isEmpty((CharSequence)((String)list.get(i2)))) continue;
                arrayList.add(i2, (Object)d.c((String)list.get(i2)));
            }
        }
        return arrayList;
    }

    @SuppressLint(value={"MissingPermission"})
    public static List<String> r(Context context) {
        List<String> list;
        if (f.a(context, "android.permission.READ_PHONE_STATE")) {
            list = f.l();
            if (list == null || list.isEmpty()) {
                list = Build.VERSION.SDK_INT >= 21 ? f.B(context) : f.C(context);
            }
        } else {
            list = null;
        }
        if (list != null && !list.isEmpty()) {
            Collections.sort(list);
            p = (String)list.get(0);
            if (list.size() >= 2) {
                q = (String)list.get(1);
            }
        }
        return list;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String s(Context context) {
        List<String> list = f.D(context);
        if (list == null) return e;
        Collections.sort(list, (Comparator)new g());
        int n2 = 0;
        do {
            if (n2 >= list.size()) break;
            list.set(n2, (Object)d.h((String)list.get(n2)));
            ++n2;
        } while (true);
        try {
            return list.toString();
        }
        catch (Throwable throwable) {
            o.b(c, "getMeidListMd5 e", throwable);
        }
        return e;
    }

    /*
     * Exception decompiling
     */
    @SuppressLint(value={"MissingPermission"})
    public static List<String> t(Context var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl170 : ACONST_NULL : trying to set 0 previously set to 1
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

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @SuppressLint(value={"MissingPermission"})
    public static String u(Context context) {
        String string2;
        if (Build.VERSION.SDK_INT >= 26) {
            boolean bl = f.a(context, "android.permission.READ_PHONE_STATE");
            string2 = null;
            if (bl) {
                try {
                    Method method = Class.forName((String)"android.os.Build").getMethod("getSerial", new Class[0]);
                    string2 = null;
                    if (method != null) {
                        String string3;
                        string2 = string3 = (String)method.invoke(null, new Object[0]);
                    }
                }
                catch (Exception exception) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("querySerial failed ex: ");
                    stringBuilder.append(exception.getMessage());
                    o.a(c, stringBuilder.toString());
                    string2 = null;
                }
            }
        } else {
            string2 = Build.SERIAL;
        }
        if (!TextUtils.isEmpty((CharSequence)string2) && !"unknown".equals((Object)string2)) {
            t = string2;
            return string2;
        }
        return e;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String v(Context context) {
        List<String> list = f.t(context);
        if (list == null) return e;
        int n2 = 0;
        do {
            if (n2 >= list.size()) break;
            list.set(n2, (Object)d.h((String)list.get(n2)));
            ++n2;
        } while (true);
        try {
            return list.toString();
        }
        catch (Throwable throwable) {
            o.b(o.a(c), "getImeiListMd5 failed!", throwable);
        }
        return e;
    }

    public static String w(Context context) {
        if (!TextUtils.isEmpty((CharSequence)I)) {
            return I;
        }
        if (f.o()) {
            I = "Pad";
            return I;
        }
        if (f.F(context)) {
            I = "Tv";
            return I;
        }
        return "Phone";
    }

    public static boolean x(Context context) {
        if (H == null) {
            H = b.a(context);
        }
        return H;
    }

    public static String y(Context context) {
        return com.xiaomi.onetrack.h.a.a.a().a(context);
    }

    public static String z(Context context) {
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

    private static class com.xiaomi.onetrack.h.f$a {
        private static final String a = "GAIDClient";

        private com.xiaomi.onetrack.h.f$a() {
        }

        /*
         * Exception decompiling
         */
        static String a(Context var0) {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 5[SIMPLE_IF_TAKEN]
            // org.benf.cfr.reader.b.a.a.j.a(Op04StructuredStatement.java:432)
            // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:484)
            // org.benf.cfr.reader.b.a.a.i.a(Op03SimpleStatement.java:607)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:692)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
            // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
            // org.benf.cfr.reader.entities.g.p(Method.java:396)
            // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
            // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
            // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
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

        /*
         * Exception decompiling
         */
        static boolean b(Context var0) {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 5[SIMPLE_IF_TAKEN]
            // org.benf.cfr.reader.b.a.a.j.a(Op04StructuredStatement.java:432)
            // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:484)
            // org.benf.cfr.reader.b.a.a.i.a(Op03SimpleStatement.java:607)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:692)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
            // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
            // org.benf.cfr.reader.entities.g.p(Method.java:396)
            // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
            // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
            // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
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

        private static boolean c(Context context) {
            try {
                context.getPackageManager().getPackageInfo("com.android.vending", 16384);
                return true;
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                return false;
            }
        }

        private static final class a
        implements ServiceConnection {
            private static final int a = 30000;
            private boolean b = false;
            private IBinder c;

            private a() {
            }

            /* synthetic */ a(g g2) {
                this();
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public IBinder a() throws InterruptedException {
                IBinder iBinder = this.c;
                if (iBinder != null) {
                    return iBinder;
                }
                if (iBinder != null) return this.c;
                if (this.b) return this.c;
                a a2 = this;
                synchronized (a2) {
                    this.wait(30000L);
                    if (this.c == null) throw new InterruptedException("Not connect or connect timeout to google play service");
                    return this.c;
                }
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                a a2 = this;
                synchronized (a2) {
                    this.c = iBinder;
                    this.notifyAll();
                    return;
                }
            }

            public void onServiceDisconnected(ComponentName componentName) {
                this.b = true;
                this.c = null;
            }
        }

        private static final class b
        implements IInterface {
            private IBinder a;

            public b(IBinder iBinder) {
                this.a = iBinder;
            }

            public String a() throws RemoteException {
                if (this.a == null) {
                    return f.e;
                }
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    this.a.transact(1, parcel, parcel2, 0);
                    parcel2.readException();
                    String string2 = parcel2.readString();
                    return string2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public boolean a(boolean bl) throws RemoteException {
                if (this.a == null) {
                    return false;
                }
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    int n2 = bl ? 1 : 0;
                    parcel.writeInt(n2);
                    this.a.transact(2, parcel, parcel2, 0);
                    parcel2.readException();
                    int n3 = parcel2.readInt();
                    boolean bl2 = false;
                    if (n3 != 0) {
                        bl2 = true;
                    }
                    return bl2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            public IBinder asBinder() {
                return this.a;
            }
        }

    }

    private static class b {
        private static final String a = "box";
        private static final String b = "tvbox";
        private static final String c = "projector";
        private static final String d = "tv";
        private static final String e = "mi_device_mac";
        private static Signature[] f;
        private static final Signature g;

        static {
            g = new Signature("3082033b30820223a003020102020900a07a328482f70d2a300d06092a864886f70d01010505003035310b30090603550406130255533113301106035504080c0a43616c69666f726e69613111300f06035504070c084d6f756e7461696e301e170d3133303430313033303831325a170d3430303831373033303831325a3035310b30090603550406130255533113301106035504080c0a43616c69666f726e69613111300f06035504070c084d6f756e7461696e30820120300d06092a864886f70d01010105000382010d00308201080282010100ac678c9234a0226edbeb75a43e8e18f632d8c8a094c087fffbbb0b5e4429d845e36bffbe2d7098e320855258aa777368c18c538f968063d5d61663dc946ab03acbb31d00a27d452e12e6d42865e27d6d0ad2d8b12cf3b3096a7ec66a21db2a6a697857fd4d29fb4cdf294b3371d7601f2e3f190c0164efa543897026c719b334808e4f612fe3a3da589115fc30f9ca89862feefdf31a9164ecb295dcf7767e673be2192dda64f88189fd6e6ebd62e572c7997c2385a0ea9292ec799dee8f87596fc73aa123fb6f577d09ac0c123179c3bdbc978c2fe6194eb9fa4ab3658bfe8b44040bb13fe7809409e622189379fbc63966ab36521793547b01673ecb5f15cf020103a350304e301d0603551d0e0416041447203684e562385ada79108c4c94c5055037592f301f0603551d2304183016801447203684e562385ada79108c4c94c5055037592f300c0603551d13040530030101ff300d06092a864886f70d010105050003820101008d530fe05c6fe694c7559ddb5dd2c556528dd3cad4f7580f439f9a90a4681d37ce246b9a6681bdd5a5437f0b8bba903e39bac309fc0e9ee5553681612e723e9ec4f6abab6b643b33013f09246a9b5db7703b96f838fb27b00612f5fcd431bea32f68350ae51a4a1d012c520c401db7cccc15a7b19c4310b0c3bfc625ce5744744d0b9eeb02b0a4e7d51ed59849ce580b9f7c3062c84b9a0b13cc211e1c916c289820266a610801e3316c915649804571b147beadbf88d3b517ee04121d40630853f2f2a506bb788620de9648faeacff568e5033a666316bc2046526674ed3de25ceefdc4ad3628f1a230fd41bf9ca9f6a078173850dba555768fe1c191483ad9");
        }

        private b() {
        }

        private static Signature a(PackageInfo packageInfo) {
            if (packageInfo != null && packageInfo.signatures != null && packageInfo.signatures.length > 0) {
                return packageInfo.signatures[0];
            }
            return null;
        }

        private static <T> T a(Class<?> class_, String string2) {
            Object object;
            try {
                Field field = class_.getDeclaredField(string2);
                field.setAccessible(true);
                object = field.get(null);
            }
            catch (Exception exception) {
                o.b(f.c, "getStaticVariableValue exception", exception);
                return null;
            }
            return (T)object;
        }

        private static String a() {
            int n2;
            Class class_;
            block8 : {
                block7 : {
                    block6 : {
                        Class class_2 = Class.forName((String)"mitv.common.ConfigurationManager");
                        Object object = class_2.getMethod("getInstance", new Class[0]).invoke((Object)class_2, new Object[0]);
                        n2 = Integer.parseInt((String)String.valueOf((Object)class_2.getMethod("getProductCategory", new Class[0]).invoke(object, new Object[0])));
                        class_ = Class.forName((String)"mitv.tv.TvContext");
                        if (n2 != Integer.parseInt((String)String.valueOf(b.a(class_, "PRODUCT_CATEGORY_MITV")))) break block6;
                        return d;
                    }
                    if (n2 != Integer.parseInt((String)String.valueOf(b.a(class_, "PRODUCT_CATEGORY_MIBOX")))) break block7;
                    return a;
                }
                if (n2 != Integer.parseInt((String)String.valueOf(b.a(class_, "PRODUCT_CATEGORY_MITVBOX")))) break block8;
                return b;
            }
            try {
                if (n2 == Integer.parseInt((String)String.valueOf(b.a(class_, "PRODUCT_CATEGORY_MIPROJECTOR")))) {
                    return c;
                }
            }
            catch (Exception exception) {
                o.a(f.c, "getMiTvProductCategory exception", exception);
            }
            return f.e;
        }

        /*
         * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Lifted jumps to return sites
         */
        private static String a(String var0) {
            block8 : {
                block7 : {
                    var1_1 = "";
                    var2_2 = null;
                    var3_3 = new BufferedReader((Reader)new InputStreamReader((InputStream)new FileInputStream(var0)), 512);
                    try {
                        var6_4 = var3_3.readLine();
                        if (var6_4 == null) break block7;
                        var7_5 = new StringBuilder();
                        var7_5.append(var1_1);
                        var7_5.append(var6_4);
                        var1_1 = var7_5.toString();
                    }
                    catch (Throwable var5_6) {
                        var2_2 = var3_3;
                        break block8;
                    }
                    catch (Exception var4_9) {
                        var2_2 = var3_3;
                        ** GOTO lbl-1000
                    }
                }
                l.a((Closeable)var3_3);
                return var1_1;
                catch (Throwable var5_7) {
                    break block8;
                }
                catch (Exception var4_10) {
                    // empty catch block
                }
lbl-1000: // 2 sources:
                {
                    o.b("DeviceUtil", "catEntry exception", (Throwable)var4_11);
                }
                l.a(var2_2);
                return var1_1;
            }
            l.a(var2_2);
            throw var5_8;
        }

        static boolean a(Context context) {
            Signature[] arrsignature;
            if (f == null) {
                Signature[] arrsignature2 = new Signature[]{b.c(context)};
                f = arrsignature2;
            }
            return (arrsignature = f)[0] != null && arrsignature[0].equals((Object)g);
        }

        /*
         * Exception decompiling
         */
        public static String b(Context var0) {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl16.3 : FAKE_TRY : trying to set 1 previously set to 0
            // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
            // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
            // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
            // org.benf.cfr.reader.entities.g.p(Method.java:396)
            // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
            // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
            // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
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

        private static Signature c(Context context) {
            try {
                Signature signature = b.a(context.getPackageManager().getPackageInfo("android", 64));
                return signature;
            }
            catch (Exception exception) {
                return null;
            }
        }
    }

}

