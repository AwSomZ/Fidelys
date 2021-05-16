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
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;


public class CreationReclamationFragment extends Fragment implements AdapterView.OnItemSelectedListener, View.OnClickListener {
Spinner titre;
String titreadd;
EditText description;
Button creer;
String client;
String descriptionadd;
    private SharedPreferences sharedPreferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_creation_reclamation, container, false);
        titre= (Spinner) v.findViewById(R.id.titre);
        description= (EditText) v.findViewById(R.id.contenu);
        creer= (Button) v.findViewById(R.id.creer);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(container.getContext(),
                R.array.reclamation, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        titre.setAdapter(adapter);
        titre.setOnItemSelectedListener(this);
        sharedPreferences = this.getActivity().getSharedPreferences("clientfidelys", Context.MODE_PRIVATE);
        client = sharedPreferences.getString("id", "");
        creer.setOnClickListener(this);
        return v;
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

        Retrofit Rf = new Retrofit.Builder().baseUrl("http://192.168.1.27:80/").addConverterFactory(GsonConverterFactory.create()).build();
        ApiHandler api = (ApiHandler) Rf.create(ApiHandler.class);

        Call<reclamation> buy = api.submitComplaint(client,titreadd,descriptionadd);
        buy.enqueue(new retrofit.Callback<reclamation>() {
            @Override
            public void onResponse(Response<reclamation> response, Retrofit retrofit) {
                Toast.makeText(CreationReclamationFragment.this.getActivity(), "Reclamation Envoyé ", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(CreationReclamationFragment.this.getActivity(), "Echec d'envoie ", Toast.LENGTH_LONG).show();
            }
        });


    }
}