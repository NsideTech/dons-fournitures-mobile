package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    private TextView txtName;
    private TextView txtPhone;
    private TextView txtEmail;
    private TextView txtPays;
    private TextView txtDescription;
    private ImageView imageView;
    private Button btnContacter;
    String nom;
    String phone;
    String email;
    String pays;
    String description;
    Long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        liaison();
        Log.i("TAG", "id de la demande est : " + id);
    }

    private void liaison() {
        txtName = findViewById(R.id.txtName);
        txtPhone = findViewById(R.id.txtPhone);
        txtEmail = findViewById(R.id.txtEmail);
        txtPays = findViewById(R.id.txtPays);
        txtDescription = findViewById(R.id.edtDescriptionRecherche);
        imageView = findViewById(R.id.logo);
        btnContacter = findViewById(R.id.btnContacter);
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.books));

        Intent intent = getIntent();
        id = intent.getLongExtra("id",0);
        nom = intent.getStringExtra("nom");
        phone = intent.getStringExtra("phone");
        email = intent.getStringExtra("email");
        pays = intent.getStringExtra("pays");
        description = intent.getStringExtra("description");

        txtName.setText(nom);
        txtPhone.setText(phone);
        txtEmail.setText(email);
        txtPays.setText(pays);
        txtDescription.setText(description);

        btnContacter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = String.format("mailto: %s",email);
                String email =  "Je voudrais faire un don pour la demande avec l'identifiant " + id;


                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, mail);
                intent.putExtra(Intent.EXTRA_SUBJECT, email);
                startActivity(intent);
            }
        });

    }
}