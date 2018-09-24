package com.example.ayanbadejo.gbeduplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MediaPlayer extends AppCompatActivity {
    //create an image view variable
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_media_player);
        // assign the back variable to the image view object
        back=findViewById (R.id.back);
        // set on click listener on the variable and create an intent object to move to the home screen activity
        back.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent HomeIntent  = new Intent(MediaPlayer.this, HomeScreen.class );
                startActivity(HomeIntent);
                finish();
            }
        });
    }
}
