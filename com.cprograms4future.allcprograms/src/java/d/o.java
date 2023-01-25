/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.c
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.annotation.Annotation
 *  java.lang.reflect.Array
 *  java.lang.reflect.GenericArrayType
 *  java.lang.reflect.GenericDeclaration
 *  java.lang.reflect.ParameterizedType
 *  java.lang.reflect.Type
 *  java.lang.reflect.TypeVariable
 *  java.lang.reflect.WildcardType
 *  java.util.Arrays
 *  java.util.NoSuchElementException
 */
package d;

import b.ac;
import b.u;
import c.e;
import c.q;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.NoSuchElementException;

final class o {
    static final Type[] a = new Type[0];

    static int a(Object object) {
        if (object != null) {
            return object.hashCode();
        }
        return 0;
    }

    private static int a(Object[] arrobject, Object object) {
        for (int i2 = 0; i2 < arrobject.length; ++i2) {
            if (!object.equals(arrobject[i2])) continue;
            return i2;
        }
        throw new NoSuchElementException();
    }

    static ac a(ac ac2) throws IOException {
        c.c c2 = new c.c();
        ac2.d().a((q)c2);
        return ac.a(ac2.a(), ac2.b(), (e)c2);
    }

    static Class<?> a(Type type) {
        if (type != null) {
            if (type instanceof Class) {
                return (Class)type;
            }
            if (type instanceof ParameterizedType) {
                Type type2 = ((ParameterizedType)type).getRawType();
                if (type2 instanceof Class) {
                    return (Class)type2;
                }
                throw new IllegalArgumentException();
            }
            if (type instanceof GenericArrayType) {
                return Array.newInstance(o.a(((GenericArrayType)type).getGenericComponentType()), (int)0).getClass();
            }
            if (type instanceof TypeVariable) {
                return Object.class;
            }
            if (type instanceof WildcardType) {
                return o.a(((WildcardType)type).getUpperBounds()[0]);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Expected a Class, ParameterizedType, or GenericArrayType, but <");
            stringBuilder.append((Object)type);
            stringBuilder.append("> is of type ");
            stringBuilder.append(type.getClass().getName());
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        throw new NullPointerException("type == null");
    }

    private static Class<?> a(TypeVariable<?> typeVariable) {
        GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            return (Class)genericDeclaration;
        }
        return null;
    }

    static <T> T a(T t2, String string) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(string);
    }

    static Type a(int n2, ParameterizedType parameterizedType) {
        Type[] arrtype = parameterizedType.getActualTypeArguments();
        if (n2 >= 0 && n2 < arrtype.length) {
            Type type = arrtype[n2];
            if (type instanceof WildcardType) {
                type = ((WildcardType)type).getUpperBounds()[0];
            }
            return type;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Index ");
        stringBuilder.append(n2);
        stringBuilder.append(" not in range [0,");
        stringBuilder.append(arrtype.length);
        stringBuilder.append(") for ");
        stringBuilder.append((Object)parameterizedType);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    static Type a(Type type, Class<?> class_, Class<?> class_2) {
        if (class_2 == class_) {
            return type;
        }
        if (class_2.isInterface()) {
            Class[] arrclass = class_.getInterfaces();
            int n2 = arrclass.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (arrclass[i2] == class_2) {
                    return class_.getGenericInterfaces()[i2];
                }
                if (!class_2.isAssignableFrom(arrclass[i2])) continue;
                return o.a(class_.getGenericInterfaces()[i2], arrclass[i2], class_2);
            }
        }
        if (!class_.isInterface()) {
            while (class_ != Object.class) {
                Class class_3 = class_.getSuperclass();
                if (class_3 == class_2) {
                    return class_.getGenericSuperclass();
                }
                if (class_2.isAssignableFrom(class_3)) {
                    return o.a(class_.getGenericSuperclass(), class_3, class_2);
                }
                class_ = class_3;
            }
        }
        return class_2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static Type a(Type type, Class<?> class_, Type type2) {
        Class class_2;
        while (type2 instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable)type2;
            Type type3 = o.a(type, class_, typeVariable);
            if (type3 == typeVariable) {
                return type3;
            }
            type2 = type3;
        }
        if (type2 instanceof Class && (class_2 = (Class)type2).isArray()) {
            Type type4;
            Class class_3 = class_2.getComponentType();
            if (class_3 != (type4 = o.a(type, class_, (Type)class_3))) return new a(type4);
            return class_2;
        }
        if (type2 instanceof GenericArrayType) {
            Type type5;
            GenericArrayType genericArrayType = (GenericArrayType)type2;
            Type type6 = genericArrayType.getGenericComponentType();
            if (type6 != (type5 = o.a(type, class_, type6))) return new a(type5);
            return genericArrayType;
        }
        boolean bl = type2 instanceof ParameterizedType;
        if (bl) {
            ParameterizedType parameterizedType = (ParameterizedType)type2;
            Type type7 = parameterizedType.getOwnerType();
            Type type8 = o.a(type, class_, type7);
            boolean bl2 = type8 != type7;
            Type[] arrtype = parameterizedType.getActualTypeArguments();
            int n2 = arrtype.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                Type type9 = o.a(type, class_, arrtype[i2]);
                if (type9 == arrtype[i2]) continue;
                if (!bl2) {
                    arrtype = (Type[])arrtype.clone();
                    bl2 = true;
                }
                arrtype[i2] = type9;
            }
            if (!bl2) return parameterizedType;
            return new b(type8, parameterizedType.getRawType(), arrtype);
        }
        if (!(type2 instanceof WildcardType)) return type2;
        type2 = (WildcardType)type2;
        Type[] arrtype = type2.getLowerBounds();
        Type[] arrtype2 = type2.getUpperBounds();
        if (arrtype.length == 1) {
            Type type10 = o.a(type, class_, arrtype[0]);
            if (type10 == arrtype[0]) return type2;
            return new c(new Type[]{Object.class}, new Type[]{type10});
        }
        if (arrtype2.length != 1) return type2;
        Type type11 = arrtype2[0];
        Type type12 = o.a(type, class_, type11);
        if (type12 == arrtype2[0]) return type2;
        return new c(new Type[]{type12}, a);
    }

