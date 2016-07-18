package com.achraf.sport.cote.gestion_commercial_sqlite.model;

/**
 * Created by Achraf on 20/06/2016.
 */
public class Commande {
    int id;
    String date_commande;
    int id_client;

    public String getDate_commande() {
        return date_commande;
    }

    public void setDate_commande(String date_commande) {
        this.date_commande = date_commande;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }
}
