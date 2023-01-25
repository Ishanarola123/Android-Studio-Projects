/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.support.v7.app.a
 *  android.support.v7.app.e
 *  android.view.View
 *  android.view.Window
 *  android.widget.ExpandableListAdapter
 *  android.widget.ExpandableListView
 *  android.widget.ExpandableListView$OnChildClickListener
 *  android.widget.LinearLayout
 *  com.google.android.gms.ads.AdView
 *  com.google.android.gms.ads.c
 *  com.google.android.gms.ads.c$a
 *  com.google.android.gms.ads.reward.c
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.List
 */
package com.cprograms4future.allcprograms;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.a;
import android.support.v7.app.e;
import android.view.View;
import android.view.Window;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import com.cprograms4future.allcprograms.Main2Activity;
import com.cprograms4future.allcprograms.PracticeQuestionsActivity;
import com.cprograms4future.allcprograms.g;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.c;
import com.google.android.gms.ads.reward.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PracticeQuestionsActivity
extends e {
    ExpandableListView expandableListView;
    int flagCompletedVideo = 0;
    private c mRewardedVideoAd;

    private void SetNightModeTheme() {
        this.getSupportActionBar().a((Drawable)new ColorDrawable(this.getResources().getColor(2131099699)));
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(this.getResources().getColor(2131099684));
        }
    }

    private void SetNightModeThemeAfterContent() {
        ((LinearLayout)this.findViewById(2131296266)).setBackgroundColor(this.getResources().getColor(2131099684));
    }

    private void loadRewardedVideoAd() {
        if (!this.mRewardedVideoAd.a()) {
            this.mRewardedVideoAd.a(this.getString(2131820587), new c.a().a());
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int n2 = Main2Activity.getNightState((Context)this);
        if (n2 == 1) {
            this.SetNightModeTheme();
        }
        this.setContentView(2131492900);
        if (n2 == 1) {
            this.SetNightModeThemeAfterContent();
        }
        ((AdView)this.findViewById(2131296301)).a(new c.a().c("android_studio:ad_template").a());
        this.expandableListView = (ExpandableListView)this.findViewById(2131296533);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap = new HashMap();
        String[] arrstring = this.getResources().getStringArray(2130903071);
        String[] arrstring2 = this.getResources().getStringArray(2130903040);
        int n3 = arrstring.length;
        for (int i2 = 0; i2 < n3; ++i2) {
            arrayList.add((Object)arrstring[i2]);
        }
        int n4 = arrstring2.length;
        for (int i3 = 0; i3 < n4; ++i3) {
            arrayList2.add((Object)arrstring2[i3]);
        }
        for (int i4 = 0; i4 < 30; ++i4) {
            hashMap.put(arrayList.get(i4), (Object)arrayList2);
        }
        String[] arrstring3 = new String[]{"file:///android_asset/practice1_pattern.html", "file:///android_asset/practice2_pattern2.html", "file:///android_asset/practice3_pattern3.html", "file:///android_asset/practice4_replace_vowels_with_ashsymbol.html", "file:///android_asset/practice5_display_consonants.html", "file:///android_asset/practice6_display_numbers_string.html", "file:///android_asset/practice7_numbers_left_alpha_right.html", "file:///android_asset/practice8_non_strings_non_numbers.html", "file:///android_asset/practice9_replace_zeros_with_ones_viceversa.html", "file:///android_asset/practice10_convert_string_upper.html", "file:///android_asset/practice11_convert_to_lower.html", "file:///android_asset/practice12_sum_1_11_111_till_n.html", "file:///android_asset/practice13_display_characters_individually.html", "file:///android_asset/practice14_numbers_in_letters_till_n.html", "file:///android_asset/practice15_check_upper_lower.html", "file:///android_asset/practice16_print_string_before_new_line.html", "file:///android_asset/practice17_remove_spaces_between_strings.html", "file:///android_asset/practice18_remove_first_character_each_string.html", "file:///android_asset/practice19_lenght_of_each_string.html", "file:///android_asset/practice20_capitalise_first_letter_in_each_word.html", "file:///android_asset/practice21_nested_printf.html", "file:///android_asset/practice22_print_string_given_times.html", "file:///android_asset/practice23_even_divide_2_else_multiply_3.html", "file:///android_asset/practice24_print_only_10_num_each_line.html", "file:///android_asset/practice25_display_minus_to_plus_num.html", "file:///android_asset/practice26_array_beautiful_or_not.html", "file:///android_asset/parctice27_final_value_if_double_every_success_search.html", "file:///android_asset/practice28_print_squares_odd_cubes_even.html", "file:///android_asset/practice29_upper_lower_in_decimals.html", "file:///android_asset/practice30_multi_table_right_angle.html"};
        g g2 = new g((Context)this, (List<String>)arrayList, (HashMap<String, List<String>>)hashMap, 19.0f);
        this.expandableListView.setAdapter((ExpandableListAdapter)g2);
        this.expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener(this, arrstring3){
            final /* synthetic */ PracticeQuestionsActivity this$0;
            final /* synthetic */ String[] val$practiceQuestionsPath;
            {
                this.this$0 = practiceQuestionsActivity;
                this.val$practiceQuestionsPath = arrstring;
            }

            public boolean onChildClick(ExpandableListView expandableListView, View view, int n2, int n3, long l2) {
                android.content.Intent intent = new android.content.Intent(this.this$0.getApplicationContext(), com.cprograms4future.allcprograms.HelloWorld.class);
                if (n2 <= this.val$practiceQuestionsPath.length) {
                    intent.setData(android.net.Uri.parse((String)this.val$practiceQuestionsPath[n2]));
                } else {
                    intent.setData(android.net.Uri.parse((String)"file:///android_asset/solution_not_found.html"));
                    android.widget.Toast.makeText((Context)this.this$0.getApplicationContext(), (java.lang.CharSequence)"Solution not Set", (int)1).show();
                }
                this.this$0.startActivity(intent);
                return false;
            }
        });
    }
}

