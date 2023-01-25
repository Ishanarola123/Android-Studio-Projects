/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.Path$Direction
 *  android.graphics.Path$Op
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffXfermode
 *  android.graphics.RectF
 *  android.graphics.Region
 *  android.graphics.Xfermode
 *  android.util.AttributeSet
 *  android.widget.FrameLayout
 *  miuix.appcompat.R
 *  miuix.appcompat.R$dimen
 */
package miuix.internal.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import miuix.appcompat.R;

public class RoundFrameLayout
extends FrameLayout {
    private Region mAreaRegion;
    private Path mClipOutPath;
    private Path mClipPath;
    private RectF mLayer;
    private Paint mPaint;
    private float[] mRadii;

    public RoundFrameLayout(Context context) {
        this(context, null);
    }

    public RoundFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundFrameLayout(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.init();
    }

    private void init() {
        float f = this.getContext().getResources().getDimensionPixelSize(R.dimen.miuix_appcompat_immersion_menu_background_radius);
        this.mRadii = new float[]{f, f, f, f, f, f, f, f};
        this.mLayer = new RectF();
        this.mClipPath = new Path();
        this.mClipOutPath = new Path();
        this.mAreaRegion = new Region();
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setAntiAlias(true);
    }

    private void refreshRegion() {
        if (this.mRadii == null) {
            return;
        }
        int n = (int)this.mLayer.width();
        int n2 = (int)this.mLayer.height();
        RectF rectF = new RectF();
        rectF.left = this.getPaddingLeft();
        rectF.top = this.getPaddingTop();
        rectF.right = n - this.getPaddingRight();
        rectF.bottom = n2 - this.getPaddingBottom();
        this.mClipPath.reset();
        this.mClipPath.addRoundRect(rectF, this.mRadii, Path.Direction.CW);
        Region region = new Region((int)rectF.left, (int)rectF.top, (int)rectF.right, (int)rectF.bottom);
        this.mAreaRegion.setPath(this.mClipPath, region);
        this.mClipOutPath.reset();
        this.mClipOutPath.addRect(0.0f, 0.0f, (float)((int)this.mLayer.width()), (float)((int)this.mLayer.height()), Path.Direction.CW);
        this.mClipOutPath.op(this.mClipPath, Path.Op.DIFFERENCE);
    }

    protected void dispatchDraw(Canvas canvas) {
        int n = canvas.saveLayer(this.mLayer, null, 31);
        super.dispatchDraw(canvas);
        this.onClipDraw(canvas);
        canvas.restoreToCount(n);
    }

    public void onClipDraw(Canvas canvas) {
        if (this.mRadii == null) {
            return;
        }
        this.mPaint.setColor(-1);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        canvas.drawPath(this.mClipOutPath, this.mPaint);
    }

    protected void onSizeChanged(int n, int n2, int n3, int n4) {
        super.onSizeChanged(n, n2, n3, n4);
        this.mLayer.set(0.0f, 0.0f, (float)n, (float)n2);
        this.refreshRegion();
    }
}

