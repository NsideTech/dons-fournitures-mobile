package com.example.myapplication.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.model.Recherche;
import com.example.myapplication.model.RechercheInterface;

import java.util.ArrayList;
import java.util.List;


public class Detail extends Fragment {
    private TextView txtName;
    private TextView txtPhone;
    private TextView txtEmail;
    private TextView txtPays;
    private TextView txtDescription;
    private ImageView imageView;
    private Button btnContacter;
    private List<Recherche> rechercheItems = new ArrayList<>();
    private int itemposition;

    public Detail() {}

    public static Detail newInstance() {

        return new Detail();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rechercheItems = ((RechercheInterface) requireContext()).getInformation();
        itemposition = ((RechercheInterface) requireContext()).getInt();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        txtName = view.findViewById(R.id.txtName);
        txtPhone  = view.findViewById(R.id.txtPhone);
        txtEmail  = view.findViewById(R.id.txtEmail);
        txtPays  = view.findViewById(R.id.txtPays);
        txtDescription  = view.findViewById(R.id.edtDescriptionRecherche);
        imageView  = view.findViewById(R.id.imageview);
        btnContacter = view.findViewById(R.id.btnContacter);

        txtName.setText(rechercheItems.get(itemposition).getNom());
        txtPhone.setText(rechercheItems.get(itemposition).getPhone());
        txtEmail.setText(rechercheItems.get(itemposition).getEmail());
        txtDescription.setText(rechercheItems.get(itemposition).getDescription());
        txtPays.setText(rechercheItems.get(itemposition).getPays());
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.books));


        return view;
    }
}