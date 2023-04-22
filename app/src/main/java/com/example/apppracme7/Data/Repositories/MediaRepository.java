package com.example.apppracme7.Data.Repositories;

import androidx.lifecycle.LiveData;

import com.example.apppracme7.Data.DataSources.MediaDataSource;
import com.example.apppracme7.Data.Models.Media;
import com.example.apppracme7.Data.Models.User;

import java.util.List;

public class MediaRepository {
    private MediaDataSource media;
    public MediaRepository(Media media) {
        this.media = new MediaDataSource();
    }
    public LiveData<List<Media>>  getData() {
        return media.media();
    }

}
