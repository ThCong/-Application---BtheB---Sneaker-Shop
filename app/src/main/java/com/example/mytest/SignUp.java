package com.example.mytest;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

Button btnSignUp;
ImageView imvBack;
CheckBox cbAccept;
EditText edtName, edtPhone, edtMail, edtPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        
        LinksView();
        AddEvents();
    }
    
    private void LinksView() {
        cbAccept = findViewById(R.id.checkboxAccept);
        btnSignUp = findViewById(R.id.btnSignUp);
        imvBack = findViewById(R.id.imvBack);
        edtMail = findViewById(R.id.edtMail);
        edtPass = findViewById(R.id.edtPassword);
        edtName = findViewById(R.id.edtName);
        edtPhone = findViewById(R.id.edtPhone);
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