package com.example.mytest.model;

public class Noti {
    int imgThumb;
    String txtTitle;

    public Noti(int imgThumb, String txtTitle) {
        this.imgThumb = imgThumb;
        this.txtTitle = txtTitle;
    }

    public int getImgThumb() {
        return imgThumb;
    }

    public void setImgThumb(int imgThumb) {
        this.imgThumb = imgThumb;
    }

    public String getTxtTitle() {
        return txtTitle;
    }

    public void setTxtTitle(String txtTitle) {
        this.txtTitle = txtTitle;
    }

}
