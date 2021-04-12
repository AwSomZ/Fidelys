package com.example.fidelyss;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CarteFragment extends Fragment {
    TextView id;
    ImageView img;
    SharedPreferences sharedPreferences;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView= (ViewGroup)inflater.inflate(R.layout.cartefragment,container,false);
        id= (TextView) rootView.findViewById(R.id.identifiant);
        img = (ImageView) rootView.findViewById(R.id.card) ;
        sharedPreferences = this.getActivity().getSharedPreferences("clientfidelys", Context.MODE_PRIVATE);
        String idd = sharedPreferences.getString("id", "") ;
        String sold = sharedPreferences.getString("solde", "") ;
        int s = Integer.valueOf(sold);
        if (s <= 6000) {
            img.setImageResource(R.drawable.classic);
        } else if ((s <= 12000) && (s > 6000)) {
            img.setImageResource(R.drawable.silver);
        } else if (s > 12000) {
            img.setImageResource(R.drawable.gold);
        }
        id.setText(idd);
        return rootView;
    }


}
