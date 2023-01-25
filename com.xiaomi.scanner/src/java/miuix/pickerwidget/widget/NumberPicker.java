/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.Paint
 *  android.graphics.Paint$Align
 *  android.graphics.Rect
 *  android.graphics.Typeface
 *  android.media.SoundPool
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  android.text.Editable
 *  android.text.InputFilter
 *  android.text.Spanned
 *  android.text.TextUtils
 *  android.text.method.NumberKeyListener
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.util.SparseArray
 *  android.util.TypedValue
 *  android.view.KeyEvent
 *  android.view.LayoutInflater
 *  android.view.MotionEvent
 *  android.view.VelocityTracker
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.View$OnFocusChangeListener
 *  android.view.ViewConfiguration
 *  android.view.ViewGroup
 *  android.view.ViewParent
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.accessibility.AccessibilityManager
 *  android.view.accessibility.AccessibilityNodeInfo
 *  android.view.accessibility.AccessibilityNodeProvider
 *  android.view.animation.DecelerateInterpolator
 *  android.view.animation.Interpolator
 *  android.widget.Button
 *  android.widget.EditText
 *  android.widget.LinearLayout
 *  android.widget.Scroller
 *  android.widget.TextView
 *  androidx.appcompat.widget.ViewUtils
 *  androidx.collection.ArraySet
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.List
 *  java.util.Set
 *  java.util.concurrent.atomic.AtomicInteger
 *  miuix.pickerwidget.widget.NumberPicker$NumberFormatter
 *  miuix.view.HapticCompat
 *  miuix.view.HapticFeedbackConstants
 */
package miuix.pickerwidget.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Scroller;
import android.widget.TextView;
import androidx.appcompat.widget.ViewUtils;
import androidx.collection.ArraySet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import miuix.internal.util.ReflectUtil;
import miuix.pickerwidget.R;
import miuix.pickerwidget.internal.util.SimpleNumberFormatter;
import miuix.pickerwidget.internal.util.async.WorkerThreads;
import miuix.pickerwidget.widget.NumberPicker;
import miuix.view.HapticCompat;
import miuix.view.HapticFeedbackConstants;

/*
 * Exception performing whole class analysis.
 */
