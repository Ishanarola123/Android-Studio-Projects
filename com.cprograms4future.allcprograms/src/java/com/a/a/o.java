/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.ContentUris
 *  android.content.Context
 *  android.database.Cursor
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.graphics.BitmapFactory$Options
 *  android.net.Uri
 *  android.provider.MediaStore
 *  android.provider.MediaStore$Images
 *  android.provider.MediaStore$Images$Thumbnails
 *  android.provider.MediaStore$Video
 *  android.provider.MediaStore$Video$Thumbnails
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.a.a;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import com.a.a.g;
import com.a.a.t;
import com.a.a.w;
import com.a.a.y;
import java.io.IOException;
import java.io.InputStream;

class o
extends g {
    private static final String[] b = new String[]{"orientation"};

    o(Context context) {
        super(context);
    }

    /*
     * Loose catch block
     * Enabled aggressive exception aggregation
     */
    static int a(ContentResolver contentResolver, Uri uri) {
        Cursor cursor;
        block12 : {
            RuntimeException runtimeException2;
            void var3_6;
            block11 : {
                block9 : {
                    int n2;
                    block10 : {
                        cursor = contentResolver.query(uri, b, null, null, null);
                        if (cursor == null) break block9;
                        try {
                            if (!cursor.moveToFirst()) break block9;
                            n2 = cursor.getInt(0);
                            if (cursor == null) break block10;
                        }
                        catch (Throwable throwable) {
                            break block11;
                        }
                        catch (RuntimeException runtimeException2) {
                            break block12;
                        }
                        cursor.close();
                    }
                    return n2;
                }
                if (cursor != null) {
                    cursor.close();
                }
                return 0;
                catch (Throwable throwable) {
                    cursor = null;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            throw var3_6;
            catch (RuntimeException runtimeException2) {
                cursor = null;
            }
        }
        if (cursor != null) {
            cursor.close();
        }
        return 0;
    }

    static a a(int n2, int n3) {
        if (n2 <= a.a.e && n3 <= a.a.f) {
            return a.a;
        }
        if (n2 <= a.b.e && n3 <= a.b.f) {
            return a.b;
        }
        return a.c;
    }

    @Override
    public y.a a(w w2, int n2) throws IOException {
        ContentResolver contentResolver = this.a.getContentResolver();
        int n3 = o.a(contentResolver, w2.d);
        String string = contentResolver.getType(w2.d);
        boolean bl = string != null && string.startsWith("video/");
        if (w2.d()) {
            Bitmap bitmap;
            a a2 = o.a(w2.h, w2.i);
            if (!bl && a2 == a.c) {
                return new y.a(null, this.b(w2), t.d.b, n3);
            }
            long l2 = ContentUris.parseId((Uri)w2.d);
            BitmapFactory.Options options = o.c(w2);
            options.inJustDecodeBounds = true;
            o.a(w2.h, w2.i, a2.e, a2.f, options, w2);
            if (bl) {
                int n4 = a2 == a.c ? 1 : a2.d;
                bitmap = MediaStore.Video.Thumbnails.getThumbnail((ContentResolver)contentResolver, (long)l2, (int)n4, (BitmapFactory.Options)options);
            } else {
                bitmap = MediaStore.Images.Thumbnails.getThumbnail((ContentResolver)contentResolver, (long)l2, (int)a2.d, (BitmapFactory.Options)options);
            }
            if (bitmap != null) {
                return new y.a(bitmap, null, t.d.b, n3);
            }
        }
        return new y.a(null, this.b(w2), t.d.b, n3);
    }

    @Override
    public boolean a(w w2) {
        Uri uri = w2.d;
        return "content".equals((Object)uri.getScheme()) && "media".equals((Object)uri.getAuthority());
    }

}

