package com.example.myapplication;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.myapplication.fragment.Accueil;
import com.example.myapplication.fragment.Contact;
import com.example.myapplication.fragment.DonFragment;
import com.example.myapplication.fragment.Liste;
import com.example.myapplication.fragment.MapsFragment;
import com.example.myapplication.fragment.RechercheFragment;
import com.example.myapplication.model.Recherche;
import com.google.android.material.navigation.NavigationView;

import java.util.List;
import java.util.Objects;



public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);

        drawerLayout = findViewById(R.id.my_drawer);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();


        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


        getSupportFragmentManager().
                beginTransaction().replace(R.id.container_fragment, new Accueil()).commit();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Class fragmentClass = null;
        if (item.getItemId() == R.id.nav_accueil) {
            fragmentClass = Accueil.class;
        }
        if (item.getItemId() == R.id.nav_listes) {
            fragmentClass = Liste.class;
        }
        if (item.getItemId() == R.id.nav_don) {
            fragmentClass = DonFragment.class;
        }
        if (item.getItemId() == R.id.nav_recherche) {
            fragmentClass = RechercheFragment.class;
        }
        if (item.getItemId() == R.id.nav_contact) {
            fragmentClass = Contact.class;
        }
        if (item.getItemId() == R.id.nav_emplacement) {
            fragmentClass = MapsFragment.class;
        }

        Fragment fragment;
        try {
            fragment = (Fragment) Objects.requireNonNull(fragmentClass).newInstance();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.container_fragment, fragment).commit();
            drawerLayout.closeDrawers();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        setTitle(item.getTitle());
        return true;
    }

}