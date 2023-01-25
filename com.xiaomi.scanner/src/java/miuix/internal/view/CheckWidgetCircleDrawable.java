/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  java.lang.Math
 */
package miuix.internal.view;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public class CheckWidgetCircleDrawable
extends Drawable {
    private static final int PADDING = 3;
    private boolean mHasStroke;
    private Paint mPaint = new Paint();
    private float mScale = 1.0f;
    private int mStrokeDisableAlpha;
    private int mStrokeNormalAlpha;
    private Paint mStrokePaint = new Paint();
    private int mUncheckedDisableAlpha;
    private int mUncheckedNormalAlpha;

    public CheckWidgetCircleDrawable(int n, int n2, int n3) {
        this(n, n2, n3, 0, 0, 0);
    }

    public CheckWidgetCircleDrawable(int n, int n2, int n3, int n4, int n5, int n6) {
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(n);
        this.mUncheckedNormalAlpha = n2;
        this.mUncheckedDisableAlpha = n3;
        boolean bl = n4 != 0;
        this.mHasStroke = bl;
        if (this.mHasStroke) {
            this.mStrokePaint.setAntiAlias(true);
            this.mStrokePaint.setColor(n4);
            this.mStrokePaint.setStyle(Paint.Style.STROKE);
        }
        this.mStrokeNormalAlpha = n5;
        this.mStrokeDisableAlpha = n6;
    }

    public void draw(Canvas canvas) {
        Rect rect = this.getBounds();
        int n = (rect.right + rect.left) / 2;
        int n2 = (rect.top + rect.bottom) / 2;
        int n3 = Math.min((int)(rect.right - rect.left), (int)(rect.bottom - rect.top)) / 2;
        float f = n;
        float f2 = n2;
        float f3 = n3;
        canvas.drawCircle(f, f2, f3 * this.mScale - 3.0f, this.mPaint);
        if (this.mHasStroke) {
            canvas.drawCircle(f, f2, f3 * this.mScale - 3.0f, this.mStrokePaint);
        }
    }

    public int getAlpha() {
        return this.mPaint.getAlpha();
    }

    public int getOpacity() {
        return -3;
    }

    public float getScale() {
        return this.mScale;
    }

    public void setAlpha(int n) {
        this.mPaint.setAlpha(n);
        if (this.mHasStroke) {
            if (n == this.mUncheckedNormalAlpha) {
                this.mStrokePaint.setAlpha(this.mStrokeNormalAlpha);
                return;
            }
            if (n == this.mUncheckedDisableAlpha) {
                this.mStrokePaint.setAlpha(this.mStrokeDisableAlpha);
            }
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    public void setScale(float f) {
        this.mScale = f;
    }
}

