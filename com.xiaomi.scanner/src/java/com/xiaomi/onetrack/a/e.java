/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.PrintWriter
 *  java.io.StringWriter
 *  java.io.Writer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Thread
 *  java.lang.Thread$UncaughtExceptionHandler
 *  java.lang.Throwable
 */
package com.xiaomi.onetrack.a;

import com.xiaomi.onetrack.CrashAnalysis;
import com.xiaomi.onetrack.a.f;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public class e
implements Thread.UncaughtExceptionHandler {
    private f a;
    private Thread.UncaughtExceptionHandler b;

    public e(f f2) {
        this.a = f2;
    }

    public void a() {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (uncaughtExceptionHandler instanceof e) {
            return;
        }
        this.b = uncaughtExceptionHandler;
        Thread.setDefaultUncaughtExceptionHandler((Thread.UncaughtExceptionHandler)this);
    }

    public void uncaughtException(Thread thread, Throwable throwable) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        if (this.a != null) {
            StringWriter stringWriter = new StringWriter();
            throwable.printStackTrace(new PrintWriter((Writer)stringWriter));
            String string2 = stringWriter.toString();
            String string3 = CrashAnalysis.calculateJavaDigest(string2);
            this.a.a(string2, throwable.toString(), "java", null, string3);
        }
        if ((uncaughtExceptionHandler = this.b) != null) {
            uncaughtExceptionHandler.uncaughtException(thread, throwable);
        }
    }
}

