/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.database.DataSetObserver
 *  android.graphics.Outline
 *  android.graphics.Rect
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.IBinder
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.View$OnClickListener
 *  android.view.View$OnLayoutChangeListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewOutlineProvider
 *  android.view.WindowManager
 *  android.view.WindowManager$LayoutParams
 *  android.view.inputmethod.InputMethodManager
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.ListAdapter
 *  android.widget.ListView
 *  android.widget.PopupWindow
 *  android.widget.PopupWindow$OnDismissListener
 *  androidx.annotation.RequiresApi
 *  androidx.appcompat.widget.ViewUtils
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  miuix.appcompat.R
 *  miuix.appcompat.R$attr
 *  miuix.appcompat.R$dimen
 *  miuix.appcompat.R$layout
 *  miuix.appcompat.R$style
 *  miuix.springback.view.SpringBackLayout
 *  miuix.view.HapticCompat
 *  miuix.view.HapticFeedbackConstants
 */
package miuix.internal.widget;

import android.content.Context;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.ViewUtils;
import miuix.appcompat.R;
import miuix.internal.util.AttributeResolver;
import miuix.internal.util.DeviceHelper;
import miuix.internal.widget.-$$Lambda$ListPopup$8JGgEYjH8MfL0nDL6g92Af4GuJg;
import miuix.internal.widget.-$$Lambda$ListPopup$EEAHM0S02mwIJGsdW6acNhVxhE4;
import miuix.internal.widget.-$$Lambda$ListPopup$EUXfagJaknNM11VVsRAcJmoWPsQ;
import miuix.internal.widget.RoundFrameLayout;
import miuix.springback.view.SpringBackLayout;
import miuix.view.HapticCompat;
import miuix.view.HapticFeedbackConstants;

