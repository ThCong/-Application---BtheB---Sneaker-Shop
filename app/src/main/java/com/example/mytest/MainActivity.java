package com.example.mytest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;


import com.example.database.Product_Database_Helper;
import com.example.mytest.fragments.CartFragment;
import com.example.mytest.ui.HomeFragment;
import com.example.mytest.ui.MoreFragment;
import com.example.mytest.ui.NotificationsFragment;
import com.example.mytest.ui.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    public static BottomNavigationView bottomNavigationView;
    ImageView imvCart;
    EditText edtSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemReselectedListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();

        imvCart=findViewById(R.id.imvCart);
        imvCart.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_full,new CartFragment()).commit();
            bottomNavigationView.setVisibility(View.GONE);
        }
    });

    edtSearch= findViewById(R.id.edtSearch);
    edtSearch.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(MainActivity.this,Search_keyword.class));
        }
    });

    }
    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemReselectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId())
            {
                case R.id.navigation_home:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.navigation_search:
                    selectedFragment = new SearchFragment();
                    break;
                case R.id.navigation_notifications:
                    selectedFragment = new NotificationsFragment();
                    break;
                case R.id.navigation_more:
                    selectedFragment = new MoreFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();

            return true;
        }
    };

//    @Override
//    public void messclick(Noti n) {
//
//    switch (n.getTxtTitle()) {
//        case "PEGASUS 38 FLYEASE “LIGHTING’" :
//            Mess1Fragment mess1Fragment = new Mess1Fragment();
//            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_full,mess1Fragment).commit();
//    }

//    }
}