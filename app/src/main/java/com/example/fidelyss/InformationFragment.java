package com.example.fidelyss;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class InformationFragment extends Fragment {

    SharedPreferences sharedPreferences;
    TextView np;
    TextView id;
    TextView sexe;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView= (ViewGroup)inflater.inflate(R.layout.informationfragment,container,false);
        np= (TextView) rootView.findViewById(R.id.np);
        sexe= (TextView) rootView.findViewById(R.id.sexe);
        id= (TextView) rootView.findViewById(R.id.identifiant);
        sharedPreferences = this.getActivity().getSharedPreferences("clientfidelys", Context.MODE_PRIVATE);
        String npp = sharedPreferences.getString("nom", "") + " " + sharedPreferences.getString("prenom", "");
        String sx = sharedPreferences.getString("sexe", "");
        String idd = sharedPreferences.getString("id", "");
        np.setText(npp);
        sexe.setText(sx);
        id.setText(idd);

        return rootView;

    }
}
