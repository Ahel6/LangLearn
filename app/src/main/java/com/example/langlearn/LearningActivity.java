package com.example.langlearn;

import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LearningActivity extends MainActivity {
    public int correctButton;

    boolean quesAnswered = false;
    private ArrayList langWordsArr;
    private ArrayList engWordsArr;

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private String SelectedLanguage;
    private String SelectedCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learning_activity);

        //get selected language and category
        Bundle Extras = getIntent().getExtras();
        assert Extras != null;
        this.SelectedLanguage = Extras.getString("LanguageChosen");
        this.SelectedCategory = Extras.getString("SelectedCategory");

        setArrays(SelectedLanguage, SelectedCategory);
        setButtons();
        newQuestion();

    }

    public void setArrays(String SelectedLanguage, String SelectedCategory) {
        DatabaseController DBController = new DatabaseController(LearningActivity.this);
        DBController.getReadableDatabase();

        this.langWordsArr = (DBController.getForeign(SelectedLanguage, SelectedCategory));
        this.engWordsArr = (DBController.getEnglish(SelectedLanguage, SelectedCategory));
    }

    public void setButtons() { //set the listeners and colours of buttons, called when a new question is generated

        this.button1 = findViewById(R.id.LearnButton1);
        button1.setBackgroundColor(Color.parseColor("#6363E1"));
        button1.setOnClickListener(this);

        this.button2 = findViewById(R.id.LearnButton2);
        button2.setBackgroundColor(Color.parseColor("#6363E1"));
        button2.setOnClickListener(this);

        this.button3 = findViewById(R.id.LearnButton3);
        button3.setBackgroundColor(Color.parseColor("#6363E1"));
        button3.setOnClickListener(this);

        this.button4 = findViewById(R.id.LearnButton4);
        button4.setBackgroundColor(Color.parseColor("#6363E1"));
        button4.setOnClickListener(this);
    }


    public void newQuestion() {
        this.setButtons();
        this.setArrays(SelectedLanguage, SelectedCategory); //used to reset the arrays
        quesAnswered = false;

        //element assignment, buttons and text
        TextView foreignWord = findViewById(R.id.foreignWord);
        //get a random word from the foreign words array
        Random RandInt = new Random();
        int index = RandInt.nextInt(langWordsArr.size());
        Log.println(Log.INFO, "Marker", "Chosen index " + index); //print the chosen index
        String chosen = String.valueOf(langWordsArr.get(index));
        Log.println(Log.INFO, "Marker", "Chosen word " + chosen);

        //set the text based on selected element
        foreignWord.setText(chosen);

        //select random button for correct translation, uses button ID to identify the correct answer
        int dontUse = 0;
        switch (RandInt.nextInt(4)) {
            case 0:
                button1.setText(String.valueOf(engWordsArr.get(index)));
                correctButton = R.id.LearnButton1;
                break;
            case 1:
                button2.setText(String.valueOf(engWordsArr.get(index)));
                correctButton = R.id.LearnButton2;
                dontUse = 1;
                break;
            case 2:
                button3.setText(String.valueOf(engWordsArr.get(index)));
                correctButton = R.id.LearnButton3;
                dontUse = 2;
                break;
            case 3:
                button4.setText(String.valueOf(engWordsArr.get(index)));
                correctButton = R.id.LearnButton4;
                dontUse = 3;
                break;
        }
        engWordsArr.remove(index); //word is removed so it doesn't get used to fill other buttons

        //iterate the 4 buttons, adding random words to all of them
        ViewGroup layout = (ViewGroup) findViewById(R.id.LearningButtons);
        for (int I = 0; I < layout.getChildCount(); I++) {
            if (I != dontUse) {
                index = RandInt.nextInt(engWordsArr.size());
                View child = layout.getChildAt(I);
                Button temp = (Button) child;
                temp.setText(String.valueOf(engWordsArr.get(index)));
                engWordsArr.remove(index);
            }
        }


    }

    public void onClick(View view) {
        if (!quesAnswered) { //if question hasn't been answered
            if (view.getId() == correctButton) {
                view.setBackgroundColor(Color.rgb(49, 173, 65));
                quesAnswered = true;
            } else {
                view.setBackgroundColor(Color.RED);
            }
        } else { //if answered, generate a new question
            newQuestion();
        }

    }

    public void openMain(View v) {
        Intent showMain = new Intent(this, MainActivity.class);
        startActivity(showMain);

    }
}
