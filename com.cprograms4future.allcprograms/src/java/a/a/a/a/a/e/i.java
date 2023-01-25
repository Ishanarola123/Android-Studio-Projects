/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.BufferedInputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.AssertionError
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.security.GeneralSecurityException
 *  java.security.KeyStore
 *  java.security.KeyStoreException
 *  java.security.NoSuchAlgorithmException
 *  java.security.Principal
 *  java.security.PublicKey
 *  java.security.cert.Certificate
 *  java.security.cert.CertificateException
 *  java.security.cert.X509Certificate
 *  java.util.Enumeration
 *  java.util.HashMap
 *  javax.security.auth.x500.X500Principal
 */
package a.a.a.a.a.e;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.HashMap;
import javax.security.auth.x500.X500Principal;

class i {
    final KeyStore a;
    private final HashMap<Principal, X509Certificate> b;

    public i(InputStream inputStream, String string) {
        KeyStore keyStore = this.a(inputStream, string);
        this.b = this.a(keyStore);
        this.a = keyStore;
    }

    private KeyStore a(InputStream inputStream, String string) {
        KeyStore keyStore = KeyStore.getInstance((String)"BKS");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        try {
            keyStore.load((InputStream)bufferedInputStream, string.toCharArray());
        }
        catch (Throwable throwable) {
            try {
                bufferedInputStream.close();
                throw throwable;
            }
            catch (IOException iOException) {
                throw new AssertionError((Object)iOException);
            }
            catch (CertificateException certificateException) {
                throw new AssertionError((Object)certificateException);
            }
            catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                throw new AssertionError((Object)noSuchAlgorithmException);
            }
            catch (KeyStoreException keyStoreException) {
                throw new AssertionError((Object)keyStoreException);
            }
        }
        bufferedInputStream.close();
        return keyStore;
    }

    private HashMap<Principal, X509Certificate> a(KeyStore keyStore) {
        X509Certificate x509Certificate;
        HashMap hashMap;
        try {
            hashMap = new HashMap();
            Enumeration enumeration = keyStore.aliases();
            while (enumeration.hasMoreElements()) {
                x509Certificate = (X509Certificate)keyStore.getCertificate((String)enumeration.nextElement());
                if (x509Certificate == null) continue;
            }
        }
        catch (KeyStoreException keyStoreException) {
            throw new AssertionError((Object)keyStoreException);
        }
        {
            hashMap.put((Object)x509Certificate.getSubjectX500Principal(), (Object)x509Certificate);
            continue;
        }
        return hashMap;
    }

    public boolean a(X509Certificate x509Certificate) {
        X509Certificate x509Certificate2 = (X509Certificate)this.b.get((Object)x509Certificate.getSubjectX500Principal());
        return x509Certificate2 != null && x509Certificate2.getPublicKey().equals((Object)x509Certificate.getPublicKey());
    }

    public X509Certificate b(X509Certificate x509Certificate) {
        X509Certificate x509Certificate2 = (X509Certificate)this.b.get((Object)x509Certificate.getIssuerX500Principal());
        if (x509Certificate2 == null) {
            return null;
        }
        if (x509Certificate2.getSubjectX500Principal().equals((Object)x509Certificate.getSubjectX500Principal())) {
            return null;
        }
        try {
            x509Certificate.verify(x509Certificate2.getPublicKey());
            return x509Certificate2;
        }
        catch (GeneralSecurityException generalSecurityException) {
            return null;
        }
    }
}

