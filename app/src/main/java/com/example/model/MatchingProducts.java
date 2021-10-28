package com.example.model;

public class MatchingProducts {
    public String ProductName;
    public int ProductPhoto;

    public MatchingProducts(String productName, int productPhoto) {
        ProductName = productName;
        ProductPhoto = productPhoto;

    }

    public MatchingProducts() {
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public int getProductPhoto() {
        return ProductPhoto;
    }

    public void setProductPhoto(int productPhoto) {
        ProductPhoto = productPhoto;
    }
}
