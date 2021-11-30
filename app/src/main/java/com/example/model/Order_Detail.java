package com.example.model;

public class Order_Detail {
    private int Thumb;
    private String Name;
    private Double Price;
    private Double Quantity;

    public Order_Detail(int thumb, String name, Double price, Double quantity) {
        Thumb = thumb;
        Name = name;
        Price = price;
        Quantity = quantity;
    }

    public int getThumb() {
        return Thumb;
    }

    public void setThumb(int thumb) {
        Thumb = thumb;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public Double getQuantity() {
        return Quantity;
    }

    public void setQuantity(Double quantity) {
        Quantity = quantity;
    }
}
