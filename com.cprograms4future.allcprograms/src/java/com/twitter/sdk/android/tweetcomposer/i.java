/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.database.Cursor
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.provider.DocumentsContract
 *  android.provider.MediaStore
 *  android.provider.MediaStore$Images
 *  android.provider.MediaStore$Images$Media
 *  android.text.TextUtils
 *  android.webkit.MimeTypeMap
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.twitter.sdk.android.tweetcomposer;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.io.File;

class i {
    @TargetApi(value=19)
    static String a(Context context, Uri uri) {
        boolean bl = Build.VERSION.SDK_INT >= 19;
        if (bl && i.a(uri)) {
            String[] arrstring = DocumentsContract.getDocumentId((Uri)uri).split(":");
            if ("image".equals((Object)arrstring[0])) {
                Uri uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                String[] arrstring2 = new String[]{arrstring[1]};
                return i.a(context, uri2, "_id=?", arrstring2);
            }
            return null;
        }
        if (i.b(uri)) {
            return i.a(context, uri, null, null);
        }
        if (i.c(uri)) {
            return uri.getPath();
        }
        return null;
    }

    /*
     * Loose catch block
     * Enabled aggressive exception aggregation
     */
    static String a(Context context, Uri uri, String string, String[] arrstring) {
        void var5_9;
        Cursor cursor;
        block8 : {
            block6 : {
                String string2;
                block7 : {
                    String[] arrstring2 = new String[]{"_data"};
                    cursor = context.getContentResolver().query(uri, arrstring2, string, arrstring, null);
                    if (cursor == null) break block6;
                    try {
                        if (!cursor.moveToFirst()) break block6;
                        string2 = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                        if (cursor == null) break block7;
                    }
                    catch (Throwable throwable) {
                        break block8;
                    }
                    cursor.close();
                }
                return string2;
            }
            if (cursor != null) {
                cursor.close();
            }
            return null;
            catch (Throwable throwable) {
                cursor = null;
            }
        }
        if (cursor != null) {
            cursor.close();
        }
        throw var5_9;
    }

    static String a(File file) {
        String string = i.a(file.getName());
        if (!TextUtils.isEmpty((CharSequence)string)) {
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(string);
        }
        return "application/octet-stream";
    }

    static String a(String string) {
        if (string == null) {
            return null;
        }
        int n2 = string.lastIndexOf(".");
        if (n2 < 0) {
            return "";
        }
        return string.substring(n2 + 1);
    }

    public static boolean a(Uri uri) {
        return "com.android.providers.media.documents".equalsIgnoreCase(uri.getAuthority());
    }

    public static boolean b(Uri uri) {
        return "content".equalsIgnoreCase(uri.getScheme());
    }

    public static boolean c(Uri uri) {
        return "file".equalsIgnoreCase(uri.getScheme());
    }
}

