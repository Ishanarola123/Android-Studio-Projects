/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.TextView
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 *  com.xiaomi.scanner.module.ModuleManager
 *  com.xiaomi.scanner.module.ModuleManager$ModuleBaseInfo
 *  com.xiaomi.scanner.ui.helper.ItemTouchHelperAdapter
 *  com.xiaomi.scanner.ui.helper.ItemTouchHelperViewHolder
 *  com.xiaomi.scanner.ui.helper.OnStartDragListener
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.List
 */
package com.xiaomi.scanner.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.scanner.adapter.FunctionSortAdapter;
import com.xiaomi.scanner.module.ModuleManager;
import com.xiaomi.scanner.ui.helper.ItemTouchHelperAdapter;
import com.xiaomi.scanner.ui.helper.ItemTouchHelperViewHolder;
import com.xiaomi.scanner.ui.helper.OnStartDragListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FunctionSortAdapter
extends RecyclerView.Adapter<ItemViewHolder>
implements ItemTouchHelperAdapter {
    private Context context;
    private final OnStartDragListener mDragStartListener;
    private List<ModuleManager.ModuleBaseInfo> mItems = new ArrayList();

    public FunctionSortAdapter(Context context, OnStartDragListener onStartDragListener, List<ModuleManager.ModuleBaseInfo> list) {
        this.mDragStartListener = onStartDragListener;
        this.context = context;
        this.mItems = list;
    }

    static /* synthetic */ OnStartDragListener access$000(FunctionSortAdapter functionSortAdapter) {
        return functionSortAdapter.mDragStartListener;
    }

    public int getItemCount() {
        return this.mItems.size();
    }

    public List<ModuleManager.ModuleBaseInfo> getmItems() {
        return this.mItems;
    }

    public void onBindViewHolder(ItemViewHolder itemViewHolder, int n) {
        itemViewHolder.textView.setText((CharSequence)this.context.getResources().getString(((ModuleManager.ModuleBaseInfo)this.mItems.get(n)).getTitleResourceId()));
        itemViewHolder.handleView.setImageResource(((ModuleManager.ModuleBaseInfo)this.mItems.get(n)).getIconResourceSortId());
        itemViewHolder.itemView.setOnTouchListener(new View.OnTouchListener(this, itemViewHolder){
            final /* synthetic */ FunctionSortAdapter this$0;
            final /* synthetic */ ItemViewHolder val$holder;
            {
                this.this$0 = functionSortAdapter;
                this.val$holder = itemViewHolder;
            }

            public boolean onTouch(View view, android.view.MotionEvent motionEvent) {
                if (androidx.core.view.MotionEventCompat.getActionMasked((android.view.MotionEvent)motionEvent) == 0) {
                    FunctionSortAdapter.access$000(this.this$0).onStartDrag((RecyclerView.ViewHolder)this.val$holder);
                }
                return false;
            }
        });
    }

    public ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int n) {
        return new ItemViewHolder(LayoutInflater.from((Context)viewGroup.getContext()).inflate(2131558460, viewGroup, false), this.context);
    }

    public void onItemDismiss(int n) {
        this.mItems.remove(n);
        this.notifyItemRemoved(n);
    }

    public boolean onItemMove(int n, int n2) {
        Collections.swap(this.mItems, (int)n, (int)n2);
        this.notifyItemMoved(n, n2);
        return true;
    }

    public static class ItemViewHolder
    extends RecyclerView.ViewHolder
    implements ItemTouchHelperViewHolder {
        public final ImageView handleView;
        public final View itemView;
        private final Context mContext;
        public final TextView textView;

        public ItemViewHolder(View view, Context context) {
            super(view);
            this.textView = (TextView)view.findViewById(2131362190);
            this.handleView = (ImageView)view.findViewById(2131362051);
            this.itemView = view;
            this.mContext = context;
        }

        public void onItemClear() {
            this.itemView.setBackgroundColor(this.mContext.getResources().getColor(2131099727));
        }

        public void onItemSelected() {
            this.itemView.setBackgroundColor(this.mContext.getResources().getColor(2131099728));
        }
    }

}

