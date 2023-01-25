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
 *  android.util.AttributeSet
 *  android.util.SparseArray
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$BaseSavedState
 *  android.view.ViewGroup
 *  android.view.ViewParent
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.accessibility.AccessibilityNodeInfo
 *  android.widget.LinearLayout
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ThreadLocal
 *  java.util.List
 *  java.util.Locale
 *  miuix.pickerwidget.widget.DateTimePicker$LunarFormatter
 *  miuix.pickerwidget.widget.DateTimePicker$PickerValueChangeListener
 */
package miuix.pickerwidget.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import java.util.List;
import java.util.Locale;
import miuix.pickerwidget.R;
import miuix.pickerwidget.date.Calendar;
import miuix.pickerwidget.date.DateUtils;
import miuix.pickerwidget.widget.DateTimePicker;
import miuix.pickerwidget.widget.NumberPicker;

/*
 * Exception performing whole class analysis.
 */
public class DateTimePicker
extends LinearLayout {
    private static final int DAYPICKER_ALL_ITEM_MAX_VALUE = 4;
    private static final int DAYPICKER_WHEEL_ITEM_COUNT = 5;
    private static DayFormatter DEFAULT_DAY_FORMATTER;
    private static final int DEFAULT_MINUTE_INTERVAL = 1;
    private static final int HALF_WHEEL_ITEM_COUNT = 1;
    private static final ThreadLocal<Calendar> sCalCache;
    private static ThreadLocal<Calendar> sCalendarCache;
    private Calendar mCalendar;
    String[] mDayDisplayValues;
    private DayFormatter mDayFormatter;
    private int mDayLastValue;
    private NumberPicker mDayPicker;
    private NumberPicker mHourPicker;
    private boolean mIsLunarMode;
    private OnDateTimeChangedListener mListener;
    private DayFormatter mLunarFormatter;
    private Calendar mMaxDate;
    private Calendar mMinDate;
    private String[] mMinuteDisplayValues;
    private int mMinuteInterval;
    private NumberPicker mMinutePicker;

    static {
        sCalCache = new ThreadLocal();
        sCalendarCache = new ThreadLocal();
    }

    public DateTimePicker(Context context) {
        this(context, null);
    }

    public DateTimePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.dateTimePickerStyle);
    }

    public DateTimePicker(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.mMinuteInterval = 1;
        this.mMinDate = null;
        this.mMaxDate = null;
        this.mDayDisplayValues = null;
        this.mIsLunarMode = false;
        DEFAULT_DAY_FORMATTER = new DayFormatter(this.getContext());
        ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(R.layout.miuix_appcompat_date_time_picker, (ViewGroup)this, true);
        PickerValueChangeListener pickerValueChangeListener = new /* Unavailable Anonymous Inner Class!! */;
        this.mCalendar = new Calendar();
        this.adjustCalendar(this.mCalendar, true);
        Calendar calendar = (Calendar)sCalCache.get();
        if (calendar == null) {
            calendar = new Calendar();
            sCalCache.set((Object)calendar);
        }
        calendar.setTimeInMillis(0L);
        this.mDayPicker = (NumberPicker)this.findViewById(R.id.day);
        this.mHourPicker = (NumberPicker)this.findViewById(R.id.hour);
        this.mMinutePicker = (NumberPicker)this.findViewById(R.id.minute);
        this.mDayPicker.setOnValueChangedListener((NumberPicker.OnValueChangeListener)pickerValueChangeListener);
        this.mDayPicker.setMaxFlingSpeedFactor(3.0f);
        this.mHourPicker.setOnValueChangedListener((NumberPicker.OnValueChangeListener)pickerValueChangeListener);
        this.mMinutePicker.setOnValueChangedListener((NumberPicker.OnValueChangeListener)pickerValueChangeListener);
        this.mMinutePicker.setMinValue(0);
        this.mMinutePicker.setMaxValue(59);
        this.mHourPicker.setFormatter(NumberPicker.TWO_DIGIT_FORMATTER);
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.DateTimePicker, n, 0);
        this.mIsLunarMode = typedArray.getBoolean(R.styleable.DateTimePicker_lunarCalendar, false);
        typedArray.recycle();
        this.reorderLayout();
        this.checkCurrentTime();
        this.updateDayPicker(true);
        this.updateHourPicker();
        this.updateMinutePicker();
        if (this.getImportantForAccessibility() == 0) {
            this.setImportantForAccessibility(1);
        }
    }

    static /* synthetic */ void access$1000(DateTimePicker dateTimePicker) {
        dateTimePicker.updateHourPicker();
    }

    static /* synthetic */ void access$1100(DateTimePicker dateTimePicker) {
        dateTimePicker.updateMinutePicker();
    }

    static /* synthetic */ OnDateTimeChangedListener access$1200(DateTimePicker dateTimePicker) {
        return dateTimePicker.mListener;
    }

    static /* synthetic */ NumberPicker access$200(DateTimePicker dateTimePicker) {
        return dateTimePicker.mDayPicker;
    }

    static /* synthetic */ int access$300(DateTimePicker dateTimePicker) {
        return dateTimePicker.mDayLastValue;
    }

    static /* synthetic */ int access$302(DateTimePicker dateTimePicker, int n) {
        dateTimePicker.mDayLastValue = n;
        return n;
    }

    static /* synthetic */ Calendar access$400(DateTimePicker dateTimePicker) {
        return dateTimePicker.mCalendar;
    }

    static /* synthetic */ NumberPicker access$500(DateTimePicker dateTimePicker) {
        return dateTimePicker.mHourPicker;
    }

    static /* synthetic */ NumberPicker access$600(DateTimePicker dateTimePicker) {
        return dateTimePicker.mMinutePicker;
    }

    static /* synthetic */ int access$700(DateTimePicker dateTimePicker) {
        return dateTimePicker.mMinuteInterval;
    }

    static /* synthetic */ void access$800(DateTimePicker dateTimePicker) {
        dateTimePicker.checkCurrentTime();
    }

    static /* synthetic */ void access$900(DateTimePicker dateTimePicker, boolean bl) {
        dateTimePicker.updateDayPicker(bl);
    }

    private void adjustCalendar(Calendar calendar, boolean bl) {
        calendar.set(22, 0);
        calendar.set(21, 0);
        int n = calendar.get(20);
        int n2 = this.mMinuteInterval;
        int n3 = n % n2;
        if (n3 != 0) {
            if (bl) {
                calendar.add(20, n2 - n3);
                return;
            }
            calendar.add(20, -n3);
        }
    }

    private void checkCurrentTime() {
        Calendar calendar;
        Calendar calendar2 = this.mMinDate;
        if (calendar2 != null && calendar2.getTimeInMillis() > this.mCalendar.getTimeInMillis()) {
            this.mCalendar.setTimeInMillis(this.mMinDate.getTimeInMillis());
        }
        if ((calendar = this.mMaxDate) != null && calendar.getTimeInMillis() < this.mCalendar.getTimeInMillis()) {
            this.mCalendar.setTimeInMillis(this.mMaxDate.getTimeInMillis());
        }
    }

    private void checkDisplayeValid(NumberPicker numberPicker, int n, int n2) {
        String[] arrstring = numberPicker.getDisplayedValues();
        if (arrstring != null && arrstring.length < 1 + (n2 - n)) {
            numberPicker.setDisplayedValues(null);
        }
    }

    private int computeDayCount(Calendar calendar, Calendar calendar2) {
        Calendar calendar3 = (Calendar)calendar.clone();
        Calendar calendar4 = (Calendar)calendar2.clone();
        calendar3.set(18, 0);
        calendar3.set(20, 0);
        calendar3.set(21, 0);
        calendar3.set(22, 0);
        calendar4.set(18, 0);
        calendar4.set(20, 0);
        calendar4.set(21, 0);
        calendar4.set(22, 0);
        return (int)(calendar3.getTimeInMillis() / 1000L / 60L / 60L / 24L - calendar4.getTimeInMillis() / 1000L / 60L / 60L / 24L);
    }

    private String formatDay(int n, int n2, int n3) {
        DayFormatter dayFormatter;
        DayFormatter dayFormatter2 = DEFAULT_DAY_FORMATTER;
        if (this.mIsLunarMode) {
            if (this.mLunarFormatter == null) {
                this.mLunarFormatter = new /* Unavailable Anonymous Inner Class!! */;
            }
            dayFormatter2 = this.mLunarFormatter;
        }
        if ((dayFormatter = this.mDayFormatter) != null) {
            dayFormatter2 = dayFormatter;
        }
        return dayFormatter2.formatDay(n, n2, n3);
    }

    private void reorderLayout() {
        boolean bl;
        block5 : {
            block4 : {
                Resources resources = this.getResources();
                boolean bl2 = resources.getConfiguration().getLayoutDirection() == 1;
                boolean bl3 = resources.getString(R.string.fmt_time_12hour_minute).startsWith("h");
                if (bl3 && bl2) break block4;
                bl = false;
                if (bl3) break block5;
                bl = false;
                if (bl2) break block5;
            }
            bl = true;
        }
        if (bl) {
            ViewGroup viewGroup = (ViewGroup)this.mHourPicker.getParent();
            viewGroup.removeView((View)this.mHourPicker);
            viewGroup.addView((View)this.mHourPicker, viewGroup.getChildCount());
        }
    }

    private void updateDayPicker(boolean bl) {
        String[] arrstring;
        Calendar calendar = this.mMinDate;
        int n = Integer.MAX_VALUE;
        int n2 = calendar == null ? Integer.MAX_VALUE : this.computeDayCount(this.mCalendar, calendar);
        Calendar calendar2 = this.mMaxDate;
        if (calendar2 != null) {
            n = this.computeDayCount(calendar2, this.mCalendar);
        }
        if (n2 <= 1 && n <= 1) {
            int n3 = this.computeDayCount(this.mMaxDate, this.mMinDate);
            this.checkDisplayeValid(this.mDayPicker, 0, n3);
            this.mDayPicker.setMinValue(0);
            this.mDayPicker.setMaxValue(n3);
            this.mDayPicker.setValue(n2);
            this.mDayLastValue = n2;
            this.mDayPicker.setWrapSelectorWheel(false);
        } else {
            this.checkDisplayeValid(this.mDayPicker, 0, 4);
            this.mDayPicker.setMinValue(0);
            this.mDayPicker.setMaxValue(4);
            if (n2 <= 1) {
                this.mDayPicker.setValue(n2);
                this.mDayLastValue = n2;
                this.mDayPicker.setWrapSelectorWheel(false);
            }
            if (n <= 1) {
                this.mDayLastValue = 4 - n;
                this.mDayPicker.setValue(this.mDayLastValue);
                this.mDayPicker.setWrapSelectorWheel(false);
            }
            if (n2 > 1 && n > 1) {
                this.mDayPicker.setWrapSelectorWheel(true);
            }
        }
        int n4 = 1 + (this.mDayPicker.getMaxValue() - this.mDayPicker.getMinValue());
        if (bl || (arrstring = this.mDayDisplayValues) == null || arrstring.length != n4) {
            this.mDayDisplayValues = new String[n4];
        }
        int n5 = this.mDayPicker.getValue();
        Calendar calendar3 = (Calendar)sCalCache.get();
        if (calendar3 == null) {
            calendar3 = new Calendar();
            sCalCache.set((Object)calendar3);
        }
        calendar3.setTimeInMillis(this.mCalendar.getTimeInMillis());
        this.mDayDisplayValues[n5] = this.formatDay(calendar3.get(1), calendar3.get(5), calendar3.get(9));
        for (int i = 1; i <= 2; ++i) {
            calendar3.add(12, 1);
            int n6 = (n5 + i) % 5;
            String[] arrstring2 = this.mDayDisplayValues;
            if (n6 >= arrstring2.length) break;
            arrstring2[n6] = this.formatDay(calendar3.get(1), calendar3.get(5), calendar3.get(9));
        }
        calendar3.setTimeInMillis(this.mCalendar.getTimeInMillis());
        for (int i = 1; i <= 2; ++i) {
            calendar3.add(12, -1);
            int n7 = (5 + (n5 - i)) % 5;
            String[] arrstring3 = this.mDayDisplayValues;
            if (n7 >= arrstring3.length) break;
            arrstring3[n7] = this.formatDay(calendar3.get(1), calendar3.get(5), calendar3.get(9));
        }
        this.mDayPicker.setDisplayedValues(this.mDayDisplayValues);
    }

    private void updateHourPicker() {
        boolean bl;
        Calendar calendar = this.mMaxDate;
        if (calendar != null && this.computeDayCount(this.mCalendar, calendar) == 0) {
            int n = this.mMaxDate.get(18);
            this.mHourPicker.setMaxValue(n);
            this.mHourPicker.setWrapSelectorWheel(false);
            bl = true;
        } else {
            bl = false;
        }
        Calendar calendar2 = this.mMinDate;
        if (calendar2 != null && this.computeDayCount(this.mCalendar, calendar2) == 0) {
            int n = this.mMinDate.get(18);
            this.mHourPicker.setMinValue(n);
            this.mHourPicker.setWrapSelectorWheel(false);
            bl = true;
        }
        if (!bl) {
            this.mHourPicker.setMinValue(0);
            this.mHourPicker.setMaxValue(23);
            this.mHourPicker.setWrapSelectorWheel(true);
        }
        int n = this.mCalendar.get(18);
        this.mHourPicker.setValue(n);
    }

    private void updateMinutePicker() {
        boolean bl;
        Calendar calendar = this.mMaxDate;
        int n = 0;
        if (calendar != null && this.computeDayCount(this.mCalendar, calendar) == 0 && this.mCalendar.get(18) == this.mMaxDate.get(18)) {
            int n2 = this.mMaxDate.get(20);
            this.mMinutePicker.setMinValue(0);
            this.mMinutePicker.setMaxValue(n2 / this.mMinuteInterval);
            this.mMinutePicker.setWrapSelectorWheel(false);
            bl = true;
        } else {
            bl = false;
        }
        Calendar calendar2 = this.mMinDate;
        if (calendar2 != null && this.computeDayCount(this.mCalendar, calendar2) == 0 && this.mCalendar.get(18) == this.mMinDate.get(18)) {
            int n3 = this.mMinDate.get(20);
            this.mMinutePicker.setMinValue(n3 / this.mMinuteInterval);
            this.mMinutePicker.setWrapSelectorWheel(false);
            bl = true;
        }
        if (!bl) {
            this.checkDisplayeValid(this.mMinutePicker, 0, 60 / this.mMinuteInterval - 1);
            this.mMinutePicker.setMinValue(0);
            this.mMinutePicker.setMaxValue(60 / this.mMinuteInterval - 1);
            this.mMinutePicker.setWrapSelectorWheel(true);
        }
        int n4 = 1 + (this.mMinutePicker.getMaxValue() - this.mMinutePicker.getMinValue());
        String[] arrstring = this.mMinuteDisplayValues;
        if (arrstring == null || arrstring.length != n4) {
            this.mMinuteDisplayValues = new String[n4];
            while (n < n4) {
                this.mMinuteDisplayValues[n] = NumberPicker.TWO_DIGIT_FORMATTER.format((n + this.mMinutePicker.getMinValue()) * this.mMinuteInterval);
                ++n;
            }
            this.mMinutePicker.setDisplayedValues(this.mMinuteDisplayValues);
        }
        int n5 = this.mCalendar.get(20) / this.mMinuteInterval;
        this.mMinutePicker.setValue(n5);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        this.onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.dispatchThawSelfOnly(sparseArray);
    }

    public long getTimeInMillis() {
        return this.mCalendar.getTimeInMillis();
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName((CharSequence)DateTimePicker.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName((CharSequence)DateTimePicker.class.getName());
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        String string2 = DateUtils.formatDateTime(this.getContext(), this.mCalendar.getTimeInMillis(), 1420);
        accessibilityEvent.getText().add((Object)string2);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState)parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.update(savedState.getTimeInMillis());
    }

    protected Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.getTimeInMillis());
    }

    public void setDayFormatter(DayFormatter dayFormatter) {
        this.mDayFormatter = dayFormatter;
        this.updateDayPicker(true);
    }

    public void setLunarMode(boolean bl) {
        this.mIsLunarMode = bl;
        this.updateDayPicker(true);
    }

    public void setMaxDateTime(long l) {
        if (l <= 0L) {
            this.mMaxDate = null;
        } else {
            this.mMaxDate = new Calendar();
            this.mMaxDate.setTimeInMillis(l);
            this.adjustCalendar(this.mMaxDate, false);
            Calendar calendar = this.mMinDate;
            if (calendar != null && calendar.getTimeInMillis() > this.mMaxDate.getTimeInMillis()) {
                this.mMaxDate.setTimeInMillis(this.mMinDate.getTimeInMillis());
            }
        }
        this.checkCurrentTime();
        this.updateDayPicker(true);
        this.updateHourPicker();
        this.updateMinutePicker();
    }

    public void setMinDateTime(long l) {
        if (l <= 0L) {
            this.mMinDate = null;
        } else {
            this.mMinDate = new Calendar();
            this.mMinDate.setTimeInMillis(l);
            if (this.mMinDate.get(21) != 0 || this.mMinDate.get(22) != 0) {
                this.mMinDate.add(20, 1);
            }
            this.adjustCalendar(this.mMinDate, true);
            Calendar calendar = this.mMaxDate;
            if (calendar != null && calendar.getTimeInMillis() < this.mMinDate.getTimeInMillis()) {
                this.mMinDate.setTimeInMillis(this.mMaxDate.getTimeInMillis());
            }
        }
        this.checkCurrentTime();
        this.updateDayPicker(true);
        this.updateHourPicker();
        this.updateMinutePicker();
    }

    public void setMinuteInterval(int n) {
        if (this.mMinuteInterval == n) {
            return;
        }
        this.mMinuteInterval = n;
        this.adjustCalendar(this.mCalendar, true);
        this.checkCurrentTime();
        this.updateMinutePicker();
    }

    public void setOnTimeChangedListener(OnDateTimeChangedListener onDateTimeChangedListener) {
        this.mListener = onDateTimeChangedListener;
    }

    public void update(long l) {
        this.mCalendar.setTimeInMillis(l);
        this.adjustCalendar(this.mCalendar, true);
        this.checkCurrentTime();
        this.updateDayPicker(true);
        this.updateHourPicker();
        this.updateMinutePicker();
    }

    public static class DayFormatter {
        protected Context mContext;

        public DayFormatter(Context context) {
            this.mContext = context.getApplicationContext();
        }

        public String formatDay(int n, int n2, int n3) {
            Calendar calendar = (Calendar)sCalendarCache.get();
            if (calendar == null) {
                calendar = new Calendar();
                sCalendarCache.set((Object)calendar);
            }
            calendar.set(1, n);
            calendar.set(5, n2);
            calendar.set(9, n3);
            if (Locale.getDefault().getLanguage().equals((Object)Locale.CHINESE.getLanguage())) {
                String string2 = DateUtils.formatDateTime(this.mContext, calendar.getTimeInMillis(), 4480);
                String string3 = DateUtils.formatDateTime(this.mContext, calendar.getTimeInMillis(), 9216);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string2.replace((CharSequence)" ", (CharSequence)""));
                stringBuilder.append(" ");
                stringBuilder.append(string3);
                return stringBuilder.toString();
            }
            return DateUtils.formatDateTime(this.mContext, calendar.getTimeInMillis(), 13696);
        }
    }

    public static interface OnDateTimeChangedListener {
        public void onDateTimeChanged(DateTimePicker var1, long var2);
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
        private long nTimeInMillis;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.nTimeInMillis = parcel.readLong();
        }

        public SavedState(Parcelable parcelable, long l) {
            super(parcelable);
            this.nTimeInMillis = l;
        }

        public long getTimeInMillis() {
            return this.nTimeInMillis;
        }

        public void writeToParcel(Parcel parcel, int n) {
            super.writeToParcel(parcel, n);
            parcel.writeLong(this.nTimeInMillis);
        }

    }

}

