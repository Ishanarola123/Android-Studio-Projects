/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.view.View
 *  android.view.Window
 *  androidx.appcompat.app.AlertDialog
 *  androidx.appcompat.app.AlertDialog$Builder
 *  androidx.preference.DialogPreference
 *  androidx.preference.PreferenceDialogFragmentCompat
 *  java.lang.CharSequence
 *  java.lang.Object
 *  miuix.appcompat.app.AlertDialog
 *  miuix.appcompat.app.AlertDialog$Builder
 *  miuix.preference.BuilderDelegate
 */
package miuix.preference;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AlertDialog;
import androidx.preference.DialogPreference;
import androidx.preference.PreferenceDialogFragmentCompat;
import miuix.appcompat.app.AlertDialog;
import miuix.preference.BuilderDelegate;
import miuix.preference.IPreferenceDialogFragment;

class PreferenceDialogFragmentCompatDelegate {
    private PreferenceDialogFragmentCompat mFragmentCompat;
    private IPreferenceDialogFragment mInternal;

    public PreferenceDialogFragmentCompatDelegate(IPreferenceDialogFragment iPreferenceDialogFragment, PreferenceDialogFragmentCompat preferenceDialogFragmentCompat) {
        this.mInternal = iPreferenceDialogFragment;
        this.mFragmentCompat = preferenceDialogFragmentCompat;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Context context = this.mFragmentCompat.getContext();
        DialogPreference dialogPreference = this.mFragmentCompat.getPreference();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        BuilderDelegate builderDelegate = new BuilderDelegate(context, builder);
        builderDelegate.setTitle(dialogPreference.getDialogTitle());
        builderDelegate.setIcon(dialogPreference.getDialogIcon());
        builderDelegate.setPositiveButton(dialogPreference.getPositiveButtonText(), (DialogInterface.OnClickListener)this.mFragmentCompat);
        builderDelegate.setNegativeButton(dialogPreference.getNegativeButtonText(), (DialogInterface.OnClickListener)this.mFragmentCompat);
        View view = this.mInternal.onCreateDialogView(context);
        if (view != null) {
            this.mInternal.onBindDialogView(view);
            builderDelegate.setView(view);
        } else {
            builderDelegate.setMessage(dialogPreference.getDialogMessage());
        }
        this.mInternal.onPrepareDialogBuilder(builder);
        miuix.appcompat.app.AlertDialog alertDialog = builder.create();
        if (this.mInternal.needInputMethod()) {
            alertDialog.getWindow().setSoftInputMode(5);
        }
        return alertDialog;
    }
}

