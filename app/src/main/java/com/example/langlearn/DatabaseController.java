package com.example.langlearn;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/** Template for database creation/data addition used:
 *  https://www.geeksforgeeks.org/how-to-create-and-add-data-to-sqlite-database-in-android/
 */

public class DatabaseController extends SQLiteOpenHelper {

    //database details
    private static String DBName = "Languages";
    private static int DBVersion = 1;
    //table details
    private static String languageName = "langaugeName";
    private static String ID = "ID";
    private static String langWord = "langWord";
    private static String englishWord = "englishWord";

    //Controller constructor
    public DatabaseController(Context context) {
        super(context, DBName, null, DBVersion);
    }


    @Override //create table with column names
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE "
                + languageName + " ("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + langWord + " TEXT,"
                + englishWord + " TEXT)";

        db.execSQL(query);
    }

    /** Add data to the database
     *
     * @param languageName Name of table for the word being added to
     * @param langWord Translated word to add
     * @param englishWord english translation
     */
    public void addData(String languageName, String langWord, String englishWord){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(langWord, langWord); //in column X put Y
        values.put(englishWord, englishWord);

        db.insert(languageName, null, values);//put the added values (above) in the table

        db.close();//close database
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + languageName); //if the table already exists, don't create a new one
    }
}