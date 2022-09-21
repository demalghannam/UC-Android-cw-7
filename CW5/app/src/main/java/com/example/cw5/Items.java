package com.example.cw5;

import java.io.Serializable;

public class Items implements Serializable {
    private String itemName;
    private String itemImage;
    private double itemPrice;

    public Items() {
    }

    public Items(String itemName, String itemImage, double itemPrice) {
        this.itemName = itemName;
        this.itemImage = itemImage;
        this.itemPrice = itemPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }
}
