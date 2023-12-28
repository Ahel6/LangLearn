package com.example.langlearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    SharedPreferences themePref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set theme
        themePref = getSharedPreferences("themePicked", Context.MODE_PRIVATE);
        boolean isDark = themePref.getBoolean("isDark", false);
        Log.println(Log.VERBOSE, "isDark value", String.valueOf(isDark));

        if (isDark){
            setTheme(R.style.Dark_Theme_LangLearn);
        }else{
            setTheme(R.style.Base_Theme_LangLearn);
        }

        setContentView(R.layout.activity_main);




        //start the database - creates empty tables
        try (DatabaseController DBController = new DatabaseController(MainActivity.this)) {
            DBController.getWritableDatabase();
        }

        Button settingsButton = findViewById(R.id.settingsButton);
        settingsButton.setOnClickListener(this);

        Button languageButton1 = findViewById(R.id.openFrench);
        languageButton1.setOnClickListener(this);

        Button languageButton2 = findViewById(R.id.openSpanish);
        languageButton2.setOnClickListener(this);

        Button languageButton3 = findViewById(R.id.openLanguage3);
        languageButton3.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        int chosenView = view.getId();
        Intent LanguageChosen = new Intent(MainActivity.this, categorySelectMenu.class);

        if (chosenView == R.id.settingsButton) {
            LanguageChosen = new Intent(MainActivity.this, Settings.class);
            startActivity(LanguageChosen);

        } else if (chosenView == R.id.openFrench) {
            LanguageChosen.putExtra("LanguageChosen", "French"); //relay the chosen language to the category menu
            startActivity(LanguageChosen);

        } else if (chosenView == R.id.openSpanish) {
            LanguageChosen.putExtra("LanguageChosen", "Spanish");
            startActivity(LanguageChosen);

        } else if (chosenView == R.id.openLanguage3) {
            String txt = "Third language is unavailable at this time";
            int dur = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(this, txt, dur);
            toast.show();

        }
    }
}
