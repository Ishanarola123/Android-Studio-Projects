/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Looper
 *  android.util.TypedValue
 *  java.lang.InstantiationException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Thread
 *  java.lang.ThreadLocal
 */
package miuix.internal.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.TypedValue;

public class AttributeResolver {
    private static final TypedValue TYPED_VALUE = new TypedValue();
    private static final ThreadLocal<TypedValue> TYPED_VALUE_THREAD_LOCAL = new ThreadLocal();

    protected AttributeResolver() throws InstantiationException {
        throw new InstantiationException("Cannot instantiate utility class");
    }

    private static TypedValue getTypedValue(Context context) {
        if (context.getMainLooper().getThread() == Thread.currentThread()) {
            return TYPED_VALUE;
        }
        TypedValue typedValue = (TypedValue)TYPED_VALUE_THREAD_LOCAL.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            TYPED_VALUE_THREAD_LOCAL.set((Object)typedValue);
        }
        return typedValue;
    }

    private static Integer innerResolveColor(Context context, int n) {
        TypedValue typedValue = AttributeResolver.getTypedValue(context);
        if (context.getTheme().resolveAttribute(n, typedValue, true)) {
            if (typedValue.resourceId > 0) {
                return context.getResources().getColor(typedValue.resourceId);
            }
            if (typedValue.type >= 28 && typedValue.type <= 31) {
                return typedValue.data;
            }
        }
        return null;
    }

    public static int resolve(Context context, int n) {
        TypedValue typedValue = AttributeResolver.getTypedValue(context);
        if (context.getTheme().resolveAttribute(n, typedValue, true)) {
            return typedValue.resourceId;
        }
        return -1;
    }

    public static boolean resolveBoolean(Context context, int n, boolean bl) {
        TypedValue typedValue = AttributeResolver.getTypedValue(context);
        if (context.getTheme().resolveAttribute(n, typedValue, true)) {
            if (typedValue.type == 18 && typedValue.data != 0) {
                return true;
            }
            bl = false;
        }
        return bl;
    }

    public static int resolveColor(Context context, int n) {
        Integer n2 = AttributeResolver.innerResolveColor(context, n);
        if (n2 != null) {
            return n2;
        }
        return context.getResources().getColor(-1);
    }

    public static int resolveColor(Context context, int n, int n2) {
        Integer n3 = AttributeResolver.innerResolveColor(context, n);
        if (n3 != null) {
            return n3;
        }
        return n2;
    }

    public static float resolveDimension(Context context, int n) {
        return context.getResources().getDimension(AttributeResolver.resolve(context, n));
    }

    public static int resolveDimensionPixelSize(Context context, int n) {
        return context.getResources().getDimensionPixelSize(AttributeResolver.resolve(context, n));
    }

    public static Drawable resolveDrawable(Context context, int n) {
        TypedValue typedValue = AttributeResolver.getTypedValue(context);
        if (context.getTheme().resolveAttribute(n, typedValue, true)) {
            if (typedValue.resourceId > 0) {
                if (Build.VERSION.SDK_INT >= 21) {
                    return context.getResources().getDrawable(typedValue.resourceId, context.getTheme());
                }
                return context.getResources().getDrawable(typedValue.resourceId);
            }
            if (typedValue.type >= 28 && typedValue.type <= 31) {
                return new ColorDrawable(typedValue.data);
            }
        }
        return null;
    }

    public static float resolveFloat(Context context, int n, float f) {
        TypedValue typedValue = AttributeResolver.getTypedValue(context);
        if (context.getTheme().resolveAttribute(n, typedValue, true) && typedValue.type == 4) {
            f = typedValue.data;
        }
        return f;
    }

    public static int resolveInt(Context context, int n, int n2) {
        TypedValue typedValue = AttributeResolver.getTypedValue(context);
        if (context.getTheme().resolveAttribute(n, typedValue, true) && typedValue.type == 16) {
            n2 = typedValue.data;
        }
        return n2;
    }
}

