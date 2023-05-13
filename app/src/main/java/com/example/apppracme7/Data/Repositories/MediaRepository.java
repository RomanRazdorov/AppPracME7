package com.example.apppracme7.Data.Repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import com.example.apppracme7.Data.DataSources.MediaDataSource;
import com.example.apppracme7.Data.DataSources.room.DAO.MediaDAO;
import com.example.apppracme7.Data.DataSources.room.Entites.MediaEntity;
import com.example.apppracme7.Data.DataSources.room.Root.MediaDataBase;
import com.example.apppracme7.Data.Models.Media;

import java.util.List;
import java.util.stream.Collectors;

public class MediaRepository {
    private MediaDataSource media;
    private MediaDataBase db;

    public MediaRepository(Application application){
        db = MediaDataBase.getDatabase(application);
        media =new MediaDataSource(application);
    }
    public LiveData<List<Media>> getMedia() {
        return media.media();
    }
    public LiveData<List<Media>> getMediaFromDB() {
        return Transformations.map(
                db.mediaDAO().getAllMedia(),
                (values) -> values.stream().map(MediaEntity::toDomainModel)
                        .collect(Collectors.toList())
        );
    }
    public void addMedia(Media newMedia) {
        MediaDataBase.databaseWriteExecutor.execute(() -> {
            db.mediaDAO().insertMedia(new MediaEntity(newMedia.getTitle(),
                    newMedia.getArtistName(),
                    newMedia.getImageFilePath()));
        });
    }

}
