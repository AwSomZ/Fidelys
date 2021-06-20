package com.example.fidelyss;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
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

public class ChangePinActivity extends AppCompatActivity implements View.OnClickListener, View.OnFocusChangeListener {

    private EditText pin;
    private EditText cpin;
    private SharedPreferences sharedPreferences;
    private String id;
    private ProgressDialog progressDialog;
    private String pinadd;
    private String cpinadd;
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pin);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int) (width * 0.9), (int) (height * 0.38));
        sharedPreferences = this.getSharedPreferences("clientfidelys", Context.MODE_PRIVATE);
        id = sharedPreferences.getString("id", "");
        email = sharedPreferences.getString("email", "");
        pin = (EditText) findViewById(R.id.npin);
        cpin = (EditText) findViewById(R.id.cpin);
        pin.setOnFocusChangeListener(this);
        cpin.setOnFocusChangeListener(this);
        ((Button) findViewById(R.id.maj)).setOnClickListener(this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Veuillez patienter ...");
    }

    @Override
    public void onClick(View view) {
        pinadd = pin.getText().toString().trim();
        cpinadd= cpin.getText().toString().trim();
        if (pinadd.isEmpty()) {
            pin.setError("Vous Devez Saisir Un PIN");
        }
        else if (cpinadd.isEmpty()){
            cpin.setError("Vous Devez Confirmer Votre PIN");
        }
        else if (!(pinadd.equals(cpinadd))){
            Toast.makeText(ChangePinActivity.this, "Le PIN doit etre identique dans les deux champs", Toast.LENGTH_LONG).show();
        }
        else if (pinadd.length()<6){
            pin.setError("Le PIN doit etre de 9 chiffre");
            Toast.makeText(ChangePinActivity.this, "Le PIN doit etre de 9 chiffre", Toast.LENGTH_LONG).show();
        }
        else {
            progressDialog.show();
            Retrofit Rf = new Retrofit.Builder().baseUrl(((Global) this.getApplication()).getBaseUrl()).addConverterFactory(GsonConverterFactory.create()).build();
            ApiHandler api = (ApiHandler) Rf.create(ApiHandler.class);
            Call<String> change = api.changePin(id, pinadd, email);
            change.enqueue(new retrofit.Callback<String>() {
                @Override
                public void onResponse(Response<String> response, Retrofit retrofit) {
                    progressDialog.dismiss();
                    if (response.body().equals("sent")){
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("changed", "true");
                        Toast.makeText(ChangePinActivity.this, "Pin changé avec succés", Toast.LENGTH_LONG).show();
                        finish();
                    }
                    else{
                        Toast.makeText(ChangePinActivity.this, "on a pas pu changer le pin essayez une autre fois", Toast.LENGTH_LONG).show();
                        finish();
                    }

                }

                @Override
                public void onFailure(Throwable t) {
                    Toast.makeText(ChangePinActivity.this, "Erreur "+t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
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