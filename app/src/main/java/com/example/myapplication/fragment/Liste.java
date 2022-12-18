package com.example.myapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapteur.CustomRecyclerViewAdapter;
import com.example.myapplication.R;
import com.example.myapplication.model.Recherche;
import com.example.myapplication.model.RetrofitApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Liste extends Fragment {
    private RecyclerView recyclerView;

    public Liste() {

        // Required empty public constructor
    }
    public static Liste newInstance() {
        return new Liste();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fetchRechercheItem();
    }

    private void fetchRechercheItem() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:8080/Search/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitApi retrofitApi = retrofit.create(RetrofitApi.class);
        Call<List<Recherche>> call = retrofitApi.getRecherche();
        call.enqueue(new Callback<List<Recherche>>() {
            @Override
            public void onResponse(Call<List<Recherche>> call, Response<List<Recherche>> response) {
                List<Recherche> recherches = response.body();
                recyclerView.setAdapter(new CustomRecyclerViewAdapter(recherches,getContext()));
            }

            @Override
            public void onFailure(Call<List<Recherche>> call, Throwable t) {
                Toast.makeText(requireContext(), "Erreur durant la récupération de la liste" + t, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_liste, container, false);
        recyclerView = view.findViewById(R.id.recycleview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        return view;
    }
}