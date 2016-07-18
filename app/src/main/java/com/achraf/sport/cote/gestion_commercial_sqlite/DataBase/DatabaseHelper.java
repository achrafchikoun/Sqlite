package com.achraf.sport.cote.gestion_commercial_sqlite.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.achraf.sport.cote.gestion_commercial_sqlite.model.Client;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Achraf on 20/06/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    //Logcat TAG
    private static final String TAG = "DatabaseHelper";

    //Database Version
    private static final int DATABASE_VERSION = 1;

    //Database Name
    private static final String DATABASE_NAME = "getion_commercial";

    //Tables Names
    private static final String TABLE_CLIENT = "clients";
    private static final String TABLE_ARTICLE = "articles";
    private static final String TABLE_COMMANDE = "commandes";
    private static final String TABLE_COMMANDE_DETAILS = "commandes_details";

    /* COLUMNS NAMES */
    //Common Columns names
    private static final String COLUMN_ID = "id";

    //Client Table - Columns Names
    private static final String COLUMN_NOM = "nom";
    private static final String COLUMN_PRENOM = "prenom";

    //Article Table - Columns Names
    private static final String COLUMN_DESIGNATION = "designation";
    private static final String COLUMN_PRIX_VENTE = "prix_vente";

    //Commande Table - Columns Names
    private static final String COLUMN_DATE_COMMANDE = "date_commande";
    private static final String COLUMN_ID_CLIENT = "id_client";

    //Commande Details Table - Columns Names
    private static final String COLUMN_ID_COMMANDE = "id_commande";
    private static final String COLUMN_ID_ARTICLE = "id_article";
    private static final String COLUMN_QUANTITE = "quantite";

    /* Tables Create Statements */
    //Client Table Create Statement
    private static final String CREATE_CLIENT_TABLE = "CREATE TABLE "
            + TABLE_CLIENT +" ("+ COLUMN_ID +" INTEGER PRIMARY KEY,"+ COLUMN_NOM + " TEXT,"
            + COLUMN_PRENOM + " TEXT )";

    //Article Table Create Statement
    private static final String CREATE_ARTICLE_TABLE = "CREATE TABLE "
            + TABLE_ARTICLE + " ("+ COLUMN_ID +" INTEGER PRIMARY KEY,"+ COLUMN_DESIGNATION + " TEXT,"
            + COLUMN_PRIX_VENTE + " DOUBLE)";

    //Commande Table Create Statement
    private static final String CREATE_COMMANDE_TABLE = "CREATE TABLE "
            + TABLE_COMMANDE + " ("+ COLUMN_ID + "INTEGER PRIMARY KEY,"+ COLUMN_DATE_COMMANDE + " DATETIME,"
            + COLUMN_ID_CLIENT + "INTEGER)";

    //Commande Details Table Create Statement
    private static final String CREATE_COMMANDE_DETAILS_TABLE = "CREATE TABLE "
            + TABLE_COMMANDE_DETAILS + " ("+ COLUMN_ID + " INTEGER PRIMARY KEY,"
            + COLUMN_ID_COMMANDE + " INTEGER," + COLUMN_ID_ARTICLE + " INTEGER,"
            + COLUMN_QUANTITE + " DOUBLE)";

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_CLIENT_TABLE);
        db.execSQL(CREATE_ARTICLE_TABLE);
        db.execSQL(CREATE_COMMANDE_TABLE);
        db.execSQL(CREATE_COMMANDE_DETAILS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + TABLE_CLIENT);
        db.execSQL("DROP TABLE IF EXIST " + TABLE_ARTICLE);
        db.execSQL("DROP TABLE IF EXIST " + TABLE_COMMANDE);
        db.execSQL("DROP TABLE IF EXIST " + TABLE_COMMANDE_DETAILS);
        onCreate(db);
    }

    //CRUD TABLE CLIENT
    public void insertClient(Client client){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NOM, client.getNom());
        values.put(COLUMN_PRENOM, client.getPrenom());
        db.insert(TABLE_CLIENT, null, values);
    }

    public Client getClient(int id){
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "SELECT * FROM " + TABLE_CLIENT
                +" WHERE " + COLUMN_ID + " = " + id;

        Cursor c = db.rawQuery(query, null);

        if(c != null)
            c.moveToFirst();

        Client client = new Client();
        client.setId(id);
        client.setNom(c.getString(c.getColumnIndex(COLUMN_NOM)));
        client.setPrenom(c.getString(c.getColumnIndex(COLUMN_PRENOM)));

        return client;
    }

    public List<Client> getAllClients(){
        List<Client> clients = new ArrayList<Client>();

        SQLiteDatabase db = this.getWritableDatabase();

        String query = "SELECT * FROM " + TABLE_CLIENT;

        Cursor c = db.rawQuery(query, null);

        if(c.moveToFirst()){
            do{
                Client client = new Client();
                client.setId(c.getInt(c.getColumnIndex(COLUMN_ID)));
                client.setNom(c.getString(c.getColumnIndex(COLUMN_NOM)));
                client.setPrenom(c.getString(c.getColumnIndex(COLUMN_PRENOM)));
                clients.add(client);
            }
            while(c.moveToNext());
        }

        return clients;
    }

    public void updateClient(Client client){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NOM, client.getNom());
        values.put(COLUMN_PRENOM, client.getPrenom());

        db.update(TABLE_CLIENT, values, COLUMN_ID + " = ?", new String[] {String.valueOf(client.getId())});
    }

    public void deleteClient(int id){
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_CLIENT, COLUMN_ID + " = ?", new String[] {String.valueOf(id)});
    }

}
