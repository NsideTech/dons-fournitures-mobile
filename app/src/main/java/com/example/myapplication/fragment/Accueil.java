package com.example.myapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.example.myapplication.R;


public class Accueil extends Fragment {
    private Button buttonContribuer;
    private EditText txtFourniture;
    public Accueil() {

        // Required empty public constructor
    }
    public static Accueil newInstance() {
        return new Accueil();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_accueil, container, false);
        buttonContribuer = view.findViewById(R.id.btnContribuer);
        txtFourniture = view.findViewById(R.id.txtFourniture);

        return view;
    }
}