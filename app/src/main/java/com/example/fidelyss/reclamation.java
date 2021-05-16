package com.example.fidelyss;

public class reclamation {
    private int id;
    private String titre;
    private String description;
    private String client;

    public reclamation() {
    }

    public reclamation(int id, String titre, String description, String client) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.client = client;
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
}
