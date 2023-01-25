/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.support.v7.app.e
 *  android.text.Html
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.Button
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 */
package com.cprograms4future.allcprograms;

import android.os.Bundle;
import android.support.v7.app.e;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.cprograms4future.allcprograms.BenefitsPro;

public class BenefitsPro
extends e {
    private static final String BULLET_SYMBOL = "&#8226";

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2131492905);
        TextView textView = (TextView)this.findViewById(2131296387);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hi! Thanks for downloading my App.\n\nBenefits of Downloading All C Programs PRO App\n\nYou can Unlock: ");
        stringBuilder.append(System.getProperty((String)"line.separator"));
        stringBuilder.append(System.getProperty((String)"line.separator"));
        stringBuilder.append((Object)Html.fromHtml((String)"&#8226 Night Mode for Program which can be Switched ON or OFF"));
        stringBuilder.append(System.getProperty((String)"line.separator"));
        stringBuilder.append(System.getProperty((String)"line.separator"));
        stringBuilder.append((Object)Html.fromHtml((String)"&#8226 Zoom In and Out which can be Switched ON or OFF for Program"));
        stringBuilder.append(System.getProperty((String)"line.separator"));
        stringBuilder.append(System.getProperty((String)"line.separator"));
        stringBuilder.append((Object)Html.fromHtml((String)"&#8226 Wrapping code where code can be adjusted according to screen without scrolling horizontally.\n\n This also can be Switched ON or OFF"));
        stringBuilder.append(System.getProperty((String)"line.separator"));
        stringBuilder.append(System.getProperty((String)"line.separator"));
        stringBuilder.append((Object)Html.fromHtml((String)"&#8226 Change Font Sizes of Text for Program"));
        stringBuilder.append(System.getProperty((String)"line.separator"));
        stringBuilder.append(System.getProperty((String)"line.separator"));
        stringBuilder.append((Object)Html.fromHtml((String)"&#8226 Finally NO ADS"));
        stringBuilder.append(System.getProperty((String)"line.separator"));
        stringBuilder.append(System.getProperty((String)"line.separator"));
        stringBuilder.append((Object)Html.fromHtml((String)"For very Lesser Price.So Click on Unlock Pro to buy it from Play Store"));
        textView.setText((CharSequence)stringBuilder.toString());
        ((Button)this.findViewById(2131296272)).setOnClickListener(new View.OnClickListener(this){
            final /* synthetic */ BenefitsPro this$0;
            {
                this.this$0 = benefitsPro;
            }

            public void onClick(View view) {
                try {
                    android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse((String)"market://details?id=com.cprograms4future.allcprogramsnoads"));
                    this.this$0.startActivity(intent);
                    return;
                }
                catch (android.content.ActivityNotFoundException activityNotFoundException) {
                    this.this$0.startActivity(new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse((String)"http://play.google.com/store/apps/details?id=com.cprograms4future.allcprogramsnoads")));
                    return;
                }
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(2131558404, menu);
        menu.findItem(2131296503).setVisible(false);
        return true;
    }

    /*
     * Exception decompiling
     */
    public boolean onOptionsItemSelected(MenuItem var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl121.1 : ILOAD_2 : trying to set 1 previously set to 0
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
}

