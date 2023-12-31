package com.example.langlearn;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DatabaseController extends SQLiteOpenHelper {
    //database details
    private static final String DBName = "Languages";
    private static final int DBVersion = 1;
    private final Context context;


    //Controller constructor
    public DatabaseController(Context context) {
        super(context, DBName, null, DBVersion);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String ID = "ID"; //
        final String ColumnLangWord = "LangWord"; //column name
        final String ColumnEnglishWord = "EnglishWord"; //column name
        final String ColumnClass = "Class"; //

        //create tables
        final String query = " ("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ColumnEnglishWord + " TEXT,"
                + ColumnLangWord + " TEXT,"
                + ColumnClass + " TEXT)";

        //create Tables
        db.execSQL("CREATE TABLE " + "French" + query);
        db.execSQL("CREATE TABLE " + "Spanish" + query);


        //read and insert from CSV
        //https://stackoverflow.com/questions/16672074/import-csv-file-to-sqlite-in-android
        String[] Languages = new String[]{"French", "Spanish"};

        //create new ISR based on language files (specified above)
        for (String item : Languages) {
            InputStreamReader ISR;
            try { //open csv
                ISR = new InputStreamReader(context.getAssets().open(item + ".csv"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            BufferedReader buffer = new BufferedReader(ISR);
            String line;
            db.beginTransaction();
            try {
                while ((line = buffer.readLine()) != null) {

                    //when encountering a comma, split the string
                    String[] columns = line.split(",");
                    ContentValues Values = new ContentValues();
                    //inserts each column from .split() into the table
                    Values.put(ColumnLangWord, columns[0].trim());
                    Values.put(ColumnEnglishWord, columns[1].trim());
                    Values.put(ColumnClass, columns[2].trim());
                    db.insert(item, null, Values);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            db.setTransactionSuccessful();
            db.endTransaction();
        }
    }

    /**
     * Return the list of english words from the chosen category
     *
     * @param ChosenLanguage - language selected in main activity
     * @param ChosenCategory - language selected in categorySelectMenu activity
     * @return returns the populated arraylist
     */
    public ArrayList<String> getEnglish(String ChosenLanguage, String ChosenCategory) {

        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<String> engWordsArr = new ArrayList<>();

        Cursor getterCursor = db.query(ChosenLanguage, new String[]{"EnglishWord"},
                ("Class= " + "'" + ChosenCategory + "'"),
                null, null, null, null, null);

        //Check if cursor not empty
        if (getterCursor.moveToFirst()) {
            do {
                engWordsArr.add(getterCursor.getString(0));
            } while (getterCursor.moveToNext());
        }
        getterCursor.close();
        return engWordsArr;
    }

    public ArrayList<String> getForeign(String ChosenLanguage, String ChosenCategory) {

        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<String> langWordsArr = new ArrayList<>();

        Cursor getterCursor = db.query(ChosenLanguage, new String[]{"LangWord"},
                ("Class= " + "'" + ChosenCategory + "'"),
                null, null, null, null, null);

        //Check if cursor not empty
        if (getterCursor.moveToFirst()) {
            do {
                langWordsArr.add(getterCursor.getString(0));
            } while (getterCursor.moveToNext());
        }
        getterCursor.close();
        return langWordsArr;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + "French");
        db.execSQL("DROP TABLE IF EXISTS " + "Spanish");

    }
}
