/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.database.sqlite.SQLiteDatabase
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package com.xiaomi.onetrack.b;

import android.database.sqlite.SQLiteDatabase;
import com.xiaomi.onetrack.b.f;

class h
implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ f b;

    h(f f2, String string2) {
        this.b = f2;
        this.a = string2;
    }

    public void run() {
        try {
            SQLiteDatabase sQLiteDatabase = f.a(this.b).getWritableDatabase();
            String[] arrstring = new String[]{this.a};
            sQLiteDatabase.delete("events_cloud", "app_id=?", arrstring);
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }
}

