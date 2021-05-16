package com.example.fidelyss;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;


public class ProfilePageFragment extends Fragment implements View.OnClickListener {
    ConstraintLayout infogen;
    ConstraintLayout adresseid;
    ConstraintLayout contactemail;
    ScrollView sc;
TextView np;
TextView datenaiss;
TextView sexe;
TextView cin;
TextView pays;
TextView adresse;
TextView ville;
TextView nationalite;
TextView cp;
TextView email;
private SharedPreferences sharedPreferences;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_profile_page, container, false);
        sc = (ScrollView) v.findViewById(R.id.scrollView2);
        infogen = (ConstraintLayout) v.findViewById(R.id.infogen);
        adresseid= (ConstraintLayout) v.findViewById(R.id.adresseid);
        contactemail = (ConstraintLayout) v.findViewById(R.id.contactemail);
        np= (TextView) v.findViewById(R.id.np);
        cp= (TextView) v.findViewById(R.id.cp);
        datenaiss= (TextView) v.findViewById(R.id.datenaiss);
        sexe= (TextView) v.findViewById(R.id.sexe);
        cin= (TextView) v.findViewById(R.id.cin);
        pays= (TextView) v.findViewById(R.id.pays);
        adresse= (TextView) v.findViewById(R.id.adresse);
        ville= (TextView) v.findViewById(R.id.ville);
        nationalite= (TextView) v.findViewById(R.id.nationality);
        email= (TextView) v.findViewById(R.id.email);
        Animation aniFade = AnimationUtils.loadAnimation(getActivity().getApplicationContext(),R.anim.translate_in_left);
        Animation Fade = AnimationUtils.loadAnimation(getActivity().getApplicationContext(),R.anim.fade_in);
        sc.startAnimation(Fade);
        infogen.startAnimation(aniFade);
        adresseid.startAnimation(aniFade);
        contactemail.startAnimation(aniFade);
        sharedPreferences = this.getActivity().getSharedPreferences("clientfidelys", Context.MODE_PRIVATE);
        String cinadd = sharedPreferences.getString("cin", "");
        String cpadd = sharedPreferences.getString("cp", "");
        String dateadd = sharedPreferences.getString("date", "");
        String sexeadd = sharedPreferences.getString("sexe", "");
        String paysadd = sharedPreferences.getString("pays", "");
        String adresseadd = sharedPreferences.getString("adr", "");
        String villeadd = sharedPreferences.getString("ville", "");
        String nationaliteadd = sharedPreferences.getString("nationalite", "");
        String emailadd = sharedPreferences.getString("email", "");
        String npadd = sharedPreferences.getString("nom", "")+" "+sharedPreferences.getString("prenom", "");
        np.setText(npadd);
        datenaiss.setText(dateadd);
        sexe.setText(sexeadd);
        cin.setText(cinadd);
        pays.setText(paysadd);
        adresse.setText(adresseadd);
        ville.setText(villeadd);
        cp.setText(cpadd);
        nationalite.setText(nationaliteadd);
        email.setText(emailadd);
        infogen.setOnClickListener(this);
        contactemail.setOnClickListener(this);
        adresseid.setOnClickListener(this);
        return v;

    }

    @Override
    public void onClick(View v) {
        Fragment unFrgment = null;
        switch (v.getId()) {
            case R.id.infogen:
                unFrgment = new ProfileFragment();
                break;
            case R.id.contactemail:
                unFrgment = new EmailUpdateFragment();
                break;
            case R.id.adresseid:
                unFrgment = new Profile2Fragment();
                break;
        }
        String URL = "http://192.168.1.20:80/";
        Bundle bundle = new Bundle();
        bundle.putString("url", URL);
        unFrgment.setArguments(bundle);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentplaceholder, unFrgment).commit();
    }
}