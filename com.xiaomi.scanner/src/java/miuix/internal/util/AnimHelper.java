/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  java.lang.Object
 *  miuix.animation.Folme
 *  miuix.animation.ITouchStyle
 *  miuix.animation.ITouchStyle$TouchType
 *  miuix.animation.base.AnimConfig
 */
package miuix.internal.util;

import android.view.View;
import miuix.animation.Folme;
import miuix.animation.ITouchStyle;
import miuix.animation.base.AnimConfig;

public class AnimHelper {
    public static void addPressAnim(View view) {
        Folme.useAt((View[])new View[]{view}).touch().setScale(1.0f, new ITouchStyle.TouchType[0]).handleTouchOf(view, new AnimConfig[0]);
    }

    public static void addPressAnimWithBg(View view) {
        Folme.useAt((View[])new View[]{view}).touch().setTint(0.0f, 0.0f, 0.0f, 0.0f).setScale(1.0f, new ITouchStyle.TouchType[0]).setBackgroundColor(0.08f, 0.0f, 0.0f, 0.0f).handleTouchOf(view, new AnimConfig[0]);
    }
}

