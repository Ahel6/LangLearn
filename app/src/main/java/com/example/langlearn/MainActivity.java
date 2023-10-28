package com.example.langlearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override //show splash screen
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
        languageButton2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.settingsButton) {
            Intent openSettings = new Intent(this, Settings.class);
            startActivity(openSettings);
        } else if (view.getId() == R.id.openLanguage1) {
            Intent langMenu = new Intent(this, Language2Menu.class);
            startActivity(langMenu);
        } else if (view.getId() == R.id.openLanguage2) {
            Intent langMenu = new Intent(this, Language3Menu.class);
            startActivity(langMenu);
        } else if (view.getId() == R.id.openLanguage3) {
            Intent langMenu = new Intent(this, Language3Menu.class);
            startActivity(langMenu);
        }
    }
}
