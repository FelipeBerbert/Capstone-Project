package br.com.berbert.capstone.models;

import java.io.Serializable;

/**
 * Created by Felipe Berbert on 09/06/2016.
 */
public class Place implements Serializable {

    private static final long serialVersionUID = -5573854869178754964L;

    private int picture; //TODO change to url

    private String name;

    private long distance;

    private String description;

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
}
