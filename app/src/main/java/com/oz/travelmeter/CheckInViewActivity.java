package com.oz.travelmeter;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CheckInViewActivity extends AppCompatActivity {

    String location, stay, doing, date,time;
    int i=0;
    int j=0;
    String res=" ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in_view);
    }
    public void onfinal(View v) {
        TextView t=(TextView)findViewById(R.id.finaloutput);
        List<Contact> cl = new ArrayList<>();
        String query = " SELECT * FROM " + UserContract.NewUserInfo.TABLE_NAME;

        UserDbHelper userDbHelper = new UserDbHelper(getApplicationContext());
        SQLiteDatabase sqLiteDatabase = userDbHelper.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Contact contact=new Contact(location,stay,doing,date,time);
                contact.setLocation(cursor.getString(0));
                contact.setStay(cursor.getString(1));
                contact.setDoing(cursor.getString(2));
                contact.setDate(cursor.getString(3));
                contact.setTime(cursor.getString(4));

                Log.e("moved", "sad and moved");
                res=res+"You were in "+cursor.getString(0)+" at "+cursor.getString(1)+" doing "+cursor.getString(2)+
                        " DATE:"+cursor.getString(3)+" Time"+cursor.getString(4)+"\n";

            } while (cursor.moveToNext());

            t.setText(res);


        }
    }

        public void onBtnHome1(View v){
            Intent in1=new Intent(this,MainMenuActivity.class);
            startActivity(in1);
        }

}
