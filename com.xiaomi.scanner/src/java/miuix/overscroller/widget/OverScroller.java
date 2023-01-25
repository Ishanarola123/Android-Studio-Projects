/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  android.view.ViewConfiguration
 *  android.view.animation.AnimationUtils
 *  android.view.animation.Interpolator
 *  java.lang.Deprecated
 *  java.lang.Double
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  miuix.animation.physics.SpringOperator
 *  miuix.overscroller.widget.DynamicScroller
 */
package miuix.overscroller.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import miuix.animation.physics.SpringOperator;
import miuix.overscroller.widget.DynamicScroller;

public class OverScroller {
    private static final int DEFAULT_DURATION = 250;
    public static final int FLING_MODE = 1;
    private static boolean SCROLL_BOOST_SS_ENABLE = false;
    public static final int SCROLL_BY_FLING_MODE = 2;
    public static final int SCROLL_MODE;
    private final boolean mFlywheel;
    private Interpolator mInterpolator;
    private int mMode;
    private final SplineOverScroller mScrollerX;
    private final SplineOverScroller mScrollerY;

    public OverScroller(Context context) {
        this(context, null);
    }

    public OverScroller(Context context, Interpolator interpolator2) {
        this(context, interpolator2, true);
    }

    @Deprecated
    public OverScroller(Context context, Interpolator interpolator2, float f, float f2) {
        this(context, interpolator2, true);
    }

    @Deprecated
    public OverScroller(Context context, Interpolator interpolator2, float f, float f2, boolean bl) {
        this(context, interpolator2, bl);
    }

    public OverScroller(Context context, Interpolator interpolator2, boolean bl) {
        this.mInterpolator = interpolator2 == null ? new ViscousFluidInterpolator() : interpolator2;
        this.mFlywheel = bl;
        this.mScrollerX = new DynamicScroller(context);
        this.mScrollerY = new DynamicScroller(context);
    }

    public void abortAnimation() {
        this.mScrollerX.finish();
        this.mScrollerY.finish();
    }

    public boolean computeScrollOffset() {
        block13 : {
            int n;
            block9 : {
                block10 : {
                    boolean bl;
                    block12 : {
                        block11 : {
                            if (this.isFinished()) {
                                return false;
                            }
                            int n2 = this.mMode;
                            if (n2 == 0) break block9;
                            if (n2 == 1) break block10;
                            if (n2 != 2) {
                                return true;
                            }
                            boolean bl2 = this.mScrollerX.computeScrollOffset();
                            if (this.mScrollerY.computeScrollOffset()) break block11;
                            bl = false;
                            if (!bl2) break block12;
                        }
                        bl = true;
                    }
                    return bl;
                }
                if (!(this.mScrollerX.mFinished || this.mScrollerX.update() || this.mScrollerX.continueWhenFinished())) {
                    this.mScrollerX.finish();
                }
                if (!(this.mScrollerY.mFinished || this.mScrollerY.update() || this.mScrollerY.continueWhenFinished())) {
                    this.mScrollerY.finish();
                    return true;
                }
                break block13;
            }
            long l = AnimationUtils.currentAnimationTimeMillis() - this.mScrollerX.mStartTime;
            if (l < (long)(n = this.mScrollerX.mDuration)) {
                float f = this.mInterpolator.getInterpolation((float)l / (float)n);
                this.mScrollerX.updateScroll(f);
                this.mScrollerY.updateScroll(f);
                return true;
            }
            this.abortAnimation();
        }
        return true;
    }

    @Deprecated
    public void extendDuration(int n) {
        this.mScrollerX.extendDuration(n);
        this.mScrollerY.extendDuration(n);
    }

    public void fling(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        this.fling(n, n2, n3, n4, n5, n6, n7, n8, 0, 0);
    }

