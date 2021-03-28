package com.example.fidelyss;

public class mouvement {
  private   int id;
  private int solde;
  private String client;

    public mouvement(int id, int solde, String client) {
        this.id = id;
        this.solde = solde;
        this.client = client;
    }

    public mouvement() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }
}
