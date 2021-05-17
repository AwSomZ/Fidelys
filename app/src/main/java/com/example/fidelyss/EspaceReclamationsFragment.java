package com.example.fidelyss;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;


public class EspaceReclamationsFragment extends Fragment {

    private PagerAdapter pagerAdapter;
    private RecyclerView recyclerViewUser;
    private RecyclerView.LayoutManager layoutManager;
    private SharedPreferences sharedPreferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

      View v= inflater.inflate(R.layout.fragment_espace_reclamations, container, false);
        sharedPreferences = this.getActivity().getSharedPreferences("clientfidelys", Context.MODE_PRIVATE);
        String id = sharedPreferences.getString("id", "");
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        Retrofit Rf = new Retrofit.Builder().baseUrl("http://192.168.1.20:80/").addConverterFactory(GsonConverterFactory.create(gson)).build();
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
            }

            @Override
            public void onFailure(Throwable t) {

            }});
    return v;
    }
}