/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.scanner.camera;

public interface OrientationManager {
    public DeviceOrientation getDeviceOrientation();

    public void pause();

    public void resume();

    public static final class DeviceOrientation
    extends Enum<DeviceOrientation> {
        private static final /* synthetic */ DeviceOrientation[] $VALUES;
        public static final /* enum */ DeviceOrientation CLOCKWISE_0 = new DeviceOrientation(0);
        public static final /* enum */ DeviceOrientation CLOCKWISE_180;
        public static final /* enum */ DeviceOrientation CLOCKWISE_270;
        public static final /* enum */ DeviceOrientation CLOCKWISE_90;
        private final int mDegrees;

        static {
            CLOCKWISE_90 = new DeviceOrientation(90);
            CLOCKWISE_180 = new DeviceOrientation(180);
            CLOCKWISE_270 = new DeviceOrientation(270);
            DeviceOrientation[] arrdeviceOrientation = new DeviceOrientation[]{CLOCKWISE_0, CLOCKWISE_90, CLOCKWISE_180, CLOCKWISE_270};
            $VALUES = arrdeviceOrientation;
        }

        private DeviceOrientation(int n3) {
            this.mDegrees = n3;
        }

        public static DeviceOrientation from(int n2) {
            if (n2 != -1) {
                if (n2 != 0) {
                    if (n2 != 90) {
                        if (n2 != 180) {
                            if (n2 != 270) {
                                int n3 = (n2 + (360 + 360 * Math.abs((int)(n2 / 360)))) % 360;
                                if (n3 <= 315 && n3 > 45) {
                                    if (n3 > 45 && n3 <= 135) {
                                        return CLOCKWISE_90;
                                    }
                                    if (n3 > 135 && n3 <= 225) {
                                        return CLOCKWISE_180;
                                    }
                                    return CLOCKWISE_270;
                                }
                                return CLOCKWISE_0;
                            }
                            return CLOCKWISE_270;
                        }
                        return CLOCKWISE_180;
                    }
                    return CLOCKWISE_90;
                }
                return CLOCKWISE_0;
            }
            return CLOCKWISE_0;
        }

        public static DeviceOrientation valueOf(String string2) {
            return (DeviceOrientation)Enum.valueOf(DeviceOrientation.class, (String)string2);
        }

        public static DeviceOrientation[] values() {
            return (DeviceOrientation[])$VALUES.clone();
        }

        public int getDegrees() {
            return this.mDegrees;
        }
    }

    public static interface OrientationChangeListener {
        public void onOrientationChange(int var1);
    }

}

