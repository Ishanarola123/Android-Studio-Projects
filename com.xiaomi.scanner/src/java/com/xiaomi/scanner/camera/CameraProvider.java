/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.ex.camera2.portability.CameraAgent
 *  com.android.ex.camera2.portability.CameraAgent$CameraProxy
 *  com.android.ex.camera2.portability.CameraDeviceInfo
 *  com.android.ex.camera2.portability.CameraDeviceInfo$Characteristics
 *  com.android.ex.camera2.portability.CameraExceptionHandler
 *  java.lang.Object
 */
package com.xiaomi.scanner.camera;

import com.android.ex.camera2.portability.CameraAgent;
import com.android.ex.camera2.portability.CameraDeviceInfo;
import com.android.ex.camera2.portability.CameraExceptionHandler;

public interface CameraProvider {
    public CameraAgent.CameraProxy getCameraDevice();

    public CameraDeviceInfo.Characteristics getCharacteristics(int var1);

    public int getCurrentCameraId();

    public int getFirstBackCameraId();

    public int getFirstFrontCameraId();

    public int getNumberOfCameras();

    public boolean isBackFacingCamera(int var1);

    public boolean isFrontFacingCamera(int var1);

    public void releaseCamera(int var1);

    public void requestCamera(int var1);

    public void setCameraExceptionHandler(CameraExceptionHandler var1);

    public boolean waitingForCamera();
}

