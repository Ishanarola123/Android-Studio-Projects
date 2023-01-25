/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.content.res.AssetManager
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.support.v7.app.a
 *  android.support.v7.app.e
 *  android.text.Html
 *  android.text.Spanned
 *  android.text.TextUtils
 *  android.util.Base64
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  android.util.TypedValue
 *  android.view.InflateException
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.Window
 *  android.webkit.DownloadListener
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  android.widget.FrameLayout
 *  android.widget.RelativeLayout
 *  android.widget.Toast
 *  com.google.android.gms.ads.AdView
 *  com.google.android.gms.ads.a
 *  com.google.android.gms.ads.c
 *  com.google.android.gms.ads.c$a
 *  com.google.android.gms.ads.g
 *  com.google.android.gms.ads.reward.c
 *  com.google.android.gms.d.f
 *  java.io.BufferedReader
 *  java.io.FileInputStream
 *  java.io.FileNotFoundException
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.InputStreamReader
 *  java.io.OutputStream
 *  java.io.OutputStreamWriter
 *  java.io.Reader
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.cprograms4future.allcprograms;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.e;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.cprograms4future.allcprograms.HelloWorld;
import com.cprograms4future.allcprograms.Main2Activity;
import com.cprograms4future.allcprograms.MainActivity;
import com.cprograms4future.allcprograms.c;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.c;
import com.google.android.gms.ads.g;
import com.google.android.gms.d.f;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.util.List;

public class HelloWorld extends e {
    private static final String DOWNLOAD_URL = "file:///android_asset/AllCPrograms.txt";
    private static final String FILENAME = "AllCPrograms.txt";
    private static final String TAG = MainActivity.class.getName();
    private String currentURL = "";
    private int errorFlag = 0;
    private int hideBookmark = 0;
    private g interstitial;
    g mInterstitialAd;
    private com.google.android.gms.ads.reward.c mRewardedVideoAd;
    View v;
    WebView webHtml_HelloWorld;

    public HelloWorld(Context context, List<d> list) {
        super(context, list);
    }

    private boolean GetIsChecked() {
        return Main2Activity.getNightState((Context)this) == 1;
    }

    private boolean GetIsCheckedBookmark() {
        this.webHtml_HelloWorld = (WebView)this.findViewById(2131296686);
        String string = this.webHtml_HelloWorld.getUrl().toString();
        return new c((Context)this).CheckIsDataAlreadyInDBorNot(string);
    }

    private boolean GetIsCheckedWrap() {
        return Main2Activity.getWrapState((Context)this) == 1;
    }

    private boolean GetIsCheckedZoom() {
        return Main2Activity.getZoomState((Context)this) == 1;
    }

    private void SaveNightState(int n2) {
        SharedPreferences.Editor editor = this.getSharedPreferences("AppNightState", 0).edit();
        editor.putInt("nightState", n2);
        editor.apply();
    }

    private void SaveWrapState(int n2) {
        SharedPreferences.Editor editor = this.getSharedPreferences("AppWrapState", 0).edit();
        editor.putInt("wrapState", n2);
        editor.apply();
    }

    private void SaveZoomState(int n2) {
        SharedPreferences.Editor editor = this.getSharedPreferences("AppZoomState", 0).edit();
        editor.putInt("zoomState", n2);
        editor.apply();
    }

