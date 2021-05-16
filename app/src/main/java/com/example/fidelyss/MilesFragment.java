package com.example.fidelyss;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.text.DecimalFormat;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;


public class MilesFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener, CompoundButton.OnCheckedChangeListener {
SharedPreferences sharedPreferences;
String quantite;
CheckBox gift;
EditText to;
String id;
RadioGroup radioGroup;
TextView price;
RadioButton radioButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {

        View v = inflater.inflate(R.layout.fragment_miles, container, false);
        radioGroup = (RadioGroup) v.findViewById(R.id.milestype);
        to = (EditText)  v.findViewById(R.id.to);
        price = (TextView) v.findViewById(R.id.price);
        gift = (CheckBox)  v.findViewById(R.id.show);
        Spinner quantite = (Spinner) v.findViewById(R.id.quantite);
        quantite.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(container.getContext(),
        R.array.quantite, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        quantite.setAdapter(adapter);
        quantite.setOnItemSelectedListener(this);
        sharedPreferences = this.getActivity().getSharedPreferences("clientfidelys", Context.MODE_PRIVATE);
        id = sharedPreferences.getString("id", "");
        gift.setOnCheckedChangeListener(this);
        if (gift.isChecked())
        {
            to.setVisibility(View.VISIBLE);
        }
        else
        {
            to.setVisibility(View.GONE);
        }



        ((Button) v.findViewById(R.id.acheter)).setOnClickListener(this);


        return v;


    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        quantite = parent.getItemAtPosition(position).toString().trim();
        Double prix = Integer.valueOf(quantite)*0.07;
        DecimalFormat df = new DecimalFormat("###.###");

        price.setText(df.format(prix)+"DT");



    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
       @Override
    public void onClick(View v)
       {
           int selectedId = radioGroup.getCheckedRadioButtonId();
           System.out.println(selectedId);
           radioButton = (RadioButton) this.getActivity().findViewById(selectedId);
          String milestype = radioButton.getText().toString().trim();
           if (gift.isChecked())
           {
              if (to.getText().toString().trim().isEmpty())
                  {
                      to.setError("Vous devez saisir l'id du recepteur");
                  }
              else
                  {
                      id= to.getText().toString().trim();
                  }

           }
           Retrofit Rf = new Retrofit.Builder().baseUrl("http://192.168.1.20:80/").addConverterFactory(GsonConverterFactory.create()).build();
           ApiHandler api = (ApiHandler) Rf.create(ApiHandler.class);

           Call<String> buy = api.buyMiles(id,quantite,milestype);
           buy.enqueue(new retrofit.Callback<String>() {

               public void onResponse(retrofit.Response<String> response, Retrofit retrofit) {
                   Toast.makeText(MilesFragment.this.getActivity(), "Achat avec success ", Toast.LENGTH_LONG).show();

               }

               public void onFailure(Throwable t) {
                   Toast.makeText(MilesFragment.this.getActivity(), "wuuj" + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
               }
           });


       }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (b)
        {
            to.setVisibility(View.VISIBLE);
        }
        else
        {
            to.setVisibility(View.GONE);
        }

    }
}