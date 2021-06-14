package com.example.fidelyss;

import java.util.Date;

public class billet {
    private int id;
    private String depart;
    private String destination;
    private String type;
    private String classe;
    private Date datealler;
    private Date dateretour;
    private Date dateachat;
    private String client;
    private int prix;

    public billet() {
    }

    public billet(int id, String depart, String destination, String type, String classe, Date datealler, Date dateretour, Date dateachat, String client, int prix) {
        this.id = id;
        this.depart = depart;
        this.destination = destination;
        this.type = type;
        this.classe = classe;
        this.datealler = datealler;
        this.dateretour = dateretour;
        this.dateachat = dateachat;
        this.client = client;
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public Date getDatealler() {
        return datealler;
    }

    public void setDatealler(Date datealler) {
        this.datealler = datealler;
    }

    public Date getDateretour() {
        return dateretour;
    }

    public void setDateretour(Date dateretour) {
        this.dateretour = dateretour;
    }

    public Date getDateachat() {
        return dateachat;
    }

    public void setDateachat(Date dateachat) {
        this.dateachat = dateachat;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
}
