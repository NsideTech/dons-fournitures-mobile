package com.example.myapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.example.myapplication.R;


public class Don extends Fragment {
    private EditText txtNom;
    private EditText txtNumero;
    private EditText txtEmail;
    private EditText txtMessage;
    private Button btnSoumettre;
    public Don() {

        // Required empty public constructor
    }
    public static Don newInstance() {
        return new Don();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_don, container, false);
        txtNom = view.findViewById(R.id.editTextNomDon);
        txtNumero = view.findViewById(R.id.editTextPhoneDon);
        txtEmail = view.findViewById(R.id.editTextEmailDon);
        txtMessage = view.findViewById(R.id.editTextMessageDon);
        btnSoumettre = view.findViewById(R.id.btnSoumettreDon);
        return view;
    }
}