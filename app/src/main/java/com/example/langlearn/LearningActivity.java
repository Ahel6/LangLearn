package com.example.langlearn;

import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

public class LearningActivity extends MainActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learning_activity);

        //get selected language and category
        Bundle Extras = getIntent().getExtras();
        assert Extras != null;
        String SelectedLanguage = Extras.getString("LanguageChosen");
        String SelectedCategory = Extras.getString("SelectedCategory");

        DatabaseController DBController = new DatabaseController(LearningActivity.this);
        DBController.getReadableDatabase();


    }
}
