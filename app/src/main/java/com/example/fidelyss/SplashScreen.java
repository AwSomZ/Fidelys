package com.example.fidelyss;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {
Handler handler;

    private String login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences =  SplashScreen.this.getSharedPreferences("clientfidelys", Context.MODE_PRIVATE);
                login = sharedPreferences.getString("LOGIN",null);

                if(login != null) {Intent intent = new Intent(SplashScreen.this, MouvementActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.translate_in_right, R.anim.translate_out_left);
                    finish();

                }
                else {
                    Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.translate_in_right, R.anim.translate_out_left);
                    finish();}
            }
        },3000);
    }
}