    public void fling(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10) {
        int n11;
        int n12;
        block3 : {
            int n13;
            int n14;
            block2 : {
                block1 : {
                    block0 : {
                        if (!this.mFlywheel || this.isFinished()) break block0;
                        float f = (float)this.mScrollerX.mCurrVelocity;
                        float f2 = (float)this.mScrollerY.mCurrVelocity;
                        n13 = n3;
                        float f3 = n13;
                        if (Math.signum((float)f3) != Math.signum((float)f)) break block1;
                        n14 = n4;
                        float f4 = n14;
                        if (Math.signum((float)f4) != Math.signum((float)f2)) break block2;
                        int n15 = (int)(f3 + f);
                        n11 = (int)(f4 + f2);
                        n12 = n15;
                        break block3;
                    }
                    n13 = n3;
                }
                n14 = n4;
            }
            n11 = n14;
            n12 = n13;
        }
        this.mMode = 1;
        this.mScrollerX.fling(n, n12, n5, n6, n9);
        this.mScrollerY.fling(n2, n11, n7, n8, n10);
    }

    public final void forceFinished(boolean bl) {
        this.mScrollerX.mFinished = (this.mScrollerY.mFinished = bl);
    }

    public float getCurrVelocity() {
        return (float)Math.hypot((double)this.mScrollerX.mCurrVelocity, (double)this.mScrollerY.mCurrVelocity);
    }

    public float getCurrVelocityX() {
        return (float)this.mScrollerX.mCurrVelocity;
    }

    public float getCurrVelocityY() {
        return (float)this.mScrollerY.mCurrVelocity;
    }

    public final int getCurrX() {
        return (int)this.mScrollerX.mCurrentPosition;
    }

    public final int getCurrY() {
        return (int)this.mScrollerY.mCurrentPosition;
    }

    @Deprecated
    public final int getDuration() {
        return Math.max((int)this.mScrollerX.mDuration, (int)this.mScrollerY.mDuration);
    }

    public final int getFinalX() {
        return (int)this.mScrollerX.mFinal;
    }

    public final int getFinalY() {
        return (int)this.mScrollerY.mFinal;
    }

    public int getMode() {
        return this.mMode;
    }

    public final int getStartX() {
        return (int)this.mScrollerX.mStart;
    }

    public final int getStartY() {
        return (int)this.mScrollerY.mStart;
    }

    public final boolean isFinished() {
        return this.mScrollerX.mFinished && this.mScrollerY.mFinished;
    }

    public boolean isOverScrolled() {
        return !this.mScrollerX.mFinished && this.mScrollerX.mState != 0 || !this.mScrollerY.mFinished && this.mScrollerY.mState != 0;
    }

    public boolean isScrollingInDirection(float f, float f2) {
        int n = (int)this.mScrollerX.mFinal - (int)this.mScrollerX.mStart;
        int n2 = (int)this.mScrollerY.mFinal - (int)this.mScrollerY.mStart;
        return !this.isFinished() && Math.signum((float)f) == Math.signum((float)n) && Math.signum((float)f2) == Math.signum((float)n2);
    }

    public void notifyHorizontalEdgeReached(int n, int n2, int n3) {
        this.mScrollerX.notifyEdgeReached(n, n2, n3);
    }

    public void notifyVerticalEdgeReached(int n, int n2, int n3) {
        this.mScrollerY.notifyEdgeReached(n, n2, n3);
    }

    @Deprecated
    public void setFinalX(int n) {
        this.mScrollerX.setFinalPosition(n);
    }

    @Deprecated
    public void setFinalY(int n) {
        this.mScrollerY.setFinalPosition(n);
    }

    public final void setFriction(float f) {
        this.mScrollerX.setFriction(f);
        this.mScrollerY.setFriction(f);
    }

    void setInterpolator(Interpolator interpolator2) {
        if (interpolator2 == null) {
            this.mInterpolator = new ViscousFluidInterpolator();
            return;
        }
        this.mInterpolator = interpolator2;
    }

    public boolean springBack(int n, int n2, int n3, int n4, int n5, int n6) {
        boolean bl = true;
        this.mMode = bl;
        boolean bl2 = this.mScrollerX.springback(n, n3, n4);
        boolean bl3 = this.mScrollerY.springback(n2, n5, n6);
        if (!bl2) {
            if (bl3) {
                return bl;
            }
            bl = false;
        }
        return bl;
    }

    public void startScroll(int n, int n2, int n3, int n4) {
        this.startScroll(n, n2, n3, n4, 250);
    }

    public void startScroll(int n, int n2, int n3, int n4, int n5) {
        this.mMode = 0;
        this.mScrollerX.startScroll(n, n3, n5);
        this.mScrollerY.startScroll(n2, n4, n5);
    }

