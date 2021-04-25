package com.example.fidelyss;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MouvementActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    Fragment unFrgment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mouvement);


        bottomNavigationView=(BottomNavigationView) findViewById(R.id.botton_navigation);
        bottomNavigationView.getMenu().getItem(0).setChecked(true);
        unFrgment = new MouvementFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentplaceholder, unFrgment).commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(naviglistener);
    }

    public BottomNavigationView.OnNavigationItemSelectedListener naviglistener=new BottomNavigationView.OnNavigationItemSelectedListener() {
        @SuppressLint("NonConstantResourceId")
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment unFrgment = null;
            switch (item.getItemId()) {
                case R.id.mouvement:
                    unFrgment = new MouvementFragment();
                    break;



                case R.id.achat:
                    unFrgment = new MilesFragment();
                    break;

                case R.id.conversion:
                    unFrgment = new MouvementFragment();
                    break;

                case R.id.profile:
                    unFrgment = new Settings();
                    break;



            }
            String URL = "http://192.168.1.16:80/";
            Bundle bundle = new Bundle();
            bundle.putString("url", URL);
            unFrgment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentplaceholder, unFrgment).commit();
            return true;
        }};


}