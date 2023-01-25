/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.Matrix
 *  android.graphics.Matrix$ScaleToFit
 *  android.graphics.PointF
 *  android.graphics.RectF
 *  android.graphics.SurfaceTexture
 *  android.view.TextureView
 *  android.view.TextureView$SurfaceTextureListener
 *  android.view.View
 *  android.view.View$OnLayoutChangeListener
 *  com.android.ex.camera2.portability.CameraAgent
 *  com.android.ex.camera2.portability.CameraAgent$CameraProxy
 *  com.android.ex.camera2.portability.CameraDeviceInfo
 *  com.android.ex.camera2.portability.CameraDeviceInfo$Characteristics
 *  com.android.ex.camera2.portability.CameraSettings
 *  com.android.ex.camera2.portability.Size
 *  com.xiaomi.scanner.debug.Log
 *  com.xiaomi.scanner.debug.Log$Tag
 *  com.xiaomi.scanner.ui.PreviewStatusListener
 *  com.xiaomi.scanner.ui.PreviewStatusListener$PreviewAreaChangedListener
 *  com.xiaomi.scanner.ui.PreviewStatusListener$PreviewAspectRatioChangedListener
 *  com.xiaomi.scanner.util.CameraUtil
 *  com.xiaomi.scanner.util.ScreenUtils
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Locale
 */
