/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.Bitmap
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.Rect
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.graphics.drawable.StateListDrawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.TypedValue
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.ViewConfiguration
 *  android.view.ViewGroup
 *  android.view.ViewParent
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 *  androidx.appcompat.widget.ViewUtils
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  miuix.animation.physics.DynamicAnimation
 *  miuix.animation.physics.DynamicAnimation$OnAnimationEndListener
 *  miuix.animation.physics.DynamicAnimation$OnAnimationUpdateListener
 *  miuix.animation.physics.SpringAnimation
 *  miuix.animation.physics.SpringForce
 *  miuix.animation.property.FloatProperty
 *  miuix.slidingwidget.widget.-$
 *  miuix.slidingwidget.widget.-$$Lambda
 *  miuix.slidingwidget.widget.-$$Lambda$SlidingButtonHelper
 *  miuix.slidingwidget.widget.-$$Lambda$SlidingButtonHelper$ghp6DeaizEaJp08eI69vcSyB-yE
 *  miuix.slidingwidget.widget.SlidingButtonHelper$1
 *  miuix.slidingwidget.widget.SlidingButtonHelper$2
 *  miuix.slidingwidget.widget.SlidingButtonHelper$3
 *  miuix.slidingwidget.widget.SlidingButtonHelper$4
 *  miuix.slidingwidget.widget.SlidingButtonHelper$5
 *  miuix.slidingwidget.widget.SlidingButtonHelper$6
 *  miuix.slidingwidget.widget.SlidingButtonHelper$7
 *  miuix.smooth.SmoothContainerDrawable
 *  miuix.view.HapticCompat
 *  miuix.view.HapticFeedbackConstants
 */
package miuix.slidingwidget.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.CompoundButton;
import androidx.appcompat.widget.ViewUtils;
import miuix.animation.physics.DynamicAnimation;
import miuix.animation.physics.SpringAnimation;
import miuix.animation.physics.SpringForce;
import miuix.animation.property.FloatProperty;
import miuix.slidingwidget.R;
import miuix.slidingwidget.widget.-$;
import miuix.slidingwidget.widget.SlidingButtonHelper;
import miuix.smooth.SmoothContainerDrawable;
import miuix.view.HapticCompat;
import miuix.view.HapticFeedbackConstants;

public class SlidingButtonHelper {
    private static final int[] CHECKED_STATE_SET = new int[]{16842912};
    public static final int FULL_ALPHA = 255;
    private boolean mAnimChecked;
    private boolean mAnimCheckedTemp = false;
    private int mCornerRadius;
    private float mExtraAlpha = 1.0f;
    private int mHeight;
    private DynamicAnimation.OnAnimationUpdateListener mInvalidateUpdateListener = new -$.Lambda.SlidingButtonHelper.ghp6DeaizEaJp08eI69vcSyB-yE(this);
    private boolean mIsSliderEdgeReached = false;
    private int mLastX;
    private int mMarginVertical;
    private SpringAnimation mMarkedAlphaHideAnim;
    private SpringAnimation mMarkedAlphaShowAnim;
    private Drawable mMaskCheckedSlideBar;
    private float mMaskCheckedSlideBarAlpha = 1.0f;
    private FloatProperty<CompoundButton> mMaskCheckedSlideBarAlphaProperty = new 5(this, "MaskCheckedSlideBarAlpha");
    private float mMaskCheckedSlideBarAlphaTemp = -1.0f;
    private Drawable mMaskUnCheckedPressedSlideBar;
    private float mMaskUnCheckedPressedSlideBarAlpha = 0.0f;
    private FloatProperty<CompoundButton> mMaskUnCheckedPressedSlideBarAlphaProperty = new 6(this, "MaskUnCheckedSlideBarAlpha");
    private Drawable mMaskUnCheckedSlideBar;
    private CompoundButton.OnCheckedChangeListener mOnPerformCheckedChangeListener;
    private int mOriginalTouchPointX;
    private boolean mParamCached = false;
    private StateListDrawable mSlideBar;
    private int mSliderHeight;
    private SpringAnimation mSliderMoveAnim;
    private boolean mSliderMoved;
    private Drawable mSliderOff;
    private int mSliderOffset;
    private FloatProperty<CompoundButton> mSliderOffsetProperty = new 1(this, "SliderOffset");
    private int mSliderOffsetTemp = -1;
    private Drawable mSliderOn;
    private int mSliderOnAlpha;
    private int mSliderOnAlphaTemp = -1;
    private int mSliderPositionEnd;
    private int mSliderPositionStart;
    private SpringAnimation mSliderPressedAnim;
    private float mSliderScale = 1.0f;
    private FloatProperty<CompoundButton> mSliderScaleFloatProperty = new 2(this, "SliderScale");
    private Drawable mSliderShadow;
    private float mSliderShadowAlpha = 0.0f;
    private FloatProperty<CompoundButton> mSliderShadowAlphaProperty = new 3(this, "SliderShadowAlpha");
    private SpringAnimation mSliderShadowHideAnim;
    private SpringAnimation mSliderShadowShowAnim;
    private Drawable mSliderStroke;
    private SpringAnimation mSliderUnPressedAnim;
    private int mSliderWidth;
    private int mSlidingBarColor;
    private SpringAnimation mStokeAlphaHideAnim;
    private SpringAnimation mStokeAlphaShowAnim;
    private float mStrokeAlpha = 0.1f;
    private FloatProperty<CompoundButton> mStrokeAlphaProperty = new 4(this, "StrokeAlpha");
    private int mTapThreshold;
    private Rect mTmpRect = new Rect();
    private boolean mTracking;
    private SpringAnimation mUnMarkedPressedAlphaHideAnim;
    private SpringAnimation mUnMarkedPressedAlphaShowAnim;
    private CompoundButton mView;
    private int mWidth;

