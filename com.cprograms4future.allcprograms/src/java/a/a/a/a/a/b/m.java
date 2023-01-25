/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.provider.Settings
 *  android.provider.Settings$Secure
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Collection
 *  java.util.Locale
 *  java.util.UUID
 *  java.util.concurrent.locks.ReentrantLock
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package a.a.a.a.a.b;

import a.a.a.a.a.b.b;
import a.a.a.a.a.b.i;
import a.a.a.a.a.b.n;
import a.a.a.a.c;
import a.a.a.a.l;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.provider.Settings;
import java.util.Collection;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class m {
    private static final Pattern d = Pattern.compile((String)"[^\\p{Alnum}]");
    private static final String e = Pattern.quote((String)"/");
    a.a.a.a.a.b.c a;
    b b;
    boolean c;
    private final ReentrantLock f = new ReentrantLock();
    private final n g;
    private final boolean h;
    private final boolean i;
    private final Context j;
    private final String k;
    private final String l;
    private final Collection<a.a.a.a.i> m;

    public m(Context context, String string, String string2, Collection<a.a.a.a.i> collection) {
        if (context != null) {
            if (string != null) {
                if (collection != null) {
                    this.j = context;
                    this.k = string;
                    this.l = string2;
                    this.m = collection;
                    this.g = new n();
                    this.a = new a.a.a.a.a.b.c(context);
                    this.h = i.a(context, "com.crashlytics.CollectDeviceIdentifiers", true);
                    if (!this.h) {
                        l l2 = c.h();
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Device ID collection disabled for ");
                        stringBuilder.append(context.getPackageName());
                        l2.a("Fabric", stringBuilder.toString());
                    }
                    this.i = i.a(context, "com.crashlytics.CollectUserIdentifiers", true);
                    if (!this.i) {
                        l l3 = c.h();
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("User information collection disabled for ");
                        stringBuilder.append(context.getPackageName());
                        l3.a("Fabric", stringBuilder.toString());
                    }
                    return;
                }
                throw new IllegalArgumentException("kits must not be null");
            }
            throw new IllegalArgumentException("appIdentifier must not be null");
        }
        throw new IllegalArgumentException("appContext must not be null");
    }

    private String a(SharedPreferences sharedPreferences) {
        String string;
        block4 : {
            this.f.lock();
            string = sharedPreferences.getString("crashlytics.installation.id", null);
            if (string != null) break block4;
            string = this.a(UUID.randomUUID().toString());
            sharedPreferences.edit().putString("crashlytics.installation.id", string).commit();
        }
        return string;
        finally {
            this.f.unlock();
        }
    }

    private String a(String string) {
        if (string == null) {
            return null;
        }
        return d.matcher((CharSequence)string).replaceAll("").toLowerCase(Locale.US);
    }

    private String b(String string) {
        return string.replaceAll(e, "");
    }

    public String a() {
        String string = this.l;
        if (string == null) {
            SharedPreferences sharedPreferences = i.a(this.j);
            String string2 = sharedPreferences.getString("crashlytics.installation.id", null);
            if (string2 == null) {
                return this.a(sharedPreferences);
            }
            string = string2;
        }
        return string;
    }

    public String b() {
        return this.k;
    }

    public String c() {
        return this.b(Build.VERSION.RELEASE);
    }

    public String d() {
        return this.b(Build.VERSION.INCREMENTAL);
    }

    public String e() {
        Locale locale = Locale.US;
        Object[] arrobject = new Object[]{this.b(Build.MANUFACTURER), this.b(Build.MODEL)};
        return String.format((Locale)locale, (String)"%s/%s", (Object[])arrobject);
    }

    public String f() {
        String string = "";
        if (this.h && (string = this.j()) == null) {
            SharedPreferences sharedPreferences = i.a(this.j);
            String string2 = sharedPreferences.getString("crashlytics.installation.id", null);
            if (string2 == null) {
                return this.a(sharedPreferences);
            }
            string = string2;
        }
        return string;
    }

    public String g() {
        return this.g.a(this.j);
    }

    b h() {
        m m2 = this;
        synchronized (m2) {
            if (!this.c) {
                this.b = this.a.a();
                this.c = true;
            }
            b b2 = this.b;
            return b2;
        }
    }

    public String i() {
        b b2;
        if (this.h && (b2 = this.h()) != null) {
            return b2.a;
        }
        return null;
    }

    public String j() {
        String string;
        if (this.h && !"9774d56d682e549c".equals((Object)(string = Settings.Secure.getString((ContentResolver)this.j.getContentResolver(), (String)"android_id")))) {
            return this.a(string);
        }
        return null;
    }
}

