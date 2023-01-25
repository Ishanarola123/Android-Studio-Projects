/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Message
 *  android.text.TextPaint
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnLayoutChangeListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.ViewParent
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.SectionIndexer
 *  android.widget.TextView
 *  androidx.appcompat.content.res.AppCompatResources
 *  androidx.appcompat.widget.ViewUtils
 *  androidx.core.view.AccessibilityDelegateCompat
 *  androidx.core.view.ViewCompat
 *  java.lang.CharSequence
 *  java.lang.Double
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.HashMap
 *  miuix.animation.Folme
 *  miuix.animation.IVisibleStyle
 *  miuix.animation.IVisibleStyle$VisibleType
 *  miuix.animation.base.AnimConfig
 *  miuix.animation.listener.TransitionListener
 *  miuix.miuixbasewidget.widget.AlphabetIndexer$2
 *  miuix.miuixbasewidget.widget.AlphabetIndexer$3
 *  miuix.miuixbasewidget.widget.AlphabetIndexer$IndexerTouchHelper
 *  miuix.view.HapticCompat
 *  miuix.view.HapticFeedbackConstants
 */
package miuix.miuixbasewidget.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SectionIndexer;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.ViewUtils;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import java.util.HashMap;
import miuix.animation.Folme;
import miuix.animation.IVisibleStyle;
import miuix.animation.base.AnimConfig;
import miuix.animation.listener.TransitionListener;
import miuix.miuixbasewidget.R;
import miuix.miuixbasewidget.widget.-$$Lambda$AlphabetIndexer$EFzw0Ci39-ROWdtLrZp19Uq0wo4;
import miuix.miuixbasewidget.widget.-$$Lambda$AlphabetIndexer$yAXW6heoJfI49Nw6va7pQ7KeZGY;
import miuix.miuixbasewidget.widget.AlphabetIndexer;
import miuix.view.HapticCompat;
import miuix.view.HapticFeedbackConstants;

/*
 * Exception performing whole class analysis.
 */
