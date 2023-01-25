package com.example.intership_project.recviewpopular;

import android.widget.ImageView;
import android.widget.TextView;

public class Model_popular {

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_price() {
        return item_price;
    }

    public void setItem_price(String item_price) {
        this.item_price = item_price;
    }

    public int getImg_name() {
        return img_name;
    }

    public void setImg_name(int img_name) {
        this.img_name = img_name;
    }

    private String item_name,item_price;
    private int img_name;


}
