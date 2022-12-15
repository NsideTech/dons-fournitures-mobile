package com.example.myapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.example.myapplication.R;


public class Recherche extends Fragment {
    private EditText txtNom;
    private EditText txtNumero;
    private EditText txtEmail;
    private EditText txtMessage;
    private Button btnSoumettre;
    public Recherche() {

        // Required empty public constructor
    }
    public static Recherche newInstance() {
        return new Recherche();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recherche, container, false);
        txtNom = view.findViewById(R.id.editTextNomRecherche);
        txtNumero = view.findViewById(R.id.editTextPhoneRecherche);
        txtEmail = view.findViewById(R.id.editTextEmailRecherche);
        txtMessage = view.findViewById(R.id.editTextMessageRecherche);
        btnSoumettre = view.findViewById(R.id.btnSoumettreRecherche);
        return view;
    }
}