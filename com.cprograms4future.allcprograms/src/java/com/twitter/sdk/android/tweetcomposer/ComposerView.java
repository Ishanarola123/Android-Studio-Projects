/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.text.Editable
 *  android.text.TextWatcher
 *  android.util.AttributeSet
 *  android.view.KeyEvent
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.EditText
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  android.widget.TextView$OnEditorActionListener
 *  com.twitter.sdk.android.tweetcomposer.ComposerView$5
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Locale
 */
package com.twitter.sdk.android.tweetcomposer;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.a.a.t;
import com.a.a.x;
import com.twitter.sdk.android.core.a.r;
import com.twitter.sdk.android.core.internal.f;
import com.twitter.sdk.android.tweetcomposer.ComposerView;
import com.twitter.sdk.android.tweetcomposer.f;
import com.twitter.sdk.android.tweetcomposer.internal.util.ObservableScrollView;
import com.twitter.sdk.android.tweetcomposer.j;
import java.util.Locale;

public class ComposerView
extends LinearLayout {
    ImageView a;
    ImageView b;
    EditText c;
    TextView d;
    Button e;
    ObservableScrollView f;
    View g;
    ColorDrawable h;
    ViewGroup i;
    f.a j;
    private t k;

    public ComposerView(Context context) {
        this(context, null);
    }

    public ComposerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a(context);
    }

    public ComposerView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.a(context);
    }

    private void a(Context context) {
        this.k = t.a(this.getContext());
        this.h = new ColorDrawable(context.getResources().getColor(j.a.tw__composer_light_gray));
        ComposerView.inflate((Context)context, (int)j.d.tw__composer_view, (ViewGroup)this);
    }

    void a() {
        this.a = (ImageView)this.findViewById(j.c.tw__author_avatar);
        this.b = (ImageView)this.findViewById(j.c.tw__composer_close);
        this.c = (EditText)this.findViewById(j.c.tw__edit_tweet);
        this.d = (TextView)this.findViewById(j.c.tw__char_count);
        this.e = (Button)this.findViewById(j.c.tw__post_tweet);
        this.f = (ObservableScrollView)this.findViewById(j.c.tw__composer_scroll_view);
        this.g = this.findViewById(j.c.tw__composer_profile_divider);
        this.i = (ViewGroup)this.findViewById(j.c.tw__card_view);
    }

    void a(boolean bl) {
        this.e.setEnabled(bl);
    }

    String getTweetText() {
        return this.c.getText().toString();
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.a();
        this.b.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                ComposerView.this.j.a();
            }
        });
        this.e.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                ComposerView.this.j.b(ComposerView.this.getTweetText());
            }
        });
        this.c.setOnEditorActionListener(new TextView.OnEditorActionListener(){

            public boolean onEditorAction(TextView textView, int n2, KeyEvent keyEvent) {
                ComposerView.this.j.b(ComposerView.this.getTweetText());
                return true;
            }
        });
        this.c.addTextChangedListener(new TextWatcher(){

            public void afterTextChanged(Editable editable) {
                ComposerView.this.j.a(ComposerView.this.getTweetText());
            }

            public void beforeTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
            }

            public void onTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
            }
        });
        this.f.setScrollViewListener((ObservableScrollView.a)new 5(this));
    }

    void setCallbacks(f.a a2) {
        this.j = a2;
    }

    void setCardView(View view) {
        this.i.addView(view);
        this.i.setVisibility(0);
    }

    void setCharCount(int n2) {
        TextView textView = this.d;
        Locale locale = Locale.getDefault();
        Object[] arrobject = new Object[]{n2};
        textView.setText((CharSequence)String.format((Locale)locale, (String)"%d", (Object[])arrobject));
    }

    void setCharCountTextStyle(int n2) {
        this.d.setTextAppearance(this.getContext(), n2);
    }

    void setProfilePhotoView(r r2) {
        String string = com.twitter.sdk.android.core.internal.f.a(r2, f.a.e);
        if (this.k != null) {
            this.k.a(string).a((Drawable)this.h).a(this.a);
        }
    }

    void setTweetText(String string) {
        this.c.setText((CharSequence)string);
    }

}

