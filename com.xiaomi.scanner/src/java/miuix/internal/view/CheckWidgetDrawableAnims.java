/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Rect
 *  android.os.Handler
 *  android.os.Looper
 *  androidx.annotation.RequiresApi
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Thread
 *  miuix.animation.physics.DynamicAnimation
 *  miuix.animation.physics.DynamicAnimation$OnAnimationUpdateListener
 *  miuix.animation.physics.SpringAnimation
 *  miuix.animation.physics.SpringForce
 *  miuix.animation.property.FloatProperty
 *  miuix.internal.view.-$
 *  miuix.internal.view.-$$Lambda
 *  miuix.internal.view.-$$Lambda$CheckWidgetDrawableAnims
 *  miuix.internal.view.-$$Lambda$CheckWidgetDrawableAnims$NuChNJz4Ieoz-NWofqv7giiDpRA
 *  miuix.internal.view.CheckBoxAnimatedStateListDrawable
 *  miuix.internal.view.CheckWidgetDrawableAnims$1
 *  miuix.internal.view.CheckWidgetDrawableAnims$2
 *  miuix.internal.view.CheckWidgetDrawableAnims$3
 *  miuix.internal.view.CheckWidgetDrawableAnims$4
 *  miuix.internal.view.CheckWidgetDrawableAnims$5
 *  miuix.internal.view.CheckWidgetDrawableAnims$6
 */
package miuix.internal.view;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.RequiresApi;
import miuix.animation.physics.DynamicAnimation;
import miuix.animation.physics.SpringAnimation;
import miuix.animation.physics.SpringForce;
import miuix.animation.property.FloatProperty;
import miuix.internal.view.-$;
import miuix.internal.view.CheckBoxAnimatedStateListDrawable;
import miuix.internal.view.CheckWidgetCircleDrawable;
import miuix.internal.view.CheckWidgetDrawableAnims;

@RequiresApi(api=21)
public class CheckWidgetDrawableAnims {
    private static final int FULL_ALPHA = 255;
    private static final float HIGH_STIFFNESS = 986.96f;
    private int mBackgroundDisableAlpha;
    private int mBackgroundNormalAlpha;
    private CheckWidgetCircleDrawable mBlackDrawable;
    private CheckWidgetCircleDrawable mBlueDrawable;
    private FloatProperty<CheckWidgetCircleDrawable> mCircleAlphaFloatProperty = new 5(this, "Alpha");
    private CheckWidgetCircleDrawable mGrayDrawable;
    private boolean mIsSingleSelection = false;
    private CheckBoxAnimatedStateListDrawable mParent;
    private SpringAnimation mParentCheckedUnPressScaleAnim;
    private FloatProperty<CheckBoxAnimatedStateListDrawable> mParentContentAlphaFloatProperty = new 3(this, "ContentAlpha");
    private DynamicAnimation.OnAnimationUpdateListener mParentInvalidListener = new -$.Lambda.CheckWidgetDrawableAnims.NuChNJz4Ieoz-NWofqv7giiDpRA(this);
    private SpringAnimation mParentPressAnim;
    private FloatProperty<CheckBoxAnimatedStateListDrawable> mParentScaleFloatProperty = new 2(this, "Scale");
    private DynamicAnimation.OnAnimationUpdateListener mParentScaleInvalidListener = new 1(this);
    private SpringAnimation mParentUnCheckedUnPressScaleAnim;
    private SpringAnimation mParentUnPressAlphaAnim;
    private SpringAnimation mPressedBlackAnim;
    private SpringAnimation mPressedScaleAnim;
    private float mScale = 1.0f;
    private SpringAnimation mUnPressedBlackAnim;
    private SpringAnimation mUnPressedBlueHideAnim;
    private SpringAnimation mUnPressedBlueShowAnim;
    private FloatProperty<CheckWidgetDrawableAnims> scaleFloatProperty = new 4(this, "Scale");
    private SpringAnimation unPressedScaleAnim;

