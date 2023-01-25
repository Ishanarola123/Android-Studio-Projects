/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.tencent.mm.opensdk.channel;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.opensdk.channel.a.b;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;

public class MMessageActV2 {
    public static final String DEFAULT_ENTRY_CLASS_NAME = ".wxapi.WXEntryActivity";
    public static final String MM_ENTRY_PACKAGE_NAME = "com.tencent.mm";
    public static final String MM_MSG_ENTRY_CLASS_NAME = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
    private static final String TAG = "MicroMsg.SDK.MMessageAct";

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static boolean send(Context var0, Args var1_1) {
        block8 : {
            if (var0 == null || var1_1 == null) ** GOTO lbl42
            if (d.b(var1_1.targetPkgName)) {
                var3_2 = new StringBuilder("send fail, invalid targetPkgName, targetPkgName = ");
                var3_2.append(var1_1.targetPkgName);
                var2_3 = var3_2.toString();
            } else {
                if (d.b(var1_1.targetClassName)) {
                    var5_4 = new StringBuilder();
                    var5_4.append(var1_1.targetPkgName);
                    var5_4.append(".wxapi.WXEntryActivity");
                    var1_1.targetClassName = var5_4.toString();
                }
                var8_5 = new StringBuilder("send, targetPkgName = ");
                var8_5.append(var1_1.targetPkgName);
                var8_5.append(", targetClassName = ");
                var8_5.append(var1_1.targetClassName);
                Log.d("MicroMsg.SDK.MMessageAct", var8_5.toString());
                var12_6 = new Intent();
                var12_6.setClassName(var1_1.targetPkgName, var1_1.targetClassName);
                if (var1_1.bundle != null) {
                    var12_6.putExtras(var1_1.bundle);
                }
                var14_7 = var0.getPackageName();
                var12_6.putExtra("_mmessage_sdkVersion", 620824064);
                var12_6.putExtra("_mmessage_appPackage", var14_7);
                var12_6.putExtra("_mmessage_content", var1_1.content);
                var12_6.putExtra("_mmessage_checksum", b.a(var1_1.content, 620824064, var14_7));
                var12_6.putExtra("_message_token", var1_1.token);
                if (var1_1.flags == -1) {
                    var12_6.addFlags(268435456).addFlags(134217728);
                } else {
                    var12_6.setFlags(var1_1.flags);
                }
                try {
                    var0.startActivity(var12_6);
                }
                catch (Exception var21_9) {
                    var22_10 = new StringBuilder("send fail, ex = ");
                    var22_10.append(var21_9.getMessage());
                    var2_3 = var22_10.toString();
                    break block8;
                }
                var24_8 = new StringBuilder("send mm message, intent=");
                var24_8.append((Object)var12_6);
                Log.d("MicroMsg.SDK.MMessageAct", var24_8.toString());
                return true;
lbl42: // 1 sources:
                var2_3 = "send fail, invalid argument";
            }
        }
        Log.e("MicroMsg.SDK.MMessageAct", var2_3);
        return false;
    }

    public static class Args {
        public static final int INVALID_FLAGS = -1;
        public Bundle bundle;
        public String content;
        public int flags = -1;
        public String targetClassName;
        public String targetPkgName;
        public String token;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("targetPkgName:");
            stringBuilder.append(this.targetPkgName);
            stringBuilder.append(", targetClassName:");
            stringBuilder.append(this.targetClassName);
            stringBuilder.append(", content:");
            stringBuilder.append(this.content);
            stringBuilder.append(", flags:");
            stringBuilder.append(this.flags);
            stringBuilder.append(", bundle:");
            stringBuilder.append((Object)this.bundle);
            return stringBuilder.toString();
        }
    }

}

