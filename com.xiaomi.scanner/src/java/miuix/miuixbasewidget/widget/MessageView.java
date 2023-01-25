/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.TextView
 *  androidx.appcompat.content.res.AppCompatResources
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  miuix.animation.Folme
 *  miuix.animation.ITouchStyle
 *  miuix.animation.ITouchStyle$TouchType
 *  miuix.animation.IVisibleStyle
 *  miuix.animation.base.AnimConfig
 */
package miuix.miuixbasewidget.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import miuix.animation.Folme;
import miuix.animation.ITouchStyle;
import miuix.animation.IVisibleStyle;
import miuix.animation.base.AnimConfig;
import miuix.miuixbasewidget.R;

public class MessageView
extends LinearLayout {
    private boolean mClosable;
    private Drawable mCloseBackground;
    private int mCloseIndex;
    private OnMessageViewCloseListener mOnMessageViewCloseListener;
    private TextView mTextView;

    public MessageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MessageView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.initView(context, attributeSet, n);
    }

    private void addCloseIcon() {
        ImageView imageView = new ImageView(this.getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMarginStart(this.getResources().getDimensionPixelSize(R.dimen.miuix_appcompat_message_view_text_margin_right));
        imageView.setId(R.id.close);
        imageView.setBackground(this.mCloseBackground);
        imageView.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                Folme.useAt((View[])new View[]{view}).visible().setFlags(1L).hide(new AnimConfig[0]);
                MessageView.this.setVisibility(8);
                if (MessageView.this.mOnMessageViewCloseListener != null) {
                    MessageView.this.mOnMessageViewCloseListener.onClosed();
                }
            }
        });
        this.addView((View)imageView, (ViewGroup.LayoutParams)layoutParams);
        Folme.useAt((View[])new View[]{imageView}).touch().handleTouchOf((View)imageView, new AnimConfig[0]);
    }

    private void initView(Context context, AttributeSet attributeSet, int n) {
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.MessageView, n, R.style.Widget_MessageView);
        String string2 = typedArray.getString(R.styleable.MessageView_android_text);
        ColorStateList colorStateList = AppCompatResources.getColorStateList((Context)context, (int)typedArray.getResourceId(R.styleable.MessageView_android_textColor, R.color.miuix_appcompat_message_view_text_color_light));
        this.mCloseBackground = AppCompatResources.getDrawable((Context)context, (int)typedArray.getResourceId(R.styleable.MessageView_closeBackground, R.drawable.miuix_appcompat_ic_message_view_close_guide_light));
        boolean bl = typedArray.getBoolean(R.styleable.MessageView_closable, true);
        typedArray.recycle();
        this.mTextView = new TextView(this.getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.weight = 1.0f;
        this.mTextView.setId(16908308);
        this.mTextView.setPaddingRelative(10, 0, 0, 0);
        this.mTextView.setText((CharSequence)string2);
        this.mTextView.setTextColor(colorStateList);
        this.mTextView.setTextSize(0, (float)this.getResources().getDimensionPixelSize(R.dimen.miuix_appcompat_message_view_text_size));
        this.mTextView.setTextDirection(5);
        this.addView((View)this.mTextView, (ViewGroup.LayoutParams)layoutParams);
        this.setClosable(bl);
        this.setGravity(16);
        Folme.useAt((View[])new View[]{this}).touch().setScale(1.0f, new ITouchStyle.TouchType[0]).handleTouchOf((View)this, new AnimConfig[0]);
    }

    public void setClosable(boolean bl) {
        View view = this.findViewById(R.id.close);
        if (bl) {
            if (view == null) {
                this.addCloseIcon();
                return;
            }
        } else if (view != null) {
            this.removeView(view);
        }
    }

    public void setMessage(CharSequence charSequence) {
        this.mTextView.setText(charSequence);
    }

    public void setOnMessageViewCloseListener(OnMessageViewCloseListener onMessageViewCloseListener) {
        this.mOnMessageViewCloseListener = onMessageViewCloseListener;
    }

    public static interface OnMessageViewCloseListener {
        public void onClosed();
    }

}

