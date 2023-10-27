package com.example.langlearn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Settings extends MainActivity {

    @Override //show splash screen
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    public void openMain(View v){
        Intent showSettings = new Intent(this, MainActivity.class);
        startActivity(showSettings);

    }
}