    public SlidingButtonHelper(CompoundButton compoundButton) {
        this.mView = compoundButton;
        this.mAnimChecked = this.mView.isChecked();
        if (!this.mView.isChecked()) {
            this.mMaskCheckedSlideBarAlpha = 0.0f;
        }
    }

    static /* synthetic */ float access$000(SlidingButtonHelper slidingButtonHelper) {
        return slidingButtonHelper.mSliderScale;
    }

    static /* synthetic */ float access$002(SlidingButtonHelper slidingButtonHelper, float f) {
        slidingButtonHelper.mSliderScale = f;
        return f;
    }

    static /* synthetic */ float access$100(SlidingButtonHelper slidingButtonHelper) {
        return slidingButtonHelper.mSliderShadowAlpha;
    }

    static /* synthetic */ float access$102(SlidingButtonHelper slidingButtonHelper, float f) {
        slidingButtonHelper.mSliderShadowAlpha = f;
        return f;
    }

    static /* synthetic */ float access$200(SlidingButtonHelper slidingButtonHelper) {
        return slidingButtonHelper.mStrokeAlpha;
    }

    static /* synthetic */ float access$202(SlidingButtonHelper slidingButtonHelper, float f) {
        slidingButtonHelper.mStrokeAlpha = f;
        return f;
    }

    static /* synthetic */ float access$300(SlidingButtonHelper slidingButtonHelper) {
        return slidingButtonHelper.mMaskCheckedSlideBarAlpha;
    }

    static /* synthetic */ float access$302(SlidingButtonHelper slidingButtonHelper, float f) {
        slidingButtonHelper.mMaskCheckedSlideBarAlpha = f;
        return f;
    }

    static /* synthetic */ float access$400(SlidingButtonHelper slidingButtonHelper) {
        return slidingButtonHelper.mMaskUnCheckedPressedSlideBarAlpha;
    }

    static /* synthetic */ float access$402(SlidingButtonHelper slidingButtonHelper, float f) {
        slidingButtonHelper.mMaskUnCheckedPressedSlideBarAlpha = f;
        return f;
    }

    private void animateToState(boolean bl) {
        if (bl != this.mView.isChecked()) {
            this.mView.setChecked(bl);
            this.startCheckedChangeAnimInternal(bl);
            this.notifyCheckedChangeListener();
        }
        int n = bl ? this.mSliderPositionEnd : this.mSliderPositionStart;
        this.animateToState(bl, n, new Runnable(){

            public void run() {
                SlidingButtonHelper slidingButtonHelper = SlidingButtonHelper.this;
                boolean bl = slidingButtonHelper.mSliderOffset >= SlidingButtonHelper.this.mSliderPositionEnd;
                slidingButtonHelper.mAnimChecked = bl;
            }
        });
    }

