package com.example.myapplication.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.model.RechercheInterface;


public class Accueil extends Fragment {
    private Button btnContribuer;
    private TextView txtAcceuil;
    private int count;



    public Accueil() {}


    public static Accueil newInstance() {
        return new Accueil();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        count = ((RechercheInterface) requireContext()).getIntCount();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_accueil, container, false);

        btnContribuer = view.findViewById(R.id.btnContribuer);
        //txtAcceuil = view.findViewById(R.id.txtAcceuilAppli);

        txtAcceuil.setText("Aujourd'hui, nous avons " + count + "demandes de fournitures.");

        btnContribuer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getContext(),Accueil.class);
                startActivity(i);
            }
        });
        return view;
    }
}