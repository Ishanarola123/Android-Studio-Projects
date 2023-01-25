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
 */
package com.xiaomi.onetrack.h.a.a;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

public class r {
    public String a(Context context) {
        Uri uri = Uri.parse((String)"content://com.vivo.vms.IdProvider/IdentifierId/OAID");
        Cursor cursor = context.getContentResolver().query(uri, null, null, null, null);
        String string2 = "";
        if (cursor != null) {
            if (cursor.moveToNext()) {
                string2 = cursor.getString(cursor.getColumnIndex("value"));
            }
            cursor.close();
        }
        return string2;
    }
}

