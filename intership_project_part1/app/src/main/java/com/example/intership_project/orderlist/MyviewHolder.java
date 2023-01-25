package com.example.intership_project.orderlist;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.intership_project.R;

public class MyviewHolder extends RecyclerView.ViewHolder {
    ImageView itemimage;
    TextView textviewitemname;
    TextView textvieworderquantity, textviewprice;


    public MyviewHolder(@NonNull View itemView) {
        super(itemView);
        itemimage=itemView.findViewById(R.id.itemimage);
        textviewitemname=itemView.findViewById(R.id.itemname_orderlist);
        textvieworderquantity=itemView.findViewById(R.id.orderquantity);
        textviewprice=itemView.findViewById(R.id.price);
    }
}
