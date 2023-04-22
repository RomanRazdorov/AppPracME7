package com.example.apppracme7.Source;

public class Media {
    private String artistName;
    private int imageResourceId;
    private String title;

    public Media(String artistName, String title, int imageResourceId) {
        this.artistName = artistName;
        this.imageResourceId = imageResourceId;
        this.title = title;
    }

    public String getArtistName() {
        return artistName;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
    public String getTitle() {
        return title;
    }
}