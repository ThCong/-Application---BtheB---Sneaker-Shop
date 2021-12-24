package com.example.mytest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.adapter.CustomerService_Adapter;
import com.example.model.CustomerService;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class CustomerServiceActivity extends AppCompatActivity {
    ListView lvCustomerService;
    ArrayList<CustomerService> service_items;
    CustomerService_Adapter service_adapter;
    ImageView imvBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_service);

        lvCustomerService = findViewById(R.id.lvCustomerService);

        service_items = new ArrayList<CustomerService>();
        service_items.add(new CustomerService("FAQ",R.drawable.arrow_right));
        service_items.add(new CustomerService("Terms and Privacy",R.drawable.arrow_right));
        service_items.add(new CustomerService("Contact Us",R.drawable.arrow_right));


        service_adapter = new CustomerService_Adapter(this,R.layout.item_customer_service_layout,service_items);

        lvCustomerService.setAdapter(service_adapter);

        lvCustomerService.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 CustomerService i = service_items.get(position);
                 switch (i.getCustomerService_Name()) {
                     case "FAQ" : startActivity(new Intent(CustomerServiceActivity.this,FAQ.class)); break;
                     case "Contact Us" :
                         BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(CustomerServiceActivity.this);
                         bottomSheetDialog.setContentView(R.layout.layout_popup_contact);
                         Button btnCall;
                         btnCall = bottomSheetDialog.findViewById(R.id.btnCall);
                         btnCall.setOnClickListener(new View.OnClickListener() {
                             @Override
                             public void onClick(View view) {
                               DialCall();
                             }
                         });
                         bottomSheetDialog.show();
                 }
             }
         }
        );

        imvBack = findViewById(R.id.imvBack);
        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void DialCall() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        Uri uri = Uri.parse("tel: +0123456789");
        intent.setData(uri);
        startActivity(intent);
    }
}