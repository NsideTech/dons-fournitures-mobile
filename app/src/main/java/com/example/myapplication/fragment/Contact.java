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
import com.example.myapplication.model.ReceiveMessage;
import com.example.myapplication.model.Recherche;
import com.example.myapplication.model.RetrofitApi;
import com.example.myapplication.model.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Contact extends Fragment {
    private EditText txtNom;
    private EditText txtNumero;
    private EditText txtEmail;
    private EditText txtMessage;
    private Button btnSoumettre;

    public Contact() {}

    public static Contact newInstance() {
        return new Contact();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    private void saveMessage(String nom, String phone, String email, String message) {

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitApi retrofitApi = retrofit.create(RetrofitApi.class);
        ReceiveMessage receiveMessage = new ReceiveMessage(nom, phone, email, message);
        Call<Void> call = retrofitApi.createMessage(receiveMessage);
        call.enqueue((new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(getContext(), R.string.message_valide, Toast.LENGTH_SHORT).show();
                txtNom.setText("");
                txtEmail.setText("");
                txtNumero.setText("");
                txtMessage.setText("");

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(getContext(), R.string.information_non_valide, Toast.LENGTH_SHORT).show();
            }
        }));
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        txtNom = view.findViewById(R.id.editTextNomContact);
        txtNumero = view.findViewById(R.id.editTextNumeroContact);
        txtEmail = view.findViewById(R.id.editTextEmailContact);
        txtMessage = view.findViewById(R.id.editTextMessageContact);
        btnSoumettre = view.findViewById(R.id.btnSoumettreContact);

        btnSoumettre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom = txtNom.getText().toString();
                String phone = txtNumero.getText().toString();
                String email = txtEmail.getText().toString();
                String message = txtMessage.getText().toString();

                boolean nomIsValid =
                        Utils.checkRegexNom(nom);
                boolean phoneIsValid =
                        Utils.checkRegexPhone(phone);
                boolean emailIsValid =
                        Utils.checkRegexEmail(email);
                boolean isSaveMessage = true;

                if (nom.isEmpty()) {
                    Toast.makeText(getContext(),
                            R.string.nom_vide, Toast.LENGTH_SHORT).show();
                    isSaveMessage = false;
                } else if (phone.isEmpty()) {
                    Toast.makeText(getContext(),
                            R.string.phone_vide, Toast.LENGTH_SHORT).show();
                    isSaveMessage = false;
                } else if (email.isEmpty()) {
                    Toast.makeText(getContext(),
                            R.string.email_vide, Toast.LENGTH_SHORT).show();
                    isSaveMessage = false;
                } else if (message.isEmpty()) {
                    Toast.makeText(getContext(),
                            R.string.message_vide, Toast.LENGTH_SHORT).show();
                    isSaveMessage = false;
                }
                else if (!nomIsValid) {
                    Toast.makeText(getContext(),
                            R.string.nom_non_valide, Toast.LENGTH_SHORT).show();
                    isSaveMessage = false;
                } else if (!phoneIsValid) {
                    Toast.makeText(getContext(),
                            R.string.phone_non_valide, Toast.LENGTH_SHORT).show();
                    isSaveMessage = false;
                } else if (!emailIsValid) {
                    Toast.makeText(getContext(),
                            R.string.email_nom_valide, Toast.LENGTH_SHORT).show();
                    isSaveMessage = false;
                }if (isSaveMessage) {
                    saveMessage(nom, phone, email, message);
                }
            }
        });


        return view;
    }
}