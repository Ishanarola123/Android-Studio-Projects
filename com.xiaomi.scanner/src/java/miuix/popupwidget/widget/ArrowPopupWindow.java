/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.ListView
 *  android.widget.PopupWindow
 *  androidx.appcompat.widget.AppCompatButton
 *  java.lang.CharSequence
 *  java.lang.String
 */
package miuix.popupwidget.widget;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.widget.AppCompatButton;
import miuix.popupwidget.R;
import miuix.popupwidget.internal.widget.ArrowPopupView;

public class ArrowPopupWindow
extends PopupWindow {
    public static final int ARROW_BOTTOM_LEFT_MODE = 18;
    public static final int ARROW_BOTTOM_MODE = 16;
    public static final int ARROW_BOTTOM_RIGHT_MODE = 17;
    public static final int ARROW_LEFT_MODE = 32;
    public static final int ARROW_RIGHT_MODE = 64;
    public static final int ARROW_TOP_LEFT_MODE = 9;
    public static final int ARROW_TOP_MODE = 8;
    public static final int ARROW_TOP_RIGHT_MODE = 10;
    protected ArrowPopupView mArrowPopupView;
    private boolean mAutoDismiss = true;
    private Context mContext;
    private int mListViewMaxHeight;

    public ArrowPopupWindow(Context context) {
        this(context, null);
    }

    public ArrowPopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ArrowPopupWindow(Context context, AttributeSet attributeSet, int n) {
        this(context, attributeSet, n, 0);
    }

    public ArrowPopupWindow(Context context, AttributeSet attributeSet, int n, int n2) {
        super(context, attributeSet, n, n2);
        this.mContext = context;
        this.mAutoDismiss = true;
        this.setupPopupWindow();
    }

    private void setupPopupWindow() {
        this.mListViewMaxHeight = this.mContext.getResources().getDimensionPixelOffset(R.dimen.miuix_appcompat_arrow_popup_window_list_max_height);
        this.mArrowPopupView = (ArrowPopupView)this.getLayoutInflater().inflate(R.layout.miuix_appcompat_arrow_popup_view, null, false);
        super.setContentView((View)this.mArrowPopupView);
        super.setWidth(-1);
        super.setHeight(-1);
        this.setSoftInputMode(3);
        this.mArrowPopupView.setArrowPopupWindow(this);
        super.setTouchInterceptor(this.getDefaultOnTouchListener());
        if (Build.VERSION.SDK_INT >= 21) {
            this.mArrowPopupView.addShadow();
        }
        this.onPrepareWindow();
        this.update();
    }

    public void dismiss(boolean bl) {
        if (bl) {
            this.mArrowPopupView.animateToDismiss();
            return;
        }
        this.dismiss();
    }

    public int getArrowMode() {
        return this.mArrowPopupView.getArrowMode();
    }

    public int getContentHeight() {
        View view = this.getContentView();
        if (view != null) {
            return view.getHeight();
        }
        return 0;
    }

    public View getContentView() {
        return this.mArrowPopupView.getContentView();
    }

    public int getContentWidth() {
        View view = this.getContentView();
        if (view != null) {
            return view.getWidth();
        }
        return 0;
    }

    public Context getContext() {
        return this.mContext;
    }

    public View.OnTouchListener getDefaultOnTouchListener() {
        return this.mArrowPopupView;
    }

    public int getHeight() {
        return this.getContentHeight();
    }

    protected LayoutInflater getLayoutInflater() {
        return LayoutInflater.from((Context)this.mContext);
    }

    public AppCompatButton getNegativeButton() {
        return this.mArrowPopupView.getNegativeButton();
    }

    public AppCompatButton getPositiveButton() {
        return this.mArrowPopupView.getPositiveButton();
    }

    public int getWidth() {
        return this.getContentWidth();
    }

    protected void onPrepareWindow() {
    }

    public void setArrowMode(int n) {
        this.mArrowPopupView.setArrowMode(n);
    }

    public void setAutoDismiss(boolean bl) {
        this.mAutoDismiss = bl;
    }

    public void setContentHeight(int n) {
        int n2;
        View view = this.getContentView();
        if (view instanceof ListView && n > (n2 = this.mListViewMaxHeight)) {
            n = n2;
        }
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = n;
            view.setLayoutParams(layoutParams);
        }
    }

    public final void setContentView(int n) {
        this.mArrowPopupView.setContentView(n);
    }

    public final void setContentView(View view) {
        this.mArrowPopupView.setContentView(view);
    }

    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.mArrowPopupView.setContentView(view, layoutParams);
    }

    public void setContentWidth(int n) {
        View view = this.getContentView();
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = n;
            view.setLayoutParams(layoutParams);
        }
    }

    public void setHeight(int n) {
        this.setContentHeight(n);
    }

    public void setNegativeButton(int n, View.OnClickListener onClickListener) {
        this.setNegativeButton(this.mContext.getString(n), onClickListener);
    }

    public void setNegativeButton(CharSequence charSequence, View.OnClickListener onClickListener) {
        this.mArrowPopupView.setNegativeButton(charSequence, onClickListener);
    }

    public void setPositiveButton(int n, View.OnClickListener onClickListener) {
        this.setPositiveButton(this.mContext.getString(n), onClickListener);
    }

    public void setPositiveButton(CharSequence charSequence, View.OnClickListener onClickListener) {
        this.mArrowPopupView.setPositiveButton(charSequence, onClickListener);
    }

    public void setTitle(int n) {
        this.setTitle(this.mContext.getString(n));
    }

    public void setTitle(CharSequence charSequence) {
        this.mArrowPopupView.setTitle(charSequence);
    }

    public void setTouchInterceptor(View.OnTouchListener onTouchListener) {
        this.mArrowPopupView.setTouchInterceptor(onTouchListener);
    }

    public void setWidth(int n) {
        this.setContentWidth(n);
    }

    public void show(View view, int n, int n2) {
        this.mArrowPopupView.setAnchor(view);
        this.mArrowPopupView.setOffset(n, n2);
        this.showAtLocation(view, 8388659, 0, 0);
        this.mArrowPopupView.setAutoDismiss(this.mAutoDismiss);
        this.mArrowPopupView.animateToShow();
    }

    public void showAsDropDown(View view, int n, int n2) {
        this.show(view, n, n2);
    }

    public void showAsDropDown(View view, int n, int n2, int n3) {
        this.show(view, n, n2);
    }

    public void update(int n, int n2, int n3, int n4, boolean bl) {
        super.update(0, 0, -2, -2, bl);
        this.setContentHeight(n4);
    }
}

