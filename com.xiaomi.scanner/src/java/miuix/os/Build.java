/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  miuix.core.util.SystemProperties
 */
package miuix.os;

import miuix.core.util.SystemProperties;

public class Build {
    public static final boolean IS_INTERNATIONAL_BUILD = SystemProperties.get((String)"ro.product.mod_device", (String)"").contains((CharSequence)"_global");
}

