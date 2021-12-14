package com.example.model;

import android.content.ClipData;

import java.io.Serializable;

public class ItemModel implements Serializable {
    private int Message_Thumb;
    private String Message_Name;


    public ItemModel(int message_Thumb, String message_Name) {
        Message_Name = message_Name;
        message_Thumb = message_Thumb;
    }

    public ItemModel() {
    }
    public int getMessage_Thumb() {
        return Message_Thumb;
    }

    public void setMessage_Thumb(int message_Thumb) {
        Message_Thumb = message_Thumb;
    }

    public String getMessage_Name() {
        return Message_Name;
    }

    public void setMessage_Name(String message_Name) {
        Message_Name = message_Name;
    }
}