    public CheckWidgetDrawableAnims(CheckBoxAnimatedStateListDrawable checkBoxAnimatedStateListDrawable, boolean bl, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        CheckWidgetCircleDrawable checkWidgetCircleDrawable;
        this.mBackgroundNormalAlpha = n4;
        this.mBackgroundDisableAlpha = n5;
        this.mIsSingleSelection = bl;
        this.mGrayDrawable = checkWidgetCircleDrawable = new CheckWidgetCircleDrawable(n, n4, n5, n6, n7, n8);
        this.mGrayDrawable.setAlpha(this.mBackgroundNormalAlpha);
        this.mBlackDrawable = new CheckWidgetCircleDrawable(n2, n4, n5);
        this.mBlackDrawable.setAlpha(0);
        this.mBlueDrawable = new CheckWidgetCircleDrawable(n3, n4, n5);
        this.mBlueDrawable.setAlpha(255);
        this.mParent = checkBoxAnimatedStateListDrawable;
        this.initAnim();
    }

    static /* synthetic */ CheckBoxAnimatedStateListDrawable access$000(CheckWidgetDrawableAnims checkWidgetDrawableAnims) {
        return checkWidgetDrawableAnims.mParent;
    }

    private void initAnim() {
        this.mPressedScaleAnim = new SpringAnimation((Object)this, this.scaleFloatProperty, 0.6f);
        this.mPressedScaleAnim.getSpring().setStiffness(986.96f);
        this.mPressedScaleAnim.getSpring().setDampingRatio(0.99f);
        this.mPressedScaleAnim.getSpring().setFinalPosition(0.6f);
        this.mPressedScaleAnim.setMinimumVisibleChange(0.002f);
        this.mPressedScaleAnim.addUpdateListener(this.mParentScaleInvalidListener);
        this.unPressedScaleAnim = new SpringAnimation((Object)this, this.scaleFloatProperty, 1.0f);
        this.unPressedScaleAnim.getSpring().setStiffness(986.96f);
        this.unPressedScaleAnim.getSpring().setDampingRatio(0.6f);
        this.unPressedScaleAnim.setMinimumVisibleChange(0.002f);
        this.unPressedScaleAnim.addUpdateListener((DynamicAnimation.OnAnimationUpdateListener)new 6(this));
        this.mParentPressAnim = new SpringAnimation((Object)this.mParent, this.mParentContentAlphaFloatProperty, 0.5f);
        this.mParentPressAnim.getSpring().setStiffness(986.96f);
        this.mParentPressAnim.getSpring().setDampingRatio(0.99f);
        this.mParentPressAnim.setMinimumVisibleChange(0.00390625f);
        this.mParentPressAnim.addUpdateListener(this.mParentInvalidListener);
        this.mPressedBlackAnim = new SpringAnimation((Object)this.mBlackDrawable, this.mCircleAlphaFloatProperty, 0.1f);
        this.mPressedBlackAnim.getSpring().setStiffness(986.96f);
        this.mPressedBlackAnim.getSpring().setDampingRatio(0.99f);
        this.mPressedBlackAnim.setMinimumVisibleChange(0.00390625f);
        this.mPressedBlackAnim.addUpdateListener(this.mParentInvalidListener);
        this.mUnPressedBlackAnim = new SpringAnimation((Object)this.mBlackDrawable, this.mCircleAlphaFloatProperty, 0.0f);
        this.mUnPressedBlackAnim.getSpring().setStiffness(986.96f);
        this.mUnPressedBlackAnim.getSpring().setDampingRatio(0.99f);
        this.mUnPressedBlackAnim.setMinimumVisibleChange(0.00390625f);
        this.mUnPressedBlackAnim.addUpdateListener(this.mParentInvalidListener);
        this.mUnPressedBlueShowAnim = new SpringAnimation((Object)this.mBlueDrawable, this.mCircleAlphaFloatProperty, 1.0f);
        this.mUnPressedBlueShowAnim.getSpring().setStiffness(986.96f);
        this.mUnPressedBlueShowAnim.getSpring().setDampingRatio(0.7f);
        this.mUnPressedBlueShowAnim.setMinimumVisibleChange(0.00390625f);
        this.mUnPressedBlueShowAnim.addUpdateListener(this.mParentInvalidListener);
        this.mParentUnPressAlphaAnim = new SpringAnimation((Object)this.mParent, this.mParentContentAlphaFloatProperty, 1.0f);
        this.mParentUnPressAlphaAnim.getSpring().setStiffness(438.64f);
        this.mParentUnPressAlphaAnim.getSpring().setDampingRatio(0.6f);
        this.mParentUnPressAlphaAnim.setMinimumVisibleChange(0.00390625f);
        this.mParentUnPressAlphaAnim.addUpdateListener(this.mParentInvalidListener);
        this.mUnPressedBlueHideAnim = new SpringAnimation((Object)this.mBlueDrawable, this.mCircleAlphaFloatProperty, 0.0f);
        this.mUnPressedBlueHideAnim.getSpring().setStiffness(986.96f);
        this.mUnPressedBlueHideAnim.getSpring().setDampingRatio(0.99f);
        this.mUnPressedBlueHideAnim.setMinimumVisibleChange(0.00390625f);
        this.mUnPressedBlueHideAnim.addUpdateListener(this.mParentInvalidListener);
        this.mParentCheckedUnPressScaleAnim = new SpringAnimation((Object)this.mParent, this.mParentScaleFloatProperty, 1.0f);
        this.mParentCheckedUnPressScaleAnim.getSpring().setStiffness(438.64f);
        this.mParentCheckedUnPressScaleAnim.getSpring().setDampingRatio(0.6f);
        this.mParentCheckedUnPressScaleAnim.setMinimumVisibleChange(0.002f);
        this.mParentCheckedUnPressScaleAnim.addUpdateListener(this.mParentInvalidListener);
        if (this.mIsSingleSelection) {
            this.mParentCheckedUnPressScaleAnim.setStartVelocity(5.0f);
        } else {
            this.mParentCheckedUnPressScaleAnim.setStartVelocity(10.0f);
        }
        this.mParentUnCheckedUnPressScaleAnim = new SpringAnimation((Object)this.mParent, this.mParentScaleFloatProperty, 0.3f);
        this.mParentUnCheckedUnPressScaleAnim.getSpring().setStiffness(986.96f);
        this.mParentUnCheckedUnPressScaleAnim.getSpring().setDampingRatio(0.99f);
        this.mParentUnCheckedUnPressScaleAnim.setMinimumVisibleChange(0.002f);
        this.mParentUnCheckedUnPressScaleAnim.addUpdateListener(this.mParentScaleInvalidListener);
    }

