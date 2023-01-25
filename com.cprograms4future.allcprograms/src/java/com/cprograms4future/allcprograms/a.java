/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.Intent
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.net.Uri
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.Button
 *  java.lang.CharSequence
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 */
package com.cprograms4future.allcprograms;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.view.View;
import android.widget.Button;

public class a {
    private static final String APP_PNAME = "com.cprograms4future.allcprograms";
    private static final String APP_TITLE = "All C Programs";
    private static final int DAYS_UNTIL_PROMPT = 3;
    private static final int LAUNCHES_UNTIL_PROMPT = 3;

    public static void app_launched(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("apprater", 0);
        if (sharedPreferences.getBoolean("dontshowagain", false)) {
            return;
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        long l2 = 1L + sharedPreferences.getLong("launch_count", 0L);
        editor.putLong("launch_count", l2);
        Long l3 = sharedPreferences.getLong("date_firstlaunch", 0L);
        if (l3 == 0L) {
            l3 = System.currentTimeMillis();
            editor.putLong("date_firstlaunch", l3.longValue());
        }
        if (l2 >= 3L && System.currentTimeMillis() >= 259200000L + l3) {
            a.showRateDialog(context, editor);
        }
        editor.commit();
    }

    public static void showRateDialog(final Context context, final SharedPreferences.Editor editor) {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(1);
        dialog.setContentView(2131492903);
        dialog.setTitle((CharSequence)"Support App");
        ((Button)dialog.findViewById(2131296331)).setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse((String)"http://play.google.com/store/apps/details?id=com.cprograms4future.allcprograms")));
                if (editor != null) {
                    editor.putBoolean("dontshowagain", true);
                    editor.commit();
                }
                dialog.dismiss();
            }
        });
        ((Button)dialog.findViewById(2131296333)).setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        ((Button)dialog.findViewById(2131296332)).setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                if (editor != null) {
                    editor.putBoolean("dontshowagain", true);
                    editor.commit();
                }
                dialog.dismiss();
            }
        });
        dialog.show();
    }

}

