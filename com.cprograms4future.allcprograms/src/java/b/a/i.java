/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.c
 *  java.io.Closeable
 *  java.io.IOException
 *  java.io.InterruptedIOException
 *  java.lang.ArrayIndexOutOfBoundsException
 *  java.lang.AssertionError
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Error
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.lang.reflect.Array
 *  java.net.IDN
 *  java.net.Socket
 *  java.nio.charset.Charset
 *  java.security.MessageDigest
 *  java.security.NoSuchAlgorithmException
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.List
 *  java.util.Locale
 *  java.util.TimeZone
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.TimeUnit
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package b.a;

import b.s;
import c.c;
import c.f;
import c.r;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.Array;
import java.net.IDN;
import java.net.Socket;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class i {
    public static final byte[] a = new byte[0];
    public static final String[] b = new String[0];
    public static final Charset c = Charset.forName((String)"UTF-8");
    public static final TimeZone d = TimeZone.getTimeZone((String)"GMT");
    private static final Pattern e = Pattern.compile((String)"([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    public static int a(String string, int n2, int n3) {
        while (n2 < n3) {
            switch (string.charAt(n2)) {
                default: {
                    return n2;
                }
                case '\t': 
                case '\n': 
                case '\f': 
                case '\r': 
                case ' ': 
            }
            ++n2;
        }
        return n3;
    }

    public static int a(String string, int n2, int n3, char c2) {
        while (n2 < n3) {
            if (string.charAt(n2) == c2) {
                return n2;
            }
            ++n2;
        }
        return n3;
    }

    public static int a(String string, int n2, int n3, String string2) {
        while (n2 < n3) {
            if (string2.indexOf((int)string.charAt(n2)) != -1) {
                return n2;
            }
            ++n2;
        }
        return n3;
    }

    public static f a(f f2) {
        try {
            f f3 = f.a(MessageDigest.getInstance((String)"SHA-1").digest(f2.g()));
            return f3;
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new AssertionError((Object)noSuchAlgorithmException);
        }
    }

    public static String a(s s2, boolean bl) {
        String string;
        if (s2.f().contains((CharSequence)":")) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append(s2.f());
            stringBuilder.append("]");
            string = stringBuilder.toString();
        } else {
            string = s2.f();
        }
        if (bl || s2.g() != s.a(s2.b())) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append(":");
            stringBuilder.append(s2.g());
            string = stringBuilder.toString();
        }
        return string;
    }

    public static String a(String string) {
        String string2;
        block4 : {
            try {
                string2 = IDN.toASCII((String)string).toLowerCase(Locale.US);
                if (!string2.isEmpty()) break block4;
                return null;
            }
            catch (IllegalArgumentException illegalArgumentException) {
                return null;
            }
        }
        boolean bl = i.c(string2);
        if (bl) {
            return null;
        }
        return string2;
    }

    public static <T> List<T> a(List<T> list) {
        return Collections.unmodifiableList((List)new ArrayList(list));
    }

    public static /* varargs */ <T> List<T> a(T ... arrT) {
        return Collections.unmodifiableList((List)Arrays.asList((Object[])((Object[])arrT.clone())));
    }

    private static <T> List<T> a(T[] arrT, T[] arrT2) {
        ArrayList arrayList = new ArrayList();
        block0 : for (T t2 : arrT) {
            for (T t3 : arrT2) {
                if (!t2.equals(t3)) continue;
                arrayList.add(t3);
                continue block0;
            }
        }
        return arrayList;
    }

    public static ThreadFactory a(final String string, final boolean bl) {
        return new ThreadFactory(){

            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, string);
                thread.setDaemon(bl);
                return thread;
            }
        };
    }

    public static void a(long l2, long l3, long l4) {
        if ((l3 | l4) >= 0L && l3 <= l2 && l2 - l3 >= l4) {
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    /*
     * Exception decompiling
     */
    public static void a(Closeable var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl9.1 : RETURN : trying to set 0 previously set to 1
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
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

    public static void a(Closeable closeable, Closeable closeable2) throws IOException {
        Throwable throwable;
        block8 : {
            try {
                closeable.close();
                throwable = null;
            }
            catch (Throwable throwable2) {
                // empty catch block
            }
            try {
                closeable2.close();
            }
            catch (Throwable throwable3) {
                if (throwable != null) break block8;
                throwable = throwable3;
            }
        }
        if (throwable == null) {
            return;
        }
        if (!(throwable instanceof IOException)) {
            if (!(throwable instanceof RuntimeException)) {
                if (throwable instanceof Error) {
                    throw (Error)throwable;
                }
                throw new AssertionError((Object)throwable);
            }
            throw (RuntimeException)throwable;
        }
        throw (IOException)throwable;
    }

    /*
     * Exception decompiling
     */
    public static void a(Socket var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl16.1 : RETURN : trying to set 0 previously set to 1
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
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

    public static boolean a(r r2, int n2, TimeUnit timeUnit) {
        try {
            boolean bl = i.b(r2, n2, timeUnit);
            return bl;
        }
        catch (IOException iOException) {
            return false;
        }
    }

    public static boolean a(AssertionError assertionError) {
        return assertionError.getCause() != null && assertionError.getMessage() != null && assertionError.getMessage().contains((CharSequence)"getsockname failed");
    }

    public static boolean a(Object object, Object object2) {
        return object == object2 || object != null && object.equals(object2);
        {
        }
    }

    public static boolean a(String[] arrstring, String string) {
        return Arrays.asList((Object[])arrstring).contains((Object)string);
    }

    public static <T> T[] a(Class<T> class_, T[] arrT, T[] arrT2) {
        List<T> list = i.a(arrT, arrT2);
        return list.toArray((Object[])Array.newInstance(class_, (int)list.size()));
    }

    public static int b(String string, int n2, int n3) {
        for (int i2 = n3 - 1; i2 >= n2; --i2) {
            switch (string.charAt(i2)) {
                default: {
                    return i2 + 1;
                }
                case '\t': 
                case '\n': 
                case '\f': 
                case '\r': 
                case ' ': 
            }
        }
        return n2;
    }

    public static f b(f f2) {
        try {
            f f3 = f.a(MessageDigest.getInstance((String)"SHA-256").digest(f2.g()));
            return f3;
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new AssertionError((Object)noSuchAlgorithmException);
        }
    }

    public static boolean b(r r2, int n2, TimeUnit timeUnit) throws IOException {
        long l2;
        long l3;
        block7 : {
            l3 = System.nanoTime();
            l2 = r2.a().B_() ? r2.a().d() - l3 : Long.MAX_VALUE;
            r2.a().a(l3 + Math.min((long)l2, (long)timeUnit.toNanos((long)n2)));
            try {
                c c2 = new c();
                while (r2.a(c2, 2048L) != -1L) {
                    c2.clear();
                }
                if (l2 != Long.MAX_VALUE) break block7;
            }
            catch (Throwable throwable) {
                if (l2 == Long.MAX_VALUE) {
                    r2.a().f();
                } else {
                    r2.a().a(l3 + l2);
                }
                throw throwable;
            }
            catch (InterruptedIOException interruptedIOException) {
                if (l2 == Long.MAX_VALUE) {
                    r2.a().f();
                    return false;
                }
                r2.a().a(l3 + l2);
                return false;
            }
            r2.a().f();
            return true;
        }
        r2.a().a(l3 + l2);
        return true;
    }

    public static boolean b(String string) {
        return e.matcher((CharSequence)string).matches();
    }

    public static String[] b(String[] arrstring, String string) {
        String[] arrstring2 = new String[1 + arrstring.length];
        System.arraycopy((Object)arrstring, (int)0, (Object)arrstring2, (int)0, (int)arrstring.length);
        arrstring2[-1 + arrstring2.length] = string;
        return arrstring2;
    }

    public static String c(String string, int n2, int n3) {
        int n4 = i.a(string, n2, n3);
        return string.substring(n4, i.b(string, n4, n3));
    }

    private static boolean c(String string) {
        for (int i2 = 0; i2 < string.length(); ++i2) {
            char c2 = string.charAt(i2);
            if (c2 > '\u001f') {
                if (c2 >= '') {
                    return true;
                }
                if (" #%/:?@[\\]".indexOf((int)c2) == -1) continue;
                return true;
            }
            return true;
        }
        return false;
    }

}

