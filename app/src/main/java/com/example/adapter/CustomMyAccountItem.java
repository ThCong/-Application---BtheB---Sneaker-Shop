package com.example.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.model.My_account;
import com.example.mytest.MyAccount_main;
import com.example.mytest.R;

import java.util.ArrayList;
import java.util.List;

public class CustomMyAccountItem extends BaseAdapter {


    Activity context;
    int item_listview;

    public CustomMyAccountItem(Activity context, int item_listview, List<My_account> accountList) {
        this.context = context;
        this.item_listview = item_listview;
        this.accountList = accountList;
    }

    List<My_account> accountList;

    public CustomMyAccountItem(MyAccount_main context, int list_my_account_item) {
    }

    @Override
    public int getCount() {
        return accountList.size();
    }

    @Override
    public Object getItem(int i) {
        return accountList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        CustomMyAccountItem.ViewHolder holder;
        if(view ==null){
            holder = new CustomMyAccountItem.ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_listview, null);
            holder.txtText1 = view.findViewById(R.id.txtText1);
            holder.txtText2 = view.findViewById(R.id.txtText2);
            holder.txtText3 = view.findViewById(R.id.txtText3);

            view.setTag(holder);

        }else{
            holder = (CustomMyAccountItem.ViewHolder) view.getTag();
        }

        My_account AC = accountList.get(i);
        holder.txtText1.setText(AC.getText1());
        holder.txtText2.setText(AC.getText2());
        holder.txtText3.setText(AC.getText3());

        return view;
    }
    public static class ViewHolder {
        TextView txtText1, txtText2,txtText3;
    }
}