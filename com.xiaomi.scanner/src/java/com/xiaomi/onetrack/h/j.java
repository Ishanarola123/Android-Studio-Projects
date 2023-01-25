/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.LruCache
 *  java.io.BufferedReader
 *  java.io.BufferedWriter
 *  java.io.Closeable
 *  java.io.File
 *  java.io.FileReader
 *  java.io.FileWriter
 *  java.io.Reader
 *  java.io.Writer
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package com.xiaomi.onetrack.h;

import android.text.TextUtils;
import android.util.LruCache;
import com.xiaomi.onetrack.h.k;
import com.xiaomi.onetrack.h.l;
import com.xiaomi.onetrack.h.o;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

public class j {
    private static final String a = "FileUtil";
    private static final String b = "onetrack";
    private static final String c = "tombstone";
    private static LruCache<String, a> d = new k(1048576);

    public static String a() {
        return j.c(c);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static String a(String var0) {
        block12 : {
            block11 : {
                block10 : {
                    if (TextUtils.isEmpty((CharSequence)var0)) {
                        return "";
                    }
                    var1_1 = (a)j.d.get((Object)var0);
                    if (var1_1 != null) {
                        return var1_1.a;
                    }
                    var2_2 = null;
                    var3_3 = new File(j.b(), var0);
                    var4_4 = new StringBuilder();
                    var10_5 = var3_3.exists();
                    var2_2 = null;
                    if (!var10_5) break block10;
                    var11_6 = new BufferedReader((Reader)new FileReader(var3_3));
                    try {
                        while ((var12_7 = var11_6.readLine()) != null) {
                            var4_4.append(var12_7);
                        }
                        break block11;
                    }
                    catch (Throwable var9_10) {
                        var2_2 = var11_6;
                        break block12;
                    }
                    catch (Exception var5_13) {
                        var2_2 = var11_6;
                        ** GOTO lbl-1000
                    }
                }
                var11_6 = null;
            }
            var14_8 = var4_4.toString();
            var15_9 = new a(null);
            var15_9.a = var14_8;
            j.d.put((Object)var0, (Object)var15_9);
            l.a((Closeable)var11_6);
            return var14_8;
            catch (Throwable var9_11) {
                break block12;
            }
            catch (Exception var5_14) {
                // empty catch block
            }
lbl-1000: // 2 sources:
            {
                var6_16 = new StringBuilder();
                var6_16.append("get error:");
                var6_16.append(var5_15.toString());
                o.b("FileUtil", var6_16.toString());
            }
            l.a(var2_2);
            return "";
        }
        l.a(var2_2);
        throw var9_12;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static String a(String var0, int var1_1) {
        block10 : {
            block11 : {
                block12 : {
                    block9 : {
                        var2_2 = new File(var0);
                        var3_3 = new StringBuilder();
                        if (!var2_2.exists()) ** GOTO lbl19
                        var5_4 = new BufferedReader((Reader)new FileReader(var2_2));
                        while ((var10_5 = var5_4.readLine()) != null) {
                            var3_3.append(var10_5);
                            var3_3.append("\n");
                            if (var3_3.length() <= var1_1) continue;
                            break block9;
                        }
                        break block9;
                        catch (Throwable var7_11) {
                            var5_4 = null;
                            break block10;
                        }
                        catch (Exception var4_9) {
                            var5_4 = null;
                            break block11;
                        }
lbl19: // 1 sources:
                        var5_4 = null;
                    }
                    if (var3_3.length() <= var1_1) break block12;
                    var14_6 = var3_3.substring(0, var1_1 - 1);
                    l.a((Closeable)var5_4);
                    return var14_6;
                }
                try {
                    var13_7 = var3_3.toString();
                }
                catch (Exception var4_8) {}
                l.a((Closeable)var5_4);
                return var13_7;
            }
            try {
                var6_14 = new StringBuilder();
                var6_14.append("get error:");
                var6_14.append(var4_10.toString());
                o.b("FileUtil", var6_14.toString());
            }
            catch (Throwable var7_12) {
                // empty catch block
            }
            l.a((Closeable)var5_4);
            return null;
        }
        l.a(var5_4);
        throw var7_13;
    }

    public static void a(File file) {
        try {
            if (file.exists() && file.isFile()) {
                file.delete();
                return;
            }
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("failed to remove file: ");
            stringBuilder.append(file.getName());
            stringBuilder.append(",");
            stringBuilder.append(exception.toString());
            o.b(a, stringBuilder.toString());
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static void a(String var0, String var1_1) {
        block10 : {
            if (TextUtils.isEmpty((CharSequence)var0) != false) return;
            if (TextUtils.isEmpty((CharSequence)var1_1)) {
                return;
            }
            var2_2 = null;
            var3_3 = new a(null);
            var3_3.a = var1_1;
            j.d.put((Object)var0, (Object)var3_3);
            var10_4 = j.b();
            var11_5 = new File(var10_4);
            var12_6 = var11_5.exists();
            var2_2 = null;
            if (!var12_6) {
                var11_5.mkdirs();
            }
            var14_7 = new File(var10_4, var0);
            var15_8 = var14_7.exists();
            var2_2 = null;
            if (!var15_8) {
                var14_7.createNewFile();
            }
            var17_9 = new BufferedWriter((Writer)new FileWriter(var14_7), 1024);
            try {
                var17_9.write(var1_1);
                var17_9.flush();
            }
            catch (Throwable var19_10) {
                var2_2 = var17_9;
                var8_11 = var19_10;
                break block10;
            }
            catch (Exception var18_13) {
                var2_2 = var17_9;
                var4_14 = var18_13;
                ** GOTO lbl-1000
            }
            l.a((Closeable)var17_9);
            return;
            catch (Throwable var8_12) {
                break block10;
            }
            catch (Exception var4_15) {
                // empty catch block
            }
lbl-1000: // 2 sources:
            {
                var5_16 = new StringBuilder();
                var5_16.append("put error:");
                var5_16.append(var4_14.toString());
                o.b("FileUtil", var5_16.toString());
            }
            l.a(var2_2);
            return;
        }
        l.a(var2_2);
        throw var8_11;
    }

    private static String b() {
        return j.c(b);
    }

    public static void b(String string2) {
        try {
            if (TextUtils.isEmpty((CharSequence)string2)) {
                return;
            }
            d.remove((Object)string2);
            File file = new File(j.b(), string2);
            if (file.exists() && file.isFile()) {
                file.delete();
                return;
            }
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("clear error:");
            stringBuilder.append(exception.toString());
            o.b(a, stringBuilder.toString());
        }
    }

    private static String c(String string2) {
        StringBuilder stringBuilder = new StringBuilder(com.xiaomi.onetrack.f.a.a().getFilesDir().getAbsolutePath());
        stringBuilder.append(File.separator);
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    private static class a {
        String a;

        private a() {
        }

        /* synthetic */ a(k k2) {
            this();
        }
    }

}

