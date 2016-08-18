package br.berbert.capstone.models;

import java.util.List;

/**
 * Created by Felipe Berbert for the Udacity Android Nanodegree capstone project on 22/06/2016.
 */
public class PlaceDetailsResponse {
    private Place result;
    private List<String> html_attributions;

    public Place getResult() {
        return result;
    }

    public void setResult(Place result) {
        this.result = result;
    }

    public List<String> getHtml_attributions() {
        return html_attributions;
    }

    public void setHtml_attributions(List<String> html_attributions) {
        this.html_attributions = html_attributions;
    }
}
