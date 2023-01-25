/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.res.AssetManager
 *  android.content.res.AssetManager$AssetInputStream
 *  android.net.Uri
 *  android.util.Log
 *  java.io.ByteArrayInputStream
 *  java.io.FileInputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Enum
 *  java.lang.IllegalStateException
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.nio.channels.FileChannel
 */
package miuix.io;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;

public class ResettableInputStream
extends InputStream {
    private final AssetManager mAssetManager;
    private final String mAssetPath;
    private final byte[] mByteArray;
    private final Context mContext;
    private final Object mFinalizeGuardian = new Object(){

        protected void finalize() throws Throwable {
            try {
                if (ResettableInputStream.this.mOpenStack != null) {
                    Log.e((String)"ResettableInputStream", (String)"InputStream is opened but never closed here", (Throwable)ResettableInputStream.this.mOpenStack);
                }
                ResettableInputStream.this.close();
                return;
            }
            finally {
                super.finalize();
            }
        }
    };
    private volatile InputStream mInputStream;
    private IOException mLastException;
    private Throwable mOpenStack;
    private final String mPath;
    private final Type mType;
    private final Uri mUri;

    public ResettableInputStream(Context context, Uri uri) {
        if ("file".equals((Object)uri.getScheme())) {
            this.mType = Type.File;
            this.mPath = uri.getPath();
            this.mContext = null;
            this.mUri = null;
            this.mAssetManager = null;
            this.mAssetPath = null;
            this.mByteArray = null;
            return;
        }
        this.mType = Type.Uri;
        this.mContext = context;
        this.mUri = uri;
        this.mPath = null;
        this.mAssetManager = null;
        this.mAssetPath = null;
        this.mByteArray = null;
    }

    public ResettableInputStream(AssetManager assetManager, String string2) {
        this.mType = Type.Asset;
        this.mAssetManager = assetManager;
        this.mAssetPath = string2;
        this.mPath = null;
        this.mContext = null;
        this.mUri = null;
        this.mByteArray = null;
    }

    public ResettableInputStream(String string2) {
        this.mType = Type.File;
        this.mPath = string2;
        this.mContext = null;
        this.mUri = null;
        this.mAssetManager = null;
        this.mAssetPath = null;
        this.mByteArray = null;
    }

    public ResettableInputStream(byte[] arrby) {
        this.mType = Type.ByteArray;
        this.mByteArray = arrby;
        this.mPath = null;
        this.mContext = null;
        this.mUri = null;
        this.mAssetManager = null;
        this.mAssetPath = null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void openStream() throws IOException {
        Object object;
        IOException iOException = this.mLastException;
        if (iOException != null) {
            throw iOException;
        }
        if (this.mInputStream != null) {
            return;
        }
        Object object2 = object = this.mFinalizeGuardian;
        synchronized (object2) {
            if (this.mInputStream != null) {
                return;
            }
            int n = 2.$SwitchMap$miuix$io$ResettableInputStream$Type[this.mType.ordinal()];
            if (n != 1) {
                if (n != 2) {
                    if (n != 3) {
                        if (n != 4) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Unkown type ");
                            stringBuilder.append((Object)this.mType);
                            throw new IllegalStateException(stringBuilder.toString());
                        }
                        this.mInputStream = new ByteArrayInputStream(this.mByteArray);
                    } else {
                        this.mInputStream = this.mAssetManager.open(this.mAssetPath);
                    }
                } else {
                    this.mInputStream = new FileInputStream(this.mPath);
                }
            } else {
                this.mInputStream = this.mContext.getContentResolver().openInputStream(this.mUri);
            }
            this.mOpenStack = new Throwable();
            return;
        }
    }

    public int available() throws IOException {
        this.openStream();
        return this.mInputStream.available();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void close() throws IOException {
        Object object;
        if (this.mInputStream == null) {
            return;
        }
        Object object2 = object = this.mFinalizeGuardian;
        synchronized (object2) {
            if (this.mInputStream == null) {
                return;
            }
            try {
                this.mInputStream.close();
                return;
            }
            finally {
                this.mOpenStack = null;
                this.mInputStream = null;
                this.mLastException = null;
            }
        }
    }

    public void mark(int n) {
        try {
            this.openStream();
            this.mInputStream.mark(n);
            return;
        }
        catch (IOException iOException) {
            this.mLastException = iOException;
            return;
        }
    }

    public boolean markSupported() {
        try {
            this.openStream();
            boolean bl = this.mInputStream.markSupported();
            return bl;
        }
        catch (IOException iOException) {
            this.mLastException = iOException;
            return super.markSupported();
        }
    }

    public int read() throws IOException {
        this.openStream();
        return this.mInputStream.read();
    }

    public int read(byte[] arrby) throws IOException {
        this.openStream();
        return this.mInputStream.read(arrby);
    }

    public int read(byte[] arrby, int n, int n2) throws IOException {
        this.openStream();
        return this.mInputStream.read(arrby, n, n2);
    }

    public void reset() throws IOException {
        ResettableInputStream resettableInputStream = this;
        synchronized (resettableInputStream) {
            if (this.mInputStream != null) {
                if (this.mInputStream instanceof FileInputStream) {
                    ((FileInputStream)this.mInputStream).getChannel().position(0L);
                    return;
                }
                if (!(this.mInputStream instanceof AssetManager.AssetInputStream) && !(this.mInputStream instanceof ByteArrayInputStream)) {
                    this.close();
                } else {
                    this.mInputStream.reset();
                    return;
                }
            }
            return;
        }
    }

    public long skip(long l) throws IOException {
        this.openStream();
        return this.mInputStream.skip(l);
    }

    private static final class Type
    extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES;
        public static final /* enum */ Type Asset;
        public static final /* enum */ Type ByteArray;
        public static final /* enum */ Type File;
        public static final /* enum */ Type Uri;

        static {
            File = new Type();
            Uri = new Type();
            Asset = new Type();
            ByteArray = new Type();
            Type[] arrtype = new Type[]{File, Uri, Asset, ByteArray};
            $VALUES = arrtype;
        }

        public static Type valueOf(String string2) {
            return (Type)Enum.valueOf(Type.class, (String)string2);
        }

        public static Type[] values() {
            return (Type[])$VALUES.clone();
        }
    }

}

