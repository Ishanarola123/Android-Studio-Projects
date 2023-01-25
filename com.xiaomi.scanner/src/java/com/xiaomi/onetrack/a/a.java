/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.xiaomi.onetrack.a;

import com.xiaomi.onetrack.Configuration;

public class a {
    private static final int a = 1;
    private static final int b = 2;
    private static final int c = 4;
    private static final int d = 8;
    private static final int e = 16;

    public static int a(Configuration configuration) {
        if (configuration == null) {
            return 0;
        }
        boolean bl = configuration.isGAIDEnable();
        int n2 = 0;
        if (bl) {
            n2 = 1;
        }
        if (configuration.isIMSIEnable()) {
            n2 |= 2;
        }
        if (configuration.isIMEIEnable()) {
            n2 |= 4;
        }
        if (configuration.isExceptionCatcherEnable()) {
            n2 |= 8;
        }
        if (configuration.isOverrideMiuiRegionSetting()) {
            n2 |= 16;
        }
        return n2;
    }
}