package com.xiaomi.scanner.camera;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.view.TextureView;
import android.view.View;
import com.android.ex.camera2.portability.CameraAgent;
import com.android.ex.camera2.portability.CameraDeviceInfo;
import com.android.ex.camera2.portability.CameraSettings;
import com.android.ex.camera2.portability.Size;
import com.xiaomi.scanner.camera.CameraProvider;
import com.xiaomi.scanner.debug.Log;
import com.xiaomi.scanner.ui.PreviewStatusListener;
import com.xiaomi.scanner.util.CameraUtil;
import com.xiaomi.scanner.util.ScreenUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class TextureViewHelper
implements TextureView.SurfaceTextureListener,
View.OnLayoutChangeListener {
    public static final float MATCH_SCREEN = 0.0f;
    private static final Log.Tag TAG = new Log.Tag("TextureView");
    private static final int UNSET = -1;
    private float mAspectRatio = 0.0f;
    private final ArrayList<PreviewStatusListener.PreviewAspectRatioChangedListener> mAspectRatioChangedListeners = new ArrayList();
    private boolean mAutoAdjustTransform = true;
    private final CameraProvider mCameraProvider;
    private int mHeight = 0;
    private Matrix mMatrixPreview;
    private View.OnLayoutChangeListener mOnLayoutChangeListener = null;
    private int mOrientation = -1;
    private TextureView mPreview;
    private RectF mPreviewArea = new RectF();
    private int mPreviewDisplayHeight;
    private int mPreviewDisplayWidth;
    private final ArrayList<PreviewStatusListener.PreviewAreaChangedListener> mPreviewSizeChangedListeners = new ArrayList();
    private TextureView.SurfaceTextureListener mSurfaceTextureListener;
    private int mWidth = 0;

    public TextureViewHelper(TextureView textureView, CameraProvider cameraProvider) {
        this.mPreview = textureView;
        this.mCameraProvider = cameraProvider;
        this.mPreview.addOnLayoutChangeListener((View.OnLayoutChangeListener)this);
        this.mPreview.setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void getPreviewScale(PointF var1_1, Size var2_2) {
        block8 : {
            block6 : {
                block7 : {
                    var3_3 = 1.0f;
                    if (var2_2 != null) {
                        var7_4 = var2_2.width();
                        var5_6 = var7_4 != (var8_5 = this.mWidth) ? var3_3 * (float)var8_5 / (float)var2_2.width() : 1.0f;
                        var9_7 = var2_2.height();
                        var4_9 = var9_7 != (var10_8 = this.mHeight) ? var3_3 * (float)var10_8 / (float)var2_2.height() : 1.0f;
                    } else {
                        var4_9 = 1.0f;
                        var5_6 = 1.0f;
                    }
                    if (var5_6 == var4_9) ** GOTO lbl26
                    if (!(var5_6 < var3_3) || !(var4_9 < var3_3)) break block6;
                    if (!(var5_6 > var4_9)) break block7;
                    var6_10 = var5_6 * (var3_3 / var4_9);
                    ** GOTO lbl25
                }
                if (!(var5_6 < var4_9)) ** GOTO lbl-1000
                var4_9 *= var3_3 / var5_6;
                break block8;
            }
            if (var5_6 > var4_9) {
                var4_9 = var5_6 * (var3_3 / var4_9);
            } else if (var5_6 < var4_9) {
                var6_10 = var4_9 * (var3_3 / var5_6);
lbl25: // 2 sources:
                var3_3 = var6_10;
lbl26: // 2 sources:
                var4_9 = 1.0f;
            } else lbl-1000: // 2 sources:
            {
                var3_3 = var5_6;
            }
        }
        var1_1.set(var3_3, var4_9);
    }

    private Size getPreviewSize(Size size, int n2) {
        if (n2 != 0) {
            if (n2 == 180) {
                return size;
            }
            return new Size(size.height(), size.width());
        }
        return size;
    }

    private void onAspectRatioChanged() {
        Iterator iterator = this.mAspectRatioChangedListeners.iterator();
        while (iterator.hasNext()) {
            ((PreviewStatusListener.PreviewAspectRatioChangedListener)iterator.next()).onPreviewAspectRatioChanged(this.mAspectRatio);
        }
    }

    private void onPreviewAreaChanged(RectF rectF) {
        ArrayList arrayList = new ArrayList(this.mPreviewSizeChangedListeners);
        this.mPreview.post(new Runnable((List)arrayList, rectF){
            final /* synthetic */ List val$listeners;
            final /* synthetic */ RectF val$previewArea;
            {
                this.val$listeners = list;
                this.val$previewArea = rectF;
            }

            public void run() {
                Iterator iterator = this.val$listeners.iterator();
                while (iterator.hasNext()) {
                    ((PreviewStatusListener.PreviewAreaChangedListener)iterator.next()).onPreviewAreaChanged(this.val$previewArea);
                }
            }
        });
    }

    private void setAspectRatio(float f2) {
        if (this.mAspectRatio != f2) {
            Log.Tag tag = TAG;
            Locale locale = Locale.ENGLISH;
            Object[] arrobject = new Object[]{Float.valueOf((float)this.mAspectRatio), Float.valueOf((float)f2)};
            Log.v((Log.Tag)tag, (String)String.format((Locale)locale, (String)"aspectRatio: [%.2f -> %.2f] ", (Object[])arrobject));
            this.mAspectRatio = f2;
            this.onAspectRatioChanged();
        }
    }

    private void updatePreviewArea(Matrix matrix) {
        this.mPreviewArea.set(0.0f, 0.0f, (float)this.mWidth, (float)this.mHeight);
        matrix.mapRect(this.mPreviewArea);
        this.onPreviewAreaChanged(this.mPreviewArea);
    }

    private boolean updateTransform() {
        if (ScreenUtils.isPad((int)this.mPreview.getContext().getResources().getConfiguration().screenLayout)) {
            return true;
        }
        Log.Tag tag = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("updateTransform: autoAdjust=");
        stringBuilder.append(this.mAutoAdjustTransform);
        stringBuilder.append(" orientation=");
        stringBuilder.append(this.mOrientation);
        Log.v((Log.Tag)tag, (String)stringBuilder.toString());
        if (!this.mAutoAdjustTransform) {
            return false;
        }
        float f2 = this.mAspectRatio;
        if (f2 != 0.0f && !(f2 < 0.0f) && this.mWidth != 0) {
            if (this.mHeight == 0) {
                return true;
            }
            this.mMatrixPreview = new Matrix();
            int n2 = this.mCameraProvider.getCurrentCameraId();
            if (n2 >= 0) {
                CameraDeviceInfo.Characteristics characteristics = this.mCameraProvider.getCharacteristics(n2);
                PointF pointF = new PointF();
                CameraAgent.CameraProxy cameraProxy = this.mCameraProvider.getCameraDevice();
                if (cameraProxy != null) {
                    Size size = cameraProxy.getSettings().getCurrentPreviewSize();
                    int n3 = characteristics != null ? characteristics.getPreviewOrientation(CameraUtil.getDisplayRotation()) : 90;
                    this.getPreviewScale(pointF, this.getPreviewSize(size, n3));
                    this.mPreviewDisplayWidth = (int)((float)this.mWidth / pointF.x);
                    this.mPreviewDisplayHeight = (int)((float)this.mHeight / pointF.y);
                }
                if (characteristics != null) {
                    this.mMatrixPreview = characteristics.getPreviewTransform(this.mOrientation, new RectF(0.0f, 0.0f, 1.0f, 1.0f), new RectF(0.0f, 0.0f, pointF.x, pointF.y));
                } else {
                    this.mMatrixPreview = new Matrix();
                    this.mMatrixPreview.setRectToRect(new RectF(0.0f, 0.0f, 1.0f, 1.0f), new RectF(0.0f, 0.0f, pointF.x, pointF.y), Matrix.ScaleToFit.FILL);
                }
                Log.Tag tag2 = TAG;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("updateTransform: matrix=");
                stringBuilder2.append((Object)this.mMatrixPreview);
                Log.v((Log.Tag)tag2, (String)stringBuilder2.toString());
            }
            this.mPreview.setTransform(this.mMatrixPreview);
            this.updatePreviewArea(this.mMatrixPreview);
        }
        return true;
    }

    public void addAspectRatioChangedListener(PreviewStatusListener.PreviewAspectRatioChangedListener previewAspectRatioChangedListener) {
        if (previewAspectRatioChangedListener != null && !this.mAspectRatioChangedListeners.contains((Object)previewAspectRatioChangedListener)) {
            this.mAspectRatioChangedListeners.add((Object)previewAspectRatioChangedListener);
        }
    }

    public void addPreviewAreaSizeChangedListener(PreviewStatusListener.PreviewAreaChangedListener previewAreaChangedListener) {
        if (previewAreaChangedListener != null && !this.mPreviewSizeChangedListeners.contains((Object)previewAreaChangedListener)) {
            this.mPreviewSizeChangedListeners.add((Object)previewAreaChangedListener);
            if (this.mPreviewArea.width() != 0.0f && this.mPreviewArea.height() != 0.0f) {
                previewAreaChangedListener.onPreviewAreaChanged(new RectF(this.mPreviewArea));
                return;
            }
            previewAreaChangedListener.onPreviewAreaChanged(new RectF(0.0f, 0.0f, (float)this.mWidth, (float)this.mHeight));
        }
    }

    public void clearTransform() {
        this.mPreview.setTransform(new Matrix());
        this.mPreviewArea.set(0.0f, 0.0f, (float)this.mWidth, (float)this.mHeight);
        this.onPreviewAreaChanged(this.mPreviewArea);
        this.setAspectRatio(0.0f);
    }

    public RectF getPreviewArea() {
        return new RectF(this.mPreviewArea);
    }

    public Bitmap getPreviewBitmap() {
        Bitmap bitmap = this.mPreview.getBitmap();
        if (this.mPreviewDisplayWidth != this.mWidth || this.mPreviewDisplayHeight != this.mHeight) {
            bitmap = Bitmap.createBitmap((Bitmap)bitmap, (int)0, (int)0, (int)this.mPreviewDisplayWidth, (int)this.mPreviewDisplayHeight, (Matrix)this.mMatrixPreview, (boolean)true);
        }
        return bitmap;
    }

    public Bitmap getPreviewBitmap(int n2) {
        RectF rectF = this.getTextureArea();
        int n3 = (int)rectF.width() / n2;
        int n4 = (int)rectF.height() / n2;
        return Bitmap.createBitmap((Bitmap)this.mPreview.getBitmap(n3, n4), (int)0, (int)0, (int)n3, (int)n4, (Matrix)this.mPreview.getTransform(null), (boolean)true);
    }

    public int getPreviewHeight() {
        return this.mHeight;
    }

    public int getPreviewWidth() {
        return this.mWidth;
    }

    public RectF getTextureArea() {
        if (this.mPreview == null) {
            return new RectF();
        }
        Matrix matrix = new Matrix();
        RectF rectF = new RectF(0.0f, 0.0f, (float)this.mWidth, (float)this.mHeight);
        this.mPreview.getTransform(matrix).mapRect(rectF);
        return rectF;
    }

    public void onLayoutChange(View view, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
        View.OnLayoutChangeListener onLayoutChangeListener;
        int n10 = n4 - n2;
        int n11 = n5 - n3;
        int n12 = CameraUtil.getDisplayRotation();
        Log.Tag tag = TAG;
        Locale locale = Locale.ENGLISH;
        Object[] arrobject = new Object[]{n6, n7, n8, n9, n2, n3, n4, n5, n12};
        Log.v((Log.Tag)tag, (String)String.format((Locale)locale, (String)"onLayoutChange: [%d %d %d %d]->[%d %d %d %d], orientation=%d", (Object[])arrobject));
        if (this.mWidth != n10 || this.mHeight != n11 || this.mOrientation != n12) {
            this.mWidth = n10;
            this.mHeight = n11;
            this.mOrientation = n12;
            if (!this.updateTransform()) {
                this.clearTransform();
            }
        }
        if ((onLayoutChangeListener = this.mOnLayoutChangeListener) != null) {
            onLayoutChangeListener.onLayoutChange(view, n2, n3, n4, n5, n6, n7, n8, n9);
        }
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int n2, int n3) {
        TextureView.SurfaceTextureListener surfaceTextureListener;
        if (this.mWidth != 0 && this.mHeight != 0) {
            this.updateTransform();
        }
        if ((surfaceTextureListener = this.mSurfaceTextureListener) != null) {
            surfaceTextureListener.onSurfaceTextureAvailable(surfaceTexture, n2, n3);
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        TextureView.SurfaceTextureListener surfaceTextureListener = this.mSurfaceTextureListener;
        if (surfaceTextureListener != null) {
            surfaceTextureListener.onSurfaceTextureDestroyed(surfaceTexture);
        }
        return false;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int n2, int n3) {
        TextureView.SurfaceTextureListener surfaceTextureListener = this.mSurfaceTextureListener;
        if (surfaceTextureListener != null) {
            surfaceTextureListener.onSurfaceTextureSizeChanged(surfaceTexture, n2, n3);
        }
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        TextureView.SurfaceTextureListener surfaceTextureListener = this.mSurfaceTextureListener;
        if (surfaceTextureListener != null) {
            surfaceTextureListener.onSurfaceTextureUpdated(surfaceTexture);
        }
    }

    public void removePreviewAreaSizeChangedListener(PreviewStatusListener.PreviewAreaChangedListener previewAreaChangedListener) {
        if (previewAreaChangedListener != null && this.mPreviewSizeChangedListeners.contains((Object)previewAreaChangedListener)) {
            this.mPreviewSizeChangedListeners.remove((Object)previewAreaChangedListener);
        }
    }

    public void setAutoAdjustTransform(boolean bl) {
        this.mAutoAdjustTransform = bl;
    }

    public void setOnLayoutChangeListener(View.OnLayoutChangeListener onLayoutChangeListener) {
        this.mOnLayoutChangeListener = onLayoutChangeListener;
    }

    public void setSurfaceTextureListener(TextureView.SurfaceTextureListener surfaceTextureListener) {
        this.mSurfaceTextureListener = surfaceTextureListener;
    }

    public void updateAspectRatio(float f2) {
        Log.Tag tag = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("updateAspectRatio: ");
        stringBuilder.append(f2);
        Log.v((Log.Tag)tag, (String)stringBuilder.toString());
        if (f2 <= 0.0f) {
            Log.Tag tag2 = TAG;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Invalid aspect ratio: ");
            stringBuilder2.append(f2);
            Log.e((Log.Tag)tag2, (String)stringBuilder2.toString());
            return;
        }
        if (f2 < 1.0f) {
            f2 = 1.0f / f2;
        }
        this.setAspectRatio(f2);
        this.updateTransform();
    }

    public void updateTransform(Matrix matrix) {
        RectF rectF = new RectF(0.0f, 0.0f, (float)this.mWidth, (float)this.mHeight);
        matrix.mapRect(rectF);
        float f2 = rectF.width();
        float f3 = rectF.height();
        if (f3 != 0.0f && f2 != 0.0f) {
            float f4 = f2 / f3;
            if (f4 < 1.0f) {
                f4 = 1.0f / f4;
            }
            if (f4 != this.mAspectRatio) {
                this.setAspectRatio(f4);
            }
            RectF rectF2 = new RectF(0.0f, 0.0f, (float)this.mWidth, (float)this.mHeight);
            Matrix matrix2 = new Matrix();
            matrix2.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            matrix.postConcat(matrix2);
            this.mPreview.setTransform(matrix);
            this.updatePreviewArea(matrix);
            return;
        }
        Log.Tag tag = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid preview size: ");
        stringBuilder.append(f2);
        stringBuilder.append(" x ");
        stringBuilder.append(f3);
        Log.e((Log.Tag)tag, (String)stringBuilder.toString());
    }

}