    public void startScrollByFling(int n, int n2, int n3, int n4) {
        this.startScrollByFling(n, n2, n3, n4, 0, 0);
    }

    public void startScrollByFling(int n, int n2, int n3, int n4, int n5, int n6) {
        this.mMode = 2;
        this.mScrollerX.startScrollByFling(n, n3, n5);
        this.mScrollerY.startScrollByFling(n2, n4, n6);
    }

    public int timePassed() {
        return (int)(AnimationUtils.currentAnimationTimeMillis() - Math.min((long)this.mScrollerX.mStartTime, (long)this.mScrollerY.mStartTime));
    }

    static class SplineOverScroller {
        private static final int BALLISTIC = 2;
        private static final int CUBIC = 1;
        private static float DECELERATION_RATE = 0.0f;
        private static final float END_TENSION = 1.0f;
        private static final float GRAVITY = 2000.0f;
        private static final float INFLEXION = 0.35f;
        private static final float MAX_DELTA_TIME = 0.016f;
        private static final int NB_SAMPLES = 100;
        private static final float P1 = 0.175f;
        private static final float P2 = 0.35000002f;
        private static final int SPLINE = 0;
        private static final float[] SPLINE_POSITION;
        private static final float[] SPLINE_TIME;
        private static final float START_TENSION = 0.5f;
        static final int STATE_BALLISTIC = 2;
        static final int STATE_CUBIC = 1;
        static final int STATE_SPLINE = 0;
        private static final float VALUE_THRESHOLD = 1.0f;
        private Context mContext;
        private double mCurrVelocity;
        private double mCurrentPosition;
        private float mDeceleration;
        private int mDuration;
        private double mFinal;
        private boolean mFinished;
        private float mFlingFriction = ViewConfiguration.getScrollFriction();
        private boolean mLastStep;
        private double mOriginStart;
        private int mOver;
        private float mPhysicalCoeff;
        private int mSplineDistance;
        private int mSplineDuration;
        private SpringOperator mSpringOperator;
        private double[] mSpringParams;
        private double mStart;
        private long mStartTime;
        private int mState = 0;
        private double mVelocity;

        static {
            DECELERATION_RATE = (float)(Math.log((double)0.78) / Math.log((double)0.9));
            SPLINE_POSITION = new float[101];
            SPLINE_TIME = new float[101];
            float f = 0.0f;
            float f2 = 0.0f;
            block0 : for (int i = 0; i < 100; ++i) {
                float f3 = (float)i / 100.0f;
                float f4 = 1.0f;
                do {
                    float f5;
                    float f6;
                    float f7;
                    float f8;
                    float f9;
                    float f10;
                    float f11;
                    float f12;
                    float f13;
                    float f14;
                    if ((double)Math.abs((float)((f11 = (f9 = (f7 = (f13 = (f6 = f + (f5 = f4 - f) / (f14 = 2.0f)) * (f8 = 3.0f)) * (f12 = 1.0f - f6)) * (f12 * 0.175f + f6 * 0.35000002f)) + (f10 = f6 * (f6 * f6))) - f3)) < 1.0E-5) {
                        SplineOverScroller.SPLINE_POSITION[i] = f10 + f7 * (f6 + f12 * 0.5f);
                        float f15 = 1.0f;
                        do {
                            float f16;
                            float f17;
                            float f18;
                            float f19;
                            float f20;
                            float f21;
                            float f22;
                            if ((double)Math.abs((float)((f16 = (f20 = (f22 = (f19 = (f21 = f2 + (f15 - f2) / f14) * f8) * (f18 = 1.0f - f21)) * (f21 + f18 * 0.5f)) + (f17 = f21 * (f21 * f21))) - f3)) < 1.0E-5) {
                                SplineOverScroller.SPLINE_TIME[i] = f17 + f22 * (f18 * 0.175f + f21 * 0.35000002f);
                                continue block0;
                            }
                            if (f16 > f3) {
                                f15 = f21;
                            } else {
                                f2 = f21;
                            }
                            f14 = 2.0f;
                            f8 = 3.0f;
                        } while (true);
                    }
                    if (f11 > f3) {
                        f4 = f6;
                        continue;
                    }
                    f = f6;
                } while (true);
            }
            float[] arrf = SPLINE_POSITION;
            SplineOverScroller.SPLINE_TIME[100] = 1.0f;
            arrf[100] = 1.0f;
        }

