/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.text.TextUtils
 *  android.text.format.DateFormat
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.SparseArray
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$BaseSavedState
 *  android.view.ViewGroup
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.accessibility.AccessibilityNodeInfo
 *  android.widget.FrameLayout
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.text.DateFormat
 *  java.text.ParseException
 *  java.text.SimpleDateFormat
 *  java.util.Arrays
 *  java.util.Date
 *  java.util.List
 *  java.util.Locale
 *  miuix.pickerwidget.widget.DatePicker$1
 *  miuix.pickerwidget.widget.NumberPicker$NumberFormatter
 */
package miuix.pickerwidget.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import miuix.pickerwidget.R;
import miuix.pickerwidget.date.Calendar;
import miuix.pickerwidget.date.CalendarFormatSymbols;
import miuix.pickerwidget.date.DateUtils;
import miuix.pickerwidget.widget.DatePicker;
import miuix.pickerwidget.widget.NumberPicker;

/*
 * Exception performing whole class analysis.
 */
public class DatePicker
extends FrameLayout {
    private static final String DATE_FORMAT = "MM/dd/yyyy";
    private static final boolean DEFAULT_CALENDAR_VIEW_SHOWN = false;
    private static final boolean DEFAULT_ENABLED_STATE = true;
    private static final int DEFAULT_END_YEAR = 2100;
    private static final boolean DEFAULT_SPINNERS_SHOWN = true;
    private static final int DEFAULT_START_YEAR = 1900;
    private static final String LOG_TAG = "DatePicker";
    private static String[] sChineseDays;
    private static String sChineseLeapMonthMark;
    private static String[] sChineseLeapYearMonths;
    private static String[] sChineseMonths;
    private Calendar mCurrentDate;
    private Locale mCurrentLocale;
    private final java.text.DateFormat mDateFormat;
    private char[] mDateFormatOrder;
    private final NumberPicker mDaySpinner;
    private boolean mIsEnabled;
    private boolean mIsLunarMode;
    private Calendar mMaxDate;
    private Calendar mMinDate;
    private final NumberPicker mMonthSpinner;
    private int mNumberOfMonths;
    private OnDateChangedListener mOnDateChangedListener;
    private String[] mShortMonths;
    private final LinearLayout mSpinners;
    private Calendar mTempDate;
    private final NumberPicker mYearSpinner;

    public DatePicker(Context context) {
        this(context, null);
    }

    public DatePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.datePickerStyle);
    }

    public DatePicker(Context context, AttributeSet attributeSet, int n) {
        String string2;
        super(context, attributeSet, n);
        this.mDateFormat = new SimpleDateFormat(DATE_FORMAT);
        this.mIsEnabled = true;
        this.mIsLunarMode = false;
        this.initChineseDaysIfNeeded();
        this.mTempDate = new Calendar();
        this.mMinDate = new Calendar();
        this.mMaxDate = new Calendar();
        this.mCurrentDate = new Calendar();
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.DatePicker, n, R.style.Widget_DatePicker);
        boolean bl = typedArray.getBoolean(R.styleable.DatePicker_spinnersShown, true);
        int n2 = typedArray.getInt(R.styleable.DatePicker_startYear, 1900);
        int n3 = typedArray.getInt(R.styleable.DatePicker_endYear, 2100);
        String string3 = typedArray.getString(R.styleable.DatePicker_minDate);
        String string4 = typedArray.getString(R.styleable.DatePicker_maxDate);
        int n4 = R.layout.miuix_appcompat_date_picker;
        this.mIsLunarMode = typedArray.getBoolean(R.styleable.DatePicker_lunarCalendar, false);
        boolean bl2 = typedArray.getBoolean(R.styleable.DatePicker_showYear, true);
        boolean bl3 = typedArray.getBoolean(R.styleable.DatePicker_showMonth, true);
        boolean bl4 = typedArray.getBoolean(R.styleable.DatePicker_showDay, true);
        typedArray.recycle();
        this.setCurrentLocale(Locale.getDefault());
        ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(n4, (ViewGroup)this, true);
        1 var15_14 = new 1(this);
        this.mSpinners = (LinearLayout)this.findViewById(R.id.pickers);
        this.mDaySpinner = (NumberPicker)this.findViewById(R.id.day);
        this.mDaySpinner.setOnLongPressUpdateInterval(100L);
        this.mDaySpinner.setOnValueChangedListener((NumberPicker.OnValueChangeListener)var15_14);
        if (!bl4) {
            this.mDaySpinner.setVisibility(8);
        }
        this.mMonthSpinner = (NumberPicker)this.findViewById(R.id.month);
        this.mMonthSpinner.setMinValue(0);
        this.mMonthSpinner.setMaxValue(this.mNumberOfMonths - 1);
        this.mMonthSpinner.setDisplayedValues(this.mShortMonths);
        this.mMonthSpinner.setOnLongPressUpdateInterval(200L);
        this.mMonthSpinner.setOnValueChangedListener((NumberPicker.OnValueChangeListener)var15_14);
        if (!bl3) {
            this.mMonthSpinner.setVisibility(8);
        }
        this.mYearSpinner = (NumberPicker)this.findViewById(R.id.year);
        this.mYearSpinner.setOnLongPressUpdateInterval(100L);
        this.mYearSpinner.setOnValueChangedListener((NumberPicker.OnValueChangeListener)var15_14);
        if (!bl2) {
            this.mYearSpinner.setVisibility(8);
        }
        this.updateFormatters();
        if (!bl) {
            this.setSpinnersShown(true);
        } else {
            this.setSpinnersShown(bl);
        }
        this.mTempDate.setTimeInMillis(0L);
        if (!TextUtils.isEmpty((CharSequence)string3)) {
            if (!this.parseDate(string3, this.mTempDate)) {
                Calendar calendar = this.mTempDate;
                string2 = string4;
                calendar.set(n2, 0, 1, 0, 0, 0, 0);
            } else {
                string2 = string4;
            }
        } else {
            string2 = string4;
            this.mTempDate.set(n2, 0, 1, 0, 0, 0, 0);
        }
        this.setMinDate(this.mTempDate.getTimeInMillis());
        this.mTempDate.setTimeInMillis(0L);
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            if (!this.parseDate(string2, this.mTempDate)) {
                this.mTempDate.set(n3, 11, 31, 0, 0, 0, 0);
            }
        } else {
            this.mTempDate.set(n3, 11, 31, 0, 0, 0, 0);
        }
        this.setMaxDate(this.mTempDate.getTimeInMillis());
        this.mCurrentDate.setTimeInMillis(System.currentTimeMillis());
        this.init(this.mCurrentDate.get(1), this.mCurrentDate.get(5), this.mCurrentDate.get(9), null);
        this.reorderSpinners();
        if (this.getImportantForAccessibility() == 0) {
            this.setImportantForAccessibility(1);
        }
    }

    static /* synthetic */ Calendar access$000(DatePicker datePicker) {
        return datePicker.mCurrentDate;
    }

    static /* synthetic */ Calendar access$100(DatePicker datePicker) {
        return datePicker.mTempDate;
    }

    static /* synthetic */ NumberPicker access$200(DatePicker datePicker) {
        return datePicker.mDaySpinner;
    }

    static /* synthetic */ boolean access$300(DatePicker datePicker) {
        return datePicker.mIsLunarMode;
    }

    static /* synthetic */ NumberPicker access$400(DatePicker datePicker) {
        return datePicker.mMonthSpinner;
    }

    static /* synthetic */ NumberPicker access$500(DatePicker datePicker) {
        return datePicker.mYearSpinner;
    }

    static /* synthetic */ void access$600(DatePicker datePicker, int n, int n2, int n3) {
        datePicker.setDate(n, n2, n3);
    }

    static /* synthetic */ void access$700(DatePicker datePicker) {
        datePicker.resetMonthsDisplayedValues();
    }

    static /* synthetic */ void access$800(DatePicker datePicker) {
        datePicker.updateSpinners();
    }

    static /* synthetic */ void access$900(DatePicker datePicker) {
        datePicker.notifyDateChanged();
    }

    private void initChineseDaysIfNeeded() {
        if (sChineseDays == null) {
            sChineseDays = CalendarFormatSymbols.getOrCreate(this.getContext()).getChineseDays();
        }
        if (sChineseMonths == null) {
            String[] arrstring;
            sChineseMonths = CalendarFormatSymbols.getOrCreate(this.getContext()).getChineseMonths();
            Resources resources = this.getContext().getResources();
            for (int i = 0; i < (arrstring = sChineseMonths).length; ++i) {
                StringBuilder stringBuilder = new StringBuilder();
                String[] arrstring2 = sChineseMonths;
                stringBuilder.append(arrstring2[i]);
                stringBuilder.append(resources.getString(R.string.chinese_month));
                arrstring2[i] = stringBuilder.toString();
            }
            sChineseLeapYearMonths = new String[1 + arrstring.length];
        }
        if (sChineseLeapMonthMark == null) {
            sChineseLeapMonthMark = CalendarFormatSymbols.getOrCreate(this.getContext()).getChineseLeapMonths()[1];
        }
    }

    private boolean isNewDate(int n, int n2, int n3) {
        Calendar calendar = this.mCurrentDate;
        boolean bl = true;
        if (calendar.get((int)bl) == n && this.mCurrentDate.get(5) == n3) {
            if (this.mCurrentDate.get(9) != n2) {
                return bl;
            }
            bl = false;
        }
        return bl;
    }

    private void notifyDateChanged() {
        this.sendAccessibilityEvent(4);
        OnDateChangedListener onDateChangedListener = this.mOnDateChangedListener;
        if (onDateChangedListener != null) {
            onDateChangedListener.onDateChanged(this, this.getYear(), this.getMonth(), this.getDayOfMonth(), this.mIsLunarMode);
        }
    }

    private boolean parseDate(String string2, Calendar calendar) {
        try {
            calendar.setTimeInMillis(this.mDateFormat.parse(string2).getTime());
            return true;
        }
        catch (ParseException parseException) {
            String string3 = LOG_TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Date: ");
            stringBuilder.append(string2);
            stringBuilder.append(" not in format: ");
            stringBuilder.append(DATE_FORMAT);
            Log.w((String)string3, (String)stringBuilder.toString());
            return false;
        }
    }

    private void reorderSpinners() {
        this.mSpinners.removeAllViews();
        char[] arrc = this.mDateFormatOrder;
        if (arrc == null) {
            arrc = DateFormat.getDateFormatOrder((Context)this.getContext());
        }
        int n = arrc.length;
        for (int i = 0; i < n; ++i) {
            char c2 = arrc[i];
            if (c2 != 'M') {
                if (c2 != 'd') {
                    if (c2 == 'y') {
                        this.mSpinners.addView((View)this.mYearSpinner);
                        this.setImeOptions(this.mYearSpinner, n, i);
                        continue;
                    }
                    throw new IllegalArgumentException();
                }
                this.mSpinners.addView((View)this.mDaySpinner);
                this.setImeOptions(this.mDaySpinner, n, i);
                continue;
            }
            this.mSpinners.addView((View)this.mMonthSpinner);
            this.setImeOptions(this.mMonthSpinner, n, i);
        }
    }

    private void resetMonthsDisplayedValues() {
        String[] arrstring;
        boolean bl = this.mIsLunarMode;
        int n = 0;
        if (bl) {
            int n2 = this.mCurrentDate.getChineseLeapMonth();
            if (n2 < 0) {
                this.mShortMonths = sChineseMonths;
                return;
            }
            this.mShortMonths = sChineseLeapYearMonths;
            String[] arrstring2 = sChineseMonths;
            String[] arrstring3 = this.mShortMonths;
            int n3 = n2 + 1;
            System.arraycopy((Object)arrstring2, (int)0, (Object)arrstring3, (int)0, (int)n3);
            String[] arrstring4 = sChineseMonths;
            System.arraycopy((Object)arrstring4, (int)n2, (Object)this.mShortMonths, (int)n3, (int)(arrstring4.length - n2));
            String[] arrstring5 = this.mShortMonths;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(sChineseLeapMonthMark);
            stringBuilder.append(this.mShortMonths[n3]);
            arrstring5[n3] = stringBuilder.toString();
            return;
        }
        if ("en".equals((Object)this.mCurrentLocale.getLanguage().toLowerCase())) {
            this.mShortMonths = CalendarFormatSymbols.getOrCreate(this.getContext()).getShortMonths();
            return;
        }
        this.mShortMonths = new String[12];
        while (n < (arrstring = this.mShortMonths).length) {
            NumberPicker.Formatter formatter = NumberPicker.TWO_DIGIT_FORMATTER;
            int n4 = n + 1;
            arrstring[n] = formatter.format(n4);
            n = n4;
        }
    }

    private void setCurrentLocale(Locale locale) {
        if (locale.equals((Object)this.mCurrentLocale)) {
            return;
        }
        this.mCurrentLocale = locale;
        this.mNumberOfMonths = 1 + this.mTempDate.getActualMaximum(5);
        this.resetMonthsDisplayedValues();
        this.updateFormatters();
    }

    private void setDate(int n, int n2, int n3) {
        this.mCurrentDate.set(n, n2, n3, 0, 0, 0, 0);
        if (this.mCurrentDate.before(this.mMinDate)) {
            this.mCurrentDate.setTimeInMillis(this.mMinDate.getTimeInMillis());
            return;
        }
        if (this.mCurrentDate.after(this.mMaxDate)) {
            this.mCurrentDate.setTimeInMillis(this.mMaxDate.getTimeInMillis());
        }
    }

    private void setImeOptions(NumberPicker numberPicker, int n, int n2) {
        int n3 = n2 < n - 1 ? 5 : 6;
        ((TextView)numberPicker.findViewById(R.id.number_picker_input)).setImeOptions(n3);
    }

    private void updateFormatters() {
        NumberPicker numberPicker = this.mDaySpinner;
        if (numberPicker != null) {
            if (this.mYearSpinner == null) {
                return;
            }
            numberPicker.setFormatter(NumberPicker.TWO_DIGIT_FORMATTER);
            this.mYearSpinner.setFormatter((NumberPicker.Formatter)new /* Unavailable Anonymous Inner Class!! */);
        }
    }

    private void updateSpinners() {
        boolean bl;
        block11 : {
            block12 : {
                if (this.mIsLunarMode) {
                    this.mDaySpinner.setLabel(null);
                    this.mMonthSpinner.setLabel(null);
                    this.mYearSpinner.setLabel(null);
                } else {
                    this.mDaySpinner.setLabel(this.getContext().getString(R.string.date_picker_label_day));
                    this.mMonthSpinner.setLabel(this.getContext().getString(R.string.date_picker_label_month));
                    this.mYearSpinner.setLabel(this.getContext().getString(R.string.date_picker_label_year));
                }
                this.mDaySpinner.setDisplayedValues(null);
                this.mDaySpinner.setMinValue(1);
                NumberPicker numberPicker = this.mDaySpinner;
                int n = this.mIsLunarMode ? this.mCurrentDate.getActualMaximum(10) : this.mCurrentDate.getActualMaximum(9);
                numberPicker.setMaxValue(n);
                this.mDaySpinner.setWrapSelectorWheel(true);
                this.mMonthSpinner.setDisplayedValues(null);
                this.mMonthSpinner.setMinValue(0);
                NumberPicker numberPicker2 = this.mMonthSpinner;
                boolean bl2 = this.mIsLunarMode;
                int n2 = 11;
                if (bl2 && this.mCurrentDate.getChineseLeapMonth() >= 0) {
                    n2 = 12;
                }
                numberPicker2.setMaxValue(n2);
                this.mMonthSpinner.setWrapSelectorWheel(true);
                int n3 = this.mIsLunarMode ? 2 : 1;
                if (this.mCurrentDate.get(n3) == this.mMinDate.get(n3)) {
                    NumberPicker numberPicker3 = this.mMonthSpinner;
                    int n4 = this.mIsLunarMode ? this.mMinDate.get(6) : this.mMinDate.get(5);
                    numberPicker3.setMinValue(n4);
                    this.mMonthSpinner.setWrapSelectorWheel(false);
                    int n5 = this.mIsLunarMode ? 6 : 5;
                    if (this.mCurrentDate.get(n5) == this.mMinDate.get(n5)) {
                        NumberPicker numberPicker4 = this.mDaySpinner;
                        int n6 = this.mIsLunarMode ? this.mMinDate.get(10) : this.mMinDate.get(9);
                        numberPicker4.setMinValue(n6);
                        this.mDaySpinner.setWrapSelectorWheel(false);
                    }
                }
                if (this.mCurrentDate.get(n3) == this.mMaxDate.get(n3)) {
                    NumberPicker numberPicker5 = this.mMonthSpinner;
                    int n7 = this.mIsLunarMode ? this.mMinDate.get(6) : this.mMaxDate.get(5);
                    numberPicker5.setMaxValue(n7);
                    this.mMonthSpinner.setWrapSelectorWheel(false);
                    this.mMonthSpinner.setDisplayedValues(null);
                    int n8 = this.mIsLunarMode ? 6 : 5;
                    if (this.mCurrentDate.get(n8) == this.mMaxDate.get(n8)) {
                        NumberPicker numberPicker6 = this.mDaySpinner;
                        int n9 = this.mIsLunarMode ? this.mMaxDate.get(10) : this.mMaxDate.get(9);
                        numberPicker6.setMaxValue(n9);
                        this.mDaySpinner.setWrapSelectorWheel(false);
                    }
                }
                String[] arrstring = (String[])Arrays.copyOfRange((Object[])this.mShortMonths, (int)this.mMonthSpinner.getMinValue(), (int)this.mShortMonths.length);
                this.mMonthSpinner.setDisplayedValues(arrstring);
                if (this.mIsLunarMode) {
                    String[] arrstring2 = (String[])Arrays.copyOfRange((Object[])sChineseDays, (int)(this.mDaySpinner.getMinValue() - 1), (int)sChineseDays.length);
                    this.mDaySpinner.setDisplayedValues(arrstring2);
                }
                int n10 = this.isLunarMode() ? 2 : 1;
                this.mYearSpinner.setMinValue(this.mMinDate.get(n10));
                this.mYearSpinner.setMaxValue(this.mMaxDate.get(n10));
                this.mYearSpinner.setWrapSelectorWheel(false);
                int n11 = this.mCurrentDate.getChineseLeapMonth();
                bl = false;
                if (n11 < 0) break block11;
                if (this.mCurrentDate.isChineseLeapMonth()) break block12;
                int n12 = this.mCurrentDate.get(6);
                bl = false;
                if (n12 <= n11) break block11;
            }
            bl = true;
        }
        NumberPicker numberPicker = this.mYearSpinner;
        int n = this.mIsLunarMode ? this.mCurrentDate.get(2) : this.mCurrentDate.get(1);
        numberPicker.setValue(n);
        NumberPicker numberPicker7 = this.mMonthSpinner;
        int n13 = this.mIsLunarMode ? (bl ? 1 + this.mCurrentDate.get(6) : this.mCurrentDate.get(6)) : this.mCurrentDate.get(5);
        numberPicker7.setValue(n13);
        NumberPicker numberPicker8 = this.mDaySpinner;
        int n14 = this.mIsLunarMode ? this.mCurrentDate.get(10) : this.mCurrentDate.get(9);
        numberPicker8.setValue(n14);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        this.onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.dispatchThawSelfOnly(sparseArray);
    }

    public int getDayOfMonth() {
        Calendar calendar = this.mCurrentDate;
        int n = this.mIsLunarMode ? 10 : 9;
        return calendar.get(n);
    }

    public long getMaxDate() {
        return this.mMaxDate.getTimeInMillis();
    }

    public long getMinDate() {
        return this.mMinDate.getTimeInMillis();
    }

    public int getMonth() {
        if (this.mIsLunarMode) {
            if (this.mCurrentDate.isChineseLeapMonth()) {
                return 12 + this.mCurrentDate.get(6);
            }
            return this.mCurrentDate.get(6);
        }
        return this.mCurrentDate.get(5);
    }

    public boolean getSpinnersShown() {
        return this.mSpinners.isShown();
    }

    public int getYear() {
        Calendar calendar = this.mCurrentDate;
        int n = this.mIsLunarMode ? 2 : 1;
        return calendar.get(n);
    }

    public void init(int n, int n2, int n3, OnDateChangedListener onDateChangedListener) {
        this.setDate(n, n2, n3);
        this.updateSpinners();
        this.mOnDateChangedListener = onDateChangedListener;
    }

    public boolean isEnabled() {
        return this.mIsEnabled;
    }

    public boolean isLunarMode() {
        return this.mIsLunarMode;
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.setCurrentLocale(configuration.locale);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName((CharSequence)DatePicker.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName((CharSequence)DatePicker.class.getName());
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        String string2 = DateUtils.formatDateTime(this.getContext(), this.mCurrentDate.getTimeInMillis(), 896);
        accessibilityEvent.getText().add((Object)string2);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState)parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.setDate(savedState.mYear, savedState.mMonth, savedState.mDay);
        this.mIsLunarMode = savedState.mIsLunar;
        this.updateSpinners();
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable parcelable = super.onSaveInstanceState();
        int n = this.mCurrentDate.get(1);
        int n2 = this.mCurrentDate.get(5);
        int n3 = this.mCurrentDate.get(9);
        SavedState savedState = new SavedState(parcelable, n, n2, n3, this.mIsLunarMode);
        return savedState;
    }

    public void setDateFormatOrder(char[] arrc) {
        this.mDateFormatOrder = arrc;
        this.reorderSpinners();
    }

    public void setEnabled(boolean bl) {
        if (this.mIsEnabled == bl) {
            return;
        }
        super.setEnabled(bl);
        this.mDaySpinner.setEnabled(bl);
        this.mMonthSpinner.setEnabled(bl);
        this.mYearSpinner.setEnabled(bl);
        this.mIsEnabled = bl;
    }

    public void setLunarMode(boolean bl) {
        if (bl != this.mIsLunarMode) {
            this.mIsLunarMode = bl;
            this.resetMonthsDisplayedValues();
            this.updateSpinners();
        }
    }

    public void setMaxDate(long l) {
        this.mTempDate.setTimeInMillis(l);
        if (this.mTempDate.get(1) == this.mMaxDate.get(1) && this.mTempDate.get(12) != this.mMaxDate.get(12)) {
            return;
        }
        this.mMaxDate.setTimeInMillis(l);
        if (this.mCurrentDate.after(this.mMaxDate)) {
            this.mCurrentDate.setTimeInMillis(this.mMaxDate.getTimeInMillis());
        }
        this.updateSpinners();
    }

    public void setMinDate(long l) {
        this.mTempDate.setTimeInMillis(l);
        if (this.mTempDate.get(1) == this.mMinDate.get(1) && this.mTempDate.get(12) != this.mMinDate.get(12)) {
            return;
        }
        this.mMinDate.setTimeInMillis(l);
        if (this.mCurrentDate.before(this.mMinDate)) {
            this.mCurrentDate.setTimeInMillis(this.mMinDate.getTimeInMillis());
        }
        this.updateSpinners();
    }

    public void setSpinnersShown(boolean bl) {
        LinearLayout linearLayout = this.mSpinners;
        int n = bl ? 0 : 8;
        linearLayout.setVisibility(n);
    }

    public void showDayPicker(boolean bl) {
        NumberPicker numberPicker = this.mDaySpinner;
        int n = bl ? 0 : 8;
        numberPicker.setVisibility(n);
    }

    public void showMonthPicker(boolean bl) {
        NumberPicker numberPicker = this.mMonthSpinner;
        int n = bl ? 0 : 8;
        numberPicker.setVisibility(n);
    }

    public void showYearPicker(boolean bl) {
        NumberPicker numberPicker = this.mYearSpinner;
        int n = bl ? 0 : 8;
        numberPicker.setVisibility(n);
    }

    public void updateDate(int n, int n2, int n3) {
        if (!this.isNewDate(n, n2, n3)) {
            return;
        }
        this.setDate(n, n2, n3);
        this.updateSpinners();
        this.notifyDateChanged();
    }

    public static interface OnDateChangedListener {
        public void onDateChanged(DatePicker var1, int var2, int var3, int var4, boolean var5);
    }

    private static class SavedState
    extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>(){

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int n) {
                return new SavedState[n];
            }
        };
        private final int mDay;
        private final boolean mIsLunar;
        private final int mMonth;
        private final int mYear;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.mYear = parcel.readInt();
            this.mMonth = parcel.readInt();
            this.mDay = parcel.readInt();
            int n = parcel.readInt();
            int n2 = 1;
            if (n != n2) {
                n2 = 0;
            }
            this.mIsLunar = n2;
        }

        private SavedState(Parcelable parcelable, int n, int n2, int n3, boolean bl) {
            super(parcelable);
            this.mYear = n;
            this.mMonth = n2;
            this.mDay = n3;
            this.mIsLunar = bl;
        }

        public void writeToParcel(Parcel parcel, int n) {
            super.writeToParcel(parcel, n);
            parcel.writeInt(this.mYear);
            parcel.writeInt(this.mMonth);
            parcel.writeInt(this.mDay);
            parcel.writeInt((int)this.mIsLunar);
        }

    }

}

