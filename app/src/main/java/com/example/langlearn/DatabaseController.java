package com.example.langlearn;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



/** Template for database creation/data addition used:
 *  <a href="https://www.geeksforgeeks.org/how-to-create-and-add-data-to-sqlite-database-in-android/">...</a>
 */

public class DatabaseController extends SQLiteOpenHelper {

    //database details
    private static final String DBName = "Languages";
    private static final int DBVersion = 1;

    //table details
    private final String ID = "ID"; //
    private final String ColumnLangWord = "LangWord"; //column name
    private final String ColumnEnglishWord = "EnglishWord"; //column name
    private final String ColumnClass = "Class"; //

    private Context context;
    //Controller constructor
    public DatabaseController(Context context) {
        super(context, DBName, null, DBVersion);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //create tables
        String query = " ("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ColumnEnglishWord + " TEXT,"
                + ColumnLangWord + " TEXT,"
                + ColumnClass + " TEXT)";

        //create Tables
        db.execSQL("CREATE TABLE " + "French" + query);
        db.execSQL("CREATE TABLE " + "Spanish" + query);

        /** https://stackoverflow.com/questions/16672074/import-csv-file-to-sqlite-in-android **/

        //read and insert from CSV
        InputStreamReader ISR;
        try {
            ISR = new InputStreamReader(context.getAssets().open("FrenchWords.csv"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BufferedReader buffer = new BufferedReader(ISR);
        String line = "";
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
                db.insert("French", null, Values);
                Log.println(Log.VERBOSE, "Marker", "Entry inserted");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        db.setTransactionSuccessful();
        db.endTransaction();
        Log.println(Log.VERBOSE, "Marker", "Data Insertion Complete");

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + "French"); //if the table already exists, Drop and make a new one
        db.execSQL("DROP TABLE IF EXISTS " + "Spanish");

    }
}