        SplineOverScroller(Context context) {
            this.mContext = context;
            this.mFinished = true;
            this.mPhysicalCoeff = 0.84f * (386.0878f * (160.0f * context.getResources().getDisplayMetrics().density));
        }

        private void adjustDuration(int n, int n2, int n3) {
            int n4 = n2 - n;
            float f = Math.abs((float)((float)(n3 - n) / (float)n4));
            int n5 = (int)(f * 100.0f);
            if (n5 < 100) {
                float f2 = (float)n5 / 100.0f;
                int n6 = n5 + 1;
                float f3 = (float)n6 / 100.0f;
                float[] arrf = SPLINE_TIME;
                float f4 = arrf[n5];
                float f5 = arrf[n6];
                this.mDuration = (int)((f4 + (f - f2) / (f3 - f2) * (f5 - f4)) * (float)this.mDuration);
            }
        }

        private void fitOnBounceCurve(int n, int n2, int n3) {
            double d2;
            float f = -n3;
            float f2 = this.mDeceleration;
            float f3 = f / f2;
            float f4 = n3;
            double d3 = f4 * f4 / 2.0f / Math.abs((float)f2) + (float)Math.abs((int)(n2 - n));
            Double.isNaN((double)d3);
            double d4 = d3 * 2.0;
            double d5 = Math.abs((float)this.mDeceleration);
            Double.isNaN((double)d5);
            float f5 = (float)Math.sqrt((double)(d4 / d5));
            this.mStartTime -= (long)((int)(1000.0f * (f5 - f3)));
            this.mStart = d2 = (double)n2;
            this.mCurrentPosition = d2;
            this.mVelocity = (int)(f5 * -this.mDeceleration);
        }

        private static float getDeceleration(int n) {
            if (n > 0) {
                return -2000.0f;
            }
            return 2000.0f;
        }

        private double getSplineDeceleration(int n) {
            return Math.log((double)(0.35f * (float)Math.abs((int)n) / (this.mFlingFriction * this.mPhysicalCoeff)));
        }

        private double getSplineFlingDistance(int n) {
            double d2 = this.getSplineDeceleration(n);
            float f = DECELERATION_RATE;
            double d3 = f;
            Double.isNaN((double)d3);
            double d4 = d3 - 1.0;
            double d5 = this.mFlingFriction * this.mPhysicalCoeff;
            double d6 = f;
            Double.isNaN((double)d6);
            double d7 = Math.exp((double)(d2 * (d6 / d4)));
            Double.isNaN((double)d5);
            return d5 * d7;
        }

        private int getSplineFlingDuration(int n) {
            double d2 = this.getSplineDeceleration(n);
            double d3 = DECELERATION_RATE;
            Double.isNaN((double)d3);
            return (int)(1000.0 * Math.exp((double)(d2 / (d3 - 1.0))));
        }

        private void onEdgeReached() {
            double d2 = this.mVelocity;
            float f = (float)d2 * (float)d2;
            float f2 = f / (2.0f * Math.abs((float)this.mDeceleration));
            float f3 = Math.signum((float)((float)this.mVelocity));
            int n = this.mOver;
            if (f2 > (float)n) {
                this.mDeceleration = f * -f3 / (2.0f * (float)n);
                f2 = n;
            }
            this.mOver = (int)f2;
            this.mState = 2;
            double d3 = this.mStart;
            if (!(this.mVelocity > 0.0)) {
                f2 = -f2;
            }
            double d4 = (int)f2;
            Double.isNaN((double)d4);
            this.mFinal = d3 + d4;
            double d5 = 1000.0 * this.mVelocity;
            double d6 = this.mDeceleration;
            Double.isNaN((double)d6);
            this.mDuration = -((int)(d5 / d6));
        }

