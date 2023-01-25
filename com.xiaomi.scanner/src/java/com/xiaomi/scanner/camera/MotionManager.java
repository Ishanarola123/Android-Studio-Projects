/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.hardware.Sensor
 *  android.hardware.SensorEvent
 *  android.hardware.SensorEventListener
 *  android.hardware.SensorManager
 *  com.xiaomi.scanner.debug.Log
 *  com.xiaomi.scanner.debug.Log$Tag
 *  java.lang.Double
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Iterator
 *  java.util.LinkedList
 */
package com.xiaomi.scanner.camera;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.xiaomi.scanner.debug.Log;
import java.util.Iterator;
import java.util.LinkedList;

public class MotionManager {
    private static final double ACCELEROMETER_GAP_TOLERANCE = 1.0;
    private static final long EVENT_PROCESS_INTERVAL = 100000000L;
    private static final long EVENT_TIME_OUT = 1000000000L;
    private static final double GYROSCOPE_FOCUS_THRESHOLD = 0.5235987755982988;
    private static final double GYROSCOPE_IGNORE_THRESHOLD = 0.05000000074505806;
    private static final double GYROSCOPE_MOVING_THRESHOLD = 1.5;
    private static final float NS2S = 1.0E-9f;
    private static final Log.Tag TAG = new Log.Tag("MotionManager");
    private long mAccelerometerTimeStamp = 0L;
    private double mAngleTotal = 0.0;
    private final Sensor mGyroscope;
    private SensorEventListener mGyroscopeListener = new SensorEventListener(){

        public void onAccuracyChanged(Sensor sensor, int n2) {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            long l2 = Math.abs((long)(sensorEvent.timestamp - MotionManager.this.mGyroscopeTimeStamp));
            if (l2 >= 100000000L) {
                if (!MotionManager.this.isEnabled()) {
                    return;
                }
                if (MotionManager.this.mGyroscopeTimeStamp != 0L && l2 <= 1000000000L) {
                    float f2 = 1.0E-9f * (float)l2;
                    double d2 = Math.sqrt((double)(sensorEvent.values[0] * sensorEvent.values[0] + sensorEvent.values[1] * sensorEvent.values[1] + sensorEvent.values[2] * sensorEvent.values[2]));
                    MotionManager.this.mGyroscopeTimeStamp = sensorEvent.timestamp;
                    if (d2 > 1.5) {
                        MotionManager.this.deviceMoving();
                        return;
                    }
                    if (d2 < 0.05000000074505806) {
                        return;
                    }
                    MotionManager motionManager = MotionManager.this;
                    double d3 = motionManager.mAngleTotal;
                    double d4 = f2;
                    Double.isNaN((double)d4);
                    motionManager.mAngleTotal = d3 + d2 * d4;
                    if (MotionManager.this.mAngleTotal > 0.5235987755982988) {
                        MotionManager.this.mAngleTotal = 0.0;
                        MotionManager.this.deviceMoving();
                    }
                    return;
                }
                MotionManager.this.mGyroscopeTimeStamp = sensorEvent.timestamp;
            }
        }
    };
    private long mGyroscopeTimeStamp = 0L;
    private boolean mIsEnabled = false;
    private SensorEventListener mLinearAccelerationListener = new SensorEventListener(){

        public void onAccuracyChanged(Sensor sensor, int n2) {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            long l2 = Math.abs((long)(sensorEvent.timestamp - MotionManager.this.mAccelerometerTimeStamp));
            if (l2 >= 100000000L) {
                if (!MotionManager.this.isEnabled()) {
                    return;
                }
                if (MotionManager.this.mAccelerometerTimeStamp != 0L && l2 <= 1000000000L) {
                    double d2 = Math.sqrt((double)(sensorEvent.values[0] * sensorEvent.values[0] + sensorEvent.values[1] * sensorEvent.values[1] + sensorEvent.values[2] * sensorEvent.values[2]));
                    MotionManager.this.mAccelerometerTimeStamp = sensorEvent.timestamp;
                    if (d2 > 1.0) {
                        MotionManager.this.deviceMoving();
                    }
                    return;
                }
                MotionManager.this.mAccelerometerTimeStamp = sensorEvent.timestamp;
            }
        }
    };
    private final Sensor mLinearAccelerometer;
    private final LinkedList<MotionListener> mListeners = new LinkedList();
    private final SensorManager mSensorManager;

    public MotionManager(Context context) {
        this.mSensorManager = (SensorManager)context.getSystemService("sensor");
        this.mGyroscope = this.mSensorManager.getDefaultSensor(4);
        this.mLinearAccelerometer = this.mSensorManager.getDefaultSensor(10);
    }

    private void deviceMoving() {
        Iterator iterator = ((LinkedList)this.mListeners.clone()).iterator();
        while (iterator.hasNext()) {
            ((MotionListener)iterator.next()).onMoving();
        }
    }

    public void addListener(MotionListener motionListener) {
        this.mListeners.add((Object)motionListener);
    }

    public boolean isEnabled() {
        return this.mIsEnabled;
    }

    public void removeListener(MotionListener motionListener) {
        this.mListeners.remove((Object)motionListener);
    }

    public void reset() {
        Log.v((Log.Tag)TAG, (String)"reset");
        this.mListeners.clear();
        this.stop();
    }

    public void start() {
        Log.Tag tag = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("start: enable=");
        stringBuilder.append(this.mIsEnabled);
        Log.v((Log.Tag)tag, (String)stringBuilder.toString());
        if (!this.mIsEnabled) {
            this.mIsEnabled = true;
            Sensor sensor = this.mGyroscope;
            if (sensor != null) {
                this.mSensorManager.registerListener(this.mGyroscopeListener, sensor, 2);
                return;
            }
            Sensor sensor2 = this.mLinearAccelerometer;
            if (sensor2 != null) {
                this.mSensorManager.registerListener(this.mLinearAccelerationListener, sensor2, 2);
            }
        }
    }

    public void stop() {
        Log.Tag tag = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("stop: enable=");
        stringBuilder.append(this.mIsEnabled);
        Log.v((Log.Tag)tag, (String)stringBuilder.toString());
        if (this.mIsEnabled) {
            this.mIsEnabled = false;
            if (this.mGyroscope != null) {
                this.mSensorManager.unregisterListener(this.mGyroscopeListener);
                return;
            }
            SensorEventListener sensorEventListener = this.mLinearAccelerationListener;
            if (sensorEventListener != null) {
                this.mSensorManager.unregisterListener(sensorEventListener);
            }
        }
    }

    public static interface MotionListener {
        public void onMoving();
    }

}

