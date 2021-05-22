package com.example.fidelyss;

import java.util.Date;

public class billet {
    private int id;
    private String de;
    private String vers;
    private String type;
    private String classe;
    private Date datealler;
    private Date dateretour;
    private int adulte;
    private int jeune;
    private int enfant;
    private int bebe;
    private Date dateachat;
    private String client;

    public billet() {
    }

    public billet(int id, String de, String vers, String type, String classe, Date datealler, Date dateretour, int adulte, int jeune, int enfant, int bebe, Date dateachat, String client) {
        this.id = id;
        this.de = de;
        this.vers = vers;
        this.type = type;
        this.classe = classe;
        this.datealler = datealler;
        this.dateretour = dateretour;
        this.adulte = adulte;
        this.jeune = jeune;
        this.enfant = enfant;
        this.bebe = bebe;
        this.dateachat = dateachat;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDe() {
        return de;
    }

    public void setDe(String de) {
        this.de = de;
    }

    public String getVers() {
        return vers;
    }

    public void setVers(String vers) {
        this.vers = vers;
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

    public int getAdulte() {
        return adulte;
    }

    public void setAdulte(int adulte) {
        this.adulte = adulte;
    }

    public int getJeune() {
        return jeune;
    }

    public void setJeune(int jeune) {
        this.jeune = jeune;
    }

    public int getEnfant() {
        return enfant;
    }

    public void setEnfant(int enfant) {
        this.enfant = enfant;
    }

    public int getBebe() {
        return bebe;
    }

    public void setBebe(int bebe) {
        this.bebe = bebe;
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
}
