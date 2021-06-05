package com.example.fidelyss;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class ForgotPinActivity extends AppCompatActivity implements View.OnClickListener {

    String idadd;
    private EditText id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pin);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int) (width * 0.9), (int) (height * 0.3));
        id=(EditText) findViewById(R.id.identifiant);
        ((Button) findViewById(R.id.verifier)).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        idadd = id.getText().toString().trim();
        if (idadd.isEmpty()) {
            id.setError("Vous Devez Saisir Votre Identifiant");
        }
        else {
            Retrofit Rf = new Retrofit.Builder().baseUrl(((Global) this.getApplication()).getBaseUrl()).addConverterFactory(GsonConverterFactory.create()).build();
            ApiHandler api = (ApiHandler) Rf.create(ApiHandler.class);

            Call<String> buy = api.forgotpin(idadd);
            buy.enqueue(new retrofit.Callback<String>() {

                @Override
                public void onResponse(Response<String> response, Retrofit retrofit) {
                if (response.body().equals("sent"))
                {
                    Toast.makeText(ForgotPinActivity.this, "Votre Code Pin a été evoyer a votre email" , Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(ForgotPinActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(ForgotPinActivity.this, "Verifiez votre identifiant" , Toast.LENGTH_LONG).show();
                }
                }

                @Override
                public void onFailure(Throwable t) {
                    Toast.makeText(ForgotPinActivity.this, "Error "+t.getLocalizedMessage() , Toast.LENGTH_LONG).show();
                }
            });
            }
    }
}