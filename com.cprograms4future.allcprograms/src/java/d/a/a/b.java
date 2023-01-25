/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.io.OutputStreamWriter
 *  java.io.Writer
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.charset.Charset
 */
package d.a.a;

import b.aa;
import b.u;
import com.google.a.d.c;
import com.google.a.f;
import com.google.a.w;
import d.e;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;

final class b<T>
implements e<T, aa> {
    private static final u a = u.a("application/json; charset=UTF-8");
    private static final Charset b = Charset.forName((String)"UTF-8");
    private final f c;
    private final w<T> d;

    b(f f2, w<T> w2) {
        this.c = f2;
        this.d = w2;
    }

    @Override
    public /* synthetic */ Object a(Object object) throws IOException {
        return this.b(object);
    }

    public aa b(T t2) throws IOException {
        c.c c2 = new c.c();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(c2.d(), b);
        c c3 = this.c.a((Writer)outputStreamWriter);
        this.d.a(c3, t2);
        c3.close();
        return aa.a(a, c2.p());
    }
}

