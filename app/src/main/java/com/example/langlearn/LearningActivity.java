package com.example.langlearn;

import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class LearningActivity extends MainActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learning_activity);

        //get selected language and category
        Bundle Extras = getIntent().getExtras();
        assert Extras != null;
        String SelectedLanguage = Extras.getString("LanguageChosen");
        String SelectedCategory = Extras.getString("SelectedCategory");

        DatabaseController DBController = new DatabaseController(LearningActivity.this);
        DBController.getReadableDatabase();
        ArrayList<ArrayList> wordsArray = new ArrayList<>();
        wordsArray.add(DBController.getTranslations(SelectedLanguage, SelectedCategory));
        Log.println(Log.VERBOSE, "Marker", String.valueOf(wordsArray));

    }

    public void openMain(View v) {
        Intent showMain = new Intent(this, MainActivity.class);
        startActivity(showMain);

    }
}
