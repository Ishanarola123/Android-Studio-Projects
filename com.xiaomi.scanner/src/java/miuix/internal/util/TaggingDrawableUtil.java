/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.StateListDrawable
 *  android.view.View
 *  java.lang.Object
 *  miuix.appcompat.R
 *  miuix.appcompat.R$dimen
 *  miuix.internal.graphics.drawable.TaggingDrawable
 */
package miuix.internal.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import miuix.appcompat.R;
import miuix.internal.graphics.drawable.TaggingDrawable;

public class TaggingDrawableUtil {
    private static final int[] STATES_TAGS = new int[]{16842915, 16842916, 16842917, 16842918};
    private static final int[] STATE_SET_FIRST;
    private static final int[] STATE_SET_LAST;
    private static final int[] STATE_SET_MIDDLE;
    private static final int[] STATE_SET_SINGLE;
    private static final int UNINITIAL = -1;
    private static int mPaddingLarge = -1;
    private static int mPaddingSingle = -1;
    private static int mPaddingSmall = -1;

    static {
        STATE_SET_SINGLE = new int[]{16842915};
        STATE_SET_FIRST = new int[]{16842916};
        STATE_SET_MIDDLE = new int[]{16842917};
        STATE_SET_LAST = new int[]{16842918};
    }

    private static int getDimen(Context context, int n) {
        return context.getResources().getDimensionPixelSize(n);
    }

    public static void updateBackgroundState(View view, int n, int n2) {
        if (view != null) {
            if (n2 == 0) {
                return;
            }
            Drawable drawable2 = view.getBackground();
            if (drawable2 instanceof StateListDrawable && TaggingDrawable.containsTagState((StateListDrawable)((StateListDrawable)drawable2), (int[])STATES_TAGS)) {
                TaggingDrawable taggingDrawable = new TaggingDrawable(drawable2);
                view.setBackground((Drawable)taggingDrawable);
                drawable2 = taggingDrawable;
            }
            if (drawable2 instanceof TaggingDrawable) {
                TaggingDrawable taggingDrawable = (TaggingDrawable)drawable2;
                int[] arrn = n2 == 1 ? STATE_SET_SINGLE : (n == 0 ? STATE_SET_FIRST : (n == n2 - 1 ? STATE_SET_LAST : STATE_SET_MIDDLE));
                taggingDrawable.setTaggingState(arrn);
            }
        }
    }

    public static void updateItemBackground(View view, int n, int n2) {
        TaggingDrawableUtil.updateBackgroundState(view, n, n2);
        TaggingDrawableUtil.updateItemPadding(view, n, n2);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static void updateItemPadding(View var0, int var1_1, int var2_2) {
        block8 : {
            if (var0 == null) return;
            if (var2_2 == 0) {
                return;
            }
            var3_3 = var0.getContext();
            var4_4 = var0.getPaddingStart();
            var0.getPaddingTop();
            var6_5 = var0.getPaddingEnd();
            var0.getPaddingBottom();
            if (var2_2 != 1) break block8;
            if (TaggingDrawableUtil.mPaddingSingle == -1) {
                TaggingDrawableUtil.mPaddingSingle = TaggingDrawableUtil.getDimen(var3_3, R.dimen.miuix_appcompat_drop_down_menu_padding_single_item);
            }
            var8_6 = TaggingDrawableUtil.mPaddingSingle;
            ** GOTO lbl28
        }
        if (TaggingDrawableUtil.mPaddingSmall == -1) {
            TaggingDrawableUtil.mPaddingSmall = TaggingDrawableUtil.getDimen(var3_3, R.dimen.miuix_appcompat_drop_down_menu_padding_small);
        }
        if (TaggingDrawableUtil.mPaddingLarge == -1) {
            TaggingDrawableUtil.mPaddingLarge = TaggingDrawableUtil.getDimen(var3_3, R.dimen.miuix_appcompat_drop_down_menu_padding_large);
        }
        if (var1_1 == 0) {
            var8_6 = TaggingDrawableUtil.mPaddingLarge;
            var9_7 = TaggingDrawableUtil.mPaddingSmall;
        } else if (var1_1 == var2_2 - 1) {
            var8_6 = TaggingDrawableUtil.mPaddingSmall;
            var9_7 = TaggingDrawableUtil.mPaddingLarge;
        } else {
            var8_6 = TaggingDrawableUtil.mPaddingSmall;
lbl28: // 2 sources:
            var9_7 = var8_6;
        }
        var0.setPaddingRelative(var4_4, var8_6, var6_5, var9_7);
    }
}

