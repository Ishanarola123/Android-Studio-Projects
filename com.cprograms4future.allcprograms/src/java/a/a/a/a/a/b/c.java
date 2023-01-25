/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  a.a.a.a.a.b.c$1
 *  a.a.a.a.a.b.d
 *  a.a.a.a.a.b.e
 *  a.a.a.a.a.f.c
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Thread
 */
package a.a.a.a.a.b;

import a.a.a.a.a.b.b;
import a.a.a.a.a.b.c;
import a.a.a.a.a.b.d;
import a.a.a.a.a.b.e;
import a.a.a.a.a.b.f;
import a.a.a.a.l;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

class c {
    private final Context a;
    private final a.a.a.a.a.f.b b;

    public c(Context context) {
        this.a = context.getApplicationContext();
        this.b = new a.a.a.a.a.f.c(context, "TwitterAdvertisingInfoPreferences");
    }

    static /* synthetic */ b a(c c2) {
        return c2.e();
    }

    private void a(b b2) {
        new Thread((Runnable)new 1(this, b2)).start();
    }

    static /* synthetic */ void a(c c2, b b2) {
        c2.b(b2);
    }

    @SuppressLint(value={"CommitPrefEdits"})
    private void b(b b2) {
        if (this.c(b2)) {
            this.b.a(this.b.b().putString("advertising_id", b2.a).putBoolean("limit_ad_tracking_enabled", b2.b));
            return;
        }
        this.b.a(this.b.b().remove("advertising_id").remove("limit_ad_tracking_enabled"));
    }

    private boolean c(b b2) {
        return b2 != null && !TextUtils.isEmpty((CharSequence)b2.a);
    }

    private b e() {
        l l2;
        String string;
        String string2;
        b b2 = this.c().a();
        if (!this.c(b2)) {
            b2 = this.d().a();
            if (!this.c(b2)) {
                l2 = a.a.a.a.c.h();
                string = "Fabric";
                string2 = "AdvertisingInfo not present";
            } else {
                l2 = a.a.a.a.c.h();
                string = "Fabric";
                string2 = "Using AdvertisingInfo from Service Provider";
            }
        } else {
            l2 = a.a.a.a.c.h();
            string = "Fabric";
            string2 = "Using AdvertisingInfo from Reflection Provider";
        }
        l2.a(string, string2);
        return b2;
    }

    public b a() {
        b b2 = this.b();
        if (this.c(b2)) {
            a.a.a.a.c.h().a("Fabric", "Using AdvertisingInfo from Preference Store");
            this.a(b2);
            return b2;
        }
        b b3 = this.e();
        this.b(b3);
        return b3;
    }

    protected b b() {
        return new b(this.b.a().getString("advertising_id", ""), this.b.a().getBoolean("limit_ad_tracking_enabled", false));
    }

    public f c() {
        return new d(this.a);
    }

    public f d() {
        return new e(this.a);
    }
}

