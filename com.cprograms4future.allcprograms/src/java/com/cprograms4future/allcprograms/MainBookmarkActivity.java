/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.database.Cursor
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.support.v7.app.e
 *  android.view.InflateException
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.Window
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.ListAdapter
 *  android.widget.ListView
 *  android.widget.SimpleCursorAdapter
 *  android.widget.TextView
 *  com.google.android.gms.ads.AdView
 *  com.google.android.gms.ads.c
 *  com.google.android.gms.ads.c$a
 *  com.google.android.gms.ads.g
 *  java.lang.CharSequence
 *  java.lang.String
 */
package com.cprograms4future.allcprograms;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.e;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import com.cprograms4future.allcprograms.Main2Activity;
import com.cprograms4future.allcprograms.MainBookmarkActivity;
import com.cprograms4future.allcprograms.c;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.c;
import com.google.android.gms.ads.g;

public class MainBookmarkActivity
extends e {
    public static final String KEY_EXTRA_CONTACT_ID = "KEY_EXTRA_CONTACT_ID";
    c dbHelper;
    private g interstitial;
    private ListView listView;
    g mInterstitialAd;

    private void SetNightModeTheme() {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(this.getResources().getColor(2131099684));
        }
        this.setTheme(2131886090);
    }

    private void SetNightModeThemeAfterContent() {
    }

    static /* synthetic */ ListView access$000(MainBookmarkActivity mainBookmarkActivity) {
        return mainBookmarkActivity.listView;
    }

    public void displayInterstitial() {
        if (this.interstitial.a()) {
            this.interstitial.b();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int n2 = Main2Activity.getNightState((Context)this);
        if (n2 == 1) {
            this.SetNightModeTheme();
        }
        this.setContentView(2131492898);
        if (n2 == 1) {
            this.SetNightModeThemeAfterContent();
        }
        ((AdView)this.findViewById(2131296303)).a(new c.a().c("android_studio:ad_template").a());
        this.setTitle((CharSequence)"Bookmarks");
        this.dbHelper = new c((Context)this);
        Cursor cursor = this.dbHelper.getAllBookmarks();
        String[] arrstring = new String[]{"_id", "programName"};
        int[] arrn = new int[]{2131296321, 2131296319};
        SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter((Context)this, 2131492906, cursor, arrstring, arrn, 0);
        if (simpleCursorAdapter.getCount() == 0) {
            ((TextView)this.findViewById(2131296518)).setVisibility(0);
            return;
        }
        this.listView = (ListView)this.findViewById(2131296459);
        this.listView.setAdapter((ListAdapter)simpleCursorAdapter);
        ((TextView)this.findViewById(2131296518)).setVisibility(4);
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener(this){
            final /* synthetic */ MainBookmarkActivity this$0;
            {
                this.this$0 = mainBookmarkActivity;
            }

            public void onItemClick(AdapterView<?> adapterView, View view, int n2, long l2) {
                Cursor cursor = (Cursor)MainBookmarkActivity.access$000(this.this$0).getItemAtPosition(n2);
                String string = cursor.getString(cursor.getColumnIndex("programUrl"));
                android.content.Intent intent = new android.content.Intent(this.this$0.getApplicationContext(), com.cprograms4future.allcprograms.HelloWorld.class);
                intent.setData(android.net.Uri.parse((String)string));
                this.this$0.startActivity(intent);
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        try {
            this.getMenuInflater().inflate(2131558402, menu);
        }
        catch (InflateException inflateException) {}
        return true;
    }

    /*
     * Exception decompiling
     */
    public boolean onOptionsItemSelected(MenuItem var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl182 : ICONST_1 : trying to set 0 previously set to 1
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1162)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:636)
        // java.lang.Thread.run(Thread.java:764)
        throw new IllegalStateException("Decompilation failed");
    }

    public void onResume() {
        super.onResume();
        this.dbHelper = new c((Context)this);
        Cursor cursor = this.dbHelper.getAllBookmarks();
        String[] arrstring = new String[]{"_id", "programName"};
        int[] arrn = new int[]{2131296321, 2131296319};
        SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter((Context)this, 2131492906, cursor, arrstring, arrn, 0);
        if (simpleCursorAdapter.getCount() == 0) {
            this.listView = (ListView)this.findViewById(2131296459);
            this.listView.setAdapter((ListAdapter)simpleCursorAdapter);
            this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener(this){
                final /* synthetic */ MainBookmarkActivity this$0;
                {
                    this.this$0 = mainBookmarkActivity;
                }

                public void onItemClick(AdapterView<?> adapterView, View view, int n2, long l2) {
                    Cursor cursor = (Cursor)MainBookmarkActivity.access$000(this.this$0).getItemAtPosition(n2);
                    String string = cursor.getString(cursor.getColumnIndex("programUrl"));
                    android.content.Intent intent = new android.content.Intent(this.this$0.getApplicationContext(), com.cprograms4future.allcprograms.HelloWorld.class);
                    intent.setData(android.net.Uri.parse((String)string));
                    this.this$0.startActivity(intent);
                }
            });
            ((TextView)this.findViewById(2131296518)).setVisibility(0);
            return;
        }
        this.listView = (ListView)this.findViewById(2131296459);
        this.listView.setAdapter((ListAdapter)simpleCursorAdapter);
        ((TextView)this.findViewById(2131296518)).setVisibility(4);
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener(this){
            final /* synthetic */ MainBookmarkActivity this$0;
            {
                this.this$0 = mainBookmarkActivity;
            }

            public void onItemClick(AdapterView<?> adapterView, View view, int n2, long l2) {
                Cursor cursor = (Cursor)MainBookmarkActivity.access$000(this.this$0).getItemAtPosition(n2);
                String string = cursor.getString(cursor.getColumnIndex("programUrl"));
                android.content.Intent intent = new android.content.Intent(this.this$0.getApplicationContext(), com.cprograms4future.allcprograms.HelloWorld.class);
                intent.setData(android.net.Uri.parse((String)string));
                this.this$0.startActivity(intent);
            }
        });
    }
}

