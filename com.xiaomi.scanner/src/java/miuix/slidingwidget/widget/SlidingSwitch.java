/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 *  android.widget.Switch
 */
package miuix.slidingwidget.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.CompoundButton;
import android.widget.Switch;
import miuix.slidingwidget.R;
import miuix.slidingwidget.widget.SlidingButtonHelper;

public class SlidingSwitch
extends Switch {
    private SlidingButtonHelper mHelper = new SlidingButtonHelper((CompoundButton)this);

    public SlidingSwitch(Context context) {
        this(context, null);
    }

    public SlidingSwitch(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.slidingButtonStyle);
    }

    public SlidingSwitch(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.mHelper.initDrawable();
        this.mHelper.initAnim();
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.SlidingButton, n, R.style.Widget_SlidingButton_DayNight);
        this.mHelper.initResource(context, typedArray);
        typedArray.recycle();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        SlidingButtonHelper slidingButtonHelper = this.mHelper;
        if (slidingButtonHelper != null) {
            slidingButtonHelper.setSliderDrawState();
        }
    }

    public float getAlpha() {
        SlidingButtonHelper slidingButtonHelper = this.mHelper;
        if (slidingButtonHelper != null) {
            return slidingButtonHelper.getAlpha();
        }
        return super.getAlpha();
    }

    public boolean hasOverlappingRendering() {
        return false;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        SlidingButtonHelper slidingButtonHelper = this.mHelper;
        if (slidingButtonHelper != null) {
            slidingButtonHelper.jumpDrawablesToCurrentState();
        }
    }

    protected void onDraw(Canvas canvas) {
        SlidingButtonHelper slidingButtonHelper = this.mHelper;
        if (slidingButtonHelper == null) {
            super.onDraw(canvas);
            return;
        }
        slidingButtonHelper.onDraw(canvas);
    }

    public void onMeasure(int n, int n2) {
        this.setMeasuredDimension(this.mHelper.getMeasuredWidth(), this.mHelper.getMeasuredHeight());
        this.mHelper.setParentClipChildren();
    }

    protected boolean onSetAlpha(int n) {
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.isEnabled()) {
            return false;
        }
        SlidingButtonHelper slidingButtonHelper = this.mHelper;
        if (slidingButtonHelper != null) {
            slidingButtonHelper.onTouchEvent(motionEvent);
        }
        return true;
    }

    public boolean performClick() {
        super.performClick();
        SlidingButtonHelper slidingButtonHelper = this.mHelper;
        if (slidingButtonHelper != null) {
            slidingButtonHelper.notifyCheckedChangeListener();
        }
        return true;
    }

    public void setAlpha(float f) {
        super.setAlpha(f);
        SlidingButtonHelper slidingButtonHelper = this.mHelper;
        if (slidingButtonHelper != null) {
            slidingButtonHelper.setAlpha(f);
        }
        this.invalidate();
    }

    public void setButtonDrawable(Drawable drawable2) {
    }

    public void setChecked(boolean bl) {
        if (this.isChecked() != bl) {
            super.setChecked(bl);
            boolean bl2 = this.isChecked();
            SlidingButtonHelper slidingButtonHelper = this.mHelper;
            if (slidingButtonHelper != null) {
                slidingButtonHelper.setChecked(bl2);
            }
        }
    }

    public void setOnPerformCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        SlidingButtonHelper slidingButtonHelper = this.mHelper;
        if (slidingButtonHelper != null) {
            slidingButtonHelper.setOnPerformCheckedChangeListener(onCheckedChangeListener);
        }
    }

    public void setPressed(boolean bl) {
        super.setPressed(bl);
        this.invalidate();
    }

    protected boolean verifyDrawable(Drawable drawable2) {
        SlidingButtonHelper slidingButtonHelper;
        return super.verifyDrawable(drawable2) || (slidingButtonHelper = this.mHelper) != null && slidingButtonHelper.verifyDrawable(drawable2);
        {
        }
    }
}

