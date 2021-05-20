package com.example.fidelyss;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class AchatBilletFragment extends Fragment implements AdapterView.OnItemClickListener, RadioGroup.OnCheckedChangeListener {

Spinner de;
String deString;
String versString;
Spinner vers;
TextView datealler;
TextView dateretour;
RadioGroup type;
RadioButton aller;
RadioButton retour;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_achat_billet, container, false);
        de = (Spinner) v.findViewById(R.id.de);
        datealler = (TextView) v.findViewById(R.id.datealler);
        dateretour = (TextView) v.findViewById(R.id.dateretour);
        aller = (RadioButton) v.findViewById(R.id.aller);
        type = (RadioGroup) v.findViewById(R.id.type);
        retour = (RadioButton) v.findViewById(R.id.retour);
        vers = (Spinner) v.findViewById(R.id.vers);
        de.setOnItemClickListener(this);
        vers.setOnItemClickListener(this);
        type.setOnCheckedChangeListener(this);

        return v;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
        switch (v.getId())
        {

            case R.id.de:
                deString= parent.getItemAtPosition(position).toString().trim();
                break;
            case R.id.vers:
                versString= parent.getItemAtPosition(position).toString().trim();
                break;
        }

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedid) {
        switch (checkedid)
        {
          case  R.id.aller :dateretour.setVisibility(View.GONE);break;
           case R.id.retour : dateretour.setVisibility(View.VISIBLE); break;
        }

    }
}