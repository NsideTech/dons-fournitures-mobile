package com.example.myapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.model.Recherche;
import com.example.myapplication.model.RetrofitApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Accueil extends Fragment {
    private Button btnContribuer;
    private TextView txtAcceuil;

    

    public interface FragmentAlistener { }

    public Accueil() {
    }


    public static Accueil newInstance() {
        return new Accueil();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        getNbSearch();
    }

    private void getNbSearch() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:8080/Search/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitApi retrofitApi = retrofit.create(RetrofitApi.class);
        Call<List<Recherche>> call = retrofitApi.getRecherche();
        call.enqueue(new Callback<List<Recherche>>() {
            @Override
            public void onResponse(Call<List<Recherche>> call, Response<List<Recherche>> response) {
                if (!response.isSuccessful()) {
                    return;
                }
                List<Recherche> recherches = response.body();

                txtAcceuil.setText("Aujourd'hui, nous avons " + recherches.size() + " demandes de fournitures.");
            }

            @Override
            public void onFailure(Call<List<Recherche>> call, Throwable t) {
                Toast.makeText(requireContext(), "Erreur durant la récupération de la liste" + t, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_accueil, container, false);

        btnContribuer = view.findViewById(R.id.btnContribuer);
        txtAcceuil = view.findViewById(R.id.txtAcceuilAppli);


        btnContribuer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RechercheFragment rechercheFragment = new RechercheFragment();
                getFragmentManager().beginTransaction().replace(R.id.container_fragment, rechercheFragment).commit();
            }
        });
        return view;
    }

}