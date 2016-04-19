package com.oz.travelmeter;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CheckInsActivity extends AppCompatActivity {

    Context context=this;
    UserDbHelper userDbHelper;
    SQLiteDatabase sqLiteDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_ins);
       Log.e("saas","sdsa");

    }



    public void onBtnSave(View v){


        Cursor cursor;
        UserDbHelper dbHelper=new UserDbHelper(getApplicationContext());
        TextView res=(TextView)findViewById(R.id.showresult);


        EditText elocation=(EditText)findViewById(R.id.getLocation);
        EditText estay=(EditText)findViewById(R.id.getStay);
        EditText edoing=(EditText)findViewById(R.id.getDoing);
        EditText edate=(EditText)findViewById(R.id.getDate);
        EditText etime=(EditText)findViewById(R.id.getTime);

        String location=elocation.getText().toString();
        String stay=estay.getText().toString();
        String doing=edoing.getText().toString();
        String dayfinal=edate.getText().toString();
        String timefinal=etime.getText().toString();

        userDbHelper=new UserDbHelper(context);
        sqLiteDatabase = userDbHelper.getReadableDatabase();
        userDbHelper.addInformations(location, stay, doing,dayfinal,timefinal, sqLiteDatabase);
        Toast.makeText(getBaseContext(), "datasavaed", Toast.LENGTH_LONG).show();
        userDbHelper.close();

        sqLiteDatabase=dbHelper.getReadableDatabase();
        Log.e("sql", "conected");
        cursor= dbHelper.getInformation(sqLiteDatabase);

        Log.e("cursor", "set");
        if (cursor.moveToFirst()) {
            do {

                String location1, stay1, doing1,date1,time1;
                location1 = cursor.getString(0);
                stay1 = cursor.getString(1);
                doing1 = cursor.getString(2);
                date1=cursor.getString(3);
                time1=cursor.getString(4);
                Log.e("data", "fetched");

                res.setText("You are in "+location1+" at "+stay1+" doing "+doing1+" DATE= "+date1+" TIME="+time1);


            } while ((cursor.moveToNext()));

        }
    }

        public void onBtnHome(View v){

            Intent intent=new Intent(this,MainMenuActivity.class);
            startActivity(intent);
        }


}
