package br.com.berbert.capstone.models;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;

import java.util.ArrayList;
import java.util.List;

import br.com.berbert.capstone.BuildConfig;

/**
 * Created by Felipe Berbert for the Udacity Android Nanodegree capstone project on 19/06/2016.
 */
public class Photo {

    private final static String DEFAULT_IMAGE_SIZE_DOWNLOAD = "400";

    private int width;
    private int height;
    private List<String> html_attributions;
    private String photo_reference;

    public Photo() {
        html_attributions = new ArrayList<>();
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public List<String> getHtml_attributions() {
        return html_attributions;
    }

    public void setHtml_attributions(List<String> html_attributions) {
        this.html_attributions = html_attributions;
    }

    public String getPhoto_reference() {
        return photo_reference;
    }

    public void setPhoto_reference(String photo_reference) {
        this.photo_reference = photo_reference;
    }

    public void fetchPhoto(ImageView view){
            Glide.with(view.getContext()).load(buildRequest()).into(view);
    }
    public void fetchPhoto(Context context, Target target){
            Glide.with(context).load(buildRequest()).asBitmap().into(target);
    }

    public void loadPhoto(Context context){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(buildRequest()));
        context.startActivity(intent);
    }

    private String buildRequest(){
        StringBuilder sb = new StringBuilder("https://maps.googleapis.com/maps/api/place/photo?");
        sb.append("key=" + BuildConfig.PLACES_API_KEY);
        sb.append("&maxwidth=").append(DEFAULT_IMAGE_SIZE_DOWNLOAD);
        sb.append("&photoreference=").append(photo_reference);
        return sb.toString();
    }
}
