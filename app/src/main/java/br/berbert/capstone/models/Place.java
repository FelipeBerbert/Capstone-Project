package br.berbert.capstone.models;

import android.content.Context;
import android.location.*;
import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.target.Target;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import br.berbert.capstone.BuildConfig;

/**
 * Created by Felipe Berbert on 09/06/2016.
 */
public class Place implements Parcelable {

//    private static final long serialVersionUID = -5573854869178754964L;

//    private int picture; //TODO change to url
    private List<Photo> photos;

    private String name;

    @SerializedName("place_id")
    private String placeId;

    private String vicinity;

    @SerializedName("international_phone_number")
    private String phoneNumber;

    private float distance;

    private Geometry geometry;

    private List<String> types;

    private List<Review> reviews;

    public Place(){
        photos = new ArrayList<>();
        types = new ArrayList<>();
    }

    public Place(Parcel parcel){
        String[] params = new String[4];
        parcel.readStringArray(params);
        this.name = params[0];
        this.distance = Float.valueOf(params[1]);
        this.placeId = params[2];
        this.vicinity = params[3];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns
     * @param userLocation
     * @return The distance between the given location and this place's location,
     * or -1 if the user location is null
     */
    public float getDistance(android.location.Location userLocation) {
        Location placeLocation = new Location(name);
        placeLocation.setLatitude(geometry.getLocation().getLat());
        placeLocation.setLongitude(geometry.getLocation().getLng());

        if (userLocation != null)
            return userLocation.distanceTo(placeLocation);
        else
            return -1;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public String getVicinity() {
        return vicinity;
    }

    public void setVicinity(String vicinity) {
        this.vicinity = vicinity;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[]{this.name,Float.toString(this.distance),this.placeId,this.vicinity});
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
