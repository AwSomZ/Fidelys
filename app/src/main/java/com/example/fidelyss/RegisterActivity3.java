package com.example.fidelyss;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

public class RegisterActivity3 extends AppCompatActivity implements View.OnClickListener,GoogleApiClient.ConnectionCallbacks{
     String cinadd;
     String adradd;
     String teldadd;
     String telpadd;
     String telmadd;
     String villeadd;
     String paysadd;
     String cpadd;
     String nationaliteadd;
     String fonctionadd;
     String societeadd;
     String faxadd;
     String langueadd;
    public RadioButton radioButton;
    private RadioGroup r1;
    public Date date;
    private RadioGroup r2;
    private RadioGroup r3;
    private RadioGroup r4;
    private RadioGroup r5;
    private RadioGroup r6;
    private CheckBox checkBox;
    String email = "";
    String nom = "";
    String prenom = "";
    String sexe = "";
    GoogleApiClient googleApiClient;
    String Key ="6Ld2YnQaAAAAAKjcJIcpKYDBofusqkXq1CYmdu1O";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register3);

        r1 = (RadioGroup) findViewById(R.id.classh);
        r2 = (RadioGroup) findViewById(R.id.habitude);
        r3 = (RadioGroup) findViewById(R.id.payment);
        r4 = (RadioGroup) findViewById(R.id.type);
        r5= (RadioGroup) findViewById(R.id.pref);
        r6= (RadioGroup) findViewById(R.id.assistance);
        checkBox =(CheckBox) findViewById(R.id.tos);
        ((Button)findViewById(R.id.add)).setOnClickListener(this);

        Intent intent = getIntent();
        if (intent != null){



            if (intent.hasExtra("email")){
                email = intent.getStringExtra("email");
            }
            if (intent.hasExtra("nom")){
                nom = intent.getStringExtra("nom");
            }
            if (intent.hasExtra("prenom")){
                prenom = intent.getStringExtra("prenom");
            }
            if (intent.hasExtra("sexe")){
                sexe = intent.getStringExtra("sexe");
            }
            if (intent.hasExtra("date")){
                date=Date.valueOf(intent.getStringExtra("date"));

            }
            if (intent.hasExtra("nationaliteadd")){
                nationaliteadd=intent.getStringExtra("nationaliteadd");

            }
            if (intent.hasExtra("cinadd")){
                cinadd=intent.getStringExtra("cinadd");

            }
            if (intent.hasExtra("villeadd")){
               villeadd=intent.getStringExtra("villeadd");

            }
            if (intent.hasExtra("adradd")){
                adradd=intent.getStringExtra("adradd");

            }
            if (intent.hasExtra("cpadd")){
                cpadd=intent.getStringExtra("cpadd");

            }
            if (intent.hasExtra("paysadd")){
                paysadd=intent.getStringExtra("paysadd");

            }
            if (intent.hasExtra("langueadd")){
                langueadd=intent.getStringExtra("langueadd");

            }
            if (intent.hasExtra("faxadd")){
                faxadd=intent.getStringExtra("faxadd");

            }
            if (intent.hasExtra("societeadd")){
                societeadd=intent.getStringExtra("societeadd");

            }
            if (intent.hasExtra("fonctionadd")){
                fonctionadd=intent.getStringExtra("fonctionadd");

            }
            if (intent.hasExtra("telpadd")){
                telpadd=intent.getStringExtra("telpadd");

            }
            if (intent.hasExtra("telmadd")){
                telmadd=intent.getStringExtra("telmadd");

            }
            if (intent.hasExtra("teldadd")){
                teldadd=intent.getStringExtra("teldadd");

            }


        }
   googleApiClient = new GoogleApiClient.Builder(this)
           .addApi(SafetyNet.API)
           .addConnectionCallbacks(RegisterActivity3.this)
           .build();
        googleApiClient.connect();
    }
    @Override
    public void onClick(View v) {
        if (checkBox.isChecked() == false) {
            checkBox.setError("You have To agree");
            Toast.makeText(RegisterActivity3.this, "You have To agree ", Toast.LENGTH_LONG).show();
        } else {
            SafetyNet.SafetyNetApi.verifyWithRecaptcha(googleApiClient, Key)
                    .setResultCallback(new ResultCallback<SafetyNetApi.RecaptchaTokenResult>() {
                        @Override
                        public void onResult(@NonNull SafetyNetApi.RecaptchaTokenResult recaptchaTokenResult) {
                            Status status = recaptchaTokenResult.getStatus();
                            if ((status != null) && status.isSuccess()) {
                                ajouter();
                            }
                        }

                    });
        }

    }

    private void ajouter() {

            //assistance
            int selectedId = r6.getCheckedRadioButtonId();
            radioButton = (RadioButton) findViewById(selectedId);
            String assistanceadd = radioButton.getText().toString().trim();

            //type
            selectedId = r4.getCheckedRadioButtonId();
            radioButton = (RadioButton) findViewById(selectedId);
            String typeadd = radioButton.getText().toString().trim();

            //classe habituelle
            selectedId = r1.getCheckedRadioButtonId();
            radioButton = (RadioButton) findViewById(selectedId);
            String classehadd = radioButton.getText().toString().trim();

            //payment method
            selectedId = r3.getCheckedRadioButtonId();
            radioButton = (RadioButton) findViewById(selectedId);
            String paiementadd = radioButton.getText().toString().trim();

            //preference
            selectedId = r5.getCheckedRadioButtonId();
            radioButton = (RadioButton) findViewById(selectedId);
            String prefadd = radioButton.getText().toString().trim();

            //habitude
            selectedId = r2.getCheckedRadioButtonId();
            radioButton = (RadioButton) findViewById(selectedId);
            String habadd = radioButton.getText().toString().trim();

            Retrofit Rf = new Retrofit.Builder().baseUrl("http://192.168.1.26:80/").addConverterFactory(GsonConverterFactory.create()).build();
            ApiHandler api = (ApiHandler) Rf.create(ApiHandler.class);
            Call<user> addUser = api.insertUser(cinadd, sexe, nom, prenom, date, email, nationaliteadd, adradd, villeadd, cpadd, paysadd, teldadd, telmadd, societeadd, fonctionadd, telpadd, faxadd, langueadd, prefadd, paiementadd, habadd, classehadd, assistanceadd, typeadd);
            addUser.enqueue(new Callback<user>() {
                public void onResponse(Response<user> response, Retrofit retrofit) {
                    Toast.makeText(RegisterActivity3.this, "user successfully registred ", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(RegisterActivity3.this, Redirection.class);
                    startActivity(intent);
                }

                public void onFailure(Throwable t) {
                    Toast.makeText(RegisterActivity3.this, "failed" + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                }
            });

        }


    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }
}

