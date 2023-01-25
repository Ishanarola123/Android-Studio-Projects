/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.AsyncTask
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Environment
 *  android.util.Base64
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Void
 *  java.util.concurrent.Executor
 *  org.json.JSONObject
 */
package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.util.Base64;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.diffdev.a.e;
import com.tencent.mm.opensdk.diffdev.a.f;
import com.tencent.mm.opensdk.utils.Log;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public final class d
extends AsyncTask<Void, Void, a> {
    private static final String h;
    private static String i;
    private String appId;
    private String j;
    private String k;
    private OAuthListener l;
    private f m;
    private String scope;
    private String signature;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Environment.getExternalStorageDirectory().getAbsolutePath());
        stringBuilder.append("/tencent/MicroMsg/oauth_qrcode.png");
        h = stringBuilder.toString();
        i = null;
        i = "https://open.weixin.qq.com/connect/sdk/qrconnect?appid=%s&noncestr=%s&timestamp=%s&scope=%s&signature=%s";
    }

    public d(String string2, String string3, String string4, String string5, String string6, OAuthListener oAuthListener) {
        this.appId = string2;
        this.scope = string3;
        this.j = string4;
        this.k = string5;
        this.signature = string6;
        this.l = oAuthListener;
    }

    public final boolean a() {
        Log.i("MicroMsg.SDK.GetQRCodeTask", "cancelTask");
        f f2 = this.m;
        if (f2 == null) {
            return this.cancel(true);
        }
        return f2.cancel(true);
    }

    protected final /* synthetic */ Object doInBackground(Object[] arrobject) {
        Log.i("MicroMsg.SDK.GetQRCodeTask", "external storage available = false");
        String string2 = i;
        Object[] arrobject2 = new Object[]{this.appId, this.j, this.k, this.scope, this.signature};
        String string3 = String.format((String)string2, (Object[])arrobject2);
        long l2 = System.currentTimeMillis();
        byte[] arrby = e.a(string3);
        Object[] arrobject3 = new Object[]{string3, System.currentTimeMillis() - l2};
        Log.d("MicroMsg.SDK.GetQRCodeTask", String.format((String)"doInBackground, url = %s, time consumed = %d(ms)", (Object[])arrobject3));
        return a.a(arrby);
    }

    protected final /* synthetic */ void onPostExecute(Object object) {
        a a2 = (a)object;
        if (a2.n == OAuthErrCode.WechatAuth_Err_OK) {
            Log.d("MicroMsg.SDK.GetQRCodeTask", "onPostExecute, get qrcode success");
            this.l.onAuthGotQrcode(a2.q, a2.t);
            f f2 = this.m = new f(a2.o, this.l);
            if (Build.VERSION.SDK_INT >= 11) {
                f2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])new Void[0]);
                return;
            }
            f2.execute((Object[])new Void[0]);
            return;
        }
        Object[] arrobject = new Object[]{a2.n};
        Log.e("MicroMsg.SDK.GetQRCodeTask", String.format((String)"onPostExecute, get qrcode fail, OAuthErrCode = %s", (Object[])arrobject));
        this.l.onAuthFinish(a2.n, null);
    }

    static final class a {
        public OAuthErrCode n;
        public String o;
        public String p;
        public String q;
        public int r;
        public String s;
        public byte[] t;

        private a() {
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Lifted jumps to return sites
         */
        public static a a(byte[] var0) {
            var1_1 = new a();
            if (var0 == null || var0.length == 0) ** GOTO lbl43
            var3_2 = new String(var0, "utf-8");
            try {
                var4_3 = new JSONObject(var3_2);
                var8_4 = var4_3.getInt("errcode");
                if (var8_4 != 0) {
                    var9_5 = new Object[]{var8_4};
                    Log.e("MicroMsg.SDK.GetQRCodeResult", String.format((String)"resp errcode = %d", (Object[])var9_5));
                    var1_1.n = OAuthErrCode.WechatAuth_Err_NormalErr;
                    var1_1.r = var8_4;
                    var1_1.s = var4_3.optString("errmsg");
                    return var1_1;
                }
                var10_6 = var4_3.getJSONObject("qrcode").getString("qrcodebase64");
                if (var10_6 != null && var10_6.length() != 0) {
                    var11_7 = Base64.decode((String)var10_6, (int)0);
                    if (var11_7 != null && var11_7.length != 0) {
                        var1_1.n = OAuthErrCode.WechatAuth_Err_OK;
                        var1_1.t = var11_7;
                        var1_1.o = var4_3.getString("uuid");
                        var1_1.p = var4_3.getString("appname");
                        var12_8 = new Object[]{var1_1.o, var1_1.p, var1_1.t.length};
                        Log.d("MicroMsg.SDK.GetQRCodeResult", String.format((String)"parse succ, save in memory, uuid = %s, appname = %s, imgBufLength = %d", (Object[])var12_8));
                        return var1_1;
                    }
                    Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBuf is null");
                    var1_1.n = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                    return var1_1;
                }
                Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBase64 is null");
                var1_1.n = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                return var1_1;
            }
            catch (Exception var5_9) {
                block8 : {
                    block7 : {
                        var6_10 = new Object[]{var5_9.getMessage()};
                        var7_11 = "parse json fail, ex = %s";
                        break block7;
                        catch (Exception var13_13) {
                            var6_10 = new Object[]{var13_13.getMessage()};
                            var7_11 = "parse fail, build String fail, ex = %s";
                        }
                    }
                    Log.e("MicroMsg.SDK.GetQRCodeResult", String.format((String)var7_11, (Object[])var6_10));
                    var2_12 = OAuthErrCode.WechatAuth_Err_NormalErr;
                    break block8;
lbl43: // 1 sources:
                    Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, buf is null");
                    var2_12 = OAuthErrCode.WechatAuth_Err_NetworkErr;
                }
                var1_1.n = var2_12;
                return var1_1;
            }
        }
    }

}

