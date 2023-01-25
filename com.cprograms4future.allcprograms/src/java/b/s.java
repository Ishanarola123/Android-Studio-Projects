/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.c
 *  java.lang.AssertionError
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.net.InetAddress
 *  java.net.URI
 *  java.net.URISyntaxException
 *  java.net.UnknownHostException
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.List
 */
package b;

import b.a.i;
import c.c;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class s {
    private static final char[] a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final int f;
    private final List<String> g;
    private final List<String> h;
    private final String i;
    private final String j;

    private s(a a2) {
        this.b = a2.a;
        this.c = s.a(a2.b, false);
        this.d = s.a(a2.c, false);
        this.e = a2.d;
        this.f = a2.a();
        this.g = this.a(a2.f, false);
        List<String> list = a2.g != null ? this.a(a2.g, true) : null;
        this.h = list;
        String string = a2.h;
        String string2 = null;
        if (string != null) {
            string2 = s.a(a2.h, false);
        }
        this.i = string2;
        this.j = a2.toString();
    }

    /*
     * Enabled aggressive block sorting
     */
    static int a(char n2) {
        if (n2 >= 48 && n2 <= 57) {
            return n2 - 48;
        }
        int n3 = 97;
        if (n2 >= n3 && n2 <= 102) {
            return 10 + (n2 - n3);
        }
        n3 = 65;
        if (n2 < n3) return -1;
        if (n2 > 70) return -1;
        return 10 + (n2 - n3);
    }

    public static int a(String string) {
        if (string.equals((Object)"http")) {
            return 80;
        }
        if (string.equals((Object)"https")) {
            return 443;
        }
        return -1;
    }

    static /* synthetic */ String a(s s2) {
        return s2.b;
    }

    static String a(String string, int n2, int n3, String string2, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        int n4;
        for (int i2 = n2; i2 < n3; i2 += Character.charCount((int)n4)) {
            n4 = string.codePointAt(i2);
            if (!(n4 < 32 || n4 == 127 || n4 >= 128 && bl4 || string2.indexOf(n4) != -1 || n4 == 37 && (!bl || bl2 && !s.a(string, i2, n3)) || n4 == 43 && bl3)) {
                continue;
            }
            c c2 = new c();
            c2.a(string, n2, i2);
            s.a(c2, string, i2, n3, string2, bl, bl2, bl3, bl4);
            return c2.q();
        }
        return string.substring(n2, n3);
    }

    static String a(String string, int n2, int n3, boolean bl) {
        for (int i2 = n2; i2 < n3; ++i2) {
            char c2 = string.charAt(i2);
            if (!(c2 == '%' || c2 == '+' && bl)) {
                continue;
            }
            c c3 = new c();
            c3.a(string, n2, i2);
            s.a(c3, string, i2, n3, bl);
            return c3.q();
        }
        return string.substring(n2, n3);
    }

    static String a(String string, String string2, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        return s.a(string, 0, string.length(), string2, bl, bl2, bl3, bl4);
    }

    static String a(String string, boolean bl) {
        return s.a(string, 0, string.length(), bl);
    }

    private List<String> a(List<String> list, boolean bl) {
        ArrayList arrayList = new ArrayList(list.size());
        for (String string : list) {
            String string2 = string != null ? s.a(string, bl) : null;
            arrayList.add((Object)string2);
        }
        return Collections.unmodifiableList((List)arrayList);
    }

    static void a(c c2, String string, int n2, int n3, String string2, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        c c3 = null;
        while (n2 < n3) {
            int n4 = string.codePointAt(n2);
            if (!bl || n4 != 9 && n4 != 10 && n4 != 12 && n4 != 13) {
                if (n4 == 43 && bl3) {
                    String string3 = bl ? "+" : "%2B";
                    c2.a(string3);
                } else if (!(n4 < 32 || n4 == 127 || n4 >= 128 && bl4 || string2.indexOf(n4) != -1 || n4 == 37 && (!bl || bl2 && !s.a(string, n2, n3)))) {
                    c2.a(n4);
                } else {
                    if (c3 == null) {
                        c3 = new c();
                    }
                    c3.a(n4);
                    while (!c3.g()) {
                        int n5 = 255 & c3.j();
                        c2.b(37);
                        c2.b((int)a[15 & n5 >> 4]);
                        c2.b((int)a[n5 & 15]);
                    }
                }
            }
            n2 += Character.charCount((int)n4);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    static void a(c var0, String var1_1, int var2_2, int var3_3, boolean var4_4) {
        while (var2_2 < var3_3) {
            block4 : {
                block3 : {
                    var5_5 = var1_1.codePointAt(var2_2);
                    if (var5_5 != 37 || (var8_6 = var2_2 + 2) >= var3_3) break block3;
                    var9_7 = s.a(var1_1.charAt(var2_2 + 1));
                    var10_8 = s.a(var1_1.charAt(var8_6));
                    if (var9_7 == -1 || var10_8 == -1) ** GOTO lbl-1000
                    var0.b(var10_8 + (var9_7 << 4));
                    var2_2 = var8_6;
                    break block4;
                }
                if (var5_5 == 43 && var4_4) {
                    var0.b(32);
                } else lbl-1000: // 2 sources:
                {
                    var0.a(var5_5);
                }
            }
            var2_2 += Character.charCount((int)var5_5);
        }
    }

    static void a(StringBuilder stringBuilder, List<String> list) {
        int n2 = list.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            stringBuilder.append('/');
            stringBuilder.append((String)list.get(i2));
        }
    }

    static boolean a(String string, int n2, int n3) {
        int n4 = n2 + 2;
        return n4 < n3 && string.charAt(n2) == '%' && s.a(string.charAt(n2 + 1)) != -1 && s.a(string.charAt(n4)) != -1;
    }

    static /* synthetic */ String b(s s2) {
        return s2.e;
    }

    static List<String> b(String string) {
        ArrayList arrayList = new ArrayList();
        int n2 = 0;
        while (n2 <= string.length()) {
            String string2;
            int n3;
            int n4 = string.indexOf(38, n2);
            if (n4 == -1) {
                n4 = string.length();
            }
            if ((n3 = string.indexOf(61, n2)) != -1 && n3 <= n4) {
                arrayList.add((Object)string.substring(n2, n3));
                string2 = string.substring(n3 + 1, n4);
            } else {
                arrayList.add((Object)string.substring(n2, n4));
                string2 = null;
            }
            arrayList.add(string2);
            n2 = n4 + 1;
        }
        return arrayList;
    }

    static void b(StringBuilder stringBuilder, List<String> list) {
        int n2 = list.size();
        for (int i2 = 0; i2 < n2; i2 += 2) {
            String string = (String)list.get(i2);
            String string2 = (String)list.get(i2 + 1);
            if (i2 > 0) {
                stringBuilder.append('&');
            }
            stringBuilder.append(string);
            if (string2 == null) continue;
            stringBuilder.append('=');
            stringBuilder.append(string2);
        }
    }

    static /* synthetic */ int c(s s2) {
        return s2.f;
    }

    public static s e(String string) {
        a a2 = new a();
        a.a a3 = a2.a((s)null, string);
        a.a a4 = a.a.a;
        s s2 = null;
        if (a3 == a4) {
            s2 = a2.c();
        }
        return s2;
    }

    public String a(int n2) {
        return (String)this.h.get(n2 * 2);
    }

    public URI a() {
        String string = this.o().b().toString();
        try {
            URI uRI = new URI(string);
            return uRI;
        }
        catch (URISyntaxException uRISyntaxException) {
            try {
                URI uRI = URI.create((String)string.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
                return uRI;
            }
            catch (Exception exception) {
                throw new RuntimeException((Throwable)uRISyntaxException);
            }
        }
    }

    public String b() {
        return this.b;
    }

    public String b(int n2) {
        return (String)this.h.get(1 + n2 * 2);
    }

    public s c(String string) {
        a a2 = this.d(string);
        if (a2 != null) {
            return a2.c();
        }
        return null;
    }

    public boolean c() {
        return this.b.equals((Object)"https");
    }

    public a d(String string) {
        a a2 = new a();
        if (a2.a(this, string) == a.a.a) {
            return a2;
        }
        return null;
    }

    public String d() {
        if (this.c.isEmpty()) {
            return "";
        }
        int n2 = 3 + this.b.length();
        int n3 = i.a(this.j, n2, this.j.length(), ":@");
        return this.j.substring(n2, n3);
    }

    public String e() {
        if (this.d.isEmpty()) {
            return "";
        }
        int n2 = 1 + this.j.indexOf(58, 3 + this.b.length());
        int n3 = this.j.indexOf(64);
        return this.j.substring(n2, n3);
    }

    public boolean equals(Object object) {
        return object instanceof s && ((s)object).j.equals((Object)this.j);
    }

    public String f() {
        return this.e;
    }

    public int g() {
        return this.f;
    }

    public String h() {
        int n2 = this.j.indexOf(47, 3 + this.b.length());
        int n3 = i.a(this.j, n2, this.j.length(), "?#");
        return this.j.substring(n2, n3);
    }

    public int hashCode() {
        return this.j.hashCode();
    }

    public List<String> i() {
        int n2 = this.j.indexOf(47, 3 + this.b.length());
        int n3 = i.a(this.j, n2, this.j.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (n2 < n3) {
            int n4 = n2 + 1;
            int n5 = i.a(this.j, n4, n3, '/');
            arrayList.add((Object)this.j.substring(n4, n5));
            n2 = n5;
        }
        return arrayList;
    }

    public List<String> j() {
        return this.g;
    }

    public String k() {
        if (this.h == null) {
            return null;
        }
        int n2 = 1 + this.j.indexOf(63);
        int n3 = i.a(this.j, n2 + 1, this.j.length(), '#');
        return this.j.substring(n2, n3);
    }

    public String l() {
        if (this.h == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        s.b(stringBuilder, this.h);
        return stringBuilder.toString();
    }

    public int m() {
        if (this.h != null) {
            return this.h.size() / 2;
        }
        return 0;
    }

    public String n() {
        if (this.i == null) {
            return null;
        }
        int n2 = 1 + this.j.indexOf(35);
        return this.j.substring(n2);
    }

    public a o() {
        a a2 = new a();
        a2.a = this.b;
        a2.b = this.d();
        a2.c = this.e();
        a2.d = this.e;
        int n2 = this.f != s.a(this.b) ? this.f : -1;
        a2.e = n2;
        a2.f.clear();
        a2.f.addAll(this.i());
        a2.d(this.k());
        a2.h = this.n();
        return a2;
    }

    public String toString() {
        return this.j;
    }

    public static final class b.s$a {
        String a;
        String b = "";
        String c = "";
        String d;
        int e = -1;
        final List<String> f = new ArrayList();
        List<String> g;
        String h;

        public b.s$a() {
            this.f.add((Object)"");
        }

        private static String a(byte[] arrby) {
            int n2 = 0;
            int n3 = 0;
            int n4 = 0;
            int n5 = -1;
            while (n3 < arrby.length) {
                int n6;
                for (n6 = n3; n6 < 16 && arrby[n6] == 0 && arrby[n6 + 1] == 0; n6 += 2) {
                }
                int n7 = n6 - n3;
                if (n7 > n4) {
                    n5 = n3;
                    n4 = n7;
                }
                n3 = n6 + 2;
            }
            c c2 = new c();
            while (n2 < arrby.length) {
                if (n2 == n5) {
                    c2.b(58);
                    if ((n2 += n4) != 16) continue;
                    c2.b(58);
                    continue;
                }
                if (n2 > 0) {
                    c2.b(58);
                }
                c2.i((long)((255 & arrby[n2]) << 8 | 255 & arrby[n2 + 1]));
                n2 += 2;
            }
            return c2.q();
        }

        private void a(String string, int n2, int n3) {
            int n4;
            if (n2 == n3) {
                return;
            }
            char c2 = string.charAt(n2);
            if (c2 != '/' && c2 != '\\') {
                this.f.set(this.f.size() - 1, (Object)"");
            } else {
                this.f.clear();
                this.f.add((Object)"");
            }
            while ((n4 = ++n2) < n3) {
                n2 = i.a(string, n4, n3, "/\\");
                boolean bl = n2 < n3;
                this.a(string, n4, n2, bl, true);
                if (!bl) continue;
            }
        }

        private void a(String string, int n2, int n3, boolean bl, boolean bl2) {
            String string2 = s.a(string, n2, n3, " \"<>^`{}|/\\?#", bl2, false, false, true);
            if (this.e(string2)) {
                return;
            }
            if (this.f(string2)) {
                this.d();
                return;
            }
            if (((String)this.f.get(-1 + this.f.size())).isEmpty()) {
                this.f.set(-1 + this.f.size(), (Object)string2);
            } else {
                this.f.add((Object)string2);
            }
            if (bl) {
                this.f.add((Object)"");
            }
        }

        private static boolean a(String string, int n2, int n3, byte[] arrby, int n4) {
            int n5 = n4;
            while (n2 < n3) {
                char c2;
                int n6;
                if (n5 == arrby.length) {
                    return false;
                }
                if (n5 != n4 && string.charAt(n2) != '.') {
                    return false;
                }
                int n7 = 0;
                for (n6 = ++n2; n6 < n3 && (c2 = string.charAt(n6)) >= '0' && c2 <= '9'; ++n6) {
                    if (n7 == 0 && n2 != n6) {
                        return false;
                    }
                    if ((n7 = c2 + n7 * 10 - 48) <= 255) continue;
                    return false;
                }
                if (n6 - n2 == 0) {
                    return false;
                }
                int n8 = n5 + 1;
                arrby[n5] = (byte)n7;
                n5 = n8;
                n2 = n6;
            }
            return n5 == n4 + 4;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        private static int b(String string, int n2, int n3) {
            if (n3 - n2 < 2) {
                return -1;
            }
            char c2 = string.charAt(n2);
            if (c2 < 'a' || c2 > 'z') {
                if (c2 < 'A') return -1;
                if (c2 > 'Z') {
                    return -1;
                }
            }
            while (++n2 < n3) {
                char c3 = string.charAt(n2);
                if (c3 >= 'a' && c3 <= 'z' || c3 >= 'A' && c3 <= 'Z' || c3 >= '0' && c3 <= '9' || c3 == '+' || c3 == '-' || c3 == '.') continue;
                if (c3 != ':') return -1;
                return n2;
            }
            return -1;
        }

        private static int c(String string, int n2, int n3) {
            char c2;
            int n4 = 0;
            while (n2 < n3 && ((c2 = string.charAt(n2)) == '\\' || c2 == '/')) {
                ++n4;
                ++n2;
            }
            return n4;
        }

        private static int d(String string, int n2, int n3) {
            while (n2 < n3) {
                char c2 = string.charAt(n2);
                if (c2 != ':') {
                    if (c2 == '[') {
                        while (++n2 < n3 && string.charAt(n2) != ']') {
                        }
                    }
                    ++n2;
                    continue;
                }
                return n2;
            }
            return n3;
        }

        private void d() {
            if (((String)this.f.remove(-1 + this.f.size())).isEmpty() && !this.f.isEmpty()) {
                this.f.set(-1 + this.f.size(), (Object)"");
                return;
            }
            this.f.add((Object)"");
        }

        private static String e(String string, int n2, int n3) {
            String string2 = s.a(string, n2, n3, false);
            if (string2.contains((CharSequence)":")) {
                InetAddress inetAddress = string2.startsWith("[") && string2.endsWith("]") ? b.s$a.f(string2, 1, string2.length() - 1) : b.s$a.f(string2, 0, string2.length());
                if (inetAddress == null) {
                    return null;
                }
                byte[] arrby = inetAddress.getAddress();
                if (arrby.length == 16) {
                    return b.s$a.a(arrby);
                }
                throw new AssertionError();
            }
            return i.a(string2);
        }

        private boolean e(String string) {
            return string.equals((Object)".") || string.equalsIgnoreCase("%2e");
            {
            }
        }

        private static InetAddress f(String string, int n2, int n3) {
            byte[] arrby = new byte[16];
            int n4 = 0;
            int n5 = -1;
            int n6 = -1;
            while (n2 < n3) {
                int n7;
                if (n4 == arrby.length) {
                    return null;
                }
                int n8 = n2 + 2;
                if (n8 <= n3 && string.regionMatches(n2, "::", 0, 2)) {
                    if (n5 != -1) {
                        return null;
                    }
                    n4 += 2;
                    if (n8 == n3) {
                        n5 = n4;
                        break;
                    }
                    n5 = n4;
                    n6 = n8;
                } else {
                    if (n4 != 0 && !string.regionMatches(n2, ":", 0, 1)) {
                        if (string.regionMatches(n2, ".", 0, 1)) {
                            if (!b.s$a.a(string, n6, n3, arrby, n4 - 2)) {
                                return null;
                            }
                            n4 += 2;
                            break;
                        }
                        return null;
                    }
                    n6 = ++n2;
                }
                int n9 = 0;
                for (n2 = n6; n2 < n3 && (n7 = s.a(string.charAt(n2))) != -1; ++n2) {
                    n9 = n7 + (n9 << 4);
                }
                int n10 = n2 - n6;
                if (n10 != 0) {
                    if (n10 > 4) {
                        return null;
                    }
                    int n11 = n4 + 1;
                    arrby[n4] = (byte)(255 & n9 >>> 8);
                    n4 = n11 + 1;
                    arrby[n11] = (byte)(n9 & 255);
                    continue;
                }
                return null;
            }
            if (n4 != arrby.length) {
                if (n5 == -1) {
                    return null;
                }
                int n12 = arrby.length;
                int n13 = n4 - n5;
                System.arraycopy((Object)arrby, (int)n5, (Object)arrby, (int)(n12 - n13), (int)n13);
                Arrays.fill((byte[])arrby, (int)n5, (int)(n5 + (arrby.length - n4)), (byte)0);
            }
            try {
                InetAddress inetAddress = InetAddress.getByAddress((byte[])arrby);
                return inetAddress;
            }
            catch (UnknownHostException unknownHostException) {
                throw new AssertionError();
            }
        }

        private boolean f(String string) {
            return string.equals((Object)"..") || string.equalsIgnoreCase("%2e.") || string.equalsIgnoreCase(".%2e") || string.equalsIgnoreCase("%2e%2e");
            {
            }
        }

        /*
         * Exception decompiling
         */
        private static int g(String var0, int var1, int var2) {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl19.1 : ICONST_M1 : trying to set 1 previously set to 0
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

        int a() {
            if (this.e != -1) {
                return this.e;
            }
            return s.a(this.a);
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        a a(s var1_1, String var2_2) {
            block20 : {
                block19 : {
                    var3_3 = i.a(var2_2, 0, var2_2.length());
                    if (b.s$a.b(var2_2, var3_3, var4_4 = i.b(var2_2, var3_3, var2_2.length())) != -1) {
                        if (var2_2.regionMatches(true, var3_3, "https:", 0, 6)) {
                            this.a = "https";
                            var30_5 = "https:";
                        } else {
                            if (var2_2.regionMatches(true, var3_3, "http:", 0, 5) == false) return a.c;
                            this.a = "http";
                            var30_5 = "http:";
                        }
                        var3_3 += var30_5.length();
                    } else {
                        if (var1_1 == null) return a.b;
                        this.a = s.a(var1_1);
                    }
                    var5_6 = b.s$a.c(var2_2, var3_3, var4_4);
                    var6_7 = '#';
                    if (var5_6 >= 2 || var1_1 == null || !s.a(var1_1).equals((Object)this.a)) break block19;
                    this.b = var1_1.d();
                    this.c = var1_1.e();
                    this.d = s.b(var1_1);
                    this.e = s.c(var1_1);
                    this.f.clear();
                    this.f.addAll(var1_1.i());
                    if (var3_3 == var4_4 || var2_2.charAt(var3_3) == var6_7) {
                        this.d(var1_1.k());
                    }
                    var12_8 = var3_3;
                    break block20;
                }
                var7_9 = var3_3 + var5_6;
                var8_10 = false;
                var9_11 = false;
                block4 : while ((var11_13 = (var10_12 = i.a(var2_2, var7_9, var4_4, "@/\\?#")) != var4_4 ? (char)var2_2.charAt(var10_12) : '\uffffffff') != '\uffffffff' && var11_13 != var6_7 && var11_13 != '/' && var11_13 != '\\') {
                    switch (var11_13) {
                        default: {
                            ** GOTO lbl59
                        }
                        case '@': {
                            if (!var8_10) {
                                var22_16 = i.a(var2_2, var7_9, var10_12, ':');
                                var17_14 = var10_12;
                                var23_17 = s.a(var2_2, var7_9, var22_16, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                                if (var9_11) {
                                    var24_18 = new StringBuilder();
                                    var24_18.append(this.b);
                                    var24_18.append("%40");
                                    var24_18.append(var23_17);
                                    var23_17 = var24_18.toString();
                                }
                                this.b = var23_17;
                                if (var22_16 != var17_14) {
                                    this.c = s.a(var2_2, var22_16 + 1, var17_14, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                                    var8_10 = true;
                                }
                                var9_11 = true;
                            } else {
                                var17_14 = var10_12;
                                var18_15 = new StringBuilder();
                                var18_15.append(this.c);
                                var18_15.append("%40");
                                var18_15.append(s.a(var2_2, var7_9, var17_14, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true));
                                this.c = var18_15.toString();
                            }
                            var7_9 = var17_14 + 1;
lbl59: // 2 sources:
                            var6_7 = '#';
                            continue block4;
                        }
                        case '?': {
                            break block4;
                        }
                    }
                }
                if ((var14_20 = (var13_19 = b.s$a.d(var2_2, var7_9, var12_8 = var10_12)) + 1) < var12_8) {
                    this.d = b.s$a.e(var2_2, var7_9, var13_19);
                    this.e = b.s$a.g(var2_2, var14_20, var12_8);
                    if (this.e == -1) {
                        return a.d;
                    }
                } else {
                    this.d = b.s$a.e(var2_2, var7_9, var13_19);
                    this.e = s.a(this.a);
                }
                if (this.d == null) {
                    return a.e;
                }
            }
            var15_21 = i.a(var2_2, var12_8, var4_4, "?#");
            this.a(var2_2, var12_8, var15_21);
            if (var15_21 < var4_4 && var2_2.charAt(var15_21) == '?') {
                var16_22 = i.a(var2_2, var15_21, var4_4, '#');
                this.g = s.b(s.a(var2_2, var15_21 + 1, var16_22, " \"'<>#", true, false, true, true));
                var15_21 = var16_22;
            }
            if (var15_21 >= var4_4) return a.a;
            if (var2_2.charAt(var15_21) != '#') return a.a;
            this.h = s.a(var2_2, 1 + var15_21, var4_4, "", true, false, false, false);
            return a.a;
        }

        public b.s$a a(int n2) {
            if (n2 > 0 && n2 <= 65535) {
                this.e = n2;
                return this;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("unexpected port: ");
            stringBuilder.append(n2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }

        /*
         * Enabled aggressive block sorting
         */
        public b.s$a a(String string) {
            String string2;
            if (string == null) {
                throw new IllegalArgumentException("scheme == null");
            }
            if (string.equalsIgnoreCase("http")) {
                string2 = "http";
            } else {
                if (!string.equalsIgnoreCase("https")) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("unexpected scheme: ");
                    stringBuilder.append(string);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
                string2 = "https";
            }
            this.a = string2;
            return this;
        }

        public b.s$a a(String string, String string2) {
            if (string != null) {
                if (this.g == null) {
                    this.g = new ArrayList();
                }
                this.g.add((Object)s.a(string, " \"'<>#&=", false, false, true, true));
                List<String> list = this.g;
                String string3 = string2 != null ? s.a(string2, " \"'<>#&=", false, false, true, true) : null;
                list.add(string3);
                return this;
            }
            throw new IllegalArgumentException("name == null");
        }

        b.s$a b() {
            int n2 = this.f.size();
            int n3 = 0;
            for (int i2 = 0; i2 < n2; ++i2) {
                String string = (String)this.f.get(i2);
                this.f.set(i2, (Object)s.a(string, "[]", true, true, false, true));
            }
            if (this.g != null) {
                int n4 = this.g.size();
                while (n3 < n4) {
                    String string = (String)this.g.get(n3);
                    if (string != null) {
                        this.g.set(n3, (Object)s.a(string, "\\^`{|}", true, true, true, true));
                    }
                    ++n3;
                }
            }
            if (this.h != null) {
                this.h = s.a(this.h, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        public b.s$a b(String string) {
            if (string != null) {
                String string2 = b.s$a.e(string, 0, string.length());
                if (string2 != null) {
                    this.d = string2;
                    return this;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("unexpected host: ");
                stringBuilder.append(string);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            throw new IllegalArgumentException("host == null");
        }

        public b.s$a b(String string, String string2) {
            if (string != null) {
                if (this.g == null) {
                    this.g = new ArrayList();
                }
                this.g.add((Object)s.a(string, " \"'<>#&=", true, false, true, true));
                List<String> list = this.g;
                String string3 = string2 != null ? s.a(string2, " \"'<>#&=", true, false, true, true) : null;
                list.add(string3);
                return this;
            }
            throw new IllegalArgumentException("encodedName == null");
        }

        public b.s$a c(String string) {
            List<String> list = string != null ? s.b(s.a(string, " \"'<>#", false, false, true, true)) : null;
            this.g = list;
            return this;
        }

        public s c() {
            if (this.a != null) {
                if (this.d != null) {
                    return new s(this);
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        public b.s$a d(String string) {
            List<String> list = string != null ? s.b(s.a(string, " \"'<>#", true, false, true, true)) : null;
            this.g = list;
            return this;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a);
            stringBuilder.append("://");
            if (!this.b.isEmpty() || !this.c.isEmpty()) {
                stringBuilder.append(this.b);
                if (!this.c.isEmpty()) {
                    stringBuilder.append(':');
                    stringBuilder.append(this.c);
                }
                stringBuilder.append('@');
            }
            if (this.d.indexOf(58) != -1) {
                stringBuilder.append('[');
                stringBuilder.append(this.d);
                stringBuilder.append(']');
            } else {
                stringBuilder.append(this.d);
            }
            int n2 = this.a();
            if (n2 != s.a(this.a)) {
                stringBuilder.append(':');
                stringBuilder.append(n2);
            }
            s.a(stringBuilder, this.f);
            if (this.g != null) {
                stringBuilder.append('?');
                s.b(stringBuilder, this.g);
            }
            if (this.h != null) {
                stringBuilder.append('#');
                stringBuilder.append(this.h);
            }
            return stringBuilder.toString();
        }

        static final class a
        extends Enum<a> {
            public static final /* enum */ a a = new a();
            public static final /* enum */ a b = new a();
            public static final /* enum */ a c = new a();
            public static final /* enum */ a d = new a();
            public static final /* enum */ a e = new a();
            private static final /* synthetic */ a[] f;

            static {
                a[] arra = new a[]{a, b, c, d, e};
                f = arra;
            }

            public static a valueOf(String string) {
                return (a)Enum.valueOf(a.class, (String)string);
            }

            public static a[] values() {
                return (a[])f.clone();
            }
        }

    }

}

