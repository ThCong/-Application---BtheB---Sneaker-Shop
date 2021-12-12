package com.example.model;

public class Order_Detail {
    private int Thumb;
    private String Name,Type;
    private double Price;
    private Integer Quantity;

    public Order_Detail(int thumb, String name, String type, double price, Integer quantity) {
        Thumb = thumb;
        Name = name;
        Type = type;
        Price = price;
        Quantity = quantity;
    }

    public Order_Detail() {
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

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(Integer price) {
        Price = price;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }
}
