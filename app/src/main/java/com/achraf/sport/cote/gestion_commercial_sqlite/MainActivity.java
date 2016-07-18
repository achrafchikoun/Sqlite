package com.achraf.sport.cote.gestion_commercial_sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.achraf.sport.cote.gestion_commercial_sqlite.ArticleActivities.NewArticleActivity;
import com.achraf.sport.cote.gestion_commercial_sqlite.ClientAcitivities.NewClientActivity;
import com.achraf.sport.cote.gestion_commercial_sqlite.CommandeActivities.NewCommandeActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void client(View view){
        startActivity(new Intent(this, NewClientActivity.class));
    }

    public void article(View view){
        startActivity(new Intent(this, NewArticleActivity.class));
    }

    public void commande(View view){
        startActivity(new Intent(this, NewCommandeActivity.class));
    }
}
