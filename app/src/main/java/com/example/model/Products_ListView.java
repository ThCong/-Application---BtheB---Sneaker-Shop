package com.example.model;

import java.io.Serializable;

public class Products_ListView implements Serializable {
    private String Name;
    private int Thumb;
    private double Price;
    private String Type;

    public Products_ListView(int thumb, String name, double price, String type) {
        this.Thumb = thumb;
        this.Name = name;
        this.Price = price;
        this.Type = type;
    }

    public Products_ListView() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getThumb() {
        return Thumb;
    }

    public void setThumb(int thumb) {
        Thumb = thumb;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}
