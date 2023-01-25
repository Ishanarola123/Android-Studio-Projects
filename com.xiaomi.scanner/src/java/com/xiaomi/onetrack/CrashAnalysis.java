/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  android.util.Log
 *  java.io.File
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.Exception
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.reflect.Constructor
 *  java.lang.reflect.Method
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.Iterator
 *  java.util.List
 *  java.util.concurrent.atomic.AtomicBoolean
 */
package com.xiaomi.onetrack;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.onetrack.CrashAnalysis$1;
import com.xiaomi.onetrack.CrashAnalysis$2;
import com.xiaomi.onetrack.a.f;
import com.xiaomi.onetrack.d.d;
import com.xiaomi.onetrack.f.a;
import com.xiaomi.onetrack.h.h;
import com.xiaomi.onetrack.h.j;
import com.xiaomi.onetrack.h.o;
import com.xiaomi.onetrack.h.w;
import com.xiaomi.onetrack.h.y;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class CrashAnalysis {
    public static final String ANR_CRASH = "anr";
    public static final String JAVA_CRASH = "java";
    public static final String NATIVE_CRASH = "native";
    private static final String a = "CrashAnalysis";
    private static final String b = "com.xiaomi.digest.DigestUtil";
    private static final String c = "calcuateJavaDigest";
    private static final String d = "/sdcard/tombstone";
    private static final String e = "backtrace feature id:\n\t";
    private static final String f = "error reason:\n\t";
    private static final String g = ".xcrash";
    private static final int h = 604800000;
    private static final int i = 102400;
    private static final int j = 10;
    private static final int k = 20;
    private static final String l = "@[0-9a-fA-F]{1,10}";
    private static final String m = "\\$[0-9a-fA-F]{1,10}@[0-9a-fA-F]{1,10}";
    private static final String n = "0x[0-9a-fA-F]{1,10}";
    private static final String o = "\\d+[B,KB,MB]*";
    private static final String p = "((java:)|(length=)|(index=)|(Index:)|(Size:))\\d+";
    private static final int q = 20;
    private static final boolean r;
    private static final AtomicBoolean s;
    private final FileProcessor[] t;
    private final f u;

    static {
        s = new AtomicBoolean(false);
    }

    private CrashAnalysis(Context context, f f2) {
        try {
            Object object = Class.forName((String)"xcrash.XCrash$InitParameters").getConstructor(new Class[0]).newInstance(new Object[0]);
            this.a(object, "setNativeDumpAllThreads", false);
            this.a(object, "setLogDir", CrashAnalysis.a());
            this.a(object, "setNativeDumpMap", false);
            this.a(object, "setNativeDumpFds", false);
            this.a(object, "setJavaDumpAllThreads", false);
            Class class_ = Class.forName((String)"xcrash.XCrash");
            Class[] arrclass = new Class[]{Context.class, object.getClass()};
            Method method = class_.getDeclaredMethod("init", arrclass);
            Object[] arrobject = new Object[]{context.getApplicationContext(), object};
            method.invoke(null, arrobject);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        this.u = f2;
        FileProcessor[] arrfileProcessor = new FileProcessor[]{new FileProcessor(JAVA_CRASH), new FileProcessor(ANR_CRASH), new FileProcessor(NATIVE_CRASH)};
        this.t = arrfileProcessor;
    }

    /* synthetic */ CrashAnalysis(Context context, f f2, CrashAnalysis$1 crashAnalysis$1) {
        this(context, f2);
    }

    private static String a() {
        return j.a();
    }

    private void a(long l2) {
        w.d(l2 + 100L * y.b());
    }

    static void a(Context context) {
        try {
            a.a(context);
            Method method = Class.forName((String)"xcrash.XCrash").getDeclaredMethod("initHooker", new Class[]{Context.class, String.class});
            Object[] arrobject = new Object[]{context.getApplicationContext(), CrashAnalysis.a()};
            method.invoke(null, arrobject);
            Log.d((String)a, (String)"registerHook succeeded");
            return;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("registerHook failed: ");
            stringBuilder.append(exception.toString());
            Log.d((String)a, (String)stringBuilder.toString());
            exception.printStackTrace();
            return;
        }
    }

    private void a(Object object, String string2, Object object2) throws Exception {
        Class class_ = object2.getClass() == Boolean.class ? Boolean.TYPE : object2.getClass();
        object.getClass().getDeclaredMethod(string2, new Class[]{class_}).invoke(object, new Object[]{object2});
    }

    static /* synthetic */ boolean a(CrashAnalysis crashAnalysis) {
        return crashAnalysis.d();
    }

    private long b() {
        long l2 = w.c();
        if (l2 == 0L) {
            o.a(a, "no ticket data found, return max count");
            return 10L;
        }
        long l3 = y.b();
        if (l2 / 100L != l3) {
            o.a(a, "no today's ticket, return max count");
            return 10L;
        }
        Long.signum((long)l3);
        long l4 = l2 - l3 * 100L;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("today's remain ticket is ");
        stringBuilder.append(l4);
        o.a(a, stringBuilder.toString());
        return l4;
    }

    static /* synthetic */ void b(CrashAnalysis crashAnalysis) {
        crashAnalysis.e();
    }

    private static String c(String string2, String string3) {
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            if (string3.equals((Object)ANR_CRASH)) {
                int n2;
                int n3;
                int n4 = string2.indexOf(" tid=1 ");
                if (n4 != -1 && (n3 = string2.indexOf("\n  at ", n4)) != -1 && (n2 = string2.indexOf(10, n3 + 6)) != -1) {
                    return string2.substring(n3 + 2, n2);
                }
            } else {
                int n5;
                int n6;
                int n7 = string2.indexOf(f);
                if (n7 != -1 && (n5 = string2.indexOf("\n\n", n6 = n7 + 15)) != -1) {
                    return string2.substring(n6, n5);
                }
            }
        }
        return "uncategoried";
    }

    private List<File> c() {
        Object[] arrobject = new File(CrashAnalysis.a()).listFiles();
        if (arrobject == null) {
            o.a(a, "this path does not denote a directory, or if an I/O error occurs.");
            return null;
        }
        List list = Arrays.asList((Object[])arrobject);
        Collections.sort((List)list, (Comparator)new CrashAnalysis$2(this));
        int n2 = list.size();
        if (n2 > 20) {
            int n3 = n2 - 20;
            for (int i2 = 0; i2 < n3; ++i2) {
                j.a((File)list.get(i2));
            }
            list = list.subList(n3, n2);
        }
        return list;
    }

    public static String calculateJavaDigest(String string2) {
        String[] arrstring = string2.replaceAll("\\t", "").split("\\n");
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = Math.min((int)arrstring.length, (int)20);
        int n3 = 0;
        do {
            if (n3 >= n2) break;
            arrstring[n3] = arrstring[n3].replaceAll(p, "$1XX").replaceAll("\\$[0-9a-fA-F]{1,10}@[0-9a-fA-F]{1,10}|@[0-9a-fA-F]{1,10}|0x[0-9a-fA-F]{1,10}", "XX").replaceAll(o, "");
            ++n3;
        } while (true);
        for (int i2 = 0; !(i2 >= n2 || arrstring[i2].contains((CharSequence)"...") && arrstring[i2].contains((CharSequence)"more")); ++i2) {
            stringBuilder.append(arrstring[i2]);
            stringBuilder.append('\n');
        }
        return d.h(stringBuilder.toString());
    }

    private static String d(String string2, String string3) {
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            if (string3.equals((Object)ANR_CRASH)) {
                int n2;
                int n3 = string2.indexOf(" tid=1 ");
                if (n3 != -1 && (n2 = string2.indexOf("\n\n", n3)) != -1) {
                    return CrashAnalysis.calculateJavaDigest(string2.substring(n3, n2));
                }
            } else {
                int n4;
                int n5;
                int n6 = string2.indexOf(e);
                if (n6 != -1 && (n4 = string2.indexOf("\n\n", n5 = n6 + 23)) != -1) {
                    return string2.substring(n5, n4);
                }
            }
        }
        return "";
    }

    private boolean d() {
        boolean bl;
        List<File> list = this.c();
        long l2 = this.b();
        if (list != null && list.size() > 0) {
            long l3 = System.currentTimeMillis();
            long l4 = w.b();
            long l5 = 604800000L;
            if (l4 > l3) {
                l4 = l3 - l5;
            }
            Iterator iterator = list.iterator();
            long l6 = 0L;
            long l7 = l2;
            long l8 = l6;
            boolean bl2 = false;
            while (iterator.hasNext()) {
                File file = (File)iterator.next();
                long l9 = file.lastModified();
                if (l9 >= l3 - l5 && l9 <= l3) {
                    if (l9 <= l4) {
                        o.a(a, "found already reported crash file, ignore");
                    } else if (l7 > l6) {
                        FileProcessor[] arrfileProcessor = this.t;
                        int n2 = arrfileProcessor.length;
                        long l10 = l8;
                        for (int i2 = 0; i2 < n2; ++i2) {
                            if (!arrfileProcessor[i2].a(file)) continue;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("find crash file:");
                            stringBuilder.append(file.getName());
                            o.a(a, stringBuilder.toString());
                            --l7;
                            if (l10 < l9) {
                                l10 = l9;
                            }
                            bl2 = true;
                        }
                        l8 = l10;
                    }
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("remove obsolete crash files: ");
                    stringBuilder.append(file.getName());
                    o.a(a, stringBuilder.toString());
                    j.a(file);
                }
                l5 = 604800000L;
                l6 = 0L;
            }
            if (l8 > l6) {
                w.c(l8);
            }
            bl = bl2;
            l2 = l7;
        } else {
            bl = false;
        }
        if (bl) {
            this.a(l2);
        }
        return bl;
    }

    private void e() {
        FileProcessor[] arrfileProcessor = this.t;
        int n2 = arrfileProcessor.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            arrfileProcessor[i2].a();
        }
    }

    public static boolean isSupport() {
        try {
            Class.forName((String)"xcrash.XCrash");
            return true;
        }
        catch (ClassNotFoundException classNotFoundException) {
            return false;
        }
    }

    public static void start(Context context, f f2) {
        if (s.compareAndSet(false, true)) {
            h.a(new CrashAnalysis$1(context, f2));
            return;
        }
        o.b(a, "run method has been invoked more than once");
    }

    private class FileProcessor {
        final List<File> a = new ArrayList();
        final String b;
        final String c;

        FileProcessor(String string2) {
            this.c = string2;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(CrashAnalysis.g);
            this.b = stringBuilder.toString();
        }

        private String a(String string2) {
            String[] arrstring;
            String[] arrstring2;
            if (!TextUtils.isEmpty((CharSequence)string2) && (arrstring2 = string2.split("__")).length == 2 && (arrstring = arrstring2[0].split("_")).length == 3) {
                return arrstring[2];
            }
            return null;
        }

        void a() {
            for (int i2 = 0; i2 < this.a.size(); ++i2) {
                String string2 = ((File)this.a.get(i2)).getAbsoluteFile().getAbsolutePath();
                String string3 = this.a(string2);
                String string4 = j.a(string2, 102400);
                if (TextUtils.isEmpty((CharSequence)string4) || CrashAnalysis.this.u == null) continue;
                String string5 = CrashAnalysis.d(string4, this.c);
                String string6 = CrashAnalysis.c(string4, this.c);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("fileName: ");
                stringBuilder.append(string2);
                o.a(CrashAnalysis.a, stringBuilder.toString());
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("feature id: ");
                stringBuilder2.append(string5);
                o.a(CrashAnalysis.a, stringBuilder2.toString());
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append("error: ");
                stringBuilder3.append(string6);
                o.a(CrashAnalysis.a, stringBuilder3.toString());
                CrashAnalysis.this.u.a(string4, string6, this.c, string3, string5);
                j.a(new File(string2));
                o.a(CrashAnalysis.a, "remove reported crash file");
            }
        }

        boolean a(File file) {
            if (file.getName().contains((CharSequence)this.b)) {
                this.a.add((Object)file);
                return true;
            }
            return false;
        }
    }

}

