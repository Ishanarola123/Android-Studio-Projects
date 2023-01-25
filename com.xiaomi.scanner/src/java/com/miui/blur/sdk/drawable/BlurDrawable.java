/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.ColorFilter
 *  android.graphics.Paint
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Looper
 *  android.util.Log
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.lang.reflect.Method
 */
package com.miui.blur.sdk.drawable;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Method;

public class BlurDrawable
extends Drawable {
    public static final int MIUI_BLUR_DEFAULT_DARK = 6;
    public static final int MIUI_BLUR_DEFAULT_LIGHT = 2;
    public static final int MIUI_BLUR_EXTRA_THIN_DARK = 4;
    public static final int MIUI_BLUR_EXTRA_THIN_LIGHT = 0;
    public static final int MIUI_BLUR_HEAVY_DARK = 7;
    public static final int MIUI_BLUR_HEAVY_LIGHT = 3;
    public static final int MIUI_BLUR_THIN_DARK = 5;
    public static final int MIUI_BLUR_THIN_LIGHT = 1;
    public static final int MIUI_FULL_SCREEN_BLUR_DEFAULT_DARK = 11;
    public static final int MIUI_FULL_SCREEN_BLUR_DEFAULT_LIGHT = 9;
    public static final int MIUI_FULL_SCREEN_BLUR_THIN_DARK = 10;
    public static final int MIUI_FULL_SCREEN_BLUR_THIN_LIGHT = 8;
    private static final String TAG = "BlurDrawable";
    private static final Handler mainThreadHandler = new Handler(Looper.getMainLooper());
    private int mAlpha;
    private boolean mBlurEnabled = true;
    private int mBlurHeight = this.getBounds().height();
    private int mBlurWidth = this.getBounds().width();
    private long mFunctor = 0L;
    private Method mMethodCallDrawGLFunction;
    private Paint mPaint = new Paint();

    static {
        try {
            if (BlurDrawable.isSupportBlurStatic()) {
                System.loadLibrary((String)"miuiblursdk");
            }
        }
        catch (Throwable throwable) {
            Log.e((String)TAG, (String)"Failed to load miuiblursdk library", (Throwable)throwable);
            try {
                System.loadLibrary((String)"miuiblur");
            }
            catch (Throwable throwable2) {
                Log.e((String)TAG, (String)"Failed to load miuiblur library", (Throwable)throwable2);
            }
        }
    }

    public BlurDrawable() {
        this.mPaint.setColor(0);
        if (this.isSupportBlur()) {
            this.mFunctor = BlurDrawable.nCreateNativeFunctor(this.mBlurWidth, this.mBlurHeight);
            this.initMethod();
        }
    }

    private void drawBlurBack(Canvas canvas) {
        try {
            this.mMethodCallDrawGLFunction.setAccessible(true);
            Method method = this.mMethodCallDrawGLFunction;
            Object[] arrobject = new Object[]{this.mFunctor};
            method.invoke((Object)canvas, arrobject);
            return;
        }
        catch (Throwable throwable) {
            Log.e((String)TAG, (String)"canvas function [callDrawGLFunction()] error", (Throwable)throwable);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void initMethod() {
        try {
            int n2 = Build.VERSION.SDK_INT;
            if (n2 > 28) {
                Method method = Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class});
                Class class_ = (Class)Class.class.getDeclaredMethod("forName", new Class[]{String.class}).invoke(null, new Object[]{"android.graphics.RecordingCanvas"});
                Object[] arrobject = new Object[2];
                arrobject[0] = "callDrawGLFunction2";
                Class[] arrclass = new Class[]{Long.TYPE};
                arrobject[1] = arrclass;
                this.mMethodCallDrawGLFunction = (Method)method.invoke((Object)class_, arrobject);
                return;
            }
            if (Build.VERSION.SDK_INT > 22) {
                Class class_ = Class.forName((String)"android.view.DisplayListCanvas");
                Class[] arrclass = new Class[]{Long.TYPE};
                this.mMethodCallDrawGLFunction = class_.getMethod("callDrawGLFunction2", arrclass);
                return;
            }
            int n3 = Build.VERSION.SDK_INT;
            if (n3 == 21) {
                Class class_ = Class.forName((String)"android.view.HardwareCanvas");
                Class[] arrclass = new Class[]{Long.TYPE};
                this.mMethodCallDrawGLFunction = class_.getMethod("callDrawGLFunction", arrclass);
                return;
            }
            if (Build.VERSION.SDK_INT == 22) {
                Class class_ = Class.forName((String)"android.view.HardwareCanvas");
                Class[] arrclass = new Class[]{Long.TYPE};
                this.mMethodCallDrawGLFunction = class_.getMethod("callDrawGLFunction2", arrclass);
                return;
            }
            Class class_ = Class.forName((String)"android.view.HardwareCanvas");
            Class[] arrclass = new Class[]{Integer.TYPE};
            this.mMethodCallDrawGLFunction = class_.getMethod("callDrawGLFunction", arrclass);
            return;
        }
        catch (Exception exception) {
            Log.e((String)TAG, (String)"canvas function [callDrawGLFunction()] error", (Throwable)exception);
            return;
        }
    }

    private void invalidateOnMainThread() {
        Looper looper = Looper.myLooper();
        if (looper != null && looper.equals((Object)Looper.getMainLooper())) {
            this.invalidateSelf();
            return;
        }
        mainThreadHandler.post(new Runnable(){

            public void run() {
                BlurDrawable.this.invalidateSelf();
            }
        });
    }

    public static boolean isSupportBlurStatic() {
        return Build.VERSION.SDK_INT > 25;
    }

    public static native void nAddMixColor(long var0, int var2, int var3);

    public static native void nClearMixColor(long var0);

    public static native long nCreateNativeFunctor(int var0, int var1);

    public static native long nDeleteNativeFunctor(long var0);

    public static native void nEnableBlur(long var0, boolean var2);

    public static native void nNeedUpdateBounds(long var0, boolean var2);

    public static native void nSetAlpha(long var0, float var2);

    public static native void nSetBlurCornerRadii(long var0, float[] var2);

    public static native void nSetBlurMode(long var0, int var2);

    public static native void nSetBlurRatio(long var0, float var2);

    public static native void nSetMixColor(long var0, int var2, int var3);

    public void addMixColor(int n2) {
        if (this.isSupportBlur()) {
            BlurDrawable.nAddMixColor(this.mFunctor, n2, 4);
            this.invalidateOnMainThread();
        }
    }

    public void addMixColor(int n2, int n3) {
        if (this.isSupportBlur()) {
            BlurDrawable.nAddMixColor(this.mFunctor, n3, n2);
            this.invalidateOnMainThread();
        }
    }

    public void clearMixColor() {
        if (this.isSupportBlur()) {
            BlurDrawable.nClearMixColor(this.mFunctor);
            this.invalidateOnMainThread();
        }
    }

    public void draw(Canvas canvas) {
        Log.e((String)"BlurDrawable", (String)"draw");
        if (canvas.isHardwareAccelerated() && this.mBlurEnabled && this.isSupportBlur()) {
            this.drawBlurBack(canvas);
            return;
        }
        canvas.drawRect(this.getBounds(), this.mPaint);
    }

    public void enableBlur(boolean bl) {
        if (this.isSupportBlur()) {
            this.mBlurEnabled = bl;
            BlurDrawable.nEnableBlur(this.mFunctor, bl);
        }
    }

    protected void finalize() throws Throwable {
        if (this.isSupportBlur()) {
            BlurDrawable.nDeleteNativeFunctor(this.mFunctor);
        }
        Log.e((String)"BlurDrawable", (String)"finalize");
        Object.super.finalize();
    }

    public int getOpacity() {
        return 0;
    }

    public boolean isSupportBlur() {
        return Build.VERSION.SDK_INT > 25;
    }

    public void needUpdateBounds(boolean bl) {
        if (this.isSupportBlur()) {
            BlurDrawable.nNeedUpdateBounds(this.mFunctor, bl);
        }
    }

    public void setAlpha(int n2) {
        this.mAlpha = n2;
        BlurDrawable.nSetAlpha(this.mFunctor, (float)n2 / 255.0f);
    }

    public void setBlurCornerRadii(float[] arrf) {
        if (this.isSupportBlur()) {
            BlurDrawable.nSetBlurCornerRadii(this.mFunctor, arrf);
            this.invalidateOnMainThread();
        }
    }

    public void setBlurMode(int n2) {
        if (this.isSupportBlur()) {
            BlurDrawable.nSetBlurMode(this.mFunctor, n2);
            this.invalidateOnMainThread();
        }
    }

    public void setBlurRatio(float f2) {
        if (this.isSupportBlur()) {
            BlurDrawable.nSetBlurRatio(this.mFunctor, f2);
            this.invalidateOnMainThread();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Log.d((String)"BlurDrawable", (String)"nothing in setColorFilter");
    }

    public void setMiuiBlurType(int n2) {
        switch (n2) {
            default: {
                return;
            }
            case 11: {
                this.clearMixColor();
                this.addMixColor(19, Color.parseColor((String)"#80a3a3a3"));
                this.addMixColor(29, Color.parseColor((String)"#66000000"));
                this.setBlurRatio(1.0f);
                return;
            }
            case 10: {
                this.clearMixColor();
                this.addMixColor(19, Color.parseColor((String)"#52b4b4b4"));
                this.addMixColor(29, Color.parseColor((String)"#26000000"));
                this.setBlurRatio(1.0f);
                return;
            }
            case 9: {
                this.clearMixColor();
                this.addMixColor(18, Color.parseColor((String)"#85666666"));
                this.addMixColor(29, Color.parseColor((String)"#66ffffff"));
                this.setBlurRatio(1.0f);
                return;
            }
            case 8: {
                this.clearMixColor();
                this.addMixColor(18, Color.parseColor((String)"#61424242"));
                this.addMixColor(29, Color.parseColor((String)"#1effffff"));
                this.setBlurRatio(1.0f);
                return;
            }
            case 7: {
                this.clearMixColor();
                this.addMixColor(19, Color.parseColor((String)"#7f5c5c5c"));
                this.addMixColor(29, Color.parseColor((String)"#bf1f1f1f"));
                this.setBlurRatio(1.0f);
                return;
            }
            case 6: {
                this.clearMixColor();
                this.addMixColor(19, Color.parseColor((String)"#75737373"));
                this.addMixColor(29, Color.parseColor((String)"#8a262626"));
                this.setBlurRatio(0.9f);
                return;
            }
            case 5: {
                this.clearMixColor();
                this.addMixColor(19, Color.parseColor((String)"#618a8a8a"));
                this.addMixColor(29, Color.parseColor((String)"#4d424242"));
                this.setBlurRatio(0.7f);
                return;
            }
            case 4: {
                this.clearMixColor();
                this.addMixColor(19, Color.parseColor((String)"#4dadadad"));
                this.addMixColor(29, Color.parseColor((String)"#33616161"));
                this.setBlurRatio(0.4f);
                return;
            }
            case 3: {
                this.clearMixColor();
                this.addMixColor(18, Color.parseColor((String)"#a66b6b6b"));
                this.addMixColor(29, Color.parseColor((String)"#ccf5f5f5"));
                this.setBlurRatio(1.0f);
                return;
            }
            case 2: {
                this.clearMixColor();
                this.addMixColor(18, Color.parseColor((String)"#8f606060"));
                this.addMixColor(29, Color.parseColor((String)"#a3f2f2f2"));
                this.setBlurRatio(0.9f);
                return;
            }
            case 1: {
                this.clearMixColor();
                this.addMixColor(18, Color.parseColor((String)"#84585858"));
                this.addMixColor(29, Color.parseColor((String)"#40e3e3e3"));
                this.setBlurRatio(0.7f);
                return;
            }
            case 0: 
        }
        this.clearMixColor();
        this.addMixColor(18, Color.parseColor((String)"#7f4d4d4d"));
        this.addMixColor(29, Color.parseColor((String)"#26d9d9d9"));
        this.setBlurRatio(0.4f);
    }

    public void setMixColor(int n2, int n3) {
        if (this.isSupportBlur()) {
            BlurDrawable.nSetMixColor(this.mFunctor, n3, n2);
            this.invalidateOnMainThread();
        }
    }

}

