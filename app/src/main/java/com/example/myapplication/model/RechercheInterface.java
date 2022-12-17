package com.example.myapplication.model;

import java.util.List;

public interface RechercheInterface {


    void saveInformation(Recherche recherche);

    List<Recherche> getInformation();

    void saveInt(int i);

    int getInt();

    void saveIntCount(int i);

    int getIntCount();
}
