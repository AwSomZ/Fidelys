package com.example.fidelyss;

public class mouvement {
  private   int id;
  private int solde;
    private int debit;
    private int credit;
  private String client;

    public mouvement(int id, int solde, int debit, int credit, String client) {
        this.id = id;
        this.solde = solde;
        this.debit = debit;
        this.credit = credit;
        this.client = client;
    }

    public mouvement() {
    }

    public int getDebit() {
        return debit;
    }

    public void setDebit(int debit) {
        this.debit = debit;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
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
