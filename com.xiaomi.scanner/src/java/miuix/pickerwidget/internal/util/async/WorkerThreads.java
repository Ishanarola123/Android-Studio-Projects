/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.util.ArrayMap
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package miuix.pickerwidget.internal.util.async;

import android.os.HandlerThread;
import android.os.Looper;
import android.util.ArrayMap;
import java.util.Map;

public class WorkerThreads {
    public static final String TAG_COMMON_WORK = "common_work";
    private static final Map<String, ThreadWrapper> sWorkers = new ArrayMap();

    private WorkerThreads() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Looper aquireWorker(String string2) {
        Class<WorkerThreads> class_ = WorkerThreads.class;
        synchronized (WorkerThreads.class) {
            ThreadWrapper threadWrapper = (ThreadWrapper)sWorkers.get((Object)string2);
            if (threadWrapper == null) {
                threadWrapper = new ThreadWrapper(string2);
                sWorkers.put((Object)string2, (Object)threadWrapper);
                return threadWrapper.thread.getLooper();
            } else {
                threadWrapper.refCount = 1 + threadWrapper.refCount;
            }
            return threadWrapper.thread.getLooper();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void releaseWorker(String string2) {
        Class<WorkerThreads> class_ = WorkerThreads.class;
        synchronized (WorkerThreads.class) {
            ThreadWrapper threadWrapper = (ThreadWrapper)sWorkers.get((Object)string2);
            if (threadWrapper != null) {
                threadWrapper.refCount = -1 + threadWrapper.refCount;
                if (threadWrapper.refCount == 0) {
                    sWorkers.remove((Object)string2);
                    threadWrapper.thread.quitSafely();
                }
            }
            // ** MonitorExit[var5_1] (shouldn't be in output)
            return;
        }
    }

    private static class ThreadWrapper {
        int refCount = 1;
        final HandlerThread thread;

        ThreadWrapper(String string2) {
            this.thread = new HandlerThread(string2);
            this.thread.start();
        }
    }

}

