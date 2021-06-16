package com.example.fidelyss;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.SafetyNet;
import com.google.android.gms.safetynet.SafetyNetApi;

import java.sql.Date;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class RegisterActivity2 extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener, View.OnFocusChangeListener, GoogleApiClient.ConnectionCallbacks {
    public EditText cin;
    public EditText adr;
    public EditText teld;
    public EditText telm;
    public EditText ville;
    public EditText pays;
    public EditText cp;
    public EditText nationalite;
    ProgressDialog progressDialog;
    GoogleApiClient googleApiClient;
    String Key ="6Ld2YnQaAAAAAKjcJIcpKYDBofusqkXq1CYmdu1O";
    String email = "";
    String nom = "";
    String prenom = "";
    String sexe = "";
    Date date;
    String paysadd;
    private ImageView goback;
    private CheckBox checkBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
        adr = (EditText) findViewById(R.id.adresse);
        teld = (EditText) findViewById(R.id.teldomicile);
        telm = (EditText) findViewById(R.id.telmobile);
        ville = (EditText) findViewById(R.id.ville);
        checkBox =(CheckBox) findViewById(R.id.tos);
        cp = (EditText) findViewById(R.id.codepostal);
        nationalite = (EditText) findViewById(R.id.nationality);
        cin = (EditText) findViewById(R.id.cin);
        adr.setOnFocusChangeListener(this);
        teld.setOnFocusChangeListener(this);
        telm.setOnFocusChangeListener(this);
        ville.setOnFocusChangeListener(this);
        cp.setOnFocusChangeListener(this);
        nationalite.setOnFocusChangeListener(this);
        cin.setOnFocusChangeListener(this);


        Spinner pays = (Spinner) findViewById(R.id.pays);
        goback= (ImageView) findViewById(R.id.goback);
        goback.setOnClickListener(this);
        pays.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.country_arrays, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pays.setAdapter(adapter);
        pays.setOnItemSelectedListener(this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Attendre s il vous plait ...");


        ((Button) findViewById(R.id.envoyer)).setOnClickListener(this);
        Intent intent = getIntent();
        if (intent != null) {


            if (intent.hasExtra("email")) {
                email = intent.getStringExtra("email");
            }
            if (intent.hasExtra("nom")) {
                nom = intent.getStringExtra("nom");
            }
            if (intent.hasExtra("prenom")) {
                prenom = intent.getStringExtra("prenom");
            }
            if (intent.hasExtra("sexe")) {
                sexe = intent.getStringExtra("sexe");
            }
            if (intent.hasExtra("date")) {
                date= Date.valueOf(intent.getStringExtra("date"));
            }
        }
        googleApiClient = new GoogleApiClient.Builder(this)
                .addApi(SafetyNet.API)
                .addConnectionCallbacks(RegisterActivity2.this)
                .build();
        googleApiClient.connect();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
         paysadd = parent.getItemAtPosition(position).toString().trim();


    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.goback:finish();
                break;
            case R.id.envoyer:
                if (checkBox.isChecked() == false) {
                    checkBox.setError("Vous devez accepter pour continuer");
                    Toast.makeText(RegisterActivity2.this, "Vous devez accepter pour continuer", Toast.LENGTH_LONG).show();
                }
                else {
                        SafetyNet.SafetyNetApi.verifyWithRecaptcha(googleApiClient, Key)
                        .setResultCallback(new ResultCallback<SafetyNetApi.RecaptchaTokenResult>() {
                            @Override
                            public void onResult(@NonNull SafetyNetApi.RecaptchaTokenResult recaptchaTokenResult) {
                                Status status = recaptchaTokenResult.getStatus();
                                if ((status != null) && status.isSuccess()) {
                                    etape2();
                                }
                            }

                        });
                }
                break;
        }
    }

    private void etape2() {


        String cinadd = cin.getText().toString().trim();
        String adradd = adr.getText().toString().trim();
        String teldadd = teld.getText().toString().trim();
        String telmadd = telm.getText().toString().trim();
        String villeadd = ville.getText().toString().trim();
        String cpadd = cp.getText().toString().trim();
        String nationaliteadd = nationalite.getText().toString().trim();
        if (cinadd.isEmpty()) {
            cin.setError("Saisir votre cin");
        }
        else if (nationaliteadd.isEmpty()) {
              nationalite.setError("Saisir votre nationalite");
        }
        else if (adradd.isEmpty()) {
            adr.setError("Saisir votre adresse");
        }
        else if (paysadd.isEmpty()) {
              pays.setError("Saisir votre pays");
        }
        else if (villeadd.isEmpty()) {
              ville.setError("Saisir votre ville");
        }
        else if (cpadd.isEmpty()) {
              cp.setError("Saisir votre code postal");
        }
        else if (paysadd.equals("Choisir votre pays")) {
              Toast.makeText(RegisterActivity2.this, "Vous devez choisir une pays", Toast.LENGTH_LONG).show();
        }
        else {
              progressDialog.show();
              Retrofit Rf = new Retrofit.Builder().baseUrl(((Global) this.getApplication()).getBaseUrl()).addConverterFactory(GsonConverterFactory.create()).build();
              ApiHandler api = (ApiHandler) Rf.create(ApiHandler.class);
              Call<user> addUser = api.insertUser(cinadd, sexe, nom, prenom, date, email, nationaliteadd, adradd, villeadd, cpadd, paysadd, teldadd, telmadd);
              addUser.enqueue(new Callback<user>() {
                  public void onResponse(Response<user> response, Retrofit retrofit) {
                      Toast.makeText(RegisterActivity2.this, "utilisateur inscrit avec succes", Toast.LENGTH_LONG).show();
                      Intent intent = new Intent(RegisterActivity2.this, Redirection.class);
                      intent.putExtra("user", cinadd);
                      startActivity(intent);
                      progressDialog.dismiss();
                      overridePendingTransition(R.anim.zoom_in,R.anim.zoom_out);
                  }

                  public void onFailure(Throwable t) {
                      Toast.makeText(RegisterActivity2.this, "erreur" + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
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

    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }
}