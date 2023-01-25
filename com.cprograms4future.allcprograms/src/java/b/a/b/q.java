/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Integer
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.net.ProtocolException
 */
package b.a.b;

import b.x;
import java.io.IOException;
import java.net.ProtocolException;

public final class q {
    public final x a;
    public final int b;
    public final String c;

    public q(x x2, int n2, String string) {
        this.a = x2;
        this.b = n2;
        this.c = string;
    }

    public static q a(String string) throws IOException {
        block14 : {
            int n2;
            x x2;
            block12 : {
                block9 : {
                    block10 : {
                        block13 : {
                            int n3;
                            block11 : {
                                boolean bl = string.startsWith("HTTP/1.");
                                n2 = 9;
                                if (!bl) break block9;
                                if (string.length() < n2 || string.charAt(8) != ' ') break block10;
                                n3 = -48 + string.charAt(7);
                                if (n3 != 0) break block11;
                                x2 = x.a;
                                break block12;
                            }
                            if (n3 != 1) break block13;
                            x2 = x.b;
                            break block12;
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Unexpected status line: ");
                        stringBuilder.append(string);
                        throw new ProtocolException(stringBuilder.toString());
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unexpected status line: ");
                    stringBuilder.append(string);
                    throw new ProtocolException(stringBuilder.toString());
                }
                if (!string.startsWith("ICY ")) break block14;
                x2 = x.a;
                n2 = 4;
            }
            int n4 = string.length();
            int n5 = n2 + 3;
            if (n4 >= n5) {
                int n6;
                String string2;
                try {
                    n6 = Integer.parseInt((String)string.substring(n2, n5));
                    string2 = "";
                }
                catch (NumberFormatException numberFormatException) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unexpected status line: ");
                    stringBuilder.append(string);
                    throw new ProtocolException(stringBuilder.toString());
                }
                if (string.length() > n5) {
                    if (string.charAt(n5) == ' ') {
                        string2 = string.substring(n2 + 4);
                    } else {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Unexpected status line: ");
                        stringBuilder.append(string);
                        throw new ProtocolException(stringBuilder.toString());
                    }
                }
                return new q(x2, n6, string2);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unexpected status line: ");
            stringBuilder.append(string);
            throw new ProtocolException(stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected status line: ");
        stringBuilder.append(string);
        throw new ProtocolException(stringBuilder.toString());
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String string = this.a == x.a ? "HTTP/1.0" : "HTTP/1.1";
        stringBuilder.append(string);
        stringBuilder.append(' ');
        stringBuilder.append(this.b);
        if (this.c != null) {
            stringBuilder.append(' ');
            stringBuilder.append(this.c);
        }
        return stringBuilder.toString();
    }
}

