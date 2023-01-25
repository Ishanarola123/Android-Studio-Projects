package com.example.intership_project.orderlist;

public class Model {
    public Model(String username, String itemname, String description, String phonenumber, double price, int orderquantity) {
        this.username = username;
        this.itemname = itemname;
        this.description = description;
        this.phonenumber = phonenumber;
        this.price = price;
        this.orderquantity = orderquantity;
    }

    String username,itemname,description,phonenumber;
    double price;
    int orderquantity;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getOrderquantity() {
        return orderquantity;
    }

    public void setOrderquantity(int orderquantity) {
        this.orderquantity = orderquantity;
    }
}
