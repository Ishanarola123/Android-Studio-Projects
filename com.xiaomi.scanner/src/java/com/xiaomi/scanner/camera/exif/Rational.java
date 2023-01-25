/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.xiaomi.scanner.camera.exif;

public class Rational {
    private final long mDenominator;
    private final long mNumerator;

    public Rational(long l2, long l3) {
        this.mNumerator = l2;
        this.mDenominator = l3;
    }

    public Rational(Rational rational) {
        this.mNumerator = rational.mNumerator;
        this.mDenominator = rational.mDenominator;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (this == object) {
            return true;
        }
        boolean bl = object instanceof Rational;
        boolean bl2 = false;
        if (bl) {
            Rational rational = (Rational)object;
            long l2 = this.mNumerator LCMP rational.mNumerator;
            bl2 = false;
            if (l2 == false) {
                long l3 = this.mDenominator LCMP rational.mDenominator;
                bl2 = false;
                if (l3 == false) {
                    bl2 = true;
                }
            }
        }
        return bl2;
    }

    public long getDenominator() {
        return this.mDenominator;
    }

    public long getNumerator() {
        return this.mNumerator;
    }

    public double toDouble() {
        double d2 = this.mNumerator;
        double d3 = this.mDenominator;
        Double.isNaN((double)d2);
        Double.isNaN((double)d3);
        return d2 / d3;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.mNumerator);
        stringBuilder.append("/");
        stringBuilder.append(this.mDenominator);
        return stringBuilder.toString();
    }
}

