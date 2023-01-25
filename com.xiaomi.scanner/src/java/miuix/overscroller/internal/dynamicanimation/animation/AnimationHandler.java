/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.SystemClock
 *  android.util.ArrayMap
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.ThreadLocal
 *  java.util.ArrayList
 *  miuix.overscroller.internal.dynamicanimation.animation.AnimationHandler$FrameCallbackProvider14
 *  miuix.overscroller.internal.dynamicanimation.animation.AnimationHandler$FrameCallbackProvider16
 */
package miuix.overscroller.internal.dynamicanimation.animation;

import android.os.Build;
import android.os.SystemClock;
import android.util.ArrayMap;
import java.util.ArrayList;
import miuix.overscroller.internal.dynamicanimation.animation.AnimationHandler;

/*
 * Exception performing whole class analysis.
 */
class AnimationHandler {
    private static final long FRAME_DELAY_MS = 10L;
    public static final ThreadLocal<AnimationHandler> sAnimatorHandler;
    final ArrayList<AnimationFrameCallback> mAnimationCallbacks;
    private final AnimationCallbackDispatcher mCallbackDispatcher;
    long mCurrentFrameTime;
    private final ArrayMap<AnimationFrameCallback, Long> mDelayedCallbackStartTime;
    private boolean mListDirty;
    private AnimationFrameCallbackProvider mProvider;

    static {
        sAnimatorHandler = new ThreadLocal();
    }

    AnimationHandler() {
        this.mDelayedCallbackStartTime = new ArrayMap();
        this.mAnimationCallbacks = new ArrayList();
        this.mCallbackDispatcher = new AnimationCallbackDispatcher();
        this.mCurrentFrameTime = 0L;
        this.mListDirty = false;
    }

    private void cleanUpList() {
        if (this.mListDirty) {
            for (int i = -1 + this.mAnimationCallbacks.size(); i >= 0; --i) {
                if (this.mAnimationCallbacks.get(i) != null) continue;
                this.mAnimationCallbacks.remove(i);
            }
            this.mListDirty = false;
        }
    }

    public static long getFrameTime() {
        if (sAnimatorHandler.get() == null) {
            return 0L;
        }
        return ((AnimationHandler)AnimationHandler.sAnimatorHandler.get()).mCurrentFrameTime;
    }

    public static AnimationHandler getInstance() {
        if (sAnimatorHandler.get() == null) {
            sAnimatorHandler.set((Object)new AnimationHandler());
        }
        return (AnimationHandler)sAnimatorHandler.get();
    }

    private boolean isCallbackDue(AnimationFrameCallback animationFrameCallback, long l) {
        Long l2 = (Long)this.mDelayedCallbackStartTime.get((Object)animationFrameCallback);
        if (l2 == null) {
            return true;
        }
        if (l2 < l) {
            this.mDelayedCallbackStartTime.remove((Object)animationFrameCallback);
            return true;
        }
        return false;
    }

    public void addAnimationFrameCallback(AnimationFrameCallback animationFrameCallback, long l) {
        if (this.mAnimationCallbacks.size() == 0) {
            this.getProvider().postFrameCallback();
        }
        if (!this.mAnimationCallbacks.contains((Object)animationFrameCallback)) {
            this.mAnimationCallbacks.add((Object)animationFrameCallback);
        }
        if (l > 0L) {
            this.mDelayedCallbackStartTime.put((Object)animationFrameCallback, (Object)(l + SystemClock.uptimeMillis()));
        }
    }

    void doAnimationFrame(long l) {
        long l2 = SystemClock.uptimeMillis();
        for (int i = 0; i < this.mAnimationCallbacks.size(); ++i) {
            AnimationFrameCallback animationFrameCallback = (AnimationFrameCallback)this.mAnimationCallbacks.get(i);
            if (animationFrameCallback == null || !this.isCallbackDue(animationFrameCallback, l2)) continue;
            animationFrameCallback.doAnimationFrame(l);
        }
        this.cleanUpList();
    }

    AnimationFrameCallbackProvider getProvider() {
        if (this.mProvider == null) {
            this.mProvider = Build.VERSION.SDK_INT >= 16 ? new /* Unavailable Anonymous Inner Class!! */ : new /* Unavailable Anonymous Inner Class!! */;
        }
        return this.mProvider;
    }

    public void removeCallback(AnimationFrameCallback animationFrameCallback) {
        this.mDelayedCallbackStartTime.remove((Object)animationFrameCallback);
        int n = this.mAnimationCallbacks.indexOf((Object)animationFrameCallback);
        if (n >= 0) {
            this.mAnimationCallbacks.set(n, null);
            this.mListDirty = true;
        }
    }

    public void setProvider(AnimationFrameCallbackProvider animationFrameCallbackProvider) {
        this.mProvider = animationFrameCallbackProvider;
    }

    class AnimationCallbackDispatcher {
        AnimationCallbackDispatcher() {
        }

        void dispatchAnimationFrame() {
            AnimationHandler.this.mCurrentFrameTime = SystemClock.uptimeMillis();
            AnimationHandler animationHandler = AnimationHandler.this;
            animationHandler.doAnimationFrame(animationHandler.mCurrentFrameTime);
            if (AnimationHandler.this.mAnimationCallbacks.size() > 0) {
                AnimationHandler.this.getProvider().postFrameCallback();
            }
        }
    }

    static interface AnimationFrameCallback {
        public boolean doAnimationFrame(long var1);
    }

    static abstract class AnimationFrameCallbackProvider {
        final AnimationCallbackDispatcher mDispatcher;

        AnimationFrameCallbackProvider(AnimationCallbackDispatcher animationCallbackDispatcher) {
            this.mDispatcher = animationCallbackDispatcher;
        }

        abstract void postFrameCallback();
    }

}

