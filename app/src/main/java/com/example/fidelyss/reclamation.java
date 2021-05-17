package com.example.fidelyss;

import java.util.Date;

public class reclamation {
    private int id;
    private String titre;
    private String description;
    private String client;
    private Date datecreation;
    private String etat;
    public reclamation() {
    }

    public reclamation(int id, String titre, String description, String client, Date datecreation, String etat) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.client = client;
        this.datecreation = datecreation;
        this.etat = etat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Date getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(Date datecreation) {
        this.datecreation = datecreation;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
}
