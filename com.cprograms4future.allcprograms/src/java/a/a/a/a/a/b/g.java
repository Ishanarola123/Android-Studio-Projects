/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager
 *  android.content.res.Resources
 *  android.os.Bundle
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package a.a.a.a.a.b;

import a.a.a.a.a.b.i;
import a.a.a.a.c;
import a.a.a.a.l;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;

public class g {
    protected String a() {
        return "Fabric could not be initialized, API key missing from AndroidManifest.xml. Add the following tag to your Application element \n\t<meta-data android:name=\"io.fabric.ApiKey\" android:value=\"YOUR_API_KEY\"/>";
    }

    public String a(Context context) {
        String string = this.b(context);
        if (TextUtils.isEmpty((CharSequence)string)) {
            string = this.c(context);
        }
        if (TextUtils.isEmpty((CharSequence)string)) {
            this.d(context);
        }
        return string;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    protected String b(Context context) {
        void var3_9;
        String string;
        block4 : {
            string = null;
            String string3 = context.getPackageName();
            Bundle bundle = context.getPackageManager().getApplicationInfo((String)string3, (int)128).metaData;
            string = null;
            if (bundle == null) return string;
            String string2 = bundle.getString("io.fabric.ApiKey");
            if (string2 != null) return string2;
            try {
                c.h().a("Fabric", "Falling back to Crashlytics key lookup from Manifest");
                return bundle.getString("com.crashlytics.ApiKey");
            }
            catch (Exception exception) {
                string = string2;
            }
            break block4;
            catch (Exception exception) {
                // empty catch block
            }
        }
        l l2 = c.h();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Caught non-fatal exception while retrieving apiKey: ");
        stringBuilder.append((Object)var3_9);
        l2.a("Fabric", stringBuilder.toString());
        return string;
    }

    protected String c(Context context) {
        int n2 = i.a(context, "io.fabric.ApiKey", "string");
        if (n2 == 0) {
            c.h().a("Fabric", "Falling back to Crashlytics key lookup from Strings");
            n2 = i.a(context, "com.crashlytics.ApiKey", "string");
        }
        if (n2 != 0) {
            return context.getResources().getString(n2);
        }
        return null;
    }

    protected void d(Context context) {
        if (!c.i() && !i.c(context)) {
            c.h().d("Fabric", this.a());
            return;
        }
        throw new IllegalArgumentException(this.a());
    }
}

