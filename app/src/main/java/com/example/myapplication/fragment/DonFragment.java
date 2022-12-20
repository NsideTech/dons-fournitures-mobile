package com.example.myapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.model.Don;
import com.example.myapplication.model.Recherche;
import com.example.myapplication.model.RetrofitApi;
import com.example.myapplication.model.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class DonFragment extends Fragment {
    private EditText txtNom;
    private EditText txtNumero;
    private EditText txtEmail;
    private EditText txtVille;
    private EditText txtDescription;
    private EditText txtPays;
    private Button btnSoumettre;

    public DonFragment() {

        // Required empty public constructor
    }

    public static DonFragment newInstance() {
        return new DonFragment();
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
        txtDescription = view.findViewById(R.id.editTextMessageDon);
        txtVille = view.findViewById(R.id.editTextVilleDon);
        txtPays = view.findViewById(R.id.editTextPaysDon);
        btnSoumettre = view.findViewById(R.id.btnSoumettreDon);

        btnSoumettre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nom = txtNom.getText().toString();
                String phone = txtNumero.getText().toString();
                String email = txtEmail.getText().toString();
                String ville = txtVille.getText().toString();
                String pays = txtPays.getText().toString();
                String description = txtDescription.getText().toString();
                boolean nomIsValid =
                        Utils.checkRegexNom(nom);
                boolean phoneIsValid =
                        Utils.checkRegexPhone(phone);
                boolean emailIsValid =
                        Utils.checkRegexEmail(email);
                boolean villeIsValid =
                        Utils.checkRegexPays(ville);
                boolean paysIsValid =
                        Utils.checkRegexPays(pays);
                boolean descriptionIsValid =
                        Utils.checkRegexDescription(description);
                boolean isSaveSearch = true;
                if (nom.isEmpty()) {
                    Toast.makeText(getContext(),
                            R.string.nom_vide, Toast.LENGTH_SHORT).show();
                    isSaveSearch = false;
                } else if (phone.isEmpty()) {
                    Toast.makeText(getContext(),
                            R.string.phone_vide, Toast.LENGTH_SHORT).show();
                    isSaveSearch = false;
                } else if (ville.isEmpty()) {
                    Toast.makeText(getContext(),
                            R.string.ville_vide, Toast.LENGTH_SHORT).show();
                    isSaveSearch = false;
                } else if (email.isEmpty()) {
                    Toast.makeText(getContext(),
                            R.string.email_vide, Toast.LENGTH_SHORT).show();
                    isSaveSearch = false;
                } else if (pays.isEmpty()) {
                    Toast.makeText(getContext(),
                            R.string.pays_vide, Toast.LENGTH_SHORT).show();
                    isSaveSearch = false;
                } else if (description.isEmpty()) {
                    Toast.makeText(getContext(),
                            R.string.description_vide, Toast.LENGTH_SHORT).show();
                    isSaveSearch = false;
                } else if (!nomIsValid) {
                    Toast.makeText(getContext(),
                            R.string.nom_non_valide, Toast.LENGTH_SHORT).show();
                    isSaveSearch = false;
                } else if (!phoneIsValid) {
                    Toast.makeText(getContext(),
                            R.string.phone_non_valide, Toast.LENGTH_SHORT).show();
                    isSaveSearch = false;
                } else if (!emailIsValid) {
                    Toast.makeText(getContext(),
                            R.string.email_nom_valide, Toast.LENGTH_SHORT).show();
                    isSaveSearch = false;
                } else if (!villeIsValid) {
                    Toast.makeText(getContext(),
                            R.string.ville_non_valide, Toast.LENGTH_SHORT).show();
                    isSaveSearch = false;
                } else if (!paysIsValid) {
                    Toast.makeText(getContext(),
                            R.string.pays_non_valide, Toast.LENGTH_SHORT).show();
                    isSaveSearch = false;
                } else if (!descriptionIsValid) {
                    Toast.makeText(getContext(),
                            R.string.description_non_valide, Toast.LENGTH_SHORT).show();
                    isSaveSearch = false;
                }
                if (isSaveSearch) {
                    saveGive(nom, phone, email, pays, ville, description);
                }

            }
        });
        return view;
    }

    private void saveGive(String nom, String phone, String email, String pays, String ville, String description) {

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitApi retrofitApi = retrofit.create(RetrofitApi.class);
        Don don = new Don(nom, phone, email, pays, ville, description);
        Call<Void> call = retrofitApi.createGive(don);
        call.enqueue((new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(getContext(), "Donation added to API", Toast.LENGTH_SHORT).show();
                txtNom.setText("");
                txtNumero.setText("");
                txtEmail.setText("");
                txtNumero.setText("");
                txtDescription.setText("");
                txtVille.setText("");
                txtPays.setText("");
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(getContext(), "Data fail to API", Toast.LENGTH_SHORT).show();
            }
        }));
    }
}