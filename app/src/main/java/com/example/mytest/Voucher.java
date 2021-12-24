package com.example.mytest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import com.example.adapter.VoucherAdapter;




public class Voucher extends AppCompatActivity {

    ListView lvVoucher;
    VoucherAdapter adapter;
    ArrayList<com.example.model.Voucher> vouchers;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voucher);
        lvVoucher = findViewById(R.id.lvVoucher);
        initData();
        loadData();
    }



    private void initData() {
        vouchers = new ArrayList<>();
        vouchers.add(new com.example.model.Voucher(R.drawable.nike,"NIKE","Sale off 10% all products."));
        vouchers.add(new com.example.model.Voucher(R.drawable.balenciaga,"BALENCIAGA","Sale off 10% for women items"));
        vouchers.add(new com.example.model.Voucher(R.drawable.accessories,"ACCESSORIES","Sale up to 10% for all accessories items."));
        vouchers.add(new com.example.model.Voucher(R.drawable.converse,"CONVERSE","BUY 1 GET 1"));
    }
    private void loadData() {
        adapter = new VoucherAdapter(this,R.layout.voucher_item_layout,vouchers);
        lvVoucher.setAdapter(adapter);
    }
}