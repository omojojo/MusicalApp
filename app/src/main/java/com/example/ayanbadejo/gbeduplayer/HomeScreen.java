package com.example.ayanbadejo.gbeduplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class HomeScreen extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //Create a list view variable root
    ListView root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_home_screen);
        Toolbar toolbar = findViewById (R.id.toolbar);
        setSupportActionBar (toolbar);

        //create a list of words
        ArrayList<Songs> songs = new ArrayList<> ();

        songs.add (new Songs ("Korede Bello ", "Favorite Song", R.drawable.korede, "3:18", "1"));
        songs.add (new Songs ("Dj Consequence ft Sammylee_iyanya", "Body on me", R.drawable.dj, "4:10", "2"));
        songs.add (new Songs ("Duncan Mighty ft Wiz kid ", "Fake Love", R.drawable.duncan, "3:39", "3"));
        songs.add (new Songs ("Iyanya", "Good Vibes", R.drawable.iyanya, "3:54", "4"));
        songs.add (new Songs ("Kizz Daniel", "Yeba", R.drawable.kizz, "4:18", "5"));
        songs.add (new Songs ("Teni", "Wait", R.drawable.teni, "3:28", "6"));
        songs.add (new Songs ("Wiz Kid", "Manya", R.drawable.wiz, "3:30", "7"));
        songs.add (new Songs ("Davido", "Assurance", R.drawable.davido, "4:12", "8"));
        songs.add (new Songs ("DJ Big N ft Reekado bank", "i am in love", R.drawable.big, "3:51", "9"));
        songs.add (new Songs ("Dija", "Aww", R.drawable.dija, "3:01", "10"));

        //find the root View by id
        root = findViewById (R.id.rootView);
        // create an adapter object and input the context and the songs object
        SongAdapter adapter = new SongAdapter (this, songs);
        //Allow the listView (root) make use of the arrayAdapter by calling the setAdapter method and passing the argument Adapter
        root.setAdapter (adapter);

        // set on item click listener on the list view root
        root.setOnItemClickListener (new AdapterView.OnItemClickListener () {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //create an home intent object to move to the mediaPlayer activity
                Intent HomeIntent = new Intent (HomeScreen.this, MediaPlayer.class);
                startActivity (HomeIntent);
                finish ();
            }
        });

        FloatingActionButton fab = findViewById (R.id.fab);
        fab.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (HomeScreen.this, AllSongs.class);
                startActivity (i);
                finish ();
                Snackbar.make (view, "Music Now Playing", Snackbar.LENGTH_LONG)
                        .setAction ("Action", null).show ();
            }
        });

        DrawerLayout drawer = findViewById (R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle (
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener (toggle);
        toggle.syncState ();

        NavigationView navigationView = findViewById (R.id.nav_view);
        navigationView.setNavigationItemSelectedListener (this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById (R.id.drawer_layout);
        if (drawer.isDrawerOpen (GravityCompat.START)) {
            drawer.closeDrawer (GravityCompat.START);
        } else {
            super.onBackPressed ();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater ().inflate (R.menu.home_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId ();
        int id1 = item.getItemId ();
        int id2 = item.getItemId ();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search && id1 == R.id.action_library && id2 == R.id.action_videos) {
            return true;
        }

        return super.onOptionsItemSelected (item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId ();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById (R.id.drawer_layout);
        drawer.closeDrawer (GravityCompat.START);
        return true;
    }
}
