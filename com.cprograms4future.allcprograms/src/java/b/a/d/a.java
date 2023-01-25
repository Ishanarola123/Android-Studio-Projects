/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.IllegalAccessException
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Method
 *  java.security.cert.TrustAnchor
 *  java.security.cert.X509Certificate
 *  javax.net.ssl.X509TrustManager
 */
package b.a.d;

import b.a.d.f;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

public final class a
implements f {
    private final X509TrustManager a;
    private final Method b;

    public a(X509TrustManager x509TrustManager, Method method) {
        this.b = method;
        this.a = x509TrustManager;
    }

    public static f a(X509TrustManager x509TrustManager) {
        try {
            Method method = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[]{X509Certificate.class});
            method.setAccessible(true);
            a a2 = new a(x509TrustManager, method);
            return a2;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            return null;
        }
    }

    @Override
    public X509Certificate a(X509Certificate x509Certificate) {
        block4 : {
            TrustAnchor trustAnchor = (TrustAnchor)this.b.invoke((Object)this.a, new Object[]{x509Certificate});
            if (trustAnchor == null) break block4;
            try {
                X509Certificate x509Certificate2 = trustAnchor.getTrustedCert();
                return x509Certificate2;
            }
            catch (InvocationTargetException invocationTargetException) {
                return null;
            }
            catch (IllegalAccessException illegalAccessException) {
                throw new AssertionError();
            }
        }
        return null;
    }
}

