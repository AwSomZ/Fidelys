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

public class VerifierCompte extends AppCompatActivity implements View.OnClickListener{
    EditText cin;
    String cinadd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verifier_compte);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int) (width * 0.9), (int) (height * 0.50));
        cin=(EditText) findViewById(R.id.cin);
        ((Button) findViewById(R.id.gotologin)).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        cinadd = cin.getText().toString().trim();
        if (cinadd.isEmpty()) {
            cin.setError("Vous Devez Saisir Votre CIN");
        }
        else {
            Retrofit Rf = new Retrofit.Builder().baseUrl(((Global) this.getApplication()).getBaseUrl()).addConverterFactory(GsonConverterFactory.create()).build();
            ApiHandler api = (ApiHandler) Rf.create(ApiHandler.class);

            Call<user> buy = api.check(cinadd);
            buy.enqueue(new retrofit.Callback<user>() {
                @Override
                public void onResponse(Response<user> response, Retrofit retrofit) {
                    if(response.body() != null ){
                        Intent intent = new Intent(VerifierCompte.this, Redirection.class);
                        intent.putExtra("user", cinadd);
                        startActivity(intent);
                        overridePendingTransition(R.anim.zoom_in,R.anim.zoom_out);
                }
                    else {
                        Toast.makeText(VerifierCompte.this, "Compte Non Trouvé" , Toast.LENGTH_LONG).show();
                    }

                }

                @Override
                public void onFailure(Throwable t) {
                    Toast.makeText(VerifierCompte.this, "error" + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();

                }

    });
        }
        }
    }
