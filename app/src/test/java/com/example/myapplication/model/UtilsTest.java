package com.example.myapplication.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class UtilsTest {

    @Test
    public void checkRegexNomValide() {
        String nom = "jackydetongamasson";
        assertTrue(Utils.checkRegexNom(nom));
    }
    @Test
    public void checkRegexNomNonValide() {
        String nom = "jackydetongamassonkemajou";
        assertFalse(Utils.checkRegexNom(nom));
    }

    @Test
    public void checkRegexPhoneValide() {
        String phone = "111-111-1111";
        assertTrue(Utils.checkRegexPhone(phone));
    }
    @Test
    public void checkRegexPhoneNonValide() {
        String phone = "1121-111-1111";
        assertFalse(Utils.checkRegexPhone(phone));
    }

    @Test
    public void checkRegexEmailValide() {
        String email = "@jacky@gmail.com";
        assertTrue(Utils.checkRegexEmail(email));
    }
    @Test
    public void checkRegexEmailNonValide() {
        String email = "jacky@gmail.com";
        assertFalse(Utils.checkRegexEmail(email));
    }

    @Test
    public void checkRegexPaysValide() {
        String pays = "canada";
        assertTrue(Utils.checkRegexPays(pays));
    }
    @Test
    public void checkRegexPaysNonValide() {
        String pays = "canada10";
        assertFalse(Utils.checkRegexPays(pays));
    }

    @Test
    public void checkRegexVilleValide() {
        String ville = "quebec";
        assertTrue(Utils.checkRegexVille(ville));
    }
    @Test
    public void checkRegexVilleNonValide() {
        String ville = "quebec10";
        assertFalse(Utils.checkRegexVille(ville));
    }

    @Test
    public void checkRegexDescriptionValide() {
        String description = "calculatrice";
        assertTrue(Utils.checkRegexDescription(description));
    }
    @Test
    public void checkRegexDescriptionNonValide() {
        String description = "calculatrice@";
        assertFalse(Utils.checkRegexDescription(description));
    }
}