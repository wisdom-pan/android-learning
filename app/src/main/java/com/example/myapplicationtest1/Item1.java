package com.example.myapplicationtest1;

public class Item1 {
    private String name1;
    private String name2;
    private String description;
    private String price;
    private String purchase;


    public String getName1() {
        return name1;
    }

    public String getName2() {
        return name2;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public String getPurchase() {
        return purchase;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setPurchase(String purchase) {
        this.purchase = purchase;
    }
    public Item1(){}

    public Item1(String name1, String name2, String description, String price, String purchase) {
        this.name1 = name1;
        this.name2 = name2;
        this.description = description;
        this.price = price;
        this.purchase = purchase;
    }


}
