package com.achraf.sport.cote.gestion_commercial_sqlite.model;

/**
 * Created by Achraf on 20/06/2016.
 */
public class Client {
    int id;
    String nom;
    String prenom;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