    public void draw(Canvas canvas) {
        this.mGrayDrawable.draw(canvas);
        this.mBlackDrawable.draw(canvas);
        this.mBlueDrawable.draw(canvas);
    }

    public float getScale() {
        return this.mScale;
    }

    public /* synthetic */ void lambda$new$0$CheckWidgetDrawableAnims(DynamicAnimation dynamicAnimation, float f, float f2) {
        this.mParent.invalidateSelf();
    }

    public void setBounds(int n, int n2, int n3, int n4) {
        this.mGrayDrawable.setBounds(n, n2, n3, n4);
        this.mBlackDrawable.setBounds(n, n2, n3, n4);
        this.mBlueDrawable.setBounds(n, n2, n3, n4);
    }

    public void setBounds(Rect rect) {
        this.mGrayDrawable.setBounds(rect);
        this.mBlackDrawable.setBounds(rect);
        this.mBlueDrawable.setBounds(rect);
    }

    public void setScale(float f) {
        this.mGrayDrawable.setScale(f);
        this.mBlackDrawable.setScale(f);
        this.mBlueDrawable.setScale(f);
        this.mScale = f;
    }

    protected void startPressedAnim(boolean bl, boolean bl2) {
        if (bl2) {
            if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                return;
            }
            if (!this.mPressedScaleAnim.isRunning()) {
                this.mPressedScaleAnim.start();
            }
            if (!this.mParentPressAnim.isRunning()) {
                this.mParentPressAnim.start();
            }
            if (!bl && !this.mPressedBlackAnim.isRunning()) {
                this.mPressedBlackAnim.start();
            }
            if (this.mUnPressedBlackAnim.isRunning()) {
                this.mUnPressedBlackAnim.cancel();
            }
            if (this.unPressedScaleAnim.isRunning()) {
                this.unPressedScaleAnim.cancel();
            }
            if (this.mParentUnPressAlphaAnim.isRunning()) {
                this.mParentUnPressAlphaAnim.cancel();
            }
            if (this.mParentCheckedUnPressScaleAnim.isRunning()) {
                this.mParentCheckedUnPressScaleAnim.cancel();
            }
            if (this.mParentUnCheckedUnPressScaleAnim.isRunning()) {
                this.mParentUnCheckedUnPressScaleAnim.cancel();
            }
            if (this.mUnPressedBlueHideAnim.isRunning()) {
                this.mUnPressedBlueHideAnim.cancel();
            }
            if (this.mUnPressedBlueShowAnim.isRunning()) {
                this.mUnPressedBlueShowAnim.cancel();
            }
        }
    }

    protected void startUnPressedAnim(boolean bl, boolean bl2) {
        if (bl2 && Thread.currentThread() == Looper.getMainLooper().getThread()) {
            if (this.mPressedScaleAnim.isRunning()) {
                this.mPressedScaleAnim.cancel();
            }
            if (this.mParentPressAnim.isRunning()) {
                this.mParentPressAnim.cancel();
            }
            if (this.mPressedBlackAnim.isRunning()) {
                this.mPressedBlackAnim.cancel();
            }
            if (!this.mUnPressedBlackAnim.isRunning()) {
                this.mUnPressedBlackAnim.start();
            }
            if (bl) {
                if (this.mUnPressedBlueHideAnim.isRunning()) {
                    this.mUnPressedBlueHideAnim.cancel();
                }
                if (!this.mUnPressedBlueShowAnim.isRunning()) {
                    this.mUnPressedBlueShowAnim.start();
                }
                new Handler().postDelayed(new Runnable(){

                    public void run() {
                        if (!CheckWidgetDrawableAnims.this.mParentUnPressAlphaAnim.isRunning()) {
                            CheckWidgetDrawableAnims.this.mParentUnPressAlphaAnim.start();
                        }
                        if (!CheckWidgetDrawableAnims.this.mParentCheckedUnPressScaleAnim.isRunning()) {
                            CheckWidgetDrawableAnims.this.mParentCheckedUnPressScaleAnim.start();
                        }
                    }
                }, 50L);
                if (this.mIsSingleSelection) {
                    this.unPressedScaleAnim.setStartVelocity(10.0f);
                } else {
                    this.unPressedScaleAnim.setStartVelocity(5.0f);
                }
            } else {
                if (this.mUnPressedBlueShowAnim.isRunning()) {
                    this.mUnPressedBlueShowAnim.cancel();
                }
                if (!this.mUnPressedBlueHideAnim.isRunning()) {
                    this.mUnPressedBlueHideAnim.start();
                }
                if (!this.mParentUnCheckedUnPressScaleAnim.isRunning()) {
                    this.mParentUnCheckedUnPressScaleAnim.start();
                }
            }
            this.unPressedScaleAnim.start();
            return;
        }
        if (bl) {
            this.mBlueDrawable.setAlpha((int)(255.0f * this.mUnPressedBlueShowAnim.getSpring().getFinalPosition()));
            return;
        }
        this.mBlueDrawable.setAlpha((int)(255.0f * this.mUnPressedBlueHideAnim.getSpring().getFinalPosition()));
    }

    protected void verifyChecked(boolean bl, boolean bl2) {
        if (bl2) {
            if (bl) {
                this.mBlueDrawable.setAlpha(255);
                this.mBlackDrawable.setAlpha(25);
            } else {
                this.mBlueDrawable.setAlpha(0);
                this.mBlackDrawable.setAlpha(0);
            }
            this.mGrayDrawable.setAlpha(this.mBackgroundNormalAlpha);
            return;
        }
        this.mBlueDrawable.setAlpha(0);
        this.mBlackDrawable.setAlpha(0);
        this.mGrayDrawable.setAlpha(this.mBackgroundDisableAlpha);
    }

}

