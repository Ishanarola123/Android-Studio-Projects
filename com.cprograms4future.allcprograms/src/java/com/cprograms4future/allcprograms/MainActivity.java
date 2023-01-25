/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.support.design.widget.NavigationView
 *  android.support.design.widget.NavigationView$a
 *  android.support.v4.app.a
 *  android.support.v4.widget.DrawerLayout
 *  android.support.v7.app.e
 *  android.support.v7.widget.Toolbar
 *  android.text.Html
 *  android.util.Log
 *  android.view.InflateException
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.Window
 *  android.widget.Button
 *  android.widget.ExpandableListView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 */
package com.cprograms4future.allcprograms;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.a;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.e;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cprograms4future.allcprograms.Main2Activity;
import com.cprograms4future.allcprograms.MainActivity;
import com.github.clans.fab.FloatingActionMenu;

public class MainActivity
extends e
implements NavigationView.a {
    public static final String PREFS = "PrefsFile";
    private static final String TAG = "MainActivity";
    private SharedPreferences.Editor editor = null;
    ExpandableListView expandableListView;
    FloatingActionMenu fabMain;
    NavigationView navigationView;
    private SharedPreferences settings = null;

    /*
     * Enabled aggressive block sorting
     */
    private void SetNavigationIconColors() {
        int n2;
        int n3;
        Drawable drawable;
        this.navigationView = (NavigationView)this.findViewById(2131296510);
        this.navigationView.setItemIconTintList(null);
        if (Main2Activity.getNightState((Context)this) == 0) {
            Drawable drawable2 = this.navigationView.getMenu().findItem(2131296506).getIcon();
            Resources resources = this.getResources();
            n2 = 2131099686;
            drawable2.setColorFilter(resources.getColor(n2), PorterDuff.Mode.SRC_IN);
            this.navigationView.getMenu().findItem(2131296512).getIcon().setColorFilter(this.getResources().getColor(2131099708), PorterDuff.Mode.SRC_IN);
            this.navigationView.getMenu().findItem(2131296495).getIcon().setColorFilter(this.getResources().getColor(2131099847), PorterDuff.Mode.SRC_IN);
            this.navigationView.getMenu().findItem(2131296492).getIcon().setColorFilter(this.getResources().getColor(2131099740), PorterDuff.Mode.SRC_IN);
            this.navigationView.getMenu().findItem(2131296486).getIcon().setColorFilter(this.getResources().getColor(2131099705), PorterDuff.Mode.SRC_IN);
            this.navigationView.getMenu().findItem(2131296491).getIcon().setColorFilter(this.getResources().getColor(2131099813), PorterDuff.Mode.SRC_IN);
            this.navigationView.getMenu().findItem(2131296509).getIcon().setColorFilter(this.getResources().getColor(2131099814), PorterDuff.Mode.SRC_IN);
            this.navigationView.getMenu().findItem(2131296504).getIcon().setColorFilter(this.getResources().getColor(2131099866), PorterDuff.Mode.SRC_IN);
            this.navigationView.getMenu().findItem(2131296493).getIcon().setColorFilter(this.getResources().getColor(n2), PorterDuff.Mode.SRC_IN);
            this.navigationView.getMenu().findItem(2131296499).getIcon().setColorFilter(this.getResources().getColor(2131099725), PorterDuff.Mode.SRC_IN);
            this.navigationView.getMenu().findItem(2131296320).getIcon().setColorFilter(this.getResources().getColor(2131099847), PorterDuff.Mode.SRC_IN);
            this.navigationView.getMenu().findItem(2131296472).getIcon().setColorFilter(this.getResources().getColor(2131099814), PorterDuff.Mode.SRC_IN);
            this.navigationView.getMenu().findItem(2131296490).getIcon().setColorFilter(this.getResources().getColor(n2), PorterDuff.Mode.SRC_IN);
            this.navigationView.getMenu().findItem(2131296505).getIcon().setColorFilter(this.getResources().getColor(2131099742), PorterDuff.Mode.SRC_IN);
            drawable = this.navigationView.getMenu().findItem(2131296497).getIcon();
            n3 = this.getResources().getColor(2131099823);
        } else {
            Drawable drawable3 = this.navigationView.getMenu().findItem(2131296506).getIcon();
            Resources resources = this.getResources();
            n2 = 2131099865;
            drawable3.setColorFilter(resources.getColor(n2), PorterDuff.Mode.SRC_IN);
            this.navigationView.getMenu().findItem(2131296512).getIcon().setColorFilter(this.getResources().getColor(n2), PorterDuff.Mode.SRC_IN);
            this.navigationView.getMenu().findItem(2131296495).getIcon().setColorFilter(this.getResources().getColor(n2), PorterDuff.Mode.SRC_IN);
            this.navigationView.getMenu().findItem(2131296492).getIcon().setColorFilter(this.getResources().getColor(n2), PorterDuff.Mode.SRC_IN);
            this.navigationView.getMenu().findItem(2131296486).getIcon().setColorFilter(this.getResources().getColor(n2), PorterDuff.Mode.SRC_IN);
            this.navigationView.getMenu().findItem(2131296491).getIcon().setColorFilter(this.getResources().getColor(n2), PorterDuff.Mode.SRC_IN);
            this.navigationView.getMenu().findItem(2131296509).getIcon().setColorFilter(this.getResources().getColor(n2), PorterDuff.Mode.SRC_IN);
            this.navigationView.getMenu().findItem(2131296504).getIcon().setColorFilter(this.getResources().getColor(n2), PorterDuff.Mode.SRC_IN);
            this.navigationView.getMenu().findItem(2131296493).getIcon().setColorFilter(this.getResources().getColor(n2), PorterDuff.Mode.SRC_IN);
            this.navigationView.getMenu().findItem(2131296499).getIcon().setColorFilter(this.getResources().getColor(n2), PorterDuff.Mode.SRC_IN);
            this.navigationView.getMenu().findItem(2131296320).getIcon().setColorFilter(this.getResources().getColor(n2), PorterDuff.Mode.SRC_IN);
            this.navigationView.getMenu().findItem(2131296472).getIcon().setColorFilter(this.getResources().getColor(n2), PorterDuff.Mode.SRC_IN);
            this.navigationView.getMenu().findItem(2131296490).getIcon().setColorFilter(this.getResources().getColor(n2), PorterDuff.Mode.SRC_IN);
            this.navigationView.getMenu().findItem(2131296505).getIcon().setColorFilter(this.getResources().getColor(n2), PorterDuff.Mode.SRC_IN);
            drawable = this.navigationView.getMenu().findItem(2131296497).getIcon();
            n3 = this.getResources().getColor(n2);
        }
        drawable.setColorFilter(n3, PorterDuff.Mode.SRC_IN);
        this.navigationView.getMenu().findItem(2131296502).getIcon().setColorFilter(this.getResources().getColor(n2), PorterDuff.Mode.SRC_IN);
    }

    private void SetNightModeAfterSetContent() {
        ((LinearLayout)this.findViewById(2131296263)).setBackgroundColor(this.getResources().getColor(2131099830));
        ColorStateList colorStateList = new ColorStateList((int[][])new int[][]{{16842910}, {-16842910}, {-16842912}, {16842919}}, new int[]{-1, -1, -1, -1});
        this.navigationView = (NavigationView)this.findViewById(2131296510);
        this.navigationView.setBackgroundColor(this.getResources().getColor(2131099699));
        this.navigationView.setItemTextColor(colorStateList);
    }

    private void SetNightModeTheme() {
        (Toolbar)this.findViewById(2131296615);
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(this.getResources().getColor(2131099684));
        }
        this.setTheme(2131886090);
    }

    private void refreshNightState() {
        Main2Activity.getNightState((Context)this);
    }

    public void ShowTermsandConditions() {
        Dialog dialog = new Dialog((Context)this);
        dialog.requestWindowFeature(1);
        dialog.setContentView(2131492892);
        ((TextView)dialog.findViewById(2131296386)).setText((CharSequence)"Terms and Conditions");
        TextView textView = (TextView)dialog.findViewById(2131296387);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(System.getProperty((String)"line.separator"));
        stringBuilder.append((Object)Html.fromHtml((String)"This Chat is for Education Purpose.So utilise it properly."));
        stringBuilder.append(System.getProperty((String)"line.separator"));
        stringBuilder.append(System.getProperty((String)"line.separator"));
        stringBuilder.append((Object)Html.fromHtml((String)"If any one uses unofficial languange or not uses it for education purpose,their account will be disabled and cannot enter chat again."));
        stringBuilder.append(System.getProperty((String)"line.separator"));
        stringBuilder.append(System.getProperty((String)"line.separator"));
        stringBuilder.append((Object)Html.fromHtml((String)"Please Don't share any of your personal information or credentials through chat,if you did by any mistake then I am not responsible for that.You can report that immediately to cprograms4future@gmail.com so I can delete it from database."));
        stringBuilder.append(System.getProperty((String)"line.separator"));
        stringBuilder.append(System.getProperty((String)"line.separator"));
        stringBuilder.append((Object)Html.fromHtml((String)"We won't call you asking to share your personal information etc so please be careful.Thats all I can say!!"));
        stringBuilder.append(System.getProperty((String)"line.separator"));
        stringBuilder.append(System.getProperty((String)"line.separator"));
        stringBuilder.append((Object)Html.fromHtml((String)"Your data is not shared to others and is protected with full Security.You can always mail me at cprograms4future@gmail.com in case of reporting any kind of issue."));
        stringBuilder.append(System.getProperty((String)"line.separator"));
        stringBuilder.append((Object)Html.fromHtml((String)""));
        textView.setText((CharSequence)stringBuilder.toString());
        ((Button)dialog.findViewById(2131296330)).setOnClickListener(new View.OnClickListener(this, dialog){
            final /* synthetic */ MainActivity this$0;
            final /* synthetic */ Dialog val$dialog;
            {
                this.this$0 = mainActivity;
                this.val$dialog = dialog;
            }

            public void onClick(View view) {
                this.val$dialog.dismiss();
            }
        });
        dialog.show();
    }

    @TargetApi(value=23)
    protected void askPermissions() {
        if (a.a((Context)this, (String)"android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            this.requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 200);
        }
    }

    public void enableNotification(View view) {
        this.editor.putLong("lastRun", System.currentTimeMillis());
        this.editor.putBoolean("enabled", true);
        this.editor.commit();
        Log.v((String)TAG, (String)"Notifications enabled");
    }

    public void onBackPressed() {
        DrawerLayout drawerLayout = (DrawerLayout)this.findViewById(2131296392);
        if (drawerLayout.g(8388611)) {
            drawerLayout.f(8388611);
            return;
        }
        super.onBackPressed();
    }

    /*
     * Exception decompiling
     */
    protected void onCreate(Bundle var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.lang.UnsupportedOperationException
        // org.benf.cfr.reader.b.a.a.f.c(Op01WithProcessedDataAndByteJumps.java:77)
        // org.benf.cfr.reader.entities.e.f.a(ExceptionGroup.java:90)
        // org.benf.cfr.reader.entities.e.f.a(ExceptionGroup.java:67)
        // org.benf.cfr.reader.entities.e.b.a(ExceptionAggregator.java:360)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:273)
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

    public boolean onCreateOptionsMenu(Menu menu) {
        try {
            this.getMenuInflater().inflate(2131558403, menu);
        }
        catch (InflateException inflateException) {}
        return true;
    }

    /*
     * Exception decompiling
     */
    public boolean onNavigationItemSelected(MenuItem var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl59 : ALOAD_0 : trying to set 1 previously set to 0
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

    /*
     * Exception decompiling
     */
    public boolean onOptionsItemSelected(MenuItem var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl1173 : ICONST_1 : trying to set 1 previously set to 0
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

    public void openBenefitsProDialog() {
        Dialog dialog = new Dialog((Context)this);
        dialog.setContentView(2131492905);
        dialog.setTitle(2131820647);
        dialog.show();
    }

    public void openDialog() {
        Dialog dialog = new Dialog((Context)this);
        dialog.requestWindowFeature(1);
        dialog.setContentView(2131492892);
        dialog.setTitle(2131820646);
        TextView textView = (TextView)dialog.findViewById(2131296387);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hi! This is Mahidhar Guggilam who developed this app.\nFirst of all I am very thankful to each and every user of this app for making it a big success with 150k installs in less than a year.");
        stringBuilder.append(System.getProperty((String)"line.separator"));
        stringBuilder.append(System.getProperty((String)"line.separator"));
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("&#8226");
        stringBuilder2.append(" This app is to help students to learn C Programs at any time.First of all I thought to release 2 apps paid and free.Paid app having other features such as Night Mode,Wrap Code,Zoom and Change font and normal app doesn't have all these but I thought this is a learning app which is mostly used by students and may not afford to buy an app and that too app should give comfort while learning and studying so I have released this app with all features for free keeping students in view.");
        stringBuilder.append((Object)Html.fromHtml((String)stringBuilder2.toString()));
        stringBuilder.append(System.getProperty((String)"line.separator"));
        stringBuilder.append(System.getProperty((String)"line.separator"));
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("&#8226");
        stringBuilder3.append("   If you find any issue or any program is missing with some bracket or semicolon or any other issue,please mail at cprograms4future@gmail.com or click on email icon at bottom of screen.");
        stringBuilder.append((Object)Html.fromHtml((String)stringBuilder3.toString()));
        stringBuilder.append(System.getProperty((String)"line.separator"));
        stringBuilder.append(System.getProperty((String)"line.separator"));
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append("&#8226");
        stringBuilder4.append("  I will rectify and upload it ASAP.Not only that if you require any program email to the same mail.");
        stringBuilder.append((Object)Html.fromHtml((String)stringBuilder4.toString()));
        stringBuilder.append(System.getProperty((String)"line.separator"));
        stringBuilder.append(System.getProperty((String)"line.separator"));
        StringBuilder stringBuilder5 = new StringBuilder();
        stringBuilder5.append("&#8226");
        stringBuilder5.append(" If You Liked it Please Share my App and Get Updates by Liking my Facebook Page.Link is Available in Menu.");
        stringBuilder.append((Object)Html.fromHtml((String)stringBuilder5.toString()));
        stringBuilder.append(System.getProperty((String)"line.separator"));
        stringBuilder.append(System.getProperty((String)"line.separator"));
        StringBuilder stringBuilder6 = new StringBuilder();
        stringBuilder6.append("&#8226");
        stringBuilder6.append(" I will update app for every 50 programs or when it reaches 400 in my website.So keep updating.Enjoy Programming.");
        stringBuilder.append((Object)Html.fromHtml((String)stringBuilder6.toString()));
        stringBuilder.append(System.getProperty((String)"line.separator"));
        stringBuilder.append(System.getProperty((String)"line.separator"));
        StringBuilder stringBuilder7 = new StringBuilder();
        stringBuilder7.append("&#8226");
        stringBuilder7.append("All the programs in this app are developed and executed by me.\nI thought to complete explanations to all programs but due to less time I have I am unable to complete it soon.\nHowever,I will try to complete all explanations ASAP.");
        stringBuilder.append((Object)Html.fromHtml((String)stringBuilder7.toString()));
        stringBuilder.append(System.getProperty((String)"line.separator"));
        stringBuilder.append(System.getProperty((String)"line.separator"));
        StringBuilder stringBuilder8 = new StringBuilder();
        stringBuilder8.append("&#8226");
        stringBuilder8.append("Hope you enjoy this app.\nGood Bye.......");
        stringBuilder.append((Object)Html.fromHtml((String)stringBuilder8.toString()));
        stringBuilder.append(System.getProperty((String)"line.separator"));
        stringBuilder.append(System.getProperty((String)"line.separator"));
        textView.setText((CharSequence)stringBuilder.toString());
        ((Button)dialog.findViewById(2131296330)).setOnClickListener(new View.OnClickListener(this, dialog){
            final /* synthetic */ MainActivity this$0;
            final /* synthetic */ Dialog val$dialog;
            {
                this.this$0 = mainActivity;
                this.val$dialog = dialog;
            }

            public void onClick(View view) {
                this.val$dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void recordRunTime() {
        this.editor.putLong("lastRun", System.currentTimeMillis());
        this.editor.commit();
    }

    protected boolean shouldAskPermissions() {
        return Build.VERSION.SDK_INT > 22;
    }
}

