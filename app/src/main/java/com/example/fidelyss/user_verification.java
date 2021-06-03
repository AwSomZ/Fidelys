package com.example.fidelyss;

import java.util.Date;

public class user_verification {
    private int id;
    private String token;
    private Date dateconfirmation;
    private Date datecreation;
    private String user;

    public user_verification() {
    }

    public user_verification(int id, String token, Date dateconfirmation, Date datecreation, String user) {
        this.id = id;
        this.token = token;
        this.dateconfirmation = dateconfirmation;
        this.datecreation = datecreation;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getDateconfirmation() {
        return dateconfirmation;
    }

    public void setDateconfirmation(Date dateconfirmation) {
        this.dateconfirmation = dateconfirmation;
    }

    public Date getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(Date datecreation) {
        this.datecreation = datecreation;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
