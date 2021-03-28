package com.example.fidelyss;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity2 extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemSelectedListener {
    public EditText cin;
    public EditText adr;
    public EditText teld;
    public EditText telp;
    public EditText telm;
    public EditText ville;
    public EditText pays;
    public EditText cp;
    public EditText nationalite;
    public EditText fonction;
    public EditText societe;
    public EditText fax;
    public EditText langue;
    public RadioButton radioButton;
    private RadioGroup r1;
    private RadioGroup radioGroup;
    private RadioGroup r2;
    private RadioGroup r3;
    private RadioGroup r4;
    private RadioGroup r5;
    private RadioGroup r6;
    String email = "";
    String nom = "";
    String prenom = "";
    String sexe = "";
    String date="";
    String paysadd;
    String f=null;
    String td=null;
    String tp=null;
    String fa=null;
    String s=null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        adr = (EditText) findViewById(R.id.adresse);
        teld = (EditText) findViewById(R.id.teldomicile);
        telm = (EditText) findViewById(R.id.telmobile);
        telp = (EditText) findViewById(R.id.telpro);
        ville = (EditText) findViewById(R.id.ville);
        //pays = (EditText) findViewById(R.id.pays);
        cp = (EditText) findViewById(R.id.codepostal);
        nationalite = (EditText) findViewById(R.id.nationality);
        fonction = (EditText) findViewById(R.id.fonction);
        societe = (EditText) findViewById(R.id.societe);
        fax = (EditText) findViewById(R.id.fax);
        cin = (EditText) findViewById(R.id.cin);
        radioGroup = (RadioGroup) findViewById(R.id.langue);


        Spinner pays = (Spinner) findViewById(R.id.pays);
        pays.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.country_arrays, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pays.setAdapter(adapter);
        pays.setOnItemSelectedListener(this);


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
                date = intent.getStringExtra("date");

            }
        }
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
        etape2();

    }

    private void etape2() {


        String cinadd = cin.getText().toString().trim();
        String adradd = adr.getText().toString().trim();
        String teldadd = teld.getText().toString().trim();
        String telmadd = telm.getText().toString().trim();
        String telpadd = telp.getText().toString().trim();
        String villeadd = ville.getText().toString().trim();
        String cpadd = cp.getText().toString().trim();
        String nationaliteadd = nationalite.getText().toString().trim();
        String fonctionadd = fonction.getText().toString().trim();
        String societeadd = societe.getText().toString().trim();
        String faxadd = fax.getText().toString().trim();

        //langue
        int selectedId = radioGroup.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(selectedId);
        String langueadd = radioButton.getText().toString().trim();



          if (cinadd.isEmpty()) {
            cin.setError("Please enter your cin");
          } else if (nationaliteadd.isEmpty()) {
              nationalite.setError("Please enter your nationality");
          } else if (adradd.isEmpty()) {
            adr.setError("Please enter your adress");
          } else if (paysadd.isEmpty()) {
              pays.setError("Please enter your pays");
          } else if (villeadd.isEmpty()) {
              ville.setError("Please enter your ville");
          } else if (cpadd.isEmpty()) {
              cp.setError("Please enter your zip code");
          } else if (langueadd.isEmpty()) {
              langue.setError("Please enter your langue");
          } else {

            Intent intent = new Intent(this, RegisterActivity3.class);
            intent.putExtra("email", email);
            intent.putExtra("nom", nom);
            intent.putExtra("prenom", prenom);
            intent.putExtra("sexe", sexe);
            intent.putExtra("date", date);
            intent.putExtra("nationaliteadd", nationaliteadd);
            intent.putExtra("adradd", adradd);
            intent.putExtra("villeadd", villeadd);
            intent.putExtra("cpadd", cpadd);
            intent.putExtra("paysadd", paysadd);
            intent.putExtra("teldadd", teldadd);
            intent.putExtra("telmadd", telmadd);
            intent.putExtra("societeadd", societeadd);
            intent.putExtra("fonctionadd", fonctionadd);
            intent.putExtra("telpadd", telpadd);
            intent.putExtra("faxadd", faxadd);
            intent.putExtra("langueadd", langueadd);
            intent.putExtra("cinadd", cinadd);
            startActivity(intent);

        }
    }
}