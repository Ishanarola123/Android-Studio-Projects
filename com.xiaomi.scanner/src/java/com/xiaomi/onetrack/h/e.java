/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.Message
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.HashMap
 *  java.util.Map
 */
package com.xiaomi.onetrack.h;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.xiaomi.onetrack.h.a.a;
import com.xiaomi.onetrack.h.b;
import com.xiaomi.onetrack.h.f;
import com.xiaomi.onetrack.h.n;
import com.xiaomi.onetrack.h.o;
import java.util.HashMap;
import java.util.Map;

class e
implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ b d;

    e(b b2, String string2, String string3, String string4) {
        this.d = b2;
        this.a = string2;
        this.b = string3;
        this.c = string4;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        try {
            String string2;
            boolean bl = this.a.contains((CharSequence)"http://");
            if (bl) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.a);
                stringBuilder.append("/api/open/device/writeBack");
                string2 = stringBuilder.toString();
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("http://");
                stringBuilder.append(this.a);
                stringBuilder.append("/api/open/device/writeBack");
                string2 = stringBuilder.toString();
            }
            HashMap hashMap = new HashMap();
            hashMap.put((Object)"instanceId", (Object)n.a().b());
            hashMap.put((Object)"imei", (Object)f.b(b.a(this.d)));
            hashMap.put((Object)"oaid", (Object)a.a().a(b.a(this.d)));
            hashMap.put((Object)"projectId", (Object)this.b);
            hashMap.put((Object)"user", (Object)this.c);
            String string3 = com.xiaomi.onetrack.g.b.b(string2, (Map<String, String>)hashMap, false);
            if (!TextUtils.isEmpty((CharSequence)string3) && !"".equals((Object)string3)) {
                b.b(this.d, string3);
                return;
            }
            Message message = Message.obtain();
            message.what = 100;
            Bundle bundle = new Bundle();
            bundle.putString("hint", "\u6ce8\u518c\u4fe1\u606f\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5\u662f\u7f51\u7edc\u73af\u5883\u662f\u5426\u5728\u5185\u7f51");
            message.setData(bundle);
            b.b(this.d).sendMessage(message);
            return;
        }
        catch (Exception exception) {
            o.b(b.b(), exception.getMessage());
            return;
        }
    }
}