public class AlphabetIndexer
extends LinearLayout {
    private static final int MSG_FADE = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SCROLL = 1;
    private static final String STARRED_LABEL = "\u2665";
    public static final String STARRED_TITLE = "!";
    public static final int STATE_NONE;
    private final int INVALID_INDEX;
    private Adapter mAdapter;
    private boolean mCancelOverlayTextColorAnim;
    private boolean mDrawOverlay;
    private Handler mHandler;
    private int mIndexWidth;
    private SectionIndexer mIndexer;
    private IndexerTouchHelper mIndexerTouchHelper;
    private int mItemHeight;
    private int mItemMargin;
    private int mLastAlphabetIndex;
    private TextView mLastSelectedItem;
    private int mListScrollState;
    private TextView mOverlay;
    private Drawable mOverlayBackground;
    private int mOverlayHeight;
    private AnimConfig mOverlayHideAnimConfig;
    private AnimConfig mOverlayShowAnimConfig;
    private int mOverlayTextAppearanceRes;
    private int mOverlayTextColor;
    private TextPaint mOverlayTextPaint;
    private int mOverlayTextSize;
    private int mOverlayWidth;
    HashMap<Object, Integer> mSectionMap;
    private TextHighlighter mTextHighlighter;
    private int mVerticalPosition;

    public AlphabetIndexer(Context context) {
        this(context, null);
    }

    public AlphabetIndexer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.miuixAppcompatAlphabetIndexerStyle);
    }

    public AlphabetIndexer(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.INVALID_INDEX = -1;
        this.mSectionMap = new HashMap();
        this.mListScrollState = 0;
        this.mHandler = new Handler(){

            public void handleMessage(Message message) {
                if (message.what != 1) {
                    return;
                }
                AlphabetIndexer.this.hideOverlay();
            }
        };
        this.parseAttrs(attributeSet, n);
        this.init();
    }

    static /* synthetic */ void access$100(AlphabetIndexer alphabetIndexer, int n) {
        alphabetIndexer.stop(n);
    }

    static /* synthetic */ void access$200(AlphabetIndexer alphabetIndexer, float f) {
        alphabetIndexer.updateOverlayTranslationX(f);
    }

    static /* synthetic */ boolean access$300(AlphabetIndexer alphabetIndexer) {
        return alphabetIndexer.mCancelOverlayTextColorAnim;
    }

    static /* synthetic */ boolean access$302(AlphabetIndexer alphabetIndexer, boolean bl) {
        alphabetIndexer.mCancelOverlayTextColorAnim = bl;
        return bl;
    }

    static /* synthetic */ void access$400(AlphabetIndexer alphabetIndexer, float f) {
        alphabetIndexer.updateOverlayTextAlpha(f);
    }

    static /* synthetic */ void access$600(AlphabetIndexer alphabetIndexer, int n) {
        alphabetIndexer.setChecked(n);
    }

    static /* synthetic */ SectionIndexer access$700(AlphabetIndexer alphabetIndexer) {
        return alphabetIndexer.getSectionIndexer();
    }

    static /* synthetic */ void access$800(AlphabetIndexer alphabetIndexer, int n, SectionIndexer sectionIndexer) {
        alphabetIndexer.scrollToSelection(n, sectionIndexer);
    }

    private int calculateIndex(float f, int n) {
        block3 : {
            View view;
            block2 : {
                view = this.getChildAt(n);
                if (!(f > (float)view.getBottom())) break block2;
                for (int i = n + 1; i < this.getChildCount(); ++i) {
                    if (!(f < (float)this.getChildAt(i).getBottom())) continue;
                    return i;
                }
                break block3;
            }
            if (!(f < (float)view.getTop())) break block3;
            for (int i = n - 1; i > 0; --i) {
                if (!(f > (float)this.getChildAt(i).getTop())) continue;
                return i;
            }
        }
        return n;
    }

    private int calculateOverlayPosition(int n) {
        int n2 = this.normalizeIndex(n);
        View view = this.getChildAt(n2);
        if (view == null) {
            return 0;
        }
        int n3 = (view.getTop() + view.getBottom()) / 2;
        if (n3 <= 0) {
            double d2 = n2 + 1;
            Double.isNaN((double)d2);
            double d3 = d2 + 0.5;
            double d4 = this.mItemHeight;
            Double.isNaN((double)d4);
            double d5 = d3 * d4;
            double d6 = this.getPaddingTop();
            Double.isNaN((double)d6);
            n3 = (int)(d5 + d6);
        }
        return n3 + this.getMarginTop();
    }

    private void checkItemHeight() {
        int n = this.getChildAt(0).getHeight();
        if (n != 0) {
            int n2 = this.mItemHeight;
            if (n < n2) {
                int n3 = Math.min((int)(n2 - n), (int)(2 * this.mItemMargin)) / 2;
                View view = this.getChildAt(0);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)view.getLayoutParams();
                layoutParams.topMargin -= n3;
                layoutParams.bottomMargin -= n3;
                view.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
                return;
            }
            if (n != n2) {
                this.mItemHeight = n;
            }
        }
    }

    private void clearLastChecked() {
        for (int i = 0; i < this.getChildCount(); ++i) {
            ((TextView)this.getChildAt(i)).setTextColor(this.mTextHighlighter.mNormalColor);
        }
    }

    private void constructItem() {
        int n;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 1;
        layoutParams.bottomMargin = n = this.mItemMargin;
        layoutParams.topMargin = n;
        layoutParams.weight = 1.0f;
        Typeface typeface = Typeface.create((String)"mipro-medium", (int)0);
        for (String string2 : this.mTextHighlighter.mIndexes) {
            TextView textView = new TextView(this.getContext());
            textView.setTypeface(typeface);
            textView.setGravity(17);
            textView.setHeight(this.mItemHeight);
            textView.setTextColor(this.mTextHighlighter.mNormalColor);
            textView.setTextSize(0, (float)this.mTextHighlighter.mIndexerTextSize);
            if (TextUtils.equals((CharSequence)string2, (CharSequence)STARRED_TITLE)) {
                string2 = STARRED_LABEL;
            }
            textView.setText((CharSequence)string2);
            this.attachViewToParent((View)textView, -1, (ViewGroup.LayoutParams)layoutParams);
        }
    }

    private void constructOverlay() {
        if (this.mDrawOverlay) {
            FrameLayout frameLayout = (FrameLayout)this.getParent();
            this.mOverlay = new TextView(this.getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mOverlayWidth, this.mOverlayHeight, 8388613);
            layoutParams.topMargin = ((FrameLayout.LayoutParams)this.getLayoutParams()).topMargin;
            layoutParams.setMarginEnd(1 + (this.mIndexWidth + this.getMarinEnd()));
            this.mOverlay.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            this.mOverlay.setTextAlignment(5);
            this.mOverlay.setBackgroundDrawable(this.mOverlayBackground);
            this.mOverlay.setGravity(16);
            this.mOverlay.setTextSize(0, (float)this.mOverlayTextSize);
            this.mOverlay.setTextColor(this.mOverlayTextColor);
            this.mOverlay.setVisibility(0);
            this.mOverlay.setAlpha(0.0f);
            this.mOverlay.setScaleX(0.0f);
            this.mOverlay.setScaleY(0.0f);
            if (Build.VERSION.SDK_INT >= 23) {
                this.mOverlay.setTextAppearance(this.mOverlayTextAppearanceRes);
            }
            this.mOverlayTextPaint = this.mOverlay.getPaint();
            frameLayout.addView((View)this.mOverlay);
        }
    }

    private void drawThumb(CharSequence charSequence) {
        if (!TextUtils.isEmpty((CharSequence)charSequence)) {
            int n = this.normalizeIndex(this.getIndex(charSequence.toString().toUpperCase()));
            this.clearLastChecked();
            this.setChecked(n);
        }
    }

    private void drawThumbInternal(CharSequence charSequence, float f) {
        if (this.mAdapter == null) {
            return;
        }
        if (this.mOverlay != null) {
            this.mCancelOverlayTextColorAnim = true;
            if (TextUtils.equals((CharSequence)charSequence, (CharSequence)STARRED_TITLE)) {
                charSequence = STARRED_LABEL;
            }
            if (!TextUtils.equals((CharSequence)this.mOverlay.getText(), (CharSequence)charSequence)) {
                HapticCompat.performHapticFeedback((View)this, (int)HapticFeedbackConstants.MIUI_MESH_NORMAL);
            }
            this.mOverlay.setTranslationY(f - (float)this.getMarginTop());
            this.updateOverlayTextAlpha(1.0f);
            this.mOverlay.setText(charSequence);
            int n = (int)this.mOverlayTextPaint.measureText(charSequence.toString());
            int n2 = (this.mOverlayHeight - n) / 2;
            this.mOverlay.setPaddingRelative(n2, 0, 0, 0);
            this.mOverlay.setVisibility(0);
            this.showOverlay();
        }
    }

    private int getIndex(String string2) {
        int n = this.mLastAlphabetIndex;
        for (int i = 0; i < this.mTextHighlighter.mIndexes.length; ++i) {
            if (!TextUtils.equals((CharSequence)string2, (CharSequence)this.mTextHighlighter.mIndexes[i])) continue;
            n = i;
        }
        if (n == -1) {
            return 0;
        }
        return n;
    }

    private int getListOffset() {
        return this.mAdapter.getListHeaderCount();
    }

    private int getMarginTop() {
        return ((ViewGroup.MarginLayoutParams)this.getLayoutParams()).topMargin;
    }

    private int getMarinEnd() {
        return ((ViewGroup.MarginLayoutParams)this.getLayoutParams()).getMarginEnd();
    }

    private int getPosition(int n, SectionIndexer sectionIndexer) {
        Object[] arrobject = sectionIndexer.getSections();
        if (arrobject == null) {
            return -1;
        }
        if (this.getHeight() - this.getPaddingTop() - this.getPaddingBottom() <= 0) {
            return -1;
        }
        if (n < 0) {
            return -1;
        }
        if (n >= this.mTextHighlighter.mIndexes.length) {
            return arrobject.length;
        }
        this.mSectionMap.clear();
        for (int i = 0; i < arrobject.length; ++i) {
            this.mSectionMap.put((Object)arrobject[i].toString().toUpperCase(), (Object)i);
        }
        String[] arrstring = this.mTextHighlighter.mIndexes;
        int n2 = 0;
        do {
            block12 : {
                int n3;
                block11 : {
                    int n4;
                    block10 : {
                        if ((n4 = n2 + n) < arrstring.length) break block10;
                        n3 = 0;
                        if (n < n2) break block11;
                    }
                    int n5 = n - n2;
                    if (n4 < arrstring.length && this.mSectionMap.containsKey((Object)arrstring[n4])) {
                        return (Integer)this.mSectionMap.get((Object)arrstring[n4]);
                    }
                    if (n5 < 0 || !this.mSectionMap.containsKey((Object)arrstring[n5])) break block12;
                    n3 = (Integer)this.mSectionMap.get((Object)arrstring[n5]);
                }
                return n3;
            }
            ++n2;
        } while (true);
    }

    private SectionIndexer getSectionIndexer() {
        return this.mIndexer;
    }

    private boolean hasShown() {
        TextView textView = this.mOverlay;
        return textView != null && textView.getVisibility() == 0 && this.mOverlay.getAlpha() == 1.0f;
    }

    private void hideOverlay() {
        TextView textView = this.mOverlay;
        if (textView != null) {
            IVisibleStyle iVisibleStyle = Folme.useAt((View[])new View[]{textView}).visible().setFlags(1L);
            IVisibleStyle.VisibleType[] arrvisibleType = new IVisibleStyle.VisibleType[]{IVisibleStyle.VisibleType.SHOW};
            IVisibleStyle iVisibleStyle2 = iVisibleStyle.setScale(1.0f, arrvisibleType);
            IVisibleStyle.VisibleType[] arrvisibleType2 = new IVisibleStyle.VisibleType[]{IVisibleStyle.VisibleType.HIDE};
            IVisibleStyle iVisibleStyle3 = iVisibleStyle2.setScale(0.0f, arrvisibleType2);
            AnimConfig[] arranimConfig = new AnimConfig[]{this.mOverlayHideAnimConfig};
            iVisibleStyle3.hide(arranimConfig);
        }
    }

    private void init() {
        this.mVerticalPosition = 8388613;
        this.setGravity(1);
        this.setOrientation(1);
        this.initAnimConfig();
        this.constructItem();
        this.post((Runnable)new -$$Lambda$AlphabetIndexer$EFzw0Ci39-ROWdtLrZp19Uq0wo4(this));
        this.addOnLayoutChangeListener(new View.OnLayoutChangeListener(){

            public void onLayoutChange(View view, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
                AlphabetIndexer.this.removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
                AlphabetIndexer.this.checkItemHeight();
            }
        });
        this.setClickable(true);
        this.mIndexerTouchHelper = new /* Unavailable Anonymous Inner Class!! */;
        ViewCompat.setAccessibilityDelegate((View)this, (AccessibilityDelegateCompat)this.mIndexerTouchHelper);
    }

    private void initAnimConfig() {
        AnimConfig animConfig = this.mOverlayShowAnimConfig = new AnimConfig();
        TransitionListener[] arrtransitionListener = new TransitionListener[]{new 2(this)};
        animConfig.addListeners(arrtransitionListener);
        AnimConfig animConfig2 = this.mOverlayHideAnimConfig = new AnimConfig();
        TransitionListener[] arrtransitionListener2 = new TransitionListener[]{new 3(this)};
        animConfig2.addListeners(arrtransitionListener2);
    }

    public static /* synthetic */ void lambda$yAXW6heoJfI49Nw6va7pQ7KeZGY(AlphabetIndexer alphabetIndexer) {
        alphabetIndexer.checkItemHeight();
    }

    private int normalizeIndex(int n) {
        if (n < 0) {
            return 0;
        }
        if (n >= this.getChildCount()) {
            n = -1 + this.getChildCount();
        }
        return n;
    }

    private void parseAttrs(AttributeSet attributeSet, int n) {
        Resources resources = this.getContext().getResources();
        TypedArray typedArray = this.getContext().obtainStyledAttributes(attributeSet, R.styleable.MiuixAppcompatAlphabetIndexer, n, R.style.Widget_AlphabetIndexer_Starred_DayNight);
        this.mTextHighlighter = new TextHighlighter(this.getContext(), typedArray);
        this.mDrawOverlay = typedArray.getBoolean(R.styleable.MiuixAppcompatAlphabetIndexer_miuixAppcompatDrawOverlay, true);
        if (this.mDrawOverlay) {
            this.mOverlayTextSize = typedArray.getDimensionPixelSize(R.styleable.MiuixAppcompatAlphabetIndexer_miuixAppcompatOverlayTextSize, resources.getDimensionPixelSize(R.dimen.miuix_appcompat_alphabet_indexer_overlay_text_size));
            this.mOverlayTextColor = typedArray.getColor(R.styleable.MiuixAppcompatAlphabetIndexer_miuixAppcompatOverlayTextColor, resources.getColor(R.color.miuix_appcompat_alphabet_indexer_overlay_text_color));
            this.mOverlayTextAppearanceRes = typedArray.getResourceId(R.styleable.MiuixAppcompatAlphabetIndexer_miuixAppCompatOverlayTextAppearance, R.style.Widget_TextAppearance_AlphabetIndexer_Overlay);
            this.mOverlayBackground = typedArray.getDrawable(R.styleable.MiuixAppcompatAlphabetIndexer_miuixAppcompatOverlayBackground);
            this.mItemHeight = resources.getDimensionPixelOffset(R.dimen.miuix_appcompat_alphabet_indexer_item_height);
            this.mItemMargin = resources.getDimensionPixelOffset(R.dimen.miuix_appcompat_alphabet_indexer_item_margin);
            this.mOverlayWidth = resources.getDimensionPixelOffset(R.dimen.miuix_appcompat_alphabet_overlay_width);
            this.mOverlayHeight = resources.getDimensionPixelOffset(R.dimen.miuix_appcompat_alphabet_overlay_height);
            this.mIndexWidth = resources.getDimensionPixelOffset(R.dimen.miuix_appcompat_alphabet_indexer_min_width);
        }
        typedArray.recycle();
    }

    private void refreshMask() {
        String string2;
        int n;
        if (this.mAdapter == null) {
            return;
        }
        SectionIndexer sectionIndexer = this.getSectionIndexer();
        if (sectionIndexer == null) {
            return;
        }
        int n2 = sectionIndexer.getSectionForPosition(this.mAdapter.getFirstVisibleItemPosition() - this.getListOffset());
        if (n2 != -1 && !TextUtils.isEmpty((CharSequence)(string2 = (String)sectionIndexer.getSections()[n2]))) {
            String string3 = string2.toUpperCase();
            for (n = 0; n < this.mTextHighlighter.mIndexes.length; ++n) {
                if (!TextUtils.equals((CharSequence)string3, (CharSequence)this.mTextHighlighter.mIndexes[n])) {
                    continue;
                }
                break;
            }
        } else {
            n = -1;
        }
        if (n != -1 && this.mLastAlphabetIndex != n) {
            this.mLastAlphabetIndex = this.normalizeIndex(n);
        }
    }

    private void scrollTo(SectionIndexer sectionIndexer, int n) {
        int n2;
        Adapter adapter = this.mAdapter;
        if (adapter == null) {
            return;
        }
        adapter.stopScroll();
        int n3 = this.mAdapter.getItemCount();
        int n4 = this.getListOffset();
        float f = 1.0f / (float)n3 / 8.0f;
        Object[] arrobject = sectionIndexer.getSections();
        if (arrobject != null && arrobject.length > 1) {
            int n5;
            int n6;
            int n7;
            int n8;
            int n9;
            int n10;
            block10 : {
                n10 = arrobject.length;
                n7 = n >= n10 ? n10 - 1 : n;
                int n11 = sectionIndexer.getPositionForSection(n7);
                n6 = n7 + 1;
                n8 = n7 < n10 - 1 ? sectionIndexer.getPositionForSection(n6) : n3;
                if (n8 == n11) {
                    n9 = n7;
                    n5 = n11;
                    while (n9 > 0) {
                        if ((n5 = sectionIndexer.getPositionForSection(--n9)) != n11) break block9;
                        if (n9 != 0) continue;
                        n9 = n7;
                        n2 = 0;
                        break block10;
                    }
                    n9 = n2 = n7;
                } else {
                    block9 : {
                        n9 = n7;
                        n5 = n11;
                    }
                    n2 = n9;
                }
            }
            int n12 = n6 + 1;
            while (n12 < n10 && sectionIndexer.getPositionForSection(n12) == n8) {
                ++n12;
                ++n6;
            }
            float f2 = n9;
            float f3 = n10;
            float f4 = f2 / f3;
            float f5 = (float)n6 / f3;
            float f6 = (float)n / f3;
            if (n9 != n7 || !(f6 - f4 < f)) {
                n5 += Math.round((float)((float)(n8 - n5) * (f6 - f4) / (f5 - f4)));
            }
            int n13 = n3 - 1;
            if (n5 > n13) {
                n5 = n13;
            }
            this.mAdapter.scrollToPosition(n5 + n4);
        } else {
            int n14 = Math.round((float)(n * n3));
            this.mAdapter.scrollToPosition(n14 + n4);
            n2 = -1;
        }
        this.updateOverlay(n2, arrobject);
    }

    private void scrollToSelection(int n, SectionIndexer sectionIndexer) {
        int n2 = this.getPosition(n, sectionIndexer);
        if (n2 < 0) {
            this.mAdapter.scrollToPosition(0);
            return;
        }
        this.scrollTo(sectionIndexer, n2);
    }

    private void setChecked(int n) {
        TextView textView = this.mLastSelectedItem;
        if (textView != null) {
            textView.setTextColor(this.mTextHighlighter.mNormalColor);
        }
        this.mLastSelectedItem = (TextView)this.getChildAt(n);
        this.mLastSelectedItem.setTextColor(this.mTextHighlighter.mHighlightColor);
    }

    private void showOverlay() {
        TextView textView = this.mOverlay;
        if (textView != null) {
            IVisibleStyle iVisibleStyle = Folme.useAt((View[])new View[]{textView}).visible().setFlags(1L);
            IVisibleStyle.VisibleType[] arrvisibleType = new IVisibleStyle.VisibleType[]{IVisibleStyle.VisibleType.HIDE};
            IVisibleStyle iVisibleStyle2 = iVisibleStyle.setScale(0.0f, arrvisibleType);
            IVisibleStyle.VisibleType[] arrvisibleType2 = new IVisibleStyle.VisibleType[]{IVisibleStyle.VisibleType.SHOW};
            IVisibleStyle iVisibleStyle3 = iVisibleStyle2.setScale(1.0f, arrvisibleType2);
            AnimConfig[] arranimConfig = new AnimConfig[]{this.mOverlayShowAnimConfig};
            iVisibleStyle3.show(arranimConfig);
        }
    }

    private void stop(int n) {
        this.mHandler.removeMessages(1);
        Message message = this.mHandler.obtainMessage(1);
        Handler handler = this.mHandler;
        long l = n <= 0 ? 0L : (long)n;
        handler.sendMessageDelayed(message, l);
    }

    private void updateOverlay(int n, Object[] arrobject) {
        String string2;
        if (n >= 0 && arrobject != null && !TextUtils.isEmpty((CharSequence)(string2 = arrobject[n].toString()))) {
            String string3 = string2.toUpperCase();
            this.drawThumbInternal(string3.subSequence(0, 1), this.calculateOverlayPosition(this.getIndex(string3)));
        }
    }

    private void updateOverlayTextAlpha(float f) {
        TextView textView = this.mOverlay;
        textView.setTextColor(textView.getTextColors().withAlpha((int)(f * 255.0f)));
    }

    private void updateOverlayTranslationX(float f) {
        float f2 = (float)(this.mOverlay.getWidth() / 2) * (1.0f - f);
        if (ViewUtils.isLayoutRtl((View)this)) {
            f2 *= -1.0f;
        }
        this.mOverlay.setTranslationX(f2);
    }

    public void attach(Adapter adapter) {
        if (this.mAdapter == adapter) {
            return;
        }
        this.detach();
        if (adapter == null) {
            return;
        }
        this.mLastAlphabetIndex = -1;
        this.mAdapter = adapter;
        this.constructOverlay();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.getLayoutParams();
        layoutParams.gravity = 48 | this.mVerticalPosition;
        layoutParams.bottomMargin += 1 + this.mOverlayHeight / 2;
        layoutParams.topMargin += 1 + this.mOverlayHeight / 2;
        this.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    }

    public void detach() {
        if (this.mAdapter != null) {
            this.stop(0);
            FrameLayout frameLayout = (FrameLayout)this.getParent();
            TextView textView = this.mOverlay;
            if (textView != null) {
                frameLayout.removeView((View)textView);
            }
            this.setVisibility(8);
            this.mAdapter = null;
        }
    }

    protected boolean dispatchHoverEvent(MotionEvent motionEvent) {
        IndexerTouchHelper indexerTouchHelper = this.mIndexerTouchHelper;
        if (indexerTouchHelper != null && indexerTouchHelper.dispatchHoverEvent(motionEvent)) {
            return true;
        }
        return super.dispatchHoverEvent(motionEvent);
    }

    public int getIndexerIntrinsicWidth() {
        Drawable drawable2 = this.getBackground();
        if (drawable2 != null) {
            return drawable2.getIntrinsicWidth();
        }
        return 0;
    }

    public /* synthetic */ void lambda$init$0$AlphabetIndexer() {
        this.checkItemHeight();
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.post((Runnable)new -$$Lambda$AlphabetIndexer$yAXW6heoJfI49Nw6va7pQ7KeZGY(this));
    }

    public void onScrollStateChanged(int n) {
        this.mListScrollState = n;
    }

    public void onScrolled(int n, int n2) {
        this.refreshMask();
        int n3 = this.mAdapter.getFirstVisibleItemPosition();
        int n4 = this.getSectionIndexer().getSectionForPosition(n3);
        this.drawThumb((String)this.getSectionIndexer().getSections()[n4]);
    }

    /*
     * Unable to fully structure code
     */
    public boolean onTouchEvent(MotionEvent var1_1) {
        block11 : {
            block10 : {
                block8 : {
                    block9 : {
                        if (this.mAdapter == null) {
                            this.stop(0);
                            return false;
                        }
                        var2_2 = this.getSectionIndexer();
                        if (var2_2 == null) {
                            this.stop(0);
                            return false;
                        }
                        var3_3 = var1_1.getActionMasked();
                        var4_4 = var1_1.getY() - (float)this.getPaddingTop();
                        if (!(var4_4 >= 0.0f)) {
                            var4_4 = 0.0f;
                        }
                        var5_5 = this.calculateIndex(var1_1.getY(), this.normalizeIndex((int)(var4_4 / (float)this.mItemHeight)));
                        if (var3_3 == 0) break block8;
                        if (var3_3 == 1) break block9;
                        if (var3_3 == 2) break block10;
                        if (var3_3 == 3) break block9;
                        if (var3_3 != 5) {
                            if (var3_3 != 6) {
                                return true;
                            } else {
                                ** GOTO lbl21
                            }
                        }
                        break block8;
                    }
                    if (var1_1.getPointerId(var1_1.getActionIndex()) != 0) {
                        return true;
                    }
                    this.setPressed(false);
                    if (this.hasShown()) {
                        this.stop(0);
                        return true;
                    }
                    break block11;
                }
                if (var1_1.getPointerId(var1_1.getActionIndex()) != 0) {
                    return true;
                }
                this.setPressed(true);
            }
            this.clearLastChecked();
            this.setChecked(var5_5);
            this.scrollToSelection(var5_5, var2_2);
        }
        return true;
    }

    public void setSectionIndexer(SectionIndexer sectionIndexer) {
        this.mIndexer = sectionIndexer;
    }

    public void setVerticalPosition(boolean bl) {
        int n = bl ? 8388613 : 8388611;
        this.mVerticalPosition = n;
    }

    public static interface Adapter {
        public int getFirstVisibleItemPosition();

        public int getItemCount();

        public int getListHeaderCount();

        public void scrollToPosition(int var1);

        public void stopScroll();
    }

    private static class TextHighlighter {
        int mActivatedColor;
        int mHighlightColor;
        int mIndexerTextSize;
        String[] mIndexes;
        int mNormalColor;

        TextHighlighter(Context context, TypedArray typedArray) {
            Resources resources = context.getResources();
            CharSequence[] arrcharSequence = typedArray.getTextArray(R.styleable.MiuixAppcompatAlphabetIndexer_miuixAppcompatIndexerTable);
            if (arrcharSequence != null) {
                this.mIndexes = new String[arrcharSequence.length];
                int n = arrcharSequence.length;
                int n2 = 0;
                for (int i = 0; i < n; ++i) {
                    CharSequence charSequence = arrcharSequence[i];
                    String[] arrstring = this.mIndexes;
                    int n3 = n2 + 1;
                    arrstring[n2] = charSequence.toString();
                    n2 = n3;
                }
            } else {
                this.mIndexes = resources.getStringArray(R.array.alphabet_table);
            }
            ColorStateList colorStateList = AppCompatResources.getColorStateList((Context)context, (int)typedArray.getResourceId(R.styleable.MiuixAppcompatAlphabetIndexer_miuixAppcompatIndexerTextColorList, R.color.miuix_appcompat_alphabet_indexer_text_light));
            this.mHighlightColor = colorStateList.getColorForState(new int[]{16842913}, resources.getColor(R.color.miuix_appcompat_alphabet_indexer_highlight_text_color));
            this.mActivatedColor = colorStateList.getColorForState(new int[]{16843518}, resources.getColor(R.color.miuix_appcompat_alphabet_indexer_activated_text_color));
            this.mNormalColor = colorStateList.getColorForState(new int[0], resources.getColor(R.color.miuix_appcompat_alphabet_indexer_text_color));
            this.mIndexerTextSize = typedArray.getDimensionPixelSize(R.styleable.MiuixAppcompatAlphabetIndexer_miuixAppcompatIndexerTextSize, resources.getDimensionPixelSize(R.dimen.miuix_appcompat_alphabet_indexer_text_size));
        }
    }

}

