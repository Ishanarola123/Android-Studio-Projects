/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.pm.ApplicationInfo
 *  android.content.res.Resources
 *  java.io.Closeable
 *  java.io.File
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.security.MessageDigest
 *  java.security.NoSuchAlgorithmException
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Locale
 *  java.util.Scanner
 */
package a.a.a.a.a.b;

import a.a.a.a.c;
import a.a.a.a.l;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class i {
    public static final Comparator<File> a;
    private static Boolean b;
    private static final char[] c;
    private static long d;

    static {
        c = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        d = -1L;
        a = new Comparator<File>(){

            public int a(File file, File file2) {
                return (int)(file.lastModified() - file2.lastModified());
            }

            public /* synthetic */ int compare(Object object, Object object2) {
                return this.a((File)object, (File)object2);
            }
        };
    }

    public static int a(Context context, String string, String string2) {
        return context.getResources().getIdentifier(string, string2, i.d(context));
    }

    public static SharedPreferences a(Context context) {
        return context.getSharedPreferences("com.crashlytics.prefs", 0);
    }

    public static String a(InputStream inputStream) throws IOException {
        Scanner scanner = new Scanner(inputStream).useDelimiter("\\A");
        if (scanner.hasNext()) {
            return scanner.next();
        }
        return "";
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static String a(InputStream inputStream, String string) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance((String)"SHA-1");
            byte[] arrby = new byte[1024];
            do {
                int n2;
                if ((n2 = inputStream.read(arrby)) == -1) {
                    return i.a(messageDigest.digest());
                }
                messageDigest.update(arrby, 0, n2);
            } while (true);
        }
        catch (Exception exception) {
            c.h().d("Fabric", "Could not calculate hash for app icon.", exception);
            return "";
        }
    }

    public static String a(String string) {
        return i.a(string, "SHA-1");
    }

    private static String a(String string, String string2) {
        return i.a(string.getBytes(), string2);
    }

    public static String a(byte[] arrby) {
        char[] arrc = new char[2 * arrby.length];
        for (int i2 = 0; i2 < arrby.length; ++i2) {
            int n2 = 255 & arrby[i2];
            int n3 = i2 * 2;
            arrc[n3] = c[n2 >>> 4];
            arrc[n3 + 1] = c[n2 & 15];
        }
        return new String(arrc);
    }

    private static String a(byte[] arrby, String string) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance((String)string);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            l l2 = c.h();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Could not create hashing algorithm: ");
            stringBuilder.append(string);
            stringBuilder.append(", returning empty string.");
            l2.d("Fabric", stringBuilder.toString(), noSuchAlgorithmException);
            return "";
        }
        messageDigest.update(arrby);
        return i.a(messageDigest.digest());
    }

    public static /* varargs */ String a(String ... arrstring) {
        String string = null;
        if (arrstring != null) {
            if (arrstring.length == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (String string2 : arrstring) {
                if (string2 == null) continue;
                arrayList.add((Object)string2.replace((CharSequence)"-", (CharSequence)"").toLowerCase(Locale.US));
            }
            Collections.sort((List)arrayList);
            StringBuilder stringBuilder = new StringBuilder();
            Iterator iterator = arrayList.iterator();
            while (iterator.hasNext()) {
                stringBuilder.append((String)iterator.next());
            }
            String string3 = stringBuilder.toString();
            int n2 = string3.length();
            string = null;
            if (n2 > 0) {
                string = i.a(string3);
            }
        }
        return string;
    }

    public static void a(Context context, int n2, String string, String string2) {
        if (i.b(context)) {
            c.h().a(n2, "Fabric", string2);
        }
    }

    public static void a(Context context, String string) {
        if (i.b(context)) {
            c.h().a("Fabric", string);
        }
    }

    public static void a(Context context, String string, Throwable throwable) {
        if (i.b(context)) {
            c.h().d("Fabric", string);
        }
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

    public static void a(Closeable closeable, String string) {
        if (closeable != null) {
            try {
                closeable.close();
                return;
            }
            catch (IOException iOException) {
                c.h().d("Fabric", string, iOException);
            }
        }
    }

    public static void a(InputStream inputStream, OutputStream outputStream, byte[] arrby) throws IOException {
        int n2;
        while ((n2 = inputStream.read(arrby)) != -1) {
            outputStream.write(arrby, 0, n2);
        }
    }

    public static boolean a(Context context, String string, boolean bl) {
        Resources resources;
        if (context != null && (resources = context.getResources()) != null) {
            int n2 = i.a(context, string, "bool");
            if (n2 > 0) {
                return resources.getBoolean(n2);
            }
            int n3 = i.a(context, string, "string");
            if (n3 > 0) {
                return Boolean.parseBoolean((String)context.getString(n3));
            }
        }
        return bl;
    }

    public static String b(Context context, String string) {
        int n2 = i.a(context, string, "string");
        if (n2 > 0) {
            return context.getString(n2);
        }
        return "";
    }

    public static String b(InputStream inputStream) {
        return i.a(inputStream, "SHA-1");
    }

    public static boolean b(Context context) {
        if (b == null) {
            b = i.a(context, "com.crashlytics.Trace", false);
        }
        return b;
    }

    public static boolean b(String string) {
        return string == null || string.length() == 0;
        {
        }
    }

    public static boolean c(Context context) {
        return (2 & context.getApplicationInfo().flags) != 0;
    }

    public static String d(Context context) {
        int n2 = context.getApplicationContext().getApplicationInfo().icon;
        if (n2 > 0) {
            return context.getResources().getResourcePackageName(n2);
        }
        return context.getPackageName();
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static String e(Context context) {
        InputStream inputStream;
        Throwable throwable;
        block8 : {
            block7 : {
                String string;
                inputStream = context.getResources().openRawResource(i.f(context));
                try {
                    String string2 = i.b(inputStream);
                    boolean bl = i.b(string2);
                    string = bl ? null : string2;
                }
                catch (Exception exception) {
                    break block7;
                }
                i.a((Closeable)inputStream, "Failed to close icon input stream.");
                return string;
                catch (Throwable throwable2) {
                    throwable = throwable2;
                    inputStream = null;
                    break block8;
                }
                catch (Exception exception) {
                    inputStream = null;
                }
            }
            try {
                void var1_7;
                c.h().d("Fabric", "Could not calculate hash for app icon.", (Throwable)var1_7);
            }
            catch (Throwable throwable3) {
                // empty catch block
            }
            i.a((Closeable)inputStream, "Failed to close icon input stream.");
            return null;
        }
        i.a((Closeable)inputStream, "Failed to close icon input stream.");
        throw throwable;
    }

    public static int f(Context context) {
        return context.getApplicationContext().getApplicationInfo().icon;
    }

    public static String g(Context context) {
        int n2 = i.a(context, "io.fabric.android.build_id", "string");
        if (n2 == 0) {
            n2 = i.a(context, "com.crashlytics.android.build_id", "string");
        }
        if (n2 != 0) {
            String string = context.getResources().getString(n2);
            l l2 = c.h();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Build ID is: ");
            stringBuilder.append(string);
            l2.a("Fabric", stringBuilder.toString());
            return string;
        }
        return null;
    }

}