    private static Type a(Type type, Class<?> class_, TypeVariable<?> typeVariable) {
        Class<?> class_2 = o.a(typeVariable);
        if (class_2 == null) {
            return typeVariable;
        }
        Type type2 = o.a(type, class_, class_2);
        if (type2 instanceof ParameterizedType) {
            int n2 = o.a((Object[])class_2.getTypeParameters(), typeVariable);
            return ((ParameterizedType)type2).getActualTypeArguments()[n2];
        }
        return typeVariable;
    }

    static <T> void a(Class<T> class_) {
        if (class_.isInterface()) {
            if (class_.getInterfaces().length <= 0) {
                return;
            }
            throw new IllegalArgumentException("API interfaces must not extend other interfaces.");
        }
        throw new IllegalArgumentException("API declarations must be interfaces.");
    }

    private static boolean a(Object object, Object object2) {
        return object == object2 || object != null && object.equals(object2);
        {
        }
    }

    static boolean a(Type type, Type type2) {
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals((Object)type2);
        }
        if (type instanceof ParameterizedType) {
            if (!(type2 instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType)type;
            ParameterizedType parameterizedType2 = (ParameterizedType)type2;
            return o.a((Object)parameterizedType.getOwnerType(), (Object)parameterizedType2.getOwnerType()) && parameterizedType.getRawType().equals((Object)parameterizedType2.getRawType()) && Arrays.equals((Object[])parameterizedType.getActualTypeArguments(), (Object[])parameterizedType2.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            if (!(type2 instanceof GenericArrayType)) {
                return false;
            }
            GenericArrayType genericArrayType = (GenericArrayType)type;
            GenericArrayType genericArrayType2 = (GenericArrayType)type2;
            return o.a(genericArrayType.getGenericComponentType(), genericArrayType2.getGenericComponentType());
        }
        if (type instanceof WildcardType) {
            if (!(type2 instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType)type;
            WildcardType wildcardType2 = (WildcardType)type2;
            return Arrays.equals((Object[])wildcardType.getUpperBounds(), (Object[])wildcardType2.getUpperBounds()) && Arrays.equals((Object[])wildcardType.getLowerBounds(), (Object[])wildcardType2.getLowerBounds());
        }
        if (type instanceof TypeVariable) {
            if (!(type2 instanceof TypeVariable)) {
                return false;
            }
            TypeVariable typeVariable = (TypeVariable)type;
            TypeVariable typeVariable2 = (TypeVariable)type2;
            return typeVariable.getGenericDeclaration() == typeVariable2.getGenericDeclaration() && typeVariable.getName().equals((Object)typeVariable2.getName());
        }
        return false;
    }

    static boolean a(Annotation[] arrannotation, Class<? extends Annotation> class_) {
        int n2 = arrannotation.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!class_.isInstance((Object)arrannotation[i2])) continue;
            return true;
        }
        return false;
    }

    static String b(Type type) {
        if (type instanceof Class) {
            return ((Class)type).getName();
        }
        return type.toString();
    }

    static Type b(Type type, Class<?> class_, Class<?> class_2) {
        if (class_2.isAssignableFrom(class_)) {
            return o.a(type, class_, o.a(type, class_, class_2));
        }
        throw new IllegalArgumentException();
    }

