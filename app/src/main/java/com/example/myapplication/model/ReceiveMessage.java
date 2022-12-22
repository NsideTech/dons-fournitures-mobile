package com.example.myapplication.model;

public class ReceiveMessage {

    private Long id;
    private String nom;
    private String phone;
    private String email;
    private String message;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ReceiveMessage(String nom, String phone, String email, String message) {
        this.nom = nom;
        this.phone = phone;
        this.email = email;
        this.message = message;


    }
}
