/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Typeface
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.BaseExpandableListAdapter
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  com.cprograms4future.allcprograms.Main2Activity
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.List
 */
package com.cprograms4future.allcprograms;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cprograms4future.allcprograms.Main2Activity;
import java.util.HashMap;
import java.util.List;

public class g
extends BaseExpandableListAdapter {
    private HashMap<String, List<String>> child_titles;
    private Context ctx;
    private List<String> header_titles;
    private float textSizeHeading = 0.0f;

    g(Context context, List<String> list, HashMap<String, List<String>> hashMap) {
        this.ctx = context;
        this.child_titles = hashMap;
        this.header_titles = list;
    }

    g(Context context, List<String> list, HashMap<String, List<String>> hashMap, float f2) {
        this.ctx = context;
        this.child_titles = hashMap;
        this.header_titles = list;
        this.textSizeHeading = f2;
    }

    public Object getChild(int n2, int n3) {
        return ((List)this.child_titles.get(this.header_titles.get(n2))).get(n3);
    }

    public long getChildId(int n2, int n3) {
        return n3;
    }

    public View getChildView(int n2, int n3, boolean bl, View view, ViewGroup viewGroup) {
        String string = (String)this.getChild(n2, n3);
        if (view == null) {
            view = ((LayoutInflater)this.ctx.getSystemService("layout_inflater")).inflate(2131492910, null);
        }
        LinearLayout linearLayout = (LinearLayout)view.findViewById(2131296262);
        TextView textView = (TextView)view.findViewById(2131296348);
        textView.setText((CharSequence)string);
        if (Main2Activity.getNightState((Context)view.getContext()) == 1) {
            textView.setTextColor(view.getContext().getResources().getColor(2131099865));
            linearLayout.setBackgroundColor(view.getContext().getResources().getColor(2131099684));
        }
        return view;
    }

    public int getChildrenCount(int n2) {
        return ((List)this.child_titles.get(this.header_titles.get(n2))).size();
    }

    public Object getGroup(int n2) {
        return this.header_titles.get(n2);
    }

    public int getGroupCount() {
        return this.header_titles.size();
    }

    public long getGroupId(int n2) {
        return n2;
    }

    public View getGroupView(int n2, boolean bl, View view, ViewGroup viewGroup) {
        String string = (String)this.getGroup(n2);
        if (view == null) {
            view = ((LayoutInflater)this.ctx.getSystemService("layout_inflater")).inflate(2131492962, null);
        }
        LinearLayout linearLayout = (LinearLayout)view.findViewById(2131296265);
        TextView textView = (TextView)view.findViewById(2131296431);
        if (this.textSizeHeading != 0.0f) {
            textView.setTextSize(this.textSizeHeading);
        }
        textView.setTypeface(null, 1);
        textView.setText((CharSequence)string);
        if (Main2Activity.getNightState((Context)view.getContext()) == 1) {
            textView.setTextColor(view.getContext().getResources().getColor(2131099865));
            linearLayout.setBackgroundColor(view.getContext().getResources().getColor(2131099685));
        }
        return view;
    }

    public boolean hasStableIds() {
        return false;
    }

    public boolean isChildSelectable(int n2, int n3) {
        return true;
    }
}

