package br.com.berbert.capstone.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Felipe Berbert for the Udacity Android Nanodegree capstone project on 19/06/2016.
 */
public class Photo {

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
}
