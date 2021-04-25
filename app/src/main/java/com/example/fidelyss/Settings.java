package com.example.fidelyss;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class Settings extends Fragment implements View.OnClickListener {
TextView personal;
TextView general;
TextView logout;
TextView about;
TextView email;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v= inflater.inflate(R.layout.fragment_settings, container, false);
       personal= (TextView) v.findViewById(R.id.personal);
       general= (TextView) v.findViewById(R.id.general);
       logout= (TextView) v.findViewById(R.id.Logout);
       email= (TextView) v.findViewById(R.id.contact);
       about= (TextView) v.findViewById(R.id.about);

        Animation aniFade = AnimationUtils.loadAnimation(getActivity().getApplicationContext(),R.anim.translate_in_left);
        personal.startAnimation(aniFade);
        general.startAnimation(aniFade);
        email.startAnimation(aniFade);
        logout.startAnimation(aniFade);
        about.startAnimation(aniFade);
       personal.setOnClickListener(this);
       general.setOnClickListener(this);
       logout.setOnClickListener(this);

    return v;
    }

    @Override
    public void onClick(View v) {
        Fragment unFrgment = null;
        switch (v.getId()) {
            case R.id.personal: unFrgment = new ProfileFragment();
                break;
                case R.id.general:unFrgment = new Profile2Fragment();
                break;

    }

        String URL = "http://192.168.1.16:80/";
        Bundle bundle = new Bundle();
        bundle.putString("url", URL);
        unFrgment.setArguments(bundle);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentplaceholder, unFrgment).commit();


    }
}