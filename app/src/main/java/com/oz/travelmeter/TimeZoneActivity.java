package com.oz.travelmeter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class TimeZoneActivity extends AppCompatActivity {

    double offset1=0;
    double offset2=0;
    double offset2back=0;
    double offset1back=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_zone);
    }

    public void onbtnConvert(View v) {
        Spinner spnt = (Spinner) findViewById(R.id.spinnerto);
        Spinner spnf = (Spinner) findViewById(R.id.spinnerfrom);

        String to = spnt.getSelectedItem().toString();
        String from = spnf.getSelectedItem().toString();
        TextView ans = (TextView) findViewById(R.id.output);

        EditText uday = (EditText) findViewById(R.id.userDay);
        EditText umonth = (EditText) findViewById(R.id.userMonth);
        EditText uyear = (EditText) findViewById(R.id.userYear);
        EditText uhour = (EditText) findViewById(R.id.userHour);
        EditText umin = (EditText) findViewById(R.id.usermin);

        if (to.equals("Australia")) {

            offset1 = 11;
            offset1back = 0;
        }
        if (to.equals("Bangladesh")) {

            offset1 = 6;
            offset1back = 0;
        }

        if (to.equals("India")) {

            offset1 = 5;
            offset1back = 30;
        }
        if (to.equals("Japan")) {

            offset1 = 9;
            offset1back = 0;
        }
        if (to.equals("Korea")) {

            offset1 = 9;
            offset1back = 0;
        }
        if (to.equals("Nepal")) {

            offset1 = 5;
            offset1back = 45;
        }
        if (to.equals("Pakistan")) {

            offset1 = 5;
            offset1back = 0;
        }
        if (to.equals("USA")) {

            offset1 = -8;
            offset1back = 0;
        }

        if (from.equals("Australia")) {

            offset2 = 11;
            offset2back = 0;
        }
        if (from.equals("Bangladesh")) {

            offset2 = 6;
            offset2back = 0;
        }

        if (from.equals("India")) {

            offset2 = 5;
            offset2back = 30;
        }
        if (from.equals("Japan")) {

            offset2 = 9;
            offset2back = 0;
        }
        if (from.equals("Korea")) {

            offset2 = 9;
            offset2back = 0;
        }
        if (from.equals("Nepal")) {

            offset2 = 5;
            offset2back = 45;
        }
        if (from.equals("Pakistan")) {

            offset2 = 5;
            offset2back = 0;
        }
        if (from.equals("USA")) {

            offset2 = -8;
            offset2back = 0;
        }

        int year = Integer.parseInt(uyear.getText().toString());
        int month = Integer.parseInt(umonth.getText().toString());
        int day = Integer.parseInt(uday.getText().toString());
        int hour = Integer.parseInt(uhour.getText().toString());
        int min = Integer.parseInt(umin.getText().toString());

        int newhr= (int) (hour+offset1-offset2);
        int newmin=(int)(min+offset1back-offset2back);

        double monthrim=month%12;
        double monthquo=month/12;

        double dayrim=day%30;
        double dayquo=day/30;

        double hourrim=newhr%24;
        double hourquo=newhr/24;


        double minquo=newmin/60;




        if(newmin>=60&&newhr>=24&&day>=30&&month>=12) {
            ans.setText("and Today is:" + day+hourquo+monthrim + "-" + +dayquo+month+hourquo + "-" +monthquo+year + "and time is " +newhr+dayrim+minquo + "hr -" + newmin+hourrim+"min in:"+to);
        }
        else if (newhr>=24&&day>=30&&month>=12){
            ans.setText("and Today is:" + day+hourquo+monthrim + "-" + month+hourquo +hourquo +"-" + year+monthquo + "and time is " +newhr+dayrim + "hr -" + newmin+hourrim+"min in:"+to);
        }
        else if (day>=30&&month>=12)
        {
            ans.setText("and Today is:" + day+monthrim + "-" + month +dayquo+ "-" + year +monthquo+ "and time is " +newhr+dayrim + "hr -" + newmin+"min in:"+to);
        }else if(month>=12){

            ans.setText("and Today is:" + day+monthrim + "-" + month + "-" + year +monthquo+ "and time is " +newhr + "hr -" + newmin+"min in"+to);

        }
        else{
            ans.setText("and Today is:" + day + "-" + month + "-" + year + " and time is " +newhr + "hr -" + newmin+"min in:"+to);
        }

    }




    public void onbtnHome1(View v) {

        Intent intent = new Intent(this, MainMenuActivity.class);
        startActivity(intent);
    }
}
