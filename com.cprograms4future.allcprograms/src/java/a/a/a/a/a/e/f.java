/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.InputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.security.KeyManagementException
 *  java.security.NoSuchAlgorithmException
 *  java.security.SecureRandom
 *  javax.net.ssl.KeyManager
 *  javax.net.ssl.SSLContext
 *  javax.net.ssl.SSLSocketFactory
 *  javax.net.ssl.TrustManager
 */
package a.a.a.a.a.e;

import a.a.a.a.a.e.g;
import a.a.a.a.a.e.h;
import a.a.a.a.a.e.i;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public final class f {
    public static final SSLSocketFactory a(g g2) throws KeyManagementException, NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance((String)"TLS");
        sSLContext.init(null, new TrustManager[]{new h(new i(g2.a(), g2.b()), g2)}, null);
        return sSLContext.getSocketFactory();
    }
}

