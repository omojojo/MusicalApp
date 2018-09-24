package com.example.ayanbadejo.gbeduplayer;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

public class SongAdapter extends ArrayAdapter<Songs> {

    //create variables for each Views
    protected TextView name;
    protected TextView number;
    protected TextView duration;
    protected ImageView imageView;

    //Initialize the ArrayAdapter's internal storage context and pass the array list and its class songs .
    // going to use this second argument, so it can be any value. Here, we used 0.
    SongAdapter(Activity context, ArrayList<Songs> songs) {
        super (context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // inflate the view if the existing view is not reused
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from (getContext ()).inflate (
                    R.layout.list_item_layout, parent, false);
        }
        // Get the object located at this position in the list
        Songs currentSong = getItem (position);

        //Assign the variable created to each view Objects
        name = listItemView.findViewById (R.id.Artist_name);
        number = listItemView.findViewById (R.id.number);
        duration = listItemView.findViewById (R.id.Duration);
        imageView = listItemView.findViewById (R.id.img);
        TextView songName = listItemView.findViewById (R.id.song_name);
        name.setText (Objects.requireNonNull (currentSong).getArtistNames ());

        /*set the variables to each views
         Get the variables from the current songs object
        */
        number.setText (Objects.requireNonNull (currentSong).getSerialNumber ());
        songName.setText (Objects.requireNonNull (currentSong).getArtistSongs ());
        duration.setText (Objects.requireNonNull (currentSong).getDuration ());
        imageView.setImageResource (Objects.requireNonNull (currentSong).getImageId ());

        /* Return the whole list layout
         so that it can be shown in the ListView
         */
        return listItemView;
    }
}
