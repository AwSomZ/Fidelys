package com.example.fidelyss;

import java.sql.Date;

public class mouvement {
  private   int id;
  private int milesprime;
  private int milesstatut;
  private String client;
  private String statut;
  private int soldecummule;
  private int plafond;
  private int seuil;
  private Date date_niveau;
  private Date date_expiration;

    public mouvement(int id, int milesprime, int milesstatut, String client, String statut, int soldecummule, int plafond, int seuil, Date date_niveau, Date date_expiration) {
        this.id = id;
        this.milesprime = milesprime;
        this.milesstatut = milesstatut;
        this.client = client;
        this.statut = statut;
        this.soldecummule = soldecummule;
        this.plafond = plafond;
        this.seuil = seuil;
        this.date_niveau = date_niveau;
        this.date_expiration = date_expiration;
    }

    public mouvement() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMilesprime() {
        return milesprime;
    }

    public void setMilesprime(int milesprime) {
        this.milesprime = milesprime;
    }

    public int getMilesstatut() {
        return milesstatut;
    }

    public void setMilesstatut(int milesstatut) {
        this.milesstatut = milesstatut;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public int getSoldecummule() {
        return soldecummule;
    }

    public void setSoldecummule(int soldecummule) {
        this.soldecummule = soldecummule;
    }

    public int getPlafond() {
        return plafond;
    }

    public void setPlafond(int plafond) {
        this.plafond = plafond;
    }

    public int getSeuil() {
        return seuil;
    }

    public void setSeuil(int seuil) {
        this.seuil = seuil;
    }

    public Date getDate_niveau() {
        return date_niveau;
    }

    public void setDate_niveau(Date date_niveau) {
        this.date_niveau = date_niveau;
    }

    public Date getDate_expiration() {
        return date_expiration;
    }

    public void setDate_expiration(Date date_expiration) {
        this.date_expiration = date_expiration;
    }
}

