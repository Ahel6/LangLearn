package com.example.langlearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //start the database - creates empty tables
        DatabaseController DBController = new DatabaseController(MainActivity.this);

        DBController.getWritableDatabase();
        //DBController.populate("French",1, "FrenchTest", "EnglishTest");



        //Values to store in the database, should only run once
        String[] frenchNum = {"Un", "Deux", "Trois", "Quatre", "Cinq", "Six", "Sept", "Huit", "Neuf", "Dix"};
        String[] engNum = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};

        for (int I = 0; I < frenchNum.length; I++) {
            DBController.populate("French", frenchNum[I], engNum[I]);
        }



        Button settingsButton = findViewById(R.id.settingsButton);
        settingsButton.setOnClickListener(this);

        Button languageButton1 = findViewById(R.id.openLanguage1);
        languageButton1.setOnClickListener(this);

        Button languageButton2 = findViewById(R.id.openLanguage2);
        languageButton2.setOnClickListener(this);

        Button languageButton3 = findViewById(R.id.openLanguage3);
        languageButton3.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int chosenView = view.getId();
        Intent LanguageChosen;
        int LanguageKeyNo;

        if (chosenView == R.id.settingsButton) {
            LanguageChosen = new Intent(MainActivity.this, Settings.class);
            startActivity(LanguageChosen);

        } else if (chosenView == R.id.openLanguage1) {
            LanguageChosen = new Intent(MainActivity.this, categorySelectMenu.class);
            LanguageKeyNo = 1;
            LanguageChosen.putExtra("LanguageKey", LanguageKeyNo); //relay the chosen language to the category menu
            startActivity(LanguageChosen);

        } else if (chosenView == R.id.openLanguage2) {
            LanguageChosen = new Intent(MainActivity.this, categorySelectMenu.class);
            LanguageKeyNo = 2;
            LanguageChosen.putExtra("LanguageKey", LanguageKeyNo);
            startActivity(LanguageChosen);

        } else if (chosenView == R.id.openLanguage3) {
            LanguageChosen = new Intent(MainActivity.this, categorySelectMenu.class);
            LanguageKeyNo = 3;
            LanguageChosen.putExtra("LanguageKey", LanguageKeyNo);
            startActivity(LanguageChosen);

        }
    }
}
