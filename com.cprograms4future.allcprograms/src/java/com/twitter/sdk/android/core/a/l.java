/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.Object
 *  java.util.Collections
 *  java.util.List
 */
package com.twitter.sdk.android.core.a;

import com.google.a.c.a;
import com.google.a.d.c;
import com.google.a.f;
import com.google.a.w;
import com.google.a.x;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class l
implements x {
    @Override
    public <T> w<T> a(f f2, a<T> a2) {
        return new w<T>(f2.a(this, a2), a2){
            final /* synthetic */ w a;
            final /* synthetic */ a b;
            {
                this.a = w2;
                this.b = a2;
            }

            @Override
            public void a(c c2, T t2) throws IOException {
                this.a.a(c2, t2);
            }

            @Override
            public T b(com.google.a.d.a a2) throws IOException {
                Object object = this.a.b(a2);
                if (List.class.isAssignableFrom(this.b.a())) {
                    if (object == null) {
                        return (T)Collections.EMPTY_LIST;
                    }
                    object = Collections.unmodifiableList((List)((List)object));
                }
                return object;
            }
        };
    }

}

