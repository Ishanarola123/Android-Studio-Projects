/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  android.database.sqlite.SQLiteDatabase
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.util.concurrent.Callable
 *  org.json.JSONObject
 */
package com.xiaomi.onetrack.b;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.xiaomi.onetrack.b.f;
import com.xiaomi.onetrack.b.j;
import java.util.concurrent.Callable;
import org.json.JSONObject;

class i
implements Callable<j> {
    final /* synthetic */ String a;
    final /* synthetic */ f b;

    i(f f2, String string2) {
        this.b = f2;
        this.a = string2;
    }

    public j a() throws Exception {
        SQLiteDatabase sQLiteDatabase = f.a(this.b).getWritableDatabase();
        String[] arrstring = new String[]{this.a};
        Cursor cursor = sQLiteDatabase.query("events_cloud", null, "app_id=?", arrstring, null, null, null);
        int n2 = cursor.getColumnIndex("app_id");
        int n3 = cursor.getColumnIndex("cloud_data");
        int n4 = cursor.getColumnIndex("data_hash");
        int n5 = cursor.getColumnIndex("timestamp");
        if (cursor.moveToNext()) {
            j j2 = new j();
            j2.a = cursor.getString(n2);
            String string2 = cursor.getString(n3);
            if (!TextUtils.isEmpty((CharSequence)string2)) {
                j2.d = new JSONObject(string2);
            }
            j2.c = cursor.getString(n4);
            j2.b = cursor.getLong(n5);
            return j2;
        }
        return null;
    }

    public /* synthetic */ Object call() throws Exception {
        return this.a();
    }
}

