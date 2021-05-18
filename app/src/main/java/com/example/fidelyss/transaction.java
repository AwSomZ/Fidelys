package com.example.fidelyss;

import java.util.Date;

public class transaction {
    private int id;
    private int debit;
    private int credit;
    private Date date;
    private String client;
    private String description;

    public transaction(int id, int debit, int credit, Date date, String client, String description) {
        this.id = id;
        this.debit = debit;
        this.credit = credit;
        this.date = date;
        this.client = client;
        this.description = description;
    }

    public transaction() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
