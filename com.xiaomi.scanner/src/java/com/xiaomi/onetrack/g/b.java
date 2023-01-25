/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.net.HttpURLConnection
 *  java.net.URL
 *  java.net.URLConnection
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 */
package com.xiaomi.onetrack.g;

import android.text.TextUtils;
import com.xiaomi.onetrack.d.d;
import com.xiaomi.onetrack.d.f;
import com.xiaomi.onetrack.f.a;
import com.xiaomi.onetrack.g.c;
import com.xiaomi.onetrack.h.l;
import com.xiaomi.onetrack.h.o;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class b {
    public static final int a = 10000;
    public static final int b = 15000;
    public static final String c = "OT_SID";
    public static final String d = "OT_ts";
    public static final String e = "OT_net";
    public static final String f = "OT_sender";
    public static final String g = "OT_protocol";
    private static String h = "HttpUtil";
    private static final String i = "GET";
    private static final String j = "POST";
    private static final String k = "&";
    private static final String l = "=";
    private static final String m = "UTF-8";
    private static final String n = "miui_sdkconfig_jafej!@#)(*e@!#";

    private b() {
    }

    public static String a(String string2) throws IOException {
        return b.a(string2, null, false);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static String a(String var0, String var1_1, Map<String, String> var2_2, boolean var3_3) {
        block18 : {
            block19 : {
                block17 : {
                    block16 : {
                        block20 : {
                            if (var2_2 != null) break block20;
                            var4_4 = null;
                            ** GOTO lbl7
                        }
                        var4_4 = b.a(var2_2, var3_3);
lbl7: // 2 sources:
                        if ("GET".equals((Object)var0) && var4_4 != null) {
                            var11_5 = new StringBuilder();
                            var11_5.append(var1_1);
                            var11_5.append("? ");
                            var11_5.append(var4_4);
                            var15_6 = var11_5.toString();
                        } else {
                            var15_6 = var1_1;
                        }
                        var7_7 = (HttpURLConnection)new URL(var15_6).openConnection();
                        var7_7.setConnectTimeout(10000);
                        var7_7.setReadTimeout(15000);
                        var16_8 = "GET".equals((Object)var0);
                        if (var16_8) {
                            var7_7.setRequestMethod("GET");
                            break block16;
                        }
                        if (!"POST".equals((Object)var0) || var4_4 == null) break block16;
                        var7_7.setRequestMethod("POST");
                        var7_7.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                        var7_7.setDoOutput(true);
                        var17_9 = var4_4.getBytes("UTF-8");
                        var6_10 = var7_7.getOutputStream();
                        try {
                            var6_10.write(var17_9, 0, var17_9.length);
                            var6_10.flush();
                            break block17;
                        }
                        catch (Throwable var9_22) {
                            var10_27 = null;
                            break block18;
                        }
                        catch (Exception var5_18) {
                            var8_12 = null;
                            break block19;
                        }
                        catch (Throwable var9_23) {
                            var10_27 = null;
                            var6_10 = null;
                            break block18;
                        }
                        catch (Exception var5_19) {
                            var8_12 = null;
                            var6_10 = null;
                            break block19;
                        }
                        catch (Throwable var9_24) {
                            var10_27 = null;
                            var6_10 = null;
                            var7_7 = null;
                            break block18;
                        }
                        catch (Exception var5_20) {
                            var6_10 = null;
                            var7_7 = null;
                            var8_12 = null;
                            break block19;
                        }
                    }
                    var6_10 = null;
                }
                var18_11 = var7_7.getResponseCode();
                var8_12 = var7_7.getInputStream();
                try {
                    var19_13 = l.b(var8_12);
                    var20_14 = b.h;
                    var21_15 = new Object[]{var1_1, var18_11};
                    o.a(var20_14, String.format((String)"HttpUtils POST \u4e0a\u4f20\u6210\u529f url: %s, code: %s", (Object[])var21_15));
                    var22_16 = new String(var19_13, "UTF-8");
                }
                catch (Exception var5_17) {}
                l.a(var8_12);
                l.a(var6_10);
                l.a(var7_7);
                return var22_16;
            }
            try {
                o.b(b.h, "HttpUtils POST \u4e0a\u4f20\u5f02\u5e38", (Throwable)var5_21);
            }
            catch (Throwable var9_25) {
                var10_27 = var8_12;
            }
            l.a(var8_12);
            l.a(var6_10);
            l.a(var7_7);
            return null;
        }
        l.a(var10_27);
        l.a(var6_10);
        l.a(var7_7);
        throw var9_26;
    }

    public static String a(String string2, Map<String, String> map) throws IOException {
        return b.a(string2, map, true);
    }

    public static String a(String string2, Map<String, String> map, boolean bl) throws IOException {
        return b.a(i, string2, map, bl);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static String a(String string2, byte[] arrby) throws IOException {
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        void var12_24;
        OutputStream outputStream;
        block14 : {
            InputStream inputStream2;
            block13 : {
                block15 : {
                    String string3;
                    String string4 = h;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("doPost url=");
                    stringBuilder.append(string2);
                    stringBuilder.append(", len=");
                    stringBuilder.append(arrby.length);
                    o.a(string4, stringBuilder.toString());
                    httpURLConnection = (HttpURLConnection)new URL(string2).openConnection();
                    httpURLConnection.setConnectTimeout(10000);
                    httpURLConnection.setReadTimeout(15000);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod(j);
                    httpURLConnection.setRequestProperty("Content-Type", "application/octet-stream");
                    String string5 = f.a().b()[1];
                    httpURLConnection.setRequestProperty(c, string5);
                    httpURLConnection.setRequestProperty(d, Long.toString((long)System.currentTimeMillis()));
                    httpURLConnection.setRequestProperty(e, c.a(a.a()).toString());
                    httpURLConnection.setRequestProperty(f, a.d());
                    httpURLConnection.setRequestProperty(g, "3.0");
                    String string6 = h;
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("sid:");
                    stringBuilder2.append(string5);
                    o.a(string6, stringBuilder2.toString());
                    outputStream = httpURLConnection.getOutputStream();
                    outputStream.write(arrby, 0, arrby.length);
                    outputStream.flush();
                    int n2 = httpURLConnection.getResponseCode();
                    inputStream2 = httpURLConnection.getInputStream();
                    try {
                        byte[] arrby2 = l.b(inputStream2);
                        String string7 = h;
                        Object[] arrobject = new Object[]{string2, n2};
                        o.a(string7, String.format((String)"HttpUtils POST \u4e0a\u4f20\u6210\u529f url: %s, code: %s", (Object[])arrobject));
                        string3 = new String(arrby2, m);
                    }
                    catch (IOException iOException) {
                        break block13;
                    }
                    l.a(inputStream2);
                    l.a(outputStream);
                    l.a(httpURLConnection);
                    return string3;
                    catch (Throwable throwable) {
                        inputStream = null;
                        break block14;
                    }
                    catch (IOException iOException) {
                        inputStream2 = null;
                        break block13;
                    }
                    catch (Throwable throwable) {
                        inputStream = null;
                        outputStream = null;
                        break block14;
                    }
                    catch (IOException iOException) {
                        outputStream = null;
                        break block15;
                    }
                    catch (Throwable throwable) {
                        inputStream = null;
                        httpURLConnection = null;
                        outputStream = null;
                        break block14;
                    }
                    catch (IOException iOException) {
                        httpURLConnection = null;
                        outputStream = null;
                    }
                }
                inputStream2 = null;
            }
            try {
                void var8_19;
                String string8 = h;
                Object[] arrobject = new Object[]{string2, var8_19.getMessage()};
                o.b(string8, String.format((String)"HttpUtils POST \u4e0a\u4f20\u5931\u8d25, url: %s, error: %s", (Object[])arrobject));
            }
            catch (Throwable throwable) {
                inputStream = inputStream2;
            }
            l.a(inputStream2);
            l.a(outputStream);
            l.a(httpURLConnection);
            return null;
        }
        l.a(inputStream);
        l.a(outputStream);
        l.a(httpURLConnection);
        throw var12_24;
    }

    public static String a(Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        if (map != null) {
            ArrayList arrayList = new ArrayList((Collection)map.keySet());
            Collections.sort((List)arrayList);
            for (String string2 : arrayList) {
                if (TextUtils.isEmpty((CharSequence)string2)) continue;
                stringBuilder.append(string2);
                stringBuilder.append((String)map.get((Object)string2));
            }
        }
        stringBuilder.append(n);
        return d.c(stringBuilder.toString());
    }

    /*
     * Exception decompiling
     */
    private static String a(Map<String, String> var0, boolean var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl92 : ALOAD_2 : trying to set 1 previously set to 0
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

    public static String b(String string2, Map<String, String> map) throws IOException {
        return b.b(string2, map, true);
    }

    public static String b(String string2, Map<String, String> map, boolean bl) throws IOException {
        return b.a(j, string2, map, bl);
    }
}

