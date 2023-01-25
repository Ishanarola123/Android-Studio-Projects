/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ObjectStreamException
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Number
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.math.BigDecimal
 */
package com.google.a.b;

import java.io.ObjectStreamException;
import java.math.BigDecimal;

public final class f
extends Number {
    private final String a;

    public f(String string) {
        this.a = string;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new BigDecimal(this.a);
    }

    public double doubleValue() {
        return Double.parseDouble((String)this.a);
    }

    public boolean equals(Object object) {
        boolean bl = true;
        if (this == object) {
            return bl;
        }
        if (object instanceof f) {
            f f2 = (f)((Object)object);
            if (this.a != f2.a) {
                if (this.a.equals((Object)f2.a)) {
                    return bl;
                }
                bl = false;
            }
            return bl;
        }
        return false;
    }

    public float floatValue() {
        return Float.parseFloat((String)this.a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public int intValue() {
        try {
            int n2 = Integer.parseInt((String)this.a);
            return n2;
        }
        catch (NumberFormatException numberFormatException) {
            long l2;
            try {
                l2 = Long.parseLong((String)this.a);
            }
            catch (NumberFormatException numberFormatException2) {
                return new BigDecimal(this.a).intValue();
            }
            return (int)l2;
        }
    }

    public long longValue() {
        try {
            long l2 = Long.parseLong((String)this.a);
            return l2;
        }
        catch (NumberFormatException numberFormatException) {
            return new BigDecimal(this.a).longValue();
        }
    }

    public String toString() {
        return this.a;
    }
}

