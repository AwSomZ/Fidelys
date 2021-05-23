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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;


public class BilletListFragment extends Fragment {


    private SharedPreferences sharedPreferences;
    private RecyclerView recyclerViewUser3;
    private RecyclerView.LayoutManager layoutManager3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v= inflater.inflate(R.layout.fragment_billet_list, container, false);
        sharedPreferences = this.getActivity().getSharedPreferences("clientfidelys", Context.MODE_PRIVATE);
        String id = sharedPreferences.getString("id", "");
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        Retrofit Rf = new Retrofit.Builder().baseUrl(((Global) this.getActivity().getApplication()).getBaseUrl()).addConverterFactory(GsonConverterFactory.create(gson)).build();
        ApiHandler api = (ApiHandler) Rf.create(ApiHandler.class);
        Call<List<billet>> getBillet = api.getBillet(id);
        getBillet.enqueue(new Callback<List<billet>>(){
            @Override
            public void onResponse(Response<List<billet>> response, Retrofit retrofit) {
                if(response.body()!= null) {
                    List<billet> listBillet = new ArrayList<billet>();
                    listBillet = (List<billet>) response.body();
                    recyclerViewUser3 = v.findViewById(R.id.billet);
                    layoutManager3 = new LinearLayoutManager(getActivity());
                    recyclerViewUser3.setLayoutManager(layoutManager3);
                    recyclerViewUser3.setHasFixedSize(true);
                    BilletAdapter adapter = new BilletAdapter(getActivity(), listBillet);
                    recyclerViewUser3.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }});
            return v;
    }
}