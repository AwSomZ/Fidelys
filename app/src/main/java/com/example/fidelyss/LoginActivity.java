package com.example.fidelyss;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    public EditText cin;
    public EditText pin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        cin= (EditText) findViewById(R.id.logincin);
        pin= (EditText) findViewById(R.id.loginpin);
        ((Button) findViewById(R.id.login)).setOnClickListener(this);
        ((TextView) findViewById(R.id.signup)).setOnClickListener(this);



    }
    @Override
    public void onClick(View v)
    {
        Intent intent;

        switch (v.getId()) {
            case R.id.login: login();
                break;
            case R.id.signup:intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.translate_in_right, R.anim.translate_out_left);
                break;
        }
    }

    private void login()
    {
        String cinadd = cin.getText().toString().trim();
        String pinadd = pin.getText().toString().trim();
        Gson gson = new GsonBuilder().setDateFormat("yyyy-mm-dd").create();
        Retrofit Rf = new Retrofit.Builder().baseUrl("http://192.168.1.13:80/").addConverterFactory(GsonConverterFactory.create(gson)).build();
        ApiHandler api = (ApiHandler)Rf.create(ApiHandler.class);
        Call<client> find = api.selectUser(cinadd,pinadd);
        find.enqueue(new Callback<client>() {
            @Override
            public void onResponse(Response<client> response, Retrofit retrofit)
            {
                if(response.body() != null ){

                    SharedPreferences sharedPreferences =  LoginActivity.this.getSharedPreferences("clientfidelys", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("nom",response.body().getNom());
                    editor.putString("prenom",response.body().getPrenom());
                    editor.putString("cin", response.body().getCin());
                    editor.putString("id", response.body().getId());
                    editor.putString("sexe", response.body().getSexe());
                    editor.commit();
                    Intent intent= new Intent(LoginActivity.this, MouvementActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.translate_in_right, R.anim.translate_out_left);

                }
                else{
                    System.out.println("/"+cinadd);

                    if(cinadd.equals("")){
                        cin.setError("Please enter you email");
                    }else {
                        Toast.makeText(LoginActivity.this, " cin is incorrect ", Toast.LENGTH_LONG).show();
                    }
                }
            }
            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(LoginActivity.this, "failed" + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();

            }
        });

    }

}