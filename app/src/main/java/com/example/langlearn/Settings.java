package com.example.langlearn;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Settings extends MainActivity {
    private RadioButton darkRadio;
    private RadioButton defaultRadio;
    private SharedPreferences themPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        RadioGroup group1 = findViewById(R.id.themeRadioGroup);
        darkRadio = findViewById(R.id.darkRadio);
        defaultRadio = findViewById(R.id.defaultRadio);

        themPref = getSharedPreferences("themePicked", Context.MODE_PRIVATE);
        boolean isDark = themPref.getBoolean("isDark", false); //change from boolean to string/int if more themes are added
        if (isDark){
            setTheme(R.style.Dark_Theme_LangLearn);
        }else{
            setTheme(R.style.Base_Theme_LangLearn);
        }

        group1.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == defaultRadio.getId()){
                setTheme(R.style.Base_Theme_LangLearn);
                saveChoice(false);
            } else if (checkedId == darkRadio.getId()){
                setTheme(R.style.Dark_Theme_LangLearn);
                saveChoice(true);
            }

        });
    }

    private void saveChoice(boolean isDark) {
        SharedPreferences.Editor editor = themPref.edit();
        editor.putBoolean("isDark", isDark).apply();
        }

    public void openMain(View v) {
        Intent showMain = new Intent(this, MainActivity.class);
        startActivity(showMain);
    }
}
