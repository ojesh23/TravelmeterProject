package com.oz.travelmeter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by champa on 1/12/2016.
 */
public class UserDbHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME="USERdatabase_db";
    private  static final int DATABASE_VERSION=1;
    private static final String CREATE_QUERY=
            "CREATE TABLE "+ UserContract.NewUserInfo.TABLE_NAME+"("+ UserContract.NewUserInfo.USER_LOCATION+" TEXT,"+
                    UserContract.NewUserInfo.USER_STAY+" TEXT,"+ UserContract.NewUserInfo.USER_DOING+" TEXT,"+ UserContract.NewUserInfo.USER_DATE+" TEXT,"+ UserContract.NewUserInfo.USER_TIME+" TEXT);";




    public UserDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.e("DATABASE OPERATIONS", "DATABASE created/opened....");

    }

        @Override
    public void onCreate(SQLiteDatabase db) {

            db.execSQL(CREATE_QUERY);
            Log.e("db","table created");
    }


    public void addInformations( String location,String stay,String doing,String date,String time,SQLiteDatabase db){

        ContentValues contentValues=new ContentValues();
        contentValues.put(UserContract.NewUserInfo.USER_LOCATION,location);
        contentValues.put(UserContract.NewUserInfo.USER_STAY,stay);
        contentValues.put(UserContract.NewUserInfo.USER_DOING,doing);
        contentValues.put(UserContract.NewUserInfo.USER_DATE,date);
        contentValues.put(UserContract.NewUserInfo.USER_TIME,time);
        db.insert(UserContract.NewUserInfo.TABLE_NAME, null, contentValues);
        Log.e("db","1row is inserted");

    }
    public Cursor getInformation(SQLiteDatabase db) {
        Cursor cursor;
        String[] projection = {UserContract.NewUserInfo.USER_LOCATION, UserContract.NewUserInfo.USER_STAY,
                UserContract.NewUserInfo.USER_DOING, UserContract.NewUserInfo.USER_DATE, UserContract.NewUserInfo.USER_TIME};
        cursor = db.query(UserContract.NewUserInfo.TABLE_NAME, projection, null, null, null, null, null);
        Log.e("row", "is returned");
        return cursor;

    }
        @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
