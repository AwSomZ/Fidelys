package com.example.fidelyss;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;


public class EspaceReclamationsFragment extends Fragment implements View.OnClickListener {

    TextView error;
    TextView error1;
    TextView enc;
    TextView enr;
    ImageView ajouter;
    private RecyclerView recyclerViewUser;
    private RecyclerView.LayoutManager layoutManager;
    private SharedPreferences sharedPreferences;
    private RecyclerView recyclerViewUser2;
    private RecyclerView.LayoutManager layoutManager2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

      View v= inflater.inflate(R.layout.fragment_espace_reclamations, container, false);
      error = (TextView) v.findViewById(R.id.error);
      error1 = (TextView) v.findViewById(R.id.error1);
      enc = (TextView) v.findViewById(R.id.enc);
      enr = (TextView) v.findViewById(R.id.enr);
      TextView bare = (TextView) v.findViewById(R.id.bare);
      ajouter =(ImageView) v.findViewById(R.id.ajouter);
        Animation left = AnimationUtils.loadAnimation(getActivity().getApplicationContext(),R.anim.translate_in_left);
        Animation right = AnimationUtils.loadAnimation(getActivity().getApplicationContext(),R.anim.translate_in_right);
        Animation zoom = AnimationUtils.loadAnimation(getActivity().getApplicationContext(),R.anim.zoom_in);
        Animation fade = AnimationUtils.loadAnimation(getActivity().getApplicationContext(),R.anim.fade_in);
        error.setAnimation(fade);
        ajouter.setAnimation(right);
        enc.setAnimation(left);
        enr.setAnimation(left);
        error1.setAnimation(fade);
        bare.setAnimation(left);
      sharedPreferences = this.getActivity().getSharedPreferences("clientfidelys", Context.MODE_PRIVATE);
      String id = sharedPreferences.getString("id", "");
      ajouter.setOnClickListener(this);
      Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
      Retrofit Rf = new Retrofit.Builder().baseUrl(((Global) this.getActivity().getApplication()).getBaseUrl()).addConverterFactory(GsonConverterFactory.create(gson)).build();
      ApiHandler api = (ApiHandler) Rf.create(ApiHandler.class);
      Call<List<reclamation>> getreclamationencours = api.getReclamationEncours(id);
      getreclamationencours.enqueue(new Callback<List<reclamation>>(){

            @Override
            public void onResponse(Response<List<reclamation>> response, Retrofit retrofit) {
                if(response.body()!= null) {
                    List<reclamation> listReclamationEncours = new ArrayList<reclamation>();
                    listReclamationEncours = (List<reclamation>) response.body();
                    recyclerViewUser = v.findViewById(R.id.encours);
                    layoutManager = new LinearLayoutManager(getActivity());
                    recyclerViewUser.setLayoutManager(layoutManager);
                    recyclerViewUser.setHasFixedSize(true);
                    ReclamationEncoursAdapter adapter = new ReclamationEncoursAdapter(getActivity(), listReclamationEncours);
                    recyclerViewUser.setAdapter(adapter);
                }
                else {error.setVisibility(View.VISIBLE);error.setAnimation(fade);}
            }

            @Override
            public void onFailure(Throwable t) {

            }});
        Call<List<reclamation>> getreclamationresolu = api.getReclamationResolu(id);
        getreclamationresolu.enqueue(new Callback<List<reclamation>>(){

            @Override
            public void onResponse(Response<List<reclamation>> response, Retrofit retrofit) {
                if(response.body()!= null) {
                    List<reclamation> listReclamationResolu = new ArrayList<reclamation>();
                    listReclamationResolu = (List<reclamation>) response.body();
                    recyclerViewUser2 = v.findViewById(R.id.resolu);
                    layoutManager2 = new LinearLayoutManager(getActivity());
                    recyclerViewUser2.setLayoutManager(layoutManager2);
                    recyclerViewUser2.setHasFixedSize(true);
                    ReclamationResoluAdapter adapter2 = new ReclamationResoluAdapter(getActivity(), listReclamationResolu);
                    recyclerViewUser2.setAdapter(adapter2);
                }
                else {error1.setVisibility(View.VISIBLE);error1.setAnimation(fade);}
            }

            @Override
            public void onFailure(Throwable t) {

            }});
            return v;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this.getContext(), CreationReclamationActivity.class);

        startActivity(intent);

        getActivity().overridePendingTransition(R.anim.zoom_in,R.anim.zoom_out);
    }
}