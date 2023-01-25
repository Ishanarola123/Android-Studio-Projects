/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.FloatProperty
 *  java.lang.Object
 *  java.lang.String
 *  miuix.overscroller.internal.dynamicanimation.animation.FloatPropertyCompat$1
 */
package miuix.overscroller.internal.dynamicanimation.animation;

import android.util.FloatProperty;
import miuix.overscroller.internal.dynamicanimation.animation.FloatPropertyCompat;

public abstract class FloatPropertyCompat<T> {
    final String mPropertyName;

    public FloatPropertyCompat(String string2) {
        this.mPropertyName = string2;
    }

    public static <T> FloatPropertyCompat<T> createFloatPropertyCompat(FloatProperty<T> floatProperty) {
        return new 1(floatProperty.getName(), floatProperty);
    }

    public abstract float getValue(T var1);

    public abstract void setValue(T var1, float var2);
}

