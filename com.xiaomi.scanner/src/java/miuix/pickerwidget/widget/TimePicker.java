/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$BaseSavedState
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.accessibility.AccessibilityNodeInfo
 *  android.widget.Button
 *  android.widget.EditText
 *  android.widget.FrameLayout
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 *  java.util.Locale
 *  miuix.pickerwidget.widget.TimePicker$1
 *  miuix.pickerwidget.widget.TimePicker$2
 *  miuix.pickerwidget.widget.TimePicker$3
 *  miuix.pickerwidget.widget.TimePicker$5
 */
package miuix.pickerwidget.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import java.util.List;
import java.util.Locale;
import miuix.pickerwidget.R;
import miuix.pickerwidget.date.Calendar;
import miuix.pickerwidget.date.CalendarFormatSymbols;
import miuix.pickerwidget.date.DateUtils;
import miuix.pickerwidget.widget.NumberPicker;
import miuix.pickerwidget.widget.TimePicker;

public class TimePicker
extends FrameLayout {
    private static final boolean DEFAULT_ENABLED_STATE = true;
    private static final int HOURS_IN_HALF_DAY = 12;
    private static final OnTimeChangedListener NO_OP_CHANGE_LISTENER = new 1();
    private final Button mAmPmButton;
    private final NumberPicker mAmPmSpinner;
    private Locale mCurrentLocale;
    private final NumberPicker mHourSpinner;
    private boolean mIs24HourView;
    private boolean mIsAm;
    private boolean mIsEnabled = true;
    private final NumberPicker mMinuteSpinner;
    private OnTimeChangedListener mOnTimeChangedListener;
    private Calendar mTempCalendar;

    public TimePicker(Context context) {
        this(context, null);
    }

    public TimePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TimePicker(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.setCurrentLocale(Locale.getDefault());
        int n2 = R.layout.miuix_appcompat_time_picker;
        ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(n2, (ViewGroup)this, true);
        this.mHourSpinner = (NumberPicker)this.findViewById(R.id.hour);
        this.mHourSpinner.setOnValueChangedListener((NumberPicker.OnValueChangeListener)new 2(this));
        ((EditText)this.mHourSpinner.findViewById(R.id.number_picker_input)).setImeOptions(5);
        this.mMinuteSpinner = (NumberPicker)this.findViewById(R.id.minute);
        this.mMinuteSpinner.setMinValue(0);
        this.mMinuteSpinner.setMaxValue(59);
        this.mMinuteSpinner.setOnLongPressUpdateInterval(100L);
        this.mMinuteSpinner.setFormatter(NumberPicker.TWO_DIGIT_FORMATTER);
        this.mMinuteSpinner.setOnValueChangedListener((NumberPicker.OnValueChangeListener)new 3(this));
        ((EditText)this.mMinuteSpinner.findViewById(R.id.number_picker_input)).setImeOptions(5);
        View view = this.findViewById(R.id.amPm);
        if (view instanceof Button) {
            this.mAmPmSpinner = null;
            this.mAmPmButton = (Button)view;
            this.mAmPmButton.setOnClickListener(new View.OnClickListener(){

                public void onClick(View view) {
                    view.requestFocus();
                    TimePicker timePicker = TimePicker.this;
                    timePicker.mIsAm = true ^ timePicker.mIsAm;
                    TimePicker.this.updateAmPmControl();
                    TimePicker.this.onTimeChanged();
                }
            });
        } else {
            this.mAmPmButton = null;
            this.mAmPmSpinner = (NumberPicker)view;
            this.mAmPmSpinner.setMinValue(0);
            this.mAmPmSpinner.setMaxValue(1);
            this.mAmPmSpinner.setDisplayedValues(CalendarFormatSymbols.getOrCreate(this.getContext()).getAmPms());
            this.mAmPmSpinner.setOnValueChangedListener((NumberPicker.OnValueChangeListener)new 5(this));
            ((EditText)this.mAmPmSpinner.findViewById(R.id.number_picker_input)).setImeOptions(6);
        }
        if (this.isAmPmAtStart()) {
            ViewGroup viewGroup = (ViewGroup)this.findViewById(R.id.timePickerLayout);
            viewGroup.removeView(view);
            viewGroup.addView(view, 0);
        }
        this.updateHourControl();
        this.updateAmPmControl();
        this.setOnTimeChangedListener(NO_OP_CHANGE_LISTENER);
        this.setCurrentHour(this.mTempCalendar.get(18));
        this.setCurrentMinute(this.mTempCalendar.get(20));
        if (!this.isEnabled()) {
            this.setEnabled(false);
        }
        if (this.getImportantForAccessibility() == 0) {
            this.setImportantForAccessibility(1);
        }
    }

    private boolean isAmPmAtStart() {
        boolean bl = this.getContext().getString(R.string.fmt_time_12hour_pm).startsWith("a");
        if (this.getResources().getConfiguration().getLayoutDirection() == 1) {
            bl ^= true;
        }
        return bl;
    }

    private void onTimeChanged() {
        this.sendAccessibilityEvent(4);
        OnTimeChangedListener onTimeChangedListener = this.mOnTimeChangedListener;
        if (onTimeChangedListener != null) {
            onTimeChangedListener.onTimeChanged(this, this.getCurrentHour(), this.getCurrentMinute());
        }
    }

    private void setCurrentLocale(Locale locale) {
        if (locale.equals((Object)this.mCurrentLocale)) {
            return;
        }
        this.mCurrentLocale = locale;
        if (this.mTempCalendar == null) {
            this.mTempCalendar = new Calendar();
        }
    }

    private void trySetContentDescription(View view, int n, int n2) {
        View view2 = view.findViewById(n);
        if (view2 != null) {
            view2.setContentDescription((CharSequence)this.getContext().getString(n2));
        }
    }

    private void updateAmPmControl() {
        if (this.is24HourView()) {
            NumberPicker numberPicker = this.mAmPmSpinner;
            if (numberPicker != null) {
                numberPicker.setVisibility(8);
            } else {
                this.mAmPmButton.setVisibility(8);
            }
        } else {
            int n = true ^ this.mIsAm;
            NumberPicker numberPicker = this.mAmPmSpinner;
            if (numberPicker != null) {
                numberPicker.setValue(n);
                this.mAmPmSpinner.setVisibility(0);
            } else {
                this.mAmPmButton.setText((CharSequence)CalendarFormatSymbols.getOrCreate(this.getContext()).getAmPms()[n]);
                this.mAmPmButton.setVisibility(0);
            }
        }
        this.sendAccessibilityEvent(4);
    }

    private void updateHourControl() {
        if (this.is24HourView()) {
            this.mHourSpinner.setMinValue(0);
            this.mHourSpinner.setMaxValue(23);
            this.mHourSpinner.setFormatter(NumberPicker.TWO_DIGIT_FORMATTER);
            return;
        }
        this.mHourSpinner.setMinValue(1);
        this.mHourSpinner.setMaxValue(12);
        this.mHourSpinner.setFormatter(null);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        this.onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    public int getBaseline() {
        return this.mHourSpinner.getBaseline();
    }

    public Integer getCurrentHour() {
        int n = this.mHourSpinner.getValue();
        if (this.is24HourView()) {
            return n;
        }
        if (this.mIsAm) {
            return n % 12;
        }
        return 12 + n % 12;
    }

    public Integer getCurrentMinute() {
        return this.mMinuteSpinner.getValue();
    }

    public boolean is24HourView() {
        return this.mIs24HourView;
    }

    public boolean isEnabled() {
        return this.mIsEnabled;
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.setCurrentLocale(configuration.locale);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName((CharSequence)TimePicker.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName((CharSequence)TimePicker.class.getName());
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        int n = this.mIs24HourView ? 44 : 28;
        this.mTempCalendar.set(18, this.getCurrentHour());
        this.mTempCalendar.set(20, this.getCurrentMinute());
        String string2 = DateUtils.formatDateTime(this.getContext(), this.mTempCalendar.getTimeInMillis(), n);
        accessibilityEvent.getText().add((Object)string2);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState)parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.setCurrentHour(savedState.getHour());
        this.setCurrentMinute(savedState.getMinute());
    }

    protected Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.getCurrentHour(), this.getCurrentMinute());
    }

    public void set24HourView(Boolean bl) {
        if (this.mIs24HourView == bl) {
            return;
        }
        this.mIs24HourView = bl;
        int n = this.getCurrentHour();
        this.updateHourControl();
        this.setCurrentHour(n);
        this.updateAmPmControl();
    }

    public void setCurrentHour(Integer n) {
        if (n != null) {
            if (n.equals((Object)this.getCurrentHour())) {
                return;
            }
            if (!this.is24HourView()) {
                if (n >= 12) {
                    this.mIsAm = false;
                    if (n > 12) {
                        n = n - 12;
                    }
                } else {
                    this.mIsAm = true;
                    if (n == 0) {
                        n = 12;
                    }
                }
                this.updateAmPmControl();
            }
            this.mHourSpinner.setValue(n);
            this.onTimeChanged();
        }
    }

    public void setCurrentMinute(Integer n) {
        if (n.equals((Object)this.getCurrentMinute())) {
            return;
        }
        this.mMinuteSpinner.setValue(n);
        this.onTimeChanged();
    }

    public void setEnabled(boolean bl) {
        if (this.mIsEnabled == bl) {
            return;
        }
        super.setEnabled(bl);
        this.mMinuteSpinner.setEnabled(bl);
        this.mHourSpinner.setEnabled(bl);
        NumberPicker numberPicker = this.mAmPmSpinner;
        if (numberPicker != null) {
            numberPicker.setEnabled(bl);
        } else {
            this.mAmPmButton.setEnabled(bl);
        }
        this.mIsEnabled = bl;
    }

    public void setOnTimeChangedListener(OnTimeChangedListener onTimeChangedListener) {
        this.mOnTimeChangedListener = onTimeChangedListener;
    }

    public static interface OnTimeChangedListener {
        public void onTimeChanged(TimePicker var1, int var2, int var3);
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
        private final int mHour;
        private final int mMinute;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.mHour = parcel.readInt();
            this.mMinute = parcel.readInt();
        }

        private SavedState(Parcelable parcelable, int n, int n2) {
            super(parcelable);
            this.mHour = n;
            this.mMinute = n2;
        }

        public int getHour() {
            return this.mHour;
        }

        public int getMinute() {
            return this.mMinute;
        }

        public void writeToParcel(Parcel parcel, int n) {
            super.writeToParcel(parcel, n);
            parcel.writeInt(this.mHour);
            parcel.writeInt(this.mMinute);
        }

    }

}

