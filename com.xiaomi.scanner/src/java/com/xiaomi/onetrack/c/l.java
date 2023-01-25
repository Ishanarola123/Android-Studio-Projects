/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.text.TextUtils
 *  java.io.ByteArrayOutputStream
 *  java.io.OutputStream
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.zip.GZIPOutputStream
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.xiaomi.onetrack.c;

import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.xiaomi.onetrack.c.b;
import com.xiaomi.onetrack.c.f;
import com.xiaomi.onetrack.c.j;
import com.xiaomi.onetrack.d.a;
import com.xiaomi.onetrack.d.c;
import com.xiaomi.onetrack.h.o;
import com.xiaomi.onetrack.h.u;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

public class l {
    private static final String a = "UploaderEngine";
    private static final String b = "code";
    private static final String c = "UTF-8";
    private static volatile l d;
    private j e;

    private l() {
        this.c();
    }

    public static l a() {
        l.b();
        return d;
    }

    private boolean a(JSONArray jSONArray) {
        String string2;
        block3 : {
            try {
                String string3 = u.a().b();
                String string4 = jSONArray.toString();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(" payload:");
                stringBuilder.append(string4);
                o.a(a, stringBuilder.toString());
                byte[] arrby = this.a(l.a(string4));
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("before zip and encrypt, len=");
                stringBuilder2.append(string4.length());
                stringBuilder2.append(", after=");
                stringBuilder2.append(arrby.length);
                o.a(a, stringBuilder2.toString());
                string2 = com.xiaomi.onetrack.g.b.a(string3, arrby);
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append("sendDataToServer response: ");
                stringBuilder3.append(string2);
                o.a(a, stringBuilder3.toString());
                if (!TextUtils.isEmpty((CharSequence)string2)) break block3;
                return false;
            }
            catch (Exception exception) {
                o.b(a, "Exception while uploading ", exception);
                return false;
            }
        }
        boolean bl = this.b(string2);
        return bl;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static byte[] a(String string2) {
        void var4_11;
        GZIPOutputStream gZIPOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        block12 : {
            byte[] arrby;
            block10 : {
                arrby = null;
                byteArrayOutputStream = new ByteArrayOutputStream(string2.getBytes(c).length);
                gZIPOutputStream = new GZIPOutputStream((OutputStream)byteArrayOutputStream);
                try {
                    void var5_7;
                    block11 : {
                        try {
                            gZIPOutputStream.write(string2.getBytes(c));
                            gZIPOutputStream.finish();
                            arrby = byteArrayOutputStream.toByteArray();
                            break block10;
                        }
                        catch (Exception exception) {
                            break block11;
                        }
                        catch (Throwable throwable) {
                            gZIPOutputStream = null;
                            break block12;
                        }
                        catch (Exception exception) {
                            gZIPOutputStream = null;
                            break block11;
                        }
                        catch (Throwable throwable) {
                            byteArrayOutputStream = null;
                            gZIPOutputStream = null;
                            break block12;
                        }
                        catch (Exception exception) {
                            byteArrayOutputStream = null;
                            gZIPOutputStream = null;
                        }
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(" zipData failed! ");
                    stringBuilder.append(var5_7.toString());
                    o.b(a, stringBuilder.toString());
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
            }
            com.xiaomi.onetrack.h.l.a((OutputStream)byteArrayOutputStream);
            com.xiaomi.onetrack.h.l.a((OutputStream)gZIPOutputStream);
            return arrby;
        }
        com.xiaomi.onetrack.h.l.a((OutputStream)byteArrayOutputStream);
        com.xiaomi.onetrack.h.l.a(gZIPOutputStream);
        throw var4_11;
    }

    private byte[] a(byte[] arrby) {
        if (arrby == null) {
            o.b(a, "content is null");
            return null;
        }
        return a.a(arrby, c.a(com.xiaomi.onetrack.d.f.a().b()[0]));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void b() {
        if (d != null) {
            return;
        }
        Class<l> class_ = l.class;
        synchronized (l.class) {
            if (d == null) {
                d = new l();
            }
            // ** MonitorExit[var1] (shouldn't be in output)
            return;
        }
    }

    private boolean b(String string2) {
        int n2;
        block6 : {
            try {
                n2 = new JSONObject(string2).optInt(b);
                if (n2 != 0) break block6;
            }
            catch (Exception exception) {
                o.b(a, "parseUploadingResult exception ", exception);
                return false;
            }
            o.a(a, "\u6210\u529f\u53d1\u9001\u6570\u636e\u5230\u670d\u52a1\u7aef");
            return true;
        }
        if (n2 == -3) {
            o.b(a, "signature expired, will update");
            com.xiaomi.onetrack.d.f.a().c();
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Error: status code=");
        stringBuilder.append(n2);
        o.b(a, stringBuilder.toString());
        return false;
    }

    private void c() {
        HandlerThread handlerThread = new HandlerThread("mi_analytics_uploader_worker");
        handlerThread.start();
        this.e = new j(handlerThread.getLooper());
    }

    public void a(int n2, boolean bl) {
        l l2 = this;
        synchronized (l2) {
            if (this.e != null) {
                this.e.a(n2, bl);
            } else {
                o.b(a, "*** impossible, upload timer should not be null");
            }
            return;
        }
    }

    public boolean a(int n2) {
        f f2;
        o.a(a, "\u5373\u5c06\u8bfb\u53d6\u6570\u636e\u5e93\u5e76\u4e0a\u4f20\u6570\u636e");
        do {
            if ((f2 = b.a().a(n2)) == null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("\u6ee1\u8db3\u6761\u4ef6\u7684\u8bb0\u5f55\u4e3a\u7a7a\uff0c\u5373\u5c06\u8fd4\u56de, priority=");
                stringBuilder.append(n2);
                o.a(a, stringBuilder.toString());
                return true;
            }
            ArrayList<Long> arrayList = f2.c;
            boolean bl = this.a(f2.a);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("upload success:");
            stringBuilder.append(bl);
            o.a(a, stringBuilder.toString());
            if (!bl) {
                return false;
            }
            if (b.a().a(arrayList) != 0) continue;
            o.b(a, "delete DB failed!", new Throwable());
            return true;
        } while (!f2.d);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("No more records for prio=");
        stringBuilder.append(n2);
        o.a(a, stringBuilder.toString());
        return true;
    }
}

