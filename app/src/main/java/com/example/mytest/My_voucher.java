package com.example.mytest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.adapter.VoucherAdapter;
import com.example.model.Voucher;

import java.util.ArrayList;

public class My_voucher extends AppCompatActivity {

    ImageView imvback;

    ListView lvVouchers;
    VoucherAdapter adapter;
    ArrayList<Voucher> vouchers;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_voucher);
        linkViews();
        initData();
        loadData();
        addEvents();
    }


    private void linkViews() {
        lvVouchers = findViewById(R.id.lvMyVoucher);
        imvback = findViewById(R.id.imvBack_MyVoucher);
    }


    private void initData() {
        vouchers = new ArrayList<>();
        vouchers.add(new com.example.model.Voucher(R.drawable.converse,"CONVERSE","BUY 1 GET 1"));
        vouchers.add(new com.example.model.Voucher(R.drawable.balenciaga,"BALENCIAGA","Sale off 10% for women items"));
        vouchers.add(new com.example.model.Voucher(R.drawable.nike,"NIKE","Sale off 10% all products."));
        vouchers.add(new com.example.model.Voucher(R.drawable.accessories,"ACCESSORIES","Sale up to 10% for all accessories items."));
    }
    private void loadData() {
        adapter = new VoucherAdapter(this,R.layout.item_myvoucher_layout,vouchers);
        lvVouchers.setAdapter(adapter);
    }

    private void addEvents() {
        imvback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}