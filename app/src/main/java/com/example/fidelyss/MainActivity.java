package com.example.fidelyss;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,NavigationView.OnNavigationItemSelectedListener  {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout= findViewById(R.id.drawer_layout);
        navigationView= findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(this);
        ((Button) findViewById(R.id.button)).setOnClickListener(this);
        ((Button) findViewById(R.id.button2)).setOnClickListener(this);

    }
    @Override
    public void onClick(View v)
    {
        Intent intent;

        switch (v.getId()) {
            case R.id.button:
                intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.button2:
                intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                break;}

    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_home:
                break;
            case R.id.nav_signup:
                Intent intent= new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_signin:
                Intent intent1= new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent1);
                break;

        }
        return true;
    }
}