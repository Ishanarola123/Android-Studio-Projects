/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.List
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package com.twitter;

import com.twitter.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class a {
    protected boolean a = true;

    /*
     * Enabled aggressive block sorting
     */
    public List<a> a(String string) {
        if (string == null) return Collections.emptyList();
        if (string.length() == 0) return Collections.emptyList();
        int n2 = this.a ? 46 : 58;
        int n3 = string.indexOf(n2);
        if (n3 == -1) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Matcher matcher = b.h.matcher((CharSequence)string);
        while (matcher.find()) {
            if (matcher.group(4) == null && (!this.a || b.j.matcher((CharSequence)matcher.group(2)).matches())) continue;
            String string2 = matcher.group(3);
            int n4 = matcher.start(3);
            int n5 = matcher.end(3);
            Matcher matcher2 = b.i.matcher((CharSequence)string2);
            if (matcher2.find()) {
                string2 = matcher2.group();
                n5 = n4 + string2.length();
            }
            arrayList.add((Object)new a(n4, n5, string2, a.a.a));
        }
        return arrayList;
    }

    public static class com.twitter.a$a {
        protected int a;
        protected int b;
        protected final String c;
        protected final String d;
        protected final a e;
        protected String f = null;
        protected String g = null;

        public com.twitter.a$a(int n2, int n3, String string, a a2) {
            this(n2, n3, string, null, a2);
        }

        public com.twitter.a$a(int n2, int n3, String string, String string2, a a2) {
            this.a = n2;
            this.b = n3;
            this.c = string;
            this.d = string2;
            this.e = a2;
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (!(object instanceof com.twitter.a$a)) {
                return false;
            }
            com.twitter.a$a a2 = (com.twitter.a$a)object;
            return this.e.equals((Object)a2.e) && this.a == a2.a && this.b == a2.b && this.c.equals((Object)a2.c);
        }

        public int hashCode() {
            return this.e.hashCode() + this.c.hashCode() + this.a + this.b;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.c);
            stringBuilder.append("(");
            stringBuilder.append((Object)this.e);
            stringBuilder.append(") [");
            stringBuilder.append(this.a);
            stringBuilder.append(",");
            stringBuilder.append(this.b);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }

        public static final class a
        extends Enum<a> {
            public static final /* enum */ a a = new a();
            public static final /* enum */ a b = new a();
            public static final /* enum */ a c = new a();
            public static final /* enum */ a d = new a();
            private static final /* synthetic */ a[] e;

            static {
                a[] arra = new a[]{a, b, c, d};
                e = arra;
            }

            public static a valueOf(String string) {
                return (a)Enum.valueOf(a.class, (String)string);
            }

            public static a[] values() {
                return (a[])e.clone();
            }
        }

    }

}

