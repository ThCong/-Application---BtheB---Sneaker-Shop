package com.example.mytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
Button btnSignUp;
ImageView imvBack;
CheckBox cbAccept;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_layout);
        
        LinksView();
        AddEvents();
    }
    
    private void LinksView() {
        cbAccept = findViewById(R.id.checkboxAccept);
        btnSignUp = findViewById(R.id.btnSignUp);
        imvBack = findViewById(R.id.imvBack);
    }
    
    private void AddEvents() { 
        btnSignUp.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (cbAccept.isChecked())
            startActivity(new Intent(SignUp.this, MainActivity.class));
            else  Toast.makeText(SignUp.this,"You have to accept terms of use to signing up", Toast.LENGTH_SHORT).show();;
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