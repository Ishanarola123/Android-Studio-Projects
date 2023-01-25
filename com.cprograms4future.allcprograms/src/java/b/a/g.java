/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  b.a.d.e
 *  c.c
 *  java.io.IOException
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.Void
 *  java.lang.reflect.InvocationHandler
 *  java.lang.reflect.Method
 *  java.net.InetSocketAddress
 *  java.net.Socket
 *  java.net.SocketAddress
 *  java.security.cert.X509Certificate
 *  java.util.List
 *  javax.net.ssl.SSLSocket
 *  javax.net.ssl.SSLSocketFactory
 *  javax.net.ssl.X509TrustManager
 */
package b.a;

import b.a.d.e;
import b.a.d.f;
import b.a.i;
import b.x;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

public class g {
    private static final g a = g.c();

    public static g a() {
        return a;
    }

    /*
     * Exception decompiling
     */
    static <T> T a(Object var0, Class<T> var1, String var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl4 : ALOAD_3 : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
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

    static byte[] a(List<x> list) {
        c.c c2 = new c.c();
        int n2 = list.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            x x2 = (x)((Object)list.get(i2));
            if (x2 == x.a) continue;
            c2.b(x2.toString().length());
            c2.a(x2.toString());
        }
        return c2.s();
    }

    /*
     * Exception decompiling
     */
    private static g c() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl69 : ALOAD : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
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

    public f a(X509TrustManager x509TrustManager) {
        return new e(x509TrustManager.getAcceptedIssuers());
    }

    public X509TrustManager a(SSLSocketFactory sSLSocketFactory) {
        T t2;
        block3 : {
            try {
                t2 = g.a((Object)sSLSocketFactory, Class.forName((String)"sun.security.ssl.SSLContextImpl"), "context");
                if (t2 != null) break block3;
                return null;
            }
            catch (ClassNotFoundException classNotFoundException) {
                return null;
            }
        }
        X509TrustManager x509TrustManager = g.a(t2, X509TrustManager.class, "trustManager");
        return x509TrustManager;
    }

    public void a(Socket socket, InetSocketAddress inetSocketAddress, int n2) throws IOException {
        socket.connect((SocketAddress)inetSocketAddress, n2);
    }

    public void a(SSLSocket sSLSocket) {
    }

    public void a(SSLSocket sSLSocket, String string, List<x> list) {
    }

    public String b() {
        return "OkHttp";
    }

    public String b(SSLSocket sSLSocket) {
        return null;
    }

    private static class c
    implements InvocationHandler {
        private final List<String> a;
        private boolean b;
        private String c;

        public c(List<String> list) {
            this.a = list;
        }

        static /* synthetic */ boolean a(c c2) {
            return c2.b;
        }

        static /* synthetic */ String b(c c2) {
            return c2.c;
        }

        /*
         * Enabled aggressive block sorting
         */
        public Object invoke(Object object, Method method, Object[] arrobject) throws Throwable {
            String string;
            Object object2;
            block8 : {
                int n2;
                List list;
                String string2 = method.getName();
                Class class_ = method.getReturnType();
                if (arrobject == null) {
                    arrobject = i.b;
                }
                if (string2.equals((Object)"supports") && Boolean.TYPE == class_) {
                    return true;
                }
                if (string2.equals((Object)"unsupported") && Void.TYPE == class_) {
                    this.b = true;
                    return null;
                }
                if (string2.equals((Object)"protocols") && arrobject.length == 0) {
                    return this.a;
                }
                if ((string2.equals((Object)"selectProtocol") || string2.equals((Object)"select")) && String.class == class_ && arrobject.length == 1 && arrobject[0] instanceof List) {
                    list = (List)arrobject[0];
                    n2 = list.size();
                } else {
                    if ((string2.equals((Object)"protocolSelected") || string2.equals((Object)"selected")) && arrobject.length == 1) {
                        this.c = (String)arrobject[0];
                        return null;
                    }
                    return method.invoke((Object)this, arrobject);
                }
                for (int i2 = 0; i2 < n2; ++i2) {
                    if (!this.a.contains(list.get(i2))) continue;
                    object2 = list.get(i2);
                    break block8;
                }
                object2 = this.a.get(0);
            }
            this.c = string = (String)object2;
            return string;
        }
    }

}

