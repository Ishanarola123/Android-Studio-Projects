/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.AsyncTask
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Void
 */
package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.diffdev.a.e;
import com.tencent.mm.opensdk.diffdev.a.g;
import com.tencent.mm.opensdk.utils.Log;

final class f
extends AsyncTask<Void, Void, a> {
    private OAuthListener l;
    private String o;
    private int u;
    private String url;

    public f(String string2, OAuthListener oAuthListener) {
        this.o = string2;
        this.l = oAuthListener;
        this.url = String.format((String)"https://long.open.weixin.qq.com/connect/l/qrconnect?f=json&uuid=%s", (Object[])new Object[]{string2});
    }

    /*
     * Enabled aggressive block sorting
     */
    protected final /* synthetic */ Object doInBackground(Object[] arrobject) {
        OAuthErrCode oAuthErrCode;
        a a2;
        String string2 = this.o;
        if (string2 == null || string2.length() == 0) {
            Log.e("MicroMsg.SDK.NoopingTask", "run fail, uuid is null");
            a2 = new a();
            oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
        } else {
            while (!this.isCancelled()) {
                String string3;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.url);
                if (this.u == 0) {
                    string3 = "";
                } else {
                    StringBuilder stringBuilder2 = new StringBuilder("&last=");
                    stringBuilder2.append(this.u);
                    string3 = stringBuilder2.toString();
                }
                stringBuilder.append(string3);
                String string4 = stringBuilder.toString();
                long l2 = System.currentTimeMillis();
                byte[] arrby = e.a(string4);
                long l3 = System.currentTimeMillis();
                a a3 = a.b(arrby);
                Object[] arrobject2 = new Object[]{string4, a3.n.toString(), a3.w, l3 - l2};
                Log.d("MicroMsg.SDK.NoopingTask", String.format((String)"nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", (Object[])arrobject2));
                if (a3.n != OAuthErrCode.WechatAuth_Err_OK) {
                    Object[] arrobject3 = new Object[]{a3.n.toString(), a3.w};
                    Log.e("MicroMsg.SDK.NoopingTask", String.format((String)"nooping fail, errCode = %s, uuidStatusCode = %d", (Object[])arrobject3));
                    return a3;
                }
                this.u = a3.w;
                if (a3.w == g.z.getCode()) {
                    this.l.onQrcodeScanned();
                    continue;
                }
                if (a3.w == g.B.getCode() || a3.w != g.A.getCode()) continue;
                if (a3.v == null || a3.v.length() == 0) {
                    Log.e("MicroMsg.SDK.NoopingTask", "nooping fail, confirm with an empty code!!!");
                    a3.n = OAuthErrCode.WechatAuth_Err_NormalErr;
                }
                return a3;
            }
            Log.i("MicroMsg.SDK.NoopingTask", "IDiffDevOAuth.stopAuth / detach invoked");
            a2 = new a();
            oAuthErrCode = OAuthErrCode.WechatAuth_Err_Auth_Stopped;
        }
        a2.n = oAuthErrCode;
        return a2;
    }

    protected final /* synthetic */ void onPostExecute(Object object) {
        a a2 = (a)object;
        this.l.onAuthFinish(a2.n, a2.v);
    }

    static final class a {
        public OAuthErrCode n;
        public String v;
        public int w;

        a() {
        }

        /*
         * Exception decompiling
         */
        public static a b(byte[] var0) {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [4[CASE]], but top level block is 2[TRYBLOCK]
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
    }

}

