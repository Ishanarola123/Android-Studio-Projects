/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.ThreadLocal
 *  java.text.DateFormat
 *  java.text.ParsePosition
 *  java.text.SimpleDateFormat
 *  java.util.Date
 *  java.util.Locale
 *  java.util.TimeZone
 */
package b.a.b;

import b.a.i;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class f {
    private static final ThreadLocal<DateFormat> a = new ThreadLocal<DateFormat>(){

        protected DateFormat a() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setLenient(false);
            simpleDateFormat.setTimeZone(i.d);
            return simpleDateFormat;
        }

        protected /* synthetic */ Object initialValue() {
            return this.a();
        }
    };
    private static final String[] b = new String[]{"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
    private static final DateFormat[] c = new DateFormat[b.length];

    public static String a(Date date) {
        return ((DateFormat)a.get()).format(date);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Date a(String string) {
        String[] arrstring;
        if (string.length() == 0) {
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Date date = ((DateFormat)a.get()).parse(string, parsePosition);
        if (parsePosition.getIndex() == string.length()) {
            return date;
        }
        String[] arrstring2 = arrstring = b;
        synchronized (arrstring2) {
            int n2 = b.length;
            int n3 = 0;
            while (n3 < n2) {
                DateFormat dateFormat = c[n3];
                if (dateFormat == null) {
                    dateFormat = new SimpleDateFormat(b[n3], Locale.US);
                    dateFormat.setTimeZone(i.d);
                    f.c[n3] = dateFormat;
                }
                parsePosition.setIndex(0);
                Date date2 = dateFormat.parse(string, parsePosition);
                if (parsePosition.getIndex() != 0) {
                    return date2;
                }
                ++n3;
            }
            return null;
        }
    }

}

