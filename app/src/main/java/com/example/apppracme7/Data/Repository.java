package com.example.apppracme7.Data;

import com.example.apppracme7.Data.Source.Media;
import com.example.apppracme7.Data.Source.User;

public class Repository {
    private Media media;
    private User user;

    public Repository(User user) {
        this.user = user;
    }

    public Repository(Media media) {
        this.media = media;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }
}
