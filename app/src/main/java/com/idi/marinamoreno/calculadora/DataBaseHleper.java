package com.idi.marinamoreno.calculadora;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DataBaseHleper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "contacts.db";
    private static final String TABLE_NAME = "contacts";
    //private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASS = "pass";
    SQLiteDatabase db;


    private static final String TABLE_CREATE = "CREATE TABLE " +  TABLE_NAME + " ( "
            + COLUMN_NAME + " TEXT PRIMARY KEY , "
            + COLUMN_EMAIL + " TEXT, "
            + COLUMN_USERNAME + " TEXT NOT NULL, "
            + COLUMN_PASS + " TEXT NOT NULL "
            + " );" ;




    public DataBaseHleper (Context context){
        //constructora
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        db.execSQL(TABLE_NAME);
        //this.onCreate(db);
    }


    /*@Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(STATISTICS_TABLE_CREATE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + STATISTICS_TABLE_NAME);
        db.execSQL(STATISTICS_TABLE_CREATE);
    }*/

    public void insertContact(Contact c){
        Log.v("DATABASHELEPER", "INSERT CONTACT");

        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        //String query = "(SELECT * FROM contacts);";
        //Cursor cursor = db.rawQuery(query, null);
        //int count = cursor.getCount();

        //values.put(COLUMN_ID,null);

        //db.execSQL("UPDATE " + TABLE_NAME + " SET " + COLUMN_NAME + "," + COLUMN_EMAIL + "," + COLUMN_USERNAME  + "," + COLUMN_PASS + ";");

        values.put(COLUMN_NAME, c.getName());
        Log.v ( "DATA INSERT", c.getName());
        values.put(COLUMN_EMAIL, c.getEmail());
        Log.v ( "DATA INSERT", COLUMN_EMAIL);
        values.put(COLUMN_USERNAME, c.getUsername());
        Log.v ( "DATA INSERT", COLUMN_USERNAME);
        values.put(COLUMN_PASS, c.getPassword());
        Log.v ( "DATA INSERT", COLUMN_PASS);

        db.insert(TABLE_NAME,null,values);
        db.close();
    }

    public String searchPass(String uname, String password){

        Cursor cursor = getReadableDatabase().rawQuery("SELECT "+COLUMN_USERNAME+ " FROM "+TABLE_NAME+" WHERE "+COLUMN_USERNAME+"='" + uname + "' and "+COLUMN_PASS+" ='" + password + "';", null);
        String b;
        b = "";
        if (cursor.moveToFirst()){
            do{
                b = cursor.getString(cursor.getColumnIndex(COLUMN_USERNAME));
            }
            while(cursor.moveToNext());

        }
        //db.close();//<-db aqui no te perquè estar oberta aixi que peta al fer el close

        if (b == "") return "not found";
        else return b;
    }
}