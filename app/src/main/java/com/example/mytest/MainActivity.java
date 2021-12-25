package com.example.mytest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.Interface.MyMessClick;
import com.example.model.Messages;
import com.example.mytest.fragments.CartFragment;
import com.example.mytest.fragments.Mess1Fragment;
import com.example.mytest.fragments.Mess2Fragment;
import com.example.mytest.fragments.Mess3Fragment;
import com.example.mytest.ui.HomeFragment;
import com.example.mytest.ui.MoreFragment;
import com.example.mytest.ui.NotificationsFragment;
import com.example.mytest.ui.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements MyMessClick {

    public static BottomNavigationView bottomNavigationView;
    ImageView imvCart;
    EditText edtSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        setContentView(R.layout.activity_main);

        LinkViews();
        AddEvents();
        FirstTimeInstall();
    }


    private void LinkViews() {
        imvCart=findViewById(R.id.imvCart);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        edtSearch= findViewById(R.id.edtSearch);
    }

    private void AddEvents() {
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemReselectedListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();

        imvCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_full,new CartFragment()).commit();
                bottomNavigationView.setVisibility(View.GONE);
            }
        });

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

    private void FirstTimeInstall() {
        Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);

        if (isFirstRun) {
            startActivity(new Intent(MainActivity.this, SignIn.class));
        }
        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                .putBoolean("isFirstRun", false).commit();
    }


    boolean doubleBackToExitPressedOnce = false;
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 4000);
    }
}