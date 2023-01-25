/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.AudioDeviceInfo
 *  android.media.AudioManager
 *  android.media.SoundPool
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.SparseIntArray
 *  com.xiaomi.scanner.debug.Log
 *  com.xiaomi.scanner.debug.Log$Tag
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.xiaomi.scanner.camera;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.util.SparseIntArray;
import com.xiaomi.scanner.app.ScannerApp;
import com.xiaomi.scanner.debug.Log;

public class SoundPlayer {
    private static final Log.Tag TAG = new Log.Tag("sound");
    private final AudioManager mAudioManager = (AudioManager)ScannerApp.getAndroidContext().getSystemService("audio");
    private boolean mIsReleased = false;
    private final SparseIntArray mResourceToSoundId = new SparseIntArray();
    private final SoundPool mSoundPool = new SoundPool(1, 3, 0);

    public boolean isCanPlaySound() {
        AudioManager audioManager = this.mAudioManager;
        return audioManager != null && audioManager.getRingerMode() == 2;
    }

    public boolean isReleased() {
        return this.mIsReleased;
    }

    public boolean isUseHeadset() {
        if (this.mAudioManager != null) {
            if (Build.VERSION.SDK_INT < 23) {
                return false;
            }
            AudioDeviceInfo[] arraudioDeviceInfo = this.mAudioManager.getDevices(1);
            if (arraudioDeviceInfo != null) {
                for (AudioDeviceInfo audioDeviceInfo : arraudioDeviceInfo) {
                    if (audioDeviceInfo.getType() != 3 && audioDeviceInfo.getType() != 4) {
                        if (audioDeviceInfo.getType() != 7) continue;
                        return true;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public void loadSound(int n2) {
        try {
            int n3 = this.mSoundPool.load(ScannerApp.getAndroidContext(), n2, 1);
            this.mResourceToSoundId.put(n2, n3);
            return;
        }
        catch (Exception exception) {
            Log.Tag tag = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("loadSound error ");
            stringBuilder.append((Object)exception);
            Log.e((Log.Tag)tag, (String)stringBuilder.toString());
            return;
        }
    }

    public void play(int n2, float f2) {
        if (this.isCanPlaySound()) {
            Integer n3 = this.mResourceToSoundId.get(n2);
            if (n3 != null) {
                this.mSoundPool.play(n3.intValue(), f2, f2, 0, 0, 1.0f);
                return;
            }
            throw new IllegalStateException("Sound not loaded. Must call #loadSound first.");
        }
    }

    public void release() {
        this.mIsReleased = true;
        this.mSoundPool.release();
    }

    public void unloadSound(int n2) {
        Integer n3 = this.mResourceToSoundId.get(n2);
        if (n3 != null) {
            this.mSoundPool.unload(n3.intValue());
            return;
        }
        throw new IllegalStateException("Sound not loaded. Must call #loadSound first.");
    }
}

