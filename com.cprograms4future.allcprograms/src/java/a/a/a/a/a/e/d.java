/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  a.a.a.a.a.e.d$1
 *  a.a.a.a.a.e.d$c$1
 *  java.io.BufferedInputStream
 *  java.io.BufferedOutputStream
 *  java.io.ByteArrayOutputStream
 *  java.io.Closeable
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.io.UnsupportedEncodingException
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.NullPointerException
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.net.HttpURLConnection
 *  java.net.InetSocketAddress
 *  java.net.MalformedURLException
 *  java.net.Proxy
 *  java.net.Proxy$Type
 *  java.net.SocketAddress
 *  java.net.URI
 *  java.net.URISyntaxException
 *  java.net.URL
 *  java.nio.ByteBuffer
 *  java.nio.CharBuffer
 *  java.nio.charset.Charset
 *  java.nio.charset.CharsetEncoder
 *  java.util.Iterator
 *  java.util.Locale
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.concurrent.Callable
 *  java.util.zip.GZIPInputStream
 */
package a.a.a.a.a.e;

import a.a.a.a.a.e.d;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.zip.GZIPInputStream;

public class d {
    private static final String[] b = new String[0];
    private static c c = c.a;
    public final URL a;
    private HttpURLConnection d = null;
    private final String e;
    private f f;
    private boolean g;
    private boolean h = true;
    private boolean i = false;
    private int j = 8192;
    private String k;
    private int l;

    public d(CharSequence charSequence, String string) throws d {
        try {
            this.a = new URL(charSequence.toString());
        }
        catch (MalformedURLException malformedURLException) {
            throw new d((IOException)((Object)malformedURLException));
        }
        this.e = string;
    }

    static /* synthetic */ int a(d d2) {
        return d2.j;
    }

