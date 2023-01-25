/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.charset.Charset
 *  java.util.Locale
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package b;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class u {
    private static final Pattern a = Pattern.compile((String)"([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    private static final Pattern b = Pattern.compile((String)";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    private final String c;
    private final String d;
    private final String e;
    private final String f;

    private u(String string, String string2, String string3, String string4) {
        this.c = string;
        this.d = string2;
        this.e = string3;
        this.f = string4;
    }

    public static u a(String string) {
        Matcher matcher = a.matcher((CharSequence)string);
        if (!matcher.lookingAt()) {
            return null;
        }
        String string2 = matcher.group(1).toLowerCase(Locale.US);
        String string3 = matcher.group(2).toLowerCase(Locale.US);
        Matcher matcher2 = b.matcher((CharSequence)string);
        int n2 = matcher.end();
        String string4 = null;
        while (n2 < string.length()) {
            matcher2.region(n2, string.length());
            if (!matcher2.lookingAt()) {
                return null;
            }
            String string5 = matcher2.group(1);
            if (string5 != null && string5.equalsIgnoreCase("charset")) {
                String string6 = matcher2.group(2) != null ? matcher2.group(2) : matcher2.group(3);
                if (string4 != null && !string6.equalsIgnoreCase(string4)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Multiple different charsets: ");
                    stringBuilder.append(string);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
                string4 = string6;
            }
            n2 = matcher2.end();
        }
        return new u(string, string2, string3, string4);
    }

    public String a() {
        return this.d;
    }

    public Charset a(Charset charset) {
        if (this.f != null) {
            charset = Charset.forName((String)this.f);
        }
        return charset;
    }

    public boolean equals(Object object) {
        return object instanceof u && ((u)object).c.equals((Object)this.c);
    }

    public int hashCode() {
        return this.c.hashCode();
    }

    public String toString() {
        return this.c;
    }
}

