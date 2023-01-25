/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.database.Cursor
 *  android.net.Uri
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.xiaomi.onetrack.h.a.a;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

public class i {
    private String a(Cursor cursor) {
        int n2;
        int n3;
        if (cursor == null) {
            return null;
        }
        if (cursor.isClosed()) {
            return null;
        }
        cursor.moveToFirst();
        int n4 = cursor.getColumnIndex("value");
        String string2 = null;
        if (n4 > 0) {
            string2 = cursor.getString(n4);
        }
        if ((n2 = cursor.getColumnIndex("code")) > 0) {
            cursor.getInt(n2);
        }
        if ((n3 = cursor.getColumnIndex("expired")) > 0) {
            cursor.getLong(n3);
        }
        return string2;
    }

    public String a(Context context) {
        Uri uri = Uri.parse((String)"content://com.meizu.flyme.openidsdk/");
        String string2 = "";
        ContentResolver contentResolver = context.getContentResolver();
        try {
            Cursor cursor = contentResolver.query(uri, null, null, new String[]{"oaid"}, null);
            string2 = this.a(cursor);
            cursor.close();
            return string2;
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
            return string2;
        }
    }
}

