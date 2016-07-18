package com.achraf.sport.cote.gestion_commercial_sqlite.ClientAcitivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.achraf.sport.cote.gestion_commercial_sqlite.DataBase.DatabaseHelper;
import com.achraf.sport.cote.gestion_commercial_sqlite.R;
import com.achraf.sport.cote.gestion_commercial_sqlite.model.Client;

public class NewClientActivity extends AppCompatActivity {

    EditText txt_nom, txt_prenom;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_client);
        db = new DatabaseHelper(getApplicationContext());
        txt_nom = (EditText) findViewById(R.id.txtNom);
        txt_prenom = (EditText) findViewById(R.id.txtPrenom);
    }

    public void insertClient(View view){
        Client client = new Client();
        client.setNom(txt_nom.getText().toString());
        client.setPrenom(txt_prenom.getText().toString());
        db.insertClient(client);
        Toast.makeText(this, "Opération réussie", Toast.LENGTH_LONG).show();
    }

    public void listClient(View view){
        startActivity(new Intent(this, ListClientAcitivity.class));
        Toast.makeText(this, "Opération réussie", Toast.LENGTH_LONG).show();
    }

    public void goToMenu(View view){
        NewClientActivity.this.finish();
    }
}
