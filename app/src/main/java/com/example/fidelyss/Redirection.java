package com.example.fidelyss;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Redirection extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redirection);
        ((Button)findViewById(R.id.gotologin)).setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}