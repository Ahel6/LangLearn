package com.example.langlearn;


import androidx.appcompat.app.AppCompatActivity;

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

@Override
public void onClick(View view) {
        if (view.getId() == R.id.BackButton){
                Intent backToMain = new Intent(this, MainActivity.class);
                startActivity(backToMain);
        /**
        } else if (view.getId() == R.id.openLanguage1) {
                Intent langMenu = new Intent(this, categorySelectMenu.class);
        startActivity(langMenu);
        } else if (view.getId() == R.id.openLanguage2) {
                Intent langMenu = new Intent(this, categorySelectMenu.class);
                startActivity(langMenu);
        } else if (view.getId() == R.id.openLanguage3) {
                Intent langMenu = new Intent(this, categorySelectMenu.class);
                startActivity(langMenu);
        }
         **/
    }

}
}