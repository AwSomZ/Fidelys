package com.example.fidelyss;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;


public class MouvementFragment extends Fragment {


    SharedPreferences sharedPreferences;
    TextView identifiant;
    TextView np;
    TextView solde;
    TextView error;
    ImageView img;
    private ViewPager pager;
    private PagerAdapter pagerAdapter;
    private RecyclerView recyclerViewUser;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_mouvement, container, false);
        Animation left = AnimationUtils.loadAnimation(getActivity().getApplicationContext(),R.anim.translate_in_left);
        Animation right = AnimationUtils.loadAnimation(getActivity().getApplicationContext(),R.anim.translate_in_right);
        Animation zoom = AnimationUtils.loadAnimation(getActivity().getApplicationContext(),R.anim.zoom_in);
        Animation fade = AnimationUtils.loadAnimation(getActivity().getApplicationContext(),R.anim.fade_in);
        List<Fragment> list= new ArrayList<>();
        list.add(new SoldeFragment());
        list.add(new SoldeStatutFragment());
        list.add(new RestToUpgradeFragment());
        list.add(new InformationFragment());
        list.add(new CarteFragment());
        pager = v.findViewById(R.id.view_pager);
        error = v.findViewById(R.id.error1);
        error.setAnimation(fade);
        Animation aniFade = AnimationUtils.loadAnimation(getActivity().getApplicationContext(),R.anim.translate_in_left);
        pager.setAnimation(aniFade);
        pagerAdapter= new SliderPageAdapter(getFragmentManager(),list);
        pager.setAdapter(pagerAdapter);
        TabLayout tabLayout = (TabLayout) v.findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(pager, true);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        Retrofit Rf = new Retrofit.Builder().baseUrl(((Global) this.getActivity().getApplication()).getBaseUrl()).addConverterFactory(GsonConverterFactory.create(gson)).build();
        ApiHandler api = (ApiHandler) Rf.create(ApiHandler.class);
        sharedPreferences = this.getContext().getSharedPreferences("clientfidelys", Context.MODE_PRIVATE);
        String id = sharedPreferences.getString("id", "");
        String sexe = sharedPreferences.getString("sexe", "");
        String npp = sharedPreferences.getString("nom", "") + " " + sharedPreferences.getString("prenom", "");

        Call<mouvement> find = api.getMvt(id);
        find.enqueue(new Callback<mouvement>() {
            public void onResponse(Response<mouvement> response, Retrofit retrofit) {
                if (response.body() != null) {
                    int s = response.body().getMilesstatut();
                    int p = response.body().getMilesprime();
                    int pl = response.body().getPlafond();
                    int sc = response.body().getSoldecummule();
                    String se= Integer.toString(s);
                    String plafond= Integer.toString(pl);
                    String soldecum= Integer.toString(sc);
                    String sp= Integer.toString(p);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                    editor.putString("dateniveau", df.format(response.body().getDate_niveau()));
                    editor.putString("dateexpiration", df.format(response.body().getDate_expiration()));
                    editor.putString("milesstatut",se);
                    editor.putString("statut",response.body().getStatut());
                    editor.putString("plafond",plafond);
                    editor.putString("soldecummule",soldecum);
                    editor.putString("milesprime",sp);
                    editor.apply();
                    // api call on response on failure
                    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
                    Retrofit Rf = new Retrofit.Builder().baseUrl(((Global) getActivity().getApplication()).getBaseUrl()).addConverterFactory(GsonConverterFactory.create(gson)).build();
                    ApiHandler api = (ApiHandler) Rf.create(ApiHandler.class);
                    Call<List<transaction>>tr = api.getTransaction(id);
                    tr.enqueue(new Callback<List<transaction>>(){
                        public void onResponse(Response<List<transaction>> response, Retrofit retrofit) {
                            List<transaction> listtransaction =new ArrayList<transaction>();
                            if(response.body()!= null) {
                                listtransaction= (List<transaction>)response.body();
                                recyclerViewUser = v.findViewById(R.id.rv1);
                                layoutManager = new LinearLayoutManager(getActivity());
                                recyclerViewUser.setLayoutManager(layoutManager);
                                recyclerViewUser.setHasFixedSize(true);
                                TransactionAdapter adapter=new TransactionAdapter(getActivity(),listtransaction);
                                recyclerViewUser.setAdapter(adapter);
                            }
                            else {error.setVisibility(View.VISIBLE);}


                        }
                        public void onFailure(Throwable t) {
                            Toast.makeText(MouvementFragment.this.getActivity(), "Erreur" + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
            public void onFailure(Throwable t) {
                Toast.makeText(MouvementFragment.this.getActivity(), "Erreur " + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
        return v;
    }
}


