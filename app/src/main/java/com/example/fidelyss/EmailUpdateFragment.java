package com.example.fidelyss;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;


public class EmailUpdateFragment extends Fragment implements View.OnClickListener, View.OnFocusChangeListener {
    EditText email;
    String emailadd;
    private SharedPreferences sharedPreferences;
    private ProgressDialog progressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

       View v= inflater.inflate(R.layout.fragment_email_update, container, false);
       email= (EditText) v.findViewById(R.id.Email);
       email.setOnFocusChangeListener(this);
       sharedPreferences = this.getActivity().getSharedPreferences("clientfidelys", Context.MODE_PRIVATE);
       emailadd = sharedPreferences.getString("email", "");
        String changed = sharedPreferences.getString("changed", "");
        if (changed.equals("false")){
            Intent intent = new Intent(getActivity(), ChangePinActivity.class);
            startActivity(intent);
            getActivity().overridePendingTransition(R.anim.zoom_in, R.anim.zoom_out);
        }
       email.setText(emailadd);
       ((Button) v.findViewById(R.id.maj)).setOnClickListener(this);
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Veuillez patienter ...");
       return v;
    }

    @Override
    public void onClick(View view) {
        progressDialog.show();
        Retrofit Rf = new Retrofit.Builder().baseUrl(((Global) this.getActivity().getApplication()).getBaseUrl()).addConverterFactory(GsonConverterFactory.create()).build();
        ApiHandler api = (ApiHandler)Rf.create(ApiHandler.class);
        Call<client> editUser = api.updateEmail(sharedPreferences.getString("id",""),emailadd,email.getText().toString().trim());
        editUser.enqueue(new Callback<client>() {
            @Override
            public void onResponse(Response<client> response, Retrofit retrofit) {
                progressDialog.dismiss();
                Toast.makeText(getActivity(), "Vérifiez votre email", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getActivity(), "Erreur "+t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
}

    @Override
    public void onFocusChange(View view, boolean b) {
        if(!b){
            InputMethodManager inputMethodManager =(InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }
}