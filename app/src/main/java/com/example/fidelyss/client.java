package com.example.fidelyss;

import java.util.Date;

public class client {
    private String id;
    private String pin;
    private String cin;
    private String sexe;
    private String nom;
    private String prenom;
    private Date datenaiss;
    private String email;
    private String nationalite;
    private String adressedomicile;
    private String ville;
    private String codepostal;
    private String pays;
    private String teldomicile;
    private String telmobile;

    public client() {
    }

    public client(String id, String pin, String cin, String sexe, String nom, String prenom, Date datenaiss, String email, String nationalite, String adressedomicile, String ville, String codepostal, String pays, String teldomicile, String telmobile) {
        this.id = id;
        this.pin = pin;
        this.cin = cin;
        this.sexe = sexe;
        this.nom = nom;
        this.prenom = prenom;
        this.datenaiss = datenaiss;
        this.email = email;
        this.nationalite = nationalite;
        this.adressedomicile = adressedomicile;
        this.ville = ville;
        this.codepostal = codepostal;
        this.pays = pays;
        this.teldomicile = teldomicile;
        this.telmobile = telmobile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDatenaiss() {
        return datenaiss;
    }

    public void setDatenaiss(Date datenaiss) {
        this.datenaiss = datenaiss;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getAdressedomicile() {
        return adressedomicile;
    }

    public void setAdressedomicile(String adressedomicile) {
        this.adressedomicile = adressedomicile;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodepostal() {
        return codepostal;
    }

    public void setCodepostal(String codepostal) {
        this.codepostal = codepostal;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getTeldomicile() {
        return teldomicile;
    }

    public void setTeldomicile(String teldomicile) {
        this.teldomicile = teldomicile;
    }

    public String getTelmobile() {
        return telmobile;
    }

    public void setTelmobile(String telmobile) {
        this.telmobile = telmobile;
    }
}
