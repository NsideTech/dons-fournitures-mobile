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
import com.example.myapplication.model.Recherche;
import com.example.myapplication.model.RechercheInterface;
import com.example.myapplication.model.RetrofitApi;
import com.example.myapplication.model.Utils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RechercheFragment extends Fragment {
    private EditText txtNom;
    private EditText txtNumero;
    private EditText txtEmail;
    private EditText txtPays;
    private EditText txtDescription;
    private Button btnSoumettre;
    private List<Recherche> recherches = new ArrayList<>();
    private static int count;

    public RechercheFragment() {}

    public static RechercheFragment newInstance() {
        return new RechercheFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        ((RechercheInterface) getContext()).saveIntCount(count);
        Bundle bundle = new Bundle();
        bundle.putInt("0",count);
        Accueil accueil = new Accueil();
        accueil.setArguments(bundle);

    }

    private void saveSearch(String nom,String phone,String email, String pays,String description) {

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitApi retrofitApi = retrofit.create(RetrofitApi.class);
        Recherche search = new Recherche(nom,phone,email,pays,description);
        Call<Void> call = retrofitApi.createPost(search);
        call.enqueue((new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(getContext(), "Data added to API", Toast.LENGTH_SHORT).show();
                txtNom.setText("");
                txtEmail.setText("");
                txtNumero.setText("");
                txtPays.setText("");
                txtDescription.setText("");
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(getContext(), "Data fail to API", Toast.LENGTH_SHORT).show();
            }
        }));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recherche, container, false);
        txtNom = view.findViewById(R.id.editTextNomRecherche);
        txtNumero = view.findViewById(R.id.editTextPhoneRecherche);
        txtEmail = view.findViewById(R.id.editTextEmailRecherche);
        txtPays = view.findViewById(R.id.editTextPaysRecherche);
        txtDescription = view.findViewById(R.id.edtDescriptionRecherche);
        btnSoumettre = view.findViewById(R.id.btnContacter);
        btnSoumettre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nom = txtNom.getText().toString();
                String phone = txtNumero.getText().toString();
                String email = txtEmail.getText().toString();
                String pays = txtPays.getText().toString();
                String description = txtDescription.getText().toString();
                boolean nomIsValid =
                        Utils.checkRegexNom(nom);
                boolean phoneIsValid =
                        Utils.checkRegexPhone(phone);
                boolean emailIsValid =
                        Utils.checkRegexEmail(email);
                boolean paysIsValid =
                        Utils.checkRegexPays(pays);
                boolean descriptionIsValid =
                        Utils.checkRegexDescription(description);
                boolean isSaveSearch = true;
                if(nom.isEmpty()){
                    Toast.makeText(getContext(),
                            R.string.nom_vide, Toast.LENGTH_SHORT).show();
                    isSaveSearch =false;
                }else if(phone.isEmpty()){
                    Toast.makeText(getContext(),
                            R.string.phone_vide, Toast.LENGTH_SHORT).show();
                    isSaveSearch =false;
                }else if(email.isEmpty()){
                    Toast.makeText(getContext(),
                            R.string.email_vide, Toast.LENGTH_SHORT).show();
                    isSaveSearch =false;
                }else if(pays.isEmpty()){
                    Toast.makeText(getContext(),
                            R.string.pays_vide, Toast.LENGTH_SHORT).show();
                    isSaveSearch =false;
                }else if(description.isEmpty()){
                    Toast.makeText(getContext(),
                            R.string.description_vide, Toast.LENGTH_SHORT).show();
                    isSaveSearch =false;
                }else if(!nomIsValid){
                    Toast.makeText(getContext(),
                            R.string.nom_non_valide, Toast.LENGTH_SHORT).show();
                    isSaveSearch =false;
                }else if(!phoneIsValid){
                    Toast.makeText(getContext(),
                            R.string.phone_non_valide, Toast.LENGTH_SHORT).show();
                    isSaveSearch =false;
                }else if(!emailIsValid){
                    Toast.makeText(getContext(),
                            R.string.email_nom_valide, Toast.LENGTH_SHORT).show();
                    isSaveSearch =false;
                }else if(!paysIsValid){
                    Toast.makeText(getContext(),
                            R.string.pays_non_valide, Toast.LENGTH_SHORT).show();
                    isSaveSearch =false;
                }else if(!descriptionIsValid){
                    Toast.makeText(getContext(),
                            R.string.description_non_valide, Toast.LENGTH_SHORT).show();
                    isSaveSearch =false;
                }
                if(isSaveSearch){
                    saveSearch(nom,phone,email,pays,description);
                }
                count++;

            }
        });

        return view;
    }
}