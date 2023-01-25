/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Outline
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewOutlineProvider
 *  android.view.WindowManager
 *  android.view.WindowManager$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.ListAdapter
 *  android.widget.ListView
 *  android.widget.PopupWindow
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Locale
 *  miuix.popupwidget.widget.DropDownPopupWindow$ContainerController
 *  miuix.popupwidget.widget.DropDownPopupWindow$ContainerView
 *  miuix.popupwidget.widget.DropDownPopupWindow$ContentController
 *  miuix.view.HapticCompat
 *  miuix.view.HapticFeedbackConstants
 */
package miuix.popupwidget.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import java.util.Locale;
import miuix.internal.util.DeviceHelper;
import miuix.internal.util.ViewUtils;
import miuix.popupwidget.R;
import miuix.popupwidget.widget.DropDownPopupWindow;
import miuix.view.HapticCompat;
import miuix.view.HapticFeedbackConstants;

/*
 * Exception performing whole class analysis.
 */
public class DropDownPopupWindow {
    private static final float DIM = 0.3f;
    private static int OFFSET_H = 40;
    private static final String TAG = "DropDownPopupWindow";
    private View mAnchorView;
    private ValueAnimator mAnimator;
    private Animator.AnimatorListener mAnimatorListener;
    private ContainerView mContainer;
    private ContainerController mContainerController;
    private ContentController mContentController;
    private View mContentView;
    private Context mContext;
    private int mDismissDuration;
    private boolean mDismissPending;
    private Controller mDropDownController;
    private int mElevation;
    private int mMaxWith;
    private int mMinWith;
    private PopupWindow mPopupWindow;
    private View mRealContainerView;
    private int mShowDuration;
    private ValueAnimator.AnimatorUpdateListener mValueUpdateListener;

