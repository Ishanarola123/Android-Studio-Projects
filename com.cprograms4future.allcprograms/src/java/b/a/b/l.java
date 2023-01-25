/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Exception
 *  java.lang.Throwable
 */
package b.a.b;

import java.io.IOException;

public final class l
extends Exception {
    public IOException a() {
        return (IOException)super.getCause();
    }

    public /* synthetic */ Throwable getCause() {
        return this.a();
    }
}

