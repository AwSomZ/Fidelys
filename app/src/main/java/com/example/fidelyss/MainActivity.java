package com.example.fidelyss;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ((Button) findViewById(R.id.button)).setOnClickListener(this);
        ((TextView) findViewById(R.id.login)).setOnClickListener(this);

    }
    @Override
    public void onClick(View v)
    {
        Intent intent;

        switch (v.getId()) {
            case R.id.button:
                intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.translate_in_right,R.anim.translate_out_left);

                break;
            case R.id.login:
                intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.translate_in_right,R.anim.translate_out_left);

                break;}

    }

}