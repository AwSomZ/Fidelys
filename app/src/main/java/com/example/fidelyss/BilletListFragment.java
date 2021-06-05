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
import android.widget.Button;
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


public class BilletListFragment extends Fragment implements View.OnClickListener {


    private SharedPreferences sharedPreferences;
    private RecyclerView recyclerViewUser3;
    private RecyclerView.LayoutManager layoutManager3;
    TextView error;
    Button acheter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v= inflater.inflate(R.layout.fragment_billet_list, container, false);
        Animation fade = AnimationUtils.loadAnimation(getActivity().getApplicationContext(),R.anim.fade_in);
        acheter = (Button) v.findViewById(R.id.acheter);
        error = (TextView) v.findViewById(R.id.error1);
        error.setAnimation(fade);
        acheter.setOnClickListener(this);
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
                else {
                    error.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }});
            return v;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this.getContext(), AchatBilletActivity.class);

        startActivity(intent);

        getActivity().overridePendingTransition(R.anim.zoom_in,R.anim.zoom_out);
    }
}