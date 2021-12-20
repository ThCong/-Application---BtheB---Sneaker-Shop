package com.example.model;

import java.io.Serializable;

public class Myorders implements Serializable {
    private String Name;
    private int Thumb;

    public Myorders(String name, int thumb) {
        Name = name;
        Thumb = thumb;
    }

    public Myorders() {
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
}
