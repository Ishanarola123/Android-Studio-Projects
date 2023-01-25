/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.AssertionError
 *  java.lang.Character
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.security.KeyStore
 *  java.security.KeyStoreException
 *  java.security.MessageDigest
 *  java.security.NoSuchAlgorithmException
 *  java.security.PublicKey
 *  java.security.cert.CertificateException
 *  java.security.cert.X509Certificate
 *  java.util.Arrays
 *  java.util.Collections
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.LinkedList
 *  java.util.List
 *  java.util.Set
 *  javax.net.ssl.TrustManager
 *  javax.net.ssl.TrustManagerFactory
 *  javax.net.ssl.X509TrustManager
 */
package a.a.a.a.a.e;

import a.a.a.a.a.e.a;
import a.a.a.a.a.e.g;
import a.a.a.a.a.e.i;
import a.a.a.a.c;
import a.a.a.a.l;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

class h
implements X509TrustManager {
    private static final X509Certificate[] a = new X509Certificate[0];
    private final TrustManager[] b;
    private final i c;
    private final long d;
    private final List<byte[]> e = new LinkedList();
    private final Set<X509Certificate> f = Collections.synchronizedSet((Set)new HashSet());

    public h(i i2, g g2) {
        this.b = this.a(i2);
        this.c = i2;
        this.d = g2.d();
        for (String string : g2.c()) {
            this.e.add((Object)this.a(string));
        }
    }

    private void a(X509Certificate[] arrx509Certificate) throws CertificateException {
        if (this.d != -1L && System.currentTimeMillis() - this.d > 15552000000L) {
            l l2 = c.h();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Certificate pins are stale, (");
            stringBuilder.append(System.currentTimeMillis() - this.d);
            stringBuilder.append(" millis vs ");
            stringBuilder.append(15552000000L);
            stringBuilder.append(" millis) ");
            stringBuilder.append("falling back to system trust.");
            l2.c("Fabric", stringBuilder.toString());
            return;
        }
        X509Certificate[] arrx509Certificate2 = a.a(arrx509Certificate, this.c);
        int n2 = arrx509Certificate2.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!this.a(arrx509Certificate2[i2])) continue;
            return;
        }
        throw new CertificateException("No valid pins found in chain!");
    }

    private void a(X509Certificate[] arrx509Certificate, String string) throws CertificateException {
        TrustManager[] arrtrustManager = this.b;
        int n2 = arrtrustManager.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            ((X509TrustManager)arrtrustManager[i2]).checkServerTrusted(arrx509Certificate, string);
        }
    }

    private boolean a(X509Certificate x509Certificate) throws CertificateException {
        try {
            byte[] arrby = MessageDigest.getInstance((String)"SHA1").digest(x509Certificate.getPublicKey().getEncoded());
            Iterator iterator = this.e.iterator();
            while (iterator.hasNext()) {
                boolean bl = Arrays.equals((byte[])((byte[])iterator.next()), (byte[])arrby);
                if (!bl) continue;
                return true;
            }
            return false;
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new CertificateException((Throwable)noSuchAlgorithmException);
        }
    }

    private byte[] a(String string) {
        int n2 = string.length();
        byte[] arrby = new byte[n2 / 2];
        for (int i2 = 0; i2 < n2; i2 += 2) {
            arrby[i2 / 2] = (byte)((Character.digit((char)string.charAt(i2), (int)16) << 4) + Character.digit((char)string.charAt(i2 + 1), (int)16));
        }
        return arrby;
    }

    private TrustManager[] a(i i2) {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance((String)"X509");
            trustManagerFactory.init(i2.a);
            TrustManager[] arrtrustManager = trustManagerFactory.getTrustManagers();
            return arrtrustManager;
        }
        catch (KeyStoreException keyStoreException) {
            throw new AssertionError((Object)keyStoreException);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new AssertionError((Object)noSuchAlgorithmException);
        }
    }

    public void checkClientTrusted(X509Certificate[] arrx509Certificate, String string) throws CertificateException {
        throw new CertificateException("Client certificates not supported!");
    }

    public void checkServerTrusted(X509Certificate[] arrx509Certificate, String string) throws CertificateException {
        if (this.f.contains((Object)arrx509Certificate[0])) {
            return;
        }
        this.a(arrx509Certificate, string);
        this.a(arrx509Certificate);
        this.f.add((Object)arrx509Certificate[0]);
    }

    public X509Certificate[] getAcceptedIssuers() {
        return a;
    }
}

