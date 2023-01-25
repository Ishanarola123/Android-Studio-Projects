/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  javax.security.auth.x500.X500Principal
 */
package b.a.d;

import javax.security.auth.x500.X500Principal;

final class c {
    private final String a;
    private final int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private char[] g;

    public c(X500Principal x500Principal) {
        this.a = x500Principal.getName("RFC2253");
        this.b = this.a.length();
    }

    private int a(int n2) {
        block2 : {
            block6 : {
                block10 : {
                    int n3;
                    int n4;
                    block8 : {
                        char c2;
                        block9 : {
                            block7 : {
                                int n5;
                                block4 : {
                                    char c3;
                                    block5 : {
                                        block3 : {
                                            n5 = n2 + 1;
                                            if (n5 >= this.b) break block2;
                                            c3 = this.g[n2];
                                            if (c3 < '0' || c3 > '9') break block3;
                                            n3 = c3 - 48;
                                            break block4;
                                        }
                                        if (c3 < 'a' || c3 > 'f') break block5;
                                        n3 = c3 - 87;
                                        break block4;
                                    }
                                    if (c3 < 'A' || c3 > 'F') break block6;
                                    n3 = c3 - 55;
                                }
                                c2 = this.g[n5];
                                if (c2 < '0' || c2 > '9') break block7;
                                n4 = c2 - 48;
                                break block8;
                            }
                            if (c2 < 'a' || c2 > 'f') break block9;
                            n4 = c2 - 87;
                            break block8;
                        }
                        if (c2 < 'A' || c2 > 'F') break block10;
                        n4 = c2 - 55;
                    }
                    return n4 + (n3 << 4);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Malformed DN: ");
                stringBuilder.append(this.a);
                throw new IllegalStateException(stringBuilder.toString());
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Malformed DN: ");
            stringBuilder.append(this.a);
            throw new IllegalStateException(stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Malformed DN: ");
        stringBuilder.append(this.a);
        throw new IllegalStateException(stringBuilder.toString());
    }

    private String a() {
        while (this.c < this.b && this.g[this.c] == ' ') {
            this.c = 1 + this.c;
        }
        if (this.c == this.b) {
            return null;
        }
        this.d = this.c;
        do {
            this.c = 1 + this.c;
        } while (this.c < this.b && this.g[this.c] != '=' && this.g[this.c] != ' ');
        if (this.c < this.b) {
            this.e = this.c;
            if (this.g[this.c] == ' ') {
                while (this.c < this.b && this.g[this.c] != '=' && this.g[this.c] == ' ') {
                    this.c = 1 + this.c;
                }
                if (this.g[this.c] != '=' || this.c == this.b) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unexpected end of DN: ");
                    stringBuilder.append(this.a);
                    throw new IllegalStateException(stringBuilder.toString());
                }
            }
            do {
                this.c = 1 + this.c;
            } while (this.c < this.b && this.g[this.c] == ' ');
            if (!(this.e - this.d <= 4 || this.g[3 + this.d] != '.' || this.g[this.d] != 'O' && this.g[this.d] != 'o' || this.g[1 + this.d] != 'I' && this.g[1 + this.d] != 'i' || this.g[2 + this.d] != 'D' && this.g[2 + this.d] != 'd')) {
                this.d = 4 + this.d;
            }
            return new String(this.g, this.d, this.e - this.d);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected end of DN: ");
        stringBuilder.append(this.a);
        throw new IllegalStateException(stringBuilder.toString());
    }

    private String b() {
        int n2 = this.d = (this.c = 1 + this.c);
        do {
            this.e = n2;
            if (this.c == this.b) break;
            if (this.g[this.c] == '\"') {
                do {
                    this.c = 1 + this.c;
                } while (this.c < this.b && this.g[this.c] == ' ');
                return new String(this.g, this.d, this.e - this.d);
            }
            this.g[this.e] = this.g[this.c] == '\\' ? this.e() : this.g[this.c];
            this.c = 1 + this.c;
            n2 = 1 + this.e;
        } while (true);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected end of DN: ");
        stringBuilder.append(this.a);
        throw new IllegalStateException(stringBuilder.toString());
    }

    private String c() {
        if (4 + this.c < this.b) {
            int n2;
            block8 : {
                this.d = this.c;
                int n3 = this.c;
                do {
                    this.c = n3 + 1;
                    if (this.c == this.b || this.g[this.c] == '+' || this.g[this.c] == ',' || this.g[this.c] == ';') break;
                    if (this.g[this.c] == ' ') {
                        this.e = this.c;
                        do {
                            this.c = 1 + this.c;
                            if (this.c < this.b && this.g[this.c] == ' ') {
                                continue;
                            }
                            break block8;
                            break;
                        } while (true);
                    }
                    if (this.g[this.c] >= 'A' && this.g[this.c] <= 'F') {
                        char[] arrc = this.g;
                        int n4 = this.c;
                        arrc[n4] = (char)(32 + arrc[n4]);
                    }
                    n3 = this.c;
                } while (true);
                this.e = this.c;
            }
            if ((n2 = this.e - this.d) >= 5 && (n2 & 1) != 0) {
                byte[] arrby = new byte[n2 / 2];
                int n5 = 1 + this.d;
                for (int i2 = 0; i2 < arrby.length; ++i2) {
                    arrby[i2] = (byte)this.a(n5);
                    n5 += 2;
                }
                return new String(this.g, this.d, n2);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unexpected end of DN: ");
            stringBuilder.append(this.a);
            throw new IllegalStateException(stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected end of DN: ");
        stringBuilder.append(this.a);
        throw new IllegalStateException(stringBuilder.toString());
    }

    /*
     * Exception decompiling
     */
    private String d() {
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

    private char e() {
        this.c = 1 + this.c;
        if (this.c != this.b) {
            char c2 = this.g[this.c];
            if (c2 != ' ' && c2 != '%' && c2 != '\\' && c2 != '_') {
                switch (c2) {
                    default: {
                        switch (c2) {
                            default: {
                                switch (c2) {
                                    default: {
                                        return this.f();
                                    }
                                    case ';': 
                                    case '<': 
                                    case '=': 
                                    case '>': 
                                }
                            }
                            case '*': 
                            case '+': 
                            case ',': 
                        }
                    }
                    case '\"': 
                    case '#': 
                }
            }
            return this.g[this.c];
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected end of DN: ");
        stringBuilder.append(this.a);
        throw new IllegalStateException(stringBuilder.toString());
    }

    private char f() {
        int n2 = this.a(this.c);
        this.c = 1 + this.c;
        if (n2 < 128) {
            return (char)n2;
        }
        if (n2 >= 192 && n2 <= 247) {
            int n3;
            int n4;
            if (n2 <= 223) {
                n3 = n2 & 31;
                n4 = 1;
            } else if (n2 <= 239) {
                n4 = 2;
                n3 = n2 & 15;
            } else {
                n4 = 3;
                n3 = n2 & 7;
            }
            for (int i2 = 0; i2 < n4; ++i2) {
                this.c = 1 + this.c;
                if (this.c != this.b) {
                    if (this.g[this.c] != '\\') {
                        return '?';
                    }
                    this.c = 1 + this.c;
                    int n5 = this.a(this.c);
                    this.c = 1 + this.c;
                    if ((n5 & 192) != 128) {
                        return '?';
                    }
                    n3 = (n3 << 6) + (n5 & 63);
                    continue;
                }
                return '?';
            }
            return (char)n3;
        }
        return '?';
    }

    public String a(String string) {
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = this.a.toCharArray();
        String string2 = this.a();
        if (string2 == null) {
            return null;
        }
        do {
            String string3 = "";
            if (this.c == this.b) {
                return null;
            }
            switch (this.g[this.c]) {
                default: {
                    string3 = this.d();
                    break;
                }
                case '#': {
                    string3 = this.c();
                    break;
                }
                case '\"': {
                    string3 = this.b();
                }
                case '+': 
                case ',': 
                case ';': 
            }
            if (string.equalsIgnoreCase(string2)) {
                return string3;
            }
            if (this.c >= this.b) {
                return null;
            }
            if (this.g[this.c] != ',' && this.g[this.c] != ';' && this.g[this.c] != '+') {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Malformed DN: ");
                stringBuilder.append(this.a);
                throw new IllegalStateException(stringBuilder.toString());
            }
            this.c = 1 + this.c;
        } while ((string2 = this.a()) != null);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Malformed DN: ");
        stringBuilder.append(this.a);
        throw new IllegalStateException(stringBuilder.toString());
    }
}

