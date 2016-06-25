package br.com.berbert.capstone.models;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.target.Target;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import br.com.berbert.capstone.BuildConfig;

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

    private float rating;

    private String vicinity;

    @SerializedName("international_phone_number")
    private String phoneNumber;

    private long distance;

    private double lat;
    private double lng;

    private List<String> types;

    private String description;

    public Place(){
        photos = new ArrayList<>();
        types = new ArrayList<>();
    }

    public Place(Parcel parcel){
        String[] params = new String[4];
        parcel.readStringArray(params);
        this.name = params[0];
        this.distance = Long.valueOf(params[1]);
        this.placeId = params[2];
        this.vicinity = params[3];
    }

    public void fetchPhoto(ImageView view){
        if (getPhotos().size() > 0)
            Glide.with(view.getContext()).load(buildRequest(getPhotos().get(0).getPhoto_reference())).into(view);
    }
    public void fetchPhoto(Context context, Target target){
        if (getPhotos().size() > 0)
            Glide.with(context).load(buildRequest(getPhotos().get(0).getPhoto_reference())).asBitmap().into(target);
    }
    public void fetchPhoto(ImageView view, String reference){
        Glide.with(view.getContext()).load(buildRequest(reference)).into(view);
    }

    private String buildRequest(String reference){
        StringBuilder sb = new StringBuilder("https://maps.googleapis.com/maps/api/place/photo?");
        sb.append("key=" + BuildConfig.PLACES_API_KEY);
        sb.append("&maxwidth=" + "400");
        sb.append("&photoreference=" + reference);
        return sb.toString();
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

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[]{this.name,Long.toString(this.distance),this.placeId,this.vicinity});
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
