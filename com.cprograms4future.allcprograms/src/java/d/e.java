/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.annotation.Annotation
 *  java.lang.reflect.Type
 */
package d;

import b.aa;
import b.ac;
import d.m;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

public interface e<F, T> {
    public T a(F var1) throws IOException;

    public static abstract class a {
        public e<ac, ?> a(Type type, Annotation[] arrannotation, m m2) {
            return null;
        }

        public e<?, aa> a(Type type, Annotation[] arrannotation, Annotation[] arrannotation2, m m2) {
            return null;
        }

        public e<?, String> b(Type type, Annotation[] arrannotation, m m2) {
            return null;
        }
    }

}

