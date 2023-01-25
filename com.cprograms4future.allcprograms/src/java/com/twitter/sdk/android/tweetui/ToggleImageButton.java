/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.util.AttributeSet
 *  android.widget.ImageButton
 *  java.lang.CharSequence
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.twitter.sdk.android.tweetui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageButton;
import com.twitter.sdk.android.tweetui.h;

public class ToggleImageButton
extends ImageButton {
    private static final int[] e;
    boolean a;
    String b;
    String c;
    final boolean d;

    static {
        int[] arrn = new int[]{h.b.state_toggled_on};
        e = arrn;
    }

    public ToggleImageButton(Context context) {
        this(context, null);
    }

    public ToggleImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public ToggleImageButton(Context context, AttributeSet attributeSet, int n2) {
        void var4_9;
        TypedArray typedArray;
        block6 : {
            super(context, attributeSet, n2);
            typedArray = context.getTheme().obtainStyledAttributes(attributeSet, h.h.ToggleImageButton, n2, 0);
            try {
                String string = typedArray.getString(h.h.ToggleImageButton_contentDescriptionOn);
                String string2 = typedArray.getString(h.h.ToggleImageButton_contentDescriptionOff);
                if (string == null) {
                    string = (String)this.getContentDescription();
                }
                this.b = string;
                if (string2 == null) {
                    string2 = (String)this.getContentDescription();
                }
                this.c = string2;
                this.d = typedArray.getBoolean(h.h.ToggleImageButton_toggleOnClick, true);
                this.setToggledOn(false);
                if (typedArray == null) return;
            }
            catch (Throwable throwable) {}
            typedArray.recycle();
            return;
            break block6;
            catch (Throwable throwable) {
                typedArray = null;
            }
        }
        if (typedArray == null) throw var4_9;
        typedArray.recycle();
        throw var4_9;
    }

    public void a() {
        this.setToggledOn(true ^ this.a);
    }

    public int[] onCreateDrawableState(int n2) {
        int[] arrn = super.onCreateDrawableState(n2 + 2);
        if (this.a) {
            ToggleImageButton.mergeDrawableStates((int[])arrn, (int[])e);
        }
        return arrn;
    }

    public boolean performClick() {
        if (this.d) {
            this.a();
        }
        return super.performClick();
    }

    public void setToggledOn(boolean bl) {
        this.a = bl;
        String string = bl ? this.b : this.c;
        this.setContentDescription((CharSequence)string);
        this.refreshDrawableState();
    }
}

