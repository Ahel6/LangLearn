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

        Button GreetingsButton = (Button) findViewById(R.id.GreetingsButton);
        GreetingsButton.setOnClickListener(this);

        Button NumbersButton = (Button) findViewById(R.id.NumbersButton);
        NumbersButton.setOnClickListener(this);

        Button FoodDrinkButton = (Button) findViewById(R.id.FoodDrinkButton);
        FoodDrinkButton.setOnClickListener(this);

        Button HelpButton = (Button) findViewById(R.id.HelpButton);
        HelpButton.setOnClickListener(this);

        Button backButton = (Button) findViewById(R.id.BackButton);
        backButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) { //open new activity based on button clicked

        //get the language chosen in main menu
        String SelectedLanguage;
        Bundle Extras = getIntent().getExtras();
        assert Extras != null;
        SelectedLanguage = Extras.getString("LanguageKey");

        if (view.getId() == R.id.BackButton) {
            Intent backToMain = new Intent(this, MainActivity.class);
            startActivity(backToMain);

        } else if (view.getId() == R.id.GreetingsButton) {
            Intent langMenu = new Intent(this, categorySelectMenu.class);

            //send the selected language and category
            langMenu.putExtra("SelectedLanguage", SelectedLanguage);
            langMenu.putExtra("SelectedCategory", "Greeting");
            startActivity(langMenu);

        } else if (view.getId() == R.id.NumbersButton) {
            Intent langMenu = new Intent(this, categorySelectMenu.class);
            langMenu.putExtra("SelectedLanguage", SelectedLanguage);
            langMenu.putExtra("SelectedCategory", "Number");
            startActivity(langMenu);

        } else if (view.getId() == R.id.FoodDrinkButton) {
            Intent langMenu = new Intent(this, categorySelectMenu.class);
            langMenu.putExtra("SelectedLanguage", SelectedLanguage);
            langMenu.putExtra("SelectedCategory", "Food");
            startActivity(langMenu);

        } else if (view.getId() == R.id.HelpButton) {
            Intent langMenu = new Intent(this, categorySelectMenu.class);
            langMenu.putExtra("SelectedLanguage", SelectedLanguage);
            langMenu.putExtra("SelectedCategory", "Help");

            startActivity(langMenu);
        }
    }

}
