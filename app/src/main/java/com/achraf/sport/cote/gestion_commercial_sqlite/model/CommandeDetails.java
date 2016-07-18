package com.achraf.sport.cote.gestion_commercial_sqlite.model;

/**
 * Created by Achraf on 20/06/2016.
 */
public class CommandeDetails {
    int id;
    int id_commande;
    int id_article;
    double quantite;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_article() {
        return id_article;
    }

    public void setId_article(int id_article) {
        this.id_article = id_article;
    }

    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }
}
