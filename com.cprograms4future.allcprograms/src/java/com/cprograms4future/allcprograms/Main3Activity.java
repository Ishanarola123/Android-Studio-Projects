/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 *  android.os.Bundle
 *  android.support.v7.app.d
 *  android.support.v7.app.d$a
 *  android.support.v7.app.e
 *  android.text.Editable
 *  android.text.Html
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.Button
 *  android.widget.EditText
 *  android.widget.ListAdapter
 *  android.widget.ListView
 *  android.widget.TextView
 *  android.widget.Toast
 *  com.google.android.gms.d.c
 *  com.google.android.gms.d.g
 *  com.google.firebase.a.e
 *  com.google.firebase.a.g
 *  com.google.firebase.a.l
 *  com.google.firebase.auth.FirebaseAuth
 *  com.google.firebase.auth.q
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Void
 */
package com.cprograms4future.allcprograms;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.d;
import android.support.v7.app.e;
import android.text.Editable;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.cprograms4future.allcprograms.Main3Activity;
import com.cprograms4future.allcprograms.MainActivity;
import com.cprograms4future.allcprograms.b;
import com.firebase.ui.auth.a;
import com.google.android.gms.d.c;
import com.google.android.gms.d.g;
import com.google.firebase.a.l;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.q;

public class Main3Activity
extends e {
    private static final int SIGN_IN_REQUEST_CODE = 0;
    private static final int SIGN_UP_REQUEST_CODE = 1;
    private com.firebase.ui.a.b<b> adapter;
    String messageTxt = "";

    static /* synthetic */ boolean access$000(Main3Activity main3Activity) {
        return main3Activity.haveNetworkConnection();
    }

    static /* synthetic */ void access$100(Main3Activity main3Activity, int n2) {
        main3Activity.showDialogInternet(n2);
    }

    private void displayChatMessages() {
        com.firebase.ui.a.b<b> b2;
        ListView listView = (ListView)this.findViewById(2131296463);
        this.adapter = b2 = new com.firebase.ui.a.b<b>(this, (Activity)this, b.class, 2131492937, (l)com.google.firebase.a.g.a().b()){
            final /* synthetic */ Main3Activity this$0;
            {
                this.this$0 = main3Activity;
                super(activity, class_, n2, l2);
            }

            protected void populateView(View view, b b2, int n2) {
                TextView textView = (TextView)view.findViewById(2131296474);
                TextView textView2 = (TextView)view.findViewById(2131296476);
                TextView textView3 = (TextView)view.findViewById(2131296475);
                textView.setText((CharSequence)b2.getMessageText());
                textView2.setText((CharSequence)b2.getMessageUser());
                textView3.setText(android.text.format.DateFormat.format((CharSequence)"dd-MM-yyyy @ HH:mm:ss", (long)b2.getMessageTime()));
            }
        };
        listView.setAdapter(this.adapter);
    }

    private boolean haveNetworkConnection() {
        boolean bl;
        block6 : {
            block5 : {
                NetworkInfo[] arrnetworkInfo = ((ConnectivityManager)this.getSystemService("connectivity")).getAllNetworkInfo();
                int n2 = arrnetworkInfo.length;
                boolean bl2 = false;
                boolean bl3 = false;
                for (int i2 = 0; i2 < n2; ++i2) {
                    NetworkInfo networkInfo = arrnetworkInfo[i2];
                    if (networkInfo.getTypeName().equalsIgnoreCase("WIFI") && networkInfo.isConnected()) {
                        bl2 = true;
                    }
                    if (!networkInfo.getTypeName().equalsIgnoreCase("MOBILE") || !networkInfo.isConnected()) continue;
                    bl3 = true;
                }
                if (bl2) break block5;
                bl = false;
                if (!bl3) break block6;
            }
            bl = true;
        }
        return bl;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private void showDialogInternet(int var1_1) {
        if (var1_1 != 0) ** GOTO lbl7
        try {
            block2 : {
                var2_2 = new d.a((Context)this);
                var2_2.a((CharSequence)"No Internet Connection");
                var2_2.b((CharSequence)"Please Check your Internet Connection and Try again later.").a(false).c((CharSequence)"Go to Home", new DialogInterface.OnClickListener(this){
                    final /* synthetic */ Main3Activity this$0;
                    {
                        this.this$0 = main3Activity;
                    }

                    public void onClick(DialogInterface dialogInterface, int n2) {
                        Intent intent = new Intent((Context)this.this$0, MainActivity.class);
                        this.this$0.startActivity(intent);
                    }
                });
                break block2;
lbl7: // 1 sources:
                var2_2 = new d.a((Context)this);
                var2_2.b((CharSequence)"Internet Connection is On.Please Go back Home and Come again to Continue!!").a(false).a((CharSequence)"Go to Home", new DialogInterface.OnClickListener(this){
                    final /* synthetic */ Main3Activity this$0;
                    {
                        this.this$0 = main3Activity;
                    }

                    public void onClick(DialogInterface dialogInterface, int n2) {
                        Intent intent = new Intent((Context)this.this$0, MainActivity.class);
                        this.this$0.startActivity(intent);
                    }
                });
            }
            var2_2.b().show();
            return;
        }
        catch (Exception v0) {
            Toast.makeText((Context)this, (CharSequence)"Error Occured", (int)0).show();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public void enableSubmitIfReady() {
        Resources resources;
        int n2;
        boolean bl = ((EditText)this.findViewById(2131296446)).getText().toString().trim().length() > 0;
        Button button = (Button)this.findViewById(2131296409);
        if (!bl) {
            button.setEnabled(false);
            button.setBackgroundColor(this.getResources().getColor(2131099731));
            resources = this.getResources();
            n2 = 2131099684;
        } else {
            button.setEnabled(true);
            button.setBackgroundColor(this.getResources().getColor(2131099706));
            resources = this.getResources();
            n2 = 2131099865;
        }
        button.setTextColor(resources.getColor(n2));
    }

    protected void onActivityResult(int n2, int n3, Intent intent) {
        super.onActivityResult(n2, n3, intent);
        if (n2 == 0) {
            if (n3 == -1) {
                if (FirebaseAuth.getInstance().a().g() == null) {
                    Toast.makeText((Context)this, (CharSequence)"Account Created Successfully! Please Sign In Now!", (int)1).show();
                    this.startActivityForResult(a.a().c().a(), 0);
                    return;
                }
                this.showDialog();
                Toast.makeText((Context)this, (CharSequence)"Welcome SignedIn!", (int)1).show();
                this.displayChatMessages();
                return;
            }
            Toast.makeText((Context)this, (CharSequence)"We couldn't sign you in. Please Check your Internet Connection and try again later.", (int)1).show();
            this.finish();
        }
    }

    /*
     * Exception decompiling
     */
    protected void onCreate(Bundle var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl127 : ALOAD_0 : trying to set 1 previously set to 0
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

    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(2131558401, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 2131296471) {
            a.a().a((Activity)this).a((c)new c<Void>(this){
                final /* synthetic */ Main3Activity this$0;
                {
                    this.this$0 = main3Activity;
                }

                public void onComplete(g<Void> g2) {
                    Toast.makeText((Context)this.this$0, (CharSequence)"You have been signed out.", (int)1).show();
                    this.this$0.finish();
                }
            });
        }
        if (menuItem.getItemId() == 2131296469) {
            this.startActivity(new Intent((Context)this, MainActivity.class));
        }
        if (menuItem.getItemId() == 2131296534) {
            Dialog dialog = new Dialog((Context)this);
            dialog.requestWindowFeature(1);
            dialog.setContentView(2131492892);
            ((TextView)dialog.findViewById(2131296386)).setText((CharSequence)"Privacy Policy");
            TextView textView = (TextView)dialog.findViewById(2131296387);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("");
            stringBuilder.append(System.getProperty((String)"line.separator"));
            stringBuilder.append(System.getProperty((String)"line.separator"));
            stringBuilder.append((Object)Html.fromHtml((String)"This Chat Application uses Google Firebase Authentication and your data collected is completely safe."));
            stringBuilder.append(System.getProperty((String)"line.separator"));
            stringBuilder.append((Object)Html.fromHtml((String)"Your data is not shared to others and is protected with full Security.You can always mail me at cprograms4future@gmail.com in case of reporting any kind of issue."));
            stringBuilder.append(System.getProperty((String)"line.separator"));
            stringBuilder.append((Object)Html.fromHtml((String)""));
            textView.setText((CharSequence)stringBuilder.toString());
            ((Button)dialog.findViewById(2131296330)).setOnClickListener(new View.OnClickListener(this, dialog){
                final /* synthetic */ Main3Activity this$0;
                final /* synthetic */ Dialog val$dialog;
                {
                    this.this$0 = main3Activity;
                    this.val$dialog = dialog;
                }

                public void onClick(View view) {
                    this.val$dialog.dismiss();
                }
            });
            dialog.show();
        }
        if (menuItem.getItemId() == 2131296470) {
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
                final /* synthetic */ Main3Activity this$0;
                final /* synthetic */ Dialog val$dialog;
                {
                    this.this$0 = main3Activity;
                    this.val$dialog = dialog;
                }

                public void onClick(View view) {
                    this.val$dialog.dismiss();
                }
            });
            dialog.show();
        }
        return true;
    }

    public void showDialog() {
        Dialog dialog = new Dialog((Context)this);
        dialog.requestWindowFeature(1);
        dialog.setContentView(2131492892);
        ((TextView)dialog.findViewById(2131296386)).setText((CharSequence)"Only 100 Connections");
        TextView textView = (TextView)dialog.findViewById(2131296387);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hi! Thanks for downloading my App.");
        stringBuilder.append(System.getProperty((String)"line.separator"));
        stringBuilder.append(System.getProperty((String)"line.separator"));
        stringBuilder.append((Object)Html.fromHtml((String)"Only 100 Connections are possible simultaneously"));
        stringBuilder.append(System.getProperty((String)"line.separator"));
        stringBuilder.append(System.getProperty((String)"line.separator"));
        stringBuilder.append((Object)Html.fromHtml((String)"This is a simple Chat.May not have expected features in this But hope this will help you."));
        stringBuilder.append(System.getProperty((String)"line.separator"));
        stringBuilder.append(System.getProperty((String)"line.separator"));
        stringBuilder.append((Object)Html.fromHtml((String)"Please use this Chat for Education purpose."));
        stringBuilder.append(System.getProperty((String)"line.separator"));
        stringBuilder.append((Object)Html.fromHtml((String)"Please Read Terms and Conditions Before Proceeding"));
        stringBuilder.append(System.getProperty((String)"line.separator"));
        stringBuilder.append((Object)Html.fromHtml((String)"If you want to report any chat Please mail me at cprograms4future@gmail.com"));
        textView.setText((CharSequence)stringBuilder.toString());
        ((Button)dialog.findViewById(2131296330)).setOnClickListener(new View.OnClickListener(this, dialog){
            final /* synthetic */ Main3Activity this$0;
            final /* synthetic */ Dialog val$dialog;
            {
                this.this$0 = main3Activity;
                this.val$dialog = dialog;
            }

            public void onClick(View view) {
                this.val$dialog.dismiss();
            }
        });
        dialog.show();
    }
}

