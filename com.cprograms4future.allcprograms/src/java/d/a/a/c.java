/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.Reader
 *  java.lang.Object
 */
package d.a.a;

import b.ac;
import com.google.a.d.a;
import com.google.a.f;
import com.google.a.w;
import d.e;
import java.io.IOException;
import java.io.Reader;

final class c<T>
implements e<ac, T> {
    private final f a;
    private final w<T> b;

    c(f f2, w<T> w2) {
        this.a = f2;
        this.b = w2;
    }

    @Override
    public T a(ac ac2) throws IOException {
        a a2 = this.a.a(ac2.e());
        try {
            T t2 = this.b.b(a2);
            return t2;
        }
        finally {
            ac2.close();
        }
    }
}

