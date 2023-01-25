/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  org.json.JSONObject
 */
package com.xiaomi.onetrack.a;

import android.text.TextUtils;
import com.xiaomi.onetrack.a.f;
import com.xiaomi.onetrack.h.j;
import com.xiaomi.onetrack.h.o;
import org.json.JSONObject;

class q
implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ f b;

    q(f f2, String string2) {
        this.b = f2;
        this.a = string2;
    }

    public void run() {
        try {
            String string2 = j.a(f.g(this.b));
            if (!TextUtils.isEmpty((CharSequence)string2)) {
                JSONObject jSONObject = new JSONObject(string2);
                jSONObject.remove(this.a);
                j.a(f.g(this.b), jSONObject.toString());
                return;
            }
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("removeCommonProperty error:");
            stringBuilder.append(exception.toString());
            o.b("OneTrackImp", stringBuilder.toString());
        }
    }
}

