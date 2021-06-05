package com.example.fidelyss;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;


public class Profile3Fragment extends Fragment implements View.OnClickListener {


    private RadioGroup r1;
    private RadioGroup r2;
    private RadioGroup r3;
    private RadioGroup r4;
    private RadioGroup r5;
    private RadioGroup r6;
    private SharedPreferences sharedPreferences;
    private RadioButton radioButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View v=inflater.inflate(R.layout.fragment_profile3, container, false);
        r1 = (RadioGroup) v.findViewById(R.id.classh);
        r2 = (RadioGroup) v.findViewById(R.id.habitude);
        r3 = (RadioGroup) v.findViewById(R.id.payment);
        r4 = (RadioGroup) v.findViewById(R.id.type);
        r5= (RadioGroup) v.findViewById(R.id.pref);
        r6= (RadioGroup) v.findViewById(R.id.assistance);
        sharedPreferences = this.getActivity().getSharedPreferences("clientfidelys", Context.MODE_PRIVATE);


        String classhadd = sharedPreferences.getString("classh", "");
        switch (classhadd)
            {
                case "Business" :  r1.check(R.id.business);
                    break;
                case "Economique" :  r1.check(R.id.economique);
                    break;
            }
        String habitudeadd= sharedPreferences.getString("habitude", "");
        switch (habitudeadd)
            {
                case "Seul" :  r2.check(R.id.seul);
                    break;
                case "Accompagné" :  r2.check(R.id.accompagne);
                    break;
            }
        String paiementadd = sharedPreferences.getString("paiement", "");
        switch (paiementadd)
            {
                case "Carte de crédit" :  r3.check(R.id.cc);
                    break;
                case "Cash" :  r3.check(R.id.cash);
                    break;
                case "Chèque" :  r3.check(R.id.cheque);
                    break;
            }
        String typeadd = sharedPreferences.getString("type", "");
        switch (typeadd)
            {
                case "individuelle" :  r4.check(R.id.ind);
                    break;
                case "familiale" :  r4.check(R.id.fam);
                    break;
            }
        String prefadd = sharedPreferences.getString("pref", "");
        switch (prefadd)
            {
                case "Côté hublot" :  r5.check(R.id.hub);
                    break;
                case "Côté couloir" :  r5.check(R.id.couloir);
                    break;
                case "Indifférent" :  r5.check(R.id.indif);
                    break;
            }
        String assistanceadd = sharedPreferences.getString("assistance", "");
        switch (typeadd)
            {
                case "Oui" :  r6.check(R.id.oui);
                    break;
                case "Non" :  r6.check(R.id.non);
                    break;
            }

        ((Button)v.findViewById(R.id.maj)).setOnClickListener(this);
      return v;
    }

    @Override
    public void onClick(View v) {
update3();
    }
    public void update3()
    {
        //assistance
        int selectedId = r6.getCheckedRadioButtonId();
        radioButton = (RadioButton) getActivity().findViewById(selectedId);
        String assistanceaddd = radioButton.getText().toString().trim();

        //type
        selectedId = r4.getCheckedRadioButtonId();
        radioButton = (RadioButton) getActivity().findViewById(selectedId);
        String typeaddd = radioButton.getText().toString().trim();

        //classe habituelle
        selectedId = r1.getCheckedRadioButtonId();
        radioButton = (RadioButton) getActivity().findViewById(selectedId);
        String classehaddd = radioButton.getText().toString().trim();

        //payment method
        selectedId = r3.getCheckedRadioButtonId();
        radioButton = (RadioButton) getActivity().findViewById(selectedId);
        String paiementaddd = radioButton.getText().toString().trim();

        //preference
        selectedId = r5.getCheckedRadioButtonId();
        radioButton = (RadioButton) getActivity().findViewById(selectedId);
        String prefaddd = radioButton.getText().toString().trim();

        //habitude
        selectedId = r2.getCheckedRadioButtonId();
        radioButton = (RadioButton) getActivity().findViewById(selectedId);
        String habaddd = radioButton.getText().toString().trim();


        Retrofit Rf = new Retrofit.Builder().baseUrl(((Global) this.getActivity().getApplication()).getBaseUrl()).addConverterFactory(GsonConverterFactory.create()).build();
        ApiHandler api = (ApiHandler)Rf.create(ApiHandler.class);
        Call<client> editUser = api.updateInf3(sharedPreferences.getString("id",""),classehaddd,typeaddd,assistanceaddd,paiementaddd,prefaddd,habaddd);
        editUser.enqueue(new Callback<client>() {
            public void onResponse(Response<client> response, Retrofit retrofit)
                {
                    Toast.makeText(getActivity(), "Client updated", Toast.LENGTH_LONG).show();
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("classeh", classehaddd);
                    editor.putString("habitude", habaddd);
                    editor.putString("pref", prefaddd);
                    editor.putString("paiement", paiementaddd);
                    editor.putString("type", typeaddd);
                    editor.putString("assistance", assistanceaddd);
                    editor.commit();
                }
                public void onFailure(Throwable t) {
                Toast.makeText(getActivity(), "failed " + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}