    private void animateToState(boolean bl, int n, Runnable runnable) {
        SpringAnimation springAnimation = this.mSliderMoveAnim;
        if (springAnimation != null && springAnimation.isRunning()) {
            this.mSliderMoveAnim.cancel();
        }
        if (bl != this.mView.isChecked()) {
            return;
        }
        this.mSliderMoveAnim = new SpringAnimation((Object)this.mView, this.mSliderOffsetProperty, (float)n);
        this.mSliderMoveAnim.getSpring().setStiffness(986.96f);
        this.mSliderMoveAnim.getSpring().setDampingRatio(0.7f);
        this.mSliderMoveAnim.addUpdateListener(this.mInvalidateUpdateListener);
        this.mSliderMoveAnim.addEndListener((DynamicAnimation.OnAnimationEndListener)new 7(this, runnable));
        this.mSliderMoveAnim.start();
        if (bl) {
            if (!this.mMarkedAlphaShowAnim.isRunning()) {
                this.mMarkedAlphaShowAnim.start();
            }
            if (this.mMarkedAlphaHideAnim.isRunning()) {
                this.mMarkedAlphaHideAnim.cancel();
                return;
            }
        } else {
            if (!this.mMarkedAlphaHideAnim.isRunning()) {
                this.mMarkedAlphaHideAnim.start();
            }
            if (this.mMarkedAlphaShowAnim.isRunning()) {
                this.mMarkedAlphaShowAnim.cancel();
            }
        }
    }

    private void animateToggle() {
        this.animateToState(true ^ this.mView.isChecked());
        HapticCompat.performHapticFeedback((View)this.mView, (int)HapticFeedbackConstants.MIUI_SWITCH);
    }

    private Drawable createMaskDrawable(Drawable drawable2) {
        SmoothContainerDrawable smoothContainerDrawable = new SmoothContainerDrawable();
        smoothContainerDrawable.setCornerRadius((float)this.mCornerRadius);
        smoothContainerDrawable.setChildDrawable(drawable2);
        int n = this.mMarginVertical;
        smoothContainerDrawable.setBounds(new Rect(0, n, this.mWidth, this.mHeight - n));
        return smoothContainerDrawable;
    }

