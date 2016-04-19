package com.oz.travelmeter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ojesh on 1/5/2016.
 */
public class MyDBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "placesDB.db";
    public static final String TABLE_PLACES = "places";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_PLACENAME = "placesname";

     //We need to pass database information along to superclass
            public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, DATABASE_NAME, factory, DATABASE_VERSION);
         }

    @Override
     public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_PLACES + "(" +
        COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
        COLUMN_PLACENAME + " TEXT " +
        ");";
        db.execSQL(query);
         }

     @Override
     public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PLACES);
        onCreate(db);
         }

     //Add a new row to the database
            public void addProduct(Places places){
            ContentValues values = new ContentValues();
             values.put(COLUMN_PLACENAME, places.get_placesname());
             SQLiteDatabase db = getWritableDatabase();
            db.insert(TABLE_PLACES, null, values);
            db.close();
             }

    //Delete a product from the database
            public void deleteProduct(String productName){
            SQLiteDatabase db = getWritableDatabase();
            db.execSQL("DELETE FROM " + TABLE_PLACES + " WHERE " + COLUMN_PLACENAME + "=\"" + productName + "\";");
             }

        public String databaseToString(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_PLACES + " WHERE 1";

         //Cursor points to a location in your results
         Cursor c = db.rawQuery(query, null);
        //Move to the first row in your results
         c.moveToFirst();

         //Position after the last row means the end of the results
         while (!c.isAfterLast()) {
           if (c.getString(c.getColumnIndex("placename")) != null) {
                 dbString += c.getString(c.getColumnIndex("placename"));
                dbString += "\n";
                 }
            c.moveToNext();
            }
         db.close();
        return dbString;
         }

}
