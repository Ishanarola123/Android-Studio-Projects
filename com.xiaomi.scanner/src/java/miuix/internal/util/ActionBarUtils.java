/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewParent
 *  java.lang.Object
 *  miuix.appcompat.R
 *  miuix.appcompat.R$id
 *  miuix.appcompat.app.ActionBar
 *  miuix.appcompat.app.ActionBar$OnScrollListener
 *  miuix.appcompat.internal.app.widget.ActionBarMovableLayout
 *  miuix.appcompat.internal.app.widget.ActionBarOverlayLayout
 */
package miuix.internal.util;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import miuix.appcompat.R;
import miuix.appcompat.app.ActionBar;
import miuix.appcompat.internal.app.widget.ActionBarMovableLayout;
import miuix.appcompat.internal.app.widget.ActionBarOverlayLayout;

public class ActionBarUtils {
    private ActionBarUtils() {
    }

    public static ViewGroup getActionBarOverlayLayout(View view) {
        while (view != null) {
            if (view instanceof ActionBarOverlayLayout) {
                return (ActionBarOverlayLayout)view;
            }
            if (view.getParent() instanceof View) {
                view = (View)view.getParent();
                continue;
            }
            view = null;
        }
        return null;
    }

    public static void setOnScrollListener(Activity activity, ActionBar.OnScrollListener onScrollListener) {
        ((ActionBarMovableLayout)activity.findViewById(R.id.action_bar_overlay_layout)).setOnScrollListener(onScrollListener);
    }
}

