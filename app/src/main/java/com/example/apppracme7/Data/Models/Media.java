package com.example.apppracme7.Data.Models;

import android.net.Uri;

public class Media {
    private String artistName;
    private String  imageFilePath;
    private String title;

    public Media(String artistName, String title, String imageFilePath) {
        this.artistName = artistName;
        this.imageFilePath = imageFilePath;
        this.title = title;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getImageFilePath() {
        return imageFilePath;
    }
    public String getTitle() {
        return title;
    }
}