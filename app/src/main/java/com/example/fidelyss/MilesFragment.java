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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;


public class MilesFragment extends Fragment implements View.OnClickListener,AdapterView.OnItemSelectedListener {
SharedPreferences sharedPreferences;
String quantite;
String milestype;
RadioGroup radioGroup;
RadioButton radioButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {

        View v = inflater.inflate(R.layout.fragment_miles, container, false);
        radioGroup = (RadioGroup) v.findViewById(R.id.milestype);
        Spinner quantite = (Spinner) v.findViewById(R.id.quantite);
        quantite.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(container.getContext(),
                R.array.quantite, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        quantite.setAdapter(adapter);
        quantite.setOnItemSelectedListener(this);



        ((Button) v.findViewById(R.id.acheter)).setOnClickListener(this);


        return v;


    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        quantite = parent.getItemAtPosition(position).toString().trim();


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
           Retrofit Rf = new Retrofit.Builder().baseUrl("http://192.168.1.26:80/").addConverterFactory(GsonConverterFactory.create()).build();
           ApiHandler api = (ApiHandler) Rf.create(ApiHandler.class);
           sharedPreferences = this.getActivity().getSharedPreferences("clientfidelys", Context.MODE_PRIVATE);
           String id = sharedPreferences.getString("id", "");
           Call<String> buy = api.buyMiles(id,quantite,milestype);
           buy.enqueue(new Callback<String>() {
               public void onResponse(Response<String> response, Retrofit retrofit) {
                   Toast.makeText(MilesFragment.this.getActivity(), "Achat avec success ", Toast.LENGTH_LONG).show();

               }

               public void onFailure(Throwable t) {
                   Toast.makeText(MilesFragment.this.getActivity(), "failed" + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
               }
           });


       }
}