/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.graphics.drawable.AnimatedStateListDrawable
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.graphics.drawable.DrawableContainer
 *  android.graphics.drawable.DrawableContainer$DrawableContainerState
 *  androidx.annotation.RequiresApi
 */
package miuix.internal.view;

import android.content.res.Resources;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import androidx.annotation.RequiresApi;

@RequiresApi(api=21)
public class CheckWidgetAnimatedStateListDrawable
extends AnimatedStateListDrawable {
    protected CheckWidgetConstantState mCheckWidgetConstantState;

    public CheckWidgetAnimatedStateListDrawable() {
        this.mCheckWidgetConstantState = this.newCheckWidgetConstantState();
    }

    protected CheckWidgetAnimatedStateListDrawable(Resources resources, Resources.Theme theme, CheckWidgetConstantState checkWidgetConstantState) {
        Drawable drawable2 = resources == null ? checkWidgetConstantState.mParent.newDrawable() : (theme == null ? checkWidgetConstantState.mParent.newDrawable(resources) : checkWidgetConstantState.mParent.newDrawable(resources, theme));
        checkWidgetConstantState.mParent = drawable2.getConstantState();
        this.setConstantState((DrawableContainer.DrawableContainerState)checkWidgetConstantState.mParent);
        this.onStateChange(this.getState());
        this.jumpToCurrentState();
        this.mCheckWidgetConstantState.grayColor = checkWidgetConstantState.grayColor;
        this.mCheckWidgetConstantState.blackColor = checkWidgetConstantState.blackColor;
        this.mCheckWidgetConstantState.backGroundColor = checkWidgetConstantState.backGroundColor;
        this.mCheckWidgetConstantState.touchAnimEnable = checkWidgetConstantState.touchAnimEnable;
    }

    public boolean canApplyTheme() {
        return true;
    }

    public Drawable.ConstantState getConstantState() {
        return this.mCheckWidgetConstantState;
    }

    protected CheckWidgetConstantState newCheckWidgetConstantState() {
        return new CheckWidgetConstantState();
    }

    protected void setConstantState(DrawableContainer.DrawableContainerState drawableContainerState) {
        super.setConstantState(drawableContainerState);
        if (this.mCheckWidgetConstantState == null) {
            this.mCheckWidgetConstantState = this.newCheckWidgetConstantState();
        }
        this.mCheckWidgetConstantState.mParent = drawableContainerState;
    }

    public static class CheckWidgetConstantState
    extends Drawable.ConstantState {
        int backGroundColor;
        int backgroundDisableAlpha;
        int backgroundNormalAlpha;
        int blackColor;
        int grayColor;
        Drawable.ConstantState mParent;
        int strokeColor;
        int strokeDisableAlpha;
        int strokeNormalAlpha;
        boolean touchAnimEnable;

        public boolean canApplyTheme() {
            return this.mParent.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.mParent.getChangingConfigurations();
        }

        protected Drawable newAnimatedStateListDrawable(Resources resources, Resources.Theme theme, CheckWidgetConstantState checkWidgetConstantState) {
            return new CheckWidgetAnimatedStateListDrawable(resources, theme, checkWidgetConstantState);
        }

        public Drawable newDrawable() {
            if (this.mParent == null) {
                return null;
            }
            return this.newAnimatedStateListDrawable(null, null, this);
        }

        public Drawable newDrawable(Resources resources) {
            if (this.mParent == null) {
                return null;
            }
            return this.newAnimatedStateListDrawable(resources, null, this);
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            if (this.mParent == null) {
                return null;
            }
            return this.newAnimatedStateListDrawable(resources, theme, this);
        }
    }

}

