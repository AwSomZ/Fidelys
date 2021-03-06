package com.example.fidelyss;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
    public static final String TAG="RegisterActivity";
    public EditText email;
    public EditText nom;
    public EditText prenom;
    public EditText sexe;
    public RadioButton radioButton;
    private RadioGroup radioGroup;
    int i;
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = (EditText) findViewById(R.id.Email);
        nom = (EditText) findViewById(R.id.Nom);
        prenom = (EditText)findViewById(R.id.Prenom);
        radioGroup = (RadioGroup) findViewById(R.id.sexe);
        mDisplayDate = (TextView) findViewById(R.id.tvDate) ;

        ((Button)findViewById(R.id.button)).setOnClickListener(this);


        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog;
                dialog = new DatePickerDialog(RegisterActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, mDateSetListener, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener= new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day){
                month= month+1;
                Log.d(TAG, "onDateSet: yyyy-mm-dd "+ year +"-"+month+"-"+day);
                String date= year+"-"+month+"-"+day;
                mDisplayDate.setText(date);
            }
        };
    }


    @Override
    public void onClick(View v) {
        Intent intent;




        sendInfo();



    }

    private void sendInfo() {



        String emailadd = email.getText().toString().trim();
        String nomadd = nom.getText().toString().trim();
        String prenomadd = prenom.getText().toString().trim();
        String dateadd =  mDisplayDate.getText().toString().trim();
        int selectedId = radioGroup.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(selectedId);
        String sexeadd = radioButton.getText().toString().trim();

        if(emailadd.isEmpty()){
            email.setError("Veuillez taper votre Email");
        }else if(nomadd.isEmpty()){
            nom.setError("Veuillez taper votre Nom");
        }else if(prenomadd.isEmpty()){
            prenom.setError("Veuillez taper votre Prenom");
        }else if(sexeadd.isEmpty()){
            sexe.setError("Veuillez choisir votre sexe");
        }
        else{
            Intent intent = new Intent(this, RegisterActivity2.class);
            intent.putExtra("email", emailadd);
            intent.putExtra("nom", nomadd);
            intent.putExtra("prenom", prenomadd);
            intent.putExtra("sexe", sexeadd);
            intent.putExtra("date", dateadd);
            startActivity(intent);

        }


    }

}