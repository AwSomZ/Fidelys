package com.example.fidelyss;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MouvementActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    TextView identifiant;
    TextView np;
    TextView solde;
    TextView titre;
    ImageView img;
    TextView sold;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mouvement);
        identifiant = findViewById(R.id.identifiant);
        titre= findViewById(R.id.titre);
        np = findViewById(R.id.np);
        solde=findViewById(R.id.solde);
        sold = findViewById(R.id.sold);
        img=findViewById(R.id.img);
        Retrofit Rf = new Retrofit.Builder().baseUrl("http://192.168.1.14:80/").addConverterFactory(GsonConverterFactory.create()).build();
        ApiHandler api = (ApiHandler) Rf.create(ApiHandler.class);
        sharedPreferences = getSharedPreferences("clientfidelys", Context.MODE_PRIVATE);
        String id = sharedPreferences.getString("id","");
        String sexe = sharedPreferences.getString("sexe","");
        String npp= sharedPreferences.getString("nom","")+" "+sharedPreferences.getString("prenom","");

        identifiant.setText(id);
        np.setText(npp);
        titre.setText(sexe);
        Call<mouvement> addUser = api.getMvt(id);
        addUser.enqueue(new Callback<mouvement>() {

            public void onResponse(Response<mouvement> response, Retrofit retrofit){
                if(response.body() != null ){
                    int s= response.body().getSolde();
                    if (s<=6000)
                    {img.setImageResource(R.drawable.classic);}
                    else if ((s<=12000) && (s>6000))
                    {img.setImageResource(R.drawable.silver);}
                    else if (s >12000)
                    {img.setImageResource(R.drawable.gold);}
                    solde.setText(String.valueOf(s));
                    sold.setText(String.valueOf(s));
                    Toast.makeText(MouvementActivity.this, " ", Toast.LENGTH_LONG).show();
                }
            }

            public void onFailure(Throwable t) {
                Toast.makeText(MouvementActivity.this, "failed" + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}