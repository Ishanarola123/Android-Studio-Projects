/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.text.format.DateFormat
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.InstantiationException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.TimeZone
 *  miuix.core.util.Pools
 *  miuix.core.util.Pools$Manager
 *  miuix.core.util.Pools$Pool
 *  miuix.pickerwidget.date.DateUtils$1
 */
package miuix.pickerwidget.date;

import android.content.Context;
import android.content.res.Resources;
import android.text.format.DateFormat;
import java.util.TimeZone;
import miuix.core.util.Pools;
import miuix.pickerwidget.R;
import miuix.pickerwidget.date.Calendar;
import miuix.pickerwidget.date.DateUtils;

public class DateUtils {
    private static final Pools.Pool<Calendar> CALENDAR_POOL = Pools.createSoftReferencePool((Pools.Manager)new 1(), (int)1);
    public static final int FORMAT_12HOUR = 16;
    public static final int FORMAT_24HOUR = 32;
    public static final int FORMAT_ABBREV_ALL = 28672;
    public static final int FORMAT_ABBREV_MONTH = 4096;
    public static final int FORMAT_ABBREV_TIME = 16384;
    public static final int FORMAT_ABBREV_WEEKDAY = 8192;
    public static final int FORMAT_NO_AM_PM = 64;
    public static final int FORMAT_NUMERIC_DATE = 32768;
    public static final int FORMAT_SHOW_BRIEF_TIME = 12;
    public static final int FORMAT_SHOW_DATE = 896;
    public static final int FORMAT_SHOW_HOUR = 8;
    public static final int FORMAT_SHOW_MILLISECOND = 1;
    public static final int FORMAT_SHOW_MINUTE = 4;
    public static final int FORMAT_SHOW_MONTH = 256;
    public static final int FORMAT_SHOW_MONTH_DAY = 128;
    public static final int FORMAT_SHOW_SECOND = 2;
    public static final int FORMAT_SHOW_TIME = 15;
    public static final int FORMAT_SHOW_TIME_ZONE = 2048;
    public static final int FORMAT_SHOW_WEEKDAY = 1024;
    public static final int FORMAT_SHOW_YEAR = 512;

    protected DateUtils() throws InstantiationException {
        throw new InstantiationException("Cannot instantiate utility class");
    }

    public static String formatDateTime(Context context, long l, int n) {
        StringBuilder stringBuilder = (StringBuilder)Pools.getStringBuilderPool().acquire();
        String string2 = DateUtils.formatDateTime(context, stringBuilder, l, n, null).toString();
        Pools.getStringBuilderPool().release((Object)stringBuilder);
        return string2;
    }

    public static String formatDateTime(Context context, long l, int n, TimeZone timeZone) {
        StringBuilder stringBuilder = (StringBuilder)Pools.getStringBuilderPool().acquire();
        String string2 = DateUtils.formatDateTime(context, stringBuilder, l, n, timeZone).toString();
        Pools.getStringBuilderPool().release((Object)stringBuilder);
        return string2;
    }

    public static StringBuilder formatDateTime(Context context, StringBuilder stringBuilder, long l, int n) {
        return DateUtils.formatDateTime(context, stringBuilder, l, n, null);
    }

    public static StringBuilder formatDateTime(Context context, StringBuilder stringBuilder, long l, int n, TimeZone timeZone) {
        if ((n & 16) == 0 && (n & 32) == 0) {
            int n2 = DateFormat.is24HourFormat((Context)context) ? 32 : 16;
            n |= n2;
        }
        String string2 = context.getString(DateUtils.getFormatResId(n));
        StringBuilder stringBuilder2 = (StringBuilder)Pools.getStringBuilderPool().acquire();
        Calendar calendar = (Calendar)CALENDAR_POOL.acquire();
        calendar.setTimeZone(timeZone);
        calendar.setTimeInMillis(l);
        int n3 = string2.length();
        for (int i = 0; i < n3; ++i) {
            char c2 = string2.charAt(i);
            if (c2 != 'D') {
                if (c2 != 'T') {
                    if (c2 != 'W') {
                        stringBuilder2.append(c2);
                        continue;
                    }
                    stringBuilder2.append(context.getString(DateUtils.getWeekdayPatternResId(n)));
                    continue;
                }
                stringBuilder2.append(context.getString(DateUtils.getTimePatternResId(calendar, n)));
                continue;
            }
            stringBuilder2.append(context.getString(DateUtils.getDatePatternResId(n)));
        }
        calendar.format(context, stringBuilder, (CharSequence)stringBuilder2);
        Pools.getStringBuilderPool().release((Object)stringBuilder2);
        CALENDAR_POOL.release((Object)calendar);
        return stringBuilder;
    }

    public static String formatRelativeTime(Context context, long l, boolean bl) {
        StringBuilder stringBuilder = (StringBuilder)Pools.getStringBuilderPool().acquire();
        String string2 = DateUtils.formatRelativeTime(context, stringBuilder, l, bl, null).toString();
        Pools.getStringBuilderPool().release((Object)stringBuilder);
        return string2;
    }

