/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.SubMenu
 *  android.widget.PopupWindow
 *  android.widget.PopupWindow$OnDismissListener
 *  java.lang.Object
 *  miuix.internal.widget.PopupMenuWindow
 */
package miuix.internal.widget;

import android.view.SubMenu;
import android.widget.PopupWindow;
import miuix.internal.widget.PopupMenuWindow;

public final class -$$Lambda$PopupMenuWindow$K8XAqnRastPelOAVKwmzHaXRtqg
implements PopupWindow.OnDismissListener {
    private final /* synthetic */ PopupMenuWindow f$0;
    private final /* synthetic */ SubMenu f$1;

    public /* synthetic */ -$$Lambda$PopupMenuWindow$K8XAqnRastPelOAVKwmzHaXRtqg(PopupMenuWindow popupMenuWindow, SubMenu subMenu) {
        this.f$0 = popupMenuWindow;
        this.f$1 = subMenu;
    }

    public final void onDismiss() {
        this.f$0.lambda$null$0$PopupMenuWindow(this.f$1);
    }
}

