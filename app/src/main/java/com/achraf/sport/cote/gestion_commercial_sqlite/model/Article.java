package com.achraf.sport.cote.gestion_commercial_sqlite.model;

/**
 * Created by Achraf on 20/06/2016.
 */
public class Article {
    int id;
    String designation;
    double prix_vente;

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrix_vente() {
        return prix_vente;
    }

    public void setPrix_vente(double prix_vente) {
        this.prix_vente = prix_vente;
    }
}
