package com.example.mytest.model;

public class Noti {
    int imgThumb;
    String txtTitle;
    int btnExplore;

    public Noti(int imgThumb, String txtTitle, int btnExplore) {
        this.imgThumb = imgThumb;
        this.txtTitle = txtTitle;
        this.btnExplore = btnExplore;
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

    public int getBtnExplore() {
        return btnExplore;
    }

    public void setBtnExplore(int btnExplore) {
        this.btnExplore = btnExplore;
    }
}
