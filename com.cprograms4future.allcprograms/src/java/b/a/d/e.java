/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.security.PublicKey
 *  java.security.cert.X509Certificate
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.Map
 *  javax.security.auth.x500.X500Principal
 */
package b.a.d;

import b.a.d.f;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.security.auth.x500.X500Principal;

public final class e
implements f {
    private final Map<X500Principal, List<X509Certificate>> a = new LinkedHashMap();

    public /* varargs */ e(X509Certificate ... arrx509Certificate) {
        for (X509Certificate x509Certificate : arrx509Certificate) {
            X500Principal x500Principal = x509Certificate.getSubjectX500Principal();
            List list = (List)this.a.get((Object)x500Principal);
            if (list == null) {
                list = new ArrayList(1);
                this.a.put((Object)x500Principal, (Object)list);
            }
            list.add((Object)x509Certificate);
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public X509Certificate a(X509Certificate x509Certificate) {
        X500Principal x500Principal = x509Certificate.getIssuerX500Principal();
        List list = (List)this.a.get((Object)x500Principal);
        if (list == null) {
            return null;
        }
        Iterator iterator = list.iterator();
        if (!iterator.hasNext()) {
            return null;
        }
        X509Certificate x509Certificate2 = (X509Certificate)iterator.next();
        PublicKey publicKey = x509Certificate2.getPublicKey();
        {
            x509Certificate.verify(publicKey);
            return x509Certificate2;
        }
    }
}

