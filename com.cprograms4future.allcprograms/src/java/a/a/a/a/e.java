/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  java.io.Closeable
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.Map
 *  java.util.Properties
 *  java.util.concurrent.Callable
 *  java.util.zip.ZipEntry
 *  java.util.zip.ZipFile
 */
package a.a.a.a;

import a.a.a.a.a.b.i;
import a.a.a.a.c;
import a.a.a.a.k;
import a.a.a.a.l;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

class e
implements Callable<Map<String, k>> {
    final String a;

    e(String string) {
        this.a = string;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private k a(ZipEntry zipEntry, ZipFile zipFile) {
        void var9_12;
        InputStream inputStream;
        block9 : {
            void var3_15;
            block10 : {
                block8 : {
                    inputStream = zipFile.getInputStream(zipEntry);
                    Properties properties = new Properties();
                    properties.load(inputStream);
                    String string = properties.getProperty("fabric-identifier");
                    String string2 = properties.getProperty("fabric-version");
                    String string3 = properties.getProperty("fabric-build-type");
                    if (TextUtils.isEmpty((CharSequence)string) || TextUtils.isEmpty((CharSequence)string2)) break block8;
                    k k2 = new k(string, string2, string3);
                    i.a((Closeable)inputStream);
                    return k2;
                }
                try {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Invalid format of fabric file,");
                    stringBuilder.append(zipEntry.getName());
                    throw new IllegalStateException(stringBuilder.toString());
                }
                catch (Throwable throwable) {
                    break block9;
                }
                catch (IOException iOException) {
                    break block10;
                }
                catch (Throwable throwable) {
                    inputStream = null;
                    break block9;
                }
                catch (IOException iOException) {
                    inputStream = null;
                }
            }
            l l2 = c.h();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error when parsing fabric properties ");
            stringBuilder.append(zipEntry.getName());
            l2.d("Fabric", stringBuilder.toString(), (Throwable)var3_15);
            i.a((Closeable)inputStream);
            return null;
        }
        i.a((Closeable)inputStream);
        throw var9_12;
    }

    /*
     * Exception decompiling
     */
    public Map<String, k> a() throws Exception {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
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

    protected ZipFile b() throws IOException {
        return new ZipFile(this.a);
    }

    public /* synthetic */ Object call() throws Exception {
        return this.a();
    }
}

