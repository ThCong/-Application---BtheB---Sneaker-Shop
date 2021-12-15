package com.example.mytest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.adapter.CustomerService_Adapter;
import com.example.model.ItemCustomerServiceModel;

import java.util.ArrayList;

public class CustomerServiceActivity extends AppCompatActivity {
    ListView lvCustomerService;
    ArrayList<ItemCustomerServiceModel> service_items;
    CustomerService_Adapter service_adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_service);

        lvCustomerService = findViewById(R.id.lvCustomerService);

        service_items = new ArrayList<ItemCustomerServiceModel>();
        service_items.add(new ItemCustomerServiceModel("FAQ",R.drawable.arrow_right));
        service_items.add(new ItemCustomerServiceModel("Terms and Privacy",R.drawable.arrow_right));
        service_items.add(new ItemCustomerServiceModel("Contact Us",R.drawable.arrow_right));


        service_adapter = new CustomerService_Adapter(this,R.layout.custom_item_customer_service,service_items);

        lvCustomerService.setAdapter(service_adapter);


    }
}