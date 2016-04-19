package com.oz.travelmeter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

/**
 * Created by Ojesh on 1/5/2016.
 */
public class  MainMenuActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu_activity);
    }
    public void ClickMaps(View view){
        Intent startMapsActivity= new Intent(MainMenuActivity.this, MapsActivity.class);
        startActivity(startMapsActivity);

    }
    public void ClickPlacePicker(View view){
        Intent startPlacePicker =new Intent(MainMenuActivity.this,MainActivity.class);
        startActivity(startPlacePicker);
    }
    public void ClickCheckins(View view){
        Intent startCheckins =new Intent(MainMenuActivity.this,CheckInsActivity.class);
        startActivity(startCheckins);
    }
    public void ClickViewcheckins(View view){
        Intent startCheckins =new Intent(MainMenuActivity.this,CheckInViewActivity.class);
        startActivity(startCheckins);
    }

    public void ClickTzc(View view){
        Intent startCheckins =new Intent(MainMenuActivity.this,TimeZoneActivity.class);
        startActivity(startCheckins);
    }


}
