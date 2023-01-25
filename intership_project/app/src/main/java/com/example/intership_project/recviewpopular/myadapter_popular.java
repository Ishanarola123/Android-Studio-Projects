package com.example.intership_project.recviewpopular;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.intership_project.R;
import com.example.intership_project.recviewcat.myviewholder;

import java.util.ArrayList;

public class myadapter_popular extends RecyclerView.Adapter<myviewholder_popular> {
    ArrayList<Model_popular> data;

    public myadapter_popular(ArrayList<Model_popular> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public myviewholder_popular onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.singlerow_popular_categories,parent,false);
        return new myviewholder_popular(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder_popular holder, int position) {
        holder.itemname.setText(data.get(position).getItem_name());
        holder.itemprice.setText(data.get(position).getItem_price());
        holder.imageView.setImageResource(data.get(position).getImg_name());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
