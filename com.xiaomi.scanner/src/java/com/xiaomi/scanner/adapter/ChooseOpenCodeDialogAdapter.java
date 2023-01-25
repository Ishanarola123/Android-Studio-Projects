/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Color
 *  android.graphics.drawable.Drawable
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.BaseAdapter
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  com.xiaomi.scanner.util.Util
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package com.xiaomi.scanner.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xiaomi.scanner.bean.ItemCHooseOpenCodeListBean;
import com.xiaomi.scanner.util.Util;
import java.util.List;

public class ChooseOpenCodeDialogAdapter
extends BaseAdapter {
    private Context context;
    private List<ItemCHooseOpenCodeListBean> list;

    public ChooseOpenCodeDialogAdapter(List<ItemCHooseOpenCodeListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public int getCount() {
        return this.list.size();
    }

    public Object getItem(int n2) {
        return this.list.get(n2);
    }

    public long getItemId(int n2) {
        return n2;
    }

    public View getView(int n2, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from((Context)this.context).inflate(2131558458, null, false);
            viewHolder = new ViewHolder();
            viewHolder.checked = (ImageView)view.findViewById(2131361949);
            viewHolder.icon = (ImageView)view.findViewById(2131361950);
            viewHolder.name = (TextView)view.findViewById(2131361953);
            viewHolder.layout = (LinearLayout)view.findViewById(2131361951);
            view.setTag((Object)viewHolder);
        } else {
            viewHolder = (ViewHolder)view.getTag();
        }
        viewHolder.name.setText((CharSequence)((ItemCHooseOpenCodeListBean)this.list.get(n2)).getAppName());
        Drawable drawable2 = Util.getAppIcon((Context)this.context, (String)((ItemCHooseOpenCodeListBean)this.list.get(n2)).getPackageName());
        if (drawable2 != null) {
            viewHolder.icon.setImageDrawable(drawable2);
        }
        if (((ItemCHooseOpenCodeListBean)this.list.get(n2)).isChecked()) {
            viewHolder.checked.setVisibility(0);
            viewHolder.layout.setBackgroundColor(Color.parseColor((String)"#0A000000"));
            viewHolder.name.setTextColor(Color.parseColor((String)"#ff0097ff"));
            return view;
        }
        viewHolder.checked.setVisibility(4);
        viewHolder.layout.setBackgroundColor(-1);
        viewHolder.name.setTextColor(-16777216);
        return view;
    }

    static class ViewHolder {
        ImageView checked;
        ImageView icon;
        LinearLayout layout;
        TextView name;

        ViewHolder() {
        }
    }

}