    public DropDownPopupWindow(Context context, AttributeSet attributeSet, int n) {
        this.mShowDuration = 300;
        this.mDismissDuration = 300;
        this.mValueUpdateListener = new ValueAnimator.AnimatorUpdateListener(){

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float f = ((Float)DropDownPopupWindow.this.mAnimator.getAnimatedValue()).floatValue();
                if (DropDownPopupWindow.this.mContainerController != null) {
                    DropDownPopupWindow.this.mContainerController.onAniamtionUpdate((View)DropDownPopupWindow.this.mContainer, f);
                }
                if (DropDownPopupWindow.this.mContentController != null) {
                    DropDownPopupWindow.this.mContentController.onAniamtionUpdate(DropDownPopupWindow.this.mContentView, f);
                }
            }
        };
        this.mAnimatorListener = new Animator.AnimatorListener(){

            private void tryDismiss() {
                if (DropDownPopupWindow.this.mDismissPending) {
                    DropDownPopupWindow.this.realDismiss();
                }
            }

            public void onAnimationCancel(Animator animator2) {
                this.tryDismiss();
            }

            public void onAnimationEnd(Animator animator2) {
                this.tryDismiss();
            }

            public void onAnimationRepeat(Animator animator2) {
            }

            public void onAnimationStart(Animator animator2) {
                if (DropDownPopupWindow.this.mDismissPending && DropDownPopupWindow.this.mDropDownController != null) {
                    DropDownPopupWindow.this.mDropDownController.onDismiss();
                }
            }
        };
        this.mContext = context;
        this.mPopupWindow = new PopupWindow(context, attributeSet, 0, n);
        this.mContainer = new /* Unavailable Anonymous Inner Class!! */;
        PopupWindow popupWindow = this.mPopupWindow;
        boolean bl = DeviceHelper.isFeatureWholeAnim();
        int n2 = 0;
        if (bl) {
            n2 = R.style.Animation_PopupWindow_DropDown;
        }
        popupWindow.setAnimationStyle(n2);
        this.initPopupWindow();
    }

    private void initPopupWindow() {
        this.mElevation = this.mContext.getResources().getDimensionPixelSize(R.dimen.miuix_appcompat_drop_down_menu_elevation);
        this.mMinWith = this.mContext.getResources().getDimensionPixelSize(R.dimen.miuix_appcompat_drop_down_menu_min_width);
        this.mMaxWith = this.mContext.getResources().getDisplayMetrics().widthPixels - 2 * OFFSET_H;
        this.mPopupWindow.setWidth(-2);
        this.mPopupWindow.setHeight(-2);
        this.mPopupWindow.setSoftInputMode(3);
        this.mPopupWindow.setOutsideTouchable(false);
        this.mPopupWindow.setFocusable(true);
        this.mContainer.setFocusableInTouchMode(true);
        this.mPopupWindow.setContentView((View)this.mContainer);
    }

    private int measureListViewWidth(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        int n = View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
        int n2 = View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
        int n3 = listAdapter.getCount();
        View view = null;
        int n4 = 0;
        int n5 = 0;
        for (int i = 0; i < n3; ++i) {
            int n6 = listAdapter.getItemViewType(i);
            if (n6 != n5) {
                view = null;
                n5 = n6;
            }
            view = listAdapter.getView(i, view, (ViewGroup)listView);
            view.measure(n, n2);
            int n7 = view.getMeasuredWidth();
            if (n7 <= n4) continue;
            n4 = n7;
        }
        return n4;
    }

    private void realDismiss() {
        ContentController contentController;
        Controller controller;
        ContainerController containerController;
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        if ((containerController = this.mContainerController) != null) {
            containerController.onDismiss();
        }
        if ((contentController = this.mContentController) != null) {
            contentController.onDismiss();
        }
        if ((controller = this.mDropDownController) != null) {
            controller.onDismiss();
        }
        this.mDismissPending = false;
    }

    private void startAnimation(float f, float f2, int n) {
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (this.mContainerController != null || this.mContentController != null) {
            ValueAnimator valueAnimator2 = this.mAnimator;
            if (valueAnimator2 == null) {
                this.mAnimator = ValueAnimator.ofFloat((float[])new float[]{f, f2});
            } else {
                valueAnimator2.setFloatValues(new float[]{f, f2});
            }
            ValueAnimator valueAnimator3 = this.mAnimator;
            long l = DeviceHelper.isFeatureWholeAnim() ? (long)n : 0L;
            valueAnimator3.setDuration(l);
            this.mAnimator.addUpdateListener(this.mValueUpdateListener);
            this.mAnimator.addListener(this.mAnimatorListener);
            this.mAnimator.start();
        }
    }

    public void changeWindowBackground(View view, float f) {
        if (view != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams)view.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            layoutParams.flags = 2 | layoutParams.flags;
            layoutParams.dimAmount = f;
            ((WindowManager)view.getContext().getSystemService("window")).updateViewLayout(view, (ViewGroup.LayoutParams)layoutParams);
            return;
        }
        Log.w((String)TAG, (String)"can't change window dim with null view");
    }

    public void dismiss() {
        this.mDismissPending = true;
        this.realDismiss();
    }

    public Context getContext() {
        return this.mContext;
    }

    public void setAnchor(View view) {
        this.mAnchorView = view;
    }

    public void setContainerController(ContainerController containerController) {
        this.mContainerController = containerController;
    }

    public void setContentController(ContentController contentController) {
        this.mContentController = contentController;
    }

    public void setDropDownController(Controller controller) {
        this.mDropDownController = controller;
    }

    public int setupContentView(FrameLayout frameLayout, final View view, int n, int n2, ContainerController containerController) {
        int n3;
        if (view == null) {
            return -2;
        }
        if (n > 0 && Build.VERSION.SDK_INT >= 21) {
            view.setElevation((float)n);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            view.setOutlineProvider(new ViewOutlineProvider(){

                public void getOutline(View view2, Outline outline) {
                    if (view2.getWidth() != 0) {
                        if (view2.getHeight() == 0) {
                            return;
                        }
                        outline.setAlpha(0.7f);
                        if (view.getBackground() != null) {
                            view.getBackground().getOutline(outline);
                        }
                    }
                }
            });
        }
        if (view instanceof ListView) {
            n3 = this.measureListViewWidth((ListView)view);
        } else {
            view.measure(0, 0);
            n3 = view.getMeasuredWidth();
        }
        if (n3 < n2) {
            n3 = n2;
        }
        return n3;
    }

    public void show() {
        if (this.mPopupWindow.isShowing()) {
            View view = this.mAnchorView;
            if (view != null) {
                this.mPopupWindow.update(view, 0, 0);
            } else {
                this.mPopupWindow.update(0, 0);
            }
        } else {
            int n;
            View view;
            View view2;
            ContentController contentController = this.mContentController;
            int n2 = contentController != null && (view = (this.mContentView = contentController.getContentView())) != null ? this.setupContentView((FrameLayout)this.mContainer, view, this.mElevation, this.mMinWith, this.mContainerController) : -2;
            if (n2 > (n = this.mMaxWith)) {
                n2 = n;
            }
            this.mRealContainerView = this.mContentView;
            this.mPopupWindow.setTouchInterceptor(new View.OnTouchListener(){

                public boolean onTouch(View view, MotionEvent motionEvent) {
                    int n = (int)motionEvent.getX();
                    int n2 = (int)motionEvent.getY();
                    if (motionEvent.getAction() == 0 && (n < 0 || n >= DropDownPopupWindow.this.mRealContainerView.getWidth() || n2 < 0 || n2 >= DropDownPopupWindow.this.mRealContainerView.getHeight())) {
                        DropDownPopupWindow.this.dismiss();
                        return true;
                    }
                    return false;
                }
            });
            ContainerController containerController = this.mContainerController;
            if (containerController != null) {
                containerController.onShow();
            }
            this.mPopupWindow.setWidth(n2);
            this.mPopupWindow.setHeight(-2);
            if (Build.VERSION.SDK_INT >= 21) {
                PopupWindow popupWindow = this.mPopupWindow;
                View view3 = this.mRealContainerView;
                float f = view3 == null ? 0.0f : view3.getElevation();
                popupWindow.setElevation(f);
            }
            this.mContainer.removeAllViews();
            this.mContainer.addView(this.mRealContainerView);
            View view4 = this.mAnchorView;
            if (view4 != null && view4.isAttachedToWindow()) {
                int n3;
                this.mPopupWindow.setHeight(-2);
                int[] arrn = new int[2];
                this.mAnchorView.getLocationInWindow(arrn);
                if (n2 == this.mMaxWith) {
                    n3 = OFFSET_H;
                    if (ViewUtils.isLayoutRtl(this.mRealContainerView)) {
                        n3 += this.mMaxWith;
                    }
                } else {
                    n3 = TextUtils.getLayoutDirectionFromLocale((Locale)Locale.getDefault()) != 1 ? arrn[0] : arrn[0] + this.mAnchorView.getWidth() - this.mPopupWindow.getWidth();
                }
                this.mPopupWindow.showAtLocation(this.mRealContainerView, 0, n3, arrn[1]);
                view2 = this.mAnchorView;
            } else {
                this.mPopupWindow.showAtLocation(this.mRealContainerView, 8388659, 0, 0);
                view2 = this.mRealContainerView;
            }
            if (view2 != null) {
                HapticCompat.performHapticFeedback((View)view2, (int)HapticFeedbackConstants.MIUI_POPUP_NORMAL);
            }
        }
        View view = this.mRealContainerView;
        if (view != null) {
            this.changeWindowBackground(view.getRootView(), 0.3f);
        }
    }

    public static interface Controller {
        public void onAniamtionUpdate(View var1, float var2);

        public void onDismiss();

        public void onShow();
    }

}

