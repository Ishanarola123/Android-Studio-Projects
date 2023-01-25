/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.security.GeneralSecurityException
 *  java.security.PublicKey
 *  java.security.cert.CertificateException
 *  java.security.cert.X509Certificate
 *  java.util.LinkedList
 *  javax.security.auth.x500.X500Principal
 */
package a.a.a.a.a.e;

import a.a.a.a.a.e.i;
import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.LinkedList;
import javax.security.auth.x500.X500Principal;

final class a {
    private static boolean a(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        if (!x509Certificate.getSubjectX500Principal().equals((Object)x509Certificate2.getIssuerX500Principal())) {
            return false;
        }
        try {
            x509Certificate2.verify(x509Certificate.getPublicKey());
            return true;
        }
        catch (GeneralSecurityException generalSecurityException) {
            return false;
        }
    }

    public static X509Certificate[] a(X509Certificate[] arrx509Certificate, i i2) throws CertificateException {
        int n2;
        X509Certificate x509Certificate;
        LinkedList linkedList = new LinkedList();
        boolean bl = i2.a(arrx509Certificate[0]);
        linkedList.add((Object)arrx509Certificate[0]);
        int n3 = 1;
        boolean bl2 = bl;
        for (n2 = 1; n2 < arrx509Certificate.length; ++n2) {
            if (i2.a(arrx509Certificate[n2])) {
                bl2 = true;
            }
            if (!a.a(arrx509Certificate[n2], arrx509Certificate[n2 - 1])) break;
            linkedList.add((Object)arrx509Certificate[n2]);
        }
        if ((x509Certificate = i2.b(arrx509Certificate[n2 - n3])) != null) {
            linkedList.add((Object)x509Certificate);
        } else {
            n3 = bl2 ? 1 : 0;
        }
        if (n3 != 0) {
            return (X509Certificate[])linkedList.toArray((Object[])new X509Certificate[linkedList.size()]);
        }
        throw new CertificateException("Didn't find a trust anchor in chain cleanup!");
    }
}

