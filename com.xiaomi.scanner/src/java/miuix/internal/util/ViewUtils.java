/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  android.view.ViewGroup
 *  java.lang.Object
 *  java.lang.String
 */
package miuix.internal.util;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;

public class ViewUtils {
    static final String TAG = "ViewUtils";

    private ViewUtils() {
    }

    public static boolean containsPoint(View view, int n, int n2) {
        return n > view.getLeft() && n < view.getRight() && n2 > view.getTop() && n2 < view.getBottom();
    }

    public static int getBackgroundHeight(View view) {
        Drawable drawable2 = view.getBackground();
        if (drawable2 != null) {
            return drawable2.getIntrinsicHeight();
        }
        return -1;
    }

    public static int getBackgroundWidth(View view) {
        Drawable drawable2 = view.getBackground();
        if (drawable2 != null) {
            return drawable2.getIntrinsicWidth();
        }
        return -1;
    }

    public static void getContentRect(View view, Rect rect) {
        rect.left = view.getScrollX() + view.getPaddingLeft();
        rect.top = view.getScrollY() + view.getPaddingTop();
        rect.right = view.getWidth() - view.getPaddingRight() - rect.left;
        rect.bottom = view.getHeight() - view.getPaddingBottom() - rect.top;
    }

    public static boolean intersectsWith(View view, Rect rect) {
        return rect != null && view.getLeft() < rect.right && view.getTop() < rect.bottom && view.getRight() > rect.left && view.getBottom() > rect.top;
    }

    public static boolean isLayoutRtl(View view) {
        return view.getLayoutDirection() == 1;
    }

    public static boolean isNightMode(Context context) {
        return (48 & context.getResources().getConfiguration().uiMode) == 32;
    }

    public static void layoutChildView(ViewGroup viewGroup, View view, int n, int n2, int n3, int n4) {
        boolean bl = ViewUtils.isLayoutRtl((View)viewGroup);
        int n5 = viewGroup.getWidth();
        int n6 = bl ? n5 - n3 : n;
        if (bl) {
            n3 = n5 - n;
        }
        view.layout(n6, n2, n3, n4);
    }
}

