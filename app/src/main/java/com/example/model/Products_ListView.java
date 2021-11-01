package com.example.model;

public class Products_ListView {
    private String Name;
    private int Thumb;
    private double Price;

    public Products_ListView(String name, int thumb, double price) {
        Name = name;
        Thumb = thumb;
        Price = price;
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
}
