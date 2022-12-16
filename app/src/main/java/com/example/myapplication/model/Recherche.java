package com.example.myapplication.model;

public class Recherche {

    private Long id;
    private String nom;
    private String phone;
    private String email;
    private String pays;
    private String description;

    public Recherche( String nom, String phone, String email, String pays, String description) {
        this.nom = nom;
        this.phone = phone;
        this.email = email;
        this.pays = pays;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPays() {
        return pays;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
