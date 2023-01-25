/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.io.IOException
 *  java.lang.InstantiationException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.Locale
 *  miuix.core.util.FileUtils
 */
package miuix.os;

import android.util.Log;
import java.io.IOException;
import java.util.Locale;
import miuix.core.util.FileUtils;

public class ProcessUtils {
    private static final String TAG = "ProcessUtils";

    protected ProcessUtils() throws InstantiationException {
        throw new InstantiationException("Cannot instantiate utility class");
    }

    public static String getProcessNameByPid(int n) {
        block4 : {
            String string2;
            block5 : {
                Locale locale = Locale.US;
                Object[] arrobject = new Object[]{n};
                String string3 = String.format((Locale)locale, (String)"/proc/%d/cmdline", (Object[])arrobject);
                string2 = FileUtils.readFileAsString((String)string3);
                if (string2 == null) break block4;
                int n2 = string2.indexOf(0);
                if (n2 < 0) break block5;
                try {
                    string2 = string2.substring(0, n2);
                }
                catch (IOException iOException) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Fail to read cmdline: ");
                    stringBuilder.append(string3);
                    Log.e((String)TAG, (String)stringBuilder.toString(), (Throwable)iOException);
                }
            }
            return string2;
        }
        return null;
    }
}

