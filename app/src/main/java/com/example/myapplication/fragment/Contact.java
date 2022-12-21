package com.example.myapplication.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.model.Utils;


public class Contact extends Fragment {
    private EditText txtSubject;
    private EditText txtEmail;
    private EditText txtMessage;
    private Button btnSoumettre;
    private String email;
    private String subject;
    private String message;
    private boolean readyToSend;

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
        txtSubject = view.findViewById(R.id.editTextSubjectContact);
        txtEmail = view.findViewById(R.id.editTextEmailContact);
        txtMessage = view.findViewById(R.id.editTextMessageContact);
        btnSoumettre = view.findViewById(R.id.btnSoumettreContact);
        btnSoumettre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 email = txtEmail.getText().toString();
                message = txtMessage.getText().toString();
                subject = txtSubject.getText().toString();
                checkdata();
                if(readyToSend) {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
                    intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                    intent.putExtra(Intent.EXTRA_TEXT, message);
                    intent.setType("message/rfc822");


                    startActivity(Intent.createChooser(intent, "Choose an Email client :"));
                }

            }
        });

        return view;
    }

    private void checkdata() {
        boolean emailIsValid =
                Utils.checkRegexEmail(email);
        if (email.isEmpty()) {
            Toast.makeText(getContext(),
                    R.string.email_vide, Toast.LENGTH_SHORT).show();
        }
        else if (message.isEmpty()) {
            Toast.makeText(getContext(),
                    "Svp entrer un message", Toast.LENGTH_SHORT).show();
        }
        else if (!emailIsValid) {
            Toast.makeText(getContext(),
                    R.string.email_nom_valide, Toast.LENGTH_SHORT).show();
        }
        else{
            readyToSend=true;
        }
    }
}