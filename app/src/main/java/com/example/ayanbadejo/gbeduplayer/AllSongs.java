package com.example.ayanbadejo.gbeduplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AllSongs extends AppCompatActivity {

    //create a text view variable
    TextView backAll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_all_songs);
        //assigned the variable to an id of the text view object
        backAll=findViewById (R.id.backPlay);
        //set onclick listener on the object
        backAll.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                //create an intent object to return to the previous activity
                Intent intent = new Intent (AllSongs.this,HomeScreen.class);
                startActivity (intent);
                finish ();
            }
        });
    }
}
