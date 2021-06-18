package com.example.fidelyss;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class ForgotPinActivity extends AppCompatActivity implements View.OnClickListener, View.OnFocusChangeListener {

    String idadd;
    private EditText id;
    ProgressDialog progressDialog;
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
        id.setOnFocusChangeListener(this);
        ((Button) findViewById(R.id.verifier)).setOnClickListener(this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Veuillez patienter ...");
    }

    @Override
    public void onClick(View view) {
        idadd = id.getText().toString().trim();
        if (idadd.isEmpty()) {
            id.setError("Vous Devez Saisir Votre Identifiant");
        }
        else {
            progressDialog.show();
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
                    progressDialog.dismiss();
                    finish();
                }
                else if (response.body().equals("non")){
                    Toast.makeText(ForgotPinActivity.this, "Vous avez utilisé cette fonctionalité veuillez verifier votre email" , Toast.LENGTH_LONG).show();
                    progressDialog.dismiss();
                    finish();
                }
                else {
                    Toast.makeText(ForgotPinActivity.this, "Verifiez votre identifiant" , Toast.LENGTH_LONG).show();
                    progressDialog.dismiss();
                }
                }

                @Override
                public void onFailure(Throwable t) {
                    Toast.makeText(ForgotPinActivity.this, "Erreur "+t.getLocalizedMessage() , Toast.LENGTH_LONG).show();
                    progressDialog.dismiss();
                }
            });
            }
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        if(!b){
            InputMethodManager inputMethodManager =(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }
}