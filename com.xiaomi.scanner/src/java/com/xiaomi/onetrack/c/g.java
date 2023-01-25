/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 *  java.io.BufferedReader
 *  java.io.BufferedWriter
 *  java.io.Closeable
 *  java.io.File
 *  java.io.FileReader
 *  java.io.FileWriter
 *  java.io.IOException
 *  java.io.Reader
 *  java.io.Writer
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.text.SimpleDateFormat
 *  java.util.ArrayList
 *  java.util.Date
 *  java.util.List
 *  org.json.JSONObject
 */
package com.xiaomi.onetrack.c;

import android.content.Context;
import android.util.Log;
import com.xiaomi.onetrack.c.b;
import com.xiaomi.onetrack.c.h;
import com.xiaomi.onetrack.d.c;
import com.xiaomi.onetrack.f.a;
import com.xiaomi.onetrack.h.l;
import com.xiaomi.onetrack.h.o;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONObject;

public class g {
    public static final long a = 0L;
    public static final long b = 1L;
    public static final long c = 2L;
    public static final String d = "eventName";
    public static final String e = "data";
    private static final String f = "NetworkAccessManager";
    private static final String g = "networkAccess";
    private static String h = "onetrack_netaccess_%s";
    private static SimpleDateFormat i = new SimpleDateFormat("yyyyMMdd");
    private static boolean j = false;

    public static void a(String string2, String string3) {
        com.xiaomi.onetrack.h.h.a(new h(string2, string3));
    }

    public static void a(boolean bl) {
        j = bl;
    }

    public static boolean a() {
        return j;
    }

