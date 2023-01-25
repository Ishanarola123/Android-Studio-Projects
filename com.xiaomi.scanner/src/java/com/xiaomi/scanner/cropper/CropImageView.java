/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.Bitmap
 *  android.graphics.Canvas
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.PointF
 *  android.graphics.RectF
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 *  android.view.ViewParent
 *  android.widget.ImageView
 *  androidx.annotation.NonNull
 *  androidx.annotation.Nullable
 *  com.xiaomi.scanner.cropper.cropwindow.edge.Edge
 *  com.xiaomi.scanner.cropper.cropwindow.handle.Handle
 *  com.xiaomi.scanner.cropper.util.AspectRatioUtil
 *  com.xiaomi.scanner.cropper.util.HandleUtil
 *  com.xiaomi.scanner.cropper.util.PaintUtil
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.String
 */
package com.xiaomi.scanner.cropper;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.xiaomi.scanner.R;
import com.xiaomi.scanner.cropper.cropwindow.edge.Edge;
import com.xiaomi.scanner.cropper.cropwindow.handle.Handle;
import com.xiaomi.scanner.cropper.util.AspectRatioUtil;
import com.xiaomi.scanner.cropper.util.HandleUtil;
import com.xiaomi.scanner.cropper.util.PaintUtil;

public class CropImageView
extends ImageView {
    public static final int GUIDELINES_OFF = 0;
    public static final int GUIDELINES_ON = 2;
    public static final int GUIDELINES_ON_TOUCH = 1;
    private static final String TAG = "com.xiaomi.scanner.cropper.CropImageView";
    private int mAspectRatioX = 1;
    private int mAspectRatioY = 1;
    @NonNull
    private RectF mBitmapRect = new RectF();
    private Paint mBorderPaint;
    private float mBorderThickness;
    private float mCornerLength;
    private Paint mCornerPaint;
    private float mCornerThickness;
    private boolean mFixAspectRatio;
    private Paint mGuidelinePaint;
    private int mGuidelinesMode = 1;
    private float mHandleRadius;
    private Handle mPressedHandle;
    private float mSnapRadius;
    private Paint mSurroundingAreaOverlayPaint;
    @NonNull
    private PointF mTouchOffset = new PointF();

    public CropImageView(Context context) {
        super(context);
        this.init(context, null);
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.init(context, attributeSet);
    }

    public CropImageView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.init(context, attributeSet);
    }

    private void drawBorder(@NonNull Canvas canvas) {
        canvas.drawRect(Edge.LEFT.getCoordinate(), Edge.TOP.getCoordinate(), Edge.RIGHT.getCoordinate(), Edge.BOTTOM.getCoordinate(), this.mBorderPaint);
    }

    private void drawCorners(@NonNull Canvas canvas) {
        float f2 = Edge.LEFT.getCoordinate();
        float f3 = Edge.TOP.getCoordinate();
        float f4 = Edge.RIGHT.getCoordinate();
        float f5 = Edge.BOTTOM.getCoordinate();
        float f6 = this.mCornerThickness;
        float f7 = this.mBorderThickness;
        float f8 = (f6 - f7) / 2.0f;
        float f9 = f6 - f7 / 2.0f;
        float f10 = f2 - f8;
        float f11 = f3 - f9;
        canvas.drawLine(f10, f11, f10, f3 + this.mCornerLength, this.mCornerPaint);
        float f12 = f2 - f9;
        float f13 = f3 - f8;
        canvas.drawLine(f12, f13, f2 + this.mCornerLength, f13, this.mCornerPaint);
        float f14 = f4 + f8;
        canvas.drawLine(f14, f11, f14, f3 + this.mCornerLength, this.mCornerPaint);
        float f15 = f4 + f9;
        canvas.drawLine(f15, f13, f4 - this.mCornerLength, f13, this.mCornerPaint);
        float f16 = f5 + f9;
        canvas.drawLine(f10, f16, f10, f5 - this.mCornerLength, this.mCornerPaint);
        float f17 = f5 + f8;
        canvas.drawLine(f12, f17, f2 + this.mCornerLength, f17, this.mCornerPaint);
        canvas.drawLine(f14, f16, f14, f5 - this.mCornerLength, this.mCornerPaint);
        canvas.drawLine(f15, f17, f4 - this.mCornerLength, f17, this.mCornerPaint);
    }

    private void drawDarkenedSurroundingArea(@NonNull Canvas canvas) {
        RectF rectF = this.mBitmapRect;
        float f2 = Edge.LEFT.getCoordinate();
        float f3 = Edge.TOP.getCoordinate();
        float f4 = Edge.RIGHT.getCoordinate();
        float f5 = Edge.BOTTOM.getCoordinate();
        canvas.drawRect(rectF.left, rectF.top, rectF.right, f3, this.mSurroundingAreaOverlayPaint);
        canvas.drawRect(rectF.left, f5, rectF.right, rectF.bottom, this.mSurroundingAreaOverlayPaint);
        canvas.drawRect(rectF.left, f3, f2, f5, this.mSurroundingAreaOverlayPaint);
        canvas.drawRect(f4, f3, rectF.right, f5, this.mSurroundingAreaOverlayPaint);
    }

    private void drawGuidelines(@NonNull Canvas canvas) {
        if (!this.shouldGuidelinesBeShown()) {
            return;
        }
        float f2 = Edge.LEFT.getCoordinate();
        float f3 = Edge.TOP.getCoordinate();
        float f4 = Edge.RIGHT.getCoordinate();
        float f5 = Edge.BOTTOM.getCoordinate();
        float f6 = Edge.getWidth() / 3.0f;
        float f7 = f2 + f6;
        canvas.drawLine(f7, f3, f7, f5, this.mGuidelinePaint);
        float f8 = f4 - f6;
        canvas.drawLine(f8, f3, f8, f5, this.mGuidelinePaint);
        float f9 = Edge.getHeight() / 3.0f;
        float f10 = f3 + f9;
        canvas.drawLine(f2, f10, f4, f10, this.mGuidelinePaint);
        float f11 = f5 - f9;
        canvas.drawLine(f2, f11, f4, f11, this.mGuidelinePaint);
    }

    private RectF getBitmapRect() {
        Drawable drawable2 = this.getDrawable();
        if (drawable2 == null) {
            return new RectF();
        }
        float[] arrf = new float[9];
        this.getImageMatrix().getValues(arrf);
        float f2 = arrf[0];
        float f3 = arrf[4];
        float f4 = arrf[2];
        float f5 = arrf[5];
        int n2 = drawable2.getIntrinsicWidth();
        int n3 = drawable2.getIntrinsicHeight();
        int n4 = Math.round((float)(f2 * (float)n2));
        int n5 = Math.round((float)(f3 * (float)n3));
        float f6 = Math.max((float)f4, (float)0.0f);
        float f7 = Math.max((float)f5, (float)0.0f);
        return new RectF(f6, f7, Math.min((float)(f6 + (float)n4), (float)this.getWidth()), Math.min((float)(f7 + (float)n5), (float)this.getHeight()));
    }

    private float getTargetAspectRatio() {
        return (float)this.mAspectRatioX / (float)this.mAspectRatioY;
    }

    private void init(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.CropImageView, 0, 0);
        this.mGuidelinesMode = typedArray.getInteger(3, 1);
        this.mFixAspectRatio = typedArray.getBoolean(2, false);
        this.mAspectRatioX = typedArray.getInteger(0, 1);
        this.mAspectRatioY = typedArray.getInteger(1, 1);
        typedArray.recycle();
        Resources resources = context.getResources();
        this.mBorderPaint = PaintUtil.newBorderPaint((Resources)resources);
        this.mGuidelinePaint = PaintUtil.newGuidelinePaint((Resources)resources);
        this.mSurroundingAreaOverlayPaint = PaintUtil.newSurroundingAreaOverlayPaint((Resources)resources);
        this.mCornerPaint = PaintUtil.newCornerPaint((Resources)resources);
        this.mHandleRadius = resources.getDimension(2131165854);
        this.mSnapRadius = resources.getDimension(2131165850);
        this.mBorderThickness = resources.getDimension(2131165266);
        this.mCornerThickness = resources.getDimension(2131165279);
        this.mCornerLength = resources.getDimension(2131165278);
    }

    private void initCropWindow(@NonNull RectF rectF) {
        if (this.mFixAspectRatio) {
            this.initCropWindowWithFixedAspectRatio(rectF);
            return;
        }
        float f2 = 0.1f * rectF.width();
        float f3 = 0.1f * rectF.height();
        Edge.LEFT.setCoordinate(f2 + rectF.left);
        Edge.TOP.setCoordinate(f3 + rectF.top);
        Edge.RIGHT.setCoordinate(rectF.right - f2);
        Edge.BOTTOM.setCoordinate(rectF.bottom - f3);
    }

    private void initCropWindowWithFixedAspectRatio(@NonNull RectF rectF) {
        if (AspectRatioUtil.calculateAspectRatio((RectF)rectF) > this.getTargetAspectRatio()) {
            float f2 = AspectRatioUtil.calculateWidth((float)rectF.height(), (float)this.getTargetAspectRatio());
            Edge edge = Edge.LEFT;
            float f3 = rectF.centerX();
            float f4 = f2 / 2.0f;
            edge.setCoordinate(f3 - f4);
            Edge.TOP.setCoordinate(rectF.top);
            Edge.RIGHT.setCoordinate(f4 + rectF.centerX());
            Edge.BOTTOM.setCoordinate(rectF.bottom);
            return;
        }
        float f5 = AspectRatioUtil.calculateHeight((float)rectF.width(), (float)this.getTargetAspectRatio());
        Edge.LEFT.setCoordinate(rectF.left);
        Edge edge = Edge.TOP;
        float f6 = rectF.centerY();
        float f7 = f5 / 2.0f;
        edge.setCoordinate(f6 - f7);
        Edge.RIGHT.setCoordinate(rectF.right);
        Edge.BOTTOM.setCoordinate(f7 + rectF.centerY());
    }

    private void onActionDown(float f2, float f3) {
        float f4;
        float f5;
        float f6;
        float f7 = Edge.LEFT.getCoordinate();
        this.mPressedHandle = HandleUtil.getPressedHandle((float)f2, (float)f3, (float)f7, (float)(f6 = Edge.TOP.getCoordinate()), (float)(f4 = Edge.RIGHT.getCoordinate()), (float)(f5 = Edge.BOTTOM.getCoordinate()), (float)this.mHandleRadius);
        Handle handle = this.mPressedHandle;
        if (handle != null) {
            HandleUtil.getOffset((Handle)handle, (float)f2, (float)f3, (float)f7, (float)f6, (float)f4, (float)f5, (PointF)this.mTouchOffset);
            this.invalidate();
        }
    }

    private void onActionMove(float f2, float f3) {
        if (this.mPressedHandle == null) {
            return;
        }
        float f4 = f2 + this.mTouchOffset.x;
        float f5 = f3 + this.mTouchOffset.y;
        if (this.mFixAspectRatio) {
            this.mPressedHandle.updateCropWindow(f4, f5, this.getTargetAspectRatio(), this.mBitmapRect, this.mSnapRadius);
        } else {
            this.mPressedHandle.updateCropWindow(f4, f5, this.mBitmapRect, this.mSnapRadius);
        }
        this.invalidate();
    }

    private void onActionUp() {
        if (this.mPressedHandle != null) {
            this.mPressedHandle = null;
            this.invalidate();
        }
    }

    private boolean shouldGuidelinesBeShown() {
        boolean bl = this.mGuidelinesMode;
        boolean bl2 = true;
        if (!bl) {
            if (bl == bl2 && this.mPressedHandle != null) {
                return bl2;
            }
            bl2 = false;
        }
        return bl2;
    }

    public Bitmap getCroppedImage() {
        Drawable drawable2 = this.getDrawable();
        if (drawable2 != null && drawable2 instanceof BitmapDrawable) {
            float[] arrf = new float[9];
            this.getImageMatrix().getValues(arrf);
            float f2 = arrf[0];
            float f3 = arrf[4];
            float f4 = arrf[2];
            float f5 = arrf[5];
            float f6 = f4 < 0.0f ? Math.abs((float)f4) : 0.0f;
            float f7 = f5 FCMPG 0.0f;
            float f8 = 0.0f;
            if (f7 < 0) {
                f8 = Math.abs((float)f5);
            }
            Bitmap bitmap = ((BitmapDrawable)drawable2).getBitmap();
            float f9 = (f6 + Edge.LEFT.getCoordinate()) / f2;
            float f10 = (f8 + Edge.TOP.getCoordinate()) / f3;
            float f11 = Math.min((float)(Edge.getWidth() / f2), (float)((float)bitmap.getWidth() - f9));
            float f12 = Math.min((float)(Edge.getHeight() / f3), (float)((float)bitmap.getHeight() - f10));
            return Bitmap.createBitmap((Bitmap)bitmap, (int)((int)f9), (int)((int)f10), (int)((int)f11), (int)((int)f12));
        }
        return null;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.drawDarkenedSurroundingArea(canvas);
        this.drawGuidelines(canvas);
        this.drawBorder(canvas);
        this.drawCorners(canvas);
    }

    protected void onLayout(boolean bl, int n2, int n3, int n4, int n5) {
        super.onLayout(bl, n2, n3, n4, n5);
        this.mBitmapRect = this.getBitmapRect();
        this.initCropWindow(this.mBitmapRect);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.isEnabled()) {
            return false;
        }
        int n2 = motionEvent.getAction();
        if (n2 != 0) {
            if (n2 != 1) {
                if (n2 != 2) {
                    if (n2 != 3) {
                        return false;
                    }
                } else {
                    this.onActionMove(motionEvent.getX(), motionEvent.getY());
                    this.getParent().requestDisallowInterceptTouchEvent(true);
                    return true;
                }
            }
            this.getParent().requestDisallowInterceptTouchEvent(false);
            this.onActionUp();
            return true;
        }
        this.onActionDown(motionEvent.getX(), motionEvent.getY());
        return true;
    }

    public void setAspectRatio(int n2, int n3) {
        if (n2 > 0 && n3 > 0) {
            this.mAspectRatioX = n2;
            this.mAspectRatioY = n3;
            if (this.mFixAspectRatio) {
                this.requestLayout();
            }
            return;
        }
        throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
    }

    public void setFixedAspectRatio(boolean bl) {
        this.mFixAspectRatio = bl;
        this.requestLayout();
    }

    public void setGuidelines(int n2) {
        this.mGuidelinesMode = n2;
        this.invalidate();
    }
}