    static void c(Type type) {
        if (type instanceof Class) {
            if (!((Class)type).isPrimitive()) {
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    static boolean d(Type type) {
        if (type instanceof Class) {
            return false;
        }
        if (type instanceof ParameterizedType) {
            Type[] arrtype = ((ParameterizedType)type).getActualTypeArguments();
            int n2 = arrtype.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (!o.d(arrtype[i2])) continue;
                return true;
            }
            return false;
        }
        if (type instanceof GenericArrayType) {
            return o.d(((GenericArrayType)type).getGenericComponentType());
        }
        if (type instanceof TypeVariable) {
            return true;
        }
        if (type instanceof WildcardType) {
            return true;
        }
        String string = type == null ? "null" : type.getClass().getName();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected a Class, ParameterizedType, or GenericArrayType, but <");
        stringBuilder.append((Object)type);
        stringBuilder.append("> is of type ");
        stringBuilder.append(string);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    static Type e(Type type) {
        if (type instanceof ParameterizedType) {
            return o.a(0, (ParameterizedType)type);
        }
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }

    private static final class a
    implements GenericArrayType {
        private final Type a;

        public a(Type type) {
            this.a = type;
        }

        public boolean equals(Object object) {
            return object instanceof GenericArrayType && o.a((Type)this, (Type)((GenericArrayType)object));
        }

        public Type getGenericComponentType() {
            return this.a;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(o.b(this.a));
            stringBuilder.append("[]");
            return stringBuilder.toString();
        }
    }

    private static final class b
    implements ParameterizedType {
        private final Type a;
        private final Type b;
        private final Type[] c;

        public /* varargs */ b(Type type, Type type2, Type ... arrtype) {
            boolean bl = type2 instanceof Class;
            int n2 = 0;
            if (bl) {
                boolean bl2 = true;
                boolean bl3 = type == null;
                if (((Class)type2).getEnclosingClass() != null) {
                    bl2 = false;
                }
                if (bl3 != bl2) {
                    throw new IllegalArgumentException();
                }
            }
            this.a = type;
            this.b = type2;
            Type[] arrtype2 = this.c = (Type[])arrtype.clone();
            int n3 = arrtype2.length;
            while (n2 < n3) {
                Type type3 = arrtype2[n2];
                if (type3 != null) {
                    o.c(type3);
                    ++n2;
                    continue;
                }
                throw new NullPointerException();
            }
        }

        public boolean equals(Object object) {
            return object instanceof ParameterizedType && o.a((Type)this, (Type)((ParameterizedType)object));
        }

        public Type[] getActualTypeArguments() {
            return (Type[])this.c.clone();
        }

        public Type getOwnerType() {
            return this.a;
        }

        public Type getRawType() {
            return this.b;
        }

        public int hashCode() {
            return Arrays.hashCode((Object[])this.c) ^ this.b.hashCode() ^ o.a((Object)this.a);
        }

        public String toString() {
            int n2;
            int n3 = this.c.length;
            StringBuilder stringBuilder = new StringBuilder(30 * (n3 + n2));
            stringBuilder.append(o.b(this.b));
            if (this.c.length == 0) {
                return stringBuilder.toString();
            }
            stringBuilder.append("<");
            stringBuilder.append(o.b(this.c[0]));
            for (n2 = 1; n2 < this.c.length; ++n2) {
                stringBuilder.append(", ");
                stringBuilder.append(o.b(this.c[n2]));
            }
            stringBuilder.append(">");
            return stringBuilder.toString();
        }
    }

    private static final class c
    implements WildcardType {
        private final Type a;
        private final Type b;

        public c(Type[] arrtype, Type[] arrtype2) {
            block2 : {
                block3 : {
                    block8 : {
                        Object object;
                        block7 : {
                            block4 : {
                                block5 : {
                                    block6 : {
                                        if (arrtype2.length > 1) break block2;
                                        if (arrtype.length != 1) break block3;
                                        if (arrtype2.length != 1) break block4;
                                        if (arrtype2[0] == null) break block5;
                                        o.c(arrtype2[0]);
                                        if (arrtype[0] != Object.class) break block6;
                                        this.b = arrtype2[0];
                                        object = Object.class;
                                        break block7;
                                    }
                                    throw new IllegalArgumentException();
                                }
                                throw new NullPointerException();
                            }
                            if (arrtype[0] == null) break block8;
                            o.c(arrtype[0]);
                            this.b = null;
                            object = arrtype[0];
                        }
                        this.a = object;
                        return;
                    }
                    throw new NullPointerException();
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException();
        }

        public boolean equals(Object object) {
            return object instanceof WildcardType && o.a((Type)this, (Type)((WildcardType)object));
        }

        public Type[] getLowerBounds() {
            if (this.b != null) {
                Type[] arrtype = new Type[]{this.b};
                return arrtype;
            }
            return o.a;
        }

        public Type[] getUpperBounds() {
            Type[] arrtype = new Type[]{this.a};
            return arrtype;
        }

        public int hashCode() {
            int n2 = this.b != null ? 31 + this.b.hashCode() : 1;
            return n2 ^ 31 + this.a.hashCode();
        }

        /*
         * Enabled aggressive block sorting
         */
        public String toString() {
            Type type;
            StringBuilder stringBuilder;
            if (this.b != null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("? super ");
                type = this.b;
            } else {
                if (this.a == Object.class) {
                    return "?";
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append("? extends ");
                type = this.a;
            }
            stringBuilder.append(o.b(type));
            return stringBuilder.toString();
        }
    }

}

