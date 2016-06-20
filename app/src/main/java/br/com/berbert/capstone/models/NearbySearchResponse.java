package br.com.berbert.capstone.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Felipe Berbert for the Udacity Android Nanodegree capstone project on 19/06/2016.
 */
public class NearbySearchResponse {

    private List<Place> results;

    public NearbySearchResponse() {
        this.results = new ArrayList<>();
    }

//    public static NearbySearchResponse parseJSON(String response) {
//        Gson gson = new GsonBuilder().create();
//        return gson.fromJson(response, NearbySearchResponse.class);
//    }

    public List<Place> getResults() {
        return results;
    }

    public void setResults(List<Place> results) {
        this.results = results;
    }


}
