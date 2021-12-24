package com.example.mytest;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import com.example.Interface.MyBtnVoucherClick;
import com.example.adapter.VoucherAdapter;
import com.example.model.Vouchers;


public class Voucher extends AppCompatActivity{


    ImageView imvback;
    ListView lvVoucher;
    VoucherAdapter adapter;
    ArrayList<Vouchers> vouchers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voucher);
        linkViews();
        initData();
        loadData();
        addEvents();
    }


    private void linkViews() {
        lvVoucher = findViewById(R.id.lvVoucher);
        imvback = findViewById(R.id.imvBack_Voucher);
    }


    private void initData() {
        vouchers = new ArrayList<>();
        vouchers.add(new com.example.model.Vouchers(R.drawable.nike,"NIKE","Sale off 10% all products."));
        vouchers.add(new com.example.model.Vouchers(R.drawable.balenciaga,"BALENCIAGA","Sale off 10% for women items"));
        vouchers.add(new com.example.model.Vouchers(R.drawable.accessories,"ACCESSORIES","Sale up to 10% for all accessories items."));
        vouchers.add(new com.example.model.Vouchers(R.drawable.converse,"CONVERSE","BUY 1 GET 1"));
    }
    private void loadData() {
        adapter = new VoucherAdapter(this,R.layout.item_voucher_layout,vouchers);
        lvVoucher.setAdapter(adapter);
    }

    private void addEvents() {
        imvback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    public void btngetVoucher(Button btnVoucher) {
        btnVoucher.setBackgroundColor(this.getResources().getColor(R.color.grey));
    }
}