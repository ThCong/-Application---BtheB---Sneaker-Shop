package com.example.mytest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.adapter.OrderDetailAdapter;
import com.example.adapter.PaymentMethodAdapter;
import com.example.adapter.VoucherAdapter;
import com.example.model.Order_Detail;
import com.example.model.PaymentMethod;
import com.example.model.Vouchers;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class Checkout extends AppCompatActivity {
    ListView lvItemCheckouts;
    ArrayList<Order_Detail> order_detailList;
    OrderDetailAdapter orderadapter;

    RecyclerView rcvPaymentMethod;
    ArrayList<PaymentMethod> methods;
    PaymentMethodAdapter methodadapter;
    BottomSheetDialog dialog;
    ImageView imvback;
    TextView txtRedeem,txtSubvoucher,txtVouchervalue,txtqtyvoucher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkout);
        linkViews();
        initData();
        loadData();
        addEvents();
    }


    private void linkViews() {
        lvItemCheckouts = findViewById(R.id.lvItemCheckouts);
        rcvPaymentMethod = findViewById(R.id.rcvPaymentMethod);
        imvback = findViewById(R.id.imvback_checkout);
        txtRedeem = findViewById(R.id.txtRedeem);
        txtSubvoucher = findViewById(R.id.txtSubvoucher);
        txtVouchervalue = findViewById(R.id.txtVouchervalue);
        txtqtyvoucher = findViewById(R.id.txtqtyvoucher);
    }

    private void initData() {

        //nạp dữ liệu vào danh sách item
        order_detailList = new ArrayList<>();
        order_detailList.add(new Order_Detail(R.drawable.sneaker2,"Ultraboost 29 Shoes","Fashion shoes",170.0,1,"To recieve"));
        order_detailList.add(new Order_Detail(R.drawable.sneaker1,"Ultraboost 29 Shoes","Fashion shoes",140.0,2,"Processing"));
        //nạp dữ liệu vào danh sách phương thức thanh toán
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        rcvPaymentMethod.setLayoutManager(manager);
        rcvPaymentMethod.setHasFixedSize(true);
        rcvPaymentMethod.setItemAnimator(new DefaultItemAnimator());
        methods = new ArrayList<>();
        methods.add(new PaymentMethod("Cash On Delivery","Pay when you receive",R.drawable.selected,R.drawable.cod));
        methods.add(new PaymentMethod("Internet Banking","Payment processed at Napas",R.drawable.nonselected,R.drawable.ebanking));
        methods.add(new PaymentMethod("E-wallet","Pay with E-Wallet App",R.drawable.nonselected,R.drawable.ewallet));
        DividerItemDecoration divider = new DividerItemDecoration(rcvPaymentMethod.getContext(),DividerItemDecoration.HORIZONTAL);
        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), R.drawable.custom_divider);
        divider.setDrawable(drawable);
        rcvPaymentMethod.addItemDecoration(divider);
    }

    private void loadData() {
       //nạp dữ liệu vào danh sách item
        orderadapter = new OrderDetailAdapter(Checkout.this, R.layout.item_checkout_layout,order_detailList);
        lvItemCheckouts.setAdapter(orderadapter);
        //nạp dữ liệu vào danh sách phương thức thanh toán
        methodadapter = new PaymentMethodAdapter(getApplicationContext(),methods);
        rcvPaymentMethod.setAdapter(methodadapter);
    }

    private void addEvents() {
        txtRedeem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new BottomSheetDialog(Checkout.this);
                dialog.setContentView(R.layout.layout_popup_myvoucher);
                ListView lvVoucher = dialog.findViewById(R.id.lvMyVoucherPopUp);
                VoucherAdapter adapter;
                ArrayList<Vouchers> vouchers;
                vouchers = new ArrayList<>();
                vouchers.add(new Vouchers(R.drawable.converse,"CONVERSE","BUY 1 GET 1"));
                vouchers.add(new Vouchers(R.drawable.balenciaga,"BALENCIAGA","Sale off 10%"));
                vouchers.add(new Vouchers(R.drawable.nike,"NIKE","Sale off 10% "));
                vouchers.add(new Vouchers(R.drawable.accessories,"ACCESSORIES","Sale up to 10%"));
                adapter = new VoucherAdapter(Checkout.this,R.layout.item_myvoucher_layout,vouchers);
                lvVoucher.setAdapter(adapter);

                dialog.show();
            }
        });


        imvback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void useVoucher(Vouchers voucher) {
        txtRedeem.setText(voucher.getTxtTittle());
        if (txtRedeem.getText() != "Redeem"){
            txtqtyvoucher.setText("1");
            txtSubvoucher.setText("Redeem (1) Voucher");
            txtVouchervalue.setText("-$5.00");
        }
        dialog.dismiss();
    }

}