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

public class Redirection extends AppCompatActivity implements View.OnClickListener, View.OnFocusChangeListener {

    private String user;
    String tokenadd;
    EditText token;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redirection);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int) (width * 0.9), (int) (height * 0.33));
        token = (EditText) findViewById(R.id.token);
        token.setOnFocusChangeListener(this);
        user = getIntent().getStringExtra("user");
        ((Button) findViewById(R.id.gotologin)).setOnClickListener(this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Attendre s il vous plait ...");

    }

    @Override
    public void onClick(View v) {
        tokenadd = token.getText().toString().trim();
        if (tokenadd.isEmpty()) {
            token.setError("Vous Devez Saisir Le Code");
        }
        else {
            progressDialog.show();
            Retrofit Rf = new Retrofit.Builder().baseUrl(((Global) this.getApplication()).getBaseUrl()).addConverterFactory(GsonConverterFactory.create()).build();
            ApiHandler api = (ApiHandler) Rf.create(ApiHandler.class);
            Call<String> buy = api.verify(user, tokenadd);
            buy.enqueue(new retrofit.Callback<String>() {

                @Override
                public void onResponse(Response<String> response, Retrofit retrofit) {
                    if (response.body().equals("verifie")){
                        Toast.makeText(Redirection.this, "Votre Identifiant et Code Pin Ont été envoyer à votre Email", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(Redirection.this, LoginActivity.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.translate_in_right, R.anim.translate_out_left);
                    }
                    else if (response.body().equals("incorrect")) {
                        Toast.makeText(Redirection.this, " Code Est Incorrecte Verifie Votre Email ", Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(Redirection.this, "Compte Non Trouvé", Toast.LENGTH_LONG).show();
                    }
                    progressDialog.dismiss();
                }


                @Override
                public void onFailure(Throwable t) {
                    Toast.makeText(Redirection.this, " Erreur "+t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
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