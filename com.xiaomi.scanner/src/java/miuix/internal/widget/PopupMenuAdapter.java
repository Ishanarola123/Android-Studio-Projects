/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.view.LayoutInflater
 *  android.view.Menu
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.BaseAdapter
 *  android.widget.ImageView
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.util.ArrayList
 *  miuix.appcompat.R
 *  miuix.appcompat.R$id
 *  miuix.appcompat.R$layout
 */
package miuix.internal.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import miuix.appcompat.R;
import miuix.internal.util.AnimHelper;
import miuix.internal.util.TaggingDrawableUtil;

public class PopupMenuAdapter
extends BaseAdapter {
    private ArrayList<MenuItem> mAvailableItems;
    private Context mContext;
    private LayoutInflater mInflater;

    PopupMenuAdapter(Context context) {
        this(context, null);
    }

    protected PopupMenuAdapter(Context context, Menu menu) {
        this.mInflater = LayoutInflater.from((Context)context);
        this.mAvailableItems = new ArrayList();
        if (menu != null) {
            this.buildMenuItems(menu, this.mAvailableItems);
        }
        this.mContext = context;
    }

    private void buildMenuItems(Menu menu, ArrayList<MenuItem> arrayList) {
        arrayList.clear();
        if (menu != null) {
            int n = menu.size();
            for (int i = 0; i < n; ++i) {
                MenuItem menuItem = menu.getItem(i);
                if (!this.checkMenuItem(menuItem)) continue;
                arrayList.add((Object)menuItem);
            }
        }
    }

    protected boolean checkMenuItem(MenuItem menuItem) {
        return menuItem.isVisible();
    }

    public int getCount() {
        return this.mAvailableItems.size();
    }

    public MenuItem getItem(int n) {
        return (MenuItem)this.mAvailableItems.get(n);
    }

    public long getItemId(int n) {
        return n;
    }

    public View getView(int n, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.mInflater.inflate(R.layout.miuix_appcompat_popup_menu_item, viewGroup, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.icon = (ImageView)view.findViewById(16908294);
            viewHolder.title = (TextView)view.findViewById(16908308);
            view.setTag(R.id.tag_popup_menu_item, (Object)viewHolder);
            AnimHelper.addPressAnimWithBg(view);
        }
        TaggingDrawableUtil.updateItemBackground(view, n, this.getCount());
        Object object = view.getTag(R.id.tag_popup_menu_item);
        if (object != null) {
            ViewHolder viewHolder = (ViewHolder)object;
            MenuItem menuItem = this.getItem(n);
            if (menuItem.getIcon() != null) {
                viewHolder.icon.setImageDrawable(menuItem.getIcon());
                viewHolder.icon.setVisibility(0);
            } else {
                viewHolder.icon.setVisibility(8);
            }
            viewHolder.title.setText(menuItem.getTitle());
        }
        return view;
    }

    public void update(Menu menu) {
        this.buildMenuItems(menu, this.mAvailableItems);
        this.notifyDataSetChanged();
    }

    private static class ViewHolder {
        ImageView icon;
        TextView title;

        private ViewHolder() {
        }
    }

}

