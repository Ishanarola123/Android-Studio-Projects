/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.content.Context
 *  android.database.Cursor
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteDatabase$CursorFactory
 *  android.database.sqlite.SQLiteException
 *  android.database.sqlite.SQLiteOpenHelper
 *  java.lang.Integer
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.cprograms4future.allcprograms;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

public class c
extends SQLiteOpenHelper {
    public static final String BOOKMARK_COLUMN_ID = "_id";
    public static final String BOOKMARK_COLUMN_NAME = "programName";
    public static final String BOOKMARK_COLUMN_URL = "programUrl";
    public static final String BOOKMARK_TABLE_NAME = "bookmark";
    public static final String DATABASE_NAME = "SQLiteExample.db";
    private static final int DATABASE_VERSION = 1;

    public c(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public boolean CheckIsDataAlreadyInDBorNot(String string) {
        try {
            SQLiteDatabase.openDatabase((String)DATABASE_NAME, null, (int)1).close();
        }
        catch (SQLiteException sQLiteException) {}
        SQLiteDatabase sQLiteDatabase = this.getReadableDatabase();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Select * from bookmark where programUrl = ");
        stringBuilder.append(string);
        stringBuilder.toString();
        Cursor cursor = sQLiteDatabase.rawQuery("SELECT * FROM bookmark WHERE programUrl=?", new String[]{string});
        if (cursor.getCount() <= 0) {
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }

    public Integer deleteBookmark(Integer n2) {
        SQLiteDatabase sQLiteDatabase = this.getWritableDatabase();
        String[] arrstring = new String[]{Integer.toString((int)n2)};
        return sQLiteDatabase.delete(BOOKMARK_TABLE_NAME, "_id = ? ", arrstring);
    }

    public Integer deleteBookmarkByUrl(String string) {
        return this.getWritableDatabase().delete(BOOKMARK_TABLE_NAME, "programUrl = ? ", new String[]{string});
    }

    public Cursor getAllBookmarks() {
        return this.getReadableDatabase().rawQuery("SELECT * FROM bookmark", null);
    }

    public Cursor getBookmark(int n2) {
        SQLiteDatabase sQLiteDatabase = this.getReadableDatabase();
        String[] arrstring = new String[]{Integer.toString((int)n2)};
        return sQLiteDatabase.rawQuery("SELECT * FROM bookmark WHERE _id=?", arrstring);
    }

    public boolean insertBookmark(String string, String string2) {
        SQLiteDatabase sQLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(BOOKMARK_COLUMN_NAME, string);
        contentValues.put(BOOKMARK_COLUMN_URL, string2);
        sQLiteDatabase.insert(BOOKMARK_TABLE_NAME, null, contentValues);
        return true;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE bookmark(_id INTEGER PRIMARY KEY, programName TEXT, programUrl TEXT)");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int n2, int n3) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS bookmark");
        this.onCreate(sQLiteDatabase);
    }

    public boolean updateBookmark(Integer n2, String string, String string2) {
        SQLiteDatabase sQLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(BOOKMARK_COLUMN_NAME, string);
        contentValues.put(BOOKMARK_COLUMN_URL, string2);
        String[] arrstring = new String[]{Integer.toString((int)n2)};
        sQLiteDatabase.update(BOOKMARK_TABLE_NAME, contentValues, "_id = ? ", arrstring);
        return true;
    }
}

