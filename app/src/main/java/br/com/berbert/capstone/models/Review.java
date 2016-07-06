package br.com.berbert.capstone.models;

/**
 * Created by Felipe Berbert for the Udacity Android Nanodegree capstone project on 06/07/2016.
 */
public class Review {

    private String author_name;

    private String author_url;

    private int rating;

    private String text;

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getAuthor_url() {
        return author_url;
    }

    public void setAuthor_url(String author_url) {
        this.author_url = author_url;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
