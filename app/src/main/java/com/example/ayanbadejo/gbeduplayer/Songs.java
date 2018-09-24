package com.example.ayanbadejo.gbeduplayer;

import android.os.Parcel;
import android.os.Parcelable;

public class Songs implements Parcelable {
    public static final Creator<Songs> CREATOR = new Creator<Songs> () {
        @Override
        public Songs createFromParcel(Parcel in) {
            return new Songs (in);
        }

        @Override
        public Songs[] newArray(int size) {
            return new Songs[size];
        }
    };
    // Create Variable for ArtName,artistSong, duration of play, serial Number And image
    private String artistNames;
    private String artistSongs;
    private String duration;
    private String serialNumber;
    private int imageId;

    //Create a new songs object by the constructor for each variables
    Songs(String artistNames, String artistSongs, int imageId, String duration, String serialNumber) {
        this.artistNames = artistNames;
        this.artistSongs = artistSongs;
        this.imageId = imageId;
        this.duration = duration;
        this.serialNumber = serialNumber;
    }

    private Songs(Parcel in) {
        artistNames = in.readString ();
        artistSongs = in.readString ();
        duration = in.readString ();
        serialNumber = in.readString ();
        imageId = in.readInt ();
    }

    //get the songs object from the variables
    public String getArtistNames() {
        return artistNames;
    }

    public String getArtistSongs() {
        return artistSongs;
    }

    public int getImageId() {
        return imageId;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * Describe the kinds of special objects contained in this Parcelable
     * instance's marshaled representation. For example, if the object will
     * include a file descriptor in the output of {@link #writeToParcel(Parcel, int)},
     * the return value of this method must include the
     * {@link #CONTENTS_FILE_DESCRIPTOR} bit.
     *
     * @return a bitmask indicating the set of special object types marshaled
     * by this Parcelable object instance.
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Flatten this object in to a Parcel.
     *
     * @param dest  The Parcel in which the object should be written.
     * @param flags Additional flags about how the object should be written.
     *              May be 0 or {@link #PARCELABLE_WRITE_RETURN_VALUE}.
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString (artistNames);
        dest.writeString (artistSongs);
        dest.writeString (duration);
        dest.writeString (serialNumber);
        dest.writeInt (imageId);
    }
}
