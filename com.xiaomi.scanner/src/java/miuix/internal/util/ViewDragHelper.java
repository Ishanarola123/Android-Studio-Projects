/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  android.view.MotionEvent
 *  android.view.VelocityTracker
 *  android.view.View
 *  android.view.ViewConfiguration
 *  android.view.ViewGroup
 *  android.view.ViewParent
 *  android.view.animation.Interpolator
 *  android.widget.Scroller
 *  java.lang.Double
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.Arrays
 */
package miuix.internal.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import java.util.Arrays;

public class ViewDragHelper {
    private static final int BASE_SETTLE_DURATION = 256;
    public static final int DIRECTION_ALL = 3;
    public static final int DIRECTION_HORIZONTAL = 1;
    public static final int DIRECTION_VERTICAL = 2;
    public static final int EDGE_ALL = 15;
    public static final int EDGE_BOTTOM = 8;
    public static final int EDGE_LEFT = 1;
    public static final int EDGE_RIGHT = 2;
    private static final int EDGE_SIZE = 20;
    public static final int EDGE_TOP = 4;
    public static final int INVALID_POINTER = -1;
    private static final int MAX_SETTLE_DURATION = 600;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "ViewDragHelper";
    private static final Interpolator sInterpolator = new Interpolator(){

        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return 1.0f + f2 * (f2 * (f2 * (f2 * f2)));
        }
    };
    private int mActivePointerId = -1;
    private final Callback mCallback;
    private View mCapturedView;
    private int mDragState;
    private int[] mEdgeDragsInProgress;
    private int[] mEdgeDragsLocked;
    private int mEdgeSize;
    private int[] mInitialEdgesTouched;
    private float[] mInitialMotionX;
    private float[] mInitialMotionY;
    private float[] mLastMotionX;
    private float[] mLastMotionY;
    private float mMaxVelocity;
    private float mMinVelocity;
    private final ViewGroup mParentView;
    private int mPointersDown;
    private boolean mReleaseInProgress;
    private Scroller mScroller;
    private final Runnable mSetIdleRunnable = new Runnable(){

        public void run() {
            ViewDragHelper.this.setDragState(0);
        }
    };
    private int mTouchSlop;
    private int mTrackingEdges;
    private VelocityTracker mVelocityTracker;

    private ViewDragHelper(Context context, ViewGroup viewGroup, Callback callback) {
        if (viewGroup != null) {
            if (callback != null) {
                this.mParentView = viewGroup;
                this.mCallback = callback;
                ViewConfiguration viewConfiguration = ViewConfiguration.get((Context)context);
                this.mEdgeSize = (int)(0.5f + 20.0f * context.getResources().getDisplayMetrics().density);
                this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
                this.mMaxVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
                this.mMinVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
                this.mScroller = new Scroller(context, sInterpolator);
                return;
            }
            throw new IllegalArgumentException("Callback may not be null");
        }
        throw new IllegalArgumentException("Parent view may not be null");
    }

    private boolean checkNewEdgeDrag(float f, float f2, int n, int n2) {
        float f3 = Math.abs((float)f);
        float f4 = Math.abs((float)f2);
        int n3 = n2 & this.mInitialEdgesTouched[n];
        boolean bl = false;
        if (n3 == n2) {
            int n4 = n2 & this.mTrackingEdges;
            bl = false;
            if (n4 != 0) {
                int n5 = n2 & this.mEdgeDragsLocked[n];
                bl = false;
                if (n5 != n2) {
                    int n6 = n2 & this.mEdgeDragsInProgress[n];
                    bl = false;
                    if (n6 != n2) {
                        int n7 = this.mTouchSlop;
                        if (f3 <= (float)n7 && f4 <= (float)n7) {
                            return false;
                        }
                        if (f3 < f4 * 0.5f && this.mCallback.onEdgeLock(n2)) {
                            int[] arrn = this.mEdgeDragsLocked;
                            arrn[n] = n2 | arrn[n];
                            return false;
                        }
                        int n8 = n2 & this.mEdgeDragsInProgress[n];
                        bl = false;
                        if (n8 == 0) {
                            float f5 = f3 FCMPL (float)this.mTouchSlop;
                            bl = false;
                            if (f5 > 0) {
                                bl = true;
                            }
                        }
                    }
                }
            }
        }
        return bl;
    }

    private boolean checkTouchSlop(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean bl = this.mCallback.getViewHorizontalDragRange(view) > 0;
        boolean bl2 = this.mCallback.getViewVerticalDragRange(view) > 0;
        if (bl && bl2) {
            float f3 = f * f + f2 * f2;
            int n = this.mTouchSlop;
            float f4 = f3 FCMPL (float)(n * n);
            boolean bl3 = false;
            if (f4 > 0) {
                bl3 = true;
            }
            return bl3;
        }
        if (bl) {
            float f5 = Math.abs((float)f2) FCMPG (float)this.mTouchSlop;
            boolean bl4 = false;
            if (f5 < 0) {
                float f6 = Math.abs((float)f) FCMPL (float)this.mTouchSlop;
                bl4 = false;
                if (f6 > 0) {
                    bl4 = true;
                }
            }
            return bl4;
        }
        boolean bl5 = false;
        if (bl2) {
            float f7 = Math.abs((float)f) FCMPG (float)this.mTouchSlop;
            bl5 = false;
            if (f7 < 0) {
                float f8 = Math.abs((float)f2) FCMPL (float)this.mTouchSlop;
                bl5 = false;
                if (f8 > 0) {
                    bl5 = true;
                }
            }
        }
        return bl5;
    }

    private float clampMag(float f, float f2, float f3) {
        float f4 = Math.abs((float)f);
        if (f4 < f2) {
            return 0.0f;
        }
        if (f4 > f3) {
            if (f > 0.0f) {
                return f3;
            }
            return -f3;
        }
        return f;
    }

    private int clampMag(int n, int n2, int n3) {
        int n4 = Math.abs((int)n);
        if (n4 < n2) {
            return 0;
        }
        if (n4 > n3) {
            if (n > 0) {
                return n3;
            }
            return -n3;
        }
        return n;
    }

    private void clearMotionHistory() {
        float[] arrf = this.mInitialMotionX;
        if (arrf == null) {
            return;
        }
        Arrays.fill((float[])arrf, (float)0.0f);
        Arrays.fill((float[])this.mInitialMotionY, (float)0.0f);
        Arrays.fill((float[])this.mLastMotionX, (float)0.0f);
        Arrays.fill((float[])this.mLastMotionY, (float)0.0f);
        Arrays.fill((int[])this.mInitialEdgesTouched, (int)0);
        Arrays.fill((int[])this.mEdgeDragsInProgress, (int)0);
        Arrays.fill((int[])this.mEdgeDragsLocked, (int)0);
        this.mPointersDown = 0;
    }

    private void clearMotionHistory(int n) {
        if (this.mInitialMotionX != null) {
            if (!this.isPointerDown(n)) {
                return;
            }
            this.mInitialMotionX[n] = 0.0f;
            this.mInitialMotionY[n] = 0.0f;
            this.mLastMotionX[n] = 0.0f;
            this.mLastMotionY[n] = 0.0f;
            this.mInitialEdgesTouched[n] = 0;
            this.mEdgeDragsInProgress[n] = 0;
            this.mEdgeDragsLocked[n] = 0;
            this.mPointersDown &= -1 ^ 1 << n;
        }
    }

    private int computeAxisDuration(int n, int n2, int n3) {
        if (n == 0) {
            return 0;
        }
        int n4 = this.mParentView.getWidth();
        int n5 = n4 / 2;
        float f = Math.min((float)1.0f, (float)((float)Math.abs((int)n) / (float)n4));
        float f2 = n5;
        float f3 = f2 + f2 * this.distanceInfluenceForSnapDuration(f);
        int n6 = Math.abs((int)n2);
        int n7 = n6 > 0 ? 4 * Math.round((float)(1000.0f * Math.abs((float)(f3 / (float)n6)))) : (int)(256.0f * (1.0f + (float)Math.abs((int)n) / (float)n3));
        return Math.min((int)n7, (int)600);
    }

    private int computeSettleDuration(View view, int n, int n2, int n3, int n4) {
        float f;
        float f2;
        float f3;
        float f4;
        int n5 = this.clampMag(n3, (int)this.mMinVelocity, (int)this.mMaxVelocity);
        int n6 = this.clampMag(n4, (int)this.mMinVelocity, (int)this.mMaxVelocity);
        int n7 = Math.abs((int)n);
        int n8 = Math.abs((int)n2);
        int n9 = Math.abs((int)n5);
        int n10 = Math.abs((int)n6);
        int n11 = n9 + n10;
        int n12 = n7 + n8;
        if (n5 != 0) {
            f2 = n9;
            f4 = n11;
        } else {
            f2 = n7;
            f4 = n12;
        }
        float f5 = f2 / f4;
        if (n6 != 0) {
            f = n10;
            f3 = n11;
        } else {
            f = n8;
            f3 = n12;
        }
        float f6 = f / f3;
        int n13 = this.computeAxisDuration(n, n5, this.mCallback.getViewHorizontalDragRange(view));
        int n14 = this.computeAxisDuration(n2, n6, this.mCallback.getViewVerticalDragRange(view));
        return (int)(f5 * (float)n13 + f6 * (float)n14);
    }

    public static ViewDragHelper create(ViewGroup viewGroup, float f, Callback callback) {
        ViewDragHelper viewDragHelper = ViewDragHelper.create(viewGroup, callback);
        viewDragHelper.mTouchSlop = (int)((float)viewDragHelper.mTouchSlop * (1.0f / f));
        return viewDragHelper;
    }

    public static ViewDragHelper create(ViewGroup viewGroup, Callback callback) {
        return new ViewDragHelper(viewGroup.getContext(), viewGroup, callback);
    }

    private void dispatchViewReleased(float f, float f2) {
        this.mReleaseInProgress = true;
        this.mCallback.onViewReleased(this.mCapturedView, f, f2);
        this.mReleaseInProgress = false;
        if (this.mDragState == 1) {
            this.setDragState(0);
        }
    }

    private float distanceInfluenceForSnapDuration(float f) {
        double d2 = f - 0.5f;
        Double.isNaN((double)d2);
        return (float)Math.sin((double)((float)(d2 * 0.4712389167638204)));
    }

    private void dragTo(int n, int n2, int n3, int n4) {
        int n5 = this.mCapturedView.getLeft();
        int n6 = this.mCapturedView.getTop();
        if (n3 != 0) {
            n = this.mCallback.clampViewPositionHorizontal(this.mCapturedView, n, n3);
            this.mCapturedView.offsetLeftAndRight(n - n5);
        }
        int n7 = n;
        if (n4 != 0) {
            n2 = this.mCallback.clampViewPositionVertical(this.mCapturedView, n2, n4);
            this.mCapturedView.offsetTopAndBottom(n2 - n6);
        }
        int n8 = n2;
        if (n3 != 0 || n4 != 0) {
            int n9 = n7 - n5;
            int n10 = n8 - n6;
            this.mCallback.onViewPositionChanged(this.mCapturedView, n7, n8, n9, n10);
        }
    }

    private void ensureMotionHistorySizeForId(int n) {
        float[] arrf = this.mInitialMotionX;
        if (arrf == null || arrf.length <= n) {
            int n2 = n + 1;
            float[] arrf2 = new float[n2];
            float[] arrf3 = new float[n2];
            float[] arrf4 = new float[n2];
            float[] arrf5 = new float[n2];
            int[] arrn = new int[n2];
            int[] arrn2 = new int[n2];
            int[] arrn3 = new int[n2];
            float[] arrf6 = this.mInitialMotionX;
            if (arrf6 != null) {
                System.arraycopy((Object)arrf6, (int)0, (Object)arrf2, (int)0, (int)arrf6.length);
                float[] arrf7 = this.mInitialMotionY;
                System.arraycopy((Object)arrf7, (int)0, (Object)arrf3, (int)0, (int)arrf7.length);
                float[] arrf8 = this.mLastMotionX;
                System.arraycopy((Object)arrf8, (int)0, (Object)arrf4, (int)0, (int)arrf8.length);
                float[] arrf9 = this.mLastMotionY;
                System.arraycopy((Object)arrf9, (int)0, (Object)arrf5, (int)0, (int)arrf9.length);
                int[] arrn4 = this.mInitialEdgesTouched;
                System.arraycopy((Object)arrn4, (int)0, (Object)arrn, (int)0, (int)arrn4.length);
                int[] arrn5 = this.mEdgeDragsInProgress;
                System.arraycopy((Object)arrn5, (int)0, (Object)arrn2, (int)0, (int)arrn5.length);
                int[] arrn6 = this.mEdgeDragsLocked;
                System.arraycopy((Object)arrn6, (int)0, (Object)arrn3, (int)0, (int)arrn6.length);
            }
            this.mInitialMotionX = arrf2;
            this.mInitialMotionY = arrf3;
            this.mLastMotionX = arrf4;
            this.mLastMotionY = arrf5;
            this.mInitialEdgesTouched = arrn;
            this.mEdgeDragsInProgress = arrn2;
            this.mEdgeDragsLocked = arrn3;
        }
    }

    private boolean forceSettleCapturedViewAt(int n, int n2, int n3, int n4) {
        int n5 = this.mCapturedView.getLeft();
        int n6 = this.mCapturedView.getTop();
        int n7 = n - n5;
        int n8 = n2 - n6;
        if (n7 == 0 && n8 == 0) {
            this.mScroller.abortAnimation();
            this.setDragState(0);
            return false;
        }
        int n9 = this.computeSettleDuration(this.mCapturedView, n7, n8, n3, n4);
        this.mScroller.startScroll(n5, n6, n7, n8, n9);
        this.setDragState(2);
        return true;
    }

    private int getEdgesTouched(int n, int n2) {
        int n3 = n < this.mParentView.getLeft() + this.mEdgeSize ? 1 : 0;
        if (n2 < this.mParentView.getTop() + this.mEdgeSize) {
            n3 |= 4;
        }
        if (n > this.mParentView.getRight() - this.mEdgeSize) {
            n3 |= 2;
        }
        if (n2 > this.mParentView.getBottom() - this.mEdgeSize) {
            n3 |= 8;
        }
        return n3;
    }

    private boolean isValidPointerForActionMove(int n) {
        if (!this.isPointerDown(n)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Ignoring pointerId=");
            stringBuilder.append(n);
            stringBuilder.append(" because ACTION_DOWN was not received ");
            stringBuilder.append("for this pointer before ACTION_MOVE. It likely happened because ");
            stringBuilder.append(" ViewDragHelper did not receive all the events in the event stream.");
            Log.e((String)TAG, (String)stringBuilder.toString());
            return false;
        }
        return true;
    }

    private void releaseViewForPointerUp() {
        this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxVelocity);
        this.dispatchViewReleased(this.clampMag(this.mVelocityTracker.getXVelocity(this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity), this.clampMag(this.mVelocityTracker.getYVelocity(this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity));
    }

    private void reportNewEdgeDrags(float f, float f2, int n) {
        int n2 = 1;
        if (!this.checkNewEdgeDrag(f, f2, n, n2)) {
            n2 = 0;
        }
        if (this.checkNewEdgeDrag(f2, f, n, 4)) {
            n2 |= 4;
        }
        if (this.checkNewEdgeDrag(f, f2, n, 2)) {
            n2 |= 2;
        }
        if (this.checkNewEdgeDrag(f2, f, n, 8)) {
            n2 |= 8;
        }
        if (n2 != 0) {
            int[] arrn = this.mEdgeDragsInProgress;
            arrn[n] = n2 | arrn[n];
            this.mCallback.onEdgeDragStarted(n2, n);
        }
    }

    private void saveInitialMotion(float f, float f2, int n) {
        this.ensureMotionHistorySizeForId(n);
        float[] arrf = this.mInitialMotionX;
        this.mLastMotionX[n] = f;
        arrf[n] = f;
        float[] arrf2 = this.mInitialMotionY;
        this.mLastMotionY[n] = f2;
        arrf2[n] = f2;
        this.mInitialEdgesTouched[n] = this.getEdgesTouched((int)f, (int)f2);
        this.mPointersDown |= 1 << n;
    }

    private void saveLastMotion(MotionEvent motionEvent) {
        int n = motionEvent.getPointerCount();
        for (int i = 0; i < n; ++i) {
            int n2 = motionEvent.getPointerId(i);
            if (!this.isValidPointerForActionMove(n2)) continue;
            float f = motionEvent.getX(i);
            float f2 = motionEvent.getY(i);
            this.mLastMotionX[n2] = f;
            this.mLastMotionY[n2] = f2;
        }
    }

    public void abort() {
        this.cancel();
        if (this.mDragState == 2) {
            int n = this.mScroller.getCurrX();
            int n2 = this.mScroller.getCurrY();
            this.mScroller.abortAnimation();
            int n3 = this.mScroller.getCurrX();
            int n4 = this.mScroller.getCurrY();
            this.mCallback.onViewPositionChanged(this.mCapturedView, n3, n4, n3 - n, n4 - n2);
        }
        this.setDragState(0);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    protected boolean canScroll(View view, boolean bl, int n, int n2, int n3, int n4) {
        boolean bl2 = view instanceof ViewGroup;
        boolean bl3 = true;
        if (bl2) {
            ViewGroup viewGroup = (ViewGroup)view;
            int n5 = view.getScrollX();
            int n6 = view.getScrollY();
            for (int i = viewGroup.getChildCount() - bl3; i >= 0; --i) {
                int n7;
                int n8 = n3 + n5;
                View view2 = viewGroup.getChildAt(i);
                if (n8 < view2.getLeft() || n8 >= view2.getRight() || (n7 = n4 + n6) < view2.getTop() || n7 >= view2.getBottom() || !this.canScroll(view2, true, n, n2, n8 - view2.getLeft(), n7 - view2.getTop())) continue;
                return bl3;
            }
        }
        if (!bl) return false;
        if (view.canScrollHorizontally(-n)) return bl3;
        if (!view.canScrollVertically(-n2)) return false;
        return bl3;
    }

    public void cancel() {
        this.mActivePointerId = -1;
        this.clearMotionHistory();
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public void captureChildView(View view, int n) {
        if (view.getParent() == this.mParentView) {
            this.mCapturedView = view;
            this.mActivePointerId = n;
            this.mCallback.onViewCaptured(view, n);
            this.setDragState(1);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (");
        stringBuilder.append((Object)this.mParentView);
        stringBuilder.append(")");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public boolean checkTouchSlop(int n) {
        int n2 = this.mInitialMotionX.length;
        for (int i = 0; i < n2; ++i) {
            if (!this.checkTouchSlop(n, i)) continue;
            return true;
        }
        return false;
    }

    public boolean checkTouchSlop(int n, int n2) {
        if (!this.isPointerDown(n2)) {
            return false;
        }
        boolean bl = (n & 1) == 1;
        boolean bl2 = (n & 2) == 2;
        float f = this.mLastMotionX[n2] - this.mInitialMotionX[n2];
        float f2 = this.mLastMotionY[n2] - this.mInitialMotionY[n2];
        if (bl && bl2) {
            float f3 = f * f + f2 * f2;
            int n3 = this.mTouchSlop;
            float f4 = f3 FCMPL (float)(n3 * n3);
            boolean bl3 = false;
            if (f4 > 0) {
                bl3 = true;
            }
            return bl3;
        }
        if (bl) {
            float f5 = Math.abs((float)f) FCMPL (float)this.mTouchSlop;
            boolean bl4 = false;
            if (f5 > 0) {
                bl4 = true;
            }
            return bl4;
        }
        boolean bl5 = false;
        if (bl2) {
            float f6 = Math.abs((float)f2) FCMPL (float)this.mTouchSlop;
            bl5 = false;
            if (f6 > 0) {
                bl5 = true;
            }
        }
        return bl5;
    }

    public boolean continueSettling(boolean bl) {
        if (this.mDragState == 2) {
            boolean bl2 = this.mScroller.computeScrollOffset();
            int n = this.mScroller.getCurrX();
            int n2 = this.mScroller.getCurrY();
            int n3 = n - this.mCapturedView.getLeft();
            int n4 = n2 - this.mCapturedView.getTop();
            if (n3 != 0) {
                this.mCapturedView.offsetLeftAndRight(n3);
            }
            if (n4 != 0) {
                this.mCapturedView.offsetTopAndBottom(n4);
            }
            if (n3 != 0 || n4 != 0) {
                this.mCallback.onViewPositionChanged(this.mCapturedView, n, n2, n3, n4);
            }
            if (bl2 && n == this.mScroller.getFinalX() && n2 == this.mScroller.getFinalY()) {
                this.mScroller.abortAnimation();
                bl2 = this.mScroller.isFinished();
            }
            if (!bl2) {
                if (bl) {
                    this.mParentView.post(this.mSetIdleRunnable);
                } else {
                    this.setDragState(0);
                }
            }
        }
        int n = this.mDragState;
        boolean bl3 = false;
        if (n == 2) {
            bl3 = true;
        }
        return bl3;
    }

    public View findTopChildUnder(int n, int n2) {
        for (int i = -1 + this.mParentView.getChildCount(); i >= 0; --i) {
            View view = this.mParentView.getChildAt(this.mCallback.getOrderedChildIndex(i));
            if (n < view.getLeft() || n >= view.getRight() || n2 < view.getTop() || n2 >= view.getBottom()) continue;
            return view;
        }
        return null;
    }

    public void flingCapturedView(int n, int n2, int n3, int n4) {
        if (this.mReleaseInProgress) {
            this.mScroller.fling(this.mCapturedView.getLeft(), this.mCapturedView.getTop(), (int)this.mVelocityTracker.getXVelocity(this.mActivePointerId), (int)this.mVelocityTracker.getYVelocity(this.mActivePointerId), n, n3, n2, n4);
            this.setDragState(2);
            return;
        }
        throw new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
    }

    public int getActivePointerId() {
        return this.mActivePointerId;
    }

    public View getCapturedView() {
        return this.mCapturedView;
    }

    public int getEdgeSize() {
        return this.mEdgeSize;
    }

    public float getMinVelocity() {
        return this.mMinVelocity;
    }

    public int getTouchSlop() {
        return this.mTouchSlop;
    }

    public int getViewDragState() {
        return this.mDragState;
    }

    public boolean isCapturedViewUnder(int n, int n2) {
        return this.isViewUnder(this.mCapturedView, n, n2);
    }

    public boolean isEdgeTouched(int n) {
        int n2 = this.mInitialEdgesTouched.length;
        for (int i = 0; i < n2; ++i) {
            if (!this.isEdgeTouched(n, i)) continue;
            return true;
        }
        return false;
    }

    public boolean isEdgeTouched(int n, int n2) {
        return this.isPointerDown(n2) && (n & this.mInitialEdgesTouched[n2]) != 0;
    }

    public boolean isPointerDown(int n) {
        return (this.mPointersDown & 1 << n) != 0;
    }

    public boolean isViewUnder(View view, int n, int n2) {
        return view != null && n >= view.getLeft() && n < view.getRight() && n2 >= view.getTop() && n2 < view.getBottom();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void processTouchEvent(MotionEvent motionEvent) {
        int n = motionEvent.getActionMasked();
        int n2 = motionEvent.getActionIndex();
        if (n == 0) {
            this.cancel();
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        if (n != 0) {
            if (n != 1) {
                int n3;
                if (n != 2) {
                    if (n != 3) {
                        if (n != 5) {
                            if (n != 6) {
                                return;
                            }
                            int n4 = motionEvent.getPointerId(n2);
                            if (this.mDragState == 1 && n4 == this.mActivePointerId) {
                                int n5;
                                block18 : {
                                    int n6 = motionEvent.getPointerCount();
                                    for (n3 = 0; n3 < n6; ++n3) {
                                        float f;
                                        View view;
                                        View view2;
                                        float f2;
                                        int n7 = motionEvent.getPointerId(n3);
                                        if (n7 == this.mActivePointerId || (view = this.findTopChildUnder((int)(f = motionEvent.getX(n3)), (int)(f2 = motionEvent.getY(n3)))) != (view2 = this.mCapturedView) || !this.tryCaptureViewForDrag(view2, n7)) continue;
                                        n5 = this.mActivePointerId;
                                        break block18;
                                    }
                                    n5 = -1;
                                }
                                if (n5 == -1) {
                                    this.releaseViewForPointerUp();
                                }
                            }
                            this.clearMotionHistory(n4);
                            return;
                        }
                        int n8 = motionEvent.getPointerId(n2);
                        float f = motionEvent.getX(n2);
                        float f3 = motionEvent.getY(n2);
                        this.saveInitialMotion(f, f3, n8);
                        if (this.mDragState == 0) {
                            this.tryCaptureViewForDrag(this.findTopChildUnder((int)f, (int)f3), n8);
                            int n9 = this.mInitialEdgesTouched[n8];
                            int n10 = this.mTrackingEdges;
                            if ((n9 & n10) == 0) return;
                            this.mCallback.onEdgeTouched(n9 & n10, n8);
                            return;
                        }
                        if (!this.isCapturedViewUnder((int)f, (int)f3)) return;
                        this.tryCaptureViewForDrag(this.mCapturedView, n8);
                        return;
                    }
                    if (this.mDragState == 1) {
                        this.dispatchViewReleased(0.0f, 0.0f);
                    }
                    this.cancel();
                    return;
                }
                if (this.mDragState == 1) {
                    if (!this.isValidPointerForActionMove(this.mActivePointerId)) {
                        return;
                    }
                    int n11 = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (n11 < 0 || n11 >= motionEvent.getPointerCount()) return;
                    float f = motionEvent.getX(n11);
                    float f4 = motionEvent.getY(n11);
                    float[] arrf = this.mLastMotionX;
                    int n12 = this.mActivePointerId;
                    int n13 = (int)(f - arrf[n12]);
                    int n14 = (int)(f4 - this.mLastMotionY[n12]);
                    this.dragTo(n13 + this.mCapturedView.getLeft(), n14 + this.mCapturedView.getTop(), n13, n14);
                    this.saveLastMotion(motionEvent);
                    return;
                }
                int n15 = motionEvent.getPointerCount();
                while (n3 < n15) {
                    int n16 = motionEvent.getPointerId(n3);
                    if (this.isValidPointerForActionMove(n16)) {
                        View view;
                        float f = motionEvent.getX(n3);
                        float f5 = motionEvent.getY(n3);
                        float f6 = f - this.mInitialMotionX[n16];
                        float f7 = f5 - this.mInitialMotionY[n16];
                        this.reportNewEdgeDrags(f6, f7, n16);
                        if (this.mDragState == 1 || this.checkTouchSlop(view = this.findTopChildUnder((int)f, (int)f5), f6, f7) && this.tryCaptureViewForDrag(view, n16)) break;
                    }
                    ++n3;
                }
                this.saveLastMotion(motionEvent);
                return;
            }
            if (this.mDragState == 1) {
                this.releaseViewForPointerUp();
            }
            this.cancel();
            return;
        }
        float f = motionEvent.getX();
        float f8 = motionEvent.getY();
        int n17 = motionEvent.getPointerId(0);
        View view = this.findTopChildUnder((int)f, (int)f8);
        this.saveInitialMotion(f, f8, n17);
        this.tryCaptureViewForDrag(view, n17);
        int n18 = this.mInitialEdgesTouched[n17];
        int n19 = this.mTrackingEdges;
        if ((n18 & n19) == 0) return;
        this.mCallback.onEdgeTouched(n18 & n19, n17);
    }

    void setDragState(int n) {
        if (this.mDragState != n) {
            this.mDragState = n;
            this.mCallback.onViewDragStateChanged(n);
            if (n == 0) {
                this.mCapturedView = null;
            }
        }
    }

    public void setEdgeTrackingEnabled(int n) {
        this.mTrackingEdges = n;
    }

    public void setMinVelocity(float f) {
        this.mMinVelocity = f;
    }

    public boolean settleCapturedViewAt(int n, int n2) {
        if (this.mReleaseInProgress) {
            return this.forceSettleCapturedViewAt(n, n2, (int)this.mVelocityTracker.getXVelocity(this.mActivePointerId), (int)this.mVelocityTracker.getYVelocity(this.mActivePointerId));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    public boolean shouldInterceptTouchEvent(MotionEvent motionEvent) {
        block16 : {
            int n;
            int n2;
            block13 : {
                block14 : {
                    block15 : {
                        int n3 = motionEvent.getActionMasked();
                        int n4 = motionEvent.getActionIndex();
                        if (n3 == 0) {
                            this.cancel();
                        }
                        if (this.mVelocityTracker == null) {
                            this.mVelocityTracker = VelocityTracker.obtain();
                        }
                        this.mVelocityTracker.addMovement(motionEvent);
                        if (n3 == 0) break block13;
                        if (n3 == 1) break block14;
                        if (n3 == 2) break block15;
                        if (n3 == 3) break block14;
                        if (n3 != 5) {
                            if (n3 == 6) {
                                this.clearMotionHistory(motionEvent.getPointerId(n4));
                            }
                        } else {
                            View view;
                            int n5 = motionEvent.getPointerId(n4);
                            float f = motionEvent.getX(n4);
                            float f2 = motionEvent.getY(n4);
                            this.saveInitialMotion(f, f2, n5);
                            int n6 = this.mDragState;
                            if (n6 == 0) {
                                int n7 = this.mInitialEdgesTouched[n5];
                                int n8 = this.mTrackingEdges;
                                if ((n7 & n8) != 0) {
                                    this.mCallback.onEdgeTouched(n7 & n8, n5);
                                }
                            } else if (n6 == 2 && (view = this.findTopChildUnder((int)f, (int)f2)) == this.mCapturedView) {
                                this.tryCaptureViewForDrag(view, n5);
                            }
                        }
                        break block16;
                    }
                    int n9 = motionEvent.getPointerCount();
                    for (int i = 0; i < n9; ++i) {
                        View view;
                        int n10 = motionEvent.getPointerId(i);
                        if (!this.isValidPointerForActionMove(n10)) continue;
                        float f = motionEvent.getX(i);
                        float f3 = motionEvent.getY(i);
                        float f4 = f - this.mInitialMotionX[n10];
                        float f5 = f3 - this.mInitialMotionY[n10];
                        this.reportNewEdgeDrags(f4, f5, n10);
                        if (this.mDragState == 1 || (view = this.findTopChildUnder((int)f, (int)f3)) != null && this.checkTouchSlop(view, f4, f5) && this.tryCaptureViewForDrag(view, n10)) break;
                    }
                    this.saveLastMotion(motionEvent);
                    break block16;
                }
                this.cancel();
                break block16;
            }
            float f = motionEvent.getX();
            float f6 = motionEvent.getY();
            int n11 = motionEvent.getPointerId(0);
            this.saveInitialMotion(f, f6, n11);
            View view = this.findTopChildUnder((int)f, (int)f6);
            if (view == this.mCapturedView && this.mDragState == 2) {
                this.tryCaptureViewForDrag(view, n11);
            }
            if (((n2 = this.mInitialEdgesTouched[n11]) & (n = this.mTrackingEdges)) != 0) {
                this.mCallback.onEdgeTouched(n2 & n, n11);
            }
        }
        int n = this.mDragState;
        boolean bl = false;
        if (n == 1) {
            bl = true;
        }
        return bl;
    }

    public boolean smoothSlideViewTo(View view, int n, int n2) {
        this.mCapturedView = view;
        this.mActivePointerId = -1;
        return this.forceSettleCapturedViewAt(n, n2, 0, 0);
    }

    boolean tryCaptureViewForDrag(View view, int n) {
        if (view == this.mCapturedView && this.mActivePointerId == n) {
            return true;
        }
        if (view != null && this.mCallback.tryCaptureView(view, n)) {
            this.mActivePointerId = n;
            this.captureChildView(view, n);
            return true;
        }
        return false;
    }

    public static abstract class Callback {
        public int clampViewPositionHorizontal(View view, int n, int n2) {
            return 0;
        }

        public int clampViewPositionVertical(View view, int n, int n2) {
            return 0;
        }

        public int getOrderedChildIndex(int n) {
            return n;
        }

        public int getViewHorizontalDragRange(View view) {
            return 0;
        }

        public int getViewVerticalDragRange(View view) {
            return 0;
        }

        public void onEdgeDragStarted(int n, int n2) {
        }

        public boolean onEdgeLock(int n) {
            return false;
        }

        public void onEdgeTouched(int n, int n2) {
        }

        public void onViewCaptured(View view, int n) {
        }

        public void onViewDragStateChanged(int n) {
        }

        public void onViewPositionChanged(View view, int n, int n2, int n3, int n4) {
        }

        public void onViewReleased(View view, float f, float f2) {
        }

        public abstract boolean tryCaptureView(View var1, int var2);
    }

}

