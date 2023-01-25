/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.a.d.a$1
 *  java.io.Closeable
 *  java.io.EOFException
 *  java.io.IOException
 *  java.io.Reader
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.IllegalStateException
 *  java.lang.Long
 *  java.lang.NullPointerException
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 */
package com.google.a.d;

import com.google.a.b.e;
import com.google.a.d.a;
import com.google.a.d.b;
import com.google.a.d.d;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

public class a
implements Closeable {
    private static final char[] b = ")]}'\n".toCharArray();
    int a = 0;
    private final Reader c;
    private boolean d = false;
    private final char[] e = new char[1024];
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private int i = 0;
    private long j;
    private int k;
    private String l;
    private int[] m = new int[32];
    private int n = 0;
    private String[] o;
    private int[] p;

    static {
        e.a = new 1();
    }

    public a(Reader reader) {
        int[] arrn = this.m;
        int n2 = this.n;
        this.n = n2 + 1;
        arrn[n2] = 6;
        this.o = new String[32];
        this.p = new int[32];
        if (reader != null) {
            this.c = reader;
            return;
        }
        throw new NullPointerException("in == null");
    }

    private void A() throws IOException {
        this.b(true);
        --this.f;
        if (this.f + b.length > this.g && !this.b(b.length)) {
            return;
        }
        for (int i2 = 0; i2 < b.length; ++i2) {
            if (this.e[i2 + this.f] == b[i2]) continue;
            return;
        }
        this.f += b.length;
    }

    private void a(int n2) {
        if (this.n == this.m.length) {
            int[] arrn = new int[2 * this.n];
            int[] arrn2 = new int[2 * this.n];
            String[] arrstring = new String[2 * this.n];
            System.arraycopy((Object)this.m, (int)0, (Object)arrn, (int)0, (int)this.n);
            System.arraycopy((Object)this.p, (int)0, (Object)arrn2, (int)0, (int)this.n);
            System.arraycopy((Object)this.o, (int)0, (Object)arrstring, (int)0, (int)this.n);
            this.m = arrn;
            this.p = arrn2;
            this.o = arrstring;
        }
        int[] arrn = this.m;
        int n3 = this.n;
        this.n = n3 + 1;
        arrn[n3] = n2;
    }

    private boolean a(char c2) throws IOException {
        switch (c2) {
            default: {
                return true;
            }
            case '#': 
            case '/': 
            case ';': 
            case '=': 
            case '\\': {
                this.x();
            }
            case '\t': 
            case '\n': 
            case '\f': 
            case '\r': 
            case ' ': 
            case ',': 
            case ':': 
            case '[': 
            case ']': 
            case '{': 
            case '}': 
        }
        return false;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private boolean a(String var1_1) throws IOException {
        block0 : do {
            block6 : {
                if (this.f + var1_1.length() > this.g) {
                    if (this.b(var1_1.length()) == false) return false;
                }
                var2_2 = this.e[this.f];
                var3_3 = 0;
                if (var2_2 != '\n') break block6;
                this.h = 1 + this.h;
                this.i = 1 + this.f;
                ** GOTO lbl13
            }
            while (var3_3 < var1_1.length()) {
                block7 : {
                    if (this.e[var3_3 + this.f] == var1_1.charAt(var3_3)) break block7;
lbl13: // 2 sources:
                    this.f = 1 + this.f;
                    continue block0;
                }
                ++var3_3;
            }
            return true;
            break;
        } while (true);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private int b(boolean var1_1) throws IOException {
        var2_2 = this.e;
        block0 : do {
            var3_3 = this.f;
            block1 : do {
                var4_4 = this.g;
                do {
                    block13 : {
                        block12 : {
                            if (var3_3 == var4_4) {
                                this.f = var3_3;
                                if (!this.b(1)) {
                                    if (!var1_1) {
                                        return -1;
                                    }
                                    var9_9 = new StringBuilder();
                                    var9_9.append("End of input at line ");
                                    var9_9.append(this.r());
                                    var9_9.append(" column ");
                                    var9_9.append(this.s());
                                    throw new EOFException(var9_9.toString());
                                }
                                var3_3 = this.f;
                                var4_4 = this.g;
                            }
                            var5_5 = var3_3 + 1;
                            var6_6 = var2_2[var3_3];
                            if (var6_6 != '\n') break block12;
                            this.h = 1 + this.h;
                            this.i = var5_5;
                            break block13;
                        }
                        if (var6_6 == ' ' || var6_6 == '\r' || var6_6 == '\t') break block13;
                        if (var6_6 != '/') ** GOTO lbl47
                        this.f = var5_5;
                        if (var5_5 == var4_4) {
                            --this.f;
                            var8_8 = this.b(2);
                            this.f = 1 + this.f;
                            if (!var8_8) {
                                return var6_6;
                            }
                        }
                        this.x();
                        var7_7 = var2_2[this.f];
                        if (var7_7 != '*') {
                            if (var7_7 != '/') {
                                return var6_6;
                            }
                            this.f = 1 + this.f;
                        } else {
                            this.f = 1 + this.f;
                            if (this.a("*/") == false) throw this.b("Unterminated comment");
                            var3_3 = 2 + this.f;
                            continue block1;
lbl47: // 1 sources:
                            if (var6_6 != '#') {
                                this.f = var5_5;
                                return var6_6;
                            }
                            this.f = var5_5;
                            this.x();
                        }
                        this.y();
                        continue block0;
                    }
                    var3_3 = var5_5;
                } while (true);
                break;
            } while (true);
            break;
        } while (true);
    }

    private IOException b(String string) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(" at line ");
        stringBuilder.append(this.r());
        stringBuilder.append(" column ");
        stringBuilder.append(this.s());
        stringBuilder.append(" path ");
        stringBuilder.append(this.t());
        throw new d(stringBuilder.toString());
    }

    private String b(char c2) throws IOException {
        char[] arrc = this.e;
        StringBuilder stringBuilder = new StringBuilder();
        block0 : do {
            int n2 = this.f;
            int n3 = this.g;
            int n4 = n2;
            while (n2 < n3) {
                int n5 = n2 + 1;
                char c3 = arrc[n2];
                if (c3 == c2) {
                    this.f = n5;
                    stringBuilder.append(arrc, n4, n5 - n4 - 1);
                    return stringBuilder.toString();
                }
                if (c3 == '\\') {
                    this.f = n5;
                    stringBuilder.append(arrc, n4, n5 - n4 - 1);
                    stringBuilder.append(this.z());
                    continue block0;
                }
                if (c3 == '\n') {
                    this.h = 1 + this.h;
                    this.i = n5;
                }
                n2 = n5;
            }
            stringBuilder.append(arrc, n4, n2 - n4);
            this.f = n2;
            if (!this.b(1)) break;
        } while (true);
        throw this.b("Unterminated string");
    }

    private boolean b(int n2) throws IOException {
        int n3;
        char[] arrc = this.e;
        this.i -= this.f;
        if (this.g != this.f) {
            this.g -= this.f;
            System.arraycopy((Object)arrc, (int)this.f, (Object)arrc, (int)0, (int)this.g);
        } else {
            this.g = 0;
        }
        this.f = 0;
        while ((n3 = this.c.read(arrc, this.g, arrc.length - this.g)) != -1) {
            this.g = n3 + this.g;
            if (this.h == 0 && this.i == 0 && this.g > 0 && arrc[0] == '\ufeff') {
                this.f = 1 + this.f;
                this.i = 1 + this.i;
                ++n2;
            }
            if (this.g < n2) continue;
            return true;
        }
        return false;
    }

    private void c(char c2) throws IOException {
        char[] arrc = this.e;
        block0 : do {
            int n2 = this.f;
            int n3 = this.g;
            while (n2 < n3) {
                int n4 = n2 + 1;
                char c3 = arrc[n2];
                if (c3 == c2) {
                    this.f = n4;
                    return;
                }
                if (c3 == '\\') {
                    this.f = n4;
                    this.z();
                    continue block0;
                }
                if (c3 == '\n') {
                    this.h = 1 + this.h;
                    this.i = n4;
                }
                n2 = n4;
            }
            this.f = n2;
            if (!this.b(1)) break;
        } while (true);
        throw this.b("Unterminated string");
    }

    private int o() throws IOException {
        String string;
        String string2;
        int n2;
        char c2 = this.e[this.f];
        if (c2 != 't' && c2 != 'T') {
            if (c2 != 'f' && c2 != 'F') {
                if (c2 != 'n' && c2 != 'N') {
                    return 0;
                }
                string2 = "null";
                string = "NULL";
                n2 = 7;
            } else {
                string2 = "false";
                string = "FALSE";
                n2 = 6;
            }
        } else {
            string2 = "true";
            string = "TRUE";
            n2 = 5;
        }
        int n3 = string2.length();
        for (int i2 = 1; i2 < n3; ++i2) {
            if (i2 + this.f >= this.g && !this.b(i2 + 1)) {
                return 0;
            }
            char c3 = this.e[i2 + this.f];
            if (c3 == string2.charAt(i2) || c3 == string.charAt(i2)) continue;
            return 0;
        }
        if ((n3 + this.f < this.g || this.b(n3 + 1)) && this.a(this.e[n3 + this.f])) {
            return 0;
        }
        this.f = n3 + this.f;
        this.a = n2;
        return n2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private int u() throws IOException {
        var1_1 = this.e;
        var2_2 = this.f;
        var3_3 = this.g;
        var4_4 = 0;
        var5_5 = 0;
        var6_6 = true;
        var7_7 = 0L;
        var9_8 = false;
        do {
            block22 : {
                block23 : {
                    block20 : {
                        block21 : {
                            block19 : {
                                if (var2_2 + var4_4 != var3_3) break block19;
                                if (var4_4 == var1_1.length) {
                                    return 0;
                                }
                                if (!this.b(var4_4 + 1)) ** GOTO lbl42
                                var2_2 = this.f;
                                var3_3 = this.g;
                            }
                            if ((var10_9 = var1_1[var2_2 + var4_4]) == '+') break block20;
                            if (var10_9 == 'E' || var10_9 == 'e') break block21;
                            switch (var10_9) {
                                default: {
                                    if (var10_9 < '0' || var10_9 > '9') ** GOTO lbl41
                                    if (var5_5 != 1 && var5_5 != 0) {
                                        if (var5_5 == 2) {
                                            if (var7_7 == 0L) {
                                                return 0;
                                            }
                                            var12_10 = 10L * var7_7 - (long)(var10_9 - 48);
                                            var14_11 = var7_7 > -922337203685477580L || var7_7 == -922337203685477580L && var12_10 < var7_7;
                                            var15_12 = var14_11 & var6_6;
                                            var7_7 = var12_10;
                                            var6_6 = var15_12;
                                        } else if (var5_5 == 3) {
                                            var5_5 = 4;
                                        } else if (var5_5 == 5 || var5_5 == 6) {
                                            var5_5 = 7;
                                        }
                                    } else {
                                        var7_7 = -(var10_9 - 48);
                                        var5_5 = 2;
                                    }
                                    break block22;
lbl41: // 1 sources:
                                    if (this.a(var10_9) != false) return 0;
lbl42: // 2 sources:
                                    if (var5_5 == 2 && var6_6 && (var7_7 != Long.MIN_VALUE || var9_8)) {
                                        if (!var9_8) {
                                            var7_7 = -var7_7;
                                        }
                                        this.j = var7_7;
                                        this.f = var4_4 + this.f;
                                        var11_13 = 15;
                                    } else {
                                        if (var5_5 != 2 && var5_5 != 4) {
                                            if (var5_5 != 7) return 0;
                                        }
                                        this.k = var4_4;
                                        var11_13 = 16;
                                    }
                                    this.a = var11_13;
                                    return var11_13;
                                }
                                case '.': {
                                    if (var5_5 != 2) return 0;
                                    var5_5 = 3;
                                    break block22;
                                }
                                case '-': {
                                    if (var5_5 != 0) ** GOTO lbl64
                                    var5_5 = 1;
                                    var9_8 = true;
                                    break block22;
lbl64: // 1 sources:
                                    if (var5_5 != 5) return 0;
                                    break;
                                }
                            }
                            break block23;
                        }
                        if (var5_5 != 2) {
                            if (var5_5 != 4) return 0;
                        }
                        var5_5 = 5;
                        break block22;
                    }
                    if (var5_5 != 5) return 0;
                }
                var5_5 = 6;
            }
            ++var4_4;
        } while (true);
    }

    /*
     * Exception decompiling
     */
    private String v() throws IOException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Extractable last case doesn't follow previous
        // org.benf.cfr.reader.b.a.a.b.as.a(SwitchReplacer.java:478)
        // org.benf.cfr.reader.b.a.a.b.as.a(SwitchReplacer.java:61)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:372)
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

    private void w() throws IOException {
        do {
            int n2 = 0;
            block5 : while (n2 + this.f < this.g) {
                switch (this.e[n2 + this.f]) {
                    default: {
                        ++n2;
                        continue block5;
                    }
                    case '#': 
                    case '/': 
                    case ';': 
                    case '=': 
                    case '\\': {
                        this.x();
                    }
                    case '\t': 
                    case '\n': 
                    case '\f': 
                    case '\r': 
                    case ' ': 
                    case ',': 
                    case ':': 
                    case '[': 
                    case ']': 
                    case '{': 
                    case '}': 
                }
                this.f = n2 + this.f;
                return;
            }
            this.f = n2 + this.f;
        } while (this.b(1));
    }

    private void x() throws IOException {
        if (this.d) {
            return;
        }
        throw this.b("Use JsonReader.setLenient(true) to accept malformed JSON");
    }

    private void y() throws IOException {
        while (this.f < this.g || this.b(1)) {
            char[] arrc = this.e;
            int n2 = this.f;
            this.f = n2 + 1;
            char c2 = arrc[n2];
            if (c2 == '\n') {
                this.h = 1 + this.h;
                this.i = this.f;
                return;
            }
            if (c2 != '\r') continue;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private char z() throws IOException {
        if (this.f == this.g && !this.b(1)) {
            throw this.b("Unterminated escape sequence");
        }
        char[] arrc = this.e;
        int n2 = this.f;
        this.f = n2 + 1;
        char c2 = arrc[n2];
        if (c2 == '\n') {
            this.h = 1 + this.h;
            this.i = this.f;
            return c2;
        }
        if (c2 == 'b') {
            return '\b';
        }
        if (c2 == 'f') {
            return '\f';
        }
        if (c2 == 'n') {
            return '\n';
        }
        if (c2 == 'r') {
            return '\r';
        }
        switch (c2) {
            default: {
                return c2;
            }
            case 'u': {
                if (4 + this.f > this.g && !this.b(4)) {
                    throw this.b("Unterminated escape sequence");
                }
                char c3 = '\u0000';
                int n3 = this.f;
                int n4 = n3 + 4;
                do {
                    int n5;
                    if (n3 >= n4) {
                        this.f = 4 + this.f;
                        return c3;
                    }
                    char c4 = this.e[n3];
                    char c5 = (char)(c3 << 4);
                    if (c4 >= '0' && c4 <= '9') {
                        n5 = c4 - 48;
                    } else {
                        int n6;
                        if (c4 >= 'a' && c4 <= 'f') {
                            n6 = c4 - 97;
                        } else {
                            if (c4 < 'A' || c4 > 'F') break;
                            n6 = c4 - 65;
                        }
                        n5 = n6 + 10;
                    }
                    c3 = (char)(c5 + n5);
                    ++n3;
                } while (true);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("\\u");
                stringBuilder.append(new String(this.e, this.f, 4));
                throw new NumberFormatException(stringBuilder.toString());
            }
            case 't': 
        }
        return '\t';
    }

    public void a() throws IOException {
        int n2 = this.a;
        if (n2 == 0) {
            n2 = this.q();
        }
        if (n2 == 3) {
            this.a(1);
            this.p[this.n - 1] = 0;
            this.a = 0;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected BEGIN_ARRAY but was ");
        stringBuilder.append((Object)this.f());
        stringBuilder.append(" at line ");
        stringBuilder.append(this.r());
        stringBuilder.append(" column ");
        stringBuilder.append(this.s());
        stringBuilder.append(" path ");
        stringBuilder.append(this.t());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public final void a(boolean bl) {
        this.d = bl;
    }

    public void b() throws IOException {
        int n2 = this.a;
        if (n2 == 0) {
            n2 = this.q();
        }
        if (n2 == 4) {
            this.n = -1 + this.n;
            int[] arrn = this.p;
            int n3 = -1 + this.n;
            arrn[n3] = 1 + arrn[n3];
            this.a = 0;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected END_ARRAY but was ");
        stringBuilder.append((Object)this.f());
        stringBuilder.append(" at line ");
        stringBuilder.append(this.r());
        stringBuilder.append(" column ");
        stringBuilder.append(this.s());
        stringBuilder.append(" path ");
        stringBuilder.append(this.t());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public void c() throws IOException {
        int n2 = this.a;
        if (n2 == 0) {
            n2 = this.q();
        }
        if (n2 == 1) {
            this.a(3);
            this.a = 0;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected BEGIN_OBJECT but was ");
        stringBuilder.append((Object)this.f());
        stringBuilder.append(" at line ");
        stringBuilder.append(this.r());
        stringBuilder.append(" column ");
        stringBuilder.append(this.s());
        stringBuilder.append(" path ");
        stringBuilder.append(this.t());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public void close() throws IOException {
        this.a = 0;
        this.m[0] = 8;
        this.n = 1;
        this.c.close();
    }

    public void d() throws IOException {
        int n2 = this.a;
        if (n2 == 0) {
            n2 = this.q();
        }
        if (n2 == 2) {
            this.n = -1 + this.n;
            this.o[this.n] = null;
            int[] arrn = this.p;
            int n3 = -1 + this.n;
            arrn[n3] = 1 + arrn[n3];
            this.a = 0;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected END_OBJECT but was ");
        stringBuilder.append((Object)this.f());
        stringBuilder.append(" at line ");
        stringBuilder.append(this.r());
        stringBuilder.append(" column ");
        stringBuilder.append(this.s());
        stringBuilder.append(" path ");
        stringBuilder.append(this.t());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public boolean e() throws IOException {
        int n2 = this.a;
        if (n2 == 0) {
            n2 = this.q();
        }
        return n2 != 2 && n2 != 4;
    }

    public b f() throws IOException {
        int n2 = this.a;
        if (n2 == 0) {
            n2 = this.q();
        }
        switch (n2) {
            default: {
                throw new AssertionError();
            }
            case 17: {
                return b.j;
            }
            case 15: 
            case 16: {
                return b.g;
            }
            case 12: 
            case 13: 
            case 14: {
                return b.e;
            }
            case 8: 
            case 9: 
            case 10: 
            case 11: {
                return b.f;
            }
            case 7: {
                return b.i;
            }
            case 5: 
            case 6: {
                return b.h;
            }
            case 4: {
                return b.b;
            }
            case 3: {
                return b.a;
            }
            case 2: {
                return b.d;
            }
            case 1: 
        }
        return b.c;
    }

    /*
     * Enabled aggressive block sorting
     */
    public String g() throws IOException {
        String string;
        int n2 = this.a;
        if (n2 == 0) {
            n2 = this.q();
        }
        if (n2 == 14) {
            string = this.v();
        } else {
            int n3;
            if (n2 == 12) {
                n3 = 39;
            } else {
                if (n2 != 13) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Expected a name but was ");
                    stringBuilder.append((Object)this.f());
                    stringBuilder.append(" at line ");
                    stringBuilder.append(this.r());
                    stringBuilder.append(" column ");
                    stringBuilder.append(this.s());
                    stringBuilder.append(" path ");
                    stringBuilder.append(this.t());
                    throw new IllegalStateException(stringBuilder.toString());
                }
                n3 = 34;
            }
            string = this.b((char)n3);
        }
        this.a = 0;
        this.o[-1 + this.n] = string;
        return string;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public String h() throws IOException {
        block9 : {
            block10 : {
                block8 : {
                    var1_1 = this.a;
                    if (var1_1 == 0) {
                        var1_1 = this.q();
                    }
                    if (var1_1 != 10) break block8;
                    var2_2 = this.v();
                    break block9;
                }
                if (var1_1 != 8) break block10;
                var14_3 = 39;
                ** GOTO lbl14
            }
            if (var1_1 == 9) {
                var14_3 = 34;
lbl14: // 2 sources:
                var2_2 = this.b((char)var14_3);
            } else if (var1_1 == 11) {
                var2_2 = this.l;
                this.l = null;
            } else if (var1_1 == 15) {
                var2_2 = Long.toString((long)this.j);
            } else {
                if (var1_1 != 16) {
                    var5_6 = new StringBuilder();
                    var5_6.append("Expected a string but was ");
                    var5_6.append((Object)this.f());
                    var5_6.append(" at line ");
                    var5_6.append(this.r());
                    var5_6.append(" column ");
                    var5_6.append(this.s());
                    var5_6.append(" path ");
                    var5_6.append(this.t());
                    throw new IllegalStateException(var5_6.toString());
                }
                var2_2 = new String(this.e, this.f, this.k);
                this.f += this.k;
            }
        }
        this.a = 0;
        var3_4 = this.p;
        var4_5 = -1 + this.n;
        var3_4[var4_5] = 1 + var3_4[var4_5];
        return var2_2;
    }

    public boolean i() throws IOException {
        int n2 = this.a;
        if (n2 == 0) {
            n2 = this.q();
        }
        if (n2 == 5) {
            this.a = 0;
            int[] arrn = this.p;
            int n3 = this.n - 1;
            arrn[n3] = 1 + arrn[n3];
            return true;
        }
        if (n2 == 6) {
            this.a = 0;
            int[] arrn = this.p;
            int n4 = this.n - 1;
            arrn[n4] = 1 + arrn[n4];
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected a boolean but was ");
        stringBuilder.append((Object)this.f());
        stringBuilder.append(" at line ");
        stringBuilder.append(this.r());
        stringBuilder.append(" column ");
        stringBuilder.append(this.s());
        stringBuilder.append(" path ");
        stringBuilder.append(this.t());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public void j() throws IOException {
        int n2 = this.a;
        if (n2 == 0) {
            n2 = this.q();
        }
        if (n2 == 7) {
            this.a = 0;
            int[] arrn = this.p;
            int n3 = -1 + this.n;
            arrn[n3] = 1 + arrn[n3];
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected null but was ");
        stringBuilder.append((Object)this.f());
        stringBuilder.append(" at line ");
        stringBuilder.append(this.r());
        stringBuilder.append(" column ");
        stringBuilder.append(this.s());
        stringBuilder.append(" path ");
        stringBuilder.append(this.t());
        throw new IllegalStateException(stringBuilder.toString());
    }

    /*
     * Enabled aggressive block sorting
     */
    public double k() throws IOException {
        block5 : {
            String string;
            block8 : {
                int n2;
                block6 : {
                    block7 : {
                        block4 : {
                            n2 = this.a;
                            if (n2 == 0) {
                                n2 = this.q();
                            }
                            if (n2 == 15) {
                                this.a = 0;
                                int[] arrn = this.p;
                                int n3 = -1 + this.n;
                                arrn[n3] = 1 + arrn[n3];
                                return this.j;
                            }
                            if (n2 != 16) break block4;
                            this.l = new String(this.e, this.f, this.k);
                            this.f += this.k;
                            break block5;
                        }
                        if (n2 == 8 || n2 == 9) break block6;
                        if (n2 != 10) break block7;
                        string = this.v();
                        break block8;
                    }
                    if (n2 != 11) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Expected a double but was ");
                        stringBuilder.append((Object)this.f());
                        stringBuilder.append(" at line ");
                        stringBuilder.append(this.r());
                        stringBuilder.append(" column ");
                        stringBuilder.append(this.s());
                        stringBuilder.append(" path ");
                        stringBuilder.append(this.t());
                        throw new IllegalStateException(stringBuilder.toString());
                    }
                    break block5;
                }
                char c2 = n2 == 8 ? (char)'\'' : '\"';
                string = this.b(c2);
            }
            this.l = string;
        }
        this.a = 11;
        double d2 = Double.parseDouble((String)this.l);
        if (!this.d && (Double.isNaN((double)d2) || Double.isInfinite((double)d2))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("JSON forbids NaN and infinities: ");
            stringBuilder.append(d2);
            stringBuilder.append(" at line ");
            stringBuilder.append(this.r());
            stringBuilder.append(" column ");
            stringBuilder.append(this.s());
            stringBuilder.append(" path ");
            stringBuilder.append(this.t());
            throw new d(stringBuilder.toString());
        }
        this.l = null;
        this.a = 0;
        int[] arrn = this.p;
        int n4 = -1 + this.n;
        arrn[n4] = 1 + arrn[n4];
        return d2;
    }

    /*
     * Exception decompiling
     */
    public long l() throws IOException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl147.1 : ALOAD_0 : trying to set 1 previously set to 0
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

    /*
     * Exception decompiling
     */
    public int m() throws IOException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl202.1 : ALOAD_0 : trying to set 1 previously set to 0
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

    /*
     * Enabled aggressive block sorting
     */
    public void n() throws IOException {
        int n2 = 0;
        do {
            block6 : {
                block8 : {
                    int n3;
                    block11 : {
                        block9 : {
                            block10 : {
                                int n4;
                                block7 : {
                                    block5 : {
                                        block4 : {
                                            block3 : {
                                                if ((n4 = this.a) == 0) {
                                                    n4 = this.q();
                                                }
                                                if (n4 != 3) break block3;
                                                this.a(1);
                                                break block4;
                                            }
                                            if (n4 != 1) break block5;
                                            this.a(3);
                                        }
                                        ++n2;
                                        break block6;
                                    }
                                    if (n4 != 4 && n4 != 2) break block7;
                                    --this.n;
                                    --n2;
                                    break block6;
                                }
                                if (n4 == 14 || n4 == 10) break block8;
                                if (n4 == 8 || n4 == 12) break block9;
                                if (n4 == 9 || n4 == 13) break block10;
                                if (n4 == 16) {
                                    this.f += this.k;
                                }
                                break block6;
                            }
                            n3 = 34;
                            break block11;
                        }
                        n3 = 39;
                    }
                    this.c((char)n3);
                    break block6;
                }
                this.w();
            }
            this.a = 0;
        } while (n2 != 0);
        int[] arrn = this.p;
        int n5 = this.n - 1;
        arrn[n5] = 1 + arrn[n5];
        this.o[this.n - 1] = "null";
    }

    public final boolean p() {
        return this.d;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    int q() throws IOException {
        block28 : {
            block22 : {
                block20 : {
                    block26 : {
                        block24 : {
                            block27 : {
                                block25 : {
                                    block23 : {
                                        block21 : {
                                            block19 : {
                                                var1_1 = this.m[this.n - 1];
                                                if (var1_1 != 1) break block19;
                                                this.m[this.n - 1] = 2;
                                                break block20;
                                            }
                                            if (var1_1 != 2) break block21;
                                            var10_2 = this.b(true);
                                            if (var10_2 != 44) {
                                                if (var10_2 != 59) {
                                                    if (var10_2 != 93) throw this.b("Unterminated array");
                                                    this.a = 4;
                                                    return 4;
                                                }
                                                this.x();
                                            }
                                            break block20;
                                        }
                                        if (var1_1 == 3 || var1_1 == 5) break block22;
                                        if (var1_1 != 4) break block23;
                                        this.m[this.n - 1] = 5;
                                        var9_3 = this.b(true);
                                        if (var9_3 == 58) break block20;
                                        if (var9_3 != 61) throw this.b("Expected ':'");
                                        this.x();
                                        if (this.f >= this.g && !this.b(1) || this.e[this.f] != '>') break block20;
                                        var8_4 = 1 + this.f;
                                        break block24;
                                    }
                                    if (var1_1 != 6) break block25;
                                    if (this.d) {
                                        this.A();
                                    }
                                    this.m[this.n - 1] = 7;
                                    break block20;
                                }
                                if (var1_1 != 7) break block26;
                                if (this.b(false) != -1) break block27;
                                var3_5 = 17;
                                break block28;
                            }
                            this.x();
                            var8_4 = this.f - 1;
                        }
                        this.f = var8_4;
                        break block20;
                    }
                    if (var1_1 == 8) throw new IllegalStateException("JsonReader is closed");
                }
                var5_6 = this.b(true);
                if (var5_6 == 34) ** GOTO lbl80
                if (var5_6 == 39) {
                    this.x();
                    this.a = 8;
                    return 8;
                }
                if (var5_6 == 44 || var5_6 == 59) ** GOTO lbl74
                if (var5_6 == 91) {
                    this.a = 3;
                    return 3;
                }
                if (var5_6 != 93) {
                    if (var5_6 == 123) {
                        this.a = 1;
                        return 1;
                    }
                    --this.f;
                    var6_7 = this.o();
                    if (var6_7 != 0) {
                        return var6_7;
                    }
                    var7_8 = this.u();
                    if (var7_8 != 0) {
                        return var7_8;
                    }
                    if (this.a(this.e[this.f]) == false) throw this.b("Expected value");
                    this.x();
                    var3_5 = 10;
                } else {
                    if (var1_1 == 1) {
                        this.a = 4;
                        return 4;
                    }
lbl74: // 3 sources:
                    if (var1_1 != 1) {
                        if (var1_1 != 2) throw this.b("Unexpected value");
                    }
                    this.x();
                    --this.f;
                    this.a = 7;
                    return 7;
lbl80: // 1 sources:
                    var3_5 = 9;
                }
                break block28;
            }
            this.m[this.n - 1] = 4;
            if (var1_1 == 5 && (var4_9 = this.b(true)) != 44) {
                if (var4_9 != 59) {
                    if (var4_9 != 125) throw this.b("Unterminated object");
                    this.a = 2;
                    return 2;
                }
                this.x();
            }
            if ((var2_10 = this.b(true)) != 34) {
                if (var2_10 != 39) {
                    if (var2_10 == 125) {
                        if (var1_1 == 5) throw this.b("Expected name");
                        this.a = 2;
                        return 2;
                    }
                    this.x();
                    --this.f;
                    if (this.a((char)var2_10) == false) throw this.b("Expected name");
                    var3_5 = 14;
                } else {
                    this.x();
                    var3_5 = 12;
                }
            } else {
                var3_5 = 13;
            }
        }
        this.a = var3_5;
        return var3_5;
    }

    int r() {
        return 1 + this.h;
    }

    int s() {
        return 1 + (this.f - this.i);
    }

    public String t() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('$');
        int n2 = this.n;
        block4 : for (int i2 = 0; i2 < n2; ++i2) {
            switch (this.m[i2]) {
                default: {
                    continue block4;
                }
                case 3: 
                case 4: 
                case 5: {
                    stringBuilder.append('.');
                    if (this.o[i2] == null) continue block4;
                    stringBuilder.append(this.o[i2]);
                    continue block4;
                }
                case 1: 
                case 2: {
                    stringBuilder.append('[');
                    stringBuilder.append(this.p[i2]);
                    stringBuilder.append(']');
                }
            }
        }
        return stringBuilder.toString();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getClass().getSimpleName());
        stringBuilder.append(" at line ");
        stringBuilder.append(this.r());
        stringBuilder.append(" column ");
        stringBuilder.append(this.s());
        return stringBuilder.toString();
    }
}