public class NumberPicker
extends LinearLayout {
    private static final int DEFAULT_LAYOUT_RESOURCE_ID = 0;
    private static final long DEFAULT_LONG_PRESS_UPDATE_INTERVAL = 300L;
    private static final char[] DIGIT_CHARACTERS;
    private static final int MAX_HEIGHT = 202;
    private static final int[] PRESSED_STATE_SET;
    private static final float SELECTION_DIVIDERS_DISTANCE = 45.0f;
    private static final int SELECTOR_ADJUSTMENT_DURATION_MILLIS = 800;
    private static final int SELECTOR_MAX_FLING_VELOCITY_ADJUSTMENT = 8;
    private static final int SELECTOR_MIDDLE_ITEM_INDEX = 1;
    static final int SELECTOR_WHEEL_ITEM_COUNT = 3;
    private static final int SIZE_UNSPECIFIED = -1;
    private static final int SNAP_SCROLL_DURATION = 300;
    private static final String SOUND_PLAY_THREAD = "NumberPicker_sound_play";
    private static final float TOP_AND_BOTTOM_FADING_EDGE_STRENGTH = 0.9f;
    static final Formatter TWO_DIGIT_FORMATTER;
    private static final int UNSCALED_DEFAULT_SELECTION_DIVIDERS_DISTANCE = 48;
    private static final int UNSCALED_DEFAULT_SELECTION_DIVIDER_HEIGHT = 2;
    private static final AtomicInteger sIdGenerator;
    private int MARGIN_LABEL_LEFT;
    private int MARGIN_LABEL_TOP;
    private AccessibilityNodeProviderImpl mAccessibilityNodeProvider;
    private final Scroller mAdjustScroller;
    private BeginSoftInputOnLongPressCommand mBeginSoftInputOnLongPressCommand;
    private int mBottomSelectionDividerBottom;
    private ChangeCurrentByOneFromLongPressCommand mChangeCurrentByOneFromLongPressCommand;
    private final boolean mComputeMaxWidth;
    private int mCurrentScrollOffset;
    private boolean mDecrementVirtualButtonPressed;
    private float mDisplayedMaxTextWidth;
    private String[] mDisplayedValues;
    private final Scroller mFlingScroller;
    private Formatter mFormatter;
    private final boolean mHasSelectorWheel;
    private final int mId;
    private boolean mIncrementVirtualButtonPressed;
    private boolean mIngonreMoveEvents;
    private int mInitialScrollOffset;
    private final EditText mInputText;
    private CharSequence mLabel;
    private Paint mLabelPaint;
    private int mLabelTextColor;
    private int mLabelTextSize;
    private float mLabelTextSizeThreshold;
    private float mLabelTextSizeTrimFactor;
    private long mLastDownEventTime;
    private float mLastDownEventY;
    private float mLastDownOrMoveEventY;
    private int mLastHandledDownDpadKeyCode;
    private int mLastHoveredChildVirtualViewId;
    private long mLongPressUpdateInterval;
    private float mMaxFlingSpeedFactor;
    private final int mMaxHeight;
    private int mMaxValue;
    private int mMaxWidth;
    private int mMaximumFlingVelocity;
    private final int mMinHeight;
    private int mMinValue;
    private final int mMinWidth;
    private int mMinimumFlingVelocity;
    private String mModDevice;
    private OnScrollListener mOnScrollListener;
    private OnValueChangeListener mOnValueChangeListener;
    private int mOriginLabelTextSize;
    private final PressedStateHelper mPressedStateHelper;
    private int mPreviousScrollerY;
    private int mScrollState;
    private final int mSelectionDividerHeight;
    private final int mSelectionDividersDistance;
    private int mSelectorElementHeight;
    private final SparseArray<String> mSelectorIndexToStringCache;
    private final int[] mSelectorIndices;
    private int mSelectorTextGapHeight;
    private final Paint mSelectorWheelPaint;
    private SetSelectionCommand mSetSelectionCommand;
    private boolean mShowSoftInputOnTap;
    private SoundPlayHandler mSoundPlayHandler;
    private int mTextColorHilight;
    private int mTextColorHint;
    private int mTextPadding;
    private final int mTextSize;
    private int mTextSizeHilight;
    private int mTextSizeHint;
    private int mTopSelectionDividerTop;
    private int mTouchSlop;
    private String mUpdateText;
    private int mValue;
    private VelocityTracker mVelocityTracker;
    private boolean mWrapSelectorWheel;

    static {
        DEFAULT_LAYOUT_RESOURCE_ID = R.layout.miuix_appcompat_number_picker_layout;
        sIdGenerator = new AtomicInteger(0);
        TWO_DIGIT_FORMATTER = new /* Unavailable Anonymous Inner Class!! */;
        PRESSED_STATE_SET = new int[]{16842919};
        DIGIT_CHARACTERS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    }

    public NumberPicker(Context context) {
        this(context, null);
    }

    public NumberPicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.numberPickerStyle);
    }

    public NumberPicker(Context context, AttributeSet attributeSet, int n) {
        int n2;
        int n3;
        super(context, attributeSet, n);
        this.mId = sIdGenerator.incrementAndGet();
        this.MARGIN_LABEL_LEFT = 1;
        this.MARGIN_LABEL_TOP = 2;
        this.mMaxWidth = 400;
        this.mLongPressUpdateInterval = 300L;
        this.mSelectorIndexToStringCache = new SparseArray();
        this.mSelectorIndices = new int[3];
        this.mInitialScrollOffset = Integer.MIN_VALUE;
        this.mScrollState = 0;
        this.mLastHandledDownDpadKeyCode = -1;
        this.mLabelTextSizeThreshold = 12.0f;
        this.mLabelTextSizeTrimFactor = 0.8f;
        this.mMaxFlingSpeedFactor = 1.0f;
        float f = this.getResources().getDisplayMetrics().density;
        this.MARGIN_LABEL_LEFT = this.getResources().getDimensionPixelOffset(R.dimen.miuix_appcompat_number_picker_label_margin_left);
        this.MARGIN_LABEL_TOP = this.getResources().getDimensionPixelOffset(R.dimen.miuix_appcompat_number_picker_label_margin_top);
        this.parseStyle(attributeSet, n);
        this.initSoundPlayer();
        this.mHasSelectorWheel = true;
        this.mSelectionDividerHeight = (int)TypedValue.applyDimension((int)1, (float)2.0f, (DisplayMetrics)this.getResources().getDisplayMetrics());
        this.mSelectionDividersDistance = (int)(45.0f * f);
        this.mMinHeight = -1;
        this.mMaxHeight = (int)(f * 202.0f);
        int n4 = this.mMinHeight;
        if (n4 != -1 && (n3 = this.mMaxHeight) != -1 && n4 > n3) {
            throw new IllegalArgumentException("minHeight > maxHeight");
        }
        this.mMinWidth = -1;
        this.mMaxWidth = -1;
        int n5 = this.mMinWidth;
        if (n5 != -1 && (n2 = this.mMaxWidth) != -1 && n5 > n2) {
            throw new IllegalArgumentException("minWidth > maxWidth");
        }
        int n6 = this.mMaxWidth;
        boolean bl = false;
        if (n6 == -1) {
            bl = true;
        }
        this.mComputeMaxWidth = bl;
        this.mPressedStateHelper = new PressedStateHelper();
        this.setWillNotDraw(true ^ this.mHasSelectorWheel);
        ((LayoutInflater)this.getContext().getSystemService("layout_inflater")).inflate(R.layout.miuix_appcompat_number_picker_layout, (ViewGroup)this, true);
        this.mInputText = (EditText)this.findViewById(R.id.number_picker_input);
        this.initInputText();
        ViewConfiguration viewConfiguration = ViewConfiguration.get((Context)context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity() / 8;
        this.mTextSize = (int)this.mInputText.getTextSize();
        this.mSelectorWheelPaint = this.initSelectorWheelPaint();
        this.initLabelPaint();
        this.mFlingScroller = new Scroller(this.getContext(), null, true);
        this.mAdjustScroller = new Scroller(this.getContext(), (Interpolator)new DecelerateInterpolator(2.5f));
        this.updateInputTextView();
        if (this.getImportantForAccessibility() == 0) {
            this.setImportantForAccessibility(1);
        }
    }

    private void changeValueByOne(boolean bl) {
        if (this.mHasSelectorWheel) {
            this.mInputText.setVisibility(4);
            if (!this.moveToFinalScrollerPosition(this.mFlingScroller)) {
                this.moveToFinalScrollerPosition(this.mAdjustScroller);
            }
            this.mPreviousScrollerY = 0;
            if (bl) {
                this.mFlingScroller.startScroll(0, 0, 0, -this.mSelectorElementHeight, 300);
            } else {
                this.mFlingScroller.startScroll(0, 0, 0, this.mSelectorElementHeight, 300);
            }
            this.invalidate();
            return;
        }
        if (bl) {
            this.setValueInternal(1 + this.mValue, true);
            return;
        }
        this.setValueInternal(this.mValue - 1, true);
    }

    private void decrementSelectorIndices(int[] arrn) {
        for (int i = arrn.length - 1; i > 0; --i) {
            arrn[i] = arrn[i - 1];
        }
        int n = arrn[1] - 1;
        if (this.mWrapSelectorWheel && n < this.mMinValue) {
            n = this.mMaxValue;
        }
        arrn[0] = n;
        this.ensureCachedScrollSelectorValue(n);
    }

    private void drawLabelText(Canvas canvas, float f, float f2, float f3) {
        if (!TextUtils.isEmpty((CharSequence)this.mLabel) && !this.isInternationalBuild()) {
            float f4 = this.mLabelPaint.measureText(this.mLabel.toString());
            float f5 = ViewUtils.isLayoutRtl((View)this) ? Math.max((float)(f - this.mDisplayedMaxTextWidth / 2.0f - (float)this.MARGIN_LABEL_LEFT - f4), (float)0.0f) : Math.min((float)(f + this.mDisplayedMaxTextWidth / 2.0f + (float)this.MARGIN_LABEL_LEFT), (float)((float)this.getWidth() - f4));
            float f6 = f2 - (float)(this.mTextSizeHilight / 2) + (float)(this.mLabelTextSize / 2) + (float)this.MARGIN_LABEL_TOP;
            canvas.drawText(this.mLabel.toString(), f5, f6, this.mLabelPaint);
        }
    }

    private float drawScrollValue(Canvas canvas, float f, float f2) {
        float f3 = this.mCurrentScrollOffset;
        SparseArray<String> sparseArray = this.mSelectorIndexToStringCache;
        int[] arrn = this.mSelectorIndices;
        float f4 = f3;
        for (int i = 0; i < arrn.length; ++i) {
            String string2 = (String)sparseArray.get(arrn[i]);
            float f5 = Math.abs((float)(f2 - f4)) / (float)this.mSelectorElementHeight;
            float f6 = this.getTextSize(f5, this.mTextSizeHilight, this.mTextSizeHint);
            this.mSelectorWheelPaint.setTextSize(f6);
            this.mSelectorWheelPaint.setColor(this.getAlphaGradient(f5, this.mTextColorHint, false));
            canvas.drawText(string2, f, f4 + (f6 - (float)this.mTextSizeHint) / 2.0f, this.mSelectorWheelPaint);
            if (f5 < 1.0f) {
                this.mSelectorWheelPaint.setColor(this.getAlphaGradient(f5, this.mTextColorHilight, true));
                canvas.drawText(string2, f, f4 + (f6 - (float)this.mTextSizeHint) / 2.0f, this.mSelectorWheelPaint);
            }
            f4 += (float)this.mSelectorElementHeight;
        }
        return f4;
    }

    private void ensureCachedScrollSelectorValue(int n) {
        String[] arrstring;
        SparseArray<String> sparseArray = this.mSelectorIndexToStringCache;
        if ((String)sparseArray.get(n) != null) {
            return;
        }
        int n2 = this.mMinValue;
        String string2 = n >= n2 && n <= this.mMaxValue ? ((arrstring = this.mDisplayedValues) != null ? arrstring[n - n2] : this.formatNumber(n)) : "";
        sparseArray.put(n, (Object)string2);
    }

    private boolean ensureScrollWheelAdjusted() {
        int n = this.mInitialScrollOffset - this.mCurrentScrollOffset;
        if (n != 0) {
            int n2;
            this.mPreviousScrollerY = 0;
            int n3 = Math.abs((int)n);
            if (n3 > (n2 = this.mSelectorElementHeight) / 2) {
                if (n > 0) {
                    n2 = -n2;
                }
                n += n2;
            }
            int n4 = n;
            this.mAdjustScroller.startScroll(0, 0, 0, n4, 800);
            this.invalidate();
            return true;
        }
        return false;
    }

    private void fling(int n) {
        this.mPreviousScrollerY = 0;
        if (n > 0) {
            this.mFlingScroller.fling(0, 0, 0, n, 0, 0, 0, Integer.MAX_VALUE);
        } else {
            this.mFlingScroller.fling(0, Integer.MAX_VALUE, 0, n, 0, 0, 0, Integer.MAX_VALUE);
        }
        this.invalidate();
    }

    private String formatNumber(int n) {
        Formatter formatter = this.mFormatter;
        if (formatter != null) {
            return formatter.format(n);
        }
        return SimpleNumberFormatter.format(n);
    }

    private int getAlphaGradient(float f, int n, boolean bl) {
        if (f >= 1.0f) {
            return n;
        }
        float f2 = bl ? -f * (float)Color.alpha((int)n) + (float)Color.alpha((int)n) : f * (float)Color.alpha((int)n);
        int n2 = (int)f2;
        return n & 16777215 | n2 << 24;
    }

    private float getLabelWidth() {
        if (!TextUtils.isEmpty((CharSequence)this.mLabel) && !this.isInternationalBuild()) {
            return this.mLabelPaint.measureText(this.mLabel.toString());
        }
        return 0.0f;
    }

    private int getSelectedPos(String string2) {
        if (this.mDisplayedValues == null) {
            int n = Integer.parseInt((String)string2);
            return n;
        }
        for (int i = 0; i < this.mDisplayedValues.length; ++i) {
            string2 = string2.toLowerCase();
            if (!this.mDisplayedValues[i].toLowerCase().startsWith(string2)) continue;
            return i + this.mMinValue;
        }
        try {
            int n = Integer.parseInt((String)string2);
            return n;
        }
        catch (NumberFormatException numberFormatException) {
            return this.mMinValue;
        }
    }

    private float getTextSize(float f, int n, int n2) {
        if (f >= 1.0f) {
            return n2;
        }
        return f * (float)(n2 - n) + (float)n;
    }

    private int getWrappedSelectorIndex(int n) {
        int n2 = this.mMaxValue;
        if (n > n2) {
            int n3 = this.mMinValue;
            return -1 + (n3 + (n - n2) % (n2 - n3));
        }
        int n4 = this.mMinValue;
        if (n < n4) {
            return 1 + (n2 - (n4 - n) % (n2 - n4));
        }
        return n;
    }

    private void incrementSelectorIndices(int[] arrn) {
        int n = 0;
        while (n < -1 + arrn.length) {
            int n2 = n + 1;
            arrn[n] = arrn[n2];
            n = n2;
        }
        int n3 = 1 + arrn[-2 + arrn.length];
        if (this.mWrapSelectorWheel && n3 > this.mMaxValue) {
            n3 = this.mMinValue;
        }
        arrn[-1 + arrn.length] = n3;
        this.ensureCachedScrollSelectorValue(n3);
    }

    private void initInputText() {
        this.mInputText.setOnFocusChangeListener(new View.OnFocusChangeListener(){

            public void onFocusChange(View view, boolean bl) {
                if (bl) {
                    NumberPicker.this.mInputText.selectAll();
                    return;
                }
                NumberPicker.this.mInputText.setSelection(0, 0);
                NumberPicker.this.validateInputTextView(view);
            }
        });
        EditText editText = this.mInputText;
        InputFilter[] arrinputFilter = new InputFilter[]{new InputTextFilter()};
        editText.setFilters(arrinputFilter);
        this.mInputText.setRawInputType(2);
        this.mInputText.setImeOptions(6);
        this.mInputText.setVisibility(4);
        this.mInputText.setGravity(8388611);
        this.mInputText.setScaleX(0.0f);
        this.mInputText.setSaveEnabled(false);
        EditText editText2 = this.mInputText;
        editText2.setPadding(this.mTextPadding, editText2.getPaddingTop(), this.mTextPadding, this.mInputText.getPaddingRight());
    }

    private void initLabelPaint() {
        this.mLabelPaint = new Paint();
        this.mLabelPaint.setAntiAlias(true);
        this.mLabelPaint.setFakeBoldText(true);
        this.mLabelPaint.setColor(this.mLabelTextColor);
        this.mLabelPaint.setTextSize((float)this.mLabelTextSize);
    }

    private Paint initSelectorWheelPaint() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize((float)this.mTextSizeHilight);
        paint.setTypeface(this.mInputText.getTypeface());
        paint.setColor(this.mInputText.getTextColors().getColorForState(ENABLED_STATE_SET, -1));
        return paint;
    }

    private void initSoundPlayer() {
        if (this.mSoundPlayHandler == null) {
            this.mSoundPlayHandler = new SoundPlayHandler(WorkerThreads.aquireWorker(SOUND_PLAY_THREAD));
            this.mSoundPlayHandler.init(this.getContext().getApplicationContext(), this.mId);
        }
    }

    private void initializeFadingEdges() {
        this.setVerticalFadingEdgeEnabled(true);
        this.setFadingEdgeLength((this.getBottom() - this.getTop() - this.mTextSize) / 2);
    }

    private void initializeSelectorWheel() {
        this.initializeSelectorWheelIndices();
        int[] arrn = this.mSelectorIndices;
        int n = arrn.length * this.mTextSize;
        float f = this.getBottom() - this.getTop() - n;
        if (f < 0.0f) {
            f = 0.0f;
        }
        this.mSelectorTextGapHeight = (int)(0.5f + f / (float)arrn.length);
        this.mSelectorElementHeight = this.mTextSize + this.mSelectorTextGapHeight;
        this.mCurrentScrollOffset = this.mInitialScrollOffset = this.mInputText.getBaseline() + this.mInputText.getTop() - 1 * this.mSelectorElementHeight;
        this.updateInputTextView();
    }

    private void initializeSelectorWheelIndices() {
        this.mSelectorIndexToStringCache.clear();
        int[] arrn = this.mSelectorIndices;
        int n = this.getValue();
        for (int i = 0; i < this.mSelectorIndices.length; ++i) {
            int n2 = n + (i - 1);
            if (this.mWrapSelectorWheel) {
                n2 = this.getWrappedSelectorIndex(n2);
            }
            arrn[i] = n2;
            this.ensureCachedScrollSelectorValue(arrn[i]);
        }
    }

    private boolean isInternationalBuild() {
        if (this.mModDevice == null) {
            this.mModDevice = ReflectUtil.callStaticObjectMethod(ReflectUtil.getClass("android.os.SystemProperties"), String.class, "get", new Class[]{String.class, String.class}, "ro.product.mod_device", "");
        }
        return this.mModDevice.endsWith("_global");
    }

    private int makeMeasureSpec(int n, int n2) {
        if (n2 == -1) {
            return n;
        }
        int n3 = View.MeasureSpec.getSize((int)n);
        int n4 = View.MeasureSpec.getMode((int)n);
        if (n4 != Integer.MIN_VALUE) {
            if (n4 != 0) {
                if (n4 == 1073741824) {
                    return n;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown measure mode: ");
                stringBuilder.append(n4);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            return View.MeasureSpec.makeMeasureSpec((int)n2, (int)1073741824);
        }
        return View.MeasureSpec.makeMeasureSpec((int)Math.min((int)n3, (int)n2), (int)1073741824);
    }

    private boolean moveToFinalScrollerPosition(Scroller scroller) {
        scroller.forceFinished(true);
        int n = scroller.getFinalY() - scroller.getCurrY();
        int n2 = (n + this.mCurrentScrollOffset) % this.mSelectorElementHeight;
        int n3 = this.mInitialScrollOffset - n2;
        if (n3 != 0) {
            int n4;
            int n5 = Math.abs((int)n3);
            if (n5 > (n4 = this.mSelectorElementHeight) / 2) {
                n3 = n3 > 0 ? (n3 -= n4) : (n3 += n4);
            }
            this.scrollBy(0, n + n3);
            return true;
        }
        return false;
    }

    private void notifyChange(int n) {
        this.sendAccessibilityEvent(4);
        this.playSound();
        HapticCompat.performHapticFeedback((View)this, (int)HapticFeedbackConstants.MIUI_MESH_NORMAL);
        OnValueChangeListener onValueChangeListener = this.mOnValueChangeListener;
        if (onValueChangeListener != null) {
            onValueChangeListener.onValueChange(this, n, this.mValue);
        }
    }

    private void onScrollStateChange(int n) {
        if (this.mScrollState == n) {
            return;
        }
        if (n == 0) {
            String string2 = this.mUpdateText;
            if (string2 != null && !string2.equals((Object)this.mInputText.getText().toString())) {
                this.mInputText.setText((CharSequence)this.mUpdateText);
            }
            this.mUpdateText = null;
            this.stopSoundPlay();
        }
        this.mScrollState = n;
        OnScrollListener onScrollListener = this.mOnScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChange(this, n);
        }
    }

    private void onScrollerFinished(Scroller scroller) {
        if (scroller == this.mFlingScroller) {
            if (!this.ensureScrollWheelAdjusted()) {
                this.updateInputTextView();
            }
            this.onScrollStateChange(0);
            return;
        }
        if (this.mScrollState != 1) {
            this.updateInputTextView();
        }
    }

    private void parseStyle(AttributeSet attributeSet, int n) {
        Resources resources = this.getResources();
        TypedArray typedArray = this.getContext().obtainStyledAttributes(attributeSet, R.styleable.NumberPicker, n, R.style.Widget_NumberPicker_DayNight);
        this.mLabel = typedArray.getText(R.styleable.NumberPicker_android_text);
        this.mTextSizeHilight = typedArray.getDimensionPixelSize(R.styleable.NumberPicker_textSizeHighlight, resources.getDimensionPixelOffset(R.dimen.miuix_appcompat_number_picker_text_size_highlight_normal));
        this.mTextSizeHint = typedArray.getDimensionPixelSize(R.styleable.NumberPicker_textSizeHint, resources.getDimensionPixelOffset(R.dimen.miuix_appcompat_number_picker_text_size_hint_normal));
        this.mLabelTextSize = typedArray.getDimensionPixelSize(R.styleable.NumberPicker_android_labelTextSize, resources.getDimensionPixelOffset(R.dimen.miuix_appcompat_number_picker_label_text_size));
        this.mTextColorHilight = typedArray.getColor(R.styleable.NumberPicker_android_textColorHighlight, resources.getColor(R.color.miuix_appcompat_number_picker_highlight_color));
        this.mTextColorHint = typedArray.getColor(R.styleable.NumberPicker_android_textColorHint, resources.getColor(R.color.miuix_appcompat_number_picker_hint_color));
        this.mLabelTextColor = typedArray.getColor(R.styleable.NumberPicker_labelTextColor, resources.getColor(R.color.miuix_appcompat_number_picker_label_color));
        this.mTextPadding = typedArray.getDimensionPixelSize(R.styleable.NumberPicker_labelPadding, resources.getDimensionPixelOffset(R.dimen.miuix_appcompat_number_picker_label_padding));
        typedArray.recycle();
        this.mOriginLabelTextSize = this.mLabelTextSize;
    }

    private void playSound() {
        SoundPlayHandler soundPlayHandler = this.mSoundPlayHandler;
        if (soundPlayHandler != null) {
            soundPlayHandler.play();
        }
    }

    private void postBeginSoftInputOnLongPressCommand() {
        BeginSoftInputOnLongPressCommand beginSoftInputOnLongPressCommand = this.mBeginSoftInputOnLongPressCommand;
        if (beginSoftInputOnLongPressCommand == null) {
            this.mBeginSoftInputOnLongPressCommand = new BeginSoftInputOnLongPressCommand();
        } else {
            this.removeCallbacks((Runnable)beginSoftInputOnLongPressCommand);
        }
        this.postDelayed((Runnable)this.mBeginSoftInputOnLongPressCommand, (long)ViewConfiguration.getLongPressTimeout());
    }

    private void postChangeCurrentByOneFromLongPress(boolean bl, long l) {
        ChangeCurrentByOneFromLongPressCommand changeCurrentByOneFromLongPressCommand = this.mChangeCurrentByOneFromLongPressCommand;
        if (changeCurrentByOneFromLongPressCommand == null) {
            this.mChangeCurrentByOneFromLongPressCommand = new ChangeCurrentByOneFromLongPressCommand();
        } else {
            this.removeCallbacks((Runnable)changeCurrentByOneFromLongPressCommand);
        }
        this.mChangeCurrentByOneFromLongPressCommand.setStep(bl);
        this.postDelayed((Runnable)this.mChangeCurrentByOneFromLongPressCommand, l);
    }

    private void postSetSelectionCommand(int n, int n2) {
        SetSelectionCommand setSelectionCommand = this.mSetSelectionCommand;
        if (setSelectionCommand == null) {
            this.mSetSelectionCommand = new SetSelectionCommand();
        } else {
            this.removeCallbacks((Runnable)setSelectionCommand);
        }
        this.mSetSelectionCommand.mSelectionStart = n;
        this.mSetSelectionCommand.mSelectionEnd = n2;
        this.post((Runnable)this.mSetSelectionCommand);
    }

    private void refreshWheel() {
        this.initializeSelectorWheelIndices();
        this.invalidate();
    }

    private void releaseSoundPlayer() {
        SoundPlayHandler soundPlayHandler = this.mSoundPlayHandler;
        if (soundPlayHandler != null) {
            soundPlayHandler.release(this.mId);
            this.mSoundPlayHandler = null;
        }
    }

    private void removeAllCallbacks() {
        SetSelectionCommand setSelectionCommand;
        BeginSoftInputOnLongPressCommand beginSoftInputOnLongPressCommand;
        ChangeCurrentByOneFromLongPressCommand changeCurrentByOneFromLongPressCommand = this.mChangeCurrentByOneFromLongPressCommand;
        if (changeCurrentByOneFromLongPressCommand != null) {
            this.removeCallbacks((Runnable)changeCurrentByOneFromLongPressCommand);
        }
        if ((setSelectionCommand = this.mSetSelectionCommand) != null) {
            this.removeCallbacks((Runnable)setSelectionCommand);
        }
        if ((beginSoftInputOnLongPressCommand = this.mBeginSoftInputOnLongPressCommand) != null) {
            this.removeCallbacks((Runnable)beginSoftInputOnLongPressCommand);
        }
        this.mPressedStateHelper.cancel();
    }

    private void removeBeginSoftInputCommand() {
        BeginSoftInputOnLongPressCommand beginSoftInputOnLongPressCommand = this.mBeginSoftInputOnLongPressCommand;
        if (beginSoftInputOnLongPressCommand != null) {
            this.removeCallbacks((Runnable)beginSoftInputOnLongPressCommand);
        }
    }

    private void removeChangeCurrentByOneFromLongPress() {
        ChangeCurrentByOneFromLongPressCommand changeCurrentByOneFromLongPressCommand = this.mChangeCurrentByOneFromLongPressCommand;
        if (changeCurrentByOneFromLongPressCommand != null) {
            this.removeCallbacks((Runnable)changeCurrentByOneFromLongPressCommand);
        }
    }

    private int resolveSizeAndStateRespectingMinSize(int n, int n2, int n3) {
        if (n != -1) {
            return NumberPicker.resolveSizeAndState((int)Math.max((int)n, (int)n2), (int)n3, (int)0);
        }
        return n2;
    }

    private void setValueInternal(int n, boolean bl) {
        int n2 = this.mValue;
        int n3 = this.mWrapSelectorWheel ? this.getWrappedSelectorIndex(n) : Math.min((int)Math.max((int)n, (int)this.mMinValue), (int)this.mMaxValue);
        if (n2 == n3) {
            return;
        }
        this.mValue = n3;
        this.updateInputTextView();
        if (bl) {
            this.notifyChange(n2);
        }
        this.initializeSelectorWheelIndices();
        this.invalidate();
    }

    private void stopSoundPlay() {
        SoundPlayHandler soundPlayHandler = this.mSoundPlayHandler;
        if (soundPlayHandler != null) {
            soundPlayHandler.stop();
        }
    }

    private void trimLabelTextSize(float f) {
        if (this.getLabelWidth() > 0.0f) {
            int n;
            this.mLabelTextSize = this.mOriginLabelTextSize;
            this.mLabelPaint.setTextSize((float)this.mLabelTextSize);
            while (f + this.mDisplayedMaxTextWidth / 2.0f + (float)this.MARGIN_LABEL_LEFT + this.getLabelWidth() > (float)this.getWidth() && (float)(n = this.mLabelTextSize) > this.mLabelTextSizeThreshold) {
                this.mLabelTextSize = (int)((float)n * this.mLabelTextSizeTrimFactor);
                this.mLabelPaint.setTextSize((float)this.mLabelTextSize);
            }
        }
    }

    private void tryComputeMaxWidth() {
        int n;
        if (!this.mComputeMaxWidth) {
            return;
        }
        float f = -1.0f;
        this.mSelectorWheelPaint.setTextSize((float)this.mTextSizeHilight);
        String[] arrstring = this.mDisplayedValues;
        if (arrstring == null) {
            float f2 = 0.0f;
            for (n = 0; n < 9; ++n) {
                float f3 = this.mSelectorWheelPaint.measureText(String.valueOf((int)n));
                if (!(f3 > f2)) continue;
                f2 = f3;
            }
            f = (int)(f2 * (float)this.formatNumber(this.mMaxValue).length());
        } else {
            int n2 = arrstring.length;
            while (n < n2) {
                String string2 = this.mDisplayedValues[n];
                float f4 = this.mSelectorWheelPaint.measureText(string2);
                if (f4 > f) {
                    f = f4;
                }
                ++n;
            }
        }
        this.mDisplayedMaxTextWidth = f;
        float f5 = f + (float)(this.mInputText.getPaddingLeft() + this.mInputText.getPaddingRight()) + (float)this.getPaddingLeft() + (float)this.getPaddingRight();
        if ((float)this.mMaxWidth != f5) {
            int n3 = this.mMinWidth;
            if (f5 > (float)n3) {
                this.mMaxWidth = (int)f5;
                return;
            }
            this.mMaxWidth = n3;
        }
    }

    private boolean updateInputTextView() {
        String[] arrstring = this.mDisplayedValues;
        String string2 = arrstring == null ? this.formatNumber(this.mValue) : arrstring[this.mValue - this.mMinValue];
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            if (this.mScrollState != 0) {
                this.mUpdateText = string2;
            } else if (!string2.equals((Object)this.mInputText.getText().toString())) {
                this.mInputText.setText((CharSequence)string2);
            }
            return true;
        }
        return false;
    }

    private void validateInputTextView(View view) {
        String string2 = String.valueOf((Object)((TextView)view).getText());
        if (TextUtils.isEmpty((CharSequence)string2)) {
            this.updateInputTextView();
            return;
        }
        this.setValueInternal(this.getSelectedPos(string2.toString()), true);
    }

    public void computeScroll() {
        Scroller scroller = this.mFlingScroller;
        if (scroller.isFinished() && (scroller = this.mAdjustScroller).isFinished()) {
            return;
        }
        scroller.computeScrollOffset();
        int n = scroller.getCurrY();
        if (this.mPreviousScrollerY == 0) {
            this.mPreviousScrollerY = scroller.getStartY();
        }
        this.scrollBy(0, n - this.mPreviousScrollerY);
        this.mPreviousScrollerY = n;
        if (scroller.isFinished()) {
            this.onScrollerFinished(scroller);
            return;
        }
        this.invalidate();
    }

    protected boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (!this.mHasSelectorWheel) {
            return super.dispatchHoverEvent(motionEvent);
        }
        if (((AccessibilityManager)this.getContext().getSystemService("accessibility")).isEnabled()) {
            int n = (int)motionEvent.getY();
            int n2 = n < this.mTopSelectionDividerTop ? 3 : (n > this.mBottomSelectionDividerBottom ? 1 : 2);
            int n3 = motionEvent.getActionMasked();
            AccessibilityNodeProviderImpl accessibilityNodeProviderImpl = (AccessibilityNodeProviderImpl)this.getAccessibilityNodeProvider();
            if (n3 != 7) {
                if (n3 != 9) {
                    if (n3 == 10) {
                        accessibilityNodeProviderImpl.sendAccessibilityEventForVirtualView(n2, 256);
                        this.mLastHoveredChildVirtualViewId = -1;
                    }
                } else {
                    accessibilityNodeProviderImpl.sendAccessibilityEventForVirtualView(n2, 128);
                    this.mLastHoveredChildVirtualViewId = n2;
                    accessibilityNodeProviderImpl.performAction(n2, 64, null);
                }
            } else {
                int n4 = this.mLastHoveredChildVirtualViewId;
                if (n4 != n2 && n4 != -1) {
                    accessibilityNodeProviderImpl.sendAccessibilityEventForVirtualView(n4, 256);
                    accessibilityNodeProviderImpl.sendAccessibilityEventForVirtualView(n2, 128);
                    this.mLastHoveredChildVirtualViewId = n2;
                    accessibilityNodeProviderImpl.performAction(n2, 64, null);
                }
            }
        }
        return false;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int n = keyEvent.getKeyCode();
        if (n != 19 && n != 20) {
            if (n == 23 || n == 66) {
                this.removeAllCallbacks();
            }
        } else if (this.mHasSelectorWheel) {
            int n2 = keyEvent.getAction();
            if (n2 != 0) {
                if (n2 == 1 && this.mLastHandledDownDpadKeyCode == n) {
                    this.mLastHandledDownDpadKeyCode = -1;
                    return true;
                }
            } else if (!this.mWrapSelectorWheel && n != 20 ? this.getValue() > this.getMinValue() : this.getValue() < this.getMaxValue()) {
                this.requestFocus();
                this.mLastHandledDownDpadKeyCode = n;
                this.removeAllCallbacks();
                if (this.mFlingScroller.isFinished()) {
                    boolean bl = n == 20;
                    this.changeValueByOne(bl);
                }
                return true;
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        this.onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int n = motionEvent.getActionMasked();
        if (n == 1 || n == 3) {
            this.removeAllCallbacks();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        int n = motionEvent.getActionMasked();
        if (n == 1 || n == 3) {
            this.removeAllCallbacks();
        }
        return super.dispatchTrackballEvent(motionEvent);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.tryComputeMaxWidth();
    }

    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        if (!this.mHasSelectorWheel) {
            return super.getAccessibilityNodeProvider();
        }
        if (this.mAccessibilityNodeProvider == null) {
            this.mAccessibilityNodeProvider = new AccessibilityNodeProviderImpl();
        }
        return this.mAccessibilityNodeProvider;
    }

    protected float getBottomFadingEdgeStrength() {
        return 0.9f;
    }

    public String[] getDisplayedValues() {
        return this.mDisplayedValues;
    }

    public int getMaxValue() {
        return this.mMaxValue;
    }

    public int getMinValue() {
        return this.mMinValue;
    }

    protected float getTopFadingEdgeStrength() {
        return 0.9f;
    }

    public int getValue() {
        return this.mValue;
    }

    public boolean getWrapSelectorWheel() {
        return this.mWrapSelectorWheel;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.initSoundPlayer();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.releaseSoundPlayer();
        this.removeAllCallbacks();
        WorkerThreads.releaseWorker(SOUND_PLAY_THREAD);
    }

    protected void onDraw(Canvas canvas) {
        if (!this.mHasSelectorWheel) {
            super.onDraw(canvas);
            return;
        }
        int n = this.getPaddingLeft();
        int n2 = this.getPaddingRight();
        float f = (n + (this.getRight() - this.getLeft()) - n2) / 2;
        float f2 = this.mInitialScrollOffset + 1 * this.mSelectorElementHeight;
        this.drawLabelText(canvas, f, f2, this.drawScrollValue(canvas, f, f2));
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName((CharSequence)NumberPicker.class.getName());
        accessibilityEvent.setScrollable(true);
        accessibilityEvent.setScrollY((this.mMinValue + this.mValue) * this.mSelectorElementHeight);
        accessibilityEvent.setMaxScrollY((this.mMaxValue - this.mMinValue) * this.mSelectorElementHeight);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.mHasSelectorWheel) {
            float f;
            if (!this.isEnabled()) {
                return false;
            }
            if (motionEvent.getActionMasked() != 0) {
                return false;
            }
            this.removeAllCallbacks();
            this.mInputText.setVisibility(4);
            this.mLastDownEventY = f = motionEvent.getY();
            this.mLastDownOrMoveEventY = f;
            this.mLastDownEventTime = motionEvent.getEventTime();
            this.mIngonreMoveEvents = false;
            this.mShowSoftInputOnTap = false;
            float f2 = this.mLastDownEventY;
            if (f2 < (float)this.mTopSelectionDividerTop) {
                if (this.mScrollState == 0) {
                    this.mPressedStateHelper.buttonPressDelayed(2);
                }
            } else if (f2 > (float)this.mBottomSelectionDividerBottom && this.mScrollState == 0) {
                this.mPressedStateHelper.buttonPressDelayed(1);
            }
            if (!this.mFlingScroller.isFinished()) {
                this.mFlingScroller.forceFinished(true);
                this.mAdjustScroller.forceFinished(true);
                this.onScrollStateChange(0);
                return true;
            }
            if (!this.mAdjustScroller.isFinished()) {
                this.mFlingScroller.forceFinished(true);
                this.mAdjustScroller.forceFinished(true);
                return true;
            }
            float f3 = this.mLastDownEventY;
            if (f3 < (float)this.mTopSelectionDividerTop) {
                this.postChangeCurrentByOneFromLongPress(false, ViewConfiguration.getLongPressTimeout());
                return true;
            }
            if (f3 > (float)this.mBottomSelectionDividerBottom) {
                this.postChangeCurrentByOneFromLongPress(true, ViewConfiguration.getLongPressTimeout());
                return true;
            }
            this.mShowSoftInputOnTap = true;
            this.postBeginSoftInputOnLongPressCommand();
            return true;
        }
        return false;
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        if (!this.mHasSelectorWheel) {
            super.onLayout(bl, n, n2, n3, n4);
            return;
        }
        int n5 = this.getMeasuredWidth();
        int n6 = this.getMeasuredHeight();
        int n7 = this.mInputText.getMeasuredWidth();
        int n8 = this.mInputText.getMeasuredHeight();
        int n9 = (n5 - n7) / 2;
        int n10 = (n6 - n8) / 2;
        int n11 = n7 + n9;
        int n12 = n8 + n10;
        this.mInputText.layout(n9, n10, n11, n12);
        if (bl) {
            this.initializeSelectorWheel();
            this.initializeFadingEdges();
            int n13 = this.getHeight();
            int n14 = this.mSelectionDividersDistance;
            int n15 = (n13 - n14) / 2;
            int n16 = this.mSelectionDividerHeight;
            this.mTopSelectionDividerTop = n15 - n16;
            this.mBottomSelectionDividerBottom = n14 + (this.mTopSelectionDividerTop + n16 * 2);
        }
        this.trimLabelTextSize((this.getRight() - this.getLeft() + this.getPaddingLeft() - this.getPaddingRight()) / 2);
    }

    protected void onMeasure(int n, int n2) {
        if (!this.mHasSelectorWheel) {
            super.onMeasure(n, n2);
            return;
        }
        super.onMeasure(this.makeMeasureSpec(n, this.mMaxWidth), this.makeMeasureSpec(n2, this.mMaxHeight));
        this.setMeasuredDimension(this.resolveSizeAndStateRespectingMinSize(this.mMinWidth, this.getMeasuredWidth(), n), this.resolveSizeAndStateRespectingMinSize(this.mMinHeight, this.getMeasuredHeight(), n2));
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        String string2 = this.mScrollState != 0 ? this.mUpdateText : this.mInputText.getText().toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        CharSequence charSequence = this.mLabel;
        if (charSequence == null) {
            charSequence = "";
        }
        stringBuilder.append((Object)charSequence);
        String string3 = stringBuilder.toString();
        accessibilityEvent.getText().add((Object)string3);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.isEnabled()) {
            if (!this.mHasSelectorWheel) {
                return false;
            }
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
            int n = motionEvent.getActionMasked();
            if (n != 1) {
                if (n != 2) {
                    return true;
                }
                if (this.mIngonreMoveEvents) {
                    return true;
                }
                float f = motionEvent.getY();
                if (this.mScrollState != 1) {
                    if ((int)Math.abs((float)(f - this.mLastDownEventY)) > this.mTouchSlop) {
                        this.removeAllCallbacks();
                        this.onScrollStateChange(1);
                    }
                } else {
                    this.scrollBy(0, (int)(f - this.mLastDownOrMoveEventY));
                    this.invalidate();
                }
                this.mLastDownOrMoveEventY = f;
                return true;
            }
            this.removeBeginSoftInputCommand();
            this.removeChangeCurrentByOneFromLongPress();
            this.mPressedStateHelper.cancel();
            VelocityTracker velocityTracker = this.mVelocityTracker;
            velocityTracker.computeCurrentVelocity(1000, (float)this.mMaximumFlingVelocity);
            int n2 = (int)velocityTracker.getYVelocity();
            if (Math.abs((int)n2) >= Math.abs((int)this.mMaximumFlingVelocity)) {
                n2 = (int)((float)n2 * this.mMaxFlingSpeedFactor);
            }
            if (Math.abs((int)n2) > this.mMinimumFlingVelocity) {
                this.fling(n2);
                this.onScrollStateChange(2);
            } else {
                int n3 = (int)motionEvent.getY();
                int n4 = (int)Math.abs((float)((float)n3 - this.mLastDownEventY));
                long l = motionEvent.getEventTime() - this.mLastDownEventTime;
                if (n4 <= this.mTouchSlop && l < (long)ViewConfiguration.getTapTimeout()) {
                    if (this.mShowSoftInputOnTap) {
                        this.mShowSoftInputOnTap = false;
                    } else {
                        int n5 = n3 / this.mSelectorElementHeight - 1;
                        if (n5 > 0) {
                            this.changeValueByOne(true);
                            this.mPressedStateHelper.buttonTapped(1);
                        } else if (n5 < 0) {
                            this.changeValueByOne(false);
                            this.mPressedStateHelper.buttonTapped(2);
                        }
                    }
                } else {
                    this.ensureScrollWheelAdjusted();
                }
                this.onScrollStateChange(0);
            }
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
            return true;
        }
        return false;
    }

    public void scrollBy(int n, int n2) {
        int n3;
        int n4;
        int[] arrn = this.mSelectorIndices;
        if (!this.mWrapSelectorWheel && n2 > 0 && arrn[1] <= this.mMinValue) {
            this.mCurrentScrollOffset = this.mInitialScrollOffset;
            return;
        }
        if (!this.mWrapSelectorWheel && n2 < 0 && arrn[1] >= this.mMaxValue) {
            this.mCurrentScrollOffset = this.mInitialScrollOffset;
            return;
        }
        this.mCurrentScrollOffset = n2 + this.mCurrentScrollOffset;
        while ((n4 = this.mCurrentScrollOffset) - this.mInitialScrollOffset > this.mSelectorTextGapHeight) {
            this.mCurrentScrollOffset = n4 - this.mSelectorElementHeight;
            this.decrementSelectorIndices(arrn);
            this.setValueInternal(arrn[1], true);
            if (this.mWrapSelectorWheel || arrn[1] > this.mMinValue) continue;
            this.mCurrentScrollOffset = this.mInitialScrollOffset;
        }
        while ((n3 = this.mCurrentScrollOffset) - this.mInitialScrollOffset < -this.mSelectorTextGapHeight) {
            this.mCurrentScrollOffset = n3 + this.mSelectorElementHeight;
            this.incrementSelectorIndices(arrn);
            this.setValueInternal(arrn[1], true);
            if (this.mWrapSelectorWheel || arrn[1] < this.mMaxValue) continue;
            this.mCurrentScrollOffset = this.mInitialScrollOffset;
        }
    }

    public void setDisplayedValues(String[] arrstring) {
        if (this.mDisplayedValues == arrstring) {
            return;
        }
        this.mDisplayedValues = arrstring;
        if (this.mDisplayedValues != null) {
            this.mInputText.setRawInputType(524289);
        } else {
            this.mInputText.setRawInputType(2);
        }
        this.updateInputTextView();
        this.initializeSelectorWheelIndices();
        this.tryComputeMaxWidth();
    }

    public void setFormatter(Formatter formatter) {
        if (formatter == this.mFormatter) {
            return;
        }
        this.mFormatter = formatter;
        this.initializeSelectorWheelIndices();
        this.updateInputTextView();
    }

    public void setLabel(String string2) {
        CharSequence charSequence;
        if (this.mLabel == null && string2 != null || (charSequence = this.mLabel) != null && !charSequence.equals((Object)string2)) {
            this.mLabel = string2;
            this.invalidate();
        }
    }

    public void setLabelTextSizeThreshold(float f) {
        this.mLabelTextSizeThreshold = Math.max((float)f, (float)0.0f);
    }

    public void setLabelTextSizeTrimFactor(float f) {
        if (f > 0.0f && f < 1.0f) {
            this.mLabelTextSizeTrimFactor = f;
        }
    }

    public void setMaxFlingSpeedFactor(float f) {
        if (f >= 0.0f) {
            this.mMaxFlingSpeedFactor = f;
        }
    }

    public void setMaxValue(int n) {
        if (this.mMaxValue == n) {
            return;
        }
        if (n >= 0) {
            this.mMaxValue = n;
            int n2 = this.mMaxValue;
            if (n2 < this.mValue) {
                this.mValue = n2;
            }
            boolean bl = this.mMaxValue - this.mMinValue > this.mSelectorIndices.length;
            this.setWrapSelectorWheel(bl);
            this.initializeSelectorWheelIndices();
            this.updateInputTextView();
            this.tryComputeMaxWidth();
            this.invalidate();
            return;
        }
        throw new IllegalArgumentException("maxValue must be >= 0");
    }

    public void setMinValue(int n) {
        if (this.mMinValue == n) {
            return;
        }
        if (n >= 0) {
            this.mMinValue = n;
            int n2 = this.mMinValue;
            if (n2 > this.mValue) {
                this.mValue = n2;
            }
            boolean bl = this.mMaxValue - this.mMinValue > this.mSelectorIndices.length;
            this.setWrapSelectorWheel(bl);
            this.initializeSelectorWheelIndices();
            this.updateInputTextView();
            this.tryComputeMaxWidth();
            this.invalidate();
            return;
        }
        throw new IllegalArgumentException("minValue must be >= 0");
    }

    public void setOnLongPressUpdateInterval(long l) {
        this.mLongPressUpdateInterval = l;
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.mOnScrollListener = onScrollListener;
    }

    public void setOnValueChangedListener(OnValueChangeListener onValueChangeListener) {
        this.mOnValueChangeListener = onValueChangeListener;
    }

    public void setValue(int n) {
        this.setValueInternal(n, false);
    }

    public void setWrapSelectorWheel(boolean bl) {
        boolean bl2 = this.mMaxValue - this.mMinValue >= this.mSelectorIndices.length;
        if ((!bl || bl2) && bl != this.mWrapSelectorWheel) {
            this.mWrapSelectorWheel = bl;
        }
        this.refreshWheel();
    }

    class AccessibilityNodeProviderImpl
    extends AccessibilityNodeProvider {
        private static final int UNDEFINED = Integer.MIN_VALUE;
        private static final int VIRTUAL_VIEW_ID_DECREMENT = 3;
        private static final int VIRTUAL_VIEW_ID_INCREMENT = 1;
        private static final int VIRTUAL_VIEW_ID_INPUT = 2;
        private int mAccessibilityFocusedView = Integer.MIN_VALUE;
        private final int[] mTempArray = new int[2];
        private final Rect mTempRect = new Rect();

        AccessibilityNodeProviderImpl() {
        }

        private AccessibilityNodeInfo createAccessibilityNodeInfoForNumberPicker(int n, int n2, int n3, int n4) {
            AccessibilityNodeInfo accessibilityNodeInfo = AccessibilityNodeInfo.obtain();
            accessibilityNodeInfo.setClassName((CharSequence)NumberPicker.class.getName());
            accessibilityNodeInfo.setPackageName((CharSequence)NumberPicker.this.getContext().getPackageName());
            accessibilityNodeInfo.setSource((View)NumberPicker.this);
            if (this.hasVirtualDecrementButton()) {
                accessibilityNodeInfo.addChild((View)NumberPicker.this, 3);
            }
            accessibilityNodeInfo.addChild((View)NumberPicker.this, 2);
            if (this.hasVirtualIncrementButton()) {
                accessibilityNodeInfo.addChild((View)NumberPicker.this, 1);
            }
            accessibilityNodeInfo.setParent((View)NumberPicker.this.getParentForAccessibility());
            accessibilityNodeInfo.setEnabled(NumberPicker.this.isEnabled());
            accessibilityNodeInfo.setScrollable(true);
            Rect rect = this.mTempRect;
            rect.set(n, n2, n3, n4);
            accessibilityNodeInfo.setBoundsInParent(rect);
            boolean bl = NumberPicker.this.getVisibility() == 0;
            accessibilityNodeInfo.setVisibleToUser(bl);
            int[] arrn = this.mTempArray;
            NumberPicker.this.getLocationOnScreen(arrn);
            rect.offset(arrn[0], arrn[1]);
            accessibilityNodeInfo.setBoundsInScreen(rect);
            if (this.mAccessibilityFocusedView != -1) {
                accessibilityNodeInfo.addAction(64);
            }
            if (this.mAccessibilityFocusedView == -1) {
                accessibilityNodeInfo.addAction(128);
            }
            if (NumberPicker.this.isEnabled()) {
                if (NumberPicker.this.getWrapSelectorWheel() || NumberPicker.this.getValue() < NumberPicker.this.getMaxValue()) {
                    accessibilityNodeInfo.addAction(4096);
                }
                if (NumberPicker.this.getWrapSelectorWheel() || NumberPicker.this.getValue() > NumberPicker.this.getMinValue()) {
                    accessibilityNodeInfo.addAction(8192);
                }
            }
            return accessibilityNodeInfo;
        }

        private AccessibilityNodeInfo createAccessibilityNodeInfoForVirtualButton(int n, String string2, int n2, int n3, int n4, int n5) {
            AccessibilityNodeInfo accessibilityNodeInfo = AccessibilityNodeInfo.obtain();
            accessibilityNodeInfo.setClassName((CharSequence)Button.class.getName());
            accessibilityNodeInfo.setPackageName((CharSequence)NumberPicker.this.getContext().getPackageName());
            accessibilityNodeInfo.setSource((View)NumberPicker.this, n);
            accessibilityNodeInfo.setParent((View)NumberPicker.this);
            accessibilityNodeInfo.setText((CharSequence)string2);
            accessibilityNodeInfo.setClickable(true);
            accessibilityNodeInfo.setLongClickable(true);
            accessibilityNodeInfo.setEnabled(NumberPicker.this.isEnabled());
            Rect rect = this.mTempRect;
            rect.set(n2, n3, n4, n5);
            boolean bl = NumberPicker.this.getVisibility() == 0;
            accessibilityNodeInfo.setVisibleToUser(bl);
            accessibilityNodeInfo.setBoundsInParent(rect);
            int[] arrn = this.mTempArray;
            NumberPicker.this.getLocationOnScreen(arrn);
            rect.offset(arrn[0], arrn[1]);
            accessibilityNodeInfo.setBoundsInScreen(rect);
            if (this.mAccessibilityFocusedView != n) {
                accessibilityNodeInfo.addAction(64);
            }
            if (this.mAccessibilityFocusedView == n) {
                accessibilityNodeInfo.addAction(128);
            }
            if (NumberPicker.this.isEnabled()) {
                accessibilityNodeInfo.addAction(16);
            }
            return accessibilityNodeInfo;
        }

        private AccessibilityNodeInfo createAccessibiltyNodeInfoForInputText(int n, int n2, int n3, int n4) {
            AccessibilityNodeInfo accessibilityNodeInfo = NumberPicker.this.mInputText.createAccessibilityNodeInfo();
            accessibilityNodeInfo.setSource((View)NumberPicker.this, 2);
            if (this.mAccessibilityFocusedView != 2) {
                accessibilityNodeInfo.addAction(64);
            }
            if (this.mAccessibilityFocusedView == 2) {
                accessibilityNodeInfo.addAction(128);
            }
            Rect rect = this.mTempRect;
            rect.set(n, n2, n3, n4);
            boolean bl = NumberPicker.this.getVisibility() == 0;
            accessibilityNodeInfo.setVisibleToUser(bl);
            accessibilityNodeInfo.setBoundsInParent(rect);
            int[] arrn = this.mTempArray;
            NumberPicker.this.getLocationOnScreen(arrn);
            rect.offset(arrn[0], arrn[1]);
            accessibilityNodeInfo.setBoundsInScreen(rect);
            return accessibilityNodeInfo;
        }

        private void findAccessibilityNodeInfosByTextInChild(String string2, int n, List<AccessibilityNodeInfo> list) {
            if (n != 1) {
                if (n != 2) {
                    if (n != 3) {
                        return;
                    }
                    String string3 = this.getVirtualDecrementButtonText();
                    if (!TextUtils.isEmpty((CharSequence)string3) && string3.toString().toLowerCase().contains((CharSequence)string2)) {
                        list.add((Object)this.createAccessibilityNodeInfo(3));
                    }
                    return;
                }
                Editable editable = NumberPicker.this.mInputText.getText();
                if (!TextUtils.isEmpty((CharSequence)editable) && editable.toString().toLowerCase().contains((CharSequence)string2)) {
                    list.add((Object)this.createAccessibilityNodeInfo(2));
                    return;
                }
                Editable editable2 = NumberPicker.this.mInputText.getText();
                if (!TextUtils.isEmpty((CharSequence)editable2) && editable2.toString().toLowerCase().contains((CharSequence)string2)) {
                    list.add((Object)this.createAccessibilityNodeInfo(2));
                }
                return;
            }
            String string4 = this.getVirtualIncrementButtonText();
            if (!TextUtils.isEmpty((CharSequence)string4) && string4.toString().toLowerCase().contains((CharSequence)string2)) {
                list.add((Object)this.createAccessibilityNodeInfo(1));
            }
        }

        private String getVirtualDecrementButtonText() {
            int n = -1 + NumberPicker.this.mValue;
            if (NumberPicker.this.mWrapSelectorWheel) {
                n = NumberPicker.this.getWrappedSelectorIndex(n);
            }
            if (n >= NumberPicker.this.mMinValue) {
                if (NumberPicker.this.mDisplayedValues == null) {
                    return NumberPicker.this.formatNumber(n);
                }
                return NumberPicker.this.mDisplayedValues[n - NumberPicker.this.mMinValue];
            }
            return null;
        }

        private String getVirtualIncrementButtonText() {
            int n = 1 + NumberPicker.this.mValue;
            if (NumberPicker.this.mWrapSelectorWheel) {
                n = NumberPicker.this.getWrappedSelectorIndex(n);
            }
            if (n <= NumberPicker.this.mMaxValue) {
                if (NumberPicker.this.mDisplayedValues == null) {
                    return NumberPicker.this.formatNumber(n);
                }
                return NumberPicker.this.mDisplayedValues[n - NumberPicker.this.mMinValue];
            }
            return null;
        }

        private boolean hasVirtualDecrementButton() {
            return NumberPicker.this.getWrapSelectorWheel() || NumberPicker.this.getValue() > NumberPicker.this.getMinValue();
            {
            }
        }

        private boolean hasVirtualIncrementButton() {
            return NumberPicker.this.getWrapSelectorWheel() || NumberPicker.this.getValue() < NumberPicker.this.getMaxValue();
            {
            }
        }

        private void sendAccessibilityEventForVirtualButton(int n, int n2, String string2) {
            if (((AccessibilityManager)NumberPicker.this.getContext().getSystemService("accessibility")).isEnabled()) {
                AccessibilityEvent accessibilityEvent = AccessibilityEvent.obtain((int)n2);
                accessibilityEvent.setClassName((CharSequence)Button.class.getName());
                accessibilityEvent.setPackageName((CharSequence)NumberPicker.this.getContext().getPackageName());
                accessibilityEvent.getText().add((Object)string2);
                accessibilityEvent.setEnabled(NumberPicker.this.isEnabled());
                accessibilityEvent.setSource((View)NumberPicker.this, n);
                NumberPicker numberPicker = NumberPicker.this;
                numberPicker.requestSendAccessibilityEvent((View)numberPicker, accessibilityEvent);
            }
        }

        private void sendAccessibilityEventForVirtualText(int n) {
            if (((AccessibilityManager)NumberPicker.this.getContext().getSystemService("accessibility")).isEnabled()) {
                AccessibilityEvent accessibilityEvent = AccessibilityEvent.obtain((int)n);
                NumberPicker.this.mInputText.onInitializeAccessibilityEvent(accessibilityEvent);
                NumberPicker.this.mInputText.onPopulateAccessibilityEvent(accessibilityEvent);
                accessibilityEvent.setSource((View)NumberPicker.this, 2);
                NumberPicker numberPicker = NumberPicker.this;
                numberPicker.requestSendAccessibilityEvent((View)numberPicker, accessibilityEvent);
            }
        }

        public AccessibilityNodeInfo createAccessibilityNodeInfo(int n) {
            if (n != -1) {
                if (n != 1) {
                    if (n != 2) {
                        if (n != 3) {
                            return super.createAccessibilityNodeInfo(n);
                        }
                        return this.createAccessibilityNodeInfoForVirtualButton(3, this.getVirtualDecrementButtonText(), NumberPicker.this.getScrollX(), NumberPicker.this.getScrollY(), NumberPicker.this.getScrollX() + (NumberPicker.this.getRight() - NumberPicker.this.getLeft()), NumberPicker.this.mTopSelectionDividerTop + NumberPicker.this.mSelectionDividerHeight);
                    }
                    return this.createAccessibiltyNodeInfoForInputText(NumberPicker.this.getScrollX(), NumberPicker.this.mTopSelectionDividerTop + NumberPicker.this.mSelectionDividerHeight, NumberPicker.this.getScrollX() + (NumberPicker.this.getRight() - NumberPicker.this.getLeft()), NumberPicker.this.mBottomSelectionDividerBottom - NumberPicker.this.mSelectionDividerHeight);
                }
                return this.createAccessibilityNodeInfoForVirtualButton(1, this.getVirtualIncrementButtonText(), NumberPicker.this.getScrollX(), NumberPicker.this.mBottomSelectionDividerBottom - NumberPicker.this.mSelectionDividerHeight, NumberPicker.this.getScrollX() + (NumberPicker.this.getRight() - NumberPicker.this.getLeft()), NumberPicker.this.getScrollY() + (NumberPicker.this.getBottom() - NumberPicker.this.getTop()));
            }
            return this.createAccessibilityNodeInfoForNumberPicker(NumberPicker.this.getScrollX(), NumberPicker.this.getScrollY(), NumberPicker.this.getScrollX() + (NumberPicker.this.getRight() - NumberPicker.this.getLeft()), NumberPicker.this.getScrollY() + (NumberPicker.this.getBottom() - NumberPicker.this.getTop()));
        }

        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String string2, int n) {
            if (TextUtils.isEmpty((CharSequence)string2)) {
                return Collections.emptyList();
            }
            String string3 = string2.toLowerCase();
            ArrayList arrayList = new ArrayList();
            if (n != -1) {
                if (n != 1 && n != 2 && n != 3) {
                    return super.findAccessibilityNodeInfosByText(string2, n);
                }
                this.findAccessibilityNodeInfosByTextInChild(string3, n, (List<AccessibilityNodeInfo>)arrayList);
                return arrayList;
            }
            this.findAccessibilityNodeInfosByTextInChild(string3, 3, (List<AccessibilityNodeInfo>)arrayList);
            this.findAccessibilityNodeInfosByTextInChild(string3, 2, (List<AccessibilityNodeInfo>)arrayList);
            this.findAccessibilityNodeInfosByTextInChild(string3, 1, (List<AccessibilityNodeInfo>)arrayList);
            return arrayList;
        }

        public boolean performAction(int n, int n2, Bundle bundle) {
            block35 : {
                block36 : {
                    block37 : {
                        block38 : {
                            block34 : {
                                block31 : {
                                    block32 : {
                                        block33 : {
                                            if (n == -1) break block31;
                                            if (n == 1) break block32;
                                            if (n == 2) break block33;
                                            if (n == 3) {
                                                if (n2 != 16) {
                                                    if (n2 != 64) {
                                                        if (n2 != 128) {
                                                            return false;
                                                        }
                                                        if (this.mAccessibilityFocusedView == n) {
                                                            this.mAccessibilityFocusedView = Integer.MIN_VALUE;
                                                            this.sendAccessibilityEventForVirtualView(n, 65536);
                                                            NumberPicker numberPicker = NumberPicker.this;
                                                            numberPicker.invalidate(0, 0, numberPicker.getRight(), NumberPicker.this.mTopSelectionDividerTop);
                                                            return true;
                                                        }
                                                        return false;
                                                    }
                                                    if (this.mAccessibilityFocusedView != n) {
                                                        this.mAccessibilityFocusedView = n;
                                                        this.sendAccessibilityEventForVirtualView(n, 32768);
                                                        NumberPicker numberPicker = NumberPicker.this;
                                                        numberPicker.invalidate(0, 0, numberPicker.getRight(), NumberPicker.this.mTopSelectionDividerTop);
                                                        return true;
                                                    }
                                                    return false;
                                                }
                                                if (NumberPicker.this.isEnabled()) {
                                                    boolean bl = false;
                                                    if (n == 1) {
                                                        bl = true;
                                                    }
                                                    NumberPicker.this.changeValueByOne(bl);
                                                    this.sendAccessibilityEventForVirtualView(n, 1);
                                                    return true;
                                                }
                                                return false;
                                            }
                                            break block34;
                                        }
                                        if (n2 != 1) {
                                            if (n2 != 2) {
                                                if (n2 != 16) {
                                                    if (n2 != 64) {
                                                        if (n2 != 128) {
                                                            return NumberPicker.this.mInputText.performAccessibilityAction(n2, bundle);
                                                        }
                                                        if (this.mAccessibilityFocusedView == n) {
                                                            this.mAccessibilityFocusedView = Integer.MIN_VALUE;
                                                            this.sendAccessibilityEventForVirtualView(n, 65536);
                                                            NumberPicker.this.mInputText.invalidate();
                                                            return true;
                                                        }
                                                        return false;
                                                    }
                                                    if (this.mAccessibilityFocusedView != n) {
                                                        this.mAccessibilityFocusedView = n;
                                                        this.sendAccessibilityEventForVirtualView(n, 32768);
                                                        NumberPicker.this.mInputText.invalidate();
                                                        return true;
                                                    }
                                                    return false;
                                                }
                                                return NumberPicker.this.isEnabled();
                                            }
                                            if (NumberPicker.this.isEnabled() && NumberPicker.this.mInputText.isFocused()) {
                                                NumberPicker.this.mInputText.clearFocus();
                                                return true;
                                            }
                                            return false;
                                        }
                                        if (NumberPicker.this.isEnabled() && !NumberPicker.this.mInputText.isFocused()) {
                                            return NumberPicker.this.mInputText.requestFocus();
                                        }
                                        return false;
                                    }
                                    if (n2 != 16) {
                                        if (n2 != 64) {
                                            if (n2 != 128) {
                                                return false;
                                            }
                                            if (this.mAccessibilityFocusedView == n) {
                                                this.mAccessibilityFocusedView = Integer.MIN_VALUE;
                                                this.sendAccessibilityEventForVirtualView(n, 65536);
                                                NumberPicker numberPicker = NumberPicker.this;
                                                numberPicker.invalidate(0, numberPicker.mBottomSelectionDividerBottom, NumberPicker.this.getRight(), NumberPicker.this.getBottom());
                                                return true;
                                            }
                                            return false;
                                        }
                                        if (this.mAccessibilityFocusedView != n) {
                                            this.mAccessibilityFocusedView = n;
                                            this.sendAccessibilityEventForVirtualView(n, 32768);
                                            NumberPicker numberPicker = NumberPicker.this;
                                            numberPicker.invalidate(0, numberPicker.mBottomSelectionDividerBottom, NumberPicker.this.getRight(), NumberPicker.this.getBottom());
                                            return true;
                                        }
                                        return false;
                                    }
                                    if (NumberPicker.this.isEnabled()) {
                                        NumberPicker.this.changeValueByOne(true);
                                        this.sendAccessibilityEventForVirtualView(n, 1);
                                        return true;
                                    }
                                    return false;
                                }
                                if (n2 == 64) break block35;
                                if (n2 == 128) break block36;
                                if (n2 == 4096) break block37;
                                if (n2 == 8192) break block38;
                            }
                            return super.performAction(n, n2, bundle);
                        }
                        if (NumberPicker.this.isEnabled() && (NumberPicker.this.getWrapSelectorWheel() || NumberPicker.this.getValue() > NumberPicker.this.getMinValue())) {
                            NumberPicker.this.changeValueByOne(false);
                            return true;
                        }
                        return false;
                    }
                    if (NumberPicker.this.isEnabled() && (NumberPicker.this.getWrapSelectorWheel() || NumberPicker.this.getValue() < NumberPicker.this.getMaxValue())) {
                        NumberPicker.this.changeValueByOne(true);
                        return true;
                    }
                    return false;
                }
                if (this.mAccessibilityFocusedView == n) {
                    this.mAccessibilityFocusedView = Integer.MIN_VALUE;
                    return true;
                }
                return false;
            }
            if (this.mAccessibilityFocusedView != n) {
                this.mAccessibilityFocusedView = n;
                return true;
            }
            return false;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public void sendAccessibilityEventForVirtualView(int n, int n2) {
            if (n != 1) {
                if (n != 2) {
                    if (n != 3) {
                        return;
                    }
                    if (!this.hasVirtualDecrementButton()) return;
                    this.sendAccessibilityEventForVirtualButton(n, n2, this.getVirtualDecrementButtonText());
                    return;
                }
                this.sendAccessibilityEventForVirtualText(n2);
                return;
            }
            if (!this.hasVirtualIncrementButton()) return;
            this.sendAccessibilityEventForVirtualButton(n, n2, this.getVirtualIncrementButtonText());
        }
    }

    class BeginSoftInputOnLongPressCommand
    implements Runnable {
        BeginSoftInputOnLongPressCommand() {
        }

        public void run() {
            NumberPicker.this.mIngonreMoveEvents = true;
        }
    }

    class ChangeCurrentByOneFromLongPressCommand
    implements Runnable {
        private boolean mIncrement;

        ChangeCurrentByOneFromLongPressCommand() {
        }

        private void setStep(boolean bl) {
            this.mIncrement = bl;
        }

        public void run() {
            NumberPicker.this.changeValueByOne(this.mIncrement);
            NumberPicker numberPicker = NumberPicker.this;
            numberPicker.postDelayed((Runnable)this, numberPicker.mLongPressUpdateInterval);
        }
    }

    public static interface Formatter {
        public String format(int var1);
    }

    class InputTextFilter
    extends NumberKeyListener {
        InputTextFilter() {
        }

        public CharSequence filter(CharSequence charSequence, int n, int n2, Spanned spanned, int n3, int n4) {
            String[] arrstring = NumberPicker.this.mDisplayedValues;
            if (arrstring == null) {
                CharSequence charSequence2 = super.filter(charSequence, n, n2, spanned, n3, n4);
                if (charSequence2 == null) {
                    charSequence2 = charSequence.subSequence(n, n2);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(String.valueOf((Object)spanned.subSequence(0, n3)));
                stringBuilder.append((Object)charSequence2);
                stringBuilder.append((Object)spanned.subSequence(n4, spanned.length()));
                String string2 = stringBuilder.toString();
                if ("".equals((Object)string2)) {
                    return string2;
                }
                if (NumberPicker.this.getSelectedPos(string2) <= NumberPicker.this.mMaxValue) {
                    if (string2.length() > String.valueOf((int)NumberPicker.this.mMaxValue).length()) {
                        return "";
                    }
                    return charSequence2;
                }
                return "";
            }
            String string3 = String.valueOf((Object)charSequence.subSequence(n, n2));
            if (TextUtils.isEmpty((CharSequence)string3)) {
                return "";
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(String.valueOf((Object)spanned.subSequence(0, n3)));
            stringBuilder.append((Object)string3);
            stringBuilder.append((Object)spanned.subSequence(n4, spanned.length()));
            String string4 = stringBuilder.toString();
            String string5 = String.valueOf((Object)string4).toLowerCase();
            for (String string6 : NumberPicker.this.mDisplayedValues) {
                if (!string6.toLowerCase().startsWith(string5)) continue;
                NumberPicker.this.postSetSelectionCommand(string4.length(), string6.length());
                return string6.subSequence(n3, string6.length());
            }
            return "";
        }

        protected char[] getAcceptedChars() {
            return DIGIT_CHARACTERS;
        }

        public int getInputType() {
            return 1;
        }
    }

    public static interface OnScrollListener {
        public static final int SCROLL_STATE_FLING = 2;
        public static final int SCROLL_STATE_IDLE = 0;
        public static final int SCROLL_STATE_TOUCH_SCROLL = 1;

        public void onScrollStateChange(NumberPicker var1, int var2);
    }

    public static interface OnValueChangeListener {
        public void onValueChange(NumberPicker var1, int var2, int var3);
    }

    class PressedStateHelper
    implements Runnable {
        public static final int BUTTON_DECREMENT = 2;
        public static final int BUTTON_INCREMENT = 1;
        private final int MODE_PRESS = 1;
        private final int MODE_TAPPED = 2;
        private int mManagedButton;
        private int mMode;

        PressedStateHelper() {
        }

        public void buttonPressDelayed(int n) {
            this.cancel();
            this.mMode = 1;
            this.mManagedButton = n;
            NumberPicker.this.postDelayed((Runnable)this, (long)ViewConfiguration.getTapTimeout());
        }

        public void buttonTapped(int n) {
            this.cancel();
            this.mMode = 2;
            this.mManagedButton = n;
            NumberPicker.this.post((Runnable)this);
        }

        public void cancel() {
            this.mMode = 0;
            this.mManagedButton = 0;
            NumberPicker.this.removeCallbacks((Runnable)this);
            if (NumberPicker.this.mIncrementVirtualButtonPressed) {
                NumberPicker.this.mIncrementVirtualButtonPressed = false;
                NumberPicker numberPicker = NumberPicker.this;
                numberPicker.invalidate(0, numberPicker.mBottomSelectionDividerBottom, NumberPicker.this.getRight(), NumberPicker.this.getBottom());
            }
            if (NumberPicker.this.mDecrementVirtualButtonPressed) {
                NumberPicker.this.mDecrementVirtualButtonPressed = false;
                NumberPicker numberPicker = NumberPicker.this;
                numberPicker.invalidate(0, 0, numberPicker.getRight(), NumberPicker.this.mTopSelectionDividerTop);
            }
        }

        public void run() {
            int n = this.mMode;
            if (n != 1) {
                if (n != 2) {
                    return;
                }
                int n2 = this.mManagedButton;
                if (n2 != 1) {
                    if (n2 != 2) {
                        return;
                    }
                    if (!NumberPicker.this.mDecrementVirtualButtonPressed) {
                        NumberPicker.this.postDelayed((Runnable)this, (long)ViewConfiguration.getPressedStateDuration());
                    }
                    NumberPicker numberPicker = NumberPicker.this;
                    numberPicker.mDecrementVirtualButtonPressed = true ^ numberPicker.mDecrementVirtualButtonPressed;
                    NumberPicker numberPicker2 = NumberPicker.this;
                    numberPicker2.invalidate(0, 0, numberPicker2.getRight(), NumberPicker.this.mTopSelectionDividerTop);
                    return;
                }
                if (!NumberPicker.this.mIncrementVirtualButtonPressed) {
                    NumberPicker.this.postDelayed((Runnable)this, (long)ViewConfiguration.getPressedStateDuration());
                }
                NumberPicker numberPicker = NumberPicker.this;
                numberPicker.mIncrementVirtualButtonPressed = true ^ numberPicker.mIncrementVirtualButtonPressed;
                NumberPicker numberPicker3 = NumberPicker.this;
                numberPicker3.invalidate(0, numberPicker3.mBottomSelectionDividerBottom, NumberPicker.this.getRight(), NumberPicker.this.getBottom());
                return;
            }
            int n3 = this.mManagedButton;
            if (n3 != 1) {
                if (n3 != 2) {
                    return;
                }
                NumberPicker.this.mDecrementVirtualButtonPressed = true;
                NumberPicker numberPicker = NumberPicker.this;
                numberPicker.invalidate(0, 0, numberPicker.getRight(), NumberPicker.this.mTopSelectionDividerTop);
                return;
            }
            NumberPicker.this.mIncrementVirtualButtonPressed = true;
            NumberPicker numberPicker = NumberPicker.this;
            numberPicker.invalidate(0, numberPicker.mBottomSelectionDividerBottom, NumberPicker.this.getRight(), NumberPicker.this.getBottom());
        }
    }

    class SetSelectionCommand
    implements Runnable {
        private int mSelectionEnd;
        private int mSelectionStart;

        SetSelectionCommand() {
        }

        public void run() {
            if (this.mSelectionEnd < NumberPicker.this.mInputText.length()) {
                NumberPicker.this.mInputText.setSelection(this.mSelectionStart, this.mSelectionEnd);
            }
        }
    }

    private static class SoundPlayHandler
    extends Handler {
        private static final int MSG_INIT = 0;
        private static final int MSG_PLAY = 1;
        private static final int MSG_RELEASE = 2;
        private static final SoundPlayerContainer sPlayerContainer = new SoundPlayerContainer();

        SoundPlayHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            int n = message.what;
            if (n != 0) {
                if (n != 1) {
                    if (n != 2) {
                        return;
                    }
                    sPlayerContainer.release(message.arg1);
                    return;
                }
                sPlayerContainer.play();
                return;
            }
            sPlayerContainer.init((Context)message.obj, message.arg1);
        }

        void init(Context context, int n) {
            Message message = this.obtainMessage(0, n, 0);
            message.obj = context;
            this.sendMessage(message);
        }

        void play() {
            this.sendMessage(this.obtainMessage(1));
        }

        void release(int n) {
            this.sendMessage(this.obtainMessage(2, n, 0));
        }

        void stop() {
            this.removeMessages(1);
        }

        private static class SoundPlayerContainer {
            private static final long INTERVAL = 50L;
            private long mPrevPlayTime;
            private Set<Integer> mRefs = new ArraySet();
            private int mSoundId;
            private SoundPool mSoundPlayer;

            private SoundPlayerContainer() {
            }

            void init(Context context, int n) {
                if (this.mSoundPlayer == null) {
                    this.mSoundPlayer = new SoundPool(1, 1, 0);
                    this.mSoundId = this.mSoundPlayer.load(context, R.raw.number_picker_value_change, 1);
                }
                this.mRefs.add((Object)n);
            }

            void play() {
                long l = System.currentTimeMillis();
                SoundPool soundPool = this.mSoundPlayer;
                if (soundPool != null && l - this.mPrevPlayTime > 50L) {
                    soundPool.play(this.mSoundId, 1.0f, 1.0f, 0, 0, 1.0f);
                    this.mPrevPlayTime = l;
                }
            }

            void release(int n) {
                SoundPool soundPool;
                if (this.mRefs.remove((Object)n) && this.mRefs.isEmpty() && (soundPool = this.mSoundPlayer) != null) {
                    soundPool.release();
                    this.mSoundPlayer = null;
                }
            }
        }

    }

}

