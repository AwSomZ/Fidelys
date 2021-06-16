package com.example.fidelyss;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
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
import retrofit.Response;
import retrofit.Retrofit;


public class MilesFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener, CompoundButton.OnCheckedChangeListener, RadioGroup.OnCheckedChangeListener, View.OnFocusChangeListener {
    SharedPreferences sharedPreferences;
    String quantite="1000";
    CheckBox gift;
    double coef=0.07;
    EditText to;
    String id;
    String solde;
    String client;
    RadioGroup radioGroup;
    TextView price;
    RadioButton radioButton;
    ProgressDialog progressDialog;
    private String milestype="prime";
    private TextView unit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_miles, container, false);
        radioGroup = (RadioGroup) v.findViewById(R.id.milestype);
        to = (EditText)  v.findViewById(R.id.to);
        price = (TextView) v.findViewById(R.id.price);
        unit= (TextView) v.findViewById(R.id.unit);
        gift = (CheckBox)  v.findViewById(R.id.show);
        to.setOnFocusChangeListener(this);
        Spinner quantitee = (Spinner) v.findViewById(R.id.quantite);
        quantitee.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(container.getContext(),
        R.array.quantite, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        quantitee.setAdapter(adapter);
        quantitee.setOnItemSelectedListener(this);
        radioGroup.setOnCheckedChangeListener(this);
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Veuillez patienter ...\"");
        int selectedId = radioGroup.getCheckedRadioButtonId();
        System.out.println(selectedId);
        sharedPreferences = this.getActivity().getSharedPreferences("clientfidelys", Context.MODE_PRIVATE);
        id = sharedPreferences.getString("id", "");
        solde = sharedPreferences.getString("milesprime", "");
        client = sharedPreferences.getString("id", "");
        gift.setOnCheckedChangeListener(this);
        if (gift.isChecked()) {
            to.setVisibility(View.VISIBLE);
        }
        else {
            to.setVisibility(View.GONE);
        }

        ((Button) v.findViewById(R.id.acheter)).setOnClickListener(this);
        Double prix = Integer.valueOf(quantite)*coef;
        DecimalFormat df = new DecimalFormat("###.###");
        price.setText(df.format(prix)+"DT");
        return v;
    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        quantite = parent.getItemAtPosition(position).toString().trim();
        Double prix = Integer.valueOf(quantite)*coef;
        DecimalFormat df = new DecimalFormat("###.###");
        price.setText(df.format(prix)+"DT");

    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
       @Override
    public void onClick(View v) {

           if (gift.isChecked())
           {
              if (to.getText().toString().trim().isEmpty())
                  {
                      to.setError("Vous devez saisir l'id du recepteur");
                  }
              else {
                      id= to.getText().toString().trim();
                      Retrofit Rf = new Retrofit.Builder().baseUrl(((Global) this.getActivity().getApplication()).getBaseUrl()).addConverterFactory(GsonConverterFactory.create()).build();
                      ApiHandler api = (ApiHandler) Rf.create(ApiHandler.class);
                      Call<String> buy = api.buyMiles(id,quantite,milestype,client);
                      progressDialog.show();
                      buy.enqueue(new retrofit.Callback<String>() {

                          public void onResponse(Response<String> response, Retrofit retrofit) {
                              if ((response.body()!=null)&&(response.body().trim().equals("error"))) {
                                  to.setError("Verifiez l id du recepteur");
                                  Toast.makeText(MilesFragment.this.getActivity(), "Client non trouvé ", Toast.LENGTH_LONG).show();
                              }
                              else {
                                  Toast.makeText(MilesFragment.this.getActivity(), "Achat avec success ", Toast.LENGTH_LONG).show();
                              }
                              progressDialog.dismiss();

                          }

                          public void onFailure(Throwable t) {
                              progressDialog.dismiss();
                              Toast.makeText(MilesFragment.this.getActivity(), "Erreur" + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                          }
                      });
              }

           }
           else {
               progressDialog.show();
               Retrofit Rf = new Retrofit.Builder().baseUrl(((Global) this.getActivity().getApplication()).getBaseUrl()).addConverterFactory(GsonConverterFactory.create()).build();
               ApiHandler api = (ApiHandler) Rf.create(ApiHandler.class);
               Call<String> buy = api.buyMiles(id, quantite, milestype, client);
               buy.enqueue(new retrofit.Callback<String>() {
                   public void onResponse(Response<String> response, Retrofit retrofit) {
                       Toast.makeText(MilesFragment.this.getActivity(), "Achat avec success ", Toast.LENGTH_LONG).show();
                       int nvsolde= Integer.valueOf(solde)+Integer.valueOf(quantite);
                       SharedPreferences.Editor editor = sharedPreferences.edit();
                       editor.putString("milesprime",String.valueOf(nvsolde));
                       editor.commit();
                       progressDialog.dismiss();

                   }

                   public void onFailure(Throwable t) {
                       Toast.makeText(MilesFragment.this.getActivity(), "Erreur" + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                       progressDialog.dismiss();
                   }
               });
           }
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

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i)
        {
            case R.id.prime:coef=0.07;
            milestype="prime";
            unit.setText("Prix Unitaire 0.07DT");
            break;
            case R.id.statut:coef=0.14;
            milestype="statut";
            unit.setText("Prix Unitaire 0.14DT");
            break;
        }
        Double prix = Integer.valueOf(quantite)*coef;
        DecimalFormat df = new DecimalFormat("###.###");
        price.setText(df.format(prix)+"DT");
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        if(!b){
            InputMethodManager inputMethodManager =(InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }
}