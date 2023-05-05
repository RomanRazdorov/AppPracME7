package com.example.apppracme7.Data.Repositories;

import androidx.lifecycle.LiveData;

import com.example.apppracme7.Data.DataSources.MediaDataSource;
import com.example.apppracme7.Data.Models.Media;

import java.util.List;

public class MediaRepository {
    private MediaDataSource media;
    public LiveData<List<Media>>  getData() {
        return media.media();
    }

}
