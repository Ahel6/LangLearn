package com.example.langlearn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Settings extends MainActivity {

    @Override //show splash screen
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }
    public void openMain() {
        Button settingsBack = (Button) findViewById(R.id.settingsButton);
        settingsBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View Main) {
                startActivity(new Intent(Settings.this, MainActivity.class));
               //this.finish();
            }
        });
    }
}
