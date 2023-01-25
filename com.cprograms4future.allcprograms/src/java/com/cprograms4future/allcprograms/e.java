/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.BaseAdapter
 *  android.widget.TextView
 *  com.cprograms4future.allcprograms.HelloWorld
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 *  java.util.Locale
 */
package com.cprograms4future.allcprograms;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.cprograms4future.allcprograms.HelloWorld;
import com.cprograms4future.allcprograms.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

public class e
extends BaseAdapter {
    private ArrayList<d> arraylist;
    LayoutInflater inflater;
    private List<d> interviewQuestionslist = null;
    Context mContext;

    public e(Context context, List<d> list) {
        this.mContext = context;
        this.interviewQuestionslist = list;
        this.inflater = LayoutInflater.from((Context)this.mContext);
        this.arraylist = new ArrayList();
        this.arraylist.addAll(list);
    }

    public void filter(String string) {
        String string2 = string.toLowerCase(Locale.getDefault());
        this.interviewQuestionslist.clear();
        if (string2.length() == 0) {
            this.interviewQuestionslist.addAll(this.arraylist);
        } else {
            for (d d2 : this.arraylist) {
                if (!d2.getQuestion().toLowerCase(Locale.getDefault()).contains((CharSequence)string2)) continue;
                this.interviewQuestionslist.add((Object)d2);
            }
        }
        this.notifyDataSetChanged();
    }

    public int getCount() {
        return this.interviewQuestionslist.size();
    }

    public d getItem(int n2) {
        return (d)this.interviewQuestionslist.get(n2);
    }

    public long getItemId(int n2) {
        return n2;
    }

    public View getView(final int n2, View view, ViewGroup viewGroup) {
        a a2;
        View view2;
        final String[] arrstring = new String[]{"file:///android_asset/interviewquestions/history_c.html", "file:///android_asset/interviewquestions/why_to_learn_c.html", "file:///android_asset/interviewquestions/low_middle_high_level.html", "file:///android_asset/interviewquestions/compiler_vs_interpreter.html", "file:///android_asset/interviewquestions/include_stdio_means.html", "file:///android_asset/interviewquestions/diff_stdio_vs_doublequot_stdio.html", "file:///android_asset/interviewquestions/header_files.html", "file:///android_asset/interviewquestions/what_is_main.html", "file:///android_asset/interviewquestions/comments_use.html", "file:///android_asset/interviewquestions/structure_c_prog.html", "file:///android_asset/interviewquestions/returntype.html", "file:///android_asset/interviewquestions/void_means.html", "file:///android_asset/interviewquestions/why_semicolon_end.html", "file:///android_asset/interviewquestions/whatifsomeone_tellsyoushould.html", "file:///android_asset/interviewquestions/different_comments.html", "file:///android_asset/interviewquestions/whatisvariable.html", "file:///android_asset/interviewquestions/datatype_and_hw_many.html", "file:///android_asset/interviewquestions/typecast.html", "file:///android_asset/interviewquestions/printfscanf.html", "file:///android_asset/interviewquestions/formatspecifier.html", "file:///android_asset/interviewquestions/printf_syntax.html", "file:///android_asset/interviewquestions/scanf_syntax.html", "file:///android_asset/interviewquestions/significance_point3f.html", "file:///android_asset/interviewquestions/significance_3d.html", "file:///android_asset/interviewquestions/what_is_operator.html", "file:///android_asset/interviewquestions/increment_decrement.html", "file:///android_asset/interviewquestions/postandpreinc_dec.html", "file:///android_asset/interviewquestions/operatorprecedence.html", "file:///android_asset/interviewquestions/ternary.html", "file:///android_asset/interviewquestions/stringtointeger.html", "file:///android_asset/interviewquestions/break.html", "file:///android_asset/interviewquestions/continue.html", "file:///android_asset/interviewquestions/goto.html", "file:///android_asset/interviewquestions/recursion.html", "file:///android_asset/interviewquestions/types_of_functions.html", "file:///android_asset/interviewquestions/calling_called_func_declaration.html", "file:///android_asset/interviewquestions/actual-formal_parametes.html", "file:///android_asset/interviewquestions/return_in_func.html", "file:///android_asset/interviewquestions/parameterpassing_technique.html", "file:///android_asset/interviewquestions/infiniteloop.html", "file:///android_asset/interviewquestions/strcmp.html", "file:///android_asset/interviewquestions/storage_classes.html", "file:///android_asset/interviewquestions/variable_scope.html", "file:///android_asset/interviewquestions/automatic.html", "file:///android_asset/interviewquestions/register.html", "file:///android_asset/interviewquestions/static.html", "file:///android_asset/interviewquestions/external.html", "file:///android_asset/interviewquestions/pointer.html", "file:///android_asset/interviewquestions/nullpointer.html", "file:///android_asset/interviewquestions/danglingpointer.html", "file:///android_asset/interviewquestions/arrayuse.html", "file:///android_asset/interviewquestions/prototype.html", "file:///android_asset/interviewquestions/arraytofunction.html", "file:///android_asset/interviewquestions/recursive_func_way_execute.html", "file:///android_asset/interviewquestions/entry_exit_controlledloop.html", "file:///android_asset/interviewquestions/stringvsarrays.html", "file:///android_asset/interviewquestions/format_vs_unformatted.html", "file:///android_asset/interviewquestions/dynamicmem_alloc.html", "file:///android_asset/interviewquestions/local_vs_global.html", "file:///android_asset/interviewquestions/implicit_vs_explicit.html", "file:///android_asset/interviewquestions/conio_getch.html", "file:///android_asset/interviewquestions/unionvsstructure.html", "file:///android_asset/interviewquestions/def-referenceop.html", "file:///android_asset/interviewquestions/d_o_x_i.html", "file:///android_asset/interviewquestions/shorthand.html", "file:///android_asset/interviewquestions/escapesequnce.html", "file:///android_asset/interviewquestions/print_slash_n.html", "file:///android_asset/interviewquestions/getsgetcgetchar.html", "file:///android_asset/interviewquestions/plusequal_minusequal.html", "file:///android_asset/interviewquestions/gets_vs_scanf.html", "file:///android_asset/interviewquestions/min_execution_do_while.html", "file:///android_asset/interviewquestions/filemodes.html", "file:///android_asset/interviewquestions/application_c.html", "file:///android_asset/interviewquestions/typedef.html", "file:///android_asset/interviewquestions/bitwise.html", "file:///android_asset/interviewquestions/arithmetic.html", "file:///android_asset/interviewquestions/logical_operators.html", "file:///android_asset/interviewquestions/relational.html", "file:///android_asset/interviewquestions/itoa.html", "file:///android_asset/interviewquestions/iscweakly_strongly.html", "file:///android_asset/interviewquestions/print_hello_semi.html", "file:///android_asset/interviewquestions/wildpointer.html", "file:///android_asset/interviewquestions/farpointer.html", "file:///android_asset/interviewquestions/output_percent_d.html", "file:///android_asset/interviewquestions/token.html", "file:///android_asset/interviewquestions/ascii_ansi_full.html", "file:///android_asset/interviewquestions/commandlineargument.html", "file:///android_asset/interviewquestions/func_ret_multiple.html", "file:///android_asset/interviewquestions/output_gen_file_linker.html", "file:///android_asset/interviewquestions/printf_fprintf_sprintf.html", "file:///android_asset/interviewquestions/f_in_printf.html", "file:///android_asset/interviewquestions/hello_Hello_HELLO.html", "file:///android_asset/interviewquestions/files_generated_runc.html", "file:///android_asset/interviewquestions/rules_variables.html", "file:///android_asset/interviewquestions/malloc_realloc_calloc.html", "file:///android_asset/interviewquestions/equal_equalequal.html", "file:///android_asset/interviewquestions/lvalue_rvalue.html", "file:///android_asset/interviewquestions/main_compile.html", "file:///android_asset/interviewquestions/variable_declaration_definition.html", "file:///android_asset/interviewquestions/structure_vs_procedural.html", "file:///android_asset/interviewquestions/fixednumbertimespreferedloop.html", "file:///android_asset/interviewquestions/release_dynamically_allocated_memory.html", "file:///android_asset/interviewquestions/func_used_to_close_file.html", "file:///android_asset/interviewquestions/character_end_string.html", "file:///android_asset/interviewquestions/not_valid_operations_pointer.html", "file:///android_asset/interviewquestions/pointer_array_access.html", "file:///android_asset/interviewquestions/c_derived_from.html", "file:///android_asset/interviewquestions/enumeration.html", "file:///android_asset/interviewquestions/unconditional_branching.html", "file:///android_asset/interviewquestions/file_built_datatype.html", "file:///android_asset/interviewquestions/default_global_local.html", "file:///android_asset/interviewquestions/static_mem_allocation.html", "file:///android_asset/interviewquestions/generic_pointer.html", "file:///android_asset/interviewquestions/cyclic_property.html", "file:///android_asset/interviewquestions/fasterexecution_i_inc.html", "file:///android_asset/interviewquestions/pre_post_inc_fastness.html"};
        final String[] arrstring2 = new String[]{"Inventor of C", "Why to learn C?", "What is low,middle and High level language? Is C a low or middle or high level language?", "Difference between Compiler and Interpreter", "What is #include<stdio.h>", "Difference between #include<stdio.h> and #include\"stdio.h\"", "What are header files?", "What is main()?", "What are comments and why we use them and In what way they will affect the program?", "Structure of C Program", "What is return type?", "What is void?", "Why every line ends with semicolon but not for functions?", "What if someone tells you should write a program only with one function?", "Different types of comments", "What is a variable?", "What is data type and how many are there?", "What is typecast?", "What is printf and scanf?", "What is a format specifier?", "Syntax for printf", "Syntax for scanf", "How to print only till certain decimal points in c or Significance of %.3d or %.4f etc", "Significance of %2d or %3d and %-3d etc", "What is an operator?", "What is ++ and --", "What is post and pre increment or decrement?", "Different types of Operators in c and their Precedence", "What is ternary operator?", "How to convert String to Integer in C?", "What is \"break\" Statement?", "What is \"continue\" Statement?", "What is \"goto\" statement?", "What is recursion?", "What are the types of functions?", "What is calling function, called function and function declaration?", "What are actual parameters(arguments) and formal parameters?", "What is return in called function?", "What are the types of parameter passing?", "Create an infinite loop using functions or Create an infinite loop without using Loops.", "What is the functionality of strcmp()?", "What are storage classes in C?", "What is the scope of a variable in c?", "What is Automatic storage Class?", "What is Register Storage Class?", "What is Static Storage Class?", "What is External Storage Class?", "What is a Pointer?", "What is NULL Pointer?", "What is Dangling Pointer?", "What is an Array and why are we using it?", "What is prototype of a function?", "How arrays are passed to function?", "In which order recursive functions execute?", "What is entry controlled and exit controlled loop?", "Differnece between String and Arrays?", "What is formatted and Unformatted IO?", "What is dynamic memory allocation?", "What is the difference between local and global variables?", "What is implicit and explicit conversion?", "What is conio.h and getch() and clrscr()?", "Difference between union and structures", "what is reference operator and de-reference operator in pointers?", "what is d in %d and i in %i,x in %x,o in %obtain", "What are shorthand assignment operators?", "What is an escape sequence?", "How to print \\n?", "Difference between getc,getchar,getch,getche,gets,puts?", "What is += , -=  operator?", "Advantages of gets() over scanf?", "What is the min number of times a do while loop execute?", "What are the modes in files?", "Applications of C", "What is typedef?", "What are bitwise operators?", "What are Arithmetic operators?", "What are Logical operators?", "What are Relational Operators?", "What is itoa?", "Is C weakly typed language or strongly typed language and why?", "Print hello world without using semicolon?", "What is wild pointer?", "What is Far Pointer?", "What is the output of printf(\"%d\")?", "What is token?", "What is Acronym for ANSI and ASCII?", "What is Command Line Argument?", "Can a function return multiple values to called function?", "What is the output file generated by linker?", "Difference between printf,fprintf and sprintf", "What is 'f' in printf or scanf?", "Is hello,Hello,HELLO are same?", "What are the files that are generated after running C Program?", "What are the rules for a variable?", "Difference between malloc,calloc,realloc", "Difference between = and ==", "What is lvalue and rvalue", "Can a program be compiled without main() function?", "Difference between variable declaration and variable definition?", "Is C a structured or procedural programming language?", "When to use ForLoop,WhileLoop and Do-whileloop?", "Function used to release dynamically allocated memory?", "Function used to close file stream?", "What character is the end of a string?", "What are not valid operations on pointers?", "How can a pointer access array elements?", "C is derived from which language?", "What is enumeration?", "Keyword used to perform unconditional branching", "Is FILE a built in datatype?", "Default value of local and global variables", "What is static memory allocation", "How to make a generic pointer?", "What is cyclic property of datatype in C?", "Why i++ execution is faster than i+1?", "Why Pre Increment operator is faster than Post Increment Operator?"};
        if (view == null) {
            a2 = new a();
            view2 = this.inflater.inflate(2131492936, null);
            a2.questions = (TextView)view2.findViewById(2131296539);
            view2.setTag((Object)a2);
        } else {
            a2 = (a)view.getTag();
            view2 = view;
        }
        a2.questions.setText((CharSequence)((d)this.interviewQuestionslist.get(n2)).getQuestion());
        view2.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                int n22;
                String string = ((d)e.this.interviewQuestionslist.get(n2)).getQuestion();
                int n3 = 0;
                do {
                    int n4 = arrstring.length;
                    n22 = 0;
                    if (n3 >= n4) break;
                    StringBuilder stringBuilder = new StringBuilder();
                    int n5 = n3 + 1;
                    stringBuilder.append(n5);
                    stringBuilder.append(".");
                    stringBuilder.append(arrstring2[n3]);
                    if (string.equals((Object)stringBuilder.toString())) {
                        n22 = n3;
                        break;
                    }
                    n3 = n5;
                } while (true);
                String string2 = arrstring[n22];
                Intent intent = new Intent(e.this.mContext, HelloWorld.class);
                intent.setData(Uri.parse((String)string2));
                e.this.mContext.startActivity(intent);
            }
        });
        return view2;
    }

    public class a {
        TextView questions;
    }

}

