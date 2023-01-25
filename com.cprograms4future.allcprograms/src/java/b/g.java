/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.AssertionError
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.security.Principal
 *  java.security.PublicKey
 *  java.security.cert.Certificate
 *  java.security.cert.X509Certificate
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.List
 *  javax.net.ssl.SSLPeerUnverifiedException
 */
package b;

import b.a.d.f;
import b.a.i;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

public final class g {
    public static final g a = new a().a();
    private final List<b> b;
    private final f c;

    private g(a a2) {
        this.b = i.a(a2.a);
        this.c = a2.b;
    }

    static c.f a(X509Certificate x509Certificate) {
        return i.a(c.f.a(x509Certificate.getPublicKey().getEncoded()));
    }

    public static String a(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("sha256/");
            stringBuilder.append(g.b((X509Certificate)certificate).b());
            return stringBuilder.toString();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    static c.f b(X509Certificate x509Certificate) {
        return i.b(c.f.a(x509Certificate.getPublicKey().getEncoded()));
    }

    a a() {
        return new a(this);
    }

    List<b> a(String string) {
        List list = Collections.emptyList();
        for (b b2 : this.b) {
            if (!b2.a(string)) continue;
            if (list.isEmpty()) {
                list = new ArrayList();
            }
            list.add((Object)b2);
        }
        return list;
    }

    public void a(String string, List<Certificate> list) throws SSLPeerUnverifiedException {
        List<b> list2 = this.a(string);
        if (list2.isEmpty()) {
            return;
        }
        if (this.c != null) {
            list = new b.a.d.b(this.c).a(list);
        }
        int n2 = list.size();
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            X509Certificate x509Certificate = (X509Certificate)list.get(i2);
            int n4 = list2.size();
            c.f f2 = null;
            c.f f3 = null;
            for (int i3 = 0; i3 < n4; ++i3) {
                b b2 = (b)list2.get(i3);
                if (b2.b.equals((Object)"sha256/")) {
                    if (f2 == null) {
                        f2 = g.b(x509Certificate);
                    }
                    if (!b2.c.equals(f2)) continue;
                    return;
                }
                if (b2.b.equals((Object)"sha1/")) {
                    if (f3 == null) {
                        f3 = g.a(x509Certificate);
                    }
                    if (!b2.c.equals(f3)) continue;
                    return;
                }
                throw new AssertionError();
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Certificate pinning failure!");
        stringBuilder.append("\n  Peer certificate chain:");
        int n5 = list.size();
        for (int i4 = 0; i4 < n5; ++i4) {
            X509Certificate x509Certificate = (X509Certificate)list.get(i4);
            stringBuilder.append("\n    ");
            stringBuilder.append(g.a((Certificate)x509Certificate));
            stringBuilder.append(": ");
            stringBuilder.append(x509Certificate.getSubjectDN().getName());
        }
        stringBuilder.append("\n  Pinned certificates for ");
        stringBuilder.append(string);
        stringBuilder.append(":");
        int n6 = list2.size();
        while (n3 < n6) {
            b b3 = (b)list2.get(n3);
            stringBuilder.append("\n    ");
            stringBuilder.append((Object)b3);
            ++n3;
        }
        throw new SSLPeerUnverifiedException(stringBuilder.toString());
    }

    public static final class a {
        private final List<b> a = new ArrayList();
        private f b;

        public a() {
        }

        a(g g2) {
            this.a.addAll((Collection)g2.b);
            this.b = g2.c;
        }

        public a a(f f2) {
            this.b = f2;
            return this;
        }

        public g a() {
            return new g(this);
        }
    }

    static final class b {
        final String a;
        final String b;
        final c.f c;

        boolean a(String string) {
            if (this.a.equals((Object)string)) {
                return true;
            }
            int n2 = string.indexOf(46);
            return this.a.startsWith("*.") && string.regionMatches(false, n2 + 1, this.a, 2, -2 + this.a.length());
        }

        public boolean equals(Object object) {
            if (object instanceof b) {
                String string = this.a;
                b b2 = (b)object;
                if (string.equals((Object)b2.a) && this.b.equals((Object)b2.b) && this.c.equals(b2.c)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return 31 * (31 * (527 + this.a.hashCode()) + this.b.hashCode()) + this.c.hashCode();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.b);
            stringBuilder.append(this.c.b());
            return stringBuilder.toString();
        }
    }

}

