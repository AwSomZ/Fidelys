package com.example.fidelyss;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class CreationReclamationActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener, View.OnFocusChangeListener {
    Spinner titre;
    String titreadd;
    EditText description;
    Button creer;
    String client;
    String descriptionadd;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation_reclamation);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*0.97),(int)(height*0.465));

        titre= (Spinner) findViewById(R.id.titre);
        description= (EditText) findViewById(R.id.contenu);
        description.setOnFocusChangeListener(this);
        creer= (Button) findViewById(R.id.creer);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.reclamation, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        titre.setAdapter(adapter);
        titre.setOnItemSelectedListener(this);
        sharedPreferences = this.getSharedPreferences("clientfidelys", Context.MODE_PRIVATE);
        client = sharedPreferences.getString("id", "");
        creer.setOnClickListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        titreadd= parent.getItemAtPosition(position).toString().trim();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View v) {
        descriptionadd= description.getText().toString().trim();
        if (descriptionadd.isEmpty())
        {
            description.setError("Ajouter une description");
        }
        else {
            Retrofit Rf = new Retrofit.Builder().baseUrl(((Global) this.getApplication()).getBaseUrl()).addConverterFactory(GsonConverterFactory.create()).build();
            ApiHandler api = (ApiHandler) Rf.create(ApiHandler.class);

            Call<reclamation> buy = api.submitComplaint(client, titreadd, descriptionadd);
            buy.enqueue(new retrofit.Callback<reclamation>() {
                @Override
                public void onResponse(Response<reclamation> response, Retrofit retrofit) {
                    Toast.makeText(CreationReclamationActivity.this, "Reclamation Envoyé ", Toast.LENGTH_LONG).show();
                }

                @Override
                public void onFailure(Throwable t) {
                    Toast.makeText(CreationReclamationActivity.this, "Echec d'envoie " + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
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