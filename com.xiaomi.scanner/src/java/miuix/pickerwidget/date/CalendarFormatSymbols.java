/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  androidx.annotation.NonNull
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Locale
 *  miuix.core.util.SoftReferenceSingleton
 *  miuix.pickerwidget.date.CalendarFormatSymbols$1
 */
package miuix.pickerwidget.date;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import java.util.Locale;
import miuix.core.util.SoftReferenceSingleton;
import miuix.pickerwidget.R;
import miuix.pickerwidget.date.CalendarFormatSymbols;

public class CalendarFormatSymbols {
    private static SoftReferenceSingleton<CalendarFormatSymbols> INSTANCE;
    private Resources mResources;

    private CalendarFormatSymbols(@NonNull Context context) {
        this.mResources = context.getResources();
    }

    public static CalendarFormatSymbols getOrCreate(@NonNull Context context) {
        if (INSTANCE == null) {
            INSTANCE = new 1();
        }
        return (CalendarFormatSymbols)INSTANCE.get((Object)context);
    }

    public String[] getAmPms() {
        return this.mResources.getStringArray(R.array.am_pms);
    }

    public String[] getChineseDays() {
        return this.mResources.getStringArray(R.array.chinese_days);
    }

    public String[] getChineseDigits() {
        return this.mResources.getStringArray(R.array.chinese_digits);
    }

    public String[] getChineseLeapMonths() {
        return this.mResources.getStringArray(R.array.chinese_leap_months);
    }

    public String[] getChineseMonths() {
        return this.mResources.getStringArray(R.array.chinese_months);
    }

    public String[] getChineseSymbolAnimals() {
        return this.mResources.getStringArray(R.array.chinese_symbol_animals);
    }

    public String[] getDetailedAmPms() {
        return this.mResources.getStringArray(R.array.detailed_am_pms);
    }

    public String[] getEarthlyBranches() {
        return this.mResources.getStringArray(R.array.earthly_branches);
    }

    public String[] getEras() {
        return this.mResources.getStringArray(R.array.eras);
    }

    public String[] getHeavenlyStems() {
        return this.mResources.getStringArray(R.array.heavenly_stems);
    }

    public Locale getLocale() {
        return Locale.getDefault();
    }

    public String[] getMonths() {
        return this.mResources.getStringArray(R.array.months);
    }

    public String[] getShortMonths() {
        return this.mResources.getStringArray(R.array.months_short);
    }

    public String[] getShortWeekDays() {
        return this.mResources.getStringArray(R.array.week_days_short);
    }

    public String[] getShortestMonths() {
        return this.mResources.getStringArray(R.array.months_shortest);
    }

    public String[] getShortestWeekDays() {
        return this.mResources.getStringArray(R.array.week_days_shortest);
    }

    public String[] getSolarTerms() {
        return this.mResources.getStringArray(R.array.solar_terms);
    }

    public String[] getWeekDays() {
        return this.mResources.getStringArray(R.array.week_days);
    }
}

