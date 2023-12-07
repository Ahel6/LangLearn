package com.example.langlearn;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class categorySelectMenu extends MainActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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

        //get the language chosen in main menu
        String SelectedLanguage;
        Bundle Extras = getIntent().getExtras();
        assert Extras != null;
        SelectedLanguage = Extras.getString("LanguageKey");
        Intent StartActivity = new Intent(this, LearningActivity.class);
        StartActivity.putExtra("SelectedLanguage", SelectedLanguage);

        if (view.getId() == R.id.BackButton) {
            Intent backToMain = new Intent(this, MainActivity.class);
            startActivity(backToMain);

        } else if (view.getId() == R.id.GreetingsButton) {
            StartActivity.putExtra("SelectedCategory", "Greeting");
            startActivity(StartActivity);

        } else if (view.getId() == R.id.NumbersButton) {
            StartActivity.putExtra("SelectedCategory", "Number");
            startActivity(StartActivity);

        } else if (view.getId() == R.id.FoodDrinkButton) {
            StartActivity.putExtra("SelectedCategory", "Food");
            startActivity(StartActivity);

        } else if (view.getId() == R.id.HelpButton) {
            StartActivity.putExtra("SelectedCategory", "Help");
            startActivity(StartActivity);
        }
    }

}