    static /* synthetic */ void b(String string2, String string3) {
        g.c(string2, string3);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static void b(boolean var0) {
        var1_1 = new File(a.a().getFilesDir(), ".ot_net_allowed");
        var2_2 = new File(a.a().getFilesDir(), ".ot_net_disallowed");
        if (!var0) ** GOTO lbl9
        try {
            var1_1.createNewFile();
            if (var2_2.exists() == false) return;
            var2_2.delete();
            return;
lbl9: // 1 sources:
            var2_2.createNewFile();
            if (var1_1.exists() == false) return;
            var1_1.delete();
            return;
        }
        catch (IOException var3_3) {
            var4_4 = new StringBuilder();
            var4_4.append("setNetworkAccessStateEnabled: ");
            var4_4.append(var0);
            var4_4.append("failed ");
            Log.e((String)"NetworkAccessManager", (String)var4_4.toString(), (Throwable)var3_3);
        }
    }

    public static boolean b() {
        return true ^ new File(a.a().getFilesDir(), ".ot_net_disallowed").exists();
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static List<JSONObject> c() {
        BufferedReader bufferedReader;
        void var8_14;
        FileReader fileReader;
        block19 : {
            ArrayList arrayList;
            block20 : {
                Exception exception;
                block18 : {
                    Class<g> class_ = g.class;
                    // MONITORENTER : com.xiaomi.onetrack.c.g.class
                    String string2 = i.format(new Date());
                    String string3 = String.format((String)h, (Object[])new Object[]{string2});
                    File file = new File(g.d(), string3);
                    boolean bl = file.exists();
                    if (!bl) {
                        // MONITOREXIT : class_
                        return null;
                    }
                    arrayList = new ArrayList();
                    fileReader = new FileReader(file);
                    bufferedReader = new BufferedReader((Reader)fileReader);
                    try {
                        String string4;
                        while ((string4 = bufferedReader.readLine()) != null) {
                            arrayList.add((Object)new JSONObject(b.a(c.a(string4))));
                        }
                    }
                    catch (Exception exception2) {
                        break block18;
                    }
                    l.a((Closeable)bufferedReader);
                    break block20;
                    catch (Throwable throwable) {
                        bufferedReader = null;
                        break block19;
                    }
                    catch (Exception exception3) {
                        exception = exception3;
                        bufferedReader = null;
                        break block18;
                    }
                    catch (Throwable throwable) {
                        bufferedReader = null;
                        fileReader = null;
                        break block19;
                    }
                    catch (Exception exception4) {
                        fileReader = null;
                        exception = exception4;
                        bufferedReader = null;
                    }
                }
                try {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("cta getCacheData error: ");
                    stringBuilder.append(exception.toString());
                    o.b(f, stringBuilder.toString());
                    exception.printStackTrace();
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
                l.a((Closeable)bufferedReader);
            }
            l.a((Closeable)fileReader);
            if (arrayList.size() > 100) {
                arrayList = arrayList.subList(arrayList.size() - 100, arrayList.size());
            }
            // MONITOREXIT : class_
            return arrayList;
        }
        l.a(bufferedReader);
        l.a((Closeable)fileReader);
        throw var8_14;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private static void c(String string2, String string3) {
        void var10_14;
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;
        block17 : {
            block19 : {
                block18 : {
                    Class<g> class_ = g.class;
                    // MONITORENTER : com.xiaomi.onetrack.c.g.class
                    String string4 = i.format(new Date());
                    String string5 = String.format((String)h, (Object[])new Object[]{string4});
                    File file = new File(g.d(), string5);
                    bufferedWriter = null;
                    if (!file.exists()) {
                        if (file.getParentFile().exists()) {
                            file.createNewFile();
                        } else {
                            new File(file.getParentFile().getAbsolutePath()).mkdirs();
                            file.createNewFile();
                        }
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(d, (Object)string2);
                    jSONObject.put(e, (Object)string3);
                    byte[] arrby = b.a(jSONObject.toString());
                    fileWriter = new FileWriter(file, true);
                    BufferedWriter bufferedWriter2 = new BufferedWriter((Writer)fileWriter);
                    try {
                        bufferedWriter2.write(c.a(arrby));
                        bufferedWriter2.newLine();
                    }
                    catch (Throwable throwable) {
                        bufferedWriter = bufferedWriter2;
                        break block17;
                    }
                    catch (Exception exception) {
                        bufferedWriter = bufferedWriter2;
                        break block18;
                    }
                    l.a((Closeable)bufferedWriter2);
                    break block19;
                    catch (Exception exception) {
                        bufferedWriter = null;
                        break block18;
                    }
                    catch (Throwable throwable) {
                        bufferedWriter = null;
                        fileWriter = null;
                        break block17;
                    }
                    catch (Exception exception) {
                        fileWriter = null;
                    }
                }
                try {
                    void var7_18;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("cta doSaveData error: ");
                    stringBuilder.append(var7_18.toString());
                    o.b(f, stringBuilder.toString());
                    var7_18.printStackTrace();
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
                l.a(bufferedWriter);
            }
            l.a((Closeable)fileWriter);
            return;
        }
        l.a(bufferedWriter);
        l.a(fileWriter);
        throw var10_14;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static void c(boolean bl) {
        File[] arrfile;
        String string2;
        Class<g> class_ = g.class;
        // MONITORENTER : com.xiaomi.onetrack.c.g.class
        File file = new File(g.d());
        if (file.exists()) {
            if (!file.isDirectory()) {
                return;
            }
            String string3 = i.format(new Date());
            String string4 = h;
            Object[] arrobject = new Object[1];
            arrobject[0] = string3;
            string2 = String.format((String)string4, (Object[])arrobject);
            arrfile = file.listFiles();
        } else {
            // MONITOREXIT : class_
            return;
        }
        for (int i2 = 0; i2 < arrfile.length; ++i2) {
            if (!arrfile[i2].isFile() || !bl && arrfile[i2].getName().equalsIgnoreCase(string2)) continue;
            arrfile[i2].delete();
        }
        return;
        {
            catch (Throwable throwable) {
                throw throwable;
            }
            catch (Exception exception) {}
            {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("cta removeObsoleteEvent error: ");
                stringBuilder.append(exception.toString());
                o.b(f, stringBuilder.toString());
                exception.printStackTrace();
                // MONITOREXIT : class_
                return;
            }
        }
    }

    private static String d() {
        Context context = a.a();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.getFilesDir().getAbsolutePath());
        stringBuilder.append(File.separator);
        stringBuilder.append(g);
        return stringBuilder.toString();
    }
}

