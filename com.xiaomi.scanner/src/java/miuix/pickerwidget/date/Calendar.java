/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.io.Serializable
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.CloneNotSupportedException
 *  java.lang.Cloneable
 *  java.lang.Comparable
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.Locale
 *  java.util.TimeZone
 *  miuix.core.util.Pools
 */
package miuix.pickerwidget.date;

import android.content.Context;
import java.io.Serializable;
import java.util.Locale;
import java.util.TimeZone;
import miuix.core.util.Pools;
import miuix.pickerwidget.date.CalendarFormatSymbols;
import miuix.pickerwidget.internal.util.SimpleNumberFormatter;

public class Calendar
implements Serializable,
Cloneable,
Comparable<Calendar> {
    public static final int AD = 1;
    public static final int AFTERNOON = 4;
    public static final int AM = 0;
    public static final int AM_PM = 17;
    public static final int APRIL = 3;
    public static final int AUGUST = 7;
    public static final int AUTUMN_BEGINS = 15;
    public static final int AUTUMN_EQUINOX = 18;
    public static final int BC = 0;
    public static final int CHICKEN = 9;
    public static final int CHINESE_ERA_DAY = 11;
    public static final int CHINESE_ERA_HOUR = 19;
    public static final int CHINESE_ERA_MONTH = 7;
    public static final int CHINESE_ERA_YEAR = 4;
    public static final int CHINESE_MONTH = 6;
    public static final int CHINESE_MONTH_IS_LEAP = 8;
    public static final int CHINESE_YEAR = 2;
    private static final int[] CHINESE_YEAR_INFO;
    public static final int CHINESE_YEAR_SYMBOL_ANIMAL = 3;
    public static final int CLEAR_AND_BRIGHT = 7;
    public static final int COLD_DEWS = 19;
    public static final int COW = 1;
    private static final int DAYS_19000131_TO_19700101 = -25537;
    private static final byte[] DAYS_IN_MONTH;
    private static final int[] DAYS_IN_YEAR;
    private static final int[] DAY_CHINESE_YEAR_FROM_19000101;
    public static final int DAY_OF_CHINESE_MONTH = 10;
    public static final int DAY_OF_CHINESE_YEAR = 13;
    public static final int DAY_OF_MONTH = 9;
    public static final int DAY_OF_WEEK = 14;
    public static final int DAY_OF_YEAR = 12;
    public static final int DECEMBER = 11;
    public static final int DETAIL_AM_PM = 16;
    public static final int DOG = 10;
    public static final int DRAGON = 4;
    public static final int DST_OFFSET = 24;
    public static final int EARLY_MORNING = 1;
    public static final int ERA = 0;
    public static final int EVENING = 5;
    public static final int FEBRUARY = 1;
    public static final int FIELD_COUNT = 25;
    private static final String[] FIELD_NAMES;
    private static final int[] FORMAT_CHARACTERS;
    public static final int FRIDAY = 6;
    public static final int GRAIN_BUDS = 10;
    public static final int GRAIN_IN_EAR = 11;
    public static final int GRAIN_RAIN = 8;
    public static final int GREAT_COLD = 2;
    public static final int GREAT_HEAT = 14;
    public static final int HEAVY_SNOW = 23;
    public static final int HOAR_FROST_FALLS = 20;
    public static final int HORSE = 6;
    public static final int HOUR = 18;
    public static final int INSECTS_AWAKEN = 5;
    public static final int IS_CHINESE_LEAP_MONTH = 1;
    public static final int JANUARY = 0;
    public static final int JULY = 6;
    public static final int JUNE = 5;
    public static final int LIGHT_SNOW = 22;
    public static final int MARCH = 2;
    private static final long MAX_CHINESE_CALENDAR_MILLISECOND = 4136400000000L;
    private static final int MAX_CHINESE_YEAR = 2100;
    public static final int MAY = 4;
    public static final int MIDNIGHT = 0;
    public static final int MILLISECOND = 22;
    public static final int MILLISECOND_OF_DAY = 86400000;
    public static final int MILLISECOND_OF_HOUR = 3600000;
    public static final int MILLISECOND_OF_MINUTE = 60000;
    public static final int MILLISECOND_OF_SECOND = 1000;
    public static final int MINUTE = 20;
    private static final long MIN_CHINESE_CALENDAR_MILLISECOND = -2206396800000L;
    private static final int MIN_CHINESE_YEAR = 1900;
    public static final int MONDAY = 2;
    public static final int MONKEY = 8;
    public static final int MONTH = 5;
    public static final int MORNING = 2;
    public static final int MOUSE = 0;
    public static final int NIGHT = 6;
    public static final int NOON = 3;
    public static final int NOT_CHINESE_LEAP_MONTH = 0;
    public static final int NOVEMBER = 10;
    public static final int NO_SOLAR_TERM = 0;
    public static final int OCTOBER = 9;
    public static final int PIG = 11;
    public static final int PM = 1;
    public static final int RABBIT = 3;
    public static final int SATURDAY = 7;
    public static final int SECOND = 21;
    public static final int SEPTEMBER = 8;
    public static final int SHEEP = 7;
    public static final int SLIGHT_COLD = 1;
    public static final int SLIGHT_HEAT = 13;
    public static final int SNAKE = 5;
    public static final int SOLAR_TERM = 15;
    private static final int[] SOLAR_TERM_BASE;
    private static final byte[] SOLAR_TERM_INDEX;
    private static final byte[] SOLAR_TERM_OS;
    public static final int SPRING_BEGINS = 3;
    public static final int STOPPING_THE_HEAT = 16;
    public static final int SUMMER_BEGINS = 9;
    public static final int SUMMER_SOLSTICE = 12;
    public static final int SUNDAY = 1;
    public static final int THE_RAINS = 4;
    public static final int THURSDAY = 5;
    public static final int TIGER = 2;
    public static final int TUESDAY = 3;
    public static final int VERNAL_EQUINOX = 6;
    public static final int WEDNESDAY = 4;
    public static final int WHITE_DEWS = 17;
    public static final int WINTER_BEGINS = 21;
    public static final int WINTER_SOLSTICE = 24;
    public static final int YEAR = 1;
    public static final int ZONE_OFFSET = 23;
    private static final long defaultGregorianCutover = -12219292800000L;
    private static final long serialVersionUID = 1L;
    private transient int changeYear;
    private transient int currentYearSkew;
    private transient long gregorianCutover = -12219292800000L;
    private transient int julianError;
    private transient int julianSkew;
    private transient int lastYearSkew;
    private int[] mFields = new int[25];
    private long mMillisecond;
    private TimeZone mTimeZone;

    static {
        DAYS_IN_MONTH = new byte[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        DAYS_IN_YEAR = new int[]{0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};
        FIELD_NAMES = new String[]{"ERA", "YEAR", "CHINESE_YEAR", "CHINESE_YEAR_SYMBOL_ANIMAL", "CHINESE_ERA_YEAR", "MONTH", "CHINESE_MONTH", "CHINESE_ERA_MONTH", "CHINESE_MONTH_IS_LEAP", "DAY_OF_MONTH", "DAY_OF_CHINESE_MONTH", "CHINESE_ERA_DAY", "DAY_OF_YEAR", "DAY_OF_CHINESE_YEAR", "DAY_OF_WEEK", "SOLAR_TERM", "DETAIL_AM_PM", "AM_PM", "HOUR", "CHINESE_ERA_HOUR", "MINUTE", "SECOND", "MILLISECOND", "ZONE_OFFSET", "DST_OFFSET"};
        FORMAT_CHARACTERS = new int[]{3, -1, -1, 12, 14, 26, 0, 18, 19, -1, 18, 5, 5, 7, -1, -1, -1, -1, 22, -1, -1, -1, 26, -1, 4, 25, -1, -1, -1, -1, -1, -1, 16, -1, 14, 9, 7, -1, -1, 18, -1, -1, 18, -1, 20, -1, -1, -1, -1, -1, 21, 15, -1, -1, 26, -1, 1, 25};
        DAY_CHINESE_YEAR_FROM_19000101 = new int[]{0, 384, 738, 1093, 1476, 1830, 2185, 2569, 2923, 3278, 3662, 4016, 4400, 4754, 5108, 5492, 5846, 6201, 6585, 6940, 7324, 7678, 8032, 8416, 8770, 9124, 9509, 9863, 10218, 10602, 10956, 11339, 11693, 12048, 12432, 12787, 13141, 13525, 13879, 14263, 14617, 14971, 15355, 15710, 16064, 16449, 16803, 17157, 17541, 17895, 18279, 18633, 18988, 19372, 19726, 20081, 20465, 20819, 21202, 21557, 21911, 22295, 22650, 23004, 23388, 23743, 24096, 24480, 24835, 25219, 25573, 25928, 26312, 26666, 27020, 27404, 27758, 28142, 28496, 28851, 29235, 29590, 29944, 30328, 30682, 31066, 31420, 31774, 32158, 32513, 32868, 33252, 33606, 33960, 34343, 34698, 35082, 35436, 35791, 36175, 36529, 36883, 37267, 37621, 37976, 38360, 38714, 39099, 39453, 39807, 40191, 40545, 40899, 41283, 41638, 42022, 42376, 42731, 43115, 43469, 43823, 44207, 44561, 44916, 45300, 45654, 46038, 46392, 46746, 47130, 47485, 47839, 48223, 48578, 48962, 49316, 49670, 50054, 50408, 50762, 51146, 51501, 51856, 52240, 52594, 52978, 53332, 53686, 54070, 54424, 54779, 55163, 55518, 55902, 56256, 56610, 56993, 57348, 57702, 58086, 58441, 58795, 59179, 59533, 59917, 60271, 60626, 61010, 61364, 61719, 62103, 62457, 62841, 63195, 63549, 63933, 64288, 64642, 65026, 65381, 65735, 66119, 66473, 66857, 67211, 67566, 67950, 68304, 68659, 69042, 69396, 69780, 70134, 70489, 70873, 71228, 71582, 71966, 72320, 72674, 73058, 73412};
        CHINESE_YEAR_INFO = new int[]{19416, 19168, 42352, 21717, 53856, 55632, 21844, 22191, 39632, 21970, 19168, 42422, 42192, 53840, 53909, 46415, 54944, 44450, 38320, 18807, 18815, 42160, 46261, 27216, 27968, 43860, 11119, 38256, 21234, 18800, 25958, 54432, 59984, 27285, 23263, 11104, 34531, 37615, 51415, 51551, 54432, 55462, 46431, 22176, 42420, 9695, 37584, 53938, 43344, 46423, 27808, 46416, 21333, 19887, 42416, 17779, 21183, 43432, 59728, 27296, 44710, 43856, 19296, 43748, 42352, 21088, 62051, 55632, 23383, 22176, 38608, 19925, 19152, 42192, 54484, 53840, 54616, 46400, 46752, 38310, 38335, 18864, 43380, 42160, 45690, 27216, 27968, 44870, 43872, 38256, 19189, 18800, 25776, 29859, 59984, 27480, 23232, 43872, 38613, 37600, 51552, 55636, 54432, 55888, 30034, 22176, 43959, 9680, 37584, 51893, 43344, 46240, 47780, 44368, 21977, 19360, 42416, 20854, 21183, 43312, 31060, 27296, 44368, 23378, 19296, 42726, 42208, 53856, 60005, 54576, 23200, 30371, 38608, 19195, 19152, 42192, 53430, 53855, 54560, 56645, 46496, 22224, 21938, 18864, 42359, 42160, 43600, 45653, 27951, 44448, 19299, 37759, 18936, 18800, 25776, 26790, 59999, 27424, 42692, 43759, 37600, 53987, 51552, 54615, 54432, 55888, 23893, 22176, 42704, 21972, 21200, 43448, 43344, 46240, 46758, 44368, 21920, 43940, 42416, 21168, 45683, 26928, 29495, 27296, 44368, 19285, 19311, 42352, 21732, 53856, 59752, 54560, 55968, 27302, 22239, 19168, 43476, 42192, 53584, 62034, 54560};
        SOLAR_TERM_BASE = new int[]{4, 19, 3, 18, 4, 19, 4, 19, 4, 20, 4, 20, 6, 22, 6, 22, 6, 22, 7, 22, 6, 21, 6, 21};
        SOLAR_TERM_INDEX = "0123415341536789:;<9:=<>:=1>?012@015@015@015AB78CDE8CD=1FD01GH01GH01IH01IJ0KLMN;LMBEOPDQRST0RUH0RVH0RWH0RWM0XYMNZ[MB\\]PT^_ST`_WH`_WH`_WM`_WM`aYMbc[Mde]Sfe]gfh_gih_Wih_WjhaWjka[jkl[jmn]ope]qph_qrh_sth_W".getBytes();
        SOLAR_TERM_OS = "211122112122112121222211221122122222212222222221222122222232222222222222222233223232223232222222322222112122112121222211222122222222222222222222322222112122112121222111211122122222212221222221221122122222222222222222222223222232222232222222222222112122112121122111211122122122212221222221221122122222222222222221211122112122212221222211222122222232222232222222222222112122112121111111222222112121112121111111222222111121112121111111211122112122112121122111222212111121111121111111111122112122112121122111211122112122212221222221222211111121111121111111222111111121111111111111111122112121112121111111222111111111111111111111111122111121112121111111221122122222212221222221222111011111111111111111111122111121111121111111211122112122112121122211221111011111101111111111111112111121111121111111211122112122112221222211221111011111101111111110111111111121111111111111111122112121112121122111111011111121111111111111111011111111112111111111111011111111111111111111221111011111101110111110111011011111111111111111221111011011101110111110111011011111101111111111211111001011101110111110110011011111101111111111211111001011001010111110110011011111101111111110211111001011001010111100110011011011101110111110211111001011001010011100110011001011101110111110211111001010001010011000100011001011001010111110111111001010001010011000111111111111111111111111100011001011001010111100111111001010001010000000111111000010000010000000100011001011001010011100110011001011001110111110100011001010001010011000110011001011001010111110111100000010000000000000000011001010001010011000111100000000000000000000000011001010001010000000111000000000000000000000000011001010000010000000".getBytes();
    }

    public Calendar() {
        this(null);
    }

    public Calendar(TimeZone timeZone) {
        int n = this.changeYear = 1582;
        this.julianError = -2 + (n / 100 - n / 400);
        this.julianSkew = (n - 2000) / 400 + this.julianError - (n - 2000) / 100;
        this.currentYearSkew = 10;
        this.lastYearSkew = 0;
        this.mMillisecond = System.currentTimeMillis();
        this.setTimeZone(timeZone);
    }

    private void appendNumericTimeZone(StringBuilder stringBuilder, boolean bl, boolean bl2) {
        char c2;
        int n = this.get(23) + this.get(24);
        if (n < 0) {
            c2 = '-';
            n = -n;
        } else {
            c2 = '+';
        }
        if (bl) {
            stringBuilder.append("GMT");
        }
        stringBuilder.append(c2);
        Calendar.appendNumericValue(stringBuilder, 2, n / 3600000);
        if (bl2) {
            stringBuilder.append(':');
        }
        Calendar.appendNumericValue(stringBuilder, 2, n % 3600000 / 60000);
    }

    private static void appendNumericValue(StringBuilder stringBuilder, int n, int n2) {
        stringBuilder.append(SimpleNumberFormatter.format(n, n2));
    }

    private void appendTimeZone(StringBuilder stringBuilder, CalendarFormatSymbols calendarFormatSymbols, int n) {
        String string2;
        TimeZone timeZone = this.mTimeZone;
        int n2 = this.mFields[24];
        int n3 = 1;
        boolean bl = n2 != 0;
        if (n != 4) {
            n3 = 0;
        }
        if ((string2 = timeZone.getDisplayName(bl, n3, calendarFormatSymbols.getLocale())) != null) {
            stringBuilder.append(string2);
            return;
        }
        this.appendNumericTimeZone(stringBuilder, false, false);
    }

    /*
     * Exception decompiling
     */
    private void appendValue(StringBuilder var1_1, CalendarFormatSymbols var2_2, char var3_3, int var4_4, int var5_5) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Extractable last case doesn't follow previous
        // org.benf.cfr.reader.b.a.a.b.as.a(SwitchReplacer.java:478)
        // org.benf.cfr.reader.b.a.a.b.as.a(SwitchReplacer.java:61)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:372)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    private void compute() {
        long l = this.computeDateTime();
        if (!this.outOfChineseCalendarRange()) {
            this.computeChineseDate(l);
            this.computeSolarTerm();
            this.computeChineseEraNames(l);
        }
    }

    private void computeChineseDate(long l) {
        int n;
        int n2;
        int n3 = (int)(l + 25537L);
        int[] arrn = this.mFields;
        int n4 = arrn[1];
        int n5 = 2100;
        if (n4 < n5) {
            n5 = 1 + arrn[1];
        }
        int n6 = n3 - DAY_CHINESE_YEAR_FROM_19000101[n5 - 1900];
        if (n6 < 0) {
            n6 += Calendar.daysInChineseYear(--n5);
        }
        if (n6 < 0) {
            n6 += Calendar.daysInChineseYear(--n5);
        }
        int[] arrn2 = this.mFields;
        arrn2[2] = n5;
        arrn2[13] = n6 + 1;
        int n7 = Calendar.leapChineseMonth(n5);
        int n8 = n6;
        int n9 = 0;
        int n10 = 0;
        for (n2 = 0; n2 < 12 && n8 > 0; n8 -= n10, ++n2) {
            if (n7 >= 0 && n2 == n7 + 1 && n9 == 0) {
                --n2;
                n10 = Calendar.leapDaysInChineseYear(n5);
                n9 = 1;
            } else {
                n10 = Calendar.daysInChineseMonth(n5, n2);
            }
            if (n9 == 0 || n2 != n7 + 1) continue;
            n9 = 0;
        }
        if (n8 == 0 && n7 > 0 && n2 == n7 + 1) {
            if (n9 != 0) {
                n = 0;
            } else {
                --n2;
                n = 1;
            }
        } else {
            n = n9;
        }
        if (n8 < 0) {
            n8 += n10;
        }
        int[] arrn3 = this.mFields;
        arrn3[8] = n;
        arrn3[6] = --n2;
        arrn3[10] = n8 + 1;
    }

    private void computeChineseEraNames(long l) {
        int[] arrn;
        int[] arrn2 = this.mFields;
        int n = arrn2[1];
        if (arrn2[5] < 2) {
            --n;
        }
        if ((arrn = this.mFields)[5] == 1 && arrn[9] >= Calendar.solarTermDaysOfMonth(arrn[1], 1) >> 8) {
            n = this.mFields[1];
        }
        int[] arrn3 = this.mFields;
        int n2 = n - 1900;
        arrn3[3] = Calendar.mod(n2 + 12, 12);
        this.mFields[4] = Calendar.mod(n2 + 36, 60);
        int[] arrn4 = this.mFields;
        int n3 = Calendar.solarTermDaysOfMonth(arrn4[1], arrn4[5]) >> 8;
        int[] arrn5 = this.mFields;
        int n4 = 12 * (-1900 + arrn5[1]) + arrn5[5];
        if (arrn5[9] >= n3) {
            ++n4;
        }
        this.mFields[7] = Calendar.mod(n4 + 12, 60);
        int n5 = (int)(l + 25537L);
        this.mFields[11] = Calendar.mod(n5 + 40, 60);
        int[] arrn6 = this.mFields;
        arrn6[19] = Calendar.mod(n5 * 12 + (1 + arrn6[18]) % 24 / 2, 60);
    }

    private void computeDate(long l, long l2) {
        int n = this.computeYearAndDay(l, l2);
        int[] arrn = this.mFields;
        arrn[12] = n;
        if (arrn[1] == this.changeYear && this.gregorianCutover <= l2) {
            n += this.currentYearSkew;
        }
        int n2 = n / 32;
        boolean bl = this.isLeapYear(this.mFields[1]);
        int n3 = n - Calendar.daysInYear(bl, n2);
        if (n3 > Calendar.daysInMonth(bl, n2)) {
            n3 -= Calendar.daysInMonth(bl, n2);
        }
        int[] arrn2 = this.mFields;
        arrn2[5] = ++n2;
        arrn2[9] = n3;
        arrn2[14] = 1 + Calendar.mod(l - 3L, 7);
    }

    private long computeDateTime() {
        long l;
        int[] arrn;
        int n;
        this.mFields[23] = this.mTimeZone.getRawOffset();
        long l2 = this.mMillisecond;
        long l3 = l2 / 86400000L;
        int n2 = (int)(l2 % 86400000L);
        if (n2 < 0) {
            n2 += 86400000;
            --l3;
        }
        int n3 = n2 + this.mFields[23];
        while (n3 < 0) {
            n3 += 86400000;
            --l3;
        }
        while (n3 >= 86400000) {
            n3 -= 86400000;
            ++l3;
        }
        int n4 = this.mFields[23];
        long l4 = this.mMillisecond;
        long l5 = l4 + (long)n4;
        if (l4 > 0L && l5 < 0L && n4 > 0) {
            l5 = Long.MAX_VALUE;
        } else if (this.mMillisecond < 0L && l5 > 0L && n4 < 0) {
            l5 = Long.MIN_VALUE;
        }
        this.computeDate(l3, l5);
        this.mFields[24] = n = this.getDstOffset(n3);
        if (n != 0) {
            if ((n3 += n) < 0) {
                n3 += 86400000;
                l = l3 - 1L;
            } else if (n3 >= 86400000) {
                n3 -= 86400000;
                l = 1L + l3;
            } else {
                l = l3;
            }
            if (l3 != l) {
                int[] arrn2 = this.mFields;
                int n5 = arrn2[24] - arrn2[23];
                long l6 = this.mMillisecond;
                long l7 = l6 + (long)n5;
                if (l6 > 0L && l7 < 0L && n5 > 0) {
                    l7 = Long.MAX_VALUE;
                } else if (this.mMillisecond < 0L && l7 > 0L && n5 < 0) {
                    l7 = Long.MIN_VALUE;
                }
                this.computeDate(l, l7);
            }
        } else {
            l = l3;
        }
        if ((arrn = this.mFields)[1] <= 0) {
            arrn[0] = 0;
            arrn[1] = 1 - arrn[1];
        } else {
            arrn[0] = 1;
        }
        int[] arrn3 = this.mFields;
        arrn3[22] = n3 % 1000;
        int n6 = n3 / 1000;
        arrn3[21] = n6 % 60;
        int n7 = n6 / 60;
        arrn3[20] = n7 % 60;
        arrn3[18] = n7 / 60 % 24;
        int n8 = arrn3[18] > 11 ? 1 : 0;
        arrn3[17] = n8;
        int[] arrn4 = this.mFields;
        switch (arrn4[18]) {
            default: {
                return l;
            }
            case 19: 
            case 20: 
            case 21: 
            case 22: 
            case 23: {
                arrn4[16] = 6;
                return l;
            }
            case 18: {
                arrn4[16] = 5;
                return l;
            }
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 17: {
                arrn4[16] = 4;
                return l;
            }
            case 12: {
                arrn4[16] = 3;
                return l;
            }
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: {
                arrn4[16] = 2;
                return l;
            }
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: {
                arrn4[16] = 1;
                return l;
            }
            case 0: 
        }
        arrn4[16] = 0;
        return l;
    }

    private void computeSolarTerm() {
        int[] arrn = this.mFields;
        int[] arrn2 = this.mFields;
        int n = Calendar.solarTermDaysOfMonth(arrn2[1], arrn2[5]);
        if (arrn[9] == n >> 8) {
            arrn[15] = 1 + 2 * arrn[5];
            return;
        }
        if (arrn[9] == (n & 255)) {
            arrn[15] = 2 + 2 * arrn[5];
            return;
        }
        arrn[15] = 0;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private int computeYearAndDay(long var1_1, long var3_2) {
        block2 : {
            var5_3 = this.gregorianCutover;
            var7_4 = 1970;
            if (var3_2 < var5_3) break block2;
            var8_6 = var1_1;
            ** GOTO lbl10
        }
        var11_5 = this.julianSkew;
        do {
            var8_6 = var1_1 - var11_5;
lbl10: // 2 sources:
            var10_7 = (int)(var8_6 / 365L);
            if (var10_7 == 0) break;
            var11_5 = this.daysFromBaseYear(var7_4 += var10_7);
        } while (true);
        if (var8_6 < 0L) {
            var8_6 += (long)this.daysInYear(--var7_4);
        }
        this.mFields[1] = var7_4;
        return 1 + (int)var8_6;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private long daysFromBaseYear(long l) {
        if (l >= 1970L) {
            int n;
            long l2 = 365L * (l - 1970L) + (l - 1969L) / 4L;
            int n2 = this.changeYear;
            if (l > (long)n2) {
                return l2 - ((l - 1901L) / 100L - (l - 1601L) / 400L);
            }
            if (l == (long)n2) {
                n = this.currentYearSkew;
                do {
                    return l2 + (long)n;
                    break;
                } while (true);
            }
            if (l == (long)(n2 - 1)) {
                n = this.lastYearSkew;
                return l2 + (long)n;
            }
            n = this.julianSkew;
            return l2 + (long)n;
        }
        if (l <= (long)this.changeYear) {
            return 365L * (l - 1970L) + (l - 1972L) / 4L + (long)this.julianSkew;
        }
        long l3 = 365L * (l - 1970L) + (l - 1972L) / 4L;
        long l4 = l - 2000L;
        return l3 - l4 / 100L + l4 / 400L;
    }

    static int daysInChineseMonth(int n, int n2) {
        if ((CHINESE_YEAR_INFO[n - 1900] & 65536 >> n2 + 1) != 0) {
            return 30;
        }
        return 29;
    }

    static int daysInChineseYear(int n) {
        int[] arrn = DAY_CHINESE_YEAR_FROM_19000101;
        int n2 = n - 1900;
        return arrn[n2 + 1] - arrn[n2];
    }

    private static int daysInMonth(boolean bl, int n) {
        if (bl && n == 1) {
            return 1 + DAYS_IN_MONTH[n];
        }
        return DAYS_IN_MONTH[n];
    }

    private int daysInYear(int n) {
        int n2 = this.isLeapYear(n) ? 366 : 365;
        if (n == this.changeYear) {
            n2 -= this.currentYearSkew;
        }
        if (n == -1 + this.changeYear) {
            n2 -= this.lastYearSkew;
        }
        return n2;
    }

    private static int daysInYear(boolean bl, int n) {
        if (bl && n > 1) {
            return 1 + DAYS_IN_YEAR[n];
        }
        return DAYS_IN_YEAR[n];
    }

    private int getDstOffset(int n) {
        int[] arrn = this.mFields;
        int n2 = arrn[1] <= 0 ? 0 : this.mTimeZone.getOffset(1, arrn[1], arrn[5], arrn[9], arrn[14], n);
        int[] arrn2 = this.mFields;
        if (arrn2[1] > 0) {
            return n2 - arrn2[23];
        }
        return 0;
    }

    private static int leapChineseMonth(int n) {
        int n2 = 15 & CHINESE_YEAR_INFO[n - 1900];
        if (n2 == 15) {
            return -1;
        }
        return n2 - 1;
    }

    static int leapDaysInChineseYear(int n) {
        if (Calendar.leapChineseMonth(n) >= 0) {
            if ((15 & CHINESE_YEAR_INFO[1 + (n - 1900)]) == 15) {
                return 30;
            }
            return 29;
        }
        return 0;
    }

    private static int mod(long l, int n) {
        int n2 = (int)(l % (long)n);
        if (l < 0L && n2 < 0) {
            n2 += n;
        }
        return n2;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void onChineseDateChange() {
        long l;
        block5 : {
            int n;
            block4 : {
                int[] arrn;
                int[] arrn2;
                block3 : {
                    l = -25537L + (long)DAY_CHINESE_YEAR_FROM_19000101[-1900 + this.mFields[2]];
                    for (int i = 0; i < (arrn2 = this.mFields)[6]; l += (long)Calendar.daysInChineseMonth((int)arrn2[2], (int)i), ++i) {
                    }
                    if (arrn2[8] != 1) break block3;
                    n = Calendar.daysInChineseMonth(arrn2[2], arrn2[6]);
                    break block4;
                }
                int n2 = Calendar.leapChineseMonth(arrn2[2]);
                if (n2 < 0 || n2 >= (arrn = this.mFields)[6]) break block5;
                n = Calendar.leapDaysInChineseYear(arrn[2]);
            }
            l += (long)n;
        }
        this.computeDate(l + (long)(this.mFields[10] - 1), 0L);
        this.onSolarDateChange();
    }

    private void onSolarDateChange() {
        int[] arrn = this.mFields;
        int n = arrn[1];
        int n2 = arrn[5];
        int n3 = arrn[9];
        long l = this.daysFromBaseYear(n) + (long)(n3 + Calendar.daysInYear(this.isLeapYear(n), n2) - 1);
        this.mFields[14] = 1 + Calendar.mod(l - 3L, 7);
        int[] arrn2 = this.mFields;
        int n4 = 3600000 * arrn2[18] + 60000 * arrn2[20] + 1000 * arrn2[21] + arrn2[22];
        this.mMillisecond = l * 86400000L + (long)n4;
        long l2 = this.mTimeZone.getOffset(this.mMillisecond);
        long l3 = this.mMillisecond;
        if (n <= 0) {
            l2 = 0L;
        }
        this.mMillisecond = l3 - l2;
        this.compute();
    }

    static int solarTermDaysOfMonth(int n, int n2) {
        if (n > 2100) {
            return 0;
        }
        int n3 = -48 + SOLAR_TERM_INDEX[n - 1900];
        int n4 = n2 * 2;
        int n5 = n4 + n3 * 24;
        int n6 = n5 + 1;
        byte[] arrby = SOLAR_TERM_OS;
        int n7 = -48 + arrby[n5];
        int[] arrn = SOLAR_TERM_BASE;
        int n8 = n7 + arrn[n4];
        return -48 + arrby[n6] + arrn[n4 + 1] + (n8 << 8);
    }

    public Calendar add(int n, int n2) {
        block49 : {
            block57 : {
                int[] arrn;
                int n3;
                block50 : {
                    block51 : {
                        block52 : {
                            block53 : {
                                block54 : {
                                    block55 : {
                                        block56 : {
                                            if (n < 0 || n >= 25) break block49;
                                            if (n == 0) break block50;
                                            if (n == 1) break block51;
                                            if (n == 2) break block52;
                                            if (n == 5) break block53;
                                            if (n == 6) break block54;
                                            if (n == 9 || n == 10 || n == 12 || n == 13) break block55;
                                            if (n == 18) break block56;
                                            switch (n) {
                                                default: {
                                                    StringBuilder stringBuilder = new StringBuilder();
                                                    stringBuilder.append("unsupported set field:");
                                                    stringBuilder.append(FIELD_NAMES[n]);
                                                    throw new IllegalArgumentException(stringBuilder.toString());
                                                }
                                                case 22: {
                                                    if (n2 != 0) {
                                                        long l = this.mMillisecond + (long)n2;
                                                        boolean bl = n2 > 0;
                                                        long l2 = l LCMP this.mMillisecond;
                                                        boolean bl2 = false;
                                                        if (l2 > 0) {
                                                            bl2 = true;
                                                        }
                                                        if (bl == bl2) {
                                                            this.mMillisecond = l;
                                                            this.compute();
                                                            return this;
                                                        }
                                                        throw new IllegalArgumentException("out of range");
                                                    }
                                                    break block57;
                                                }
                                                case 21: {
                                                    if (n2 != 0) {
                                                        long l = this.mMillisecond + 1000L * (long)n2;
                                                        boolean bl = n2 > 0;
                                                        long l3 = l LCMP this.mMillisecond;
                                                        boolean bl3 = false;
                                                        if (l3 > 0) {
                                                            bl3 = true;
                                                        }
                                                        if (bl == bl3) {
                                                            this.mMillisecond = l;
                                                            this.compute();
                                                            return this;
                                                        }
                                                        throw new IllegalArgumentException("out of range");
                                                    }
                                                    break block57;
                                                }
                                                case 20: {
                                                    if (n2 != 0) {
                                                        long l = this.mMillisecond + 60000L * (long)n2;
                                                        boolean bl = n2 > 0;
                                                        long l4 = l LCMP this.mMillisecond;
                                                        boolean bl4 = false;
                                                        if (l4 > 0) {
                                                            bl4 = true;
                                                        }
                                                        if (bl == bl4) {
                                                            this.mMillisecond = l;
                                                            this.compute();
                                                            return this;
                                                        }
                                                        throw new IllegalArgumentException("out of range");
                                                    }
                                                    break block57;
                                                }
                                            }
                                        }
                                        if (n2 != 0) {
                                            long l = this.mMillisecond + 3600000L * (long)n2;
                                            boolean bl = n2 > 0;
                                            long l5 = l LCMP this.mMillisecond;
                                            boolean bl5 = false;
                                            if (l5 > 0) {
                                                bl5 = true;
                                            }
                                            if (bl == bl5) {
                                                this.mMillisecond = l;
                                                this.compute();
                                                return this;
                                            }
                                            throw new IllegalArgumentException("out of range");
                                        }
                                        break block57;
                                    }
                                    if (n2 != 0) {
                                        long l = this.mMillisecond + 86400000L * (long)n2;
                                        boolean bl = n2 > 0;
                                        long l6 = l LCMP this.mMillisecond;
                                        boolean bl6 = false;
                                        if (l6 > 0) {
                                            bl6 = true;
                                        }
                                        if (bl == bl6) {
                                            this.mMillisecond = l;
                                            this.compute();
                                            return this;
                                        }
                                        throw new IllegalArgumentException("out of range");
                                    }
                                    break block57;
                                }
                                if (n2 != 0) {
                                    if (!this.outOfChineseCalendarRange()) {
                                        int n4 = Calendar.leapChineseMonth(this.mFields[2]);
                                        while (n2 > 0) {
                                            int[] arrn2 = this.mFields;
                                            if (arrn2[6] == n4 && arrn2[8] == 0) {
                                                arrn2[8] = 1;
                                            } else {
                                                int[] arrn3 = this.mFields;
                                                arrn3[6] = 1 + arrn3[6];
                                                arrn3[8] = 0;
                                                if (arrn3[6] > 11) {
                                                    arrn3[6] = 0;
                                                    arrn3[2] = 1 + arrn3[2];
                                                    if (arrn3[2] <= 2100) {
                                                        n4 = Calendar.leapChineseMonth(arrn3[2]);
                                                    } else {
                                                        throw new IllegalArgumentException("out of range of Chinese Lunar Year");
                                                    }
                                                }
                                            }
                                            --n2;
                                        }
                                        while (n2 < 0) {
                                            int[] arrn4 = this.mFields;
                                            if (arrn4[6] == n4 && arrn4[8] == 1) {
                                                arrn4[8] = 0;
                                            } else {
                                                int[] arrn5;
                                                int[] arrn6 = this.mFields;
                                                arrn6[6] = arrn6[6] - 1;
                                                if (arrn6[6] < 0) {
                                                    arrn6[6] = 11;
                                                    arrn6[6] = arrn6[6] - 1;
                                                    if (arrn6[2] >= 1900) {
                                                        n4 = Calendar.leapChineseMonth(arrn6[1]);
                                                    } else {
                                                        throw new IllegalArgumentException("out of range of Chinese Lunar Year");
                                                    }
                                                }
                                                if ((arrn5 = this.mFields)[6] == n4) {
                                                    arrn5[8] = 1;
                                                }
                                            }
                                            ++n2;
                                        }
                                        int[] arrn7 = this.mFields;
                                        int[] arrn8 = this.mFields;
                                        int n5 = arrn8[8] == 1 ? Calendar.leapDaysInChineseYear(arrn8[2]) : Calendar.daysInChineseMonth(arrn8[2], arrn8[6]);
                                        if (arrn7[10] > n5) {
                                            arrn7[10] = n5;
                                        }
                                        this.onChineseDateChange();
                                        return this;
                                    }
                                    throw new IllegalArgumentException("out of range of Chinese Lunar Year");
                                }
                                break block57;
                            }
                            if (n2 != 0) {
                                int n6 = n2 + this.mFields[5];
                                int n7 = n6 / 12;
                                int n8 = n6 % 12;
                                if (n8 < 0) {
                                    n8 += 12;
                                    --n7;
                                }
                                int[] arrn9 = this.mFields;
                                arrn9[5] = n8;
                                if (n7 == 0) {
                                    int n9;
                                    int[] arrn10;
                                    if (arrn9[0] == 0) {
                                        arrn9[1] = -1 - arrn9[1];
                                    }
                                    if ((arrn10 = this.mFields)[9] > (n9 = Calendar.daysInMonth(this.isLeapYear(this.mFields[1]), this.mFields[5]))) {
                                        arrn10[9] = n9;
                                    }
                                    this.onSolarDateChange();
                                    return this;
                                }
                                this.add(1, n7);
                                return this;
                            }
                            break block57;
                        }
                        if (n2 != 0) {
                            int n10 = n2 + this.mFields[2];
                            if (!this.outOfChineseCalendarRange() && n10 >= 1900 && n10 <= 2100) {
                                int[] arrn11;
                                int[] arrn12;
                                int n11;
                                int[] arrn13 = this.mFields;
                                arrn13[2] = n10;
                                if (arrn13[8] == 1 && arrn13[6] == Calendar.leapChineseMonth(arrn13[2])) {
                                    this.mFields[8] = 0;
                                }
                                if ((arrn11 = this.mFields)[10] > (n11 = (arrn12 = this.mFields)[8] == 1 ? Calendar.leapDaysInChineseYear(arrn12[2]) : Calendar.daysInChineseMonth(arrn12[2], arrn12[6]))) {
                                    arrn11[10] = n11;
                                }
                                this.onChineseDateChange();
                                return this;
                            }
                            throw new IllegalArgumentException("out of range of Chinese Lunar Year");
                        }
                        break block57;
                    }
                    if (n2 != 0) {
                        int[] arrn14 = this.mFields;
                        if (arrn14[0] == 0) {
                            arrn14[1] = -1 - arrn14[1];
                        }
                        int[] arrn15 = this.mFields;
                        arrn15[1] = n2 + arrn15[1];
                        int[] arrn16 = this.mFields;
                        int n12 = Calendar.daysInMonth(this.isLeapYear(arrn15[1]), this.mFields[5]);
                        if (arrn16[9] > n12) {
                            arrn16[9] = n12;
                        }
                        this.onSolarDateChange();
                        return this;
                    }
                    break block57;
                }
                if (n2 != 0 && (arrn = this.mFields)[0] != (n3 = (n2 + arrn[0]) % 2) && arrn[0] == 0) {
                    arrn[1] = -1 - arrn[1];
                    this.onSolarDateChange();
                }
            }
            return this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Field out of range [0-25]: ");
        stringBuilder.append(n);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public boolean after(Calendar calendar) {
        return this.getTimeInMillis() > calendar.getTimeInMillis();
    }

    public boolean before(Calendar calendar) {
        return this.getTimeInMillis() < calendar.getTimeInMillis();
    }

    public final Object clone() {
        try {
            Calendar calendar = (Calendar)super.clone();
            calendar.mFields = (int[])this.mFields.clone();
            calendar.mTimeZone = (TimeZone)this.mTimeZone.clone();
            return calendar;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new RuntimeException((Throwable)cloneNotSupportedException);
        }
    }

    public int compareTo(Calendar calendar) {
        long l = this.mMillisecond;
        long l2 = calendar.mMillisecond;
        if (l < l2) {
            return -1;
        }
        return l != l2;
    }

    public boolean equals(Object object) {
        return object == this || object instanceof Calendar && this.mMillisecond == ((Calendar)object).mMillisecond;
        {
        }
    }

    public String format(Context context, CharSequence charSequence) {
        return this.format(context, charSequence, null);
    }

    public String format(Context context, CharSequence charSequence, CalendarFormatSymbols calendarFormatSymbols) {
        StringBuilder stringBuilder = (StringBuilder)Pools.getStringBuilderPool().acquire();
        String string2 = this.format(context, stringBuilder, charSequence, calendarFormatSymbols).toString();
        Pools.getStringBuilderPool().release((Object)stringBuilder);
        return string2;
    }

    public StringBuilder format(Context context, StringBuilder stringBuilder, CharSequence charSequence) {
        return this.format(context, stringBuilder, charSequence, null);
    }

    public StringBuilder format(Context context, StringBuilder stringBuilder, CharSequence charSequence, CalendarFormatSymbols calendarFormatSymbols) {
        if (calendarFormatSymbols == null) {
            calendarFormatSymbols = CalendarFormatSymbols.getOrCreate(context);
        }
        int n = charSequence.length();
        boolean bl = false;
        for (int i = 0; i < n; ++i) {
            int[] arrn;
            int n2;
            char c2;
            block11 : {
                block12 : {
                    int n3;
                    block10 : {
                        block7 : {
                            block8 : {
                                block9 : {
                                    c2 = charSequence.charAt(i);
                                    if (!bl) break block7;
                                    if (c2 != '\'') break block8;
                                    n3 = i + 1;
                                    if (n3 >= n || charSequence.charAt(n3) != c2) break block9;
                                    stringBuilder.append(c2);
                                    break block10;
                                }
                                bl = false;
                                continue;
                            }
                            stringBuilder.append(c2);
                            continue;
                        }
                        if (c2 != '\'') break block11;
                        n3 = i + 1;
                        if (n3 >= n || charSequence.charAt(n3) != c2) break block12;
                        stringBuilder.append(c2);
                    }
                    i = n3;
                    continue;
                }
                bl = true;
                continue;
            }
            if (c2 >= 'A' && c2 <= 'z' && (arrn = FORMAT_CHARACTERS)[n2 = c2 - 65] >= 0) {
                int n4;
                int n5 = i;
                int n6 = 1;
                while ((n4 = n5 + 1) < n && charSequence.charAt(n4) == c2) {
                    ++n6;
                    n5 = n4;
                }
                int n7 = FORMAT_CHARACTERS[n2];
                this.appendValue(stringBuilder, calendarFormatSymbols, c2, n6, n7);
                i = n5;
                continue;
            }
            stringBuilder.append(c2);
        }
        return stringBuilder;
    }

    public int get(int n) {
        if (n >= 0 && n < 25) {
            return this.mFields[n];
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Field out of range [0-25]: ");
        stringBuilder.append(n);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public int getActualMaximum(int n) {
        if (n >= 0 && n < 25) {
            switch (n) {
                default: {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("unsupported field: ");
                    stringBuilder.append(FIELD_NAMES[n]);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
                case 22: {
                    return 999;
                }
                case 20: 
                case 21: {
                    return 59;
                }
                case 18: {
                    return 23;
                }
                case 17: {
                    return 1;
                }
                case 16: {
                    return 6;
                }
                case 15: {
                    return 24;
                }
                case 14: {
                    return 7;
                }
                case 13: {
                    if (this.outOfChineseCalendarRange()) {
                        return 0;
                    }
                    return Calendar.daysInChineseYear(this.mFields[2]);
                }
                case 12: {
                    return this.daysInYear(this.mFields[1]);
                }
                case 10: {
                    if (this.outOfChineseCalendarRange()) {
                        return 0;
                    }
                    if (this.isChineseLeapMonth()) {
                        return Calendar.leapDaysInChineseYear(this.mFields[2]);
                    }
                    int[] arrn = this.mFields;
                    return Calendar.daysInChineseMonth(arrn[2], arrn[6]);
                }
                case 9: {
                    return Calendar.daysInMonth(this.isLeapYear(this.mFields[1]), this.mFields[5]);
                }
                case 8: {
                    return 1;
                }
                case 5: 
                case 6: {
                    return 11;
                }
                case 4: 
                case 7: 
                case 11: 
                case 19: {
                    return 59;
                }
                case 3: {
                    return 11;
                }
                case 2: {
                    return 2100;
                }
                case 1: {
                    if (this.mFields[0] == 1) {
                        return 292278994;
                    }
                    return 292269055;
                }
                case 0: 
            }
            return 1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Field out of range [0-25]: ");
        stringBuilder.append(n);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public int getActualMinimum(int n) {
        if (n >= 0 && n < 25) {
            switch (n) {
                default: {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("unsupported field: ");
                    stringBuilder.append(FIELD_NAMES[n]);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
                case 15: 
                case 16: 
                case 17: 
                case 18: 
                case 20: 
                case 21: 
                case 22: {
                    return 0;
                }
                case 14: {
                    return 1;
                }
                case 13: {
                    return true ^ this.outOfChineseCalendarRange();
                }
                case 12: {
                    return 1;
                }
                case 10: {
                    return true ^ this.outOfChineseCalendarRange();
                }
                case 9: {
                    return 1;
                }
                case 3: 
                case 4: 
                case 5: 
                case 6: 
                case 7: 
                case 8: 
                case 11: 
                case 19: {
                    return 0;
                }
                case 2: {
                    return 1900;
                }
                case 1: {
                    return 1;
                }
                case 0: 
            }
            return 0;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Field out of range [0-25]: ");
        stringBuilder.append(n);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public int getChineseLeapMonth() {
        return Calendar.leapChineseMonth(this.mFields[2]);
    }

    public long getTimeInMillis() {
        return this.mMillisecond;
    }

    public TimeZone getTimeZone() {
        return this.mTimeZone;
    }

    public int hashCode() {
        long l = this.mMillisecond;
        return (int)(l ^ l >>> 32);
    }

    public boolean isChineseLeapMonth() {
        return this.mFields[8] == 1;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean isLeapYear(int n) {
        int n2 = this.changeYear;
        boolean bl = true;
        if (n > n2) {
            if (n % 4 != 0) return false;
            if (n % 100 != 0) return bl;
            if (n % 400 != 0) return false;
            return bl;
        }
        if (n % 4 != 0) return false;
        return bl;
    }

    public boolean outOfChineseCalendarRange() {
        long l = this.mMillisecond;
        int[] arrn = this.mFields;
        return l < -2206396800000L - (long)arrn[23] - (long)arrn[24] || l >= 4136400000000L - (long)arrn[23] - (long)arrn[24];
        {
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Calendar set(int n, int n2) {
        if (n == 6) {
            if (n2 < 0) {
                if ((n2 = -n2) != Calendar.leapChineseMonth(this.mFields[2])) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("year ");
                    stringBuilder.append(this.mFields[2]);
                    stringBuilder.append(" has no such leap month:");
                    stringBuilder.append(n2);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
                this.mFields[8] = 1;
            } else {
                if (n2 < this.getActualMinimum(n) && n2 > this.getActualMaximum(n)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("value is out of date range [");
                    stringBuilder.append(this.getActualMinimum(n));
                    stringBuilder.append("-");
                    stringBuilder.append(this.getActualMaximum(n));
                    stringBuilder.append("]: ");
                    stringBuilder.append(n2);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
                this.mFields[8] = 0;
            }
            int[] arrn = this.mFields;
            arrn[6] = n2;
            int n3 = arrn[8] == 1 ? Calendar.leapDaysInChineseYear(arrn[2]) : Calendar.daysInChineseMonth(arrn[2], arrn[6]);
            int[] arrn2 = this.mFields;
            if (arrn2[10] > n3) {
                arrn2[10] = n3;
            }
            this.onChineseDateChange();
            return this;
        }
        if (n2 < this.getActualMinimum(n) && n2 > this.getActualMaximum(n)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("value is out of date range [");
            stringBuilder.append(this.getActualMinimum(n));
            stringBuilder.append("-");
            stringBuilder.append(this.getActualMaximum(n));
            stringBuilder.append("]: ");
            stringBuilder.append(n2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        try {
            this.add(n, n2 - this.mFields[n]);
            return this;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("unsupported set field:");
            stringBuilder.append(FIELD_NAMES[n]);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public Calendar set(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        if (n2 >= 0 && n2 <= 11) {
            if (n3 > 0 && n3 <= Calendar.daysInMonth(this.isLeapYear(n), n2)) {
                if (n4 >= 0 && n4 <= 23) {
                    if (n5 >= 0 && n5 <= 59) {
                        if (n6 >= 0 && n6 <= 59) {
                            if (n7 >= 0 && n7 <= 999) {
                                int[] arrn = this.mFields;
                                arrn[1] = n;
                                arrn[5] = n2;
                                arrn[9] = n3;
                                arrn[18] = n4;
                                arrn[20] = n5;
                                arrn[21] = n6;
                                arrn[22] = n7;
                                this.onSolarDateChange();
                                return this;
                            }
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Invalid millisecond ");
                            stringBuilder.append(n7);
                            throw new IllegalArgumentException(stringBuilder.toString());
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Invalid second ");
                        stringBuilder.append(n6);
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Invalid minute ");
                    stringBuilder.append(n5);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid hour ");
                stringBuilder.append(n4);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Year ");
            stringBuilder.append(n);
            stringBuilder.append(" month ");
            stringBuilder.append(n2);
            stringBuilder.append(" has no day ");
            stringBuilder.append(n3);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Year ");
        stringBuilder.append(n);
        stringBuilder.append(" has no month ");
        stringBuilder.append(n2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public Calendar setChineseTime(int n, int n2, int n3, boolean bl, int n4, int n5, int n6, int n7) {
        block10 : {
            block11 : {
                block14 : {
                    block13 : {
                        block12 : {
                            if (n < 1900 || n > 2100) break block10;
                            if (n2 < 0 || n2 > 11) break block11;
                            if (bl && Calendar.leapChineseMonth(n) != n2) {
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("Year ");
                                stringBuilder.append(n);
                                stringBuilder.append(" has no leap month ");
                                stringBuilder.append(n2);
                                throw new IllegalArgumentException(stringBuilder.toString());
                            }
                            if (!bl) break block12;
                            if (n3 <= 0 || n3 > Calendar.leapDaysInChineseYear(n)) {
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("Year ");
                                stringBuilder.append(n);
                                stringBuilder.append(" month ");
                                stringBuilder.append(n2);
                                stringBuilder.append(" has no day ");
                                stringBuilder.append(n3);
                                throw new IllegalArgumentException(stringBuilder.toString());
                            }
                            break block13;
                        }
                        if (n3 <= 0 || n3 > Calendar.daysInChineseMonth(n, n2)) break block14;
                    }
                    if (n4 >= 0 && n4 <= 23) {
                        if (n5 >= 0 && n5 <= 59) {
                            if (n6 >= 0 && n6 <= 59) {
                                if (n7 >= 0 && n7 <= 1000) {
                                    int[] arrn = this.mFields;
                                    arrn[2] = n;
                                    arrn[6] = n2;
                                    arrn[10] = n3;
                                    arrn[8] = bl ? 1 : 0;
                                    arrn[18] = n4;
                                    arrn[20] = n5;
                                    arrn[21] = n6;
                                    arrn[22] = n7;
                                    this.onChineseDateChange();
                                    return this;
                                }
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("Invalid millisecond ");
                                stringBuilder.append(n7);
                                throw new IllegalArgumentException(stringBuilder.toString());
                            }
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Invalid second ");
                            stringBuilder.append(n6);
                            throw new IllegalArgumentException(stringBuilder.toString());
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Invalid minute ");
                        stringBuilder.append(n5);
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Invalid hour ");
                    stringBuilder.append(n4);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Year ");
                stringBuilder.append(n);
                stringBuilder.append(" month ");
                stringBuilder.append(n2);
                stringBuilder.append(" has no day ");
                stringBuilder.append(n3);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Year ");
            stringBuilder.append(n);
            stringBuilder.append(" has no month ");
            stringBuilder.append(n2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Date out of range [1900 - 2100] expected, but year is ");
        stringBuilder.append(n);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public void setGregorianChange(long l) {
        int n;
        this.gregorianCutover = l;
        Calendar calendar = new Calendar(TimeZone.getTimeZone((String)"GMT"));
        calendar.setTimeInMillis(l);
        this.changeYear = calendar.get(1);
        if (calendar.get(0) == 0) {
            this.changeYear = 1 - this.changeYear;
        }
        int n2 = this.changeYear;
        this.julianError = -2 + (n2 / 100 - n2 / 400);
        this.julianSkew = (n2 - 2000) / 400 + this.julianError - (n2 - 2000) / 100;
        int n3 = calendar.get(12);
        if (n3 < (n = this.julianSkew)) {
            this.currentYearSkew = n3 - 1;
            this.lastYearSkew = 1 + (n - n3);
            return;
        }
        this.lastYearSkew = 0;
        this.currentYearSkew = n;
    }

    public Calendar setTimeInMillis(long l) {
        this.mMillisecond = l;
        this.compute();
        return this;
    }

    public Calendar setTimeZone(TimeZone timeZone) {
        TimeZone timeZone2;
        if (timeZone == null) {
            timeZone = TimeZone.getDefault();
        }
        if ((timeZone2 = this.mTimeZone) == null || !timeZone2.getID().equals((Object)timeZone.getID())) {
            this.mTimeZone = timeZone;
            this.compute();
        }
        return this;
    }

    public String toString() {
        StringBuilder stringBuilder = (StringBuilder)Pools.getStringBuilderPool().acquire();
        stringBuilder.append(this.getClass().getName());
        stringBuilder.append("[time");
        stringBuilder.append(this.mMillisecond);
        stringBuilder.append(",zone=");
        stringBuilder.append(this.mTimeZone.getID());
        for (int i = 0; i < 25; ++i) {
            stringBuilder.append(',');
            stringBuilder.append(FIELD_NAMES[i]);
            stringBuilder.append('=');
            stringBuilder.append(this.mFields[i]);
        }
        stringBuilder.append(']');
        String string2 = stringBuilder.toString();
        Pools.getStringBuilderPool().release((Object)stringBuilder);
        return string2;
    }
}

