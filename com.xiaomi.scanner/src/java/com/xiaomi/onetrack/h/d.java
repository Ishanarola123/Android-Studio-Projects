/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.onetrack.h;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.onetrack.f.a;
import com.xiaomi.onetrack.h.b;
import com.xiaomi.onetrack.h.o;

class d
extends BroadcastReceiver {
    final /* synthetic */ b a;

    d(b b2) {
        this.a = b2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void onReceive(Context context, Intent intent) {
        String string2;
        String string3;
        String string4;
        block4 : {
            try {
                string4 = intent.getStringExtra("host");
                String string5 = intent.getStringExtra("packagename");
                string2 = intent.getStringExtra("projectId");
                string3 = intent.getStringExtra("user");
                boolean bl = intent.getBooleanExtra("logon", false);
                boolean bl2 = intent.getBooleanExtra("quickuploadon", false);
                String string6 = a.d();
                if (TextUtils.isEmpty((CharSequence)string5) || "".equals((Object)string5)) return;
                if (!string6.equals((Object)string5)) {
                    return;
                }
                o.a = bl;
                o.b = bl2;
                if (bl2) break block4;
                return;
            }
            catch (Exception exception) {
                o.b(b.b(), exception.getMessage());
                return;
            }
        }
        b.a(this.a, string4, string2, string3);
    }
}

