/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.xiaomi.scanner.camera.exif;

class JpegHeader {
    public static final short APP0 = -32;
    public static final short APP1 = -31;
    public static final short DAC = -52;
    public static final short DHT = -60;
    public static final short EOI = -39;
    public static final short JPG = -56;
    public static final short SOF0 = -64;
    public static final short SOF15 = -49;
    public static final short SOI = -40;

    JpegHeader() {
    }

    public static final boolean isSofMarker(short s2) {
        return s2 >= -64 && s2 <= -49 && s2 != -60 && s2 != -56 && s2 != -52;
    }
}

