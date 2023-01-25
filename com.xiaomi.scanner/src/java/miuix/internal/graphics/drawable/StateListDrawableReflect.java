/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.StateListDrawable
 *  java.lang.Object
 */
package miuix.internal.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;

public class StateListDrawableReflect {
    private StateListDrawableReflect() {
    }

    public static int getStateCount(StateListDrawable stateListDrawable) {
        return stateListDrawable.getStateCount();
    }

    public static Drawable getStateDrawable(StateListDrawable stateListDrawable, int n) {
        return stateListDrawable.getStateDrawable(n);
    }

    public static int[] getStateSet(StateListDrawable stateListDrawable, int n) {
        return stateListDrawable.getStateSet(n);
    }
}