public class ListPopup
extends PopupWindow {
    private static final float DIM = 0.3f;
    private static final int OFFSET_FROM_STATUS_BAR = 22;
    private static final float OFFSET_X = 8.0f;
    private static final float OFFSET_Y = 8.0f;
    private static final String TAG = "ListPopupWindow";
    private ListAdapter mAdapter;
    protected final Rect mBackgroundPadding;
    private ContentSize mContentSize;
    protected View mContentView;
    private Context mContext;
    private int mDropDownGravity = 8388661;
    protected int mElevation;
    private boolean mHasShadow = true;
    private ListView mListView;
    private int mMaxAllowedHeight;
    private int mMaxAllowedWidth;
    private int mMinAllowedWidth;
    private int mMinMarginScreen;
    private DataSetObserver mObserver = new DataSetObserver(){

        public void onChanged() {
            ListPopup.access$000((ListPopup)ListPopup.this).mHasContentWidth = false;
            if (ListPopup.this.isShowing()) {
                ListPopup listPopup = ListPopup.this;
                listPopup.update(listPopup.computePopupContentWidth(), ListPopup.this.getHeight());
            }
        }
    };
    private int mOffsetX;
    private boolean mOffsetXSet;
    private int mOffsetY;
    private boolean mOffsetYSet;
    private PopupWindow.OnDismissListener mOnDismissListener;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    protected FrameLayout mRootView;

    public ListPopup(Context context) {
        int n;
        super(context);
        this.mContext = context;
        this.setHeight(-2);
        Resources resources = context.getResources();
        this.mMaxAllowedWidth = resources.getDimensionPixelSize(R.dimen.miuix_appcompat_list_menu_dialog_maximum_width);
        this.mMinAllowedWidth = resources.getDimensionPixelSize(R.dimen.miuix_appcompat_list_menu_dialog_minimum_width);
        this.mOffsetX = n = (int)(8.0f * resources.getDisplayMetrics().density);
        this.mOffsetY = n;
        this.mBackgroundPadding = new Rect();
        this.mContentSize = new ContentSize();
        this.setFocusable(true);
        this.mRootView = new RoundFrameLayout(context);
        this.mRootView.setOnClickListener((View.OnClickListener)new -$$Lambda$ListPopup$8JGgEYjH8MfL0nDL6g92Af4GuJg(this));
        this.prepareContentView(context);
        this.setAnimationStyle(R.style.Animation_PopupWindow_ImmersionMenu);
        this.mElevation = AttributeResolver.resolveDimensionPixelSize(this.mContext, R.attr.popupWindowElevation);
        super.setOnDismissListener((PopupWindow.OnDismissListener)new -$$Lambda$ListPopup$EUXfagJaknNM11VVsRAcJmoWPsQ(this));
        this.mMinMarginScreen = context.getResources().getDimensionPixelSize(R.dimen.miuix_appcompat_context_menu_window_margin_screen);
    }

    static /* synthetic */ ContentSize access$000(ListPopup listPopup) {
        return listPopup.mContentSize;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private int calculateXoffset(View var1_1) {
        block3 : {
            var2_2 = new int[2];
            var1_1.getLocationInWindow(var2_2);
            var3_3 = ViewUtils.isLayoutRtl((View)var1_1);
            var4_4 = true;
            if (!var3_3) break block3;
            if (var2_2[0] - this.mOffsetX + this.getWidth() + this.mMinMarginScreen <= var1_1.getRootView().getWidth()) ** GOTO lbl-1000
            var6_5 = var1_1.getRootView().getWidth() - this.getWidth() - this.mMinMarginScreen;
            var7_6 = var2_2[0];
            ** GOTO lbl14
        }
        if (var2_2[0] + var1_1.getWidth() + this.mOffsetX - this.getWidth() - this.mMinMarginScreen < 0) {
            var6_5 = this.getWidth() + this.mMinMarginScreen;
            var7_6 = var2_2[0] + var1_1.getWidth();
lbl14: // 2 sources:
            var5_7 = var6_5 - var7_6;
        } else lbl-1000: // 2 sources:
        {
            var5_7 = 0;
            var4_4 = false;
        }
        if (var4_4 != false) return var5_7;
        var5_7 = this.mOffsetXSet != false ? this.mOffsetX : 0;
        if (var5_7 == 0) return var5_7;
        if (this.mOffsetXSet != false) return var5_7;
        if (ViewUtils.isLayoutRtl((View)var1_1)) {
            return var5_7 - (this.mBackgroundPadding.left - this.mOffsetX);
        }
        var5_7 += this.mBackgroundPadding.right - this.mOffsetX;
        return var5_7;
    }

    private int calculateYoffset(View view) {
        int n = this.mOffsetYSet ? this.mOffsetY : -view.getHeight() - this.mBackgroundPadding.top + this.mOffsetY;
        int[] arrn = new int[2];
        view.getLocationInWindow(arrn);
        float f = arrn[1];
        int n2 = this.mContext.getResources().getDisplayMetrics().heightPixels;
        int n3 = Math.min((int)this.mContentSize.mHeight, (int)this.mMaxAllowedHeight);
        if (n3 < n2 && f + (float)n + (float)n3 + (float)view.getHeight() > (float)n2) {
            int n4 = this.mOffsetYSet ? view.getHeight() : 0;
            n -= n4 + n3;
        }
        return n;
    }

    public static void changeWindowBackground(View view) {
        if (view == null) {
            return;
        }
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams)view.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        layoutParams.flags = 2 | layoutParams.flags;
        layoutParams.dimAmount = 0.3f;
        ((WindowManager)view.getContext().getSystemService("window")).updateViewLayout(view, (ViewGroup.LayoutParams)layoutParams);
    }

    private void measureContentSize(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int n) {
        int n2 = View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
        int n3 = View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
        int n4 = listAdapter.getCount();
        ViewGroup viewGroup2 = viewGroup;
        View view = null;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        for (int i = 0; i < n4; ++i) {
            int n8 = listAdapter.getItemViewType(i);
            if (n8 != n5) {
                view = null;
                n5 = n8;
            }
            if (viewGroup2 == null) {
                viewGroup2 = new FrameLayout(context);
            }
            view = listAdapter.getView(i, view, viewGroup2);
            view.measure(n2, n3);
            n7 += view.getMeasuredHeight();
            if (this.mContentSize.mHasContentWidth) continue;
            int n9 = view.getMeasuredWidth();
            if (n9 >= n) {
                this.mContentSize.updateWidth(n);
                continue;
            }
            if (n9 <= n6) continue;
            n6 = n9;
        }
        if (!this.mContentSize.mHasContentWidth) {
            this.mContentSize.updateWidth(n6);
        }
        this.mContentSize.mHeight = n7;
    }

    @RequiresApi(api=21)
    protected static void setPopupShadowAlpha(View view) {
        view.setOutlineProvider(new ViewOutlineProvider(){

            public void getOutline(View view, Outline outline) {
                if (view.getWidth() != 0) {
                    if (view.getHeight() == 0) {
                        return;
                    }
                    outline.setAlpha(AttributeResolver.resolveFloat(view.getContext(), R.attr.popupWindowShadowAlpha, 0.0f));
                    if (view.getBackground() != null) {
                        view.getBackground().getOutline(outline);
                    }
                }
            }
        });
    }

    private void showWithAnchor(View view) {
        int n = this.calculateYoffset(view);
        this.showAsDropDown(view, this.calculateXoffset(view), n, this.mDropDownGravity);
        HapticCompat.performHapticFeedback((View)view, (int)HapticFeedbackConstants.MIUI_POPUP_NORMAL);
        ListPopup.changeWindowBackground(this.mRootView.getRootView());
    }

    protected int computePopupContentWidth() {
        if (!this.mContentSize.mHasContentWidth) {
            this.measureContentSize(this.mAdapter, null, this.mContext, this.mMaxAllowedWidth);
        }
        return Math.max((int)this.mContentSize.mWidth, (int)this.mMinAllowedWidth) + this.mBackgroundPadding.left + this.mBackgroundPadding.right;
    }

    public void fastShow(View view, ViewGroup viewGroup) {
        this.setWidth(this.computePopupContentWidth());
        this.showWithAnchor(view);
    }

    public int getHorizontalOffset() {
        return this.mOffsetX;
    }

    public ListView getListView() {
        return this.mListView;
    }

    public int getMinMarginScreen() {
        return this.mMinMarginScreen;
    }

    public int getOffsetFromStatusBar() {
        return 22;
    }

    public int getVerticalOffset() {
        return this.mOffsetY;
    }

    public /* synthetic */ void lambda$new$0$ListPopup(View view) {
        this.dismiss();
    }

    public /* synthetic */ void lambda$new$1$ListPopup() {
        PopupWindow.OnDismissListener onDismissListener = this.mOnDismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public /* synthetic */ void lambda$prepareShow$2$ListPopup(AdapterView adapterView, View view, int n, long l) {
        int n2 = n - this.mListView.getHeaderViewsCount();
        if (this.mOnItemClickListener != null && n2 >= 0 && n2 < this.mAdapter.getCount()) {
            this.mOnItemClickListener.onItemClick(adapterView, view, n2, l);
        }
    }

    protected void prepareContentView(Context context) {
        Drawable drawable2 = AttributeResolver.resolveDrawable(this.mContext, R.attr.immersionWindowBackground);
        if (drawable2 != null) {
            drawable2.getPadding(this.mBackgroundPadding);
            this.mRootView.setBackground(drawable2);
        }
        this.setBackgroundDrawable((Drawable)new ColorDrawable(0));
        this.setPopupWindowContentView((View)this.mRootView);
    }

    protected boolean prepareShow(View view, ViewGroup viewGroup) {
        ListView listView;
        int n;
        int n2;
        if (view == null) {
            Log.e((String)TAG, (String)"show: anchor is null");
            return false;
        }
        if (this.mContentView == null) {
            this.mContentView = LayoutInflater.from((Context)this.mContext).inflate(R.layout.miuix_appcompat_list_popup_list, null);
            this.mContentView.addOnLayoutChangeListener(new View.OnLayoutChangeListener(){

                public void onLayoutChange(View view, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
                    view.removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
                    boolean bl = ListPopup.this.mListView.getLastVisiblePosition() == ListPopup.this.mListView.getAdapter().getCount() - 1;
                    ((SpringBackLayout)ListPopup.this.mContentView).setEnabled(bl ^ true);
                }
            });
        }
        if (this.mRootView.getChildCount() != 1 || this.mRootView.getChildAt(0) != this.mContentView) {
            this.mRootView.removeAllViews();
            this.mRootView.addView(this.mContentView);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.mContentView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            layoutParams.gravity = 16;
        }
        if (this.mHasShadow && Build.VERSION.SDK_INT >= 21) {
            this.mRootView.setElevation((float)this.mElevation);
            this.setElevation((float)this.mElevation);
            ListPopup.setPopupShadowAlpha((View)this.mRootView);
        }
        if ((listView = (this.mListView = (ListView)this.mContentView.findViewById(16908298))) == null) {
            Log.e((String)TAG, (String)"list not found");
            return false;
        }
        listView.setOnItemClickListener((AdapterView.OnItemClickListener)new -$$Lambda$ListPopup$EEAHM0S02mwIJGsdW6acNhVxhE4(this));
        this.mListView.setAdapter(this.mAdapter);
        this.setWidth(this.computePopupContentWidth());
        if (DeviceHelper.isTablet() && this.mMaxAllowedHeight > 0 && (n = this.mContentSize.mHeight) > (n2 = this.mMaxAllowedHeight)) {
            this.setHeight(n2);
        }
        ((InputMethodManager)this.mContext.getApplicationContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        return true;
    }

    public void setAdapter(ListAdapter listAdapter) {
        ListAdapter listAdapter2;
        ListAdapter listAdapter3 = this.mAdapter;
        if (listAdapter3 != null) {
            listAdapter3.unregisterDataSetObserver(this.mObserver);
        }
        if ((listAdapter2 = (this.mAdapter = listAdapter)) != null) {
            listAdapter2.registerDataSetObserver(this.mObserver);
        }
    }

    public void setContentWidth(int n) {
        this.mContentSize.updateWidth(n);
    }

    public void setDropDownGravity(int n) {
        this.mDropDownGravity = n;
    }

    public void setHasShadow(boolean bl) {
        this.mHasShadow = bl;
    }

    public void setHorizontalOffset(int n) {
        this.mOffsetX = n;
        this.mOffsetXSet = true;
    }

    public void setMaxAllowedHeight(int n) {
        this.mMaxAllowedHeight = n;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    protected void setPopupWindowContentView(View view) {
        super.setContentView(view);
    }

    public void setVerticalOffset(int n) {
        this.mOffsetY = n;
        this.mOffsetYSet = true;
    }

    public void show(View view, ViewGroup viewGroup) {
        if (this.prepareShow(view, viewGroup)) {
            this.showWithAnchor(view);
        }
    }

    private class ContentSize {
        boolean mHasContentWidth;
        int mHeight;
        int mWidth;

        private ContentSize() {
        }

        public void updateWidth(int n) {
            this.mWidth = n;
            this.mHasContentWidth = true;
        }
    }

}

