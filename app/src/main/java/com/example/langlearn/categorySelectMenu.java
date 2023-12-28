package com.example.langlearn;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class categorySelectMenu extends MainActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //set theme
        themePref = getSharedPreferences("themePicked", Context.MODE_PRIVATE);
        boolean isDark = themePref.getBoolean("isDark", false);
        Log.println(Log.VERBOSE, "isDark value", String.valueOf(isDark));

        if (isDark){
            setTheme(R.style.Dark_Theme_LangLearn);
        }else{
            setTheme(R.style.Base_Theme_LangLearn);
        }

        setContentView(R.layout.activity_category_select_menu);

        Button GreetingsButton = findViewById(R.id.GreetingsButton);
        GreetingsButton.setOnClickListener(this);

        Button NumbersButton = findViewById(R.id.NumbersButton);
        NumbersButton.setOnClickListener(this);

        Button FoodDrinkButton = findViewById(R.id.FoodDrinkButton);
        FoodDrinkButton.setOnClickListener(this);

        Button HelpButton = findViewById(R.id.HelpButton);
        HelpButton.setOnClickListener(this);

        Button backButton = findViewById(R.id.BackButton);
        backButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) { //open new activity based on button clicked
        Intent LearningActivity = new Intent(this, LearningActivity.class);

        //get the language chosen in main menu
        String SelectedLanguage;
        Bundle Extras = getIntent().getExtras();
        assert Extras != null;
        SelectedLanguage = Extras.getString("LanguageChosen");
        LearningActivity.putExtra("LanguageChosen", SelectedLanguage);

        if (view.getId() == R.id.BackButton) {
            Intent backToMain = new Intent(this, MainActivity.class);
            startActivity(backToMain);

        } else if (view.getId() == R.id.GreetingsButton) {
            LearningActivity.putExtra("SelectedCategory", "Greeting");
            startActivity(LearningActivity);

        } else if (view.getId() == R.id.NumbersButton) {
            LearningActivity.putExtra("SelectedCategory", "Number");
            startActivity(LearningActivity);

        } else if (view.getId() == R.id.FoodDrinkButton) {
            LearningActivity.putExtra("SelectedCategory", "Food");
            startActivity(LearningActivity);

        } else if (view.getId() == R.id.HelpButton) {
            LearningActivity.putExtra("SelectedCategory", "Help");
            startActivity(LearningActivity);
        }
    }

}
