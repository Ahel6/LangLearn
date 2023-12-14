package com.example.langlearn;

import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;
public class LearningActivity extends MainActivity {
    public int correctButton;

    private ArrayList langWordsArr;
    private ArrayList engWordsArr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learning_activity);

        //get selected language and category
        Bundle Extras = getIntent().getExtras();
        assert Extras != null;
        String SelectedLanguage = Extras.getString("LanguageChosen");
        String SelectedCategory = Extras.getString("SelectedCategory");

        this.setArrays(SelectedLanguage, SelectedCategory);

    }

    public void setArrays (String SelectedLanguage, String SelectedCategory){
        DatabaseController DBController = new DatabaseController(LearningActivity.this);
        DBController.getReadableDatabase();

        this.langWordsArr = (DBController.getForeign(SelectedLanguage,SelectedCategory));
        this.engWordsArr = (DBController.getEnglish(SelectedLanguage,SelectedCategory));
    }


    public void newQuestion(){
        //element assignment, buttons and text
        TextView foreignWord = findViewById(R.id.foreignWord);

        Button button1 = findViewById(R.id.LearnButton1);
        button1.setOnClickListener(this);

        Button button2 = findViewById(R.id.LearnButton2);
        button2.setOnClickListener(this);

        Button button3 = findViewById(R.id.LearnButton3);
        button3.setOnClickListener(this);

        Button button4 = findViewById(R.id.LearnButton4);
        button4.setOnClickListener(this);

            //get a random word from the foreign words array
            Random RandInt = new Random();
            int index = RandInt.nextInt(langWordsArr.size());
            Log.println(Log.INFO, "Marker", "Chosen index " + index); //print the chosen index
            String chosen = String.valueOf(langWordsArr.get(index));
            Log.println(Log.INFO, "Marker", "Chosen word " + chosen);

            //set the text based on selected element
            foreignWord.setText(chosen);
            switch(RandInt.nextInt(4)){//select random button for correct translation
                case 0:
                    button1.setText(String.valueOf(engWordsArr.get(index)));
                    correctButton = R.id.LearnButton1;
                    break;
                case 1:
                    button2.setText(String.valueOf(engWordsArr.get(index)));
                    correctButton = R.id.LearnButton2;
                    break;
                case 2:
                    button3.setText(String.valueOf(engWordsArr.get(index)));
                    correctButton = R.id.LearnButton3;
                    break;
                case 3:
                    button4.setText(String.valueOf(engWordsArr.get(index)));
                    correctButton = R.id.LearnButton4;
                    break;
        }
    }
    public void onClick(View view) {
        if (view.getId() == correctButton){
            view.setBackgroundColor(Color.GREEN);
            this.newQuestion();
        }else{
            view.setBackgroundColor(Color.RED);
        }

    }
    public void openMain(View v) {
        Intent showMain = new Intent(this, MainActivity.class);
        startActivity(showMain);

    }
}
