package com.example.fidelyss;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class RestToUpgradeFragment extends Fragment {
    TextView solde;
    SharedPreferences sharedPreferences;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView= (ViewGroup)inflater.inflate(R.layout.resttoupgradefragment,container,false);
        solde= (TextView) rootView.findViewById(R.id.solde);
        sharedPreferences = getActivity().getSharedPreferences("clientfidelys", Context.MODE_PRIVATE);
        String plafond = sharedPreferences.getString("plafond", "") ;
        String cumule = sharedPreferences.getString("soldecummule", "") ;

        int rest = Integer.valueOf(plafond)-Integer.valueOf(cumule);
        solde.setText(rest+" Miles Statut");

        final Handler refreshHandler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                String plafond = sharedPreferences.getString("plafond", "") ;
                String cumule = sharedPreferences.getString("soldecummule", "") ;

                int rest = Integer.valueOf(plafond)-Integer.valueOf(cumule);
                solde.setText(rest+" Miles Statut");
                refreshHandler.postDelayed(this, 10);
            }
        };
        refreshHandler.postDelayed(runnable, 10);
        return rootView;
    }


}
