/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.database.DataSetObserver
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.os.Handler
 *  android.os.IBinder
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  android.view.KeyEvent
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.widget.AbsListView
 *  android.widget.AbsListView$OnScrollListener
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.AdapterView$OnItemSelectedListener
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.ListAdapter
 *  android.widget.ListView
 *  android.widget.PopupWindow
 *  android.widget.PopupWindow$OnDismissListener
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package miuix.popupwidget.widget;

import android.content.Context;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.IBinder;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import miuix.popupwidget.widget.ArrowPopupWindow;

public class ListPopupWindow {
    private static final boolean DEBUG = false;
    private static final int EXPAND_LIST_TIMEOUT = 250;
    public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;
    public static final int INPUT_METHOD_NEEDED = 1;
    public static final int INPUT_METHOD_NOT_NEEDED = 2;
    public static final int MATCH_PARENT = -1;
    public static final int POSITION_PROMPT_ABOVE = 0;
    public static final int POSITION_PROMPT_BELOW = 1;
    private static final String TAG = "ListPopupWindow";
    public static final int WRAP_CONTENT = -2;
    private ListAdapter mAdapter;
    private Context mContext;
    private boolean mDropDownAlwaysVisible = false;
    private View mDropDownAnchorView;
    private int mDropDownHeight = -2;
    private int mDropDownHorizontalOffset;
    private DropDownListView mDropDownList;
    private Drawable mDropDownListHighlight;
    private int mDropDownVerticalOffset;
    private boolean mDropDownVerticalOffsetSet;
    private int mDropDownWidth = -2;
    private boolean mForceIgnoreOutsideTouch = false;
    private Handler mHandler = new Handler();
    private final ListSelectorHider mHideSelector = new ListSelectorHider();
    private AdapterView.OnItemClickListener mItemClickListener;
    private AdapterView.OnItemSelectedListener mItemSelectedListener;
    int mListItemExpandMaximum = Integer.MAX_VALUE;
    private boolean mModal;
    private DataSetObserver mObserver;
    private ArrowPopupWindow mPopup;
    private int mPromptPosition = 0;
    private View mPromptView;
    private final ResizePopupRunnable mResizePopupRunnable = new ResizePopupRunnable();
    private final PopupScrollListener mScrollListener = new PopupScrollListener();
    private Runnable mShowDropDownRunnable;
    private Rect mTempRect = new Rect();
    private final PopupTouchInterceptor mTouchInterceptor = new PopupTouchInterceptor();

