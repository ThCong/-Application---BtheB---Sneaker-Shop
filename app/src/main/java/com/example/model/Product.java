package com.example.model;

import java.io.Serializable;

public class Product implements Serializable {
    private String Name;
    private byte[] Thumb;
    private double Price;
    private String Type;


    public Product ( String name, double price, byte[] thumb, String type) {
        this.Name = name;
        this.Price = price;
        this.Thumb = thumb;
        this.Type = type;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public byte[] getThumb() {
        return Thumb;
    }

    public void setThumb(byte[] thumb) {
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
