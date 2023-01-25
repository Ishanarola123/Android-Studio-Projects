/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.AnimatorSet
 *  android.animation.ObjectAnimator
 *  android.animation.TimeInterpolator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.Outline
 *  android.graphics.Path
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  android.util.Property
 *  android.util.SparseIntArray
 *  android.view.LayoutInflater
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewOutlineProvider
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnPreDrawListener
 *  android.view.animation.AccelerateDecelerateInterpolator
 *  android.view.animation.AccelerateInterpolator
 *  android.view.animation.AlphaAnimation
 *  android.view.animation.Animation
 *  android.view.animation.Animation$AnimationListener
 *  android.view.animation.AnimationSet
 *  android.view.animation.DecelerateInterpolator
 *  android.view.animation.Interpolator
 *  android.view.animation.ScaleAnimation
 *  android.widget.FrameLayout
 *  android.widget.LinearLayout
 *  androidx.appcompat.widget.AppCompatButton
 *  androidx.appcompat.widget.AppCompatImageView
 *  androidx.appcompat.widget.AppCompatTextView
 *  java.lang.CharSequence
 *  java.lang.Deprecated
 *  java.lang.Float
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 */
package miuix.popupwidget.internal.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Property;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import miuix.internal.util.DeviceHelper;
import miuix.popupwidget.R;
import miuix.popupwidget.widget.ArrowPopupWindow;

