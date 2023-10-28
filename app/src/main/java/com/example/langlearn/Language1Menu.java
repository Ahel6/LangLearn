package com.example.langlearn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Language1Menu extends MainActivity {

    @Override //show splash screen
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language1menu);
    }

    public void openMain(View v){
        Intent showMain = new Intent(this, MainActivity.class);
        startActivity(showMain);

    }
}
