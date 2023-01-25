/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Looper
 *  android.os.Parcel
 *  android.os.RemoteException
 *  java.lang.Exception
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.concurrent.LinkedBlockingQueue
 *  java.util.concurrent.TimeUnit
 */
package a.a.a.a.a.b;

import a.a.a.a.a.b.e;
import a.a.a.a.a.b.f;
import a.a.a.a.c;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

class e
implements f {
    private final Context a;

    public e(Context context) {
        this.a = context.getApplicationContext();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Override
    public a.a.a.a.a.b.b a() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            c.h().a("Fabric", "AdvertisingInfoServiceStrategy cannot be called on the main thread");
            return null;
        }
        this.a.getPackageManager().getPackageInfo("com.android.vending", 0);
        var3_1 = new ServiceConnection(){
            private boolean a = false;
            private final LinkedBlockingQueue<IBinder> b = new LinkedBlockingQueue(1);

            public IBinder a() {
                if (this.a) {
                    c.h().d("Fabric", "getBinder already called");
                }
                this.a = true;
                try {
                    IBinder iBinder = (IBinder)this.b.poll(200L, TimeUnit.MILLISECONDS);
                    return iBinder;
                }
                catch (InterruptedException interruptedException) {
                    return null;
                }
            }

            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                try {
                    this.b.put((Object)iBinder);
                }
                catch (InterruptedException interruptedException) {}
            }

            public void onServiceDisconnected(ComponentName componentName) {
                this.b.clear();
            }
        };
        var4_2 = new Intent("com.google.android.gms.ads.identifier.service.START");
        var4_2.setPackage("com.google.android.gms");
        var7_3 = this.a.bindService(var4_2, var3_1, 1);
        if (!var7_3) ** GOTO lbl-1000
lbl-1000: // 3 sources:
        {
            catch (Throwable var6_8) {
                c.h().a("Fabric", "Could not bind to Google Play Service to capture AdvertisingId", var6_8);
                return null;
            }
        }
        var8_4 = new IInterface(var3_1.a()){
            private final IBinder a;
            {
                this.a = iBinder;
            }

            /*
             * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            public String a() throws RemoteException {
                Throwable throwable2222;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.a.transact(1, parcel, parcel2, 0);
                parcel2.readException();
                String string = parcel2.readString();
                parcel2.recycle();
                parcel.recycle();
                return string;
                {
                    catch (Throwable throwable2222) {
                    }
                    catch (Exception exception) {}
                    {
                        c.h().a("Fabric", "Could not get parcel from Google Play Service to capture AdvertisingId");
                    }
                    parcel2.recycle();
                    parcel.recycle();
                    return null;
                }
                parcel2.recycle();
                parcel.recycle();
                throw throwable2222;
            }

            public IBinder asBinder() {
                return this.a;
            }

            /*
             * Exception decompiling
             */
            public boolean b() throws RemoteException {
                // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl39 : ALOAD_2 : trying to set 1 previously set to 0
                // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
                // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
                // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
                // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
                // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
                // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
                // org.benf.cfr.reader.entities.g.p(Method.java:396)
                // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
                // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
                // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
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
        };
        var9_5 = new a.a.a.a.a.b.b(var8_4.a(), var8_4.b());
        this.a.unbindService(var3_1);
        return var9_5;
lbl-1000: // 1 sources:
        {
            c.h().a("Fabric", "Could not bind to Google Play Service to capture AdvertisingId");
            return null;
            catch (Exception var1_9) {
                c.h().a("Fabric", "Unable to determine if Google Play Services is available", var1_9);
                return null;
            }
            catch (PackageManager.NameNotFoundException v0) {
                c.h().a("Fabric", "Unable to find Google Play Services package name");
                return null;
            }
            {
                block12 : {
                    catch (Throwable var11_6) {
                        break block12;
                    }
                    catch (Exception var10_7) {}
                    {
                        c.h().c("Fabric", "Exception in binding to Google Play Service to capture AdvertisingId", var10_7);
                    }
                    ** try [egrp 5[TRYBLOCK] [7 : 147->180)] { 
lbl34: // 1 sources:
                    this.a.unbindService(var3_1);
                    return null;
                }
                this.a.unbindService(var3_1);
                throw var11_6;
            }
        }
    }

}

