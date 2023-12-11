package com.example.langlearn;

import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;
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

        ArrayList<String> langWordsArr;
        langWordsArr = (DBController.getForeign(SelectedLanguage,SelectedCategory));

        ArrayList<String> engWordsArr;
        engWordsArr = (DBController.getEnglish(SelectedLanguage,SelectedCategory));

        Log.println(Log.INFO, "Learning Activity", "Two arrays (hopefully): \n" + langWordsArr + "\n" + engWordsArr); //print the chosen index

        //First creation, set random words on buttons
        Random RandInt = new Random();
        int index = RandInt.nextInt(langWordsArr.size());
        Log.println(Log.INFO, "Marker", "Chosen index " + index); //print the chosen index

        //get a random word from the first (foreign words) array
        String chosen = String.valueOf(langWordsArr.get(index));
        Log.println(Log.INFO, "Marker", "Chosen word " + chosen);

    }

    public void openMain(View v) {
        Intent showMain = new Intent(this, MainActivity.class);
        startActivity(showMain);

    }
}
