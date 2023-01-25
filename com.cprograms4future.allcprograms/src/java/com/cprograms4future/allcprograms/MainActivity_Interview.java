/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Color
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.support.v7.app.a
 *  android.support.v7.app.e
 *  android.text.TextWatcher
 *  android.view.View
 *  android.view.Window
 *  android.widget.Button
 *  android.widget.EditText
 *  android.widget.ListAdapter
 *  android.widget.ListView
 *  android.widget.RelativeLayout
 *  com.google.android.gms.ads.AdView
 *  com.google.android.gms.ads.c
 *  com.google.android.gms.ads.c$a
 *  com.google.android.gms.ads.g
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.List
 */
package com.cprograms4future.allcprograms;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.a;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.cprograms4future.allcprograms.Main2Activity;
import com.cprograms4future.allcprograms.MainActivity_Interview;
import com.cprograms4future.allcprograms.d;
import com.cprograms4future.allcprograms.e;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.c;
import com.google.android.gms.ads.g;
import java.util.ArrayList;
import java.util.List;

public class MainActivity_Interview
extends android.support.v7.app.e {
    e adapter;
    ArrayList<d> arraylist = new ArrayList();
    EditText editsearch;
    private g interstitial;
    ListView list;
    Button mClearText;
    g mInterstitialAd;
    String[] questions;

    private void SetNightModeTheme() {
        this.getSupportActionBar().a((Drawable)new ColorDrawable(this.getResources().getColor(2131099699)));
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(this.getResources().getColor(2131099684));
        }
    }

    private void SetNightModeThemeAfterContent() {
        RelativeLayout relativeLayout = (RelativeLayout)this.findViewById(2131296261);
        this.editsearch = (EditText)this.findViewById(2131296393);
        this.editsearch.setTextColor(Color.parseColor((String)"#eeffffff"));
        this.editsearch.setHintTextColor(Color.parseColor((String)"#eeffffff"));
        relativeLayout.setBackgroundColor(this.getResources().getColor(2131099699));
    }

    public void clear(View view) {
        this.editsearch.setText((CharSequence)"");
        this.mClearText.setVisibility(8);
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
        this.setContentView(2131492897);
        if (n2 == 1) {
            this.SetNightModeThemeAfterContent();
        }
        ((AdView)this.findViewById(2131296305)).a(new c.a().c("android_studio:ad_template").a());
        String[] arrstring = new String[116];
        int n3 = 0;
        arrstring[0] = "Inventor of C";
        arrstring[1] = "Why to learn C?";
        arrstring[2] = "What is low,middle and High level language? Is C a low or middle or high level language?";
        arrstring[3] = "Difference between Compiler and Interpreter";
        arrstring[4] = "What is #include<stdio.h>";
        arrstring[5] = "Difference between #include<stdio.h> and #include\"stdio.h\"";
        arrstring[6] = "What are header files?";
        arrstring[7] = "What is main()?";
        arrstring[8] = "What are comments and why we use them and In what way they will affect the program?";
        arrstring[9] = "Structure of C Program";
        arrstring[10] = "What is return type?";
        arrstring[11] = "What is void?";
        arrstring[12] = "Why every line ends with semicolon but not for functions?";
        arrstring[13] = "What if someone tells you should write a program only with one function?";
        arrstring[14] = "Different types of comments";
        arrstring[15] = "What is a variable?";
        arrstring[16] = "What is data type and how many are there?";
        arrstring[17] = "What is typecast?";
        arrstring[18] = "What is printf and scanf?";
        arrstring[19] = "What is a format specifier?";
        arrstring[20] = "Syntax for printf";
        arrstring[21] = "Syntax for scanf";
        arrstring[22] = "How to print only till certain decimal points in c or Significance of %.3d or %.4f etc";
        arrstring[23] = "Significance of %2d or %3d and %-3d etc";
        arrstring[24] = "What is an operator?";
        arrstring[25] = "What is ++ and --";
        arrstring[26] = "What is post and pre increment or decrement?";
        arrstring[27] = "Different types of Operators in c and their Precedence";
        arrstring[28] = "What is ternary operator?";
        arrstring[29] = "How to convert String to Integer in C?";
        arrstring[30] = "What is \"break\" Statement?";
        arrstring[31] = "What is \"continue\" Statement?";
        arrstring[32] = "What is \"goto\" statement?";
        arrstring[33] = "What is recursion?";
        arrstring[34] = "What are the types of functions?";
        arrstring[35] = "What is calling function, called function and function declaration?";
        arrstring[36] = "What are actual parameters(arguments) and formal parameters?";
        arrstring[37] = "What is return in called function?";
        arrstring[38] = "What are the types of parameter passing?";
        arrstring[39] = "Create an infinite loop using functions or Create an infinite loop without using Loops.";
        arrstring[40] = "What is the functionality of strcmp()?";
        arrstring[41] = "What are storage classes in C?";
        arrstring[42] = "What is the scope of a variable in c?";
        arrstring[43] = "What is Automatic storage Class?";
        arrstring[44] = "What is Register Storage Class?";
        arrstring[45] = "What is Static Storage Class?";
        arrstring[46] = "What is External Storage Class?";
        arrstring[47] = "What is a Pointer?";
        arrstring[48] = "What is NULL Pointer?";
        arrstring[49] = "What is Dangling Pointer?";
        arrstring[50] = "What is an Array and why are we using it?";
        arrstring[51] = "What is prototype of a function?";
        arrstring[52] = "How arrays are passed to function?";
        arrstring[53] = "In which order recursive functions execute?";
        arrstring[54] = "What is entry controlled and exit controlled loop?";
        arrstring[55] = "Differnece between String and Arrays?";
        arrstring[56] = "What is formatted and Unformatted IO?";
        arrstring[57] = "What is dynamic memory allocation?";
        arrstring[58] = "What is the difference between local and global variables?";
        arrstring[59] = "What is implicit and explicit conversion?";
        arrstring[60] = "What is conio.h and getch() and clrscr()?";
        arrstring[61] = "Difference between union and structures";
        arrstring[62] = "what is reference operator and de-reference operator in pointers?";
        arrstring[63] = "what is d in %d and i in %i,x in %x,o in %obtain";
        arrstring[64] = "What are shorthand assignment operators?";
        arrstring[65] = "What is an escape sequence?";
        arrstring[66] = "How to print \\n?";
        arrstring[67] = "Difference between getc,getchar,getch,getche,gets,puts?";
        arrstring[68] = "What is += , -=  operator?";
        arrstring[69] = "Advantages of gets() over scanf?";
        arrstring[70] = "What is the min number of times a do while loop execute?";
        arrstring[71] = "What are the modes in files?";
        arrstring[72] = "Applications of C";
        arrstring[73] = "What is typedef?";
        arrstring[74] = "What are bitwise operators?";
        arrstring[75] = "What are Arithmetic operators?";
        arrstring[76] = "What are Logical operators?";
        arrstring[77] = "What are Relational Operators?";
        arrstring[78] = "What is itoa?";
        arrstring[79] = "Is C weakly typed language or strongly typed language and why?";
        arrstring[80] = "Print hello world without using semicolon?";
        arrstring[81] = "What is wild pointer?";
        arrstring[82] = "What is Far Pointer?";
        arrstring[83] = "What is the output of printf(\"%d\")?";
        arrstring[84] = "What is token?";
        arrstring[85] = "What is Acronym for ANSI and ASCII?";
        arrstring[86] = "What is Command Line Argument?";
        arrstring[87] = "Can a function return multiple values to called function?";
        arrstring[88] = "What is the output file generated by linker?";
        arrstring[89] = "Difference between printf,fprintf and sprintf";
        arrstring[90] = "What is 'f' in printf or scanf?";
        arrstring[91] = "Is hello,Hello,HELLO are same?";
        arrstring[92] = "What are the files that are generated after running C Program?";
        arrstring[93] = "What are the rules for a variable?";
        arrstring[94] = "Difference between malloc,calloc,realloc";
        arrstring[95] = "Difference between = and ==";
        arrstring[96] = "What is lvalue and rvalue";
        arrstring[97] = "Can a program be compiled without main() function?";
        arrstring[98] = "Difference between variable declaration and variable definition?";
        arrstring[99] = "Is C a structured or procedural programming language?";
        arrstring[100] = "When to use ForLoop,WhileLoop and Do-whileloop?";
        arrstring[101] = "Function used to release dynamically allocated memory?";
        arrstring[102] = "Function used to close file stream?";
        arrstring[103] = "What character is the end of a string?";
        arrstring[104] = "What are not valid operations on pointers?";
        arrstring[105] = "How can a pointer access array elements?";
        arrstring[106] = "C is derived from which language?";
        arrstring[107] = "What is enumeration?";
        arrstring[108] = "Keyword used to perform unconditional branching";
        arrstring[109] = "Is FILE a built in datatype?";
        arrstring[110] = "Default value of local and global variables";
        arrstring[111] = "What is static memory allocation";
        arrstring[112] = "How to make a generic pointer?";
        arrstring[113] = "What is cyclic property of datatype in C?";
        arrstring[114] = "Why i++ execution is faster than i+1?";
        arrstring[115] = "Why Pre Increment operator is faster than Post Increment Operator?";
        this.questions = arrstring;
        this.list = (ListView)this.findViewById(2131296460);
        while (n3 < this.questions.length) {
            String[] arrstring2 = this.questions;
            StringBuilder stringBuilder = new StringBuilder();
            int n4 = n3 + 1;
            stringBuilder.append(n4);
            stringBuilder.append(".");
            stringBuilder.append(this.questions[n3]);
            arrstring2[n3] = stringBuilder.toString();
            d d2 = new d(this.questions[n3]);
            this.arraylist.add((Object)d2);
            n3 = n4;
        }
        this.adapter = new e((Context)this, (List<d>)this.arraylist);
        this.list.setAdapter((ListAdapter)this.adapter);
        this.editsearch = (EditText)this.findViewById(2131296393);
        this.mClearText = (Button)this.findViewById(2131296351);
        this.mClearText.setVisibility(4);
        this.editsearch.addTextChangedListener(new TextWatcher(this){
            final /* synthetic */ MainActivity_Interview this$0;
            {
                this.this$0 = mainActivity_Interview;
            }

            public void afterTextChanged(android.text.Editable editable) {
                String string = this.this$0.editsearch.getText().toString().toLowerCase(java.util.Locale.getDefault());
                this.this$0.adapter.filter(string);
            }

            public void beforeTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
            }

            /*
             * Enabled aggressive block sorting
             */
            public void onTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
                Button button;
                int n5;
                if (charSequence.length() != 0) {
                    button = this.this$0.mClearText;
                    n5 = 0;
                } else {
                    button = this.this$0.mClearText;
                    n5 = 8;
                }
                button.setVisibility(n5);
            }
        });
    }
}

