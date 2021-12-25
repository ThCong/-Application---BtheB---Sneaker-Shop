package com.example.mytest;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Forgot_pwd extends AppCompatActivity {

Button btnReset;
ImageView imvBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pwd);

        LinkViews();
        AddEvents();
    }

    private void LinkViews() {
        btnReset = findViewById(R.id.btnResetPW);
        imvBack = findViewById(R.id.imvBack);
    }

    private void AddEvents() {
        btnReset.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(Forgot_pwd.this,SignIn.class));
        }
    });

        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}