        private void startAfterEdge(int n, int n2, int n3, int n4) {
            boolean bl = true;
            if (n > n2 && n < n3) {
                Log.e((String)"OverScroller", (String)"startAfterEdge called from a valid position");
                this.mFinished = bl;
                return;
            }
            boolean bl2 = n > n3;
            int n5 = bl2 ? n3 : n2;
            int n6 = n - n5;
            if (n6 * n4 < 0) {
                bl = false;
            }
            if (bl) {
                this.startBounceAfterEdge(n, n5, n4);
                return;
            }
            if (this.getSplineFlingDistance(n4) > (double)Math.abs((int)n6)) {
                int n7 = bl2 ? n2 : n;
                int n8 = bl2 ? n : n3;
                this.fling(n, n4, n7, n8, this.mOver);
                return;
            }
            this.startSpringback(n, n5, n4);
        }

        private void startBounceAfterEdge(int n, int n2, int n3) {
            int n4 = n3 == 0 ? n - n2 : n3;
            this.mDeceleration = SplineOverScroller.getDeceleration(n4);
            this.fitOnBounceCurve(n, n2, n3);
            this.onEdgeReached();
        }

        private void startSpringback(int n, int n2, int n3) {
            double d2;
            this.mFinished = false;
            this.mState = 1;
            this.mStart = d2 = (double)n;
            this.mCurrentPosition = d2;
            this.mFinal = n2;
            int n4 = n - n2;
            this.mDeceleration = SplineOverScroller.getDeceleration(n4);
            this.mVelocity = -n4;
            this.mOver = Math.abs((int)n4);
            double d3 = n4;
            Double.isNaN((double)d3);
            double d4 = d3 * -2.0;
            double d5 = this.mDeceleration;
            Double.isNaN((double)d5);
            this.mDuration = (int)(1000.0 * Math.sqrt((double)(d4 / d5)));
        }

        boolean computeScrollOffset() {
            if (this.mSpringOperator != null) {
                if (this.mFinished) {
                    return false;
                }
                if (this.mLastStep) {
                    this.mFinished = true;
                    this.mCurrentPosition = this.mFinal;
                    return true;
                }
                long l = AnimationUtils.currentAnimationTimeMillis();
                double d2 = Math.min((double)((float)(l - this.mStartTime) / 1000.0f), (double)0.01600000075995922);
                if (d2 == 0.0) {
                    d2 = 0.01600000075995922;
                }
                this.mStartTime = l;
                SpringOperator springOperator = this.mSpringOperator;
                double d3 = this.mCurrVelocity;
                double[] arrd = this.mSpringParams;
                double d4 = arrd[0];
                double d5 = arrd[1];
                double[] arrd2 = new double[]{this.mFinal, this.mStart};
                double d6 = springOperator.updateVelocity(d3, d4, d5, d2, arrd2);
                this.mCurrentPosition = this.mStart + d2 * d6;
                this.mCurrVelocity = d6;
                if (this.isAtEquilibrium(this.mCurrentPosition, this.mFinal)) {
                    this.mLastStep = true;
                    return true;
                }
                this.mStart = this.mCurrentPosition;
                return true;
            }
            return false;
        }

        boolean continueWhenFinished() {
            block8 : {
                block7 : {
                    double d2;
                    block5 : {
                        block6 : {
                            int n = this.mState;
                            if (n == 0) break block5;
                            if (n == 1) break block6;
                            if (n == 2) {
                                this.mStartTime += (long)this.mDuration;
                                this.startSpringback((int)this.mFinal, (int)this.mStart, 0);
                            }
                            break block7;
                        }
                        return false;
                    }
                    if (this.mDuration >= this.mSplineDuration) break block8;
                    this.mStart = d2 = this.mFinal;
                    this.mCurrentPosition = d2;
                    this.mVelocity = (int)this.mCurrVelocity;
                    this.mDeceleration = SplineOverScroller.getDeceleration((int)this.mVelocity);
                    this.mStartTime += (long)this.mDuration;
                    this.onEdgeReached();
                }
                this.update();
                return true;
            }
            return false;
        }

        void extendDuration(int n) {
            this.mDuration = n + (int)(AnimationUtils.currentAnimationTimeMillis() - this.mStartTime);
            this.mFinished = false;
        }

        void finish() {
            this.mCurrentPosition = this.mFinal;
            this.mFinished = true;
        }

