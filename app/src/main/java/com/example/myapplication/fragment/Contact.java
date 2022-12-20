package com.example.myapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.example.myapplication.R;


public class Contact extends Fragment {
    private EditText txtNom;
    private EditText txtNumero;
    private EditText txtEmail;
    private EditText txtMessage;
    private Button btnSoumettre;

    public Contact() {

        // Required empty public constructor
    }

    public static Contact newInstance() {
        return new Contact();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        txtNom = view.findViewById(R.id.editTextNomContact);
        txtNumero = view.findViewById(R.id.editTextNumeroContact);
        txtEmail = view.findViewById(R.id.editTextEmailContact);
        txtMessage = view.findViewById(R.id.editTextMessageContact);
        btnSoumettre = view.findViewById(R.id.btnSoumettreContact);
        return view;
    }
}