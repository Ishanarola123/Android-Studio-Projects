/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffXfermode
 *  android.graphics.Xfermode
 *  android.util.AttributeSet
 *  android.widget.LinearLayout
 */
package miuix.popupwidget.internal.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import miuix.popupwidget.R;

public class ArrowPopupContentWrapper
extends LinearLayout {
    private Bitmap mMask1;
    private Bitmap mMask2;
    private Bitmap mMask3;
    private Bitmap mMask4;
    private Paint mPaint = new Paint();

    public ArrowPopupContentWrapper(Context context) {
        this(context, null);
    }

    public ArrowPopupContentWrapper(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ArrowPopupContentWrapper(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.mPaint.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.mPaint.setAntiAlias(true);
        Resources resources = this.getResources();
        this.mMask1 = BitmapFactory.decodeResource((Resources)resources, (int)R.drawable.miuix_appcompat_popup_mask_1);
        this.mMask2 = BitmapFactory.decodeResource((Resources)resources, (int)R.drawable.miuix_appcompat_popup_mask_2);
        this.mMask3 = BitmapFactory.decodeResource((Resources)resources, (int)R.drawable.miuix_appcompat_popup_mask_3);
        this.mMask4 = BitmapFactory.decodeResource((Resources)resources, (int)R.drawable.miuix_appcompat_popup_mask_4);
    }

    protected void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(0.0f, 0.0f, (float)this.getWidth(), (float)this.getHeight(), null, 31);
        super.dispatchDraw(canvas);
        canvas.drawBitmap(this.mMask1, (float)(0 + this.getPaddingLeft()), (float)(0 + this.getPaddingTop()), this.mPaint);
        canvas.drawBitmap(this.mMask2, (float)(this.getWidth() - this.mMask2.getWidth() - this.getPaddingRight()), (float)(0 + this.getPaddingTop()), this.mPaint);
        canvas.drawBitmap(this.mMask3, (float)(0 + this.getPaddingLeft()), (float)(this.getHeight() - this.mMask3.getHeight() - this.getPaddingBottom()), this.mPaint);
        canvas.drawBitmap(this.mMask4, (float)(this.getWidth() - this.mMask4.getWidth() - this.getPaddingRight()), (float)(this.getHeight() - this.mMask4.getHeight() - this.getPaddingBottom()), this.mPaint);
        canvas.restore();
    }
}

