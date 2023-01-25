/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.xiaomi.scanner.debug.Log
 *  com.xiaomi.scanner.debug.Log$Tag
 *  java.io.FileNotFoundException
 *  java.io.IOException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 */
package com.xiaomi.scanner.camera;

import com.xiaomi.scanner.camera.exif.ExifInterface;
import com.xiaomi.scanner.debug.Log;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Exif {
    private static final Log.Tag TAG = new Log.Tag("Exif");

    public static ExifInterface getExif(String string2) {
        ExifInterface exifInterface = new ExifInterface();
        try {
            exifInterface.readExif(string2);
            return exifInterface;
        }
        catch (IOException iOException) {
            Log.Tag tag = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to read EXIF from file: ");
            stringBuilder.append(string2);
            Log.w((Log.Tag)tag, (String)stringBuilder.toString(), (Throwable)iOException);
            return exifInterface;
        }
        catch (FileNotFoundException fileNotFoundException) {
            Log.Tag tag = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to find file: ");
            stringBuilder.append(string2);
            Log.w((Log.Tag)tag, (String)stringBuilder.toString(), (Throwable)fileNotFoundException);
            return exifInterface;
        }
    }

    public static ExifInterface getExif(byte[] arrby) {
        ExifInterface exifInterface = new ExifInterface();
        try {
            exifInterface.readExif(arrby);
            return exifInterface;
        }
        catch (IOException iOException) {
            Log.w((Log.Tag)TAG, (String)"Failed to read EXIF data", (Throwable)iOException);
            return exifInterface;
        }
    }

    public static int getOrientation(ExifInterface exifInterface) {
        Integer n2 = exifInterface.getTagIntValue(ExifInterface.TAG_ORIENTATION);
        if (n2 == null) {
            return 0;
        }
        return ExifInterface.getRotationForOrientationValue(n2.shortValue());
    }

    public static int getOrientation(String string2) {
        if (string2 == null) {
            return 0;
        }
        long l2 = System.currentTimeMillis();
        int n2 = Exif.getOrientation(Exif.getExif(string2));
        Log.Tag tag = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("cost:");
        stringBuilder.append(System.currentTimeMillis() - l2);
        Log.t((Log.Tag)tag, (String)stringBuilder.toString());
        return n2;
    }

    public static int getOrientation(byte[] arrby) {
        if (arrby == null) {
            return 0;
        }
        return Exif.getOrientation(Exif.getExif(arrby));
    }
}

