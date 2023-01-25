/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.content.res.Resources
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.support.v7.app.a
 *  android.support.v7.app.e
 *  android.support.v7.widget.Toolbar
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.Window
 *  android.webkit.WebView
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 *  android.widget.RelativeLayout
 *  android.widget.SeekBar
 *  android.widget.SeekBar$OnSeekBarChangeListener
 *  android.widget.Switch
 *  android.widget.TextView
 *  com.google.android.gms.ads.AdView
 *  com.google.android.gms.ads.c
 *  com.google.android.gms.ads.c$a
 *  com.google.android.gms.ads.g
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.cprograms4future.allcprograms;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.e;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import com.cprograms4future.allcprograms.HelloWorld;
import com.cprograms4future.allcprograms.Main2Activity;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.c;
import com.google.android.gms.ads.g;

public class Main2Activity extends e {
    private HelloWorld hello = new HelloWorld();
    private g interstitial;
    g mInterstitialAd;
    Switch toggleSwitchZoom;
    WebView webHtml_HelloWorld;

    private void SaveFontChange(int n2) {
        SharedPreferences.Editor editor = this.getSharedPreferences("AppFontChange", 0).edit();
        editor.putInt("fontChange", n2);
        editor.apply();
    }

    private void SaveFontState(int n2) {
        SharedPreferences.Editor editor = this.getSharedPreferences("AppfontState", 0).edit();
        editor.putInt("fontState", n2);
        editor.apply();
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
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(this.getResources().getColor(2131099684));
        }
        this.setTheme(2131886090);
    }

    private void SetNightModeThemeAfterContent() {
        ((RelativeLayout)this.findViewById(2131296268)).setBackgroundColor(this.getResources().getColor(2131099699));
        ((TextView)this.findViewById(2131296675)).setTextColor(this.getResources().getColor(2131099865));
        ((TextView)this.findViewById(2131296670)).setTextColor(this.getResources().getColor(2131099865));
        ((TextView)this.findViewById(2131296671)).setTextColor(this.getResources().getColor(2131099865));
        ((TextView)this.findViewById(2131296672)).setTextColor(this.getResources().getColor(2131099865));
        ((TextView)this.findViewById(2131296674)).setTextColor(this.getResources().getColor(2131099865));
    }

    static /* synthetic */ void access$000(Main2Activity main2Activity, int n2) {
        main2Activity.SaveZoomState(n2);
    }

    static /* synthetic */ void access$100(Main2Activity main2Activity, int n2) {
        main2Activity.SaveFontChange(n2);
    }

    static /* synthetic */ void access$200(Main2Activity main2Activity, int n2) {
        main2Activity.SaveFontState(n2);
    }

    static /* synthetic */ void access$300(Main2Activity main2Activity, int n2) {
        main2Activity.SaveNightState(n2);
    }

    static /* synthetic */ void access$400(Main2Activity main2Activity, int n2) {
        main2Activity.SaveWrapState(n2);
    }

    public static int getFontChange(Context context) {
        return context.getSharedPreferences("AppFontChange", 0).getInt("fontChange", 100);
    }

    public static int getFontState(Context context) {
        return context.getSharedPreferences("AppfontState", 0).getInt("fontState", 0);
    }

    public static int getNightState(Context context) {
        return context.getSharedPreferences("AppNightState", 0).getInt("nightState", 0);
    }

    public static int getWrapState(Context context) {
        return context.getSharedPreferences("AppWrapState", 0).getInt("wrapState", 0);
    }

    public static int getZoomState(Context context) {
        return context.getSharedPreferences("AppZoomState", 0).getInt("zoomState", 0);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void SwitchClickToggleZoom() {
        int n2 = this.toggleSwitchZoom.isChecked() ? 1 : 0;
        this.SaveZoomState(n2);
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
        this.setContentView(2131492895);
        if (n2 == 1) {
            this.SetNightModeThemeAfterContent();
        }
        this.setSupportActionBar((Toolbar)this.findViewById(2131296615));
        this.getSupportActionBar().a(true);
        ((AdView)this.findViewById(2131296302)).a(new c.a().c("android_studio:ad_template").a());
        this.toggleSwitchZoom = (Switch)this.findViewById(2131296591);
        this.toggleSwitchZoom.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this){
            final /* synthetic */ Main2Activity this$0;
            {
                this.this$0 = main2Activity;
            }

            /*
             * Enabled aggressive block sorting
             */
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Main2Activity main2Activity;
                int n2;
                if (bl) {
                    main2Activity = this.this$0;
                    n2 = 1;
                } else {
                    main2Activity = this.this$0;
                    n2 = 0;
                }
                Main2Activity.access$000(main2Activity, n2);
            }
        });
        if (Main2Activity.getZoomState((Context)this) == 1) {
            this.toggleSwitchZoom.setChecked(true);
        } else {
            this.toggleSwitchZoom.setChecked(false);
        }
        SeekBar seekBar = (SeekBar)this.findViewById(2131296424);
        TextView textView = (TextView)this.findViewById(2131296671);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Font Size: ");
        stringBuilder.append(seekBar.getProgress());
        stringBuilder.append("/");
        stringBuilder.append(seekBar.getMax());
        textView.setText((CharSequence)stringBuilder.toString());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(this, textView){
            int progress;
            final /* synthetic */ Main2Activity this$0;
            final /* synthetic */ TextView val$textView;
            {
                this.this$0 = main2Activity;
                this.val$textView = textView;
                this.progress = 0;
            }

            public void onProgressChanged(SeekBar seekBar, int n2, boolean bl) {
                this.progress = n2;
                TextView textView = this.val$textView;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Font Size: ");
                stringBuilder.append(seekBar.getProgress());
                stringBuilder.append("/");
                stringBuilder.append(seekBar.getMax());
                stringBuilder.append(" (Default 100)");
                textView.setText((CharSequence)stringBuilder.toString());
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                TextView textView = this.val$textView;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Font Size: ");
                stringBuilder.append(this.progress);
                stringBuilder.append("/");
                stringBuilder.append(seekBar.getMax());
                stringBuilder.append(" (Default 100)");
                textView.setText((CharSequence)stringBuilder.toString());
                Main2Activity.access$100(this.this$0, seekBar.getProgress());
            }
        });
        seekBar.setProgress(Main2Activity.getFontChange((Context)this));
        Switch switch_ = (Switch)this.findViewById(2131296612);
        switch_.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this, seekBar, textView){
            final /* synthetic */ Main2Activity this$0;
            final /* synthetic */ SeekBar val$seekBar;
            final /* synthetic */ TextView val$textView;
            {
                this.this$0 = main2Activity;
                this.val$seekBar = seekBar;
                this.val$textView = textView;
            }

            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                if (bl) {
                    this.val$seekBar.setEnabled(true);
                    Main2Activity.access$200(this.this$0, 1);
                    Main2Activity.access$100(this.this$0, this.val$seekBar.getProgress());
                    return;
                }
                this.val$seekBar.setEnabled(false);
                this.val$seekBar.setProgress(100);
                TextView textView = this.val$textView;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Font Size: ");
                stringBuilder.append(this.val$seekBar.getProgress());
                stringBuilder.append("/");
                stringBuilder.append(this.val$seekBar.getMax());
                stringBuilder.append(" (Default 100)");
                textView.setText((CharSequence)stringBuilder.toString());
                Main2Activity.access$100(this.this$0, this.val$seekBar.getProgress());
                Main2Activity.access$200(this.this$0, 0);
            }
        });
        if (Main2Activity.getFontState((Context)this) == 1) {
            seekBar.setEnabled(true);
            switch_.setChecked(true);
            this.SaveFontChange(seekBar.getProgress());
        } else {
            seekBar.setEnabled(false);
            seekBar.setProgress(100);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Font Size: ");
            stringBuilder2.append(seekBar.getProgress());
            stringBuilder2.append("/");
            stringBuilder2.append(seekBar.getMax());
            stringBuilder2.append(" (Default 100)");
            textView.setText((CharSequence)stringBuilder2.toString());
            this.SaveFontChange(seekBar.getProgress());
            switch_.setChecked(false);
        }
        Switch switch_2 = (Switch)this.findViewById(2131296613);
        switch_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this){
            final /* synthetic */ Main2Activity this$0;
            {
                this.this$0 = main2Activity;
            }

            /*
             * Enabled aggressive block sorting
             */
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                View.OnClickListener onClickListener;
                android.support.design.widget.Snackbar snackbar;
                String string;
                if (bl) {
                    Main2Activity.access$300(this.this$0, 1);
                    snackbar = android.support.design.widget.Snackbar.a((View)this.this$0.findViewById(16908290), (CharSequence)"Please relaunch the App to activate Night Mode for entire App", (int)-2);
                    TextView textView = (TextView)snackbar.d().findViewById(2131296577);
                    textView.setMaxLines(5);
                    textView.setTextColor(this.this$0.getResources().getColor(2131099864));
                    string = "Ok";
                    onClickListener = new View.OnClickListener(this.this$0){

                        public void onClick(View view) {
                        }
                    };
                } else {
                    Main2Activity.access$300(this.this$0, 0);
                    snackbar = android.support.design.widget.Snackbar.a((View)this.this$0.findViewById(16908290), (CharSequence)"Please relaunch the App to activate Normal Mode for entire App", (int)-2);
                    TextView textView = (TextView)snackbar.d().findViewById(2131296577);
                    textView.setMaxLines(5);
                    textView.setTextColor(this.this$0.getResources().getColor(2131099864));
                    string = "Ok";
                    onClickListener = new /* invalid duplicate definition of identical inner class */;
                }
                snackbar.a((CharSequence)string, onClickListener);
                snackbar.e();
            }
        });
        if (Main2Activity.getNightState((Context)this) == 1) {
            switch_2.setChecked(true);
        } else {
            switch_2.setChecked(false);
        }
        Switch switch_3 = (Switch)this.findViewById(2131296614);
        switch_3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this){
            final /* synthetic */ Main2Activity this$0;
            {
                this.this$0 = main2Activity;
            }

            /*
             * Enabled aggressive block sorting
             */
            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                Main2Activity main2Activity;
                int n2;
                if (bl) {
                    main2Activity = this.this$0;
                    n2 = 1;
                } else {
                    main2Activity = this.this$0;
                    n2 = 0;
                }
                Main2Activity.access$400(main2Activity, n2);
            }
        });
        if (Main2Activity.getWrapState((Context)this) == 1) {
            switch_3.setChecked(true);
            return;
        }
        switch_3.setChecked(false);
    }

    public boolean onSupportNavigateUp() {
        this.onBackPressed();
        return true;
    }

}

