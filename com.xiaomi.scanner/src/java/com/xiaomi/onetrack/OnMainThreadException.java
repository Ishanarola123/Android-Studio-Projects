/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.xiaomi.onetrack;

import com.xiaomi.onetrack.OneTrackException;

public class OnMainThreadException
extends OneTrackException {
    public OnMainThreadException() {
    }

    public OnMainThreadException(String string) {
        super(string);
    }

    public OnMainThreadException(String string, Throwable throwable) {
        super(string, throwable);
    }

    public OnMainThreadException(Throwable throwable) {
        super(throwable);
    }
}