    public static d a(CharSequence charSequence, Map<?, ?> map, boolean bl) {
        String string = d.a(charSequence, map);
        if (bl) {
            string = d.a(string);
        }
        return d.b(string);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String a(CharSequence charSequence) throws d {
        URL uRL;
        try {
            uRL = new URL(charSequence.toString());
        }
        catch (IOException iOException) {
            throw new d(iOException);
        }
        String string2 = uRL.getHost();
        int n3 = uRL.getPort();
        if (n3 != -1) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(':');
            stringBuilder.append(Integer.toString((int)n3));
            string2 = stringBuilder.toString();
        }
        String string3 = string2;
        try {
            URI uRI = new URI(uRL.getProtocol(), string3, uRL.getPath(), uRL.getQuery(), null);
            String string = uRI.toASCIIString();
            int n2 = string.indexOf(63);
            if (n2 <= 0) return string;
            int n4 = n2 + 1;
            if (n4 >= string.length()) return string;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string.substring(0, n4));
            stringBuilder.append(string.substring(n4).replace((CharSequence)"+", (CharSequence)"%2B"));
            return stringBuilder.toString();
        }
        catch (URISyntaxException uRISyntaxException) {
            iOException = new IOException("Parsing URI failed");
            iOException.initCause((Throwable)uRISyntaxException);
            throw new d(iOException);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static String a(CharSequence var0, Map<?, ?> var1_1) {
        var2_2 = var0.toString();
        if (var1_1 == null) return var2_2;
        if (var1_1.isEmpty()) {
            return var2_2;
        }
        var3_3 = new StringBuilder(var2_2);
        d.a(var2_2, var3_3);
        d.b(var2_2, var3_3);
        var6_4 = var1_1.entrySet().iterator();
        var7_5 = (Map.Entry)var6_4.next();
        var3_3.append(var7_5.getKey().toString());
        var3_3.append('=');
        var10_6 = var7_5.getValue();
        if (var10_6 == null) ** GOTO lbl16
        do {
            var3_3.append(var10_6);
lbl16: // 2 sources:
            do {
                if (!var6_4.hasNext()) {
                    return var3_3.toString();
                }
                var3_3.append('&');
                var12_7 = (Map.Entry)var6_4.next();
                var3_3.append(var12_7.getKey().toString());
                var3_3.append('=');
            } while ((var10_6 = var12_7.getValue()) == null);
        } while (true);
    }

    private static StringBuilder a(String string, StringBuilder stringBuilder) {
        if (2 + string.indexOf(58) == string.lastIndexOf(47)) {
            stringBuilder.append('/');
        }
        return stringBuilder;
    }

    public static d b(CharSequence charSequence) throws d {
        return new d(charSequence, "GET");
    }

    public static d b(CharSequence charSequence, Map<?, ?> map, boolean bl) {
        String string = d.a(charSequence, map);
        if (bl) {
            string = d.a(string);
        }
        return d.c(string);
    }

    /*
     * Enabled aggressive block sorting
     */
    private static StringBuilder b(String string, StringBuilder stringBuilder) {
        char c2;
        char c3 = '?';
        int n2 = string.indexOf((int)c3);
        int n3 = -1 + stringBuilder.length();
        if (n2 == -1 || n2 < n3 && (c2 = string.charAt(n3)) != (c3 = '&')) {
            stringBuilder.append(c3);
            return stringBuilder;
        }
        return stringBuilder;
    }

    public static d c(CharSequence charSequence) throws d {
        return new d(charSequence, "POST");
    }

    public static d d(CharSequence charSequence) throws d {
        return new d(charSequence, "PUT");
    }

    public static d e(CharSequence charSequence) throws d {
        return new d(charSequence, "DELETE");
    }

    private static String f(String string) {
        if (string != null && string.length() > 0) {
            return string;
        }
        return "UTF-8";
    }

    private Proxy p() {
        return new Proxy(Proxy.Type.HTTP, (SocketAddress)new InetSocketAddress(this.k, this.l));
    }

    private HttpURLConnection q() {
        try {
            HttpURLConnection httpURLConnection = this.k != null ? c.a(this.a, this.p()) : c.a(this.a);
            httpURLConnection.setRequestMethod(this.e);
            return httpURLConnection;
        }
        catch (IOException iOException) {
            throw new d(iOException);
        }
    }

    public int a(String string, int n2) throws d {
        this.k();
        return this.a().getHeaderFieldInt(string, n2);
    }

    public d a(int n2) {
        this.a().setConnectTimeout(n2);
        return this;
    }

    protected d a(InputStream inputStream, OutputStream outputStream) throws IOException {
        1 var3_3 = new 1(this, (Closeable)inputStream, this.h, inputStream, outputStream);
        return (d)var3_3.call();
    }

    public d a(String string, Number number) throws d {
        return this.a(string, null, number);
    }

    public d a(String string, String string2) {
        this.a().setRequestProperty(string, string2);
        return this;
    }

    public d a(String string, String string2, Number number) throws d {
        String string3 = number != null ? number.toString() : null;
        return this.b(string, string2, string3);
    }

    protected d a(String string, String string2, String string3) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("form-data; name=\"");
        stringBuilder.append(string);
        if (string2 != null) {
            stringBuilder.append("\"; filename=\"");
            stringBuilder.append(string2);
        }
        stringBuilder.append('\"');
        this.f("Content-Disposition", stringBuilder.toString());
        if (string3 != null) {
            this.f("Content-Type", string3);
        }
        return this.f("\r\n");
    }

    public d a(String string, String string2, String string3, InputStream inputStream) throws d {
        try {
            this.m();
            this.a(string, string2, string3);
            this.a(inputStream, (OutputStream)this.f);
            return this;
        }
        catch (IOException iOException) {
            throw new d(iOException);
        }
    }

    public d a(String string, String string2, String string3, String string4) throws d {
        try {
            this.m();
            this.a(string, string2, string3);
            this.f.a(string4);
            return this;
        }
        catch (IOException iOException) {
            throw new d(iOException);
        }
    }