    public static String formatRelativeTime(Context context, long l, boolean bl, TimeZone timeZone) {
        StringBuilder stringBuilder = (StringBuilder)Pools.getStringBuilderPool().acquire();
        String string2 = DateUtils.formatRelativeTime(context, stringBuilder, l, bl, timeZone).toString();
        Pools.getStringBuilderPool().release((Object)stringBuilder);
        return string2;
    }

    public static StringBuilder formatRelativeTime(Context context, StringBuilder stringBuilder, long l, boolean bl) {
        return DateUtils.formatRelativeTime(context, stringBuilder, l, bl, null);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static StringBuilder formatRelativeTime(Context var0, StringBuilder var1_1, long var2_2, boolean var4_3, TimeZone var5_4) {
        block7 : {
            block8 : {
                block6 : {
                    var6_5 = System.currentTimeMillis();
                    var8_6 = 1;
                    var9_7 = var6_5 >= var2_2 ? 1 : 0;
                    var10_8 = Math.abs((long)(var6_5 - var2_2)) / 60000L;
                    var12_9 = var0.getResources();
                    if (var10_8 <= 60L && !var4_3) {
                        var31_10 = var9_7 != 0 ? (var10_8 == 60L ? R.plurals.abbrev_a_hour_ago : (var10_8 == 30L ? R.plurals.abbrev_half_hour_ago : (var10_8 == 0L ? R.plurals.abbrev_less_than_one_minute_ago : R.plurals.abbrev_num_minutes_ago))) : (var10_8 == 60L ? R.plurals.abbrev_in_a_hour : (var10_8 == 30L ? R.plurals.abbrev_in_half_hour : (var10_8 == 0L ? R.plurals.abbrev_in_less_than_one_minute : R.plurals.abbrev_in_num_minutes)));
                        var32_11 = var12_9.getQuantityString(var31_10, (int)var10_8);
                        var33_12 = new Object[var8_6];
                        var33_12[0] = var10_8;
                        var1_1.append(String.format((String)var32_11, (Object[])var33_12));
                        return var1_1;
                    }
                    var13_13 = (Calendar)DateUtils.CALENDAR_POOL.acquire();
                    var13_13.setTimeZone(var5_4);
                    var13_13.setTimeInMillis(var6_5);
                    var16_14 = var13_13.get(var8_6);
                    var17_15 = var13_13.get(12);
                    var18_16 = var13_13.get(14);
                    var13_13.setTimeInMillis(var2_2);
                    var20_17 = var16_14 == var13_13.get(var8_6);
                    if (!var20_17 || var17_15 != var13_13.get(12)) break block6;
                    DateUtils.formatDateTime(var0, var1_1, var2_2, 12300, var5_4);
                    break block7;
                }
                if (!var20_17 || Math.abs((int)(var17_15 - var13_13.get(12))) >= 2) break block8;
                var26_18 = var9_7 != 0 ? R.string.yesterday : R.string.tomorrow;
                var1_1.append(var12_9.getString(var26_18));
                var1_1.append(' ');
                DateUtils.formatDateTime(var0, var1_1, var2_2, 12300, var5_4);
                break block7;
            }
            if (!var20_17 || Math.abs((int)(var17_15 - var13_13.get(12))) >= 7) ** GOTO lbl-1000
            if (var18_16 <= var13_13.get(14)) {
                var8_6 = 0;
            }
            if (var9_7 == var8_6) {
                DateUtils.formatDateTime(var0, var1_1, var2_2, 13324, var5_4);
            } else if (var20_17) {
                var23_19 = var4_3 != false ? 396 : 384;
                DateUtils.formatDateTime(var0, var1_1, var2_2, 12288 | var23_19, var5_4);
            } else {
                var21_20 = var4_3 != false ? 908 : 896;
                DateUtils.formatDateTime(var0, var1_1, var2_2, 12288 | var21_20, var5_4);
            }
        }
        DateUtils.CALENDAR_POOL.release((Object)var13_13);
        return var1_1;
    }

    private static int getDatePatternResId(int n) {
        if ((n & 32768) == 32768) {
            if ((n & 512) == 512) {
                if ((n & 256) == 256) {
                    if ((n & 128) == 128) {
                        return R.string.fmt_date_numeric_year_month_day;
                    }
                    return R.string.fmt_date_numeric_year_month;
                }
                return R.string.fmt_date_numeric_year;
            }
            if ((n & 256) == 256) {
                if ((n & 128) == 128) {
                    return R.string.fmt_date_numeric_month_day;
                }
                return R.string.fmt_date_numeric_month;
            }
            if ((n & 128) == 128) {
                return R.string.fmt_date_numeric_day;
            }
            throw new IllegalArgumentException("no any time date");
        }
        if ((n & 4096) == 4096) {
            if ((n & 512) == 512) {
                if ((n & 256) == 256) {
                    if ((n & 128) == 128) {
                        return R.string.fmt_date_short_year_month_day;
                    }
                    return R.string.fmt_date_short_year_month;
                }
                return R.string.fmt_date_year;
            }
            if ((n & 256) == 256) {
                if ((n & 128) == 128) {
                    return R.string.fmt_date_short_month_day;
                }
                return R.string.fmt_date_short_month;
            }
            if ((n & 128) == 128) {
                return R.string.fmt_date_day;
            }
            throw new IllegalArgumentException("no any time date");
        }
        if ((n & 512) == 512) {
            if ((n & 256) == 256) {
                if ((n & 128) == 128) {
                    return R.string.fmt_date_long_year_month_day;
                }
                return R.string.fmt_date_long_year_month;
            }
            return R.string.fmt_date_year;
        }
        if ((n & 256) == 256) {
            if ((n & 128) == 128) {
                return R.string.fmt_date_long_month_day;
            }
            return R.string.fmt_date_long_month;
        }
        if ((n & 128) == 128) {
            return R.string.fmt_date_day;
        }
        throw new IllegalArgumentException("no any time date");
    }

    private static int getFormatResId(int n) {
        if ((n & 1024) == 1024) {
            if ((n & 896) != 0) {
                if ((n & 15) != 0) {
                    if ((n & 2048) == 2048) {
                        return R.string.fmt_weekday_date_time_timezone;
                    }
                    return R.string.fmt_weekday_date_time;
                }
                if ((n & 2048) == 2048) {
                    return R.string.fmt_weekday_date_timezone;
                }
                return R.string.fmt_weekday_date;
            }
            if ((n & 15) != 0) {
                if ((n & 2048) == 2048) {
                    return R.string.fmt_weekday_time_timezone;
                }
                return R.string.fmt_weekday_time;
            }
            if ((n & 2048) == 2048) {
                return R.string.fmt_weekday_timezone;
            }
            return R.string.fmt_weekday;
        }
        if ((n & 896) != 0) {
            if ((n & 15) != 0) {
                if ((n & 2048) == 2048) {
                    return R.string.fmt_date_time_timezone;
                }
                return R.string.fmt_date_time;
            }
            if ((n & 2048) == 2048) {
                return R.string.fmt_date_timezone;
            }
            return R.string.fmt_date;
        }
        if ((n & 15) != 0) {
            if ((n & 2048) == 2048) {
                return R.string.fmt_time_timezone;
            }
            return R.string.fmt_time;
        }
        if ((n & 2048) == 2048) {
            return R.string.fmt_timezone;
        }
        return R.string.empty;
    }

    private static int getTimePatternResId(Calendar calendar, int n) {
        if (!((n & 16384) != 16384 || (n & 1) == 1 && calendar.get(22) != 0 || (n & 14) == 0 || ((n &= -2) & 2) == 2 && calendar.get(21) != 0 || (n & 12) == 0 || calendar.get(20) != 0 || ((n &= -3) & 8) == 0)) {
            n &= -5;
        }
        if ((n & 8) == 8) {
            if ((n & 16) == 16) {
                if ((n & 64) == 64) {
                    if ((n & 4) == 4) {
                        if ((n & 2) == 2) {
                            if ((n & 1) == 1) {
                                return R.string.fmt_time_12hour_minute_second_millis;
                            }
                            return R.string.fmt_time_12hour_minute_second;
                        }
                        return R.string.fmt_time_12hour_minute;
                    }
                    return R.string.fmt_time_12hour;
                }
                if ((n & 4) == 4) {
                    if ((n & 2) == 2) {
                        if ((n & 1) == 1) {
                            return R.string.fmt_time_12hour_minute_second_millis_pm;
                        }
                        return R.string.fmt_time_12hour_minute_second_pm;
                    }
                    return R.string.fmt_time_12hour_minute_pm;
                }
                return R.string.fmt_time_12hour_pm;
            }
            if ((n & 4) == 4) {
                if ((n & 2) == 2) {
                    if ((n & 1) == 1) {
                        return R.string.fmt_time_24hour_minute_second_millis;
                    }
                    return R.string.fmt_time_24hour_minute_second;
                }
                return R.string.fmt_time_24hour_minute;
            }
            return R.string.fmt_time_24hour;
        }
        if ((n & 4) == 4) {
            if ((n & 2) == 2) {
                if ((n & 1) == 1) {
                    return R.string.fmt_time_minute_second_millis;
                }
                return R.string.fmt_time_minute_second;
            }
            return R.string.fmt_time_minute;
        }
        if ((n & 2) == 2) {
            if ((n & 1) == 1) {
                return R.string.fmt_time_second_millis;
            }
            return R.string.fmt_time_second;
        }
        if ((n & 1) == 1) {
            return R.string.fmt_time_millis;
        }
        throw new IllegalArgumentException("no any time date");
    }

    private static int getWeekdayPatternResId(int n) {
        if ((n & 8192) == 8192) {
            return R.string.fmt_weekday_short;
        }
        return R.string.fmt_weekday_long;
    }
}

