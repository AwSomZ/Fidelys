package com.example.fidelyss;

import java.util.Date;

public class transaction {
    private int id;
    private String type;
    private int montant;
    private Date date;
    private String client;
    private String description;

    public transaction() {
    }

    public transaction(int id, String type, int montant, Date date, String client, String description) {
        this.id = id;
        this.type = type;
        this.montant = montant;
        this.date = date;
        this.client = client;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
