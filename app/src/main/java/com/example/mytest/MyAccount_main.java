package com.example.mytest;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.adapter.CustomMyAccountItem;
import com.example.model.My_account;

import java.util.ArrayList;

public class MyAccount_main extends AppCompatActivity {
    ListView lvAccount;
    ArrayList<My_account> myAccounts;
    CustomMyAccountItem adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_account);

        LinkViews();
        initData();
        loadData();

    }

    private void loadData() {
        adapter = new CustomMyAccountItem(MyAccount_main.this, R.layout.list_my_account_item);
        lvAccount.setAdapter(adapter);
    }


    private void LinkViews() {
        lvAccount = findViewById(R.id.lvMyAccount);
    }





    private void initData() {

        myAccounts = new ArrayList<My_account>();
        myAccounts.add(new My_account("My Details", "BTB", "behindthebush@gmail.com"))  ;
        myAccounts.add(new My_account("Delivery", "0123456789", "Trường ĐH Kinh tế - Luật"))  ;
        myAccounts.add(new My_account("My Orders", "",""))  ;
        myAccounts.add(new My_account("My Returns", "",""))  ;
    }




}