    public ListPopupWindow(Context context) {
        this(context, null, 16843519);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843519);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int n) {
        this.mContext = context;
        this.mPopup = new ArrowPopupWindow(context, attributeSet, n);
    }

    /*
     * Enabled aggressive block sorting
     */
    private int buildDropDown() {
        int n;
        int n2;
        if (this.mDropDownList == null) {
            Context context = this.mContext;
            this.mShowDropDownRunnable = new Runnable(){

                public void run() {
                    View view = ListPopupWindow.this.getAnchorView();
                    if (view != null && view.getWindowToken() != null) {
                        ListPopupWindow.this.show();
                    }
                }
            };
            this.mDropDownList = new DropDownListView(context, true ^ this.mModal);
            Drawable drawable2 = this.mDropDownListHighlight;
            if (drawable2 != null) {
                this.mDropDownList.setSelector(drawable2);
            }
            this.mDropDownList.setAdapter(this.mAdapter);
            this.mDropDownList.setOnItemClickListener(this.mItemClickListener);
            this.mDropDownList.setFocusable(true);
            this.mDropDownList.setFocusableInTouchMode(true);
            this.mDropDownList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

                public void onItemSelected(AdapterView<?> adapterView, View view, int n, long l) {
                    DropDownListView dropDownListView;
                    if (n != -1 && (dropDownListView = ListPopupWindow.this.mDropDownList) != null) {
                        dropDownListView.mListSelectionHidden = false;
                    }
                }

                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            this.mDropDownList.setOnScrollListener((AbsListView.OnScrollListener)this.mScrollListener);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.mItemSelectedListener;
            if (onItemSelectedListener != null) {
                this.mDropDownList.setOnItemSelectedListener(onItemSelectedListener);
            }
            DropDownListView dropDownListView = this.mDropDownList;
            View view = this.mPromptView;
            if (view != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                int n3 = this.mPromptPosition;
                if (n3 != 0) {
                    if (n3 != 1) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Invalid hint position ");
                        stringBuilder.append(this.mPromptPosition);
                        Log.e((String)TAG, (String)stringBuilder.toString());
                    } else {
                        linearLayout.addView((View)dropDownListView, (ViewGroup.LayoutParams)layoutParams);
                        linearLayout.addView(view);
                    }
                } else {
                    linearLayout.addView(view);
                    linearLayout.addView((View)dropDownListView, (ViewGroup.LayoutParams)layoutParams);
                }
                view.measure(View.MeasureSpec.makeMeasureSpec((int)this.mDropDownWidth, (int)Integer.MIN_VALUE), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams)view.getLayoutParams();
                n = view.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                dropDownListView = linearLayout;
            } else {
                n = 0;
            }
            this.mPopup.setContentView((View)dropDownListView);
        } else {
            View view = this.mPromptView;
            if (view != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)view.getLayoutParams();
                n = view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            } else {
                n = 0;
            }
        }
        Drawable drawable3 = this.mPopup.getBackground();
        if (drawable3 != null) {
            drawable3.getPadding(this.mTempRect);
            n2 = this.mTempRect.top + this.mTempRect.bottom;
            if (!this.mDropDownVerticalOffsetSet) {
                this.mDropDownVerticalOffset = -this.mTempRect.top;
            }
        } else {
            this.mTempRect.setEmpty();
            n2 = 0;
        }
        int n4 = this.mPopup.getInputMethodMode();
        boolean bl = false;
        if (n4 == 2) {
            bl = true;
        }
        int n5 = this.getMaxAvailableHeight(this.getAnchorView(), this.mDropDownVerticalOffset, bl);
        if (this.mDropDownAlwaysVisible) return n5 + n2;
        if (this.mDropDownHeight == -1) {
            return n5 + n2;
        }
        int n6 = this.mDropDownWidth;
        int n7 = n6 != -2 ? (n6 != -1 ? View.MeasureSpec.makeMeasureSpec((int)n6, (int)1073741824) : View.MeasureSpec.makeMeasureSpec((int)(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right)), (int)1073741824)) : View.MeasureSpec.makeMeasureSpec((int)(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right)), (int)Integer.MIN_VALUE);
        int n8 = n7;
        int n9 = this.mDropDownList.measureHeightOfChildrenCompact(n8, 0, -1, n5 - n, -1);
        if (n9 <= 0) return n9 + n;
        n += n2;
        return n9 + n;
    }

    private void removePromptView() {
        ViewParent viewParent;
        View view = this.mPromptView;
        if (view != null && (viewParent = view.getParent()) instanceof ViewGroup) {
            ((ViewGroup)viewParent).removeView(this.mPromptView);
        }
    }

    public void clearListSelection() {
        DropDownListView dropDownListView = this.mDropDownList;
        if (dropDownListView != null) {
            dropDownListView.mListSelectionHidden = true;
            dropDownListView.requestLayout();
        }
    }

    public void dismiss() {
        this.dismiss(true);
    }

    public void dismiss(boolean bl) {
        this.mPopup.dismiss(bl);
        this.removePromptView();
        this.mDropDownList = null;
        this.mHandler.removeCallbacks((Runnable)this.mResizePopupRunnable);
    }

    public View getAnchorView() {
        return this.mDropDownAnchorView;
    }

    public int getAnimationStyle() {
        return this.mPopup.getAnimationStyle();
    }

    public Drawable getBackground() {
        return this.mPopup.getBackground();
    }

    public int getHeight() {
        return this.mDropDownHeight;
    }

    public int getHorizontalOffset() {
        return this.mDropDownHorizontalOffset;
    }

    public int getInputMethodMode() {
        return this.mPopup.getInputMethodMode();
    }

    public ListView getListView() {
        return this.mDropDownList;
    }

    public int getMaxAvailableHeight(View view, int n, boolean bl) {
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        int[] arrn = new int[2];
        view.getLocationOnScreen(arrn);
        int n2 = rect.bottom;
        if (bl) {
            n2 = view.getContext().getResources().getDisplayMetrics().heightPixels;
        }
        int n3 = Math.max((int)(n2 - (arrn[1] + view.getHeight()) - n), (int)(n + (arrn[1] - rect.top)));
        if (this.mPopup.getBackground() != null) {
            this.mPopup.getBackground().getPadding(this.mTempRect);
            n3 -= this.mTempRect.top + this.mTempRect.bottom;
        }
        return n3;
    }

    public ArrowPopupWindow getPopupWindow() {
        return this.mPopup;
    }

    public int getPromptPosition() {
        return this.mPromptPosition;
    }

    public Object getSelectedItem() {
        if (!this.isShowing()) {
            return null;
        }
        return this.mDropDownList.getSelectedItem();
    }

    public long getSelectedItemId() {
        if (!this.isShowing()) {
            return Long.MIN_VALUE;
        }
        return this.mDropDownList.getSelectedItemId();
    }

    public int getSelectedItemPosition() {
        if (!this.isShowing()) {
            return -1;
        }
        return this.mDropDownList.getSelectedItemPosition();
    }

    public View getSelectedView() {
        if (!this.isShowing()) {
            return null;
        }
        return this.mDropDownList.getSelectedView();
    }

    public int getSoftInputMode() {
        return this.mPopup.getSoftInputMode();
    }

    public int getVerticalOffset() {
        if (!this.mDropDownVerticalOffsetSet) {
            return 0;
        }
        return this.mDropDownVerticalOffset;
    }

    public int getWidth() {
        return this.mDropDownWidth;
    }

    public boolean isDropDownAlwaysVisible() {
        return this.mDropDownAlwaysVisible;
    }

    public boolean isInputMethodNotNeeded() {
        return this.mPopup.getInputMethodMode() == 2;
    }

    public boolean isModal() {
        return this.mModal;
    }

    public boolean isShowing() {
        return this.mPopup.isShowing();
    }

    public boolean onKeyDown(int n, KeyEvent keyEvent) {
        if (this.isShowing() && n != 62 && (this.mDropDownList.getSelectedItemPosition() >= 0 || n != 66 && n != 23)) {
            int n2;
            int n3 = this.mDropDownList.getSelectedItemPosition();
            boolean bl = true ^ this.mPopup.isAboveAnchor();
            ListAdapter listAdapter = this.mAdapter;
            int n4 = Integer.MAX_VALUE;
            if (listAdapter != null) {
                boolean bl2 = listAdapter.areAllItemsEnabled();
                int n5 = bl2 ? 0 : this.mDropDownList.lookForSelectablePosition(0, true);
                n2 = bl2 ? listAdapter.getCount() - 1 : this.mDropDownList.lookForSelectablePosition(listAdapter.getCount() - 1, false);
                n4 = n5;
            } else {
                n2 = Integer.MIN_VALUE;
            }
            if (bl && n == 19 && n3 <= n4 || !bl && n == 20 && n3 >= n2) {
                this.clearListSelection();
                this.mPopup.setInputMethodMode(1);
                this.show();
                return true;
            }
            this.mDropDownList.mListSelectionHidden = false;
            if (this.mDropDownList.onKeyDown(n, keyEvent)) {
                this.mPopup.setInputMethodMode(2);
                this.mDropDownList.requestFocusFromTouch();
                this.show();
                return n == 19 || n == 20 || n == 23 || n == 66;
            }
            if (bl && n == 20 ? n3 == n2 : !bl && n == 19 && n3 == n4) {
                return true;
            }
        }
        return false;
    }

    public boolean onKeyUp(int n, KeyEvent keyEvent) {
        if (this.isShowing() && this.mDropDownList.getSelectedItemPosition() >= 0) {
            boolean bl = this.mDropDownList.onKeyUp(n, keyEvent);
            if (bl) {
                if (n != 23 && n != 66) {
                    return bl;
                }
                this.dismiss(true);
            }
            return bl;
        }
        return false;
    }

    public boolean performItemClick(int n) {
        if (this.isShowing()) {
            if (this.mItemClickListener != null) {
                DropDownListView dropDownListView = this.mDropDownList;
                View view = dropDownListView.getChildAt(n - dropDownListView.getFirstVisiblePosition());
                ListAdapter listAdapter = dropDownListView.getAdapter();
                this.mItemClickListener.onItemClick((AdapterView)dropDownListView, view, n, listAdapter.getItemId(n));
            }
            return true;
        }
        return false;
    }

    public void postShow() {
        this.mHandler.post(this.mShowDropDownRunnable);
    }

    public void setAdapter(ListAdapter listAdapter) {
        DropDownListView dropDownListView;
        DataSetObserver dataSetObserver = this.mObserver;
        if (dataSetObserver == null) {
            this.mObserver = new PopupDataSetObserver();
        } else {
            ListAdapter listAdapter2 = this.mAdapter;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.mAdapter = listAdapter;
        if (this.mAdapter != null) {
            listAdapter.registerDataSetObserver(this.mObserver);
        }
        if ((dropDownListView = this.mDropDownList) != null) {
            dropDownListView.setAdapter(this.mAdapter);
        }
    }

    public void setAnchorView(View view) {
        this.mDropDownAnchorView = view;
    }

    public void setAnimationStyle(int n) {
        this.mPopup.setAnimationStyle(n);
    }

    public void setBackgroundDrawable(Drawable drawable2) {
        this.mPopup.setBackgroundDrawable(drawable2);
    }

    public void setContentWidth(int n) {
        Drawable drawable2 = this.mPopup.getBackground();
        if (drawable2 != null) {
            drawable2.getPadding(this.mTempRect);
            this.mDropDownWidth = n + (this.mTempRect.left + this.mTempRect.right);
            return;
        }
        this.setWidth(n);
    }

    public void setDropDownAlwaysVisible(boolean bl) {
        this.mDropDownAlwaysVisible = bl;
    }

    public void setForceIgnoreOutsideTouch(boolean bl) {
        this.mForceIgnoreOutsideTouch = bl;
    }

    public void setHeight(int n) {
        this.mDropDownHeight = n;
    }

    public void setHorizontalOffset(int n) {
        this.mDropDownHorizontalOffset = n;
    }

    public void setInputMethodMode(int n) {
        this.mPopup.setInputMethodMode(n);
    }

    void setListItemExpandMax(int n) {
        this.mListItemExpandMaximum = n;
    }

    public void setListSelector(Drawable drawable2) {
        this.mDropDownListHighlight = drawable2;
    }

    public void setModal(boolean bl) {
        this.mModal = true;
        this.mPopup.setFocusable(bl);
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.mPopup.setOnDismissListener(onDismissListener);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.mItemClickListener = onItemClickListener;
    }

    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.mItemSelectedListener = onItemSelectedListener;
    }

    public void setPromptPosition(int n) {
        this.mPromptPosition = n;
    }

    public void setPromptView(View view) {
        boolean bl = this.isShowing();
        if (bl) {
            this.removePromptView();
        }
        this.mPromptView = view;
        if (bl) {
            this.show();
        }
    }

    public void setSelection(int n) {
        DropDownListView dropDownListView = this.mDropDownList;
        if (this.isShowing() && dropDownListView != null) {
            dropDownListView.mListSelectionHidden = false;
            dropDownListView.setSelection(n);
            if (dropDownListView.getChoiceMode() != 0) {
                dropDownListView.setItemChecked(n, true);
            }
        }
    }

    public void setSoftInputMode(int n) {
        this.mPopup.setSoftInputMode(n);
    }

    public void setVerticalOffset(int n) {
        this.mDropDownVerticalOffset = n;
        this.mDropDownVerticalOffsetSet = true;
    }

    public void setWidth(int n) {
        this.mDropDownWidth = n;
    }

    public void show() {
        int n;
        int n2 = this.buildDropDown();
        int n3 = this.mDropDownWidth;
        if (n3 != -1) {
            if (n3 == -2) {
                this.mPopup.setContentWidth(this.getAnchorView().getWidth());
            } else {
                this.mPopup.setContentWidth(n3);
            }
        }
        if ((n = this.mDropDownHeight) != -1) {
            if (n == -2) {
                this.mPopup.setContentHeight(n2);
            } else {
                this.mPopup.setContentHeight(n);
            }
        }
        ArrowPopupWindow arrowPopupWindow = this.mPopup;
        boolean bl = true;
        arrowPopupWindow.setFocusable(bl);
        if (this.mPopup.isShowing()) {
            ArrowPopupWindow arrowPopupWindow2 = this.mPopup;
            if (this.mForceIgnoreOutsideTouch || this.mDropDownAlwaysVisible) {
                bl = false;
            }
            arrowPopupWindow2.setOutsideTouchable(bl);
            this.mPopup.update(this.getAnchorView(), this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset, this.mDropDownWidth, n2);
            return;
        }
        this.mPopup.setWindowLayoutMode(-1, -1);
        ArrowPopupWindow arrowPopupWindow3 = this.mPopup;
        if (this.mForceIgnoreOutsideTouch || this.mDropDownAlwaysVisible) {
            bl = false;
        }
        arrowPopupWindow3.setOutsideTouchable(bl);
        this.mPopup.setTouchInterceptor(this.mTouchInterceptor);
        this.mPopup.show(this.getAnchorView(), this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset);
        this.mDropDownList.setSelection(-1);
        if (!this.mModal || this.mDropDownList.isInTouchMode()) {
            this.clearListSelection();
        }
        if (!this.mModal) {
            this.mHandler.post((Runnable)this.mHideSelector);
        }
    }

    private static class DropDownListView
    extends ListView {
        public static final int INVALID_POSITION = -1;
        static final int NO_POSITION = -1;
        private boolean mHijackFocus;
        private boolean mListSelectionHidden;

        public DropDownListView(Context context, boolean bl) {
            super(context, null, 16842861);
            this.mHijackFocus = bl;
            this.setCacheColorHint(0);
        }

        private int lookForSelectablePosition(int n, boolean bl) {
            ListAdapter listAdapter = this.getAdapter();
            if (listAdapter != null) {
                if (this.isInTouchMode()) {
                    return -1;
                }
                int n2 = listAdapter.getCount();
                if (!this.getAdapter().areAllItemsEnabled()) {
                    int n3;
                    if (bl) {
                        for (n3 = Math.max((int)0, (int)n); n3 < n2 && !listAdapter.isEnabled(n3); ++n3) {
                        }
                    } else {
                        for (n3 = Math.min((int)n, (int)(n2 - 1)); n3 >= 0 && !listAdapter.isEnabled(n3); --n3) {
                        }
                    }
                    if (n3 >= 0) {
                        if (n3 >= n2) {
                            return -1;
                        }
                        return n3;
                    }
                    return -1;
                }
                if (n >= 0) {
                    if (n >= n2) {
                        return -1;
                    }
                    return n;
                }
            }
            return -1;
        }

        public boolean hasFocus() {
            return this.mHijackFocus || super.hasFocus();
            {
            }
        }

        public boolean hasWindowFocus() {
            return this.mHijackFocus || super.hasWindowFocus();
            {
            }
        }

        public boolean isFocused() {
            return this.mHijackFocus || super.isFocused();
            {
            }
        }

        public boolean isInTouchMode() {
            return this.mHijackFocus && this.mListSelectionHidden || super.isInTouchMode();
        }

        final int measureHeightOfChildrenCompact(int n, int n2, int n3, int n4, int n5) {
            int n6 = this.getListPaddingTop();
            int n7 = this.getListPaddingBottom();
            int n8 = this.getDividerHeight();
            Drawable drawable2 = this.getDivider();
            ListAdapter listAdapter = this.getAdapter();
            if (listAdapter == null) {
                return n6 + n7;
            }
            int n9 = n6 + n7;
            if (n8 <= 0 || drawable2 == null) {
                n8 = 0;
            }
            int n10 = listAdapter.getCount();
            int n11 = n9;
            View view = null;
            int n12 = 0;
            int n13 = 0;
            for (int i = 0; i < n10; ++i) {
                int n14 = listAdapter.getItemViewType(i);
                if (n14 != n12) {
                    view = null;
                    n12 = n14;
                }
                view = listAdapter.getView(i, view, (ViewGroup)this);
                int n15 = view.getLayoutParams().height;
                int n16 = n15 > 0 ? View.MeasureSpec.makeMeasureSpec((int)n15, (int)1073741824) : View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
                view.measure(n, n16);
                if (i > 0) {
                    n11 += n8;
                }
                if ((n11 += view.getMeasuredHeight()) >= n4) {
                    if (n5 >= 0 && i > n5 && n13 > 0 && n11 != n4) {
                        n4 = n13;
                    }
                    return n4;
                }
                if (n5 < 0 || i < n5) continue;
                n13 = n11;
            }
            return n11;
        }
    }

    private class ListSelectorHider
    implements Runnable {
        private ListSelectorHider() {
        }

        public void run() {
            ListPopupWindow.this.clearListSelection();
        }
    }

    private class PopupDataSetObserver
    extends DataSetObserver {
        private PopupDataSetObserver() {
        }

        public void onChanged() {
            if (ListPopupWindow.this.isShowing()) {
                ListPopupWindow.this.show();
            }
        }

        public void onInvalidated() {
            ListPopupWindow.this.dismiss(true);
        }
    }

    private class PopupScrollListener
    implements AbsListView.OnScrollListener {
        private PopupScrollListener() {
        }

        public void onScroll(AbsListView absListView, int n, int n2, int n3) {
        }

        public void onScrollStateChanged(AbsListView absListView, int n) {
            if (n == 1 && !ListPopupWindow.this.isInputMethodNotNeeded() && ListPopupWindow.this.mPopup.getContentView() != null) {
                ListPopupWindow.this.mHandler.removeCallbacks((Runnable)ListPopupWindow.this.mResizePopupRunnable);
                ListPopupWindow.this.mResizePopupRunnable.run();
            }
        }
    }

    private class PopupTouchInterceptor
    implements View.OnTouchListener {
        private PopupTouchInterceptor() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int n = motionEvent.getAction();
            int n2 = (int)motionEvent.getX();
            int n3 = (int)motionEvent.getY();
            if (n == 0 && ListPopupWindow.this.mPopup != null && ListPopupWindow.this.mPopup.isShowing() && n2 >= 0 && n2 < ListPopupWindow.this.mPopup.getContentWidth() && n3 >= 0 && n3 < ListPopupWindow.this.mPopup.getContentHeight()) {
                ListPopupWindow.this.mHandler.postDelayed((Runnable)ListPopupWindow.this.mResizePopupRunnable, 250L);
            } else if (n == 1) {
                ListPopupWindow.this.mHandler.removeCallbacks((Runnable)ListPopupWindow.this.mResizePopupRunnable);
            }
            return false;
        }
    }

    private class ResizePopupRunnable
    implements Runnable {
        private ResizePopupRunnable() {
        }

        public void run() {
            if (ListPopupWindow.this.mDropDownList != null && ListPopupWindow.this.mDropDownList.getCount() > ListPopupWindow.this.mDropDownList.getChildCount() && ListPopupWindow.this.mDropDownList.getChildCount() <= ListPopupWindow.this.mListItemExpandMaximum) {
                ListPopupWindow.this.mPopup.setInputMethodMode(2);
                ListPopupWindow.this.show();
            }
        }
    }

}

