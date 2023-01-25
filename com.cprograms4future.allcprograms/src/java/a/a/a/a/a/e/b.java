/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.net.HttpURLConnection
 *  java.util.Locale
 *  java.util.Map
 *  javax.net.ssl.HttpsURLConnection
 *  javax.net.ssl.SSLSocketFactory
 */
package a.a.a.a.a.e;

import a.a.a.a.a.e.b;
import a.a.a.a.a.e.c;
import a.a.a.a.a.e.d;
import a.a.a.a.a.e.e;
import a.a.a.a.a.e.f;
import a.a.a.a.a.e.g;
import a.a.a.a.l;
import java.net.HttpURLConnection;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public class b
implements e {
    private final l a;
    private g b;
    private SSLSocketFactory c;
    private boolean d;

    public b() {
        this(new a.a.a.a.b());
    }

    public b(l l2) {
        this.a = l2;
    }

    private SSLSocketFactory a() {
        b b2 = this;
        synchronized (b2) {
            if (this.c == null && !this.d) {
                this.c = this.b();
            }
            SSLSocketFactory sSLSocketFactory = this.c;
            return sSLSocketFactory;
        }
    }

    private boolean a(String string) {
        return string != null && string.toLowerCase(Locale.US).startsWith("https");
    }

    private SSLSocketFactory b() {
        b b2 = this;
        synchronized (b2) {
            this.d = true;
            try {
                SSLSocketFactory sSLSocketFactory = f.a(this.b);
                this.a.a("Fabric", "Custom SSL pinning enabled");
                return sSLSocketFactory;
            }
            catch (Exception exception) {
                this.a.d("Fabric", "Exception while validating pinned certs", exception);
                return null;
            }
        }
    }

    @Override
    public d a(c c2, String string, Map<String, String> map) {
        SSLSocketFactory sSLSocketFactory;
        d d2;
        switch (1.a[c2.ordinal()]) {
            default: {
                throw new IllegalArgumentException("Unsupported HTTP method!");
            }
            case 4: {
                d2 = d.e((CharSequence)string);
                break;
            }
            case 3: {
                d2 = d.d(string);
                break;
            }
            case 2: {
                d2 = d.b(string, map, true);
                break;
            }
            case 1: {
                d2 = d.a(string, map, true);
            }
        }
        if (this.a(string) && this.b != null && (sSLSocketFactory = this.a()) != null) {
            ((HttpsURLConnection)d2.a()).setSSLSocketFactory(sSLSocketFactory);
        }
        return d2;
    }
}

