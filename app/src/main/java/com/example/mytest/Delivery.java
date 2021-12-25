package com.example.mytest;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Delivery extends AppCompatActivity {

    ImageView imvBack;
    Button btnTrackOrder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);

        LinkViews();
        AddEvents();
    }

    private void AddEvents() {
    imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

            btnTrackOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Delivery.this,Track_My_Order.class));
            }
        });
    }
    private void LinkViews() {
        imvBack = findViewById(R.id.imvBack);
        btnTrackOrder = findViewById(R.id.btnTrackOrder);
    }
}