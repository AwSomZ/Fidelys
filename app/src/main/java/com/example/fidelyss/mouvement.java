package com.example.fidelyss;

public class mouvement {
  private   int id;
  private int milesprime;
  private int milesstatut;
  private String client;

    public mouvement(int id, int milesprime, int milesstatut, String client) {
        this.id = id;
        this.milesprime = milesprime;
        this.milesstatut = milesstatut;
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
}