    public d a(boolean bl) {
        this.a().setUseCaches(bl);
        return this;
    }

    public String a(String string) throws d {
        ByteArrayOutputStream byteArrayOutputStream = this.c();
        try {
            this.a((InputStream)this.e(), (OutputStream)byteArrayOutputStream);
            String string2 = byteArrayOutputStream.toString(d.f(string));
            return string2;
        }
        catch (IOException iOException) {
            throw new d(iOException);
        }
    }

    public HttpURLConnection a() {
        if (this.d == null) {
            this.d = this.q();
        }
        return this.d;
    }

    public int b() throws d {
        try {
            this.j();
            int n2 = this.a().getResponseCode();
            return n2;
        }
        catch (IOException iOException) {
            throw new d(iOException);
        }
    }

    public d b(String string, String string2, String string3) throws d {
        return this.a(string, string2, null, string3);
    }

    public String b(String string) throws d {
        this.k();
        return this.a().getHeaderField(string);
    }

    public String b(String string, String string2) {
        return this.c(this.b(string), string2);
    }

    public int c(String string) throws d {
        return this.a(string, -1);
    }

    protected ByteArrayOutputStream c() {
        int n2 = this.i();
        if (n2 > 0) {
            return new ByteArrayOutputStream(n2);
        }
        return new ByteArrayOutputStream();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    protected String c(String var1_1, String var2_2) {
        if (var1_1 == null) return null;
        if (var1_1.length() == 0) {
            return null;
        }
        var3_3 = var1_1.length();
        var4_4 = 1 + var1_1.indexOf(59);
        if (var4_4 == 0) return null;
        if (var4_4 == var3_3) {
            return null;
        }
        var5_5 = var1_1.indexOf(59, var4_4);
        if (var5_5 != -1) ** GOTO lbl13
        do {
            var5_5 = var3_3;
lbl13: // 2 sources:
            do {
                if (var4_4 >= var5_5) return null;
                var6_6 = var1_1.indexOf(61, var4_4);
                if (var6_6 != -1 && var6_6 < var5_5 && var2_2.equals((Object)var1_1.substring(var4_4, var6_6).trim()) && (var8_8 = (var7_7 = var1_1.substring(var6_6 + 1, var5_5).trim()).length()) != 0) {
                    if (var8_8 <= 2) return var7_7;
                    if ('\"' != var7_7.charAt(0)) return var7_7;
                    var9_9 = var8_8 - 1;
                    if ('\"' != var7_7.charAt(var9_9)) return var7_7;
                    return var7_7.substring(1, var9_9);
                }
                var4_4 = var5_5 + 1;
            } while ((var5_5 = var1_1.indexOf(59, var4_4)) != -1);
        } while (true);
    }

    public d d(String string) {
        return this.d(string, null);
    }

    public d d(String string, String string2) {
        if (string2 != null && string2.length() > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append("; charset=");
            stringBuilder.append(string2);
            return this.a("Content-Type", stringBuilder.toString());
        }
        return this.a("Content-Type", string);
    }

    public String d() throws d {
        return this.a(this.g());
    }

    public d e(String string, String string2) {
        return this.b(string, null, string2);
    }

    public BufferedInputStream e() throws d {
        return new BufferedInputStream(this.f(), this.j);
    }

    public d f(CharSequence charSequence) throws d {
        try {
            this.l();
            this.f.a(charSequence.toString());
            return this;
        }
        catch (IOException iOException) {
            throw new d(iOException);
        }
    }

    public d f(String string, String string2) throws d {
        return this.f(string).f(": ").f(string2).f("\r\n");
    }

    public InputStream f() throws d {
        InputStream inputStream;
        if (this.b() < 400) {
            try {
                inputStream = this.a().getInputStream();
            }
            catch (IOException iOException) {
                throw new d(iOException);
            }
        }
        inputStream = this.a().getErrorStream();
        if (inputStream == null) {
            try {
                inputStream = this.a().getInputStream();
            }
            catch (IOException iOException) {
                throw new d(iOException);
            }
        }
        if (this.i) {
            if (!"gzip".equals((Object)this.h())) {
                return inputStream;
            }
            try {
                GZIPInputStream gZIPInputStream = new GZIPInputStream(inputStream);
                return gZIPInputStream;
            }
            catch (IOException iOException) {
                throw new d(iOException);
            }
        }
        return inputStream;
    }

    public String g() {
        return this.b("Content-Type", "charset");
    }

    public String h() {
        return this.b("Content-Encoding");
    }

    public int i() {
        return this.c("Content-Length");
    }

    /*
     * Exception decompiling
     */
    protected d j() throws IOException {
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

    protected d k() throws d {
        try {
            d d2 = this.j();
            return d2;
        }
        catch (IOException iOException) {
            throw new d(iOException);
        }
    }

    protected d l() throws IOException {
        if (this.f != null) {
            return this;
        }
        this.a().setDoOutput(true);
        String string = this.c(this.a().getRequestProperty("Content-Type"), "charset");
        this.f = new f(this.a().getOutputStream(), string, this.j);
        return this;
    }

    /*
     * Enabled aggressive block sorting
     */
    protected d m() throws IOException {
        f f2;
        String string;
        if (!this.g) {
            this.g = true;
            this.d("multipart/form-data; boundary=00content0boundary00").l();
            f2 = this.f;
            string = "--00content0boundary00\r\n";
        } else {
            f2 = this.f;
            string = "\r\n--00content0boundary00\r\n";
        }
        f2.a(string);
        return this;
    }

    public URL n() {
        return this.a().getURL();
    }

    public String o() {
        return this.a().getRequestMethod();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.o());
        stringBuilder.append(' ');
        stringBuilder.append((Object)this.n());
        return stringBuilder.toString();
    }

    public static class a {
        private static final byte[] a = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

        /*
         * Exception decompiling
         */
        public static String a(String var0) {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl9 : ALOAD_1 : trying to set 1 previously set to 0
            // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
            // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
            // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
            // org.benf.cfr.reader.entities.g.p(Method.java:396)
            // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
            // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
            // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
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

        public static String a(byte[] arrby) {
            return a.a(arrby, 0, arrby.length);
        }

        public static String a(byte[] arrby, int n2, int n3) {
            byte[] arrby2 = a.b(arrby, n2, n3);
            try {
                String string = new String(arrby2, "US-ASCII");
                return string;
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                return new String(arrby2);
            }
        }

        private static byte[] a(byte[] arrby, int n2, int n3, byte[] arrby2, int n4) {
            byte[] arrby3 = a;
            int n5 = n3 > 0 ? arrby[n2] << 24 >>> 8 : 0;
            int n6 = n3 > 1 ? arrby[n2 + 1] << 24 >>> 16 : 0;
            int n7 = n5 | n6;
            int n8 = 0;
            if (n3 > 2) {
                n8 = arrby[n2 + 2] << 24 >>> 24;
            }
            int n9 = n7 | n8;
            switch (n3) {
                default: {
                    return arrby2;
                }
                case 3: {
                    arrby2[n4] = arrby3[n9 >>> 18];
                    arrby2[n4 + 1] = arrby3[63 & n9 >>> 12];
                    arrby2[n4 + 2] = arrby3[63 & n9 >>> 6];
                    arrby2[n4 + 3] = arrby3[n9 & 63];
                    return arrby2;
                }
                case 2: {
                    arrby2[n4] = arrby3[n9 >>> 18];
                    arrby2[n4 + 1] = arrby3[63 & n9 >>> 12];
                    arrby2[n4 + 2] = arrby3[63 & n9 >>> 6];
                    arrby2[n4 + 3] = 61;
                    return arrby2;
                }
                case 1: 
            }
            arrby2[n4] = arrby3[n9 >>> 18];
            arrby2[n4 + 1] = arrby3[63 & n9 >>> 12];
            arrby2[n4 + 2] = 61;
            arrby2[n4 + 3] = 61;
            return arrby2;
        }

        public static byte[] b(byte[] arrby, int n2, int n3) {
            if (arrby != null) {
                if (n2 >= 0) {
                    if (n3 >= 0) {
                        if (n2 + n3 <= arrby.length) {
                            int n4 = n3 / 3;
                            int n5 = 4;
                            int n6 = n4 * 4;
                            if (n3 % 3 <= 0) {
                                n5 = 0;
                            }
                            byte[] arrby2 = new byte[n6 + n5];
                            int n7 = n3 - 2;
                            int n8 = 0;
                            int n9 = 0;
                            while (n8 < n7) {
                                a.a(arrby, n8 + n2, 3, arrby2, n9);
                                n8 += 3;
                                n9 += 4;
                            }
                            if (n8 < n3) {
                                a.a(arrby, n2 + n8, n3 - n8, arrby2, n9);
                                n9 += 4;
                            }
                            if (n9 <= arrby2.length - 1) {
                                byte[] arrby3 = new byte[n9];
                                System.arraycopy((Object)arrby2, (int)0, (Object)arrby3, (int)0, (int)n9);
                                return arrby3;
                            }
                            return arrby2;
                        }
                        Locale locale = Locale.ENGLISH;
                        Object[] arrobject = new Object[]{n2, n3, arrby.length};
                        throw new IllegalArgumentException(String.format((Locale)locale, (String)"Cannot have offset of %d and length of %d with array of length %d", (Object[])arrobject));
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Cannot have length offset: ");
                    stringBuilder.append(n3);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Cannot have negative offset: ");
                stringBuilder.append(n2);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            throw new NullPointerException("Cannot serialize a null array.");
        }
    }

    public static interface c {
        public static final c a = new 1();

        public HttpURLConnection a(URL var1) throws IOException;

        public HttpURLConnection a(URL var1, Proxy var2) throws IOException;
    }

    public static class d
    extends RuntimeException {
        protected d(IOException iOException) {
            super((Throwable)iOException);
        }

        public IOException a() {
            return (IOException)super.getCause();
        }

        public /* synthetic */ Throwable getCause() {
            return this.a();
        }
    }

    protected static abstract class e<V>
    implements Callable<V> {
        protected e() {
        }

        protected abstract V b() throws d, IOException;

        protected abstract void c() throws IOException;

        /*
         * Loose catch block
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Lifted jumps to return sites
         */
        public V call() throws d {
            Throwable throwable;
            boolean bl = true;
            V v2 = this.b();
            try {
                this.c();
            }
            catch (IOException iOException) {
                throw new d(iOException);
            }
            return v2;
            catch (Throwable throwable2) {
                throwable = throwable2;
                bl = false;
            }
            catch (IOException iOException) {
                try {
                    throw new d(iOException);
                    catch (d d2) {
                        throw d2;
                    }
                }
                catch (Throwable throwable3) {
                    // empty catch block
                }
            }
            try {
                this.c();
                throw throwable;
            }
            catch (IOException iOException) {
                if (bl) throw throwable;
                throw new d(iOException);
            }
        }
    }

    public static class f
    extends BufferedOutputStream {
        private final CharsetEncoder a;

        public f(OutputStream outputStream, String string, int n2) {
            super(outputStream, n2);
            this.a = Charset.forName((String)d.f(string)).newEncoder();
        }

        public f a(String string) throws IOException {
            ByteBuffer byteBuffer = this.a.encode(CharBuffer.wrap((CharSequence)string));
            super.write(byteBuffer.array(), 0, byteBuffer.limit());
            return this;
        }
    }

}

