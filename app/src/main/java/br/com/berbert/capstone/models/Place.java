package br.com.berbert.capstone.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Felipe Berbert on 09/06/2016.
 */
public class Place implements Parcelable {

//    private static final long serialVersionUID = -5573854869178754964L;

    private int picture; //TODO change to url

    private String name;

    private long distance;

    private String description;

    public Place(){
    }

    public Place(Parcel parcel){
        String[] params = new String[4];
        parcel.readStringArray(params);
        this.picture = Integer.valueOf(params[0]);
        this.name = params[1];
        this.distance = Long.valueOf(params[2]);
        this.description = params[3];
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[]{String.valueOf(this.picture),this.name,Long.toString(this.distance),this.description});
    }
    public static final Parcelable.Creator<Place> CREATOR = new Parcelable.Creator<Place>(){
        @Override
        public Place createFromParcel(Parcel parcel){
            return new Place(parcel);
        }
        @Override
        public Place[] newArray(int size){
            return new Place[size];
        }
    };
}
