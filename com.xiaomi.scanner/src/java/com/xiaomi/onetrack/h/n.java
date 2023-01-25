/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.ContentValues
 *  android.content.Context
 *  android.database.Cursor
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  android.text.TextUtils
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.UUID
 */
package com.xiaomi.onetrack.h;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.xiaomi.onetrack.d.a;
import com.xiaomi.onetrack.h.o;
import com.xiaomi.onetrack.h.w;
import java.util.UUID;

public class n {
    private static final String a = "n";
    private static final String b = "content://com.miui.analytics.OneTrackProvider/insId";
    private static final String c = "insId";
    private static final String d = "pkg";
    private static final String e = "sign";
    private static volatile n f;
    private static String g;
    private static String i;
    private final Context h = com.xiaomi.onetrack.f.a.a();
    private boolean j = false;

    private n() {
        i = com.xiaomi.onetrack.f.a.d();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static n a() {
        if (f != null) return f;
        Class<n> class_ = n.class;
        synchronized (n.class) {
            if (f != null) return f;
            f = new n();
            // ** MonitorExit[var1] (shouldn't be in output)
            return f;
        }
    }

    private void b(String string2) {
        try {
            if (TextUtils.isEmpty((CharSequence)string2)) {
                return;
            }
            Uri uri = Uri.parse((String)b);
            ContentValues contentValues = new ContentValues();
            contentValues.put(i, string2);
            this.h.getContentResolver().insert(uri, contentValues);
            return;
        }
        catch (Exception exception) {
            w.e(string2);
            o.b(a, "setRemoteCacheInstanceId e", exception);
            return;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private String c() {
        String string2 = null;
        Uri.Builder builder = Uri.parse((String)b).buildUpon();
        builder.appendQueryParameter(d, i);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c);
        stringBuilder.append(i);
        builder.appendQueryParameter(e, a.a(stringBuilder.toString()));
        Cursor cursor = this.h.getContentResolver().query(builder.build(), null, null, null, null);
        string2 = null;
        if (cursor == null) return string2;
        try {
            while (cursor.moveToNext()) {
                string2 = cursor.getString(0);
            }
            cursor.close();
            return string2;
        }
        catch (Exception exception) {
            o.b(a, "getRemoteCacheInstanceId e", exception);
        }
        return string2;
    }

    private String d() {
        String string2 = w.a(this.h);
        if (TextUtils.isEmpty((CharSequence)string2)) {
            return w.m();
        }
        w.e(string2);
        return string2;
    }

    public void a(Boolean bl) {
        this.j = bl;
    }

    public void a(String string2) {
        if (TextUtils.isEmpty((CharSequence)string2)) {
            return;
        }
        g = string2;
        if (this.j) {
            this.b(g);
        }
        w.e(g);
    }

    public String b() {
        String string2;
        if (!TextUtils.isEmpty((CharSequence)g)) {
            return g;
        }
        if (this.j) {
            string2 = this.c();
            String string3 = this.d();
            if (TextUtils.isEmpty((CharSequence)string2) && !TextUtils.isEmpty((CharSequence)string3)) {
                this.b(string3);
                string2 = string3;
            } else if (!TextUtils.isEmpty((CharSequence)string2) && TextUtils.isEmpty((CharSequence)string3)) {
                w.e(string2);
            }
        } else {
            string2 = this.d();
        }
        if (TextUtils.isEmpty((CharSequence)string2)) {
            g = UUID.randomUUID().toString();
            if (this.j) {
                this.b(g);
            }
            w.e(g);
        } else {
            g = string2;
        }
        return g;
    }
}