    private void SetNightModeTheme() {
        this.getSupportActionBar().a((Drawable)new ColorDrawable(this.getResources().getColor(2131099699)));
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(this.getResources().getColor(2131099684));
        }
    }

    private void SetNightModeThemeAfterContent() {
        ((RelativeLayout)this.findViewById(2131296260)).setBackgroundColor(this.getResources().getColor(2131099684));
    }

    static /* synthetic */ String access$000() {
        return TAG;
    }

    static /* synthetic */ String access$100(HelloWorld helloWorld, String string) throws IOException {
        return helloWorld.getHtml(string);
    }

    static /* synthetic */ void access$200(HelloWorld helloWorld, String string) {
        helloWorld.writeToFile(string);
    }

    static /* synthetic */ int access$302(HelloWorld helloWorld, int n2) {
        helloWorld.errorFlag = n2;
        return n2;
    }

    static /* synthetic */ void access$400(HelloWorld helloWorld, int n2) {
        helloWorld.injectCSS(n2);
    }

    /*
     * Enabled aggressive block sorting
     */
    private String getHtml(String string) throws IOException {
        String string2;
        InputStream inputStream = this.getAssets().open(string);
        BufferedReader bufferedReader = new BufferedReader((Reader)new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        while ((string2 = bufferedReader.readLine()) != null) {
            stringBuilder.append(string2);
        }
        Spanned spanned = Html.fromHtml((String)stringBuilder.toString());
        char[] arrc = new char[spanned.length()];
        TextUtils.getChars((CharSequence)spanned, (int)0, (int)spanned.length(), (char[])arrc, (int)0);
        String string3 = new String(arrc);
        String string4 = "";
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        do {
            StringBuilder stringBuilder2;
            block13 : {
                block14 : {
                    block10 : {
                        block12 : {
                            block7 : {
                                block11 : {
                                    block9 : {
                                        block8 : {
                                            block6 : {
                                                if (string3.charAt(n2) == '#' || string3.charAt(n2) == '<' || string3.charAt(n2) == '>' || string3.charAt(n2) == ';' || string3.charAt(n2) == '}' || string3.charAt(n2) == '{' || string3.charAt(n2) == '(' || string3.charAt(n2) == ')') break block6;
                                                stringBuilder2 = new StringBuilder();
                                                break block7;
                                            }
                                            string3.charAt(n2);
                                            string3.charAt(n2);
                                            if (string3.charAt(n2) == '<' && n3 == 0) {
                                                ++n4;
                                            }
                                            if (string3.charAt(n2) == '>' && n3 == 0) {
                                                --n4;
                                            }
                                            if (string3.charAt(n2) == '(') {
                                                ++n3;
                                                n4 = 0;
                                            }
                                            if (string3.charAt(n2) == ')') {
                                                --n3;
                                            }
                                            if (n3 <= 0) break block8;
                                            stringBuilder2 = new StringBuilder();
                                            break block7;
                                        }
                                        if (string3.charAt(n2) != ')') break block9;
                                        stringBuilder2 = new StringBuilder();
                                        break block7;
                                    }
                                    if (string3.charAt(n2) == '{' || string3.charAt(n2) == '}') break block10;
                                    if (n4 <= 0) break block11;
                                    stringBuilder2 = new StringBuilder();
                                    break block7;
                                }
                                if (string3.charAt(n2) != '#') break block12;
                                stringBuilder2 = new StringBuilder();
                                stringBuilder2.append(string4);
                                string4 = "\n";
                            }
                            stringBuilder2.append(string4);
                            stringBuilder2.append(string3.charAt(n2));
                            break block13;
                        }
                        stringBuilder2 = new StringBuilder();
                        break block14;
                    }
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(string4);
                    string4 = "\n";
                }
                stringBuilder2.append(string4);
                stringBuilder2.append(string3.charAt(n2));
                stringBuilder2.append("\n");
            }
            string4 = stringBuilder2.toString();
        } while (++n2 < string3.length());
        String string5 = HelloWorld.removeTillWord(string4, "#include", "Output");
        inputStream.close();
        return string5;
    }

    public static int getNightState1(Context context) {
        return context.getSharedPreferences("AppNightState", 0).getInt("nightState", 0);
    }

    public static int getWrapState1(Context context) {
        return context.getSharedPreferences("AppWrapState", 0).getInt("wrapState", 0);
    }

    public static int getZoomState1(Context context) {
        return context.getSharedPreferences("AppZoomState", 0).getInt("zoomState", 0);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void injectCSS(int n2) {
        String string = "fontawesome.css";
        if (n2 == 10) {
            string = "nightModeCSS.css";
        }
        if (n2 == 1) {
            string = "WrapMode.css";
        }
        if (n2 == 11) {
            string = "NightModeWrapMode.css";
        }
        try {
            InputStream inputStream = this.getAssets().open(string);
            byte[] arrby = new byte[inputStream.available()];
            inputStream.read(arrby);
            inputStream.close();
            String string2 = Base64.encodeToString((byte[])arrby, (int)2);
            WebView webView = this.webHtml_HelloWorld;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("javascript:(function() {var parent = document.getElementsByTagName('head').item(0);var style = document.createElement('style');style.type = 'text/css';style.innerHTML = window.atob('");
            stringBuilder.append(string2);
            stringBuilder.append("');parent.appendChild(style)})()");
            webView.loadUrl(stringBuilder.toString());
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }

    private void loadRewardedVideoAd() {
        if (!this.mRewardedVideoAd.a()) {
            this.mRewardedVideoAd.a(this.getResources().getString(2131820587), new c.a().a());
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private String readFromFile() {
        String string;
        String string2;
        StringBuilder stringBuilder;
        try {
            FileInputStream fileInputStream = this.openFileInput(FILENAME);
            if (fileInputStream == null) return "";
            BufferedReader bufferedReader = new BufferedReader((Reader)new InputStreamReader((InputStream)fileInputStream));
            StringBuilder stringBuilder2 = new StringBuilder();
            do {
                String string3;
                if ((string3 = bufferedReader.readLine()) == null) {
                    fileInputStream.close();
                    return stringBuilder2.toString();
                }
                stringBuilder2.append(string3);
            } while (true);
        }
        catch (IOException iOException) {
            string2 = TAG;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Can not read file: ");
            string = iOException.toString();
        }
        catch (FileNotFoundException fileNotFoundException) {
            string2 = TAG;
            stringBuilder = new StringBuilder();
            stringBuilder.append("File not found: ");
            string = fileNotFoundException.toString();
        }
        stringBuilder.append(string);
        Log.e((String)string2, (String)stringBuilder.toString());
        return "";
    }

    private void refreshNightState() {
        int n2 = Main2Activity.getNightState((Context)this);
        int n3 = Main2Activity.getWrapState((Context)this);
        if (n2 == 0 && n3 == 0) {
            this.webHtml_HelloWorld.setWebViewClient(new WebViewClient(this){
                final /* synthetic */ HelloWorld this$0;
                {
                    this.this$0 = helloWorld;
                }

                public void onPageFinished(WebView webView, String string) {
                    HelloWorld.access$400(this.this$0, 0);
                    super.onPageFinished(webView, string);
                }
            });
        }
        if (n2 == 1 && n3 == 0) {
            this.webHtml_HelloWorld.setWebViewClient(new WebViewClient(this){
                final /* synthetic */ HelloWorld this$0;
                {
                    this.this$0 = helloWorld;
                }

                public void onPageFinished(WebView webView, String string) {
                    HelloWorld.access$400(this.this$0, 10);
                    super.onPageFinished(webView, string);
                }
            });
        }
        if (n2 == 0 && n3 == 1) {
            this.webHtml_HelloWorld.setWebViewClient(new WebViewClient(this){
                final /* synthetic */ HelloWorld this$0;
                {
                    this.this$0 = helloWorld;
                }

                public void onPageFinished(WebView webView, String string) {
                    HelloWorld.access$400(this.this$0, 1);
                    super.onPageFinished(webView, string);
                }
            });
        }
        if (n2 == 1 && n3 == 1) {
            this.webHtml_HelloWorld.setWebViewClient(new WebViewClient(this){
                final /* synthetic */ HelloWorld this$0;
                {
                    this.this$0 = helloWorld;
                }

                public void onPageFinished(WebView webView, String string) {
                    HelloWorld.access$400(this.this$0, 11);
                    super.onPageFinished(webView, string);
                }
            });
        }
    }

    private void refreshNightState1() {
        int n2 = HelloWorld.getNightState1((Context)this);
        int n3 = HelloWorld.getWrapState1((Context)this);
        if (n2 == 1 && n3 == 0) {
            this.webHtml_HelloWorld.setWebViewClient(new WebViewClient(this){
                final /* synthetic */ HelloWorld this$0;
                {
                    this.this$0 = helloWorld;
                }

                public void onPageFinished(WebView webView, String string) {
                    HelloWorld.access$400(this.this$0, 10);
                    super.onPageFinished(webView, string);
                }
            });
        }
        if (n2 == 0 && n3 == 1) {
            this.webHtml_HelloWorld.setWebViewClient(new WebViewClient(this){
                final /* synthetic */ HelloWorld this$0;
                {
                    this.this$0 = helloWorld;
                }

                public void onPageFinished(WebView webView, String string) {
                    HelloWorld.access$400(this.this$0, 1);
                    super.onPageFinished(webView, string);
                }
            });
        }
        if (n2 == 1 && n3 == 1) {
            this.webHtml_HelloWorld.setWebViewClient(new WebViewClient(this){
                final /* synthetic */ HelloWorld this$0;
                {
                    this.this$0 = helloWorld;
                }

                public void onPageFinished(WebView webView, String string) {
                    HelloWorld.access$400(this.this$0, 11);
                    super.onPageFinished(webView, string);
                }
            });
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void refreshScreen() {
        (WebView)this.findViewById(2131296686);
        WebSettings webSettings = this.webHtml_HelloWorld.getSettings();
        int n2 = 1;
        webSettings.setBuiltInZoomControls((boolean)n2);
        if (Main2Activity.getZoomState((Context)this) != n2) {
            n2 = 0;
        }
        webSettings.setBuiltInZoomControls((boolean)n2);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void refreshScreen1() {
        (WebView)this.findViewById(2131296686);
        WebSettings webSettings = this.webHtml_HelloWorld.getSettings();
        int n2 = 1;
        webSettings.setBuiltInZoomControls((boolean)n2);
        if (HelloWorld.getZoomState1((Context)this) != n2) {
            n2 = 0;
        }
        webSettings.setBuiltInZoomControls((boolean)n2);
    }

    private void refreshScreenFont() {
        (WebView)this.findViewById(2131296686);
        this.webHtml_HelloWorld.getSettings().setTextZoom(Main2Activity.getFontChange((Context)this));
    }

    public static String removeTillWord(String string, String string2, String string3) {
        return string.substring(string.indexOf(string2), string.indexOf(string3));
    }

    private void writeToFile(String string) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter((OutputStream)this.openFileOutput(FILENAME, 0));
            outputStreamWriter.write(string);
            outputStreamWriter.close();
            return;
        }
        catch (IOException iOException) {
            String string2 = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("File write failed: ");
            stringBuilder.append(iOException.toString());
            Log.e((String)string2, (String)stringBuilder.toString());
            return;
        }
    }

    public void displayInterstitial() {
        if (this.interstitial.a()) {
            this.interstitial.b();
        }
    }

    public int getActionBarHeight() {
        TypedValue typedValue = new TypedValue();
        if (this.getTheme().resolveAttribute(16843499, typedValue, true)) {
            return TypedValue.complexToDimensionPixelSize((int)typedValue.data, (DisplayMetrics)this.getResources().getDisplayMetrics());
        }
        return 0;
    }

    public int getStatusBarHeight() {
        int n2 = this.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (n2 > 0) {
            return this.getResources().getDimensionPixelSize(n2);
        }
        return 0;
    }

    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    protected void onCreate(Bundle var1_1) {
        block427 : {
            block426 : {
                try {
                    block456 : {
                        block455 : {
                            block454 : {
                                block453 : {
                                    block452 : {
                                        block451 : {
                                            block450 : {
                                                block449 : {
                                                    block448 : {
                                                        block447 : {
                                                            block446 : {
                                                                block445 : {
                                                                    block444 : {
                                                                        block443 : {
                                                                            block442 : {
                                                                                block441 : {
                                                                                    block440 : {
                                                                                        block439 : {
                                                                                            block438 : {
                                                                                                block437 : {
                                                                                                    block436 : {
                                                                                                        block435 : {
                                                                                                            block434 : {
                                                                                                                block433 : {
                                                                                                                    block432 : {
                                                                                                                        block431 : {
                                                                                                                            block430 : {
                                                                                                                                block429 : {
                                                                                                                                    block428 : {
                                                                                                                                        super.onCreate(var1_1);
                                                                                                                                        var5_2 = Main2Activity.getNightState((Context)this);
                                                                                                                                        if (var5_2 == 1) {
                                                                                                                                            this.SetNightModeTheme();
                                                                                                                                        }
                                                                                                                                        this.setContentView(2131492893);
                                                                                                                                        if (var5_2 == 1) {
                                                                                                                                            this.SetNightModeThemeAfterContent();
                                                                                                                                        }
                                                                                                                                        ((AdView)this.findViewById(2131296301)).a(new c.a().c("android_studio:ad_template").a());
                                                                                                                                        this.webHtml_HelloWorld = (WebView)this.findViewById(2131296686);
                                                                                                                                        this.webHtml_HelloWorld.getSettings().setJavaScriptEnabled(true);
                                                                                                                                        this.setTitle((CharSequence)"All C Programs");
                                                                                                                                        this.webHtml_HelloWorld.loadUrl(this.getIntent().getDataString());
                                                                                                                                        var6_3 = this.webHtml_HelloWorld.getUrl().toString();
                                                                                                                                        var7_4 = (FloatingActionMenu)this.findViewById(2131296467);
                                                                                                                                        var8_5 = (FrameLayout)this.findViewById(2131296423);
                                                                                                                                        var8_5.setOnTouchListener(new View.OnTouchListener(this, var7_4, var8_5){
                                                                                                                                            final /* synthetic */ HelloWorld this$0;
                                                                                                                                            final /* synthetic */ FloatingActionMenu val$fabMain;
                                                                                                                                            final /* synthetic */ FrameLayout val$mInterceptorFrame;
                                                                                                                                            {
                                                                                                                                                this.this$0 = helloWorld;
                                                                                                                                                this.val$fabMain = floatingActionMenu;
                                                                                                                                                this.val$mInterceptorFrame = frameLayout;
                                                                                                                                            }

                                                                                                                                            public boolean onTouch(View view, android.view.MotionEvent motionEvent) {
                                                                                                                                                Log.d((String)HelloWorld.access$000(), (String)"onTouch  ");
                                                                                                                                                if (this.val$fabMain.b()) {
                                                                                                                                                    this.val$fabMain.c(true);
                                                                                                                                                    this.val$mInterceptorFrame.setBackgroundColor(0);
                                                                                                                                                    return true;
                                                                                                                                                }
                                                                                                                                                return false;
                                                                                                                                            }
                                                                                                                                        });
                                                                                                                                        var7_4.setOnMenuButtonClickListener(new View.OnClickListener(this, var7_4, var8_5){
                                                                                                                                            final /* synthetic */ HelloWorld this$0;
                                                                                                                                            final /* synthetic */ FloatingActionMenu val$fabMain;
                                                                                                                                            final /* synthetic */ FrameLayout val$mInterceptorFrame;
                                                                                                                                            {
                                                                                                                                                this.this$0 = helloWorld;
                                                                                                                                                this.val$fabMain = floatingActionMenu;
                                                                                                                                                this.val$mInterceptorFrame = frameLayout;
                                                                                                                                            }

                                                                                                                                            public void onClick(View view) {
                                                                                                                                                try {
                                                                                                                                                    if (this.val$fabMain.b()) {
                                                                                                                                                        this.val$fabMain.c(true);
                                                                                                                                                        this.val$mInterceptorFrame.setBackgroundColor(0);
                                                                                                                                                        return;
                                                                                                                                                    }
                                                                                                                                                    this.val$mInterceptorFrame.setBackgroundColor(this.this$0.getResources().getColor(2131099686));
                                                                                                                                                    this.val$fabMain.b(true);
                                                                                                                                                }
                                                                                                                                                catch (android.content.ActivityNotFoundException activityNotFoundException) {}
                                                                                                                                            }
                                                                                                                                        });
                                                                                                                                        ((FloatingActionButton)this.findViewById(2131296494)).setOnClickListener(new View.OnClickListener(this, var6_3){
                                                                                                                                            final /* synthetic */ HelloWorld this$0;
                                                                                                                                            final /* synthetic */ String val$webUrl;
                                                                                                                                            {
                                                                                                                                                this.this$0 = helloWorld;
                                                                                                                                                this.val$webUrl = string;
                                                                                                                                            }

                                                                                                                                            public void onClick(View view) {
                                                                                                                                                String string = "";
                                                                                                                                                android.content.ClipboardManager clipboardManager = (android.content.ClipboardManager)this.this$0.getSystemService("clipboard");
                                                                                                                                                try {
                                                                                                                                                    String string2;
                                                                                                                                                    string = string2 = HelloWorld.access$100(this.this$0, this.val$webUrl.toString().substring(22));
                                                                                                                                                }
                                                                                                                                                catch (IOException iOException) {
                                                                                                                                                    iOException.printStackTrace();
                                                                                                                                                }
                                                                                                                                                clipboardManager.setPrimaryClip(android.content.ClipData.newPlainText((CharSequence)"Program", (CharSequence)string));
                                                                                                                                                Toast.makeText((Context)this.this$0.getApplicationContext(), (CharSequence)"Program Copied.\nIf programs Contains comments then please rearrange the code before compiling.", (int)0).show();
                                                                                                                                            }
                                                                                                                                        });
                                                                                                                                        ((FloatingActionButton)this.findViewById(2131296485)).setOnClickListener(new View.OnClickListener(this){
                                                                                                                                            final /* synthetic */ HelloWorld this$0;
                                                                                                                                            {
                                                                                                                                                this.this$0 = helloWorld;
                                                                                                                                            }

                                                                                                                                            public void onClick(View view) {
                                                                                                                                                String string = this.this$0.webHtml_HelloWorld.getUrl().toString();
                                                                                                                                                Intent intent = new Intent("android.intent.action.SEND");
                                                                                                                                                intent.setType("text/plain");
                                                                                                                                                try {
                                                                                                                                                    StringBuilder stringBuilder = new StringBuilder();
                                                                                                                                                    stringBuilder.append(HelloWorld.access$100(this.this$0, string.toString().substring(22)));
                                                                                                                                                    stringBuilder.append("\n\nIf programs Contains comments then please rearrange the code before compiling.\nLearn Over 350+ C Programs with Explanations including Ciphers,Games,Applications,Strings,and all types of Basics.\n https://play.google.com/store/apps/details?id=com.cprograms4future.allcprograms");
                                                                                                                                                    intent.putExtra("android.intent.extra.TEXT", stringBuilder.toString());
                                                                                                                                                }
                                                                                                                                                catch (IOException iOException) {
                                                                                                                                                    iOException.printStackTrace();
                                                                                                                                                }
                                                                                                                                                this.this$0.startActivity(Intent.createChooser((Intent)intent, (CharSequence)"Share Program Via"));
                                                                                                                                            }
                                                                                                                                        });
                                                                                                                                        var9_6 = new String[]{"file:///android_asset/interviewquestions/history_c.html", "file:///android_asset/interviewquestions/why_to_learn_c.html", "file:///android_asset/interviewquestions/low_middle_high_level.html", "file:///android_asset/interviewquestions/compiler_vs_interpreter.html", "file:///android_asset/interviewquestions/include_stdio_means.html", "file:///android_asset/interviewquestions/diff_stdio_vs_doublequot_stdio.html", "file:///android_asset/interviewquestions/header_files.html", "file:///android_asset/interviewquestions/what_is_main.html", "file:///android_asset/interviewquestions/comments_use.html", "file:///android_asset/interviewquestions/structure_c_prog.html", "file:///android_asset/interviewquestions/returntype.html", "file:///android_asset/interviewquestions/void_means.html", "file:///android_asset/interviewquestions/why_semicolon_end.html", "file:///android_asset/interviewquestions/whatifsomeone_tellsyoushould.html", "file:///android_asset/interviewquestions/different_comments.html", "file:///android_asset/interviewquestions/whatisvariable.html", "file:///android_asset/interviewquestions/datatype_and_hw_many.html", "file:///android_asset/interviewquestions/typecast.html", "file:///android_asset/interviewquestions/printfscanf.html", "file:///android_asset/interviewquestions/formatspecifier.html", "file:///android_asset/interviewquestions/printf_syntax.html", "file:///android_asset/interviewquestions/scanf_syntax.html", "file:///android_asset/interviewquestions/significance_point3f.html", "file:///android_asset/interviewquestions/significance_3d.html", "file:///android_asset/interviewquestions/what_is_operator.html", "file:///android_asset/interviewquestions/increment_decrement.html", "file:///android_asset/interviewquestions/postandpreinc_dec.html", "file:///android_asset/interviewquestions/operatorprecedence.html", "file:///android_asset/interviewquestions/ternary.html", "file:///android_asset/interviewquestions/stringtointeger.html", "file:///android_asset/interviewquestions/break.html", "file:///android_asset/interviewquestions/continue.html", "file:///android_asset/interviewquestions/goto.html", "file:///android_asset/interviewquestions/recursion.html", "file:///android_asset/interviewquestions/types_of_functions.html", "file:///android_asset/interviewquestions/calling_called_func_declaration.html", "file:///android_asset/interviewquestions/actual-formal_parametes.html", "file:///android_asset/interviewquestions/return_in_func.html", "file:///android_asset/interviewquestions/parameterpassing_technique.html", "file:///android_asset/interviewquestions/infiniteloop.html", "file:///android_asset/interviewquestions/strcmp.html", "file:///android_asset/interviewquestions/storage_classes.html", "file:///android_asset/interviewquestions/variable_scope.html", "file:///android_asset/interviewquestions/automatic.html", "file:///android_asset/interviewquestions/register.html", "file:///android_asset/interviewquestions/static.html", "file:///android_asset/interviewquestions/external.html", "file:///android_asset/interviewquestions/pointer.html", "file:///android_asset/interviewquestions/nullpointer.html", "file:///android_asset/interviewquestions/danglingpointer.html", "file:///android_asset/interviewquestions/arrayuse.html", "file:///android_asset/interviewquestions/prototype.html", "file:///android_asset/interviewquestions/arraytofunction.html", "file:///android_asset/interviewquestions/recursive_func_way_execute.html", "file:///android_asset/interviewquestions/entry_exit_controlledloop.html", "file:///android_asset/interviewquestions/stringvsarrays.html", "file:///android_asset/interviewquestions/format_vs_unformatted.html", "file:///android_asset/interviewquestions/dynamicmem_alloc.html", "file:///android_asset/interviewquestions/local_vs_global.html", "file:///android_asset/interviewquestions/implicit_vs_explicit.html", "file:///android_asset/interviewquestions/conio_getch.html", "file:///android_asset/interviewquestions/unionvsstructure.html", "file:///android_asset/interviewquestions/def-referenceop.html", "file:///android_asset/interviewquestions/d_o_x_i.html", "file:///android_asset/interviewquestions/shorthand.html", "file:///android_asset/interviewquestions/escapesequnce.html", "file:///android_asset/interviewquestions/print_slash_n.html", "file:///android_asset/interviewquestions/getsgetcgetchar.html", "file:///android_asset/interviewquestions/plusequal_minusequal.html", "file:///android_asset/interviewquestions/gets_vs_scanf.html", "file:///android_asset/interviewquestions/min_execution_do_while.html", "file:///android_asset/interviewquestions/filemodes.html", "file:///android_asset/interviewquestions/application_c.html", "file:///android_asset/interviewquestions/typedef.html", "file:///android_asset/interviewquestions/bitwise.html", "file:///android_asset/interviewquestions/arithmetic.html", "file:///android_asset/interviewquestions/logical_operators.html", "file:///android_asset/interviewquestions/relational.html", "file:///android_asset/interviewquestions/itoa.html", "file:///android_asset/interviewquestions/iscweakly_strongly.html", "file:///android_asset/interviewquestions/print_hello_semi.html", "file:///android_asset/interviewquestions/wildpointer.html", "file:///android_asset/interviewquestions/farpointer.html", "file:///android_asset/interviewquestions/output_percent_d.html", "file:///android_asset/interviewquestions/token.html", "file:///android_asset/interviewquestions/ascii_ansi_full.html", "file:///android_asset/interviewquestions/commandlineargument.html", "file:///android_asset/interviewquestions/func_ret_multiple.html", "file:///android_asset/interviewquestions/output_gen_file_linker.html", "file:///android_asset/interviewquestions/printf_fprintf_sprintf.html", "file:///android_asset/interviewquestions/f_in_printf.html", "file:///android_asset/interviewquestions/hello_Hello_HELLO.html", "file:///android_asset/interviewquestions/files_generated_runc.html", "file:///android_asset/interviewquestions/rules_variables.html", "file:///android_asset/interviewquestions/malloc_realloc_calloc.html", "file:///android_asset/interviewquestions/equal_equalequal.html", "file:///android_asset/interviewquestions/lvalue_rvalue.html", "file:///android_asset/interviewquestions/main_compile.html", "file:///android_asset/interviewquestions/variable_declaration_definition.html", "file:///android_asset/interviewquestions/structure_vs_procedural.html", "file:///android_asset/interviewquestions/fixednumbertimespreferedloop.html", "file:///android_asset/interviewquestions/release_dynamically_allocated_memory.html", "file:///android_asset/interviewquestions/func_used_to_close_file.html", "file:///android_asset/interviewquestions/character_end_string.html", "file:///android_asset/interviewquestions/not_valid_operations_pointer.html", "file:///android_asset/interviewquestions/pointer_array_access.html", "file:///android_asset/interviewquestions/c_derived_from.html", "file:///android_asset/interviewquestions/enumeration.html", "file:///android_asset/interviewquestions/unconditional_branching.html", "file:///android_asset/interviewquestions/file_built_datatype.html", "file:///android_asset/interviewquestions/default_global_local.html", "file:///android_asset/interviewquestions/static_mem_allocation.html", "file:///android_asset/interviewquestions/generic_pointer.html", "file:///android_asset/interviewquestions/cyclic_property.html", "file:///android_asset/interviewquestions/fasterexecution_i_inc.html", "file:///android_asset/interviewquestions/pre_post_inc_fastness.html"};
                                                                                                                                        if (var6_3.equals((Object)"file:///android_asset/hello.html")) {
                                                                                                                                            var10_7 = "Hello World";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.equals((Object)"file:///android_asset/prog_2_print_1to100/print_1to100")) {
                                                                                                                                            var10_7 = "Print 1 to 100";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog3_alphabets_from_A_Z/alphabets_from_A_Z")) {
                                                                                                                                            var10_7 = "Print A to Z";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog4_small_a_z/small_a_z")) {
                                                                                                                                            var10_7 = "Print a to z";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog5_print_odd_or_even/prog4_print_odd_or_even")) {
                                                                                                                                            var10_7 = "Print Odd or Even";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog6_print_n_odd.html")) {
                                                                                                                                            var10_7 = "Print till N Odd Numbers";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog7_swap_using_third_variablle.html")) {
                                                                                                                                            var10_7 = Html.fromHtml((String)"<small>Swap Numbers using 3rd Variable</small>");
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog8_swap_without_third_variable.html")) {
                                                                                                                                            var10_7 = Html.fromHtml((String)"<small>Swap Numbers without using 3rd Variable</small>");
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog9_print_leap_or_not.html")) {
                                                                                                                                            var10_7 = "Check Leap Year or not";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog10_totdays_years_week_days.html")) {
                                                                                                                                            var10_7 = "Convert Days to Years,Week,Days";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog11_biggest_of_three_numbers.html")) {
                                                                                                                                            var10_7 = "Biggest of 3 numbers";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog12_multiply_using_addition.html")) {
                                                                                                                                            var10_7 = "Multiply using Addition";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog13_company_bonus.html")) {
                                                                                                                                            var10_7 = "Company Bonus on Salary";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog14_sum_n_numbers.html")) {
                                                                                                                                            var10_7 = "Sum of N Numbers";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog14_basic_pay.html")) {
                                                                                                                                            var10_7 = "Calculate  Gross Salary";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog1_1_sum_all_digits.html")) {
                                                                                                                                            var10_7 = Html.fromHtml((String)"<small>Sum of all Digits in Number</small>");
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog1_2_print_reverse_number.html")) {
                                                                                                                                            var10_7 = Html.fromHtml((String)"<small>Print Reverse of Given Number</small>");
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog_1_3_num_palindrome_or_not.html")) {
                                                                                                                                            var10_7 = Html.fromHtml((String)"<small>Check Number is Palindrome or not</small>");
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog1_4_sum_integers_divisible_2.html")) {
                                                                                                                                            var10_7 = Html.fromHtml((String)"<small>Sum of integers divisible by 2</small>");
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog1_5_factorial.html")) {
                                                                                                                                            var10_7 = "Factorial of given Number";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog1_6_fibonacci.html")) {
                                                                                                                                            var10_7 = "Fibonacci of given Number";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog1_7_prime_or_not.html")) {
                                                                                                                                            var10_7 = "Prime Number or Not";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog1_8_print_all_prime.html")) {
                                                                                                                                            var10_7 = Html.fromHtml((String)"<small>All Prime numbers till N</small>");
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog1_9_armstrong_or_not.html")) {
                                                                                                                                            var10_7 = "Armstrong or Not";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog1_10_all_armstrong.html")) {
                                                                                                                                            var10_7 = Html.fromHtml((String)"<small>All Armstrong Numbers till N</small>");
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog1_11_perfect_or_not.html")) {
                                                                                                                                            var10_7 = "Perfect or Not";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog1_12_all_perfect.html")) {
                                                                                                                                            var10_7 = Html.fromHtml((String)"<small>All Perfect Numbers till N</small>");
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog1_13_repeated_digits_check.html")) {
                                                                                                                                            var10_7 = Html.fromHtml((String)"<small>Check for repeated digits in Number</small>");
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog1_14_strong_or_not.html")) {
                                                                                                                                            var10_7 = Html.fromHtml((String)"<small>Find whether given number is Strong or Not</small>");
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog1_15_n_strong_numbers.html")) {
                                                                                                                                            var10_7 = Html.fromHtml((String)"<small>Find N Strong Numbers</small>");
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog1_16_magic_or_not.html")) {
                                                                                                                                            var10_7 = Html.fromHtml((String)"<small>Display whether given number is Magic or Not</small>");
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog1_17_magic_till_n.html")) {
                                                                                                                                            var10_7 = Html.fromHtml((String)"<small>Display all Magic Numbers till N</small>");
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog1_18_max_prime_below_n_number.html")) {
                                                                                                                                            var10_7 = Html.fromHtml((String)"<small>Maximum Prime Number below given Number</small>");
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog1_19_prime_num_between_two_numbers.html")) {
                                                                                                                                            var10_7 = Html.fromHtml((String)"<small>Prime Numbers between 2 given numbers</small>");
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog1_20_arrange_zeros_left_ones_left.html")) {
                                                                                                                                            var10_7 = Html.fromHtml((String)"<small>Arrange Zeros to left side and Ones right side in Arrays</small>");
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog1_21_arrangezeros_rhgt_ones_left.html")) {
                                                                                                                                            var10_7 = Html.fromHtml((String)"<small>Arrange Zeros to right side and Ones left side in Arrays</small>");
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog2_0_areas_of_all_tri_para_etc.html")) {
                                                                                                                                            var10_7 = "Areas of Triangle,Circle etc";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog2_1_sine_value.html")) {
                                                                                                                                            var10_7 = "Sine Value Mathematically";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog2_2_cosine_value.html")) {
                                                                                                                                            var10_7 = "Cosine Value Mathematically";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog2_3_quadrant_coordinates.html")) {
                                                                                                                                            var10_7 = Html.fromHtml((String)"<small>Quadrant of Given Co-ordinates</small>");
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog2_4_quadratic_equation_roots.html")) {
                                                                                                                                            var10_7 = Html.fromHtml((String)"<small>Roots of Quadratic Equation</small>");
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog2_5_calculator.html")) {
                                                                                                                                            var10_7 = "Calculator";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog2_6_simple_interest.html")) {
                                                                                                                                            var10_7 = Html.fromHtml((String)"<small>Simple Interest in all ways</small>");
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog2_7_calculate_only_simple_interest.html")) {
                                                                                                                                            var10_7 = "Simple Interest";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog2_8_compound_interest.html")) {
                                                                                                                                            var10_7 = "Compound Interest";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog2_9_polynomial_equation.html")) {
                                                                                                                                            var10_7 = "Polynomial Equation";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog2_10_calculate_permutaion_npr.html")) {
                                                                                                                                            var10_7 = Html.fromHtml((String)"<small>Permutation Value(nPr)</small>");
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog2_11_combination_ncr.html")) {
                                                                                                                                            var10_7 = Html.fromHtml((String)"<small>Combination Value(nCr)</small>");
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog2_12_multiplicative_inverse.html")) {
                                                                                                                                            var10_7 = "Multiplicative Inverse";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog2_13_happy_or_not.html")) {
                                                                                                                                            var10_7 = "Happy Number or Not";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog2_14_happy_till_n.html")) {
                                                                                                                                            var10_7 = Html.fromHtml((String)"<small>Happy Numbers till N</small>");
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog2_15_number_poer_integer.html")) {
                                                                                                                                            var10_7 = Html.fromHtml((String)"<small>Number Power of Integer</small>");
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog2_16_mean_varicance_deviation.html")) {
                                                                                                                                            var10_7 = "Mean,Variance,Deviation";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog2_17_display_x_y_simultaneous.html")) {
                                                                                                                                            var10_7 = Html.fromHtml((String)"<small>Display X,Y of Simultaneous Equation</small>");
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog2_18_display_asquare_rootab_bsquare.html")) {
                                                                                                                                            var10_7 = Html.fromHtml((String)"<small>Display a<sup>2</sup>+&radic;(ab)+b<sup>2</sup></small>");
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog2_19_add_2_polynomials.html")) {
                                                                                                                                            var10_7 = Html.fromHtml((String)"<small>Add 2 Polynomials</small>");
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog2_20_multiply_2_polynomials.html")) {
                                                                                                                                            var10_7 = Html.fromHtml((String)"<small>Multiply 2 Polynomials</small>");
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog2_21_add_n_polynomials.html")) {
                                                                                                                                            var10_7 = Html.fromHtml((String)"<small>Add N Polynomials</small>");
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog2_22_dist_between_2_points.html")) {
                                                                                                                                            var10_7 = Html.fromHtml((String)"<small>Distance between 2 points</small>");
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog2_23_angles_triangle_for_side_lengths.html")) {
                                                                                                                                            var10_7 = Html.fromHtml((String)"<small>Find Angles of Triangle for given lengths of sides</small>");
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog3_0_sumseries1_12_13.html")) {
                                                                                                                                            var10_7 = "1+1/2+1/3+1/4...+1/N";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog3_1_sumseries2_1_12_factorial.html")) {
                                                                                                                                            var10_7 = "1/1!+2/2!+3/3!+...N/N!";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog3_2_sum_AP.html")) {
                                                                                                                                            var10_7 = Html.fromHtml((String)"<small>Arithmetic Progressions(AP) Series</small>");
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog3_3_GP_series.html")) {
                                                                                                                                            var10_7 = Html.fromHtml((String)"<small>Geometric Progressions</small>");
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog3_4_sumseries3_12_22_32_powers.html")) {
                                                                                                                                            var10_7 = "1^2+2^2+3^2...+n^2";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog3_5_sumseries4_12_22_32_power_differnece.html")) {
                                                                                                                                            var10_7 = "1^2-2^2+3^2-4^2...n^2";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog3_6_Sum_AP_2.html")) {
                                                                                                                                            var10_7 = Html.fromHtml((String)"<small>AP Series for given Conditions</small>");
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog3_7_sumseries5_11_22_33_powerfactorial.html")) {
                                                                                                                                            var10_7 = Html.fromHtml((String)"<small>1^1/1!+2^2/2!+3^3/3!..till N^N/N!</small>");
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog3_8_sumseries_6.html")) {
                                                                                                                                            var10_7 = Html.fromHtml((String)"<small>1+(1+2)+(1+2+3)..n</small>");
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog3_9_sumseries_7.html")) {
                                                                                                                                            var10_7 = Html.fromHtml((String)"<small>(1+(1*2)+(1*2*3)+....till N</small>");
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog3_10_series_8.html")) {
                                                                                                                                            var10_7 = Html.fromHtml((String)"<small>-1,4,-7,10,-13....till N</small>");
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog4_0__sum_even_recursion.html")) {
                                                                                                                                            var10_7 = Html.fromHtml((String)"<small>Sum of Even using Recursion</small>");
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog4_1_binary_search_recursion.html")) {
                                                                                                                                            var10_7 = Html.fromHtml((String)"<small>Binary Search Recursion</small>");
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog4_2_bubble_sort_recursion.html")) {
                                                                                                                                            var10_7 = Html.fromHtml((String)"<small>Bubble Sort using Recursion</small>");
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog4_3_check_repeated_digits_recursion.html")) {
                                                                                                                                            var10_7 = Html.fromHtml((String)"<small>Check Repeated Digits using Recursion</small>");
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog4_4_min_number_recursion.html")) {
                                                                                                                                            var10_7 = "Minimum Number using Recursion";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog4_5_factorial_recursion.html")) {
                                                                                                                                            var10_7 = "Factorial using Recursion";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog4_6_gcd_recursion.html")) {
                                                                                                                                            var10_7 = "GCD using Recursion";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog5_0vowel_or_not.html")) {
                                                                                                                                            var10_7 = "Check character is Vowel or Not";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog5_1_count_vowels.html")) {
                                                                                                                                            var10_7 = "Count Vowels in String";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog5_2_length_string.html")) {
                                                                                                                                            var10_7 = "Length of String";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog5_3_count_words_sentence.html")) {
                                                                                                                                            var10_7 = "Count Words in Sentence";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog5_4_vowels_count.html")) {
                                                                                                                                            var10_7 = "Count Vowels in Sentence";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog5_5_letter_repeat_count.html")) {
                                                                                                                                            var10_7 = "Count letter repeatance in sentence";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog5_6_character_frequency.html")) {
                                                                                                                                            var10_7 = "Frequency of each Character";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog5_7_convert_upper_to_lower_viceversa.html")) {
                                                                                                                                            var10_7 = "Convert Upper to Lower case and Vice Versa";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog5_8_count_whitespaces.html")) {
                                                                                                                                            var10_7 = "Count white spaces in Sentence";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog5_9_string_palindrome.html")) {
                                                                                                                                            var10_7 = "String Palindrome or Not";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog5_10_reverse_string.html")) {
                                                                                                                                            var10_7 = "Reverse of Given String";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog5_11_concatenate_string.html")) {
                                                                                                                                            var10_7 = "Concatenate 2 Strings";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog5_12_count_vowels_consonants_etc.html")) {
                                                                                                                                            var10_7 = "Count Vowels,Consonants,Digits,Special Characters";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog5_13_search_substring.html")) {
                                                                                                                                            var10_7 = "Search Substring";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog5_14_compare_strings.html")) {
                                                                                                                                            var10_7 = "Compare 2 Strings";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog5_15_sum_digits_string.html")) {
                                                                                                                                            var10_7 = "Sum of Digits in String";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog5_16_first_capital_letter.html")) {
                                                                                                                                            var10_7 = "Find First Capital Letter";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog5_17_split_sentence.html")) {
                                                                                                                                            var10_7 = Html.fromHtml((String)"<small>Split Sentence for given Character</small>");
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog5_18_sort_names.html")) {
                                                                                                                                            var10_7 = "Sort Names Alphabetically";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog5_19_reverse_words.html")) {
                                                                                                                                            var10_7 = Html.fromHtml((String)"<small>Reverse of Words in given String</small>");
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog5_20_largerst_smallest_word.html")) {
                                                                                                                                            var10_7 = Html.fromHtml((String)"<small>Largest and Smallest Word in Sentence</small>");
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog5_21_largest_smallest_palindrome.html")) {
                                                                                                                                            var10_7 = Html.fromHtml((String)"<small>Largest and Smallest Palindrome in Sentence</small>");
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog5_22_circular_permuted.html")) {
                                                                                                                                            var10_7 = "Circularly Permuted String";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog5_23_remove_repeated.html")) {
                                                                                                                                            var10_7 = "Remove Repeated Words in String";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog5_24_replace_substring_given_string.html")) {
                                                                                                                                            var10_7 = "Replace Substring with given String";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog5_25_limit_characters.html")) {
                                                                                                                                            var10_7 = "Limit number of characters entered by User";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog5_26_words_consecutive_vowels.html")) {
                                                                                                                                            var10_7 = "Words with Consecutive Vowels";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog5_27_subset_words.html")) {
                                                                                                                                            var10_7 = "Find Subsets of Given String";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog5_28_letters_repeated_more.html")) {
                                                                                                                                            var10_7 = "Letters Repeated more number of times";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog5_29_string1_present_string2.html")) {
                                                                                                                                            var10_7 = "Check all Characters from string 1 present in string 2";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog5_30_first_small_letter.html")) {
                                                                                                                                            var10_7 = "First Small Letter in String";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog5_31_find_words_ended_character.html")) {
                                                                                                                                            var10_7 = "All Words ended with given Character";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog5_32_char_need_palindrome.html")) {
                                                                                                                                            var10_7 = "Characters needed to make a String Palindrome";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog5_33_anagrams_or_not.html")) {
                                                                                                                                            var10_7 = "Anagrams or Not";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog5_34_ascii_letters.html")) {
                                                                                                                                            var10_7 = "ASCII Letters";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog5_35_ascii_letters_of_next_character.html")) {
                                                                                                                                            var10_7 = "Print ASCII value of given Character and Print its next character";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog5_36_rev_num_in_words.html")) {
                                                                                                                                            var10_7 = "Display Reverse of Number in words";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog5_37_rev_num_words_separate.html")) {
                                                                                                                                            var10_7 = "Reverse of Given Number in words separate digits";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog5_38_swap_2_strings_without_string.html")) {
                                                                                                                                            var10_7 = "Swap 2 Strings without String Library Functions";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog5_39_all_palindromes_all_non_palindromes.html")) {
                                                                                                                                            var10_7 = "Display All Palindromes and Non-Palindromes in a given sentence";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog5_40_remove_common_alpha_from_string2.html")) {
                                                                                                                                            var10_7 = "Remove all the common alphabets from String 2";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog5_38_swap_2_strings.html")) {
                                                                                                                                            var10_7 = "Swap 2 Strings";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog6_0_length_string_library.html")) {
                                                                                                                                            var10_7 = "String Length using Library Functions";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog6_1_upper_lower_viceversa.html")) {
                                                                                                                                            var10_7 = "Convert upper to lower case vice versa ";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog6_2_reverse_string.html")) {
                                                                                                                                            var10_7 = "Reverse of String using Library Function";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog6_3_palindrome_library_string.html")) {
                                                                                                                                            var10_7 = "Palindrome using Library Functions";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog6_4_string_compare_library.html")) {
                                                                                                                                            var10_7 = "String Comparision using Library Functions";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog6_5_occurance_word_library.html")) {
                                                                                                                                            var10_7 = "Occurance of Word using Library Functions";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog7_0_decimal_binary.html")) {
                                                                                                                                            var10_7 = "Decimal to Binary";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog7_1_binary_decimal.html")) {
                                                                                                                                            var10_7 = "Binary to Decimal";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog7_2_roman_decimal.html")) {
                                                                                                                                            var10_7 = "Roman to Decimal";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog7_3_decimal_octal.html")) {
                                                                                                                                            var10_7 = "Decimal to Octal";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog7_4_octal_decimal.html")) {
                                                                                                                                            var10_7 = "Octal to Decimal";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog7_5_celcius_farenheit.html")) {
                                                                                                                                            var10_7 = "Celsius to Fahrenheit";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog7_6_fahrenheit_celcius.html")) {
                                                                                                                                            var10_7 = "Fahrenheit to Celsius";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog7_7_currency_spped_conversion.html")) {
                                                                                                                                            var10_7 = "Currency Length Speed Conversions";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog7_8_allinone_conversion.html")) {
                                                                                                                                            var10_7 = "All in One Conversion";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog7_9_binary_octal.html")) {
                                                                                                                                            var10_7 = "Binary to Octal";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog7_10_octal_binary.html")) {
                                                                                                                                            var10_7 = "Octal to Binary";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog7_11_binary_hexa.html")) {
                                                                                                                                            var10_7 = "Binary to Hexa Decimal";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog8_0_average_class.html")) {
                                                                                                                                            var10_7 = "Find Average of Class";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog8_1_neg_pos.html")) {
                                                                                                                                            var10_7 = "Sum of -ve and +ve integers";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog8_2_min_max.html")) {
                                                                                                                                            var10_7 = "Min and Max in an Array";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog8_3_max_2_num.html")) {
                                                                                                                                            var10_7 = "First 2 Max numbers in Array";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog8_4_even_odd_separate.html")) {
                                                                                                                                            var10_7 = "Separate Even and Odd Numbers";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog8_5_deleted_element.html")) {
                                                                                                                                            var10_7 = "Delete Spcific Integer n Array";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog8_6_insert_element.html")) {
                                                                                                                                            var10_7 = "Insert element in array at given position";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog8_7_remove_repeated_array.html")) {
                                                                                                                                            var10_7 = "Remove Repeated elements in array";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog8_8_merge_arrays.html")) {
                                                                                                                                            var10_7 = "Merge 2 Arrays";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog8_9_union_intersection.html")) {
                                                                                                                                            var10_7 = "Union and Intersection of 2 Arrays";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog8_10_arraypair_sum_equal_number.html")) {
                                                                                                                                            var10_7 = "Array Pairs whose sum equals Number";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog8_11_largest_diff_bet_array_ele.html")) {
                                                                                                                                            var10_7 = "Largest Difference between 2 arrays";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog8_12_avg_no_even_position.html")) {
                                                                                                                                            var10_7 = "Avg of No.s at even positions";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog8_13_array_rev_swap_method.html")) {
                                                                                                                                            var10_7 = "Array Elements in Reverse Order using Swapping Method";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog8_14_array_pair_near_zero.html")) {
                                                                                                                                            var10_7 = "Array Pair nearest zero";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog8_15_odd_times_repeated_array.html")) {
                                                                                                                                            var10_7 = "Number repeated odd number of times";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog8_16_frequency_array_numbers.html")) {
                                                                                                                                            var10_7 = "Frequency of numbers in array";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog8_17_avg_best2testmarks.html")) {
                                                                                                                                            var10_7 = "Average of best two test marks out of given number of test marks";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog8_18_sum_n_numbers_array.html")) {
                                                                                                                                            var10_7 = "Sum of N Numbers in Array";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog9_0_linear_search.html")) {
                                                                                                                                            var10_7 = "Linear Search";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog9_1_binary_search_with_unsorted_input.html")) {
                                                                                                                                            var10_7 = "Binary Search with un-sorted input";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog9_2_binary_search_sorted_input.html")) {
                                                                                                                                            var10_7 = "Binary Search with sorted input";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog10_0_sort_ascending.html")) {
                                                                                                                                            var10_7 = "Sort Array in Ascending";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog10_1_sort_descending.html")) {
                                                                                                                                            var10_7 = "Sort Array in Descending";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog10_2_bubble_sort.html")) {
                                                                                                                                            var10_7 = "Bubble Sort";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog10_3_insertion_sort.html")) {
                                                                                                                                            var10_7 = "Insertion Sort";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog10_4_selection_sort.html")) {
                                                                                                                                            var10_7 = "Selection Sort";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog10_5_oddeven_sort.html")) {
                                                                                                                                            var10_7 = "Odd Even Sort";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog10_6_row_col_ascnding.html")) {
                                                                                                                                            var10_7 = "Rows and Cols of Matrix in Ascending";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog10_7_row_col_asc2.html")) {
                                                                                                                                            var10_7 = "Rows and Cols of Matrix in Ascending MethodII";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog10_8_row_col_desc.html")) {
                                                                                                                                            var10_7 = "Rows and Cols of Matrix in Descending";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog10_9_row_asc_col_desc.html")) {
                                                                                                                                            var10_7 = "Rows in Asc,Cols in Desc";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog10_10_quicksort.html")) {
                                                                                                                                            var10_7 = "Quick Sort";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog11_0_add_2_matrices.html")) {
                                                                                                                                            var10_7 = "Add 2 Matrices";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog11_1_diff_2_matrices.html")) {
                                                                                                                                            var10_7 = "Sub 2 Matrices";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog11_2_mul_2_matrices.html")) {
                                                                                                                                            var10_7 = "Multiply 2 Matrices";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog11_3_add_n_matrices.html")) {
                                                                                                                                            var10_7 = "Add N Matrices";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog11_4_diff_n_matrices.html")) {
                                                                                                                                            var10_7 = "Sub N Matrices";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog11_5_mul_n_matrices.html")) {
                                                                                                                                            var10_7 = "Multiply N Matrices";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog11_6_compare_matrices.html")) {
                                                                                                                                            var10_7 = "Compare 2 Matrices";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog11_7_transpose_matrix.html")) {
                                                                                                                                            var10_7 = "Transpose of Matrix";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog11_8_trace_matrix.html")) {
                                                                                                                                            var10_7 = "Trace of Matrix";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog11_9_matrix_identity.html")) {
                                                                                                                                            var10_7 = "Matrix is Identity or Not";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog11_10_sum_row_col_matrix.html")) {
                                                                                                                                            var10_7 = "Sum of Rows and Columns";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog11_11_sum_col_goto.html")) {
                                                                                                                                            var10_7 = "Sum of Columns using GOTO";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog11_12_sum_diagonal.html")) {
                                                                                                                                            var10_7 = "Sum of all Diagonals";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog11_13_sparse_matrix.html")) {
                                                                                                                                            var10_7 = "Sparse Matrix";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog11_14_normal_matrix.html")) {
                                                                                                                                            var10_7 = "Normal Matrix";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog11_15_upper_lower_triangle_matrix.html")) {
                                                                                                                                            var10_7 = "Upper and Lower Triangle of Matrix";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog11_16_sum_upper_lower_triangle_matrix.html")) {
                                                                                                                                            var10_7 = "Sum of Upper and Lower Triangle of Matrix";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog11_17_interchange_diagonals.html")) {
                                                                                                                                            var10_7 = "Interchange Diagonals";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog11_18_orthogonal_or_not.html")) {
                                                                                                                                            var10_7 = "Matrix is Orthogonal or Not";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog11_19_matrix_equal_or_not.html")) {
                                                                                                                                            var10_7 = "Matrices are equal or not";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog12_0_automatic.html")) {
                                                                                                                                            var10_7 = "Automatic Storage Class";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog12_1-register.html")) {
                                                                                                                                            var10_7 = "Register Storage Class";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog12_2_static.html")) {
                                                                                                                                            var10_7 = "Voting System using Static Storage Class";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog12_3_external.html")) {
                                                                                                                                            var10_7 = "External Storage Class";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog13_0_variables_value_pointer.html")) {
                                                                                                                                            var10_7 = "Print Values in Variables using pointers";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog13_1_swap_pointer.html")) {
                                                                                                                                            var10_7 = "Swap numbers using pointers";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog13_2_copy_string_pointer.html")) {
                                                                                                                                            var10_7 = "Copy String using Pointers";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog13_3_length_string_pointer.html")) {
                                                                                                                                            var10_7 = "String Length using pointers";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog13_4_concatenate_pointer.html")) {
                                                                                                                                            var10_7 = "Concatenate Strings using pointers";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog13_5_compare_string_pointer.html")) {
                                                                                                                                            var10_7 = "Compare Strings using pointers";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog13_6_inc_array_pointer.html")) {
                                                                                                                                            var10_7 = "Print values by incrementing pointer";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog13_7_dec_array_pointer.html")) {
                                                                                                                                            var10_7 = "Print values by decrementing pointer";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog13_8_char_array_pointer.html")) {
                                                                                                                                            var10_7 = "Print Character Array";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog13_9_sum_array_num_pointer.html")) {
                                                                                                                                            var10_7 = "Sum of Numbers in Array using Pointer";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog13_10_n_char_pointer.html")) {
                                                                                                                                            var10_7 = "Print N Characters from given Position";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog13_11_add_matrix_pointers.html")) {
                                                                                                                                            var10_7 = "Add 2 Matrices using Pointers";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog13_12_subtract_matrix_pointers.html")) {
                                                                                                                                            var10_7 = "Subtract 2 Matrices using Pointers";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog14_0_simple_structure.html")) {
                                                                                                                                            var10_7 = "Simple Structure";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog14_1_simple_structure2.html")) {
                                                                                                                                            var10_7 = "Simple Structure II";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog14_2_structure_pointer.html")) {
                                                                                                                                            var10_7 = "Structure Pointer";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog14_3_structure_array.html")) {
                                                                                                                                            var10_7 = "Structure Array";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog14_4_structure_func.html")) {
                                                                                                                                            var10_7 = "Structure using Function";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog14_5_complex_n_structures.html")) {
                                                                                                                                            var10_7 = "Add N Complex Numbers using Structures";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog14_6_marks_n_students_m_subjects.html")) {
                                                                                                                                            var10_7 = "Marks of all N Students for M subjects";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog15_0_single_linked_list.html")) {
                                                                                                                                            var10_7 = "Single Linked List";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog15_1_linked_list_names.html")) {
                                                                                                                                            var10_7 = "Single Linked List for Names";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog15_2_stacks_arrays.html")) {
                                                                                                                                            var10_7 = "Stacks";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog16_0_read_file.html")) {
                                                                                                                                            var10_7 = "Reading a File";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog16_1_write_files.html")) {
                                                                                                                                            var10_7 = "Writing a File";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog16_2_append_text.html")) {
                                                                                                                                            var10_7 = "Append Text into File";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog16_3_sum_int_file.html")) {
                                                                                                                                            var10_7 = "Sum of Integers in Files";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog16_4_count_tabs_spaces_file.html")) {
                                                                                                                                            var10_7 = "Number of Spaces,Lines,characters,tabs in File";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog16_5_copy_file_another.html")) {
                                                                                                                                            var10_7 = "Copy Text from one file to other";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog16_6_lucky_winner.html")) {
                                                                                                                                            var10_7 = "Are you a Lucky Winner?";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog16_7_contact_files.html")) {
                                                                                                                                            var10_7 = "Store Contacts in Text File";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog16_8_Agenda_text_file.html")) {
                                                                                                                                            var10_7 = "Store todays Agenda using C";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog16_9_separate_odd_even_file.html")) {
                                                                                                                                            var10_7 = "Create a file with a set of numbers and write Odd and Even numbers into separate files";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog16_10_location_of_running_program.html")) {
                                                                                                                                            var10_7 = "Print Loaction of running Program";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog16_11_own_sorce_code.html")) {
                                                                                                                                            var10_7 = "Printing program's own Source Code";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog16_12_merge_2_files.html")) {
                                                                                                                                            var10_7 = "Merge 2 files into another file";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog16_13_merge_n_files.html")) {
                                                                                                                                            var10_7 = "Merge N given files into another file";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog17_0_floyyds.html")) {
                                                                                                                                            var10_7 = "Floyyds Triangle";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog17_2_number_diamond.html")) {
                                                                                                                                            var10_7 = "Number Diamond";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog17_1_number_pyramid_1_232.html")) {
                                                                                                                                            var10_7 = "Number Pyramid";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog17_3_number_diamond_2.html")) {
                                                                                                                                            var10_7 = "Number Diamond II";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog17_5_right_angle_pattern1_22_333.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog17_4_pascals_triangle.html")) {
                                                                                                                                            var10_7 = "Pascals Triangle";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog17_6_right_angle_pattern2_1_12_123.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog17_7_numerical_pattern_1_111_222_333.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog17_8_numerical_pattern_2_123_123_123.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog17_9_reverse_right_angle1_4321_321_21_1.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog17_10_reverse_right_2_1234_123_12_1.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog17_11_rev_pat_3_111_22_3.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog17_12_rev_rigt_pat4_333_22_1.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog17_13_num_patt_4_consecutive_numbers.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog17_14_num_pat6_1_23_357.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog17_15_number_x_pat.html")) {
                                                                                                                                            var10_7 = "Number X Pattern";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog17_16_rev_number_x_pat.html")) {
                                                                                                                                            var10_7 = "Number X Pattern";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog17_15_number_x_pat.html")) {
                                                                                                                                            var10_7 = "Number reverse X Pattern";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog17_17_spiral_pat.html")) {
                                                                                                                                            var10_7 = "Spiral Pattern";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog17_18_misc_num_pat1.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog17_19_mis_num_pat2.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog17_20_mis_num_pat3.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog17_21_misc_num_pat4.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog17_22_mis_num_pat5.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog17_23_1_21_321_right.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog17_24_numerical_hollow_parallelogram.html")) {
                                                                                                                                            var10_7 = "Numerical Hollow Parallelogram pattern";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog17_26_sum_row_right_triangle.html")) {
                                                                                                                                            var10_7 = "Sum of row in right angle Triangle";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog17_25_horizontal_triangle_spiral_pattern.html")) {
                                                                                                                                            var10_7 = "Horizontal Triangle Spiral Pattern";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog18_0_alpha_pat_1_a_bb_ccc.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog18_1_alpha_pat2_a_ab_abc.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog18_2_alp_pat3_aaa_bbb_ccc.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog18_3_alp_pat4_abc_abc_abc.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog18_4_rev_alph_pat1_abc_ab_a.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog18_5_rev_alph_pat2_aaa_bb_c.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog18_6_rev_alpha_pat4_dddd_ccc_bb_a.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog18_6_rev_alp_3_cba_cb_c.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog18_8_alpha_x_pattern.html")) {
                                                                                                                                            var10_7 = "Alphabetical X Pattern";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog18_10_string_symbol_pattern.html")) {
                                                                                                                                            var10_7 = "String as Symbol Pattern";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog18_9_rev_x_pat.html")) {
                                                                                                                                            var10_7 = "Alphabetcal Reverse X Pattern";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog18_11_rev_v_patt.html")) {
                                                                                                                                            var10_7 = "Alphabetcal Reverse V Pattern";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog18_12_spiral_alpha.html")) {
                                                                                                                                            var10_7 = "Alphabetcal Spiral Pattern";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog18_13_alpha_pat6_a_cb_fed.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog18_14_mis_alpha_pat1.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog18_15_mis_alpha_pat2.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog18_16_mis_alpha_pat3.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog18_17_mis_alpha_pat4.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog18_18_mis_alpha_pat5.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog18_19_mis_alpha_num.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog18_20_alpha_hollo_pattern.html")) {
                                                                                                                                            var10_7 = "Alphabetical Hollow Parallelogram Pattern";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog19_0_symbol_diamond_3rows.html")) {
                                                                                                                                            var10_7 = "Symbol Diamond 3 Rows";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog_19_1_symbol_diamond.html")) {
                                                                                                                                            var10_7 = "Symbol Diamond for N Rows";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog19_2_symbol_pattern1.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog19_3_symbol_pattern_2.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog19_4_symbol_patt_3.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog19_5_symbol_pat4.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog19_6_symbol_pat5.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog19_7_symbol_pat_rev_v.html")) {
                                                                                                                                            var10_7 = "Symbol V Pattern";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog19_8_symbol_x_pattern.html")) {
                                                                                                                                            var10_7 = "Symbol X Pattern";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog19_9_symbol_hollow_parallelogram.html")) {
                                                                                                                                            var10_7 = "Symbol Hollow Parallelogram Pattern";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog19_10_symbol_hollow_square.html")) {
                                                                                                                                            var10_7 = "Symbol Hollow Square Pattern";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog19_11_symbol_steps_pattern.html")) {
                                                                                                                                            var10_7 = "Symbol Steps Pattern";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog19_12_left_rev_symbol_step.html")) {
                                                                                                                                            var10_7 = "Left Reverse Symbol Steps Pattern";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog19_13_right_symbol_steps.html")) {
                                                                                                                                            var10_7 = "Right Symbol Steps Pattern";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog19_14_right_rev_symbol_step.html")) {
                                                                                                                                            var10_7 = "Right Reverse Symbol Steps Pattern";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog19_15_left_v_symbol.html")) {
                                                                                                                                            var10_7 = "Left V Symbol Pattern";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog20_0_symb_pyramid.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog20_1_rev_symb_pyramid.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog20_2_left_sym_pyramid.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog20_3_right_sym_pyramid.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog21_0_alpha_pyramid1.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog21_1_alpha_pyramid2.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog21_2_left_alpha_pyramid.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog21_3_right_alpha_pyramid.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog21_4_alpha_pyramid_2.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog21_5_rev_alpha_pyramid2.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog21_6_left_alpha_pyramid2.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog21_7_right_alpha_pyramid2.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog21_8_alpha_pyramid_3.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog21_9_alpha_pyramid_3.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog21_10_left_alpha_pyramid3.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog21_11_right_alpha_pyramid_3.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog21_12_alpha_pyramid4.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog21_13_rev_alpha_pyramid4.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog21_14_left_alpha_pyramid_4.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog21_15_alpha_pyramid_5.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog21_16_rev_alpha_pyramid_5.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog21_17_sand_glass_pat1.html")) {
                                                                                                                                            var10_7 = "Sand Glass Pattern I";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog21_18_sand_glass_pat2.html")) {
                                                                                                                                            var10_7 = "Sand Glass Pattern II";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog21_19_alpha_pyramid_4.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog22_0_num_pyramid_1.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog22_1_rev_num_pyramid_1.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog22_2_left_num_pyramid1.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog22_3_right_num_pyramid1.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog22_4_num_pyramid_2.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog22_5_rev_num_pyramid_2.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog22_6_left_pyramid2.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog22_7_right_num_pyramid2.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog22_8_num_pyramid_3.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog22_9_rev_pyramid_3.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog22_10_left_num_pyramid3.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog22_13_num_sand_glass_patt.html")) {
                                                                                                                                            var10_7 = "Number SandGlass Pattern";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog22_14_left_tensmultiple_pyrmaid.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog22_15_misc_numerical_pattern5.html")) {
                                                                                                                                            var10_7 = "All C Programs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog22_11_ev_binary_pyramid.html")) {
                                                                                                                                            var10_7 = "Reverse Binary Pyramid";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog22_12_bin_pyramid.html")) {
                                                                                                                                            var10_7 = "Binary Pyramid";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog23_0_number_guessing.html")) {
                                                                                                                                            var10_7 = "Number Guessing Game";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog23_1_tic_tac_toe.html")) {
                                                                                                                                            var10_7 = "TIC-TAC-TOE Game";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog23_2_towrs_hanoi.html")) {
                                                                                                                                            var10_7 = "Towers of Hanoi";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog23_3_guess_toss_coin.html")) {
                                                                                                                                            var10_7 = "Guess the Toss of Coin";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog23_4_hand_cricket.html")) {
                                                                                                                                            var10_7 = "Hand Cricket";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog23_5_magic_square.html")) {
                                                                                                                                            var10_7 = "Magic Square";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog23_6_check_magic_square.html")) {
                                                                                                                                            var10_7 = "Check Magic Square or Not";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog24_0_area_circum_circle_macro.html")) {
                                                                                                                                            var10_7 = "Area and Circumference of Circle";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog24_1_all_mathematical_operation_macro.html")) {
                                                                                                                                            var10_7 = "Mathematical Operation";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog25_0_multiplication_table.html")) {
                                                                                                                                            var10_7 = "Multiplication Table";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog25_1_tell_me_date_i_will_tell_u_day.html")) {
                                                                                                                                            var10_7 = "Get Day for given Date";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog25_2_time_elapsed_from_january.html")) {
                                                                                                                                            var10_7 = "Time Elapsed from Jan of the year till given Date";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog25_3_wall_clock_method_1.html")) {
                                                                                                                                            var10_7 = "Wall Clock Method I";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog25_4_wallclock2.html")) {
                                                                                                                                            var10_7 = "Wall Clock Method II";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog25_5_html_shutdown-restart.html")) {
                                                                                                                                            var10_7 = "Shutdown,Restart,Open Html";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog25_6_online_shopping.html")) {
                                                                                                                                            var10_7 = "Online Shopping";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog25_7_medical_store.html")) {
                                                                                                                                            var10_7 = "Medical Store";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog25_8_authenticate_user_3_attempts.html")) {
                                                                                                                                            var10_7 = "Authenticate User(3 attempts)";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog25_9_atm_machine.html")) {
                                                                                                                                            var10_7 = "ATM Machine";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog25_10_get_Calendar.html")) {
                                                                                                                                            var10_7 = "Get Calender of Given Month and Year";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog25_11_money_words.html")) {
                                                                                                                                            var10_7 = "Print Money in Words";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog25_12_compound_interest_years.html")) {
                                                                                                                                            var10_7 = "Compound Interest for 4 yrs";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog25_13_password_generator.html")) {
                                                                                                                                            var10_7 = "Password Generator";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog25_14_rearrange_c_code.html")) {
                                                                                                                                            var10_7 = "Rearrange C Code";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog25_15_chakravyuha.html")) {
                                                                                                                                            var10_7 = "Chakravyuha";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog25_16_generateElectricBill.html")) {
                                                                                                                                            var10_7 = "Caluclate Electric Bill";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog25_17_possi_squares_for_n_vertices.html")) {
                                                                                                                                            var10_7 = "Print all possible squares from given N Co-ordinates";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog25_18_display_file_size.html")) {
                                                                                                                                            var10_7 = "Display File Size";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog25_19_pizza_hut_management.html")) {
                                                                                                                                            var10_7 = "Pizza Hut Management System";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog25_20_num_of_days_between_dates.html")) {
                                                                                                                                            var10_7 = "Calculate Number of Days, Weeks and Days between 2 dates";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog25_21_display_date_words.html")) {
                                                                                                                                            var10_7 = "Display Date in Words";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog25_22_cricket_score_board.html")) {
                                                                                                                                            var10_7 = "Cricket Score Board";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog25_23_pad_remaining_with_zeros.html")) {
                                                                                                                                            var10_7 = "Pad with zeros for the remaining digits";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog26_0_caesar_cipher.html")) {
                                                                                                                                            var10_7 = "Caesar Code Encryption";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog26_1_binary_cipher.html")) {
                                                                                                                                            var10_7 = "Binary Code Encryption";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog26_2_ASCII_cipher.html")) {
                                                                                                                                            var10_7 = "ASCII Code Encryption";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog26_3_morse_code.html")) {
                                                                                                                                            var10_7 = "Morse Code Encryption";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog26_4_numerial_code.html")) {
                                                                                                                                            var10_7 = "Numeral Code Encryption";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog26_5_atbash_cipher.html")) {
                                                                                                                                            var10_7 = "Atbash Encryption";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog26_6_latin_alphabet.html")) {
                                                                                                                                            var10_7 = "Latin Alphabet Encryption";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog26_7_polybius_cipher.html")) {
                                                                                                                                            var10_7 = "Polybius Cipher";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog26_8_rail_fence.html")) {
                                                                                                                                            var10_7 = "Rail Fence Cipher";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog26_9_scytale_cipher.html")) {
                                                                                                                                            var10_7 = "Scytale Cipher";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog26_10_onetimepad.html")) {
                                                                                                                                            var10_7 = "One Time Pad Cipher";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog26_11_vigenere_cipher.html")) {
                                                                                                                                            var10_7 = "Vigenere Cipher";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog26_12_affine_cipher.html")) {
                                                                                                                                            var10_7 = "Affine Cipher";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog26_13_playfair.html")) {
                                                                                                                                            var10_7 = "Play Fair Cipher";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog27_0_caesar_decrypt.html")) {
                                                                                                                                            var10_7 = "Caesar Code Decryption";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog27_1_morsecode.html")) {
                                                                                                                                            var10_7 = "Morse Code Decryption";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog27_2_railfence_decrypt.html")) {
                                                                                                                                            var10_7 = "Rail Fence Decryption";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog27_3_binary_decrypt.html")) {
                                                                                                                                            var10_7 = "Binary Code Decryption";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog27_4_atbash_decrypt.html")) {
                                                                                                                                            var10_7 = "Atbash Decryption";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog27_5_latin_decrypt.html")) {
                                                                                                                                            var10_7 = "Latin Alphabet Decryption";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog27_6_scytale_decrypt.html")) {
                                                                                                                                            var10_7 = "Scytale Decryption";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog27_7_onetimepad_decrypt.html")) {
                                                                                                                                            var10_7 = "One Time Pad Decryption";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog27_8_vigenere_decrypt.html")) {
                                                                                                                                            var10_7 = "Vigenere Decryption";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog27_9_ascii_decrypt.html")) {
                                                                                                                                            var10_7 = "ASCII Code Decryption";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog27_10_numeral_decrypt.html")) {
                                                                                                                                            var10_7 = "Numeral Code Decryption";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog27_11_affine_decrypt.html")) {
                                                                                                                                            var10_7 = "Affine Decipher";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog27_12_polybius_decrypt.html")) {
                                                                                                                                            var10_7 = "Polybius Decryption";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog_27_13_playfair.decrypt.html")) {
                                                                                                                                            var10_7 = "Play Fair Decryption";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog29_0_all_bitwise.html")) {
                                                                                                                                            var10_7 = "All Bitwise Operations";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog28_1_add_mul_bitwise.html")) {
                                                                                                                                            var10_7 = "Add and Mul using bitwise";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog28_2_odd_even_bitwise.html")) {
                                                                                                                                            var10_7 = "Odd or Even using bitwise";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog28_3_all_bits_1.html")) {
                                                                                                                                            var10_7 = "Check all bits of number are 1";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/display_and.html")) {
                                                                                                                                            var10_7 = "AND Table";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/display_or.html")) {
                                                                                                                                            var10_7 = "OR Table";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/display_xor.html")) {
                                                                                                                                            var10_7 = "XOR Table";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog28_7_show_bits_of_integer.html")) {
                                                                                                                                            var10_7 = "To show bits of Integer";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (var6_3.toString().equals((Object)"file:///android_asset/prog28_8_swap_two_num_bitwise.html")) {
                                                                                                                                            var10_7 = "Swap 2 numbers using Bitwise Operators";
                                                                                                                                            break block426;
                                                                                                                                        }
                                                                                                                                        if (!var6_3.equals((Object)"file:///android_asset/practice1_pattern.html")) break block428;
                                                                                                                                        this.setTitle((CharSequence)"Practice Pattern 1");
                                                                                                                                        ** GOTO lbl1361
                                                                                                                                    }
                                                                                                                                    if (!var6_3.equals((Object)"file:///android_asset/practice2_pattern2.html")) break block429;
                                                                                                                                    this.setTitle((CharSequence)"Practice Pattern 2");
                                                                                                                                    ** GOTO lbl1361
                                                                                                                                }
                                                                                                                                if (!var6_3.equals((Object)"file:///android_asset/practice3_pattern3.html")) break block430;
                                                                                                                                this.setTitle((CharSequence)"Practice Pattern 3");
                                                                                                                                ** GOTO lbl1361
                                                                                                                            }
                                                                                                                            if (!var6_3.equals((Object)"file:///android_asset/practice4_replace_vowels_with_ashsymbol.html")) break block431;
                                                                                                                            this.setTitle((CharSequence)"Replace all vowels with \u2018#\u2019");
                                                                                                                            ** GOTO lbl1361
                                                                                                                        }
                                                                                                                        if (!var6_3.equals((Object)"file:///android_asset/practice5_display_consonants.html")) break block432;
                                                                                                                        this.setTitle((CharSequence)"Display all consonants");
                                                                                                                        ** GOTO lbl1361
                                                                                                                    }
                                                                                                                    if (!var6_3.equals((Object)"file:///android_asset/practice6_display_numbers_string.html")) break block433;
                                                                                                                    this.setTitle((CharSequence)"Display all numbers in String");
                                                                                                                    ** GOTO lbl1361
                                                                                                                }
                                                                                                                if (!var6_3.equals((Object)"file:///android_asset/practice7_numbers_left_alpha_right.html")) break block434;
                                                                                                                this.setTitle((CharSequence)"Numbers Left and Alpha Right");
                                                                                                                ** GOTO lbl1361
                                                                                                            }
                                                                                                            if (!var6_3.equals((Object)"file:///android_asset/practice8_non_strings_non_numbers.html")) break block435;
                                                                                                            this.setTitle((CharSequence)"Not Numbers Not Alphabets");
                                                                                                            ** GOTO lbl1361
                                                                                                        }
                                                                                                        if (!var6_3.equals((Object)"file:///android_asset/practice9_replace_zeros_with_ones_viceversa.html")) break block436;
                                                                                                        this.setTitle((CharSequence)"Replace 0's with 1's and vice versa");
                                                                                                        ** GOTO lbl1361
                                                                                                    }
                                                                                                    if (!var6_3.equals((Object)"file:///android_asset/practice10_convert_string_upper.html")) break block437;
                                                                                                    this.setTitle((CharSequence)"Convert to Upper Case");
                                                                                                    ** GOTO lbl1361
                                                                                                }
                                                                                                if (!var6_3.equals((Object)"file:///android_asset/practice11_convert_to_lower.html")) break block438;
                                                                                                this.setTitle((CharSequence)"Convert to Lower Case");
                                                                                                ** GOTO lbl1361
                                                                                            }
                                                                                            if (!var6_3.equals((Object)"file:///android_asset/practice12_sum_1_11_111_till_n.html")) break block439;
                                                                                            this.setTitle((CharSequence)"Sum of 1+11+111+..+till N");
                                                                                            ** GOTO lbl1361
                                                                                        }
                                                                                        if (!var6_3.equals((Object)"file:///android_asset/practice13_display_characters_individually.html")) break block440;
                                                                                        this.setTitle((CharSequence)"Display Characters Individually");
                                                                                        ** GOTO lbl1361
                                                                                    }
                                                                                    if (!var6_3.equals((Object)"file:///android_asset/practice14_numbers_in_letters_till_n.html")) break block441;
                                                                                    this.setTitle((CharSequence)"Numbers in Letters till N");
                                                                                    ** GOTO lbl1361
                                                                                }
                                                                                if (!var6_3.equals((Object)"file:///android_asset/practice15_check_upper_lower.html")) break block442;
                                                                                this.setTitle((CharSequence)"Check Upper or Lower");
                                                                                ** GOTO lbl1361
                                                                            }
                                                                            if (!var6_3.equals((Object)"file:///android_asset/practice16_print_string_before_new_line.html")) break block443;
                                                                            this.setTitle((CharSequence)"Word Before New Line");
                                                                            ** GOTO lbl1361
                                                                        }
                                                                        if (!var6_3.equals((Object)"file:///android_asset/practice17_remove_spaces_between_strings.html")) break block444;
                                                                        this.setTitle((CharSequence)"Remove Spaces in Sentence");
                                                                        ** GOTO lbl1361
                                                                    }
                                                                    if (!var6_3.equals((Object)"file:///android_asset/practice18_remove_first_character_each_string.html")) break block445;
                                                                    this.setTitle((CharSequence)"Remove 1st Character from each Word");
                                                                    ** GOTO lbl1361
                                                                }
                                                                if (!var6_3.equals((Object)"file:///android_asset/practice19_lenght_of_each_string.html")) break block446;
                                                                this.setTitle((CharSequence)"Length of Each Word");
                                                                ** GOTO lbl1361
                                                            }
                                                            if (!var6_3.equals((Object)"file:///android_asset/practice20_capitalise_first_letter_in_each_word.html")) break block447;
                                                            this.setTitle((CharSequence)"Capitalise 1st letter of each word");
                                                            ** GOTO lbl1361
                                                        }
                                                        if (!var6_3.equals((Object)"file:///android_asset/practice21_nested_printf.html")) break block448;
                                                        this.setTitle((CharSequence)"Print length of String using printf only");
                                                        ** GOTO lbl1361
                                                    }
                                                    if (!var6_3.equals((Object)"file:///android_asset/practice22_print_string_given_times.html")) break block449;
                                                    this.setTitle((CharSequence)"Print word given number of times");
                                                    ** GOTO lbl1361
                                                }
                                                if (!var6_3.equals((Object)"file:///android_asset/practice23_even_divide_2_else_multiply_3.html")) break block450;
                                                this.setTitle((CharSequence)"If Even Divide by 2 else Multiply by 3");
                                                ** GOTO lbl1361
                                            }
                                            if (!var6_3.equals((Object)"file:///android_asset/practice24_print_only_10_num_each_line.html")) break block451;
                                            this.setTitle((CharSequence)"Print only 10 numbers in each line");
                                            ** GOTO lbl1361
                                        }
                                        if (!var6_3.equals((Object)"file:///android_asset/practice25_display_minus_to_plus_num.html")) break block452;
                                        this.setTitle((CharSequence)"Display -num to +num");
                                        ** GOTO lbl1361
                                    }
                                    if (!var6_3.equals((Object)"file:///android_asset/practice26_array_beautiful_or_not.html")) break block453;
                                    this.setTitle((CharSequence)"Array beautiful or not");
                                    ** GOTO lbl1361
                                }
                                if (!var6_3.equals((Object)"file:///android_asset/parctice27_final_value_if_double_every_success_search.html")) break block454;
                                this.setTitle((CharSequence)"Final value if we double after every successful search in array");
                                ** GOTO lbl1361
                            }
                            if (!var6_3.equals((Object)"file:///android_asset/practice28_print_squares_odd_cubes_even.html")) break block455;
                            this.setTitle((CharSequence)"Print squares of elements in odd positions and cubes of even positioned elements");
                            ** GOTO lbl1361
                        }
                        if (!var6_3.equals((Object)"file:///android_asset/practice29_upper_lower_in_decimals.html")) break block456;
                        this.setTitle((CharSequence)"Upper and Lower in Decimal");
                        ** GOTO lbl1361
                    }
                    if (var6_3.equals((Object)"file:///android_asset/practice30_multi_table_right_angle.html")) {
                        this.setTitle((CharSequence)"Print Multiplication Table in Right Angle Triangle");
lbl1361: // 30 sources:
                        this.startVideoAd();
                    } else if (var6_3.toString().equals((Object)"file:///android_asset/comingsoon.html")) {
                        var7_4.setVisibility(4);
                    } else {
                        if (var6_3.toString().equals((Object)"file:///android_asset/asciitable.html")) {
                            var7_4.setVisibility(4);
                            var10_7 = "ASCII Table";
                            break block426;
                        }
                        if (!var6_3.toString().equals((Object)"https://drive.google.com/file/d/0Bw0yvlP6yfxzeTcyTHRyeFZUaXc/view?usp=sharing") && !var6_3.toString().equals((Object)"https://drive.google.com/file/d/0Bw0yvlP6yfxzeTcyTHRyeFZUaXc/view")) {
                            var11_8 = new c.a().a();
                            this.interstitial = new g((Context)this);
                            this.interstitial.a(this.getString(2131820585));
                            this.interstitial.a(var11_8);
                            this.interstitial.a(new com.google.android.gms.ads.a(this){
                                final /* synthetic */ HelloWorld this$0;
                                {
                                    this.this$0 = helloWorld;
                                }

                                public void onAdLoaded() {
                                    this.this$0.displayInterstitial();
                                }
                            });
                            var12_9 = 0;
                            break block427;
                        }
                        var7_4.setVisibility(4);
                        this.setTitle((CharSequence)"Let Us C By Yeswanth Kanetkar");
                        this.webHtml_HelloWorld.setDownloadListener(new DownloadListener(this){
                            final /* synthetic */ HelloWorld this$0;
                            {
                                this.this$0 = helloWorld;
                            }

                            public void onDownloadStart(String string, String string2, String string3, String string4, long l2) {
                                try {
                                    android.app.DownloadManager$Request request = new android.app.DownloadManager$Request(android.net.Uri.parse((String)string));
                                    request.allowScanningByMediaScanner();
                                    request.setNotificationVisibility(1);
                                    request.setDestinationInExternalPublicDir(android.os.Environment.DIRECTORY_DOWNLOADS, "LetUsC.pdf");
                                    ((android.app.DownloadManager)this.this$0.getSystemService("download")).enqueue(request);
                                    Toast.makeText((Context)this.this$0.getApplicationContext(), (CharSequence)"Downloading Pdf.Check in Notification bar.Total 7 Mb", (int)1).show();
                                    return;
                                }
                                catch (Exception exception) {
                                    Toast.makeText((Context)this.this$0, (CharSequence)"Error Occured", (int)0).show();
                                    return;
                                }
                            }
                        });
                    }
lbl1381: // 4 sources:
                    do {
                        this.refreshScreen();
                        this.refreshScreenFont();
                        this.refreshNightState();
                        ((FloatingActionButton)this.findViewById(2131296496)).setOnClickListener(new View.OnClickListener(this, var6_3, var7_4){
                            final /* synthetic */ HelloWorld this$0;
                            final /* synthetic */ FloatingActionMenu val$fabMain;
                            final /* synthetic */ String val$webUrl;
                            {
                                this.this$0 = helloWorld;
                                this.val$webUrl = string;
                                this.val$fabMain = floatingActionMenu;
                            }

                            public void onClick(View view) {
                                String string = "";
                                try {
                                    String string2;
                                    string = string2 = HelloWorld.access$100(this.this$0, this.val$webUrl.toString().substring(22));
                                }
                                catch (IOException iOException) {
                                    iOException.printStackTrace();
                                }
                                try {
                                    HelloWorld.access$200(this.this$0, string);
                                    java.io.File file = android.os.Environment.getExternalStoragePublicDirectory((String)android.os.Environment.DIRECTORY_DOWNLOADS);
                                    java.util.Date date = new java.util.Date(28800000L + new java.util.Date().getTime());
                                    String string3 = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(date);
                                    android.support.v7.app.a a2 = this.this$0.getSupportActionBar();
                                    StringBuilder stringBuilder = new StringBuilder();
                                    stringBuilder.append(a2.a().toString());
                                    stringBuilder.append(string3);
                                    stringBuilder.append(".txt");
                                    java.io.File file2 = new java.io.File(file, stringBuilder.toString().replaceAll(" ", "").toLowerCase().replaceAll(",", "").toLowerCase().replaceAll(":", "").toLowerCase().replaceAll("/", "").toLowerCase());
                                    FileOutputStream fileOutputStream = new FileOutputStream(file2, true);
                                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter((OutputStream)fileOutputStream);
                                    outputStreamWriter.append((CharSequence)string);
                                    outputStreamWriter.close();
                                    fileOutputStream.close();
                                    View view2 = this.this$0.v = this.this$0.findViewById(16908290);
                                    StringBuilder stringBuilder2 = new StringBuilder();
                                    stringBuilder2.append("Download Completed.Text file Saved at \n");
                                    stringBuilder2.append((Object)file2);
                                    stringBuilder2.append("\n Please Rearrange the code.");
                                    android.support.design.widget.Snackbar snackbar = android.support.design.widget.Snackbar.a((View)view2, (CharSequence)stringBuilder2.toString(), (int)-2);
                                    ((android.widget.TextView)snackbar.d().findViewById(2131296577)).setMaxLines(5);
                                    snackbar.a((CharSequence)"Ok", new View.OnClickListener(this.this$0){

                                        public void onClick(View view) {
                                        }
                                    });
                                    snackbar.e();
                                    return;
                                }
                                catch (NullPointerException nullPointerException) {
                                    this.val$fabMain.setVisibility(4);
                                    Toast.makeText((Context)this.this$0.getApplicationContext(), (CharSequence)"Copy,Download,Share code,Night mode,Wrap Code,Zoom code will be available for android versions 4.3 and above.I am trying to solve this issue.", (int)1).show();
                                    nullPointerException.printStackTrace();
                                    HelloWorld.access$302(this.this$0, 1);
                                    return;
                                }
                                catch (IOException iOException) {
                                    Toast.makeText((Context)this.this$0.getApplicationContext(), (CharSequence)"Please give permission to allow storage permission in settings", (int)1).show();
                                    Toast.makeText((Context)this.this$0.getApplicationContext(), (CharSequence)"After allowing permission and if still error exists then please mail at cprograms4future@gmail.com", (int)1).show();
                                    return;
                                }
                            }
                        });
                        return;
                        break;
                    } while (true);
                }
                catch (RuntimeException var4_12) {
                    var4_12.printStackTrace();
                    return;
                }
                catch (f var3_13) {
                    var3_13.printStackTrace();
                    return;
                }
                catch (NullPointerException var2_14) {
                    var2_14.printStackTrace();
                    ((FloatingActionMenu)this.findViewById(2131296467)).setVisibility(4);
                    Toast.makeText((Context)this.getApplicationContext(), (CharSequence)"Copy,Download,Share code,Night mode,Wrap Code,Zoom code will be available for android versions 4.3 and above.I am trying to solve this issue.", (int)1).show();
                    this.errorFlag = 1;
                    return;
                }
            }
lbl1400: // 2 sources:
            do {
                this.setTitle((CharSequence)var10_7);
                ** continue;
                break;
            } while (true);
        }
        do {
            block458 : {
                block457 : {
                    var13_10 = var9_6.length;
                    var14_11 = false;
                    if (var12_9 > var13_10) break block457;
                    if (!var6_3.toString().equals((Object)var9_6[var12_9])) break block458;
                    var14_11 = true;
                }
                if (!var14_11) break;
                var7_4.setVisibility(4);
                this.hideBookmark = 1;
                break;
            }
            ++var12_9;
        } while (true);
        var10_7 = "All C Programs";
        ** while (true)
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        try {
            this.getMenuInflater().inflate(2131558405, menu);
            return true;
        }
        catch (NullPointerException nullPointerException) {
            ((FloatingActionMenu)this.findViewById(2131296467)).setVisibility(4);
            Toast.makeText((Context)this.getApplicationContext(), (CharSequence)"Copy,Download,Share code,Night mode,Wrap Code,Zoom code will be available for android versions 4.3 and above.I am trying to solve this issue.", (int)1).show();
            this.errorFlag = 1;
            return true;
        }
        catch (InflateException inflateException) {
            Toast.makeText((Context)this.getApplicationContext(), (CharSequence)"Inflate Exception", (int)1).show();
            return true;
        }
    }

    /*
     * Exception decompiling
     */
    public boolean onOptionsItemSelected(MenuItem var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl73.1 : ILOAD_2 : trying to set 1 previously set to 0
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
    public boolean onPrepareOptionsMenu(Menu var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl278 : ICONST_1 : trying to set 1 previously set to 0
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

    public boolean onSupportNavigateUp() {
        this.onBackPressed();
        return true;
    }

    public void prepareAd() {
        this.mInterstitialAd = new g((Context)this);
        this.mInterstitialAd.a(this.getString(2131820585));
        this.mInterstitialAd.a(new c.a().a());
    }

    public void setStatusBarColor(View view, int n2) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.getWindow().setFlags(67108864, 67108864);
            int n3 = this.getActionBarHeight();
            int n4 = this.getStatusBarHeight();
            view.getLayoutParams().height = n3 + n4;
            view.setBackgroundColor(n2);
        }
    }

    public void startVideoAd() {
    }

}