    private StateListDrawable createMaskedSlideBar() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.setBounds(0, 0, this.mWidth, this.mHeight);
        stateListDrawable.setCallback((Drawable.Callback)this.mView);
        return stateListDrawable;
    }

    private void initMaskedSlideBar(Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        this.mMaskCheckedSlideBar = drawable2;
        this.mMaskUnCheckedSlideBar = drawable3;
        this.mMaskUnCheckedPressedSlideBar = drawable4;
    }

    private void moveSlider(int n) {
        int n2;
        int n3;
        if (ViewUtils.isLayoutRtl((View)this.mView)) {
            n = -n;
        }
        if ((n3 = (this.mSliderOffset = n + this.mSliderOffset)) < (n2 = this.mSliderPositionStart)) {
            this.mSliderOffset = n2;
        } else {
            int n4 = this.mSliderPositionEnd;
            if (n3 > n4) {
                this.mSliderOffset = n4;
            }
        }
        int n5 = this.mSliderOffset;
        boolean bl = n5 == this.mSliderPositionStart || n5 == this.mSliderPositionEnd;
        if (bl && !this.mIsSliderEdgeReached) {
            HapticCompat.performHapticFeedback((View)this.mView, (int)HapticFeedbackConstants.MIUI_SWITCH);
        }
        this.mIsSliderEdgeReached = bl;
        this.setSliderOffset(this.mSliderOffset);
    }

    private void onDrawSlideBar(Canvas canvas, float f) {
        int n;
        int n2;
        int n3 = (int)(f * (255.0f * (1.0f - this.mMaskCheckedSlideBarAlpha)));
        if (n3 > 0) {
            this.mMaskUnCheckedSlideBar.setAlpha(n3);
            this.mMaskUnCheckedSlideBar.draw(canvas);
        }
        if ((n2 = (int)(f * (255.0f * this.mMaskUnCheckedPressedSlideBarAlpha))) > 0) {
            this.mMaskUnCheckedPressedSlideBar.setAlpha(n2);
            this.mMaskUnCheckedPressedSlideBar.draw(canvas);
        }
        if ((n = (int)(f * (255.0f * this.mMaskCheckedSlideBarAlpha))) > 0) {
            this.mMaskCheckedSlideBar.setAlpha(n);
            this.mMaskCheckedSlideBar.draw(canvas);
        }
    }

    private void onDrawSliderShadow(Canvas canvas, int n, int n2) {
        int n3;
        int n4;
        int n5 = (int)(255.0f * this.mSliderShadowAlpha);
        if (n5 == 0) {
            return;
        }
        Drawable drawable2 = this.mSliderShadow;
        if (drawable2 instanceof BitmapDrawable) {
            n4 = ((BitmapDrawable)drawable2).getBitmap().getWidth();
            n3 = ((BitmapDrawable)this.mSliderShadow).getBitmap().getHeight();
        } else {
            n4 = drawable2.getIntrinsicWidth();
            n3 = this.mSliderShadow.getIntrinsicHeight();
        }
        Drawable drawable3 = this.mSliderShadow;
        int n6 = n4 / 2;
        int n7 = n - n6;
        int n8 = n3 / 2;
        drawable3.setBounds(n7, n2 - n8, n + n6, n2 + n8);
        this.mSliderShadow.setAlpha(n5);
        this.mSliderShadow.draw(canvas);
    }

    private void onDrawSliderStroke(Canvas canvas, int n, int n2, int n3, int n4, float f) {
        this.mSliderStroke.setAlpha((int)(f * (255.0f * this.mStrokeAlpha)));
        this.mSliderStroke.setBounds(n, n2, n3, n4);
        this.mSliderStroke.draw(canvas);
    }

    private void onPressedInner() {
        if (this.mSliderUnPressedAnim.isRunning()) {
            this.mSliderUnPressedAnim.cancel();
        }
        if (!this.mSliderPressedAnim.isRunning()) {
            this.mSliderPressedAnim.start();
        }
        if (!this.mSliderShadowShowAnim.isRunning()) {
            this.mSliderShadowShowAnim.start();
        }
        if (!this.mView.isChecked()) {
            if (this.mUnMarkedPressedAlphaHideAnim.isRunning()) {
                this.mUnMarkedPressedAlphaHideAnim.cancel();
            }
            if (!this.mUnMarkedPressedAlphaShowAnim.isRunning()) {
                this.mUnMarkedPressedAlphaShowAnim.start();
            }
            if (!this.mStokeAlphaShowAnim.isRunning()) {
                this.mStokeAlphaShowAnim.start();
            }
        }
    }

    private void onUnPressedInner() {
        if (this.mSliderPressedAnim.isRunning()) {
            this.mSliderPressedAnim.cancel();
        }
        if (!this.mSliderUnPressedAnim.isRunning()) {
            this.mSliderUnPressedAnim.start();
        }
        if (this.mSliderShadowShowAnim.isRunning()) {
            this.mSliderShadowShowAnim.cancel();
        }
        if (!this.mSliderShadowHideAnim.isRunning()) {
            this.mSliderShadowHideAnim.start();
        }
        if (this.mStokeAlphaShowAnim.isRunning()) {
            this.mStokeAlphaShowAnim.cancel();
        }
        if (!this.mView.isChecked()) {
            if (this.mUnMarkedPressedAlphaShowAnim.isRunning()) {
                this.mUnMarkedPressedAlphaShowAnim.cancel();
            }
            if (!this.mUnMarkedPressedAlphaHideAnim.isRunning()) {
                this.mUnMarkedPressedAlphaHideAnim.start();
            }
            if (!this.mStokeAlphaHideAnim.isRunning()) {
                this.mStokeAlphaHideAnim.start();
            }
        }
    }

    private void popSavedParams() {
        if (this.mParamCached) {
            this.mSliderOffset = this.mSliderOffsetTemp;
            this.mSliderOnAlpha = this.mSliderOnAlphaTemp;
            this.mMaskCheckedSlideBarAlpha = this.mMaskCheckedSlideBarAlphaTemp;
            this.mAnimChecked = this.mAnimCheckedTemp;
            this.mParamCached = false;
            this.mSliderOffsetTemp = -1;
            this.mSliderOnAlphaTemp = -1;
            this.mMaskCheckedSlideBarAlphaTemp = -1.0f;
        }
    }

    private void saveCurrentParams() {
        this.mSliderOffsetTemp = this.mSliderOffset;
        this.mSliderOnAlphaTemp = this.mSliderOnAlpha;
        this.mMaskCheckedSlideBarAlphaTemp = this.mMaskCheckedSlideBarAlpha;
        this.mAnimCheckedTemp = this.mAnimChecked;
        this.mParamCached = true;
    }

    private void scaleCanvasEnd(Canvas canvas) {
        canvas.restore();
    }

    private void scaleCanvasStart(Canvas canvas, int n, int n2) {
        canvas.save();
        float f = this.mSliderScale;
        canvas.scale(f, f, (float)n, (float)n2);
    }

    private void setCheckedInner(boolean bl) {
        if (this.mAnimChecked) {
            if (this.mMarkedAlphaHideAnim.isRunning()) {
                this.mMarkedAlphaHideAnim.cancel();
            }
            if (!this.mMarkedAlphaShowAnim.isRunning() && !bl) {
                this.mMaskCheckedSlideBarAlpha = 1.0f;
            }
        }
        if (!this.mAnimChecked) {
            if (this.mMarkedAlphaShowAnim.isRunning()) {
                this.mMarkedAlphaShowAnim.cancel();
            }
            if (!this.mMarkedAlphaHideAnim.isRunning() && bl) {
                this.mMaskCheckedSlideBarAlpha = 0.0f;
            }
        }
    }

    private void startCheckedChangeAnimInternal(boolean bl) {
        SpringAnimation springAnimation = this.mSliderMoveAnim;
        if (springAnimation == null || !springAnimation.isRunning()) {
            int n = this.mAnimChecked ? this.mSliderPositionEnd : this.mSliderPositionStart;
            this.mSliderOffset = n;
            int n2 = this.mAnimChecked ? 255 : 0;
            this.mSliderOnAlpha = n2;
        }
        this.popSavedParams();
        this.setCheckedInner(bl);
    }

    public float getAlpha() {
        return this.mExtraAlpha;
    }

    public int getMeasuredHeight() {
        return this.mHeight;
    }

    public int getMeasuredWidth() {
        return this.mWidth;
    }

    public StateListDrawable getSlideBar() {
        return this.mSlideBar;
    }

    public int getSliderOffset() {
        return this.mSliderOffset;
    }

    public Drawable getSliderOn() {
        return this.mSliderOn;
    }

    public int getSliderOnAlpha() {
        return this.mSliderOnAlpha;
    }

    public void initAnim() {
        this.mSliderPressedAnim = new SpringAnimation((Object)this.mView, this.mSliderScaleFloatProperty, 1.61f);
        this.mSliderPressedAnim.getSpring().setStiffness(986.96f);
        this.mSliderPressedAnim.getSpring().setDampingRatio(0.6f);
        this.mSliderPressedAnim.setMinimumVisibleChange(0.002f);
        this.mSliderPressedAnim.addUpdateListener(this.mInvalidateUpdateListener);
        this.mSliderUnPressedAnim = new SpringAnimation((Object)this.mView, this.mSliderScaleFloatProperty, 1.0f);
        this.mSliderUnPressedAnim.getSpring().setStiffness(986.96f);
        this.mSliderUnPressedAnim.getSpring().setDampingRatio(0.6f);
        this.mSliderUnPressedAnim.setMinimumVisibleChange(0.002f);
        this.mSliderUnPressedAnim.addUpdateListener(this.mInvalidateUpdateListener);
        this.mSliderShadowShowAnim = new SpringAnimation((Object)this.mView, this.mSliderShadowAlphaProperty, 1.0f);
        this.mSliderShadowShowAnim.getSpring().setStiffness(986.96f);
        this.mSliderShadowShowAnim.getSpring().setDampingRatio(0.99f);
        this.mSliderShadowShowAnim.setMinimumVisibleChange(0.00390625f);
        this.mSliderShadowShowAnim.addUpdateListener(this.mInvalidateUpdateListener);
        this.mSliderShadowHideAnim = new SpringAnimation((Object)this.mView, this.mSliderShadowAlphaProperty, 0.0f);
        this.mSliderShadowHideAnim.getSpring().setStiffness(986.96f);
        this.mSliderShadowHideAnim.getSpring().setDampingRatio(0.99f);
        this.mSliderShadowHideAnim.setMinimumVisibleChange(0.00390625f);
        this.mSliderShadowHideAnim.addUpdateListener(this.mInvalidateUpdateListener);
        this.mStokeAlphaShowAnim = new SpringAnimation((Object)this.mView, this.mStrokeAlphaProperty, 0.15f);
        this.mStokeAlphaShowAnim.getSpring().setStiffness(986.96f);
        this.mStokeAlphaShowAnim.getSpring().setDampingRatio(0.99f);
        this.mStokeAlphaShowAnim.setMinimumVisibleChange(0.00390625f);
        this.mStokeAlphaShowAnim.addUpdateListener(this.mInvalidateUpdateListener);
        this.mStokeAlphaHideAnim = new SpringAnimation((Object)this.mView, this.mStrokeAlphaProperty, 0.1f);
        this.mStokeAlphaHideAnim.getSpring().setStiffness(986.96f);
        this.mStokeAlphaHideAnim.getSpring().setDampingRatio(0.99f);
        this.mStokeAlphaHideAnim.setMinimumVisibleChange(0.00390625f);
        this.mStokeAlphaHideAnim.addUpdateListener(this.mInvalidateUpdateListener);
        this.mMarkedAlphaShowAnim = new SpringAnimation((Object)this.mView, this.mMaskCheckedSlideBarAlphaProperty, 1.0f);
        this.mMarkedAlphaShowAnim.getSpring().setStiffness(438.64f);
        this.mMarkedAlphaShowAnim.getSpring().setDampingRatio(0.99f);
        this.mMarkedAlphaShowAnim.setMinimumVisibleChange(0.00390625f);
        this.mMarkedAlphaShowAnim.addUpdateListener(this.mInvalidateUpdateListener);
        this.mMarkedAlphaHideAnim = new SpringAnimation((Object)this.mView, this.mMaskCheckedSlideBarAlphaProperty, 0.0f);
        this.mMarkedAlphaHideAnim.getSpring().setStiffness(986.96f);
        this.mMarkedAlphaHideAnim.getSpring().setDampingRatio(0.99f);
        this.mMarkedAlphaHideAnim.setMinimumVisibleChange(0.00390625f);
        this.mMarkedAlphaHideAnim.addUpdateListener(this.mInvalidateUpdateListener);
        this.mUnMarkedPressedAlphaShowAnim = new SpringAnimation((Object)this.mView, this.mMaskUnCheckedPressedSlideBarAlphaProperty, 0.05f);
        this.mUnMarkedPressedAlphaShowAnim.getSpring().setStiffness(986.96f);
        this.mUnMarkedPressedAlphaShowAnim.getSpring().setDampingRatio(0.99f);
        this.mUnMarkedPressedAlphaShowAnim.setMinimumVisibleChange(0.00390625f);
        this.mUnMarkedPressedAlphaShowAnim.addUpdateListener(this.mInvalidateUpdateListener);
        this.mUnMarkedPressedAlphaHideAnim = new SpringAnimation((Object)this.mView, this.mMaskUnCheckedPressedSlideBarAlphaProperty, 0.0f);
        this.mUnMarkedPressedAlphaHideAnim.getSpring().setStiffness(986.96f);
        this.mUnMarkedPressedAlphaHideAnim.getSpring().setDampingRatio(0.99f);
        this.mUnMarkedPressedAlphaHideAnim.setMinimumVisibleChange(0.00390625f);
        this.mUnMarkedPressedAlphaHideAnim.addUpdateListener(this.mInvalidateUpdateListener);
    }

    public void initDrawable() {
        this.mSliderShadow = this.mView.getResources().getDrawable(R.drawable.miuix_appcompat_sliding_btn_slider_shadow);
        this.mSliderStroke = this.mView.getResources().getDrawable(R.drawable.miuix_appcompat_sliding_btn_slider_stroke_light);
    }

    public void initResource(Context context, TypedArray typedArray) {
        this.mCornerRadius = this.mView.getResources().getDimensionPixelSize(R.dimen.miuix_appcompat_sliding_button_frame_corner_radius);
        this.mMarginVertical = this.mView.getResources().getDimensionPixelSize(R.dimen.miuix_appcompat_sliding_button_mask_vertical_padding);
        this.mView.setDrawingCacheEnabled(false);
        this.mTapThreshold = ViewConfiguration.get((Context)context).getScaledTouchSlop() / 2;
        this.mSliderOn = typedArray.getDrawable(R.styleable.SlidingButton_sliderOn);
        this.mSliderOff = typedArray.getDrawable(R.styleable.SlidingButton_sliderOff);
        this.mView.setBackground(typedArray.getDrawable(R.styleable.SlidingButton_android_background));
        int n = Color.parseColor((String)"#FF0D84FF");
        if (Build.VERSION.SDK_INT >= 23) {
            n = context.getColor(R.color.miuix_appcompat_sliding_button_bar_on_light);
        }
        this.mSlidingBarColor = typedArray.getColor(R.styleable.SlidingButton_slidingBarColor, n);
        int n2 = this.mView.getResources().getDimensionPixelSize(R.dimen.miuix_appcompat_sliding_button_frame_vertical_padding);
        int n3 = this.mView.getResources().getDimensionPixelSize(R.dimen.miuix_appcompat_sliding_button_height);
        this.mWidth = this.mView.getResources().getDimensionPixelSize(R.dimen.miuix_appcompat_sliding_button_width);
        this.mHeight = n3 + n2 * 2;
        this.mSliderWidth = Math.min((int)this.mWidth, (int)this.mSliderOn.getIntrinsicWidth());
        this.mSliderHeight = Math.min((int)this.mHeight, (int)this.mSliderOn.getIntrinsicHeight());
        this.mSliderPositionStart = 0;
        this.mSliderPositionEnd = this.mWidth - this.mSliderWidth;
        this.mSliderOffset = this.mSliderPositionStart;
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(R.styleable.SlidingButton_barOff, typedValue);
        TypedValue typedValue2 = new TypedValue();
        typedArray.getValue(R.styleable.SlidingButton_barOn, typedValue2);
        Drawable drawable2 = typedArray.getDrawable(R.styleable.SlidingButton_barOff);
        Drawable drawable3 = typedArray.getDrawable(R.styleable.SlidingButton_barOn);
        if (typedValue.type == typedValue2.type && typedValue.data == typedValue2.data && typedValue.resourceId == typedValue2.resourceId) {
            drawable3 = drawable2;
        }
        if (drawable3 != null && drawable2 != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                drawable3.setTint(this.mSlidingBarColor);
            }
            this.initMaskedSlideBar(this.createMaskDrawable(drawable3), this.createMaskDrawable(drawable2), this.createMaskDrawable(drawable3));
            this.mSlideBar = this.createMaskedSlideBar();
        }
        this.setSliderDrawState();
        if (this.mView.isChecked()) {
            this.setSliderOffset(this.mSliderPositionEnd);
        }
    }

    public void jumpDrawablesToCurrentState() {
        StateListDrawable stateListDrawable = this.mSlideBar;
        if (stateListDrawable != null) {
            stateListDrawable.jumpToCurrentState();
        }
    }

    public /* synthetic */ void lambda$new$0$SlidingButtonHelper(DynamicAnimation dynamicAnimation, float f, float f2) {
        this.mView.invalidate();
    }

    public void notifyCheckedChangeListener() {
        if (this.mOnPerformCheckedChangeListener != null) {
            boolean bl = this.mView.isChecked();
            this.mOnPerformCheckedChangeListener.onCheckedChanged(this.mView, bl);
        }
    }

    public void onDraw(Canvas canvas) {
        int n = this.mView.isEnabled() ? 255 : 127;
        int n2 = (int)((float)n * this.mExtraAlpha);
        float f = (float)n2 / 255.0f;
        this.onDrawSlideBar(canvas, f);
        boolean bl = ViewUtils.isLayoutRtl((View)this.mView);
        int n3 = bl ? this.mWidth - this.mSliderOffset - this.mSliderWidth : this.mSliderOffset;
        int n4 = n3;
        int n5 = bl ? this.mWidth - this.mSliderOffset : this.mSliderWidth + this.mSliderOffset;
        int n6 = n5;
        int n7 = this.mHeight;
        int n8 = this.mSliderHeight;
        int n9 = (n7 - n8) / 2;
        int n10 = n9 + n8;
        int n11 = (n6 + n4) / 2;
        int n12 = (n10 + n9) / 2;
        this.onDrawSliderShadow(canvas, n11, n12);
        this.scaleCanvasStart(canvas, n11, n12);
        if (this.mAnimChecked) {
            this.mSliderOn.setAlpha(n2);
            this.mSliderOn.setBounds(n4, n9, n6, n10);
            this.mSliderOn.draw(canvas);
        } else {
            this.mSliderOff.setAlpha(n2);
            this.mSliderOff.setBounds(n4, n9, n6, n10);
            this.mSliderOff.draw(canvas);
        }
        this.onDrawSliderStroke(canvas, n4, n9, n6, n10, f);
        this.scaleCanvasEnd(canvas);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void onTouchEvent(MotionEvent motionEvent) {
        boolean bl = motionEvent.getAction();
        int n = (int)motionEvent.getX();
        int n2 = (int)motionEvent.getY();
        Rect rect = this.mTmpRect;
        boolean bl2 = ViewUtils.isLayoutRtl((View)this.mView);
        int n3 = bl2 ? this.mWidth - this.mSliderOffset - this.mSliderWidth : this.mSliderOffset;
        int n4 = bl2 ? this.mWidth - this.mSliderOffset : this.mSliderOffset + this.mSliderWidth;
        rect.set(n3, 0, n4, this.mHeight);
        boolean bl3 = true;
        if (bl) {
            if (bl != bl3) {
                if (!bl) {
                    if (!bl) {
                        return;
                    }
                    this.onUnPressedInner();
                    this.mTracking = false;
                    this.mSliderMoved = false;
                    this.mView.setPressed(false);
                    return;
                }
                if (!this.mTracking) return;
                this.moveSlider(n - this.mLastX);
                this.mLastX = n;
                if (Math.abs((int)(n - this.mOriginalTouchPointX)) < this.mTapThreshold) return;
                this.mSliderMoved = bl3;
                this.mView.getParent().requestDisallowInterceptTouchEvent(bl3);
                return;
            }
            this.onUnPressedInner();
            if (this.mTracking) {
                if (!this.mSliderMoved) {
                    this.animateToggle();
                } else {
                    if (this.mSliderOffset < this.mSliderPositionEnd / 2) {
                        bl3 = false;
                    }
                    this.mAnimChecked = bl3;
                    this.animateToState(this.mAnimChecked);
                    if (rect.contains(n, n2)) {
                        HapticCompat.performHapticFeedback((View)this.mView, (int)HapticFeedbackConstants.MIUI_SWITCH);
                    }
                }
            } else {
                this.animateToggle();
            }
            this.mTracking = false;
            this.mSliderMoved = false;
            this.mView.setPressed(false);
            return;
        }
        if (rect.contains(n, n2)) {
            this.mTracking = bl3;
            this.mView.setPressed(bl3);
            this.onPressedInner();
            int n5 = this.mSliderOffset;
            if (n5 > this.mSliderPositionStart && n5 < this.mSliderPositionEnd) {
                bl3 = false;
            }
            this.mIsSliderEdgeReached = bl3;
        } else {
            this.mTracking = false;
        }
        this.mLastX = n;
        this.mOriginalTouchPointX = n;
        this.mSliderMoved = false;
    }

    public void setAlpha(float f) {
        this.mExtraAlpha = f;
    }

    public void setChecked(boolean bl) {
        this.saveCurrentParams();
        this.mAnimChecked = bl;
        int n = bl ? this.mSliderPositionEnd : this.mSliderPositionStart;
        this.mSliderOffset = n;
        int n2 = bl ? 255 : 0;
        this.mSliderOnAlpha = n2;
        float f = bl ? 1.0f : 0.0f;
        this.mMaskCheckedSlideBarAlpha = f;
        SpringAnimation springAnimation = this.mSliderMoveAnim;
        if (springAnimation != null && springAnimation.isRunning()) {
            this.mSliderMoveAnim.cancel();
        }
        if (this.mMarkedAlphaHideAnim.isRunning()) {
            this.mMarkedAlphaHideAnim.cancel();
        }
        if (this.mMarkedAlphaShowAnim.isRunning()) {
            this.mMarkedAlphaShowAnim.cancel();
        }
        this.mView.invalidate();
    }

    public void setOnPerformCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.mOnPerformCheckedChangeListener = onCheckedChangeListener;
    }

    public void setParentClipChildren() {
        ViewParent viewParent = this.mView.getParent();
        if (viewParent != null && viewParent instanceof ViewGroup) {
            ((ViewGroup)viewParent).setClipChildren(false);
        }
    }

    public void setSliderDrawState() {
        if (this.getSliderOn() != null) {
            this.getSliderOn().setState(this.mView.getDrawableState());
            this.getSlideBar().setState(this.mView.getDrawableState());
        }
    }

    public void setSliderOffset(int n) {
        this.mSliderOffset = n;
        this.mView.invalidate();
    }

    public void setSliderOnAlpha(int n) {
        this.mSliderOnAlpha = n;
        this.mView.invalidate();
    }

    public boolean verifyDrawable(Drawable drawable2) {
        return drawable2 == this.mSlideBar;
    }

}

