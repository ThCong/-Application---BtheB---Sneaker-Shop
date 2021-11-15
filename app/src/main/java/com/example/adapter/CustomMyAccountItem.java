package com.example.adapter;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

import androidx.annotation.NonNull;

import com.example.model.My_account;

import java.util.ArrayList;
import java.util.List;

public class CustomMyAccountItem extends ArrayAdapter<My_account> {

    private Context context;
    private int item_listview;
    private ArrayList<My_account> arrMyAccount;

    public CustomMyAccountItem(@NonNull Context context, int item_listview, @NonNull List<My_account> myAccountList) {
        super(context, item_listview, myAccountList);
        this.context = context;
        this.item_listview = item_listview;
        this.arrMyAccount = (ArrayList<My_account>) myAccountList;
    }


}
