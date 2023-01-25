/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.ObjectAnimator
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.TypedArray
 *  android.graphics.Bitmap
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Rect
 *  android.graphics.Region
 *  android.graphics.Region$Op
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.util.Property
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnTouchListener
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnPreDrawListener
 *  android.widget.FrameLayout
 *  android.widget.LinearLayout
 *  androidx.appcompat.widget.AppCompatTextView
 *  java.lang.CharSequence
 *  java.lang.Double
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  miuix.popupwidget.widget.GuidePopupWindow
 */
package miuix.popupwidget.internal.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import miuix.popupwidget.R;
import miuix.popupwidget.widget.GuidePopupWindow;

public class GuidePopupView
extends FrameLayout
implements View.OnTouchListener {
    public static final int ARROW_BOTTOM_LEFT_MODE = 7;
    public static final int ARROW_BOTTOM_MODE = 0;
    public static final int ARROW_BOTTOM_RIGHT_MODE = 5;
    public static final int ARROW_LEFT_MODE = 3;
    public static final int ARROW_NONE_MODE = -1;
    public static final int ARROW_RIGHT_MODE = 2;
    public static final int ARROW_TOP_LEFT_MODE = 4;
    public static final int ARROW_TOP_MODE = 1;
    public static final int ARROW_TOP_RIGHT_MODE = 6;
    private View mAnchor;
    private int mAnchorHeight;
    private int mAnchorLocationX;
    private int mAnchorLocationY;
    private int mAnchorWidth;
    private ObjectAnimator mAnimator;
    private int mArrowMode = -1;
    private int mColorBackground;
    private Context mContext;
    private int mDefaultOffset;
    private GuidePopupWindow mGuidePopupWindow;
    private Animator.AnimatorListener mHideAnimatorListener = new AnimatorListenerAdapter(){
        private boolean mCancel;

        public void onAnimationCancel(Animator animator2) {
            this.mCancel = true;
        }

        public void onAnimationEnd(Animator animator2) {
            if (this.mCancel) {
                return;
            }
            GuidePopupView.this.mIsDismissing = false;
            GuidePopupView.this.mAnimator = null;
            GuidePopupView.this.mGuidePopupWindow.dismiss();
            GuidePopupView.this.setArrowMode(0);
        }

        public void onAnimationStart(Animator animator2) {
            this.mCancel = false;
            GuidePopupView.this.mIsDismissing = true;
        }
    };
    private boolean mIsDismissing;
    private boolean mIsMirrored;
    private float mLineLength;
    private int mMinBorder;
    private LinearLayout mMirroredTextGroup;
    private int mOffsetX;
    private int mOffsetY;
    private final Paint mPaint = new Paint();
    private Animator.AnimatorListener mShowAnimatorListener = new AnimatorListenerAdapter(){
        private boolean mCancel;

        public void onAnimationCancel(Animator animator2) {
            this.mCancel = true;
        }

        public void onAnimationEnd(Animator animator2) {
            if (this.mCancel) {
                return;
            }
            GuidePopupView.this.mAnimator = null;
        }

        public void onAnimationStart(Animator animator2) {
            this.mCancel = false;
        }
    };
    private float mStartPointRadius;
    private float mTextCircleRadius;
    private ColorStateList mTextColor = null;
    private LinearLayout mTextGroup;
    private int mTextSize;
    private View.OnTouchListener mTouchInterceptor;
    private boolean mUseDefaultOffset = true;

    public GuidePopupView(Context context) {
        this(context, null);
    }

    public GuidePopupView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.guidePopupViewStyle);
    }

    public GuidePopupView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.mContext = context;
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.GuidePopupView, n, R.style.Widget_GuidePopupView_DayNight);
        this.mStartPointRadius = typedArray.getDimension(R.styleable.GuidePopupView_startPointRadius, 0.0f);
        this.mLineLength = typedArray.getDimension(R.styleable.GuidePopupView_lineLength, 0.0f);
        this.mTextCircleRadius = typedArray.getDimension(R.styleable.GuidePopupView_textCircleRadius, 0.0f);
        this.mColorBackground = typedArray.getColor(R.styleable.GuidePopupView_android_colorBackground, 0);
        int n2 = typedArray.getColor(R.styleable.GuidePopupView_paintColor, -1);
        this.mPaint.setColor(n2);
        this.mTextSize = typedArray.getDimensionPixelSize(R.styleable.GuidePopupView_android_textSize, 15);
        this.mTextColor = typedArray.getColorStateList(R.styleable.GuidePopupView_android_textColor);
        typedArray.recycle();
        this.mMinBorder = (int)(this.mLineLength + 2.5f * this.mTextCircleRadius);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void adjustArrowMode() {
        block10 : {
            block7 : {
                block11 : {
                    block8 : {
                        block9 : {
                            block6 : {
                                var1_1 = this.getWidth();
                                var2_2 = this.getHeight();
                                var3_3 = 4;
                                var4_4 = new int[var3_3];
                                var5_5 = this.mAnchorLocationY;
                                var4_4[0] = var5_5;
                                var7_7 = var2_2 - var5_5;
                                var8_8 = this.mAnchorHeight;
                                var4_4[1] = var7_7 - var8_8;
                                var4_4[2] = var9_9 = this.mAnchorLocationX;
                                var10_10 = var1_1 - var9_9;
                                var11_11 = this.mAnchorWidth;
                                var4_4[3] = var10_10 - var11_11;
                                var12_12 = var9_9 + var11_11 / 2;
                                var13_13 = var5_5 + var8_8 / 2;
                                var14_14 = Integer.MIN_VALUE;
                                var15_15 = 0;
                                for (var6_6 = 0; var6_6 < var3_3; ++var6_6) {
                                    if (var4_4[var6_6] < this.mMinBorder) {
                                        if (var4_4[var6_6] <= var14_14) continue;
                                        var14_14 = var4_4[var6_6];
                                        var15_15 = var6_6;
                                        continue;
                                    }
                                    break block6;
                                }
                                var6_6 = var15_15;
                            }
                            if (var6_6 == 0) break block7;
                            if (var6_6 == 1) break block8;
                            if (var6_6 == 2) break block9;
                            if (var6_6 != 3) ** GOTO lbl-1000
                            var22_16 = var13_13;
                            var23_17 = this.mTextCircleRadius;
                            if (var22_16 < var23_17) break block10;
                            if (!((float)(var2_2 - var13_13) < var23_17)) ** GOTO lbl-1000
                            ** GOTO lbl-1000
                        }
                        var20_18 = var13_13;
                        var21_19 = this.mTextCircleRadius;
                        if (var20_18 < var21_19) break block11;
                        if (!((float)(var2_2 - var13_13) < var21_19)) ** GOTO lbl-1000
                        ** GOTO lbl-1000
                    }
                    var18_20 = var12_12;
                    var19_21 = this.mTextCircleRadius;
                    if (var18_20 < var19_21) break block10;
                    if (!((float)(var1_1 - var12_12) < var19_21)) ** GOTO lbl-1000
                }
                var3_3 = 6;
                break block10;
            }
            var16_22 = var12_12;
            var17_23 = this.mTextCircleRadius;
            if (var16_22 < var17_23) lbl-1000: // 2 sources:
            {
                var3_3 = 7;
            } else if ((float)(var1_1 - var12_12) < var17_23) lbl-1000: // 2 sources:
            {
                var3_3 = 5;
            } else lbl-1000: // 5 sources:
            {
                var3_3 = var6_6;
            }
        }
        this.setArrowMode(var3_3);
    }

    private void arrowLayout() {
        this.caculateDefaultOffset();
        this.drawText(this.mArrowMode, this.mTextGroup, this.mOffsetX, this.mOffsetY);
        if (this.mIsMirrored) {
            this.drawText(this.getMirroredMode(), this.mMirroredTextGroup, -this.mOffsetX, -this.mOffsetY);
        }
    }

    private void caculateDefaultOffset() {
        if (!this.mUseDefaultOffset) {
            this.mDefaultOffset = 0;
            return;
        }
        int n = this.mAnchorWidth / 2;
        int n2 = this.mAnchorHeight / 2;
        int n3 = (int)Math.sqrt((double)(Math.pow((double)n, (double)2.0) + Math.pow((double)n2, (double)2.0)));
        int n4 = this.mArrowMode;
        if (n4 != 0 && n4 != 1) {
            if (n4 != 2 && n4 != 3) {
                this.mDefaultOffset = n3;
                return;
            }
            this.mDefaultOffset = n;
            return;
        }
        this.mDefaultOffset = n2;
    }

    private void drawPopup(Canvas canvas, int n, int n2, int n3) {
        float f;
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        float f2 = n2 + (this.mAnchorLocationX + this.mAnchorWidth / 2);
        float f3 = n3 + (this.mAnchorLocationY + this.mAnchorHeight / 2);
        switch (n) {
            default: {
                f = 0.0f;
                break;
            }
            case 7: {
                f = -135.0f;
                break;
            }
            case 6: {
                f = 45.0f;
                break;
            }
            case 5: {
                f = 135.0f;
                break;
            }
            case 4: {
                f = -45.0f;
                break;
            }
            case 3: {
                f = -90.0f;
                break;
            }
            case 2: {
                f = 90.0f;
                break;
            }
            case 0: {
                f = 180.0f;
            }
        }
        canvas.save();
        canvas.rotate(f, f2, f3);
        canvas.translate(0.0f, (float)this.mDefaultOffset);
        int n4 = canvas.save();
        canvas.clipRect(f2 - 2.0f, f3, f2 + 2.0f, f3 + this.mStartPointRadius, Region.Op.DIFFERENCE);
        canvas.drawCircle(f2, f3, this.mStartPointRadius, this.mPaint);
        canvas.restoreToCount(n4);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(4.0f);
        canvas.drawLine(f2, f3, f2, f3 + this.mLineLength, this.mPaint);
        float f4 = f3 + this.mLineLength + this.mTextCircleRadius;
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(4.0f);
        canvas.drawCircle(f2, f4, this.mTextCircleRadius, this.mPaint);
        canvas.restore();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void drawText(int var1_1, LinearLayout var2_2, int var3_3, int var4_4) {
        block11 : {
            block13 : {
                block8 : {
                    block12 : {
                        block9 : {
                            block10 : {
                                block6 : {
                                    block7 : {
                                        var5_5 = (float)this.mDefaultOffset + this.mLineLength + this.mTextCircleRadius;
                                        var6_6 = this.mAnchorLocationX + this.mAnchorWidth / 2;
                                        var7_7 = this.mAnchorLocationY + this.mAnchorHeight / 2;
                                        switch (var1_1) {
                                            default: {
                                                var11_8 = 0;
                                                var8_9 = 0;
                                                break block6;
                                            }
                                            case 3: {
                                                var8_9 = (int)(var5_5 + (float)var6_6 - (float)(var2_2.getMeasuredWidth() / 2));
                                                var21_10 = var2_2.getMeasuredHeight() / 2;
                                                ** GOTO lbl16
                                            }
                                            case 2: {
                                                var8_9 = (int)((float)var6_6 - var5_5 - (float)(var2_2.getMeasuredWidth() / 2));
                                                var21_10 = var2_2.getMeasuredHeight() / 2;
lbl16: // 2 sources:
                                                var11_8 = var7_7 - var21_10;
                                                break block6;
                                            }
                                            case 1: 
                                            case 4: 
                                            case 6: {
                                                var8_9 = var6_6 - var2_2.getMeasuredWidth() / 2;
                                                var9_11 = var5_5 + (float)var7_7;
                                                var10_12 = var2_2.getMeasuredHeight() / 2;
                                                break block7;
                                            }
                                            case 0: 
                                            case 5: 
                                            case 7: 
                                        }
                                        var8_9 = var6_6 - var2_2.getMeasuredWidth() / 2;
                                        var9_11 = (float)var7_7 - var5_5;
                                        var10_12 = var2_2.getMeasuredHeight() / 2;
                                    }
                                    var11_8 = (int)(var9_11 - (float)var10_12);
                                }
                                var12_13 = var5_5;
                                var14_14 = Math.sin((double)0.7853981633974483);
                                Double.isNaN((double)var12_13);
                                var17_15 = (int)(var12_13 * var14_14);
                                var18_16 = (int)(var5_5 - (float)var17_15);
                                if (var1_1 == 4) break block8;
                                if (var1_1 == 5) break block9;
                                if (var1_1 == 6) break block10;
                                if (var1_1 != 7) break block11;
                                var8_9 += var17_15;
                                break block12;
                            }
                            var8_9 -= var17_15;
                            break block13;
                        }
                        var8_9 -= var17_15;
                    }
                    var11_8 += var18_16;
                    break block11;
                }
                var8_9 += var17_15;
            }
            var11_8 -= var18_16;
        }
        var19_17 = var8_9 + var3_3;
        var20_18 = var11_8 + var4_4;
        var2_2.layout(var19_17, var20_18, var19_17 + var2_2.getMeasuredWidth(), var20_18 + var2_2.getMeasuredHeight());
    }

    private int getMirroredMode() {
        int n = this.mArrowMode;
        if (n == -1) {
            return -1;
        }
        if (n % 2 == 0) {
            return n + 1;
        }
        return n - 1;
    }

    public void addGuideTextView(LinearLayout linearLayout, String string2) {
        if (TextUtils.isEmpty((CharSequence)string2)) {
            return;
        }
        String[] arrstring = string2.split("\n");
        if (arrstring != null) {
            if (arrstring.length == 0) {
                return;
            }
            for (String string3 : arrstring) {
                AppCompatTextView appCompatTextView = (AppCompatTextView)GuidePopupView.inflate((Context)this.mContext, (int)R.layout.miuix_appcompat_guide_popup_text_view, null);
                appCompatTextView.setText((CharSequence)string3);
                appCompatTextView.setTextSize(0, (float)this.mTextSize);
                ColorStateList colorStateList = this.mTextColor;
                if (colorStateList != null) {
                    appCompatTextView.setTextColor(colorStateList);
                }
                linearLayout.addView((View)appCompatTextView);
            }
        }
    }

    public void animateToDismiss() {
        if (this.mIsDismissing) {
            return;
        }
        ObjectAnimator objectAnimator = this.mAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        this.mAnimator = ObjectAnimator.ofFloat((Object)((Object)this), (Property)View.ALPHA, (float[])new float[]{0.0f});
        this.mAnimator.setDuration(200L);
        this.mAnimator.addListener(this.mHideAnimatorListener);
        this.mAnimator.start();
    }

    public void animateToShow() {
        this.setAlpha(0.0f);
        this.invalidate();
        this.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener(){

            public boolean onPreDraw() {
                GuidePopupView.this.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
                if (GuidePopupView.this.mAnimator != null) {
                    GuidePopupView.this.mAnimator.cancel();
                }
                GuidePopupView guidePopupView = GuidePopupView.this;
                guidePopupView.mAnimator = ObjectAnimator.ofFloat((Object)((Object)guidePopupView), (Property)View.ALPHA, (float[])new float[]{1.0f});
                GuidePopupView.this.mAnimator.setDuration(300L);
                GuidePopupView.this.mAnimator.addListener(GuidePopupView.this.mShowAnimatorListener);
                GuidePopupView.this.mAnimator.start();
                return true;
            }
        });
    }

    public void clearOffset() {
        this.setOffset(0, 0);
        this.mUseDefaultOffset = true;
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.save();
        canvas.translate((float)this.mAnchorLocationX, (float)this.mAnchorLocationY);
        this.mAnchor.setDrawingCacheEnabled(true);
        this.mAnchor.buildDrawingCache();
        canvas.drawBitmap(this.mAnchor.getDrawingCache(), 0.0f, 0.0f, null);
        this.mAnchor.setDrawingCacheEnabled(false);
        canvas.restore();
        this.drawPopup(canvas, this.mArrowMode, this.mOffsetX, this.mOffsetY);
        if (this.mIsMirrored) {
            this.drawPopup(canvas, this.getMirroredMode(), -this.mOffsetX, -this.mOffsetY);
        }
    }

    public int getArrowMode() {
        return this.mArrowMode;
    }

    public int getColorBackground() {
        return this.mColorBackground;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mTextGroup = (LinearLayout)this.findViewById(R.id.text_group);
        this.mMirroredTextGroup = (LinearLayout)this.findViewById(R.id.mirrored_text_group);
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        if (this.mAnchorWidth == 0 || this.mAnchorHeight == 0) {
            this.setAnchor(this.mAnchor);
        }
        int n5 = this.mTextGroup.getMeasuredWidth();
        int n6 = this.mTextGroup.getMeasuredHeight();
        this.mTextCircleRadius = (float)Math.max((double)(Math.sqrt((double)(Math.pow((double)n5, (double)2.0) + Math.pow((double)n6, (double)2.0))) / 2.0), (double)this.mTextCircleRadius);
        if (this.mIsMirrored) {
            int n7 = this.mMirroredTextGroup.getMeasuredWidth();
            int n8 = this.mMirroredTextGroup.getMeasuredHeight();
            this.mTextCircleRadius = (float)Math.max((double)(Math.sqrt((double)(Math.pow((double)n7, (double)2.0) + Math.pow((double)n8, (double)2.0))) / 2.0), (double)this.mTextCircleRadius);
        }
        if (this.mArrowMode == -1) {
            this.adjustArrowMode();
            return;
        }
        this.arrowLayout();
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int n = (int)motionEvent.getX();
        int n2 = (int)motionEvent.getY();
        int n3 = this.mAnchorLocationX;
        Rect rect = new Rect(n3, this.mAnchorLocationY, n3 + this.mAnchor.getWidth(), this.mAnchorLocationY + this.mAnchor.getHeight());
        if (motionEvent.getAction() == 0 && rect.contains(n, n2)) {
            this.mAnchor.callOnClick();
            return true;
        }
        this.mGuidePopupWindow.dismiss(true);
        return true;
    }

    public void setAnchor(View view) {
        this.mAnchor = view;
        this.mAnchorWidth = this.mAnchor.getWidth();
        this.mAnchorHeight = this.mAnchor.getHeight();
        int[] arrn = new int[2];
        this.mAnchor.getLocationInWindow(arrn);
        this.mAnchorLocationX = arrn[0];
        this.mAnchorLocationY = arrn[1];
    }

    public void setArrowMode(int n) {
        this.mArrowMode = n;
    }

    public void setArrowMode(int n, boolean bl) {
        this.setArrowMode(n);
        this.mIsMirrored = bl;
        if (this.mIsMirrored) {
            this.mMirroredTextGroup.setVisibility(0);
            return;
        }
        this.mMirroredTextGroup.setVisibility(8);
    }

    public void setGuidePopupWindow(GuidePopupWindow guidePopupWindow) {
        this.mGuidePopupWindow = guidePopupWindow;
    }

    public void setOffset(int n, int n2) {
        this.mOffsetX = n;
        this.mOffsetY = n2;
        this.mUseDefaultOffset = false;
    }

    public void setTouchInterceptor(View.OnTouchListener onTouchListener) {
        this.mTouchInterceptor = onTouchListener;
    }

    class WrapperOnClickListener
    implements View.OnClickListener {
        public View.OnClickListener mOnClickListener;

        WrapperOnClickListener() {
        }

        public void onClick(View view) {
            View.OnClickListener onClickListener = this.mOnClickListener;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            GuidePopupView.this.mGuidePopupWindow.dismiss(true);
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.mOnClickListener = onClickListener;
        }
    }

}

