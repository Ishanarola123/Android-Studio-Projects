/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  d.i$a
 *  d.i$b
 *  d.i$c
 *  d.i$d
 *  d.i$e
 *  d.i$f
 *  d.i$g
 *  d.i$h
 *  d.i$i
 *  d.i$j
 *  d.i$k
 *  java.io.IOException
 *  java.lang.Boolean
 *  java.lang.Byte
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Iterable
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.Short
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.Void
 *  java.lang.annotation.Annotation
 *  java.lang.reflect.Method
 *  java.lang.reflect.ParameterizedType
 *  java.lang.reflect.Type
 *  java.net.URI
 *  java.util.LinkedHashSet
 *  java.util.Map
 *  java.util.Set
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package d;

import b.aa;
import b.ab;
import b.ac;
import b.e;
import b.r;
import b.u;
import b.v;
import b.z;
import d.b.b;
import d.b.d;
import d.b.e;
import d.b.f;
import d.b.g;
import d.b.h;
import d.b.i;
import d.b.j;
import d.b.p;
import d.b.q;
import d.b.r;
import d.b.s;
import d.b.t;
import d.b.v;
import d.c;
import d.i;
import d.k;
import d.l;
import d.m;
import d.o;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class n<T> {
    static final Pattern a = Pattern.compile((String)"\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");
    static final Pattern b = Pattern.compile((String)"[a-zA-Z][a-zA-Z0-9_-]*");
    final e.a c;
    final c<?> d;
    private final b.s e;
    private final d.e<ac, T> f;
    private final String g;
    private final String h;
    private final b.r i;
    private final u j;
    private final boolean k;
    private final boolean l;
    private final boolean m;
    private final d.i<?>[] n;

    n(a<T> a2) {
        this.c = a2.a.a();
        this.d = a2.w;
        this.e = a2.a.b();
        this.f = a2.v;
        this.g = a2.m;
        this.h = a2.q;
        this.i = a2.r;
        this.j = a2.s;
        this.k = a2.n;
        this.l = a2.o;
        this.m = a2.p;
        this.n = a2.u;
    }

    static Class<?> a(Class<?> object) {
        if (Boolean.TYPE == object) {
            return Boolean.class;
        }
        if (Byte.TYPE == object) {
            return Byte.class;
        }
        if (Character.TYPE == object) {
            return Character.class;
        }
        if (Double.TYPE == object) {
            return Double.class;
        }
        if (Float.TYPE == object) {
            return Float.class;
        }
        if (Integer.TYPE == object) {
            return Integer.class;
        }
        if (Long.TYPE == object) {
            return Long.class;
        }
        if (Short.TYPE == object) {
            object = Short.class;
        }
        return object;
    }

    static Set<String> a(String string) {
        Matcher matcher = a.matcher((CharSequence)string);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (matcher.find()) {
            linkedHashSet.add((Object)matcher.group(1));
        }
        return linkedHashSet;
    }

    /* varargs */ z a(Object ... arrobject) throws IOException {
        k k2 = new k(this.g, this.e, this.h, this.i, this.j, this.k, this.l, this.m);
        d.i<?>[] arri = this.n;
        int n2 = arrobject != null ? arrobject.length : 0;
        int n3 = arri.length;
        if (n2 == n3) {
            for (int i2 = 0; i2 < n2; ++i2) {
                arri[i2].a(k2, arrobject[i2]);
            }
            return k2.a();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Argument count (");
        stringBuilder.append(n2);
        stringBuilder.append(") doesn't match expected count (");
        stringBuilder.append(arri.length);
        stringBuilder.append(")");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    T a(ac ac2) throws IOException {
        return this.f.a(ac2);
    }

    /*
     * Exception performing whole class analysis.
     */
    static final class a<T> {
        final m a;
        final Method b;
        final Annotation[] c;
        final Annotation[][] d;
        final Type[] e;
        Type f;
        boolean g;
        boolean h;
        boolean i;
        boolean j;
        boolean k;
        boolean l;
        String m;
        boolean n;
        boolean o;
        boolean p;
        String q;
        b.r r;
        u s;
        Set<String> t;
        d.i<?>[] u;
        d.e<ac, T> v;
        c<?> w;

        public a(m m2, Method method) {
            this.a = m2;
            this.b = method;
            this.c = method.getAnnotations();
            this.e = method.getGenericParameterTypes();
            this.d = method.getParameterAnnotations();
        }

        private b.r a(String[] arrstring) {
            r.a a2 = new r.a();
            for (String string : arrstring) {
                int n2 = string.indexOf(58);
                if (n2 != -1 && n2 != 0 && n2 != string.length() - 1) {
                    String string2 = string.substring(0, n2);
                    String string3 = string.substring(n2 + 1).trim();
                    if ("Content-Type".equalsIgnoreCase(string2)) {
                        this.s = u.a(string3);
                        continue;
                    }
                    a2.a(string2, string3);
                    continue;
                }
                throw this.a("@Headers value must be in the form \"Name: Value\". Found: \"%s\"", string);
            }
            return a2.a();
        }

        private d.i<?> a(int n2, Type type, Annotation[] arrannotation) {
            int n3 = arrannotation.length;
            d.i<?> i2 = null;
            for (int i3 = 0; i3 < n3; ++i3) {
                d.i<?> i4 = this.a(n2, type, arrannotation, arrannotation[i3]);
                if (i4 == null) continue;
                if (i2 == null) {
                    i2 = i4;
                    continue;
                }
                throw this.a(n2, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
            }
            if (i2 != null) {
                return i2;
            }
            throw this.a(n2, "No Retrofit annotation found.", new Object[0]);
        }

        private d.i<?> a(int n2, Type type, Annotation[] arrannotation, Annotation annotation) {
            if (annotation instanceof v) {
                if (!this.l) {
                    if (!this.j) {
                        if (!this.k) {
                            if (this.q == null) {
                                this.l = true;
                                if (!(type == b.s.class || type == String.class || type == URI.class || type instanceof Class && "android.net.Uri".equals((Object)((Class)type).getName()))) {
                                    throw this.a(n2, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
                                }
                                return new /* Unavailable Anonymous Inner Class!! */;
                            }
                            Object[] arrobject = new Object[]{this.m};
                            throw this.a(n2, "@Url cannot be used with @%s URL", arrobject);
                        }
                        throw this.a(n2, "A @Url parameter must not come after a @Query", new Object[0]);
                    }
                    throw this.a(n2, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                throw this.a(n2, "Multiple @Url method annotations found.", new Object[0]);
            }
            if (annotation instanceof r) {
                if (!this.k) {
                    if (!this.l) {
                        if (this.q != null) {
                            this.j = true;
                            r r2 = (r)annotation;
                            String string = r2.a();
                            this.a(n2, string);
                            return new /* Unavailable Anonymous Inner Class!! */;
                        }
                        Object[] arrobject = new Object[]{this.m};
                        throw this.a(n2, "@Path can only be used with relative url on @%s", arrobject);
                    }
                    throw this.a(n2, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                throw this.a(n2, "A @Path parameter must not come after a @Query.", new Object[0]);
            }
            if (annotation instanceof s) {
                s s2 = (s)annotation;
                String string = s2.a();
                boolean bl = s2.b();
                Class<?> class_ = o.a(type);
                this.k = true;
                if (Iterable.class.isAssignableFrom(class_)) {
                    if (type instanceof ParameterizedType) {
                        Type type2 = o.a(0, (ParameterizedType)type);
                        return new /* Unavailable Anonymous Inner Class!! */.a();
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(class_.getSimpleName());
                    stringBuilder.append(" must include generic type (e.g., ");
                    stringBuilder.append(class_.getSimpleName());
                    stringBuilder.append("<String>)");
                    throw this.a(n2, stringBuilder.toString(), new Object[0]);
                }
                if (class_.isArray()) {
                    Class<?> class_2 = n.a(class_.getComponentType());
                    return new /* Unavailable Anonymous Inner Class!! */.b();
                }
                return new /* Unavailable Anonymous Inner Class!! */;
            }
            if (annotation instanceof t) {
                Class<?> class_ = o.a(type);
                if (Map.class.isAssignableFrom(class_)) {
                    Type type3 = o.b(type, class_, Map.class);
                    if (type3 instanceof ParameterizedType) {
                        ParameterizedType parameterizedType = (ParameterizedType)type3;
                        Type type4 = o.a(0, parameterizedType);
                        if (String.class == type4) {
                            Type type5 = o.a(1, parameterizedType);
                            return new /* Unavailable Anonymous Inner Class!! */;
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("@QueryMap keys must be of type String: ");
                        stringBuilder.append((Object)type4);
                        throw this.a(n2, stringBuilder.toString(), new Object[0]);
                    }
                    throw this.a(n2, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                throw this.a(n2, "@QueryMap parameter type must be Map.", new Object[0]);
            }
            if (annotation instanceof i) {
                String string = ((i)annotation).a();
                Class<?> class_ = o.a(type);
                if (Iterable.class.isAssignableFrom(class_)) {
                    if (type instanceof ParameterizedType) {
                        Type type6 = o.a(0, (ParameterizedType)type);
                        return new /* Unavailable Anonymous Inner Class!! */.a();
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(class_.getSimpleName());
                    stringBuilder.append(" must include generic type (e.g., ");
                    stringBuilder.append(class_.getSimpleName());
                    stringBuilder.append("<String>)");
                    throw this.a(n2, stringBuilder.toString(), new Object[0]);
                }
                if (class_.isArray()) {
                    Class<?> class_3 = n.a(class_.getComponentType());
                    return new /* Unavailable Anonymous Inner Class!! */.b();
                }
                return new /* Unavailable Anonymous Inner Class!! */;
            }
            if (annotation instanceof d.b.c) {
                if (this.o) {
                    d.b.c c2 = (d.b.c)annotation;
                    String string = c2.a();
                    boolean bl = c2.b();
                    this.g = true;
                    Class<?> class_ = o.a(type);
                    if (Iterable.class.isAssignableFrom(class_)) {
                        if (type instanceof ParameterizedType) {
                            Type type7 = o.a(0, (ParameterizedType)type);
                            return new /* Unavailable Anonymous Inner Class!! */.a();
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(class_.getSimpleName());
                        stringBuilder.append(" must include generic type (e.g., ");
                        stringBuilder.append(class_.getSimpleName());
                        stringBuilder.append("<String>)");
                        throw this.a(n2, stringBuilder.toString(), new Object[0]);
                    }
                    if (class_.isArray()) {
                        Class<?> class_4 = n.a(class_.getComponentType());
                        return new /* Unavailable Anonymous Inner Class!! */.b();
                    }
                    return new /* Unavailable Anonymous Inner Class!! */;
                }
                throw this.a(n2, "@Field parameters can only be used with form encoding.", new Object[0]);
            }
            if (annotation instanceof d) {
                if (this.o) {
                    Class<?> class_ = o.a(type);
                    if (Map.class.isAssignableFrom(class_)) {
                        Type type8 = o.b(type, class_, Map.class);
                        if (type8 instanceof ParameterizedType) {
                            ParameterizedType parameterizedType = (ParameterizedType)type8;
                            Type type9 = o.a(0, parameterizedType);
                            if (String.class == type9) {
                                Type type10 = o.a(1, parameterizedType);
                                d.e e2 = this.a.c(type10, arrannotation);
                                this.g = true;
                                return new /* Unavailable Anonymous Inner Class!! */;
                            }
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("@FieldMap keys must be of type String: ");
                            stringBuilder.append((Object)type9);
                            throw this.a(n2, stringBuilder.toString(), new Object[0]);
                        }
                        throw this.a(n2, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                    }
                    throw this.a(n2, "@FieldMap parameter type must be Map.", new Object[0]);
                }
                throw this.a(n2, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
            }
            if (annotation instanceof p) {
                if (this.p) {
                    p p2 = (p)annotation;
                    this.h = true;
                    String string = p2.a();
                    Class<?> class_ = o.a(type);
                    if (string.isEmpty()) {
                        if (Iterable.class.isAssignableFrom(class_)) {
                            if (type instanceof ParameterizedType) {
                                if (v.b.class.isAssignableFrom(o.a(o.a(0, (ParameterizedType)type)))) {
                                    return i.j.a.a();
                                }
                                throw this.a(n2, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                            }
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(class_.getSimpleName());
                            stringBuilder.append(" must include generic type (e.g., ");
                            stringBuilder.append(class_.getSimpleName());
                            stringBuilder.append("<String>)");
                            throw this.a(n2, stringBuilder.toString(), new Object[0]);
                        }
                        if (class_.isArray()) {
                            if (v.b.class.isAssignableFrom(class_.getComponentType())) {
                                return i.j.a.b();
                            }
                            throw this.a(n2, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                        }
                        if (v.b.class.isAssignableFrom(class_)) {
                            return i.j.a;
                        }
                        throw this.a(n2, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                    }
                    String[] arrstring = new String[4];
                    arrstring[0] = "Content-Disposition";
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("form-data; name=\"");
                    stringBuilder.append(string);
                    stringBuilder.append("\"");
                    arrstring[1] = stringBuilder.toString();
                    arrstring[2] = "Content-Transfer-Encoding";
                    arrstring[3] = p2.b();
                    b.r r3 = b.r.a(arrstring);
                    if (Iterable.class.isAssignableFrom(class_)) {
                        if (type instanceof ParameterizedType) {
                            Type type11 = o.a(0, (ParameterizedType)type);
                            if (!v.b.class.isAssignableFrom(o.a(type11))) {
                                return new /* Unavailable Anonymous Inner Class!! */.a();
                            }
                            throw this.a(n2, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                        }
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(class_.getSimpleName());
                        stringBuilder2.append(" must include generic type (e.g., ");
                        stringBuilder2.append(class_.getSimpleName());
                        stringBuilder2.append("<String>)");
                        throw this.a(n2, stringBuilder2.toString(), new Object[0]);
                    }
                    if (class_.isArray()) {
                        Class<?> class_5 = n.a(class_.getComponentType());
                        if (!v.b.class.isAssignableFrom(class_5)) {
                            return new /* Unavailable Anonymous Inner Class!! */.b();
                        }
                        throw this.a(n2, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    }
                    if (!v.b.class.isAssignableFrom(class_)) {
                        return new /* Unavailable Anonymous Inner Class!! */;
                    }
                    throw this.a(n2, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                }
                throw this.a(n2, "@Part parameters can only be used with multipart encoding.", new Object[0]);
            }
            if (annotation instanceof q) {
                if (this.p) {
                    this.h = true;
                    Class<?> class_ = o.a(type);
                    if (Map.class.isAssignableFrom(class_)) {
                        Type type12 = o.b(type, class_, Map.class);
                        if (type12 instanceof ParameterizedType) {
                            ParameterizedType parameterizedType = (ParameterizedType)type12;
                            Type type13 = o.a(0, parameterizedType);
                            if (String.class == type13) {
                                Type type14 = o.a(1, parameterizedType);
                                if (!v.b.class.isAssignableFrom(o.a(type14))) {
                                    return new /* Unavailable Anonymous Inner Class!! */;
                                }
                                throw this.a(n2, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
                            }
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("@PartMap keys must be of type String: ");
                            stringBuilder.append((Object)type13);
                            throw this.a(n2, stringBuilder.toString(), new Object[0]);
                        }
                        throw this.a(n2, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                    }
                    throw this.a(n2, "@PartMap parameter type must be Map.", new Object[0]);
                }
                throw this.a(n2, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
            }
            if (annotation instanceof d.b.a) {
                if (!this.o && !this.p) {
                    if (!this.i) {
                        d.e e3;
                        try {
                            e3 = this.a.a(type, arrannotation, this.c);
                        }
                        catch (RuntimeException runtimeException) {
                            throw this.a((Throwable)runtimeException, n2, "Unable to create @Body converter for %s", new Object[]{type});
                        }
                        this.i = true;
                        return new /* Unavailable Anonymous Inner Class!! */;
                    }
                    throw this.a(n2, "Multiple @Body method annotations found.", new Object[0]);
                }
                throw this.a(n2, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
            }
            return null;
        }

        private /* varargs */ RuntimeException a(int n2, String string, Object ... arrobject) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append(" (parameter #");
            stringBuilder.append(n2 + 1);
            stringBuilder.append(")");
            return this.a(stringBuilder.toString(), arrobject);
        }

        private /* varargs */ RuntimeException a(String string, Object ... arrobject) {
            return this.a(null, string, arrobject);
        }

        private /* varargs */ RuntimeException a(Throwable throwable, int n2, String string, Object ... arrobject) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append(" (parameter #");
            stringBuilder.append(n2 + 1);
            stringBuilder.append(")");
            return this.a(throwable, stringBuilder.toString(), arrobject);
        }

        private /* varargs */ RuntimeException a(Throwable throwable, String string, Object ... arrobject) {
            String string2 = String.format((String)string, (Object[])arrobject);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append("\n    for method ");
            stringBuilder.append(this.b.getDeclaringClass().getSimpleName());
            stringBuilder.append(".");
            stringBuilder.append(this.b.getName());
            return new IllegalArgumentException(stringBuilder.toString(), throwable);
        }

        private void a(int n2, String string) {
            if (n.b.matcher((CharSequence)string).matches()) {
                if (this.t.contains((Object)string)) {
                    return;
                }
                Object[] arrobject = new Object[]{this.q, string};
                throw this.a(n2, "URL \"%s\" does not contain \"{%s}\".", arrobject);
            }
            Object[] arrobject = new Object[]{n.a.pattern(), string};
            throw this.a(n2, "@Path parameter name must match %s. Found: %s", arrobject);
        }

        private void a(String string, String string2, boolean bl) {
            if (this.m == null) {
                String string3;
                this.m = string;
                this.n = bl;
                if (string2.isEmpty()) {
                    return;
                }
                int n2 = string2.indexOf(63);
                if (n2 != -1 && n2 < string2.length() - 1 && n.a.matcher((CharSequence)(string3 = string2.substring(n2 + 1))).find()) {
                    throw this.a("URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", string3);
                }
                this.q = string2;
                this.t = n.a(string2);
                return;
            }
            Object[] arrobject = new Object[]{this.m, string};
            throw this.a("Only one HTTP method is allowed. Found: %s and %s.", arrobject);
        }

        /*
         * Enabled aggressive block sorting
         */
        private void a(Annotation annotation) {
            block22 : {
                String string;
                String string2;
                block16 : {
                    block21 : {
                        String string3;
                        String string4;
                        block19 : {
                            block20 : {
                                block18 : {
                                    block17 : {
                                        block15 : {
                                            if (!(annotation instanceof b)) break block15;
                                            string2 = "DELETE";
                                            string = ((b)annotation).a();
                                            break block16;
                                        }
                                        if (!(annotation instanceof f)) break block17;
                                        string2 = "GET";
                                        string = ((f)annotation).a();
                                        break block16;
                                    }
                                    if (annotation instanceof g) {
                                        this.a("HEAD", ((g)annotation).a(), false);
                                        if (Void.class.equals((Object)this.f)) {
                                            return;
                                        }
                                        throw this.a("HEAD method must use Void as response type.", new Object[0]);
                                    }
                                    if (!(annotation instanceof d.b.m)) break block18;
                                    string4 = "PATCH";
                                    string3 = ((d.b.m)annotation).a();
                                    break block19;
                                }
                                if (!(annotation instanceof d.b.n)) break block20;
                                string4 = "POST";
                                string3 = ((d.b.n)annotation).a();
                                break block19;
                            }
                            if (!(annotation instanceof d.b.o)) break block21;
                            string4 = "PUT";
                            string3 = ((d.b.o)annotation).a();
                        }
                        this.a(string4, string3, true);
                        return;
                    }
                    if (!(annotation instanceof d.b.l)) break block22;
                    string2 = "OPTIONS";
                    string = ((d.b.l)annotation).a();
                }
                this.a(string2, string, false);
                return;
            }
            if (annotation instanceof h) {
                h h2 = (h)annotation;
                this.a(h2.a(), h2.b(), h2.c());
                return;
            }
            if (annotation instanceof j) {
                String[] arrstring = ((j)annotation).a();
                if (arrstring.length != 0) {
                    this.r = this.a(arrstring);
                    return;
                }
                throw this.a("@Headers annotation is empty.", new Object[0]);
            }
            if (annotation instanceof d.b.k) {
                if (!this.o) {
                    this.p = true;
                    return;
                }
                throw this.a("Only one encoding annotation is allowed.", new Object[0]);
            }
            if (!(annotation instanceof e)) {
                return;
            }
            if (!this.p) {
                this.o = true;
                return;
            }
            throw this.a("Only one encoding annotation is allowed.", new Object[0]);
        }

        private c<?> b() {
            Type type = this.b.getGenericReturnType();
            if (!o.d(type)) {
                if (type != Void.TYPE) {
                    Annotation[] arrannotation = this.b.getAnnotations();
                    try {
                        c<?> c2 = this.a.a(type, arrannotation);
                        return c2;
                    }
                    catch (RuntimeException runtimeException) {
                        throw this.a((Throwable)runtimeException, "Unable to create call adapter for %s", new Object[]{type});
                    }
                }
                throw this.a("Service methods cannot return void.", new Object[0]);
            }
            throw this.a("Method return type must not include a type variable or wildcard: %s", new Object[]{type});
        }

        private d.e<ac, T> c() {
            Annotation[] arrannotation = this.b.getAnnotations();
            try {
                d.e e2 = this.a.b(this.f, arrannotation);
                return e2;
            }
            catch (RuntimeException runtimeException) {
                Object[] arrobject = new Object[]{this.f};
                throw this.a((Throwable)runtimeException, "Unable to create converter for %s", arrobject);
            }
        }

        public n a() {
            this.w = this.b();
            this.f = this.w.a();
            if (this.f != l.class && this.f != ab.class) {
                this.v = this.c();
                Annotation[] arrannotation = this.c;
                int n2 = arrannotation.length;
                for (int i2 = 0; i2 < n2; ++i2) {
                    this.a(arrannotation[i2]);
                }
                if (this.m != null) {
                    if (!this.n) {
                        if (!this.p) {
                            if (this.o) {
                                throw this.a("FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                            }
                        } else {
                            throw this.a("Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                        }
                    }
                    int n3 = this.d.length;
                    this.u = new d.i[n3];
                    for (int i3 = 0; i3 < n3; ++i3) {
                        Type type = this.e[i3];
                        if (!o.d(type)) {
                            Annotation[] arrannotation2 = this.d[i3];
                            if (arrannotation2 != null) {
                                this.u[i3] = this.a(i3, type, arrannotation2);
                                continue;
                            }
                            throw this.a(i3, "No Retrofit annotation found.", new Object[0]);
                        }
                        throw this.a(i3, "Parameter type must not include a type variable or wildcard: %s", new Object[]{type});
                    }
                    if (this.q == null && !this.l) {
                        Object[] arrobject = new Object[]{this.m};
                        throw this.a("Missing either @%s URL or @Url parameter.", arrobject);
                    }
                    if (!this.o && !this.p && !this.n && this.i) {
                        throw this.a("Non-body HTTP method cannot contain @Body.", new Object[0]);
                    }
                    if (this.o && !this.g) {
                        throw this.a("Form-encoded method must contain at least one @Field.", new Object[0]);
                    }
                    if (this.p && !this.h) {
                        throw this.a("Multipart method must contain at least one @Part.", new Object[0]);
                    }
                    return new n(this);
                }
                throw this.a("HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("'");
            stringBuilder.append(o.a(this.f).getName());
            stringBuilder.append("' is not a valid response body type. Did you mean ResponseBody?");
            throw this.a(stringBuilder.toString(), new Object[0]);
        }
    }

}

