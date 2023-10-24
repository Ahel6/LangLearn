package com.example.langlearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{ //implements View.OnClickListener {

    @Override //show splash screen
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button openSettings = findViewById(R.id.settingsButton);
        //openSettings.setOnClickListener(this);
    }

    public void openSettings(View v){
        Intent showSettings = new Intent(MainActivity.this, Settings.class);
        startActivity(showSettings);

    }
}