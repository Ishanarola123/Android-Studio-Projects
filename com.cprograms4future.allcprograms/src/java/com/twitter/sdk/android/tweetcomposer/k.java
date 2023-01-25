/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.BitmapShader
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Path
 *  android.graphics.Path$Direction
 *  android.graphics.RectF
 *  android.graphics.Shader
 *  android.graphics.Shader$TileMode
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Arrays
 */
package com.twitter.sdk.android.tweetcomposer;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import com.a.a.ae;
import java.util.Arrays;

class k
implements ae {
    final float[] a;

    k(float[] arrf) {
        this.a = arrf;
    }

    @Override
    public Bitmap a(Bitmap bitmap) {
        RectF rectF = new RectF(0.0f, 0.0f, (float)bitmap.getWidth(), (float)bitmap.getHeight());
        Bitmap bitmap2 = Bitmap.createBitmap((int)bitmap.getWidth(), (int)bitmap.getHeight(), (Bitmap.Config)bitmap.getConfig());
        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader((Shader)bitmapShader);
        Path path = new Path();
        path.addRoundRect(rectF, this.a, Path.Direction.CCW);
        new Canvas(bitmap2).drawPath(path, paint);
        bitmap.recycle();
        return bitmap2;
    }

    @Override
    public String a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RoundedCornerTransformation(");
        stringBuilder.append(Arrays.toString((float[])this.a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

}

