package com.example.ayanbadejo.gbeduplayer;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class WelcomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_welcome_screen);

        int SPLASH_TIME_OUT = 2000;
        new Handler ().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent HomeIntent  = new Intent(WelcomeScreen.this, HomeScreen.class );
                startActivity(HomeIntent);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
