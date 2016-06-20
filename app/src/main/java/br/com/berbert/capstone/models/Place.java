package br.com.berbert.capstone.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Felipe Berbert on 09/06/2016.
 */
public class Place implements Parcelable {

//    private static final long serialVersionUID = -5573854869178754964L;

    private int picture; //TODO change to url
    private List<Photo> photos;

    private String name;

    @SerializedName("place_id")
    private String placeId;

    private float rating;

    private String vicinity;

    private long distance;

    private double lat;
    private double lng;

    private String description;

    public Place(){
        photos = new ArrayList<>();
    }

    public Place(Parcel parcel){
        String[] params = new String[5];
        parcel.readStringArray(params);
        this.picture = Integer.valueOf(params[0]);
        this.name = params[1];
        this.distance = Long.valueOf(params[2]);
        this.placeId = params[3];
        this.vicinity = params[4];
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

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String place_id) {
        this.placeId = place_id;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getVicinity() {
        return vicinity;
    }

    public void setVicinity(String vicinity) {
        this.vicinity = vicinity;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[]{String.valueOf(this.picture),this.name,Long.toString(this.distance),this.placeId,this.vicinity});
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