        void fling(int n, int n2, int n3, int n4, int n5) {
            double d2;
            double d3;
            this.mOver = n5;
            this.mFinished = false;
            this.mVelocity = d2 = (double)n2;
            this.mCurrVelocity = d2;
            this.mSplineDuration = 0;
            this.mDuration = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStart = d3 = (double)n;
            this.mCurrentPosition = d3;
            if (n <= n4 && n >= n3) {
                double d4;
                double d5;
                this.mState = 0;
                double d6 = 0.0;
                if (n2 != 0) {
                    int n6;
                    this.mSplineDuration = n6 = this.getSplineFlingDuration(n2);
                    this.mDuration = n6;
                    d6 = this.getSplineFlingDistance(n2);
                }
                double d7 = Math.signum((float)n2);
                Double.isNaN((double)d7);
                this.mSplineDistance = (int)(d6 * d7);
                double d8 = this.mFinal = (double)(n + this.mSplineDistance);
                double d9 = n3;
                if (d8 < d9) {
                    this.adjustDuration((int)this.mStart, (int)d8, n3);
                    this.mFinal = d9;
                }
                if ((d5 = this.mFinal) > (d4 = (double)n4)) {
                    this.adjustDuration((int)this.mStart, (int)d5, n4);
                    this.mFinal = d4;
                }
                return;
            }
            this.startAfterEdge(n, n3, n4, n2);
        }

        final float getCurrVelocity() {
            return (float)this.mCurrVelocity;
        }

        final int getCurrentPosition() {
            return (int)this.mCurrentPosition;
        }

        final int getDuration() {
            return this.mDuration;
        }

        final int getFinal() {
            return (int)this.mFinal;
        }

        final int getStart() {
            return (int)this.mStart;
        }

        final long getStartTime() {
            return this.mStartTime;
        }

        final int getState() {
            return this.mState;
        }

        boolean isAtEquilibrium(double d2, double d3) {
            return Math.abs((double)(d2 - d3)) < 1.0;
        }

        final boolean isFinished() {
            return this.mFinished;
        }

        void notifyEdgeReached(int n, int n2, int n3) {
            if (this.mState == 0) {
                this.mOver = n3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                this.startAfterEdge(n, n2, n2, (int)this.mCurrVelocity);
            }
        }

        final void setCurrVelocity(float f) {
            this.mCurrVelocity = f;
        }

        final void setCurrentPosition(int n) {
            this.mCurrentPosition = n;
        }

        final void setDuration(int n) {
            this.mDuration = n;
        }

        final void setFinal(int n) {
            this.mFinal = n;
        }

        void setFinalPosition(int n) {
            this.mFinal = n;
            this.mFinished = false;
        }

        final void setFinished(boolean bl) {
            this.mFinished = bl;
        }

        void setFriction(float f) {
            this.mFlingFriction = f;
        }

        final void setStart(int n) {
            this.mStart = n;
        }

        final void setStartTime(long l) {
            this.mStartTime = l;
        }

        final void setState(int n) {
            this.mState = n;
        }

        boolean springback(int n, int n2, int n3) {
            double d2;
            this.mFinished = true;
            this.mFinal = d2 = (double)n;
            this.mStart = d2;
            this.mCurrentPosition = d2;
            this.mVelocity = 0.0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = 0;
            if (n < n2) {
                this.startSpringback(n, n2, 0);
            } else if (n > n3) {
                this.startSpringback(n, n3, 0);
            }
            return true ^ this.mFinished;
        }

        void startScroll(int n, int n2, int n3) {
            double d2;
            this.mFinished = false;
            this.mStart = d2 = (double)n;
            this.mCurrentPosition = d2;
            this.mFinal = n + n2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = n3;
            this.mDeceleration = 0.0f;
            this.mVelocity = 0.0;
        }

        void startScrollByFling(float f, int n, int n2) {
            double d2;
            double d3;
            this.mFinished = false;
            this.mLastStep = false;
            this.mOriginStart = d3 = (double)f;
            this.mStart = d3;
            this.mCurrentPosition = d3;
            this.mFinal = f + (float)n;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mVelocity = d2 = (double)n2;
            this.mCurrVelocity = d2;
            this.mSpringOperator = new SpringOperator();
            this.mSpringParams = new double[2];
            this.mSpringOperator.getParameters(new float[]{0.99f, 0.4f}, this.mSpringParams);
        }

