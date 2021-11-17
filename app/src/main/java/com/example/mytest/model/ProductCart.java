package com.example.mytest.model;

public class ProductCart {


        private int Thumb;
        private String Name;
        private double Price;
        private String Type;


        public ProductCart() {
        }

        public ProductCart(int thumb, String name, double price, String type) {
            Thumb = thumb;
            Name = name;
            Price = price;
            Type = type;
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
