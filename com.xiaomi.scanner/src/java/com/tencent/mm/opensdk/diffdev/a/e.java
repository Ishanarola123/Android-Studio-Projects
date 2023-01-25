/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.IncompatibleClassChangeError
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  org.apache.http.HttpEntity
 *  org.apache.http.HttpResponse
 *  org.apache.http.StatusLine
 *  org.apache.http.client.methods.HttpGet
 *  org.apache.http.client.methods.HttpUriRequest
 *  org.apache.http.impl.client.DefaultHttpClient
 *  org.apache.http.params.HttpConnectionParams
 *  org.apache.http.params.HttpParams
 *  org.apache.http.util.EntityUtils
 */
package com.tencent.mm.opensdk.diffdev.a;

import com.tencent.mm.opensdk.utils.Log;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

public final class e {
    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static byte[] a(String var0) {
        if (var0 == null || var0.length() == 0) ** GOTO lbl27
        var2_1 = new DefaultHttpClient();
        var3_2 = new HttpGet(var0);
        try {
            HttpConnectionParams.setSoTimeout((HttpParams)var2_1.getParams(), (int)60000);
            var10_3 = var2_1.execute((HttpUriRequest)var3_2);
            if (var10_3.getStatusLine().getStatusCode() == 200) return EntityUtils.toByteArray((HttpEntity)var10_3.getEntity());
            var11_4 = new StringBuilder("httpGet fail, status code = ");
            var11_4.append(var10_3.getStatusLine().getStatusCode());
            Log.e("MicroMsg.SDK.NetUtil", var11_4.toString());
            return null;
        }
        catch (Throwable var9_6) {
            block5 : {
                block4 : {
                    var5_7 = new StringBuilder("httpGet, Throwable ex = ");
                    var6_8 = var9_6.getMessage();
                    break block4;
                    catch (IncompatibleClassChangeError var8_10) {
                        var5_7 = new StringBuilder("httpGet, IncompatibleClassChangeError ex = ");
                        var6_8 = var8_10.getMessage();
                        break block4;
                    }
                    catch (Exception var4_11) {
                        var5_7 = new StringBuilder("httpGet, Exception ex = ");
                        var6_8 = var4_11.getMessage();
                    }
                }
                var5_7.append(var6_8);
                var1_9 = var5_7.toString();
                break block5;
lbl27: // 1 sources:
                var1_9 = "httpGet, url is null";
            }
            Log.e("MicroMsg.SDK.NetUtil", var1_9);
            return null;
        }
    }
}