        boolean update() {
            long l = AnimationUtils.currentAnimationTimeMillis() - this.mStartTime;
            if (l == 0L) {
                int n = this.mDuration;
                boolean bl = false;
                if (n > 0) {
                    bl = true;
                }
                return bl;
            }
            int n = this.mDuration;
            if (l > (long)n) {
                return false;
            }
            double d2 = 0.0;
            int n2 = this.mState;
            if (n2 != 0) {
                if (n2 != 1) {
                    if (n2 == 2) {
                        float f = (float)l / 1000.0f;
                        double d3 = this.mVelocity;
                        float f2 = this.mDeceleration;
                        double d4 = f2 * f;
                        Double.isNaN((double)d4);
                        this.mCurrVelocity = d4 + d3;
                        double d5 = f;
                        Double.isNaN((double)d5);
                        double d6 = d3 * d5;
                        double d7 = f * (f2 * f) / 2.0f;
                        Double.isNaN((double)d7);
                        d2 = d6 + d7;
                    }
                } else {
                    float f = (float)l / (float)n;
                    float f3 = f * f;
                    float f4 = Math.signum((float)((float)this.mVelocity));
                    int n3 = this.mOver;
                    d2 = f4 * (float)n3 * (3.0f * f3 - f3 * (2.0f * f));
                    this.mCurrVelocity = 6.0f * (f4 * (float)n3) * (f3 + -f);
                }
            } else {
                float f = (float)l / (float)this.mSplineDuration;
                int n4 = (int)(f * 100.0f);
                float f5 = 1.0f;
                float f6 = 0.0f;
                if (n4 < 100) {
                    float f7 = (float)n4 / 100.0f;
                    int n5 = n4 + 1;
                    float f8 = (float)n5 / 100.0f;
                    float[] arrf = SPLINE_POSITION;
                    float f9 = arrf[n4];
                    f6 = (arrf[n5] - f9) / (f8 - f7);
                    f5 = f9 + f6 * (f - f7);
                }
                int n6 = this.mSplineDistance;
                double d8 = f5 * (float)n6;
                this.mCurrVelocity = 1000.0f * (f6 * (float)n6 / (float)this.mSplineDuration);
                d2 = d8;
            }
            double d9 = this.mStart;
            double d10 = (int)Math.round((double)d2);
            Double.isNaN((double)d10);
            this.mCurrentPosition = d9 + d10;
            return true;
        }

        void updateScroll(float f) {
            double d2 = this.mStart;
            double d3 = f;
            double d4 = this.mFinal - d2;
            Double.isNaN((double)d3);
            double d5 = Math.round((double)(d3 * d4));
            Double.isNaN((double)d5);
            this.mCurrentPosition = d2 + d5;
        }
    }

    static class ViscousFluidInterpolator
    implements Interpolator {
        private static final float VISCOUS_FLUID_NORMALIZE = 0.0f;
        private static final float VISCOUS_FLUID_OFFSET = 0.0f;
        private static final float VISCOUS_FLUID_SCALE = 8.0f;

        static {
            VISCOUS_FLUID_NORMALIZE = 1.0f / ViscousFluidInterpolator.viscousFluid(1.0f);
            VISCOUS_FLUID_OFFSET = 1.0f - VISCOUS_FLUID_NORMALIZE * ViscousFluidInterpolator.viscousFluid(1.0f);
        }

        ViscousFluidInterpolator() {
        }

        private static float viscousFluid(float f) {
            float f2 = f * 8.0f;
            if (f2 < 1.0f) {
                return f2 - (1.0f - (float)Math.exp((double)(-f2)));
            }
            return 0.36787945f + 0.63212055f * (1.0f - (float)Math.exp((double)(1.0f - f2)));
        }

        public float getInterpolation(float f) {
            float f2 = VISCOUS_FLUID_NORMALIZE * ViscousFluidInterpolator.viscousFluid(f);
            if (f2 > 0.0f) {
                f2 += VISCOUS_FLUID_OFFSET;
            }
            return f2;
        }
    }

}

