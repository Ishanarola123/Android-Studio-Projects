/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  com.xiaomi.scanner.debug.Log
 *  com.xiaomi.scanner.debug.Log$Tag
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 */
package com.xiaomi.recognizer;

import android.graphics.Bitmap;
import com.xiaomi.recognizer.RecognizeResult;
import com.xiaomi.scanner.debug.Log;

public class Quadrangle {
    private static final Log.Tag TAG = new Log.Tag("Quadrangle");

    static {
        System.loadLibrary((String)"QuadrangleRecognizer");
    }

    public static Bitmap covertToGray(Bitmap bitmap) {
        return Quadrangle.nativeCovertToGray(bitmap);
    }

    public static RecognizeResult detectBitmap(Bitmap bitmap) {
        return Quadrangle.nativeDetectBitmap(bitmap);
    }

    public static RecognizeResult detectByteArray(byte[] arrby, int n2, int n3) {
        return Quadrangle.nativeDetectByteArray(arrby, n2, n3);
    }

    private static native Bitmap nativeCovertToGray(Bitmap var0);

    private static native RecognizeResult nativeDetectBitmap(Bitmap var0);

    private static native RecognizeResult nativeDetectByteArray(byte[] var0, int var1, int var2);

    private static native Bitmap nativeRectify(Bitmap var0, float[] var1, boolean var2);

    public static Bitmap rectify(Bitmap bitmap, float[] arrf, boolean bl) {
        return Quadrangle.nativeRectify(bitmap, arrf, bl);
    }
}

