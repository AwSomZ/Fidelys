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
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.sql.Date;
import java.util.Calendar;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;


public class ProfileFragment extends Fragment implements View.OnClickListener {
EditText nom;
EditText prenom;
TextView mDisplayDate;
String sexe;
SharedPreferences sharedPreferences;
private DatePickerDialog.OnDateSetListener mDateSetListener;
RadioGroup radioGroup;
RadioButton radioButton;
int s;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_profile, container, false);
        nom = (EditText) v.findViewById(R.id.Nom);
        prenom = (EditText) v.findViewById(R.id.Prenom);
        radioGroup = (RadioGroup) v.findViewById(R.id.sexe);
        mDisplayDate = (TextView) v.findViewById(R.id.tvDate) ;

        ((Button)v.findViewById(R.id.maj)).setOnClickListener(this);
        sharedPreferences = this.getActivity().getSharedPreferences("clientfidelys", Context.MODE_PRIVATE);
        String no = sharedPreferences.getString("nom", "");
        String preno= sharedPreferences.getString("prenom", "");
        String dated = sharedPreferences.getString("date", "");
        sexe = sharedPreferences.getString("sexe", "");
        switch (sexe)
        {
            case "M" :  radioGroup.check(R.id.m);
                break;
            case "MISS" :  radioGroup.check(R.id.miss);
                break;
            case "MRS":radioGroup.check(R.id.mrs);
                break;
        }

        nom.setText(no);
        prenom.setText(preno);
        mDisplayDate.setText(dated);

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog;
                dialog = new DatePickerDialog(getContext(), android.R.style.Theme_Holo_Light_Dialog_MinWidth, mDateSetListener, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                dialog.show();
            }
        });
        mDateSetListener= new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day){
                month= month+1;

                if (2021-year<2){
                    Toast.makeText(getActivity(), "you are too young ", Toast.LENGTH_LONG).show();

                    ((Button)v.findViewById(R.id.maj)).setEnabled(false);
                }
                else {((Button)v.findViewById(R.id.maj)).setEnabled(true);}

                String date = year + "-" + month + "-" + day;
                mDisplayDate.setText(date);



            }
        };
        return  v;
    }

    private void update() {


        String nomadd = nom.getText().toString().trim();
        String prenomadd = prenom.getText().toString().trim();
        String dateadd =  mDisplayDate.getText().toString().trim();
         int selectedId = radioGroup.getCheckedRadioButtonId();
        radioButton = (RadioButton) getActivity().findViewById(selectedId);
        String sexeadd = radioButton.getText().toString().trim();
        java.util.Date date= Date.valueOf(dateadd);

       if(nomadd.isEmpty()){
            nom.setError("Veuillez taper votre Nom");
        }else if(prenomadd.isEmpty()){
            prenom.setError("Veuillez taper votre Prenom");
        }else if(dateadd.isEmpty()){
           mDisplayDate.setError("Veuillez Saisir la date de naissance");
       }


        Retrofit Rf = new Retrofit.Builder().baseUrl("http://192.168.1.20:80/").addConverterFactory(GsonConverterFactory.create()).build();
        ApiHandler api = (ApiHandler)Rf.create(ApiHandler.class);
        Call<client> editUser = api.updateInf(sharedPreferences.getString("id",""),nomadd,prenomadd,sexeadd,dateadd);
        editUser.enqueue(new Callback<client>() {
            public void onResponse(Response<client> response, Retrofit retrofit) {
                Toast.makeText(getActivity(), "Client updated", Toast.LENGTH_LONG).show();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("nom",nomadd);
                editor.putString("prenom",prenomadd);
                editor.putString("sexe",sexeadd);
                editor.putString("date",dateadd);
                editor.commit();
            }

            public void onFailure(Throwable t) {
                Toast.makeText(getActivity(), "failed " + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });




    }

    @Override
    public void onClick(View v){
update();
    }
}