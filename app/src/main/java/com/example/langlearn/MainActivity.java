package com.example.langlearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DatabaseController databaseController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button settingsButton = (Button) findViewById(R.id.settingsButton);
        settingsButton.setOnClickListener(this);

        Button languageButton1 = (Button) findViewById(R.id.openLanguage1);
        languageButton1.setOnClickListener(this);

        Button languageButton2 = (Button) findViewById(R.id.openLanguage2);
        languageButton2.setOnClickListener(this);

        Button languageButton3 = (Button) findViewById(R.id.openLanguage3);
        languageButton3.setOnClickListener(this);


        /** Values to store in the database, should only run once
         *
         */
        /**
        String[] languages = {"French", "Spanish"};
        String[] frenchNum = {"Un", "Deux", "Trois", "Quatre", "Cinq", "Six", "Sept", "Huit", "Neuf", "Dix"}
        **/
        databaseController = new DatabaseController(MainActivity.this);

        databaseController.addData("French", "Test word", "test translation" );
        databaseController.addData("French", "Test word 2 ", "test translation 2" );

    }

    @Override
    public void onClick(View view) {
        int chosenView = view.getId();
        Intent intent;

        if (chosenView == R.id.settingsButton) {
            intent = new Intent(this, Settings.class);
            startActivity(intent);

        } else if (chosenView == R.id.openLanguage1) {
            intent = new Intent(this, categorySelectMenu.class);
            intent.putExtra("LanguageChosen", 1); //relay the chosen language to the category menu
            startActivity(intent);

        } else if (chosenView == R.id.openLanguage2) {
            intent = new Intent(this, categorySelectMenu.class);
            intent.putExtra("LanguageChosen", 2);
            startActivity(intent);

        } else if (chosenView == R.id.openLanguage3) {
            intent = new Intent(this, categorySelectMenu.class);
            intent.putExtra("LanguageChosen", 3);
            startActivity(intent);

        }
    }
}
