package com.oz.travelmeter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Ojesh on 11/26/2015.
 */
public class Splashscreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(3000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent openmainactivity = new Intent("com.oz.travelmeter.MAINMENUACTIVITY");
                    startActivity(openmainactivity);
                }
            }
        };
        timer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}

