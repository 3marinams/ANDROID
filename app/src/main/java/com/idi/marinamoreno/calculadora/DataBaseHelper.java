package com.idi.marinamoreno.calculadora;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "contacts.db";
    private static final String TABLE_NAME = "contacts";
    //private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASS = "pass";
    private static final String COLUMN_INTENTS = "intents";
    SQLiteDatabase db;


    private static final String TABLE_CREATE = "CREATE TABLE " +  TABLE_NAME + " ( "
            + COLUMN_NAME + " TEXT PRIMARY KEY , "
            + COLUMN_USERNAME + " TEXT NOT NULL, "
            + COLUMN_PASS + " TEXT NOT NULL, "
            + COLUMN_INTENTS + " INTEGER "
            + " );" ;

    private String[] allColumns = {
            COLUMN_NAME,
            COLUMN_USERNAME,
            COLUMN_PASS,
            COLUMN_INTENTS};




    public DataBaseHelper(Context context){
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


    public void insertContact(Contact c){
        Log.v("DATABASHELEPER", "INSERT CONTACT");

        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_NAME, c.getName());
        Log.v ( "DATA INSERT", c.getName());
        values.put(COLUMN_USERNAME, c.getUsername());
        Log.v ( "DATA INSERT", COLUMN_USERNAME);
        values.put(COLUMN_PASS, c.getPassword());
        Log.v ( "DATA INSERT", COLUMN_PASS);
        values.put(COLUMN_INTENTS, c.getIntents());
        //Log.v ( "DATA INSERT", COLUMN_INTENTS);

        db.insert(TABLE_NAME,null,values);
        db.close();
    }

    public String searchPass(String uname){

        Cursor cursor = getReadableDatabase().query(TABLE_NAME, allColumns, COLUMN_USERNAME + "= '" + uname + "'",null, null, null,null);

        String p = "";

        if(cursor != null){
            cursor.moveToFirst();
            p = cursor.getString(cursor.getColumnIndex(COLUMN_PASS));
        }
        // make sure to close the cursor
        cursor.close();
        return p;

    }

    public List<Contact> getAllContactsOrdByIntents() {
        List<Contact> contacts = new ArrayList<>();

        Cursor cursor = getReadableDatabase().query(TABLE_NAME, allColumns, null,null, null, null,COLUMN_INTENTS + " ASC");

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Contact c = cursorToContact(cursor);
            contacts.add(c);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return contacts;
    }
    private Contact cursorToContact(Cursor cursor) {
        Contact c = new Contact();
        c.setName(cursor.getString(0));
        c.setUsername(cursor.getString(1));
        c.setPassword(cursor.getString(2));
        c.setIntents(cursor.getInt(3));
        return c;
    }
}