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

        Button category1Button = (Button) findViewById(R.id.Category1Button);
        category1Button.setOnClickListener(this);

        Button category2Button = (Button) findViewById(R.id.Category2Button);
        category2Button.setOnClickListener(this);

        Button category3Button = (Button) findViewById(R.id.Category3Button);
        category3Button.setOnClickListener(this);

        Button backButton = (Button) findViewById(R.id.BackButton);
        backButton.setOnClickListener(this);
        }
        //find which language was chosen
        Intent Source = this.getIntent();
        int SelectedLanguage = Source.getIntExtra("LanguageChosen", 0);

@Override
public void onClick(View view) { //open new activity based on button clicked
        if (view.getId() == R.id.BackButton){
                Intent backToMain = new Intent(this, MainActivity.class);
                startActivity(backToMain);

        } else if (view.getId() == R.id.Category1Button) {
                Intent langMenu = new Intent(this, categorySelectMenu.class);

                //send the selected language and category
                langMenu.putExtra("SelectedLanguage", SelectedLanguage);
                langMenu.putExtra("SelectedCategory",1);
                startActivity(langMenu);

        } else if (view.getId() == R.id.Category2Button) {
                Intent langMenu = new Intent(this, categorySelectMenu.class);
                langMenu.putExtra("SelectedLanguage", SelectedLanguage);
                langMenu.putExtra("SelectedCategory",2);
                startActivity(langMenu);

        } else if (view.getId() == R.id.Category3Button) {
                Intent langMenu = new Intent(this, categorySelectMenu.class);
                langMenu.putExtra("SelectedLanguage", SelectedLanguage);
                langMenu.putExtra("SelectedCategory",3);
                startActivity(langMenu);

        } else if (view.getId() == R.id.Category4Button) {
                Intent langMenu = new Intent(this, categorySelectMenu.class);
                langMenu.putExtra("SelectedLanguage", SelectedLanguage);
                langMenu.putExtra("SelectedCategory",4);

                startActivity(langMenu);
        }
    }

}
