/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 */
package miuix.reflect;

public class ReflectionException
extends RuntimeException {
    private static final long serialVersionUID = -7034897190745766941L;

    public ReflectionException() {
    }

    public ReflectionException(String string2) {
        super(string2);
    }

    public ReflectionException(String string2, Throwable throwable) {
        super(string2, throwable);
    }

    public ReflectionException(Throwable throwable) {
        super(throwable);
    }
}

