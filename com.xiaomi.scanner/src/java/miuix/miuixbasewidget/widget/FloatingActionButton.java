/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.ColorFilter
 *  android.graphics.Paint
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.LayerDrawable
 *  android.graphics.drawable.ShapeDrawable
 *  android.graphics.drawable.StateListDrawable
 *  android.graphics.drawable.shapes.OvalShape
 *  android.graphics.drawable.shapes.Shape
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.view.View
 *  android.widget.ImageView
 *  androidx.annotation.NonNull
 *  androidx.annotation.Nullable
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.ref.WeakReference
 *  miuix.animation.Folme
 *  miuix.animation.ITouchStyle
 *  miuix.animation.base.AnimConfig
 *  miuix.view.HapticCompat
 *  miuix.view.HapticFeedbackConstants
 */
package miuix.miuixbasewidget.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import miuix.animation.Folme;
import miuix.animation.ITouchStyle;
import miuix.animation.base.AnimConfig;
import miuix.miuixbasewidget.R;
import miuix.view.HapticCompat;
import miuix.view.HapticFeedbackConstants;

public class FloatingActionButton
extends ImageView {
    private static final int PRESSED_MASK_COLOR = 218103808;
    private static final int SHADOW_ALPHA = 25;
    private static final float SHADOW_RADIUS = 5.45f;
    private static final float X_OFFSET = 0.0f;
    private static final float Y_OFFSET = 5.45f;
    private Drawable mDefaultBackground;
    private EmptyHolder mEmptyHolder;
    private int mFabColor;
    private boolean mHasFabColor;
    private final boolean mIsShadowEnabled;
    private final int mShadowRadius;
    private final int mShadowXOffset;
    private final int mShadowYOffset;

    public FloatingActionButton(Context context) {
        this(context, null);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int n) {
        int n2;
        super(context, attributeSet, n);
        float f = this.getContext().getResources().getDisplayMetrics().density;
        this.mShadowXOffset = (int)(0.0f * f);
        this.mShadowYOffset = n2 = (int)(f * 5.45f);
        this.mShadowRadius = n2;
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.FloatingActionButton, n, R.style.Widget_FloatingActionButton);
        this.mIsShadowEnabled = typedArray.getBoolean(R.styleable.FloatingActionButton_fabShadowEnabled, true);
        this.mHasFabColor = typedArray.hasValue(R.styleable.FloatingActionButton_fabColor);
        this.mFabColor = typedArray.getColor(R.styleable.FloatingActionButton_fabColor, context.getResources().getColor(R.color.miuix_appcompat_fab_color_light));
        typedArray.recycle();
        this.mEmptyHolder = new EmptyHolder(this.getContext().getResources().getDrawable(R.drawable.miuix_appcompat_fab_empty_holder));
        this.initBackground();
        this.updatePadding();
        Folme.useAt((View[])new View[]{this}).touch().setTint(0).handleTouchOf((View)this, new AnimConfig[0]);
    }

    private int computeShadowColor(int n) {
        return Color.argb((int)25, (int)Color.red((int)n), (int)Math.max((int)0, (int)(-30 + Color.green((int)n))), (int)Color.blue((int)n));
    }

    private Drawable createFabBackground() {
        ShapeDrawable shapeDrawable = new ShapeDrawable((Shape)new OvalShapeWithPadding((View)this));
        if (this.mIsShadowEnabled) {
            int n = this.computeShadowColor(this.mFabColor);
            int n2 = Build.VERSION.SDK_INT >= 28 ? 2 : 1;
            this.setLayerType(n2, shapeDrawable.getPaint());
            shapeDrawable.getPaint().setShadowLayer((float)this.mShadowRadius, (float)this.mShadowXOffset, (float)this.mShadowYOffset, n);
        }
        shapeDrawable.getPaint().setColor(this.mFabColor);
        Drawable[] arrdrawable = new Drawable[]{shapeDrawable, this.mEmptyHolder};
        LayerDrawable layerDrawable = new LayerDrawable(arrdrawable);
        ShapeDrawable shapeDrawable2 = new ShapeDrawable((Shape)new OvalShapeWithPadding((View)this));
        shapeDrawable2.getPaint().setColor(218103808);
        LayerDrawable layerDrawable2 = new LayerDrawable(new Drawable[]{layerDrawable, shapeDrawable2});
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(PRESSED_ENABLED_STATE_SET, (Drawable)layerDrawable2);
        stateListDrawable.addState(ENABLED_SELECTED_STATE_SET, (Drawable)layerDrawable2);
        stateListDrawable.addState(EMPTY_STATE_SET, (Drawable)layerDrawable);
        return stateListDrawable;
    }

    private Drawable getDefaultBackground() {
        if (this.mDefaultBackground == null) {
            this.mFabColor = this.getContext().getResources().getColor(R.color.miuix_appcompat_fab_color_light);
            this.mHasFabColor = true;
            this.mDefaultBackground = this.createFabBackground();
        }
        return this.mDefaultBackground;
    }

    private void initBackground() {
        if (this.getBackground() == null) {
            if (this.mHasFabColor) {
                super.setBackground(this.createFabBackground());
                return;
            }
            super.setBackground(this.getDefaultBackground());
            return;
        }
        this.mHasFabColor = false;
    }

    private void initEmptyHolder() {
        int n = this.getPaddingLeft();
        int n2 = this.getPaddingTop();
        int n3 = this.getPaddingRight();
        int n4 = (this.getWidth() - n - n3) / 2;
        EmptyHolder emptyHolder = this.mEmptyHolder;
        int n5 = n4 * 2;
        emptyHolder.setBounds(n, n2, n + n5, n5 + n2);
    }

    private void updatePadding() {
        if (this.mIsShadowEnabled && this.mHasFabColor) {
            this.setPadding(Math.max((int)0, (int)(this.mShadowRadius - this.mShadowXOffset)), Math.max((int)0, (int)(this.mShadowRadius - this.mShadowYOffset)), Math.max((int)0, (int)(this.mShadowRadius + this.mShadowXOffset)), Math.max((int)0, (int)(this.mShadowRadius + this.mShadowYOffset)));
            return;
        }
        this.setPadding(0, 0, 0, 0);
    }

    protected void onDraw(Canvas canvas) {
        this.initEmptyHolder();
        super.onDraw(canvas);
    }

    public boolean performClick() {
        HapticCompat.performHapticFeedback((View)this, (int)HapticFeedbackConstants.MIUI_TAP_LIGHT);
        return super.performClick();
    }

    public void setBackground(Drawable drawable2) {
        this.mHasFabColor = false;
        if (drawable2 == null) {
            drawable2 = this.getDefaultBackground();
        }
        super.setBackground(drawable2);
        this.updatePadding();
    }

    public void setBackgroundColor(int n) {
        if (!this.mHasFabColor || this.mFabColor != n) {
            this.mFabColor = n;
            super.setBackground(this.createFabBackground());
            this.updatePadding();
        }
        this.mHasFabColor = true;
    }

    public void setBackgroundResource(int n) {
        this.mHasFabColor = false;
        if (n == 0) {
            super.setBackground(this.getDefaultBackground());
        } else {
            super.setBackgroundResource(n);
        }
        this.updatePadding();
    }

    class EmptyHolder
    extends Drawable {
        private Drawable mDrawable;
        private Paint mPaint;

        EmptyHolder(Drawable drawable2) {
            this.mDrawable = drawable2;
            this.mPaint = new Paint();
        }

        public void draw(@NonNull Canvas canvas) {
            int n = FloatingActionButton.this.getWidth();
            int n2 = FloatingActionButton.this.getPaddingLeft();
            int n3 = FloatingActionButton.this.getPaddingTop();
            int n4 = FloatingActionButton.this.getPaddingRight();
            int n5 = (n - n2 - n4) / 2;
            Drawable drawable2 = this.mDrawable;
            int n6 = n5 * 2;
            drawable2.setBounds(n2, n3, n2 + n6, n6 + n3);
            this.mDrawable.draw(canvas);
        }

        public int getOpacity() {
            return this.mDrawable.getOpacity();
        }

        public void setAlpha(int n) {
            this.mDrawable.setAlpha(n);
        }

        public void setColorFilter(@Nullable ColorFilter colorFilter) {
            this.mDrawable.setColorFilter(colorFilter);
        }
    }

    private static class OvalShapeWithPadding
    extends OvalShape {
        private WeakReference<View> mViewRef;

        public OvalShapeWithPadding() {
            this.mViewRef = new WeakReference(null);
        }

        public OvalShapeWithPadding(View view) {
            this.mViewRef = new WeakReference((Object)view);
        }

        public void draw(Canvas canvas, Paint paint) {
            View view = (View)this.mViewRef.get();
            if (view != null) {
                int n = view.getWidth();
                int n2 = view.getPaddingLeft();
                int n3 = view.getPaddingTop();
                int n4 = view.getPaddingRight();
                int n5 = (n - n2 - n4) / 2;
                int n6 = n2 + n5;
                int n7 = n3 + n5;
                canvas.drawCircle((float)n6, (float)n7, (float)n5, paint);
            }
        }
    }

}

