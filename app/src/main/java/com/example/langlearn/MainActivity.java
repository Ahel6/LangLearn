package com.example.langlearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //start the database - creates empty tables
        DatabaseController DBController = new DatabaseController(MainActivity.this);
        //DBController.getWritableDatabase();

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
