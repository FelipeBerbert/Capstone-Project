package br.com.berbert.capstone.models;

/**
 * Created by Felipe Berbert on 09/06/2016.
 */
public class Place {

    private int picture; //TODO change to url

    private String name;

    private long distance;

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
}
