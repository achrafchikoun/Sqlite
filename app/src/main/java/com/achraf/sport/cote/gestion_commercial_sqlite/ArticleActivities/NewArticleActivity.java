package com.achraf.sport.cote.gestion_commercial_sqlite.ArticleActivities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.achraf.sport.cote.gestion_commercial_sqlite.R;

public class NewArticleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_article);
    }

    public void goToMenu(View view){
        NewArticleActivity.this.finish();
    }
}
