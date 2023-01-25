/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.IllegalAccessException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Method
 */
package b.a;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class f<T> {
    private final Class<?> a;
    private final String b;
    private final Class[] c;

    public /* varargs */ f(Class<?> class_, String string, Class ... arrclass) {
        this.a = class_;
        this.b = string;
        this.c = arrclass;
    }

    private Method a(Class<?> class_) {
        String string = this.b;
        Method method = null;
        if (string != null) {
            Method method2 = f.a(class_, this.b, this.c);
            if (method2 != null && this.a != null && !this.a.isAssignableFrom(method2.getReturnType())) {
                return null;
            }
            method = method2;
        }
        return method;
    }

    /*
     * Exception decompiling
     */
    private static Method a(Class<?> var0, String var1, Class[] var2) {
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

    public /* varargs */ Object a(T t2, Object ... arrobject) throws InvocationTargetException {
        Method method = this.a(t2.getClass());
        if (method == null) {
            return null;
        }
        try {
            Object object = method.invoke(t2, arrobject);
            return object;
        }
        catch (IllegalAccessException illegalAccessException) {
            return null;
        }
    }

    public boolean a(T t2) {
        return this.a(t2.getClass()) != null;
    }

    public /* varargs */ Object b(T t2, Object ... arrobject) {
        try {
            Object object = this.a(t2, arrobject);
            return object;
        }
        catch (InvocationTargetException invocationTargetException) {
            Throwable throwable = invocationTargetException.getTargetException();
            if (throwable instanceof RuntimeException) {
                throw (RuntimeException)throwable;
            }
            AssertionError assertionError = new AssertionError((Object)"Unexpected exception");
            assertionError.initCause(throwable);
            throw assertionError;
        }
    }

    public /* varargs */ Object c(T t2, Object ... arrobject) throws InvocationTargetException {
        Method method = this.a(t2.getClass());
        if (method != null) {
            try {
                Object object = method.invoke(t2, arrobject);
                return object;
            }
            catch (IllegalAccessException illegalAccessException) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unexpectedly could not call: ");
                stringBuilder.append((Object)method);
                AssertionError assertionError = new AssertionError((Object)stringBuilder.toString());
                assertionError.initCause((Throwable)illegalAccessException);
                throw assertionError;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Method ");
        stringBuilder.append(this.b);
        stringBuilder.append(" not supported for object ");
        stringBuilder.append(t2);
        throw new AssertionError((Object)stringBuilder.toString());
    }

    public /* varargs */ Object d(T t2, Object ... arrobject) {
        try {
            Object object = this.c(t2, arrobject);
            return object;
        }
        catch (InvocationTargetException invocationTargetException) {
            Throwable throwable = invocationTargetException.getTargetException();
            if (throwable instanceof RuntimeException) {
                throw (RuntimeException)throwable;
            }
            AssertionError assertionError = new AssertionError((Object)"Unexpected exception");
            assertionError.initCause(throwable);
            throw assertionError;
        }
    }
}

