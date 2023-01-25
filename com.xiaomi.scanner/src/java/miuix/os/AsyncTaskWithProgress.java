/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.DialogInterface$OnClickListener
 *  android.os.AsyncTask
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentActivity
 *  androidx.fragment.app.FragmentManager
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.HashMap
 *  miuix.os.AsyncTaskWithProgress$ProgressDialogFragment
 */
package miuix.os;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import java.util.HashMap;
import miuix.os.AsyncTaskWithProgress;

/*
 * Exception performing whole class analysis ignored.
 */
public abstract class AsyncTaskWithProgress<Params, Result>
extends AsyncTask<Params, Integer, Result> {
    private static final HashMap<String, AsyncTaskWithProgress<?, ?>> sAllTasks = new HashMap();
    private boolean mCancelable = false;
    private int mCurrentProgress = 0;
    private volatile ProgressDialogFragment mFragment = null;
    private final FragmentManager mFragmentManager;
    private boolean mIndeterminate = false;
    private final AsyncTaskWithProgress<Params, Result> mListeners = new Listeners();
    private int mMaxProgress = 0;
    private CharSequence mMessage = null;
    private int mMessageId = 0;
    private int mProgressStyle = 0;
    private int mTheme = 0;
    private CharSequence mTitle = null;
    private int mTitleId = 0;

    static {
    }

    public AsyncTaskWithProgress(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
    }

    static /* synthetic */ int access$1000(AsyncTaskWithProgress asyncTaskWithProgress) {
        return asyncTaskWithProgress.mProgressStyle;
    }

    static /* synthetic */ ProgressDialogFragment access$102(AsyncTaskWithProgress asyncTaskWithProgress, ProgressDialogFragment progressDialogFragment) {
        asyncTaskWithProgress.mFragment = progressDialogFragment;
        return progressDialogFragment;
    }

    static /* synthetic */ boolean access$1100(AsyncTaskWithProgress asyncTaskWithProgress) {
        return asyncTaskWithProgress.mIndeterminate;
    }

    static /* synthetic */ int access$1200(AsyncTaskWithProgress asyncTaskWithProgress) {
        return asyncTaskWithProgress.mMaxProgress;
    }

    static /* synthetic */ int access$1300(AsyncTaskWithProgress asyncTaskWithProgress) {
        return asyncTaskWithProgress.mCurrentProgress;
    }

    static /* synthetic */ HashMap access$200() {
        return sAllTasks;
    }

    static /* synthetic */ boolean access$300(AsyncTaskWithProgress asyncTaskWithProgress) {
        return asyncTaskWithProgress.mCancelable;
    }

    static /* synthetic */ Listeners access$400(AsyncTaskWithProgress asyncTaskWithProgress) {
        return asyncTaskWithProgress.mListeners;
    }

    static /* synthetic */ int access$500(AsyncTaskWithProgress asyncTaskWithProgress) {
        return asyncTaskWithProgress.mTheme;
    }

    static /* synthetic */ int access$600(AsyncTaskWithProgress asyncTaskWithProgress) {
        return asyncTaskWithProgress.mTitleId;
    }

    static /* synthetic */ CharSequence access$700(AsyncTaskWithProgress asyncTaskWithProgress) {
        return asyncTaskWithProgress.mTitle;
    }

    static /* synthetic */ int access$800(AsyncTaskWithProgress asyncTaskWithProgress) {
        return asyncTaskWithProgress.mMessageId;
    }

    static /* synthetic */ CharSequence access$900(AsyncTaskWithProgress asyncTaskWithProgress) {
        return asyncTaskWithProgress.mMessage;
    }

    private void dismissDialog() {
        FragmentManager fragmentManager = this.mFragmentManager;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AsyncTaskWithProgress@");
        stringBuilder.append(this.hashCode());
        ProgressDialogFragment progressDialogFragment = fragmentManager.findFragmentByTag(stringBuilder.toString());
        if (progressDialogFragment != null) {
            progressDialogFragment.dismissAllowingStateLoss();
        }
    }

    public Activity getActivity() {
        if (this.mFragment != null) {
            return this.mFragment.getActivity();
        }
        return null;
    }

    public void onCancelled() {
        HashMap<String, AsyncTaskWithProgress<?, ?>> hashMap = sAllTasks;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AsyncTaskWithProgress@");
        stringBuilder.append(this.hashCode());
        hashMap.remove((Object)stringBuilder.toString());
        this.dismissDialog();
    }

    protected void onPostExecute(Result Result) {
        HashMap<String, AsyncTaskWithProgress<?, ?>> hashMap = sAllTasks;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AsyncTaskWithProgress@");
        stringBuilder.append(this.hashCode());
        hashMap.remove((Object)stringBuilder.toString());
        this.dismissDialog();
    }

    protected void onPreExecute() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AsyncTaskWithProgress@");
        stringBuilder.append(this.hashCode());
        String string2 = stringBuilder.toString();
        sAllTasks.put((Object)string2, (Object)this);
        if (this.mFragmentManager != null) {
            this.mFragment = ProgressDialogFragment.newInstance((String)string2);
            this.mFragment.setCancelable(this.mCancelable);
            this.mFragment.show(this.mFragmentManager, string2);
        }
    }

    protected /* varargs */ void onProgressUpdate(Integer ... arrinteger) {
        super.onProgressUpdate((Object[])arrinteger);
        this.mCurrentProgress = arrinteger[0];
        if (this.mFragment != null) {
            this.mFragment.setProgress(this.mCurrentProgress);
        }
    }

    public AsyncTaskWithProgress<Params, Result> setCancelable(boolean bl) {
        this.mCancelable = bl;
        return this;
    }

    public AsyncTaskWithProgress<Params, Result> setIndeterminate(boolean bl) {
        this.mIndeterminate = bl;
        return this;
    }

    public AsyncTaskWithProgress<Params, Result> setMaxProgress(int n) {
        this.mMaxProgress = n;
        return this;
    }

    public AsyncTaskWithProgress<Params, Result> setMessage(int n) {
        this.mMessageId = n;
        this.mMessage = null;
        return this;
    }

    public AsyncTaskWithProgress<Params, Result> setMessage(CharSequence charSequence) {
        this.mMessageId = 0;
        this.mMessage = charSequence;
        return this;
    }

    public AsyncTaskWithProgress<Params, Result> setProgressStyle(int n) {
        this.mProgressStyle = n;
        return this;
    }

    public AsyncTaskWithProgress<Params, Result> setTheme(int n) {
        this.mTheme = n;
        return this;
    }

    public AsyncTaskWithProgress<Params, Result> setTitle(int n) {
        this.mTitleId = n;
        this.mTitle = null;
        return this;
    }

    public AsyncTaskWithProgress<Params, Result> setTitle(CharSequence charSequence) {
        this.mTitleId = 0;
        this.mTitle = charSequence;
        return this;
    }

    private class Listeners
    implements DialogInterface.OnClickListener,
    DialogInterface.OnCancelListener {
        private Listeners() {
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.onClick(dialogInterface, -2);
        }

        public void onClick(DialogInterface dialogInterface, int n) {
            Dialog dialog;
            if (AsyncTaskWithProgress.this.mFragment != null && (dialog = AsyncTaskWithProgress.this.mFragment.getDialog()) != null && dialogInterface == dialog && n == -2) {
                AsyncTaskWithProgress.this.cancel(true);
            }
        }
    }

}

