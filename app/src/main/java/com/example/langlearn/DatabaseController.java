package com.example.langlearn;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/** Template for database creation/data addition used:
 *  <a href="https://www.geeksforgeeks.org/how-to-create-and-add-data-to-sqlite-database-in-android/">...</a>
 */

public class DatabaseController extends SQLiteOpenHelper {

    //database details
    private static final String DBName = "Languages";
    private static final int DBVersion = 1;

    //table details
    private String ID = "ID"; //
    private final String ColumnLangWord = "LangWord"; //column name
    private final String ColumnEnglishWord = "EnglishWord"; //column name

    //Controller constructor
    public DatabaseController(Context theContext) {
        super(theContext, DBName, null, DBVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = " ("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ColumnLangWord + " TEXT,"
                + ColumnEnglishWord + " TEXT)";

        //create Tables
        db.execSQL("CREATE TABLE " + "French" + query);
        db.execSQL("CREATE TABLE " + "Spanish" + query);

    }

    /** Add data to the database
     *
     * @param languageName Name of table for the word being added to
     * @param langWord Translated word to add
     * @param englishWord english translation
     */
    public void populate(String languageName, String langWord, String englishWord){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(ColumnLangWord, langWord); //in column X, put Y
        values.put(ColumnEnglishWord, englishWord);

        //values.put(ID, 1);
        //values.put(ColumnLangWord, "French test"); //in column X, put Y
        //values.put(ColumnEnglishWord, "englishWord");

        db.insert(languageName, null, values);//put the added values (above) in the table

        db.close();//close database
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + "French"); //if the table already exists, Drop and make a new one
        db.execSQL("DROP TABLE IF EXISTS " + "Spanish");
    }
}