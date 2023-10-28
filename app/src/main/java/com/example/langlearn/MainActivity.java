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

        Button languageButton1 = (Button) findViewById(R.id.openLanguage1);
        languageButton1.setOnClickListener(this);

        Button languageButton2 = (Button) findViewById(R.id.openLanguage2);
        languageButton2.setOnClickListener(this);

        Button languageButton3 = (Button) findViewById(R.id.openLanguage3);
        languageButton2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.openLanguage1) {
            Intent langMenu = new Intent(this, Language1Menu.class);
            startActivity(langMenu);
        } else if (view.getId() == R.id.openLanguage2) {
            Intent langMenu = new Intent(this, Language2Menu.class);
            startActivity(langMenu);
        } else if (view.getId() == R.id.openLanguage3) {
            Intent langMenu = new Intent(this, Language3Menu.class);
            startActivity(langMenu);
        }
    }
}
/**
    public void openSettings(View v){
        Intent showSettings = new Intent(this, Settings.class);
        startActivity(showSettings);

    }
    public void openLanguage1(View v){
        Intent showSettings = new Intent(this, Language1Menu.class);
        startActivity(showSettings);

    }
    public void openLanguage2(View v){
        Intent showSettings = new Intent(this, Language2Menu.class);
        startActivity(showSettings);

    }
    public void openLanguage3(View v){
        Intent showSettings = new Intent(this, Language3Menu.class);
        startActivity(showSettings);

    }
}
 **/
