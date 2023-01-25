/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.xiaomi.scanner.settings.SettingsManager
 *  java.lang.Object
 */
package com.xiaomi.scanner.camera;

import com.xiaomi.scanner.camera.MotionManager;
import com.xiaomi.scanner.settings.SettingsManager;

public interface CameraServices {
    public MotionManager getMotionManager();

    public SettingsManager getSettingsManager();
}

