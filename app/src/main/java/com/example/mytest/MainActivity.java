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


import com.example.Interface.MyMessClick;
import com.example.mytest.ui.MoreFragment;
import com.example.mytest.ui.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements MyMessClick {
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

    @Override
    public void messclick(Messages m) {
        bottomNavigationView.setVisibility(View.GONE);
        switch (m.getMessage_Name()) {
            case "PEGASUS 38 FLYEASE LIGHTING":
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_full, new Mess1Fragment()).commit();
                break;
            case "SHOP FOR RUNNING SHOES LIKE A PRO":
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_full, new Mess2Fragment()).commit();
                break;
            case "NEW FAIRIES":
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_full, new Mess3Fragment()).commit();
                break;
        }
    }
}
