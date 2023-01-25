/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.Date
 *  java.util.GregorianCalendar
 *  java.util.List
 *  java.util.Locale
 *  java.util.TimeZone
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package b;

import b.a.b.f;
import b.a.i;
import b.r;
import b.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class l {
    private static final Pattern a = Pattern.compile((String)"(\\d{2,4})[^\\d]*");
    private static final Pattern b = Pattern.compile((String)"(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern c = Pattern.compile((String)"(\\d{1,2})[^\\d]*");
    private static final Pattern d = Pattern.compile((String)"(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    private final String e;
    private final String f;
    private final long g;
    private final String h;
    private final String i;
    private final boolean j;
    private final boolean k;
    private final boolean l;
    private final boolean m;

    private l(String string, String string2, long l2, String string3, String string4, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.e = string;
        this.f = string2;
        this.g = l2;
        this.h = string3;
        this.i = string4;
        this.j = bl;
        this.k = bl2;
        this.m = bl3;
        this.l = bl4;
    }

    private static int a(String string, int n2, int n3, boolean bl) {
        while (n2 < n3) {
            char c2 = string.charAt(n2);
            boolean bl2 = c2 < ' ' && c2 != '\t' || c2 >= '' || c2 >= '0' && c2 <= '9' || c2 >= 'a' && c2 <= 'z' || c2 >= 'A' && c2 <= 'Z' || c2 == ':';
            if (bl2 == (bl ^ true)) {
                return n2;
            }
            ++n2;
        }
        return n3;
    }

    private static long a(String string) {
        try {
            long l2 = Long.parseLong((String)string);
            if (l2 <= 0L) {
                return Long.MIN_VALUE;
            }
            return l2;
        }
        catch (NumberFormatException numberFormatException) {
            if (string.matches("-?\\d+")) {
                if (string.startsWith("-")) {
                    return Long.MIN_VALUE;
                }
                return Long.MAX_VALUE;
            }
            throw numberFormatException;
        }
    }

    private static long a(String string, int n2, int n3) {
        int n4 = l.a(string, n2, n3, false);
        Matcher matcher = d.matcher((CharSequence)string);
        int n5 = -1;
        int n6 = -1;
        int n7 = -1;
        int n8 = -1;
        int n9 = -1;
        int n10 = -1;
        while (n4 < n3) {
            int n11 = l.a(string, n4 + 1, n3, true);
            matcher.region(n4, n11);
            if (n5 == -1 && matcher.usePattern(d).matches()) {
                int n12 = Integer.parseInt((String)matcher.group(1));
                int n13 = Integer.parseInt((String)matcher.group(2));
                n10 = Integer.parseInt((String)matcher.group(3));
                n9 = n13;
                n5 = n12;
            } else if (n7 == -1 && matcher.usePattern(c).matches()) {
                n7 = Integer.parseInt((String)matcher.group(1));
            } else if (n8 == -1 && matcher.usePattern(b).matches()) {
                String string2 = matcher.group(1).toLowerCase(Locale.US);
                n8 = b.pattern().indexOf(string2) / 4;
            } else if (n6 == -1 && matcher.usePattern(a).matches()) {
                n6 = Integer.parseInt((String)matcher.group(1));
            }
            n4 = l.a(string, n11 + 1, n3, false);
        }
        if (n6 >= 70 && n6 <= 99) {
            n6 += 1900;
        }
        if (n6 >= 0 && n6 <= 69) {
            n6 += 2000;
        }
        if (n6 >= 1601) {
            if (n8 != -1) {
                if (n7 >= 1 && n7 <= 31) {
                    if (n5 >= 0 && n5 <= 23) {
                        if (n9 >= 0 && n9 <= 59) {
                            if (n10 >= 0 && n10 <= 59) {
                                GregorianCalendar gregorianCalendar = new GregorianCalendar(i.d);
                                gregorianCalendar.setLenient(false);
                                gregorianCalendar.set(1, n6);
                                gregorianCalendar.set(2, n8 - 1);
                                gregorianCalendar.set(5, n7);
                                gregorianCalendar.set(11, n5);
                                gregorianCalendar.set(12, n9);
                                gregorianCalendar.set(13, n10);
                                gregorianCalendar.set(14, 0);
                                return gregorianCalendar.getTimeInMillis();
                            }
                            throw new IllegalArgumentException();
                        }
                        throw new IllegalArgumentException();
                    }
                    throw new IllegalArgumentException();
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    /*
     * Exception decompiling
     */
    static l a(long var0, s var2, String var3) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1162)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:636)
        // java.lang.Thread.run(Thread.java:764)
        throw new IllegalStateException("Decompilation failed");
    }

    public static l a(s s2, String string) {
        return l.a(System.currentTimeMillis(), s2, string);
    }

    public static List<l> a(s s2, r r2) {
        List<String> list = r2.c("Set-Cookie");
        int n2 = list.size();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < n2; ++i2) {
            l l2 = l.a(s2, (String)list.get(i2));
            if (l2 == null) continue;
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add((Object)l2);
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    private static String b(String string) {
        if (!string.endsWith(".")) {
            String string2;
            if (string.startsWith(".")) {
                string = string.substring(1);
            }
            if ((string2 = i.a(string)) != null) {
                return string2;
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    private static boolean b(s s2, String string) {
        String string2 = s2.f();
        if (string2.equals((Object)string)) {
            return true;
        }
        return string2.endsWith(string) && string2.charAt(string2.length() - string.length() - 1) == '.' && !i.b(string2);
    }

    public String a() {
        return this.e;
    }

    public String b() {
        return this.f;
    }

    public boolean equals(Object object) {
        if (!(object instanceof l)) {
            return false;
        }
        l l2 = (l)object;
        boolean bl = l2.e.equals((Object)this.e);
        boolean bl2 = false;
        if (bl) {
            boolean bl3 = l2.f.equals((Object)this.f);
            bl2 = false;
            if (bl3) {
                boolean bl4 = l2.h.equals((Object)this.h);
                bl2 = false;
                if (bl4) {
                    boolean bl5 = l2.i.equals((Object)this.i);
                    bl2 = false;
                    if (bl5) {
                        long l3 = l2.g LCMP this.g;
                        bl2 = false;
                        if (l3 == false) {
                            boolean bl6 = l2.j;
                            boolean bl7 = this.j;
                            bl2 = false;
                            if (bl6 == bl7) {
                                boolean bl8 = l2.k;
                                boolean bl9 = this.k;
                                bl2 = false;
                                if (bl8 == bl9) {
                                    boolean bl10 = l2.l;
                                    boolean bl11 = this.l;
                                    bl2 = false;
                                    if (bl10 == bl11) {
                                        boolean bl12 = l2.m;
                                        boolean bl13 = this.m;
                                        bl2 = false;
                                        if (bl12 == bl13) {
                                            bl2 = true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return bl2;
    }

    public int hashCode() {
        return 31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (527 + this.e.hashCode()) + this.f.hashCode()) + this.h.hashCode()) + this.i.hashCode()) + (int)(this.g ^ this.g >>> 32)) + (true ^ this.j)) + (true ^ this.k)) + (true ^ this.l)) + (true ^ this.m);
    }

    /*
     * Enabled aggressive block sorting
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.e);
        stringBuilder.append('=');
        stringBuilder.append(this.f);
        if (this.l) {
            String string;
            if (this.g == Long.MIN_VALUE) {
                string = "; max-age=0";
            } else {
                stringBuilder.append("; expires=");
                string = f.a(new Date(this.g));
            }
            stringBuilder.append(string);
        }
        if (!this.m) {
            stringBuilder.append("; domain=");
            stringBuilder.append(this.h);
        }
        stringBuilder.append("; path=");
        stringBuilder.append(this.i);
        if (this.j) {
            stringBuilder.append("; secure");
        }
        if (this.k) {
            stringBuilder.append("; httponly");
        }
        return stringBuilder.toString();
    }
}

