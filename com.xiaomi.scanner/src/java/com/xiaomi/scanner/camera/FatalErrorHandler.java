/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Deprecated
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.scanner.camera;

public interface FatalErrorHandler {
    public void dismisssErrorDialog();

    @Deprecated
    public void handleFatalError(Reason var1);

    public void onCameraDisabledFailure();

    public void onCameraOpenFailure();

    public void onCameraReconnectFailure();

    public void onGenericCameraAccessFailure();

    public void onMediaStorageFailure();

    public static final class Reason
    extends Enum<Reason> {
        private static final /* synthetic */ Reason[] $VALUES;
        public static final /* enum */ Reason CAMERA_DISABLED_BY_SECURITY_POLICY;
        public static final /* enum */ Reason CAMERA_HAL_FAILED;
        public static final /* enum */ Reason CANNOT_CONNECT_TO_CAMERA;
        public static final /* enum */ Reason MEDIA_STORAGE_FAILURE;
        private final int mDialogMsgId;
        private final int mFeedbackMsgId;
        private final boolean mFinishActivity;

        static {
            Reason reason;
            Reason reason2;
            Reason reason3;
            Reason reason4;
            CANNOT_CONNECT_TO_CAMERA = reason2 = new Reason(2131755192, 2131755201, true);
            CAMERA_HAL_FAILED = reason = new Reason(2131755192, 2131755201, true);
            CAMERA_DISABLED_BY_SECURITY_POLICY = reason4 = new Reason(2131755191, 2131755201, true);
            MEDIA_STORAGE_FAILURE = reason3 = new Reason(2131755194, 2131755202, false);
            Reason[] arrreason = new Reason[]{CANNOT_CONNECT_TO_CAMERA, CAMERA_HAL_FAILED, CAMERA_DISABLED_BY_SECURITY_POLICY, MEDIA_STORAGE_FAILURE};
            $VALUES = arrreason;
        }

        private Reason(int n3, int n4, boolean bl) {
            this.mDialogMsgId = n3;
            this.mFeedbackMsgId = n4;
            this.mFinishActivity = bl;
        }

        public static Reason valueOf(String string2) {
            return (Reason)Enum.valueOf(Reason.class, (String)string2);
        }

        public static Reason[] values() {
            return (Reason[])$VALUES.clone();
        }

        public boolean doesFinishActivity() {
            return this.mFinishActivity;
        }

        public int getDialogMsgId() {
            return this.mDialogMsgId;
        }

        public int getFeedbackMsgId() {
            return this.mFeedbackMsgId;
        }
    }

}

