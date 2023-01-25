/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.net.Uri
 *  android.os.IBinder
 *  android.text.TextUtils
 *  com.miui.barcodescanner.lib.utils.BarcodeScannerUtils$CreateQRImageListener
 *  com.miui.barcodescanner.lib.utils.BarcodeScannerUtils$RecogniseQRImageListener
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 */
package com.miui.barcodescanner.lib.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.IBinder;
import android.text.TextUtils;
import com.miui.barcodescanner.lib.utils.BarcodeScannerUtils;
import com.miui.barcodescanner.lib.utils.IRemoteService;

public class BarcodeScannerUtils
implements ServiceConnection {
    private static final String SERVICE_ACTION = "com.xiaomi.scanner.app.RemoteService";
    private Context mContext;
    private int mImageSize;
    private BarcodeListener mListener;
    private IRemoteService mService;
    private String mText;
    private Uri mUri;

    private void unBindSercice() {
        Context context = this.mContext;
        if (context != null) {
            context.unbindService((ServiceConnection)this);
        }
    }

    public void createQRImage(String string2, int n2, Context context, CreateQRImageListener createQRImageListener) {
        this.mListener = createQRImageListener;
        this.mText = string2;
        if (TextUtils.isEmpty((CharSequence)this.mText)) {
            if (createQRImageListener != null) {
                createQRImageListener.onFail();
            }
            return;
        }
        this.mImageSize = n2;
        this.mContext = context;
        Intent intent = new Intent();
        intent.setClassName("com.xiaomi.scanner", SERVICE_ACTION);
        context.bindService(intent, (ServiceConnection)this, 1);
    }

    /*
     * Exception decompiling
     */
    public void onServiceConnected(ComponentName var1, IBinder var2) {
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
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.release();
    }

    public void recogniseQRImage(Uri uri, Context context, RecogniseQRImageListener recogniseQRImageListener) {
        this.mUri = uri;
        this.mContext = context;
        this.mListener = recogniseQRImageListener;
        if (uri == null) {
            if (recogniseQRImageListener != null) {
                recogniseQRImageListener.onFail();
            }
            return;
        }
        Intent intent = new Intent();
        intent.setAction(SERVICE_ACTION);
        context.bindService(intent, (ServiceConnection)this, 1);
    }

    public void release() {
        try {
            this.unBindSercice();
            this.mContext = null;
            this.mListener = null;
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }

    public static interface BarcodeListener {
        public void onFail();
    }

}

