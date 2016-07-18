package com.achraf.sport.cote.gestion_commercial_sqlite.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
}
