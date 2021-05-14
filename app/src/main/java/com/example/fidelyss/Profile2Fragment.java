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
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class Profile2Fragment extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {


    private EditText adr;
    private EditText teld;
    private EditText telm;
    private EditText telp;
    private EditText ville;
    private EditText cp;
    private EditText nationalite;
    private EditText fonction;
    private EditText societe;
    private EditText fax;
    private EditText cin;
    private String paysadd;
    private SharedPreferences sharedPreferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      View v= inflater.inflate(R.layout.fragment_profile2, container, false);
        adr = (EditText) v.findViewById(R.id.adresse);
        teld = (EditText) v.findViewById(R.id.teldomicile);
        telm = (EditText) v.findViewById(R.id.telmobile);
        telp = (EditText) v.findViewById(R.id.telpro);
        ville = (EditText) v.findViewById(R.id.ville);
        cp = (EditText) v.findViewById(R.id.codepostal);
        nationalite = (EditText) v.findViewById(R.id.nationality);
        fonction = (EditText) v.findViewById(R.id.fonction);
        societe = (EditText) v.findViewById(R.id.societe);
        fax = (EditText) v.findViewById(R.id.fax);
        cin = (EditText) v.findViewById(R.id.cin);
        Spinner pays = (Spinner) v.findViewById(R.id.pays);
        sharedPreferences = this.getActivity().getSharedPreferences("clientfidelys", Context.MODE_PRIVATE);
        String cinadd = sharedPreferences.getString("cin", "");
        String adradd= sharedPreferences.getString("adr", "");
        String fonctionadd = sharedPreferences.getString("fonction", "");
        String societeadd = sharedPreferences.getString("societe", "");
        String faxadd = sharedPreferences.getString("fax", "");
        String paysadd = sharedPreferences.getString("pays", "");
        String nationaliteadd = sharedPreferences.getString("nationalite", "");
        String teldadd = sharedPreferences.getString("teld", "");
        String telmadd = sharedPreferences.getString("telm", "");
        String telpadd = sharedPreferences.getString("telp", "");
        String villeadd = sharedPreferences.getString("ville", "");
        String cpadd = sharedPreferences.getString("cp", "");
        System.out.println("adresse "+adradd);
        cin.setText(cinadd);
        adr.setText(adradd);
        fonction.setText(fonctionadd);
        societe.setText(societeadd);
        fax.setText(faxadd);
        nationalite.setText(nationaliteadd);
        teld.setText(teldadd);
        telm.setText(telmadd);
        telp.setText(telpadd);
        ville.setText(villeadd);
        cp.setText(cpadd);
        pays.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.country_arrays, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pays.setAdapter(adapter);
        pays.setSelection(adapter.getPosition(paysadd));
        ((Button) v.findViewById(R.id.maj)).setOnClickListener(this);
      return v;
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        paysadd = parent.getItemAtPosition(position).toString().trim();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View v) {
        update();

    }
public void update(){
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

    if (cinadd.isEmpty()) {
        cin.setError("Please enter your cin");
    } else if (nationaliteadd.isEmpty()) {
        nationalite.setError("Please enter your nationality");
    } else if (adradd.isEmpty()) {
        adr.setError("Please enter your adress");
    }  else if (villeadd.isEmpty()) {
        ville.setError("Please enter your ville");
    } else if (cpadd.isEmpty()) {
        cp.setError("Please enter your zip code");
    }

    Retrofit Rf = new Retrofit.Builder().baseUrl("http://192.168.1.27:80/").addConverterFactory(GsonConverterFactory.create()).build();
    ApiHandler api = (ApiHandler)Rf.create(ApiHandler.class);
    Call<client> editUser = api.updateInf2(sharedPreferences.getString("id",""),cinadd,adradd,teldadd,telmadd,telpadd,villeadd,cpadd,nationaliteadd,fonctionadd,paysadd,societeadd,faxadd);
    editUser.enqueue(new Callback<client>() {
        public void onResponse(Response<client> response, Retrofit retrofit) {
            Toast.makeText(getActivity(), "Client updated", Toast.LENGTH_LONG).show();
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("cin",cinadd);
            editor.putString("adr",adradd);
            editor.putString("teld",teldadd);
            editor.putString("telm",telmadd);
            editor.putString("telp",telpadd);
            editor.putString("ville",villeadd);
            editor.putString("cp",cpadd);
            editor.putString("nationalite",nationaliteadd);
            editor.putString("fonction",fonctionadd);
            editor.putString("pays",paysadd);
            editor.putString("societe",societeadd);
            editor.putString("fax",faxadd);
            editor.commit();
        }

        public void onFailure(Throwable t) {
            Toast.makeText(getActivity(), "failed " + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
        }
    });
}


}