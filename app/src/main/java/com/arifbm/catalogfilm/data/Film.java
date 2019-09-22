package com.arifbm.catalogfilm.data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Film implements Parcelable {

    private String title;
    private String description;
    private int banner;
    private int year;
    private float rating;

    Film (String title, String description, int banner, int year, float rating){
        this.title = title;
        this.description = description;
        this.banner = banner;
        this.year = year;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getBanner() {
        return banner;
    }

    public int getYear() {
        return year;
    }

    public float getRating() {
        return rating;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    private Film(Parcel in) {
        title = in.readString();
        description = in.readString();
        banner = in.readInt();
        year = in.readInt();
        rating = in.readFloat();
    }

    public static final Creator<Film> CREATOR = new Creator<Film>() {
        @Override
        public Film createFromParcel(Parcel in) {
            return new Film(in);
        }

        @Override
        public Film[] newArray(int size) {
            return new Film[size];
        }
    };


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.description);
        dest.writeInt(this.banner);
        dest.writeInt(this.year);
        dest.writeFloat(this.rating);
    }

}
