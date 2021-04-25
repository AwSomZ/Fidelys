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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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

    ImageView img;
    private ViewPager pager;
    private PagerAdapter pagerAdapter;
    private RecyclerView recyclerViewUser;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_mouvement, container, false);

        List<Fragment> list= new ArrayList<>();
        list.add(new SoldeFragment());
        list.add(new InformationFragment());
        list.add(new CarteFragment());
        pager = v.findViewById(R.id.view_pager);
        Animation aniFade = AnimationUtils.loadAnimation(getActivity().getApplicationContext(),R.anim.translate_in_left);
        pager.setAnimation(aniFade);
        pagerAdapter= new SliderPageAdapter(getFragmentManager(),list);
        pager.setAdapter(pagerAdapter);




        Retrofit Rf = new Retrofit.Builder().baseUrl("http://192.168.1.16:80/").addConverterFactory(GsonConverterFactory.create()).build();
        ApiHandler api = (ApiHandler) Rf.create(ApiHandler.class);
        sharedPreferences = this.getActivity().getSharedPreferences("clientfidelys", Context.MODE_PRIVATE);
        String id = sharedPreferences.getString("id", "");
        String sexe = sharedPreferences.getString("sexe", "");
        String npp = sharedPreferences.getString("nom", "") + " " + sharedPreferences.getString("prenom", "");




        Call<mouvement> addUser = api.getMvt(id);
        addUser.enqueue(new Callback<mouvement>() {

            public void onResponse(Response<mouvement> response, Retrofit retrofit) {

                if (response.body() != null) {

                    int s = response.body().getMilesprime();

                    String se= Integer.toString(s);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    System.out.println(se);
                    editor.putString("solde",se);
                    editor.commit();




                    // api call on response on failure
                    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
                    Retrofit Rf = new Retrofit.Builder().baseUrl("http://192.168.1.16:80/").addConverterFactory(GsonConverterFactory.create(gson)).build();
                    ApiHandler api = (ApiHandler) Rf.create(ApiHandler.class);
                    Call<List<transaction>>addUser = api.getTransaction(id);
                    addUser.enqueue(new Callback<List<transaction>>(){

                        public void onResponse(Response<List<transaction>> response, Retrofit retrofit) {
                            List<transaction> listtransaction =new ArrayList<transaction>();
                            if(response.body()!= null)
                            {
                                listtransaction= (List<transaction>)response.body();
                                recyclerViewUser = v.findViewById(R.id.rv1);
                                layoutManager = new LinearLayoutManager(getActivity());
                                recyclerViewUser.setLayoutManager(layoutManager);
                                recyclerViewUser.setHasFixedSize(true);
                                TransactionAdapter adapter=new TransactionAdapter(getActivity(),listtransaction);
                                recyclerViewUser.setAdapter(adapter);
                            }


                        }
                        public void onFailure(Throwable t) {
                            Toast.makeText(MouvementFragment.this.getActivity(), "Pas de transaction" + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                                        }
                                    });




                }
            }

            public void onFailure(Throwable t) {
                Toast.makeText(MouvementFragment.this.getActivity(), "wuuj" + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
        return v;
    }
}


