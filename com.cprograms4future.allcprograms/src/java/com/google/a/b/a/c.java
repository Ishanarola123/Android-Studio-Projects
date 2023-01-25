/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.text.DateFormat
 *  java.text.ParseException
 *  java.text.ParsePosition
 *  java.util.Date
 *  java.util.Locale
 */
package com.google.a.b.a;

import com.google.a.b.a.a.a;
import com.google.a.d.b;
import com.google.a.f;
import com.google.a.t;
import com.google.a.w;
import com.google.a.x;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.Locale;

public final class c
extends w<Date> {
    public static final x a = new x(){

        @Override
        public <T> w<T> a(f f2, com.google.a.c.a<T> a2) {
            if (a2.a() == Date.class) {
                return new c();
            }
            return null;
        }
    };
    private final DateFormat b = DateFormat.getDateTimeInstance((int)2, (int)2, (Locale)Locale.US);
    private final DateFormat c = DateFormat.getDateTimeInstance((int)2, (int)2);

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Date a(String string) {
        c c2 = this;
        synchronized (c2) {
            try {
                try {
                    return this.c.parse(string);
                }
                catch (ParseException parseException) {
                    try {
                        return this.b.parse(string);
                    }
                    catch (ParseException parseException2) {
                        try {
                            return a.a(string, new ParsePosition(0));
                        }
                        catch (ParseException parseException3) {
                            throw new t(string, parseException3);
                        }
                    }
                }
            }
            catch (Throwable throwable2) {}
            throw throwable2;
        }
    }

    public Date a(com.google.a.d.a a2) throws IOException {
        if (a2.f() == b.i) {
            a2.j();
            return null;
        }
        return this.a(a2.h());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(com.google.a.d.c c2, Date date) throws IOException {
        c c3 = this;
        synchronized (c3) {
            Throwable throwable2;
            if (date == null) {
                try {
                    c2.f();
                    return;
                }
                catch (Throwable throwable2) {}
            } else {
                c2.b(this.b.format(date));
                return;
            }
            throw throwable2;
        }
    }

    @Override
    public /* synthetic */ Object b(com.google.a.d.a a2) throws IOException {
        return this.a(a2);
    }

}

