package com.example.fidelyss;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.SimpleDateFormat;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, View.OnFocusChangeListener {
    public EditText cin;
    public EditText pin;
    ImageView goback;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        cin= (EditText) findViewById(R.id.logincin);
        pin= (EditText) findViewById(R.id.loginpin);
        goback= (ImageView) findViewById(R.id.goback);
        goback.setOnClickListener(this);
        ((Button) findViewById(R.id.login)).setOnClickListener(this);
        ((TextView) findViewById(R.id.signup)).setOnClickListener(this);
        ((TextView) findViewById(R.id.forgot)).setOnClickListener(this);
        cin.setOnFocusChangeListener(this);
        pin.setOnFocusChangeListener(this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Attendre s il vous plait ...");
    }
    @Override
    public void onClick(View v)
    {
        Intent intent;
        switch (v.getId()) {
            case R.id.login: login();
                break;

            case R.id.goback:finish();
            break;

            case R.id.forgot:intent = new Intent(this, ForgotPinActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.zoom_in,R.anim.zoom_out);
                break;

            case R.id.signup:intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.translate_in_right,R.anim.translate_out_left);
                break;
        }
    }

    private void login()
    {

        String cinadd = cin.getText().toString().trim();
        String pinadd = pin.getText().toString().trim();
        if(cinadd.isEmpty()){
            cin.setError("Champs obligatoire");
        }
        else if(pinadd.isEmpty()){
            pin.setError("Champs obligatoire");
        }
        else {
            progressDialog.show();
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
            Retrofit Rf = new Retrofit.Builder().baseUrl(((Global) this.getApplication()).getBaseUrl()).addConverterFactory(GsonConverterFactory.create(gson)).build();
            ApiHandler api = (ApiHandler) Rf.create(ApiHandler.class);
            Call<client> find = api.selectUser(cinadd, pinadd);
            find.enqueue(new Callback<client>() {
                @Override
                public void onResponse(Response<client> response, Retrofit retrofit) {
                    if (response.body() != null) {

                        SharedPreferences sharedPreferences = LoginActivity.this.getSharedPreferences("clientfidelys", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("nom", response.body().getNom());
                        editor.putString("prenom", response.body().getPrenom());
                        editor.putString("cin", response.body().getCin());
                        SimpleDateFormat sdft = new SimpleDateFormat("yyyy-MM-dd");
                        editor.putString("date", sdft.format(response.body().getDatenaiss()));
                        editor.putString("id", response.body().getId());
                        editor.putString("sexe", response.body().getSexe());
                        editor.putString("nationalite", response.body().getNationalite());
                        editor.putString("pays", response.body().getPays());
                        editor.putString("teld", response.body().getTeldomicile());
                        editor.putString("email", response.body().getEmail());
                        editor.putString("telm", response.body().getTelmobile());
                        editor.putString("adr", response.body().getAdressedomicile());
                        System.out.println("adresse" + response.body().getAdressedomicile());
                        editor.putString("cp", response.body().getCodepostal());
                        editor.putString("ville", response.body().getVille());
                        editor.putString("LOGIN", response.body().getId());
                        editor.apply();
                        Intent intent = new Intent(LoginActivity.this, MouvementActivity.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.translate_in_right, R.anim.translate_out_left);
                    }
                    else {
                        Toast.makeText(LoginActivity.this, " Verifez votre Id/Pin ", Toast.LENGTH_LONG).show();
                    }
                    progressDialog.dismiss();
                }

                @Override
                public void onFailure(Throwable t) {
                    Toast.makeText(LoginActivity.this, "Erreur" + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
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