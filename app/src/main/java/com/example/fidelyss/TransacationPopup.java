package com.example.fidelyss;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.DisplayMetrics;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TransacationPopup extends AppCompatActivity {
String value;
String depends;
String date;
String color;
String id;
TextView ref;
    SharedPreferences sharedPreferences;
TextView dep;
TextView description;
TextView val;
TextView dat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transacation_popup);
        sharedPreferences = getSharedPreferences("clientfidelys", Context.MODE_PRIVATE);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*0.9),(int)(height*0.46));

        ref = (TextView) findViewById(R.id.id);
        dep = (TextView) findViewById(R.id.depends);
        val = (TextView) findViewById(R.id.valeur);
        dat = (TextView) findViewById(R.id.date);
        description = (TextView) findViewById(R.id.description);
        description.setMovementMethod(new ScrollingMovementMethod());



        Intent intent = getIntent();
        if(intent.hasExtra("depends"))
            {
                depends=intent.getStringExtra("depends");
            }
        System.out.println("Hello waa"+depends);
        if (depends.equals("crédit"))
        {
            System.out.println("Credit Green");
            ref.setText(sharedPreferences.getString("ref", ""));
            dep.setText(sharedPreferences.getString("depends", ""));
            val.setText(sharedPreferences.getString("value", ""));
            dat.setText(sharedPreferences.getString("datee", ""));
            description.setText(sharedPreferences.getString("description", ""));
            val.setTextColor(getResources().getColor(R.color.green));
        }
        else
            {
                ref.setText(sharedPreferences.getString("ref", ""));
                dep.setText(sharedPreferences.getString("depends", ""));
                val.setText(sharedPreferences.getString("value", ""));
                dat.setText(sharedPreferences.getString("datee", ""));
                description.setText(sharedPreferences.getString("description", ""));
                val.setTextColor(getResources().getColor(R.color.red));

            }
    }
}