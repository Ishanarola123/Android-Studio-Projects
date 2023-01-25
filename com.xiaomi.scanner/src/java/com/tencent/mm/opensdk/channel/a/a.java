/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.tencent.mm.opensdk.channel.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.opensdk.channel.a.b;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;

public final class a {
    /*
     * Enabled aggressive block sorting
     */
    public static boolean a(Context context, a a2) {
        block7 : {
            String string2;
            block6 : {
                block5 : {
                    if (context != null) break block5;
                    string2 = "send fail, invalid argument";
                    break block6;
                }
                if (!d.b(a2.action)) break block7;
                string2 = "send fail, action is null";
            }
            Log.e("MicroMsg.SDK.MMessage", string2);
            return false;
        }
        boolean bl = d.b(a2.a);
        String string3 = null;
        if (!bl) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a2.a);
            stringBuilder.append(".permission.MM_MESSAGE");
            string3 = stringBuilder.toString();
        }
        Intent intent = new Intent(a2.action);
        if (a2.bundle != null) {
            intent.putExtras(a2.bundle);
        }
        String string4 = context.getPackageName();
        intent.putExtra("_mmessage_sdkVersion", 620824064);
        intent.putExtra("_mmessage_appPackage", string4);
        intent.putExtra("_mmessage_content", a2.content);
        intent.putExtra("_mmessage_support_content_type", a2.b);
        intent.putExtra("_mmessage_checksum", b.a(a2.content, 620824064, string4));
        context.sendBroadcast(intent, string3);
        StringBuilder stringBuilder = new StringBuilder("send mm message, intent=");
        stringBuilder.append((Object)intent);
        stringBuilder.append(", perm=");
        stringBuilder.append(string3);
        Log.d("MicroMsg.SDK.MMessage", stringBuilder.toString());
        return true;
    }

    public static final class a {
        public String a;
        public String action;
        public long b;
        public Bundle bundle;
        public String content;
    }

}

