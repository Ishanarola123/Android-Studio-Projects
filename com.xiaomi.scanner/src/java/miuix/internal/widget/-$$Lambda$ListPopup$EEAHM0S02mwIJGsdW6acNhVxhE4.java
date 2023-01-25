/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 *  java.lang.Object
 */
package miuix.internal.widget;

import android.view.View;
import android.widget.AdapterView;
import miuix.internal.widget.ListPopup;

public final class -$$Lambda$ListPopup$EEAHM0S02mwIJGsdW6acNhVxhE4
implements AdapterView.OnItemClickListener {
    private final /* synthetic */ ListPopup f$0;

    public /* synthetic */ -$$Lambda$ListPopup$EEAHM0S02mwIJGsdW6acNhVxhE4(ListPopup listPopup) {
        this.f$0 = listPopup;
    }

    public final void onItemClick(AdapterView adapterView, View view, int n, long l) {
        this.f$0.lambda$prepareShow$2$ListPopup(adapterView, view, n, l);
    }
}