public class ArrowPopupView
extends FrameLayout
implements View.OnTouchListener {
    private static final int ANIMATION_REPEAT_COUNT = 8;
    public static final byte ARROW_BOTTOM_LEFT_MODE = 18;
    public static final byte ARROW_BOTTOM_MODE = 16;
    public static final byte ARROW_BOTTOM_RIGHT_MODE = 17;
    public static final byte ARROW_LEFT_MODE = 32;
    public static final byte ARROW_NONE_MODE = 0;
    private static final int ARROW_PADDING = 1;
    public static final byte ARROW_RIGHT_MODE = 64;
    public static final byte ARROW_TOP_LEFT_MODE = 9;
    public static final byte ARROW_TOP_MODE = 8;
    public static final byte ARROW_TOP_RIGHT_MODE = 10;
    private static final String TAG = "ArrowPopupView";
    private static final int TRANSLATION_VALUE = 4;
    private View mAnchor;
    private AnimationSet mAnimationSet;
    private AnimatorSet mAnimator;
    private AppCompatImageView mArrow;
    private Drawable mArrowBottom;
    private Drawable mArrowBottomLeft;
    private Drawable mArrowBottomRight;
    private Drawable mArrowLeft;
    private int mArrowMode = 0;
    private ArrowPopupWindow mArrowPopupWindow;
    private Drawable mArrowRight;
    private int mArrowSpaceLeft;
    private int mArrowSpaceTop;
    private Drawable mArrowTop;
    private Drawable mArrowTopLeft;
    private Drawable mArrowTopRight;
    private Drawable mArrowTopWithTitle;
    private boolean mAutoDismiss = true;
    private Drawable mBackground;
    private Drawable mBackgroundLeft;
    private Drawable mBackgroundRight;
    private FrameLayout mContentFrame;
    private LinearLayout mContentFrameWrapper;
    private Animation.AnimationListener mHideAnimatorListener = new Animation.AnimationListener(){

        public void onAnimationEnd(Animation animation) {
            ArrowPopupView.this.mIsDismissing = false;
            ArrowPopupView.this.mAnimationSet = null;
            ArrowPopupView.this.mArrowPopupWindow.dismiss();
            ArrowPopupView.this.setArrowMode(0);
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    };
    private boolean mIsDismissing;
    private int mMinBorder;
    private AppCompatButton mNegativeButton;
    private WrapperOnClickListener mNegativeClickListener;
    private int mOffsetX;
    private int mOffsetY;
    private AppCompatButton mPositiveButton;
    private WrapperOnClickListener mPositiveClickListener;
    private Animation.AnimationListener mShowAnimationListener = new Animation.AnimationListener(){

        public void onAnimationEnd(Animation animation) {
            ArrowPopupView.this.mAnimationSet = null;
            if (ArrowPopupView.this.mShowingAnimation) {
                ArrowPopupView.this.animateShowing();
            }
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    };
    private boolean mShowingAnimation = false;
    private int mSpaceLeft;
    private int mSpaceTop;
    private Drawable mTitleBackground;
    private LinearLayout mTitleLayout;
    private AppCompatTextView mTitleText;
    private Rect mTmpRect = new Rect();
    private RectF mTmpRectF = new RectF();
    private View.OnTouchListener mTouchInterceptor;
    private int mTranslationValue;

    public ArrowPopupView(Context context) {
        this(context, null);
    }

    public ArrowPopupView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.arrowPopupViewStyle);
    }

    public ArrowPopupView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.ArrowPopupView, n, R.style.Widget_ArrowPopupView_DayNight);
        this.mBackground = typedArray.getDrawable(R.styleable.ArrowPopupView_contentBackground);
        this.mBackgroundLeft = typedArray.getDrawable(R.styleable.ArrowPopupView_backgroundLeft);
        this.mBackgroundRight = typedArray.getDrawable(R.styleable.ArrowPopupView_backgroundRight);
        this.mTitleBackground = typedArray.getDrawable(R.styleable.ArrowPopupView_titleBackground);
        this.mArrowTop = typedArray.getDrawable(R.styleable.ArrowPopupView_topArrow);
        this.mArrowTopWithTitle = typedArray.getDrawable(R.styleable.ArrowPopupView_topArrowWithTitle);
        this.mArrowBottom = typedArray.getDrawable(R.styleable.ArrowPopupView_bottomArrow);
        this.mArrowRight = typedArray.getDrawable(R.styleable.ArrowPopupView_rightArrow);
        this.mArrowLeft = typedArray.getDrawable(R.styleable.ArrowPopupView_leftArrow);
        this.mArrowTopLeft = typedArray.getDrawable(R.styleable.ArrowPopupView_topLeftArrow);
        this.mArrowTopRight = typedArray.getDrawable(R.styleable.ArrowPopupView_topRightArrow);
        this.mArrowBottomRight = typedArray.getDrawable(R.styleable.ArrowPopupView_bottomRightArrow);
        this.mArrowBottomLeft = typedArray.getDrawable(R.styleable.ArrowPopupView_bottomLeftArrow);
        typedArray.recycle();
        this.mMinBorder = context.getResources().getDimensionPixelOffset(R.dimen.miuix_appcompat_arrow_popup_window_min_border);
    }

    private void addShadow(View view, ViewOutlineProvider viewOutlineProvider) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setOutlineProvider(viewOutlineProvider);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            view.setElevation((float)this.getResources().getDimensionPixelSize(R.dimen.miuix_appcompat_arrow_popup_window_elevation));
        }
    }

    private void adjustArrowMode() {
        int n;
        block2 : {
            int[] arrn = new int[2];
            this.mAnchor.getLocationInWindow(arrn);
            int n2 = this.getWidth();
            int n3 = this.getHeight();
            int n4 = this.mContentFrameWrapper.getMeasuredWidth();
            int n5 = this.mContentFrameWrapper.getMeasuredHeight();
            int n6 = this.mAnchor.getHeight();
            int n7 = this.mAnchor.getWidth();
            SparseIntArray sparseIntArray = new SparseIntArray(4);
            int n8 = arrn[1] - n5;
            int n9 = 16;
            sparseIntArray.put(n9, n8);
            sparseIntArray.put(8, n3 - arrn[1] - n6 - n5);
            sparseIntArray.put(64, arrn[0] - n4);
            sparseIntArray.put(32, n2 - arrn[0] - n7 - n4);
            int n10 = Integer.MIN_VALUE;
            for (int i = 0; i < sparseIntArray.size(); ++i) {
                n = sparseIntArray.keyAt(i);
                if (sparseIntArray.get(n) < this.mMinBorder) {
                    if (sparseIntArray.get(n) <= n10) continue;
                    n10 = sparseIntArray.get(n);
                    n9 = n;
                    continue;
                }
                break block2;
            }
            n = n9;
        }
        this.setArrowMode(n);
    }

    private void animateShowing() {
        if (DeviceHelper.isFeatureWholeAnim()) {
            AnimatorSet animatorSet;
            AnimationSet animationSet = this.mAnimationSet;
            if (animationSet != null) {
                animationSet.cancel();
            }
            if ((animatorSet = this.mAnimator) != null) {
                animatorSet.cancel();
            }
            this.mAnimator = new AnimatorSet();
            this.mAnimator.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(){

                public void onAnimationEnd(Animator animator2) {
                    ArrowPopupView.this.mArrowPopupWindow.dismiss();
                }
            });
            float f = 4.0f * this.getContext().getResources().getDisplayMetrics().density;
            Property property = View.TRANSLATION_Y;
            int n = this.mArrowMode;
            if (n != 16) {
                if (n != 32) {
                    if (n == 64) {
                        f = -f;
                        property = View.TRANSLATION_X;
                    }
                } else {
                    property = View.TRANSLATION_X;
                }
            } else {
                f = -f;
            }
            ObjectAnimator objectAnimator = ObjectAnimator.ofFloat((Object)this.mContentFrameWrapper, (Property)property, (float[])new float[]{0.0f, f, 0.0f});
            objectAnimator.setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator());
            objectAnimator.setDuration(1200L);
            if (this.mAutoDismiss) {
                objectAnimator.setRepeatCount(8);
            } else {
                objectAnimator.setRepeatCount(-1);
            }
            objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){

                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ArrowPopupView.this.mTranslationValue = ((Float)valueAnimator.getAnimatedValue()).intValue();
                    int n = Math.abs((int)ArrowPopupView.this.mTranslationValue);
                    ArrowPopupView arrowPopupView = ArrowPopupView.this;
                    arrowPopupView.invalidate(arrowPopupView.mContentFrameWrapper.getLeft() - n, ArrowPopupView.this.mContentFrameWrapper.getTop() - n, n + ArrowPopupView.this.mContentFrameWrapper.getRight(), n + ArrowPopupView.this.mContentFrameWrapper.getBottom());
                }
            });
            ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat((Object)this.mArrow, (Property)property, (float[])new float[]{0.0f, f, 0.0f});
            objectAnimator2.setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator());
            objectAnimator2.setDuration(1200L);
            if (this.mAutoDismiss) {
                objectAnimator2.setRepeatCount(8);
            } else {
                objectAnimator2.setRepeatCount(-1);
            }
            this.mAnimator.playTogether(new Animator[]{objectAnimator, objectAnimator2});
            this.mAnimator.start();
        }
    }

    private void arrowHorizontalLayout() {
        int n;
        int[] arrn = new int[2];
        this.mAnchor.getLocationOnScreen(arrn);
        int n2 = arrn[0];
        int n3 = arrn[1];
        this.getLocationOnScreen(arrn);
        int n4 = this.mAnchor.getWidth();
        int n5 = this.mAnchor.getHeight();
        int n6 = this.getWidth();
        int n7 = this.getHeight();
        int n8 = this.mContentFrameWrapper.getMeasuredWidth() > this.mContentFrameWrapper.getMinimumWidth() ? this.mContentFrameWrapper.getMeasuredWidth() : this.mContentFrameWrapper.getMinimumWidth();
        int n9 = this.mContentFrameWrapper.getMeasuredHeight() > this.mContentFrameWrapper.getMinimumHeight() ? this.mContentFrameWrapper.getMeasuredHeight() : this.mContentFrameWrapper.getMinimumHeight();
        int n10 = this.getArrowWidth();
        int n11 = this.getArrowHeight();
        this.mSpaceTop = n3 + n5 / 2 - arrn[1];
        int n12 = n7 - this.mSpaceTop;
        this.mArrowSpaceTop = n3 + (n5 - n11) / 2 - arrn[1] + (this.mContentFrameWrapper.getPaddingTop() - this.mContentFrameWrapper.getPaddingBottom()) / 2;
        int n13 = n9 / 2;
        int n14 = n9 - n13;
        this.mSpaceLeft = this.getLeft() + this.mOffsetX;
        if (this.isRightMode()) {
            this.mSpaceLeft += n2 - n8 + this.mContentFrameWrapper.getPaddingRight() - n10 - arrn[0];
            n = -1 + (n2 - n10 - arrn[0] + this.mOffsetX);
        } else if (this.isLeftMode()) {
            this.mSpaceLeft += n10 + (n2 + n4 - this.mContentFrameWrapper.getPaddingLeft()) - arrn[0];
            n = 1 + (this.mSpaceLeft + (this.mContentFrameWrapper.getPaddingLeft() - n10));
        } else {
            n = 0;
        }
        int n15 = this.mSpaceTop;
        if (n15 >= n13 && n12 >= n14) {
            this.mSpaceTop = n15 - n13 + this.mOffsetY;
        } else if (n12 < n14) {
            this.mSpaceTop = n7 - n9 + this.mOffsetY;
        } else if (this.mSpaceTop < n13) {
            this.mSpaceTop = this.mOffsetY;
        }
        this.mArrowSpaceTop += this.mOffsetY;
        int n16 = this.mArrowSpaceTop;
        if (n16 < 0) {
            this.mArrowSpaceTop = 0;
        } else if (n16 + n11 > n7) {
            this.mArrowSpaceTop = n16 - (n16 + n11 - n7);
        }
        this.mContentFrameWrapper.layout(Math.max((int)this.mSpaceLeft, (int)0), Math.max((int)this.mSpaceTop, (int)0), Math.min((int)(n8 + this.mSpaceLeft), (int)n6), Math.min((int)(n9 + this.mSpaceTop), (int)n7));
        AppCompatImageView appCompatImageView = this.mArrow;
        int n17 = this.mArrowSpaceTop;
        appCompatImageView.layout(n, n17, n10 + n, n11 + n17);
    }

    private void arrowLayout() {
        if (this.isVerticalMode()) {
            this.arrowVerticalLayout();
        } else {
            this.arrowHorizontalLayout();
        }
        View view = this.getContentView();
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (view.getMeasuredHeight() > this.mContentFrameWrapper.getMeasuredHeight() - this.mTitleLayout.getMeasuredHeight()) {
                layoutParams.height = this.mContentFrameWrapper.getMeasuredHeight() - this.mTitleLayout.getMeasuredHeight();
                view.setLayoutParams(layoutParams);
            } else if (view.getMeasuredWidth() > this.mContentFrameWrapper.getMeasuredWidth()) {
                layoutParams.width = this.mContentFrameWrapper.getMeasuredWidth();
                view.setLayoutParams(layoutParams);
            }
            if (layoutParams.height <= 0 || layoutParams.width <= 0) {
                Log.w((String)TAG, (String)"Invalid LayoutPrams of content view, please check the anchor view");
            }
        }
    }

    private void arrowVerticalLayout() {
        int n;
        int n2 = this.mAnchor.getWidth();
        int n3 = this.mAnchor.getHeight();
        int n4 = this.getWidth();
        int n5 = this.getHeight();
        int n6 = this.mContentFrameWrapper.getMeasuredWidth() > this.mContentFrameWrapper.getMinimumWidth() ? this.mContentFrameWrapper.getMeasuredWidth() : this.mContentFrameWrapper.getMinimumWidth();
        int n7 = this.mContentFrameWrapper.getMeasuredHeight() > this.mContentFrameWrapper.getMinimumHeight() ? this.mContentFrameWrapper.getMeasuredHeight() : this.mContentFrameWrapper.getMinimumHeight();
        int n8 = this.getArrowWidth();
        int n9 = this.getArrowHeight();
        int[] arrn = new int[2];
        this.mAnchor.getLocationOnScreen(arrn);
        int n10 = arrn[0];
        int n11 = arrn[1];
        this.getLocationOnScreen(arrn);
        this.mSpaceLeft = n10 + n2 / 2 - arrn[0];
        int n12 = n4 - this.mSpaceLeft;
        this.mArrowSpaceLeft = n10 + (n2 - n8) / 2 - arrn[0];
        this.mSpaceTop = this.getTop() + this.mOffsetY;
        if (this.isBottomMode()) {
            this.mSpaceTop += n11 - arrn[1] - n7 + (this.mContentFrameWrapper.getPaddingBottom() - n9);
            n = -1 + (n11 - arrn[1] - n9 + this.mOffsetY);
        } else if (this.isTopMode()) {
            this.mSpaceTop += n9 + (n11 + n3 - arrn[1] - this.mContentFrameWrapper.getPaddingTop());
            n = 1 + (this.mSpaceTop + (this.mContentFrameWrapper.getPaddingTop() - n9));
        } else {
            n = 0;
        }
        int n13 = n6 / 2;
        int n14 = n6 - n13;
        int n15 = this.mSpaceLeft;
        if (n15 >= n13 && n12 >= n14) {
            this.mSpaceLeft = n15 - n13;
        } else if (n12 < n14) {
            this.mSpaceLeft = n4 - n6;
        } else if (this.mSpaceLeft < n13) {
            this.mSpaceLeft = 0;
        }
        int n16 = this.mSpaceLeft;
        int n17 = this.mOffsetX;
        this.mSpaceLeft = n16 + n17;
        int n18 = this.mArrowSpaceLeft = n17 + this.mArrowSpaceLeft;
        if (n18 < 0) {
            this.mArrowSpaceLeft = 0;
        } else if (n18 + n8 > n4) {
            this.mArrowSpaceLeft = n18 - (n18 + n8 - n4);
        }
        this.mContentFrameWrapper.layout(Math.max((int)this.mSpaceLeft, (int)0), Math.max((int)this.mSpaceTop, (int)0), Math.min((int)(n6 + this.mSpaceLeft), (int)n4), Math.min((int)(n7 + this.mSpaceTop), (int)n5));
        this.executeLayoutArrow(n8, n9, n);
    }

    private void executeLayoutArrow(int n, int n2, int n3) {
        int n4;
        int n5;
        block4 : {
            int n6;
            int n7;
            block6 : {
                block0 : {
                    block1 : {
                        int n8;
                        block5 : {
                            block2 : {
                                block3 : {
                                    int n9 = this.mArrowMode;
                                    if (n9 == 9) break block0;
                                    if (n9 == 10) break block1;
                                    if (n9 == 17) break block2;
                                    if (n9 == 18) break block3;
                                    n5 = this.mArrowSpaceLeft;
                                    n4 = n3;
                                    break block4;
                                }
                                n5 = this.mContentFrameWrapper.getLeft() + this.mContentFrameWrapper.getPaddingStart();
                                n8 = this.mContentFrameWrapper.getBottom() - this.mContentFrameWrapper.getPaddingBottom() - (this.mArrow.getMeasuredHeight() - n2);
                                AppCompatImageView appCompatImageView = this.mArrow;
                                appCompatImageView.layout(n5, n8, n5 + n, n8 + appCompatImageView.getMeasuredHeight());
                                break block5;
                            }
                            n5 = this.mContentFrameWrapper.getRight() - this.mContentFrameWrapper.getPaddingEnd() - n;
                            n8 = this.mContentFrameWrapper.getBottom() - this.mContentFrameWrapper.getPaddingBottom() - (this.mArrow.getMeasuredHeight() - n2);
                        }
                        n4 = n8 - 5;
                        break block4;
                    }
                    n7 = 1 + (this.mContentFrameWrapper.getRight() - this.mContentFrameWrapper.getPaddingEnd() - n);
                    n6 = n3 + this.mContentFrameWrapper.getPaddingTop() - n2;
                    AppCompatImageView appCompatImageView = this.mArrow;
                    appCompatImageView.layout(n7, n6, n7 + n, n6 + appCompatImageView.getMeasuredHeight());
                    break block6;
                }
                n7 = -1 + (this.mContentFrameWrapper.getLeft() + this.mContentFrameWrapper.getPaddingStart());
                n6 = n3 + this.mContentFrameWrapper.getPaddingTop() - n2;
                AppCompatImageView appCompatImageView = this.mArrow;
                appCompatImageView.layout(n7, n6, n7 + n, n6 + appCompatImageView.getMeasuredHeight());
            }
            n4 = n6;
            n5 = n7;
        }
        AppCompatImageView appCompatImageView = this.mArrow;
        appCompatImageView.layout(n5, n4, n + n5, n4 + appCompatImageView.getDrawable().getIntrinsicHeight());
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void getAnimationPivot(float[] var1_1) {
        block13 : {
            block12 : {
                block10 : {
                    block11 : {
                        var2_2 = this.mArrow.getTop();
                        var3_3 = this.mArrow.getBottom();
                        var4_4 = this.mArrow.getLeft();
                        var5_5 = this.mArrow.getRight();
                        var6_6 = this.mArrowMode;
                        if (var6_6 == 32) break block10;
                        if (var6_6 == 64) break block11;
                        switch (var6_6) {
                            default: {
                                switch (var6_6) {
                                    default: {
                                        var7_7 = (var5_5 + var4_4) / 2;
                                        var3_3 = (var3_3 + var2_2) / 2;
                                        break;
                                    }
                                    case 18: {
                                        var7_7 = var4_4;
                                        ** break;
                                    }
                                    case 16: {
                                        var5_5 = (var5_5 + var4_4) / 2;
                                    }
                                    case 17: {
                                        var7_7 = var5_5;
                                        ** break;
lbl23: // 2 sources:
                                        break;
                                    }
                                }
                                break block12;
                            }
                            case 9: {
                                var7_7 = var4_4;
                                ** break;
                            }
                            case 8: {
                                var5_5 = (var5_5 + var4_4) / 2;
                            }
                            case 10: {
                                var7_7 = var5_5;
lbl32: // 2 sources:
                                var8_8 = var2_2;
                                break;
                            }
                        }
                        break block13;
                    }
                    var7_7 = var5_5;
                    var3_3 = (var3_3 + var2_2) / 2;
                    break block12;
                }
                var7_7 = var4_4;
                var3_3 = (var3_3 + var2_2) / 2;
            }
            var8_8 = var3_3;
        }
        var1_1[0] = var7_7;
        var1_1[1] = var8_8;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private int getArrowHeight() {
        int n = this.mArrowMode;
        if (n == 9) return this.mArrowTop.getIntrinsicHeight();
        if (n == 10) return this.mArrowTop.getIntrinsicHeight();
        if (n == 17) return this.mArrowBottom.getIntrinsicHeight();
        if (n == 18) return this.mArrowBottom.getIntrinsicHeight();
        int n2 = this.mArrow.getMeasuredHeight();
        if (n2 != 0) return n2;
        return this.mArrow.getDrawable().getIntrinsicHeight();
    }

    private int getArrowWidth() {
        int n = this.mArrow.getMeasuredWidth();
        if (n == 0) {
            n = this.mArrow.getDrawable().getIntrinsicWidth();
        }
        return n;
    }

    private boolean isBottomMode() {
        return this.isCertainMode(16);
    }

    private boolean isCertainMode(int n) {
        return (n & this.mArrowMode) == n;
    }

    private boolean isLeftMode() {
        return this.isCertainMode(32);
    }

    private boolean isRightMode() {
        return this.isCertainMode(64);
    }

    private boolean isTopMode() {
        return this.isCertainMode(8);
    }

    private boolean isVerticalMode() {
        return this.isTopMode() || this.isBottomMode();
        {
        }
    }

    public void addShadow() {
        if (Build.VERSION.SDK_INT >= 21) {
            this.addShadow((View)this.mArrow, new ViewOutlineProvider(){

                public void getOutline(View view, Outline outline) {
                    if (view.getWidth() != 0) {
                        if (view.getHeight() == 0) {
                            return;
                        }
                        int n = view.getWidth();
                        int n2 = view.getHeight();
                        Rect rect = new Rect(0, 0, n, n2);
                        if (n > n2) {
                            int n3 = (n - n2) / 2;
                            rect.left = n3 + rect.left;
                            rect.right -= n3;
                        } else {
                            int n4 = (n2 - n) / 2;
                            rect.top = n4 + rect.top;
                            rect.bottom -= n4;
                        }
                        Path path = new Path();
                        int n5 = ArrowPopupView.this.mArrowMode;
                        if (n5 != 32) {
                            if (n5 != 64) {
                                switch (n5) {
                                    default: {
                                        break;
                                    }
                                    case 10: {
                                        path.moveTo(0.0f, (float)ArrowPopupView.this.mArrowTop.getIntrinsicHeight());
                                        path.quadTo((float)rect.right, 0.7f * (float)(-ArrowPopupView.this.mArrowTop.getIntrinsicHeight()), (float)rect.right, (float)ArrowPopupView.this.mArrowTop.getIntrinsicHeight());
                                        path.close();
                                        break;
                                    }
                                    case 9: {
                                        path.moveTo(0.0f, (float)ArrowPopupView.this.mArrowTop.getIntrinsicHeight());
                                        path.quadTo(0.0f, 0.7f * (float)(-ArrowPopupView.this.mArrowTop.getIntrinsicHeight()), (float)rect.right, (float)ArrowPopupView.this.mArrowTop.getIntrinsicHeight());
                                        path.close();
                                        break;
                                    }
                                    case 8: {
                                        float f = (float)(rect.right + rect.left) / 2.0f;
                                        path.moveTo((float)rect.left, (float)rect.bottom);
                                        path.quadTo(f, (float)(-rect.height()), (float)rect.right, (float)rect.bottom);
                                        path.close();
                                        break;
                                    }
                                }
                            } else {
                                path.moveTo((float)rect.left, (float)rect.top);
                                float f = (float)(rect.bottom + rect.top) / 2.0f;
                                path.quadTo((float)(rect.right + rect.width()), f, (float)rect.left, (float)rect.bottom);
                                path.close();
                            }
                        } else {
                            path.moveTo((float)rect.right, (float)rect.top);
                            float f = (float)(rect.bottom + rect.top) / 2.0f;
                            path.quadTo((float)(-rect.width()), f, (float)rect.right, (float)rect.bottom);
                        }
                        if (path.isConvex()) {
                            outline.setConvexPath(path);
                            return;
                        }
                        Log.d((String)ArrowPopupView.TAG, (String)"outline path is not convex");
                        outline.setOval(rect);
                    }
                }
            });
            this.addShadow((View)this.mContentFrameWrapper, new ViewOutlineProvider(){

                public void getOutline(View view, Outline outline) {
                    if (view.getWidth() != 0) {
                        if (view.getHeight() == 0) {
                            return;
                        }
                        Rect rect = new Rect(0, 0, view.getWidth(), view.getHeight());
                        rect.bottom -= view.getPaddingBottom();
                        rect.top += view.getPaddingTop();
                        rect.right -= view.getPaddingRight();
                        rect.left += view.getPaddingLeft();
                        outline.setRoundRect(rect, (float)ArrowPopupView.this.getContext().getResources().getDimensionPixelOffset(R.dimen.miuix_appcompat_arrow_popup_view_round_corners));
                    }
                }
            });
        }
    }

    public void animateToDismiss() {
        AnimationSet animationSet;
        if (this.mIsDismissing) {
            return;
        }
        AnimatorSet animatorSet = this.mAnimator;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        if ((animationSet = this.mAnimationSet) != null) {
            animationSet.cancel();
        }
        this.mAnimationSet = new AnimationSet(true);
        float[] arrf = new float[2];
        this.getAnimationPivot(arrf);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.6f, 1.0f, 0.6f, 0, arrf[0], 0, arrf[1]);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        if (DeviceHelper.isFeatureWholeAnim()) {
            scaleAnimation.setDuration(150L);
            alphaAnimation.setDuration(150L);
        } else {
            this.mAnimationSet.setDuration(0L);
        }
        this.mAnimationSet.addAnimation((Animation)scaleAnimation);
        this.mAnimationSet.addAnimation((Animation)alphaAnimation);
        this.mAnimationSet.setAnimationListener(this.mHideAnimatorListener);
        this.mAnimationSet.setInterpolator((Interpolator)new AccelerateInterpolator(2.0f));
        this.startAnimation((Animation)this.mAnimationSet);
    }

    public void animateToShow() {
        this.invalidate();
        this.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener(){

            public boolean onPreDraw() {
                ArrowPopupView.this.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
                if (ArrowPopupView.this.mAnimator != null) {
                    ArrowPopupView.this.mAnimator.cancel();
                }
                if (ArrowPopupView.this.mAnimationSet != null) {
                    ArrowPopupView.this.mAnimationSet.cancel();
                }
                ArrowPopupView.this.mAnimationSet = new AnimationSet(true);
                float[] arrf = new float[2];
                ArrowPopupView.this.getAnimationPivot(arrf);
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.6f, 1.0f, 0.6f, 1.0f, 0, arrf[0], 0, arrf[1]);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                if (DeviceHelper.isFeatureWholeAnim()) {
                    scaleAnimation.setDuration(280L);
                    alphaAnimation.setDuration(280L);
                } else {
                    ArrowPopupView.this.mAnimationSet.setDuration(0L);
                }
                ArrowPopupView.this.mAnimationSet.addAnimation((Animation)scaleAnimation);
                ArrowPopupView.this.mAnimationSet.addAnimation((Animation)alphaAnimation);
                ArrowPopupView.this.mAnimationSet.setAnimationListener(ArrowPopupView.this.mShowAnimationListener);
                ArrowPopupView.this.mAnimationSet.setInterpolator((Interpolator)new DecelerateInterpolator(2.0f));
                ArrowPopupView arrowPopupView = ArrowPopupView.this;
                arrowPopupView.startAnimation((Animation)arrowPopupView.mAnimationSet);
                return true;
            }
        });
    }

    public void enableShowingAnimation(boolean bl) {
        this.mShowingAnimation = bl;
    }

    public int getArrowMode() {
        return this.mArrowMode;
    }

    public View getContentView() {
        if (this.mContentFrame.getChildCount() > 0) {
            return this.mContentFrame.getChildAt(0);
        }
        return null;
    }

    public AppCompatButton getNegativeButton() {
        return this.mNegativeButton;
    }

    public AppCompatButton getPositiveButton() {
        return this.mPositiveButton;
    }

    @Deprecated
    public float getRollingPercent() {
        return 1.0f;
    }

    protected void onDraw(Canvas canvas) {
        int n;
        int n2;
        int n3;
        int n4;
        float f;
        block9 : {
            block6 : {
                int n5;
                int n6;
                block10 : {
                    block7 : {
                        block8 : {
                            if (this.mBackground != null) {
                                return;
                            }
                            n3 = this.mSpaceLeft + this.mContentFrameWrapper.getWidth() / 2;
                            n2 = this.mSpaceTop + this.mContentFrameWrapper.getHeight() / 2;
                            int n7 = this.mArrowMode;
                            if (n7 == 8) break block6;
                            if (n7 == 16) break block7;
                            if (n7 == 32) break block8;
                            if (n7 != 64) {
                                f = 0.0f;
                                n4 = 0;
                                n = 0;
                            } else {
                                f = 90.0f;
                                int n8 = this.mArrowSpaceTop + this.mArrow.getMeasuredHeight() / 2;
                                n = n8 - this.mSpaceTop;
                                n4 = this.mContentFrameWrapper.getBottom() - n8;
                            }
                            break block9;
                        }
                        f = -90.0f;
                        n6 = this.mArrowSpaceTop + this.mArrow.getMeasuredHeight() / 2;
                        n = this.mContentFrameWrapper.getBottom() - n6;
                        n5 = this.mSpaceTop;
                        break block10;
                    }
                    f = 180.0f;
                    n6 = this.mArrowSpaceLeft + this.mArrow.getMeasuredWidth() / 2;
                    n = this.mContentFrameWrapper.getRight() - n6;
                    n5 = this.mSpaceLeft;
                }
                n4 = n6 - n5;
                break block9;
            }
            int n9 = this.mArrowSpaceLeft + this.mArrow.getMeasuredWidth() / 2;
            int n10 = n9 - this.mSpaceLeft;
            int n11 = this.mContentFrameWrapper.getRight() - n9;
            n = n10;
            n4 = n11;
            f = 0.0f;
        }
        int n12 = canvas.save();
        canvas.rotate(f, (float)n3, (float)n2);
        int n13 = this.mArrowMode;
        if (n13 != 8 && n13 != 16) {
            if (n13 == 32 || n13 == 64) {
                canvas.translate((float)(n3 - this.mContentFrameWrapper.getHeight() / 2), (float)(n2 - this.mContentFrameWrapper.getWidth() / 2));
                this.mBackgroundLeft.setBounds(0, 0, n, this.mContentFrameWrapper.getWidth());
                int n14 = this.isLeftMode() ? this.mTranslationValue : -this.mTranslationValue;
                canvas.translate(0.0f, (float)n14);
                this.mBackgroundLeft.draw(canvas);
                canvas.translate((float)n, 0.0f);
                this.mBackgroundRight.setBounds(0, 0, n4, this.mContentFrameWrapper.getWidth());
                this.mBackgroundRight.draw(canvas);
            }
        } else {
            canvas.translate((float)this.mSpaceLeft, (float)this.mSpaceTop);
            this.mBackgroundLeft.setBounds(0, 0, n, this.mContentFrameWrapper.getHeight());
            int n15 = this.isTopMode() ? this.mTranslationValue : -this.mTranslationValue;
            canvas.translate(0.0f, (float)n15);
            this.mBackgroundLeft.draw(canvas);
            canvas.translate((float)n, 0.0f);
            this.mBackgroundRight.setBounds(0, 0, n4, this.mContentFrameWrapper.getHeight());
            this.mBackgroundRight.draw(canvas);
        }
        canvas.restoreToCount(n12);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mArrow = (AppCompatImageView)this.findViewById(R.id.popup_arrow);
        this.mContentFrame = (FrameLayout)this.findViewById(16908290);
        this.mContentFrameWrapper = (LinearLayout)this.findViewById(R.id.content_wrapper);
        this.mContentFrameWrapper.setBackground(this.mBackground);
        int n = this.getContext().getResources().getDimensionPixelOffset(R.dimen.miuix_appcompat_arrow_popup_view_min_height);
        this.mContentFrameWrapper.setMinimumHeight(n);
        if (this.mBackgroundLeft != null && this.mBackgroundRight != null) {
            Rect rect = new Rect();
            this.mBackgroundLeft.getPadding(rect);
            this.mContentFrameWrapper.setPadding(rect.top, rect.top, rect.top, rect.top);
        }
        this.mTitleLayout = (LinearLayout)this.findViewById(R.id.title_layout);
        this.mTitleLayout.setBackground(this.mTitleBackground);
        this.mTitleText = (AppCompatTextView)this.findViewById(16908310);
        this.mPositiveButton = (AppCompatButton)this.findViewById(16908314);
        this.mNegativeButton = (AppCompatButton)this.findViewById(16908313);
        this.mPositiveClickListener = new WrapperOnClickListener();
        this.mNegativeClickListener = new WrapperOnClickListener();
        this.mPositiveButton.setOnClickListener((View.OnClickListener)this.mPositiveClickListener);
        this.mNegativeButton.setOnClickListener((View.OnClickListener)this.mNegativeClickListener);
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        if (!this.mAnchor.isAttachedToWindow()) {
            if (this.mArrowPopupWindow.isShowing()) {
                this.mArrowPopupWindow.dismiss();
            }
            return;
        }
        if (this.mArrowMode == 0) {
            this.adjustArrowMode();
        }
        this.arrowLayout();
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int n = (int)motionEvent.getX();
        int n2 = (int)motionEvent.getY();
        Rect rect = this.mTmpRect;
        this.mContentFrameWrapper.getHitRect(rect);
        if (motionEvent.getAction() == 0 && !rect.contains(n, n2)) {
            this.mArrowPopupWindow.dismiss(true);
            return true;
        }
        View.OnTouchListener onTouchListener = this.mTouchInterceptor;
        return onTouchListener != null && onTouchListener.onTouch(view, motionEvent);
    }

    public void setAnchor(View view) {
        this.mAnchor = view;
    }

    public void setArrowMode(int n) {
        this.mArrowMode = n;
        if (n != 32) {
            if (n != 64) {
                switch (n) {
                    default: {
                        switch (n) {
                            default: {
                                return;
                            }
                            case 18: {
                                this.mArrow.setImageDrawable(this.mArrowBottomLeft);
                                return;
                            }
                            case 17: {
                                this.mArrow.setImageDrawable(this.mArrowBottomRight);
                                return;
                            }
                            case 16: 
                        }
                        this.mArrow.setImageDrawable(this.mArrowBottom);
                        return;
                    }
                    case 10: {
                        this.mArrow.setImageDrawable(this.mArrowTopRight);
                        return;
                    }
                    case 9: {
                        this.mArrow.setImageDrawable(this.mArrowTopLeft);
                        return;
                    }
                    case 8: 
                }
                AppCompatImageView appCompatImageView = this.mArrow;
                Drawable drawable2 = this.mTitleLayout.getVisibility() == 0 ? this.mArrowTopWithTitle : this.mArrowTop;
                appCompatImageView.setImageDrawable(drawable2);
                return;
            }
            this.mArrow.setImageDrawable(this.mArrowRight);
            return;
        }
        this.mArrow.setImageDrawable(this.mArrowLeft);
    }

    public void setArrowPopupWindow(ArrowPopupWindow arrowPopupWindow) {
        this.mArrowPopupWindow = arrowPopupWindow;
    }

    public void setAutoDismiss(boolean bl) {
        this.mAutoDismiss = bl;
    }

    public void setContentView(int n) {
        this.setContentView(LayoutInflater.from((Context)this.getContext()).inflate(n, null));
    }

    public void setContentView(View view) {
        this.setContentView(view, new ViewGroup.LayoutParams(-2, -2));
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.mContentFrame.removeAllViews();
        if (view != null) {
            this.mContentFrame.addView(view, layoutParams);
        }
    }

    public void setNegativeButton(CharSequence charSequence, View.OnClickListener onClickListener) {
        this.mNegativeButton.setText(charSequence);
        AppCompatButton appCompatButton = this.mNegativeButton;
        int n = TextUtils.isEmpty((CharSequence)charSequence) ? 8 : 0;
        appCompatButton.setVisibility(n);
        this.mNegativeClickListener.setOnClickListener(onClickListener);
    }

    public void setOffset(int n, int n2) {
        this.mOffsetX = n;
        this.mOffsetY = n2;
    }

    public void setPositiveButton(CharSequence charSequence, View.OnClickListener onClickListener) {
        this.mPositiveButton.setText(charSequence);
        AppCompatButton appCompatButton = this.mPositiveButton;
        int n = TextUtils.isEmpty((CharSequence)charSequence) ? 8 : 0;
        appCompatButton.setVisibility(n);
        this.mPositiveClickListener.setOnClickListener(onClickListener);
    }

    @Deprecated
    public void setRollingPercent(float f) {
    }

    public void setTitle(CharSequence charSequence) {
        LinearLayout linearLayout = this.mTitleLayout;
        int n = TextUtils.isEmpty((CharSequence)charSequence) ? 8 : 0;
        linearLayout.setVisibility(n);
        this.mTitleText.setText(charSequence);
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
            ArrowPopupView.this.mArrowPopupWindow.dismiss(true);
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.mOnClickListener = onClickListener;
        }
    }

}

