package com.example.fidelyss;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Date;
import java.util.Calendar;
import java.util.Map;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class AchatBilletActivity extends AppCompatActivity  implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {

    Spinner de;
    String deString;
    String versString;
    String priceString="Miles Prime";
    String dateallerString="";
    int solde;
    int p;
    String dateretourString="";
    String classeString;
    String enfantString;
    String bebeString;
    String jeuneString;
    String adulteString;
    String typeString;
    Spinner vers;
    Spinner classe;
    Spinner adulte;
    Spinner enfant;
    Spinner jeune;
    Spinner bebe;
    Button acheter;
    TextView datealler;
    TextView dateretour;
    TextView price;
    RadioGroup type;
    RadioButton radiobutton;
    RadioButton aller;

    RadioButton retour;
    String client;
    private DatePickerDialog.OnDateSetListener DateAllerSetListener;
    private DatePickerDialog.OnDateSetListener DateRetourSetListener;
    private SharedPreferences sharedPreferences;
    Map<String,Integer> prices;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achat_billet);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*0.98),(int)(height*0.74));

        versString="Abidjan";
        deString="Abidjan";
        prices=((Global) this.getApplication()).getMileprice();
        price = (TextView) findViewById(R.id.price) ;
        de = (Spinner) findViewById(R.id.de);
        classe = (Spinner) findViewById(R.id.classe);
        datealler = (TextView)findViewById(R.id.datealler);
        dateretour = (TextView) findViewById(R.id.dateretour);
        aller = (RadioButton)findViewById(R.id.aller);
        type = (RadioGroup) findViewById(R.id.type);
        retour = (RadioButton) findViewById(R.id.retour);
        vers = (Spinner) findViewById(R.id.vers);
        jeune = (Spinner) findViewById(R.id.jeune);
        enfant = (Spinner) findViewById(R.id.enfant);
        bebe = (Spinner) findViewById(R.id.bebe);
        adulte = (Spinner) findViewById(R.id.adulte);
        acheter = (Button) findViewById(R.id.acheter) ;
        sharedPreferences = this.getSharedPreferences("clientfidelys", Context.MODE_PRIVATE);
        client = sharedPreferences.getString("id", "");
        solde = Integer.valueOf(sharedPreferences.getString("prime", ""));
        de.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                deString= parent.getItemAtPosition(position).toString().trim();
                if (versString.equals("Tunis")||versString.equals("Sfax")||versString.equals("Enfidha")) {
                    priceString=String.valueOf(prices.get(deString))+" "+priceString;
                    p=prices.get(deString);
                    price.setText(priceString);
                    priceString="Miles Prime";
                }
                else if ((deString.equals("Tunis")) || (deString.equals("Sfax")) || (deString.equals("Enfidha")) )
                {
                    priceString=String.valueOf(prices.get(versString))+" "+priceString;
                    p=prices.get(versString);
                    price.setText(priceString);
                    priceString="Miles Prime";
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        vers.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                versString= parent.getItemAtPosition(position).toString().trim();
                if ((deString.equals("Tunis")) || (deString.equals("Sfax")) || (deString.equals("Enfidha")) ) {
                    priceString=String.valueOf(prices.get(versString))+" "+priceString;
                    p=prices.get(versString);
                    price.setText(priceString);
                    priceString="Miles Prime";
                }
                else if (versString.equals("Tunis")||versString.equals("Sfax")||versString.equals("Enfidha"))
                {
                    priceString=String.valueOf(prices.get(deString))+" "+priceString;
                    p=prices.get(deString);
                    price.setText(priceString);
                    priceString="Miles Prime";

                }
                else{p=0;}
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        enfant.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                enfantString= parent.getItemAtPosition(position).toString().trim();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        adulte.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                adulteString= parent.getItemAtPosition(position).toString().trim();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        jeune.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                jeuneString= parent.getItemAtPosition(position).toString().trim();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        bebe.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                bebeString= parent.getItemAtPosition(position).toString().trim();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        classe.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                classeString= parent.getItemAtPosition(position).toString().trim();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        type.setOnCheckedChangeListener(this);
        acheter.setOnClickListener(this);
        datealler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog;
                dialog = new DatePickerDialog(AchatBilletActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, DateAllerSetListener, year, month+1, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);

                dialog.show();
            }
        });
        DateAllerSetListener= new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day){
                String date = year + "-" + month + "-" + day;
                datealler.setText(date);
                dateallerString=date;

            }
        };

        dateretour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog;
                dialog = new DatePickerDialog(AchatBilletActivity.this , android.R.style.Theme_Holo_Light_Dialog_MinWidth, DateRetourSetListener, year, month+1, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                dialog.show();
            }
        });
        DateRetourSetListener= new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day){
                String date = year + "-" + month + "-" + day;
                dateretour.setText(date);
                dateretourString=date;




            }
        };
    }
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedid) {
        switch (checkedid)
        {
            case  R.id.aller :dateretour.setVisibility(View.GONE);break;
            case R.id.retour : dateretour.setVisibility(View.VISIBLE); break;
        }

    }





    @Override
    public void onClick(View view) {
        int selectedId = type.getCheckedRadioButtonId();


        radiobutton = (RadioButton) this.findViewById(selectedId);
        typeString=radiobutton.getText().toString().trim();
        Retrofit Rf = new Retrofit.Builder().baseUrl(((Global) this.getApplication()).getBaseUrl()).addConverterFactory(GsonConverterFactory.create()).build();
        ApiHandler api = (ApiHandler) Rf.create(ApiHandler.class);
        if (deString.equals(versString))
        {
            Toast.makeText(AchatBilletActivity.this, "la destination doit etre differente du depart", Toast.LENGTH_LONG).show();
        }
        else if (dateallerString.isEmpty())
        {
          datealler.setError("La date aller ne doit pas etre vide");
        }
        else {
            if (p > solde)
            {
                Toast.makeText(AchatBilletActivity.this, "Solde Insuffisant", Toast.LENGTH_LONG).show();
            }
            else if (retour.isChecked()&&dateretourString.isEmpty())
            {
                dateretour.setError("La date retour ne doit pas etre vide");
            }
            else if (retour.isChecked()&&java.sql.Date.valueOf(dateallerString).compareTo(Date.valueOf(dateretourString))>0)
            {
                Toast.makeText(AchatBilletActivity.this, "La date de retour doit etre apres la date d aller", Toast.LENGTH_LONG).show();
            }

            else{
                Call<billet> buytikcet = api.buyTicket(client, deString, versString, typeString, dateallerString, dateretourString, classeString, adulteString, jeuneString, enfantString, bebeString,p);
                buytikcet.enqueue(new retrofit.Callback<billet>() {
                                      @Override
                                      public void onResponse(Response<billet> response, Retrofit retrofit) {
                                          solde=solde-p;
                                          SharedPreferences.Editor editor = sharedPreferences.edit();
                                          editor.putString("solde",String.valueOf(solde));
                                          editor.commit();
                                          Toast.makeText(AchatBilletActivity.this, "Achat validé "+p, Toast.LENGTH_LONG).show();
                                      }

                                      @Override
                                      public void onFailure(Throwable t) {
                                          Toast.makeText(AchatBilletActivity.this, "Erreur " + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                                      }
                                  }
                );
            }
        }
    }
}