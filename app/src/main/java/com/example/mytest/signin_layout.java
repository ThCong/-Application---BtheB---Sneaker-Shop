package com.example.mytest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class signin_layout extends AppCompatActivity {

    EditText edtEmail, edtPassword;
    TextView tvForgotPassword;
    Button btnSignIn, btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_layout);

        linkViews();
        AddEvents();

    }
    private void linkViews() {
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        tvForgotPassword = findViewById(R.id.tvForgotPassword);
        btnSignIn = findViewById(R.id.btnSignIn);
        btnSignUp = findViewById(R.id.btnSignUp);
    }

    private void AddEvents() {
        
    }


}