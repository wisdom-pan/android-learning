package com.example.myapplicationtest1;

public class Item2 {
    private String product_name;
    private String price;




    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Item2(String product_name, String price) {
        this.product_name = product_name;
        this.price = price;
    }



}

