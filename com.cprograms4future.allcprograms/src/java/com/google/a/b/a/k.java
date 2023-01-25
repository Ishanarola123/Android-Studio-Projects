/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.sql.Time
 *  java.text.DateFormat
 *  java.text.ParseException
 *  java.text.SimpleDateFormat
 *  java.util.Date
 */
package com.google.a.b.a;

import com.google.a.c.a;
import com.google.a.d.b;
import com.google.a.d.c;
import com.google.a.f;
import com.google.a.t;
import com.google.a.w;
import com.google.a.x;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class k
extends w<Time> {
    public static final x a = new x(){

        @Override
        public <T> w<T> a(f f2, a<T> a2) {
            if (a2.a() == Time.class) {
                return new k();
            }
            return null;
        }
    };
    private final DateFormat b = new SimpleDateFormat("hh:mm:ss a");

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Time a(com.google.a.d.a a2) throws IOException {
        k k2 = this;
        synchronized (k2) {
            if (a2.f() == b.i) {
                a2.j();
                return null;
            }
            try {
                return new Time(this.b.parse(a2.h()).getTime());
            }
            catch (ParseException parseException) {
                throw new t(parseException);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(c c2, Time time) throws IOException {
        k k2 = this;
        synchronized (k2) {
            String string = time == null ? null : this.b.format((Date)time);
            c2.b(string);
            return;
        }
    }

    @Override
    public /* synthetic */ Object b(com.google.a.d.a a2) throws IOException {
        return this.a(a2);
    }

}

