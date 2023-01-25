/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  java.lang.Object
 *  miuix.appcompat.app.AlertDialog
 *  miuix.appcompat.app.AlertDialog$Builder
 */
package miuix.preference;

import android.content.Context;
import android.view.View;
import miuix.appcompat.app.AlertDialog;

interface IPreferenceDialogFragment {
    public boolean needInputMethod();

    public void onBindDialogView(View var1);

    public View onCreateDialogView(Context var1);

    public void onPrepareDialogBuilder(AlertDialog.Builder var1);
}

