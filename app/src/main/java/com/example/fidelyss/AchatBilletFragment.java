package com.example.fidelyss;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.Calendar;
import java.util.Map;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;


public class AchatBilletFragment extends Fragment implements RadioGroup.OnCheckedChangeListener, AdapterView.OnItemSelectedListener, View.OnClickListener {

Spinner de;
String deString;
String versString;
String priceString="Miles Prime";
String dateallerString;
int solde;
int p=0;
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_achat_billet, container, false);
        prices=((Global) this.getActivity().getApplication()).getMileprice();
        price = (TextView) v.findViewById(R.id.price) ;
        de = (Spinner) v.findViewById(R.id.de);
        datealler = (TextView) v.findViewById(R.id.datealler);
        dateretour = (TextView) v.findViewById(R.id.dateretour);
        aller = (RadioButton) v.findViewById(R.id.aller);
        type = (RadioGroup) v.findViewById(R.id.type);
        retour = (RadioButton) v.findViewById(R.id.retour);
        vers = (Spinner) v.findViewById(R.id.vers);
        jeune = (Spinner) v.findViewById(R.id.jeune);
        enfant = (Spinner) v.findViewById(R.id.enfant);
        bebe = (Spinner) v.findViewById(R.id.bebe);
        adulte = (Spinner) v.findViewById(R.id.adulte);
        acheter = (Button) v.findViewById(R.id.acheter) ;
        sharedPreferences = this.getActivity().getSharedPreferences("clientfidelys", Context.MODE_PRIVATE);
        client = sharedPreferences.getString("id", "");
        solde = Integer.valueOf(sharedPreferences.getString("prime", ""));
        de.setOnItemSelectedListener(this);
        vers.setOnItemSelectedListener(this);
        enfant.setOnItemSelectedListener(this);
        adulte.setOnItemSelectedListener(this);
        jeune.setOnItemSelectedListener(this);
        bebe.setOnItemSelectedListener(this);
        classe.setOnItemSelectedListener(this);
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
                dialog = new DatePickerDialog(getContext(), android.R.style.Theme_Holo_Light_Dialog_MinWidth, DateAllerSetListener, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.getDatePicker().setMinDate(System.currentTimeMillis());

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
                dialog = new DatePickerDialog(getContext(), android.R.style.Theme_Holo_Light_Dialog_MinWidth, DateRetourSetListener, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.getDatePicker().setMinDate(System.currentTimeMillis());
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

        return v;
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
    public void onItemSelected(AdapterView<?> parent, View v, int position, long l) {
        switch (v.getId())
        {

            case R.id.de:
                deString= parent.getItemAtPosition(position).toString().trim();
                if (versString.equals("Tunis")||versString.equals("Sfax")||versString.equals("Enfidha")) {
                    priceString=String.valueOf(prices.get(deString))+" "+priceString;
                    p=prices.get(deString);
                    price.setText(priceString);
                }
                else if (deString.equals("Tunis")||deString.equals("Sfax")||deString.equals("Enfidha"))
                {
                    priceString=String.valueOf(prices.get(versString))+" "+priceString;
                    p=prices.get(deString);
                    price.setText(priceString);
                }
                break;
            case R.id.vers:
                versString= parent.getItemAtPosition(position).toString().trim();
                if (deString.equals("Tunis")||deString.equals("Sfax")||deString.equals("Enfidha")) {
                    priceString=String.valueOf(prices.get(versString))+" "+priceString;
                    p=prices.get(deString);
                    price.setText(priceString);
                }
                else if (versString.equals("Tunis")||versString.equals("Sfax")||versString.equals("Enfidha"))
                {
                    priceString=String.valueOf(prices.get(deString))+" "+priceString;
                    p=prices.get(deString);
                    price.setText(priceString);

                }
                break;
            case R.id.jeune:
                jeuneString= parent.getItemAtPosition(position).toString().trim();
                break;
            case R.id.bebe:
                bebeString= parent.getItemAtPosition(position).toString().trim();
                break;
            case R.id.enfant:
                enfantString= parent.getItemAtPosition(position).toString().trim();
                break;
            case R.id.adulte:
                adulteString= parent.getItemAtPosition(position).toString().trim();
                break;
            case R.id.classe:
                classeString= parent.getItemAtPosition(position).toString().trim();
                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {
        int selectedId = type.getCheckedRadioButtonId();
        radiobutton = (RadioButton) getActivity().findViewById(selectedId);
        typeString=radiobutton.getText().toString().trim();
        Retrofit Rf = new Retrofit.Builder().baseUrl("http://192.168.1.20:80/").addConverterFactory(GsonConverterFactory.create()).build();
        ApiHandler api = (ApiHandler) Rf.create(ApiHandler.class);
        if (deString.equals(versString))
            {
                Toast.makeText(AchatBilletFragment.this.getActivity(), "la destination doit etre differente du depart", Toast.LENGTH_LONG).show();
            }
        else {
            if (p > solde)
                {
                    Toast.makeText(AchatBilletFragment.this.getActivity(), "Solde Insuffisant", Toast.LENGTH_LONG).show();
                }
                else{
                Call<billet> buytikcet = api.buyTicket(client, deString, versString, typeString, dateallerString, dateretourString, classeString, adulteString, jeuneString, enfantString, bebeString);
                buytikcet.enqueue(new retrofit.Callback<billet>() {
                                      @Override
                                      public void onResponse(Response<billet> response, Retrofit retrofit) {
                                          Toast.makeText(AchatBilletFragment.this.getActivity(), "Achat validé ", Toast.LENGTH_LONG).show();
                                      }

                                      @Override
                                      public void onFailure(Throwable t) {
                                          Toast.makeText(AchatBilletFragment.this.getActivity(), "Erreur " + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                                      }
                                  }
                );
            }
        }
            }
}