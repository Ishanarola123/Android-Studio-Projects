/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Environment
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.InstantiationException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package miuix.os;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Environment
extends android.os.Environment {
    private static File EXTERNAL_STORAGE_MIUI_DIRECTORY;
    private static final File MIUI_APP_DIRECTORY;
    private static final File MIUI_CUSTOMIZED_DIRECTORY;
    private static final File MIUI_DATA_DIRECTORY;
    private static final String MIUI_DIRECTORY_NAME = "MIUI";
    private static final File MIUI_PRESET_APP_DIRECTORY;
    private static int sCpuCount;

    static {
        MIUI_DATA_DIRECTORY = new File("/data/miui/");
        MIUI_APP_DIRECTORY = new File(Environment.getMiuiDataDirectory(), "apps");
        MIUI_PRESET_APP_DIRECTORY = new File(Environment.getMiuiDataDirectory(), "preset_apps");
        MIUI_CUSTOMIZED_DIRECTORY = new File(Environment.getMiuiDataDirectory(), "current");
        sCpuCount = 0;
    }

    protected Environment() throws InstantiationException {
        throw new InstantiationException("Cannot instantiate utility class");
    }

    public static int getCpuCount() {
        if (sCpuCount == 0) {
            Pattern pattern = Pattern.compile((String)"cpu[0-9]*");
            String[] arrstring = new File("/sys/devices/system/cpu/").list();
            int n = arrstring.length;
            int n2 = 0;
            for (int i = 0; i < n; ++i) {
                if (!pattern.matcher((CharSequence)arrstring[i]).matches()) continue;
                ++n2;
            }
            sCpuCount = n2;
        }
        return sCpuCount;
    }

    public static File getExternalStorageMiuiDirectory() {
        block3 : {
            try {
                if (EXTERNAL_STORAGE_MIUI_DIRECTORY != null) break block3;
                EXTERNAL_STORAGE_MIUI_DIRECTORY = new File(Environment.getExternalStorageDirectory(), MIUI_DIRECTORY_NAME);
            }
            catch (Exception exception) {
                exception.printStackTrace();
                return null;
            }
        }
        if (!EXTERNAL_STORAGE_MIUI_DIRECTORY.exists() && Environment.getExternalStorageDirectory().exists()) {
            EXTERNAL_STORAGE_MIUI_DIRECTORY.mkdir();
        }
        return EXTERNAL_STORAGE_MIUI_DIRECTORY;
    }

    public static File getMiuiAppDirectory() {
        return MIUI_APP_DIRECTORY;
    }

    public static File getMiuiCustomizedDirectory() {
        return MIUI_CUSTOMIZED_DIRECTORY;
    }

    public static File getMiuiDataDirectory() {
        return MIUI_DATA_DIRECTORY;
    }

    public static File getMiuiPresetAppDirectory() {
        return MIUI_PRESET_APP_DIRECTORY;
    }

    public static boolean isExternalStorageMounted() {
        return "mounted".equals((Object)Environment.getExternalStorageState());
    }
}

