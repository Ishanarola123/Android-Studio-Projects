/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteDatabase$CursorFactory
 *  android.database.sqlite.SQLiteOpenHelper
 *  android.util.Log
 *  java.lang.String
 */
package com.xiaomi.onetrack.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class e
extends SQLiteOpenHelper {
    public static final String a = "one_track_cloud";
    public static final String b = "events_cloud";
    public static final String c = "_id";
    public static final String d = "app_id";
    public static final String e = "cloud_data";
    public static final String f = "data_hash";
    public static final String g = "timestamp";
    static final String h = "CREATE TABLE events_cloud (_id  INTEGER PRIMARY KEY AUTOINCREMENT,app_id TEXT,cloud_data TEXT,timestamp INTEGER,data_hash TEXT)";
    private static final String i = "ConfigDatabaseHelper";
    private static final int j = 1;

    public e(Context context) {
        super(context, a, null, 1);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(h);
        Log.d((String)i, (String)"onCreate: ");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int n2, int n3) {
    }
}

