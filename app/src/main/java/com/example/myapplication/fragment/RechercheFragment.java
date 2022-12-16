package com.example.myapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.R;
import com.example.myapplication.model.Recherche;
import com.example.myapplication.model.RetrofitApi;
import com.example.myapplication.model.Utils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;

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
    private final Gson gson = new Gson();

    public RechercheFragment() {}

    public static RechercheFragment newInstance() {
        return new RechercheFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }
    private void validationInfo(){
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
                      Utils.checkRegexNom(email);
              boolean paysIsValid =
                      Utils.checkRegexPhone(pays);
              boolean descriptionIsValid =
                      Utils.checkRegexPhone(description);
              boolean saveSearch = true;
              if(nom.isEmpty()){
                  Toast.makeText(getContext(),
                          R.string.nom_vide, Toast.LENGTH_SHORT).show();
                  saveSearch =false;
              }else if(phone.isEmpty()){
                  Toast.makeText(getContext(),
                          R.string.phone_vide, Toast.LENGTH_SHORT).show();
                  saveSearch =false;
              }else if(email.isEmpty()){
                  Toast.makeText(getContext(),
                          R.string.email_vide, Toast.LENGTH_SHORT).show();
                  saveSearch =false;
              }else if(pays.isEmpty()){
                  Toast.makeText(getContext(),
                          R.string.pays_vide, Toast.LENGTH_SHORT).show();
                  saveSearch =false;
              }else if(description.isEmpty()){
                  Toast.makeText(getContext(),
                          R.string.description_vide, Toast.LENGTH_SHORT).show();
                  saveSearch =false;
              }else if(!nomIsValid){
                  Toast.makeText(getContext(),
                          R.string.nom_non_valide, Toast.LENGTH_SHORT).show();
                  saveSearch =false;
              }else if(!phoneIsValid){
                  Toast.makeText(getContext(),
                          R.string.phone_non_valide, Toast.LENGTH_SHORT).show();
                  saveSearch =false;
              }else if(!emailIsValid){
                  Toast.makeText(getContext(),
                          R.string.email_nom_valide, Toast.LENGTH_SHORT).show();
                  saveSearch =false;
              }else if(!paysIsValid){
                  Toast.makeText(getContext(),
                          R.string.pays_non_valide, Toast.LENGTH_SHORT).show();
                  saveSearch =false;
              }else if(!descriptionIsValid){
                  Toast.makeText(getContext(),
                          R.string.description_non_valide, Toast.LENGTH_SHORT).show();
                  saveSearch =false;
              }
              if(saveSearch){
                saveSearch(nom,phone,email,pays,description);
              }
          }
      });
    }


    
    private void saveSearch(String nom,String phone,String email, String description,String pays) {
      /*  String url = "http://10.0.2.2:8080/products";
        RequestQueue queue;
        queue = Volley.newRequestQueue(requireContext());
        StringRequest request = new StringRequest(Request.Method.POST,url;
                response -> {
                    try{
                        Recherche recherche = new Recherche();
                        recherche.setNom(nom);
                        recherche.setPhone(phone);
                        recherche.setEmail(email);
                        recherche.setPays(pays);
                        recherche.setDescription(description);
                        recherches.add(recherche);
                        GsonBuilder builder = new GsonBuilder();
                        builder.setPrettyPrinting();

                        Gson gson = builder.create();
                        Recherche recherche = gson.fromJson(jsonString, Recherche.class);
                        jsonString = gson.toJson(recherche);
                        recherches.add(jsonString);
                    }catch (){

                    }
                }

    }*/
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:8080/Search")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitApi retrofitApi = retrofit.create(RetrofitApi.class);
        Recherche search = new Recherche(nom,phone,email,pays,description);
        Call<Recherche> call = retrofitApi.createPost(search);
        call.enqueue((new Callback<Recherche>() {
            @Override
            public void onResponse(Call<Recherche> call, Response<Recherche> response) {
                Toast.makeText(getContext(), "Data added to API", Toast.LENGTH_SHORT).show();
                txtNom.setText("");
                txtEmail.setText("");
                txtNumero.setText("");
                txtPays.setText("");
                txtDescription.setText("");
            }

            @Override
            public void onFailure(Call<Recherche> call, Throwable t) {
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
        txtDescription = view.findViewById(R.id.editTextMessageRecherche);
        btnSoumettre = view.findViewById(R.id.btnSoumettreRecherche);


        return view;
    }
}