package com.example.langlearn;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;

public class Settings extends MainActivity {
    SharedPreferences choice = getPreferences(MODE_PRIVATE);

    //none of this actually works
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (loadChoice()) {
            setTheme(R.style.Dark_Theme_LangLearn);
        } else {
            setTheme(R.style.Base_Theme_LangLearn);
        }
        setContentView(R.layout.activity_settings);
        RadioButton defaultRadio = findViewById(R.id.defaultRadio);
        RadioButton darkRadio = findViewById(R.id.darkRadio);

        defaultRadio.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Log.println(Log.VERBOSE,"radio", "default checked");
            saveChoice(false);
        });

        darkRadio.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Log.println(Log.VERBOSE,"radio", "dark checked");
            saveChoice(true); //tell the save choice method that dark was picked
        });

    }

    private void saveChoice(boolean isDark) {
        SharedPreferences choice = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = choice.edit();
        editor.putBoolean("isDark", isDark); //save the dark theme
        editor.apply();
    }

    boolean loadChoice() {
        choice = getPreferences(MODE_PRIVATE);
        return choice.getBoolean("isDark", false);
    }

    public void openMain(View v) {
        Intent showMain = new Intent(this, MainActivity.class);
        startActivity(showMain);

    }
}
