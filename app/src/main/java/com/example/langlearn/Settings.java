package com.example.langlearn;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Settings extends MainActivity {
    private RadioGroup group;
    private RadioButton darkRadio;
    private RadioButton defaultRadio;

    private static boolean recreated = false;

    /** ALL WORK IN PROGRESS, RECREATE() CAUSES INFINITE LOOP
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_settings);

        group = findViewById(R.id.themeRadioGroup);
        darkRadio = findViewById(R.id.darkRadio);
        defaultRadio = findViewById(R.id.defaultRadio);

        group.setOnCheckedChangeListener((group, checkedId) -> {
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
        SharedPreferences choice = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = choice.edit();
        editor.putBoolean("isDark", isDark); //save the dark theme
        editor.apply();
        if (!recreated) {
            recreate();
            recreated = true;
        }
    }

    boolean loadChoice() {
        SharedPreferences choice;
        choice = getPreferences(MODE_PRIVATE);
        return choice.getBoolean("isDark", false);
    }

    public void openMain(View v) {
        Intent showMain = new Intent(this, MainActivity.class);
        startActivity(showMain);

    }
}
